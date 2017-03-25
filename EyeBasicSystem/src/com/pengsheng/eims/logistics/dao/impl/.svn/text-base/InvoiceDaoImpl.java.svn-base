package com.pengsheng.eims.logistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.logistics.dao.InvoiceDao;
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
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(distinct L_I_I_ID) from L_I_Invoice left join B_Departments on L_I_I_DepartmentID = B_DP_DepartmentID where 1=1 ");
		
		if (!"".equals(Utility.getName(invoicePo.getLiiCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(invoicePo.getLiiCompanyID()));	
		}
		
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
			sb.append("and L_I_I_ID like '%'+?+'%' ");
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
		if(!"".equals(Utility.getName(invoicePo.getLiiispayment()))){			
			if("1".equals(Utility.getName(invoicePo.getLiiispayment()))){
				sb.append(" and L_I_I_ID in (select distinct L_PB_PBE_InvoiceID from L_PB_PBE_PaymentBillEntry ) ");
			} else if("0".equals(Utility.getName(invoicePo.getLiiispayment()))){
				sb.append(" and L_I_I_ID not in (select distinct L_PB_PBE_InvoiceID from L_PB_PBE_PaymentBillEntry ) ");
			}
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

    /**
     * 查询发票
     */
	public List<InvoicePo> getInvoiceList(InvoicePo invoicePo,int start,int size) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT * FROM (SELECT ROW_NUMBER() Over(ORDER BY liidate desc) AS ROWNUMBER,liiid AS liiid,liisupplierid AS liisupplierid,");
		sb.append("liidepartmentname AS liidepartmentname,liidate as liidate,liiauditdate as liiauditdate,liiauditstatue as liiauditstatue ");
		sb.append(",liicreatepersonname as liicreatepersonname,liitypeName as liitypeName,liinottaxrateamount as liinottaxrateamount,liitaxamount as liitaxamount,liicostpriceamount as liicostpriceamount   ");
	    sb.append(" ,liiispaymentamount as liiispaymentamount from ( ");
		
		sb.append("SELECT L_I_I_ID AS liiid,L_I_I_SupplierID AS liisupplierid,");
		sb.append("(SELECT B_SP_SupplierName FROM B_SUPPLIER WHERE B_SP_ID=L_I_I_SupplierID) AS liidepartmentname,L_I_I_Date as liidate,L_I_I_AuditDate as liiauditdate,L_I_I_AuditStatue as liiauditstatue ");
		sb.append(",(select personName from SYS_PersonInfo where id=L_I_I_CreatePersonID) as liicreatepersonname,(select L_IT_Type from L_IT_InvoiceType where L_IT_ID=L_I_I_InvoiceType) as liitypeName,cast(sum(L_IE_IE_NotTaxRateAmount) as numeric(18,2)) as liinottaxrateamount,sum(L_IE_IE_TaxAmount) as liitaxamount,sum(L_IE_IE_CostPriceAmount) as liicostpriceamount   ");
	    sb.append(" ,( select isnull(sum(L_PB_PBE_PayMentAmount),0.00) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_InvoiceID=L_I_I_ID) as liiispaymentamount ");
		sb.append(" FROM L_I_Invoice inner join L_IE_InvoiceEntry on L_I_I_ID=L_IE_IE_InvoiceID left join B_Departments on L_I_I_DepartmentID = B_DP_DepartmentID where 1=1 and L_IE_IE_BillID not like 'POUT%' ");
		
		if (!"".equals(Utility.getName(invoicePo.getLiiCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(invoicePo.getLiiCompanyID()));	
		}
		
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
		if(!"".equals(Utility.getName(invoicePo.getLiiispayment()))){			
			if("1".equals(Utility.getName(invoicePo.getLiiispayment()))){
				sb.append(" and L_I_I_ID in (select distinct L_PB_PBE_InvoiceID from L_PB_PBE_PaymentBillEntry ) ");
			} else if("0".equals(Utility.getName(invoicePo.getLiiispayment()))){
				sb.append(" and L_I_I_ID not in (select distinct L_PB_PBE_InvoiceID from L_PB_PBE_PaymentBillEntry ) ");
			}
		}		
		sb.append(" group by L_I_I_Date,L_I_I_ID,L_I_I_SupplierID,L_I_I_AuditDate,L_I_I_AuditStatue,L_I_I_CreatePersonID,L_I_I_InvoiceType ");
		sb.append(" union all ");
		sb.append("SELECT L_I_I_ID AS liiid,L_I_I_SupplierID AS liisupplierid,");
		sb.append("(SELECT B_SP_SupplierName FROM B_SUPPLIER WHERE B_SP_ID=L_I_I_SupplierID) AS liidepartmentname,L_I_I_Date as liidate,L_I_I_AuditDate as liiauditdate,L_I_I_AuditStatue as liiauditstatue ");
		sb.append(",(select personName from SYS_PersonInfo where id=L_I_I_CreatePersonID) as liicreatepersonname,(select L_IT_Type from L_IT_InvoiceType where L_IT_ID=L_I_I_InvoiceType) as liitypeName,-cast(sum(abs(L_IE_IE_NotTaxRateAmount)) as numeric(18,2)) as liinottaxrateamount,-sum(abs(L_IE_IE_TaxAmount)) as liitaxamount,-sum(abs(L_IE_IE_CostPriceAmount)) as liicostpriceamount   ");
	    sb.append(" ,( select isnull(sum(L_PB_PBE_PayMentAmount),0.00) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_InvoiceID=L_I_I_ID) as liiispaymentamount ");
		sb.append(" FROM L_I_Invoice inner join L_IE_InvoiceEntry on L_I_I_ID=L_IE_IE_InvoiceID left join B_Departments on L_I_I_DepartmentID = B_DP_DepartmentID where 1=1 and L_IE_IE_BillID like 'POUT%' ");
		
		if (!"".equals(Utility.getName(invoicePo.getLiiCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(invoicePo.getLiiCompanyID()));	
		}
		
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
		if(!"".equals(Utility.getName(invoicePo.getLiiispayment()))){			
			if("1".equals(Utility.getName(invoicePo.getLiiispayment()))){
				sb.append(" and L_I_I_ID in (select distinct L_PB_PBE_InvoiceID from L_PB_PBE_PaymentBillEntry ) ");
			} else if("0".equals(Utility.getName(invoicePo.getLiiispayment()))){
				sb.append(" and L_I_I_ID not in (select distinct L_PB_PBE_InvoiceID from L_PB_PBE_PaymentBillEntry ) ");
			}
		}		
		sb.append(" group by L_I_I_Date,L_I_I_ID,L_I_I_SupplierID,L_I_I_AuditDate,L_I_I_AuditStatue,L_I_I_CreatePersonID,L_I_I_InvoiceType ");
		
		sb.append(" ) temp ) temp where ROWNUMBER > " + start + " and ROWNUMBER <= " + countPage);
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
		sb.append("temp.lieiecostprice as lieiecostprice,temp.lieietaxamount as lieietaxamount,lieietaxrate as lieietaxrate,lieiesourcenottaxrateamount as lieiesourcenottaxrateamount,lieiesourcetaxamount as lieiesourcetaxamount,lieiesourcecostpriceamount as lieiesourcecostpriceamount from (");
		
		sb.append("SELECT ROW_NUMBER() Over(ORDER BY L_IE_IE_BillID) AS ROWNUMBER,L_IE_IE_BillID AS lieiebillid,L_IE_IE_GoodsID AS  lieiegoodsid,L_IE_IE_GoodsName AS lieiegoodsname,L_IE_IE_GoodsQuantity AS lieiegoodsquantity,");
		sb.append("L_IE_IE_CheckGoodsQuantity as lieiecheckgoodsquantity,L_IE_IE_CostPriceAmount as lieiecostpriceamount ,");
		sb.append("l_ie_ie_spec as lieiespec,l_ie_ie_nottaxrate as lieienottaxrate,l_ie_ie_nottaxrateamount as lieienottaxrateamount, ");
		sb.append("l_ie_ie_costprice as lieiecostprice,l_ie_ie_taxamount as lieietaxamount,L_IE_IE_Taxrate as lieietaxrate,isnull(L_IE_IE_SourceNotTaxRateAmount,0) as lieiesourcenottaxrateamount,isnull(L_IE_IE_SourceTaxAmount,0) as lieiesourcetaxamount,isnull(L_IE_IE_SourceCostPriceAmount,0) as lieiesourcecostpriceamount ");
		sb.append("FROM L_Ie_Invoiceentry where L_IE_IE_InvoiceID=? ");
		sb.append(" ) temp where ROWNUMBER > " + start + " and ROWNUMBER <= "+ countPage);
		sb.append(" set rowcount 0");
		
		List<String> params = new ArrayList<String>();
		params.add(invoiceEntryPo.getLieieinvoiceid());
		
		return this.queryForObjectList(sb.toString(), params.toArray(),InvoiceEntryPo.class);
	}
	
	public InvoiceEntryPo getInvoiceAmountBySupplierID(InvoicePo invoicePo) {

		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append(" select sum(lieienottaxrateamount) as lieienottaxrateamount,sum(lieietaxamount) as lieietaxamount,sum(lieiecostpriceamount) as lieiecostpriceamount,sum(lieiepaymentamount) as lieiepaymentamount from ( ");
		sb.append("select sum(cast(L_IE_IE_NotTaxRateAmount as numeric(30,2))) as lieienottaxrateamount,sum(L_IE_IE_TaxAmount) as lieietaxamount,sum(L_IE_IE_CostPriceAmount) as lieiecostpriceamount ");
		sb.append("  ,isnull(temp.L_PB_PBE_PayMentAmount,0.00) as lieiepaymentamount from L_IE_InvoiceEntry inner join L_I_Invoice on L_I_I_ID=L_IE_IE_InvoiceID left join B_Departments on L_I_I_DepartmentID = B_DP_DepartmentID ");
		sb.append("  left join (select L_PB_PBE_InvoiceID,sum(L_PB_PBE_PayMentAmount) as L_PB_PBE_PayMentAmount from L_PB_PBE_PaymentBillEntry where substring(L_PB_PBE_InvoiceID,1,1)='I' or substring(L_PB_PBE_InvoiceID,1,3)='PIZ' group by L_PB_PBE_InvoiceID ) temp on L_I_I_ID=temp.L_PB_PBE_InvoiceID  ");
		
		sb.append(" where 1=1 and L_IE_IE_BillID not like 'POUT%' ");
		
		if (!"".equals(Utility.getName(invoicePo.getLiiCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(invoicePo.getLiiCompanyID()));	
		}
		
		if(!Utility.getName(invoicePo.getLiitypeName()).equals("")){
			sb.append("and L_I_I_InvoiceType=? ");
			params.add(Utility.getName(invoicePo.getLiitypeName()));
		}
		if(!Utility.getName(invoicePo.getLiiauditstatue()).equals("")){
			sb.append("and L_I_I_AuditStatue=? ");
			params.add(Utility.getName(invoicePo.getLiiauditstatue()));
		}
		if (!"".equals(Utility.getName(invoicePo.getLiisupplierid()))){
			sb.append(" and L_I_I_SupplierID=? ");
			params.add(Utility.getName(invoicePo.getLiisupplierid()));
		}	
		if(!Utility.getName(invoicePo.getLiicreatepersonid()).equals("")){
			sb.append("and L_I_I_CreatePersonID=? ");
			params.add(Utility.getName(invoicePo.getLiicreatepersonid()));
		}
		if(!Utility.getName(invoicePo.getLiiid()).equals("")){
			sb.append("and L_I_I_ID like '%'+?+'%' ");
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
		if(!"".equals(Utility.getName(invoicePo.getLiiispayment()))){			
			if("1".equals(Utility.getName(invoicePo.getLiiispayment()))){
				sb.append(" and L_I_I_ID in (select distinct L_PB_PBE_InvoiceID from L_PB_PBE_PaymentBillEntry ) ");
			} else if("0".equals(Utility.getName(invoicePo.getLiiispayment()))){
				sb.append(" and L_I_I_ID not in (select distinct L_PB_PBE_InvoiceID from L_PB_PBE_PaymentBillEntry ) ");
			}
		}
		sb.append(" group by temp.L_PB_PBE_PayMentAmount ");
		sb.append(" union all ");
		sb.append("select -sum(cast(abs(L_IE_IE_NotTaxRateAmount) as numeric(30,2))) as lieienottaxrateamount,-sum(abs(L_IE_IE_TaxAmount)) as lieietaxamount,-sum(abs(L_IE_IE_CostPriceAmount)) as lieiecostpriceamount ");
		sb.append("  ,isnull(temp.L_PB_PBE_PayMentAmount,0.00) as lieiepaymentamount from L_IE_InvoiceEntry inner join L_I_Invoice on L_I_I_ID=L_IE_IE_InvoiceID  ");
		sb.append("  left join (select L_PB_PBE_InvoiceID,-sum(abs(L_PB_PBE_PayMentAmount)) as L_PB_PBE_PayMentAmount from L_PB_PBE_PaymentBillEntry where substring(L_PB_PBE_InvoiceID,1,1)='I' or substring(L_PB_PBE_InvoiceID,1,3)='PIZ' group by L_PB_PBE_InvoiceID ) temp on L_I_I_ID=temp.L_PB_PBE_InvoiceID  ");
		
		sb.append(" where 1=1 and L_IE_IE_BillID like 'POUT%' ");
		if(!Utility.getName(invoicePo.getLiitypeName()).equals("")){
			sb.append("and L_I_I_InvoiceType=? ");
			params.add(Utility.getName(invoicePo.getLiitypeName()));
		}
		if(!Utility.getName(invoicePo.getLiiauditstatue()).equals("")){
			sb.append("and L_I_I_AuditStatue=? ");
			params.add(Utility.getName(invoicePo.getLiiauditstatue()));
		}
		if (!"".equals(Utility.getName(invoicePo.getLiisupplierid()))){
			sb.append(" and L_I_I_SupplierID=? ");
			params.add(Utility.getName(invoicePo.getLiisupplierid()));
		}	
		if(!Utility.getName(invoicePo.getLiicreatepersonid()).equals("")){
			sb.append("and L_I_I_CreatePersonID=? ");
			params.add(Utility.getName(invoicePo.getLiicreatepersonid()));
		}
		if(!Utility.getName(invoicePo.getLiiid()).equals("")){
			sb.append("and L_I_I_ID like '%'+?+'%' ");
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
		if(!"".equals(Utility.getName(invoicePo.getLiiispayment()))){			
			if("1".equals(Utility.getName(invoicePo.getLiiispayment()))){
				sb.append(" and L_I_I_ID in (select distinct L_PB_PBE_InvoiceID from L_PB_PBE_PaymentBillEntry ) ");
			} else if("0".equals(Utility.getName(invoicePo.getLiiispayment()))){
				sb.append(" and L_I_I_ID not in (select distinct L_PB_PBE_InvoiceID from L_PB_PBE_PaymentBillEntry ) ");
			}
		}
		sb.append(" group by temp.L_PB_PBE_PayMentAmount ");
		
		sb.append(" )temp ");
		
		return (InvoiceEntryPo) queryForObject(sb.toString(), params.toArray(),InvoiceEntryPo.class);
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
		sb.append("l_ie_ie_costprice as lieiecostprice,l_ie_ie_taxamount as lieietaxamount,L_IE_IE_Taxrate as lieietaxrate,L_IE_IE_UUID as lieieid,isnull(L_IE_IE_SourceNotTaxRateAmount,0) as lieiesourcenottaxrateamount,isnull(L_IE_IE_SourceTaxAmount,0) as lieiesourcetaxamount,isnull(L_IE_IE_SourceCostPriceAmount,0) as lieiesourcecostpriceamount ");
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
		 sb.append("L_IE_IE_UUID,L_IE_IE_SourceNotTaxRateAmount,L_IE_IE_SourceTaxAmount,L_IE_IE_SourceCostPriceAmount ");
		 sb.append("    )values(replace(NEWID(),'-',''),?,?,?,?,?,?,?          ");
		 sb.append(",?,?,?,?,?,?,?,?,?,?,?)");
		 
		 List<String> params = new ArrayList<String>();
		 params.add (invoiceEntryPo.getLieieinvoiceid           ());
		 params.add (invoiceEntryPo.getLieiebillid              ());
		 params.add (Utility.getName(invoiceEntryPo.getLieiegoodsid             ()));
		 params.add (Utility.getName(invoiceEntryPo.getLieiegoodsname           ()));
		 params.add (Utility.getName(invoiceEntryPo.getLieiespec                ()));
		 params.add (Utility.getName(invoiceEntryPo.getLieiegoodsquantity       ()).equals("")? "0" : Utility.getName(invoiceEntryPo.getLieiegoodsquantity       ()));
		 params.add (Utility.getName(invoiceEntryPo.getLieiecheckgoodsquantity  ()).equals("")? "0" : Utility.getName(invoiceEntryPo.getLieiecheckgoodsquantity  ()));
		 params.add (Utility.getName(invoiceEntryPo.getLieienottaxrate          ()).equals("")? "0" : Utility.getName(invoiceEntryPo.getLieienottaxrate  ()));
		 params.add (Utility.getName(invoiceEntryPo.getLieienottaxrateamount    ()).equals("")? "0" : Utility.getName(invoiceEntryPo.getLieienottaxrateamount  ()));
		 params.add (Utility.getName(invoiceEntryPo.getLieiecostprice           ()).equals("")? "0" : Utility.getName(invoiceEntryPo.getLieiecostprice  ()));
         params.add (Utility.getName(invoiceEntryPo.getLieietaxamount           ()).equals("")? "0" : Utility.getName(invoiceEntryPo.getLieietaxamount  ()));
         params.add (Utility.getName(invoiceEntryPo.getLieiecostpriceamount     ()).equals("")? "0" : Utility.getName(invoiceEntryPo.getLieiecostpriceamount  ()));
         params.add ("0");
         params.add (Utility.getName(invoiceEntryPo.getLieietaxrate()).equals("")? "0" : Utility.getName(invoiceEntryPo.getLieietaxrate  ()));
         params.add (Utility.getName(invoiceEntryPo.getLieieid()));
         
         params.add (Utility.getName(invoiceEntryPo.getLieiesourcenottaxrateamount()).equals("") ? "0.00" : Utility.getName(invoiceEntryPo.getLieiesourcenottaxrateamount()));
         params.add (Utility.getName(invoiceEntryPo.getLieiesourcetaxamount()).equals("") ? "0.00" : Utility.getName(invoiceEntryPo.getLieiesourcetaxamount()));
         params.add (Utility.getName(invoiceEntryPo.getLieiesourcecostpriceamount()).equals("") ? "0.00" : Utility.getName(invoiceEntryPo.getLieiesourcecostpriceamount()));
         
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
		sb.append("L_I_I_InvoiceType,L_I_I_PaymentDay,L_I_I_InvoiceForm  ");
		
		List<String> params = new ArrayList<String>();
		
		if("1".equals(invoicePo.getLiiauditstatue())){
			sb.append(",L_I_I_AuditPersonID,L_I_I_Auditdate ");
		}		
		sb.append(",L_I_I_SubSupplierID ");
		if (!"".equals(Utility.getName(invoicePo.getLiidate()))){
			sb.append(") values(?,?,?,?,?,?,?,?,?,?,?");
		}else{
			sb.append(") values(?,?,getdate(),?,?,?,?,?,?,?,?");
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
		params.add(Utility.getName(invoicePo.getLiipaymentday()));
		params.add(Utility.getName(invoicePo.getLiiisinvoiceform()));
		if("1".equals(Utility.getName(invoicePo.getLiiauditstatue()))){
			sb.append(",?,getdate()");
			params.add(Utility.getName(invoicePo.getLiiauditpersonid()));
		}
		sb.append(",?)");
		
		params.add(Utility.getName(invoicePo.getLiisubsupplierid()));

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
		sb.append("insert into L_R_Reversal(L_I_R_ID,L_I_R_SupplierID,L_I_R_Date,L_I_R_DepartmentID,L_I_R_CreatePersonID,L_I_R_AuditStatue,L_I_R_AuditPersonID,L_I_R_AuditDate,L_I_R_isVoucher,L_I_R_VoucherDate,L_I_R_Remark,L_I_R_PaymentDay,L_I_R_SubSupplierID) ");
		sb.append(" select replace(L_I_I_ID,'I','R'),L_I_I_SupplierID,L_I_I_Date,L_I_I_DepartmentID,L_I_I_CreatePersonID,L_I_I_AuditStatue,L_I_I_AuditPersonID,L_I_I_AuditDate,L_I_I_isVoucher,L_I_I_VoucherDate,L_I_I_Remark,L_I_I_PaymentDay,L_I_I_SubSupplierID from L_I_Invoice where L_I_I_ID=?");
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
		sb.append(" update L_I_Invoice set L_I_I_AuditStatue = '1',L_I_I_AuditPersonID = ?,L_I_I_AuditDate = getdate() where L_I_I_ID in ( ? ");
		
		params.add(Utility.getName(po.getLiiauditpersonid()));
		
		String[] str = Utility.getName(po.getLiiid()).split(",");
		params.add(str[0]);
		
		for (int i = 1; i < str.length; i++){
			sb.append(" ,? ");
			params.add(str[i]);
		}
		sb.append(" ) ");
	
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/*
	 * 发票和冲回全反审
	 */
	public void invoiceAllUnAudit(InvoicePo invoicePo){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append(" update L_I_Invoice set L_I_I_AuditStatue = '0',L_I_I_AuditPersonID = NULL,L_I_I_AuditDate = NULL where L_I_I_ID in ( ? ");
		
		String[] str = Utility.getName(invoicePo.getLiiid()).split(",");
		params.add(str[0]);
		
		for (int i = 1; i < str.length; i++){
			sb.append(" ,? ");
			params.add(str[i]);
		}
		sb.append(" ) ");
		
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
	
	public String getBillByInvoice(String invoiceID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select dbo.getBillByInvoice(?) ");		
		
		params.add(Utility.getName(invoiceID));
		
		return (String)this.getJdbcTemplate().queryForObject(sb.toString(),params.toArray(),String.class);
	}
	
	public InvoiceEntryPo getInvoceSum(InvoicePo invoicePo) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT isnull(sum(L_IE_IE_GoodsQuantity),'0') as lieiegoodsquantity,isnull(sum(L_IE_IE_CheckGoodsQuantity),'0') as lieiecheckgoodsquantity,isnull(sum(cast(L_IE_IE_NotTaxRateAmount as numeric(18,2))),'0.00') as lieienottaxrateamount,isnull(sum(L_IE_IE_TaxAmount),'0.00') as lieietaxamount,isnull(sum(L_IE_IE_CostPriceAmount),'0.00') as lieiecostpriceamount ");
		sb.append(" FROM L_I_Invoice inner join L_IE_InvoiceEntry on L_I_I_ID=L_IE_IE_InvoiceID where L_I_I_ID=?");
		
		params.add(invoicePo.getLiiid());
		
		return (InvoiceEntryPo) this.queryForObject(sb.toString(), params.toArray(),InvoiceEntryPo.class);
	}
	
	/**
	 * 查询采购单据总数
	 */
	public int getProcurementBillCount(InvoicePo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(lieiebillid) from ( ");
		sb.append("select lieiebillid,cstiebilltypeid,invoiceDate,lieienottaxrateamount,lieietaxamount,lieiecostpriceamount  ");
		sb.append("  from (  ");
		sb.append("select temp.C_ST_I_BillID as lieiebillid,temp.C_ST_I_BillTypeId as cstiebilltypeid,temp.C_ST_I_FinanceAuditDate as invoiceDate, ");
		sb.append("       (isnull(temp.C_ST_IE_NotTaxRateAmount,0)-isnull(temp2.L_IE_IE_NotTaxRateAmount,0)) as lieienottaxrateamount, ");
		sb.append("       (isnull(temp.C_ST_IE_TaxAmount,0)-isnull(temp2.L_IE_IE_TaxAmount,0)) as lieietaxamount, ");
		sb.append("       (isnull(temp.C_ST_IE_CostPriceAmount,0)-isnull(temp2.L_IE_IE_CostPriceAmount,0)) as lieiecostpriceamount ");
		sb.append("  from ( ");
		sb.append("select C_ST_I_BillID as C_ST_I_BillID,C_ST_I_BillTypeId as C_ST_I_BillTypeId, ");
		sb.append("       convert(varchar(10),C_ST_I_FinanceAuditDate,120) as C_ST_I_FinanceAuditDate, ");
		sb.append("	   sum(C_ST_IE_NotTaxRateAmount) as C_ST_IE_NotTaxRateAmount, ");
		sb.append("	   sum(C_ST_IE_TaxAmount) as C_ST_IE_TaxAmount, ");
		sb.append("       sum(C_ST_IE_CostPriceAmount) as C_ST_IE_CostPriceAmount ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		
		sb.append("  left join B_Warehouse a on C_ST_I_OutStockId=a.B_WH_ID left join B_Departments ab on a.B_WH_deptID = ab.B_DP_DepartmentID ");
		sb.append("  left join B_Warehouse b on C_ST_I_InStockId=b.B_WH_ID left join B_Departments bb on b.B_WH_deptID = bb.B_DP_DepartmentID ");
		
		sb.append("  where C_ST_I_BillTypeId in ('1','2','9') and C_ST_I_SupplierId=? ");
		sb.append("  and C_ST_I_AuditState='1' and C_ST_I_FinanceAuditState='1' ");
		
		params.add(Utility.getName(po.getLiisupplierid()));
		
		if (!"".equals(Utility.getName(po.getLiiCompanyID()))){
		    sb.append(" and ( ab.B_DP_CompanysID = ? or bb.B_DP_CompanysID = ? ) ");
			params.add(Utility.getName(po.getLiiCompanyID()));	
			params.add(Utility.getName(po.getLiiCompanyID()));	
		}
		
		if(!Utility.getName(po.getLiiBillID()).equals("")){
			sb.append("and C_ST_I_BillID like '%'+?+'%' ");
			params.add(Utility.getName(po.getLiiBillID()));
		}
		if(!"".equals(Utility.getName(po.getLiistartauditdate()))){
			sb.append(" and convert(varchar(10),C_ST_I_FinanceAuditDate,120)>=? ");
			params.add(Utility.getName(po.getLiistartauditdate()));
		}	
		if(!"".equals(Utility.getName(po.getLiiendauditdate()))){
			sb.append(" and  convert(varchar(10),C_ST_I_FinanceAuditDate,120)<=? ");
			params.add(Utility.getName(po.getLiiendauditdate()));
		}	
		if(!"".equals(Utility.getName(po.getLiistartdate()))){
			sb.append("and convert(varchar(10),C_ST_I_billDate,120)>=? ");
			params.add(Utility.getName(po.getLiistartdate()));
		}
		if(!"".equals(Utility.getName(po.getLiienddate()))){
			sb.append("and  convert(varchar(10),C_ST_I_billDate,120)<=? ");
			params.add(Utility.getName(po.getLiienddate()));
		}
		if("1".equals(Utility.getName(po.getLiiBillType()))){
			sb.append("and  C_ST_I_BillTypeId in ('1','9')  ");
		}
		if("2".equals(Utility.getName(po.getLiiBillType()))){
			sb.append("and  C_ST_I_BillTypeId='2'  ");
		}
			
		sb.append("  group by C_ST_I_BillID,C_ST_I_BillTypeId,convert(varchar(10),C_ST_I_FinanceAuditDate,120) ");
		sb.append(")temp left join ( ");
		sb.append("	select L_IE_IE_BillID as L_IE_IE_BillID, ");
		sb.append("		   sum(L_IE_IE_NotTaxRateAmount) as L_IE_IE_NotTaxRateAmount, ");
		sb.append("		   sum(L_IE_IE_TaxAmount) as L_IE_IE_TaxAmount, ");
		sb.append("           sum(L_IE_IE_CostPriceAmount) as L_IE_IE_CostPriceAmount ");
		sb.append("	  from L_IE_InvoiceEntry inner join L_I_Invoice on L_IE_IE_InvoiceID=L_I_I_ID ");
		sb.append("	  where L_I_I_SupplierID=? ");
		sb.append("      group by L_IE_IE_BillID ");
		sb.append(")temp2 on temp.C_ST_I_BillID=temp2.L_IE_IE_BillID ");
		sb.append(")temp ");
		sb.append("  where lieiecostpriceamount<>0 ");
		sb.append(")temp ");
		
		params.add(Utility.getName(po.getLiisupplierid()));
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询采购单据列表
	 */
	public List<InvoiceEntryPo> getProcurementBillList(InvoicePo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");

		sb.append("select * from ( ");
		sb.append("select ROW_NUMBER() Over(ORDER BY invoiceDate desc) AS ROWNUMBER,lieiebillid,cstiebilltypeid,invoiceDate,lieienottaxrateamount,lieietaxamount,lieiecostpriceamount  ");
		sb.append("  from (  ");
		sb.append("select temp.C_ST_I_BillID as lieiebillid,temp.C_ST_I_BillTypeId as cstiebilltypeid,temp.C_ST_I_FinanceAuditDate as invoiceDate, ");
		sb.append("       (isnull(temp.C_ST_IE_NotTaxRateAmount,0)-isnull(temp2.L_IE_IE_NotTaxRateAmount,0)) as lieienottaxrateamount, ");
		sb.append("       (isnull(temp.C_ST_IE_TaxAmount,0)-isnull(temp2.L_IE_IE_TaxAmount,0)) as lieietaxamount, ");
		sb.append("       (isnull(temp.C_ST_IE_CostPriceAmount,0)-isnull(temp2.L_IE_IE_CostPriceAmount,0)) as lieiecostpriceamount ");
		sb.append("  from ( ");
		sb.append("select C_ST_I_BillID as C_ST_I_BillID,C_ST_I_BillTypeId as C_ST_I_BillTypeId, ");
		sb.append("       convert(varchar(10),C_ST_I_FinanceAuditDate,120) as C_ST_I_FinanceAuditDate, ");
		sb.append("	   sum(C_ST_IE_NotTaxRateAmount) as C_ST_IE_NotTaxRateAmount, ");
		sb.append("	   sum(C_ST_IE_TaxAmount) as C_ST_IE_TaxAmount, ");
		sb.append("       sum(C_ST_IE_CostPriceAmount) as C_ST_IE_CostPriceAmount ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("  left join B_Warehouse a on C_ST_I_OutStockId=a.B_WH_ID left join B_Departments ab on a.B_WH_deptID = ab.B_DP_DepartmentID ");
		sb.append("  left join B_Warehouse b on C_ST_I_InStockId=b.B_WH_ID left join B_Departments bb on b.B_WH_deptID = bb.B_DP_DepartmentID ");
		
		sb.append("  where C_ST_I_BillTypeId in ('1','2','9') and C_ST_I_SupplierId=? ");
		sb.append("  and C_ST_I_AuditState='1' and C_ST_I_FinanceAuditState='1' ");
		
		params.add(Utility.getName(po.getLiisupplierid()));
		
		if (!"".equals(Utility.getName(po.getLiiCompanyID()))){
		    sb.append(" and ( ab.B_DP_CompanysID = ? or bb.B_DP_CompanysID = ? ) ");
			params.add(Utility.getName(po.getLiiCompanyID()));	
			params.add(Utility.getName(po.getLiiCompanyID()));	
		}
		
		if(!Utility.getName(po.getLiiBillID()).equals("")){
			sb.append("and C_ST_I_BillID like '%'+?+'%' ");
			params.add(Utility.getName(po.getLiiBillID()));
		}
		if(!"".equals(Utility.getName(po.getLiistartauditdate()))){
			sb.append(" and convert(varchar(10),C_ST_I_FinanceAuditDate,120)>=? ");
			params.add(Utility.getName(po.getLiistartauditdate()));
		}	
		if(!"".equals(Utility.getName(po.getLiiendauditdate()))){
			sb.append(" and  convert(varchar(10),C_ST_I_FinanceAuditDate,120)<=? ");
			params.add(Utility.getName(po.getLiiendauditdate()));
		}	
		if(!"".equals(Utility.getName(po.getLiistartdate()))){
			sb.append("and convert(varchar(10),C_ST_I_billDate,120)>=? ");
			params.add(Utility.getName(po.getLiistartdate()));
		}
		if(!"".equals(Utility.getName(po.getLiienddate()))){
			sb.append("and  convert(varchar(10),C_ST_I_billDate,120)<=? ");
			params.add(Utility.getName(po.getLiienddate()));
		}
		if("1".equals(Utility.getName(po.getLiiBillType()))){
			sb.append("and  C_ST_I_BillTypeId in ('1','9')  ");
		}
		if("2".equals(Utility.getName(po.getLiiBillType()))){
			sb.append("and  C_ST_I_BillTypeId='2'  ");
		}
			
		sb.append("  group by C_ST_I_BillID,C_ST_I_BillTypeId,convert(varchar(10),C_ST_I_FinanceAuditDate,120) ");
		sb.append(")temp left join ( ");
		sb.append("	select L_IE_IE_BillID as L_IE_IE_BillID, ");
		sb.append("		   sum(L_IE_IE_NotTaxRateAmount) as L_IE_IE_NotTaxRateAmount, ");
		sb.append("		   sum(L_IE_IE_TaxAmount) as L_IE_IE_TaxAmount, ");
		sb.append("           sum(L_IE_IE_CostPriceAmount) as L_IE_IE_CostPriceAmount ");
		sb.append("	  from L_IE_InvoiceEntry inner join L_I_Invoice on L_IE_IE_InvoiceID=L_I_I_ID ");
		sb.append("	  where L_I_I_SupplierID=? ");
		sb.append("      group by L_IE_IE_BillID ");
		sb.append(")temp2 on temp.C_ST_I_BillID=temp2.L_IE_IE_BillID ");
		sb.append(")temp ");
		sb.append("  where lieiecostpriceamount<>0 ");
		sb.append(" ) temp where ROWNUMBER > " + start + " and ROWNUMBER <= " + countPage);
		sb.append(" set rowcount 0");
		
		params.add(Utility.getName(po.getLiisupplierid()));
		
		return this.queryForObjectList(sb.toString(),params.toArray(),InvoiceEntryPo.class);
	}
	
} 
