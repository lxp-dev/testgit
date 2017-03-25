package com.pengsheng.eims.logistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.logistics.dao.InvoiceSelectBillDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class InvoiceSelectBillDaoImpl extends BaseJdbcDaoSupport implements InvoiceSelectBillDao {

	/**
	 * 得到业务表信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelectBillCount(InventoryPo inventoryPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(C_ST_I_BillID) ");
		buffer.append("from C_ST_Inventory ");
		buffer.append("inner join B_Supplier ");
		buffer.append("on B_Supplier.B_SP_ID = C_ST_Inventory.C_ST_I_SupplierId ");
		
		//单据类型
		if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("1")){
			buffer.append("  left join B_Warehouse on C_ST_I_InStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}else if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("2")){
			buffer.append("  left join B_Warehouse on C_ST_I_OutStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		buffer.append("where C_ST_I_FinanceAuditState='1' and C_ST_I_AuditState='1' ");
		buffer.append(" and (datediff(Month,C_ST_I_VoucherDate,getdate()) >= 0 or C_ST_I_VoucherDate is null) ");
		
		if (!"".equals(Utility.getName(inventoryPo.getCsticompanyid()))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(inventoryPo.getCsticompanyid()));	
		}
		
		//单据类型
		if ("".equals(Utility.getName(inventoryPo.getCstibilltypeid()))){
			buffer.append("and C_ST_I_BillTypeId in ('1','2','9') ");
		}else {
			if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("1")){
				buffer.append("and C_ST_I_BillTypeId in ('1' ,'9') ");
			}else if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("2")){
				buffer.append("and C_ST_I_BillTypeId='2' ");
			}
		}
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {			
			String[] bills = Utility.getName(inventoryPo.getCstibillid()).split(",");
			int length = bills.length;
			if (length != 0){
				//buffer.append(" and C_ST_I_BillID in ( ?");
				buffer.append(" and RIGHT(C_ST_I_BillID,5) in ( RIGHT(?,5)");
				params.add(bills[0]);
				for (int i = 1; i < length; i++){
					buffer.append(",RIGHT(?,5)");
					params.add(bills[i]);
				}			
				buffer.append(" ) ");
			}
		}
		
		//核销状态
		if (!"".equals(Utility.getName(inventoryPo.getCstiinvoicestate()))) {
			if ("3".equals(Utility.getName(inventoryPo.getCstiinvoicestate()))) {
				buffer.append("and C_ST_I_InvoiceState <> '2'");
			}else{
				buffer.append("and C_ST_I_InvoiceState = ? ");			
				params.add(inventoryPo.getCstiinvoicestate());
			}
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append("and C_ST_I_SupplierId = ? ");			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(inventoryPo.getCstistartTime());
			params.add(inventoryPo.getCstiendTime());
			
		} else if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& "".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			params.add(inventoryPo.getCstistartTime());
			
		} else if ("".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(inventoryPo.getCstiendTime());
		}
		
		//商品类别
		if (!"".equals(Utility.getName(inventoryPo.getCstigoodstype()))) {
			buffer.append("and C_ST_I_GoodsCategory = ? ");			
			params.add(inventoryPo.getCstigoodstype());
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 查询业务表信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryPo> selectSelectBill(InventoryPo inventoryPo , int start , int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by C_ST_I_billDate desc ) as rowNum, ");
		
		buffer.append("C_ST_I_BillID as cstibillid , ");
		buffer.append("C_ST_I_BillTypeId as cstibilltypeid , ");
		buffer.append("B_SP_SupplierName as cstisuppliername , ");
		buffer.append("C_ST_I_billDate as cstibilldate , ");
		buffer.append(" C_ST_I_InvoiceState as cstiinvoicestate,sum(C_ST_IE_GoodsQuantity-C_ST_IE_checkquantity) as cstigoodsquantity,(sum(isnull(C_ST_IE_CostPriceAmount,0))-sum(dbo.getInvoiceCostPriceAmount(C_ST_IE_ID))) as csticostpriceamount ");
		
		buffer.append("from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		buffer.append("inner join B_Supplier on B_Supplier.B_SP_ID = C_ST_Inventory.C_ST_I_SupplierId ");
		
		//单据类型
		if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("1")){
			buffer.append("  left join B_Warehouse on C_ST_I_InStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}else if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("2")){
			buffer.append("  left join B_Warehouse on C_ST_I_OutStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		buffer.append("where C_ST_I_FinanceAuditState = '1' and C_ST_I_AuditState='1' ");
		buffer.append(" and (datediff(Month,C_ST_I_VoucherDate,getdate()) >= 0 or C_ST_I_VoucherDate is null) ");
		
		if (!"".equals(Utility.getName(inventoryPo.getCsticompanyid()))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(inventoryPo.getCsticompanyid()));	
		}
		
		//单据类型
		if ("".equals(Utility.getName(inventoryPo.getCstibilltypeid()))){
			buffer.append("and C_ST_I_BillTypeId in ('1','2','9') ");
		}else {
			if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("1")){
				buffer.append("and C_ST_I_BillTypeId in ('1' ,'9') ");
			}else if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("2")){
				buffer.append("and C_ST_I_BillTypeId='2' ");
			}
		}
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {			
			String[] bills = Utility.getName(inventoryPo.getCstibillid()).split(",");
			int length = bills.length;
			if (length != 0){
//				buffer.append(" and C_ST_I_BillID in ( ?");
				buffer.append(" and RIGHT(C_ST_I_BillID,5) in ( RIGHT(?,5)");
				params.add(bills[0]);
				for (int i = 1; i < length; i++){
					buffer.append(",RIGHT(?,5)");
					params.add(bills[i]);
				}			
				buffer.append(" ) ");
			}
		}
		
		//核销状态
		if (!"".equals(Utility.getName(inventoryPo.getCstiinvoicestate()))) {
			if ("3".equals(Utility.getName(inventoryPo.getCstiinvoicestate()))) {
				buffer.append("and C_ST_I_InvoiceState <> '2'");
			}else{
				buffer.append("and C_ST_I_InvoiceState = ? ");			
				params.add(inventoryPo.getCstiinvoicestate());
			}
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append("and C_ST_I_SupplierId = ? ");			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(inventoryPo.getCstistartTime());
			params.add(inventoryPo.getCstiendTime());
			
		} else if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& "".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			params.add(inventoryPo.getCstistartTime());
			
		} else if ("".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(inventoryPo.getCstiendTime());
		}
		//商品类别
		if (!"".equals(Utility.getName(inventoryPo.getCstigoodstype()))) {
			buffer.append("and C_ST_I_GoodsCategory = ? ");			
			params.add(inventoryPo.getCstigoodstype());
		}
		buffer.append(" group by C_ST_I_BillID,C_ST_I_BillTypeId,B_SP_SupplierName,C_ST_I_billDate,C_ST_I_InvoiceState");
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryPo.class);
	}
	
	/**
	 * 发票管理中单据查询中查询单据的总数
	 */
	public int getSelBillCount(InventoryPo inventoryPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(distinct C_ST_I_BillID) ");
		buffer.append("from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_IE_BillID=C_ST_I_BillID ");
		buffer.append("inner join B_Supplier on B_Supplier.B_SP_ID = C_ST_Inventory.C_ST_I_SupplierId ");
		
		//单据类型
		if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("1")){
			buffer.append("  left join B_Warehouse on C_ST_I_InStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}else if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("2")){
			buffer.append("  left join B_Warehouse on C_ST_I_OutStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		buffer.append("where C_ST_I_FinanceAuditState='1' and C_ST_I_AuditState='1' ");
		
		if (!"".equals(Utility.getName(inventoryPo.getCsticompanyid()))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(inventoryPo.getCsticompanyid()));	
		}
		
		//单据类型
		if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("1")){
			buffer.append("and C_ST_I_BillTypeId in ('1' ,'9') ");
		}else if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("2")){
			buffer.append("and C_ST_I_BillTypeId='2' ");
		}
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {			
			String[] bills = Utility.getName(inventoryPo.getCstibillid()).split(",");
			int length = bills.length;
			if (length != 0){
				buffer.append(" and RIGHT(C_ST_I_BillID,5) in ( RIGHT(?,5)");
				params.add(bills[0]);
				for (int i = 1; i < length; i++){
					buffer.append(",RIGHT(?,5)");
					params.add(bills[i]);
				}			
				buffer.append(" ) ");
			}
		}
		
		//核销状态
		if (!"".equals(Utility.getName(inventoryPo.getCstiinvoicestate()))) {
			if ("3".equals(Utility.getName(inventoryPo.getCstiinvoicestate()))) {
				buffer.append("and C_ST_I_InvoiceState <> '2'");
			}else{
				buffer.append("and C_ST_I_InvoiceState = ? ");			
				params.add(inventoryPo.getCstiinvoicestate());
			}
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append("and C_ST_I_SupplierId = ? ");			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))){			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= ? ");
			params.add(inventoryPo.getCstistartTime());
			
		} 
		if (!"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");
			params.add(inventoryPo.getCstiendTime());
		}
		
		//商品类别
		if (!"".equals(Utility.getName(inventoryPo.getCstigoodstype()))) {
			buffer.append("and substring(C_ST_IE_GoodsId,1,1) = ? ");			
			params.add(inventoryPo.getCstigoodstype());
		}

		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 发票管理中单据查询中查询单据
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryPo> selSelectBill(InventoryPo inventoryPo , int start , int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by C_ST_I_FinanceAuditDate desc ) as rowNum, ");
		
		buffer.append("C_ST_I_BillID as cstibillid ,C_ST_I_DeliveryID as cstisourcebillid, ");
		buffer.append("C_ST_I_BillTypeId as cstibilltypeid , ");
		buffer.append("B_SP_SupplierName as cstisuppliername , ");
		buffer.append("C_ST_I_FinanceAuditDate as cstibilldate , ");
		buffer.append(" C_ST_I_InvoiceState as cstiinvoicestate, ");
		
//		buffer.append("(sum(C_ST_IE_GoodsQuantity-isnull(C_ST_IE_checkquantity,0))) as cstigoodsquantity, ");
//        buffer.append("(sum(isnull(C_ST_IE_CostPriceAmount,0))-sum(dbo.getInvoiceCostPriceAmount(C_ST_IE_ID))) as csticostpriceamount ");	
		buffer.append("sum(C_ST_IE_GoodsQuantity) as cstigoodsquantity, ");
		buffer.append("sum(isnull(C_ST_IE_CostPriceAmount,0)) as csticostpriceamount ");	
		
		buffer.append("from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_IE_BillID=C_ST_I_BillID ");
		buffer.append("inner join B_Supplier on B_Supplier.B_SP_ID = C_ST_Inventory.C_ST_I_SupplierId ");
		
		//单据类型
		if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("1")){
			buffer.append("  left join B_Warehouse on C_ST_I_InStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}else if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("2")){
			buffer.append("  left join B_Warehouse on C_ST_I_OutStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		buffer.append("where C_ST_I_FinanceAuditState = '1' and C_ST_I_AuditState='1' ");	
		
		if (!"".equals(Utility.getName(inventoryPo.getCsticompanyid()))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(inventoryPo.getCsticompanyid()));	
		}
		
		//单据类型
		if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("1")){
			buffer.append("and C_ST_I_BillTypeId in ('1' ,'9') ");
		}else if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("2")){
			buffer.append("and C_ST_I_BillTypeId='2' ");
		}
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {			
			String[] bills = Utility.getName(inventoryPo.getCstibillid()).split(",");
			int length = bills.length;
			if (length != 0){
				buffer.append(" and RIGHT(C_ST_I_BillID,5) in ( RIGHT(?,5)");
				params.add(bills[0]);
				for (int i = 1; i < length; i++){
					buffer.append(",RIGHT(?,5)");
					params.add(bills[i]);
				}			
				buffer.append(" ) ");
			}
		}
		
		//核销状态
		if (!"".equals(Utility.getName(inventoryPo.getCstiinvoicestate()))) {
			if ("3".equals(Utility.getName(inventoryPo.getCstiinvoicestate()))) {
				buffer.append("and C_ST_I_InvoiceState <> '2'");
			}else{
				buffer.append("and C_ST_I_InvoiceState = ? ");			
				params.add(inventoryPo.getCstiinvoicestate());
			}
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append("and C_ST_I_SupplierId = ? ");			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))){			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= ? ");
			params.add(inventoryPo.getCstistartTime());
			
		} 
		if (!"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");
			params.add(inventoryPo.getCstiendTime());
		}
		
		//商品类别
		if (!"".equals(Utility.getName(inventoryPo.getCstigoodstype()))) {
			buffer.append("and substring(C_ST_IE_GoodsId,1,1) = ? ");			
			params.add(inventoryPo.getCstigoodstype());
		}
		
		buffer.append(" group by C_ST_I_BillID,C_ST_I_DeliveryID,C_ST_I_BillTypeId,B_SP_SupplierName,C_ST_I_FinanceAuditDate,C_ST_I_InvoiceState");
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryPo.class);
	}
	
	/**
	 * 查询业务表信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryPo> selectSelectBill(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select C_ST_I_BillID as cstibillid , ");
		buffer.append("C_ST_I_BillTypeId as cstibilltypeid , ");
		buffer.append("B_SP_SupplierName as cstisuppliername , ");
		buffer.append("C_ST_I_billDate as cstibilldate , ");
		buffer.append("sum(C_ST_IE_GoodsQuantity)-sum(isnull(C_ST_IE_checkquantity,0)) as cstiinvoicestate, ");
		buffer.append("sum(C_ST_IE_GoodsQuantity) as cstigoodsquantity, ");
		buffer.append("sum(isnull(C_ST_IE_checkquantity,0)) as csticheckgoodsquantity ");
		
		buffer.append("from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		buffer.append("inner join B_Supplier ");
		buffer.append("on B_Supplier.B_SP_ID = C_ST_Inventory.C_ST_I_SupplierId ");
		buffer.append("where C_ST_I_FinanceAuditState = '1' and (substring(convert(varchar(10),c_st_i_voucherdate,23),0,8)<>substring(convert(varchar(10),getdate(),23),0,8) or c_st_i_voucherdate is null) ");
		
		
		//单据类型
		if ("".equals(Utility.getName(inventoryPo.getCstibilltypeid()))){
			
			buffer.append(" and C_ST_I_BillTypeId in ('1' , '2' , '7' , '8') ");
			
		}else if (!"".equals(Utility.getName(inventoryPo.getCstibilltypeid()))) {
			buffer.append(" and C_ST_I_BillTypeId = ? ");
			
			params.add(inventoryPo.getCstibilltypeid());
		}
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {
			buffer.append(" and C_ST_I_BillID in ( ?");
			String[] bills = Utility.getName(inventoryPo.getCstibillid()).split(",");
			int length = bills.length;
			params.add(bills[0]);
			for (int i = 1; i < length; i++){
				buffer.append(",?");
				params.add(bills[i]);
			}			
			buffer.append(" ) ");
		}
		
		//核销状态
		if (!"".equals(Utility.getName(inventoryPo.getCstiinvoicestate()))) {
			buffer.append(" and C_ST_I_InvoiceState = ? ");			
			params.add(inventoryPo.getCstiinvoicestate());
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append(" and C_ST_I_SupplierId = ? ");
			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append(" and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			buffer.append(" and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");

			params.add(inventoryPo.getCstistartTime());
			params.add(inventoryPo.getCstiendTime());
		} else if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& "".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append(" and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");

			params.add(inventoryPo.getCstistartTime());
		} else if ("".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append(" and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");

			params.add(inventoryPo.getCstiendTime());
		}
		buffer.append(" group by C_ST_I_BillID,C_ST_I_BillTypeId,B_SP_SupplierName,C_ST_I_billDate");
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryPo.class);
	}
	
	/**
	 * 详细开窗表头
	 * @param inventoryPo
	 * @return
	 */
	public InventoryPo getBill(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 C_ST_I_BillID as cstibillid ,C_ST_I_DeliveryID as cstisourcebillid, ");
		buffer.append("C_ST_I_billDate as cstibilldate , ");
		buffer.append("B_SP_SupplierName as cstisuppliername , ");
		buffer.append("C_ST_I_BillTypeId as cstibilltypeid , ");
		buffer.append("ins.B_WH_warehouseName as cstiinstockid , ");
		buffer.append("outs.B_WH_warehouseName as cstioutstockid , ");
		buffer.append("c.personName as csticreateperson , ");
		buffer.append("a.personName as cstiauditperson , ");
		buffer.append("C_ST_I_Remark as cstiremark ");
		buffer.append("from C_ST_Inventory ");
		buffer.append("inner join B_Supplier ");
		buffer.append("on B_Supplier.B_SP_ID = C_ST_Inventory.C_ST_I_SupplierId ");
		buffer.append("left join SYS_PersonInfo c ");
		buffer.append("on c.ID = C_ST_Inventory.C_ST_I_createPerson ");
		buffer.append("left join SYS_PersonInfo a ");
		buffer.append("on a.ID = C_ST_Inventory.C_ST_I_AuditPerson ");
		buffer.append("left join B_Warehouse ins ");
		buffer.append("on ins.B_WH_ID = C_ST_Inventory.C_ST_I_InStockId ");
		buffer.append("left join B_Warehouse outs ");
		buffer.append("on outs.B_WH_ID = C_ST_Inventory.C_ST_I_OutStockId ");
		buffer.append("where C_ST_I_BillID = ? ");
		
		params.add(inventoryPo.getCstibillid());
		
		return (InventoryPo) queryForObject(buffer.toString() , params.toArray() , InventoryPo.class);
	}

	/**
	 * 单据查询中查看单据明细信息
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryEntryPo> getBillEntry(InventoryEntryPo inventoryEntryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select C_ST_IE_GoodsId as cstiegoodsid , ");
		buffer.append("B_GI_ViewGoodsName as cstiegoodsname , ");
		buffer.append("C_ST_IE_NotTaxRate as cstienottaxrate , ");
		buffer.append("B_GI_Sph as cstiesph , ");
		buffer.append("B_GI_Cyl as cstiecyl , ");
		buffer.append("C_ST_IE_CostPrice as cstiecostprice , ");
		buffer.append("C_ST_IE_GoodsQuantity as cstiegoodsquantity , ");
		buffer.append("isnull(C_ST_IE_checkquantity,0) as cstiecheckgoodsquantity , ");
		buffer.append("(C_ST_IE_GoodsQuantity-isnull(C_ST_IE_checkquantity,0)) as cstieprovisionalnum , ");
		buffer.append("C_ST_IE_NotTaxRateAmount as cstienottaxrateamount, ");
		buffer.append("C_ST_IE_TaxAmount as cstietaxamount , ");
		buffer.append("C_ST_IE_CostPriceAmount as cstiecostpriceamount ");
		buffer.append(",'0' as cstieinvoicestate ");		
		
		buffer.append("from C_ST_InventoryEntry ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId ");
		buffer.append("where C_ST_IE_InvoiceState='0' and C_ST_IE_BillID = ? ");
		
		buffer.append(" union all ");
		
		buffer.append("select C_ST_IE_GoodsId as cstiegoodsid , ");
		buffer.append("B_GI_ViewGoodsName as cstiegoodsname , ");
		buffer.append("C_ST_IE_NotTaxRate as cstienottaxrate , ");
		buffer.append("B_GI_Sph as cstiesph , ");
		buffer.append("B_GI_Cyl as cstiecyl , ");
		buffer.append("C_ST_IE_CostPrice as cstiecostprice , ");
		buffer.append("C_ST_IE_GoodsQuantity as cstiegoodsquantity , ");
		buffer.append("isnull(C_ST_IE_checkquantity,0) as cstiecheckgoodsquantity , ");
		buffer.append("(C_ST_IE_GoodsQuantity-isnull(C_ST_IE_checkquantity,0)) as cstieprovisionalnum , ");
		
		buffer.append("(sum(isnull(C_ST_IE_NotTaxRateAmount,0))-sum(dbo.getInvoiceNotTaxRateAmount(C_ST_IE_ID))) as cstienottaxrateamount, ");
		buffer.append("(sum(isnull(C_ST_IE_CostPriceAmount,0))-sum(dbo.getInvoiceCostPriceAmount(C_ST_IE_ID))-sum(isnull(C_ST_IE_NotTaxRateAmount,0))+sum(dbo.getInvoiceNotTaxRateAmount(C_ST_IE_ID))) as cstietaxamount , ");
		buffer.append("(sum(isnull(C_ST_IE_CostPriceAmount,0))-sum(dbo.getInvoiceCostPriceAmount(C_ST_IE_ID))) as cstiecostpriceamount ");
		
		buffer.append(",'1' as cstieinvoicestate ");
		
		buffer.append("from C_ST_InventoryEntry ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId ");
		buffer.append(" where C_ST_IE_InvoiceState='1' and C_ST_IE_BillID = ? ");
		buffer.append(" group by C_ST_IE_GoodsId,B_GI_ViewGoodsName,C_ST_IE_NotTaxRate,B_GI_Sph,B_GI_Cyl,C_ST_IE_CostPrice,C_ST_IE_GoodsQuantity,C_ST_IE_checkquantity ");
		
		buffer.append(" union all ");
		
		buffer.append("select C_ST_IE_GoodsId as cstiegoodsid , ");
		buffer.append("B_GI_ViewGoodsName as cstiegoodsname , ");
		buffer.append("C_ST_IE_NotTaxRate as cstienottaxrate , ");
		buffer.append("B_GI_Sph as cstiesph , ");
		buffer.append("B_GI_Cyl as cstiecyl , ");
		buffer.append("C_ST_IE_CostPrice as cstiecostprice , ");
		buffer.append("C_ST_IE_GoodsQuantity as cstiegoodsquantity , ");
		buffer.append("isnull(C_ST_IE_checkquantity,0) as cstiecheckgoodsquantity , ");
		buffer.append("0 as cstieprovisionalnum , ");
		buffer.append("0.00 as cstienottaxrateamount, ");
		buffer.append("0.00 as cstietaxamount , ");
		buffer.append("0.00 as cstiecostpriceamount ");
		buffer.append(",'2' as cstieinvoicestate ");		
		
		buffer.append("from C_ST_InventoryEntry ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId ");
		buffer.append("where C_ST_IE_InvoiceState='2' and C_ST_IE_BillID = ? ");
		
		params.add(inventoryEntryPo.getCstiebillid());
		params.add(inventoryEntryPo.getCstiebillid());
		params.add(inventoryEntryPo.getCstiebillid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryEntryPo.class);
	}
	
	/**
	 * 查询未核销商品价税合计等数据
	 */
	public InventoryPo getBillSum(InventoryPo inventoryPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select isnull(sum(cstigoodsquantity),0) as cstigoodsquantity , ");
		buffer.append("isnull(sum(csticheckgoodsquantity),0) as csticheckgoodsquantity , ");
		buffer.append("isnull(sum(cstinottaxrate),0) as cstinottaxrate , ");
		buffer.append("isnull(sum(cstinottaxrateamount),0) as cstinottaxrateamount, ");
		buffer.append("isnull(sum(cstitaxrate),0) as cstitaxrate , ");
		buffer.append("isnull(sum(csticostprice),0) as csticostprice from( ");
		
		buffer.append("select sum(C_ST_IE_GoodsQuantity) as cstigoodsquantity , ");
		buffer.append("isnull(sum(C_ST_IE_checkquantity),0) as csticheckgoodsquantity , ");
		buffer.append("sum(C_ST_IE_GoodsQuantity-isnull(C_ST_IE_checkquantity,0)) as cstinottaxrate , ");
		buffer.append("sum(C_ST_IE_NotTaxRateAmount) as cstinottaxrateamount, ");
		buffer.append("sum(C_ST_IE_TaxAmount) as cstitaxrate , ");
		buffer.append("sum(C_ST_IE_CostPriceAmount) as csticostprice ");	
		buffer.append("from C_ST_InventoryEntry inner join C_ST_Inventory on C_ST_IE_BillID=C_ST_I_BillID ");
		
		//单据类型
		if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("1")){
			buffer.append("  left join B_Warehouse on C_ST_I_InStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}else if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("2")){
			buffer.append("  left join B_Warehouse on C_ST_I_OutStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
						
		buffer.append("where C_ST_I_FinanceAuditState = '1' and C_ST_I_AuditState='1' and C_ST_I_InvoiceState='0' ");		
		
		if (!"".equals(Utility.getName(inventoryPo.getCsticompanyid()))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(inventoryPo.getCsticompanyid()));	
		}
		
		//单据类型
		if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("1")){
			buffer.append("and C_ST_I_BillTypeId in ('1' ,'9') ");
		}else if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("2")){
			buffer.append("and C_ST_I_BillTypeId='2' ");
		}
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {			
			String[] bills = Utility.getName(inventoryPo.getCstibillid()).split(",");
			int length = bills.length;
			if (length != 0){
				buffer.append(" and right(C_ST_I_BillID,5) in ( right(?,5)");
				params.add(bills[0]);
				for (int i = 1; i < length; i++){
					buffer.append(",right(?,5)");
					params.add(bills[i]);
				}			
				buffer.append(" ) ");
			}
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append("and C_ST_I_SupplierId = ? ");			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))) {			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate,120) >= ? ");
			params.add(inventoryPo.getCstistartTime());
			
		}
		if (!"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate,120) <= ? ");
			params.add(inventoryPo.getCstiendTime());
		}
		
		//商品类别
		if (!"".equals(Utility.getName(inventoryPo.getCstigoodstype()))) {
			buffer.append("and substring(C_ST_IE_GoodsId,1,1) = ? ");			
			params.add(inventoryPo.getCstigoodstype());
		}		
		buffer.append(" union all ");
		buffer.append("select sum(C_ST_IE_GoodsQuantity) as cstigoodsquantity , ");
		buffer.append("isnull(sum(C_ST_IE_checkquantity),0) as csticheckgoodsquantity , ");
		buffer.append("sum(C_ST_IE_GoodsQuantity-isnull(C_ST_IE_checkquantity,0)) as cstinottaxrate , ");
		
		buffer.append("(sum(isnull(C_ST_IE_NotTaxRateAmount,0))-sum(dbo.getInvoiceNotTaxRateAmount(C_ST_IE_ID))) as cstinottaxrateamount, ");
		buffer.append("(sum(isnull(C_ST_IE_CostPriceAmount,0))-sum(dbo.getInvoiceCostPriceAmount(C_ST_IE_ID))-sum(isnull(C_ST_IE_NotTaxRateAmount,0))+sum(dbo.getInvoiceNotTaxRateAmount(C_ST_IE_ID))) as cstitaxrate , ");
		buffer.append("(sum(isnull(C_ST_IE_CostPriceAmount,0))-sum(dbo.getInvoiceCostPriceAmount(C_ST_IE_ID))) as csticostprice ");
		
		buffer.append("from C_ST_InventoryEntry inner join C_ST_Inventory on C_ST_IE_BillID=C_ST_I_BillID ");

		//单据类型
		if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("1")){
			buffer.append("  left join B_Warehouse on C_ST_I_InStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}else if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("2")){
			buffer.append("  left join B_Warehouse on C_ST_I_OutStockId=B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
						
		buffer.append("where C_ST_I_FinanceAuditState = '1' and C_ST_I_AuditState='1' and C_ST_I_InvoiceState='1' ");
		
		if (!"".equals(Utility.getName(inventoryPo.getCsticompanyid()))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(inventoryPo.getCsticompanyid()));	
		}
		
		//单据类型
		if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("1")){
			buffer.append("and C_ST_I_BillTypeId in ('1' ,'9') ");
		}else if(Utility.getName(inventoryPo.getCstibilltypeid()).equalsIgnoreCase("2")){
			buffer.append("and C_ST_I_BillTypeId='2' ");
		}
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {			
			String[] bills = Utility.getName(inventoryPo.getCstibillid()).split(",");
			int length = bills.length;
			if (length != 0){
				buffer.append(" and right(C_ST_I_BillID,5) in ( right(?,5)");
				params.add(bills[0]);
				for (int i = 1; i < length; i++){
					buffer.append(",right(?,5)");
					params.add(bills[i]);
				}			
				buffer.append(" ) ");
			}
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append("and C_ST_I_SupplierId = ? ");			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))) {			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate,120) >= ? ");
			params.add(inventoryPo.getCstistartTime());
			
		}
		if (!"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate,120) <= ? ");
			params.add(inventoryPo.getCstiendTime());
		}
		
		//商品类别
		if (!"".equals(Utility.getName(inventoryPo.getCstigoodstype()))) {
			buffer.append("and substring(C_ST_IE_GoodsId,1,1) = ? ");			
			params.add(inventoryPo.getCstigoodstype());
		}
		buffer.append(") temp");	
		return (InventoryPo) queryForObject(buffer.toString() , params.toArray() , InventoryPo.class);
	}
	
	/**
	 * 模块：发票管理
	 * 描述：发票新增页面查询单据
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public List<InventoryEntryPo> getBillGoods(InventoryPo inventoryPo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select cstieid as cstieid,cstiebillid as cstiebillid , ");
		buffer.append("cstiegoodsid as cstiegoodsid , ");
		buffer.append("cstiegoodsname as cstiegoodsname , ");
		buffer.append("cstiespec as cstiespec , ");
		buffer.append("cstiegoodsquantity as cstiegoodsquantity , ");
		buffer.append("cstiecheckgoodsquantity as cstiecheckgoodsquantity , ");
		buffer.append("cstienottaxrate as cstienottaxrate , ");
		buffer.append("cstienottaxrateamount as cstienottaxrateamount , ");
		buffer.append("cstietaxrate as cstietaxrate , ");
		buffer.append("cstiecostprice as cstiecostprice , ");
		buffer.append("(cstiecostpriceamount-cstienottaxrateamount) as cstietaxamount , ");
		buffer.append("cstiecostpriceamount as cstiecostpriceamount,");
		buffer.append("cstiebilltypeid as cstiebilltypeid from ( ");
		
		buffer.append("select C_ST_IE_ID as cstieid,C_ST_IE_BillID as cstiebillid , ");
		buffer.append("C_ST_IE_GoodsId as cstiegoodsid , ");
		buffer.append("B_GI_ViewGoodsName as cstiegoodsname , ");
		buffer.append("B_GI_Spec as cstiespec , ");
		buffer.append("(isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0)) as cstiegoodsquantity , ");
		buffer.append("(isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0)) as cstiecheckgoodsquantity , ");
		buffer.append("C_ST_IE_NotTaxRate as cstienottaxrate , ");
		buffer.append("(isnull(C_ST_IE_NotTaxRateAmount,0)-dbo.getInvoiceNotTaxRateAmount(C_ST_IE_ID)) as cstienottaxrateamount , ");
		buffer.append("C_ST_IE_TaxRate as cstietaxrate , ");
		buffer.append("C_ST_IE_CostPrice as cstiecostprice , ");
		buffer.append("(isnull(C_ST_IE_CostPriceAmount,0)-dbo.getInvoiceCostPriceAmount(C_ST_IE_ID)) as cstiecostpriceamount,");
		buffer.append("(case C_ST_I_BillTypeId when 2 then 2 else 1 end ) as cstiebilltypeid ");
		
		buffer.append("from C_ST_InventoryEntry ");
		buffer.append("inner join C_ST_Inventory ");
		buffer.append("on C_ST_Inventory.C_ST_I_BillID = C_ST_InventoryEntry.C_ST_IE_BillID ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId ");
		buffer.append("where C_ST_I_BillID = ? ");
		
		params.add(Utility.getName(inventoryPo.getCstibillid()));
		
		if ("c1".equals(Utility.getName(inventoryPo.getInvoiceType()))){ //采购普通发票
			buffer.append(" and isnull(C_ST_IE_TaxRate,0)=0 ");
		}
		if ("c2".equals(Utility.getName(inventoryPo.getInvoiceType()))){ //采购增值税发票
			buffer.append(" and isnull(C_ST_IE_TaxRate,0)<>0 ");
		}
		buffer.append(" )temp ");
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryEntryPo.class);
	}
	
	public int getSelectGoodsCount(InventoryPo inventoryPo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append("select count(C_ST_IE_ID) as cstieid ");		
		buffer.append("from C_ST_InventoryEntry ");
		buffer.append("inner join C_ST_Inventory ");
		buffer.append("on C_ST_Inventory.C_ST_I_BillID = C_ST_InventoryEntry.C_ST_IE_BillID ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId ");
		
		buffer.append("  left join B_Warehouse a on C_ST_I_InStockId=a.B_WH_ID left join B_Departments ab on a.B_WH_deptID = ab.B_DP_DepartmentID ");
		buffer.append("  left join B_Warehouse b on C_ST_I_OutStockId=b.B_WH_ID left join B_Departments bb on b.B_WH_deptID = bb.B_DP_DepartmentID ");
		
		buffer.append("where C_ST_I_BillID like '%'+?+'%' and (isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0))<>0 and C_ST_I_BillTypeId in ('1','2','9') ");
		
		params.add(Utility.getName(inventoryPo.getCstibillid()));
		
		if (!"".equals(Utility.getName(inventoryPo.getCsticompanyid()))){
			buffer.append(" and ( ab.B_DP_CompanysID = ? or bb.B_DP_CompanysID = ? ) ");
			params.add(Utility.getName(inventoryPo.getCsticompanyid()));	
			params.add(Utility.getName(inventoryPo.getCsticompanyid()));
		}
		
		if ("c1".equals(Utility.getName(inventoryPo.getInvoiceType()))){ //采购普通发票
			buffer.append(" and isnull(C_ST_IE_TaxRate,0)=0 ");
		}
		if ("c2".equals(Utility.getName(inventoryPo.getInvoiceType()))){ //采购增值税发票
			buffer.append(" and isnull(C_ST_IE_TaxRate,0)<>0 ");
		}
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))){ //采购增值税发票
			buffer.append(" and B_GI_SupplierID=? ");
			params.add(Utility.getName(inventoryPo.getCstisupplierid()));
		}	
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	public List<InventoryEntryPo> selectSelectGoods(InventoryPo inventoryPo,int start, int size) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by cstiebillid desc ) as rowNum, ");
		
		buffer.append("cstieid as cstieid,cstiebillid as cstiebillid , ");
		buffer.append("cstiegoodsid as cstiegoodsid , ");
		buffer.append("cstiegoodsname as cstiegoodsname , ");
		buffer.append("cstiespec as cstiespec , ");
		buffer.append("cstiegoodsquantity as cstiegoodsquantity , ");
		buffer.append("cstiecheckgoodsquantity as cstiecheckgoodsquantity , ");
		buffer.append("cstienottaxrate as cstienottaxrate , ");
		buffer.append("cstienottaxrateamount as cstienottaxrateamount , ");
		buffer.append("cstietaxrate as cstietaxrate , ");
		buffer.append("cstiecostprice as cstiecostprice , ");
		buffer.append("(cstiecostpriceamount-cstienottaxrateamount) as cstietaxamount , ");
		buffer.append("cstiecostpriceamount as cstiecostpriceamount,");
		buffer.append("cstiebilltypeid as cstiebilltypeid from ( ");
		
		buffer.append("select C_ST_IE_ID as cstieid,C_ST_IE_BillID as cstiebillid , ");
		buffer.append("C_ST_IE_GoodsId as cstiegoodsid , ");
		buffer.append("B_GI_ViewGoodsName as cstiegoodsname , ");
		buffer.append("B_GI_Spec as cstiespec , ");
		buffer.append("(isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0)) as cstiegoodsquantity , ");
		buffer.append("(isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0)) as cstiecheckgoodsquantity , ");
		buffer.append("C_ST_IE_NotTaxRate as cstienottaxrate , ");
		buffer.append("(isnull(C_ST_IE_NotTaxRateAmount,0)-dbo.getInvoiceNotTaxRateAmount(C_ST_IE_ID)) as cstienottaxrateamount , ");
		buffer.append("C_ST_IE_TaxRate as cstietaxrate , ");
		buffer.append("C_ST_IE_CostPrice as cstiecostprice , ");
		buffer.append("(isnull(C_ST_IE_CostPriceAmount,0)-dbo.getInvoiceCostPriceAmount(C_ST_IE_ID)) as cstiecostpriceamount,");
		buffer.append("(case C_ST_I_BillTypeId when 2 then 2 else 1 end ) as cstiebilltypeid ");
		
		buffer.append("from C_ST_InventoryEntry ");
		buffer.append("inner join C_ST_Inventory ");
		buffer.append("on C_ST_Inventory.C_ST_I_BillID = C_ST_InventoryEntry.C_ST_IE_BillID ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId ");
		
		buffer.append("  left join B_Warehouse a on C_ST_I_InStockId=a.B_WH_ID left join B_Departments ab on a.B_WH_deptID = ab.B_DP_DepartmentID ");
		buffer.append("  left join B_Warehouse b on C_ST_I_OutStockId=b.B_WH_ID left join B_Departments bb on b.B_WH_deptID = bb.B_DP_DepartmentID ");
		
		buffer.append("where C_ST_I_BillID like '%'+?+'%' and C_ST_I_BillTypeId in ('1','2','9') ");
		
		params.add(Utility.getName(inventoryPo.getCstibillid()));
		
		if (!"".equals(Utility.getName(inventoryPo.getCsticompanyid()))){
			buffer.append(" and ( ab.B_DP_CompanysID = ? or bb.B_DP_CompanysID = ? ) ");
			params.add(Utility.getName(inventoryPo.getCsticompanyid()));	
			params.add(Utility.getName(inventoryPo.getCsticompanyid()));
		}
		
		if ("c1".equals(Utility.getName(inventoryPo.getInvoiceType()))){ //采购普通发票
			buffer.append(" and isnull(C_ST_IE_TaxRate,0)=0 ");
		}
		if ("c2".equals(Utility.getName(inventoryPo.getInvoiceType()))){ //采购增值税发票
			buffer.append(" and isnull(C_ST_IE_TaxRate,0)<>0 ");
		}
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))){ //采购增值税发票
			buffer.append(" and B_GI_SupplierID=? ");
			params.add(Utility.getName(inventoryPo.getCstisupplierid()));
		}	
		buffer.append(" ) temp where cstiegoodsquantity<>0 ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() ,InventoryEntryPo.class);
	}	
	
}
