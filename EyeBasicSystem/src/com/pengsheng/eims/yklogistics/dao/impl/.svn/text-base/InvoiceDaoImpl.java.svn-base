package com.pengsheng.eims.yklogistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.yklogistics.dao.InvoiceDao;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.logistics.persistence.InvoiceTypePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class InvoiceDaoImpl extends BaseJdbcDaoSupport implements InvoiceDao {


	public void deleteInvoice(InvoicePo invoicePo) {
	}
	
    /**
     * 查询发票总数
     */
	public int getInvoiceCount(InvoicePo invoicePo) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(L_I_I_ID) from L_I_Invoice where 1=1 ");
		List<String> params = new ArrayList<String>();
		if(!Utility.getName(invoicePo.getLiitypeName()).equals("")){
			sb.append("and L_I_I_InvoiceType=? ");
			params.add(Utility.getName(invoicePo.getLiitypeName()));
		}
		if(!Utility.getName(invoicePo.getLiiauditstatue()).equals("")){
			sb.append("and L_I_I_AuditStatue=? ");
			params.add(Utility.getName(invoicePo.getLiiauditstatue()));
		}
		if(!Utility.getName(invoicePo.getLiisupplierid()).equals("")){
			sb.append("and L_I_I_SupplierID=? ");
			params.add(Utility.getName(invoicePo.getLiisupplierid()));
		}
		if(!Utility.getName(invoicePo.getLiicreatepersonid()).equals("")){
			sb.append("and L_I_I_CreatePersonID=? ");
			params.add(Utility.getName(invoicePo.getLiicreatepersonid()));
		}
		if(!Utility.getName(invoicePo.getLiiid()).equals("")){
			sb.append("and L_I_I_ID like '%'+?+'%' ");//quyanping
			params.add(Utility.getName(invoicePo.getLiiid()));
		}
		if(!"".equals(Utility.getName(invoicePo.getLiistartauditdate()))){
			sb.append(" and convert(varchar(10),L_I_I_AuditDate,120)>=? ");
			params.add(Utility.getName(invoicePo.getLiistartauditdate()));
		}	
		if(!"".equals(Utility.getName(invoicePo.getLiiendauditdate()))){
			sb.append(" and  convert(varchar(10),L_I_I_AuditDate,120)<=? ");
			params.add(Utility.getName(invoicePo.getLiiendauditdate()));
		}	
		if(!"".equals(Utility.getName(invoicePo.getLiistartdate()))){
			sb.append("and convert(varchar(10),L_I_I_Date,120)>=? ");
			params.add(Utility.getName(invoicePo.getLiistartdate()));
		}
		if(!"".equals(Utility.getName(invoicePo.getLiienddate()))){
			sb.append("and  convert(varchar(10),L_I_I_Date,120)<=? ");
			params.add(Utility.getName(invoicePo.getLiienddate()));
		}
	
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

    /**
     * 查询发票
     */
	@SuppressWarnings("unchecked")
	public List<InvoicePo> getInvoiceList(InvoicePo invoicePo,int start,int size) {
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT * FROM (SELECT ROW_NUMBER() Over(ORDER BY L_I_I_Date desc) AS ROWNUMBER,L_I_I_ID AS liiid,L_I_I_SupplierID AS liisupplierid,");
		sb.append("(SELECT B_SP_SupplierName FROM B_SUPPLIER WHERE B_SP_ID=L_I_I_SupplierID) AS liidepartmentname,L_I_I_Date as liidate,L_I_I_AuditDate as liiauditdate,L_I_I_AuditStatue as liiauditstatue ");
		sb.append(",(select personName from SYS_PersonInfo where id=L_I_I_CreatePersonID) as liicreatepersonname,(select L_IT_Type from L_IT_InvoiceType where L_IT_ID=L_I_I_InvoiceType) as liitypeName FROM L_I_Invoice where 1=1  ");
		
		List<String> params = new ArrayList<String>();
		if(!Utility.getName(invoicePo.getLiitypeName()).equals("")){
			sb.append("and L_I_I_InvoiceType=? ");
			params.add(Utility.getName(invoicePo.getLiitypeName()));
		}
		if(!Utility.getName(invoicePo.getLiiauditstatue()).equals("")){
			sb.append("and L_I_I_AuditStatue=? ");
			params.add(Utility.getName(invoicePo.getLiiauditstatue()));
		}
		if(!Utility.getName(invoicePo.getLiisupplierid()).equals("")){
			sb.append("and L_I_I_SupplierID=? ");
			params.add(Utility.getName(invoicePo.getLiisupplierid()));
		}
		if(!Utility.getName(invoicePo.getLiicreatepersonid()).equals("")){
			sb.append("and L_I_I_CreatePersonID=? ");
			params.add(Utility.getName(invoicePo.getLiicreatepersonid()));
		}
		if(!Utility.getName(invoicePo.getLiiid()).equals("")){
			sb.append("and L_I_I_ID like '%'+?+'%' ");//quyanping
			params.add(Utility.getName(invoicePo.getLiiid()));
		}
		if(!"".equals(Utility.getName(invoicePo.getLiistartauditdate()))){
			sb.append(" and convert(varchar(10),L_I_I_AuditDate,120)>=? ");
			params.add(Utility.getName(invoicePo.getLiistartauditdate()));
		}
		if(!"".equals(Utility.getName(invoicePo.getLiiendauditdate()))){
			sb.append(" and  convert(varchar(10),L_I_I_AuditDate,120)<=? ");
			params.add(Utility.getName(invoicePo.getLiiendauditdate()));
		}
		if(!"".equals(Utility.getName(invoicePo.getLiistartdate()))){
			sb.append("and convert(varchar(10),L_I_I_Date,120)>=? ");
			params.add(Utility.getName(invoicePo.getLiistartdate()));
		}
		if(!"".equals(Utility.getName(invoicePo.getLiienddate()))){
			sb.append("and convert(varchar(10),L_I_I_Date,120)<=? ");
			params.add(Utility.getName(invoicePo.getLiienddate()));
		}
		
		sb.append(" ) temp where ROWNUMBER > " + start + " and ROWNUMBER <= "
				+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), InvoicePo.class);
	}
	
	public InvoicePo getInvocePo(InvoicePo invoicePo) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT top 1  L_I_I_ID AS liiid,L_I_I_SupplierID AS liisupplierid,");
		sb.append("L_I_I_Date as liidate,L_I_I_AuditDate as liiauditdate,(SELECT B_SP_SupplierName FROM B_SUPPLIER WHERE B_SP_ID=L_I_I_SupplierID) AS liisuppliername,L_I_I_AuditStatue as liiauditstatue, ");
		sb.append("(select personname from sys_personinfo where id=L_I_I_CreatePersonID) liicreatepersonname,L_I_I_CreatePersonID as liicreatepersonid, (select personname from sys_personinfo where id=L_I_I_AuditPersonID) liiauditpersonName,(SELECT B_DP_DEPARTMENTNAME FROM B_DEPARTMENTS WHERE B_DP_DEPARTMENTID=L_I_I_DepartmentID) liidepartmentname,L_I_I_Remark as liiremark,L_IT_ID as liitypeID,L_IT_Type as liitypeName ");
		sb.append(" ,(case substring((select top 1 L_IE_IE_BillID from L_IE_InvoiceEntry where L_IE_IE_InvoiceID=?),2,1) when 'o' then 2 else 1 end ) as liiBillType ");
		sb.append(" FROM L_I_Invoice inner join L_IT_InvoiceType on L_I_I_InvoiceType=L_IT_ID where L_I_I_ID=?");
		List<String> params = new ArrayList<String>();
		params.add(invoicePo.getLiiid());
		params.add(invoicePo.getLiiid());
		return (InvoicePo) this.queryForObject(sb.toString(), params.toArray(),InvoicePo.class);
	}

	
	public int getInvoiceEntryCount(InvoiceEntryPo invoiceEntryPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT count(L_IE_IE_BillID) ");		
		sb.append("FROM L_Ie_Invoiceentry where L_IE_IE_InvoiceID=?");
		List<String> params = new ArrayList<String>();
		params.add(invoiceEntryPo.getLieieinvoiceid());
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public List<InvoiceEntryPo> getInvoiceEntryPoList(InvoiceEntryPo invoiceEntryPo,int start,int size) {

		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT temp.lieiebillid AS lieiebillid,temp.lieiegoodsid AS  lieiegoodsid,temp.lieiegoodsname AS lieiegoodsname,temp.lieiegoodsquantity AS lieiegoodsquantity,");
		sb.append("temp.lieiecheckgoodsquantity as lieiecheckgoodsquantity,temp.lieiecostpriceamount as lieiecostpriceamount ,");
		sb.append("temp.lieiespec as lieiespec,temp.lieienottaxrate as lieienottaxrate,temp.lieienottaxrateamount as lieienottaxrateamount, ");
		sb.append("temp.lieiecostprice as lieiecostprice,temp.lieietaxamount as lieietaxamount,lieietaxrate as lieietaxrate from (");
		
		sb.append("SELECT ROW_NUMBER() Over(ORDER BY L_IE_IE_BillID) AS ROWNUMBER,L_IE_IE_BillID AS lieiebillid,L_IE_IE_GoodsID AS  lieiegoodsid,L_IE_IE_GoodsName AS lieiegoodsname,L_IE_IE_GoodsQuantity AS lieiegoodsquantity,");
		sb.append("L_IE_IE_CheckGoodsQuantity as lieiecheckgoodsquantity,L_IE_IE_CostPriceAmount as lieiecostpriceamount ,");
		sb.append("l_ie_ie_spec as lieiespec,l_ie_ie_nottaxrate as lieienottaxrate,l_ie_ie_nottaxrateamount as lieienottaxrateamount, ");
		sb.append("l_ie_ie_costprice as lieiecostprice,l_ie_ie_taxamount as lieietaxamount,L_IE_IE_Taxrate as lieietaxrate ");
		sb.append("FROM L_Ie_Invoiceentry where L_IE_IE_InvoiceID=? ");
		sb.append(" ) temp where ROWNUMBER > " + start + " and ROWNUMBER <= "+ countPage);
		sb.append(" set rowcount 0");
		
		List<String> params = new ArrayList<String>();
		params.add(invoiceEntryPo.getLieieinvoiceid());
		
		return this.queryForObjectList(sb.toString(), params.toArray(),InvoiceEntryPo.class);
	}
	
	/**
	 * 模块：发票管理
	 * 描述：查询发票明细(未分页)
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceEntryPo> getInvoiceEntryPoList(InvoiceEntryPo invoiceEntryPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT L_IE_IE_BillID AS lieiebillid,L_IE_IE_GoodsID AS  lieiegoodsid,L_IE_IE_GoodsName AS lieiegoodsname,L_IE_IE_GoodsQuantity AS lieiegoodsquantity,");
		sb.append("L_IE_IE_CheckGoodsQuantity as lieiecheckgoodsquantity,L_IE_IE_CostPriceAmount as lieiecostpriceamount ,");
		sb.append("l_ie_ie_spec as lieiespec,l_ie_ie_nottaxrate as lieienottaxrate,l_ie_ie_nottaxrateamount as lieienottaxrateamount, ");
		sb.append("l_ie_ie_costprice as lieiecostprice,l_ie_ie_taxamount as lieietaxamount,L_IE_IE_Taxrate as lieietaxrate,L_IE_IE_UUID as lieieid ");
		sb.append("FROM L_Ie_Invoiceentry where L_IE_IE_InvoiceID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(invoiceEntryPo.getLieieinvoiceid());
		return queryForObjectList(sb.toString(), params.toArray(),InvoiceEntryPo.class);
	}
	
	/**
	 * 模块：发票管理
	 * 描述：查询要删除的发票的明细信息
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryEntryPo> getBillAndGoodidList(String invoiceID){
		StringBuffer sb = new StringBuffer();
		sb.append("select L_IE_IE_UUID as cstieid,L_IE_IE_BillID as cstiebillid,L_IE_IE_GoodsID as cstiegoodsid,-isnull(L_IE_IE_CheckGoodsQuantity,0) as cstiecheckgoodsquantity,dbo.getInvoiceState(L_IE_IE_UUID) as cstieinvoicestate from L_IE_InvoiceEntry ");
		sb.append(" where L_IE_IE_InvoiceID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(invoiceID);
		
		return queryForObjectList(sb.toString(), params.toArray(),InventoryEntryPo.class);
	}
	
	/**
	 * 模块：发票管理
	 * 描述：新增发票明细
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public void invoiceEntryInsert(InvoiceEntryPo invoiceEntryPo) {
		StringBuffer sb = new StringBuffer();
		 sb.append("insert into L_IE_InvoiceEntry(L_IE_IE_ID,  ");
		 sb.append("L_IE_IE_InvoiceID,                ");
		 sb.append("L_IE_IE_BillID,                ");
		 sb.append("L_IE_IE_GoodsID,                ");
		 sb.append("L_IE_IE_GoodsName,                ");
		 sb.append("L_IE_IE_Spec,                ");
		 sb.append("L_IE_IE_GoodsQuantity,                ");
		 sb.append("L_IE_IE_CheckGoodsQuantity,                ");
		 sb.append("L_IE_IE_NotTaxRate,                ");
		 sb.append("L_IE_IE_NotTaxRateAmount,                ");
		 sb.append("L_IE_IE_CostPrice,                ");
		 sb.append("L_IE_IE_TaxAmount,                ");
		 sb.append("L_IE_IE_CostPriceAmount,                ");
		 sb.append("L_IE_IE_isVoucher,               ");
		 sb.append("L_IE_IE_Taxrate,                ");
		 sb.append("L_IE_IE_UUID                ");
		 sb.append("    )values(replace(NEWID(),'-',''),?,?,?,?,?,?,?          ");
		 sb.append(",?,?,?,?,?,?,?,?)");
		 
		 List<String> params = new ArrayList<String>();
		 params.add (invoiceEntryPo.getLieieinvoiceid           ());
		 params.add (invoiceEntryPo.getLieiebillid              ());
		 params.add (invoiceEntryPo.getLieiegoodsid             ());
		 params.add (invoiceEntryPo.getLieiegoodsname           ());
		 params.add (invoiceEntryPo.getLieiespec                ());
		 params.add (invoiceEntryPo.getLieiegoodsquantity       ());
		 params.add (invoiceEntryPo.getLieiecheckgoodsquantity  ());
		 params.add (invoiceEntryPo.getLieienottaxrate          ());
		 params.add (invoiceEntryPo.getLieienottaxrateamount    ());
		 params.add (invoiceEntryPo.getLieiecostprice           ());
         params.add (invoiceEntryPo.getLieietaxamount           ());
         params.add (invoiceEntryPo.getLieiecostpriceamount     ());
         params.add ("0");
         params.add (Utility.getName(invoiceEntryPo.getLieietaxrate()));
         params.add (Utility.getName(invoiceEntryPo.getLieieid()));
          
         getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 模块：发票管理
	 * 描述：新增发票基本信息
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public void invoiceInsert(InvoicePo invoicePo) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into L_I_Invoice(L_I_I_ID,");
		sb.append("L_I_I_SupplierID      ,");
		sb.append("L_I_I_Date            ,");
		sb.append("L_I_I_DepartmentID    ,");
		sb.append("L_I_I_CreatePersonID  ,");
		sb.append("L_I_I_AuditStatue     ,");
		sb.append("L_I_I_isVoucher       ,");
		sb.append("L_I_I_Remark  ,");
		sb.append("L_I_I_InvoiceType  ");
		List<String> params = new ArrayList<String>();
		if("1".equals(invoicePo.getLiiauditstatue())){
			sb.append(",L_I_I_AuditPersonID,L_I_I_Auditdate ");
		}		
		if (!"".equals(Utility.getName(invoicePo.getLiidate()))){
			sb.append(") values(?,?,?,?,?,?,?,?,?");
		}else{
			sb.append(") values(?,?,getdate(),?,?,?,?,?,?");
		}
		
		params.add(Utility.getName(invoicePo.getLiiid()));
		params.add(Utility.getName(invoicePo.getLiisupplierid()));
		if (!"".equals(Utility.getName(invoicePo.getLiidate()))){
			params.add(Utility.getName(invoicePo.getLiidate()));
		}
		params.add(Utility.getName(invoicePo.getLiidepartmentid()));
		params.add(Utility.getName(invoicePo.getLiicreatepersonid()));
		params.add(Utility.getName(invoicePo.getLiiauditstatue()).equals("0")?"0":"1");
		params.add("0");
		params.add(Utility.getName(invoicePo.getLiiremark()));
		params.add(Utility.getName(invoicePo.getLiitypeID()));
		if("1".equals(Utility.getName(invoicePo.getLiiauditstatue()))){
			sb.append(",?,getdate()");
			params.add(Utility.getName(invoicePo.getLiiauditpersonid()));
		}
		sb.append(")");

		getJdbcTemplate().update(sb.toString(),params.toArray());
		
	}
//	public void invoiceUpdate(InvoicePo invoicePo){
//		StringBuffer sb = new StringBuffer();
//		sb.append("update L_I_Invoice set L_I_I_AuditStatue=?");
//		if("1".equals(invoicePo.getLiiauditstatue())){
//			sb.append(",L_I_I_AuditPersonID,L_I_I_Auditdate");
//		}
//		
//		List<String> params = new ArrayList<String>();
//		if("1".equals(invoicePo.getLiiauditstatue())){
//			sb.append(",?,getdate()");
//			params.add(invoicePo.getLiiauditpersonid());
//		}else{
//			params.add("0");
//		}
//		getJdbcTemplate().update(sb.toString(),params.toArray());
//	}
	
	public void invoiceDelete(String invoiceID) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("delete from L_I_Invoice where L_I_I_ID=?");
		List<String> params = new ArrayList<String>();
		params.add(invoiceID);
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	
	public void reversalDelete(String invoiceID) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("delete from L_R_Reversal where L_I_R_ID=replace(?,'I','R')");
		List<String> params = new ArrayList<String>();
		params.add(invoiceID);
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}


	public void invoiceEntryDelete(String invoiceID) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("delete from L_IE_InvoiceEntry where L_IE_IE_InvoiceID=?");
		List<String> params = new ArrayList<String>();
		params.add(invoiceID);
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}


	public void reversalEntryDelete(String invoiceID) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from L_Re_Reversalentry where L_IE_RE_InvoiceID=replace(?,'I','R')");
		List<String> params = new ArrayList<String>();
		params.add(invoiceID);
		getJdbcTemplate().update(sb.toString(),params.toArray());
		
	}
	
	public void reversalInsert(String invoiceID){
		StringBuffer sb = new StringBuffer();
		sb.append("insert into L_R_Reversal(L_I_R_ID,L_I_R_SupplierID,L_I_R_Date,L_I_R_DepartmentID,L_I_R_CreatePersonID,L_I_R_AuditStatue,L_I_R_AuditPersonID,L_I_R_AuditDate,L_I_R_isVoucher,L_I_R_VoucherDate,L_I_R_Remark,L_I_R_PaymentDay) ");
		sb.append(" select replace(L_I_I_ID,'I','R'),L_I_I_SupplierID,L_I_I_Date,L_I_I_DepartmentID,L_I_I_CreatePersonID,L_I_I_AuditStatue,L_I_I_AuditPersonID,L_I_I_AuditDate,L_I_I_isVoucher,L_I_I_VoucherDate,L_I_I_Remark,L_I_I_PaymentDay from L_I_Invoice where L_I_I_ID=?");
		List<String> params = new ArrayList<String>();
		params.add(invoiceID);
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void reversalEntryInsert(String invoiceID){		
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("exec [insertReversalEntry] ? ");
		params.add(invoiceID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void inventoryUpdate(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
//		StringBuffer sb = new StringBuffer();
//		sb.append("update c_st_inventory set C_ST_I_InvoiceState=? where C_ST_I_BillID=?");
//		List<String> params = new ArrayList<String>();
//		params.add(inventoryPo.getCstiinvoicestate());
//		params.add(inventoryPo.getCstibillid());
//		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 模块：发票管理
	 * 描述：修改业务单据的核销数量和核销状态
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public void inventoryEntryUpdate(InventoryEntryPo inventoryEntryPo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update c_st_inventoryentry set C_ST_Ie_InvoiceState=(case isnull(C_ST_Ie_checkquantity,0)+? when C_ST_IE_GoodsQuantity then 2 when 0 then 0 else 1 end), ");
		if ("".equals(Utility.getName(inventoryEntryPo.getIsupdate()))){
			sb.append("C_ST_Ie_checkquantity=isnull(C_ST_Ie_checkquantity,0)+? ");
		}else{
			sb.append("C_ST_Ie_checkquantity=? ");
		}
		sb.append("where C_ST_IE_ID=? ");

		params.add(Utility.getName(inventoryEntryPo.getCstiecheckgoodsquantity()));
		params.add(Utility.getName(inventoryEntryPo.getCstiecheckgoodsquantity()));
		params.add(Utility.getName(inventoryEntryPo.getCstieid()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 模块：发票管理
	 * 描述：查询发票类型
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceTypePo> getInvoiceTypeList(){
		StringBuffer sb = new StringBuffer();
		sb.append("select L_IT_ID as sLitID,L_IT_Type as sLitType from L_IT_InvoiceType ");
				
		return this.queryForObjectList(sb.toString(),null,InvoiceTypePo.class);
	}	
	
	/**
	 * 模块：发票管理
	 * 描述：根据发票号查询核销的单据号
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	@SuppressWarnings("unchecked")
	public List<InvoicePo> getInvoiceEntryOfBills(InvoicePo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select distinct L_IE_IE_BillID as liiid from L_IE_InvoiceEntry where L_IE_IE_InvoiceID=?");
		params.add(po.getLiiid());
				
		return this.queryForObjectList(sb.toString(),params.toArray(),InvoicePo.class);
	}	
	
	/**
	 * 模块：发票管理
	 * 描述：更新业务主表的核销标识
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public void updateInvoiceState(InvoicePo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update C_ST_Inventory set C_ST_I_InvoiceState=( ");
		sb.append("select case isnull(sum(isnull(C_ST_IE_GoodsQuantity,0)),0)-isnull(sum(isnull(C_ST_IE_checkquantity,0)),0) ");
		sb.append("         when 0 then 2 ");
		sb.append("         when isnull(sum(isnull(C_ST_IE_GoodsQuantity,0)),0) then 0 ");
		sb.append("         else 1 end ");
		sb.append("  from C_ST_InventoryEntry where C_ST_IE_BillID=? )");
		sb.append(" where C_ST_I_BillID=?");
		
		params.add(po.getLiiid());
		params.add(po.getLiiid());
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}	
	
	/**
	 * 模块：发票管理
	 * 描述：审核后发票数据取反
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public void updateInvoiceAbs(InvoicePo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update L_IE_InvoiceEntry set ");
		sb.append("L_IE_IE_GoodsQuantity=-abs(L_IE_IE_GoodsQuantity),L_IE_IE_CheckGoodsQuantity=-abs(L_IE_IE_CheckGoodsQuantity),");
		sb.append("L_IE_IE_NotTaxRateAmount=-abs(L_IE_IE_NotTaxRateAmount),L_IE_IE_TaxAmount=-abs(L_IE_IE_TaxAmount),L_IE_IE_CostPriceAmount=-abs(L_IE_IE_CostPriceAmount) ");
		sb.append("  where L_IE_IE_InvoiceID=? and L_IE_IE_BillID like 'POUT%'");
				
		params.add(po.getLiiid());
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}	
	
	/**
	 * 模块：发票管理
	 * 描述：审核后冲回数据取反
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public void updateReversalAbs(InvoicePo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update L_RE_ReversalEntry set ");
		sb.append("L_IE_RE_GoodsQuantity=-abs(L_IE_RE_GoodsQuantity),L_IE_RE_CheckGoodsQuantity=-abs(L_IE_RE_CheckGoodsQuantity),");
		sb.append("L_IE_RE_NotTaxRateAmount=-abs(L_IE_RE_NotTaxRateAmount),L_IE_RE_TaxAmount=-abs(L_IE_RE_TaxAmount),L_IE_RE_CostPriceAmount=-abs(L_IE_RE_CostPriceAmount) ");
		sb.append("  where L_IE_RE_InvoiceID=replace(?,'I','R') and L_IE_RE_BillID not like 'POUT%'");
				
		params.add(po.getLiiid());
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/*
	 * 发票和冲回全审
	 */
	public void invoiceAllAudit(InvoicePo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append(" exec [allAuditInvoiceAndReversal] ?,? ");
		
		params.add(Utility.getName(po.getLiiauditpersonid()));
		params.add(Utility.getName(po.getLiiid()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/*
	 * 发票和冲回全反审
	 */
	public void invoiceAllUnAudit(){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append(" exec [allUnAuditInvoiceAndReversal] ");
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	public List<InvoiceEntryPo> getInvoiceBillList(String billID){
		
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct L_I_I_ID as lieieinvoiceid,L_IE_IE_BillID as lieiebillid,B_SP_SupplierName as supplierName,personName as createPersonName,convert(varchar(10),L_I_I_Date,120) as invoiceDate ");
		sb.append(" from L_IE_InvoiceEntry inner join L_I_Invoice on L_IE_IE_InvoiceID=L_I_I_ID ");
		sb.append(" left join B_Supplier on L_I_I_SupplierID=B_SP_ID left join SYS_PersonInfo on L_I_I_CreatePersonID=id ");
		sb.append(" where L_IE_IE_BillID like '%'+? order by convert(varchar(10),L_I_I_Date,120) desc ");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(billID));
		
		return this.queryForObjectList(sb.toString(),params.toArray(),InvoiceEntryPo.class);
	}
	
} 
