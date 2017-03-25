package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.storage.dao.AllocationApplyForAppDao;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class AllocationApplyForAppDaoImpl extends BaseJdbcDaoSupport implements AllocationApplyForAppDao {
	
	/**
	 * 获取调拨单据数量
	 */
	public int getAllocationCount(AllocationPo po,DepartmentsPo departmentsPo) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(distinct C_SHA_ApplyAllocation.C_SHA_AA_billID) from C_SHA_ApplyAllocation inner join C_SHA_ApplyAllocationEntry on C_SHA_AA_billID=C_SHA_AAE_billId left join B_GoodsInfo on C_SHA_AAE_goodsId=B_GI_GoodsID ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)d on C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=d.B_DP_DepartmentID ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)dd on C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=dd.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_ApplyAllocation.C_SHA_AA_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_ApplyAllocation.C_SHA_AA_auditPerson=b.ID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)e on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=e.B_GC_ID ");
		sb.append("where C_SHA_AA_ForAppFlag = '1' AND C_SHA_AA_flag=?  ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaaflag());
		
		if (!"".equals(Utility.getName(po.getCshaaoutdptcompanyid()))){
		    sb.append(" and (d.B_DP_CompanysID = ? or dd.B_DP_CompanysID = ?) ");
			params.add(Utility.getName(po.getCshaaoutdptcompanyid()));
			params.add(Utility.getName(po.getCshaaoutdptcompanyid()));	
		}
		
		if(!"3".equals(departmentsPo.getBdptype())){
			sb.append("and (C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? or C_SHA_AA_outDepartmentId = ?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
		}else
		{
			if(!"".equals(po.getCshaaindepartmentid()))
			{
				sb.append("and (C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=?) ");
				params.add(po.getCshaaindepartmentid());
			}
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		
		
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditState=? ");
			params.add(po.getCshaaauditstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaacreateperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_createPerson like '%'+?+'%' ");
			params.add(po.getCshaacreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and B_GI_GoodsCategoryID = ? ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_supplier like '%'+?+'%' ");
			params.add(po.getChaasupplier());
		}
		if(!"".equals(Utility.getName(po.getChaagoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCshaaremark()))){
			sb.append("and C_SHA_AA_remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshaaremark()));
		}
		if(!"".equals(Utility.getName(po.getChaagoodsid()))) {
			sb.append("and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsid()));
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	/**
	 * 获取调拨单据
	 */
	public List<AllocationPo> getAllocationList(AllocationPo po,DepartmentsPo departmentsPo, int start,
			int size) {

		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select temp.cshaabillid as cshaabillid,isnull(temp.cshaabillassociation,'1') as cshaabillassociation,temp.cshaaindepartmentname as cshaaindepartmentname,temp.cshaaoutdepartmentname,");
		sb.append("temp.cshaacreatepersonname as cshaacreatepersonname,temp.cshaabilldate as cshaabilldate,");
		sb.append("temp.cshaaauditpersonname as cshaaauditpersonname,temp.cshaaauditdate as cshaaauditdate,");
		sb.append("temp.chaasuppliername as chaasuppliername,temp.goodscategoryname as goodscategoryname,temp.cshaaaindepartmentid as cshaaoutdepartmentid, ");
		sb.append("temp.cshaaauditstate as cshaaauditstate,temp.cshastatusorderid as cshastatusorderid,temp.cshaaremark as cshaaremark,TEMP.isWriteoffs  ");
		sb.append("from(select ROW_NUMBER() Over(order by temp.cshaabilldate desc) as rowNum,");		
		
		sb.append("temp.cshaabillid as cshaabillid,temp.cshaabillassociation as cshaabillassociation,temp.cshaaindepartmentname as cshaaindepartmentname,temp.cshaaoutdepartmentname,temp.cshaaaindepartmentid,");
		sb.append("temp.cshaacreatepersonname as cshaacreatepersonname,temp.cshaabilldate as cshaabilldate,");
		sb.append("temp.cshaaauditpersonname as cshaaauditpersonname,temp.cshaaauditdate as cshaaauditdate,");
		sb.append("temp.chaasuppliername as chaasuppliername,temp.goodscategoryname as goodscategoryname,");
		sb.append("temp.cshaaauditstate as cshaaauditstate,temp.cshastatusorderid as cshastatusorderid,temp.cshaaremark as cshaaremark,TEMP.isWriteoffs from ( ");
		
		sb.append("select distinct C_SHA_A_StatusBillID as cshaabillassociation,C_SHA_ApplyAllocation.C_SHA_AA_billID as cshaabillid,d.B_DP_DepartmentName as cshaaindepartmentname,dd.B_DP_DepartmentName as cshaaoutdepartmentname,C_SHA_AA_inDepartmentId as cshaaaindepartmentid,");
		sb.append("a.personName as cshaacreatepersonname,C_SHA_ApplyAllocation.C_SHA_AA_billDate as cshaabilldate,b.personName as cshaaauditpersonname,C_SHA_ApplyAllocation.C_SHA_AA_auditDate as cshaaauditdate,");
		sb.append("c.B_SP_SupplierName as chaasuppliername,f.B_GC_GoodsCategoryName as goodscategoryname,e.C_SHA_StatusOrderID as cshastatusorderid,C_SHA_AA_remark as cshaaremark,ISNULL(gg.C_SHA_StatusApplyBillID, '0') AS isWriteoffs,");
		sb.append("C_SHA_ApplyAllocation.C_SHA_AA_auditState as cshaaauditstate from C_SHA_ApplyAllocation inner join C_SHA_ApplyAllocationEntry on C_SHA_AA_billID=C_SHA_AAE_billId left join B_GoodsInfo on C_SHA_AAE_goodsId=B_GI_GoodsID ");
		sb.append("left join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)d on C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_ApplyAllocation.C_SHA_AA_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_ApplyAllocation.C_SHA_AA_auditPerson=b.ID ");
		sb.append("       LEFT JOIN (SELECT B_DP_DepartmentID,");
		sb.append("                          B_DP_DepartmentName,B_DP_CompanysID ");
		sb.append("                   FROM   B_Departments)dd");
		sb.append("        ON C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId = dd.B_DP_DepartmentID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)f on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=f.B_GC_ID ");
		sb.append("left join (select * from C_SHA_Status)e on C_SHA_ApplyAllocation.C_SHA_AA_billID=e.C_SHA_StatusApplyBillID ");
		sb.append(" LEFT JOIN (select C_SHA_StatusApplyBillID from C_SHA_Status WHERE (ISNULL(C_SHA_StatusBillID,'')<>'' OR ISNULL(C_SHA_StatusOrderID,'')<>'' OR ISNULL(C_SHA_StatusReceiptID,'')<>''))gg ON gg.C_SHA_StatusApplyBillID = C_SHA_AA_billID ");
		sb.append(" Left join C_SHA_Allocation on C_SHA_A_StatusBillID=C_SHA_AA_billID ");
		sb.append(" where C_SHA_AA_ForAppFlag = '1' AND C_SHA_AA_flag=? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaaflag());
		
		if (!"".equals(Utility.getName(po.getCshaaoutdptcompanyid()))){
		    sb.append(" and (d.B_DP_CompanysID = ? or dd.B_DP_CompanysID = ?) ");
			params.add(Utility.getName(po.getCshaaoutdptcompanyid()));
			params.add(Utility.getName(po.getCshaaoutdptcompanyid()));
		}
		
		if(!"3".equals(departmentsPo.getBdptype())){
			sb.append("and (C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? or C_SHA_AA_outDepartmentId = ?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
		}else
		{
			if(!"".equals(po.getCshaaindepartmentid()))
			{
				sb.append("and (C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=?) ");
				params.add(po.getCshaaindepartmentid());
			}
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=? ");
			params.add(po.getCshaaoutdepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		////////////////////////////////////////
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditState=? ");
			params.add(po.getCshaaauditstate());
		}
		
		if(!"".equals(Utility.getName(po.getCshaacreateperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_createPerson like '%'+?+'%' ");
			params.add(po.getCshaacreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and B_GI_GoodsCategoryID = ? ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_supplier like '%'+?+'%' ");
			params.add(po.getChaasupplier());
		}
		if(!"".equals(Utility.getName(po.getChaagoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsname()));
		}
		if(!"".equals(Utility.getName(po.getChaagoodsid()))){
			sb.append("and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsid()));
		}
		if(!"".equals(Utility.getName(po.getCshaaremark()))){
			sb.append("and C_SHA_AA_remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshaaremark()));
		}
		
		sb.append(" )temp ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), AllocationPo.class);
	}
	
	/**
	 * 获取调拨单据数量
	 */
	public int getReAllocationCount(AllocationPo po,DepartmentsPo departmentsPo) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(C_SHA_ApplyAllocation.C_SHA_AA_billID) from C_SHA_ApplyAllocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_ApplyAllocation.C_SHA_AA_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_ApplyAllocation.C_SHA_AA_auditPerson=b.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)c on C_SHA_ApplyAllocation.C_SHA_AA_consignee=c.ID ");
		sb.append("where C_SHA_AA_ForAppFlag = '1' AND  C_SHA_AA_flag=?  ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaaflag());
		
		if(!"3".equals(departmentsPo.getBdptype())){
			sb.append("and (C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=? or C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
			
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditState=? ");
			params.add(po.getCshaaauditstate());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_consignState=? ");
			params.add(po.getCshaaconsignstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaacreateperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_createPerson like '%'+?+'%' ");
			params.add(po.getCshaacreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignee()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_consignee like '%'+?+'%' ");
			params.add(po.getCshaaconsignee());
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	/**
	 * 获取负调拨单据
	 */
	public List<AllocationPo> getReAllocationList(AllocationPo po,DepartmentsPo departmentsPo, int start,
			int size) {

		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select temp.cshaabillid as cshaabillid,temp.cshaaoutdepartmentname as cshaaoutdepartmentname,temp.cshaaoutdepartmentid as cshaaoutdepartmentid,");
		sb.append("temp.cshaacreatepersonname as cshaacreatepersonname,temp.cshaabilldate as cshaabilldate,");
		sb.append("temp.cshaaauditpersonname as cshaaauditpersonname,temp.cshaaauditdate as cshaaauditdate,");
		sb.append("temp.cshaaconsigneename as cshaaconsigneename,temp.cshaaconsigndate as cshaaconsigndate,");
		sb.append("temp.cshaaauditstate as cshaaauditstate,temp.cshaaconsignstate as cshaaconsignstate ");
		sb.append("from(select ROW_NUMBER() Over(order by C_SHA_ApplyAllocation.C_SHA_AA_billDate desc,C_SHA_ApplyAllocation.C_SHA_AA_billID desc) as rowNum,");
		sb.append("C_SHA_ApplyAllocation.C_SHA_AA_billID as cshaabillid,d.B_DP_DepartmentName as cshaaoutdepartmentname,C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId as cshaaoutdepartmentid,");
		sb.append("a.personName as cshaacreatepersonname,C_SHA_ApplyAllocation.C_SHA_AA_billDate as cshaabilldate,b.personName as cshaaauditpersonname,C_SHA_ApplyAllocation.C_SHA_AA_auditDate as cshaaauditdate,");
		sb.append("c.personName as cshaaconsigneename,C_SHA_ApplyAllocation.C_SHA_AA_consignDate as cshaaconsigndate,");
		sb.append("C_SHA_ApplyAllocation.C_SHA_AA_auditState as cshaaauditstate,C_SHA_ApplyAllocation.C_SHA_AA_consignState as cshaaconsignstate from C_SHA_ApplyAllocation ");
		sb.append("left join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_ApplyAllocation.C_SHA_AA_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_ApplyAllocation.C_SHA_AA_auditPerson=b.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)c on C_SHA_ApplyAllocation.C_SHA_AA_consignee=c.ID ");
		sb.append(" where C_SHA_AA_ForAppFlag = '1' AND  C_SHA_AA_flag=? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaaflag());
		if(!"3".equals(departmentsPo.getBdptype())){
			sb.append("and (C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=? or C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
			
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=? ");
			params.add(po.getCshaaoutdepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditState=? ");
			params.add(po.getCshaaauditstate());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_consignState=? ");
			params.add(po.getCshaaconsignstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaacreateperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_createPerson like '%'+?+'%' ");
			params.add(po.getCshaacreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignee()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_consignee like '%'+?+'%' ");
			params.add(po.getCshaaconsignee());
		}
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), AllocationPo.class);
	}
	
	/**
	 * 新增调拨单
	 */
	public void insertAllocation(AllocationPo po) {
		
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		sb1.append("insert into C_SHA_ApplyAllocation(C_SHA_AA_billID,C_SHA_AA_billDate,C_SHA_AA_inDepartmentId,");
		sb1.append("C_SHA_AA_createPerson,C_SHA_AA_auditState,C_SHA_AA_remark,C_SHA_AA_flag,C_SHA_AA_ForAppFlag,C_SHA_AA_outDepartmentId ");
		sb1.append(",C_SHA_AA_goodscategory,C_SHA_AA_supplier ");
		sb2.append("?,getdate(),?,?,?,?,");
		sb2.append("?,1,?,?,? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaabillid());
		params.add(po.getCshaaindepartmentid());
		params.add(po.getCshaacreateperson());
		params.add(po.getCshaaauditstate());
		params.add(po.getCshaaremark());
		params.add(po.getCshaaflag());
		params.add(po.getCshaaoutdepartmentid());
		params.add(Utility.getName(po.getGoodscategoryid()));
		params.add(Utility.getName(po.getChaasupplier()));
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb1.append(",C_SHA_AA_auditPerson,C_SHA_AA_auditDate");
			sb2.append(",?,getdate()");
			params.add(po.getCshaaauditperson());
		}		
		
		String sql=sb1.toString()+")values("+sb2.toString()+")";
		getJdbcTemplate().update(sql,params.toArray());
		
	}
	
	/**
	 * 调拨明细新增
	 */
	public void insertAllocationEntry(AllocationEntryPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		sb.append("insert into C_SHA_ApplyAllocationEntry(C_SHA_AAE_ID,C_SHA_AAE_billId,C_SHA_AAE_goodsId");
		sb.append(",C_SHA_AAE_requirementQuantity)values");
		sb.append("(?,?,?,?)");
		params.add(this.uuid.generate());
		params.add(po.getCshaaebillid());
		params.add(po.getCshaaegoodsid());
		params.add(po.getCshaaerequirementquantity());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 更改调拨单 
	 */
	public void updateAllocation(AllocationPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("update C_SHA_ApplyAllocation set C_SHA_AA_inDepartmentId=?,");
		sb.append("C_SHA_AA_auditState=?,C_SHA_AA_remark=? ");
		params.add(po.getCshaaindepartmentid());
		params.add(po.getCshaaauditstate());
		params.add(po.getCshaaremark());
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append(",C_SHA_AA_auditPerson=?,C_SHA_AA_auditDate=getdate() ");
			params.add(po.getCshaaauditperson());
		}
		sb.append(" where C_SHA_AA_billID=?");
		params.add(po.getCshaabillid());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除调拨单
	 */
	public void deleteAllocation(AllocationPo po) {
		
		String sql="delete from C_SHA_ApplyAllocation where C_SHA_AA_billID=?";	
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaabillid());
		getJdbcTemplate().update(sql,params.toArray());
	}
	
	/**
	 * 删除调拨明细
	 */
	public void deleteAllocationEntry(AllocationPo po) {
		
		String sql="delete from C_SHA_ApplyAllocationEntry where C_SHA_AAE_billId=?";	
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaabillid());
		getJdbcTemplate().update(sql,params.toArray());
	}
	
	/**
	 * 获取调拨单
	 */
	public AllocationPo getAllocation(AllocationPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT TOP 1 C_SHA_ApplyAllocation.C_SHA_AA_billID          AS cshaabillid,");
		sb.append("             d.B_DP_DepartmentName                          AS cshaaoutdepartmentname,");//申请部门名称
		sb.append("             dd.B_DP_DepartmentName                          AS cshaaindepartmentname,");//接收部门名称
		sb.append("             d.B_DP_DepartmentID                            AS cshaaoutdepartmentid,");
		sb.append("             a.personName                                   AS cshaacreatepersonname,");
		sb.append("             C_SHA_ApplyAllocation.C_SHA_AA_billDate        AS cshaabilldate,");
		sb.append("             b.personName                                   AS cshaaauditpersonname,");
		sb.append("             C_SHA_ApplyAllocation.C_SHA_AA_createPerson    AS cshaacreateperson,");
		sb.append("             C_SHA_ApplyAllocation.C_SHA_AA_auditPerson     AS cshaaauditperson,");
		sb.append("             C_SHA_ApplyAllocation.C_SHA_AA_auditDate       AS cshaaauditdate,");
		sb.append("             C_SHA_ApplyAllocation.C_SHA_AA_auditState      AS cshaaauditstate,");
		 sb.append("            C_SHA_ApplyAllocation.C_SHA_AA_remark          AS cshaaremark,");
		sb.append("             C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId  AS cshaaindepartmentid,");//申请部门ID
		sb.append("             C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId  AS cshaaoutdepartmentid,");//接收部门ID
		sb.append("             C_SHA_ApplyAllocation.C_SHA_AA_supplier        AS chaasupplier,");
		sb.append("             x.B_SP_SupplierName                            AS chaasuppliername,");
		sb.append("			    e.B_GC_GoodsCategoryName                       as goodscategoryname,");
		sb.append("			    e.B_GC_ID                                      as goodscategoryid ");
		sb.append("FROM   C_SHA_ApplyAllocation");
		sb.append("       left JOIN (SELECT B_DP_DepartmentID,");
		sb.append("                          B_DP_DepartmentName");
		sb.append("                   FROM   B_Departments)d");
		sb.append("        ON C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId = d.B_DP_DepartmentID");
		sb.append("       left JOIN (SELECT B_DP_DepartmentID,");
		sb.append("                          B_DP_DepartmentName");
		sb.append("                   FROM   B_Departments)dd");
		sb.append("        ON C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId = dd.B_DP_DepartmentID ");
		sb.append("      LEFT JOIN (SELECT ID,");
		sb.append("                         personName");
		 sb.append("                 FROM   SYS_PersonInfo)a");
		 sb.append("        ON C_SHA_ApplyAllocation.C_SHA_AA_createPerson = a.ID");
		 sb.append("      LEFT JOIN (SELECT B_SP_ID,");
		 sb.append("                        B_SP_SupplierName");
		 sb.append("                 FROM   B_Supplier)x");
		 sb.append("        ON C_SHA_ApplyAllocation.C_SHA_AA_supplier = x.B_SP_ID");
		  sb.append("     LEFT JOIN (SELECT ID,");
		  sb.append("                       personName");
		  sb.append("                FROM   SYS_PersonInfo)b");
		  sb.append("       ON C_SHA_ApplyAllocation.C_SHA_AA_auditPerson = b.ID");
		  sb.append("     LEFT JOIN (SELECT B_GC_ID,");
		  sb.append("                       B_GC_GoodsCategoryName");
		  sb.append("                FROM   B_GoodsCategory)e");
		  sb.append("       ON C_SHA_ApplyAllocation.C_SHA_AA_goodscategory = e.B_GC_ID");
		  sb.append("      WHERE  C_SHA_ApplyAllocation.C_SHA_AA_billID = ?");

		List<String> params = new ArrayList<String>();
		params.add(po.getCshaabillid());
		
		return (AllocationPo)queryForObject(sb.toString(), params.toArray(), AllocationPo.class);
	}
	/**
	 * 获取调拨明细
	 */
	public List<AllocationEntryPo> getAllocationEntryList(AllocationPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT C_SHA_ApplyAllocationEntry.C_SHA_AAE_billId                   AS cshaaebillid, ");
				sb.append("       C_SHA_ApplyAllocationEntry.C_SHA_AAE_goodsId                  AS cshaaegoodsid, ");
				sb.append("       B_GoodsInfo.B_GI_GoodsBarCode                                AS cshaaegoodsBarCode, ");
				sb.append("       B_GoodsInfo.B_GI_ViewGoodsName                                   AS cshaaegoodsname, ");
				sb.append("       B_GoodsInfo.B_GI_Spec                                        AS cshaaespec, ");
				sb.append("       SUM(C_SHA_ApplyAllocationEntry.C_SHA_AAE_requirementQuantity) AS cshaaerequirementquantity, ");
				sb.append("       B_GoodsInfo.B_GI_NotTaxRate                                  AS cshaaenottaxrate, ");
				sb.append("       B_GoodsInfo.B_GI_TaxRate                                     AS cshaaetaxrate, ");
				sb.append("       B_GoodsInfo.B_GI_CostPrice                                   AS cshaaecostprice,");
				sb.append("       B_GoodsInfo.B_GI_RetailPrice                                 AS cshaaebgiretailprice ");
				sb.append("FROM   C_SHA_ApplyAllocationEntry ");
				sb.append("       INNER JOIN B_GoodsInfo ");
				sb.append("         ON C_SHA_ApplyAllocationEntry.C_SHA_AAE_goodsId = B_GoodsInfo.B_GI_GoodsID ");
				sb.append("WHERE  C_SHA_AAE_billId = ? ");
				sb.append("GROUP  BY C_SHA_ApplyAllocationEntry.C_SHA_AAE_goodsId, ");
				sb.append("          C_SHA_ApplyAllocationEntry.C_SHA_AAE_billId, ");
				sb.append("          B_GoodsInfo.B_GI_GoodsBarCode, ");
				sb.append("          B_GoodsInfo.B_GI_ViewGoodsName, ");
				sb.append("          B_GoodsInfo.B_GI_Spec, ");
				sb.append("          B_GoodsInfo.B_GI_NotTaxRate, ");
				sb.append("          B_GoodsInfo.B_GI_TaxRate, ");
				sb.append("         B_GoodsInfo.B_GI_CostPrice, ");
				sb.append("         B_GoodsInfo.B_GI_RetailPrice  ");
		params.add(po.getCshaabillid());
		return queryForObjectList(sb.toString(), params.toArray(), AllocationEntryPo.class);
	}
	/**
	 * 调拨收货
	 */
	public void updateAllocationReceive(AllocationPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("update C_SHA_ApplyAllocation set C_SHA_AA_consignee=?,C_SHA_AA_consignState=?,C_SHA_AA_consignDate=getdate() where C_SHA_AA_billID=?");
		params.add(po.getCshaaconsignee());
		params.add(po.getCshaaconsignstate());
		params.add(po.getCshaabillid());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	/**
	 * 调拨后业务单据新增
	 */
	public void insertAllocationForInventory(InventoryPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("insert into C_ST_Inventory(C_ST_I_BillID,C_ST_I_BillTypeId,C_ST_I_billDate,C_ST_I_InStockId,C_ST_I_OutStockId,");
		sb.append("C_ST_I_DepartmentId,C_ST_I_createPerson,C_ST_I_AuditPerson,C_ST_I_AuditDate,C_ST_I_AuditState,C_ST_I_Remark)");
		sb.append("values(?,?,?,?,?,");
		sb.append("?,?,?,?,?,?)");
		
		params.add(po.getCstibillid());
		params.add(po.getCstibilltypeid());
		params.add(po.getCstibilldate());
		params.add(po.getCstiinstockid());
		params.add(po.getCstioutstockid());
		params.add(po.getCstidepartmentid());
		params.add(po.getCsticreateperson());
		params.add(po.getCstiauditperson());
		params.add(po.getCstiauditdate());
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());
		getJdbcTemplate().update(sb.toString(),params.toArray());		
	}
	/**
	 * 调拨后业务单据明细新增
	 */
	public void insertAllocationForInventoryEntry(InventoryEntryPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();

		sb.append("insert into C_ST_InventoryEntry(C_ST_IE_ID,C_ST_IE_BillID,C_ST_IE_GoodsId,C_ST_IE_BarCode,C_ST_IE_GoodsQuantity,");
		sb.append("C_ST_IE_OutStockId,C_ST_IE_InStockId,C_ST_IE_NotTaxRate,C_ST_IE_TaxRate,C_ST_IE_CostPrice,");
		sb.append("C_ST_IE_NotTaxRateAmount,C_ST_IE_TaxAmount,C_ST_IE_CostPriceAmount,C_ST_IE_WarehousingDate)");
		sb.append("values(?,?,?,?,?,");
		sb.append("?,?,?,?,?,");
		sb.append("?,?,?,getdate())");
		
		params.add(this.uuid.generate());
		params.add(po.getCstiebillid());
		params.add(po.getCstiegoodsid());
		params.add(po.getCstiebarcode());
		params.add(po.getCstiegoodsquantity());
		params.add(po.getCstieoutstockid());
		params.add(po.getCstieinstockid());
		params.add(po.getCstienottaxrate());
		params.add(po.getCstietaxrate());
		params.add(po.getCstiecostprice());
		params.add(po.getCstienottaxrateamount());
		params.add(po.getCstietaxamount());
		params.add(po.getCstiecostpriceamount());
		getJdbcTemplate().update(sb.toString(),params.toArray());		
	}
	
	/*
	 * 反审核
	 */
	public void returnAudit(String billID){
		StringBuffer sb = new StringBuffer();
		sb.append("update C_SHA_ApplyAllocation set C_SHA_AA_auditState='0',C_SHA_AA_auditPerson='',C_SHA_AA_auditDate=null where C_SHA_AA_billID=?");
		List<String> params = new ArrayList<String>();
		params.add(billID);
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void insertSms(SmsLertsPo smsLertsPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into C_ST_SmsLerts ");
		sb.append("values(?,?,?,getdate(),?,?,?,?,?)");
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(smsLertsPo.getCstsltitle());
		params.add(smsLertsPo.getCstslcontent());
		params.add(smsLertsPo.getCstslsenddepartment());
		params.add(Utility.getName(smsLertsPo.getCstslreceivedepartment()));
		params.add(smsLertsPo.getCstslsendperson());
		params.add(smsLertsPo.getCstslreceiveperson());
		params.add(smsLertsPo.getCstslflag());
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void insertAllocationStatus(AllocationPo po) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into C_SHA_Status (C_SHA_StatusUUID,C_SHA_StatusApplyBillID) ");
		sb.append("values(?,?)");
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(po.getCshaabillid());
		
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void deleteAllocationBarcode(AllocationPo allocationPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from  C_SHA_ApplyAllocationBarcode ");
		sb.append("where C_SHA_B_billID=?");
		List<String> params = new ArrayList<String>();
		params.add(allocationPo.getCshaabillid());
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public List<AllocationBarcodePo> getAllocationBarcode(AllocationPo allocationPo){
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("select C_SHA_B_GoodsID as cshabgoodsid,C_SHA_B_GoodsBarcode as cshabgoodsbarcode from C_SHA_ApplyAllocationBarcode where C_SHA_B_billID=? and 1=1 ");
		params.add(allocationPo.getCshaabillid());
		
		return queryForObjectList(sb.toString(), params.toArray(), AllocationBarcodePo.class);
	}

	public List<AllocationBarcodePo> getAllocationBarcode(AllocationPo allocationPo,String goodsID){
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("select C_SHA_B_GoodsID as cshabgoodsid,C_SHA_B_GoodsBarcode as cshabgoodsbarcode from C_SHA_AllocationBarcode where C_SHA_B_billID=? and 1=1 ");
		params.add(allocationPo.getCshaabillid());
		if(!"".equals(goodsID)){
			sb.append(" and C_SHA_B_GoodsID=? ");
			params.add(goodsID);//此处代表商品代码
		}
		
		return queryForObjectList(sb.toString(), params.toArray(), AllocationBarcodePo.class);
	}
	
	//查询库存数量
	public int getAllocationCount(AllocationPo allocationPo) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(C_SH_SC_UUID) from C_SH_StorageChange ");
		sb.append("where C_SH_SC_ChangeID=?");
		List<String> params = new ArrayList<String>();
		params.add(allocationPo.getCshaabillid());
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public void insertAllocationBarcode(AllocationBarcodePo allocationBarcodePo) {
		
		
	}
	
	/**
	 * 获取调拨单据数量
	 */
	public int getProcurementOrdersForAppCount(AllocationPo po,DepartmentsPo departmentsPo) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(distinct C_SHA_ApplyAllocation.C_SHA_AA_billID) from C_SHA_ApplyAllocation inner join C_SHA_ApplyAllocationEntry on C_SHA_AA_billID=C_SHA_AAE_billId And C_SHA_AA_OrderStatus = '0' and C_SHA_AA_auditState = '1' and isnull(C_SHA_AA_goodscategory,'') <> '' and isnull(C_SHA_AA_supplier,'') <> '' left join B_GoodsInfo on C_SHA_AAE_goodsId=B_GI_GoodsID ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)d on C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)x on C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=x.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_ApplyAllocation.C_SHA_AA_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_ApplyAllocation.C_SHA_AA_auditPerson=b.ID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)e on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=e.B_GC_ID ");
		sb.append("where C_SHA_AA_ForAppFlag = '1' AND C_SHA_AA_flag=? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaaflag());
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    sb.append(" and (d.B_DP_CompanysID = ? or x.B_DP_CompanysID = ?) ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}		
		
		if(!"3".equals(departmentsPo.getBdptype())){
			sb.append("and (C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? or C_SHA_AA_outDepartmentId = ?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
		}else
		{
			if(!"".equals(po.getCshaaindepartmentid()))
			{
				sb.append("and (C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=?) ");
				params.add(po.getCshaaindepartmentid());
			}
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		
		
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditState=? ");
			params.add(po.getCshaaauditstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaacreateperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_createPerson like '%'+?+'%' ");
			params.add(po.getCshaacreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and B_GI_GoodsCategoryID = ? ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_supplier like '%'+?+'%' ");
			params.add(po.getChaasupplier());
		}
		if(!"".equals(Utility.getName(po.getChaagoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCshaaremark()))){
			sb.append("and C_SHA_AA_remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshaaremark()));
		}
		if(!"".equals(Utility.getName(po.getChaagoodsid()))) {
			sb.append("and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsid()));
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	/**
	 * 获取调拨单据
	 */
	public List<AllocationPo> getProcurementOrdersForAppList(AllocationPo po,DepartmentsPo departmentsPo, int start,int size) {
		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select temp.cshaabillid as cshaabillid,isnull(temp.cshaabillassociation,'1') as cshaabillassociation,temp.cshaaindepartmentname as cshaaindepartmentname,temp.cshaaoutdepartmentname,");
		sb.append("temp.cshaacreatepersonname as cshaacreatepersonname,temp.cshaabilldate as cshaabilldate,temp.chaasupplier as chaasupplier,");
		sb.append("temp.cshaaauditpersonname as cshaaauditpersonname,temp.cshaaauditdate as cshaaauditdate,temp.goodscategoryid as goodscategoryid,");
		sb.append("temp.chaasuppliername as chaasuppliername,temp.goodscategoryname as goodscategoryname,temp.cshaaaindepartmentid as cshaaoutdepartmentid, ");
		sb.append("temp.cshaaauditstate as cshaaauditstate,temp.cshastatusorderid as cshastatusorderid,temp.cshaaremark as cshaaremark,TEMP.isWriteoffs  ");
		sb.append("from(select ROW_NUMBER() Over(order by temp.cshaabilldate desc) as rowNum,");		
		
		sb.append("temp.cshaabillid as cshaabillid,temp.cshaabillassociation as cshaabillassociation,temp.cshaaindepartmentname as cshaaindepartmentname,temp.cshaaoutdepartmentname,temp.cshaaaindepartmentid,");
		sb.append("temp.cshaacreatepersonname as cshaacreatepersonname,temp.cshaabilldate as cshaabilldate,");
		sb.append("temp.cshaaauditpersonname as cshaaauditpersonname,temp.cshaaauditdate as cshaaauditdate,");
		sb.append("temp.chaasuppliername as chaasuppliername,temp.goodscategoryname as goodscategoryname,temp.chaasupplier as chaasupplier,temp.goodscategoryid as goodscategoryid,");
		sb.append("temp.cshaaauditstate as cshaaauditstate,temp.cshastatusorderid as cshastatusorderid,temp.cshaaremark as cshaaremark,TEMP.isWriteoffs from ( ");
		
		sb.append("select distinct C_SHA_A_StatusBillID as cshaabillassociation,C_SHA_ApplyAllocation.C_SHA_AA_billID as cshaabillid,d.B_DP_DepartmentName as cshaaindepartmentname,dd.B_DP_DepartmentName as cshaaoutdepartmentname,C_SHA_AA_inDepartmentId as cshaaaindepartmentid,");
		sb.append("a.personName as cshaacreatepersonname,C_SHA_ApplyAllocation.C_SHA_AA_billDate as cshaabilldate,b.personName as cshaaauditpersonname,C_SHA_ApplyAllocation.C_SHA_AA_auditDate as cshaaauditdate,");
		sb.append("c.B_SP_ID as chaasupplier,c.B_SP_SupplierName as chaasuppliername,f.B_GC_ID as goodscategoryid,f.B_GC_GoodsCategoryName as goodscategoryname,e.C_SHA_StatusOrderID as cshastatusorderid,C_SHA_AA_remark as cshaaremark,ISNULL(gg.C_SHA_StatusApplyBillID, '0') AS isWriteoffs,");
		sb.append("C_SHA_ApplyAllocation.C_SHA_AA_auditState as cshaaauditstate from C_SHA_ApplyAllocation inner join C_SHA_ApplyAllocationEntry on C_SHA_AA_billID=C_SHA_AAE_billId  And C_SHA_AA_OrderStatus = '0' and C_SHA_AA_auditState = '1' and isnull(C_SHA_AA_goodscategory,'') <> '' and isnull(C_SHA_AA_supplier,'') <> '' left join B_GoodsInfo on C_SHA_AAE_goodsId=B_GI_GoodsID ");
		sb.append("left join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)d on C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)x on C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=x.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_ApplyAllocation.C_SHA_AA_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_ApplyAllocation.C_SHA_AA_auditPerson=b.ID ");
		sb.append("       LEFT JOIN (SELECT B_DP_DepartmentID,");
		sb.append("                          B_DP_DepartmentName");
		sb.append("                   FROM   B_Departments)dd");
		sb.append("        ON C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId = dd.B_DP_DepartmentID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)f on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=f.B_GC_ID ");
		sb.append("left join (select * from C_SHA_Status)e on C_SHA_ApplyAllocation.C_SHA_AA_billID=e.C_SHA_StatusApplyBillID ");
		sb.append(" LEFT JOIN (select C_SHA_StatusApplyBillID from C_SHA_Status WHERE (ISNULL(C_SHA_StatusBillID,'')<>'' OR ISNULL(C_SHA_StatusOrderID,'')<>'' OR ISNULL(C_SHA_StatusReceiptID,'')<>''))gg ON gg.C_SHA_StatusApplyBillID = C_SHA_AA_billID ");
		sb.append(" Left join C_SHA_Allocation on C_SHA_A_StatusBillID=C_SHA_AA_billID ");
		sb.append(" where C_SHA_AA_ForAppFlag = '1' AND C_SHA_AA_flag=? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaaflag());
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    sb.append(" and (d.B_DP_CompanysID = ? or x.B_DP_CompanysID = ?) ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}	
		
		if(!"3".equals(departmentsPo.getBdptype())){
			sb.append("and (C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? or C_SHA_AA_outDepartmentId = ?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
		}else
		{
			if(!"".equals(po.getCshaaindepartmentid()))
			{
				sb.append("and (C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=?) ");
				params.add(po.getCshaaindepartmentid());
			}
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=? ");
			params.add(po.getCshaaoutdepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		////////////////////////////////////////
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditState=? ");
			params.add(po.getCshaaauditstate());
		}
		
		if(!"".equals(Utility.getName(po.getCshaacreateperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_createPerson like '%'+?+'%' ");
			params.add(po.getCshaacreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and B_GI_GoodsCategoryID = ? ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_supplier like '%'+?+'%' ");
			params.add(po.getChaasupplier());
		}
		if(!"".equals(Utility.getName(po.getChaagoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsname()));
		}
		if(!"".equals(Utility.getName(po.getChaagoodsid()))){
			sb.append("and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsid()));
		}
		if(!"".equals(Utility.getName(po.getCshaaremark()))){
			sb.append("and C_SHA_AA_remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshaaremark()));
		}
		
		sb.append(" )temp ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), AllocationPo.class);
	}

}
