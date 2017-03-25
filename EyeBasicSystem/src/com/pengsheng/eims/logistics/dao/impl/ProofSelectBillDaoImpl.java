package com.pengsheng.eims.logistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.dao.ProofSelectBillDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ProofSelectBillDaoImpl extends BaseJdbcDaoSupport implements ProofSelectBillDao {

	/**
	 * 得到业务表信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelectBillCount(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(C_ST_I_BillID) ");
		buffer.append("from C_ST_Inventory ");
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))){
			buffer.append(" inner join B_Supplier on B_Supplier.B_SP_ID = C_ST_Inventory.C_ST_I_SupplierId ");
		}else{
			buffer.append(" inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");			
		}
		buffer.append("where C_ST_I_FinanceAuditState = '1' and C_ST_I_AuditState = '1' ");
//		buffer.append(" and (DATEDIFF(MONTH,C_ST_I_VoucherDate,getdate()) > 0 or (C_ST_I_VoucherDate is null)) ");
		buffer.append(" and (isnull(C_ST_I_VoucherType,'0') = '0' or C_ST_I_VoucherType='') ");
		//单据类型
		if ("".equals(Utility.getName(inventoryPo.getCstibilltypeid()))){			
			buffer.append("and C_ST_I_BillTypeId in ('1' , '2' , '7' , '8','9' ) ");			
		}else if (!"".equals(Utility.getName(inventoryPo.getCstibilltypeid()))) {
			if ("1".equals(Utility.getName(inventoryPo.getCstibilltypeid()))){
				buffer.append("and C_ST_I_BillTypeId in ('1','9') ");
			}else{
				buffer.append("and C_ST_I_BillTypeId = ? ");			
				params.add(inventoryPo.getCstibilltypeid());
			}
		}
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {
			buffer.append("and C_ST_I_BillID like '%' + ? ");			
			params.add(inventoryPo.getCstibillid());
		}
		
		//核销状态
		if (!"".equals(Utility.getName(inventoryPo.getCstifinanceauditstate()))) {
			buffer.append("and isnull(C_ST_I_InvoiceState,'0') = ? ");			
			params.add(inventoryPo.getCstifinanceauditstate());
		}else{
			buffer.append("and isnull(C_ST_I_InvoiceState,'0') in ('0','1','2') ");
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append("and C_ST_I_SupplierId = ? ");			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//门店
		if (!"".equals(Utility.getName(inventoryPo.getCstidepartmentid()))) {
//			buffer.append("and C_ST_I_DepartmentId = ? ");	
			buffer.append("and C_ST_I_SupplierId = ? ");
			params.add(inventoryPo.getCstidepartmentid());
		}
		
		//单据日期-----
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");

			params.add(inventoryPo.getCstistartTime());
			params.add(inventoryPo.getCstiendTime());
		} else if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& "".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= ? ");

			params.add(inventoryPo.getCstistartTime());
		} else if ("".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");

			params.add(inventoryPo.getCstiendTime());
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	public int getSalesBillCount(InventoryPo inventoryPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(C_ST_I_BillID) ");
		buffer.append("from C_ST_Inventory ");
		buffer.append(" inner join B_Departments on C_ST_I_SupplierId = B_DP_DepartmentID ");
		buffer.append("where C_ST_I_AuditState = '1' and C_ST_I_BillTypeId='3' ");
		buffer.append(" and isnull(C_ST_I_VoucherType,'0') not like '%' + ? +'%' ");
		buffer.append(" and convert(varchar(10), C_ST_I_AuditDate, 23) <= ( ");
		buffer.append(" select convert(varchar(10),dateadd(dd,-day(cast(L_SA_Year as varchar)+'-'+L_SA_Month+'-01'),dateadd(m,1,cast(L_SA_Year as varchar)+'-'+L_SA_Month+'-01')),120) ");
		buffer.append("  from L_SA_SwitchAmount where L_SA_CurrentMonth='1') ");
		
		//销售出库凭证类型
		params.add(Utility.getName(inventoryPo.getSalesOutBillType()));
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {
			buffer.append("and C_ST_I_BillID like '%' + ? ");			
			params.add(inventoryPo.getCstibillid());
		}
		
		//门店
		if (!"".equals(Utility.getName(inventoryPo.getCstidepartmentid()))) {
			buffer.append("and C_ST_I_DepartmentId = ? ");			
			params.add(inventoryPo.getCstidepartmentid());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_AuditDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_I_AuditDate, 23) <= ? ");

			params.add(inventoryPo.getCstistartTime());
			params.add(inventoryPo.getCstiendTime());
			
		} else if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& "".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_AuditDate, 23) >= ? ");
			params.add(inventoryPo.getCstistartTime());
			
		} else if ("".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_AuditDate, 23) <= ? ");
			params.add(inventoryPo.getCstiendTime());
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
	public List<InventoryPo> selectSelectBill(InventoryPo inventoryPo , int start , int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by C_ST_I_FinanceAuditDate desc ) as rowNum, ");
		
		buffer.append("C_ST_I_BillID as cstibillid , ");
		buffer.append("C_ST_I_BillTypeId as cstibilltypeid , ");
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))){
			buffer.append("B_SP_SupplierName as cstisuppliername , ");
		}else{
			buffer.append(" B_DP_DepartmentName as cstidepartmentname, ");			
		}		
		buffer.append("C_ST_I_FinanceAuditDate as cstibilldate , ");
		buffer.append("C_ST_I_InvoiceState as cstifinanceauditstate , ");
		buffer.append("cstienottaxrate ");
		
		buffer.append("from C_ST_Inventory ");
		
		buffer.append("left join ");
		buffer.append("(select C_ST_IE_BillID , sum(C_ST_IE_NotTaxRate) as cstienottaxrate ");
		buffer.append("from C_ST_InventoryEntry group by C_ST_IE_BillID ) entry ");
		buffer.append("on entry.C_ST_IE_BillID = C_ST_Inventory.C_ST_I_BillID ");
		
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))){
			buffer.append(" inner join B_Supplier on B_Supplier.B_SP_ID = C_ST_Inventory.C_ST_I_SupplierId ");
		}else{
			buffer.append(" inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");			
		}		
		buffer.append("where C_ST_I_FinanceAuditState = '1' and C_ST_I_AuditState = '1' ");
//		buffer.append(" and (DATEDIFF(MONTH,C_ST_I_VoucherDate,getdate()) > 0 or (C_ST_I_VoucherDate is null)) ");
		buffer.append(" and (isnull(C_ST_I_VoucherType,'0') = '0' or C_ST_I_VoucherType='') ");
		
		//单据类型
		if ("".equals(Utility.getName(inventoryPo.getCstibilltypeid()))){
			
			buffer.append("and C_ST_I_BillTypeId in ('1' , '2' , '7' , '8' ,'9') ");
			
		}else if (!"".equals(Utility.getName(inventoryPo.getCstibilltypeid()))) {
			if ("1".equals(Utility.getName(inventoryPo.getCstibilltypeid()))){
				buffer.append("and C_ST_I_BillTypeId in ('1','9') ");
			}else{
				buffer.append("and C_ST_I_BillTypeId = ? ");			
				params.add(inventoryPo.getCstibilltypeid());
			}
		}
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {
			buffer.append("and C_ST_I_BillID like '%' + ? ");
			
			params.add(inventoryPo.getCstibillid());
		}
		
		//核销状态
		if (!"".equals(Utility.getName(inventoryPo.getCstifinanceauditstate()))) {
			buffer.append("and isnull(C_ST_I_InvoiceState,'0') = ? ");
			
			params.add(inventoryPo.getCstifinanceauditstate());
		}else{
			buffer.append("and isnull(C_ST_I_InvoiceState,'0') in ('0','1','2') ");
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append("and C_ST_I_SupplierId = ? ");
			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//门店
		if (!"".equals(Utility.getName(inventoryPo.getCstidepartmentid()))) {
//			buffer.append("and C_ST_I_DepartmentId = ? ");
			buffer.append("and C_ST_I_SupplierId = ? ");
			params.add(inventoryPo.getCstidepartmentid());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");

			params.add(inventoryPo.getCstistartTime());
			params.add(inventoryPo.getCstiendTime());
		} else if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& "".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) >= ? ");

			params.add(inventoryPo.getCstistartTime());
		} else if ("".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_FinanceAuditDate, 23) <= ? ");

			params.add(inventoryPo.getCstiendTime());
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryPo.class);
	}
	
	public List<InventoryPo> selSalesOutStorageBill(InventoryPo inventoryPo , int start , int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by C_ST_I_AuditDate desc ) as rowNum, ");
		
		buffer.append("C_ST_I_BillID as cstibillid , ");
		buffer.append("C_ST_I_BillTypeId as cstibilltypeid , ");
		buffer.append(" B_DP_DepartmentName as cstidepartmentname, ");		
		buffer.append("C_ST_I_AuditDate as cstibilldate , ");
//		buffer.append("'' as cstifinanceauditstate , ");
		buffer.append("cstienottaxrate ");
		
		buffer.append("from C_ST_Inventory ");
		
		buffer.append("left join ");
		buffer.append("(select C_ST_IE_BillID , sum(C_ST_IE_NotTaxRate) as cstienottaxrate ");
		buffer.append("from C_ST_InventoryEntry group by C_ST_IE_BillID ) entry ");
		buffer.append("on entry.C_ST_IE_BillID = C_ST_Inventory.C_ST_I_BillID ");
		
		buffer.append(" inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");				
		buffer.append("where C_ST_I_AuditState = '1'  and C_ST_I_BillTypeId='3' ");
		buffer.append(" and isnull(C_ST_I_VoucherType,'0') not like '%' + ? +'%' ");
		buffer.append(" and convert(varchar(10), C_ST_I_AuditDate, 23) <= ( ");
		buffer.append(" select convert(varchar(10),dateadd(dd,-day(cast(L_SA_Year as varchar)+'-'+L_SA_Month+'-01'),dateadd(m,1,cast(L_SA_Year as varchar)+'-'+L_SA_Month+'-01')),120) ");
		buffer.append("  from L_SA_SwitchAmount where L_SA_CurrentMonth='1') ");
		
		//销售出库凭证类型
		params.add(Utility.getName(inventoryPo.getSalesOutBillType()));
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {
			buffer.append("and C_ST_I_BillID like '%' + ? ");			
			params.add(inventoryPo.getCstibillid());
		}
		
		//门店
		if (!"".equals(Utility.getName(inventoryPo.getCstidepartmentid()))) {
			buffer.append("and C_ST_I_DepartmentId = ? ");			
			params.add(inventoryPo.getCstidepartmentid());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_AuditDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_I_AuditDate, 23) <= ? ");

			params.add(inventoryPo.getCstistartTime());
			params.add(inventoryPo.getCstiendTime());
		} else if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& "".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_AuditDate, 23) >= ? ");

			params.add(inventoryPo.getCstistartTime());
		} else if ("".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), C_ST_I_AuditDate, 23) <= ? ");

			params.add(inventoryPo.getCstiendTime());
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryPo.class);
	}
	
	/**
	 * 得到发票信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelectInvoice(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(L_I_I_ID) ");
		buffer.append("from L_I_Invoice ");
		buffer.append("inner join B_Supplier ");
		buffer.append("on B_Supplier.B_SP_ID = L_I_Invoice.L_I_I_SupplierID ");
		buffer.append("where L_I_I_isVoucher = '0' ");
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {
			buffer.append("and L_I_I_ID like '%' + ? ");			
			params.add(inventoryPo.getCstibillid());
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append("and L_I_I_SupplierID = ? ");			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//核销状态
		if (!"".equals(Utility.getName(inventoryPo.getCstifinanceauditdate()))) {
			buffer.append("and L_I_I_AuditStatue = ? ");			
			params.add(inventoryPo.getCstifinanceauditdate());
		}
		
		//发票类型
		if (!"".equals(Utility.getName(inventoryPo.getInvoiceType()))) {
			buffer.append("and L_I_I_InvoiceType = ? ");			
			params.add(inventoryPo.getInvoiceType());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), L_I_I_Date, 23) >= ? ");
			buffer.append("and convert(varchar(10), L_I_I_Date, 23) <= ? ");

			params.add(inventoryPo.getCstistartTime());
			params.add(inventoryPo.getCstiendTime());
		} else if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& "".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), L_I_I_Date, 23) >= ? ");
			params.add(inventoryPo.getCstistartTime());
			
		} else if ("".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), L_I_I_Date, 23) <= ? ");
			params.add(inventoryPo.getCstiendTime());
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	
	/**
	 * 查询发票信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectInvoice(InventoryPo inventoryPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by L_I_I_ID ) as rowNum, ");
		
		buffer.append("L_I_I_ID as cstibillid , ");
		buffer.append("'发票' as cstibilltypeid , ");
		buffer.append("B_SP_SupplierName as cstisuppliername , ");
		buffer.append("L_I_I_Date as cstibilldate , ");
		buffer.append("L_I_I_AuditStatue as cstifinanceauditstate ,");
		buffer.append("L_IT_Type as invoiceType ");
		
		buffer.append("from L_I_Invoice ");
		buffer.append("inner join B_Supplier ");
		buffer.append("on B_Supplier.B_SP_ID = L_I_Invoice.L_I_I_SupplierID inner join L_IT_InvoiceType on L_IT_ID=L_I_I_InvoiceType ");
		buffer.append("where L_I_I_isVoucher = '0' ");
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {
			buffer.append("and L_I_I_ID like '%' + ? ");			
			params.add(inventoryPo.getCstibillid());
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append("and L_I_I_SupplierID = ? ");			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//核销状态
		if (!"".equals(Utility.getName(inventoryPo.getCstifinanceauditdate()))) {
			buffer.append("and L_I_I_AuditStatue = ? ");			
			params.add(inventoryPo.getCstifinanceauditdate());
		}
		
		//发票类型
		if (!"".equals(Utility.getName(inventoryPo.getInvoiceType()))) {
			buffer.append("and L_I_I_InvoiceType = ? ");			
			params.add(inventoryPo.getInvoiceType());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), L_I_I_Date, 23) >= ? ");
			buffer.append("and convert(varchar(10), L_I_I_Date, 23) <= ? ");

			params.add(inventoryPo.getCstistartTime());
			params.add(inventoryPo.getCstiendTime());
		} else if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& "".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), L_I_I_Date, 23) >= ? ");

			params.add(inventoryPo.getCstistartTime());
		} else if ("".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), L_I_I_Date, 23) <= ? ");

			params.add(inventoryPo.getCstiendTime());
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryPo.class);
	}
	
	
	
	/**
	 * 得到冲回信息数量
	 * @param 
	 * @return
	 */
	public int getSelectReversal(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(id) from (");
		buffer.append("select L_I_R_ID as id,substring((select top 1 L_IE_RE_BillID from L_RE_ReversalEntry where L_IE_RE_InvoiceID=L_I_R_ID),2,1) as typeid ");
		buffer.append("from L_R_Reversal ");
		buffer.append("inner join B_Supplier ");
		buffer.append("on B_Supplier.B_SP_ID = L_R_Reversal.L_I_R_SupplierID ");
		buffer.append("where L_I_R_isVoucher = '0' ");
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {
			buffer.append("and L_I_R_ID like '%' + ? ");			
			params.add(inventoryPo.getCstibillid());
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append("and L_I_R_SupplierID = ? ");			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//核销状态
		if (!"".equals(Utility.getName(inventoryPo.getCstifinanceauditstate()))) {
			buffer.append("and L_I_R_AuditStatue = ? ");			
			params.add(inventoryPo.getCstifinanceauditstate());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), L_I_R_Date, 23) >= ? ");
			buffer.append("and convert(varchar(10), L_I_R_Date, 23) <= ? ");

			params.add(inventoryPo.getCstistartTime());
			params.add(inventoryPo.getCstiendTime());
		} else if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& "".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), L_I_R_Date, 23) >= ? ");

			params.add(inventoryPo.getCstistartTime());
		} else if ("".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), L_I_R_Date, 23) <= ? ");

			params.add(inventoryPo.getCstiendTime());
		}
		buffer.append(" ) temp ");
		//单据类型
		if (!"".equals(Utility.getName(inventoryPo.getCstibilltypeid()))) {
			if ("2".equals(Utility.getName(inventoryPo.getCstibilltypeid()))) {
				buffer.append("where typeid = 'o' ");
			}else{
				buffer.append("where typeid <> 'o' ");
			}
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	
	
	/**
	 * 查询冲回信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectReversal(InventoryPo inventoryPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");	
		buffer.append("select * from ( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by temp.cstibillid ) as rowNum, ");
		buffer.append("temp.cstibillid as cstibillid,temp.cstibilltypeid as cstibilltypeid,temp.cstisuppliername as cstisuppliername, ");
		buffer.append("temp.cstibilldate as cstibilldate,temp.cstifinanceauditstate as cstifinanceauditstate,temp.typeid as typeid from( ");		
		buffer.append("select L_I_R_ID as cstibillid , ");
		buffer.append("'冲回' as cstibilltypeid , ");
		buffer.append("B_SP_SupplierName as cstisuppliername , ");
		buffer.append("L_I_R_Date as cstibilldate , ");
		buffer.append("L_I_R_AuditStatue as cstifinanceauditstate, ");
		buffer.append("substring((select top 1 L_IE_RE_BillID from L_RE_ReversalEntry where L_IE_RE_InvoiceID=L_I_R_ID),2,1) as typeid ");
		buffer.append("from L_R_Reversal ");
		buffer.append("inner join B_Supplier ");
		buffer.append("on B_Supplier.B_SP_ID = L_R_Reversal.L_I_R_SupplierID ");
		buffer.append("where L_I_R_isVoucher = '0' ");
		
		//单据编号
		if (!"".equals(Utility.getName(inventoryPo.getCstibillid()))) {
			buffer.append("and L_I_R_ID like '%' + ? ");			
			params.add(inventoryPo.getCstibillid());
		}
		
		//制造商
		if (!"".equals(Utility.getName(inventoryPo.getCstisupplierid()))) {
			buffer.append("and L_I_R_SupplierID = ? ");			
			params.add(inventoryPo.getCstisupplierid());
		}
		
		//核销状态
		if (!"".equals(Utility.getName(inventoryPo.getCstifinanceauditstate()))) {
			buffer.append("and L_I_R_AuditStatue = ? ");			
			params.add(inventoryPo.getCstifinanceauditstate());
		}
		
		//单据日期
		if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), L_I_R_Date, 23) >= ? ");
			buffer.append("and convert(varchar(10), L_I_R_Date, 23) <= ? ");

			params.add(inventoryPo.getCstistartTime());
			params.add(inventoryPo.getCstiendTime());
		} else if (!"".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& "".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), L_I_R_Date, 23) >= ? ");

			params.add(inventoryPo.getCstistartTime());
		} else if ("".equals(Utility.getName(inventoryPo.getCstistartTime()))
				&& !"".equals(Utility.getName(inventoryPo.getCstiendTime()))) {
			
			buffer.append("and convert(varchar(10), L_I_R_Date, 23) <= ? ");

			params.add(inventoryPo.getCstiendTime());
		}
		buffer.append(" ) temp ");
		//单据类型
		if (!"".equals(Utility.getName(inventoryPo.getCstibilltypeid()))) {
			if ("2".equals(Utility.getName(inventoryPo.getCstibilltypeid()))) {
				buffer.append("where typeid = 'o' ");
			}else{
				buffer.append("where typeid <> 'o' ");
			}
		}
		buffer.append(" ) temp2 where rowNum > " + start + " and rowNum <= "	+ countPage);

		buffer.append(" set rowcount 0");
		
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
		
		buffer.append("select top 1  C_ST_I_BillID as cstibillid , ");
		buffer.append("C_ST_I_billDate as cstibilldate , ");
		if ("3".equals(Utility.getName(inventoryPo.getCstibilltypeid()))){
			buffer.append(" B_DP_DepartmentName as cstidepartmentname, ");	
		}else{
			buffer.append("B_SP_SupplierName as cstisuppliername , ");		
		}	
		buffer.append("C_ST_I_BillTypeId as cstibilltypeid , ");
		buffer.append("ins.B_WH_warehouseName as cstiinstockid , ");
		buffer.append("outs.B_WH_warehouseName as cstioutstockid , ");
		buffer.append("c.personName as csticreateperson , ");
		buffer.append("a.personName as cstiauditperson , ");
		buffer.append("C_ST_I_Remark as cstiremark ");
		buffer.append("from C_ST_Inventory ");
		if ("3".equals(Utility.getName(inventoryPo.getCstibilltypeid()))){
			buffer.append(" inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");	
		}else{
			buffer.append("inner join B_Supplier on B_Supplier.B_SP_ID = C_ST_Inventory.C_ST_I_SupplierId ");
		}		
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
	 * 详细开窗表体数量
	 * @param inventoryEntryPo
	 * @return
	 */
	public int getBillEntryCount(InventoryEntryPo inventoryEntryPo) {
		// TODO Auto-generated method stub
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(C_ST_IE_GoodsId) ");
		buffer.append("from C_ST_InventoryEntry ");
		buffer.append("where C_ST_IE_BillID = ? ");
		
		params.add(inventoryEntryPo.getCstiebillid());
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	

	/**
	 * 详细开窗表体
	 * @param inventoryEntryPo
	 * @return
	 */
	public List<InventoryEntryPo> getBillEntry(InventoryEntryPo inventoryEntryPo , int start , int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by C_ST_IE_GoodsId ) as rowNum, ");
		
		buffer.append("C_ST_IE_GoodsId as cstiegoodsid , ");
		buffer.append("B_GI_ViewGoodsName as cstiegoodsname , ");
		buffer.append("B_GI_Spec as cstiespec , ");
		buffer.append("B_GI_Sph as cstiesph , ");
		buffer.append("B_GI_Cyl as cstiecyl , ");
		buffer.append("B_GI_Color as cstiecolor , ");
		buffer.append("C_ST_IE_GoodsQuantity as cstiegoodsquantity , ");
		buffer.append("C_ST_IE_checkquantity as cstiecheckgoodsquantity , ");
		buffer.append("(isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0)) as cstieprovisionalnum , ");
		buffer.append("C_ST_IE_InvoiceState as cstieinvoicestate, ");
		buffer.append("C_ST_IE_NotTaxRateAmount as cstienottaxrateamount , ");
		buffer.append("C_ST_IE_TaxAmount as cstietaxamount , ");
		buffer.append("C_ST_IE_CostPriceAmount as cstiecostpriceamount ");
		
		buffer.append("from C_ST_InventoryEntry ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId ");
		buffer.append("where C_ST_IE_BillID = ? ");
		
		params.add(inventoryEntryPo.getCstiebillid());
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryEntryPo.class);
	}
	public List<InventoryEntryPo> getBillEntry(InventoryEntryPo inventoryEntryPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append("select * from( ");		
		buffer.append("select C_ST_IE_GoodsId as cstiegoodsid , ");
		buffer.append("B_GI_ViewGoodsName as cstiegoodsname , ");
		buffer.append("B_GI_Spec as cstiespec , ");
		buffer.append("B_GI_Sph as cstiesph , ");
		buffer.append("B_GI_Cyl as cstiecyl , ");
		buffer.append("B_GI_Color as cstiecolor , ");
		buffer.append("C_ST_IE_GoodsQuantity as cstiegoodsquantity , ");
		buffer.append("C_ST_IE_checkquantity as cstiecheckgoodsquantity , ");
		buffer.append("(isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0)) as cstieprovisionalnum , ");
		buffer.append("C_ST_IE_InvoiceState as cstieinvoicestate, ");
		buffer.append("C_ST_IE_NotTaxRateAmount as cstienottaxrateamount , ");
		buffer.append("C_ST_IE_TaxAmount as cstietaxamount , ");
		buffer.append("C_ST_IE_CostPriceAmount as cstiecostpriceamount ");
		
		buffer.append("from C_ST_InventoryEntry ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId ");
		buffer.append("where C_ST_IE_BillID = ? ");
		
		params.add(inventoryEntryPo.getCstiebillid());
		
		buffer.append(" ) temp");
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryEntryPo.class);
	}
	
	
	
	/**
	 * 详细发票表头
	 * @param inventoryPo
	 * @return
	 */
	public InventoryPo getInvoice(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1  L_I_I_ID as cstibillid , ");
		buffer.append("L_I_I_Date as cstibilldate , ");
		buffer.append("B_SP_SupplierName as cstisuppliername , ");
		buffer.append("'发票' as cstibilltypeid , ");
		buffer.append("c.personName as csticreateperson , ");
		buffer.append("a.personName as cstiauditperson , ");
		buffer.append("L_I_I_Remark as cstiremark ");
		buffer.append("from L_I_Invoice ");
		buffer.append("inner join B_Supplier ");
		buffer.append("on B_Supplier.B_SP_ID = L_I_Invoice.L_I_I_SupplierID ");
		buffer.append("left join SYS_PersonInfo c ");
		buffer.append("on c.ID = L_I_Invoice.L_I_I_CreatePersonID ");
		buffer.append("left join SYS_PersonInfo a ");
		buffer.append("on a.ID = L_I_Invoice.L_I_I_AuditPersonID ");
		buffer.append("where L_I_I_ID = ? ");
		
		params.add(inventoryPo.getCstibillid());
		
		return (InventoryPo) queryForObject(buffer.toString() , params.toArray() , InventoryPo.class);
	}
	
	
	/**
	 * 详细发票表体数量
	 * @param inventoryEntryPo
	 * @return
	 */
	public int getInvoiceEntryCount(InventoryEntryPo inventoryEntryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(L_IE_IE_GoodsID) ");
		buffer.append("from L_IE_InvoiceEntry ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = L_IE_InvoiceEntry.L_IE_IE_GoodsID ");
		buffer.append("inner join L_I_Invoice ");
		buffer.append("on L_I_Invoice.L_I_I_ID = L_IE_InvoiceEntry.L_IE_IE_InvoiceID ");
		buffer.append("where L_IE_IE_InvoiceID = ? ");
		
		params.add(inventoryEntryPo.getCstiebillid());
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 详细发票表体
	 * @param inventoryEntryPo
	 * @return
	 */
	public List<InventoryEntryPo> getInvoiceEntry(InventoryEntryPo inventoryEntryPo , int start , int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by L_IE_IE_GoodsID ) as rowNum, ");
		
		buffer.append("L_IE_IE_GoodsID as cstiegoodsid , ");
		buffer.append("L_IE_IE_GoodsName as cstiegoodsname , ");
		buffer.append("L_IE_IE_Spec as cstiespec , ");
		buffer.append("B_GI_Sph as cstiesph , ");
		buffer.append("B_GI_Cyl as cstiecyl , ");
		buffer.append("B_GI_Color as cstiecolor , ");
		buffer.append("L_IE_IE_GoodsQuantity as cstiegoodsquantity , ");
		buffer.append("L_IE_IE_CheckGoodsQuantity as cstiecheckgoodsquantity , ");
		buffer.append("(isnull(L_IE_IE_GoodsQuantity , 0)-isnull(L_IE_IE_CheckGoodsQuantity , 0)) as cstieprovisionalnum , ");
		buffer.append("L_I_I_AuditStatue as cstieinvoicestate ");
		buffer.append("from L_IE_InvoiceEntry ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = L_IE_InvoiceEntry.L_IE_IE_GoodsID ");
		buffer.append("inner join L_I_Invoice ");
		buffer.append("on L_I_Invoice.L_I_I_ID = L_IE_InvoiceEntry.L_IE_IE_InvoiceID ");
		buffer.append("where L_IE_IE_InvoiceID = ? ");
		
		params.add(inventoryEntryPo.getCstiebillid());
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryEntryPo.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<InventoryEntryPo> getInvoiceEntry(InventoryEntryPo inventoryEntryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();		
		
		buffer.append("select * from( ");		
		buffer.append("select L_IE_IE_BillID as cstiebillid,L_IE_IE_GoodsID as cstiegoodsid , ");
		buffer.append("L_IE_IE_GoodsName as cstiegoodsname , ");
		buffer.append("L_IE_IE_Spec as cstiespec , ");
		buffer.append("B_GI_Sph as cstiesph , ");
		buffer.append("B_GI_Cyl as cstiecyl , ");
		buffer.append("B_GI_Color as cstiecolor , ");
		buffer.append("L_IE_IE_GoodsQuantity as cstiegoodsquantity , ");
		buffer.append("L_IE_IE_CheckGoodsQuantity as cstiecheckgoodsquantity , ");
		buffer.append("(isnull(L_IE_IE_GoodsQuantity , 0)-isnull(L_IE_IE_CheckGoodsQuantity , 0)) as cstieprovisionalnum , ");
		buffer.append("L_IE_IE_NotTaxRateAmount as cstienottaxrateamount , ");
		buffer.append("L_IE_IE_TaxAmount as cstietaxamount , ");
		buffer.append("L_IE_IE_CostPriceAmount as cstiecostpriceamount , ");
		buffer.append("L_I_I_AuditStatue as cstieinvoicestate ");
		buffer.append("from L_IE_InvoiceEntry ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = L_IE_InvoiceEntry.L_IE_IE_GoodsID ");
		buffer.append("inner join L_I_Invoice ");
		buffer.append("on L_I_Invoice.L_I_I_ID = L_IE_InvoiceEntry.L_IE_IE_InvoiceID ");
		buffer.append("where L_IE_IE_InvoiceID = ? ");
		
		params.add(inventoryEntryPo.getCstiebillid());		
		buffer.append(" ) temp ");
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryEntryPo.class);
	}	
	
	
	/**
	 * 详细冲回表头
	 * @param inventoryPo
	 * @return
	 */
	public InventoryPo getReversal(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1  L_I_R_ID as cstibillid , ");
		buffer.append("L_I_R_Date as cstibilldate , ");
		buffer.append("B_SP_SupplierName as cstisuppliername , ");
		buffer.append("'冲回' as cstibilltypeid , ");
		buffer.append("c.personName as csticreateperson , ");
		buffer.append("a.personName as cstiauditperson , ");
		buffer.append("L_I_R_Remark as cstiremark ");
		buffer.append("from L_R_Reversal ");
		buffer.append("inner join B_Supplier ");
		buffer.append("on B_Supplier.B_SP_ID = L_R_Reversal.L_I_R_SupplierID ");
		buffer.append("left join SYS_PersonInfo c ");
		buffer.append("on c.ID = L_R_Reversal.L_I_R_CreatePersonID ");
		buffer.append("left join SYS_PersonInfo a ");
		buffer.append("on a.ID = L_R_Reversal.L_I_R_AuditPersonID ");
		buffer.append("where L_I_R_ID = ? ");
		
		params.add(inventoryPo.getCstibillid());
		
		return (InventoryPo) queryForObject(buffer.toString() , params.toArray() , InventoryPo.class);
	}
	
	
	/**
	 * 详细冲回表体数量
	 * @param inventoryEntryPo
	 * @return
	 */
	public int getReversalEntryCount(InventoryEntryPo inventoryEntryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(L_IE_RE_GoodsID) ");
		buffer.append("from L_RE_ReversalEntry ");
		buffer.append("inner join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = L_RE_ReversalEntry.L_IE_RE_GoodsID ");
		buffer.append("inner join L_R_Reversal ");
		buffer.append("on L_R_Reversal.L_I_R_ID = L_RE_ReversalEntry.L_IE_RE_InvoiceID ");
		buffer.append("where L_IE_RE_InvoiceID = ? ");
		
		params.add(inventoryEntryPo.getCstiebillid());
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 详细冲回表体
	 * @param inventoryEntryPo
	 * @return
	 */
	public List<InventoryEntryPo> getReversalEntry(InventoryEntryPo inventoryEntryPo , int start , int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by L_IE_RE_GoodsID ) as rowNum, ");
		
		buffer.append("L_IE_RE_GoodsID as cstiegoodsid , ");
		buffer.append("L_IE_RE_GoodsName as cstiegoodsname , ");
		buffer.append("L_IE_RE_Spec as cstiespec , ");
		buffer.append("B_GI_Sph as cstiesph , ");
		buffer.append("B_GI_Cyl as cstiecyl , ");
		buffer.append("B_GI_Color as cstiecolor , ");
		buffer.append("L_IE_RE_GoodsQuantity as cstiegoodsquantity , ");
		buffer.append("L_IE_RE_CheckGoodsQuantity as cstiecheckgoodsquantity , ");
		buffer.append("(isnull(L_IE_RE_GoodsQuantity , 0)-isnull(L_IE_RE_CheckGoodsQuantity , 0)) as cstieprovisionalnum , ");
		buffer.append("L_I_R_AuditStatue as cstieinvoicestate ");
		buffer.append("from L_RE_ReversalEntry ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = L_RE_ReversalEntry.L_IE_RE_GoodsID ");
		buffer.append("inner join L_R_Reversal ");
		buffer.append("on L_R_Reversal.L_I_R_ID = L_RE_ReversalEntry.L_IE_RE_InvoiceID ");
		buffer.append("where L_IE_RE_InvoiceID = ? ");
		
		params.add(inventoryEntryPo.getCstiebillid());
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryEntryPo.class);
	}
	public List<InventoryEntryPo> getReversalEntry(InventoryEntryPo inventoryEntryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from( ");
		buffer.append("select L_IE_RE_BillID as cstiebillid,L_IE_RE_GoodsID as cstiegoodsid , ");
		buffer.append("L_IE_RE_GoodsName as cstiegoodsname , ");
		buffer.append("L_IE_RE_Spec as cstiespec , ");
		buffer.append("B_GI_Sph as cstiesph , ");
		buffer.append("B_GI_Cyl as cstiecyl , ");
		buffer.append("B_GI_Color as cstiecolor , ");
		buffer.append("L_IE_RE_GoodsQuantity as cstiegoodsquantity , ");
		buffer.append("L_IE_RE_CheckGoodsQuantity as cstiecheckgoodsquantity , ");
		buffer.append("(isnull(L_IE_RE_GoodsQuantity , 0)-isnull(L_IE_RE_CheckGoodsQuantity , 0)) as cstieprovisionalnum , ");
		buffer.append("L_IE_RE_NotTaxRateAmount as cstienottaxrateamount , ");
		buffer.append("L_IE_RE_TaxAmount as cstietaxamount , ");
		buffer.append("L_IE_RE_CostPriceAmount as cstiecostpriceamount , ");
		buffer.append("L_I_R_AuditStatue as cstieinvoicestate ");
		buffer.append("from L_RE_ReversalEntry ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = L_RE_ReversalEntry.L_IE_RE_GoodsID ");
		buffer.append("inner join L_R_Reversal ");
		buffer.append("on L_R_Reversal.L_I_R_ID = L_RE_ReversalEntry.L_IE_RE_InvoiceID ");
		buffer.append("where L_IE_RE_InvoiceID = ? ");
		
		params.add(inventoryEntryPo.getCstiebillid());
		
		buffer.append(" ) temp ");
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryEntryPo.class);
	}
	
	

	/**
	 * 得到明细商品信息
	 * @param inventoryPo
	 * @return
	 */
	public List<InventoryEntryPo> getBillGoods(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select C_ST_IE_BillID as cstiebillid , ");
		buffer.append("C_ST_IE_GoodsId as cstiegoodsid , ");
		buffer.append("B_GI_ViewGoodsName as cstiegoodsname , ");
		buffer.append("B_GI_Spec as cstiespec , ");
		buffer.append("(isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0)) as cstiegoodsquantity , ");
		buffer.append("(isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0)) as cstiecheckgoodsquantity , ");
		buffer.append("C_ST_IE_NotTaxRate as cstienottaxrate , ");
		buffer.append("C_ST_IE_NotTaxRateAmount as cstienottaxrateamount , ");
		buffer.append("C_ST_IE_TaxRate as cstietaxrate , ");
		buffer.append("C_ST_IE_CostPrice as cstiecostprice , ");
		buffer.append("C_ST_IE_TaxAmount as cstietaxamount , ");
		buffer.append("C_ST_IE_CostPriceAmount as cstiecostpriceamount ");
		buffer.append("from C_ST_InventoryEntry ");
		buffer.append("inner join C_ST_Inventory ");
		buffer.append("on C_ST_Inventory.C_ST_I_BillID = C_ST_InventoryEntry.C_ST_IE_BillID ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId ");
		buffer.append("where C_ST_I_BillID = ? ");
		
		params.add(inventoryPo.getCstibillid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryEntryPo.class);
	}
	
	

	/**
	 * 得到发票明细商品信息
	 * @param inventoryPo
	 * @return
	 */
	public List<InventoryEntryPo> getInvoiceGoods(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select L_IE_IE_InvoiceID as cstibillid , ");
		buffer.append("	L_IE_IE_GoodsID as cstiegoodsid , ");
		buffer.append("	L_IE_IE_GoodsName as cstiegoodsname , ");
		buffer.append("	L_IE_IE_Spec as cstiespec , ");
		buffer.append("	(isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0)) as cstiegoodsquantity , ");
		buffer.append("	(isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0)) as cstiecheckgoodsquantity , ");
		buffer.append("	L_IE_IE_NotTaxRate as cstienottaxrate , ");
		buffer.append("	L_IE_IE_NotTaxRateAmount as cstienottaxrateamount , ");
		buffer.append("	L_IE_IE_CostPrice as cstiecostprice , ");
		buffer.append("	L_IE_IE_TaxAmount as cstietaxamount , ");
		buffer.append("	L_IE_IE_CostPriceAmount as cstiecostpriceamount ");
		buffer.append("from L_IE_InvoiceEntry ");
		buffer.append("inner join L_I_Invoice ");
		buffer.append("	on L_I_Invoice.L_I_I_ID = L_IE_InvoiceEntry.L_IE_IE_InvoiceID ");
		buffer.append("where L_I_I_AuditStatue = '1' and L_I_I_isVoucher = '0' and L_IE_IE_InvoiceID = ? ");
		
		params.add(inventoryPo.getCstibillid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryEntryPo.class);
	}


	

	/**
	 * 得到冲回明细商品信息
	 * @param inventoryPo
	 * @return
	 */
	public List<InventoryEntryPo> getReversalGoods(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select L_IE_RE_InvoiceID as cstibillid , ");
		buffer.append("	L_IE_RE_GoodsID as cstiegoodsid , ");
		buffer.append("	L_IE_RE_GoodsName as cstiegoodsname , ");
		buffer.append("	L_IE_RE_Spec as cstiespec , ");
		buffer.append("	(isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0)) as cstiegoodsquantity , ");
		buffer.append("	(isnull(C_ST_IE_GoodsQuantity , 0)-isnull(C_ST_IE_checkquantity , 0)) as cstiecheckgoodsquantity , ");
		buffer.append("	L_IE_RE_NotTaxRate as cstienottaxrate , ");
		buffer.append("	L_IE_RE_NotTaxRateAmount as cstienottaxrateamount , ");
		buffer.append("	L_IE_RE_CostPrice as cstiecostprice , ");
		buffer.append("	L_IE_RE_TaxAmount as cstietaxamount , ");
		buffer.append("	L_IE_RE_CostPriceAmount as cstiecostpriceamount ");
		buffer.append("from L_RE_ReversalEntry ");
		buffer.append("inner join L_R_Reversal ");
		buffer.append("	on L_R_Reversal.L_I_R_ID = L_RE_ReversalEntry.L_IE_RE_InvoiceID ");
		buffer.append("where L_I_R_AuditStatue = '1' and L_I_R_isVoucher = '0' and L_IE_RE_InvoiceID = ? ");
		
		params.add(inventoryPo.getCstibillid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryEntryPo.class);
	}
	
	
	/**
	 * 得到盘盈盘亏数量
	 */
	public int getOveragelossesCount(InventoryPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(C_ST_I_BillID) from C_ST_Inventory ");
		buffer.append("where C_ST_I_AuditState = '1' ");
		buffer.append("and isnull(C_ST_I_VoucherType , '0') = '0' ");

		// 单据编号
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			buffer.append("and C_ST_I_BillID = ? ");
			params.add(po.getCstibillid());
		}

		// 单据源编号
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			buffer.append("and C_ST_I_SourceBillId= ? ");
			params.add(po.getCstisourcebillid());
		}

		// 单据类型 5：盘盈 6：盘亏
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			buffer.append("and C_ST_I_BillTypeId= ? ");
			params.add(po.getCstibilltypeid());
		} else {
			buffer.append("and C_ST_I_BillTypeId IN (5,6) ");
		}
		// 出入库仓位
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			buffer.append("and ? IN (C_ST_I_InStockId , C_ST_I_OutStockId) ");
			params.add(po.getCstiinstockid());
		}

//		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
//			buffer.append("and C_ST_I_AuditState = ? ");
//			params.add(po.getCstiauditstate());
//		}

		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");

			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());

		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());

		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");

			params.add(po.getCstiendTime());
		}

		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			buffer.append("and C_ST_I_AuditPerson = ? ");
			params.add(po.getCstiauditperson());
		}

		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			buffer.append("and C_ST_I_createPerson = ? ");
			params.add(po.getCsticreateperson());
		}

		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}

	
	/**
	 * 得到盘盈盘亏List
	 */
	public List<InventoryPo> getOveragelossesList(InventoryPo po, int start, int size) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over(order by C_ST_I_billDate desc,C_ST_I_BillID desc) as rowNum,C_ST_I_BillID as cstibillid,C_ST_I_SourceBillId as cstisourcebillid,C_ST_I_BillTypeId as cstibilltypeid,");
		buffer.append("C_ST_I_billDate as cstibilldate,C_ST_I_AuditDate as cstiauditdate,InWarehouse.B_WH_warehouseName as cstiinstockname,OutWarehouse.B_WH_warehouseName as cstioutstockname,");
		buffer.append("C_ST_I_AuditState as cstiauditstate,a.personName as csticreatepersonname,b.personName as cstiauditpersonname from C_ST_Inventory ");
		buffer.append("left join B_Warehouse InWarehouse on C_ST_I_InStockId=InWarehouse.B_WH_ID ");
		buffer.append("left join B_Warehouse OutWarehouse on C_ST_I_OutStockId=OutWarehouse.B_WH_ID ");
		buffer.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_I_createPerson=a.ID ");
		buffer.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_AuditPerson=b.ID ");
		buffer.append("where C_ST_I_AuditState = '1' ");
		buffer.append("and isnull(C_ST_I_VoucherType , '0') = '0' ");

		// 单据编号
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			buffer.append("and C_ST_I_BillID = ? ");
			params.add(po.getCstibillid());
		}

		// 单据源编号
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			buffer.append("and C_ST_I_SourceBillId= ? ");
			params.add(po.getCstisourcebillid());
		}

		// 单据类型 5：盘盈 6：盘亏
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			buffer.append("and C_ST_I_BillTypeId= ? ");
			params.add(po.getCstibilltypeid());
		} else {
			buffer.append("and C_ST_I_BillTypeId IN (5,6) ");
		}
		// 出入库仓位
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			buffer.append("and ? IN (C_ST_I_InStockId , C_ST_I_OutStockId) ");
			params.add(po.getCstiinstockid());
		}

//		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
//			buffer.append("and C_ST_I_AuditState = ? ");
//			params.add(po.getCstiauditstate());
//		}

		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");

			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());

		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());

		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			buffer.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");

			params.add(po.getCstiendTime());
		}
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),InventoryPo.class);
	}
	
	
	/**
	 * 得到盘盈盘亏
	 * 
	 * @param po
	 * @return
	 */
	public InventoryPo getOveragelosses(InventoryPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  C_ST_I_BillID as cstibillid,C_ST_I_BillTypeId as cstibilltypeid");
		sb.append(",C_ST_I_SourceBillId as cstisourcebillid,C_ST_I_billDate as cstibilldate,");
		sb.append("C_ST_I_InStockId as cstiinstockid,instock.B_WH_warehouseName as cstiinstockname,");
		sb.append("C_ST_I_outStockId as cstioutstockid,outstock.B_WH_warehouseName as cstioutstockname,");
		sb.append("B_DP_DepartmentName as cstidepartmentname, ");
		sb.append("C_ST_I_GoodsCategory as cstigoodscategory,C_ST_I_SupplierId as cstisupplierid,C_ST_I_PurchseWayId as cstipurchsewayid,C_ST_I_DayLimit as cstidaylimit,");
		sb.append("C_ST_I_DepartmentId as cstidepartmentid,C_ST_I_createPerson as csticreateperson,C_ST_I_AuditPerson as cstiauditperson,a.personName as csticreatepersonname,b.personName as cstiauditpersonname,C_ST_I_AuditState as cstiauditstate,");
		sb.append("C_ST_I_AuditDate as cstiauditdate,C_ST_I_Remark as cstiremark from C_ST_Inventory ");
		sb.append("left join B_Warehouse instock on C_ST_Inventory.C_ST_I_InStockId=instock.B_WH_ID ");
		sb.append("left join B_Warehouse outstock on C_ST_Inventory.C_ST_I_outStockId=outstock.B_WH_ID ");
		sb.append("inner join B_Departments ON C_ST_I_DepartmentId = B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID ");
		sb.append("where C_ST_I_BillID= ? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		return (InventoryPo) queryForObject(sb.toString(), params.toArray(),InventoryPo.class);
	}
	
	
	/**
	 * 盘盈盘亏明细总数
	 * 
	 * @param inventoryPo
	 * @return
	 */
	public int getOveragelossesEntryCount(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		buffer.append("SELECT count(C_ST_IE_BillID) ");
		buffer.append("FROM C_ST_InventoryEntry  ");
		buffer.append("WHERE C_ST_IE_BillID= ? ");

		List<String> params = new ArrayList<String>();
		params.add(inventoryPo.getCstibillid());

		return this.getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * 盘盈盘亏明细分页
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryEntryPo> getOveragelossesEntryList(InventoryPo po,	int start, int size) {

		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by C_ST_IE_GoodsId ) as 'rowNum', ");
		buffer.append(" C_ST_IE_BillID as cstiebillid ");
		buffer.append(", C_ST_IE_GoodsId as cstiegoodsid ");
		buffer.append(", C_ST_IE_GoodsQuantity as cstiegoodsquantity ");
		buffer.append(", C_ST_IE_NotTaxRate as cstienottaxrate ");
		buffer.append(", C_ST_IE_NotTaxRateAmount as cstienottaxrateamount ");
		buffer.append(", C_ST_IE_BarCode as cstiebarcode ");
		buffer.append(", C_ST_IE_WarehousingDate as cstiewarehousingdate ");
		buffer.append(", C_ST_IE_Remark as cstieremark");
		buffer.append(", B_GI_ViewGoodsName as cstiegoodsname ");
		buffer.append(", B_GI_Spec as cstiespec ");
		buffer.append(", B_UT_unitName as cstieunitname ");
		buffer.append("FROM C_ST_InventoryEntry  ");
		buffer.append("left JOIN  ");
		buffer.append("B_GoodsInfo ON C_ST_IE_GoodsId = B_GI_GoodsID ");
		buffer.append("left JOIN ");
		buffer.append("B_Unit ON B_GI_UnitId = B_UT_id ");
		buffer.append("where C_ST_IE_BillID= ? ");
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		return queryForObjectList(buffer.toString(), params.toArray(),InventoryEntryPo.class);
	}

	/**
	 * 得到仓位List
	 * @param warehousePo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WarehousePo> getWarehouseList(WarehousePo warehousePo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select B_WH_ID as bwhid , ");
		buffer.append("B_WH_warehouseName as bwhwarehouseName, B_WH_IsClosed as bwhisclosed ");
		buffer.append("from B_Warehouse ");
		
		return queryForObjectList(buffer.toString() , null , WarehousePo.class);
	}
	@SuppressWarnings("unchecked")
	public List<WarehousePo> getWarehouseList(){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select B_WH_ID as bwhid ,B_WH_warehouseName as bwhwarehouseName from B_Warehouse where B_WH_deptID in ( ");
		buffer.append("  select B_DP_DepartmentID from B_Departments where B_DP_Type='1' ) ");
		
		return queryForObjectList(buffer.toString() , null , WarehousePo.class);
	}
}
