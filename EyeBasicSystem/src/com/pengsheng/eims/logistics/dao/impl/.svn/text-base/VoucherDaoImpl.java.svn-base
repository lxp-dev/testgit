/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherDaoImpl.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
**/
package com.pengsheng.eims.logistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.logistics.dao.VoucherDao;
import com.pengsheng.eims.logistics.persistence.AutoCostAccountPo;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.logistics.persistence.SalesShopPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.persistence.VoucherTallyPo;
import com.pengsheng.eims.logistics.persistence.VoucherTypePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class VoucherDaoImpl extends BaseJdbcDaoSupport implements VoucherDao {
	
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	/**
	 * Description：根据参数查询父类凭证类型是当前参数的详细信息
	 * @param     ：父类凭证类型ID
	 * @return    ：返回符合条件的凭证类型列表
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherTypePo> getVoucherTypeByID(String parentID){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select L_VT_VT_ID as sLvtvtId,L_VT_VT_TypeName as sLvtvtTypeName,isnull(L_VT_VT_ParentID,'0') as sLvtvtParentID ");
		sb.append(",(select count(b.L_VT_VT_ID) from  L_VT_VoucherType b where b.L_VT_VT_ParentID=a.L_VT_VT_ID) as  sLvtvtMinCount ");
		sb.append(" from L_VT_VoucherType a ");
		
		if (!"".equals(Utility.getName(parentID))){
			sb.append(" where isnull(a.L_VT_VT_ParentID,'0') = ?");
			params.add(parentID);
		}
		return queryForObjectList(sb.toString(), params.toArray(),VoucherTypePo.class);
	}
	
	/**
	 * Description：根据参数查询凭证总数
	 * @param     ：凭证实体
	 * @return    ：返回符合条件的凭证总数
	 */
	public int getVoucherCount(VoucherPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select count(L_V_V_ID)");		
		sb.append(" from L_V_Voucher inner join L_VT_VoucherType on L_V_V_VoucherTypeID=L_VT_VT_ID inner join SYS_PersonInfo on L_V_V_PersonID=ID where 1=1 ");		

		if (!"".equals(Utility.getName(po.getsLvvID()))){
			sb.append(" and L_V_V_ID like '%'+?+'%'");//quyanping
			params.add(po.getsLvvID());
		}
		if (!"".equals(Utility.getName(po.getsLvvSupplierID()))){
			sb.append(" and L_V_V_SupplierID=?");
			params.add(po.getsLvvSupplierID());
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append(" and isNUll(L_V_V_AuditStatue,'0')=?");
			params.add(po.getsLvvAuditStatue());
		}
		if (!"".equals(Utility.getName(po.getsLvvDateTopLimit()))){
			if (!"".equals(Utility.getName(po.getsLvvDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10) between ? and ?");
				params.add(po.getsLvvDateTopLimit());
				params.add(po.getsLvvDateLowerLimit());
			}else{
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)>=?");
				params.add(po.getsLvvDateTopLimit());
			}
		}else{
			if (!"".equals(Utility.getName(po.getsLvvDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)<=?");
				params.add(po.getsLvvDateLowerLimit());
			}
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditDateTopLimit()))){
			if (!"".equals(Utility.getName(po.getsLvvAuditDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10) between ? and ?");
				params.add(po.getsLvvAuditDateTopLimit());
				params.add(po.getsLvvAuditDateLowerLimit());
			}else{
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)>=?");
				params.add(po.getsLvvAuditDateTopLimit());
			}
		}else{
			if (!"".equals(Utility.getName(po.getsLvvAuditDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)<=?");
				params.add(po.getsLvvAuditDateLowerLimit());
			}
		}
		if (!"".equals(Utility.getName(po.getsLvvVoucherTypeID()))){
			sb.append(" and L_V_V_VoucherTypeID=?");
			params.add(po.getsLvvVoucherTypeID());
		}else{
			sb.append(" and L_VT_VT_ParentID not in ('3','11') ");
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
	 * Description：根据参数查询凭证信息
	 * @param     ：VoucherPo 凭证实体
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
	 * @return    ：返回符合条件的凭证信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherPo> getVoucherList(VoucherPo po,int start, int size){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.sLvvID as sLvvID,temp.sLvvSupplierID as sLvvSupplierID,temp.sLvvSupplierName as sLvvSupplierName,temp.sLvvDate as sLvvDate,temp.sLvvPersonID as sLvvPersonID,temp.sLvvPersonName as sLvvPersonName,");
		sb.append("temp.sLvvVoucherTypeID as sLvvVoucherTypeID,temp.sLvvVoucherTypeName as sLvvVoucherTypeName,temp.sLvvVoucherParentTypeID as sLvvVoucherParentTypeID,temp.sLvvBalanceMethod as sLvvBalanceMethod,temp.sLvvAuditDate as sLvvAuditDate,temp.sLvvAuditStatue as sLvvAuditStatue,");
		sb.append("temp.sLvvAuditPersonID as sLvvAuditPersonID,temp.sLvvHandlePersonID as sLvvHandlePersonID,temp.sLvvRemark as sLvvRemark,temp.sLvvNotTaxRateAmount as sLvvNotTaxRateAmount,temp.sLvvTaxAmount as sLvvTaxAmount,temp.sLvvCostPriceAmount as sLvvCostPriceAmount,temp.sLvvPosting as sLvvPosting ");
		sb.append(" from( select ROW_NUMBER() Over(order by L_V_V_Date desc) as rowNum,L_V_V_ID as sLvvID,L_V_V_SupplierID as sLvvSupplierID,L_V_V_Date as sLvvDate,L_V_V_PersonID as sLvvPersonID,personName as sLvvPersonName,");
		sb.append("L_V_V_VoucherTypeID as sLvvVoucherTypeID,L_VT_VT_TypeName as sLvvVoucherTypeName,L_VT_VT_ParentID as sLvvVoucherParentTypeID,L_V_V_BalanceMethod as sLvvBalanceMethod,L_V_V_AuditDate as sLvvAuditDate,isNUll(L_V_V_AuditStatue,'0') as sLvvAuditStatue,");
		sb.append("L_V_V_AuditPersonID as sLvvAuditPersonID,L_V_V_HandlePersonID as sLvvHandlePersonID,L_V_V_Remark as sLvvRemark,isnull(L_V_V_NotTaxRateAmount,0) as sLvvNotTaxRateAmount,isnull(L_V_V_TaxAmount,0) as sLvvTaxAmount,isnull(L_V_V_CostPriceAmount,0) as sLvvCostPriceAmount,isnull(L_V_V_Posting,'0') as sLvvPosting ");
		sb.append(",(select B_SP_SupplierName from B_Supplier where B_SP_ID=L_V_V_SupplierID) as sLvvSupplierName");		
		sb.append(" from L_V_Voucher inner join L_VT_VoucherType on L_V_V_VoucherTypeID=L_VT_VT_ID inner join SYS_PersonInfo on L_V_V_PersonID=ID where 1=1 ");		
	
		if (!"".equals(Utility.getName(po.getsLvvID()))){
			sb.append(" and L_V_V_ID like '%'+?+'%'");//quyanping
			params.add(po.getsLvvID());
		}
		if (!"".equals(Utility.getName(po.getsLvvSupplierID()))){
			sb.append(" and L_V_V_SupplierID=?");
			params.add(po.getsLvvSupplierID());
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append(" and isnull(L_V_V_AuditStatue,'0')=?");
			params.add(po.getsLvvAuditStatue());
		}
		if (!"".equals(Utility.getName(po.getsLvvDateTopLimit()))){
			if (!"".equals(Utility.getName(po.getsLvvDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10) between ? and ?");
				params.add(po.getsLvvDateTopLimit());
				params.add(po.getsLvvDateLowerLimit());
			}else{
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)>=?");
				params.add(po.getsLvvDateTopLimit());
			}
		}else{
			if (!"".equals(Utility.getName(po.getsLvvDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)<=?");
				params.add(po.getsLvvDateLowerLimit());
			}
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditDateTopLimit()))){
			if (!"".equals(Utility.getName(po.getsLvvAuditDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10) between ? and ?");
				params.add(po.getsLvvAuditDateTopLimit());
				params.add(po.getsLvvAuditDateLowerLimit());
			}else{
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)>=?");
				params.add(po.getsLvvAuditDateTopLimit());
			}
		}else{
			if (!"".equals(Utility.getName(po.getsLvvAuditDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)<=?");
				params.add(po.getsLvvAuditDateLowerLimit());
			}
		}
		if (!"".equals(Utility.getName(po.getsLvvVoucherTypeID()))){
			sb.append(" and L_V_V_VoucherTypeID=?");
			params.add(po.getsLvvVoucherTypeID());
		}else{
			if ("3".equals(Utility.getName(po.getsLvvVoucherParentTypeID()))){
				sb.append(" and L_VT_VT_ParentID='3' ");
			}else if ("11".equals(Utility.getName(po.getsLvvVoucherParentTypeID()))){
				sb.append(" and L_VT_VT_ParentID='11' ");
			}else{
				sb.append(" and L_VT_VT_ParentID not in ('3','11') ");
			}			
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
	 * Description：根据参数查询凭证信息
	 * @param     ：VoucherPo 凭证实体
	 * @return    ：返回符合条件的凭证信息列表
	 */
	public List<VoucherPo> getVoucherList(VoucherPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select L_V_V_ID as sLvvID from L_V_Voucher ");	
		sb.append(" where L_V_V_PersonID=? and L_V_V_AuditStatue='1' and isnull(L_V_V_Posting,0)='0' ");
		
		params.add(po.getsLvvPersonID());
		return queryForObjectList(sb.toString(), params.toArray(),VoucherPo.class);
	}
	
	/**
	 * Description：根据参数查询凭证明细(单据)信息总数
	 * @param     ：凭证明细实体
	 * @return    ：返回符合条件的凭证明细(单据)信息总数
	 */	
	public int getVoucherEntryByBillsCount(VoucherEntryPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(*) from L_VE_VoucherEntry left join B_GoodsInfo on L_VE_VE_GoodsID=B_GI_GoodsID ");
		sb.append(" where L_VE_VE_VoucherID=?");
		
		params.add(po.getsLveveID());		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}	
	
	/**
	 * Description：根据参数查询凭证明细(单据)信息
	 * @param     ：VoucherEntryPo 凭证明细实体
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
	 * @return    ：返回符合条件的凭证明细(单据)信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getVoucherEntryByBillsList(VoucherEntryPo po,int start, int size){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.sLveveBillID,temp.sLveveGoodsID as sLveveGoodsID,temp.sGoodsName as sGoodsName,temp.sSpec as sSpec,temp.sGoodsQuantity as sGoodsQuantity,temp.sNotTaxRate as sNotTaxRate,");
		sb.append("temp.sNotTaxRateAmount as sNotTaxRateAmount,temp.sTaxRate as sTaxRate,temp.sCostPrice as sCostPrice,temp.sTaxAmount as sTaxAmount,temp.sCostPriceAmount as sCostPriceAmount ");
		sb.append(" from( select ROW_NUMBER() Over(order by L_VE_VE_ID) as rowNum,L_VE_VE_BillID as sLveveBillID,L_VE_VE_GoodsID as sLveveGoodsID,B_GI_ViewGoodsName as sGoodsName,B_GI_Spec as sSpec,isnull(L_VE_VE_CheckNumber,0) as sGoodsQuantity,");
		sb.append(" isnull(L_VE_VE_NotTaxRate,0) as sNotTaxRate,isnull(L_VE_VE_NotTaxRateAmount,0) as sNotTaxRateAmount,isnull(L_VE_VE_TaxRate,0) as sTaxRate,isnull(L_VE_VE_CostPrice,0) as sCostPrice,isnull(L_VE_VE_TaxAmount,0) as sTaxAmount,isnull(L_VE_VE_CostPriceAmount,0) as sCostPriceAmount ");
		sb.append(" from L_VE_VoucherEntry left join B_GoodsInfo on L_VE_VE_GoodsID=B_GI_GoodsID ");
		sb.append(" where L_VE_VE_VoucherID=?");
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0");
		
		params.add(po.getsLveveID());
		return queryForObjectList(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * Description：根据参数查询凭证明细(单据)信息
	 * @param     ：VoucherEntryPo 凭证明细实体
	 * @return    ：返回符合条件的凭证明细(单据)信息列表
	 */
	public List<VoucherEntryPo> getVoucherEntryByBillsList(VoucherEntryPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select temp.sLveveBillID,temp.sLveveGoodsID as sLveveGoodsID,temp.sGoodsName as sGoodsName,temp.sSpec as sSpec,temp.sGoodsQuantity as sGoodsQuantity,temp.sNotTaxRate as sNotTaxRate,");
		sb.append("temp.sNotTaxRateAmount as sNotTaxRateAmount,temp.sTaxRate as sTaxRate,temp.sCostPrice as sCostPrice,temp.sTaxAmount as sTaxAmount,temp.sCostPriceAmount as sCostPriceAmount ");
		sb.append(" from( select L_VE_VE_BillID as sLveveBillID,L_VE_VE_GoodsID as sLveveGoodsID,B_GI_ViewGoodsName as sGoodsName,B_GI_Spec as sSpec,isnull(L_VE_VE_CheckNumber,0) as sGoodsQuantity,");
		sb.append(" isnull(L_VE_VE_NotTaxRate,0) as sNotTaxRate,isnull(L_VE_VE_NotTaxRateAmount,0) as sNotTaxRateAmount,isnull(L_VE_VE_TaxRate,0) as sTaxRate,isnull(L_VE_VE_CostPrice,0) as sCostPrice,isnull(L_VE_VE_TaxAmount,0) as sTaxAmount,isnull(L_VE_VE_CostPriceAmount,0) as sCostPriceAmount ");
		sb.append(" from L_VE_VoucherEntry left join B_GoodsInfo on L_VE_VE_GoodsID=B_GI_GoodsID ");
		sb.append(" where L_VE_VE_VoucherID=?");
		sb.append(" ) temp ");
		
		params.add(po.getsLveveID());
		return queryForObjectList(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * Description：根据参数查询其父类凭证类型ID
	 * @param     ：凭证ID
	 * @return    ：返回符合条件的凭证类型列表
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherTypePo> getVoucherParentTypeByID(String voucherID){
		StringBuffer sb = new StringBuffer();		
		sb.append("select L_VT_VT_ParentID as sLvtvtParentID from L_V_Voucher inner join L_VT_VoucherType on L_V_V_VoucherTypeID=L_VT_VT_ID ");
		sb.append(" where L_V_V_ID=?");
		
		List<String> params = new ArrayList<String>();
		params.add(voucherID);
		
		return queryForObjectList(sb.toString(),params.toArray(),VoucherTypePo.class);
	}
	
	/**
	 * Description：根据参数查询其父类凭证类型名称
	 * @param     ：凭证ID
	 * @return    ：返回符合条件的凭证类型类型名称
	 */
	public String getVoucherTypeName(String id){
		StringBuffer sb = new StringBuffer();		
		sb.append("select top 1  L_VT_VT_TypeName as sLvtvtTypeName from L_VT_VoucherType where L_VT_VT_ID = ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(id);
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	/**
	 * Description：根据参数删除凭证信息
	 * @param     ：凭证ID
	 */
	public void deleteVoucherByID(String voucherID){
		StringBuffer sb = new StringBuffer();		
		sb.append("delete from L_V_Voucher where L_V_V_ID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(voucherID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据参数删除凭证明细信息
	 * @param     ：凭证ID
	 */
	public void deleteVoucherEntryByID(String voucherID){
		StringBuffer sb = new StringBuffer();		
		sb.append("delete from L_VE_VoucherEntry where L_VE_VE_VoucherID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(voucherID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据参数删除记账凭证信息
	 * @param     ：凭证ID
	 */
	public void deleteVoucherTallyByID(String voucherID){
		StringBuffer sb = new StringBuffer();		
		sb.append("delete from L_VT_VoucherTally where L_VT_VT_VoucherID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(voucherID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据参数修改凭证信息
	 * @param     ：凭证ID
	 */
	public void updateVoucherByID(VoucherPo voucherPo){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_V_Voucher set ");
		if (!"".equals(Utility.getName(voucherPo.getsLvvAuditStatue()))){
			sb.append("L_V_V_AuditStatue=?");
			params.add(voucherPo.getsLvvAuditStatue());
		}
		if (!"".equals(Utility.getName(voucherPo.getsLvvDate()))){
			sb.append(",L_V_V_Date=?");
			params.add(voucherPo.getsLvvDate()+" 23:00:00.00");
		}
		if (!"".equals(Utility.getName(voucherPo.getsLvvVoucherTypeID()))){
			sb.append(",L_V_V_VoucherTypeID=?");
			params.add(voucherPo.getsLvvVoucherTypeID());
		}
		if (!"".equals(Utility.getName(voucherPo.getsLvvRemark()))){
			sb.append(",L_V_V_Remark=?");
			params.add(voucherPo.getsLvvRemark());
		}
		if (!"".equals(Utility.getName(voucherPo.getsLvvHandlePersonID()))){
			sb.append(",L_V_V_HandlePersonID=?");
			params.add(voucherPo.getsLvvHandlePersonID());
		}
		if (!"".equals(Utility.getName(voucherPo.getsLvvBalanceMethod()))){
			sb.append(",L_V_V_BalanceMethod=?");
			params.add(voucherPo.getsLvvBalanceMethod());
		}
		if ("1".equals(Utility.getName(voucherPo.getsLvvAuditStatue()))){
			sb.append(",L_V_V_AuditPersonID=?,L_V_V_AuditDate=getDate()");
			params.add(voucherPo.getsLvvAuditPersonID());
		}
		if (!"".equals(Utility.getName(voucherPo.getsLvvNotTaxRateAmount()))){
			sb.append(",L_V_V_NotTaxRateAmount=? ");
			params.add(voucherPo.getsLvvNotTaxRateAmount());
		}
		if (!"".equals(Utility.getName(voucherPo.getsLvvTaxAmount()))){
			sb.append(",L_V_V_TaxAmount=? ");
			params.add(voucherPo.getsLvvTaxAmount());
		}
		if (!"".equals(Utility.getName(voucherPo.getsLvvCostPriceAmount()))){
			sb.append(",L_V_V_CostPriceAmount=? ");
			params.add(voucherPo.getsLvvCostPriceAmount());
		}
		sb.append(" where L_V_V_ID=?");
		params.add(voucherPo.getsLvvID());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据参数修改凭证明细信息
	 * @param     ：凭证ID
	 */
	public void updateVoucherEntryByID(VoucherEntryPo po){		
		insertVoucherEntry(po);
	}
	
	/**
	 * Description：新增凭证
	 * @param     ：凭证实体
	 */
	public void insertVoucher(VoucherPo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_V_Voucher(L_V_V_ID,L_V_V_SupplierID,L_V_V_PersonID,L_V_V_VoucherTypeID,L_V_V_Remark,");
		sb.append("L_V_V_NotTaxRateAmount,L_V_V_TaxAmount,L_V_V_CostPriceAmount,L_V_V_Posting,L_V_V_AuditStatue,L_V_V_PaymentDay ");
		if ("1".endsWith(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append(",L_V_V_AuditPersonID,L_V_V_AuditDate,L_V_V_AuditDptID ");
		}		
		sb.append(",L_V_V_DepartmentID,L_V_V_TypeID,L_V_V_CreateDptID,L_V_V_FranchiseeID,L_V_V_SubSupplierID) values(?,?,?,?,?,?,?,?,'0',?,?");
		if ("1".endsWith(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append(",?,getdate(),?");
		}
		sb.append(" ,?,?,?,?,?) ");
		
		params.add(Utility.getName(po.getsLvvID()));
		params.add(Utility.getName(po.getsLvvSupplierID()));
		params.add(Utility.getName(po.getsLvvPersonID()));
		params.add(Utility.getName(po.getsLvvVoucherTypeID()));
		params.add(Utility.getName(po.getsLvvRemark()));
		if (!"".endsWith(Utility.getName(po.getsLvvNotTaxRateAmount()))){
			params.add(Utility.getName(po.getsLvvNotTaxRateAmount()));
		}else{
			params.add("0.00");
		}
		if (!"".endsWith(Utility.getName(po.getsLvvTaxAmount()))){
			params.add(Utility.getName(po.getsLvvTaxAmount()));
		}else{
			params.add("0.00");
		}
		if (!"".endsWith(Utility.getName(po.getsLvvCostPriceAmount()))){
			params.add(Utility.getName(po.getsLvvCostPriceAmount()));
		}else{
			params.add("0.00");
		}
		params.add(Utility.getName(po.getsLvvAuditStatue()).equals("") ? "0" : Utility.getName(po.getsLvvAuditStatue()));
		params.add(Utility.getName(po.getsLvvDate()));
		if ("1".endsWith(Utility.getName(po.getsLvvAuditStatue()))){
			params.add(Utility.getName(po.getsLvvPersonID()));
			params.add(Utility.getName(po.getsLvvAuditDptID()));
		}
		
		params.add(Utility.getName(po.getsLvvDepartmentID()));
		params.add(Utility.getName(po.getsLvvTypeID()));
		params.add(Utility.getName(po.getsLvvCreateDptID()));	
		params.add(Utility.getName(po.getsLvvFranchiseeDptID()));
		params.add(Utility.getName(po.getsLvvSubSupplierID()));
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * Description：新增凭证明细
	 * @param     ：凭证明细实体
	 */
	public void insertVoucherEntry(VoucherEntryPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("insert into L_VE_VoucherEntry(L_VE_VE_ID,L_VE_VE_VoucherID,L_VE_VE_BillID,L_VE_VE_GoodsID,L_VE_VE_CheckNumber,L_VE_VE_NotTaxRate,L_VE_VE_NotTaxRateAmount,L_VE_VE_TaxRate,L_VE_VE_CostPrice,L_VE_VE_TaxAmount,L_VE_VE_CostPriceAmount) ");
		sb.append(" values(?,?,?,?,?,?,?,?,?,?,?)");
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(po.getsLveveVoucherID());
		params.add(po.getsLveveBillID());
		params.add(po.getsLveveGoodsID());
		if (!"".equals(Utility.getName(po.getsGoodsQuantity()))){
			params.add(po.getsGoodsQuantity());		
		}else{
			params.add("0");		
		}
		if (!"".equals(Utility.getName(po.getsGoodsQuantity()))){
			try {
				params.add(Float.valueOf(po.getsNotTaxRate()).toString());
			} catch (Exception e) {
				params.add("0");
			}	
		}else{
			params.add("0");		
		}
		if (!"".equals(Utility.getName(po.getsGoodsQuantity()))){
			try {
				params.add(Float.valueOf(po.getsNotTaxRateAmount()).toString());
			} catch (Exception e) {
				params.add("0");
			}	
		}else{
			params.add("0");		
		}
		if (!"".equals(Utility.getName(po.getsGoodsQuantity()))){
			try {
				params.add(Float.valueOf(po.getsTaxRate()).toString());
			} catch (Exception e) {
				params.add("0");
			}
		}else{
			params.add("0");
		}
		if (!"".equals(Utility.getName(po.getsGoodsQuantity()))){
			try {
				params.add(Float.valueOf(po.getsCostPrice()).toString());
			} catch (Exception e) {
				params.add("0");
			}
		}else{
			params.add("0");		
		}
		if (!"".equals(Utility.getName(po.getsGoodsQuantity()))){
			try {
				params.add(Float.valueOf(po.getsTaxAmount()).toString());
			} catch (Exception e) {
				params.add("0");
			}
		}else{
			params.add("0");		
		}
		if (!"".equals(Utility.getName(po.getsGoodsQuantity()))){
			try {
				params.add(Float.valueOf(po.getsCostPriceAmount()).toString());
			} catch (Exception e) {
				params.add("0");
			}
		}else{
			params.add("0");		
		}
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * Description：查询符合条件的发票总数
	 * @param     ：凭证号
     * @return    ：返回符合条件的发票总数
	 */
	public int getInvoiceCount(String voucherID){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();		
		sb.append("select count(L_I_I_ID)");
		sb.append(" from L_I_Invoice inner join B_Supplier on L_I_I_SupplierID=B_SP_ID inner join B_Departments on L_I_I_DepartmentID=B_DP_DepartmentID inner join SYS_PersonInfo on L_I_I_AuditPersonID=ID ");
		sb.append(" where  L_I_I_ID in ( select L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=? )");
		
		params.add(voucherID);
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * Description：查询发票基本信息
	 * @param     ：凭证号
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
     * @return    ：返回符合条件的发票列表
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getInvoiceList(String voucherID,int start, int size){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.sLveveBillID as sLveveBillID,temp.sDate as sDate,temp.sSupplierName as sSupplierName,temp.sDepartment as sDepartment,temp.sPersonID as sPersonID ");
		sb.append("from ( select ROW_NUMBER() Over(order by L_I_I_ID) as rowNum,L_I_I_ID as sLveveBillID,L_I_I_Date as sDate,B_SP_SupplierName as sSupplierName,B_DP_DepartmentName as sDepartment,personName as sPersonID ");
		sb.append("from L_I_Invoice inner join B_Supplier on L_I_I_SupplierID=B_SP_ID inner join B_Departments on L_I_I_DepartmentID=B_DP_DepartmentID inner join SYS_PersonInfo on L_I_I_AuditPersonID=ID ");
		sb.append(" where  L_I_I_ID in ( select L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=? )");
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0");
		
		params.add(voucherID);
		return queryForObjectList(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * Description：查询发票基本信息
	 * @param     ：凭证号
     * @return    ：返回符合条件的发票列表
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getInvoiceList(String voucherID){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select temp.sLveveBillID as sLveveBillID,temp.sDate as sDate,temp.sSupplierName as sSupplierName,temp.sDepartment as sDepartment,temp.sPersonID as sPersonID ");
		sb.append(",round(temp.sNotTaxRateAmount,2) as sNotTaxRateAmount,temp.sTaxAmount as sTaxAmount,temp.sCostPriceAmount as sCostPriceAmount ");
		sb.append("from ( select L_I_I_ID as sLveveBillID,L_I_I_Date as sDate,B_SP_SupplierName as sSupplierName,B_DP_DepartmentName as sDepartment,personName as sPersonID ");
		sb.append(",sum(round(L_IE_IE_NotTaxRateAmount,2)) as sNotTaxRateAmount,sum(L_IE_IE_TaxAmount) as sTaxAmount,sum(L_IE_IE_CostPriceAmount) as sCostPriceAmount ");
		sb.append("from L_I_Invoice inner join B_Supplier on L_I_I_SupplierID=B_SP_ID inner join B_Departments on L_I_I_DepartmentID=B_DP_DepartmentID inner join SYS_PersonInfo on L_I_I_AuditPersonID=ID ");
		sb.append(" left join L_IE_InvoiceEntry on L_I_I_ID=L_IE_IE_InvoiceID ");
		sb.append(" where L_I_I_ID in ( select L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=? )");
		sb.append(" group by L_I_I_ID,L_I_I_Date,B_SP_SupplierName,B_DP_DepartmentName,personName ");
		sb.append(" ) temp ");
		
		params.add(voucherID);
		return queryForObjectList(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * Description：查询冲回基本信息
	 * @param     ：凭证号
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
     * @return    ：返回符合条件的冲回列表
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getReversalList(String voucherID,int start, int size){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.sLveveBillID as sLveveBillID,temp.sDate as sDate,temp.sSupplierName as sSupplierName,temp.sDepartment as sDepartment,temp.sPersonID as sPersonID ");
		sb.append("from ( select ROW_NUMBER() Over(order by L_I_R_ID) as rowNum,L_I_R_ID as sLveveBillID,L_I_R_Date as sDate,B_SP_SupplierName as sSupplierName,B_DP_DepartmentName as sDepartment,personName as sPersonID ");
		sb.append("from L_R_Reversal inner join B_Supplier on L_I_R_SupplierID=B_SP_ID inner join B_Departments on L_I_R_DepartmentID=B_DP_DepartmentID inner join SYS_PersonInfo on L_I_R_CreatePersonID=ID ");
		sb.append(" where  L_I_R_ID in ( select L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=? )");
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0");
		
		params.add(voucherID);
		return queryForObjectList(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * Description：查询冲回基本信息
	 * @param     ：凭证号
     * @return    ：返回符合条件的冲回列表
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getReversalList(String voucherID){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		sb.append("select temp.sLveveBillID as sLveveBillID,temp.sDate as sDate,temp.sSupplierName as sSupplierName,temp.sDepartment as sDepartment,temp.sPersonID as sPersonID ");
		sb.append(",round(temp.sNotTaxRateAmount,2) as sNotTaxRateAmount,temp.sTaxAmount as sTaxAmount,temp.sCostPriceAmount as sCostPriceAmount ");
		sb.append("from ( select L_I_R_ID as sLveveBillID,L_I_R_Date as sDate,B_SP_SupplierName as sSupplierName,B_DP_DepartmentName as sDepartment,personName as sPersonID ");
		sb.append(",sum(round(L_IE_RE_NotTaxRateAmount,2)) as sNotTaxRateAmount,sum(L_IE_RE_TaxAmount) as sTaxAmount,sum(L_IE_RE_CostPriceAmount) as sCostPriceAmount ");
		sb.append("from L_R_Reversal inner join B_Supplier on L_I_R_SupplierID=B_SP_ID inner join B_Departments on L_I_R_DepartmentID=B_DP_DepartmentID inner join SYS_PersonInfo on L_I_R_CreatePersonID=ID ");
		sb.append(" left join L_RE_ReversalEntry on L_I_R_ID=L_IE_RE_InvoiceID ");
		sb.append(" where  L_I_R_ID in ( select L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=? )");
		sb.append(" group by L_I_R_ID,L_I_R_Date,B_SP_SupplierName,B_DP_DepartmentName,personName ");
		sb.append(" ) temp ");
			
		params.add(voucherID);
		return queryForObjectList(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * Description：查询符合条件的冲回记录总数
	 * @param     ：凭证号
     * @return    ：返回符合条件的冲回记录总数
	 */
	public int getReversalCount(String voucherID){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();		
		sb.append("select count(L_I_R_ID)");
		sb.append(" from L_R_Reversal inner join B_Supplier on L_I_R_SupplierID=B_SP_ID inner join B_Departments on L_I_R_DepartmentID=B_DP_DepartmentID inner join SYS_PersonInfo on L_I_R_CreatePersonID=ID ");
		sb.append(" where  L_I_R_ID in ( select L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=? )");
		
		params.add(voucherID);
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * Description：查询符合条件的冲回明细总数
	 * @param     ：冲回实体
     * @return    ：返回符合条件的冲回明细总数
	 */
	public int getReversalEntryCount(InvoiceEntryPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT count(L_IE_RE_InvoiceID) FROM L_RE_ReversalEntry where L_IE_RE_InvoiceID=?");
		
		params.add(po.getLieieinvoiceid());
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * Description：查询符合条件的冲回明细信息
	 * @param     ：冲回实体
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
     * @return    ：返回符合条件的冲回明细信息
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceEntryPo> getReversalEntryPoList(InvoiceEntryPo po,int start, int size){
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT temp.lieiebillid as lieiebillid,temp.lieiegoodsid AS lieiegoodsid,temp.lieiegoodsname AS lieiegoodsname,temp.lieiegoodsquantity AS lieiegoodsquantity,");
		sb.append("temp.lieiecheckgoodsquantity as lieiecheckgoodsquantity,temp.lieiecostpriceamount as lieiecostpriceamount ,");
		sb.append("temp.lieiespec as lieiespec,temp.lieienottaxrate as lieienottaxrate,temp.lieienottaxrateamount as lieienottaxrateamount, ");
		sb.append("temp.lieiecostprice as lieiecostprice,temp.lieietaxamount as lieietaxamount ");		
		sb.append(" from(SELECT ROW_NUMBER() Over(order by L_IE_RE_ID) as rowNum,L_IE_RE_BillID AS lieiebillid,L_IE_RE_GoodsID AS lieiegoodsid,L_IE_RE_GoodsName AS lieiegoodsname,L_IE_RE_GoodsQuantity AS lieiegoodsquantity,");
		sb.append("L_IE_RE_CheckGoodsQuantity as lieiecheckgoodsquantity,L_IE_RE_CostPriceAmount as lieiecostpriceamount ,");
		sb.append("L_IE_RE_Spec as lieiespec,L_IE_RE_NotTaxRate as lieienottaxrate,L_IE_RE_NotTaxRateAmount as lieienottaxrateamount, ");
		sb.append("L_IE_RE_CostPrice as lieiecostprice,L_IE_RE_TaxAmount as lieietaxamount ");
		sb.append("FROM L_RE_ReversalEntry where L_IE_RE_InvoiceID=?");
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getLieieinvoiceid());
		
		return queryForObjectList(sb.toString(), params.toArray(),InvoiceEntryPo.class);
	}
	@SuppressWarnings("unchecked")
	public List<InvoiceEntryPo> getReversalEntryPoList(InvoiceEntryPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT temp.lieiebillid as lieiebillid,temp.lieiegoodsid AS lieiegoodsid,temp.lieiegoodsname AS lieiegoodsname,temp.lieiegoodsquantity AS lieiegoodsquantity,");
		sb.append("temp.lieiecheckgoodsquantity as lieiecheckgoodsquantity,temp.lieiecostpriceamount as lieiecostpriceamount ,");
		sb.append("temp.lieiespec as lieiespec,temp.lieienottaxrate as lieienottaxrate,temp.lieienottaxrateamount as lieienottaxrateamount, ");
		sb.append("temp.lieiecostprice as lieiecostprice,temp.lieietaxamount as lieietaxamount ");		
		sb.append(" from(SELECT L_IE_RE_BillID AS lieiebillid,L_IE_RE_GoodsID AS lieiegoodsid,L_IE_RE_GoodsName AS lieiegoodsname,L_IE_RE_GoodsQuantity AS lieiegoodsquantity,");
		sb.append("L_IE_RE_CheckGoodsQuantity as lieiecheckgoodsquantity,L_IE_RE_CostPriceAmount as lieiecostpriceamount ,");
		sb.append("L_IE_RE_Spec as lieiespec,L_IE_RE_NotTaxRate as lieienottaxrate,L_IE_RE_NotTaxRateAmount as lieienottaxrateamount, ");
		sb.append("L_IE_RE_CostPrice as lieiecostprice,L_IE_RE_TaxAmount as lieietaxamount ");
		sb.append("FROM L_RE_ReversalEntry where L_IE_RE_InvoiceID=?");
		sb.append(" ) temp ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getLieieinvoiceid());
		
		return queryForObjectList(sb.toString(), params.toArray(),InvoiceEntryPo.class);
	}
	
	/**
	 * Description：查询冲回基本信息
	 * @param     : 冲回号
     * @return    ：返回符合条件的冲回基本信息
	 */
	public InvoicePo getReversalPo(InvoicePo po){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT top 1  L_I_R_ID AS liiid,L_I_R_SupplierID AS liisupplierid,");
		sb.append("L_I_R_Date as liidate,L_I_R_AuditDate as liiauditdate,(SELECT B_SP_SupplierName FROM B_SUPPLIER WHERE B_SP_ID=L_I_R_SupplierID) AS liisuppliername,");
		sb.append("(select personname from sys_personinfo where id=L_I_R_CreatePersonID) liicreatepersonname, (SELECT B_DP_DEPARTMENTNAME FROM B_DEPARTMENTS WHERE B_DP_DEPARTMENTID=L_I_R_DepartmentID) liidepartmentname ");
		sb.append("FROM L_R_Reversal where L_I_R_ID=?");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getLiiid());
		
		return (InvoicePo)queryForObject(sb.toString(), params.toArray(),InvoicePo.class);
	}
	
	/**
	 * Description：根据单据号得到商品明细信息
	 * @param     ：单据号数组
	 * @return    ：返回符合条件的商品明细列表
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getBillGoods(VoucherEntryPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select C_ST_IE_ID as sLveveID,C_ST_IE_BillID as sLveveBillID , ");
		buffer.append("C_ST_IE_GoodsId as sLveveGoodsID , ");
		buffer.append("B_GI_ViewGoodsName as sGoodsName , ");
		buffer.append("B_GI_Spec as sSpec , ");
		buffer.append("C_ST_IE_GoodsQuantity as sGoodsQuantity , ");
		buffer.append("C_ST_IE_NotTaxRate as sNotTaxRate , ");
		buffer.append("C_ST_IE_NotTaxRateAmount as sNotTaxRateAmount , ");
		buffer.append("C_ST_IE_TaxRate as sTaxRate , ");
		buffer.append("C_ST_IE_CostPrice as sCostPrice , ");		
		buffer.append("C_ST_IE_TaxAmount as sTaxAmount ,  ");
		buffer.append("C_ST_IE_CostPriceAmount as sCostPriceAmount,C_ST_IE_InvoiceState as sInvoiceState ");
		buffer.append(" from C_ST_InventoryEntry left join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId ");
		buffer.append("where C_ST_IE_BillID = ? ");
		
		params.add(po.getsLveveBillID());
		
		return queryForObjectList(buffer.toString() , params.toArray() , VoucherEntryPo.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getSalesBillGoods(VoucherEntryPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select C_ST_I_BillID as sLveveID,C_ST_I_BillID as sLveveBillID,convert(varchar(10),C_ST_I_AuditDate,120) as sBillDate,C_ST_I_DepartmentId as sDepartmentID,B_DP_DepartmentName as sDepartment,isnull(sum(C_ST_IE_NotTaxRateAmount),0.00) as sNotTaxRateAmount,isnull(sum(C_ST_IE_CostPriceAmount),0.00) as sCostPriceAmount ");
		buffer.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		buffer.append("       left join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId  ");
		buffer.append("       left join B_Departments on C_ST_I_DepartmentId=B_DP_DepartmentID ");
		buffer.append("  where C_ST_I_BillID=? ");
		buffer.append("  group by C_ST_I_BillID,C_ST_I_AuditDate,C_ST_I_DepartmentId,B_DP_DepartmentName ");
		
		params.add(po.getsLveveBillID());
		
		return queryForObjectList(buffer.toString() , params.toArray() , VoucherEntryPo.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getOtherInAndOutStorageBillGoods(VoucherEntryPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select C_ST_IE_ID as sLveveID,C_ST_IE_BillID as sLveveBillID , ");
		buffer.append("C_ST_IE_GoodsId as sLveveGoodsID , ");
		buffer.append("B_GI_ViewGoodsName as sGoodsName , ");
		buffer.append("B_GI_Spec as sSpec , ");
		buffer.append("C_ST_IE_GoodsQuantity as sGoodsQuantity , ");
		buffer.append("C_ST_IE_NotTaxRate as sNotTaxRate , ");
		buffer.append("C_ST_IE_NotTaxRateAmount as sNotTaxRateAmount , ");
		buffer.append("C_ST_IE_TaxRate as sTaxRate , ");
		buffer.append("C_ST_IE_CostPrice as sCostPrice , ");		
		buffer.append("C_ST_IE_TaxAmount as sTaxAmount ,  ");
		buffer.append("C_ST_IE_CostPriceAmount as sCostPriceAmount,C_ST_I_SupplierId as sStockID ");
		buffer.append("from C_ST_InventoryEntry inner join C_ST_Inventory on C_ST_IE_BillID=C_ST_I_BillID ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId ");
		buffer.append("where C_ST_IE_BillID = ? ");
		
		params.add(po.getsLveveBillID());
		
		return queryForObjectList(buffer.toString() , params.toArray() , VoucherEntryPo.class);
	}
	
	/**
	 * Description：根据单据号得到商品明细信息
	 * @param     ：单据号数组
	 * @return    ：返回符合条件的商品明细列表
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getCheckStorgeBillGoods(VoucherEntryPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select C_ST_IE_ID as sLveveID,C_ST_IE_BillID as sLveveBillID , ");
		buffer.append("C_ST_IE_GoodsId as sLveveGoodsID , ");
		buffer.append("B_GI_ViewGoodsName as sGoodsName , ");
		buffer.append("B_GI_Spec as sSpec , ");
		buffer.append("C_ST_IE_GoodsQuantity as sGoodsQuantity , ");
		buffer.append("C_ST_IE_NotTaxRate as sNotTaxRate , ");
		buffer.append("C_ST_IE_NotTaxRateAmount as sNotTaxRateAmount , ");
		buffer.append("C_ST_IE_TaxRate as sTaxRate , ");
		buffer.append("C_ST_IE_CostPrice as sCostPrice , ");
		buffer.append("C_ST_IE_TaxAmount as sTaxAmount , ");
		buffer.append("C_ST_IE_CostPriceAmount as sCostPriceAmount,C_ST_IE_InvoiceState as sInvoiceState, ");
		if (Utility.getName(po.getsLveveBillID()).substring(0,3).equals("SCI")){
			buffer.append("C_ST_IE_InStockId as sStockID ");
		}else{
			buffer.append("C_ST_IE_OutStockId as sStockID ");
		}		
		buffer.append("from C_ST_InventoryEntry ");
		buffer.append("left join B_GoodsInfo ");
		buffer.append("on B_GoodsInfo.B_GI_GoodsID = C_ST_InventoryEntry.C_ST_IE_GoodsId ");
		buffer.append("where C_ST_IE_BillID = ? ");
		
		params.add(Utility.getName(po.getsLveveBillID()));
		
		return queryForObjectList(buffer.toString() , params.toArray() , VoucherEntryPo.class);
	}
	
	/**
	 * Description：根据单据号锁定单据
	 * @param     ：凭证明细实体
	 */
	public void lockBills(VoucherEntryPo voucherEntryPo,String type){
	
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		if (Utility.getName(voucherEntryPo.getsLveveBillID()).substring(0,4).equalsIgnoreCase("SOUT")){
			sb.append("update C_ST_Inventory set C_ST_I_VoucherType=dbo.updateBillVoucherType(?,?),C_ST_I_VoucherDate=getDate(),C_ST_I_PaymentDay=dbo.getCurrentPaymentDay() where C_ST_I_BillID=?");
			params.add(Utility.getName(voucherEntryPo.getsLveveBillID()));
		}else{
			sb.append("update C_ST_Inventory set C_ST_I_VoucherType=?,C_ST_I_VoucherDate=getDate(),C_ST_I_PaymentDay=dbo.getCurrentPaymentDay() where C_ST_I_BillID=?");
		}
				
		params.add(type);
		params.add(Utility.getName(voucherEntryPo.getsLveveBillID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}
	
	/**
	 * Description：根据发票号锁定发票
	 * @param     ：凭证明细实体
	 */
	public void lockInvoices(VoucherEntryPo voucherEntryPo){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_I_Invoice set L_I_I_isVoucher='1',L_I_I_VoucherDate=getDate(),L_I_I_PaymentDay=dbo.getCurrentPaymentDay() where L_I_I_ID=?");
		params.add(voucherEntryPo.getsLveveBillID());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据冲回号锁定冲回记录
	 * @param     ：凭证明细实体
	 */
	public void lockReversals(VoucherEntryPo voucherEntryPo){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_R_Reversal set L_I_R_isVoucher='1',L_I_R_VoucherDate=getDate(),L_I_R_PaymentDay=dbo.getCurrentPaymentDay() where L_I_R_ID=?");
		params.add(voucherEntryPo.getsLveveBillID());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据发票号锁定单据
	 * @param     ：凭证明细实体
	 */
	public void lockBillsByInvoiceID(VoucherEntryPo voucherEntryPo){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update C_ST_Inventory set C_ST_I_VoucherDate=getDate() where C_ST_I_BillID in ( ");
		sb.append("select distinct L_IE_IE_BillID from L_IE_InvoiceEntry where L_IE_IE_InvoiceID=? )");
		params.add(voucherEntryPo.getsLveveBillID());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据冲回号锁定单据
	 * @param     ：凭证明细实体
	 */
	public void lockBillsByReversalID(VoucherEntryPo voucherEntryPo){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update C_ST_Inventory set C_ST_I_VoucherDate=getDate() where C_ST_I_BillID in ( ");
		sb.append("select distinct L_IE_RE_BillID from L_RE_ReversalEntry where L_IE_RE_InvoiceID=? )");
		params.add(voucherEntryPo.getsLveveBillID());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据审核人ID查询审核人名称
	 * @param     ：审核人ID
	 * @return    : 返回审核人名称
	 */
	public String getAuditPersonNameByID(String auditPersonID){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1  personName from SYS_PersonInfo where ID=?");
		params.add(auditPersonID);
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
	/**
	 * Description：根据发票号查询核销的商品代码
	 * @param     ：发票号
	 * @return    : 返回商品代码
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getGoodsIdByInvoiceID(String invoiceID){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select L_IE_IE_GoodsID as sLveveGoodsID,L_IE_IE_NotTaxRateAmount as sNotTaxRateAmount,L_IE_IE_TaxAmount as sTaxAmount,L_IE_IE_CostPriceAmount as sCostPriceAmount from L_IE_InvoiceEntry where L_IE_IE_InvoiceID=?");
		params.add(invoiceID);
		
		return queryForObjectList(buffer.toString() , params.toArray() , VoucherEntryPo.class);
	}
	
	/**
	 * Description：根据冲回号查询核销的商品代码
	 * @param     ：冲回号
	 * @return    : 返回商品代码
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getGoodsIdByReversalID(String reversalID){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select L_IE_RE_GoodsID as sLveveGoodsID,L_IE_RE_NotTaxRateAmount as sNotTaxRateAmount,L_IE_RE_TaxAmount as sTaxAmount,L_IE_RE_CostPriceAmount as sCostPriceAmount from L_RE_ReversalEntry where L_IE_RE_InvoiceID=?");
		params.add(reversalID);
		
		return queryForObjectList(buffer.toString() , params.toArray() , VoucherEntryPo.class);
	}
	
	/**
	 * Description：根据发票号查询发票信息
	 * @param     ：voucherEntryList 旧发票列表
     * @param     ：bills 发票号数组
	 * @return    : 返回发票信息
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getInvoiceListByID(VoucherEntryPo po){		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select L_I_I_ID as sLveveBillID , ");
		buffer.append("B_SP_SupplierName as sSupplierName , ");
		buffer.append("L_I_I_Date as sDate , ");
		buffer.append("B_DP_DepartmentName as sdepartment,");
		buffer.append("personName as sPersonID, ");
		buffer.append("sum(round(L_IE_IE_NotTaxRateAmount,2)) as sNotTaxRateAmount, ");
		buffer.append("sum(L_IE_IE_TaxAmount) as sTaxAmount,");
		buffer.append("sum(L_IE_IE_CostPriceAmount) as sCostPriceAmount ");
		buffer.append("from L_I_Invoice ");
		buffer.append("inner join B_Supplier on B_Supplier.B_SP_ID = L_I_Invoice.L_I_I_SupplierID ");
		buffer.append("inner join SYS_PersonInfo on L_I_I_CreatePersonID=ID ");
		buffer.append("inner join B_Departments on L_I_I_DepartmentID=B_DP_DepartmentID ");
		buffer.append(" left join L_IE_InvoiceEntry on L_I_I_ID=L_IE_IE_InvoiceID ");
		buffer.append("where L_I_I_ID=? ");	
		buffer.append(" group by L_I_I_ID,B_SP_SupplierName,L_I_I_Date,B_DP_DepartmentName,personName");
		params.add(po.getsLveveBillID());
		
		return queryForObjectList(buffer.toString() , params.toArray() , VoucherEntryPo.class);
	}
	
	/**
	 * Description：根据冲回号查询冲回信息
	 * @param     ：voucherEntryList 旧冲回列表
     * @param     ：bills 冲回号数组
	 * @return    : 返回冲回信息
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherEntryPo> getReversalListByID(VoucherEntryPo po){		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select L_I_R_ID as sLveveBillID , ");
		buffer.append("B_SP_SupplierName as sSupplierName , ");
		buffer.append("L_I_R_Date as sDate , ");
		buffer.append("B_DP_DepartmentName as sdepartment,");
		buffer.append("personName as sPersonID, ");
		buffer.append("sum(round(L_IE_RE_NotTaxRateAmount,2)) as sNotTaxRateAmount, ");
		buffer.append("sum(L_IE_RE_TaxAmount) as sTaxAmount,");
		buffer.append("sum(L_IE_RE_CostPriceAmount) as sCostPriceAmount ");
		buffer.append("from L_R_Reversal ");
		buffer.append("inner join B_Supplier on L_I_R_SupplierID = B_SP_ID ");
		buffer.append("inner join SYS_PersonInfo on L_I_R_CreatePersonID=ID ");
		buffer.append("inner join B_Departments on L_I_R_DepartmentID=B_DP_DepartmentID ");
		buffer.append(" left join L_RE_ReversalEntry on L_I_R_ID=L_IE_RE_InvoiceID ");
		buffer.append("where L_I_R_ID=? ");	
		buffer.append(" group by L_I_R_ID,B_SP_SupplierName,L_I_R_Date,B_DP_DepartmentName,personName");
		params.add(po.getsLveveBillID());
		
		return queryForObjectList(buffer.toString() , params.toArray() , VoucherEntryPo.class);
	}
	
	/**
	 * Description：根据发票号查询成本合计、价税合计、税额合计
	 * @param     ：发票号
	 * @return    : 返回发票的成本合计、价税合计、税额合计
	 */
	public VoucherPo getAmountByInvoiceID(String invoiceID){		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1  sum(isnull(L_IE_IE_NotTaxRateAmount,0)) as sLvvNotTaxRateAmount,sum(isnull(L_IE_IE_TaxAmount,0)) as sLvvTaxAmount,sum(isnull(L_IE_IE_CostPriceAmount,0)) as sLvvCostPriceAmount ");
		buffer.append(" from L_IE_InvoiceEntry where L_IE_IE_InvoiceID=?");		
		params.add(invoiceID);
		
		return (VoucherPo)queryForObject(buffer.toString() , params.toArray() , VoucherPo.class);
	}
	
	/**
	 * Description：根据冲回号查询成本合计、价税合计、税额合计
	 * @param     ：冲回号
	 * @return    : 返回冲回的成本合计、价税合计、税额合计
	 */
	public VoucherPo getAmountByReversalID(String reversalID){		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1  sum(L_IE_RE_NotTaxRateAmount) as sLvvNotTaxRateAmount,sum(L_IE_RE_TaxAmount) as sLvvTaxAmount,sum(L_IE_RE_CostPriceAmount) as sLvvCostPriceAmount ");
		buffer.append(" from L_RE_ReversalEntry where L_IE_RE_InvoiceID=?");		
		params.add(reversalID);
		
		return (VoucherPo) queryForObject(buffer.toString() , params.toArray() , VoucherPo.class);
	}	
	
	/**
	 * Description：根据单据号解锁单据
	 * @param     ：凭证明细实体
	 */
	public void notLockBills(String voucherID,String voucherType){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
	
		sb.append("update C_ST_Inventory set C_ST_I_VoucherType=replace(C_ST_I_VoucherType,?,'0'),C_ST_I_VoucherDate=NULL,C_ST_I_PaymentDay=NULL where C_ST_I_BillID in ( ");
		sb.append(" select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?)");
		params.add(voucherType);
		params.add(voucherID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据发票号解锁发票
	 * @param     ：凭证明细实体
	 */
	public void notLockInvoices(String voucherID){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_I_Invoice set L_I_I_isVoucher='0',L_I_I_VoucherDate=NULL,L_I_I_PaymentDay=NULL where L_I_I_ID in ( ");
		sb.append(" select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?)");
		params.add(voucherID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据冲回号解锁冲回记录
	 * @param     ：凭证明细实体
	 */
	public void notLockReversals(String voucherID){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_R_Reversal set L_I_R_isVoucher='0',L_I_R_VoucherDate=NULL,L_I_R_PaymentDay=NULL where L_I_R_ID in ( ");
		sb.append(" select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?)");
		params.add(voucherID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}	
	
	/**
	 * Description：根据发票号解锁单据
	 * @param     ：凭证号
	 */
	public void notLockBillByInvoiceID(String voucherID){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update C_ST_Inventory set C_ST_I_VoucherDate=NULL where C_ST_I_BillID in ( ");
		sb.append("select distinct L_IE_IE_BillID from L_IE_InvoiceEntry where L_IE_IE_InvoiceID in ( ");
		sb.append("select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?)) ");
		params.add(voucherID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据冲回号解锁单据
	 * @param     ：凭证号
	 */
	public void notLockBillByReversalID(String voucherID){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update C_ST_Inventory set C_ST_I_VoucherDate=NULL where C_ST_I_BillID in ( ");
		sb.append("select distinct L_IE_RE_BillID from L_RE_ReversalEntry where L_IE_RE_InvoiceID in ( ");
		sb.append("select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?) )");
		params.add(voucherID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：根据凭证号查询凭证类型
	 * @param     ：凭证号
	 * @return    : 返回凭证类型
	 */
	public String getVoucherTypeByVoucherID(String voucherID){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1  L_V_V_VoucherTypeID from L_V_Voucher where L_V_V_ID=?");
		params.add(voucherID);
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}	
	
	/**
	 * Description：查询所有门店
	 * @return    : 返回所有门店
	 */
	@SuppressWarnings("unchecked")
	public List<SalesShopPo> getSalesShopList(){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select B_DP_DepartmentID as shopID,B_DP_DepartmentName as shopName from B_Departments ");
		
		return queryForObjectList(buffer.toString() ,null, SalesShopPo.class);
	}
	
	/**
	 * Description：凭证过账
	 * @param     ：凭证号
	 */
	public void voucherPosting(String vouchersID,String companyID,String flag){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("exec [XZD_VoucherPosting] ?,?,? ");
		
		params.add(vouchersID);
		params.add(companyID);
		params.add(flag);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：凭证过账(用友)
	 * @param     ：凭证号
	 */
	public void yy_VoucherPosting(String vouchersID){
		
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("exec [YY_VoucherPosting] ? ");
		params.add(vouchersID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * Description：修改凭证过账标识
	 * @param     ：凭证号
	 */
	public void updateVoucherPosting(String voucherID){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_V_Voucher set L_V_V_Posting='1',L_V_V_PostingDate=getDate() where L_V_V_ID=?");
		params.add(voucherID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 得到业务表信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelectBillCount(InventoryPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();	
		sb.append("select count(billID) from ( ");
		sb.append("select distinct C_ST_I_BillID as billID ");
		sb.append("  from C_ST_Inventory left join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		sb.append("  where   C_ST_I_AuditState='1' and C_ST_I_FinanceAuditState='1' and C_ST_I_BillTypeId in ('1','2','9') ");		
		
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append(" and C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		if ("0".equals(Utility.getName(po.getSalesOutBillType()))){
			sb.append(" and (isnull(C_ST_I_VoucherType,0)='0' or C_ST_I_VoucherType='' )");
		}else if ("1".equals(Utility.getName(po.getSalesOutBillType()))){
			sb.append(" and (isnull(C_ST_I_VoucherType,0)<>'0' and C_ST_I_VoucherType<>'' ) ");
		}
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append(" and C_ST_I_BillID=? ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){
			if (!"".equals(Utility.getName(po.getCstiendTime()))){
				sb.append(" and substring(CONVERT(varchar(10),C_ST_I_billDate,120),1,10) between ? and ? ");
				params.add(po.getCstistartTime());
				params.add(po.getCstiendTime());
			}else{
				sb.append(" and substring(CONVERT(varchar(10),C_ST_I_billDate,120),1,10)>=? ");
				params.add(po.getCstistartTime());
			}
		}else{
			if (!"".equals(Utility.getName(po.getCstiendTime()))){
				sb.append(" and substring(CONVERT(varchar(10),C_ST_I_billDate,120),1,10)<=? ");
				params.add(po.getCstiendTime());
			}
		}
		if (!"".equals(Utility.getName(po.getCstiinvoicestate()))){
			if ("3".equals(Utility.getName(po.getCstiinvoicestate()))){
				sb.append(" and isnull(C_ST_I_InvoiceState,'0') in ('0','1') ");
			}else{
				sb.append(" and isnull(C_ST_I_InvoiceState,'0')=? ");
				params.add(po.getCstiinvoicestate());
			}
		}
		if (!"".equals(Utility.getName(po.getVoucher()))){
			//sb.append(" and isnull(C_ST_I_VoucherType,'0')<>'0' and C_ST_I_BillID in ( ");
			sb.append(" and C_ST_I_BillID in ( ");
			sb.append("select distinct L_VE_VE_BillID from L_VE_VoucherEntry ");
			sb.append(" where L_VE_VE_VoucherID=? ");
			sb.append("union all ");
			sb.append("select distinct L_IE_RE_BillID  ");
			sb.append("     from L_RE_ReversalEntry ");
			sb.append("     where L_IE_RE_InvoiceID in ( ");
			sb.append("       select distinct L_VE_VE_BillID from L_VE_VoucherEntry ");
			sb.append("         where L_VE_VE_VoucherID=? ");
			sb.append(" ) ) ");
			params.add(po.getVoucher());
			params.add(po.getVoucher());
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append(" and C_ST_IE_GoodsId like ? + '%' ");
			params.add(po.getCstigoodsid());
		}
		sb.append(" ) temp ");
		
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询业务表信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryPo> selectSelectBill(InventoryPo po , int start , int size){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.billID as cstibillid,temp.supplier as cstisuppliername,temp.invoiceState as cstiinvoicestate ");
		sb.append("       ,temp.billDate as cstibilldate,temp.billTypeId as cstibilltypeid, ");
		sb.append("       temp.voucherID as voucher from (   ");	
		sb.append("select distinct ROW_NUMBER() Over(order by C_ST_I_billDate desc) as rowNum, C_ST_I_BillID as billID,B_SP_SupplierName as supplier, ");
		sb.append("       C_ST_I_BillTypeId as billTypeId,C_ST_I_InvoiceState as invoiceState,isnull(C_ST_I_VoucherType,0) as voucherType,C_ST_I_billDate as billDate,  ");
		
		if (!"".equals(Utility.getName(po.getVoucher()))){
			sb.append("  ? as voucherID ");	
		}else{
			sb.append("  (select top 1 L_VE_VE_VoucherID from L_VE_VoucherEntry where L_VE_VE_BillID=C_ST_I_BillID) as voucherID ");	
		}
		
		sb.append("  from C_ST_Inventory left join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID ");
		sb.append("  where  C_ST_I_AuditState='1' and C_ST_I_FinanceAuditState='1' and C_ST_I_BillTypeId in ('1','2','9') ");		
		
		if (!"".equals(Utility.getName(po.getVoucher()))){
			params.add(po.getVoucher());	
		}
		
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append(" and C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		if ("0".equals(Utility.getName(po.getSalesOutBillType()))){
			sb.append(" and (isnull(C_ST_I_VoucherType,0)='0' or C_ST_I_VoucherType='' )");
		}else if ("1".equals(Utility.getName(po.getSalesOutBillType()))){
			sb.append(" and (isnull(C_ST_I_VoucherType,0)<>'0' and C_ST_I_VoucherType<>'' ) ");
		}
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append(" and C_ST_I_BillID=? ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){
			if (!"".equals(Utility.getName(po.getCstiendTime()))){
				sb.append(" and substring(CONVERT(varchar(10),C_ST_I_billDate,120),1,10) between ? and ? ");
				params.add(po.getCstistartTime());
				params.add(po.getCstiendTime());
			}else{
				sb.append(" and substring(CONVERT(varchar(10),C_ST_I_billDate,120),1,10)>=? ");
				params.add(po.getCstistartTime());
			}
		}else{
			if (!"".equals(Utility.getName(po.getCstiendTime()))){
				sb.append(" and substring(CONVERT(varchar(10),C_ST_I_billDate,120),1,10)<=? ");
				params.add(po.getCstiendTime());
			}
		}
		if (!"".equals(Utility.getName(po.getCstiinvoicestate()))){
			if ("3".equals(Utility.getName(po.getCstiinvoicestate()))){
				sb.append(" and isnull(C_ST_I_InvoiceState,'0') in ('0','1') ");
			}else{
				sb.append(" and isnull(C_ST_I_InvoiceState,'0')=? ");
				params.add(po.getCstiinvoicestate());
			}
		}
//		if (!"".equals(Utility.getName(po.getVoucher()))){
//			sb.append(" and isnull(C_ST_I_VoucherType,'0')<>'0' and C_ST_I_BillID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?) ");
//			params.add(po.getVoucher());
//		}
		if (!"".equals(Utility.getName(po.getVoucher()))){
			//sb.append(" and isnull(C_ST_I_VoucherType,'0')<>'0' and C_ST_I_BillID in ( ");
			sb.append(" and C_ST_I_BillID in ( ");
			sb.append("select distinct L_VE_VE_BillID from L_VE_VoucherEntry ");
			sb.append(" where L_VE_VE_VoucherID=? ");
			sb.append("union all ");
			sb.append("select distinct L_IE_RE_BillID  ");
			sb.append("     from L_RE_ReversalEntry ");
			sb.append("     where L_IE_RE_InvoiceID in ( ");
			sb.append("       select distinct L_VE_VE_BillID from L_VE_VoucherEntry ");
			sb.append("         where L_VE_VE_VoucherID=? ");
			sb.append(" ) ) ");
			params.add(po.getVoucher());
			params.add(po.getVoucher());
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append(" and C_ST_IE_GoodsId like ? + '%' ");
			params.add(po.getCstigoodsid());
		}
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),InventoryPo.class);
	}
	
	/**
	 * 得到发票和冲回信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelInvoiceAndReversalCount(InventoryPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();	
		sb.append("select count(id) from ( ");
		sb.append("select distinct L_I_I_ID as id ");
		sb.append("  from L_I_Invoice inner join B_Supplier on L_I_I_SupplierID=B_SP_ID ");
		sb.append("       inner join L_IT_InvoiceType on L_I_I_InvoiceType=L_IT_ID ");
		sb.append("       left join L_IE_InvoiceEntry on L_I_I_ID=L_IE_IE_InvoiceID ");
		sb.append("  where L_I_I_AuditStatue='1' ");
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append(" and L_I_I_ID like '%' + ? + '%'");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append(" and L_I_I_SupplierID=? ");
			params.add(po.getCstisupplierid());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){			
			sb.append(" and substring(CONVERT(varchar(10),L_I_I_Date,120),1,10)>=? ");
			params.add(po.getCstistartTime());
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){			
			sb.append(" and substring(CONVERT(varchar(10),L_I_I_Date,120),1,10)<=? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getVoucher()))){
			sb.append(" and (( isnull(L_I_I_isVoucher,'0')<>'0' and L_I_I_ID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?)) ");
			sb.append(" or L_I_I_ID in (select distinct L_PB_PBE_InvoiceID from L_PB_PBE_PaymentBillEntry ");
			sb.append("   where L_PB_PBE_BillID in ( ");
			sb.append(" select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?))) ");
			params.add(po.getVoucher());
			params.add(po.getVoucher());
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append(" and L_IE_IE_GoodsID like ? + '%' ");
			params.add(po.getCstigoodsid());
		}
		sb.append("union all ");
		sb.append("select  distinct L_I_R_ID as id ");
		sb.append("  from L_R_Reversal inner join B_Supplier on L_I_R_SupplierID=B_SP_ID ");
		sb.append("       left join L_RE_ReversalEntry on L_I_R_ID=L_IE_RE_InvoiceID ");
		sb.append("  where L_I_R_AuditStatue='1' ");
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append(" and L_I_R_ID like '%' + ? + '%'");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append(" and L_I_R_SupplierID=? ");
			params.add(po.getCstisupplierid());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){			
			sb.append(" and substring(CONVERT(varchar(10),L_I_R_Date,120),1,10)>=? ");
			params.add(po.getCstistartTime());
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){			
			sb.append(" and substring(CONVERT(varchar(10),L_I_R_Date,120),1,10)<=? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getVoucher()))){
			sb.append(" and isnull(L_I_R_isVoucher,'0')<>'0' and L_I_R_ID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?) ");
			params.add(po.getVoucher());
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append(" and L_IE_RE_GoodsID like ? + '%' ");
			params.add(po.getCstigoodsid());
		}
		sb.append(") temp ");
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询发票和冲回信息
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryPo> selInvoiceAndReversal(InventoryPo po , int start , int size){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp2.cstibillid as cstibillid,temp2.cstibilltypeid as cstibilltypeid,temp2.cstisuppliername as cstisuppliername, ");
		sb.append("       temp2.cstibilldate as cstibilldate,temp2.voucherID as voucher from ( ");
		sb.append("select distinct ROW_NUMBER() Over(order by temp.date desc) as rowNum,temp.id as cstibillid,temp.typeName as cstibilltypeid,temp.supplierName as cstisuppliername, ");
		sb.append("       temp.date as cstibilldate,temp.voucherID as voucherID from ( ");
		sb.append("select distinct L_I_I_ID as id,L_IT_Type as typeName,B_SP_SupplierName as supplierName,L_I_I_Date as date,  ");
		sb.append("       (case isnull(a.L_VE_VE_VoucherID,'') when '' then isnull(b.L_VE_VE_VoucherID,'') else isnull(a.L_VE_VE_VoucherID,'') end ) as voucherID ");
		sb.append("  from L_I_Invoice inner join B_Supplier on L_I_I_SupplierID=B_SP_ID ");
		sb.append("       inner join L_IT_InvoiceType on L_I_I_InvoiceType=L_IT_ID ");
		sb.append("       left join L_IE_InvoiceEntry on L_I_I_ID=L_IE_IE_InvoiceID ");
		sb.append("       left join L_VE_VoucherEntry a on L_I_I_ID=a.L_VE_VE_BillID ");
		sb.append("       left join L_PB_PBE_PaymentBillEntry on L_I_I_ID=L_PB_PBE_InvoiceID ");
		sb.append("       left join L_VE_VoucherEntry b on L_PB_PBE_BillID=b.L_VE_VE_BillID ");
		
		sb.append("  where L_I_I_AuditStatue='1' ");
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append(" and L_I_I_ID like '%' + ? + '%'");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append(" and L_I_I_SupplierID=? ");
			params.add(po.getCstisupplierid());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){			
			sb.append(" and substring(CONVERT(varchar(10),L_I_I_Date,120),1,10)>=? ");
			params.add(po.getCstistartTime());
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){			
			sb.append(" and substring(CONVERT(varchar(10),L_I_I_Date,120),1,10)<=? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getVoucher()))){
			sb.append(" and (( isnull(L_I_I_isVoucher,'0')<>'0' and L_I_I_ID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?)) ");
			sb.append(" or L_I_I_ID in (select distinct L_PB_PBE_InvoiceID from L_PB_PBE_PaymentBillEntry ");
			sb.append("   where L_PB_PBE_BillID in ( ");
			sb.append(" select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?))) ");
			params.add(po.getVoucher());
			params.add(po.getVoucher());
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append(" and L_IE_IE_GoodsID like ? + '%' ");
			params.add(po.getCstigoodsid());
		}
		sb.append("union all ");
		sb.append("select distinct L_I_R_ID as id,'冲回' as typeName,B_SP_SupplierName as supplierName,L_I_R_Date as date, ");
		sb.append("       L_VE_VE_VoucherID as voucherID ");
		sb.append("  from L_R_Reversal inner join B_Supplier on L_I_R_SupplierID=B_SP_ID ");
		sb.append("       left join L_RE_ReversalEntry on L_I_R_ID=L_IE_RE_InvoiceID");
		sb.append("       left join L_VE_VoucherEntry on L_I_R_ID=L_VE_VE_BillID");
		sb.append("  where L_I_R_AuditStatue='1' ");
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append(" and L_I_R_ID like '%' + ? + '%'");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))){
			sb.append(" and L_I_R_SupplierID=? ");
			params.add(po.getCstisupplierid());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){			
			sb.append(" and substring(CONVERT(varchar(10),L_I_R_Date,120),1,10)>=? ");
			params.add(po.getCstistartTime());
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){			
			sb.append(" and substring(CONVERT(varchar(10),L_I_R_Date,120),1,10)<=? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getVoucher()))){
			sb.append(" and isnull(L_I_R_isVoucher,'0')<>'0' and L_I_R_ID in (select distinct L_VE_VE_BillID from L_VE_VoucherEntry where L_VE_VE_VoucherID=?) ");
			params.add(po.getVoucher());
		}
		if (!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append(" and L_IE_RE_GoodsID like ? + '%' ");
			params.add(po.getCstigoodsid());
		}
		sb.append(") temp ) temp2 where rowNum > " + start + " and rowNum <= "	+ countPage);		
		sb.append(" order by temp2.cstibilldate desc ");
		sb.append(" set rowcount 0");
		
    	return queryForObjectList(sb.toString(), params.toArray(),InventoryPo.class);
	}
	
	public VoucherPo selVoucherAmount(VoucherPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  L_VE_VE_VoucherID as sLvvID,sum(L_VE_VE_NotTaxRateAmount) as sLvvNotTaxRateAmount,sum(L_VE_VE_TaxAmount) as sLvvTaxAmount,sum(L_VE_VE_CostPriceAmount) as sLvvCostPriceAmount ");
		sb.append("  from L_VE_VoucherEntry where L_VE_VE_VoucherID=? group by L_VE_VE_VoucherID ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getsLvvID());
		
		return (VoucherPo)queryForObject(sb.toString(), params.toArray(),VoucherPo.class);
	}
	public void updateVoucherAmount(VoucherPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("update L_V_Voucher set L_V_V_NotTaxRateAmount=?,L_V_V_TaxAmount=?,L_V_V_CostPriceAmount=? ");
		sb.append("  where L_V_V_ID=?");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getsLvvNotTaxRateAmount());
		params.add(po.getsLvvTaxAmount());
		params.add(po.getsLvvCostPriceAmount());
		params.add(po.getsLvvID());
		
		getJdbcTemplate().update(sb.toString() , params.toArray());		
	}
	
	/**
	 * 新增出库凭证
	 * @param po
	 * @return
	 */
	public void insertOutStrogeVoucher(VoucherPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_V_Voucher(L_V_V_ID,L_V_V_SupplierID,L_V_V_Date,L_V_V_PersonID,L_V_V_VoucherTypeID,L_V_V_Remark,L_V_V_AuditStatue,L_V_V_PaymentDay,");
		if (Utility.getName(po.getsLvvAuditStatue()).equals("1")){
			sb.append("L_V_V_AuditPersonID,L_V_V_AuditDate," );
		}	
		sb.append(" L_V_V_NotTaxRateAmount,L_V_V_TaxAmount,L_V_V_CostPriceAmount,L_V_V_Posting) values(?,?,getDate(),?,?,?,?,?" );
		if (Utility.getName(po.getsLvvAuditStatue()).equals("1")){
			sb.append(",?,getDate()" );
		}	
		sb.append(" ,'0','0','0','0')" );
		params.add(Utility.getName(po.getsLvvID()));
		params.add(Utility.getName(po.getsShopCode()));
		params.add(Utility.getName(po.getsLvvPersonID()));
		params.add(Utility.getName(po.getsLvvVoucherTypeID()));
		params.add(Utility.getName(po.getsLvvRemark()));
		
		params.add(Utility.getName(po.getsLvvAuditStatue()));
		params.add(Utility.getName(po.getsLvvDate()));
		if (Utility.getName(po.getsLvvAuditStatue()).equals("1")){
			params.add(Utility.getName(po.getsLvvAuditPersonID()));
		}
				
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	public void insertOutStrogeVoucherEntry(VoucherEntryPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("insert into L_VE_VoucherEntry(L_VE_VE_ID,L_VE_VE_VoucherID,L_VE_VE_BillID,L_VE_VE_GoodsID,L_VE_VE_NotTaxRate,L_VE_VE_CheckNumber,L_VE_VE_NotTaxRateAmount,L_VE_VE_CostPriceAmount) ");
		sb.append(" select newid(),?,C_ST_IE_BillID,C_ST_IE_GoodsId,C_ST_IE_NotTaxRate,sum(C_ST_IE_GoodsQuantity),sum(C_ST_IE_NotTaxRateAmount),sum(C_ST_IE_CostPriceAmount) from C_ST_InventoryEntry");
		sb.append("  where C_ST_IE_BillID=? ");
		sb.append("  group by C_ST_IE_BillID,C_ST_IE_GoodsId,C_ST_IE_NotTaxRate ");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getsLveveVoucherID()));
		params.add(Utility.getName(po.getsLveveBillID()));

		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 查询出库凭证总数
	 * @param invoicePo
	 * @return
	 */
	public int selOutStrogeVoucherCount(VoucherPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();	
		
		sb.append("select count(sLvvID) from ( ");
		
		sb.append("select distinct L_V_V_ID as sLvvID ");
		sb.append(" from L_V_Voucher inner join L_VE_VoucherEntry on L_V_V_ID=L_VE_VE_VoucherID inner join SYS_PersonInfo on L_V_V_PersonID=ID where 1=1 ");		
	
		if (!"".equals(Utility.getName(po.getsLvvID()))){
			sb.append(" and L_V_V_ID like '%'+?+'%'");
			params.add(po.getsLvvID());
		}
		//部门
		if (!"".equals(Utility.getName(po.getsShopCode()))){
			sb.append(" and L_V_V_ID in ( select distinct L_VE_VE_VoucherID ");
			sb.append(" from L_VE_VoucherEntry inner join C_ST_Inventory on L_VE_VE_BillID=C_ST_I_BillID ");
			sb.append(" where L_VE_VE_BillID like 'SOUT%' and C_ST_I_DepartmentId=?) ");
			
			params.add(Utility.getName(po.getsShopCode()));
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append(" and isnull(L_V_V_AuditStatue,'0')=?");
			params.add(po.getsLvvAuditStatue());
		}
		if (!"".equals(Utility.getName(po.getsLvvDateTopLimit()))){
			if (!"".equals(Utility.getName(po.getsLvvDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10) between ? and ?");
				params.add(po.getsLvvDateTopLimit());
				params.add(po.getsLvvDateLowerLimit());
			}else{
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)>=?");
				params.add(po.getsLvvDateTopLimit());
			}
		}else{
			if (!"".equals(Utility.getName(po.getsLvvDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)<=?");
				params.add(po.getsLvvDateLowerLimit());
			}
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditDateTopLimit()))){
			if (!"".equals(Utility.getName(po.getsLvvAuditDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10) between ? and ?");
				params.add(po.getsLvvAuditDateTopLimit());
				params.add(po.getsLvvAuditDateLowerLimit());
			}else{
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)>=?");
				params.add(po.getsLvvAuditDateTopLimit());
			}
		}else{
			if (!"".equals(Utility.getName(po.getsLvvAuditDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)<=?");
				params.add(po.getsLvvAuditDateLowerLimit());
			}
		}
		//凭证类型
		if (!"".equals(Utility.getName(po.getsLvvVoucherTypeID()))){
			sb.append(" and L_V_V_VoucherTypeID like '%' + ? + '%' ");
			params.add(po.getsLvvVoucherTypeID());
		}
		if (!"".equals(Utility.getName(po.getsLvvPosting()))){
			sb.append(" and isnull(L_V_V_Posting,'0')=?");
			params.add(po.getsLvvPosting());
		}
		if (!"".equals(Utility.getName(po.getsLvvPersonID()))){
			sb.append(" and L_V_V_PersonID=?");
			params.add(po.getsLvvPersonID());
		}
				
		sb.append(")temp ");
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询出库凭证
	 * @param invoicePo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<VoucherPo> selOutStrogeVoucher(VoucherPo po,int start,int size){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();	
		
		int countPage = start + size;		
		sb.append("set rowcount " + countPage + " \n");
		
		sb.append("select sLvvID as sLvvID,sShopCode as sShopCode,sLvvDate as sLvvDate,sLvvPersonName as sLvvPersonName,");
		sb.append(" sLvvAuditStatue as sLvvAuditStatue,sLvvNotTaxRateAmount as sLvvNotTaxRateAmount,");
		sb.append(" sLvvCostPriceAmount as sLvvCostPriceAmount, sLvvPosting as sLvvPosting from ( ");
		
		sb.append("select distinct ROW_NUMBER() Over(order by temp.sLvvDate desc) as rowNum, sLvvID as sLvvID,sShopCode as sShopCode,sLvvDate as sLvvDate,sLvvPersonName as sLvvPersonName,");
		sb.append(" sLvvAuditStatue as sLvvAuditStatue,sum(sLvvNotTaxRateAmount) as sLvvNotTaxRateAmount,");
		sb.append(" sum(sLvvCostPriceAmount) as sLvvCostPriceAmount, sLvvPosting as sLvvPosting from ( ");
		sb.append("select L_V_V_ID as sLvvID,(select top 1 B_DP_DepartmentName from B_Departments where B_DP_DepartmentID in ");
		
		sb.append("(select top 1 C_ST_I_DepartmentId from C_ST_Inventory where C_ST_I_BillID=L_VE_VE_BillID) ");
		sb.append(") as sShopCode, ");
		sb.append("convert(varchar(10),L_V_V_Date,120) as sLvvDate,personName as sLvvPersonName,isNUll(L_V_V_AuditStatue,'0') as sLvvAuditStatue, ");
		sb.append("sum(isnull(L_VE_VE_NotTaxRateAmount,0)) as sLvvNotTaxRateAmount,sum(isnull(L_VE_VE_CostPriceAmount,0)) as sLvvCostPriceAmount, L_V_V_Posting as sLvvPosting ");
		sb.append(" from L_V_Voucher inner join L_VE_VoucherEntry on L_V_V_ID=L_VE_VE_VoucherID inner join SYS_PersonInfo on L_V_V_PersonID=ID where 1=1 ");		
	
		if (!"".equals(Utility.getName(po.getsLvvID()))){
			sb.append(" and L_V_V_ID like '%'+?+'%'");
			params.add(po.getsLvvID());
		}
		//部门
		if (!"".equals(Utility.getName(po.getsShopCode()))){
			sb.append(" and L_V_V_ID in ( select distinct L_VE_VE_VoucherID ");
			sb.append(" from L_VE_VoucherEntry inner join C_ST_Inventory on L_VE_VE_BillID=C_ST_I_BillID ");
			sb.append(" where L_VE_VE_BillID like 'SOUT%' and C_ST_I_DepartmentId=? )");
					
			params.add(Utility.getName(po.getsShopCode()));
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append(" and isnull(L_V_V_AuditStatue,'0')=?");
			params.add(po.getsLvvAuditStatue());
		}
		if (!"".equals(Utility.getName(po.getsLvvDateTopLimit()))){
			if (!"".equals(Utility.getName(po.getsLvvDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10) between ? and ?");
				params.add(po.getsLvvDateTopLimit());
				params.add(po.getsLvvDateLowerLimit());
			}else{
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)>=?");
				params.add(po.getsLvvDateTopLimit());
			}
		}else{
			if (!"".equals(Utility.getName(po.getsLvvDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)<=?");
				params.add(po.getsLvvDateLowerLimit());
			}
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditDateTopLimit()))){
			if (!"".equals(Utility.getName(po.getsLvvAuditDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10) between ? and ?");
				params.add(po.getsLvvAuditDateTopLimit());
				params.add(po.getsLvvAuditDateLowerLimit());
			}else{
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)>=?");
				params.add(po.getsLvvAuditDateTopLimit());
			}
		}else{
			if (!"".equals(Utility.getName(po.getsLvvAuditDateLowerLimit()))){
				sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)<=?");
				params.add(po.getsLvvAuditDateLowerLimit());
			}
		}
		//凭证类型
		if (!"".equals(Utility.getName(po.getsLvvVoucherTypeID()))){
			sb.append(" and L_V_V_VoucherTypeID like '%' + ? + '%' ");
			params.add(po.getsLvvVoucherTypeID());
		}
		if (!"".equals(Utility.getName(po.getsLvvPosting()))){
			sb.append(" and isnull(L_V_V_Posting,'0')=?");
			params.add(po.getsLvvPosting());
		}
		if (!"".equals(Utility.getName(po.getsLvvPersonID()))){
			sb.append(" and L_V_V_PersonID=?");
			params.add(po.getsLvvPersonID());
		}
		sb.append(" group by L_V_V_ID,L_V_V_Date,personName,L_V_V_AuditStatue,L_V_V_Posting,L_VE_VE_BillID ");		
		sb.append(")temp group by sLvvID,sShopCode,sLvvDate,sLvvPersonName,sLvvAuditStatue,sLvvPosting ");		
				
		sb.append(" ) temp2 where rowNum > " + start + " and rowNum <= "	+ countPage);		
		sb.append(" order by sLvvDate desc ");
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),VoucherPo.class);
	}
	
	
	/**
	 * 查询出库成本和销售收入
	 * @param invoicePo
	 * @return
	 */
	public VoucherEntryPo getOutStrogeAmount(String voucherPo){
		StringBuffer sb = new StringBuffer();
		sb.append("select sum(L_VE_VE_NotTaxRateAmount) as sNotTaxRateAmount,sum(L_VE_VE_CostPriceAmount) as sCostPriceAmount from L_VE_VoucherEntry  ");
		sb.append("    where L_VE_VE_VoucherID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(voucherPo);
		
		return (VoucherEntryPo)queryForObject(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
		
	/**
	 * 查询当前账期
	 */
	public VoucherPo selCurrentAccountPeriod(String companyID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if (!companyID.equals("")){
			sb.append("select top 1 cast(L_SA_Year as varchar)+'-'+L_SA_Month+'-01' as sLvvDateTopLimit,  ");
			sb.append("convert(varchar(10),dateadd(dd,-day(cast(L_SA_Year as varchar)+'-'+L_SA_Month+'-01'),dateadd(m,1,cast(L_SA_Year as varchar)+'-'+L_SA_Month+'-01')),120) as sLvvDateLowerLimit ");
			sb.append("   from L_SA_SwitchAmount where L_SA_CurrentMonth='1' and L_SA_CompanyID = ? ");
					
			params.add(companyID);
		}else{
			sb.append("select top 1 cast(L_SA_Year as varchar)+'-'+L_SA_Month+'-01' as sLvvDateTopLimit,  ");
			sb.append("convert(varchar(10),dateadd(dd,-day(cast(L_SA_Year as varchar)+'-'+L_SA_Month+'-01'),dateadd(m,1,cast(L_SA_Year as varchar)+'-'+L_SA_Month+'-01')),120) as sLvvDateLowerLimit ");
			sb.append("   from L_SA_ALL_SwitchAmount where L_SA_CurrentMonth='1' ");
		}
		
		return (VoucherPo)queryForObject(sb.toString(),params.toArray(),VoucherPo.class);
	}
	
	/**
	 * 开关账
	 */
	public void switchAmount(String month,String flag,String companyID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if (!companyID.equals("")){
			sb.append("exec eims_SwitchAmount ?,? "); 		
			
			params.add(flag); // g:关账    k:开账
			params.add(companyID);
		}else{
			sb.append("exec usp_ALL_SwitchAmount ? "); 		
			
			params.add(flag); // g:关账    k:开账
		}
		
		sb.append(" delete from L_AT_AutoCostAccount where L_AT_CA_PaymentDay = ? and isnull(L_AT_CA_CompanyID,'') = ? "); 	
		params.add(month);
		params.add(companyID);
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 查询未作账的单据总数
	 */
	public int selBillWhetherSettleAccountsCount(String date,String billType){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("exec selBillWhetherSettleAccountsCount ?,? "); 
		params.add(Utility.getName(date));
		params.add(Utility.getName(billType));
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询未作账的单据
	 */
	public List<InventoryEntryPo> selBillWhetherSettleAccounts(String date,String billType,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		
		sb.append("exec selBillWhetherSettleAccounts ?,?,?,?,? "); 		
		
		List<String> params = new ArrayList<String>();
		params.add(date);
		params.add(String.valueOf(start));
		params.add(String.valueOf(size));
		params.add(String.valueOf(countPage));
		params.add(String.valueOf(billType));
		
		return queryForObjectList(sb.toString(), params.toArray(),InventoryEntryPo.class);
	}
	
	/**
	 * 查询销售出库凭证总数
	 */
	public int getSalesOutStorageVoucherCount(VoucherPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(temp.billID) from ( "); 
		sb.append("select L_VE_VE_BillID as billID,sum(L_VE_VE_CheckNumber) as checkNumber, "); 
		sb.append("      sum(L_VE_VE_NotTaxRateAmount) as notTaxRateAmount,sum(L_VE_VE_CostPriceAmount) as costPriceAmount "); 
		sb.append("  from L_VE_VoucherEntry inner join L_V_Voucher on L_VE_VE_VoucherID=L_V_V_ID "); 
		sb.append("  where L_V_V_ID=? "); 
		sb.append("  group by L_VE_VE_BillID "); 
		sb.append(")temp left join C_ST_Inventory on temp.billID=C_ST_I_BillID "); 
		sb.append(" left join B_Departments on C_ST_I_DepartmentId=B_DP_DepartmentID "); 
		
		params.add(Utility.getName(po.getsLvvID()));
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询销售出库凭证列表(分页)
	 */
	public List<VoucherEntryPo> getSalesOutStorageVoucherList(VoucherPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;		
		sb.append("set rowcount " + countPage + " \n");
		
		sb.append("select sLveveBillID as sLveveBillID,sDepartment as sDepartment,sBillDate as sBillDate,sGoodsQuantity as sGoodsQuantity,sNotTaxRateAmount as sNotTaxRateAmount,sCostPriceAmount as sCostPriceAmount from ( ");
		
		sb.append("select ROW_NUMBER() Over(order by C_ST_I_AuditDate desc) as rowNum,temp.billID as sLveveBillID,B_DP_DepartmentName as sDepartment,convert(varchar(10),C_ST_I_AuditDate,120) as sBillDate,temp.checkNumber as sGoodsQuantity,temp.notTaxRateAmount as sNotTaxRateAmount,temp.costPriceAmount as sCostPriceAmount from ( "); 
		sb.append("select L_VE_VE_BillID as billID,sum(L_VE_VE_CheckNumber) as checkNumber, "); 
		sb.append("      sum(L_VE_VE_NotTaxRateAmount) as notTaxRateAmount,sum(L_VE_VE_CostPriceAmount) as costPriceAmount "); 
		sb.append("  from L_VE_VoucherEntry inner join L_V_Voucher on L_VE_VE_VoucherID=L_V_V_ID "); 
		sb.append("  where L_V_V_ID=? "); 
		sb.append("  group by L_VE_VE_BillID "); 
		sb.append(")temp left join C_ST_Inventory on temp.billID=C_ST_I_BillID "); 
		sb.append(" left join B_Departments on C_ST_I_DepartmentId=B_DP_DepartmentID "); 
		
		sb.append(" ) temp2 where rowNum > " + start + " and rowNum <= "	+ countPage);		
		sb.append(" order by sBillDate desc ");
		sb.append(" set rowcount 0");
		
		params.add(Utility.getName(po.getsLvvID()));
		
		return queryForObjectList(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * 查询销售出库凭证列表(无分页)
	 */
	public List<VoucherEntryPo> getSalesOutStorageVoucherList(VoucherPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select temp.billID as sLveveBillID,B_DP_DepartmentName as sDepartment,convert(varchar(10),C_ST_I_AuditDate,120) as sBillDate,temp.checkNumber as sGoodsQuantity,temp.notTaxRateAmount as sNotTaxRateAmount,temp.costPriceAmount as sCostPriceAmount from ( "); 
		sb.append("select L_VE_VE_BillID as billID,sum(L_VE_VE_CheckNumber) as checkNumber, "); 
		sb.append("      sum(L_VE_VE_NotTaxRateAmount) as notTaxRateAmount,sum(L_VE_VE_CostPriceAmount) as costPriceAmount "); 
		sb.append("  from L_VE_VoucherEntry inner join L_V_Voucher on L_VE_VE_VoucherID=L_V_V_ID "); 
		sb.append("  where L_V_V_ID=? "); 
		sb.append("  group by L_VE_VE_BillID "); 
		sb.append(")temp left join C_ST_Inventory on temp.billID=C_ST_I_BillID "); 
		sb.append(" left join B_Departments on C_ST_I_DepartmentId=B_DP_DepartmentID "); 
		
		params.add(Utility.getName(po.getsLvvID()));
		
		return queryForObjectList(sb.toString(), params.toArray(),VoucherEntryPo.class);
	}
	
	/**
	 * 修改销售出库凭证
	 */
	public void updateSalesOutStorageVoucher(VoucherPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_V_Voucher set L_V_V_Remark=?,L_V_V_AuditStatue=? "); 
		if ("1".equals(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append(",L_V_V_AuditPersonID=?,L_V_V_AuditDate=getdate(),L_V_V_AuditDptID = ? ");
		}
		sb.append(" where L_V_V_ID=? ");
		
		params.add(Utility.getName(po.getsLvvRemark()));
		params.add(Utility.getName(po.getsLvvAuditStatue()).equals("") ? "0" : Utility.getName(po.getsLvvAuditStatue()));
		if ("1".equals(Utility.getName(po.getsLvvAuditStatue()))){
			params.add(Utility.getName(po.getsLvvAuditPersonID()));
			params.add(Utility.getName(po.getsLvvAuditDptID()));
		}		
		params.add(Utility.getName(po.getsLvvID()));
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
		
	}
	
	/**
	 * 获取当前需要传输的财物软件的路径
	 */
	public String getCurrentFinanceSoftwarePath(){
		
		StringBuffer sb = new StringBuffer();
		sb.append("if not EXISTS (select top 1 L_CD_IL_Path from L_CD_InterLinkage where L_CD_IL_Current='1' ) "); 
		sb.append("begin select '' end else begin ");
		sb.append("select top 1 isnull(L_CD_IL_Path,'') from L_CD_InterLinkage where L_CD_IL_Current='1' end "); 
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), null,String.class);
	}
	
/*********************************************************************************************/
	
	/**
	 * Description：根据参数查询记账凭证总数
	 * @param     ：凭证实体
	 * @return    ：返回符合条件的记账凭证总数
	 */
	public int getVoucherTallyCount(VoucherPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(distinct L_V_V_ID)");		
		sb.append(" from L_V_Voucher inner join L_VT_VoucherTally on L_V_V_ID=L_VT_VT_VoucherID where isnull(L_V_V_VoucherTypeID,'')='' ");		

		if (!"".equals(Utility.getName(po.getsLvvID()))){
			sb.append(" and L_V_V_ID like '%'+?+'%'");
			params.add(po.getsLvvID());
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append(" and isNUll(L_V_V_AuditStatue,'0')=?");
			params.add(po.getsLvvAuditStatue());
		}
		if (!"".equals(Utility.getName(po.getsLvvDateTopLimit()))){
			sb.append(" and substring(CONVERT(varchar(10),L_V_V_Date,120),1,10)>=?");
			params.add(po.getsLvvDateTopLimit());
		}
		if (!"".equals(Utility.getName(po.getsLvvPersonID()))){
			sb.append(" and L_V_V_PersonID=?");
			params.add(po.getsLvvPersonID());
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
		if (!"".equals(Utility.getName(po.getsLvvSupplierID()))){
			sb.append(" and L_V_V_SupplierID=?");
			params.add(po.getsLvvSupplierID());
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * Description：根据参数查询记账凭证信息
	 * @param     ：VoucherPo 凭证实体
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
	 * @return    ：返回符合条件的记账凭证信息列表
	 */
	public List<VoucherPo> getVoucherTallyList(VoucherPo po,int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select distinct temp.sLvvID as sLvvID,temp.sLvvDate as sLvvDate,temp.sLvvPersonID as sLvvPersonID,temp.sLvvPersonName as sLvvPersonName,");
		sb.append("temp.sLvvAuditDate as sLvvAuditDate,temp.sLvvAuditStatue as sLvvAuditStatue,temp.sLvvAuditPersonID as sLvvAuditPersonID,temp.sLvvAuditPersonName as sLvvAuditPersonName ");
		sb.append(" from( select ROW_NUMBER() Over(order by L_V_V_Date desc) as rowNum,L_V_V_ID as sLvvID,L_V_V_Date as sLvvDate,L_V_V_PersonID as sLvvPersonID,a.personName as sLvvPersonName,");
		sb.append("L_V_V_AuditDate as sLvvAuditDate,isNUll(L_V_V_AuditStatue,'0') as sLvvAuditStatue,b.personName as sLvvAuditPersonName,L_V_V_AuditPersonID as sLvvAuditPersonID ");
		sb.append(" from L_V_Voucher inner join L_VT_VoucherTally on L_V_V_ID=L_VT_VT_VoucherID inner join SYS_PersonInfo a on L_V_V_PersonID=a.ID left join SYS_PersonInfo b on L_V_V_AuditPersonID=b.ID where isnull(L_V_V_VoucherTypeID,'')='' ");		
	
		if (!"".equals(Utility.getName(po.getsLvvID()))){
			sb.append(" and L_V_V_ID like '%'+?+'%'");
			params.add(po.getsLvvID());
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
		if (!"".equals(Utility.getName(po.getsLvvPersonID()))){
			sb.append(" and L_V_V_PersonID=?");
			params.add(po.getsLvvPersonID());
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditDateTopLimit()))){
			sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)>=?");
			params.add(po.getsLvvAuditDateTopLimit());
		}
		if (!"".equals(Utility.getName(po.getsLvvAuditDateLowerLimit()))){
			sb.append(" and substring(CONVERT(varchar(10),L_V_V_AuditDate,120),1,10)<=?");
			params.add(po.getsLvvAuditDateLowerLimit());
		}
		if (!"".equals(Utility.getName(po.getsLvvSupplierID()))){
			sb.append(" and L_V_V_SupplierID=?");
			params.add(po.getsLvvSupplierID());
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" order by temp.sLvvDate desc set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),VoucherPo.class);
	}
	
	/**
	 * 新增记账凭证
	 */
	public void insertVoucherTally(VoucherPo po){
		
		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_V_Voucher(L_V_V_ID,L_V_V_SupplierID,L_V_V_Date,L_V_V_PersonID,L_V_V_VoucherTypeID,L_V_V_Remark,L_V_V_AttachBillCount,");
		sb.append("L_V_V_Posting,L_V_V_AuditStatue,L_V_V_PaymentDay ");
		if ("1".endsWith(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append(",L_V_V_AuditPersonID,L_V_V_AuditDate ");
		}		
		sb.append(" ,L_V_V_CostPriceAmount,L_V_V_DepartmentID,L_V_V_TypeID,L_V_V_CreateDptID,L_V_V_AuditDptID,L_V_V_FranchiseeID,L_V_V_SubSupplierID ) values(?,?,?,?,?,?,?,'0',?,?");
		if ("1".endsWith(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append(",?,getdate()");
		}
		sb.append(" ,?,?,?,?,?,?,?) ");
		
		params.add(Utility.getName(po.getsLvvID()));
		params.add(Utility.getName(po.getsLvvSupplierID()));
		params.add(Utility.getName(po.getsLvvDate()));
		params.add(Utility.getName(po.getsLvvPersonID()));
		params.add("131");	
		params.add(Utility.getName(po.getsLvvRemark()));
		params.add(Utility.getName(po.getsLvvAttchBillCount()));
		params.add(Utility.getName(po.getsLvvAuditStatue()).equals("") ? "0" : Utility.getName(po.getsLvvAuditStatue()));
		params.add(Utility.getName(po.getsLvvDate()));
		if ("1".endsWith(Utility.getName(po.getsLvvAuditStatue()))){
			params.add(Utility.getName(po.getsLvvPersonID()));
		}
		params.add(Utility.getName(po.getsLvvCostPriceAmount()).equals("") ? "0.00" : Utility.getName(po.getsLvvCostPriceAmount()));		
		params.add(Utility.getName(po.getsLvvDepartmentID()));
		params.add(Utility.getName(po.getsLvvTypeID()));
		params.add(Utility.getName(po.getsLvvCreateDptID()));
		if ("1".endsWith(Utility.getName(po.getsLvvAuditStatue()))){
			params.add(Utility.getName(po.getsLvvAuditDptID()));
		}else{
			params.add("");
		}		
		params.add(Utility.getName(po.getsLvvFranchiseeDptID()));
		params.add(Utility.getName(po.getsLvvSubSupplierID()));
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 新增记账凭证明细
	 */
	public void insertVoucherTallyEntry(VoucherTallyPo voucherTallyPo){
		
	}
	
	/**
	 * 修改记账凭证
	 */
	public void updateVoucherTally(VoucherPo po){
		
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_V_Voucher set L_V_V_AttachBillCount=?,L_V_V_Remark=? ");
		if (!"".equals(Utility.getName(po.getsLvvDate()))){
			sb.append(",L_V_V_Date=?,");
		}
		if ("1".endsWith(Utility.getName(po.getsLvvAuditStatue()))){
			sb.append("L_V_V_AuditStatue='1',L_V_V_AuditPersonID=?,L_V_V_AuditDate=getdate(),L_V_V_AuditDptID=?, ");
		}	
		sb.append("L_V_V_HandlePersonID=?,L_V_V_BalanceMethod=?,L_V_V_CostPriceAmount=? where L_V_V_ID=?");
		
		params.add(Utility.getName(po.getsLvvAttchBillCount()));
		params.add(Utility.getName(po.getsLvvRemark()));
		if (!"".equals(Utility.getName(po.getsLvvDate()))){
			params.add(Utility.getName(po.getsLvvDate()));
		}
		if ("1".endsWith(Utility.getName(po.getsLvvAuditStatue()))){
			params.add(Utility.getName(po.getsLvvAuditPersonID()));
			params.add(Utility.getName(po.getsLvvAuditDptID()));
		}	
		params.add(Utility.getName(po.getsLvvHandlePersonID()));
		params.add(Utility.getName(po.getsLvvBalanceMethod()));
		params.add(Utility.getName(po.getsLvvCostPriceAmount()).equals("") ? "0.00" : Utility.getName(po.getsLvvCostPriceAmount()));	
		params.add(po.getsLvvID());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 反审核记账凭证
	 */
	public void auditVoucherTally(VoucherPo po){
		
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("update L_V_Voucher set L_V_V_AuditStatue='0',L_V_V_AuditPersonID=NULL,L_V_V_AuditDate=NULL where L_V_V_ID=? ");

		params.add(Utility.getName(po.getsLvvID()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 获取记账凭证
	 */
	public VoucherPo getVoucherTallyDetail(VoucherPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select L_V_V_ID as sLvvID,convert(varchar(10),L_V_V_Date,120) as sLvvDate,a.personname as sLvvPersonName,b.personname as sLvvAuditPersonName,convert(varchar(10),L_V_V_AuditDate,120) as sLvvAuditDate,L_V_V_AttachBillCount as sLvvAttchBillCount,L_V_V_Remark as sLvvRemark,(case L_V_V_TypeID when '1' then B_SP_SupplierName when '2' then B_DP_DepartmentName when '2' then B_FS_StoreName else '' end ) as sLvvSupplierName,L_V_V_TypeID as sLvvTypeID ");
		sb.append("  from L_V_Voucher left join SYS_PersonInfo a on L_V_V_PersonID=a.ID left join SYS_PersonInfo b on L_V_V_AuditPersonID=b.ID  left join B_Supplier on L_V_V_SupplierID=B_SP_ID left join B_Departments on L_V_V_DepartmentID=B_DP_DepartmentID left join B_Franchisee on L_V_V_FranchiseeID=B_FS_StoreID where L_V_V_ID=? ");	
		
		params.add(Utility.getName(po.getsLvvID()));
		
		return (VoucherPo)queryForObject(sb.toString(), params.toArray(),VoucherPo.class);
	}
	
	/**
	 * 获取记账凭证明细
	 */
	public List<VoucherTallyPo> getVoucherTallyEntryDetail(VoucherPo po){
		return null;
	}
	
	/**
	 * 判断是否过进行成本计算
	 */
	public int isCostAccount(){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_AT_CA_ID) from L_AT_AutoCostAccount  ");
		sb.append("  where L_AT_CA_Flag='1' and L_AT_CA_PaymentDay in ( ");	
		sb.append("select top 1 (cast(L_SA_Year as varchar)+'-'+L_SA_Month) from L_SA_SwitchAmount  ");	
		sb.append("  where L_SA_CurrentMonth='1') ");	
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * Description：获取存在凭证模板的凭证类型
	 */
	public List<VoucherTypePo> getVoucherTypeByExitsID(){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select L_VT_VT_ID as sLvtvtId,L_VT_VT_TypeName as sLvtvtTypeName,isnull(L_VT_VT_ParentID,'0') as sLvtvtParentID ");
		sb.append(",(select count(b.L_VT_VT_ID) from  L_VT_VoucherType b where b.L_VT_VT_ParentID=a.L_VT_VT_ID) as  sLvtvtMinCount ");
		sb.append(" from L_VT_VoucherType a where L_VT_VT_IsTemplet = '1' and L_VT_VT_ParentID = '0' ");

		return queryForObjectList(sb.toString(),null,VoucherTypePo.class);
	}
	
	/**
	 * 查询成本计算日志
	 */
	public List<AutoCostAccountPo> selectAutoCostAccountList(String companyID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 20 convert(varchar(16),L_AT_CA_CreateDate,120) as latcacreatedate,L_AT_CA_PaymentDay as latcapaymentday,L_AT_CA_Flag as latcaflag,convert(varchar(16),L_AT_CA_ExecDate,120) as latcaexecdate,isnull(F_CN_Name,'') as latcacompanyname from L_AT_AutoCostAccount left join F_CompanyName on L_AT_CA_CompanyID = F_CN_ID where 1 = 1 ");
		
		if (!Utility.getName(companyID).equals("")){
			sb.append(" and L_AT_CA_CompanyID = ? ");
			params.add(Utility.getName(companyID));
		}else{
			sb.append(" and isnull(L_AT_CA_CompanyID,'') = '' ");
		}
		
		sb.append(" order by L_AT_CA_PaymentDay desc,L_AT_CA_CreateDate desc ");

		return queryForObjectList(sb.toString(),params.toArray(),AutoCostAccountPo.class);
	}
	
	/**
	 * 根据当前日期查询所属账期
	 */
	public String getCurrentAccountPeriodByDate(String companyID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("declare @qcdate varchar(50) ");
		sb.append("set @qcdate = '' ");
		
		sb.append("select top 1 @qcdate = L_CT_CT_Date from L_CT_CostingTemplate ");
		
		if (!"".equals(companyID)){
			sb.append("   where L_CT_CT_CompanyID = ? ");
			params.add(Utility.getName(companyID));
		}		

		sb.append("select dbo.ufn_getCurrAccountPeriod(@qcdate) ");
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(),params.toArray(),String.class);
	}
	
	/**
	 * 查询当前账期是否做过成本计算
	 */
	public int getCurrZqCbjsCount(String date,String companyID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(L_AT_CA_ID) ");		
		sb.append(" from L_AT_AutoCostAccount where L_AT_CA_PaymentDay = ? ");		

		params.add(date);
		
		if (!"".equals(Utility.getName(companyID))){
			sb.append(" and L_AT_CA_CompanyID = ? ");
			params.add(companyID);
		}

		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
}
