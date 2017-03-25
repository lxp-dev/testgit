package com.pengsheng.eims.quartz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.quartz.dao.StockSummaryDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

/**
 * @author Liuqian
 * 
 */
public class StockSummaryDaoImpl extends BaseJdbcDaoSupport implements
		StockSummaryDao {

	/**
	 * 清除商品库存当月期初表
	 */
	public void strogeBeginningClear() {

		StringBuffer sb = new StringBuffer();

		sb.append("delete from C_SH_StorageBeginning ");
		List<String> params = new ArrayList<String>();

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	/**
	 * 清除商品库存当月库存变更表
	 */
	public void strogeChangeClear() {
		StringBuffer sb = new StringBuffer();

		sb.append("delete from C_SH_StorageChange ");
		List<String> params = new ArrayList<String>();

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void strogeChangeFlySheetClear(){
		StringBuffer sb = new StringBuffer();

		sb.append("delete from C_SH_StorageChange_FlySheet ");
		List<String> params = new ArrayList<String>();

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 当月库存汇总
	 */
	public void strogeBeginningSummary() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into C_SH_StorageBeginning (C_SH_SB_UUID,C_SH_SB_GoodsBarCode,C_SH_SB_GoodsId,C_SH_SB_StockId,C_SH_SB_GoodsQuantity) ");
		buffer.append("SELECT replace(NEWID(),'-',''),replace(C_SH_SL_GoodsId, '.', ''), C_SH_SL_GoodsId, ");
		buffer.append("C_SH_SL_StockId, SUM(C_SH_SL_GoodsQuantity) ");
		buffer.append("AS Expr1 FROM C_SH_StorageLog ");
		buffer.append("GROUP BY C_SH_SL_GoodsId, ");
		buffer.append("C_SH_SL_StockId");

		List<String> params = new ArrayList<String>();

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	/**
	 * 商品库存各月期初记录表汇总
	 */
	public void strogeBeginningRecordSummary() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into C_SH_StorageBeginningRecord ");
		buffer.append("select replace(NEWID(),'-',''),C_SH_SB_GoodsBarCode,C_SH_SB_GoodsId, ");
		buffer.append("C_SH_SB_StockId,C_SH_SB_GoodsQuantity,convert(varchar(6), DATEADD (M, 1, getdate()), 112)  ");
		buffer.append("from C_SH_StorageBeginning ");

		List<String> params = new ArrayList<String>();

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 物流系统汇总销售出库单(专汇总只有附加费的销售单)
	 */
	public void insertSalesOutBill(String billID,String billDate,String shopCode){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into C_ST_Inventory(C_ST_I_BillID,C_ST_I_BillTypeId,C_ST_I_billDate,C_ST_I_GoodsCategory, ");
		buffer.append("C_ST_I_DepartmentId,C_ST_I_SupplierId,C_ST_I_createPerson,C_ST_I_AuditPerson,C_ST_I_AuditState,C_ST_I_FinanceAuditState,C_ST_I_AuditDate, ");
		buffer.append("C_ST_I_Remark,C_ST_I_InvoiceState,C_ST_I_PaymentDay) ");
		buffer.append("  values(?,'3',?,'20',?,?,'yyb001','yyb001','1','1',?,'汇总附加费','0',?) ");
		
		params.add(billID);
		params.add(billDate);
		params.add(shopCode);
		params.add(shopCode);
		params.add(billDate);
		params.add(billDate);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 物流系统汇总销售出库单(专汇总只有附加费的销售单)
	 */
	public void insertSalesOutBillEntry(String billID,String billDate,String shopCode){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into C_ST_InventoryEntry( ");
		buffer.append("C_ST_IE_ID,C_ST_IE_BillID,C_ST_IE_GoodsId,C_ST_IE_GoodsQuantity,C_ST_IE_NotTaxRate,C_ST_IE_NotTaxRateAmount, ");
		buffer.append("C_ST_IE_TaxRate,C_ST_IE_CostPrice,C_ST_IE_TaxAmount,C_ST_IE_CostPriceAmount,C_ST_IE_InStockId,C_ST_IE_OutStockId, ");
		buffer.append("C_ST_IE_BarCode,C_ST_IE_WarehousingDate,C_ST_IE_Remark,C_ST_IE_InvoiceState,C_ST_IE_checkquantity,C_ST_IE_GuaranteePeriod,C_ST_IE_Batch ");
		buffer.append(") ");
		buffer.append("select substring(cast(newid() as varchar(50)),1,32),?,'附加费用',0,0,0,0,0,0,isnull(sum(S_SE_Amount),0),NULL,NULL,'',NULL,NULL,0,0,NULL,NULL from ( ");
		buffer.append("select sum(S_SE_Amount*Isnull(S_SE_Number, 0)) as S_SE_Amount ");
		buffer.append("  from uview_SalesBasic inner join S_SE_AdditionalCDetail on S_SE_SB_SalesID=S_SE_SalesID ");
		buffer.append("  where S_SE_SB_SalesID not in (select distinct S_SE_SD_SalesID from uview_SalesDetail)  ");
		buffer.append("   and convert(varchar(7),S_SE_SB_PosDatetime,120)=substring(?,1,7) and S_SE_SB_ValueFlag='1' and S_SE_SB_ShopCode=? ");
		buffer.append("union all ");
		buffer.append("select -sum(S_SE_Amount*Isnull(S_SE_Number, 0)) as S_SE_Amount ");
		buffer.append("  from uview_SalesBasic inner join S_SE_AdditionalCDetail on S_SE_SB_SalesID=S_SE_SalesID ");
		buffer.append("  where S_SE_SB_SalesID not in (select distinct S_SE_SD_SalesID from uview_SalesDetail) and S_SE_SB_ShopCode=?  ");
		buffer.append("   and convert(varchar(7),S_SE_SB_WithdrawDate,120)=substring(?,1,7) and S_SE_SB_ValueFlag='1' and S_SE_SB_WithdrawFlag='1' ");
		buffer.append(")temp ");
		
		params.add(billID);
		params.add(billDate);
		params.add(shopCode);		
		params.add(shopCode);
		params.add(billDate);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除定时任务日志
	 */
	public void deleteQuartzLog(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(" delete from Sys_QE_LR_QuartzLog where Sys_QE_LR_Date < convert(varchar(10),dateadd(MONTH,-1,getdate()),120)  ");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
}
