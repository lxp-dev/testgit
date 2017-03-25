/**
 * 
 */
package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.RefundDao;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.storage.persistence.StrogeLogPo;
import com.pengsheng.eims.storage.persistence.StrogeLogTempPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class RefunDaoImpl extends BaseJdbcDaoSupport implements RefundDao {
	/**
	 * 得到打印镜单信息
	 */
	public List<SalesBasicPo> getSalesBasics(SalesBasicPo salesBasicPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_SE_SB_SalesDatetime desc) as rowNum, ");
		buffer.append("S_SE_SB_SalesID as ssesbsalesid,");
		buffer.append("S_SE_SB_orderstype as ssesborderstype,");
		buffer.append("S_ME_CI_Name as ssesbpersonName,");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid,");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime,");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum,");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue,");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum,");
		buffer.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue,");
		buffer.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue, ");
		buffer.append("S_SE_SB_CheckoutFlag as ssesbcheckoutflag ");
		buffer.append("from s_se_salesbasic ");
		buffer.append("inner join SYS_PersonInfo s ");
		buffer.append("on s.ID = S_SE_SB_SalerID ");
		buffer.append("inner join S_ME_CustomerInfo ");
		buffer.append("on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");

		buffer.append("where S_SE_SB_ShopCode = ? ");
		buffer.append("and S_SE_SB_WithdrawFlag <> 1 ");

		params.add(salesBasicPo.getSsesbshopcode());

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_SE_SB_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}

		buffer.append("and S_SE_SB_InTransit not IN (8, 9, 10, 11, 12) ");
		// 已收费
		buffer.append("and S_SE_SB_ValueFlag = 1 ");

		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}

	/**
	 * 根据销售单号将信息插入在途明细表中
	 * 
	 * @param inTransitPo
	 */
	public void insertIntrnsitInfo(InTransitPo inTransitPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into S_SE_InTransit( ");
		buffer.append("S_SE_IT_ID, S_SE_IT_SalesID, S_SE_IT_State ");
		buffer.append(", S_SE_IT_Date, S_SE_IT_CreatePerson ");
		buffer.append(", S_SE_IT_Department ) ");
		buffer.append("values (? , ? , ? , getdate() , ? , ?) ");

		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitstate());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新销售基表中的在途点
	 * 
	 * @param salesDetailPo
	 */
	public void updateMaterialsInTransit(SalesBasicPo salesBasicPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("update S_SE_SalesBasic ");
		buffer.append("set S_SE_SB_InTransit= ? ");
		buffer.append(", S_SE_SB_WithdrawDate = dbo.ufn_getDayCheckOut() ");
		buffer.append(", S_SE_SB_FactWithdrawDate = GETDATE() ");
		buffer.append(", S_SE_SB_WithdrawFlag = '1' ");
		buffer.append(", S_SE_SB_WithdrawPersonID = ? ");
		buffer.append(", S_SE_SB_CheckoutFlag = '0' ");
		buffer.append("where S_SE_SB_SalesID= ? ");
		
		buffer.append("update S_SE_SalesBasic_Finished ");
		buffer.append("set S_SE_SB_InTransit= ? ");
		buffer.append(", S_SE_SB_WithdrawDate = dbo.ufn_getDayCheckOut() ");
		buffer.append(", S_SE_SB_FactWithdrawDate = GETDATE() ");
		buffer.append(", S_SE_SB_WithdrawFlag = '1' ");
		buffer.append(", S_SE_SB_WithdrawPersonID = ? ");
		buffer.append(", S_SE_SB_CheckoutFlag = '0' ");
		buffer.append("where S_SE_SB_SalesID= ? ");

		params.add(salesBasicPo.getSsesbintransit());
		params.add(salesBasicPo.getSsesbwithdrawpersonid());
		params.add(salesBasicPo.getSsesbsalesid());
		params.add(salesBasicPo.getSsesbintransit());
		params.add(salesBasicPo.getSsesbwithdrawpersonid());
		params.add(salesBasicPo.getSsesbsalesid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
//	/**
//	 * 取出退货详细
//	 * 
//	 * @param strogeChangePo
//	 */
//	public List<StrogeLogTempPo> getSalesDetailList(String salesid,String stockid) {
//		StringBuffer buffer = new StringBuffer();
//		List<String> params = new ArrayList<String>();
//		buffer.append("select cshslgoodsbarcode as cshslgoodsbarcode,cshslgoodsid as cshslgoodsid,");
//		buffer.append("cshslstockid as cshslstockid,cshslgoodsquantity as cshslgoodsquantity,");
//		buffer.append("cshslcostprice as cshslcostprice,cshslnottaxrate as cshslnottaxrate,cshslwarehousingdate as cshslwarehousingdate,");
//		buffer.append("cshslchangeid as cshslchangeid,uuid as uuid from ( ");
//		buffer.append("SELECT S_SE_SD_ItemID as cshslgoodsbarcode, ");
//		buffer.append("       S_SE_SD_SalesItemID as cshslgoodsid, ");
//		buffer.append("       ? as cshslstockid, ");
//		buffer.append("       CAST(S_SE_SD_Number AS VARCHAR) as cshslgoodsquantity, ");
//		buffer.append("       S_SE_SD_CostsPrive as cshslcostprice, ");
//		buffer.append("       S_SE_SD_UnitPrice as cshslnottaxrate, ");
//		buffer.append("       Getdate() as cshslwarehousingdate, ");
//		buffer.append("       S_SE_SD_SalesID as cshslchangeid, ");
//		buffer.append("       S_SE_SD_ID as uuid ");
//		buffer.append("FROM   S_SE_SalesDetail ");
//		buffer.append("       INNER JOIN C_SH_StorageLog ");
//		buffer.append("         ON C_SH_SL_ChangeID = S_SE_SD_SalesID ");
//		buffer.append("            AND S_SE_SD_ItemID = c_sh_sl_goodsbarcode ");
//		buffer.append("WHERE  S_SE_SD_SalesID = ? ");
//		buffer.append("       AND Substring(S_SE_SD_SalesItemID, 3, 2) <> 'zz' ");
//		buffer.append("       )t 	group by cshslgoodsbarcode,cshslgoodsid,cshslstockid,cshslgoodsquantity,");
//		buffer.append("       cshslcostprice,cshslnottaxrate,cshslwarehousingdate,cshslchangeid,uuid");
//		params.add(Utility.getName(stockid));
//		params.add(salesid);
//		return queryForObjectList(buffer.toString(), params.toArray(), StrogeLogTempPo.class);
//	}
	
	
	/**
	 * 取出退货详细--新方法，取消C_SH_StorageLog的联查
	 * 
	 * @param strogeChangePo
	 */
	public List<StrogeLogTempPo> getSalesDetailList(String salesid,String stockid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT S_SE_SD_ItemID                  AS cshslgoodsbarcode, ");
		buffer.append("       S_SE_SD_SalesItemID             AS cshslgoodsid, ");
		buffer.append("       ?                              AS cshslstockid, ");
		buffer.append("       CAST(S_SE_SD_Number AS VARCHAR) AS cshslgoodsquantity, ");
		buffer.append("       S_SE_SD_CostsPrive              AS cshslcostprice, ");
		buffer.append("       S_SE_SD_UnitPrice               AS cshslnottaxrate, ");
		buffer.append("       Getdate()                       AS cshslwarehousingdate, ");
		buffer.append("       S_SE_SD_SalesID                 AS cshslchangeid, ");
		buffer.append("       S_SE_SD_ID                      AS uuid, ");
		buffer.append("       S_SE_SD_OutStorageFlag          AS cshsloutstorageflag, ");
		buffer.append("       S_SE_SD_LargessFlag             AS cshsllargessflag,isnull(B_GI_isCustomize,'') as cshslisCustomize ");
		buffer.append("FROM   S_SE_SalesDetail inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		buffer.append("WHERE  S_SE_SD_SalesID = ? ");
		buffer.append("       AND isnull(S_SE_SD_ItemID,'') <> '' ");
		buffer.append("       AND Substring(S_SE_SD_SalesItemID, 3, 2) <> 'zz' ");
		buffer.append("  union all ");
		buffer.append("SELECT S_SE_SD_ItemID                  AS cshslgoodsbarcode, ");
		buffer.append("       S_SE_SD_SalesItemID             AS cshslgoodsid, ");
		buffer.append("       ?                              AS cshslstockid, ");
		buffer.append("       CAST(S_SE_SD_Number AS VARCHAR) AS cshslgoodsquantity, ");
		buffer.append("       S_SE_SD_CostsPrive              AS cshslcostprice, ");
		buffer.append("       S_SE_SD_UnitPrice               AS cshslnottaxrate, ");
		buffer.append("       Getdate()                       AS cshslwarehousingdate, ");
		buffer.append("       S_SE_SD_SalesID                 AS cshslchangeid, ");
		buffer.append("       S_SE_SD_ID                      AS uuid, ");
		buffer.append("       S_SE_SD_OutStorageFlag          AS cshsloutstorageflag, ");
		buffer.append("       S_SE_SD_LargessFlag             AS cshsllargessflag,isnull(B_GI_isCustomize,'') as cshslisCustomize ");
		buffer.append("FROM   S_SE_SalesDetail_Finished inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		buffer.append("WHERE  S_SE_SD_SalesID = ? ");
		buffer.append("       AND isnull(S_SE_SD_ItemID,'') <> '' ");
		buffer.append("       AND Substring(S_SE_SD_SalesItemID, 3, 2) <> 'zz' ");
		
		params.add(Utility.getName(stockid));
		params.add(salesid);
		params.add(Utility.getName(stockid));
		params.add(salesid);
		
		return queryForObjectList(buffer.toString(), params.toArray(), StrogeLogTempPo.class);
	}
	
	/**
	 * 更新退款仓位
	 * 2011-6-9
	 * @param customerid
	 * @param integral
	 */
	public void updateInWarehouse(StrogeLogTempPo strogeLogPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("update S_SE_SalesDetail set S_SE_SD_InStockId=? where S_SE_SD_ID=? ");
		buffer.append("update S_SE_SalesDetail_Finished set S_SE_SD_InStockId=? where S_SE_SD_ID=? ");
		
		params.add(strogeLogPo.getCshslstockid());
		params.add(strogeLogPo.getUuid());
		
		params.add(strogeLogPo.getCshslstockid());
		params.add(strogeLogPo.getUuid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 根据销售单号将信息插入当月库存变更表中
	 * 
	 * @param strogeChangePo
	 */
	public void insertStrogeChanges(StrogeLogTempPo strogeLogPo) {
			StringBuffer buffer = new StringBuffer();
			List<String> params = new ArrayList<String>();

			buffer.append("insert into C_SH_StorageChange( ");
			buffer.append("C_SH_SC_UUID,C_SH_SC_GoodsBarCode ");
			buffer.append(", C_SH_SC_GoodsId ");
			buffer.append(", C_SH_SC_StockId ");
			buffer.append(", C_SH_SC_GoodsQuantity ");
			buffer.append(", C_SH_SC_CostPrice ");
			buffer.append(", C_SH_SC_NotTaxRate ");
			buffer.append(", C_SH_SC_WarehousingDate ");
			buffer.append(", C_SH_SC_ChangeID) values ");
			buffer.append("(");
			buffer.append(" ?,substring(?,0,19), ?, ?, ?, ?, ?, ?, ?");
			buffer.append(") ");

			params.add(this.uuid.generate());
			params.add(strogeLogPo.getCshslgoodsbarcode());
			params.add(strogeLogPo.getCshslgoodsid());
			params.add(strogeLogPo.getCshslstockid());
			params.add(strogeLogPo.getCshslgoodsquantity());
			params.add(strogeLogPo.getCshslcostprice());
			params.add(strogeLogPo.getCshslnottaxrate());
			params.add(strogeLogPo.getCshslwarehousingdate());
			params.add(strogeLogPo.getCshslchangeid());
			

			getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
//	public void insertStrogeChange(String salesid, String stockid) {
//		StringBuffer buffer = new StringBuffer();
//		List<String> params = new ArrayList<String>();
//
//		buffer.append("insert into C_SH_StorageChange( ");
//		buffer.append("C_SH_SC_UUID,C_SH_SC_GoodsBarCode ");
//		buffer.append(", C_SH_SC_GoodsId ");
//		buffer.append(", C_SH_SC_StockId ");
//		buffer.append(", C_SH_SC_GoodsQuantity ");
//		buffer.append(", C_SH_SC_CostPrice ");
//		buffer.append(", C_SH_SC_NotTaxRate ");
//		buffer.append(", C_SH_SC_WarehousingDate ");
//		buffer.append(", C_SH_SC_ChangeID) ");
//		buffer.append("( select replace(NEWID(),'-',''),replace(S_SE_SD_SalesItemID,'.','') ");
//		buffer.append(", S_SE_SD_SalesItemID ");
//		buffer.append(", ? ");
//		buffer.append(", cast(S_SE_SD_Number as varchar ) ");
//		buffer.append(", S_SE_SD_CostsPrive ");
//		buffer.append(", S_SE_SD_UnitPrice ");
//		buffer.append(", getdate() ");
//		buffer.append(", S_SE_SD_SalesID ");
//		buffer.append("from S_SE_SalesDetail ");
//		buffer.append("inner join C_SH_StorageLog on C_SH_SL_ChangeID=S_SE_SD_SalesID and S_SE_SD_ItemID=c_sh_sl_goodsbarcode ");
//		buffer.append("where ");
//		buffer.append("S_SE_SD_SalesID= ? and ");
//		buffer.append("	substring(S_SE_SD_SalesItemID,3,2)<>'zz'");
//		buffer.append(") ");
//
//		params.add(stockid);
//		params.add(salesid);
//
//		getJdbcTemplate().update(buffer.toString(), params.toArray());
//	}
	
	/**
	 * 根据销售单号将信息插入当月库存变更表中
	 * 
	 * @param strogeChangePo
	 */
	public void insertStrogeLogs(StrogeLogTempPo strogeLogPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into C_SH_StorageLog( ");
		buffer.append("C_SH_Sl_GoodsBarCode ");
		buffer.append(", C_SH_Sl_GoodsId ");
		buffer.append(", C_SH_Sl_StockId ");
		buffer.append(", C_SH_Sl_GoodsQuantity ");
		buffer.append(", C_SH_Sl_CostPrice ");
		buffer.append(", C_SH_Sl_NotTaxRate ");
		buffer.append(", C_SH_Sl_WarehousingDate ");
		buffer.append(", C_SH_Sl_ChangeID,C_SH_Sl_UUID,C_SH_SL_Flag,C_SH_SL_GuaranteePeriod,C_SH_SL_Batch) values ");
		buffer.append("(");
		buffer.append(" ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?");
		buffer.append(") ");

		params.add(strogeLogPo.getCshslgoodsbarcode());
		params.add(strogeLogPo.getCshslgoodsid());
		params.add(strogeLogPo.getCshslstockid());
		params.add(strogeLogPo.getCshslgoodsquantity());
		params.add(strogeLogPo.getCshslcostprice());
		params.add(strogeLogPo.getCshslnottaxrate());
		params.add(strogeLogPo.getCshslwarehousingdate());
		params.add(strogeLogPo.getCshslchangeid());
		params.add(this.uuid.generate());
		params.add(Utility.getName(strogeLogPo.getCshsllargessflag())); //配镜单退款标志
		params.add(Utility.getName(strogeLogPo.getCshslguaranteeperiod()));
		params.add(Utility.getName(strogeLogPo.getCshslbatch()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
//	public void insertStrogeChangeLog(String salesid, String stockid) {
//		StringBuffer buffer = new StringBuffer();
//		List<String> params = new ArrayList<String>();
//
//		buffer.append("insert into C_SH_StorageLog( ");
//		buffer.append("C_SH_Sl_GoodsBarCode ");
//		buffer.append(", C_SH_Sl_GoodsId ");
//		buffer.append(", C_SH_Sl_StockId ");
//		buffer.append(", C_SH_Sl_GoodsQuantity ");
//		buffer.append(", C_SH_Sl_CostPrice ");
//		buffer.append(", C_SH_Sl_NotTaxRate ");
//		buffer.append(", C_SH_Sl_WarehousingDate ");
//		buffer.append(", C_SH_Sl_ChangeID,C_SH_SL_UUID) ");
//		buffer.append("( select S_SE_SD_ItemID ");
//		buffer.append(", S_SE_SD_SalesItemID ");
//		buffer.append(", ? ");
//		buffer.append(", cast(S_SE_SD_Number as varchar ) ");
//		buffer.append(", S_SE_SD_CostsPrive ");
//		buffer.append(", S_SE_SD_UnitPrice ");
//		buffer.append(", getdate() ");
//		buffer.append(", S_SE_SD_SalesID, replace(NEWID(),'-','')");
//		buffer.append("from S_SE_SalesDetail ");
//		buffer.append("inner join C_SH_StorageLog on C_SH_SL_ChangeID=S_SE_SD_SalesID and S_SE_SD_ItemID=c_sh_sl_goodsbarcode ");
//		buffer.append("where ");
//		buffer.append("S_SE_SD_SalesID= ? and ");
//		buffer.append("	substring(S_SE_SD_SalesItemID,3,2)<>'zz'");
//		buffer.append(") ");
//
//		params.add(stockid);
//		params.add(salesid);
//
//		getJdbcTemplate().update(buffer.toString(), params.toArray());
//	}


	/**
	 * 根据配镜单号查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo customerInfoPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  S_ME_CI_Name as smeciname, ");
		buffer.append("S_ME_CI_Sex as smecisex , ");
		buffer.append("S_ME_CI_Birthday as smecibirthday, ");
		buffer.append("S_ME_CI_MemberId as smecimemberid,S_ME_CI_Phone as smeciphone, ");
		buffer.append("S_ME_CI_CustomerID as smecicustomerid,S_SE_SB_SalesID as fmmsalesid,S_SE_SB_OrdersType as fmmsalesorderid ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("left JOIN ( ");
		buffer.append(" select S_SE_SB_SalesID,S_SE_SB_CustomerID,S_SE_SB_OrdersType from ( ");
		buffer.append(" select S_SE_SB_SalesID,S_SE_SB_CustomerID,S_SE_SB_OrdersType from S_SE_SalesBasic union all ");
		buffer.append(" select S_SE_SB_SalesID,S_SE_SB_CustomerID,S_SE_SB_OrdersType from S_SE_SalesBasic_Finished ");				
		buffer.append(" )t )t on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
			
		buffer.append("where 1=1 ");

		if (!"".equals(Utility.getName(customerInfoPo.getFmmsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(customerInfoPo.getFmmsalesid());
		}

		if (!"".equals(Utility.getName(customerInfoPo.getFmmsalesorderid()))) {
			buffer.append("and S_SE_SB_OrdersType = ? ");
			params.add(Utility.getName(customerInfoPo.getFmmsalesorderid()));
		}
		
		if(customerInfoPo.getSmecishoplist() != null && customerInfoPo.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = customerInfoPo.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params
				.toArray(), CustomerInfoPo.class);
	}

	public void updateCustomerIntegral(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if(Utility.getName(salesBasicPo.getSsesbfcustomerid()).equals("")){
			buffer.append("UPDATE top (1) S_ME_CustomerInfo ");
			buffer.append("SET S_ME_CI_Integral = S_ME_CI_Integral - cast( ? as float), ");
			buffer.append("S_ME_CI_ConsumptionNumber = (cast(S_ME_CI_ConsumptionNumber as numeric) - 1), ");
			buffer.append("S_ME_CI_ConsumptionPrice = (S_ME_CI_ConsumptionPrice - (select isnull(sum(S_SE_SD_SalesValue),0) from S_SE_SalesDetail where S_SE_SD_SalesID=?) - (select isnull(sum(S_SE_SD_SalesValue),0) from S_SE_SalesDetail_Finished where S_SE_SD_SalesID=?) - (select isnull(sum(cast((S_SE_Amount*S_SE_Number) as numeric(30,2))),0) from S_SE_AdditionalCDetail where S_SE_SalesID=?)) ");
			buffer.append("FROM S_ME_CustomerInfo ");
			
			buffer.append("INNER JOIN ");
			buffer.append("uview_SalesBasic ON ");
			buffer.append("S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
			buffer.append("WHERE S_SE_SB_SalesID = ? ");
			params.add(Utility.getName(salesBasicPo.getNowintegral()));
			params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
			params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
			params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
			params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		}else{
			buffer.append("UPDATE top (1) S_ME_CustomerInfo ");
			buffer.append("SET S_ME_CI_Integral = S_ME_CI_Integral - cast( ? as float) ");
			buffer.append("FROM S_ME_CustomerInfo ");
			
			buffer.append("WHERE S_ME_CI_CustomerID = ? ");
			params.add(Utility.getName(salesBasicPo.getNowintegral()));
			params.add(Utility.getName(salesBasicPo.getSsesbfcustomerid()));
			
			if("".equals(Utility.getName(salesBasicPo.getSsesbweixintype()))){
				buffer.append("UPDATE top (1) S_ME_CustomerInfo ");
				buffer.append("SET S_ME_CI_ConsumptionNumber = (cast(S_ME_CI_ConsumptionNumber as numeric) - 1), ");
				buffer.append("S_ME_CI_ConsumptionPrice = (S_ME_CI_ConsumptionPrice - (select isnull(sum(S_SE_SD_SalesValue),0) from S_SE_SalesDetail where S_SE_SD_SalesID=?) - (select isnull(sum(S_SE_SD_SalesValue),0) from S_SE_SalesDetail_Finished where S_SE_SD_SalesID=?) - (select isnull(sum(cast((S_SE_Amount*S_SE_Number) as numeric(30,2))),0) from S_SE_AdditionalCDetail where S_SE_SalesID=?)) ");
				buffer.append("FROM S_ME_CustomerInfo ");
				
				buffer.append("WHERE S_ME_CI_CustomerID = ? ");
				params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
				params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
				params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
				params.add(Utility.getName(salesBasicPo.getSsesbcustomerid()));
			}
		}
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 退顾客积分
	 * 
	 * @param customerid
	 * @param integral
	 */
	public void updateIntegralAddandSub(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into S_ME_IntegralAddandSub (S_ME_AS_UUID,S_ME_AS_CustomerID,S_ME_AS_MemberId,S_ME_AS_YIntegral,S_ME_AS_CIntegral,S_ME_AS_XIntegral,S_ME_AS_DoPersonID,S_ME_AS_DoDate,S_ME_AS_AddOrSub,S_ME_AS_SalesBillID,S_ME_AS_WithdrawFlag,S_ME_AS_FCustomerID) ");
		buffer.append("select top 1 replace(newid(),'-',''),?,");
		params.add(Utility.getName(salesBasicPo.getSsesbcustomerid()));
		buffer.append("?,");
		params.add(Utility.getName(salesBasicPo.getSsesbMemberId()));
		
		if("".equals(Utility.getName(salesBasicPo.getSsesbweixintype()))){
			if(!"".equals(Utility.getName(salesBasicPo.getSsesbfcustomerid()))){
				buffer.append("(select S_ME_CI_Integral from S_ME_CustomerInfo where S_ME_CI_CustomerID = ?),");
				params.add(Utility.getName(salesBasicPo.getSsesbcustomerid()));
			}else{
				buffer.append("(select S_ME_CI_Integral from S_ME_CustomerInfo where S_ME_CI_CustomerID = (select S_SE_SB_CustomerID from uview_SalesBasic where S_SE_SB_SalesID = ?)),");
				params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
			}
		}else{
			buffer.append("?,");
			params.add(Utility.getName(salesBasicPo.getInintrgral()));
		}
		
		buffer.append("-cast( ? as float),");
		params.add(Utility.getName(salesBasicPo.getNowintegral()));
		
		if("".equals(Utility.getName(salesBasicPo.getSsesbweixintype()))){
			if(!"".equals(Utility.getName(salesBasicPo.getSsesbfcustomerid()))){
				buffer.append("(cast((select S_ME_CI_Integral from S_ME_CustomerInfo where S_ME_CI_CustomerID = ? ) as float)-cast( ? as float)),");
				params.add(Utility.getName(salesBasicPo.getSsesbcustomerid()));
				params.add(Utility.getName(salesBasicPo.getNowintegral()));
			}else{
				buffer.append("(cast((select S_ME_CI_Integral from S_ME_CustomerInfo where S_ME_CI_CustomerID = (select S_SE_SB_CustomerID from uview_SalesBasic where S_SE_SB_SalesID = ?)) as float)-cast( ? as float)),");
				params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
				params.add(Utility.getName(salesBasicPo.getNowintegral()));
			}
		}else{
			buffer.append("(cast(? as float)-cast( ? as float)),");
			params.add(Utility.getName(salesBasicPo.getInintrgral()));
			params.add(Utility.getName(salesBasicPo.getNowintegral()));
		}
		
		buffer.append("?,");
		buffer.append("getdate(),'4',");
		buffer.append("S_ME_AS_SalesBillID,");
		buffer.append("'1', ");
		buffer.append("? ");
		buffer.append("from S_ME_IntegralAddandSub ");
		buffer.append("where isnull(S_ME_AS_WithdrawFlag,'') <> '1' ");
		buffer.append("  and isnull(S_ME_AS_SalesBillID,'') = ? order by S_ME_AS_DoDate ");
		
		params.add(Utility.getName(salesBasicPo.getSsesbwithdrawpersonid()));
		params.add(Utility.getName(salesBasicPo.getSsesbfcustomerid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public SalesBasicPo getSalesBasicPo(String salesID){
		 
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select top 1 * from ( select S_SE_SB_InTransit as ssesbintransit,S_SE_SB_CheckoutFlag as ssesbcheckoutflag from s_se_salesbasic where S_SE_SB_SalesID=? ");
		sb.append(" union all select S_SE_SB_InTransit as ssesbintransit,S_SE_SB_CheckoutFlag as ssesbcheckoutflag from s_se_salesbasic_Finished where S_SE_SB_SalesID=? )t ");
		params.add(salesID);
		params.add(salesID);
		return (SalesBasicPo) queryForObject(sb.toString(), params
				.toArray(), SalesBasicPo.class);
	}

	
	public void deleteCustomize(String salesID) {
		 
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from s_se_customize where s_se_c_salesid=? ");
	

		List<String> params = new ArrayList<String>();
		params.add(salesID);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void deleteCustomizeTui(String salesID) {
		 
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from s_se_customizeTui where s_se_c_salesid=? ");
	

		List<String> params = new ArrayList<String>();
		params.add(salesID);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}


	public List<SalesBasicPo> getSalesBasics(SalesBasicPo salesBasicPo,SystemParameterPo systemParameterPo,
			int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by ssesbsalesdatetime desc) as rowNum,* from ( ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid,");
		buffer.append("S_SE_SB_orderstype as ssesborderstype,");
		buffer.append("S_ME_CI_Name as ssesbpersonName,");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid,");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime,");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum,");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue,");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum,");
		buffer.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue,");
		buffer.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue, ");
		buffer.append("S_SE_SB_CheckoutFlag as ssesbcheckoutflag, ");
		buffer.append("S_SE_SB_Renums as ssesbrenums, ");
		buffer.append("(select top 1 isnull(S_ME_CC_HandleState,'0') from S_ME_CustomerComplain where S_ME_CC_LinkSalesID=S_SE_SB_SalesID) as ssesbhandlestate, ");
		buffer.append("(select count(S_ME_CC_LinkSalesID) from S_ME_CustomerComplain where S_ME_CC_LinkSalesID=S_SE_SB_SalesID) as ssesbhandlestatecount ");
		buffer.append(", isnull(g.hisbillcount,0) as ssesbnothisflag ");     // 已传递结款，未传递退款
		buffer.append(", isnull(h.hisbillcount,0) as ssesbhisflag ");        // 已传递退款 
		buffer.append(", isnull(m.hisbillcount,0) as ssesbhispayflag ");     // 已退费		
		buffer.append(", isnull(n.hisbillcount,0) as ssesbhiscancelflag ");  // 未传递 
		
		buffer.append("from s_se_salesbasic ");
		buffer.append("inner join SYS_PersonInfo s ");
		buffer.append("on s.ID = S_SE_SB_SalerID ");
		buffer.append("inner join S_ME_CustomerInfo ");
		buffer.append("on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		
		buffer.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm where S_HC_CC_Chargetype <> '4' group by S_HC_CC_Billid )g on S_SE_SB_SalesID = g.S_HC_CC_Billid ");
		buffer.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm where S_HC_CC_Chargetype = '4' group by S_HC_CC_Billid )h on S_SE_SB_SalesID = h.S_HC_CC_Billid ");
        buffer.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm where S_HC_CC_Flag = '1' and S_HC_CC_Chargetype = '4' group by S_HC_CC_Billid )m on S_SE_SB_SalesID = m.S_HC_CC_Billid ");
        buffer.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm group by S_HC_CC_Billid )n on S_SE_SB_SalesID = n.S_HC_CC_Billid ");
		
		buffer.append("where S_SE_SB_ShopCode = ? ");
		buffer.append("and isnull(S_SE_SB_WithdrawFlag,'') <> '1' ");
		params.add(salesBasicPo.getSsesbshopcode());

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}
		if ("0".equals(Utility.getName(systemParameterPo.getFspshopdistributionrefund()))){
			buffer.append("and S_SE_SB_InTransit IN ('2','12','13') ");
		}else{
			buffer.append("and S_SE_SB_InTransit IN ('2','3','12','13') ");
		}
		buffer.append("and S_SE_SB_ValueFlag = 1 ");

		if (!"".equals(Utility.getName(salesBasicPo.getSsesborderstype()))) {
			buffer.append("and S_SE_SB_OrdersType = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesborderstype()));
		}
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbintransit2()))) {
			buffer.append("and S_SE_SB_InTransit = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbintransit2()));
		}
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcheckoutflag()))) {
			buffer.append("and isnull(S_SE_SB_CheckoutFlag,'0') = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcheckoutflag()));
		}
		
		buffer.append(" union all ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid,");
		buffer.append("S_SE_SB_orderstype as ssesborderstype,");
		buffer.append("S_ME_CI_Name as ssesbpersonName,");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid,");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime,");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum,");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue,");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum,");
		buffer.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue,");
		buffer.append("S_SE_SB_ArrearsValue as ssesbarrearsvalue, ");
		buffer.append("S_SE_SB_CheckoutFlag as ssesbcheckoutflag, ");
		buffer.append("S_SE_SB_Renums as ssesbrenums, ");
		buffer.append("(select top 1 isnull(S_ME_CC_HandleState,'0') from S_ME_CustomerComplain where S_ME_CC_LinkSalesID=S_SE_SB_SalesID) as ssesbhandlestate, ");
		buffer.append("(select count(S_ME_CC_LinkSalesID) from S_ME_CustomerComplain where S_ME_CC_LinkSalesID=S_SE_SB_SalesID) as ssesbhandlestatecount ");
		buffer.append(", isnull(g.hisbillcount,0) as ssesbnothisflag ");     // 已传递结款，未传递退款
		buffer.append(", isnull(h.hisbillcount,0) as ssesbhisflag ");        // 已传递退款 
		buffer.append(", isnull(m.hisbillcount,0) as ssesbhispayflag ");     // 已退费		
		buffer.append(", isnull(n.hisbillcount,0) as ssesbhiscancelflag ");  // 未传递 
		buffer.append("from s_se_salesbasic_Finished ");
		buffer.append("inner join SYS_PersonInfo s ");
		buffer.append("on s.ID = S_SE_SB_SalerID ");
		buffer.append("inner join S_ME_CustomerInfo ");
		buffer.append("on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		
		buffer.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm where S_HC_CC_Chargetype <> '4' group by S_HC_CC_Billid )g on S_SE_SB_SalesID = g.S_HC_CC_Billid ");
		buffer.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm where S_HC_CC_Chargetype = '4' group by S_HC_CC_Billid )h on S_SE_SB_SalesID = h.S_HC_CC_Billid ");
        buffer.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm where S_HC_CC_Flag = '1' and S_HC_CC_Chargetype = '4' group by S_HC_CC_Billid )m on S_SE_SB_SalesID = m.S_HC_CC_Billid ");
        buffer.append("left join (select S_HC_CC_Billid,count(S_HC_CC_ID) as hisbillcount from S_HC_CC_HISChargeConfirm group by S_HC_CC_Billid )n on S_SE_SB_SalesID = n.S_HC_CC_Billid ");
		
		buffer.append("where S_SE_SB_ShopCode = ? ");
		buffer.append("and isnull(S_SE_SB_WithdrawFlag,'') <> '1' ");
		params.add(salesBasicPo.getSsesbshopcode());

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}
		if ("0".equals(Utility.getName(systemParameterPo.getFspshopdistributionrefund()))){
			buffer.append("and S_SE_SB_InTransit IN ('2','12','13') ");
		}else{
			buffer.append("and S_SE_SB_InTransit IN ('2','3','12','13') ");
		}
		buffer.append("and S_SE_SB_ValueFlag = 1 ");

		if (!"".equals(Utility.getName(salesBasicPo.getSsesborderstype()))) {
			buffer.append("and S_SE_SB_OrdersType = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesborderstype()));
		}
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbintransit2()))) {
			buffer.append("and S_SE_SB_InTransit = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbintransit2()));
		}
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcheckoutflag()))) {
			buffer.append("and isnull(S_SE_SB_CheckoutFlag,'0') = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcheckoutflag()));
		}
		
		buffer.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}

	public int getSalesBasicsCount(SalesBasicPo salesBasicPo,SystemParameterPo systemParameterPo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select sum(count1) from ( ");
		buffer.append("select count(S_SE_SB_SalesID) as count1 ");
		buffer.append("from S_SE_SalesBasic ");
		buffer
				.append("inner join SYS_PersonInfo as s on s.ID = S_SE_SB_SalerID ");
		buffer
				.append("inner join SYS_PersonInfo as p on p.ID = S_SE_SB_PosID ");
		buffer
				.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("where S_SE_SB_ShopCode = ? ");
		buffer.append("and isnull(S_SE_SB_WithdrawFlag,'') <> '1' ");

		params.add(salesBasicPo.getSsesbshopcode());

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}
		if ("0".equals(Utility.getName(systemParameterPo.getFspshopdistributionrefund()))){
			buffer.append("and S_SE_SB_InTransit IN ('2','12','13') ");
		}else{
			buffer.append("and S_SE_SB_InTransit IN ('2','3','12','13') ");
		}
	
		buffer.append("and S_SE_SB_ValueFlag = 1 ");

		if (!"".equals(Utility.getName(salesBasicPo.getSsesborderstype()))) {
			buffer.append("and S_SE_SB_OrdersType = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesborderstype()));
		}
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbintransit2()))) {
			buffer.append("and S_SE_SB_InTransit = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbintransit2()));
		}
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcheckoutflag()))) {
			buffer.append("and isnull(S_SE_SB_CheckoutFlag,'0') = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcheckoutflag()));
		}
		buffer.append(" union all ");
		buffer.append("select count(S_SE_SB_SalesID) as count1 ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer
				.append("inner join SYS_PersonInfo as s on s.ID = S_SE_SB_SalerID ");
		buffer
				.append("inner join SYS_PersonInfo as p on p.ID = S_SE_SB_PosID ");
		buffer
				.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("where S_SE_SB_ShopCode = ? ");
		buffer.append("and isnull(S_SE_SB_WithdrawFlag,'') <> '1' ");

		params.add(salesBasicPo.getSsesbshopcode());

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}

		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcustomerid()))) {
			buffer.append("and S_ME_CI_CustomerID = ? ");
			params.add(salesBasicPo.getSsesbcustomerid());
		}
		if ("0".equals(Utility.getName(systemParameterPo.getFspshopdistributionrefund()))){
			buffer.append("and S_SE_SB_InTransit IN ('2','12','13') ");
		}else{
			buffer.append("and S_SE_SB_InTransit IN ('2','3','12','13') ");
		}
	
		buffer.append("and S_SE_SB_ValueFlag = 1 ");

		if (!"".equals(Utility.getName(salesBasicPo.getSsesborderstype()))) {
			buffer.append("and S_SE_SB_OrdersType = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesborderstype()));
		}
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbintransit2()))) {
			buffer.append("and S_SE_SB_InTransit = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbintransit2()));
		}
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcheckoutflag()))) {
			buffer.append("and isnull(S_SE_SB_CheckoutFlag,'0') = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcheckoutflag()));
		}
		buffer.append(" )t ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 更新当日销售基表中的在途点
	 * 
	 * @param salesDetailPo
	 */
	public void updateMaterialsInTransitToday(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("update S_SE_SalesBasic_Today ");
		buffer.append("set S_SE_SB_InTransit= ? ");
		buffer.append(", S_SE_SB_WithdrawDate = dbo.ufn_getDayCheckOut() ");
		buffer.append(", S_SE_SB_FactWithdrawDate = GETDATE() ");		
		buffer.append(", S_SE_SB_WithdrawFlag = '1' ");
		buffer.append(", S_SE_SB_WithdrawPersonID = ? ");
		buffer.append("where S_SE_SB_SalesID= ? ");

		params.add(salesBasicPo.getSsesbintransit());
		params.add(salesBasicPo.getSsesbwithdrawpersonid());
		params.add(salesBasicPo.getSsesbsalesid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询当日销售基表中是否存在此销售单
	 * 
	 * @param salesDetailPo
	 */
	public int materialsTodayCount(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append("select count(S_SE_SB_SalesID) from S_SE_SalesBasic_Today where S_SE_SB_SalesID= ? ");

		params.add(salesBasicPo.getSsesbsalesid());
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 根据配镜单号删除当日销售明细
	 * 
	 * @param salesDetailPo
	 */
	public void deleteMmaterialsToday(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append("delete from S_SE_SalesDetail_Today where S_SE_SD_SalesID=? ");

		params.add(salesBasicPo.getSsesbsalesid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public int selectRefunIntegral(String salesid){
		StringBuffer  buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT TOP 1 (SELECT top 1 CAST((SELECT S_SE_SL_Price ");
		buffer.append("                           FROM   dbo.S_SE_SalesLog ");
		buffer.append("                           WHERE  S_SE_SL_SalesID = ? ");
		buffer.append("                                  AND S_SE_SL_ConsumptionID = '2') AS FLOAT) + CAST((SELECT top 1 S_ME_AS_CIntegral ");
		buffer.append("                                                                                     FROM   dbo.S_ME_IntegralAddandSub ");
		buffer.append("                                                                                     WHERE  S_ME_AS_SalesBillID = ?)AS FLOAT)) ");
		
		params.add(salesid);
		params.add(salesid);
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 更新商品退款标识
	 * 
	 * @param salesDetailPo
	 */
	public void updateSalesDetailGoodsWithdrawFlag(SalesDetailPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append("update top (1) S_SE_SalesDetail set S_SE_SD_WithdrawFlag='1',S_SE_SD_WithdrawDate=dbo.ufn_getDayCheckOut(),S_SE_SD_FactWithdrawDate=getdate(),S_SE_SD_WithdrawPersonID=? where S_SE_SD_ID=? ");

		buffer.append("update top (1) S_SE_SalesDetail_Finished set S_SE_SD_WithdrawFlag='1',S_SE_SD_WithdrawDate=dbo.ufn_getDayCheckOut(),S_SE_SD_FactWithdrawDate=getdate(),S_SE_SD_WithdrawPersonID=? where S_SE_SD_ID=? ");

		params.add(Utility.getName(po.getSsesdwithdrawperson()));
		params.add(Utility.getName(po.getSsesdid()));
		params.add(Utility.getName(po.getSsesdwithdrawperson()));
		params.add(Utility.getName(po.getSsesdid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新今日商品退款标识
	 * 
	 * @param salesDetailPo
	 */
	public void updateSalesDetailGoodsWithdrawFlagToday(SalesDetailPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append("update top (1) S_SE_SalesDetail_Today set S_SE_SD_WithdrawFlag='1',S_SE_SD_WithdrawDate=dbo.ufn_getDayCheckOut(),S_SE_SD_FactWithdrawDate=getdate(),S_SE_SD_WithdrawPersonID=? where S_SE_SD_ID=? ");

		params.add(Utility.getName(po.getSsesdwithdrawperson()));
		params.add(Utility.getName(po.getSsesdid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增部分退款单
	 * 
	 * @param salesDetailPo
	 */
	public void insertPartSalesGoodsWithdrawBill(SalesBasicPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into S_SE_SalesBasic ");
		buffer.append(" (S_SE_SB_SalesID , S_SE_SB_ShopCode , S_SE_SB_CustomerID , S_SE_SB_OptID , S_SE_SB_OptometryID , ");
		buffer.append(" S_SE_SB_InspectionID, S_SE_SB_TakeGlassData , S_SE_SB_SalesDatetime , S_SE_SB_OrdersType , ");
		buffer.append(" S_SE_SB_BallGlassOD , S_SE_SB_BallGlassOS , S_SE_SB_PostGlassOD , S_SE_SB_PostGlassOS , ");
		buffer.append(" S_SE_SB_AxesOD , S_SE_SB_AxesOS , S_SE_SB_ADDOD , S_SE_SB_ADDOS , S_SE_SB_ArriseGlassOD1 , ");
		buffer.append(" S_SE_SB_ArriseGlassOS1 , S_SE_SB_BasisOD1 , S_SE_SB_BasisOS1 , S_SE_SB_PrismOD , S_SE_SB_PrismOS , ");
		buffer.append(" S_SE_SB_InterHighOD , S_SE_SB_InterHighOS , S_SE_SB_InterDistanceOD , S_SE_SB_InterDistanceOS , ");
		buffer.append(" S_SE_SB_FarVAOD , S_SE_SB_FarVAOS , S_SE_SB_CloseVAOD , S_SE_SB_CloseVAOS , S_SE_SB_RecipeType , ");
		buffer.append(" S_SE_SB_DignosisRe , S_SE_SB_DiameterOD , S_SE_SB_DiameterOS , S_SE_SB_ConRecipeType , ");
		buffer.append(" S_SE_SB_SecCheckDate , S_SE_SB_SubVisitUnit , S_SE_SB_SalesType , S_SE_SB_SalerID , ");
		buffer.append(" S_SE_SB_Lryid , S_SE_SB_PosDatetime , S_SE_SB_PosID , S_SE_SB_PriceSum , S_SE_SB_SalesValue , ");
		buffer.append(" S_SE_SB_EyeCurvatureOD1 , S_SE_SB_EyeCurvatureOD2 , S_SE_SB_EyeCurvatureOS1 , S_SE_SB_EyeCurvatureOS2 , ");
		buffer.append(" S_SE_SB_DiscountRate , S_SE_SB_DiscountNum , S_SE_SB_Psalsvalue , S_SE_SB_ArrearsValue , ");
		buffer.append(" S_SE_SB_Location , S_SE_SB_ArrivedDate , S_SE_SB_ValueFlag , S_SE_SB_CheckoutFlag , ");
		buffer.append(" S_SE_SB_InTransit , S_SE_SB_WithdrawDate , S_SE_SB_WithdrawFlag , S_SE_SB_WithdrawPersonID , ");
		buffer.append(" S_SE_SB_MovementType , S_SE_SB_ArrearsAppendDate , S_SE_SB_ArrearsDate , S_SE_SB_PayCash , ");
		buffer.append(" S_SE_SB_BankCard , S_SE_SB_StoredCard , S_SE_SB_Renums , S_SE_SB_DiscountType , S_SE_SB_DiscountPerson , S_SE_SB_DragsType, ");
		buffer.append(" S_SE_SB_PupilHeightOD , S_SE_SB_PupilHeightOS ,S_SE_SB_FavorableAmount,S_SE_SB_WorryType,S_SE_SB_Integral,S_SE_SB_SetMealID,S_SE_SB_ExecStandard,S_SE_SB_SalesRemark,S_SE_SB_SourceSalesID,S_SE_SB_SwapGoodsFlag,S_SE_SB_IntegralPrice) ");
		buffer.append(" select top 1 ");
		buffer.append(" ? , S_SE_SB_ShopCode , S_SE_SB_CustomerID , S_SE_SB_OptID , S_SE_SB_OptometryID , ");
		buffer.append(" S_SE_SB_InspectionID, getdate() , getdate() , ? , ");
		buffer.append(" S_SE_SB_BallGlassOD , S_SE_SB_BallGlassOS , S_SE_SB_PostGlassOD , S_SE_SB_PostGlassOS , ");
		buffer.append(" S_SE_SB_AxesOD , S_SE_SB_AxesOS , S_SE_SB_ADDOD , S_SE_SB_ADDOS , S_SE_SB_ArriseGlassOD1 , ");
		buffer.append(" S_SE_SB_ArriseGlassOS1 , S_SE_SB_BasisOD1 , S_SE_SB_BasisOS1 , S_SE_SB_PrismOD , S_SE_SB_PrismOS , ");
		buffer.append(" S_SE_SB_InterHighOD , S_SE_SB_InterHighOS , S_SE_SB_InterDistanceOD , S_SE_SB_InterDistanceOS , ");
		buffer.append(" S_SE_SB_FarVAOD , S_SE_SB_FarVAOS , S_SE_SB_CloseVAOD , S_SE_SB_CloseVAOS , S_SE_SB_RecipeType , ");
		buffer.append(" S_SE_SB_DignosisRe , S_SE_SB_DiameterOD , S_SE_SB_DiameterOS , S_SE_SB_ConRecipeType , ");
		buffer.append(" S_SE_SB_SecCheckDate , S_SE_SB_SubVisitUnit , S_SE_SB_SalesType , S_SE_SB_SalerID , ");
		buffer.append(" S_SE_SB_Lryid , NULL , NULL , S_SE_SB_PriceSum , S_SE_SB_SalesValue , ");
		buffer.append(" S_SE_SB_EyeCurvatureOD1 , S_SE_SB_EyeCurvatureOD2 , S_SE_SB_EyeCurvatureOS1 , S_SE_SB_EyeCurvatureOS2 , ");
		buffer.append(" S_SE_SB_DiscountRate , S_SE_SB_DiscountNum ,S_SE_SB_Psalsvalue,'0.00', ");
		buffer.append(" S_SE_SB_Location , S_SE_SB_ArrivedDate , '0' , '0' , ");
		buffer.append(" '1' , NULL , '' , '' , ");
		buffer.append(" S_SE_SB_MovementType , NULL , S_SE_SB_ArrearsDate , NULL , ");
		buffer.append(" NULL , NULL , S_SE_SB_Renums , S_SE_SB_DiscountType , S_SE_SB_DiscountPerson , S_SE_SB_DragsType, ");
		buffer.append(" S_SE_SB_PupilHeightOD , S_SE_SB_PupilHeightOS ,S_SE_SB_FavorableAmount,S_SE_SB_WorryType,NULL,S_SE_SB_SetMealID,S_SE_SB_ExecStandard,S_SE_SB_SalesRemark,?,?,NULL ");
		buffer.append(" from S_SE_SalesBasic_Today where S_SE_SB_SalesID=? ");
				
		params.add(Utility.getName(po.getSsesbsalesid()));
		params.add(Utility.getName(po.getSsesborderstype()));
		params.add(Utility.getName(po.getSsesbsourcesalesid()));
		params.add(Utility.getName(po.getSsesbswapgoodsflag()));
		params.add(Utility.getName(po.getSsesbsourcesalesid()));

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增部分退款单明细
	 * 
	 * @param salesDetailPo
	 */
	public void insertPartSalesGoodsWithdrawBillEntry(SalesBasicPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_SE_SalesDetail ");
		buffer.append("(S_SE_SD_ID ");
		buffer.append(",S_SE_SD_SalesID ");
		buffer.append(",S_SE_SD_SalesItemID ");
		buffer.append(",S_SE_SD_ItemID ");
		buffer.append(",S_SE_SD_StockId ");
		buffer.append(",S_SE_SD_SalesItemName ");
		buffer.append(",S_SE_SD_SPrice ");
		buffer.append(",S_SE_SD_Number ");
		buffer.append(",S_SE_SD_UnitPrice ");
		buffer.append(",S_SE_SD_CostsPrive ");
		buffer.append(",S_SE_SD_PriceSum ");
		buffer.append(",S_SE_SD_SalesValue ");
		buffer.append(",S_SE_SD_DiscountRate ");
		buffer.append(",S_SE_SD_DiscountNum ");
		buffer.append(",S_SE_SD_GoodDescribe ");
		buffer.append(",S_SE_SD_GlassFlag ");
		buffer.append(",S_SE_SD_CommoditiesFlag ");
		buffer.append(",S_SE_SD_Updatetime ");
		buffer.append(",S_SE_SD_LargessFlag ");
		buffer.append(",S_SE_SD_Renums ");
		buffer.append(",S_SE_SD_DiscountType ");
		buffer.append(",S_SE_SD_DiscountSource,S_SE_SD_InStockId,S_SE_SD_Favorable,S_SE_SD_Integral,S_SE_SD_OutStorageFlag,S_SE_SD_InStorageFlag,S_SE_SD_Guaranteeperiod,S_SE_SD_Batch,S_SE_SD_WithdrawFlag,S_SE_SD_WithdrawDate,S_SE_SD_WithdrawPersonID ) ");
		buffer.append(" select  ");
		buffer.append("substring(cast(newid() as varchar(50)),1,32) ");
		buffer.append(",? ");
		buffer.append(",S_SE_SD_SalesItemID ");
		buffer.append(",(case substring(S_SE_SD_SalesItemID,1,1) when '3' then '' when '4' then (case isnull(B_GI_isCustomize,'') when 'D' then '' else S_SE_SD_ItemID end) else S_SE_SD_ItemID end)  ");
		buffer.append(",S_SE_SD_StockId ");
		buffer.append(",S_SE_SD_SalesItemName ");
		buffer.append(",S_SE_SD_SPrice ");
		buffer.append(",S_SE_SD_Number ");
		buffer.append(",S_SE_SD_UnitPrice ");
		buffer.append(",S_SE_SD_CostsPrive ");
		buffer.append(",S_SE_SD_PriceSum ");
		buffer.append(",S_SE_SD_SalesValue ");
		buffer.append(",S_SE_SD_DiscountRate ");
		buffer.append(",S_SE_SD_DiscountNum ");
		buffer.append(",S_SE_SD_GoodDescribe ");
		buffer.append(",S_SE_SD_GlassFlag ");
		buffer.append(",S_SE_SD_CommoditiesFlag ");
		buffer.append(",S_SE_SD_Updatetime ");
		buffer.append(",S_SE_SD_LargessFlag ");
		buffer.append(",S_SE_SD_Renums ");
		buffer.append(",S_SE_SD_DiscountType ");
		buffer.append(",S_SE_SD_DiscountSource,NULL,S_SE_SD_Favorable,S_SE_SD_Integral,'0','0',S_SE_SD_Guaranteeperiod,S_SE_SD_Batch,S_SE_SD_WithdrawFlag,S_SE_SD_WithdrawDate,S_SE_SD_WithdrawPersonID ");
		buffer.append("from S_SE_SalesDetail_Today left join B_GoodsInfo on S_SE_SD_SalesItemID = B_GI_GoodsID where S_SE_SD_SalesID=? and isnull(S_SE_SD_WithdrawFlag,'')<>'1' ");

		params.add(Utility.getName(po.getSsesbsalesid()));
		params.add(Utility.getName(po.getSsesbsourcesalesid()));

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * 新增部分退款单附加费用
	 * 
	 * @param salesDetailPo
	 */
	public void insertPartSalesGoodsWithdrawAdditional(SalesBasicPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append("INSERT INTO S_SE_AdditionalCDetail(S_SE_ID,S_SE_SalesID,S_SE_AdditionalID,S_SE_CostsName,S_SE_Amount,S_SE_Number) ");
		buffer.append("	select substring(cast(newid() as varchar(50)),1,32),?,a1,a2,a3,a4 from ( ");
		buffer.append("	  SELECT S_SE_AdditionalID as a1,S_SE_CostsName as a2,S_SE_Amount as a3,S_SE_Number as a4 FROM S_SE_AdditionalCDetail where S_SE_SalesID=? ");
		buffer.append("	)temp ");

		params.add(Utility.getName(po.getSsesbsalesid()));
		params.add(Utility.getName(po.getSsesbsourcesalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增部分退款单加工要求
	 * 
	 * @param salesDetailPo
	 */
	public void insertPartSalesGoodsWithdrawBillSpecialPDetail(SalesBasicPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append("INSERT INTO S_SE_SpecialPDetail(S_SE_SD_ID,S_SE_SD_SalesID,S_SE_SD_Requirement)	 ");
		buffer.append("	select substring(cast(newid() as varchar(50)),1,32),?,a1 from (	 ");
		buffer.append("	  SELECT S_SE_SD_Requirement as a1 FROM S_SE_SpecialPDetail where S_SE_SD_SalesID=?	 ");
		buffer.append("	)temp	 ");

		params.add(Utility.getName(po.getSsesbsalesid()));
		params.add(Utility.getName(po.getSsesbsourcesalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询原配镜单未退款商品的金额
	 * 
	 * @param salesDetailPo
	 */
	public SalesDetailPo getPartSalesGoodsNotWithdrawAmountEntry(SalesBasicPo po){
		 
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select isnull(sum(a1),0) as ssesdpricesum,isnull(sum(a2),0) as ssesdsalesvalue,isnull(sum(a3),0) as ssesddiscountnum,isnull(sum(a4),0) as ssesdrenum from ( ");
		sb.append("select sum(S_SE_SD_PriceSum) as a1,sum(S_SE_SD_SalesValue) as a2,sum(S_SE_SD_DiscountNum) as a3,sum(S_SE_SD_Renums) as a4 from S_SE_SalesDetail where S_SE_SD_SalesID=? ");
		sb.append("union all ");
		sb.append("select sum(S_SE_SD_PriceSum) as a1,sum(S_SE_SD_SalesValue) as a2,sum(S_SE_SD_DiscountNum) as a3,sum(S_SE_SD_Renums) as a4 from S_SE_SalesDetail_Finished where S_SE_SD_SalesID=? ");
		sb.append("union all ");
		sb.append("select isnull(sum(isnull(S_SE_Amount,0)*isnull(S_SE_Number,0)),0) as a1,isnull(sum(isnull(S_SE_Amount,0)*isnull(S_SE_Number,0)),0) as a2,0 as a3,0 as a4 from S_SE_AdditionalCDetail where S_SE_SalesID=? ");
		sb.append(")temp ");
		
		params.add(Utility.getName(po.getSsesbsalesid()));
		params.add(Utility.getName(po.getSsesbsalesid()));
		params.add(Utility.getName(po.getSsesbsourcesalesid()));
		
		return (SalesDetailPo) queryForObject(sb.toString(), params.toArray(), SalesDetailPo.class);
	}
	
	/**
	 * 更新原配镜单各种金额
	 * 
	 * @param salesDetailPo
	 */
	public void updatePartSalesGoodsWithdrawBillAmount(SalesBasicPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append("update top (1) S_SE_SalesBasic_Finished set S_SE_SB_PriceSum=?,S_SE_SB_SalesValue=?,S_SE_SB_Psalsvalue=?,S_SE_SB_Renums=?,S_SE_SB_DiscountNum=?,S_SE_SB_CheckoutFlag=? where S_SE_SB_SalesID=? ");

		buffer.append("update top (1) S_SE_SalesBasic set S_SE_SB_PriceSum=?,S_SE_SB_SalesValue=?,S_SE_SB_Psalsvalue=?,S_SE_SB_Renums=?,S_SE_SB_DiscountNum=?,S_SE_SB_CheckoutFlag=? where S_SE_SB_SalesID=? ");

		params.add(Utility.getName(po.getSsesbpricesum()));
		params.add(Utility.getName(po.getSsesbsalesvalue()));
		params.add(Utility.getName(po.getSsesbpsalsvalue()));
		params.add(Utility.getName(po.getSsesbrenums()));
		params.add(Utility.getName(po.getSsesbdiscountnum()));
		params.add(Utility.getName(po.getSsesbcheckoutflag()));
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		params.add(Utility.getName(po.getSsesbpricesum()));
		params.add(Utility.getName(po.getSsesbsalesvalue()));
		params.add(Utility.getName(po.getSsesbpsalsvalue()));
		params.add(Utility.getName(po.getSsesbrenums()));
		params.add(Utility.getName(po.getSsesbdiscountnum()));
		params.add(Utility.getName(po.getSsesbcheckoutflag()));
		params.add(Utility.getName(po.getSsesbsalesid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新补齐欠款日期
	 */
	public void updateArrearsAppendDate(String salesid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append("update top (1) S_SE_SalesBasic set S_SE_SB_ArrearsAppendDate = dbo.ufn_getDayCheckOut(),S_SE_SB_FactArrearsAppendDate = getdate() where S_SE_SB_SalesID=? ");
		buffer.append("update top (1) S_SE_SalesBasic_Today set S_SE_SB_ArrearsAppendDate = dbo.ufn_getDayCheckOut(),S_SE_SB_FactArrearsAppendDate = getdate() where S_SE_SB_SalesID=? ");
		buffer.append("update top (1) S_SE_SalesBasic_Finished set S_SE_SB_ArrearsAppendDate = dbo.ufn_getDayCheckOut(),S_SE_SB_FactArrearsAppendDate = getdate() where S_SE_SB_SalesID=? ");
		
		params.add(Utility.getName(salesid));
		params.add(Utility.getName(salesid));
		params.add(Utility.getName(salesid));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public List<SalesLogPo> getSalesLogList(SalesLogPo salesLogPo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select S_SE_SL_SalesID as sseslsalesid, ");
		buffer.append("S_SE_SL_ShopCode as sseslshopcode, ");
		buffer.append("S_SE_SL_Type as ssesltype, ");
		buffer.append("isnull(sum(CAST(S_SE_SL_IntegralPrice AS DECIMAL(18, 2))),0.00) as sseslintegralprice, ");
		buffer.append("isnull(sum(CAST(S_SE_SL_Price AS DECIMAL(18, 2))),0.00) as sseslprice, ");
		buffer.append("S_SE_SL_SourceID as sseslsourceid, ");
		buffer.append("isnull(sum(CAST(C_ST_CZK_Jine AS DECIMAL(18, 2))),0.00)+isnull(sum(CAST(S_SE_SL_Price AS DECIMAL(18, 2))),0.00) as czkye ");
		buffer.append("from S_SE_SalesLog ");
		buffer.append("left join C_ST_Chuzhika on S_SE_SL_SourceID=C_ST_CZK_ID ");
		buffer.append("where S_SE_SL_SalesID=? ");
		buffer.append("and S_SE_SL_ConsumptionID=? ");
		buffer.append("and (S_SE_SL_PaymentType='1' or S_SE_SL_PaymentType='2' or S_SE_SL_PaymentType='3') ");
		buffer.append("group by S_SE_SL_SalesID, ");
		buffer.append("S_SE_SL_ShopCode, ");
		buffer.append("S_SE_SL_Type, ");
		buffer.append("S_SE_SL_SourceID ");
		
		params.add(Utility.getName(salesLogPo.getSseslsalesid()));
		params.add(Utility.getName(salesLogPo.getSseslconsumptionid()));
		
		
		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesLogPo.class);
	}
	
	
	public IntegralAddandSubPo getIntegralAddandSub(
			IntegralAddandSubPo integralAddandSubPo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select t.smeassalesbill,");
		sb.append("isnull(t.S_ME_AS_CIntegral,0.00) as smeasyintegral, ");
		sb.append("isnull(t1.S_SE_SL_Price,0.00) as smeasxintegral, ");
		sb.append("isnull(t.S_ME_AS_CIntegral,0.00)+isnull(t1.S_SE_SL_Price,0.00) as smeascintegral ");
		sb.append("from(select S_ME_AS_SalesBillID as smeassalesbill, ");
		sb.append("sum(cast(S_ME_AS_CIntegral as float)) as S_ME_AS_CIntegral ");
		sb.append("from S_ME_IntegralAddandSub ");
		sb.append("where S_ME_AS_SalesBillID=? ");
		params.add(Utility.getName(integralAddandSubPo.getSmeassalesbill()));
		sb.append("and S_ME_AS_CustomerID = ? ");
		params.add(Utility.getName(integralAddandSubPo.getSmeascustomerid()));
		sb.append("and s_me_as_addorsub<>'4' ");
		sb.append("group by S_ME_AS_SalesBillID ");
		sb.append(")t left join( ");
		sb.append("select S_SE_SL_SalesID as smeassalesbill, ");
		sb.append("sum(cast(S_SE_SL_Price as float)) as S_SE_SL_Price ");
		sb.append("from S_SE_SalesLog ");
		sb.append("where S_SE_SL_SalesID=? ");
		sb.append("and S_SE_SL_ConsumptionID='2' ");
		sb.append("and (s_se_sl_paymenttype='1' or s_se_sl_paymenttype='2' or s_se_sl_paymenttype='3') ");
		sb.append("group by S_SE_SL_SalesID ");
		sb.append(")t1 on t.smeassalesbill=t1.smeassalesbill ");
		
		params.add(Utility.getName(integralAddandSubPo.getSmeassalesbill()));
		
		return (IntegralAddandSubPo) queryForObject(sb.toString(), params.toArray(), IntegralAddandSubPo.class);
	}
	
}

