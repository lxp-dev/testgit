package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.dao.SalesReturnDao;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SalesReturnDaoImpl extends BaseJdbcDaoSupport implements SalesReturnDao{
	/*
	 * 退款新增
	 */
	public void insertSalesReturn(SalesBasicPo salesBasicPo){
		
		StringBuffer sb =new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO S_SE_SalesBasic_Finished ");
		sb.append("            (S_SE_SB_SalesID, ");
		sb.append("             S_SE_SB_SalesDatetime, ");
		sb.append("             S_SE_SB_SalerID, ");
		sb.append("             S_SE_SB_SalesValue, ");
		sb.append("             S_SE_SB_PriceSum, ");
		sb.append("             S_SE_SB_InTransit, ");
		sb.append("             S_SE_SB_WithdrawDate, ");
		sb.append("             S_SE_SB_FactWithdrawDate, ");
		sb.append("             S_SE_SB_WithdrawFlag, ");
		sb.append("             S_SE_SB_WithdrawPersonID,S_SE_SB_ShopCode,S_SE_SB_CustomerID,S_SE_SB_OptID,S_SE_SB_OptometryID,S_SE_SB_OrdersType,S_SE_SB_Location,S_SE_SB_DiscountRate,S_SE_SB_DiscountNum,S_SE_SB_RecipeType,S_SE_SB_SalesType,S_SE_SB_Lryid,S_SE_SB_Psalsvalue,S_SE_SB_ArrearsValue,S_SE_SB_ValueFlag,S_SE_SB_CheckoutFlag,S_SE_SB_PayCash,S_SE_SB_SalesRemark,S_SE_SB_SwapGoodsFlag ) ");
		sb.append("VALUES     ( ?, ");
		sb.append("             Getdate(), ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             14, ");
		sb.append("             dbo.ufn_getDayCheckOut(), ");
		sb.append("             Getdate(), ");
		sb.append("             1, ");
		sb.append("             ? ,?,?,' ',' ',?,?,1,0,?,?,?,?,?,?,?,?,?,'4' ) ");		
		
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalerid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesvalue()));
		params.add(Utility.getName(salesBasicPo.getSsesbpricesum()));
		params.add(Utility.getName(salesBasicPo.getSsesbwithdrawpersonid()));
		params.add(Utility.getName(salesBasicPo.getSsesbshopcode()));
		params.add(Utility.getName(salesBasicPo.getSsesbcustomerid()));
		params.add(Utility.getName(salesBasicPo.getSsesborderstype()));
		params.add(Utility.getName(salesBasicPo.getSsesblocation()));		
		params.add(Utility.getName(salesBasicPo.getSsesbrecipetype()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalestype()));
		params.add(Utility.getName(salesBasicPo.getSsesblryid()));
		params.add(Utility.getName(salesBasicPo.getSsesbpsalsvalue()));
		params.add(Utility.getName(salesBasicPo.getSsesbarrearsvalue()));		
		params.add(Utility.getName(salesBasicPo.getSsesbvalueflag()));
		params.add(Utility.getName(salesBasicPo.getSsesbcheckoutflag()));
		params.add(Utility.getName(salesBasicPo.getSsesbpaycash()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesremark()));
		
		this.getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/*
	 * 当天退款新增
	 */
	public void insertSalesReturnToday(SalesBasicPo salesBasicPo){
		
		StringBuffer sb =new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO S_SE_SalesBasic_Today ");
		sb.append("            (S_SE_SB_SalesID, ");
		sb.append("             S_SE_SB_SalesDatetime, ");
		sb.append("             S_SE_SB_SalerID, ");
		sb.append("             S_SE_SB_SalesValue, ");
		sb.append("             S_SE_SB_PriceSum, ");
		sb.append("             S_SE_SB_InTransit, ");
		sb.append("             S_SE_SB_WithdrawDate, ");
		sb.append("             S_SE_SB_FactWithdrawDate, ");
		sb.append("             S_SE_SB_WithdrawFlag, ");
		sb.append("             S_SE_SB_WithdrawPersonID,S_SE_SB_ShopCode,S_SE_SB_CustomerID,S_SE_SB_OptID,S_SE_SB_OptometryID,S_SE_SB_OrdersType,S_SE_SB_Location,S_SE_SB_DiscountRate,S_SE_SB_DiscountNum,S_SE_SB_RecipeType,S_SE_SB_SalesType,S_SE_SB_Lryid,S_SE_SB_Psalsvalue,S_SE_SB_ArrearsValue,S_SE_SB_ValueFlag,S_SE_SB_CheckoutFlag,S_SE_SB_PayCash,S_SE_SB_SalesRemark,S_SE_SB_SwapGoodsFlag ) ");
		sb.append("VALUES     ( ?, ");
		sb.append("             Getdate(), ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             14, ");
		sb.append("             dbo.ufn_getDayCheckOut(), ");
		sb.append("             Getdate(), ");
		sb.append("             1, ");
		sb.append("             ? ,?,?,' ',' ',?,?,1,0,?,?,?,?,?,?,?,?,?,'4' ) ");		
		
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalerid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesvalue()));
		params.add(Utility.getName(salesBasicPo.getSsesbpricesum()));
		params.add(Utility.getName(salesBasicPo.getSsesbwithdrawpersonid()));
		params.add(Utility.getName(salesBasicPo.getSsesbshopcode()));
		params.add(Utility.getName(salesBasicPo.getSsesbcustomerid()));
		params.add(Utility.getName(salesBasicPo.getSsesborderstype()));
		params.add(Utility.getName(salesBasicPo.getSsesblocation()));		
		params.add(Utility.getName(salesBasicPo.getSsesbrecipetype()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalestype()));
		params.add(Utility.getName(salesBasicPo.getSsesblryid()));
		params.add(Utility.getName(salesBasicPo.getSsesbpsalsvalue()));
		params.add(Utility.getName(salesBasicPo.getSsesbarrearsvalue()));		
		params.add(Utility.getName(salesBasicPo.getSsesbvalueflag()));
		params.add(Utility.getName(salesBasicPo.getSsesbcheckoutflag()));
		params.add(Utility.getName(salesBasicPo.getSsesbpaycash()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesremark()));
		
		this.getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	/**
	 * 退款单详细新增
	 */
	public void insertSalesReturnDetail(SalesDetailPo salesDetailPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_SE_SalesDetail_Finished ");
		buffer.append("            (S_SE_SD_ID, ");
		buffer.append("             S_SE_SD_SalesID, ");
		buffer.append("             S_SE_SD_SalesItemID, ");
		buffer.append("             S_SE_SD_ItemID, ");
		buffer.append("             S_SE_SD_InStockId, ");
		buffer.append("             S_SE_SD_SalesItemName, ");
		buffer.append("             S_SE_SD_Sprice, ");
		buffer.append("             S_SE_SD_Number, ");
		buffer.append("             S_SE_SD_UnitPrice, ");
		buffer.append("             S_SE_SD_CostsPrive, ");
		buffer.append("             S_SE_SD_PriceSum, ");
		buffer.append("             S_SE_SD_SalesValue, ");
		buffer.append("             S_SE_SD_DiscountRate, ");
		buffer.append("             S_SE_SD_DiscountNum, ");
		buffer.append("             S_SE_SD_CommoditiesFlag, ");
		buffer.append("             S_SE_SD_Updatetime, ");
		buffer.append("             S_SE_SD_Guaranteeperiod, ");
		buffer.append("             S_SE_SD_Batch, ");
		buffer.append("             S_SE_SD_StockId,S_SE_SD_OutStorageFlag,S_SE_SD_InStorageFlag,S_SE_SD_GoodDescribe,S_SE_SD_GlassFlag) ");
		buffer.append("VALUES     ( ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             1, ");
		buffer.append("             0, ");
		buffer.append("             ?, ");
		buffer.append("             Getdate(), ");
		params.add(this.uuid.generate());
		params.add(Utility.getName(salesDetailPo.getSsesdsalesid()));
		params.add(Utility.getName(salesDetailPo.getSsesdsalesitemid()));
		params.add(Utility.getName(salesDetailPo.getSsesditemid()));
		params.add(Utility.getName(salesDetailPo.getSsesdinstockid()));
		params.add(Utility.getName(salesDetailPo.getSsesdsalesitemname()));
		params.add(Utility.getName(salesDetailPo.getSsesdsprice()));
		params.add(Utility.getName(salesDetailPo.getSsesdnumber()));
		params.add(Utility.getName(salesDetailPo.getSsesdunitprice()));
		params.add(Utility.getName(salesDetailPo.getSsesdcostsprive()));
		params.add(Utility.getName(salesDetailPo.getSsesdpricesum()));
		params.add(Utility.getName(salesDetailPo.getSsesdsalesvalue()));
		params.add(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()));
		if(!"".equals(Utility.getName(salesDetailPo.getSsesdguaranteeperiod()))&&!"".equals(Utility.getName(salesDetailPo.getSsesdbatch()))){
			if(Utility.getName(salesDetailPo.getFspstealtheffective()).equals("2") || Utility.getName(salesDetailPo.getFspstealtheffective()).equals("1")){
				buffer.append("             ?, ");
				buffer.append("             ?, ");
				params.add(salesDetailPo.getSsesdguaranteeperiod());
				params.add(salesDetailPo.getSsesdbatch());
			}else{
				buffer.append("             NULL, ");
				buffer.append("             NULL, ");
			}
		}else{
			buffer.append("             NULL, ");
			buffer.append("             NULL, ");
		}
		buffer.append("             '',1,1,?,?) ");

		
		params.add(Utility.getName(salesDetailPo.getSsesdgooddescribe()));
		params.add(Utility.getName(salesDetailPo.getSsesdglassflag()));
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 当天退款单详细新增
	 */
	public void insertSalesReturnDetailToday(SalesDetailPo salesDetailPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_SE_SalesDetail_Today ");
		buffer.append("            (S_SE_SD_ID, ");
		buffer.append("             S_SE_SD_SalesID, ");
		buffer.append("             S_SE_SD_SalesItemID, ");
		buffer.append("             S_SE_SD_ItemID, ");
		buffer.append("             S_SE_SD_InStockId, ");
		buffer.append("             S_SE_SD_SalesItemName, ");
		buffer.append("             S_SE_SD_Sprice, ");
		buffer.append("             S_SE_SD_Number, ");
		buffer.append("             S_SE_SD_UnitPrice, ");
		buffer.append("             S_SE_SD_CostsPrive, ");
		buffer.append("             S_SE_SD_PriceSum, ");
		buffer.append("             S_SE_SD_SalesValue, ");
		buffer.append("             S_SE_SD_DiscountRate, ");
		buffer.append("             S_SE_SD_DiscountNum, ");
		buffer.append("             S_SE_SD_CommoditiesFlag, ");
		buffer.append("             S_SE_SD_Updatetime, ");
		buffer.append("             S_SE_SD_Guaranteeperiod, ");
		buffer.append("             S_SE_SD_Batch, ");
		buffer.append("             S_SE_SD_StockId,S_SE_SD_OutStorageFlag,S_SE_SD_InStorageFlag,S_SE_SD_GoodDescribe,S_SE_SD_GlassFlag) ");
		
		buffer.append("VALUES     ( ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             1, ");
		buffer.append("             0, ");
		buffer.append("             ?, ");
		buffer.append("             Getdate(), ");
		params.add(this.uuid.generate());
		params.add(Utility.getName(salesDetailPo.getSsesdsalesid()));
		params.add(Utility.getName(salesDetailPo.getSsesdsalesitemid()));
		params.add(Utility.getName(salesDetailPo.getSsesditemid()));
		params.add(Utility.getName(salesDetailPo.getSsesdinstockid()));
		params.add(Utility.getName(salesDetailPo.getSsesdsalesitemname()));
		params.add(Utility.getName(salesDetailPo.getSsesdsprice()));
		params.add(Utility.getName(salesDetailPo.getSsesdnumber()));
		params.add(Utility.getName(salesDetailPo.getSsesdunitprice()));
		params.add(Utility.getName(salesDetailPo.getSsesdcostsprive()));
		params.add(Utility.getName(salesDetailPo.getSsesdpricesum()));
		params.add(Utility.getName(salesDetailPo.getSsesdsalesvalue()));
		params.add(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()));
		if(!"".equals(Utility.getName(salesDetailPo.getSsesdguaranteeperiod()))&&!"".equals(Utility.getName(salesDetailPo.getSsesdbatch()))){
			if(Utility.getName(salesDetailPo.getFspstealtheffective()).equals("2") || Utility.getName(salesDetailPo.getFspstealtheffective()).equals("1")){
				buffer.append("             ?, ");
				buffer.append("             ?, ");
				params.add(salesDetailPo.getSsesdguaranteeperiod());
				params.add(salesDetailPo.getSsesdbatch());
			}else{
				buffer.append("             NULL, ");
				buffer.append("             NULL, ");
			}
		}else{
			buffer.append("             NULL, ");
			buffer.append("             NULL, ");
		}
		buffer.append("             '',1,1,?,?) ");

		
		params.add(Utility.getName(salesDetailPo.getSsesdgooddescribe()));
		params.add(Utility.getName(salesDetailPo.getSsesdglassflag()));
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public SalesDetailPo getGoodsIsCustomize(String goodsId){
		StringBuffer  sb = new StringBuffer();
		sb.append("SELECT isnull(B_GI_isCustomize,'') as ssesdiscustomize");
		sb.append("FROM   B_GoodsInfo ");
		sb.append("WHERE  B_GI_GoodsID = ? ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(goodsId));
		return (SalesDetailPo) queryForObject(sb.toString(), params.toArray(), SalesDetailPo.class);
	}
	
	public SalesBasicPo getCustomerId(String cid){
		StringBuffer  sb = new StringBuffer();
		sb.append("SELECT S_ME_CI_CustomerID as ssesbcustomerid ");
		sb.append("FROM   S_ME_CustomerInfo ");
		sb.append("WHERE  S_ME_CI_MemberId = ? ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(cid));
		return (SalesBasicPo) queryForObject(sb.toString(), params.toArray(), SalesBasicPo.class);
	}
	
	/**
	 * 退款流水新增
	 */
	public void insertSalesLog(SalesBasicPo salesBasicPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("INSERT INTO S_SE_SalesLog ");
		buffer.append("            (S_SE_SL_UUID, ");
		buffer.append("             S_SE_SL_SalesID, ");
		buffer.append("             S_SE_SL_PaymentType, ");
		buffer.append("             S_SE_SL_ConsumptionID, ");
		buffer.append("             S_SE_SL_Price, ");
		buffer.append("             S_SE_SL_DateTime, ");
		buffer.append("             S_SE_SL_Person, ");
		buffer.append("             S_SE_SL_ShopCode, ");
		buffer.append("             S_SE_SL_Type) ");
		buffer.append("VALUES     ( ?, ");
		buffer.append("             ?, ");
		buffer.append("             5, ");
		buffer.append("             1, ");
		buffer.append("             ?, ");
		buffer.append("             Getdate(), ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             '1' ) ");
		params.add(this.uuid.generate());
		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		params.add(Utility.getName(salesBasicPo.getSsesbsalesvalue()));
		params.add(Utility.getName(salesBasicPo.getSsesbwithdrawpersonid()));
		params.add(Utility.getName(salesBasicPo.getSsesbshopcode()));
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 退款商品库存插入change表
	 */
	public void insertStrogeChanges(SalesBasicPo salesBasicPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("INSERT INTO C_SH_StorageChange ");
		buffer.append("            (C_SH_SC_UUID, ");
		buffer.append("             C_SH_SC_GoodsBarCode, ");
		buffer.append("             C_SH_SC_GoodsId, ");
		buffer.append("             C_SH_SC_StockId, ");
		buffer.append("             C_SH_SC_GoodsQuantity, ");
		buffer.append("             C_SH_SC_CostPrice, ");
		buffer.append("             C_SH_SC_NotTaxRate, ");
		buffer.append("             C_SH_SC_WarehousingDate, ");
		buffer.append("             C_SH_SC_ChangeID) ");
		buffer.append("SELECT replace(Newid(),'-',''), ");
		buffer.append("       replace(S_SE_SD_SalesItemID,'.',''), ");
		buffer.append("       S_SE_SD_SalesItemID, ");
		
		if (Utility.getName(salesBasicPo.getSsesbshopcodewarehouseid()).equals("")){
			buffer.append("       S_SE_SD_InStockId, ");
		}else{
			buffer.append("       ?, ");
		}

		buffer.append("       S_SE_SD_Number, ");
		buffer.append("       S_SE_SD_CostsPrive, ");
		buffer.append("       S_SE_SD_UnitPrice, ");
		buffer.append("       Getdate(), ");
		buffer.append("       S_SE_SD_SalesID ");
		buffer.append("FROM   S_SE_SalesDetail_Finished ");
		buffer.append("WHERE  S_SE_SD_SalesID = ? and isnull(S_SE_SD_ItemID,'')<>'' ");
		
		if (!Utility.getName(salesBasicPo.getSsesbshopcodewarehouseid()).equals("")){
			params.add(Utility.getName(salesBasicPo.getSsesbshopcodewarehouseid()));
		}

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 退款商品库存插入log表
	 */
	public void insertStrogeLog(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO C_SH_StorageLog ");
		buffer.append("            (C_SH_SL_UUID, ");
		buffer.append("             C_SH_SL_GoodsBarCode, ");
		buffer.append("             C_SH_SL_GoodsId, ");
		buffer.append("             C_SH_SL_StockId, ");
		buffer.append("             C_SH_SL_GoodsQuantity, ");
		buffer.append("             C_SH_SL_CostPrice, ");
		buffer.append("             C_SH_SL_NotTaxRate, ");
		buffer.append("             C_SH_SL_WarehousingDate, ");
		buffer.append("             C_SH_SL_ChangeID, ");
		buffer.append("             C_SH_SL_GuaranteePeriod, ");
		buffer.append("             C_SH_SL_Batch,C_SH_SL_Flag) ");
		buffer.append("SELECT REPLACE(Newid(), '-', ''), ");
		buffer.append("       S_SE_SD_ItemID, ");
		buffer.append("       S_SE_SD_SalesItemID, ");
		if (Utility.getName(salesBasicPo.getSsesbshopcodewarehouseid()).equals("")){
			buffer.append("       S_SE_SD_InStockId, ");
		}else{
			buffer.append("       ?, ");
		}
		buffer.append("       S_SE_SD_Number, ");
		buffer.append("       S_SE_SD_CostsPrive, ");
		buffer.append("       S_SE_SD_UnitPrice, ");
		buffer.append("       Getdate(), ");
		buffer.append("       S_SE_SD_SalesID, ");
		buffer.append("       S_SE_SD_Guaranteeperiod, ");
		buffer.append("       S_SE_SD_Batch,'1' ");
		buffer.append("FROM   S_SE_SalesDetail_Finished ");
		buffer.append("WHERE  S_SE_SD_SalesID = ? and isnull(S_SE_SD_ItemID,'')<>'' ");
		
		if (!Utility.getName(salesBasicPo.getSsesbshopcodewarehouseid()).equals("")){
			params.add(Utility.getName(salesBasicPo.getSsesbshopcodewarehouseid()));
		}

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	public List<StrogeChangePo> selectStrogeLogTemp(SalesBasicPo salesBasicPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("SELECT REPLACE(Newid(), '-', '') as cshscuuid, ");
		buffer.append("       S_SE_SD_ItemID as cshscgoodsbarcode, ");
		buffer.append("       S_SE_SD_SalesItemID as cshscgoodsid, ");
		if (Utility.getName(salesBasicPo.getSsesbshopcodewarehouseid()).equals("")){
			buffer.append("       S_SE_SD_InStockId as cshscstockid, ");
		}else{
			buffer.append("       ? as cshscstockid, ");
		}

		buffer.append("       S_SE_SD_Number as cshscgoodsquantity, ");
		buffer.append("       S_SE_SD_CostsPrive as cshsccostprice, ");
		buffer.append("       S_SE_SD_UnitPrice as cshscnottaxrate, ");
		buffer.append("       Getdate() as cshscwarehousingdate, ");
		buffer.append("       S_SE_SD_SalesID as cshscchangeid, ");
		buffer.append("       S_SE_SD_Guaranteeperiod as cshscguaranteeperiod, ");
		buffer.append("       S_SE_SD_Batch as cshscBatch ");
		buffer.append("FROM   S_SE_SalesDetail_Finished ");
		buffer.append("WHERE  S_SE_SD_SalesID = ? and isnull(S_SE_SD_ItemID,'')<>'' ");

		if (!Utility.getName(salesBasicPo.getSsesbshopcodewarehouseid()).equals("")){
			params.add(Utility.getName(salesBasicPo.getSsesbshopcodewarehouseid()));
		}

		params.add(Utility.getName(salesBasicPo.getSsesbsalesid()));

		return queryForObjectList(buffer.toString(), params.toArray(), StrogeChangePo.class);
	}
}
