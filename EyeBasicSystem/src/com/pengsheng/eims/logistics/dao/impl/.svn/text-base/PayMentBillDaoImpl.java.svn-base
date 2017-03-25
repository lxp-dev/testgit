/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : PayMentBillDaoImpl.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2012-05-04
**/
package com.pengsheng.eims.logistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.dao.PayMentBillDao;
import com.pengsheng.eims.logistics.persistence.InOrOutComeTypePo;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.PayMentBillEntryPo;
import com.pengsheng.eims.logistics.persistence.PayMentBillPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class PayMentBillDaoImpl extends BaseJdbcDaoSupport implements PayMentBillDao{
	
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	/**
	 * 查询付款单总数
	 */
	public int getPayMentBillCount(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_PB_PB_ID)");		
		sb.append(" from L_PB_PB_PaymentBill left join B_Departments on L_PB_PB_DepartmentID = B_DP_DepartmentID where 1=1 ");		

		if (!"".equals(Utility.getName(po.getsLpbpbCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getsLpbpbCompanyID()));	
		}
		if (!"".equals(Utility.getName(po.getsLpbpbTypeID()))){
			sb.append(" and L_PB_PB_PaymentType = ? ");
			params.add(Utility.getName(po.getsLpbpbTypeID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and L_PB_PB_ID like '%'+?+'%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and L_PB_PB_SupplierID=?");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(" and isNUll(L_PB_PB_AuditStatue,'0')=?");
			params.add(Utility.getName(po.getsLpbpbAuditStatue()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)>=?");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)<=?");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbCreatePersonID()))){
			sb.append(" and L_PB_PB_CreatePersonID=?");
			params.add(Utility.getName(po.getsLpbpbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbIsVoucher()))){
			sb.append(" and L_PB_PB_IsVoucher=?");
			params.add(Utility.getName(po.getsLpbpbIsVoucher()));
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	/**
	 * 查询付款单列表
	 */
	public List<PayMentBillPo> getPayMentBillList(PayMentBillPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.sLpbpbID as sLpbpbID,temp.sLpbpbSupplierID as sLpbpbSupplierID,temp.sLpbpbSupplierName as sLpbpbSupplierName,temp.sLpbpbDate as sLpbpbDate,temp.sLpbpbCreatePersonID as sLpbpbCreatePersonID,temp.sLpbpbCreatePersonName as sLpbpbCreatePersonName,");
		sb.append("temp.sLpbpbAuditDate as sLpbpbAuditDate,temp.sLpbpbAuditStatue as sLpbpbAuditStatue,");
		sb.append("temp.sLpbpbAuditPersonID as sLpbpbAuditPersonID,temp.sLpbpbAuditPersonName as sLpbpbAuditPersonName,temp.sLpbpbRemark as sLpbpbRemark,temp.sLpbpbPayMentAmount as sLpbpbPayMentAmount ");
		
		sb.append(" from( select ROW_NUMBER() Over(order by L_PB_PB_Date desc) as rowNum,L_PB_PB_ID as sLpbpbID,L_PB_PB_SupplierID as sLpbpbSupplierID,L_PB_PB_Date as sLpbpbDate,L_PB_PB_CreatePersonID as sLpbpbCreatePersonID,a.personName as sLpbpbCreatePersonName,");
		sb.append("L_PB_PB_AuditDate as sLpbpbAuditDate,isNUll(L_PB_PB_AuditStatue,'0') as sLpbpbAuditStatue,");
		
		sb.append("L_PB_PB_AuditPersonID as sLpbpbAuditPersonID,a.personName as sLpbpbAuditPersonName,L_PB_PB_Remark as sLpbpbRemark,isnull(L_PB_PB_PayedMentAmount,0) as sLpbpbPayMentAmount ");
		sb.append(",B_SP_SupplierName as sLpbpbSupplierName");		
		sb.append(" from L_PB_PB_PaymentBill left join SYS_PersonInfo a on L_PB_PB_CreatePersonID=a.ID left join SYS_PersonInfo b on L_PB_PB_AuditPersonID=b.ID ");	
		sb.append(" left join B_Supplier on L_PB_PB_SupplierID=B_SP_ID left join B_Departments on L_PB_PB_DepartmentID = B_DP_DepartmentID where 1=1 ");	
	
		if (!"".equals(Utility.getName(po.getsLpbpbCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getsLpbpbCompanyID()));	
		}
		if (!"".equals(Utility.getName(po.getsLpbpbTypeID()))){
			sb.append(" and L_PB_PB_PaymentType = ? ");
			params.add(Utility.getName(po.getsLpbpbTypeID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and L_PB_PB_ID like '%'+?+'%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and L_PB_PB_SupplierID=?");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(" and isNUll(L_PB_PB_AuditStatue,'0')=?");
			params.add(Utility.getName(po.getsLpbpbAuditStatue()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)>=?");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)<=?");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbCreatePersonID()))){
			sb.append(" and L_PB_PB_CreatePersonID=?");
			params.add(Utility.getName(po.getsLpbpbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbIsVoucher()))){
			sb.append(" and isnull(L_PB_PB_IsVoucher,'0')=?");
			params.add(Utility.getName(po.getsLpbpbIsVoucher()));
		}
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" order by temp.sLpbpbDate desc set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),PayMentBillPo.class);
	}
	
	/**
	 * 新增付款单
	 */
	public void insertPayMentBill(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_PB_PB_PaymentBill(L_PB_PB_ID,L_PB_PB_SupplierID,L_PB_PB_Date,L_PB_PB_DepartmentID,L_PB_PB_CreatePersonID,");
		sb.append("L_PB_PB_IsVoucher,L_PB_PB_CostPriceAmount,L_PB_PB_PayedMentAmount,L_PB_PB_DiscountAmount,L_PB_PB_Remark,L_PB_PB_PaymentDay,L_PB_PB_AuditStatue,L_PB_PB_PaymentType ");
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(",L_PB_PB_AuditPersonID,L_PB_PB_AuditDate ");
		}
		sb.append(",L_PB_PB_SubSupplierID,L_PB_PB_CurrentPayedMentAmount) values(?,?,getdate(),?,?,'0',?,?,'0.00',?,?,?,'1'");
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(",?,getdate() ");
		}
		sb.append(",?,? ) ");
		
		params.add(Utility.getName(po.getsLpbpbID()));
		params.add(Utility.getName(po.getsLpbpbSupplierID()));
		params.add(Utility.getName(po.getsLpbpbDepartmentID()));
		params.add(Utility.getName(po.getsLpbpbCreatePersonID()));

		if (!"".endsWith(Utility.getName(po.getsLpbpbCostPriceAmount()))){
			params.add(Utility.getName(po.getsLpbpbCostPriceAmount()));
		}else{
			params.add("0.00");
		}
		if (!"".endsWith(Utility.getName(po.getsLpbpbPayMentAmount()))){
			params.add(Utility.getName(po.getsLpbpbPayMentAmount()));
		}else{
			params.add("0.00");
		}
		params.add(Utility.getName(po.getsLpbpbRemark()));
		params.add(Utility.getName(po.getsLpbpbDate()));
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			params.add("1");
			params.add(Utility.getName(po.getsLpbpbAuditPersonID()));
		}else{
			params.add("0");
		}
		params.add(Utility.getName(po.getsLpbpbSubSupplierID()));
		if (!"".endsWith(Utility.getName(po.getsLpbpbCurrentPayMentAmount()))){
			params.add(Utility.getName(po.getsLpbpbCurrentPayMentAmount()));
		}else{
			params.add("0.00");
		}
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 新增付款单明细
	 */
	public void insertPayMentBillEntry(PayMentBillEntryPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_PB_PBE_PaymentBillEntry(L_PB_PBE_ID,L_PB_PBE_BillID,L_PB_PBE_BillTypeID,L_PB_PBE_InvoiceID,L_PB_PBE_CostPriceAmount,");
		sb.append("L_PB_PBE_PayMentAmount,L_PB_PBE_DiscountAmount) ");
		sb.append(" values(?,?,'1',?,?,?,'0.00')");
		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getsLpbpbeBillID()));
		params.add(Utility.getName(po.getsLpbpbeInvoiceID()));
		params.add(Utility.getName(po.getsLpbpbeCostPriceAmount()));
		params.add(Utility.getName(po.getsLpbpbePayMentAmount()));		
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 修改付款单
	 */
	public void updatePayMentBill(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_PB_PB_PaymentBill set L_PB_PB_Remark=?,L_PB_PB_CostPriceAmount=?,L_PB_PB_PayedMentAmount=?,L_PB_PB_CurrentPayedMentAmount=? ");
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(",L_PB_PB_AuditStatue=?,L_PB_PB_AuditPersonID=?,L_PB_PB_AuditDate=getdate() ");
		}
		sb.append(" where L_PB_PB_ID=? ");
		
		params.add(Utility.getName(po.getsLpbpbRemark()));
		params.add(Utility.getName(po.getsLpbpbCostPriceAmount()));
		params.add(Utility.getName(po.getsLpbpbPayMentAmount()));
		params.add(Utility.getName(po.getsLpbpbCurrentPayMentAmount()));
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			params.add(Utility.getName(po.getsLpbpbAuditStatue()));
			params.add(Utility.getName(po.getsLpbpbAuditPersonID()));
		}
		params.add(Utility.getName(po.getsLpbpbID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 删除付款单
	 */
	public void deletePayMentBill(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from L_PB_PB_PaymentBill where L_PB_PB_ID=? ");
		
		params.add(Utility.getName(po.getsLpbpbID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 删除付款单明细
	 */
	public void deletePayMentBillEntry(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from L_PB_PBE_PaymentBillEntry where L_PB_PBE_BillID=? ");
		
		params.add(Utility.getName(po.getsLpbpbID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 查询付款单详情
	 */
	public PayMentBillPo getPayMentBillDetail(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select top 1 L_PB_PB_ID as sLpbpbID,B_SP_SupplierName as sLpbpbSupplierName,L_PB_PB_Date as sLpbpbDate,L_PB_PB_AuditDate as sLpbpbAuditDate,b.personName as sLpbpbAuditPersonName,");
		sb.append(" a.personName as sLpbpbCreatePersonName,L_PB_PB_Remark as sLpbpbRemark,L_PB_PB_PaymentType as sLpbpbTypeID from L_PB_PB_PaymentBill  ");
		sb.append(" left join SYS_PersonInfo a on L_PB_PB_CreatePersonID=a.ID left join SYS_PersonInfo b on L_PB_PB_AuditPersonID=b.ID ");	
		sb.append(" left join B_Supplier on L_PB_PB_SupplierID=B_SP_ID ");	
		sb.append(" where L_PB_PB_ID=? ");	
			
		params.add(Utility.getName(po.getsLpbpbID()));
		
		return (PayMentBillPo)queryForObject(sb.toString(), params.toArray(),PayMentBillPo.class);
	}
	
	/**
	 * 查询付款单明细详情
	 */
	public List<PayMentBillEntryPo> getPayMentBillEntryDetail(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select L_PB_PBE_BillID as sLpbpbeBillID,L_PB_PBE_BillTypeID as sLpbpbeBillTypeID,L_PB_PBE_InvoiceID as sLpbpbeInvoiceID,L_PB_PBE_CostPriceAmount as sLpbpbeCostPriceAmount,L_PB_PBE_PayMentAmount as sLpbpbePayMentAmount");
		sb.append(" from L_PB_PBE_PaymentBillEntry  ");	
		sb.append(" where L_PB_PBE_BillID=? ");	
			
		params.add(Utility.getName(po.getsLpbpbID()));
		
		return queryForObjectList(sb.toString(), params.toArray(),PayMentBillEntryPo.class);
	}
	
	/**
	 * 查询发票总数
	 */
	public int getInvoiceCount(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(lieieinvoiceid) from ( ");
		
		sb.append(" select lieieinvoiceid as lieieinvoiceid,paidAmount  as paidAmount,lieiecostpriceamount as lieiecostpriceamount from ( ");
		
		sb.append(" select L_IE_IE_InvoiceID as lieieinvoiceid,isnull(L_I_I_PaidAmount,0.00)  as paidAmount,(sum(L_IE_IE_CostPriceAmount)-isnull(temp.payMentAmount,0.00)-isnull(L_I_I_PaidAmount,0.00)) as lieiecostpriceamount ");
		sb.append("  from L_IE_InvoiceEntry  ");	
		sb.append("       inner join L_I_Invoice on L_IE_IE_InvoiceID=L_I_I_ID left join B_Departments on L_I_I_DepartmentID = B_DP_DepartmentID ");	
		sb.append("       left join ( ");	
		sb.append("    select L_PB_PBE_InvoiceID as invoiceID,sum(L_PB_PBE_PayMentAmount) as payMentAmount ");	
		sb.append("      from L_PB_PBE_PaymentBillEntry left join L_I_Invoice on L_PB_PBE_InvoiceID=L_I_I_ID where 1=1 ");	
		
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and convert(varchar(10),L_I_I_Date,120)>=? ");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and convert(varchar(10),L_I_I_Date,120)<=? ");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbCreatePersonID()))){
			sb.append(" and L_I_I_CreatePersonID=? ");
			params.add(Utility.getName(po.getsLpbpbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and L_I_I_SupplierID=? ");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and convert(varchar(10),L_I_I_AuditDate,120)>=? ");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and convert(varchar(10),L_I_I_AuditDate,120)<=? ");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and L_I_I_ID like '%' + ? + '%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		
		sb.append("      group by L_PB_PBE_InvoiceID ");	
		sb.append(")temp on L_IE_IE_InvoiceID=temp.invoiceID where L_I_I_AuditStatue='1' ");	
				
		if (!"".equals(Utility.getName(po.getsLpbpbCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getsLpbpbCompanyID()));	
		}
		
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and convert(varchar(10),L_I_I_Date,120)>=? ");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and convert(varchar(10),L_I_I_Date,120)<=? ");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbCreatePersonID()))){
			sb.append(" and L_I_I_CreatePersonID=? ");
			params.add(Utility.getName(po.getsLpbpbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and L_I_I_SupplierID=? ");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and convert(varchar(10),L_I_I_AuditDate,120)>=? ");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and convert(varchar(10),L_I_I_AuditDate,120)<=? ");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and L_I_I_ID like '%' + ? + '%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		sb.append("  group by L_IE_IE_InvoiceID,payMentAmount,L_I_I_PaidAmount )temp where lieiecostpriceamount<>0 ) temp");
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取发票列表
	 */
	public List<InvoiceEntryPo> getInvoiceList(PayMentBillPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.lieieinvoiceid as lieieinvoiceid,temp.lieiecostpriceamount as lieiecostpriceamount,temp.invoiceDate as invoiceDate,temp.createPersonName as createPersonName ");
		
		sb.append(" from( select ROW_NUMBER() Over(order by temp.invoiceDate desc) as rowNum, lieieinvoiceid as lieieinvoiceid,invoiceDate as invoiceDate,createPersonName as createPersonName,isnull(paidAmount,0.00) as paidAmount,lieiecostpriceamount as lieiecostpriceamount ");
		
		sb.append(" from( select L_IE_IE_InvoiceID as lieieinvoiceid,L_I_I_Date as invoiceDate,personName as createPersonName,isnull(L_I_I_PaidAmount,0.00) as paidAmount,(sum(L_IE_IE_CostPriceAmount)-isnull(payMentAmount,0.00)-isnull(L_I_I_PaidAmount,0.00)) as lieiecostpriceamount ");
		sb.append("  from L_IE_InvoiceEntry  ");	
		sb.append("       inner join L_I_Invoice on L_IE_IE_InvoiceID=L_I_I_ID left join B_Departments on L_I_I_DepartmentID = B_DP_DepartmentID ");	
		sb.append("       left join SYS_PersonInfo on L_I_I_CreatePersonID=ID ");	
		sb.append("       left join ( ");	
		sb.append("    select L_PB_PBE_InvoiceID as invoiceID,sum(L_PB_PBE_PayMentAmount) as payMentAmount ");	
		sb.append("      from L_PB_PBE_PaymentBillEntry left join L_I_Invoice on L_PB_PBE_InvoiceID=L_I_I_ID where 1=1 ");	

		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and convert(varchar(10),L_I_I_Date,120)>=? ");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and convert(varchar(10),L_I_I_Date,120)<=? ");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbCreatePersonID()))){
			sb.append(" and L_I_I_CreatePersonID=? ");
			params.add(Utility.getName(po.getsLpbpbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and L_I_I_SupplierID=? ");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and convert(varchar(10),L_I_I_AuditDate,120)>=? ");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and convert(varchar(10),L_I_I_AuditDate,120)<=? ");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and L_I_I_ID like '%' + ? + '%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		
		sb.append("      group by L_PB_PBE_InvoiceID ");	
		sb.append(")temp on L_IE_IE_InvoiceID=temp.invoiceID where L_I_I_AuditStatue='1' ");	
		
		if (!"".equals(Utility.getName(po.getsLpbpbCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getsLpbpbCompanyID()));	
		}
		
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and convert(varchar(10),L_I_I_Date,120)>=? ");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and convert(varchar(10),L_I_I_Date,120)<=? ");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbCreatePersonID()))){
			sb.append(" and L_I_I_CreatePersonID=? ");
			params.add(Utility.getName(po.getsLpbpbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and L_I_I_SupplierID=? ");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and convert(varchar(10),L_I_I_AuditDate,120)>=? ");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and convert(varchar(10),L_I_I_AuditDate,120)<=? ");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and L_I_I_ID like '%' + ? + '%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		
		sb.append("  group by L_I_I_Date,L_IE_IE_InvoiceID,payMentAmount, L_I_I_CreatePersonID,personName,L_I_I_PaidAmount ");
		
		sb.append(" )temp where lieiecostpriceamount<>0 ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),InvoiceEntryPo.class);
	}

	/**
	 * 查询付款单凭证总数
	 */
	public int getVoucherCount(VoucherPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_V_V_ID)");		
		sb.append(" from L_V_Voucher left join L_VT_VoucherType on L_V_V_VoucherTypeID=L_VT_VT_ID inner join SYS_PersonInfo on L_V_V_PersonID=ID left join B_Departments on L_V_V_CreateDptID = B_DP_DepartmentID where 1=1 ");		

		if (!"".equals(Utility.getName(po.getsLvvCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getsLvvCompanyID()));	
		}
		
		if (!"".equals(Utility.getName(po.getsLvvID()))){
			sb.append(" and L_V_V_ID like '%'+?+'%'");//quyanping
			params.add(po.getsLvvID());
		}
		if (!"".equals(Utility.getName(po.getsLvvSupplierID()))){
			sb.append(" and L_V_V_SupplierID=?");
			params.add(po.getsLvvSupplierID());
		}
		if (!"".equals(Utility.getName(po.getsLvvDepartmentID()))){
			sb.append(" and L_V_V_DepartmentID=?");
			params.add(po.getsLvvDepartmentID());
		}
		if (!"".equals(Utility.getName(po.getsLvvFranchiseeDptID()))){
			sb.append(" and L_V_V_FranchiseeID=?");
			params.add(po.getsLvvFranchiseeDptID());
		}
		if (!"".equals(Utility.getName(po.getsLvvTypeID()))){
			sb.append(" and L_V_V_TypeID=?");
			params.add(po.getsLvvTypeID());
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append(" and isNUll(L_V_V_AuditStatue,'0')=?");
			params.add(po.getsLvvAuditStatue());
		}
		if (!"".equals(Utility.getName(po.getsLvvDateTopLimit()))){
			sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)>=?");
			params.add(po.getsLvvDateTopLimit());
		}
		if (!"".equals(Utility.getName(po.getsLvvDateLowerLimit()))){
			sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)<=?");
			params.add(po.getsLvvDateLowerLimit());
		}		
		if (!"".equals(Utility.getName(po.getsLvvAuditDateTopLimit()))){
			sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)>=?");
			params.add(po.getsLvvAuditDateTopLimit());
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditDateLowerLimit()))){
			sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)<=?");
			params.add(po.getsLvvAuditDateLowerLimit());
		}
		if (!"".equals(Utility.getName(po.getsLvvVoucherTypeID()))){
			sb.append(" and L_V_V_VoucherTypeID=?");
			params.add(po.getsLvvVoucherTypeID());
		}else{
			sb.append(" and L_VT_VT_ParentID in ('11','12','13') ");
		}
		if (!"".equals(Utility.getName(po.getsLvvPosting()))){
			sb.append(" and isnull(L_V_V_Posting,'0')=?");
			params.add(po.getsLvvPosting());
		}
		if (!"".equals(Utility.getName(po.getsLvvPersonID()))){
			sb.append(" and L_V_V_PersonID=?");
			params.add(po.getsLvvPersonID());
		}
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询付款单凭证
	 */
	public List<VoucherPo> getVoucherList(VoucherPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;		
		sb.append("set rowcount " + countPage + " \n");
		
		sb.append("select temp.sLvvID as sLvvID,temp.sLvvSupplierID as sLvvSupplierID,temp.sLvvSupplierName as sLvvSupplierName,temp.sLvvDate as sLvvDate,temp.sLvvPersonID as sLvvPersonID,temp.sLvvPersonName as sLvvPersonName,temp.sLvvAuditPersonName as sLvvAuditPersonName,");
		sb.append("temp.sLvvVoucherTypeID as sLvvVoucherTypeID,temp.sLvvVoucherTypeName as sLvvVoucherTypeName,temp.sLvvVoucherParentTypeID as sLvvVoucherParentTypeID,temp.sLvvBalanceMethod as sLvvBalanceMethod,temp.sLvvAuditDate as sLvvAuditDate,temp.sLvvAuditStatue as sLvvAuditStatue,");
		sb.append("temp.sLvvAuditPersonID as sLvvAuditPersonID,temp.sLvvHandlePersonID as sLvvHandlePersonID,temp.sLvvRemark as sLvvRemark,temp.sLvvNotTaxRateAmount as sLvvNotTaxRateAmount,temp.sLvvTaxAmount as sLvvTaxAmount,temp.sLvvCostPriceAmount as sLvvCostPriceAmount,temp.sLvvPosting as sLvvPosting ");
		sb.append(" from( select ROW_NUMBER() Over(order by L_V_V_Date desc) as rowNum,L_V_V_ID as sLvvID,L_V_V_SupplierID as sLvvSupplierID,L_V_V_Date as sLvvDate,L_V_V_PersonID as sLvvPersonID,a.personName as sLvvPersonName,b.personName as sLvvAuditPersonName,");
		sb.append("L_V_V_VoucherTypeID as sLvvVoucherTypeID,L_VT_VT_TypeName as sLvvVoucherTypeName,L_VT_VT_ParentID as sLvvVoucherParentTypeID,L_V_V_BalanceMethod as sLvvBalanceMethod,L_V_V_AuditDate as sLvvAuditDate,isNUll(L_V_V_AuditStatue,'0') as sLvvAuditStatue,");
		sb.append("L_V_V_AuditPersonID as sLvvAuditPersonID,L_V_V_HandlePersonID as sLvvHandlePersonID,L_V_V_Remark as sLvvRemark,isnull(L_V_V_NotTaxRateAmount,0) as sLvvNotTaxRateAmount,isnull(L_V_V_TaxAmount,0) as sLvvTaxAmount,isnull(L_V_V_CostPriceAmount,0) as sLvvCostPriceAmount,isnull(L_V_V_Posting,'0') as sLvvPosting ");
		sb.append(",(case L_V_V_TypeID when '1' then isnull(B_SP_SupplierName,'') when '2' then isnull(B_Departments.B_DP_DepartmentName,'') when '3' then isnull(B_FS_StoreName,'') else '' end) as sLvvSupplierName");		
		sb.append(" from L_V_Voucher left join L_VT_VoucherType on L_V_V_VoucherTypeID=L_VT_VT_ID left join SYS_PersonInfo a on L_V_V_PersonID=a.ID left join SYS_PersonInfo b on L_V_V_AuditPersonID=b.ID  ");
		
		sb.append(" left join B_Supplier on L_V_V_SupplierID = B_SP_ID  ");	
		sb.append(" left join B_Departments on L_V_V_DepartmentID = B_Departments.B_DP_DepartmentID  ");	
		sb.append(" left join B_Franchisee on L_V_V_FranchiseeID = B_FS_StoreID  ");	
		sb.append(" left join B_Departments d on L_V_V_CreateDptID = d.B_DP_DepartmentID ");		

		sb.append(" where 1=1 ");	
		
		if (!"".equals(Utility.getName(po.getsLvvCompanyID()))){
		    sb.append(" and d.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getsLvvCompanyID()));	
		}
	
		if (!"".equals(Utility.getName(po.getsLvvID()))){
			sb.append(" and L_V_V_ID like '%'+?+'%'");//quyanping
			params.add(po.getsLvvID());
		}
		if (!"".equals(Utility.getName(po.getsLvvSupplierID()))){
			sb.append(" and L_V_V_SupplierID=?");
			params.add(po.getsLvvSupplierID());
		}
		if (!"".equals(Utility.getName(po.getsLvvDepartmentID()))){
			sb.append(" and L_V_V_DepartmentID=?");
			params.add(po.getsLvvDepartmentID());
		}
		if (!"".equals(Utility.getName(po.getsLvvFranchiseeDptID()))){
			sb.append(" and L_V_V_FranchiseeID=?");
			params.add(po.getsLvvFranchiseeDptID());
		}
		if (!"".equals(Utility.getName(po.getsLvvTypeID()))){
			sb.append(" and L_V_V_TypeID=?");
			params.add(po.getsLvvTypeID());
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append(" and isNUll(L_V_V_AuditStatue,'0')=?");
			params.add(po.getsLvvAuditStatue());
		}
		if (!"".equals(Utility.getName(po.getsLvvDateTopLimit()))){
			sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)>=?");
			params.add(po.getsLvvDateTopLimit());
		}
		if (!"".equals(Utility.getName(po.getsLvvDateLowerLimit()))){
			sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)<=?");
			params.add(po.getsLvvDateLowerLimit());
		}		
		if (!"".equals(Utility.getName(po.getsLvvAuditDateTopLimit()))){
			sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)>=?");
			params.add(po.getsLvvAuditDateTopLimit());
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditDateLowerLimit()))){
			sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)<=?");
			params.add(po.getsLvvAuditDateLowerLimit());
		}
		if (!"".equals(Utility.getName(po.getsLvvVoucherTypeID()))){
			sb.append(" and L_V_V_VoucherTypeID=?");
			params.add(po.getsLvvVoucherTypeID());
		}else{
			sb.append(" and L_VT_VT_ParentID in ('11','12','13') ");
		}
		if (!"".equals(Utility.getName(po.getsLvvPosting()))){
			sb.append(" and isnull(L_V_V_Posting,'0')=?");
			params.add(po.getsLvvPosting());
		}
		if (!"".equals(Utility.getName(po.getsLvvPersonID()))){
			sb.append(" and L_V_V_PersonID=?");
			params.add(po.getsLvvPersonID());
		}
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" order by temp.sLvvDate desc set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),VoucherPo.class);
	}
	
	/**
	 * 修改付款单凭证标识   1 ：已做凭证    0：未做凭证
	 */
	public void updatePayMentBillVoucherFlag(VoucherPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		if ("1".equals(Utility.getName(po.getsLvvPosting()))){
			sb.append("update L_PB_PB_PaymentBill set L_PB_PB_IsVoucher='1',L_PB_PB_VoucherDate=getdate() where L_PB_PB_ID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?) ");
		}else{
			sb.append("update L_PB_PB_PaymentBill set L_PB_PB_IsVoucher='0',L_PB_PB_VoucherDate=NULL where L_PB_PB_ID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?) ");
		}
		params.add(Utility.getName(po.getsLvvID()));
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * Description：新增付款单凭证明细
	 * @param     ：凭证明细实体
	 */
	public void insertPayMentBillVoucherEntry(VoucherEntryPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_VE_VoucherEntry(L_VE_VE_ID,L_VE_VE_VoucherID,L_VE_VE_BillID,L_VE_VE_CostPriceAmount) ");
		sb.append(" values(?,?,?,?)");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getsLveveVoucherID()));
		params.add(Utility.getName(po.getsLveveBillID()));
		params.add(Utility.getName(po.getsCostPriceAmount()));

		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * Description：获取付款单凭证明细
	 * @param     ：凭证明细实体
	 */
	public List<VoucherEntryPo> getPayMentVoucherEntryDetail(VoucherPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select L_VE_VE_BillID as sLveveBillID,isnull(L_VE_VE_CostPriceAmount,0) as sCostPriceAmount,L_PB_PB_Date as sBillDate ");
		sb.append(" from L_VE_VoucherEntry inner join L_PB_PB_PaymentBill on L_VE_VE_BillID=L_PB_PB_ID ");
		sb.append(" where L_VE_VE_VoucherID=? ");
		sb.append(" union all ");
		sb.append(" select L_VE_VE_BillID as sLveveBillID,isnull(L_VE_VE_CostPriceAmount,0) as sCostPriceAmount,L_FA_RM_Date as sBillDate ");
		sb.append(" from L_VE_VoucherEntry inner join L_FA_RM_ReceiptMentBill on L_VE_VE_BillID=L_FA_RM_ID ");
		sb.append(" where L_VE_VE_VoucherID=? ");
		
		params.add(Utility.getName(po.getsLvvID()));
		params.add(Utility.getName(po.getsLvvID()));
		
		return queryForObjectList(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * Description：获取付款单凭证
	 * @param     ：凭证明细实体
	 */
	public VoucherPo getPayMentVoucherDetail(VoucherPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1 L_V_V_ID as sLvvID,(case isnull(B_SP_SupplierName,'') when '' then isnull(B_FS_StoreName,'') else isnull(B_SP_SupplierName,'') end) as sLvvSupplierName,convert(varchar(10),L_V_V_Date,120) as sLvvDate,a.personName as sLvvPersonName, ");
		sb.append("       b.personName as sLvvAuditPersonName,convert(varchar(10),L_V_V_AuditDate,120) as sLvvAuditDate,L_V_V_Remark as sLvvRemark, ");
		sb.append("       d.L_VT_VT_TypeName as sLvvVoucherParentTypeName,c.L_VT_VT_TypeName as sLvvVoucherTypeName,isnull(L_V_V_Posting,'0') as sLvvPosting,L_V_V_VoucherTypeID as sLvvVoucherTypeID ");
		sb.append("  from L_V_Voucher left join B_Supplier on L_V_V_SupplierID=B_SP_ID ");
		sb.append("       left join SYS_PersonInfo a on L_V_V_PersonID=a.id ");
		sb.append("       left join SYS_PersonInfo b on L_V_V_PersonID=b.id ");
		sb.append("       left join L_VT_VoucherType c on L_V_V_VoucherTypeID=c.L_VT_VT_ID ");
		sb.append("       left join L_VT_VoucherType d on c.L_VT_VT_ParentID=d.L_VT_VT_ID ");
		sb.append("       left join B_Franchisee e on L_V_V_SupplierID=e.B_FS_StoreID ");
		sb.append("  where L_V_V_ID=? ");
		
		params.add(Utility.getName(po.getsLvvID()));
		
		return (VoucherPo)queryForObject(sb.toString(), params.toArray(),VoucherPo.class);
	}
	
	/**
	 * 反审核付款单
	 */
	public void auditUnPayMentBill(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_PB_PB_PaymentBill set L_PB_PB_AuditStatue='0',L_PB_PB_AuditPersonID=NULL,L_PB_PB_AuditDate=NULL ");
		sb.append(" where L_PB_PB_ID in ( ? ");		
		
		String[] bills = Utility.getName(po.getsLpbpbID()).split(",");
		params.add(Utility.getName(bills[0]));
		for (int i = 1; i < bills.length; i++){
			sb.append(" ,? ");
			params.add(Utility.getName(bills[i]));
		}
		sb.append(" ) ");

		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 部分审核付款单
	 */
	public void partAuditPayMentBill(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_PB_PB_PaymentBill set L_PB_PB_AuditStatue='1',L_PB_PB_AuditPersonID=?,L_PB_PB_AuditDate=getdate() ");
		sb.append(" where L_PB_PB_ID in ( ? ");	
		
		params.add(Utility.getName(po.getsLpbpbAuditPersonID()));
		String[] bills = Utility.getName(po.getsLpbpbID()).split(",");
		params.add(Utility.getName(bills[0]));
		for (int i = 1; i < bills.length; i++){
			sb.append(" ,? ");
			params.add(Utility.getName(bills[i]));
		}
		sb.append(" ) ");
				
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 查询付款单是否已做付款单凭证
	 */
	public int getVoucherCountByPayMentBillID(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_VE_VE_ID) from L_VE_VoucherEntry where L_VE_VE_BillID=? ");
		
		params.add(Utility.getName(po.getsLpbpbID()));
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	/**
	 * 查询其他付款单总数
	 */
	public int getPayMentBillOtherCount(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_PB_PB_ID)");		
		sb.append(" from L_PB_PB_PaymentBill where L_PB_PB_PaymentType='5' ");		

		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and L_PB_PB_ID like '%'+?+'%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and L_PB_PB_SupplierID=?");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(" and isNUll(L_PB_PB_AuditStatue,'0')=?");
			params.add(Utility.getName(po.getsLpbpbAuditStatue()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)>=?");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)<=?");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbCreatePersonID()))){
			sb.append(" and L_PB_PB_CreatePersonID=?");
			params.add(Utility.getName(po.getsLpbpbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbIsVoucher()))){
			sb.append(" and L_PB_PB_IsVoucher=?");
			params.add(Utility.getName(po.getsLpbpbIsVoucher()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbPayMentDptID()))){
			sb.append(" and L_PB_PB_PaymentDpt=?");
			params.add(Utility.getName(po.getsLpbpbPayMentDptID()));
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	/**
	 * 查询其他付款单列表
	 */
	public List<PayMentBillPo> getPayMentBillOtherList(PayMentBillPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.sLpbpbID as sLpbpbID,temp.sLpbpbSupplierID as sLpbpbSupplierID,temp.sLpbpbSupplierName as sLpbpbSupplierName,temp.sLpbpbDate as sLpbpbDate,temp.sLpbpbCreatePersonID as sLpbpbCreatePersonID,temp.sLpbpbCreatePersonName as sLpbpbCreatePersonName,");
		sb.append("temp.sLpbpbAuditDate as sLpbpbAuditDate,temp.sLpbpbAuditStatue as sLpbpbAuditStatue,");
		sb.append("temp.sLpbpbAuditPersonID as sLpbpbAuditPersonID,temp.sLpbpbAuditPersonName as sLpbpbAuditPersonName,temp.sLpbpbRemark as sLpbpbRemark,temp.sLpbpbPayMentAmount as sLpbpbPayMentAmount ");
		
		sb.append(" from( select ROW_NUMBER() Over(order by L_PB_PB_Date desc) as rowNum,L_PB_PB_ID as sLpbpbID,L_PB_PB_SupplierID as sLpbpbSupplierID,L_PB_PB_Date as sLpbpbDate,L_PB_PB_CreatePersonID as sLpbpbCreatePersonID,a.personName as sLpbpbCreatePersonName,");
		sb.append("L_PB_PB_AuditDate as sLpbpbAuditDate,isNUll(L_PB_PB_AuditStatue,'0') as sLpbpbAuditStatue,");
		
		sb.append("L_PB_PB_AuditPersonID as sLpbpbAuditPersonID,a.personName as sLpbpbAuditPersonName,L_PB_PB_Remark as sLpbpbRemark,isnull(L_PB_PB_PayedMentAmount,0) as sLpbpbPayMentAmount ");
		sb.append(",B_SP_SupplierName as sLpbpbSupplierName");		
		sb.append(" from L_PB_PB_PaymentBill left join SYS_PersonInfo a on L_PB_PB_CreatePersonID=a.ID left join SYS_PersonInfo b on L_PB_PB_AuditPersonID=b.ID ");	
		sb.append(" left join B_Supplier on L_PB_PB_SupplierID=B_SP_ID where L_PB_PB_PaymentType='5' ");	
	
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and L_PB_PB_ID like '%'+?+'%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and L_PB_PB_SupplierID=?");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(" and isNUll(L_PB_PB_AuditStatue,'0')=?");
			params.add(Utility.getName(po.getsLpbpbAuditStatue()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)>=?");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)<=?");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbCreatePersonID()))){
			sb.append(" and L_PB_PB_CreatePersonID=?");
			params.add(Utility.getName(po.getsLpbpbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbIsVoucher()))){
			sb.append(" and isnull(L_PB_PB_IsVoucher,'0')=?");
			params.add(Utility.getName(po.getsLpbpbIsVoucher()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbPayMentDptID()))){
			sb.append(" and L_PB_PB_PaymentDpt=?");
			params.add(Utility.getName(po.getsLpbpbPayMentDptID()));
		}
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" order by temp.sLpbpbDate desc set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),PayMentBillPo.class);
	}
	
	/**
	 * 新增其他付款单
	 */
	public void insertPayMentBillOther(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_PB_PB_PaymentBill(L_PB_PB_ID,L_PB_PB_SupplierID,L_PB_PB_Date,L_PB_PB_DepartmentID,L_PB_PB_CreatePersonID,");
		sb.append("L_PB_PB_IsVoucher,L_PB_PB_CostPriceAmount,L_PB_PB_PayedMentAmount,L_PB_PB_DiscountAmount,L_PB_PB_Remark,L_PB_PB_PaymentDay,L_PB_PB_AuditStatue,L_PB_PB_PaymentType ");
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(",L_PB_PB_AuditPersonID,L_PB_PB_AuditDate ");
		}
		sb.append(",L_PB_PB_PaymentDpt) values(?,?,getdate(),?,?,'0',?,?,'0.00',?,?,?,'5'");
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(",?,getdate() ");
		}
		sb.append(" ,?) ");
		
		params.add(Utility.getName(po.getsLpbpbID()));
		params.add(Utility.getName(po.getsLpbpbSupplierID()));
		params.add(Utility.getName(po.getsLpbpbDepartmentID()));
		params.add(Utility.getName(po.getsLpbpbCreatePersonID()));

		if (!"".endsWith(Utility.getName(po.getsLpbpbCostPriceAmount()))){
			params.add(Utility.getName(po.getsLpbpbCostPriceAmount()));
		}else{
			params.add("0.00");
		}
		if (!"".endsWith(Utility.getName(po.getsLpbpbPayMentAmount()))){
			params.add(Utility.getName(po.getsLpbpbPayMentAmount()));
		}else{
			params.add(Utility.getName(po.getsLpbpbCostPriceAmount()).equals("") ? "0.00" : Utility.getName(po.getsLpbpbCostPriceAmount()));
		}
		params.add(Utility.getName(po.getsLpbpbRemark()));
		params.add(Utility.getName(po.getsLpbpbDate()));
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			params.add("1");
			params.add(Utility.getName(po.getsLpbpbAuditPersonID()));
		}else{
			params.add("0");
		}
		params.add(Utility.getName(po.getsLpbpbPayMentDptID()));
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 新增其他付款单明细
	 */
	public void insertPayMentBillOtherEntry(PayMentBillEntryPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_PB_PBE_PaymentBillEntry(L_PB_PBE_ID,L_PB_PBE_BillID,L_PB_PBE_BillTypeID,L_PB_PBE_InvoiceID,L_PB_PBE_CostPriceAmount,");
		sb.append("L_PB_PBE_PayMentAmount,L_PB_PBE_Remark) ");
		sb.append(" values(?,?,'2',?,?,?,?)");
		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getsLpbpbeBillID()));
		params.add(Utility.getName(po.getsLpbpbeInvoiceID()));
		params.add(Utility.getName(po.getsLpbpbeCostPriceAmount()));
		params.add(Utility.getName(po.getsLpbpbeCostPriceAmount()));
		params.add(Utility.getName(po.getsLpbpbeRemark()));		
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 修改其他付款单
	 */
	public void updatePayMentBillOther(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_PB_PB_PaymentBill set L_PB_PB_Remark=?,L_PB_PB_CostPriceAmount=?,L_PB_PB_PayedMentAmount=?,L_PB_PB_PaymentDpt=? ");
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(",L_PB_PB_AuditStatue=?,L_PB_PB_AuditPersonID=?,L_PB_PB_AuditDate=getdate() ");
		}
		sb.append(" where L_PB_PB_ID=? ");
		
		params.add(Utility.getName(po.getsLpbpbRemark()));
		params.add(Utility.getName(po.getsLpbpbCostPriceAmount()));
		params.add(Utility.getName(po.getsLpbpbCostPriceAmount()));
		params.add(Utility.getName(po.getsLpbpbPayMentDptID()));
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			params.add(Utility.getName(po.getsLpbpbAuditStatue()));
			params.add(Utility.getName(po.getsLpbpbAuditPersonID()));
		}
		params.add(Utility.getName(po.getsLpbpbID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 删除其他付款单
	 */
	public void deletePayMentBillOther(PayMentBillPo po){
		
	}
	
	/**
	 * 反审核其他付款单
	 */
	public boolean auditUnPayMentBillOther(PayMentBillPo po){
		return false;
	}
	
	/**
	 * 查询其他付款单详情
	 */
	public PayMentBillPo getPayMentBillOtherDetail(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select top 1 L_PB_PB_ID as sLpbpbID,B_SP_SupplierName as sLpbpbSupplierName,L_PB_PB_SupplierID as sLpbpbSupplierID,L_PB_PB_Date as sLpbpbDate,L_PB_PB_AuditDate as sLpbpbAuditDate,b.personName as sLpbpbAuditPersonName,");
		sb.append(" a.personName as sLpbpbCreatePersonName,L_PB_PB_Remark as sLpbpbRemark,L_PB_PB_PaymentDpt as sLpbpbPayMentDptID,B_DP_DepartmentName as sLpbpbPayMentDptName from L_PB_PB_PaymentBill  ");
		sb.append(" left join SYS_PersonInfo a on L_PB_PB_CreatePersonID=a.ID left join SYS_PersonInfo b on L_PB_PB_AuditPersonID=b.ID ");	
		sb.append(" left join B_Supplier on L_PB_PB_SupplierID=B_SP_ID left join B_Departments on L_PB_PB_PaymentDpt=B_DP_DepartmentID ");	
		sb.append(" where L_PB_PB_ID=? ");	
			
		params.add(Utility.getName(po.getsLpbpbID()));
		
		return (PayMentBillPo)queryForObject(sb.toString(), params.toArray(),PayMentBillPo.class);
	}
	
	/**
	 * 查询其他付款单明细详情
	 */
	public List<PayMentBillEntryPo> getPayMentBillOtherEntryDetail(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select L_PB_PBE_BillID as sLpbpbeBillID,L_PB_PBE_BillTypeID as sLpbpbeBillTypeID,L_PB_PBE_InvoiceID as sLpbpbeInvoiceID,(L_S_S_SubjectID+L_S_S_SubjectName) as sLpbpbeOutComeName,L_PB_PBE_CostPriceAmount as sLpbpbeCostPriceAmount,L_PB_PBE_Remark as sLpbpbeRemark ");
		sb.append(" from L_PB_PBE_PaymentBillEntry inner join L_S_Subject on L_PB_PBE_InvoiceID=L_S_S_ID ");	
		sb.append(" where L_PB_PBE_BillID=? ");	
			
		params.add(Utility.getName(po.getsLpbpbID()));
		
		return queryForObjectList(sb.toString(), params.toArray(),PayMentBillEntryPo.class);
	}
	
	/**
	 * 查询收支类别总数
	 */
	public int getInOrOutComeTypeCount(InOrOutComeTypePo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_IO_IO_ID)");		
		sb.append(" from L_IO_IO_InOrOutComeType where L_IO_IO_Flag=1 ");		

		if (!"".equals(Utility.getName(po.getsLioioTypeID()))){
			sb.append(" and L_IO_IO_TypeID like '%'+?+'%'");
			params.add(Utility.getName(po.getsLioioTypeID()));
		}
		if (!"".equals(Utility.getName(po.getsLioioTypeName()))){
			sb.append(" and L_IO_IO_TypeName like '%'+?+'%' ");
			params.add(Utility.getName(po.getsLioioTypeName()));
		}		
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	/**
	 * 查询收支类别列表
	 */
	public List<InOrOutComeTypePo> getInOrOutComeTypeList(InOrOutComeTypePo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.sLioioTypeID as sLioioTypeID,temp.sLioioTypeName as sLioioTypeName,temp.sLioioIsDelete as sLioioIsDelete,temp.sLioioID as sLioioID ");
		sb.append(" from( select ROW_NUMBER() Over(order by L_IO_IO_TypeID ) as rowNum,L_IO_IO_TypeID as sLioioTypeID,L_IO_IO_ID as sLioioID,L_IO_IO_TypeName as sLioioTypeName,isnull(L_IO_IO_IsDelete,0) as sLioioIsDelete ");
		sb.append(" from L_IO_IO_InOrOutComeType where L_IO_IO_Flag=1 ");	
	
		if (!"".equals(Utility.getName(po.getsLioioTypeID()))){
			sb.append(" and L_IO_IO_TypeID like '%'+?+'%'");
			params.add(Utility.getName(po.getsLioioTypeID()));
		}
		if (!"".equals(Utility.getName(po.getsLioioTypeName()))){
			sb.append(" and L_IO_IO_TypeName like '%'+?+'%' ");
			params.add(Utility.getName(po.getsLioioTypeName()));
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" order by temp.sLioioTypeID desc set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),InOrOutComeTypePo.class);
	}
	
	/**
	 * 新增收支类别
	 */
	public void insertInOrOutComeType(InOrOutComeTypePo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_IO_IO_InOrOutComeType(L_IO_IO_ID,L_IO_IO_TypeID,L_IO_IO_TypeName,L_IO_IO_BatchID,L_IO_IO_SubjectID,L_IO_IO_InOrOutFlag,L_IO_IO_IsDelete,L_IO_IO_Flag) ");		
		sb.append(" values(?,?,?,'',?,?,'1','1')");
			
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getsLioioTypeID()).trim());
		params.add(Utility.getName(po.getsLioioTypeName()));
		params.add(Utility.getName(po.getsLioioSubjectID()));
		params.add(Utility.getName(po.getsLioioInOrOutFlag()));
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 修改收支类别
	 */
	public void updateInOrOutComeType(InOrOutComeTypePo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_IO_IO_InOrOutComeType set L_IO_IO_TypeID=?,L_IO_IO_TypeName=? ");
		sb.append(" where L_IO_IO_ID=? ");
	
		params.add(Utility.getName(po.getsLioioTypeID()).trim());
		params.add(Utility.getName(po.getsLioioTypeName()).trim());
		params.add(Utility.getName(po.getsLioioID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 删除收支类别
	 */
	public void deleteInOrOutComeType(InOrOutComeTypePo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from L_IO_IO_InOrOutComeType where L_IO_IO_ID=? ");
		
		params.add(Utility.getName(po.getsLioioID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 查询收支类别详情
	 */
	public InOrOutComeTypePo getInOrOutComeTypeDetail(InOrOutComeTypePo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select top 1 L_IO_IO_ID as sLioioID,L_IO_IO_TypeID as sLioioTypeID,L_IO_IO_TypeName as sLioioTypeName from L_IO_IO_InOrOutComeType where L_IO_IO_ID=? ");
			
		params.add(Utility.getName(po.getsLioioID()));
		
		return (InOrOutComeTypePo)queryForObject(sb.toString(), params.toArray(),InOrOutComeTypePo.class);
	}

	/**
	 * 查询收支类别是否存在
	 */
	public int isExistsInOrOutComeType(InOrOutComeTypePo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_IO_IO_ID) from L_IO_IO_InOrOutComeType where L_IO_IO_TypeID=? ");		
		
		params.add(Utility.getName(po.getsLioioTypeID()));		
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询制造商总数
	 */
	public int getSupplierCurrentAccountCount(SupplierPo po){		
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select C_ST_I_BillID into #billinfo ");
		sb.append("  from ( ");
		sb.append("	select C_ST_I_BillID ");
		sb.append("	  from C_ST_Inventory  ");
		sb.append("		   left join B_Warehouse on C_ST_I_InStockId = B_WH_ID  ");
		sb.append("		   left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");
		sb.append("	  where C_ST_I_BillTypeId in ('1','9') ");
		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and C_ST_I_SupplierId = ? ");
			params.add(Utility.getName(po.getBspid()));
		}
		sb.append("			and B_DP_CompanysID = ? ");		
		params.add(Utility.getName(po.getBspcompanyid()));
		
		sb.append("	union ");
		sb.append("	select C_ST_I_BillID ");
		sb.append("	  from C_ST_Inventory  ");
		sb.append("		   left join B_Warehouse on C_ST_I_OutStockId = B_WH_ID  ");
		sb.append("		   left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");
		sb.append("	  where C_ST_I_BillTypeId = '2' ");
		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and C_ST_I_SupplierId = ? ");
			params.add(Utility.getName(po.getBspid()));
		}
		sb.append("			and B_DP_CompanysID = ? ");
		params.add(Utility.getName(po.getBspcompanyid()));
		sb.append("	union ");
		sb.append("	select L_PB_PB_ID ");
		sb.append("	  from L_PB_PB_PaymentBill ");
		sb.append("		   left join B_Departments on L_PB_PB_DepartmentID = B_DP_DepartmentID  ");
		sb.append("	  where B_DP_CompanysID = ? ");
		params.add(Utility.getName(po.getBspcompanyid()));
		
		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and L_PB_PB_SupplierID = ? ");
			params.add(Utility.getName(po.getBspid()));
		}
		sb.append("  )m ");
				
		sb.append("select count(distinct L_SC_SA_SubSupplierID)");		
		sb.append(" from L_SC_SupplierAccount left join B_SupplierAgent on L_SC_SA_SubSupplierID = B_SP_ID where 1=1 ");	
		
		sb.append(" and L_SC_SA_BillID in (select C_ST_I_BillID from #billinfo) ");

		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and L_SC_SA_SupplierID=? ");
			params.add(Utility.getName(po.getBspid()));
		}
		if (!"".equals(Utility.getName(po.getStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_SC_SA_Date,120) >= ? ");
			params.add(Utility.getName(po.getStartDate()));
		}
		if (!"".equals(Utility.getName(po.getEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_SC_SA_Date,120) <= ? ");
			params.add(Utility.getName(po.getEndDate()));
		}
				
		sb.append(" drop table #billinfo ");
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询各制造商往来账总金额
	 */
	public List<SupplierPo> getSupplierCurrentAccountList(SupplierPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("select C_ST_I_BillID into #billinfo ");
		sb.append("  from ( ");
		sb.append("	select C_ST_I_BillID ");
		sb.append("	  from C_ST_Inventory  ");
		sb.append("		   left join B_Warehouse on C_ST_I_InStockId = B_WH_ID  ");
		sb.append("		   left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");
		sb.append("	  where C_ST_I_BillTypeId in ('1','9') ");
		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and C_ST_I_SupplierId = ? ");
			params.add(Utility.getName(po.getBspid()));
		}
		sb.append("			and B_DP_CompanysID = ? ");		
		params.add(Utility.getName(po.getBspcompanyid()));
		
		sb.append("	union ");
		sb.append("	select C_ST_I_BillID ");
		sb.append("	  from C_ST_Inventory  ");
		sb.append("		   left join B_Warehouse on C_ST_I_OutStockId = B_WH_ID  ");
		sb.append("		   left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");
		sb.append("	  where C_ST_I_BillTypeId = '2' ");
		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and C_ST_I_SupplierId = ? ");
			params.add(Utility.getName(po.getBspid()));
		}
		sb.append("			and B_DP_CompanysID = ? ");
		params.add(Utility.getName(po.getBspcompanyid()));
		sb.append("	union ");
		sb.append("	select L_PB_PB_ID ");
		sb.append("	  from L_PB_PB_PaymentBill ");
		sb.append("		   left join B_Departments on L_PB_PB_DepartmentID = B_DP_DepartmentID  ");
		sb.append("	  where B_DP_CompanysID = ? ");
		params.add(Utility.getName(po.getBspcompanyid()));
		
		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and L_PB_PB_SupplierID = ? ");
			params.add(Utility.getName(po.getBspid()));
		}
		sb.append("  )m ");
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select * from (select ROW_NUMBER() Over(order by bspstartprice desc) as rowNum,* from ( ");
		
		sb.append(" select temp.bspid,bspsuppliername,bspcontactperson,bspcontactphone,(isnull(temp.bspstartprice,0)+isnull(temp2.bspstartprice,0)) as bspstartprice from ( ");
		sb.append("select L_SC_SA_SubSupplierID as bspid,B_SP_SupplierName as bspsuppliername,B_SP_ContactPerson as bspcontactperson,B_SP_ContactPhone as bspcontactphone,isnull(m.B_SP_StartPrice,0) as bspstartprice ");		
		sb.append(" from L_SC_SupplierAccount left join B_SupplierAgent on L_SC_SA_SubSupplierID = B_SP_ID left join (select B_SP_SupplierID,B_SP_StartPrice from B_SupplierOpening where B_SP_CompanyID = ?)m on L_SC_SA_SubSupplierID = m.B_SP_SupplierID where 1=1 ");		

		params.add(Utility.getName(po.getBspcompanyid()));
		
		sb.append(" and L_SC_SA_BillID in (select C_ST_I_BillID from #billinfo) ");
		
		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and L_SC_SA_SupplierID=? ");
			params.add(Utility.getName(po.getBspid()));
		}
		if (!"".equals(Utility.getName(po.getStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_SC_SA_Date,120) >= ? ");
			params.add(Utility.getName(po.getStartDate()));
		}
		if (!"".equals(Utility.getName(po.getEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_SC_SA_Date,120) <= ? ");
			params.add(Utility.getName(po.getEndDate()));
		}
		sb.append(" group by L_SC_SA_SubSupplierID,B_SP_SupplierName,B_SP_ContactPerson,B_SP_ContactPhone,isnull(m.B_SP_StartPrice,0) ");
		sb.append(" )temp left join ( ");
		
		sb.append(" select bspid,bspstartprice from ( ");
		sb.append("select L_SC_SA_SubSupplierID as bspid,(isnull(sum(isnull(L_SC_SA_CostPriceAmount,0)),0)+isnull(sum(isnull(L_SC_SA_PayMentAmount,0)),0)+isnull(sum(isnull(L_SC_SA_PrePayAmount,0)),0)+isnull(sum(isnull(L_SC_SA_SupplierSubAmount,0)),0)+isnull(sum(isnull(L_SC_SA_ManualAmount,0)),0)) as bspstartprice ");		
		sb.append(" from L_SC_SupplierAccount left join B_SupplierAgent on L_SC_SA_SubSupplierID = B_SP_ID where 1=1 ");		

		sb.append(" and L_SC_SA_BillID in (select C_ST_I_BillID from #billinfo) ");
		
		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and L_SC_SA_SupplierID=? ");
			params.add(Utility.getName(po.getBspid()));
		}
		if (!"".equals(Utility.getName(po.getEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_SC_SA_Date,120) <= ? ");
			params.add(Utility.getName(po.getEndDate()));
		}
		sb.append(" group by L_SC_SA_SubSupplierID )temp ");		
		sb.append(" )temp2 on temp.bspid=temp2.bspid ");		
		sb.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0");
		
		sb.append(" drop table #billinfo ");
		
		return queryForObjectList(sb.toString(), params.toArray(),SupplierPo.class);
	}

	/**
	 * 查询制造商往来账明细
	 */
	public List<InventoryPo> getSupplierCurrentAccountDetail(SupplierPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("exec L_getSupplierCurrentAccountDetail ?,?,? ");
	
		params.add(Utility.getName(po.getStartDate()));	
		params.add(Utility.getName(po.getEndDate()));
		params.add(Utility.getName(po.getBspid()));	
		
		return queryForObjectList(sb.toString(), params.toArray(),InventoryPo.class);
	}
	
	/**
	 * 查询制造商期初金额
	 */
	public String getSupplierBeginningAccount(SupplierPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select isnull(sum(costPriceAmount),0.00)+(select top 1 isnull(B_SP_StartPrice,0.00) from B_SupplierOpening where B_SP_SupplierID = ? and B_SP_CompanyID = ?) from( ");	
		sb.append("select sum(C_ST_IE_CostPriceAmount) as costPriceAmount ");	
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");	
		sb.append("  where C_ST_I_BillTypeId in ('1','9') and C_ST_I_SupplierId=? ");	
		sb.append("        and convert(varchar(10),C_ST_I_FinanceAuditDate,120)>=(select top 1 L_BFD_Date from L_BFD_BalanceForwardDate) and convert(varchar(10),C_ST_I_FinanceAuditDate,120)<? ");	
		sb.append("union all ");	
		sb.append("select -sum(C_ST_IE_CostPriceAmount) as costPriceAmount ");	
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");	
		sb.append("  where C_ST_I_BillTypeId='2' and C_ST_I_SupplierId=? ");	
		sb.append("        and convert(varchar(10),C_ST_I_FinanceAuditDate,120)>=(select top 1 L_BFD_Date from L_BFD_BalanceForwardDate) and convert(varchar(10),C_ST_I_FinanceAuditDate,120)<? ");	
		sb.append("union all ");	
		sb.append("select -sum(L_PB_PB_CostPriceAmount) as costPriceAmount ");	
		sb.append("  from L_PB_PB_PaymentBill  ");	
		sb.append("  where L_PB_PB_AuditStatue='1' and L_PB_PB_SupplierID=? and isnull(L_PB_PB_PaymentType,'')='3' ");	
		sb.append("        and convert(varchar(10),L_PB_PB_AuditDate,120)>=(select top 1 L_BFD_Date from L_BFD_BalanceForwardDate) and convert(varchar(10),L_PB_PB_AuditDate,120)<? ");	
		sb.append("union all ");	
		sb.append("select -sum(L_PB_PBE_PayMentAmount) as costPriceAmount ");	
		sb.append("  from L_PB_PB_PaymentBill inner join L_PB_PBE_PaymentBillEntry on L_PB_PB_ID=L_PB_PBE_BillID ");	
		sb.append("  where L_PB_PB_AuditStatue='1' and L_PB_PB_SupplierID=? and isnull(L_PB_PB_PaymentType,'') not in ('3','4') ");	
		sb.append("        and convert(varchar(10),L_PB_PB_AuditDate,120)>=(select top 1 L_BFD_Date from L_BFD_BalanceForwardDate) and convert(varchar(10),L_PB_PB_AuditDate,120)<? ");	
		sb.append("union all ");	
		sb.append("select sum(L_PB_PBE_PayMentAmount) as costPriceAmount ");	
		sb.append("  from L_PB_PB_PaymentBill inner join L_PB_PBE_PaymentBillEntry on L_PB_PB_ID=L_PB_PBE_BillID ");	
		sb.append("  where L_PB_PB_AuditStatue='1' and L_PB_PB_SupplierID=? and isnull(L_PB_PB_PaymentType,'')='4' ");	
		sb.append("        and convert(varchar(10),L_PB_PB_AuditDate,120)>=(select top 1 L_BFD_Date from L_BFD_BalanceForwardDate) and convert(varchar(10),L_PB_PB_AuditDate,120)<? ");	
		sb.append(")temp ");	
	
		params.add(Utility.getName(po.getBspid()));
		params.add(Utility.getName(po.getBspcompanyid()));	
		params.add(Utility.getName(po.getBspid()));	
		params.add(Utility.getName(po.getStartDate()));	
		params.add(Utility.getName(po.getBspid()));	
		params.add(Utility.getName(po.getStartDate()));
		params.add(Utility.getName(po.getBspid()));	
		params.add(Utility.getName(po.getStartDate()));
		params.add(Utility.getName(po.getBspid()));	
		params.add(Utility.getName(po.getStartDate()));
		params.add(Utility.getName(po.getBspid()));	
		params.add(Utility.getName(po.getStartDate()));
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	/**
	 * 查询制造商期末金额
	 */
	public String getSupplierEndAccount(SupplierPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select isnull(sum(costPriceAmount),0.00)+(select top 1 isnull(B_SP_StartPrice,0.00) from B_SupplierOpening where B_SP_SupplierID = ? and B_SP_CompanyID = ?) from ( ");	
		sb.append("select sum(C_ST_IE_CostPriceAmount) as costPriceAmount ");	
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");	
		sb.append("  where C_ST_I_BillTypeId in ('1','9') and C_ST_I_SupplierId=? ");	
		sb.append("        and convert(varchar(10),C_ST_I_FinanceAuditDate,120)>=(select top 1 L_BFD_Date from L_BFD_BalanceForwardDate) and convert(varchar(10),C_ST_I_FinanceAuditDate,120)<=? ");	
		sb.append("union all ");	
		sb.append("select -sum(C_ST_IE_CostPriceAmount) as costPriceAmount ");	
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");	
		sb.append("  where C_ST_I_BillTypeId='2' and C_ST_I_SupplierId=? ");	
		sb.append("        and convert(varchar(10),C_ST_I_FinanceAuditDate,120)>=(select top 1 L_BFD_Date from L_BFD_BalanceForwardDate) and convert(varchar(10),C_ST_I_FinanceAuditDate,120)<=? ");	
		sb.append("union all ");	
		sb.append("select -sum(L_PB_PB_CostPriceAmount) as costPriceAmount ");	
		sb.append("  from L_PB_PB_PaymentBill ");	
		sb.append("  where L_PB_PB_AuditStatue='1' and L_PB_PB_SupplierID=? and isnull(L_PB_PB_PaymentType,'')='3' ");	
		sb.append("        and convert(varchar(10),L_PB_PB_AuditDate,120)>=(select top 1 L_BFD_Date from L_BFD_BalanceForwardDate) and convert(varchar(10),L_PB_PB_AuditDate,120)<=? ");	
		sb.append("union all ");	
		sb.append("select -sum(L_PB_PBE_PayMentAmount) as costPriceAmount ");	
		sb.append("  from L_PB_PB_PaymentBill inner join L_PB_PBE_PaymentBillEntry on L_PB_PB_ID=L_PB_PBE_BillID ");	
		sb.append("  where L_PB_PB_AuditStatue='1' and L_PB_PB_SupplierID=? and isnull(L_PB_PB_PaymentType,'') not in ('3','4') ");	
		sb.append("        and convert(varchar(10),L_PB_PB_AuditDate,120)>=(select top 1 L_BFD_Date from L_BFD_BalanceForwardDate) and convert(varchar(10),L_PB_PB_AuditDate,120)<=? ");	
		sb.append("union all ");	
		sb.append("select sum(L_PB_PBE_PayMentAmount) as costPriceAmount ");	
		sb.append("  from L_PB_PB_PaymentBill inner join L_PB_PBE_PaymentBillEntry on L_PB_PB_ID=L_PB_PBE_BillID ");	
		sb.append("  where L_PB_PB_AuditStatue='1' and L_PB_PB_SupplierID=? and isnull(L_PB_PB_PaymentType,'')='4' ");	
		sb.append("        and convert(varchar(10),L_PB_PB_AuditDate,120)>=(select top 1 L_BFD_Date from L_BFD_BalanceForwardDate) and convert(varchar(10),L_PB_PB_AuditDate,120)<=? ");	
		sb.append(")temp ");	
	
		params.add(Utility.getName(po.getBspid()));
		params.add(Utility.getName(po.getBspcompanyid()));	
		params.add(Utility.getName(po.getBspid()));	
		params.add(Utility.getName(po.getEndDate()));	
		params.add(Utility.getName(po.getBspid()));	
		params.add(Utility.getName(po.getEndDate()));
		params.add(Utility.getName(po.getBspid()));	
		params.add(Utility.getName(po.getEndDate()));
		params.add(Utility.getName(po.getBspid()));	
		params.add(Utility.getName(po.getEndDate()));
		params.add(Utility.getName(po.getBspid()));	
		params.add(Utility.getName(po.getEndDate()));
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	
	/**
	 * 查询付款单(简)总数
	 */
	public int getPayMentBillSimpleCount(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_PB_PB_ID)");		
		sb.append(" from L_PB_PB_PaymentBill left join B_Departments on L_PB_PB_DepartmentID = B_DP_DepartmentID where 1=1 ");		

		if (!"".equals(Utility.getName(po.getsLpbpbCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getsLpbpbCompanyID()));	
		}
		
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and L_PB_PB_ID like '%'+?+'%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and L_PB_PB_SupplierID=?");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbPayMentDptID()))){
			sb.append(" and L_PB_PB_PaymentDpt=?");
			params.add(Utility.getName(po.getsLpbpbPayMentDptID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(" and isNUll(L_PB_PB_AuditStatue,'0')=?");
			params.add(Utility.getName(po.getsLpbpbAuditStatue()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)>=?");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)<=?");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbCreatePersonID()))){
			sb.append(" and L_PB_PB_CreatePersonID=?");
			params.add(Utility.getName(po.getsLpbpbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbIsVoucher()))){
			sb.append(" and L_PB_PB_IsVoucher=?");
			params.add(Utility.getName(po.getsLpbpbIsVoucher()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbTypeID()))){
			sb.append(" and L_PB_PB_PaymentType=?");
			params.add(Utility.getName(po.getsLpbpbTypeID()));
		}else{
			sb.append(" and L_PB_PB_PaymentType in ('2','3','4','6','7','5') ");
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	/**
	 * 查询付款单(简)列表
	 */
	public List<PayMentBillPo> getPayMentBillSimpleList(PayMentBillPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.sLpbpbID as sLpbpbID,temp.sLpbpbSupplierID as sLpbpbSupplierID,temp.sLpbpbSupplierName as sLpbpbSupplierName,temp.sLpbpbDate as sLpbpbDate,temp.sLpbpbCreatePersonID as sLpbpbCreatePersonID,temp.sLpbpbCreatePersonName as sLpbpbCreatePersonName,");
		sb.append("temp.sLpbpbAuditDate as sLpbpbAuditDate,temp.sLpbpbAuditStatue as sLpbpbAuditStatue,");
		sb.append("temp.sLpbpbAuditPersonID as sLpbpbAuditPersonID,temp.sLpbpbAuditPersonName as sLpbpbAuditPersonName,temp.sLpbpbRemark as sLpbpbRemark,temp.sLpbpbPayMentAmount as sLpbpbPayMentAmount,temp.sLpbpbTypeID as sLpbpbTypeID ");
		
		sb.append(" from( select ROW_NUMBER() Over(order by L_PB_PB_Date desc) as rowNum,L_PB_PB_ID as sLpbpbID,L_PB_PB_SupplierID as sLpbpbSupplierID,L_PB_PB_Date as sLpbpbDate,L_PB_PB_CreatePersonID as sLpbpbCreatePersonID,a.personName as sLpbpbCreatePersonName,");
		sb.append("L_PB_PB_AuditDate as sLpbpbAuditDate,isNUll(L_PB_PB_AuditStatue,'0') as sLpbpbAuditStatue,");
		
		sb.append("L_PB_PB_AuditPersonID as sLpbpbAuditPersonID,a.personName as sLpbpbAuditPersonName,L_PB_PB_Remark as sLpbpbRemark,isnull(L_PB_PB_PayedMentAmount,0) as sLpbpbPayMentAmount ");
		sb.append(",(case isnull(B_SP_SupplierName,'') when '' then isnull(B_Departments.B_DP_DepartmentName,'') else isnull(B_SP_SupplierName,'') end) as sLpbpbSupplierName,L_PB_PB_PaymentType as sLpbpbTypeID ");		
		sb.append(" from L_PB_PB_PaymentBill  left join B_Departments ds on L_PB_PB_DepartmentID = ds.B_DP_DepartmentID left join SYS_PersonInfo a on L_PB_PB_CreatePersonID=a.ID left join SYS_PersonInfo b on L_PB_PB_AuditPersonID=b.ID ");	
		sb.append(" left join B_Supplier on L_PB_PB_SupplierID=B_SP_ID left join B_Departments on L_PB_PB_PaymentDpt=B_Departments.B_DP_DepartmentID where 1=1 ");	
	
		if (!"".equals(Utility.getName(po.getsLpbpbCompanyID()))){
		    sb.append(" and ds.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getsLpbpbCompanyID()));	
		}
		
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and L_PB_PB_ID like '%'+?+'%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and L_PB_PB_SupplierID=?");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbPayMentDptID()))){
			sb.append(" and L_PB_PB_PaymentDpt=?");
			params.add(Utility.getName(po.getsLpbpbPayMentDptID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(" and isNUll(L_PB_PB_AuditStatue,'0')=?");
			params.add(Utility.getName(po.getsLpbpbAuditStatue()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)>=?");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)<=?");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbCreatePersonID()))){
			sb.append(" and L_PB_PB_CreatePersonID=?");
			params.add(Utility.getName(po.getsLpbpbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbIsVoucher()))){
			sb.append(" and isnull(L_PB_PB_IsVoucher,'0')=?");
			params.add(Utility.getName(po.getsLpbpbIsVoucher()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbTypeID()))){
			sb.append(" and L_PB_PB_PaymentType=?");
			params.add(Utility.getName(po.getsLpbpbTypeID()));
		}else{
			sb.append(" and L_PB_PB_PaymentType in ('2','3','4','6','7','5') ");
		}
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" order by temp.sLpbpbDate desc set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),PayMentBillPo.class);
	}
	
	/**
	 * 查询付款单(简)列表（开窗）
	 */
	public List<PayMentBillPo> getPayMentBillSimpleOpenList(PayMentBillPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.sLpbpbID as sLpbpbID,temp.sLpbpbSupplierID as sLpbpbSupplierID,temp.sLpbpbSupplierName as sLpbpbSupplierName,temp.sLpbpbDate as sLpbpbDate,temp.sLpbpbCreatePersonID as sLpbpbCreatePersonID,temp.sLpbpbCreatePersonName as sLpbpbCreatePersonName,");
		sb.append("temp.sLpbpbAuditDate as sLpbpbAuditDate,temp.sLpbpbAuditStatue as sLpbpbAuditStatue,temp.sLpbpbCostPriceAmount as sLpbpbCostPriceAmount,temp.sLpbpbDiscountAmount as sLpbpbDiscountAmount,");
		sb.append("temp.sLpbpbAuditPersonID as sLpbpbAuditPersonID,temp.sLpbpbAuditPersonName as sLpbpbAuditPersonName,temp.sLpbpbRemark as sLpbpbRemark,temp.sLpbpbPayMentAmount as sLpbpbPayMentAmount ");
		
		sb.append(" from( select ROW_NUMBER() Over(order by L_PB_PB_Date desc) as rowNum,L_PB_PB_ID as sLpbpbID,L_PB_PB_SupplierID as sLpbpbSupplierID,L_PB_PB_Date as sLpbpbDate,L_PB_PB_CreatePersonID as sLpbpbCreatePersonID,a.personName as sLpbpbCreatePersonName,");
		sb.append("L_PB_PB_AuditDate as sLpbpbAuditDate,isNUll(L_PB_PB_AuditStatue,'0') as sLpbpbAuditStatue,");
		
		sb.append("L_PB_PB_AuditPersonID as sLpbpbAuditPersonID,a.personName as sLpbpbAuditPersonName,L_PB_PB_Remark as sLpbpbRemark,isnull(L_PB_PB_CostPriceAmount,0) as sLpbpbCostPriceAmount,(isnull(L_PB_PB_CostPriceAmount,0)-(select isnull(sum(L_PB_PBE_PayMentAmount),0) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_InvoiceID=L_PB_PB_ID)) as sLpbpbPayMentAmount,(select isnull(sum(L_PB_PBE_PayMentAmount),0) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_InvoiceID=L_PB_PB_ID) as sLpbpbDiscountAmount ");
		sb.append(",B_SP_SupplierName as sLpbpbSupplierName");		
		sb.append(" from L_PB_PB_PaymentBill left join SYS_PersonInfo a on L_PB_PB_CreatePersonID=a.ID left join SYS_PersonInfo b on L_PB_PB_AuditPersonID=b.ID ");	
		sb.append(" left join B_Supplier on L_PB_PB_SupplierID=B_SP_ID where L_PB_PB_PaymentType='3' ");	
	
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and L_PB_PB_ID like '%'+?+'%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and L_PB_PB_SupplierID=?");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(" and isNUll(L_PB_PB_AuditStatue,'0')=?");
			params.add(Utility.getName(po.getsLpbpbAuditStatue()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)>=?");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_Date,120)<=?");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_PB_PB_AuditDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbCreatePersonID()))){
			sb.append(" and L_PB_PB_CreatePersonID=?");
			params.add(Utility.getName(po.getsLpbpbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbIsVoucher()))){
			sb.append(" and isnull(L_PB_PB_IsVoucher,'0')=?");
			params.add(Utility.getName(po.getsLpbpbIsVoucher()));
		}

		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" order by temp.sLpbpbDate desc set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),PayMentBillPo.class);
	}
	
	/**
	 * 新增付款单(简)
	 */
	public void insertPayMentBillSimple(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_PB_PB_PaymentBill(L_PB_PB_ID,L_PB_PB_SupplierID,L_PB_PB_Date,L_PB_PB_DepartmentID,L_PB_PB_CreatePersonID,");
		sb.append("L_PB_PB_IsVoucher,L_PB_PB_CostPriceAmount,L_PB_PB_PayedMentAmount,L_PB_PB_DiscountAmount,L_PB_PB_Remark,L_PB_PB_PaymentDay,L_PB_PB_AuditStatue,L_PB_PB_PaymentType ");
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(",L_PB_PB_AuditPersonID,L_PB_PB_AuditDate ");
		}
		sb.append(",L_PB_PB_CurrentPayedMentAmount,L_PB_PB_SubSupplierID) values(?,?,getdate(),?,?,'0',?,?,'0.00',?,?,?,?");
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(",?,getdate() ");
		}
		sb.append(" ,?,?) ");
		
		params.add(Utility.getName(po.getsLpbpbID()));
		params.add(Utility.getName(po.getsLpbpbSupplierID()));
		params.add(Utility.getName(po.getsLpbpbDepartmentID()));
		params.add(Utility.getName(po.getsLpbpbCreatePersonID()));

		if (!"".endsWith(Utility.getName(po.getsLpbpbCostPriceAmount()))){
			params.add(Utility.getName(po.getsLpbpbCostPriceAmount()));
		}else{
			params.add("0.00");
		}
		if ("3".endsWith(Utility.getName(po.getsLpbpbTypeID()))){
			if (!"".endsWith(Utility.getName(po.getsLpbpbCostPriceAmount()))){
				params.add(Utility.getName(po.getsLpbpbCostPriceAmount()));
			}else{
				params.add("0.00");
			}
		}else{
			if (!"".endsWith(Utility.getName(po.getsLpbpbPayMentAmount()))){
				params.add(Utility.getName(po.getsLpbpbPayMentAmount()));
			}else{
				params.add("0.00");
			}
		}
		params.add(Utility.getName(po.getsLpbpbRemark()));
		params.add(Utility.getName(po.getsLpbpbDate()));
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			params.add("1");
			params.add(Utility.getName(po.getsLpbpbTypeID()));
			params.add(Utility.getName(po.getsLpbpbAuditPersonID()));
		}else{
			params.add("0");
			params.add(Utility.getName(po.getsLpbpbTypeID()));
		}
		if (!"".endsWith(Utility.getName(po.getsLpbpbCurrentPayMentAmount()))){
			params.add(Utility.getName(po.getsLpbpbCurrentPayMentAmount()));
		}else{
			params.add("0.00");
		}
		params.add(Utility.getName(po.getsLpbpbSubSupplierID()));
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 新增其他付款单明细
	 */
	public void insertPayMentBillSimpleEntry(PayMentBillEntryPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_PB_PBE_PaymentBillEntry(L_PB_PBE_ID,L_PB_PBE_BillID,L_PB_PBE_BillTypeID,L_PB_PBE_InvoiceID,L_PB_PBE_CostPriceAmount,");
		sb.append("L_PB_PBE_PayMentAmount,L_PB_PBE_Remark) ");
		sb.append(" values(?,?,'3',?,?,?,?)");
		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getsLpbpbeBillID()));
		params.add(Utility.getName(po.getsLpbpbeInvoiceID()));
		params.add(Utility.getName(po.getsLpbpbeCostPriceAmount()));
		params.add(Utility.getName(po.getsLpbpbePayMentAmount()));
		params.add(Utility.getName(po.getsLpbpbeRemark()));		
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 修改付款单(简)
	 */
	public void updatePayMentBillSimple(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_PB_PB_PaymentBill set L_PB_PB_Remark=?,L_PB_PB_CostPriceAmount=?,L_PB_PB_PayedMentAmount=?,L_PB_PB_CurrentPayedMentAmount=? ");
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			sb.append(",L_PB_PB_AuditStatue=?,L_PB_PB_AuditPersonID=?,L_PB_PB_AuditDate=getdate() ");
		}
		sb.append(" where L_PB_PB_ID=? ");
		
		params.add(Utility.getName(po.getsLpbpbRemark()));
		params.add(Utility.getName(po.getsLpbpbCostPriceAmount()).equals("") ? "0.00" : Utility.getName(po.getsLpbpbCostPriceAmount()));
		params.add(Utility.getName(po.getsLpbpbPayMentAmount()).equals("") ? "0.00" : Utility.getName(po.getsLpbpbPayMentAmount()));
		params.add(Utility.getName(po.getsLpbpbCurrentPayMentAmount()).equals("") ? "0.00" : Utility.getName(po.getsLpbpbCurrentPayMentAmount()));
		
		if ("1".endsWith(Utility.getName(po.getsLpbpbAuditStatue()))){
			params.add(Utility.getName(po.getsLpbpbAuditStatue()));
			params.add(Utility.getName(po.getsLpbpbAuditPersonID()));
		}
		params.add(Utility.getName(po.getsLpbpbID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 删除付款单(简)
	 */
	public void deletePayMentBillSimple(PayMentBillPo po){
		
	}
	
	/**
	 * 反审核付款单(简)
	 */
	public boolean auditUnPayMentBillSimple(PayMentBillPo po){
		return false;
	}
	
	/**
	 * 查询付款单(简)详情
	 */
	public PayMentBillPo getPayMentBillSimpleDetail(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select top 1 L_PB_PB_ID as sLpbpbID,B_SP_SupplierName as sLpbpbSupplierName,L_PB_PB_Date as sLpbpbDate,L_PB_PB_AuditDate as sLpbpbAuditDate,b.personName as sLpbpbAuditPersonName,");
		sb.append(" a.personName as sLpbpbCreatePersonName,L_PB_PB_Remark as sLpbpbRemark,L_PB_PB_PayedMentAmount as sLpbpbPayMentAmount,L_PB_PB_CurrentPayedMentAmount as sLpbpbCurrentPayMentAmount,L_PB_PB_PaymentType as sLpbpbTypeID,(case L_PB_PB_PaymentType when '2' then '采购付款' when '3' then '预付款' when '6' then '厂商减账' when '7' then '调账' when '5' then '其他付款' else '付款单' end) as sLpbpbTypeName from L_PB_PB_PaymentBill  ");
		sb.append(" left join SYS_PersonInfo a on L_PB_PB_CreatePersonID=a.ID left join SYS_PersonInfo b on L_PB_PB_AuditPersonID=b.ID ");	
		sb.append(" left join B_Supplier on L_PB_PB_SupplierID=B_SP_ID ");	
		sb.append(" where L_PB_PB_ID=? ");	
			
		params.add(Utility.getName(po.getsLpbpbID()));
		
		return (PayMentBillPo)queryForObject(sb.toString(), params.toArray(),PayMentBillPo.class);
	}
	
	/**
	 * 查询付款单(简)明细详情
	 */
	public List<PayMentBillEntryPo> getPayMentBillSimpleEntryDetail(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select L_PB_PBE_BillID as sLpbpbeBillID,L_PB_PBE_InvoiceID as sLpbpbeInvoiceID,L_PB_PBE_CostPriceAmount as sLpbpbeCostPriceAmount,L_PB_PBE_PayMentAmount as sLpbpbePayMentAmount,L_PB_PBE_Remark as sLpbpbeRemark, ");
		sb.append(" convert(varchar(10),C_ST_I_FinanceAuditDate,120) as sLpbpbePayedMentDate,(case C_ST_I_BillTypeId when '2' then '采购退货' else '采购收货' end) as sLpbpbeBillTypeID,(case C_ST_I_BillTypeId when '2' then -sum(C_ST_IE_CostPriceAmount) else sum(C_ST_IE_CostPriceAmount) end) as sCstieCostPriceAmount,(case C_ST_I_BillTypeId when '2' then (-sum(C_ST_IE_CostPriceAmount)-L_PB_PBE_CostPriceAmount) else (sum(C_ST_IE_CostPriceAmount)-L_PB_PBE_CostPriceAmount) end) as sLpbpbePayedMentAmount from L_PB_PBE_PaymentBillEntry inner join C_ST_InventoryEntry on L_PB_PBE_InvoiceID=C_ST_IE_BillID inner join C_ST_Inventory on L_PB_PBE_InvoiceID=C_ST_I_BillID ");	
		sb.append(" where L_PB_PBE_BillID=? group by L_PB_PBE_BillID,L_PB_PBE_BillTypeID,L_PB_PBE_InvoiceID,L_PB_PBE_CostPriceAmount,L_PB_PBE_PayMentAmount,L_PB_PBE_Remark,C_ST_I_FinanceAuditDate,C_ST_I_BillTypeId");	
		sb.append(" union all ");
		sb.append(" select L_PB_PBE_BillID as sLpbpbeBillID,L_PB_PBE_InvoiceID as sLpbpbeInvoiceID,L_PB_PBE_CostPriceAmount as sLpbpbeCostPriceAmount,L_PB_PBE_PayMentAmount as sLpbpbePayMentAmount,L_PB_PBE_Remark as sLpbpbeRemark, ");
		sb.append(" (select top 1 convert(varchar(10),L_PB_PB_Date,120) from L_PB_PB_PaymentBill where L_PB_PB_ID=L_PB_PBE_InvoiceID ) as sLpbpbePayedMentDate,'预付款单' as sLpbpbeBillTypeID,(select top 1 L_PB_PB_CostPriceAmount from L_PB_PB_PaymentBill where L_PB_PB_ID=L_PB_PBE_InvoiceID ) as sCstieCostPriceAmount,((select top 1 L_PB_PB_CostPriceAmount from L_PB_PB_PaymentBill where L_PB_PB_ID=L_PB_PBE_InvoiceID)-L_PB_PBE_CostPriceAmount) as sLpbpbePayedMentAmount from L_PB_PBE_PaymentBillEntry inner join L_PB_PB_PaymentBill on L_PB_PBE_BillID=L_PB_PB_ID ");	
		sb.append(" where L_PB_PB_PaymentType='4' and L_PB_PBE_BillID=? group by L_PB_PBE_BillID,L_PB_PBE_BillTypeID,L_PB_PBE_InvoiceID,L_PB_PBE_CostPriceAmount,L_PB_PBE_PayMentAmount,L_PB_PBE_Remark");	
				
		params.add(Utility.getName(po.getsLpbpbID()));
		params.add(Utility.getName(po.getsLpbpbID()));
		
		return queryForObjectList(sb.toString(), params.toArray(),PayMentBillEntryPo.class);
	}
	
	/**
	 * 查询采购单据总数
	 */
	public int getProcurementBillCount(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select sum(billIDCount) from ( select count(distinct billIDCount) as billIDCount from ( ");	
		sb.append(" select billIDCount,costPriceAmount,notPayMentAmount from ( select C_ST_I_BillID as billIDCount,isnull(sum(C_ST_IE_CostPriceAmount),0) as costPriceAmount, ");	
		sb.append("      isnull(sum(C_ST_IE_CostPriceAmount)-abs((select isnull(sum(L_PB_PBE_PayMentAmount),0.00) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_InvoiceID=C_ST_I_BillID )),0) as notPayMentAmount ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_IE_BillID=C_ST_I_BillID ");
		sb.append("       inner join SYS_PersonInfo a on C_ST_I_FinanceAuditPerson=a.id ");
		sb.append("       left join B_Warehouse on C_ST_I_InStockId = B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");
		sb.append("  where C_ST_I_FinanceAuditState='1' and C_ST_I_AuditState='1' ");
		sb.append("        and C_ST_I_BillTypeId in ('1','9') ");
		
		if (!"".equals(Utility.getName(po.getsLpbpbCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getsLpbpbCompanyID()));	
		}
		
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and C_ST_I_BillID like '%'+?+'%' ");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and C_ST_I_SupplierId=?");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_billDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_billDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_FinanceAuditDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_FinanceAuditDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		sb.append("  group by C_ST_I_BillID )t1 where 1=1 ");
		
		if ("1".equals(Utility.getName(po.getsLpbpbCheckStatus()))){
			sb.append("  and costPriceAmount = notPayMentAmount and costPriceAmount <> 0 ");
		}
		if ("2".equals(Utility.getName(po.getsLpbpbCheckStatus()))){
			sb.append("  and costPriceAmount <> notPayMentAmount and notPayMentAmount <> 0 ");
		}
		if ("3".equals(Utility.getName(po.getsLpbpbCheckStatus()))){
			sb.append("  and notPayMentAmount = 0 ");
		}		
		
		sb.append(" )t5 ");
		sb.append("union all ");
		sb.append("select count(distinct billIDCount) as billIDCount from ( ");
		sb.append(" select billIDCount,costPriceAmount,notPayMentAmount from ( select C_ST_I_BillID as billIDCount,-isnull(sum(C_ST_IE_CostPriceAmount),0) as costPriceAmount, ");	
		sb.append("      isnull(-sum(C_ST_IE_CostPriceAmount)-((select isnull(sum(L_PB_PBE_PayMentAmount),0.00) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_InvoiceID=C_ST_I_BillID )),0) as notPayMentAmount ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_IE_BillID=C_ST_I_BillID ");
		sb.append("       inner join SYS_PersonInfo a on C_ST_I_FinanceAuditPerson=a.id ");
		sb.append("       left join B_Warehouse on C_ST_I_OutStockId = B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");
		sb.append("  where C_ST_I_FinanceAuditState='1' and C_ST_I_AuditState='1' ");
		sb.append("        and C_ST_I_BillTypeId='2' ");
		
		if (!"".equals(Utility.getName(po.getsLpbpbCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getsLpbpbCompanyID()));	
		}
		
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and C_ST_I_BillID like '%'+?+'%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and C_ST_I_SupplierId=?");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_billDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_billDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_FinanceAuditDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_FinanceAuditDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		sb.append("  group by C_ST_I_BillID ) t2 where 1=1  ");
		
		if ("1".equals(Utility.getName(po.getsLpbpbCheckStatus()))){
			sb.append("  and costPriceAmount = notPayMentAmount and costPriceAmount <> 0 ");
		}
		if ("2".equals(Utility.getName(po.getsLpbpbCheckStatus()))){
			sb.append("  and costPriceAmount <> notPayMentAmount and notPayMentAmount <> 0 ");
		}
		if ("3".equals(Utility.getName(po.getsLpbpbCheckStatus()))){
			sb.append("  and notPayMentAmount = 0 ");
		}
		
		sb.append(" )temp )t3  ");
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	/**
	 * 查询采购单据列表
	 */
	public List<PayMentBillPo> getProcurementBillList(PayMentBillPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		
		sb.append("select temp.billID as sLpbpbID,temp.financeAuditDate as sLpbpbDate,temp.aduitPersonName as sLpbpbAuditPersonName,");
		sb.append("temp.costPriceAmount as sLpbpbCostPriceAmount,temp.notPayMentAmount as sLpbpbPayMentAmount,");
		sb.append("temp.payMentAmount as sLpbpbDiscountAmount ");
				
		sb.append(" from (select ROW_NUMBER() Over(order by financeAuditDate desc) as rowNum,billID as billID,deliveryID as deliveryID,billTypeId as billTypeId,financeAuditDate as financeAuditDate, ");
		sb.append("       aduitPersonName as aduitPersonName,billType as billType,costPriceAmount as costPriceAmount, ");
		sb.append("       payMentAmount as payMentAmount,notPayMentAmount as notPayMentAmount ");
		sb.append("from ( ");
		sb.append(" select * from ( select C_ST_I_BillID as billID,C_ST_I_DeliveryID as deliveryID,convert(varchar(10),C_ST_I_FinanceAuditDate,120) as financeAuditDate, ");
		sb.append("       a.personname as aduitPersonName,'采购收货' as billType,'1' as billTypeId, ");
		sb.append("       sum(C_ST_IE_CostPriceAmount) as costPriceAmount,(select isnull(sum(L_PB_PBE_PayMentAmount),0.00) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_InvoiceID=C_ST_I_BillID ) as payMentAmount, ");
		sb.append("      (sum(C_ST_IE_CostPriceAmount)-(select isnull(sum(L_PB_PBE_PayMentAmount),0.00) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_InvoiceID=C_ST_I_BillID )) as notPayMentAmount ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_IE_BillID=C_ST_I_BillID ");
		sb.append("       inner join SYS_PersonInfo a on C_ST_I_FinanceAuditPerson=a.id ");
		sb.append("       left join B_Warehouse on C_ST_I_InStockId = B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");
		sb.append("  where C_ST_I_FinanceAuditState='1' and C_ST_I_AuditState='1' ");
		sb.append("        and C_ST_I_BillTypeId in ('1','9') ");
		
		if (!"".equals(Utility.getName(po.getsLpbpbCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getsLpbpbCompanyID()));	
		}
		
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and C_ST_I_BillID like '%'+?+'%' ");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and C_ST_I_SupplierId=?");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_billDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_billDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_FinanceAuditDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_FinanceAuditDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		sb.append("  group by C_ST_I_BillID,C_ST_I_DeliveryID,C_ST_I_FinanceAuditDate,a.personname ");
		sb.append("  )t1 where 1=1 ");

		if ("1".equals(Utility.getName(po.getsLpbpbCheckStatus()))){
			sb.append("  and costPriceAmount = notPayMentAmount and costPriceAmount <> 0 ");
		}
		if ("2".equals(Utility.getName(po.getsLpbpbCheckStatus()))){
			sb.append("  and costPriceAmount <> notPayMentAmount and notPayMentAmount <> 0 ");
		}
		if ("3".equals(Utility.getName(po.getsLpbpbCheckStatus()))){
			sb.append("  and notPayMentAmount = 0 ");
		}
		
		sb.append("union all ");		
		sb.append(" select * from ( select C_ST_I_BillID as billID,C_ST_I_DeliveryID as deliveryID,convert(varchar(10),C_ST_I_FinanceAuditDate,120) as financeAuditDate, ");
		sb.append("       a.personname as aduitPersonName,'采购退货' as billType,'2' as billTypeId, ");
		sb.append("       -sum(C_ST_IE_CostPriceAmount) as costPriceAmount,(select isnull(sum(L_PB_PBE_PayMentAmount),0.00) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_InvoiceID=C_ST_I_BillID ) as payMentAmount, ");
		sb.append("      (-sum(C_ST_IE_CostPriceAmount)-(select isnull(sum(L_PB_PBE_PayMentAmount),0.00) from L_PB_PBE_PaymentBillEntry where L_PB_PBE_InvoiceID=C_ST_I_BillID )) as notPayMentAmount ");
		sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_IE_BillID=C_ST_I_BillID ");
		sb.append("       inner join SYS_PersonInfo a on C_ST_I_FinanceAuditPerson=a.id ");
		sb.append("       left join B_Warehouse on C_ST_I_OutStockId = B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");
		sb.append("  where C_ST_I_FinanceAuditState='1' and C_ST_I_AuditState='1' ");
		sb.append("        and C_ST_I_BillTypeId='2' ");
		
		if (!"".equals(Utility.getName(po.getsLpbpbCompanyID()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getsLpbpbCompanyID()));	
		}
		
		if (!"".equals(Utility.getName(po.getsLpbpbID()))){
			sb.append(" and C_ST_I_BillID like '%'+?+'%'");
			params.add(Utility.getName(po.getsLpbpbID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbSupplierID()))){
			sb.append(" and C_ST_I_SupplierId=?");
			params.add(Utility.getName(po.getsLpbpbSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbStartDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_billDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbEndDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_billDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_FinanceAuditDate,120)>=?");
			params.add(Utility.getName(po.getsLpbpbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLpbpbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),C_ST_I_FinanceAuditDate,120)<=?");
			params.add(Utility.getName(po.getsLpbpbAuditEndDate()));
		}
		sb.append("  group by C_ST_I_BillID,C_ST_I_DeliveryID,C_ST_I_FinanceAuditDate,a.personname ");
		sb.append("  )t2 where 1=1 ");

		if ("1".equals(Utility.getName(po.getsLpbpbCheckStatus()))){
			sb.append("  and costPriceAmount = notPayMentAmount and costPriceAmount <> 0 ");
		}
		if ("2".equals(Utility.getName(po.getsLpbpbCheckStatus()))){
			sb.append("  and costPriceAmount <> notPayMentAmount and notPayMentAmount <> 0 ");
		}
		if ("3".equals(Utility.getName(po.getsLpbpbCheckStatus()))){
			sb.append("  and notPayMentAmount = 0 ");
		}
		
		sb.append(")temp where 1=1 ");

		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" order by temp.financeAuditDate desc set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),PayMentBillPo.class);
	}
		
	/**
	 * 查询预付款单总数
	 */
	public int getAdvancePayMentBillCount(PayMentBillPo po){
		return 0;
	}

	/**
	 * 查询预付款单列表
	 */
	public List<PayMentBillPo> getAdvancePayMentBillList(PayMentBillPo po,int start,int size){
		return null;
	}
	
	
	/**
	 * 查询预付款单是否被预付退款
	 */
	public int isExistsAdvancePayMentBill(PayMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_PB_PBE_ID) from L_PB_PB_PaymentBill inner join L_PB_PBE_PaymentBillEntry on L_PB_PB_ID=L_PB_PBE_BillID ");		
		sb.append(" where L_PB_PB_PaymentType='4' and L_PB_PBE_InvoiceID=? ");		

		params.add(Utility.getName(po.getsLpbpbID()));
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询所有制造商期末金额
	 */
	public String getSupplierAccount(SupplierPo po){		
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select C_ST_I_BillID into #billinfo ");
		sb.append("  from ( ");
		sb.append("	select C_ST_I_BillID ");
		sb.append("	  from C_ST_Inventory  ");
		sb.append("		   left join B_Warehouse on C_ST_I_InStockId = B_WH_ID  ");
		sb.append("		   left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");
		sb.append("	  where C_ST_I_BillTypeId in ('1','9') ");
		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and C_ST_I_SupplierId = ? ");
			params.add(Utility.getName(po.getBspid()));
		}
		sb.append("			and B_DP_CompanysID = ? ");		
		params.add(Utility.getName(po.getBspcompanyid()));
		
		sb.append("	union ");
		sb.append("	select C_ST_I_BillID ");
		sb.append("	  from C_ST_Inventory  ");
		sb.append("		   left join B_Warehouse on C_ST_I_OutStockId = B_WH_ID  ");
		sb.append("		   left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");
		sb.append("	  where C_ST_I_BillTypeId = '2' ");
		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and C_ST_I_SupplierId = ? ");
			params.add(Utility.getName(po.getBspid()));
		}
		sb.append("			and B_DP_CompanysID = ? ");
		params.add(Utility.getName(po.getBspcompanyid()));
		sb.append("	union ");
		sb.append("	select L_PB_PB_ID ");
		sb.append("	  from L_PB_PB_PaymentBill ");
		sb.append("		   left join B_Departments on L_PB_PB_DepartmentID = B_DP_DepartmentID  ");
		sb.append("	  where B_DP_CompanysID = ? ");
		params.add(Utility.getName(po.getBspcompanyid()));
		
		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and L_PB_PB_SupplierID = ? ");
			params.add(Utility.getName(po.getBspid()));
		}
		sb.append("  )m ");
		
		sb.append(" select isnull(sum(isnull(bspstartprice,0)),0) from ( ");
		sb.append(" select bspid,(bspstartprice+isnull(m.B_SP_StartPrice,0)) as bspstartprice from ( ");
		sb.append("select L_SC_SA_SubSupplierID as bspid,(isnull(sum(isnull(L_SC_SA_CostPriceAmount,0)),0)+isnull(sum(isnull(L_SC_SA_PayMentAmount,0)),0)+isnull(sum(isnull(L_SC_SA_PrePayAmount,0)),0)+isnull(sum(isnull(L_SC_SA_SupplierSubAmount,0)),0)+isnull(sum(isnull(L_SC_SA_ManualAmount,0)),0)) as bspstartprice ");		
		sb.append(" from L_SC_SupplierAccount where 1=1 ");		

		sb.append(" and L_SC_SA_BillID in (select C_ST_I_BillID from #billinfo) ");
		
		if (!"".equals(Utility.getName(po.getBspid()))){
			sb.append(" and L_SC_SA_SupplierID=? ");
			params.add(Utility.getName(po.getBspid()));
		}
		if (!"".equals(Utility.getName(po.getEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_SC_SA_Date,120) <= ? ");
			params.add(Utility.getName(po.getEndDate()));
		}
		sb.append(" group by L_SC_SA_SubSupplierID )temp left join (select B_SP_SupplierID,B_SP_StartPrice from B_SupplierOpening where B_SP_CompanyID = ?)m on temp.bspid=m.B_SP_SupplierID )temp ");	
		
		params.add(Utility.getName(po.getBspcompanyid()));
		
		sb.append(" drop table #billinfo ");
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
}
