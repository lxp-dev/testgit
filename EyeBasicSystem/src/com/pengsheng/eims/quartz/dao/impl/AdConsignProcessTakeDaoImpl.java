package com.pengsheng.eims.quartz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.quartz.dao.AdConsignProcessTakeDao;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class AdConsignProcessTakeDaoImpl extends BaseJdbcDaoSupport implements
		AdConsignProcessTakeDao {

	/**
	 * 寰楀埌涓氬姟涓存椂琛ㄤ腑渚涘簲鍟唅d
	 * 
	 * @return
	 */
	public List<InventoryPo> getSupplierid() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
													
		buffer.append("select B_DP_CompanysID as csticompanyid,C_ST_IT_SupplierId as cstisupplierid,isnull(C_ST_IT_SubSupplierId,'') as cstisubsupplierid ");
		buffer.append("from C_ST_InventoryTemp left join B_Warehouse on C_ST_IT_InStockId = B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("where C_ST_IT_flag = '0' ");
		buffer.append("group by B_DP_CompanysID,C_ST_IT_SupplierId,C_ST_IT_SubSupplierId ");

		return queryForObjectList(buffer.toString(), params.toArray(),InventoryPo.class);
	}

	/**
	 * 寰楀埌瀵瑰簲渚涘簲鍟嗙殑鏀惰揣鍗昳d
	 * 
	 * @param supplier
	 * @return
	 */
	public InventoryPo getbillid(String subsupplier,String supplier,String companyID) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 C_ST_IT_BillID as cstibillid ");
		buffer.append("from C_ST_InventoryTemp left join B_Warehouse on C_ST_IT_InStockId = B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("where C_ST_IT_SupplierId = ? and B_DP_CompanysID = ? and C_ST_IT_SubSupplierId = ? ");
		buffer.append("and C_ST_IT_flag = '0' ");

		params.add(supplier);
		params.add(companyID);
		params.add(subsupplier);

		return (InventoryPo) queryForObject(buffer.toString(),params.toArray(), InventoryPo.class);
	}

	/**
	 * 鏇存柊涓存椂琛ㄦ眹鎬绘爣璇嗗瓧娈�
	 * 
	 * @param supplier
	 */
	public void updateInventoryTemp(String subsupplier,String supplier,String companyID) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("update C_ST_InventoryTemp set C_ST_IT_flag = '1' ");
		buffer.append(" from C_ST_InventoryTemp left join B_Warehouse on C_ST_IT_InStockId = B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("where C_ST_IT_SupplierId = ? and C_ST_IT_flag = '0' and B_DP_CompanysID = ? and C_ST_IT_SubSupplierId = ? ");

		params.add(supplier);
		params.add(companyID);
		params.add(subsupplier);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 鎻掑叆涓氬姟涓昏〃涓�
	 * 
	 * @param billis
	 */
	public void insertInventory(String producedid, String billid) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into C_ST_Inventory(C_ST_I_BillID,C_ST_I_BillTypeId,C_ST_I_SourceBillId,C_ST_I_DeliveryID,C_ST_I_billDate,C_ST_I_GoodsCategory, ");
		buffer.append("C_ST_I_InStockId,C_ST_I_OutStockId,C_ST_I_SupplierId,C_ST_I_PurchseWayId,C_ST_I_DayLimit,C_ST_I_DepartmentId,C_ST_I_createPerson, ");
		buffer.append("C_ST_I_AuditPerson,C_ST_I_AuditState,C_ST_I_AuditDate,C_ST_I_FinanceAuditPerson,C_ST_I_FinanceAuditState,C_ST_I_FinanceAuditDate,C_ST_I_Remark,C_ST_I_InvoiceState,C_ST_I_VoucherType,C_ST_I_VoucherDate,C_ST_I_AllocationStatus,C_ST_I_SubSupplierId) ");
		
		buffer.append("select  ? , ");
		buffer.append("C_ST_IT_BillTypeId , ");
		buffer.append("'', ");
		buffer.append("C_ST_IT_DeliveryID, ");
		buffer.append("getdate() , ");
		buffer.append("C_ST_IT_GoodsCategory , ");
		buffer.append("C_ST_IT_InStockId , ");
		buffer.append("C_ST_IT_OutStockId , ");
		buffer.append("C_ST_IT_SupplierId , ");
		buffer.append("C_ST_IT_PurchseWayId , ");
		buffer.append("C_ST_IT_DayLimit , ");
		buffer.append("C_ST_IT_DepartmentId , ");
		buffer.append("C_ST_IT_createPerson , ");
		buffer.append("C_ST_IT_AuditPerson , ");
		buffer.append("C_ST_IT_AuditState , ");
		buffer.append("getdate() , ");
		buffer.append("C_ST_IT_FinanceAuditPerson , ");
		buffer.append("C_ST_IT_FinanceAuditState , ");
		buffer.append("C_ST_IT_FinanceAuditDate , ");
		buffer.append("C_ST_IT_Remark , ");
		buffer.append("'0' , ");
		buffer.append("'' , ");
		buffer.append("'' ,'', ");
		buffer.append("C_ST_IT_SubSupplierId ");
		buffer.append("from C_ST_InventoryTemp ");
		buffer.append("where C_ST_IT_BillID = ? ");

		params.add(producedid);
		params.add(billid);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 鏂板涓氬姟鏄庣粏琛�
	 * 
	 * @param supplierid
	 */
	public void insertInventoryEntry(String subsupplier,String producedid, String supplierid,String companyID) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into C_ST_InventoryEntry (");
		buffer.append("	C_ST_IE_ID	,");
		buffer.append("	C_ST_IE_BillID	,");
		buffer.append("	C_ST_IE_GoodsId	,");
		buffer.append("	C_ST_IE_GoodsQuantity	,");
		buffer.append("	C_ST_IE_NotTaxRate	,");
		buffer.append("	C_ST_IE_NotTaxRateAmount	,");
		buffer.append("	C_ST_IE_TaxRate	,");
		buffer.append("	C_ST_IE_CostPrice	,");
		buffer.append("	C_ST_IE_TaxAmount	,");
		buffer.append("	C_ST_IE_CostPriceAmount	,");
		buffer.append("	C_ST_IE_InStockId	,");
		buffer.append("	C_ST_IE_OutStockId	,");
		buffer.append("	C_ST_IE_BarCode	,");
		buffer.append("	C_ST_IE_WarehousingDate	,");
		buffer.append("	C_ST_IE_Remark	,");
		buffer.append("	C_ST_IE_InvoiceState	,");
		buffer.append("	C_ST_IE_checkquantity	,");
		buffer.append("	C_ST_IE_GuaranteePeriod	,");
		buffer.append("	C_ST_IE_Batch	,");
		buffer.append("	C_ST_IE_OutStorageFlag)	");

		buffer.append("select replace(newid(), '-', ''), ");
		buffer.append("? , ");
		buffer.append("C_ST_IET_GoodsId, ");
		buffer.append("sum(C_ST_IET_GoodsQuantity), ");
		buffer.append("C_ST_IET_NotTaxRate, ");
		buffer.append("C_ST_IET_NotTaxRateAmount, ");
		buffer.append("C_ST_IET_TaxRate, ");
		buffer.append("C_ST_IET_CostPrice, ");
		buffer.append("C_ST_IET_TaxAmount, ");
		buffer.append("C_ST_IET_CostPriceAmount, ");
		buffer.append("C_ST_IET_InStockId, ");
		buffer.append("C_ST_IET_OutStockId, ");
		buffer.append("C_ST_IET_BarCode, ");
		buffer.append("getdate(), ");
		buffer.append("'' , ");
		buffer.append("'0' ,");
		buffer.append("'0','','','' ");
		buffer.append("from C_ST_InventoryTempEntry ");
		buffer.append("where C_ST_IET_BillID in (select C_ST_IT_BillID ");
		buffer.append("from C_ST_InventoryTemp left join B_Warehouse on C_ST_IT_InStockId = B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("where C_ST_IT_SupplierId = ? and C_ST_IT_flag = '0' and B_DP_CompanysID = ? and C_ST_IT_SubSupplierId = ? ) ");
		buffer.append("Group by C_ST_IET_GoodsId, C_ST_IET_NotTaxRate, ");
		buffer.append("C_ST_IET_NotTaxRateAmount, C_ST_IET_TaxRate,  ");
		buffer.append("C_ST_IET_CostPrice, C_ST_IET_TaxAmount, ");
		buffer.append("C_ST_IET_CostPriceAmount, C_ST_IET_InStockId, ");
		buffer.append("C_ST_IET_OutStockId, C_ST_IET_BarCode ");

		params.add(producedid);
		params.add(supplierid);
		params.add(companyID);
		params.add(subsupplier);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

}
