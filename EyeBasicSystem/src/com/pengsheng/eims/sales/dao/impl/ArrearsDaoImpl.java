/**
 * 
 */
package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.AccSalesDao;
import com.pengsheng.eims.sales.dao.ArrearsDao;
import com.pengsheng.eims.sales.dao.ConSalesDao;
import com.pengsheng.eims.sales.dao.FrameSalesDao;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class ArrearsDaoImpl extends BaseJdbcDaoSupport implements ArrearsDao {

	/**
	 * 根据配镜单号查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo customerInfoPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer
				.append("select top 1  S_ME_CI_Name as smeciname , S_ME_CI_Sex as smecisex , ");
		buffer
				.append("S_ME_CI_Birthday as smecibirthday , S_ME_CI_MemberId as smecimemberid , ");
		buffer.append("S_ME_CI_CustomerID as smecicustomerid ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer
				.append("inner join S_SE_SalesBasic on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("where 1=1 ");

		if (!"".equals(Utility.getName(customerInfoPo.getFmmsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(customerInfoPo.getFmmsalesid());
		}

		return (CustomerInfoPo) queryForObject(buffer.toString(), params
				.toArray(), CustomerInfoPo.class);
	}


	public List<SalesBasicPo> getArrears(SalesBasicPo salesBasicPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT S_SE_SB_SalesID as ssesbsalesid,");
		sb.append("S_ME_CI_Name as ssesbpersonName,");
		sb.append("S_SE_SB_CustomerID as ssesbcustomerid,");
		sb.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime,");
		sb.append("S_SE_SB_OrdersType as ssesborderstype,");
		sb.append("S_SE_SB_PriceSum as ssesbpricesum,");
		sb.append("S_SE_SB_SalesValue as ssesbsalesvalue,");
		sb.append("S_SE_SB_DiscountNum as ssesbdiscountnum,");
		sb.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue,");
		sb.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue,");
		sb.append("S_SE_SB_DueIntegral AS ssesbjfamount, ");
		sb.append("isnull(n.hisbillcount,0) as ssesbnothisflag, ");     // 未传递
		sb.append("isnull(p.hisbillcount,0) as ssesbhispayflag ");     // HIS中已收费
		
		sb.append("from s_se_salesbasic inner join S_ME_CustomerInfo ");
		sb.append("on S_ME_CI_CustomerID=S_SE_SB_CustomerID ");
		
		sb.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm where S_HC_CC_Chargetype = '3' group by S_HC_CC_Billid )n on S_SE_SB_SalesID = n.S_HC_CC_Billid ");
		sb.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm where S_HC_CC_Flag = '1' and S_HC_CC_Chargetype = '3' group by S_HC_CC_Billid )p on S_SE_SB_SalesID = p.S_HC_CC_Billid ");
			
		sb.append("where S_SE_SB_valueflag='1' ");
		sb.append("and S_SE_SB_CheckoutFlag='1' and S_SE_SB_InTransit<>'14' and s_se_sb_shopcode=? ");

		List<String> params = new ArrayList<String>();
		
		params.add(salesBasicPo.getSsesbshopcode());
		if (!"".equals(salesBasicPo.getSsesbsalesid())) {
			sb.append("and S_SE_SB_SalesID = ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if (!"".equals(salesBasicPo.getSsesbcustomerid())) {
			sb.append("and S_SE_SB_CustomerID=? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}
		return queryForObjectList(sb.toString(), params.toArray(),
				SalesBasicPo.class);
	}


	public void updateArrears(SalesBasicPo salesBasicPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE S_SE_SALESBASIC SET ");
		sb.append("S_SE_SB_CheckoutFlag='0', ");
		sb.append("S_SE_SB_Psalsvalue=S_SE_SB_Psalsvalue+S_SE_SB_ArrearsValue, ");
		sb.append("S_SE_SB_PayCash = isnull(S_SE_SB_PayCash,'0') + ?, ");
		sb.append("S_SE_SB_BankCard = isnull(S_SE_SB_BankCard,'0') + ?, ");
		sb.append("S_SE_SB_StoredCard = isnull(S_SE_SB_StoredCard,'0') + ?,S_SE_SB_IntegralPrice=isnull(S_SE_SB_IntegralPrice,'0') + ?, ");
		sb.append("S_SE_SB_ArrearsAppendDate=dbo.ufn_getDayCheckOut(),S_SE_SB_FactArrearsAppendDate=getdate() WHERE S_SE_SB_SalesID=? ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(salesBasicPo.getSsesbpaycash()));
		params.add(Utility.getName(salesBasicPo.getSsesbbankcard()));
		if("".equals(Utility.getName(salesBasicPo.getSsesbstoredcard()))){
			params.add("0");
		}else{
			params.add(Utility.getName(salesBasicPo.getSsesbstoredcard()));
		}
		if("".equals(Utility.getName(salesBasicPo.getSsesbintegralprice()))){
			params.add("0");
		}else{
			params.add(Utility.getName(salesBasicPo.getSsesbintegralprice()));
		}
		
		params.add(salesBasicPo.getSsesbsalesid());
		this.getJdbcTemplate().update(sb.toString(), params.toArray());

	}


	public void insertCustomizeTui(String salesID) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO S_Se_Customizetui (s_se_c_salesid,s_se_c_arrearsDate,s_se_c_arrearsValue,s_se_c_customizeValue,s_se_c_FactarrearsDate) ");
		sb.append(" select ?,dbo.ufn_getDayCheckOut(),-S_SE_SB_ArrearsValue,-S_SE_SB_Psalsvalue,getdate() from s_se_salesbasic where s_se_sb_salesid=? and S_SE_SB_CheckoutFlag='1'");
		sb.append(" union all  ");
		sb.append(" select ?,dbo.ufn_getDayCheckOut(),-S_SE_SB_ArrearsValue,-S_SE_SB_Psalsvalue,getdate() from S_SE_SalesBasic_Finished where s_se_sb_salesid=? and S_SE_SB_CheckoutFlag='1'");

		params.add(Utility.getName(salesID));
		params.add(Utility.getName(salesID));
		params.add(Utility.getName(salesID));
		params.add(Utility.getName(salesID));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取当前收银员当天累计金额
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getArrearsValues(SalesBasicPo salesBasicPo) {
		
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("select sum(S_SE_SB_SalesValue) as ssesbpsalsvalue from (  ");
		varname1.append("select sum(S_SE_SB_SalesValue) as S_SE_SB_SalesValue from S_SE_SalesBasic  ");
		varname1.append("  where S_SE_SB_ValueFlag='1' and convert(varchar(10),S_SE_SB_PosDatetime,120)=convert(varchar(10),getdate(),120)  ");
		varname1.append("        and S_SE_SB_ShopCode=? and S_SE_SB_PosID=?  ");
		varname1.append("union all  ");
		varname1.append("select -sum(S_SE_SB_SalesValue) as S_SE_SB_SalesValue from S_SE_SalesBasic  ");
		varname1.append("  where S_SE_SB_ValueFlag='1' and convert(varchar(10),S_SE_SB_WithdrawDate,120)=convert(varchar(10),getdate(),120)  ");
		varname1.append("        and S_SE_SB_ShopCode=? and S_SE_SB_WithdrawPersonID=? and S_SE_SB_WithdrawFlag='1'  ");
		varname1.append(")temp  ");
		
		params.add(salesBasicPo.getSsesbshopcode());
		params.add(salesBasicPo.getSsesbposid());
		params.add(salesBasicPo.getSsesbshopcode());
		params.add(salesBasicPo.getSsesbposid());
		
		return (SalesBasicPo) queryForObject(varname1.toString(), params.toArray(),SalesBasicPo.class);
	}
	
	public SalesBasicPo getArrearsValuesFinished(SalesBasicPo salesBasicPo) {
		
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("select sum(S_SE_SB_SalesValue) as ssesbpsalsvalue from (  ");
		varname1.append("select sum(S_SE_SB_SalesValue) as S_SE_SB_SalesValue from S_SE_SalesBasic_Finished  ");
		varname1.append("  where S_SE_SB_ValueFlag='1' and convert(varchar(10),S_SE_SB_PosDatetime,120)=convert(varchar(10),getdate(),120)  ");
		varname1.append("        and S_SE_SB_ShopCode=? and S_SE_SB_PosID=?  ");
		varname1.append("union all  ");
		varname1.append("select -sum(S_SE_SB_SalesValue) as S_SE_SB_SalesValue from S_SE_SalesBasic_Finished  ");
		varname1.append("  where S_SE_SB_ValueFlag='1' and convert(varchar(10),S_SE_SB_WithdrawDate,120)=convert(varchar(10),getdate(),120)  ");
		varname1.append("        and S_SE_SB_ShopCode=? and S_SE_SB_WithdrawPersonID=? and S_SE_SB_WithdrawFlag='1'  ");
		varname1.append(")temp  ");
		
		params.add(salesBasicPo.getSsesbshopcode());
		params.add(salesBasicPo.getSsesbposid());
		params.add(salesBasicPo.getSsesbshopcode());
		params.add(salesBasicPo.getSsesbposid());
		
		return (SalesBasicPo) queryForObject(varname1.toString(), params.toArray(),SalesBasicPo.class);
	}
	
	
	/**
	 * 获取当前收银员当天累计实收金额
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getArrearsValuesToo(SalesBasicPo salesBasicPo) {
		
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("SELECT SUM(S_SE_SB_SalesValue) AS ssesbpsalsvalue ");
		varname1.append("FROM   (SELECT SUM(cast(S_SE_SL_Price as numeric(18,2))) AS S_SE_SB_SalesValue ");
		varname1.append("        FROM   S_SE_SalesLog ");
		varname1.append("        WHERE  S_SE_SL_Type = '1' ");
		varname1.append("               AND CONVERT(VARCHAR(10), S_SE_SL_FactDateTime, 120) = CONVERT(VARCHAR(10), Getdate(), 120) ");
		varname1.append("               AND S_SE_SL_ShopCode = ? ");
		varname1.append("               AND S_SE_SL_Person = ? ");
		varname1.append("               AND S_SE_SL_PaymentType IN ( '1', '2', '3' ) ");
		varname1.append("        UNION ALL ");
		varname1.append("        SELECT -SUM(cast(S_SE_SL_Price as numeric(18,2))) AS S_SE_SB_SalesValue ");
		varname1.append("        FROM   S_SE_SalesLog ");
		varname1.append("        WHERE  S_SE_SL_Type = '1' ");
		varname1.append("               AND CONVERT(VARCHAR(10), S_SE_SL_FactDateTime, 120) = CONVERT(VARCHAR(10), Getdate(), 120) ");
		varname1.append("               AND S_SE_SL_ShopCode = ? ");
		varname1.append("               AND S_SE_SL_Person = ? ");
		varname1.append("               AND S_SE_SL_PaymentType IN ( '4', '5' ))TEMP ");
		
		params.add(salesBasicPo.getSsesbshopcode());
		params.add(salesBasicPo.getSsesbposid());
		params.add(salesBasicPo.getSsesbshopcode());
		params.add(salesBasicPo.getSsesbposid());
		
		return (SalesBasicPo) queryForObject(varname1.toString(), params.toArray(),SalesBasicPo.class);
	}
	
	public void updateArrearsToday(SalesBasicPo salesBasicPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE S_SE_SalesBasic_Today SET ");
		sb.append("S_SE_SB_CheckoutFlag='0', ");
		sb.append("S_SE_SB_Psalsvalue=S_SE_SB_Psalsvalue+S_SE_SB_ArrearsValue, ");
		sb.append("S_SE_SB_PayCash = isnull(S_SE_SB_PayCash,'0') + ?, ");
		sb.append("S_SE_SB_BankCard = isnull(S_SE_SB_BankCard,'0') + ?, ");
		sb.append("S_SE_SB_StoredCard = isnull(S_SE_SB_StoredCard,'0') + ?, ");
		sb.append("S_SE_SB_ArrearsAppendDate=dbo.ufn_getDayCheckOut(),S_SE_SB_FactArrearsAppendDate=getdate() WHERE S_SE_SB_SalesID=? ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(salesBasicPo.getSsesbpaycash()));
		if("".equals(Utility.getName(salesBasicPo.getSsesbbankcard()))){
			params.add("0");
		}else{
			params.add(Utility.getName(salesBasicPo.getSsesbbankcard()));
		}
		
		if("".equals(Utility.getName(salesBasicPo.getSsesbstoredcard()))){
			params.add("0");
		}else{
			params.add(Utility.getName(salesBasicPo.getSsesbstoredcard()));
		}
		
		params.add(salesBasicPo.getSsesbsalesid());
		this.getJdbcTemplate().update(sb.toString(), params.toArray());

	}
	
}