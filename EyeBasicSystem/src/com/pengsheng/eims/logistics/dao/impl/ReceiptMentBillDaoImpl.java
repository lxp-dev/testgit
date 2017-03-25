/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : ReceiptMentBillDaoImpl.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2013-04-28
**/
package com.pengsheng.eims.logistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.dao.ReceiptMentBillDao;
import com.pengsheng.eims.logistics.persistence.ReceiptMentBillEntryPo;
import com.pengsheng.eims.logistics.persistence.ReceiptMentBillPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.TracPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ReceiptMentBillDaoImpl extends BaseJdbcDaoSupport implements ReceiptMentBillDao{
	
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();	
	
	/**
	 * 查询收款单总数
	 */
	public int getReceiptMentBillCount(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(distinct L_FA_RM_ID) from L_FA_RM_ReceiptMentBill left join L_FA_ME_ReceiptMentEntry on L_FA_RM_ID=L_FA_ME_ReceiptMentBillID where 1=1 ");

		if (!"".equals(Utility.getName(po.getsLrbrbID()))){
			sb.append(" and L_FA_RM_ID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getsLrbrbID()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbFranchiseeID()))){
			sb.append(" and L_FA_RM_FranchiseeID=? ");
			params.add(Utility.getName(po.getsLrbrbFranchiseeID()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_DA_Date,120) >= ? ");
			params.add(Utility.getName(po.getsLrbrbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_DA_Date,120) <= ? ");
			params.add(Utility.getName(po.getsLrbrbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_RM_AuditDate,120) >= ? ");
			params.add(Utility.getName(po.getsLrbrbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_RM_AuditDate,120) <= ? ");
			params.add(Utility.getName(po.getsLrbrbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbCreatePersonID()))){
			sb.append(" and L_FA_RM_CreatePersonID = ? ");
			params.add(Utility.getName(po.getsLrbrbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbAuditStatue()))){
			sb.append(" and L_FA_RM_AuditStatue = ? ");
			params.add(Utility.getName(po.getsLrbrbAuditStatue()));
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	/**
	 * 查询收款单列表
	 */
	public List<ReceiptMentBillPo> getReceiptMentBillList(ReceiptMentBillPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select * from (select ROW_NUMBER() Over(order by sLrbrbDate desc) as rowNum,* from ( ");
		sb.append("select distinct L_FA_RM_ID as sLrbrbID,isnull(B_FS_StoreName,0) as sLrbrbFranchiseeName,convert(varchar(16),L_FA_RM_Date,120) as sLrbrbDate,isnull(a.personname,'') as sLrbrbCreatePersonName,isnull(b.personname,'') as sLrbrbAuditPersonName,L_FA_RM_CurrentReceiptAmount as sLrbrbCurrentReceiptMentAmount,convert(varchar(16),L_FA_RM_AuditDate,120) as sLrbrbAuditDate,L_FA_RM_AuditStatue as sLrbrbAuditStatue ");		
		sb.append(" from L_FA_RM_ReceiptMentBill left join L_FA_ME_ReceiptMentEntry on L_FA_RM_ID=L_FA_ME_ReceiptMentBillID left join SYS_PersonInfo a on a.id=L_FA_RM_CreatePersonID left join SYS_PersonInfo b on b.id=L_FA_RM_AuditPersonID left join B_Franchisee on L_FA_RM_FranchiseeID=B_FS_StoreID  where 1=1 ");		

		if (!"".equals(Utility.getName(po.getsLrbrbID()))){
			sb.append(" and L_FA_RM_ID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getsLrbrbID()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbFranchiseeID()))){
			sb.append(" and L_FA_RM_FranchiseeID=? ");
			params.add(Utility.getName(po.getsLrbrbFranchiseeID()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_DA_Date,120) >= ? ");
			params.add(Utility.getName(po.getsLrbrbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_DA_Date,120) <= ? ");
			params.add(Utility.getName(po.getsLrbrbEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbAuditStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_RM_AuditDate,120) >= ? ");
			params.add(Utility.getName(po.getsLrbrbAuditStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbAuditEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_RM_AuditDate,120) <= ? ");
			params.add(Utility.getName(po.getsLrbrbAuditEndDate()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbCreatePersonID()))){
			sb.append(" and L_FA_RM_CreatePersonID = ? ");
			params.add(Utility.getName(po.getsLrbrbCreatePersonID()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbAuditStatue()))){
			sb.append(" and L_FA_RM_AuditStatue = ? ");
			params.add(Utility.getName(po.getsLrbrbAuditStatue()));
		}
		
		sb.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),ReceiptMentBillPo.class);
	}
	
	/**
	 * 新增收款单
	 */
	public void insertReceiptMentBill(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_FA_RM_ReceiptMentBill(L_FA_RM_ID,L_FA_RM_FranchiseeID,L_FA_RM_Date,L_FA_RM_DepartmentID,L_FA_RM_CreatePersonID,L_FA_RM_AuditStatue, ");
		if ("1".equals(Utility.getName(po.getsLrbrbAuditStatue()))){
			sb.append("L_FA_RM_AuditPersonID,L_FA_RM_AuditDate,");
		}
		sb.append("L_FA_RM_CostPriceAmount,L_FA_RM_ReceiptAmount,L_FA_RM_NotReceiptAmount,L_FA_RM_CurrentReceiptAmount,L_FA_RM_ReverseAmount,L_FA_RM_Remark,L_FA_RM_CurtainDealing,L_FA_RM_ReceiptMentType) ");
		sb.append(" values (?,?,getdate(),?,?,?, ");
		if ("1".equals(Utility.getName(po.getsLrbrbAuditStatue()))){
			sb.append("?,getdate(),");
		}
		sb.append(" ?,?,?,?,?,?,?,?) ");
		
		params.add(Utility.getName(po.getsLrbrbID()));
		params.add(Utility.getName(po.getsLrbrbFranchiseeID()));
		params.add(Utility.getName(po.getsLrbrbDepartmentID()));
		params.add(Utility.getName(po.getsLrbrbCreatePersonID()));
		params.add(Utility.getName(po.getsLrbrbAuditStatue()));
		if ("1".equals(Utility.getName(po.getsLrbrbAuditStatue()))){
			params.add(Utility.getName(po.getsLrbrbAuditPersonID()));
		}
		params.add(Utility.getName(po.getsLrbrbCostPriceAmount()));
		params.add(Utility.getName(po.getsLrbrbReceiptMentAmount()));
		params.add(Utility.getName(po.getsLrbrbNotReceiptMentAmount()));
		params.add(Utility.getName(po.getsLrbrbCurrentReceiptMentAmount()));
		params.add(Utility.getName(po.getsLrbrbCurrentReverseAmount()));
		params.add(Utility.getName(po.getsLrbrbRemark()));
		params.add(Utility.getName(po.getsLrbrbCurtainDealing()));
		params.add(Utility.getName(po.getsLrbrbTypeID()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 新增收款单明细
	 */
	public void insertReceiptMentBillEntry(ReceiptMentBillEntryPo epo){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_FA_ME_ReceiptMentEntry(L_FA_ME_ID,L_FA_ME_ReceiptMentBillID,L_FA_ME_BillTypeID,L_FA_ME_BillID,L_FA_ME_BillDate,L_FA_ME_CostPriceAmount,L_FA_ME_ReceiptAmount,L_FA_ME_NotReceiptMentAmount,L_FA_ME_ReceiptMentAmount,L_FA_ME_Remark) ");
		sb.append(" values (?,?,?,?,?,?,?,?,?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(epo.getsLrbrbeBillID()));
		params.add(Utility.getName(epo.getsLrbrbeBillTypeID()));
		params.add(Utility.getName(epo.getsLrbrbeAllocateID()));
		params.add(Utility.getName(epo.getsLrbrbeBillDate()));
		params.add(Utility.getName(epo.getsLrbrbeCostPriceAmount()));
		params.add(Utility.getName(epo.getsLrbrbeReceiptedMentAmount()));
		params.add(Utility.getName(epo.getsLrbrbeNotReceiptedMentAmount()));
		params.add(Utility.getName(epo.getsLrbrbeReceiptMentAmount()));
		params.add(Utility.getName(epo.getsLrbrbeRemark()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 修改收款单
	 */
	public void updateReceiptMentBill(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("update top (1) L_FA_RM_ReceiptMentBill set L_FA_RM_AuditStatue=?,L_FA_RM_CurrentReceiptAmount=?,L_FA_RM_ReverseAmount=?,L_FA_RM_Remark=?,L_FA_RM_CurtainDealing=? ");
		if ("1".equals(Utility.getName(po.getsLrbrbAuditStatue()))){
			sb.append(" ,L_FA_RM_AuditPersonID=?,L_FA_RM_AuditDate=getdate() ");
		}
		
		params.add(Utility.getName(po.getsLrbrbAuditStatue()));		
		params.add(Utility.getName(po.getsLrbrbCurrentReceiptMentAmount()));
		params.add(Utility.getName(po.getsLrbrbCurrentReverseAmount()));
		params.add(Utility.getName(po.getsLrbrbRemark()));
		params.add(Utility.getName(po.getsLrbrbCurtainDealing()));
		if ("1".equals(Utility.getName(po.getsLrbrbAuditStatue()))){
			params.add(Utility.getName(po.getsLrbrbAuditPersonID()));
		}
		
		if ("1".equals(Utility.getName(po.getsLrbrbCostPriceAmount()))){
			sb.append(" ,L_FA_RM_CostPriceAmount=? ");
			params.add(Utility.getName(po.getsLrbrbCostPriceAmount()));
		}
		
		if ("1".equals(Utility.getName(po.getsLrbrbNotReceiptMentAmount()))){
			sb.append(" ,L_FA_RM_NotReceiptAmount=? ");
			params.add(Utility.getName(po.getsLrbrbNotReceiptMentAmount()));
		}		
		
		sb.append(" where L_FA_RM_ID=? ");	

		params.add(Utility.getName(po.getsLrbrbID()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除收款单
	 */
	public void deleteReceiptMentBill(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("delete  top (1) from L_FA_RM_ReceiptMentBill where L_FA_RM_ID=? ");

		params.add(Utility.getName(po.getsLrbrbID()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除收款单明细
	 */
	public void deleteReceiptMentBillEntry(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("delete from L_FA_ME_ReceiptMentEntry where L_FA_ME_ReceiptMentBillID=? ");

		params.add(Utility.getName(po.getsLrbrbID()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 反审核收款单
	 */
	public int unAuditReceiptMentBill(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("update top (1) L_FA_RM_ReceiptMentBill set L_FA_RM_AuditStatue=0,L_FA_RM_AuditPersonID=NULL,L_FA_RM_AuditDate=NULL where L_FA_RM_ID=? ");

		params.add(Utility.getName(po.getsLrbrbID()));
		
		return getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 审核收款单
	 */
	public int auditReceiptMentBill(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("update top (1) L_FA_RM_ReceiptMentBill set L_FA_RM_AuditStatue=1,L_FA_RM_AuditPersonID=?,L_FA_RM_AuditDate=getdate() where L_FA_RM_ID=? ");

		params.add(Utility.getName(po.getsLrbrbAuditPersonID()));
		params.add(Utility.getName(po.getsLrbrbID()));
		
		return getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询收款单详情
	 */
	public ReceiptMentBillPo getReceiptMentBillDetail(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1 L_FA_RM_ID as sLrbrbID, ");
		sb.append("      L_FA_RM_FranchiseeID as sLrbrbFranchiseeID, ");
		sb.append("      convert(varchar(16),L_FA_RM_Date,120) as sLrbrbDate, ");
		sb.append("      L_FA_RM_DepartmentID as sLrbrbDepartmentID, ");
		sb.append("      L_FA_RM_CreatePersonID as sLrbrbCreatePersonID, ");
		sb.append("      L_FA_RM_AuditStatue as sLrbrbAuditStatue, ");
		sb.append("      L_FA_RM_AuditPersonID as sLrbrbAuditPersonID, ");
		sb.append("      convert(varchar(16),L_FA_RM_AuditDate,120) as sLrbrbAuditDate, ");
		sb.append("      L_FA_RM_CostPriceAmount as sLrbrbCostPriceAmount, ");
		sb.append("      L_FA_RM_ReceiptAmount as sLrbrbReceiptMentAmount, ");
		sb.append("      L_FA_RM_NotReceiptAmount as sLrbrbNotReceiptMentAmount, ");
		sb.append("      L_FA_RM_CurrentReceiptAmount as sLrbrbCurrentReceiptMentAmount, ");
		sb.append("      L_FA_RM_ReverseAmount as sLrbrbCurrentReverseAmount, ");
		sb.append("      L_FA_RM_Remark as sLrbrbRemark, ");
		sb.append("      L_FA_RM_CurtainDealing as sLrbrbCurtainDealing, ");
		sb.append("      a.personname as sLrbrbCreatePersonName, ");
		sb.append("      b.personname as sLrbrbAuditPersonName, ");
		sb.append("      B_DP_DepartmentName as sLrbrbDepartmentName, ");
		sb.append("      B_FS_StoreName as sLrbrbFranchiseeName, ");
		sb.append("      L_FA_RM_ReceiptMentType as sLrbrbTypeID ");
		sb.append("  from L_FA_RM_ReceiptMentBill left join SYS_PersonInfo a on a.id=L_FA_RM_CreatePersonID left join SYS_PersonInfo b on b.id=L_FA_RM_AuditPersonID ");
		sb.append("       left join B_Departments on B_DP_DepartmentID=L_FA_RM_DepartmentID left join B_Franchisee on B_FS_StoreID=L_FA_RM_FranchiseeID ");
		sb.append("  where L_FA_RM_ID=? ");
		
		params.add(Utility.getName(po.getsLrbrbID()));
		
		return (ReceiptMentBillPo)queryForObject(sb.toString(), params.toArray(),ReceiptMentBillPo.class);
	}
	
	/**
	 * 查询收款单明细详情
	 */
	public List<ReceiptMentBillEntryPo> getReceiptMentBillEntryDetail(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT L_FA_ME_ID as sLrbrbeBillID ");
		sb.append("      ,L_FA_ME_ReceiptMentBillID as sLrbrbeBillID ");
		sb.append("      ,L_FA_ME_BillTypeID as sLrbrbeBillTypeID ");
		sb.append("      ,L_FA_ME_BillID as sLrbrbeAllocateID ");
		sb.append("      ,L_FA_ME_BillDate as sLrbrbeBillDate ");
		sb.append("      ,L_FA_ME_CostPriceAmount as sLrbrbeCostPriceAmount ");
		sb.append("      ,L_FA_ME_ReceiptAmount as sLrbrbeReceiptedMentAmount ");
		sb.append("      ,L_FA_ME_NotReceiptMentAmount as sLrbrbeNotReceiptedMentAmount ");
		sb.append("      ,L_FA_ME_ReceiptMentAmount as sLrbrbeReceiptMentAmount ");
		sb.append("      ,L_FA_ME_Remark as sLrbrbeRemark ");
		sb.append("  FROM L_FA_ME_ReceiptMentEntry where L_FA_ME_ReceiptMentBillID=? ");		
		
		params.add(Utility.getName(po.getsLrbrbID()));
		
		return queryForObjectList(sb.toString() , params.toArray() , ReceiptMentBillEntryPo.class);
	}
	
	/**
	 * 查询客户总数
	 */
	public int getFranchiseeCount(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(distinct L_FA_DA_DealingsUnit)");		
		sb.append(" from L_FA_DA_DealingsAccounts inner join B_Franchisee on L_FA_DA_DealingsUnit=B_FS_StoreID where 1=1 ");		

		if (!"".equals(Utility.getName(po.getsLrbrbFranchiseeID()))){
			sb.append(" and L_FA_DA_DealingsUnit=? ");
			params.add(Utility.getName(po.getsLrbrbFranchiseeID()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_DA_Date,120) >= ? ");
			params.add(Utility.getName(po.getsLrbrbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_DA_Date,120) <= ? ");
			params.add(Utility.getName(po.getsLrbrbEndDate()));
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取客户列表
	 */
	public List<DepartmentsPo> getFranchiseeList(ReceiptMentBillPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select * from (select ROW_NUMBER() Over(order by bdpcontactamount desc) as rowNum,* from ( ");
		
		sb.append(" select temp.bdpdepartmentid,bdpdepartmentname,bdppersonname,bdpphone,(isnull(temp.bdpcontactamount,0)+isnull(temp2.bdpcontactamount,0)) as bdpcontactamount from ( ");
		sb.append("select B_FS_StoreID as bdpdepartmentid,B_FS_StoreName as bdpdepartmentname,B_FS_StorePerson as bdppersonname,B_FS_StorePhone as bdpphone,isnull(B_FS_BeginReceivable,0) as bdpcontactamount ");		
		sb.append(" from L_FA_DA_DealingsAccounts inner join B_Franchisee on L_FA_DA_DealingsUnit=B_FS_StoreID where 1=1 ");		

		if (!"".equals(Utility.getName(po.getsLrbrbFranchiseeID()))){
			sb.append(" and L_FA_DA_DealingsUnit=? ");
			params.add(Utility.getName(po.getsLrbrbFranchiseeID()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_DA_Date,120) >= ? ");
			params.add(Utility.getName(po.getsLrbrbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_DA_Date,120) <= ? ");
			params.add(Utility.getName(po.getsLrbrbEndDate()));
		}
		sb.append(" group by B_FS_StoreID,B_FS_StoreName,B_FS_StorePerson,B_FS_StorePhone,B_FS_BeginReceivable ");
		sb.append(" )temp left join ( ");
		
		sb.append(" select bdpdepartmentid,bdpcontactamount from ( ");
		sb.append("select B_FS_StoreID as bdpdepartmentid,(isnull(sum(isnull(L_FA_DA_CostPriceAmount,0)),0)+isnull(sum(isnull(L_FA_DA_ReceiptMentAmount,0)),0)) as bdpcontactamount ");		
		sb.append(" from L_FA_DA_DealingsAccounts inner join B_Franchisee on L_FA_DA_DealingsUnit=B_FS_StoreID where 1=1 ");		

		if (!"".equals(Utility.getName(po.getsLrbrbFranchiseeID()))){
			sb.append(" and L_FA_DA_DealingsUnit=? ");
			params.add(Utility.getName(po.getsLrbrbFranchiseeID()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_DA_Date,120) <= ? ");
			params.add(Utility.getName(po.getsLrbrbEndDate()));
		}
		sb.append(" group by B_FS_StoreID )temp ");		
		sb.append(" )temp2 on temp.bdpdepartmentid=temp2.bdpdepartmentid ");		
		sb.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),DepartmentsPo.class);
	}	

	/**
	 * 查询客户往来账明细
	 */
	public List<InventoryPo> getFranchiseeCurrentAccountDetail(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select convert(varchar(10),L_FA_DA_Date,120) as cstibilldate,L_FA_DA_BillID as cstibillid,L_FA_DA_BillTypeID as cstibilltypeid,L_FA_DA_CostPriceAmount as csticostpriceamount,L_FA_DA_ReceiptMentAmount as payMentAmount ");		
		sb.append(" from L_FA_DA_DealingsAccounts inner join B_Franchisee on L_FA_DA_DealingsUnit=B_FS_StoreID where L_FA_DA_DealingsUnit=? ");		

		params.add(Utility.getName(po.getsLrbrbFranchiseeID()));
		if (!"".equals(Utility.getName(po.getsLrbrbStartDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_DA_Date,120) >= ? ");
			params.add(Utility.getName(po.getsLrbrbStartDate()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_DA_Date,120) <= ? ");
			params.add(Utility.getName(po.getsLrbrbEndDate()));
		}
		sb.append(" order by L_FA_DA_Date ");
		
		return queryForObjectList(sb.toString(), params.toArray(),InventoryPo.class);
	}
	
	/**
	 * 新增客户往来账明细
	 */
	public void insertFranchiseeCurrentAccountDetail(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_FA_DA_DealingsAccounts(L_FA_DA_ID,L_FA_DA_Date,L_FA_DA_BillID,L_FA_DA_BillTypeID,L_FA_DA_DealingsUnit,L_FA_DA_ReceiptMentAmount) ");
		sb.append("select newid(),L_FA_RM_AuditDate,L_FA_RM_ID,'回款',L_FA_RM_FranchiseeID,-L_FA_RM_CurrentReceiptAmount  ");
		sb.append(" from L_FA_RM_ReceiptMentBill ");
		sb.append(" where L_FA_RM_ID=? and L_FA_RM_AuditStatue='1' ");
		
		params.add(Utility.getName(po.getsLrbrbID()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除客户往来账明细
	 */
	public void deleteFranchiseeCurrentAccountDetail(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from L_FA_DA_DealingsAccounts where L_FA_DA_BillID=? ");
		
		params.add(Utility.getName(po.getsLrbrbID()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	
	/**
	 * 查询客户批发调货单总数
	 */
	public int getFranchiseeAllocationBillCount(TracPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(M_T_BillID) from ( select * from ( select *,(M_TE_CostPriceAmount-L_FA_ME_ReceiptMentAmount) as notPayMentAmount from ( ");	
		sb.append("select M_T_BillID,convert(varchar(16),M_T_billDate,120) as M_T_billDate,convert(varchar(16),M_T_AuditDate,120) as M_T_AuditDate, ");	
		sb.append("      personname,B_FS_StoreName,M_TE_CostPriceAmount,isnull(sum(isnull(L_FA_ME_ReceiptMentAmount,0)),0) as L_FA_ME_ReceiptMentAmount  ");	
		sb.append("  from ( ");	
		sb.append("select M_T_BillID,M_T_billDate,M_T_AuditDate,personname,B_FS_StoreName,isnull(sum(isnull(M_TE_CostPriceAmount,0)),0) as M_TE_CostPriceAmount ");	
		sb.append("  from M_Trac inner join M_TracEntry on M_T_BillID=M_TE_BillID left join SYS_PersonInfo on id=M_T_createPerson inner join B_Franchisee on M_T_SupplierId=B_FS_StoreID ");	
		sb.append("  where M_T_SupplierId=? ");	

		params.add(Utility.getName(po.getCstisupplierid()));		
		
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append(" and M_T_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstibillid()));
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){
			sb.append(" and CONVERT(varchar(10),M_T_billDate,120) >= ? ");
			params.add(Utility.getName(po.getCstistartTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append(" and CONVERT(varchar(10),M_T_billDate,120) <= ? ");
			params.add(Utility.getName(po.getCstiendTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))){
			sb.append(" and CONVERT(varchar(10),M_T_AuditDate,120) >= ? ");
			params.add(Utility.getName(po.getCstiauditstartdate()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditenddate()))){
			sb.append(" and CONVERT(varchar(10),M_T_AuditDate,120) <= ? ");
			params.add(Utility.getName(po.getCstiauditenddate()));
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append(" and M_T_createPerson = ? ");
			params.add(Utility.getName(po.getCsticreateperson()));
		}	
				
		sb.append("  group by M_T_BillID,M_T_billDate,M_T_AuditDate,personname,B_FS_StoreName ");	
		sb.append(")temp left join L_FA_ME_ReceiptMentEntry on M_T_BillID=L_FA_ME_BillID ");	
		sb.append(" group by M_T_BillID,M_T_billDate,M_T_AuditDate,personname,B_FS_StoreName,M_TE_CostPriceAmount )temp )temp where 1=1 ");	
		
		if ("1".equals(Utility.getName(po.getCstiinvoicestate()))){
			sb.append("  and M_TE_CostPriceAmount = notPayMentAmount and M_TE_CostPriceAmount <> 0 ");
		}
		if ("2".equals(Utility.getName(po.getCstiinvoicestate()))){
			sb.append("  and M_TE_CostPriceAmount <> notPayMentAmount and notPayMentAmount <> 0 ");
		}
		if ("3".equals(Utility.getName(po.getCstiinvoicestate()))){
			sb.append("  and notPayMentAmount = 0 ");
		}	
		
		sb.append(")temp ");	
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询客户批发调货单总数
	 */
	public List<TracPo> getFranchiseeAllocationBillList(TracPo po,int start,int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select * from (select ROW_NUMBER() Over(order by cstiauditdate desc) as rowNum,* from ( select * from (");
		sb.append("select M_T_BillID as cstibillid,convert(varchar(16),M_T_billDate,120) as cstibilldate,convert(varchar(16),M_T_AuditDate,120) as cstiauditdate,M_T_BillTypeId as cstibilltypeid, ");	
		sb.append("      personname as csticreatepersonname,B_FS_StoreName as cstidepartmentname,(case M_T_BillTypeId when '2' then -isnull(M_TE_CostPriceAmount,0) else isnull(M_TE_CostPriceAmount,0) end) as csticostpriceamount,isnull(sum(isnull(L_FA_ME_ReceiptMentAmount,0)),0) as payMentAmount,(case M_T_BillTypeId when '2' then (-isnull(M_TE_CostPriceAmount,0)-isnull(sum(isnull(L_FA_ME_ReceiptMentAmount,0)),0)) else (isnull(M_TE_CostPriceAmount,0)-isnull(sum(isnull(L_FA_ME_ReceiptMentAmount,0)),0)) end) as notPayMentAmount  ");	
		sb.append("  from ( ");	
		sb.append("select M_T_BillID,M_T_billDate,M_T_AuditDate,personname,B_FS_StoreName,isnull(sum(isnull(M_TE_CostPriceAmount,0)),0) as M_TE_CostPriceAmount,M_T_BillTypeId as M_T_BillTypeId ");	
		sb.append("  from M_Trac inner join M_TracEntry on M_T_BillID=M_TE_BillID left join SYS_PersonInfo on id=M_T_createPerson inner join B_Franchisee on M_T_SupplierId=B_FS_StoreID ");	
		sb.append("  where M_T_SupplierId=? ");	

		params.add(Utility.getName(po.getCstisupplierid()));		
		
		if (!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append(" and M_T_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstibillid()));
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))){
			sb.append(" and CONVERT(varchar(10),M_T_billDate,120) >= ? ");
			params.add(Utility.getName(po.getCstistartTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append(" and CONVERT(varchar(10),M_T_billDate,120) <= ? ");
			params.add(Utility.getName(po.getCstiendTime()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))){
			sb.append(" and CONVERT(varchar(10),M_T_AuditDate,120) >= ? ");
			params.add(Utility.getName(po.getCstiauditstartdate()));
		}
		if (!"".equals(Utility.getName(po.getCstiauditenddate()))){
			sb.append(" and CONVERT(varchar(10),M_T_AuditDate,120) <= ? ");
			params.add(Utility.getName(po.getCstiauditenddate()));
		}		
		if (!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append(" and M_T_createPerson = ? ");
			params.add(Utility.getName(po.getCsticreateperson()));
		}
		
		sb.append("  group by M_T_BillID,M_T_billDate,M_T_AuditDate,personname,B_FS_StoreName,M_T_BillTypeId ");	
		sb.append(")temp left join L_FA_ME_ReceiptMentEntry on M_T_BillID=L_FA_ME_BillID ");	
		sb.append(" group by M_T_BillID,M_T_billDate,M_T_AuditDate,personname,B_FS_StoreName,M_TE_CostPriceAmount,M_T_BillTypeId )tmp where 1=1 ");	
		
		if ("1".equals(Utility.getName(po.getCstiinvoicestate()))){
			sb.append("  and csticostpriceamount = notPayMentAmount and csticostpriceamount <> 0 ");
		}
		if ("2".equals(Utility.getName(po.getCstiinvoicestate()))){
			sb.append("  and csticostpriceamount <> notPayMentAmount and notPayMentAmount <> 0 ");
		}
		if ("3".equals(Utility.getName(po.getCstiinvoicestate()))){
			sb.append("  and notPayMentAmount = 0 ");
		}
		
		sb.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),TracPo.class);
	}
	
	/**
	 * 应收款总余额
	 */
	public String getFranchiseeAccount(ReceiptMentBillPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select isnull(sum(isnull(sLrbrbCostPriceAmount,0)),0) from ( ");		
		sb.append(" select (isnull(B_FS_BeginReceivable,0)+isnull(temp.sLrbrbCostPriceAmount,0)) as sLrbrbCostPriceAmount from ( ");
		sb.append(" select L_FA_DA_DealingsUnit,(isnull(sum(isnull(L_FA_DA_CostPriceAmount,0)),0)+isnull(sum(isnull(L_FA_DA_ReceiptMentAmount,0)),0)) as sLrbrbCostPriceAmount ");		
		sb.append("   from L_FA_DA_DealingsAccounts where 1=1 ");		

		if (!"".equals(Utility.getName(po.getsLrbrbFranchiseeID()))){
			sb.append(" and L_FA_DA_DealingsUnit=? ");
			params.add(Utility.getName(po.getsLrbrbFranchiseeID()));
		}
		if (!"".equals(Utility.getName(po.getsLrbrbEndDate()))){
			sb.append(" and CONVERT(varchar(10),L_FA_DA_Date,120) <= ? ");
			params.add(Utility.getName(po.getsLrbrbEndDate()));
		}
		sb.append(" group by L_FA_DA_DealingsUnit )temp left join B_Franchisee on L_FA_DA_DealingsUnit=B_FS_StoreID  )temp ");	
		
		return (String)getJdbcTemplate().queryForObject(sb.toString(), params.toArray(),String.class);
	}
	
}
