package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.dao.ShopCodeTakeDao;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ShopCodeTakeDaoImpl extends BaseJdbcDaoSupport implements
		ShopCodeTakeDao {

	/**
	 * 查询门店取镜信息数量
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public int getShopCodeTakeCount(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('10') ");
		buffer.append("SELECT DISTINCT inTransit into #dpt2 FROM ufn_currentintransittab('11') ");
		
		buffer.append("select count(distinct S_SE_SB_SalesID) ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		
		if (!Utility.getName(salesBasicPo.getSsesbdistributionid()).equals("")){
			buffer.append(" inner join S_DN_DistributionEntry on S_SE_SB_SalesID = S_DN_DE_SalesID ");
		}
		
		buffer.append("where S_SE_SB_Location = ? ");
		buffer.append("and (S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) or S_SE_SB_InTransit in (SELECT inTransit FROM #dpt2) ) ");
		buffer.append("and S_SE_SB_OrdersType in ('1','2','4') ");

		params.add(salesBasicPo.getSsesblocation());

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm = ? ");
			params.add(salesBasicPo.getDjsbm());
		}

		if (!"".equals(Utility.getName(salesBasicPo
				.getSsesbsalesdatestarttime()))
				&& !"".equals(Utility.getName(salesBasicPo
						.getSsesbsalesdateendtime()))) {
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo
				.getSsesbsalesdatestarttime()))
				&& "".equals(Utility.getName(salesBasicPo
						.getSsesbsalesdateendtime()))) {
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo
				.getSsesbsalesdatestarttime()))
				&& !"".equals(Utility.getName(salesBasicPo
						.getSsesbsalesdateendtime()))) {
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))) {
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbMemberId()))) {
			buffer.append("and S_ME_CI_MemberId like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbMemberId());
		}
		
		if (!Utility.getName(salesBasicPo.getSsesbdistributionid()).equals("")){
			buffer.append(" and S_DN_DE_DistributionID like '%' + ? + '%' ");
			params.add(Utility.getName(salesBasicPo.getSsesbdistributionid()));
		}

		buffer.append(" drop table #dpt ");
		buffer.append(" drop table #dpt2 ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}

	/**
	 * 信息插入在途明细表中
	 * 
	 * @param inTransitPo
	 */
	public void insertInTransit(InTransitPo inTransitPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into S_SE_InTransit (S_SE_IT_ID , ");
		buffer.append("S_SE_IT_SalesID , S_SE_IT_State , ");
		buffer
				.append("S_SE_IT_Date , S_SE_IT_CreatePerson , S_SE_IT_Department) ");
		buffer.append("values (? , ? , '12' , getdate() , ? , ?) ");

		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 查询门店取镜信息
	 * 
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectShopCodeTake(SalesBasicPo salesBasicPo,
			int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		
		buffer.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('10') ");
		buffer.append("SELECT DISTINCT inTransit into #dpt2 FROM ufn_currentintransittab('11') ");
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by ssesbsalesdatetime desc) as rowNum,* from ( ");

		buffer.append("select distinct S_SE_SB_SalesID as ssesbsalesid , S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_PosDatetime as ssesbsalesdatetime , S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_ME_CI_Phone as ssesbphone , ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		
		if (!Utility.getName(salesBasicPo.getSsesbdistributionid()).equals("")){
			buffer.append(" inner join S_DN_DistributionEntry on S_SE_SB_SalesID = S_DN_DE_SalesID ");
		}
		
		buffer.append("where S_SE_SB_Location = ? ");
		buffer.append("and (S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) or S_SE_SB_InTransit in (SELECT inTransit FROM #dpt2) ) ");
		buffer.append("and S_SE_SB_OrdersType in ('1','2','4') ");

		params.add(salesBasicPo.getSsesblocation());

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm = ? ");
			params.add(salesBasicPo.getDjsbm());
		}

		if (!"".equals(Utility.getName(salesBasicPo
				.getSsesbsalesdatestarttime()))
				&& !"".equals(Utility.getName(salesBasicPo
						.getSsesbsalesdateendtime()))) {
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo
				.getSsesbsalesdatestarttime()))
				&& "".equals(Utility.getName(salesBasicPo
						.getSsesbsalesdateendtime()))) {
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo
				.getSsesbsalesdatestarttime()))
				&& !"".equals(Utility.getName(salesBasicPo
						.getSsesbsalesdateendtime()))) {
			buffer
					.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))) {
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbMemberId()))) {
			buffer.append("and S_ME_CI_MemberId like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbMemberId());
		}
		
		if (!Utility.getName(salesBasicPo.getSsesbdistributionid()).equals("")){
			buffer.append(" and S_DN_DE_DistributionID like '%' + ? + '%' ");
			params.add(Utility.getName(salesBasicPo.getSsesbdistributionid()));
		}

		buffer.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		buffer.append(" drop table #dpt ");
		buffer.append(" drop table #dpt2 ");
		
		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}

	/**
	 * 更新销售基表的在途状态
	 * 
	 * @param salesBasicPo
	 */
	public void updateInTransit(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("update S_SE_SalesBasic ");
		buffer.append("set S_SE_SB_InTransit='12' ");
		buffer.append("where S_SE_SB_SalesID = ? ");

		params.add(salesBasicPo.getSsesbsalesid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	/**
	 * 关联销售明细表查询商品信息
	 * 
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsDetailInfo(SalesDetailPo salesDetailPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" select S_SE_SD_SalesItemID as ssesdsalesitemid , S_SE_SD_ItemID as ssesditemid , ");
		buffer.append(" S_SE_SD_StockId as ssesdstockid , S_SE_SD_Number as ssesdnumber , ");
		buffer.append(" S_SE_SD_CostsPrive as ssesdcostsprive , S_SE_SD_UnitPrice as ssesdunitprice , ");
		buffer.append(" S_SE_SD_SalesID as ssesdsalesid ");
		buffer.append(" from S_SE_SalesDetail ");
		buffer.append(" inner join S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID=S_SE_SalesDetail.S_SE_SD_SalesID ");
		buffer.append(" where S_SE_SB_OrdersType='4' and substring(S_SE_SD_SalesItemID, 1,1) = '4' ");
		buffer.append(" and S_SE_SD_SalesID = ? ");

		params.add(salesDetailPo.getSsesdsalesid());

		return queryForObjectList(buffer.toString(), params
				.toArray(), SalesDetailPo.class);
	}

	/**
	 * 将商品详细信息插入当月库存变更表中
	 * 
	 * @param strogeLogPo
	 */
	public void insertGoodsInfo(StrogeChangePo strogeChangePo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer
				.append("insert into C_SH_StorageChange (C_SH_SC_GoodsBarCode , C_SH_SC_GoodsId , C_SH_SC_StockId , ");
		buffer
				.append("C_SH_SC_GoodsQuantity , C_SH_SC_CostPrice , C_SH_SC_NotTaxRate , ");
		buffer.append("C_SH_SC_WarehousingDate , C_SH_SC_ChangeID,C_SH_SC_UUID) ");
		buffer.append("values(? , ? , ? , '-'+? , ? , ? , getdate() , ?, ?) ");

		params.add(strogeChangePo.getCshscgoodsbarcode());
		params.add(strogeChangePo.getCshscgoodsid());
		params.add(strogeChangePo.getCshscstockid());
		params.add(strogeChangePo.getCshscgoodsquantity());
		params.add(strogeChangePo.getCshsccostprice());
		params.add(strogeChangePo.getCshscnottaxrate());
		params.add(strogeChangePo.getCshscchangeid());
		params.add(this.uuid.generate());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 新增短信记录表
	 */
	public void insertSmsRecord(SmsRecordPo smsRecordPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into F_SmsRecord ");
		buffer.append("(F_SR_id,F_SR_ReceiptPerson,F_SR_ReceiptTel, ");
		buffer.append("F_SR_SendPerson,F_SR_SendContext,F_SR_SendDate,F_SR_SendFlag ) ");
		buffer.append("values(? , ? , ? , ? , ? , getdate() , '1' ) ");

		params.add(this.uuid.generate());
		params.add(smsRecordPo.getFsrreceiptperson());
		params.add(smsRecordPo.getFsrreceipttel());
		params.add(smsRecordPo.getFsrsendperson());
		params.add(smsRecordPo.getFsrsendcontext());
		// params.add(smsRecordPo.getFsrsenddate());
		// params.add(smsRecordPo.getFsrsendflag());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	/**
	 * 查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfo(String salesid) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  S_ME_CI_CustomerID as smecicustomerid,S_ME_CI_Phone as smeciphone,S_ME_CI_Name as smeciname ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("inner join S_SE_SalesBasic on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		params.add(salesid);

		return (CustomerInfoPo) queryForObject(buffer.toString(), params
				.toArray(), CustomerInfoPo.class);
	}

	/**
	 * 获取短信平台维护表信息
	 */
	public SmsSetPo getSmsSet() {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer
				.append("select top 1  F_SS_RemindFlag as fssremindflag , F_SS_RemindContent as fssremindcontent ");
		buffer.append("from F_SmsSet ");

		return (SmsSetPo) queryForObject(buffer.toString(), null,
				SmsSetPo.class);
	}

	/**
	 * 得到销售结帐基表对象
	 */
	public SalesBasicPo getSalesBasicPo(String salesID) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT top 1  S_SE_SB_SalesID as ssesbsalesid,");
		sb.append("S_ME_CI_Name as ssesbpersonName,");
		sb.append("S_ME_CI_Phone   as ssesbphone  ,");
		sb.append("S_SE_SB_DiscountRate   as ssesbdiscountrate  ,");
		sb.append("S_SE_SB_TakeGlassData   as ssesbtakeglassdata  ,");
		sb.append("B_DP_DepartmentName   as ssesbshopName  ,");
		sb.append("S_SE_SB_CustomerID as ssesbcustomerid,");
		sb.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime,");
		sb.append("S_SE_SB_PriceSum as ssesbpricesum,");
		sb.append("S_SE_SB_SalesValue as ssesbsalesvalue,");
		sb.append("S_SE_SB_DiscountNum as ssesbdiscountnum,");
		sb.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue,");
		sb.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue ");
		sb.append("from s_se_salesbasic ");
		sb.append("and S_SE_SB_OrdersType = 4 and S_SE_SB_SalesID = ?");

		List<String> params = new ArrayList<String>();
		params.add(salesID);
		return (SalesBasicPo) queryForObject(sb.toString(), params.toArray(),
				SalesBasicPo.class);
	}

	/**
	 * 得到所有顾客销售结帐明细表,销售结帐基表对应的
	 */
	public List<SalesDetailPo> getSalesDetail(String ssesdsalesid) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("select ");
		buffer.append("C_ST_CPOD_GlassesBillID as ssesdid, ");
		buffer.append("C_ST_CPRD_GoodsID as ssesdsalesitemid, ");
		buffer.append("C_ST_CPRD_BarCode as ssesditemid ");
		buffer.append("FROM C_ST_ConsignProcessOrderDetails ");
		buffer.append("INNER JOIN C_ST_ConsignProcessReceiptDetails ON ");
		buffer.append("C_ST_CPOD_Id = C_ST_CPRD_OrderDetailsID");
		buffer.append("where C_ST_CPOD_GlassesBillID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(ssesdsalesid);

		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesDetailPo.class);
	}

	/**
	 * 获取到镜提醒时间
	 */
	public SalesBasicPo getSalesBasic(String salesID) {
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  convert(varchar(10),S_SE_SB_SalesDatetime,23)  as ssesbsalesdatetime ");
		sb.append("from s_se_salesbasic ");
		sb.append("where S_SE_SB_SalesID = ? ");
		List<String> params = new ArrayList<String>();
		params.add(salesID);
		return (SalesBasicPo) queryForObject(sb.toString(), params.toArray(),
				SalesBasicPo.class);
	}
	
	

}
