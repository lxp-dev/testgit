package com.pengsheng.eims.his.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.his.dao.HisDao;
import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class HisDaoImpl extends BaseJdbcDaoSupport implements HisDao {

	public SalesBasicPo getSalesBasicInfo(String billid){		
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 S_SE_SB_SalesID as ssesbsalesid,S_SE_SB_CustomerID as ssesbcustomerid,S_SE_SB_SalerID as ssesbsalerid,personName as ssesbsalerName,S_SE_SB_SalesValue as ssesbsalesvalue, ");
		buffer.append("       convert(varchar(19),S_SE_SB_SalesDatetime,120) as ssesbsalesdatetime,S_SE_SB_Psalsvalue as ssesbpsalsvalue,S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		buffer.append("  from S_SE_SalesBasic inner join SYS_PersonInfo on S_SE_SB_SalerID = ID ");
		buffer.append("  where S_SE_SB_SalesID = ? ");
		
		params.add(Utility.getName(billid));
		
		return (SalesBasicPo)queryForObject(buffer.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	public List<SalesDetailPo> getSalesDetailInfoList(String billid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ROW_NUMBER() Over(ORDER BY ssesdpayfeeid) as ssesdpayfeeno,ssesdpayfeeid,ssesdsalesvalue from ( ");		
		buffer.append("	select ssesdpayfeeid as ssesdpayfeeid,sum(ssesdsalesvalue) as ssesdsalesvalue from ( ");
		buffer.append("	select isnull(B_GI_PayFeeID,'') as ssesdpayfeeid,sum(S_SE_SD_SalesValue) as ssesdsalesvalue ");
		buffer.append("	  from S_SE_SalesDetail inner join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID ");
		buffer.append("	  where S_SE_SD_SalesID = ? ");
		buffer.append("	  group by B_GI_PayFeeID ");
		buffer.append("	union all ");
		buffer.append("	select isnull(F_AC_PayFeeID,'') as ssesdpayfeeid,sum(cast(S_SE_Number as numeric(18,0)) * S_SE_Amount) as ssesdsalesvalue ");
		buffer.append("	  from S_SE_AdditionalCDetail inner join F_AdditionalCosts on S_SE_AdditionalID = F_AC_ID ");
		buffer.append("	  where S_SE_SalesID = ? ");
		buffer.append("	  group by F_AC_PayFeeID ");
		buffer.append(" )m ");	
		buffer.append("	group by ssesdpayfeeid ");
		buffer.append(" )m ");
		
		params.add(Utility.getName(billid));
		params.add(Utility.getName(billid));
		
		return queryForObjectList(buffer.toString(),params.toArray(), SalesDetailPo.class);
	}
	
	public RegisteredDetailsPo getRegisteredInfo(String billid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

 
		buffer.append("select top 1 S_CR_RD_DetailsID as scrrddetailsid,S_CR_RD_CustomerID as scrrdcustomerid,S_CR_RD_Register as scrrdregister,personName as scrrdcreatename,sum(abs(S_CR_RD_Money)) as scrrdmoney, ");
		buffer.append("       convert(varchar(19),S_CR_RD_OptDate,120) as scrrdoptdate ");
		buffer.append("  from S_CR_RegisteredDetails inner join SYS_PersonInfo on S_CR_RD_Register = ID ");
		buffer.append("  where S_CR_RD_DetailsID = ? ");
		buffer.append("  group by S_CR_RD_DetailsID,S_CR_RD_CustomerID,S_CR_RD_Register,personName,convert(varchar(19),S_CR_RD_OptDate,120) ");
		
		params.add(Utility.getName(billid));
		
		return (RegisteredDetailsPo)queryForObject(buffer.toString(), params.toArray(), RegisteredDetailsPo.class);
	}
	
	public List<RegisteredDetailsPo> getRegisteredDetailInfoList(String billid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select ROW_NUMBER() Over(ORDER BY scrrdpayfeeid) as scrrdpayfeeno,scrrdpayfeeid,scrrdmoney from ( ");
		buffer.append("	select isnull(F_RC_PayFeeID,'') as scrrdpayfeeid,sum(abs(S_CR_RD_Money)) as scrrdmoney ");
		buffer.append("	  from S_CR_RegisteredDetails inner join F_RegisteredCategory on S_CR_RD_RegisteredID = F_RC_ID ");
		buffer.append("	  where S_CR_RD_DetailsID = ? ");
		buffer.append("	  group by F_RC_PayFeeID ");
		buffer.append(")m ");
		
		params.add(Utility.getName(billid));
		
		return queryForObjectList(buffer.toString(),params.toArray(), RegisteredDetailsPo.class);
	}
    /**
     * 视光系统挂号退费确认接口调用
     * 参数: 1) memberid:患者ID
     *      2) todayoutpatientid:当日就诊号
     * 返回记录数
     * 
     */
	public int getCustomerOptometryStateByHis(String memberid, String todayoutpatientid) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT  count(*) ");
		sb.append("FROM    S_HC_CO_HISCustOptometry ");
		sb.append(" WHERE  S_HC_CO_Todayid = ? ");
		sb.append(" and    S_HC_CO_Custmerid = ? ");
		sb.append(" and isnull(S_HC_CO_Isopt,0)  = '1' ");
		sb.append(" and isnull(S_HC_CO_Isrefund,0)   = '0' ");
		
		params.add(todayoutpatientid);
		params.add(memberid);

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	/**
	 * 视光系统提供挂号退费成功确认接口
	 * 参数: 1) memberid:患者ID
	 *      2) todayoutpatientid:当日就诊号
	 * 返回记录数
	 * 
	 */
	public int getCustomerIsrefundStateByHis(String memberid, String todayoutpatientid) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT  count(*) ");
		sb.append("FROM    S_HC_CO_HISCustOptometry ");
		sb.append(" WHERE  S_HC_CO_Todayid = ? ");
		sb.append(" and    S_HC_CO_Custmerid = ? ");
		sb.append(" and isnull(S_HC_CO_Isopt,0)  = '0' ");
		sb.append(" and isnull(S_HC_CO_Isrefund,0)   = '0' ");
		
		params.add(todayoutpatientid);
		params.add(memberid);
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	 
	/**
	 * 1. 用          途：根据配镜单号查询商品明细中是否存在未设置收费明细的商品
	 * 2. 参          数：billid 缴费单号
	 */
	public List<SalesDetailPo> getSalesDetailNotSetPayFeeList(String billid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ssesdsalesitemid,ssesdsalesitemname from ( ");
		buffer.append("	select distinct S_SE_SD_SalesItemID as ssesdsalesitemid,S_SE_SD_SalesItemName as ssesdsalesitemname ");
		buffer.append("	  from S_SE_SalesDetail inner join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID ");
		buffer.append("	  where S_SE_SD_SalesID = ? and isnull(B_GI_PayFeeID,'') = '' ");
		buffer.append("	union all ");
		buffer.append("	select distinct S_SE_AdditionalID as ssesdsalesitemid,S_SE_CostsName as ssesdsalesitemname ");
		buffer.append("	  from S_SE_AdditionalCDetail inner join F_AdditionalCosts on S_SE_AdditionalID = F_AC_ID ");
		buffer.append("	  where S_SE_SalesID = ? and isnull(F_AC_PayFeeID,'') = '' ");
		buffer.append(" )m ");
		
		params.add(Utility.getName(billid));
		params.add(Utility.getName(billid));
		
		return queryForObjectList(buffer.toString(),params.toArray(), SalesDetailPo.class);
	}

	/**
	 * 接口6)
	 * 
	 * 1. 接口名称：视光系统提供挂号退费成功确认接口
	 * 2. 用       途：HIS调用接口反刷患者在视光系统验光退费状态
	 */
	
	public void updateCustOptStaOKByHis(HisParamPo hisParamPo) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update   S_HC_CO_HISCustOptometry  ");
		sb.append(" set  S_HC_CO_Isrefund = '1' ");
		sb.append(" WHERE  S_HC_CO_Todayid = ? ");
		sb.append(" and    S_HC_CO_Custmerid = ? ");
		sb.append(" and isnull(S_HC_CO_Isopt,0)  = '0' ");
		sb.append(" and isnull(S_HC_CO_Isrefund,0)   = '0' ");
		
		params.add(Utility.getName(hisParamPo.getTodayoutpatientid()));
		params.add(Utility.getName(hisParamPo.getMemberid()));

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	 
	public int getChargeCount(HisParamPo po) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select count(S_HC_CC_Billid)     ");
		sb.append("   from S_HC_CC_HISChargeConfirm ");
		sb.append("where S_HC_CC_Billid = ? and S_HC_CC_Flag = '2' ");
		 
		params.add(Utility.getName(po.getBillid()));
		 
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
}
