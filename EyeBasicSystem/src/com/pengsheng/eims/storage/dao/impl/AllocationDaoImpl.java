package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.dao.AllocationDao;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StatusPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class AllocationDaoImpl extends BaseJdbcDaoSupport implements AllocationDao {
	
	/**
	 * 获取调拨单据数量
	 */
	public int getAllocationCount(AllocationPo po,DepartmentsPo departmentsPo) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(distinct C_SHA_Allocation.C_SHA_A_billID) from C_SHA_Allocation ");
		
		if(!"".equals(Utility.getName(po.getChaasupplier())) || !"".equals(Utility.getName(po.getChaabrand())) || !"".equals(Utility.getName(po.getChaagoodsname())) || !"".equals(Utility.getName(po.getChaagoodsid()))){
			sb.append("inner join C_SHA_AllocationEntry on C_SHA_A_billID=C_SHA_AE_billId inner join B_GoodsInfo on C_SHA_AE_goodsId=B_GI_GoodsID ");
		}		

		sb.append("left join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)d on C_SHA_Allocation.C_SHA_A_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)x on C_SHA_Allocation.C_SHA_A_outDepartmentId=x.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_Allocation.C_SHA_A_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_Allocation.C_SHA_A_auditPerson=b.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)c on C_SHA_Allocation.C_SHA_A_consignee=c.ID ");
		sb.append("where C_SHA_A_flag=?  ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaaflag());
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    sb.append(" and (d.B_DP_CompanysID = ? or x.B_DP_CompanysID = ?) ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_outDepartmentId=?  ");
			params.add(po.getCshaaoutdepartmentid());
		}
		
		if (departmentsPo.getBdptype().equals("1") || departmentsPo.getBdptype().equals("2")){
			sb.append("and ((C_SHA_Allocation.C_SHA_A_inDepartmentId=? and C_SHA_Allocation.C_SHA_A_auditState = '1') or C_SHA_Allocation.C_SHA_A_outDepartmentId=?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
		}
		
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_auditState=? ");
			params.add(po.getCshaaauditstate());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignState=? ");
			params.add(po.getCshaaconsignstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaacreateperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_createPerson=? ");
			params.add(po.getCshaacreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_auditPerson=? ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignee()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignee=? ");
			params.add(po.getCshaaconsignee());
		}
		
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and substring(C_SHA_AllocationEntry.C_SHA_AE_goodsId,3,2)=? ");
			params.add(Utility.getName(po.getChaasupplier()));
		}

		if(!"".equals(Utility.getName(po.getChaabrand()))){
			sb.append("and substring(C_SHA_AllocationEntry.C_SHA_AE_goodsId,6,2)=? ");
			params.add(Utility.getName(po.getChaabrand()));
		}
		
		if(!"".equals(Utility.getName(po.getChaagoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCshaaremark()))){
			sb.append("and C_SHA_A_remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshaaremark()));
		}
		if("0".equals(Utility.getName(po.getChaaautoflag()))){
			sb.append("and isnull(C_SHA_A_AutoAllocationFlag,'') = '0' ");
		}
		if("1".equals(Utility.getName(po.getChaaautoflag()))){
			sb.append("and isnull(C_SHA_A_AutoAllocationFlag,'') = '' ");
		}
		
		if(!"".equals(Utility.getName(po.getChaagoodsid()))){
			sb.append("and C_SHA_AE_goodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsid()));
		}
		
		if(!"".equals(Utility.getName(po.getCshaabillassociation()))){
			sb.append("and C_SHA_A_StatusBillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshaabillassociation()));
		}
		if(!"".equals(Utility.getName(po.getCshaacategoryid()))){
			sb.append("and C_SHA_A_CategoryID = ? ");
			params.add(Utility.getName(po.getCshaacategoryid()));
		}
		
		if(!"".equals(Utility.getName(po.getCshaaindepartmentname()))){
			sb.append("and d.B_DP_DepartmentName like '%'+?+'%' ");
			params.add(Utility.getName(po.getCshaaindepartmentname()));
		}
		
		if(!"".equals(Utility.getName(po.getCshaaprinttype()))){
			if("1".equals(Utility.getName(po.getCshaaprinttype()))){
				sb.append("and C_SHA_A_PrintType=? ");
				params.add(po.getCshaaprinttype());
			}else if("0".equals(Utility.getName(po.getCshaaprinttype()))){
				sb.append("and isnull(C_SHA_A_PrintType,'') = '' ");
			}
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
		sb.append("SELECT DISTINCT TEMP.cshaabillid AS cshaabillid, ");
		sb.append("TEMP.cshaaoutdepartmentname AS cshaaoutdepartmentname, ");
		sb.append("TEMP.cshaaoutdepartmentid   AS cshaaoutdepartmentid, ");
		sb.append("TEMP.cshaacreatepersonname  AS cshaacreatepersonname, ");
		sb.append("TEMP.cshaabilldate          AS cshaabilldate, ");
		sb.append("TEMP.cshaaauditpersonname   AS cshaaauditpersonname, ");
		sb.append("TEMP.cshaaauditdate         AS cshaaauditdate, ");
		sb.append("TEMP.cshaaconsigneename     AS cshaaconsigneename, ");
		sb.append("TEMP.cshaaconsigndate       AS cshaaconsigndate, ");
		sb.append("TEMP.cshaaauditstate        AS cshaaauditstate, ");
		sb.append("TEMP.cshaacategoryid        AS cshaacategoryid, ");
		sb.append("TEMP.cshaaremark        	   AS cshaaremark, ");
		sb.append("TEMP.goodscategoryname      AS goodscategoryname, ");
		sb.append("TEMP.cshaaprinttype         AS cshaaprinttype, ");
		sb.append("isnull(TEMP.cshaaconsignstate,'0')      AS cshaaconsignstate, ");
		sb.append("TEMP.cshaaindepartmentname      AS cshaaindepartmentname, ");
		sb.append("TEMP.cshaaindepartmentid     AS cshaaindepartmentid, ");
		sb.append("rowNum FROM  (select  ");
		sb.append("Row_number() OVER(ORDER BY cshaabilldate DESC) AS rowNum, ");
		sb.append("cshaabillid,cshaaoutdepartmentname,cshaaoutdepartmentid,cshaaprinttype, ");
		sb.append("cshaacreatepersonname,cshaabilldate,cshaaauditpersonname,cshaaauditdate, ");
		sb.append("cshaaconsigneename, cshaaconsigndate, cshaaauditstate,cshaaconsignstate,cshaaindepartmentname,cshaaindepartmentid,cshaaremark,cshaacategoryid,goodscategoryname  ");
		sb.append("from ( ");
		sb.append("SELECT distinct  C_SHA_Allocation.C_SHA_A_billID AS cshaabillid, ");                                                                         
		sb.append("d.B_DP_DepartmentName AS cshaaindepartmentname, ");
		sb.append("e.B_DP_DepartmentName AS cshaaoutdepartmentname, ");
		sb.append("C_SHA_A_CategoryID as cshaacategoryid, ");
		sb.append("B_GC_GoodsCategoryName as goodscategoryname, ");
		sb.append("C_SHA_Allocation.C_SHA_A_outDepartmentId AS cshaaoutdepartmentid, ");
		sb.append("C_SHA_Allocation.C_SHA_A_inDepartmentId AS cshaaindepartmentid, ");
		sb.append("a.personName                            AS cshaacreatepersonname, ");
		sb.append("C_SHA_Allocation.C_SHA_A_billDate       AS cshaabilldate, ");
		sb.append("b.personName                            AS cshaaauditpersonname, ");
		sb.append("C_SHA_Allocation.C_SHA_A_auditDate      AS cshaaauditdate, ");
		sb.append("c.personName                            AS cshaaconsigneename, ");
		sb.append("C_SHA_Allocation.C_SHA_A_consignDate    AS cshaaconsigndate, ");
		sb.append("C_SHA_Allocation.C_SHA_A_auditState     AS cshaaauditstate, ");
		sb.append("C_SHA_Allocation.C_SHA_A_consignState   AS cshaaconsignstate, ");
		sb.append("C_SHA_Allocation.C_SHA_A_PrintType      AS cshaaprinttype, ");
		sb.append("C_SHA_A_remark   AS cshaaremark ");
		sb.append("FROM   C_SHA_Allocation ");
		
		if(!"".equals(Utility.getName(po.getChaasupplier())) || !"".equals(Utility.getName(po.getChaabrand())) || !"".equals(Utility.getName(po.getChaagoodsname())) || !"".equals(Utility.getName(po.getChaagoodsid()))){
			sb.append("left JOIN C_SHA_AllocationEntry ON C_SHA_A_billID = C_SHA_AE_billId inner join B_GoodsInfo on C_SHA_AE_goodsId=B_GI_GoodsID ");
		}
		
		sb.append("left JOIN (SELECT B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID FROM   B_Departments)d ");
		sb.append("ON C_SHA_Allocation.C_SHA_A_inDepartmentId = d.B_DP_DepartmentID ");
		sb.append("left JOIN (SELECT B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID FROM   B_Departments)e ");
		sb.append("ON C_SHA_Allocation.C_SHA_A_outDepartmentId = e.B_DP_DepartmentID ");
		sb.append("left join B_GoodsCategory on B_GC_ID = C_SHA_A_CategoryID ");
		sb.append("LEFT JOIN (SELECT ID,personName FROM   SYS_PersonInfo)a ON C_SHA_Allocation.C_SHA_A_createPerson = a.ID ");
		sb.append("LEFT JOIN (SELECT ID,personName FROM   SYS_PersonInfo)b ON C_SHA_Allocation.C_SHA_A_auditPerson = b.ID ");
		sb.append("LEFT JOIN (SELECT ID,personName FROM   SYS_PersonInfo)c ON C_SHA_Allocation.C_SHA_A_consignee = c.ID ");

		sb.append(" where C_SHA_A_flag=? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaaflag());
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    sb.append(" and (d.B_DP_CompanysID = ? or e.B_DP_CompanysID = ?) ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");
			params.add(po.getCshaabillid());
		}	
		
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_outDepartmentId=?  ");
			params.add(po.getCshaaoutdepartmentid());
		}
		
		if (departmentsPo.getBdptype().equals("1") || departmentsPo.getBdptype().equals("2")){
			sb.append("and ((C_SHA_Allocation.C_SHA_A_inDepartmentId=? and C_SHA_Allocation.C_SHA_A_auditState = '1') or C_SHA_Allocation.C_SHA_A_outDepartmentId=?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
		}
		
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_auditState=? ");
			params.add(po.getCshaaauditstate());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignState=? ");
			params.add(po.getCshaaconsignstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaacreateperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_createPerson=? ");
			params.add(po.getCshaacreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_auditPerson=? ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignee()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignee=? ");
			params.add(po.getCshaaconsignee());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and substring(C_SHA_AllocationEntry.C_SHA_AE_goodsId,3,2)=? ");
			params.add(Utility.getName(po.getChaasupplier()));
		}
		if(!"".equals(Utility.getName(po.getChaabrand()))){
			sb.append("and substring(C_SHA_AllocationEntry.C_SHA_AE_goodsId,6,2)=? ");
			params.add(Utility.getName(po.getChaabrand()));
		}
		if(!"".equals(Utility.getName(po.getChaagoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCshaaremark()))){
			sb.append("and C_SHA_A_remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshaaremark()));
		}
		if("0".equals(Utility.getName(po.getChaaautoflag()))){
			sb.append("and isnull(C_SHA_A_AutoAllocationFlag,'') = '0' ");
		}
		if("1".equals(Utility.getName(po.getChaaautoflag()))){
			sb.append("and isnull(C_SHA_A_AutoAllocationFlag,'') = '' ");
		}
		if(!"".equals(Utility.getName(po.getChaagoodsid()))){
			sb.append("and C_SHA_AE_goodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsid()));
		}
		if(!"".equals(Utility.getName(po.getCshaabillassociation()))){
			sb.append("and C_SHA_A_StatusBillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshaabillassociation()));
		}
		if(!"".equals(Utility.getName(po.getCshaacategoryid()))){
			sb.append("and C_SHA_A_CategoryID = ? ");
			params.add(Utility.getName(po.getCshaacategoryid()));
		}
		
		if(!"".equals(Utility.getName(po.getCshaaindepartmentname()))){
			sb.append("and d.B_DP_DepartmentName like '%'+?+'%' ");
			params.add(Utility.getName(po.getCshaaindepartmentname()));
		}
		
		if(!"".equals(Utility.getName(po.getCshaaprinttype()))){
			if("1".equals(Utility.getName(po.getCshaaprinttype()))){
				sb.append("and C_SHA_A_PrintType=? ");
				params.add(po.getCshaaprinttype());
			}else if("0".equals(Utility.getName(po.getCshaaprinttype()))){
				sb.append("and isnull(C_SHA_A_PrintType,'') = '' ");
			}
		}
		
		sb.append(" )temp1  ) TEMP where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), AllocationPo.class);
	}
	
	/**
	 * 获取调拨单据数量
	 */
	public int getReAllocationCount(AllocationPo po,DepartmentsPo departmentsPo) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(C_SHA_Allocation.C_SHA_A_billID) from C_SHA_Allocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_Allocation.C_SHA_A_outDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_Allocation.C_SHA_A_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_Allocation.C_SHA_A_auditPerson=b.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)c on C_SHA_Allocation.C_SHA_A_consignee=c.ID ");
		sb.append("where C_SHA_A_flag=?  ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaaflag());
		
		if(!"3".equals(departmentsPo.getBdptype())){
			sb.append("and (C_SHA_Allocation.C_SHA_A_outDepartmentId=? or C_SHA_Allocation.C_SHA_A_inDepartmentId=?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
			
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_auditState=? ");
			params.add(po.getCshaaauditstate());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignState=? ");
			params.add(po.getCshaaconsignstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaacreateperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_createPerson like '%'+?+'%' ");
			params.add(po.getCshaacreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignee()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignee like '%'+?+'%' ");
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
		sb.append("from(select ROW_NUMBER() Over(order by C_SHA_Allocation.C_SHA_A_billDate desc,C_SHA_Allocation.C_SHA_A_billID desc) as rowNum,");
		sb.append("C_SHA_Allocation.C_SHA_A_billID as cshaabillid,d.B_DP_DepartmentName as cshaaoutdepartmentname,C_SHA_Allocation.C_SHA_A_outDepartmentId as cshaaoutdepartmentid,");
		sb.append("a.personName as cshaacreatepersonname,C_SHA_Allocation.C_SHA_A_billDate as cshaabilldate,b.personName as cshaaauditpersonname,C_SHA_Allocation.C_SHA_A_auditDate as cshaaauditdate,");
		sb.append("c.personName as cshaaconsigneename,C_SHA_Allocation.C_SHA_A_consignDate as cshaaconsigndate,");
		sb.append("C_SHA_Allocation.C_SHA_A_auditState as cshaaauditstate,C_SHA_Allocation.C_SHA_A_consignState as cshaaconsignstate from C_SHA_Allocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_Allocation.C_SHA_A_outDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_Allocation.C_SHA_A_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_Allocation.C_SHA_A_auditPerson=b.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)c on C_SHA_Allocation.C_SHA_A_consignee=c.ID ");
		sb.append(" where C_SHA_A_flag=? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaaflag());
		if(!"3".equals(departmentsPo.getBdptype())){
			sb.append("and (C_SHA_Allocation.C_SHA_A_outDepartmentId=? or C_SHA_Allocation.C_SHA_A_inDepartmentId=?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
			
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_outDepartmentId=? ");
			params.add(po.getCshaaoutdepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_auditState=? ");
			params.add(po.getCshaaauditstate());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignState=? ");
			params.add(po.getCshaaconsignstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaacreateperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_createPerson like '%'+?+'%' ");
			params.add(po.getCshaacreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignee()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignee like '%'+?+'%' ");
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
		sb1.append("insert into C_SHA_Allocation(C_SHA_A_billID,C_SHA_A_billDate,C_SHA_A_outDepartmentId,C_SHA_A_outStockId,C_SHA_A_inDepartmentId,C_SHA_A_inStockId");
		sb1.append(",C_SHA_A_createPerson,C_SHA_A_auditState,C_SHA_A_consignState,C_SHA_A_remark,C_SHA_A_flag,C_SHA_A_CategoryID ");
		sb2.append("?,getdate(),?,?,?,?,");
		sb2.append("?,?,?,?,?,? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaabillid());
		params.add(po.getCshaaoutdepartmentid());
		params.add(Utility.getName(po.getCshaaoutstockid()));
		params.add(po.getCshaaindepartmentid());
		params.add(Utility.getName(po.getCshaainstockid()));
		params.add(po.getCshaacreateperson());
		params.add(po.getCshaaauditstate());
		params.add("0");
		params.add(po.getCshaaremark());
		params.add(Utility.getName(po.getCshaaflag()));
		params.add(Utility.getName(po.getCshaacategoryid()));
		
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb1.append(",C_SHA_A_supplier ");
			sb2.append(",? ");
			params.add(po.getChaasupplier());
		}
		
		if(!"".equals(Utility.getName(po.getCshaabillassociation()))){
			sb1.append(",C_SHA_A_StatusBillID ");
			sb2.append(",? ");
			params.add(po.getCshaabillassociation());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb1.append(",C_SHA_A_auditPerson,C_SHA_A_auditDate");
			sb2.append(",?,getdate()");
			params.add(po.getCshaaauditperson());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaamounttype()))){
			sb1.append(",C_SHA_A_AmountType ");
			sb2.append(",? ");
			params.add(Utility.getName(po.getCshaaamounttype()));
		}
		
		if(!"".equals(Utility.getName(po.getCshaafinanceauditperson()))){
			sb1.append(",C_SHA_A_FinanceAuditPerson,C_SHA_A_FinanceAuditState,C_SHA_A_FinanceAuditDate ");
			sb2.append(",?,'1',getdate() ");
			params.add(Utility.getName(po.getCshaafinanceauditperson()));
		}else{
			sb1.append(",C_SHA_A_FinanceAuditState ");
			sb2.append(",'0' ");
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
		
		sb.append("insert into C_SHA_AllocationEntry(C_SHA_AE_ID,C_SHA_AE_billId,C_SHA_AE_goodsId,C_SHA_AE_goodsBarCode,C_SHA_A_outStockId,C_SHA_A_inStockId,");
		if (!"".equals(Utility.getName(po.getCshaaerequirementquantity()))){
			sb.append("C_SHA_AE_requirementQuantity,");
		}		
		sb.append(" C_SHA_AE_allocationQuantity,C_SHA_AE_OutStorageFlag,C_SHA_AE_Guaranteeperiod,C_ST_CPRD_Batch,C_SHA_AE_RegistrationNum ");
		
		if (Utility.getName(po.getCshaaeamounttype()).equals("1")){
			sb.append(" ,C_SHA_AE_CostPrice,C_SHA_AE_CostPriceAmount ");
		}else if (Utility.getName(po.getCshaaeamounttype()).equals("2")){
			sb.append(" ,C_SHA_AE_NotTaxRate,C_SHA_AE_NotTaxRateAmount ");
		}else if (Utility.getName(po.getCshaaeamounttype()).equals("3")){
			sb.append(" ,C_SHA_AE_WholesalePrice,C_SHA_AE_WholesalePriceAmount ");
		}
		
		sb.append(" ) values (?,?,?,?,?,?, ");		
		if (!"".equals(Utility.getName(po.getCshaaerequirementquantity()))){
			sb.append("?,");
		}	
		sb.append(" ?,?,?,?,? ");
		
		if (!Utility.getName(po.getCshaaeamounttype()).equals("")){
			sb.append(" ,?,? ");   // 金额
		}
		
		sb.append(" ) ");
		
		params.add(this.uuid.generate());
		params.add(po.getCshaaebillid());
		params.add(po.getCshaaegoodsid());
		params.add(po.getCshaaGoodsBarCode());
		params.add(Utility.getName(po.getCshaaoutstockid()));
		params.add(Utility.getName(po.getCshaainstockid()));
		if (!"".equals(Utility.getName(po.getCshaaerequirementquantity()))){
			params.add(Utility.getName(po.getCshaaerequirementquantity()));
		}		
		params.add(Utility.getName(po.getCshaaeallocationquantity()));
		params.add(Utility.getName(po.getCshaaeoutstorageflag()));		
		params.add(Utility.getName(po.getCshaaeguaranteeperiod()));
		params.add(Utility.getName(po.getCshaaebatch()));
		params.add(Utility.getName(po.getCshaaeregistrationnum()));
				
		if (Utility.getName(po.getCshaaeamounttype()).equals("1")){
			params.add(Utility.getName(po.getCshaaecostprice()));
			params.add(Utility.getName(po.getCshaaecostpriceamount()));				
		}else if (Utility.getName(po.getCshaaeamounttype()).equals("2")){
			params.add(Utility.getName(po.getCshaaenottaxrate()));
			params.add(Utility.getName(po.getCshaaenottaxrateamount()));		
		}else if (Utility.getName(po.getCshaaeamounttype()).equals("3")){
			params.add(Utility.getName(po.getCshaaewholesaleprice()));
			params.add(Utility.getName(po.getCshaaewholesalepriceamount()));	
		}
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 更改调拨单 
	 */
	public void updateAllocation(AllocationPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("update C_SHA_Allocation set C_SHA_A_outStockId=?,C_SHA_A_inDepartmentId=?,C_SHA_A_inStockId=?,");
		sb.append("C_SHA_A_auditState=?,C_SHA_A_remark=? ");
		params.add(po.getCshaaoutstockid());
		params.add(po.getCshaaindepartmentid());
		params.add(po.getCshaainstockid());
		params.add(po.getCshaaauditstate());
		params.add(po.getCshaaremark());
		
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append(",C_SHA_A_supplier=? ");
			params.add(po.getChaasupplier());
		}
		if(!"".equals(Utility.getName(po.getCshaabillassociation()))){
			sb.append(",C_SHA_A_StatusBillID=? ");
			params.add(po.getCshaabillassociation());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append(",C_SHA_A_auditPerson=?,C_SHA_A_auditDate=getdate() ");
			params.add(po.getCshaaauditperson());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaamounttype()))){
			sb.append(",C_SHA_A_AmountType = ? ");
			params.add(po.getCshaaamounttype());
		}
		
		sb.append(" where C_SHA_A_billID=?");
		params.add(po.getCshaabillid());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除调拨单
	 */
	public void deleteAllocation(AllocationPo po) {
		
		String sql="delete from C_SHA_Allocation where C_SHA_A_billID=?";	
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaabillid());
		getJdbcTemplate().update(sql,params.toArray());
	}
	
	/**
	 * 删除调拨明细
	 */
	public void deleteAllocationEntry(AllocationPo po) {
		
		String sql="delete from C_SHA_AllocationEntry where C_SHA_AE_billId=?";	
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaabillid());
		getJdbcTemplate().update(sql,params.toArray());
	}
	
	/**
	 * 获取调拨单
	 */
	public AllocationPo getAllocation(AllocationPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select top 1  C_SHA_Allocation.C_SHA_A_billID as cshaabillid,d.B_DP_DepartmentName as cshaaoutdepartmentname,u.B_DP_DepartmentName as cshaaindepartmentname,");
		sb.append("a.personName as cshaacreatepersonname,C_SHA_Allocation.C_SHA_A_billDate as cshaabilldate,b.personName as cshaaauditpersonname,");
		sb.append("C_SHA_A_CategoryID as cshaacategoryid,B_GC_GoodsCategoryName as goodscategoryname,C_SHA_A_StatusBillID as cshastatusorderid , ");
		sb.append("c.personName as cshaaconsigneename,C_SHA_Allocation.C_SHA_A_consignDate as cshaaconsigndate,");
		sb.append("C_SHA_Allocation.C_SHA_A_createPerson as cshaacreateperson,C_SHA_Allocation.C_SHA_A_auditPerson as cshaaauditperson,C_SHA_Allocation.C_SHA_A_auditDate as cshaaauditdate,");
		sb.append("C_SHA_Allocation.C_SHA_A_auditState as cshaaauditstate,C_SHA_Allocation.C_SHA_A_consignState as cshaaconsignstate,");
		sb.append("C_SHA_Allocation.C_SHA_A_outStockId as cshaaoutstockid,C_SHA_Allocation.C_SHA_A_inStockId as cshaainstockid,C_SHA_Allocation.C_SHA_A_remark as cshaaremark,");
		sb.append("C_SHA_Allocation.C_SHA_A_inDepartmentId as cshaaindepartmentid,C_SHA_Allocation.C_SHA_A_outDepartmentId as cshaaoutdepartmentid,C_SHA_A_StatusBillID as cshaabillassociation, ");
		sb.append("e.B_WH_warehouseName as cshaaoutstockname,f.B_WH_warehouseName as cshaainstockname,C_SHA_Allocation.C_SHA_A_supplier as chaasupplier,x.B_SP_SupplierName as chaasuppliername,isnull(C_SHA_A_AutoAllocationFlag,'') as chaaautoflag,isnull(C_SHA_A_AmountType,'') as cshaaamounttype,isnull(u.B_DP_CompanysID,'') as cshaaindptcompanyid  from C_SHA_Allocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_Allocation.C_SHA_A_outDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_Allocation.C_SHA_A_createPerson=a.ID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)x on C_SHA_Allocation.C_SHA_A_supplier=x.B_SP_ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_Allocation.C_SHA_A_auditPerson=b.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)c on C_SHA_Allocation.C_SHA_A_consignee=c.ID ");
		sb.append("left join (select B_WH_ID,B_WH_warehouseName from B_Warehouse)e on C_SHA_Allocation.C_SHA_A_outStockId=e.B_WH_ID ");
		sb.append("left join (select B_WH_ID,B_WH_warehouseName from B_Warehouse)f on C_SHA_Allocation.C_SHA_A_inStockId=f.B_WH_ID ");
		sb.append("left join B_GoodsCategory on B_GC_ID = C_SHA_A_CategoryID ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)u on C_SHA_Allocation.C_SHA_A_inDepartmentId=u.B_DP_DepartmentID ");
		sb.append("where C_SHA_Allocation.C_SHA_A_billID=? ");
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
		
		sb.append("select C_SHA_AE_ID as cshaaeid,C_SHA_AllocationEntry.C_SHA_AE_billId as cshaaebillid,sum(C_SHA_AllocationEntry.C_SHA_AE_allocationQuantity) as cshaaeallocationquantity,C_SHA_AllocationEntry.C_SHA_AE_goodsId as cshaaegoodsid,C_SHA_AE_goodsbarcode as cshaaegoodsBarCode,");
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cshaaegoodsname,B_GoodsInfo.B_GI_Spec as cshaaespec,C_SHA_AllocationEntry.C_SHA_A_outStockId as cshaaoutstockid,");
		sb.append("C_SHA_AllocationEntry.C_SHA_A_inStockId as cshaainstockid,sum(C_SHA_AllocationEntry.C_SHA_AE_requirementQuantity) as cshaaerequirementquantity,");
		sb.append("B_GoodsInfo.B_GI_NotTaxRate as cshaaenottaxrate,B_GoodsInfo.B_GI_TaxRate as cshaaetaxrate,B_GoodsInfo.B_GI_CostPrice as cshaaecostprice, ");
		sb.append("isnull(C_SHA_AE_OutStorageFlag,'1') as cshaaeoutstorageflag, ");
		sb.append("(select top 1 C_SH_BC_GuaranteePeriod from C_SH_BatchCompare where C_SH_BC_Barcode = C_SHA_AE_goodsbarcode ) as cshaaeguaranteeperiod, ");
		sb.append("(select top 1 C_SH_BC_Batch from C_SH_BatchCompare where C_SH_BC_Barcode = C_SHA_AE_goodsbarcode ) as cshaaebatch, ");
		
		sb.append("       case ");
		sb.append("       	when B_GI_GoodsCategoryID = '8' then B_GI_Sph ");
		sb.append("       	else B_GI_Color                   ");
		sb.append("       end 						  AS cshaaecolor, ");
		
		if("2".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceA as cshaaebgiretailprice, ");
		}else if("3".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceB as cshaaebgiretailprice, ");
		}else if("4".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceC as cshaaebgiretailprice, ");
		}else if("5".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceD as cshaaebgiretailprice, ");
		}else if("6".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceE as cshaaebgiretailprice, ");
		}else if("7".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceF as cshaaebgiretailprice, ");
		}else if("8".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceG as cshaaebgiretailprice, ");
		}else if("9".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceH as cshaaebgiretailprice, ");
		}else if("10".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceI as cshaaebgiretailprice, ");
		}else{
			sb.append("B_GI_RetailPrice as cshaaebgiretailprice, ");
		}
		
		sb.append("B_BD_Place as cshaaesource, ");
		sb.append("B_BD_brandName as cshaaebrandname, ");
		sb.append("sum(isnull(kucun.GoodsQuantity,0)+isnull(zaitu.GoodsNum,0)) as cshaaemaxquantity, ");
		sb.append("C_SHA_AE_RegistrationNum as cshaaeregistrationnum ");
		sb.append("from C_SHA_AllocationEntry ");
		sb.append("inner join B_GoodsInfo on C_SHA_AllocationEntry.C_SHA_AE_goodsId=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("left JOIN B_Brand ON B_GI_SupplierID = B_BD_SupplierID and B_GI_BrandID = B_BD_ID ");
		sb.append("LEFT JOIN (SELECT C_SH_SL_GoodsBarCode  AS GoodsBarCode, ");
		sb.append("        isnull(sum(C_SH_Sl_GoodsQuantity),0) AS GoodsQuantity, ");
		sb.append("        C_SH_Sl_StockId       AS StockId ");
		sb.append(" FROM   C_SH_StorageLog ");
		sb.append(" WHERE  1 = 1 ");
		sb.append(" AND C_SH_SL_StockId = (select C_SHA_A_outStockId from C_SHA_Allocation where C_SHA_A_billID = ?) ");
		params.add(po.getCshaabillid());
		sb.append(" GROUP  BY C_SH_SL_GoodsBarCode, ");
		sb.append("   C_SH_Sl_StockId) kucun ");
		sb.append(" ON C_SHA_AE_goodsbarcode = kucun.GoodsBarCode ");
		sb.append(" LEFT JOIN (SELECT C_SH_TSE_GoodsBarCode  AS GoodsBarCode, ");
		sb.append(" isnull(SUM(C_SH_TSE_GoodsNum),0) AS GoodsNum ");
        sb.append(" FROM   C_SH_InTransitStorageEntry ");
        sb.append(" WHERE  1 = 1 ");
        sb.append("        AND C_SH_TSE_OUTStockID = (select C_SHA_A_outStockId from C_SHA_Allocation where C_SHA_A_billID = ?) ");
        params.add(po.getCshaabillid());
        if (!"".equals(Utility.getName(po.getCshaabillid()))) {
			sb.append(" and C_SH_TSE_BillID <> ? ");
			params.add(po.getCshaabillid());
		}
        sb.append(" GROUP  BY C_SH_TSE_GoodsBarCode)zaitu ");
        sb.append("ON C_SHA_AE_goodsbarcode = zaitu.GoodsBarCode ");
		
		sb.append("where C_SHA_AE_billId=? ");	
		sb.append("group by C_SHA_AE_ID,");
		sb.append("C_SHA_AllocationEntry.C_SHA_AE_goodsId,C_SHA_AllocationEntry.C_SHA_AE_billId,C_SHA_AE_goodsbarcode,");
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName,B_GoodsInfo.B_GI_Spec,C_SHA_AllocationEntry.C_SHA_A_outStockId,");
		sb.append("C_SHA_AllocationEntry.C_SHA_A_inStockId,");
		sb.append("B_GoodsInfo.B_GI_NotTaxRate,B_GoodsInfo.B_GI_TaxRate,B_GoodsInfo.B_GI_CostPrice,B_GI_GoodsCategoryID,B_GI_Sph, ");
		
		if("2".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceA, ");
		}else if("3".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceB, ");
		}else if("4".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceC, ");
		}else if("5".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceD, ");
		}else if("6".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceE, ");
		}else if("7".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceF, ");
		}else if("8".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceG, ");
		}else if("9".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceH, ");
		}else if("10".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceI, ");
		}else{
			sb.append("B_GI_RetailPrice, ");
		}
		
		sb.append("isnull(C_SHA_AE_OutStorageFlag,'1'), ");
		sb.append("B_GI_Color, ");
		sb.append("B_BD_Place, ");
		sb.append("B_BD_brandName, ");
		sb.append("C_SHA_AE_RegistrationNum ");
		
		params.add(po.getCshaabillid());
		
		return queryForObjectList(sb.toString(), params.toArray(), AllocationEntryPo.class);
	}
	
	/**
	 * 获取调拨明细
	 */
	public List<AllocationEntryPo> getNotInTransitStorageGoods(AllocationPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("select C_SHA_AE_ID as cshaaeid,C_SHA_AllocationEntry.C_SHA_AE_billId as cshaaebillid,sum(C_SHA_AllocationEntry.C_SHA_AE_allocationQuantity) as cshaaeallocationquantity,C_SHA_AllocationEntry.C_SHA_AE_goodsId as cshaaegoodsid,B_GoodsInfo.B_GI_GoodsBarCode as cshaaegoodsBarCode,");
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cshaaegoodsname,B_GoodsInfo.B_GI_Spec as cshaaespec,C_SHA_AllocationEntry.C_SHA_A_outStockId as cshaaoutstockid,");
		sb.append("C_SHA_AllocationEntry.C_SHA_A_inStockId as cshaainstockid,sum(C_SHA_AllocationEntry.C_SHA_AE_requirementQuantity) as cshaaerequirementquantity,");
		sb.append("B_GoodsInfo.B_GI_NotTaxRate as cshaaenottaxrate,B_GoodsInfo.B_GI_TaxRate as cshaaetaxrate,B_GoodsInfo.B_GI_CostPrice as cshaaecostprice, ");
		sb.append("B_GoodsInfo.B_GI_RetailPrice as cshaaebgiretailprice,isnull(C_SHA_AE_OutStorageFlag,'1') as cshaaeoutstorageflag ");
		sb.append("from C_SHA_AllocationEntry ");
		sb.append("inner join B_GoodsInfo on C_SHA_AllocationEntry.C_SHA_AE_goodsId=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("where C_SHA_AE_billId=? ");
		sb.append("group by C_SHA_AE_ID,");
		sb.append("C_SHA_AllocationEntry.C_SHA_AE_goodsId,C_SHA_AllocationEntry.C_SHA_AE_billId,B_GoodsInfo.B_GI_GoodsBarCode,");
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName,B_GoodsInfo.B_GI_Spec,C_SHA_AllocationEntry.C_SHA_A_outStockId,");
		sb.append("C_SHA_AllocationEntry.C_SHA_A_inStockId,");
		sb.append("B_GoodsInfo.B_GI_NotTaxRate,B_GoodsInfo.B_GI_TaxRate,B_GoodsInfo.B_GI_CostPrice, ");
		sb.append("B_GoodsInfo.B_GI_RetailPrice,isnull(C_SHA_AE_OutStorageFlag,'1') ");
		params.add(po.getCshaabillid());
		
		return queryForObjectList(sb.toString(), params.toArray(), AllocationEntryPo.class);
	}
	
	/**
	 * 调拨收货
	 */
	public void updateAllocationReceive(AllocationPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("update C_SHA_Allocation set C_SHA_A_consignee=?,C_SHA_A_consignState=?,C_SHA_A_consignDate=getdate() where C_SHA_A_billID=?");
		params.add(po.getCshaaconsignee());
		params.add(po.getCshaaconsignstate());
		params.add(po.getCshaabillid());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	/**
	 * 调拨申请使用状态
	 */
	public void updateAllocationReceive1(AllocationPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("update C_SHA_ApplyAllocation set C_SHA_AA_AllocationStatus=0 where C_SHA_AA_billID=?");
		params.add(Utility.getName(po.getCshastatusorderid()));
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	/**
	 * 调拨申请使用状态
	 */
	public void updateAllocationReceive2(AllocationPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("update C_ST_Inventory set C_ST_I_AllocationStatus=1 where C_ST_I_BillID=?");
		params.add(Utility.getName(po.getCshastatusorderid()));
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	/**
	 * 调拨后业务单据新增
	 */
	public void insertAllocationForInventory(InventoryPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("insert into C_ST_Inventory(C_ST_I_BillID,C_ST_I_BillTypeId,C_ST_I_billDate,C_ST_I_InStockId,C_ST_I_OutStockId,");
		sb.append("C_ST_I_DepartmentId,C_ST_I_createPerson,C_ST_I_AuditPerson,C_ST_I_AuditDate,C_ST_I_AuditState,C_ST_I_Remark,C_ST_I_AmountType,C_ST_I_FinanceAuditPerson,C_ST_I_FinanceAuditDate,C_ST_I_FinanceAuditState)");
		sb.append("values(?,?,?,?,?,");
		sb.append("?,?,?,?,?,?,?,?,?,?)");
		
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
		params.add(Utility.getName(po.getCstiamounttype()));
		params.add(po.getCstiauditperson());
		params.add(po.getCstiauditdate());
		params.add(po.getCstiauditstate());
		
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
		sb.append("C_ST_IE_NotTaxRateAmount,C_ST_IE_TaxAmount,C_ST_IE_CostPriceAmount,C_ST_IE_WarehousingDate,C_ST_IE_OutStorageFlag,C_ST_IE_GuaranteePeriod,C_ST_IE_Batch,C_ST_IE_RegistrationNum,C_ST_IE_WholesalePrice,C_ST_IE_WholesalePriceAmount)");
		sb.append("values(?,?,?,?,?,");
		sb.append("?,?,?,?,?,");
		sb.append("?,?,?,getdate(),?,?,?,?,?,? )");
		
		params.add(this.uuid.generate());
		params.add(po.getCstiebillid());
		params.add(po.getCstiegoodsid());
		params.add(po.getCstiebarcode());
		params.add(po.getCstiegoodsquantity());
		params.add(po.getCstieoutstockid());
		params.add(po.getCstieinstockid());
		if (!"".equals(Utility.getName(po.getCstienottaxrate()))){
			params.add(po.getCstienottaxrate());
		}else{
			params.add("0");
		}
		
		params.add(po.getCstietaxrate());
		
		if (!"".equals(Utility.getName(po.getCstiecostprice()))){
			params.add(po.getCstiecostprice());
		}else{
			params.add("0");
		}
		
		if (!"".equals(Utility.getName(po.getCstienottaxrateamount()))){
			params.add(po.getCstienottaxrateamount());
		}else{
			params.add("0");
		}
		
		if (!"".equals(Utility.getName(po.getCstietaxamount()))){
			params.add(po.getCstietaxamount());
		}else{
			params.add("0");
		}
		
		if (!"".equals(Utility.getName(po.getCstiecostpriceamount()))){
			params.add(po.getCstiecostpriceamount());
		}else{
			params.add("0");
		}

		params.add(Utility.getName(po.getCstieoutstorageflag()));		
		params.add(Utility.getName(po.getCstieguaranteeperiod()));
		params.add(Utility.getName(po.getCstiebatch()));
		params.add(Utility.getName(po.getCstieregistrationnum()));
		
		if (!"".equals(Utility.getName(po.getCstiewholesaleprice()))){
			params.add(Utility.getName(po.getCstiewholesaleprice()));
		}else{
			params.add("0");
		}
		
		if (!"".equals(Utility.getName(po.getCstiewholesalepriceamount()))){
			params.add(Utility.getName(po.getCstiewholesalepriceamount()));
		}else{
			params.add("0");
		}	
		
		getJdbcTemplate().update(sb.toString(),params.toArray());		
	}
	
	/*
	 * 反审核
	 */
	public void returnAudit(String billID){
		StringBuffer sb = new StringBuffer();
		sb.append("update C_SHA_Allocation set C_SHA_A_auditState='0',C_SHA_A_auditPerson='',C_SHA_A_auditDate=null where C_SHA_A_billID=?");
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
		params.add("");
		params.add(smsLertsPo.getCstslsendperson());
		params.add(smsLertsPo.getCstslreceiveperson());
		params.add(smsLertsPo.getCstslflag());
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void insertAllocationBarcode(AllocationBarcodePo allocationBarcodePo) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into C_SHA_AllocationBarcode(C_SHA_B_UUID,C_SHA_B_billID,C_SHA_B_GoodsID,C_SHA_B_GoodsBarcode) ");
		sb.append("values(?,?,?,?)");
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(allocationBarcodePo.getCshabbillid());
		params.add(allocationBarcodePo.getCshabgoodsid());
		params.add(allocationBarcodePo.getCshabgoodsbarcode());
		
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void deleteAllocationBarcode(AllocationPo allocationPo) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from  C_SHA_AllocationBarcode ");
		sb.append("where C_SHA_B_billID=?");
		List<String> params = new ArrayList<String>();
		params.add(allocationPo.getCshaabillid());
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public List<AllocationBarcodePo> getAllocationBarcode(AllocationPo allocationPo){
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("select C_SHA_B_GoodsID as cshabgoodsid,C_SHA_B_GoodsBarcode as cshabgoodsbarcode from C_SHA_AllocationBarcode where C_SHA_B_billID=? and 1=1 ");
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
		List<String> params = new ArrayList<String>();
		
		sb.append(" select C_SHA_A_consignState from C_SHA_Allocation ");
		sb.append(" where C_SHA_A_billID=? ");		
		
		params.add(allocationPo.getCshaabillid());
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	//查询调拨申请商品信息
	public List<AllocationEntryPo> getApplyList(AllocationPo allocationPo) {
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT  ");
		sb.append("C_SHA_AAE_goodsId as cshaaegoodsid, ");
		
		sb.append("isnull(B_GI_TaxRate,0) as bgitaxrate, ");
		sb.append("isnull(B_GI_NotTaxRate,0) as bginottaxrate, ");
		sb.append("isnull(B_GI_CostPrice,0) as bgicostprice, ");
		sb.append("cast((dbo.ufn_getWholeSalePriceByDpt(C_SHA_AA_inDepartmentId) * isnull(B_GI_WholesalePrice,0)) as numeric(18,2)) as bgiwholesaleprice, ");	
		
		sb.append("B_GI_Spec as cshaaespec, ");
		sb.append("B_GI_Color as cshaaecolor, ");
		sb.append("B_GI_RetailPrice as cshaaebgiretailprice, ");
		sb.append("B_BD_Place as cshaaesource, ");
		sb.append("B_BD_brandName as cshaaebrandname, ");
		sb.append("B_GI_GoodsBarCode+'00000000' as cshaaegoodsBarCode, ");
		sb.append("B_GI_ViewGoodsName as cshaaegoodsname, ");
		sb.append("C_SHA_AA_inDepartmentId as cshaaeindepartmentid, ");
		sb.append("C_SHA_AAE_requirementQuantity as cshaaerequirementquantity, ");
		sb.append("C_SHA_AAE_requirementQuantity as cshaaeallocationquantity, ");
		sb.append("'' as cshaaeguaranteeperiod, ");
		sb.append("'' as cshaaebatch, ");
		sb.append("isnull(kucun.GoodsQuantity,0) + Isnull(zaitu.GoodsNum, 0) as cshaaemaxquantity, ");
		sb.append("C_SHA_AA_goodscategory as cshaaebgiretailprice ");
		sb.append("FROM C_SHA_ApplyAllocation ");
		sb.append("INNER JOIN C_SHA_ApplyAllocationEntry ON C_SHA_AA_billID = C_SHA_AAE_billId ");
		sb.append("INNER JOIN B_GoodsInfo ON C_SHA_AAE_goodsId = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("left JOIN B_Brand ON B_GI_SupplierID = B_BD_SupplierID and B_GI_BrandID = B_BD_ID ");
		sb.append(" left join ( ");
		sb.append("		SELECT GoodsId AS GoodsId, ");
		sb.append("		       SUM(GoodsQuantity) AS GoodsQuantity, ");
		sb.append("		       StockId 			  AS StockId, ");
		sb.append("		       B_WH_warehouseName AS StockName ");
		sb.append("		FROM  (SELECT C_SH_SB_GoodsId       AS GoodsId, ");
		sb.append("		              C_SH_SB_GoodsQuantity AS GoodsQuantity, ");
		sb.append("		              C_SH_SB_StockId       AS StockId ");
		sb.append("		       FROM   C_SH_StorageBeginning ");
		sb.append("		       UNION ALL ");
		sb.append("	 	       SELECT C_SH_SC_GoodsId        AS GoodsId, ");
		sb.append("		              C_SH_SC_GoodsQuantity AS GoodsQuantity, ");
		sb.append("		              C_SH_SC_StockId       AS StockId ");
		sb.append("		       FROM   C_SH_StorageChange)ktemp ");
		sb.append("		       inner join B_Warehouse on ktemp.StockId = B_WH_ID ");
		if (!"".equals(Utility.getName(allocationPo.getCshaaoutstockid()))) {
			sb.append(" and StockId = ? ");
			params.add(allocationPo.getCshaaoutstockid());
		}
		sb.append("		GROUP  BY GoodsId,StockId,B_WH_warehouseName ");
		sb.append(" ) kucun ");
		sb.append(" on C_SHA_AAE_goodsId = kucun.GoodsId ");
		sb.append(" left join ( ");
		sb.append(" select C_SH_TSE_GoodsID as GoodsId,sum(C_SH_TSE_GoodsNum) as GoodsNum from C_SH_InTransitStorageEntry ");
		sb.append(" where 1=1 ");
		
		if (!"".equals(Utility.getName(allocationPo.getCshaaoutstockid()))) {
			sb.append(" and C_SH_TSE_OUTStockID = ? ");
			params.add(allocationPo.getCshaaoutstockid());
		}
		sb.append(" group by C_SH_TSE_GoodsID)zaitu ");
		sb.append(" on C_SHA_AAE_goodsId = zaitu.GoodsId ");
		sb.append(" where C_SHA_AAE_billId = ? ");
		params.add(allocationPo.getCshaabillassociation());
		
		sb.append(" order by C_SHA_AAE_goodsId ");
		
		return queryForObjectList(sb.toString(), params.toArray(),AllocationEntryPo.class);
	}
	//查询调拨申请商品信息
	public List<AllocationEntryPo> getAlllyList(AllocationPo allocationPo) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT C_SHA_AE_goodsId                                           AS cshaaegoodsid, ");
		sb.append("       B_GI_Spec                                                  AS cshaaespec, ");
		sb.append("		  B_GI_Color 												 AS cshaaecolor, ");
		sb.append("		  B_GI_RetailPrice 										     AS cshaaebgiretailprice, ");		
		sb.append("       isnull(B_GI_TaxRate,0) as bgitaxrate, ");
		sb.append("       isnull(B_GI_NotTaxRate,0) as bginottaxrate, ");
		sb.append("       isnull(B_GI_CostPrice,0) as bgicostprice, ");
		sb.append("       cast((dbo.ufn_getWholeSalePriceByDpt(C_SHA_A_inDepartmentId) * isnull(B_GI_WholesalePrice,0)) as numeric(18,2)) as bgiwholesaleprice, ");
		
		sb.append("		  B_BD_Place 										 		 AS cshaaesource, ");
		sb.append("       C_SHA_AE_goodsbarcode                                      AS cshaaegoodsBarCode, ");
		sb.append("		  B_BD_brandName 											 AS cshaaebrandname, ");
		sb.append("       B_GI_ViewGoodsName                                         AS cshaaegoodsname, ");
		sb.append("       C_SHA_A_inDepartmentId                                     AS cshaaeindepartmentid, ");
		sb.append("       C_SHA_AE_requirementQuantity                               AS cshaaerequirementquantity, ");
		sb.append("       C_SHA_AE_allocationQuantity                                AS cshaaeallocationquantity, ");
		sb.append("       Isnull(kucun.GoodsQuantity, 0) + Isnull(zaitu.GoodsNum, 0) AS cshaaemaxquantity, ");
		sb.append("       C_SHA_A_CategoryID                                         AS cshaaebgiretailprice ");
		sb.append("FROM   C_SHA_Allocation ");
		sb.append("       INNER JOIN C_SHA_AllocationEntry ");
		sb.append("         ON C_SHA_A_billID = C_SHA_AE_billId ");
		sb.append("       INNER JOIN B_GoodsInfo ");
		sb.append("         ON C_SHA_AE_goodsId = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("left JOIN B_Brand ON B_GI_SupplierID = B_BD_SupplierID and B_GI_BrandID = B_BD_ID ");
		sb.append("       LEFT JOIN (SELECT GoodsId            AS GoodsId, ");
		sb.append("                         SUM(GoodsQuantity) AS GoodsQuantity, ");
		sb.append("                         StockId            AS StockId, ");
		sb.append("                         B_WH_warehouseName AS StockName ");
		sb.append("                  FROM   (SELECT C_SH_SB_GoodsId       AS GoodsId, ");
		sb.append("                                 C_SH_SB_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                                 C_SH_SB_StockId       AS StockId ");
		sb.append("                          FROM   C_SH_StorageBeginning ");
		sb.append("                          UNION ALL ");
		sb.append("                          SELECT C_SH_SC_GoodsId       AS GoodsId, ");
		sb.append("                                 C_SH_SC_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                                 C_SH_SC_StockId       AS StockId ");
		sb.append("                          FROM   C_SH_StorageChange)ktemp ");
		sb.append("                         INNER JOIN B_Warehouse ");
		sb.append("                           ON ktemp.StockId = B_WH_ID ");
		if (!"".equals(Utility.getName(allocationPo.getCshaaoutstockid()))) {
			sb.append(" and StockId = ? ");
			params.add(allocationPo.getCshaaoutstockid());
		}
		sb.append("                  GROUP  BY GoodsId, ");
		sb.append("                            StockId, ");
		sb.append("                            B_WH_warehouseName) kucun ");
		sb.append("         ON C_SHA_AE_goodsId = kucun.GoodsId ");
		sb.append("       LEFT JOIN (SELECT C_SH_TSE_GoodsID       AS GoodsId, ");
		sb.append("                         SUM(C_SH_TSE_GoodsNum) AS GoodsNum ");
		sb.append("                  FROM   C_SH_InTransitStorageEntry ");
		sb.append("                  WHERE  1 = 1 ");
		
		if (!"".equals(Utility.getName(allocationPo.getCshaaoutstockid()))) {
			sb.append(" and C_SH_TSE_OUTStockID = ? ");
			params.add(allocationPo.getCshaaoutstockid());
		}
		sb.append("                  GROUP  BY C_SH_TSE_GoodsID)zaitu ");
		sb.append("         ON C_SHA_AE_goodsId = zaitu.GoodsId ");
		sb.append("WHERE  C_SHA_A_billID = ? ");
		params.add(allocationPo.getCshaabillassociation());
		sb.append("ORDER  BY C_SHA_AE_goodsId ");
		
		
		return queryForObjectList(sb.toString(), params.toArray(),AllocationEntryPo.class);
	}
	
	//查询负调拨商品信息
	public List<AllocationEntryPo> getReallocationList(AllocationPo allocationPo) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT  ");
		sb.append("C_SHA_AE_goodsId as cshaaegoodsid, ");
		sb.append("B_GI_Spec as cshaaespec, ");
		sb.append("B_GI_GoodsBarCode as cshaaegoodsBarCode, ");
		sb.append("B_GI_ViewGoodsName as cshaaegoodsname, ");
//		sb.append("B_GI_GoodsBarCode as cshaaegoodsBarCode, ");
		sb.append("C_SHA_AE_requirementQuantity as cshaaerequirementquantity ");
		sb.append("FROM C_SHA_AllocationEntry INNER JOIN ");
		sb.append("B_GoodsInfo ON C_SHA_AE_goodsId = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("where C_SHA_AE_billId = ? order by C_SHA_AE_goodsId ");
		List<String> params = new ArrayList<String>();
		params.add(allocationPo.getCshaabillassociation());

		return queryForObjectList(sb.toString(), params.toArray(),AllocationEntryPo.class);
	}
	
	
	
	//查询采购收货商品信息
	public List<AllocationEntryPo> getReceiptList(AllocationPo allocationPo) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT  ");
		sb.append("C_ST_I_InStockId as cshaaoutstockid, ");
		sb.append("C_ST_IE_GoodsId as cshaaegoodsid, ");		
		sb.append("isnull(B_GI_TaxRate,0) as bgitaxrate, ");
		sb.append("isnull(B_GI_NotTaxRate,0) as bginottaxrate, ");
		sb.append("isnull(B_GI_CostPrice,0) as bgicostprice, ");
		sb.append("cast((dbo.ufn_getWholeSalePriceByDpt(?) * isnull(B_GI_WholesalePrice,0)) as numeric(18,2)) as bgiwholesaleprice, ");
		params.add(Utility.getName(allocationPo.getCshaaindepartmentid()));
		sb.append("B_GI_Spec as cshaaespec, ");
		sb.append("B_GI_Color as cshaaecolor, ");
		sb.append("B_GI_RetailPrice as cshaaebgiretailprice, ");
		sb.append("B_BD_Place as cshaaesource, ");
		sb.append("B_GI_ViewGoodsName as cshaaegoodsname, ");
		sb.append("C_ST_IE_BarCode as cshaaegoodsBarCode, ");
		sb.append("C_ST_IE_BarCode as cshabgoodsbarcode, ");
		sb.append("C_ST_IE_GoodsQuantity as cshaaeallocationquantity, ");
		sb.append("B_BD_brandName as cshaaebrandname, ");
		sb.append("kucun.cshaaeguaranteeperiod as cshaaeguaranteeperiod, ");
		sb.append("kucun.cshaaebatch as cshaaebatch, ");
		sb.append("isnull((kucun.GoodsQuantity+isnull(zaitu.GoodsNum,0)),0) as cshaaemaxquantity ");
		sb.append("FROM C_ST_InventoryEntry ");
		sb.append("INNER JOIN B_GoodsInfo ON C_ST_IE_GoodsId = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("inner join C_ST_Inventory ON C_ST_I_BillID = C_ST_IE_BillID ");
		sb.append("left JOIN B_Brand ON B_GI_SupplierID = B_BD_SupplierID and B_GI_BrandID = B_BD_ID ");
		sb.append("LEFT JOIN (SELECT		 C_SH_SL_GoodsBarCode  AS GoodsBarCode, ");
		sb.append("        isnull(sum(C_SH_Sl_GoodsQuantity),0) AS GoodsQuantity, ");
		sb.append("        isnull(C_SH_SL_GuaranteePeriod,'') AS cshaaeguaranteeperiod, ");
		sb.append("        isnull(C_SH_SL_Batch,'')		 AS cshaaebatch, ");
		sb.append("        C_SH_Sl_StockId       AS StockId ");
		sb.append(" FROM   C_SH_StorageLog ");
		sb.append(" WHERE  1 = 1 ");
		sb.append(" AND C_SH_SL_StockId = ? ");
		params.add(allocationPo.getCshaaoutstockid());
		sb.append(" GROUP  BY C_SH_SL_GoodsBarCode,isnull(C_SH_SL_GuaranteePeriod,''),isnull(C_SH_SL_Batch,''), ");
		sb.append("   C_SH_Sl_StockId) kucun ");
		sb.append(" ON C_ST_IE_BarCode = kucun.GoodsBarCode ");
		sb.append(" LEFT JOIN (SELECT C_SH_TSE_GoodsBarCode  AS GoodsBarCode, ");
		sb.append(" isnull(SUM(C_SH_TSE_GoodsNum),0) AS GoodsNum ");
        sb.append(" FROM   C_SH_InTransitStorageEntry ");
        sb.append(" WHERE  1 = 1 ");
        sb.append("        AND C_SH_TSE_OUTStockID = ? ");
        params.add(allocationPo.getCshaaoutstockid());
        sb.append(" GROUP  BY C_SH_TSE_GoodsBarCode)zaitu ");
        sb.append("ON C_ST_IE_BarCode = zaitu.GoodsBarCode ");
		
		sb.append("where C_ST_IE_BillID = ? ");
		params.add(allocationPo.getCshaabillassociation());
		sb.append(" order by C_ST_IE_GoodsId ");
		

		return queryForObjectList(sb.toString(), params.toArray(),AllocationEntryPo.class);
	}
	
	//插入状态表（调拨申请）
	public void insertAllocationStatus(AllocationPo allocationPo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE C_SHA_Status ");
		sb.append("SET ");
		
		sb.append(" C_SHA_StatusBillID = ? ");
		sb.append("WHERE C_SHA_StatusApplyBillID = ?");
		params.add(allocationPo.getCshaabillid());
		params.add(allocationPo.getCshaabillassociation());

		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	//反添加调拨申请的状态（对于调拨新增）
	public void insertAllocationApplyStatus(AllocationPo allocationPo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE C_SHA_ApplyAllocation ");
		sb.append("SET ");
		sb.append("C_SHA_AA_AllocationStatus = '1' ");
		sb.append("WHERE C_SHA_AA_billID = ? ");
		params.add(allocationPo.getCshaabillassociation());

		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	//插入状态表（收货单）
	public void insertAllocationReceiptStatus(AllocationPo allocationPo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE C_SHA_Status ");
		sb.append("SET ");
		sb.append(" C_SHA_StatusBillID = ? ");
		sb.append("WHERE C_SHA_StatusReceiptID = ?");
		params.add(allocationPo.getCshaabillid());
		params.add(allocationPo.getCshaabillassociation());

		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	//反添加采购收货的状态（对于调拨新增）
	public void insertAllocationApplyReceiptStatus(AllocationPo allocationPo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE C_ST_Inventory ");
		sb.append("SET ");
		sb.append("C_ST_I_AllocationStatus = '2' ");
		sb.append("WHERE C_ST_I_BillID = ? ");
		params.add(allocationPo.getCshaabillassociation());

		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 获取调拨单
	 */
	public StatusPo getStatusPo(StatusPo statusPo) {
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT C_SHA_StatusUUID        AS cshastatusuuid, ");
		sb.append("       C_SHA_StatusApplyBillID AS cshastatusapplybillid, ");
		sb.append("       C_SHA_StatusBillID      AS cshastatusbillid, ");
		sb.append("       C_SHA_StatusOrderID     AS cshastatusorderid, ");
		sb.append("       C_SHA_StatusReceiptID   AS cshastatusreceiptid ");
		sb.append("FROM   C_SHA_Status ");
		sb.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(statusPo.getCshastatusapplybillid()))){
			sb.append("       AND C_SHA_StatusApplyBillID = ? ");
			params.add(statusPo.getCshastatusapplybillid());
		}
		
		if(!"".equals(Utility.getName(statusPo.getCshastatusbillid()))){
			sb.append("       AND C_SHA_StatusBillID = ? ");
			params.add(statusPo.getCshastatusbillid());
		}
		
		if(!"".equals(Utility.getName(statusPo.getCshastatusorderid()))){
			sb.append("       AND C_SHA_StatusOrderID = ? ");
			params.add(statusPo.getCshastatusorderid());
		}
		
		if(!"".equals(Utility.getName(statusPo.getCshastatusreceiptid()))){
			sb.append("       AND C_SHA_StatusReceiptID = ? ");
			params.add(statusPo.getCshastatusreceiptid());
		}
		
		return (StatusPo)queryForObject(sb.toString(), params.toArray(), StatusPo.class);
	}
	
	/**
	 * 获取调拨单条码
	 */
	public List<AllocationEntryPo> getAllocationBarcode(String billid) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select C_SHA_B_GoodsBarcode as cshaaegoodsBarCode ");
		buffer.append("from dbo.C_SHA_AllocationBarcode ");
		buffer.append("where C_SHA_B_billID = ? ");
		
		params.add(billid);
		
		return queryForObjectList(buffer.toString(), params.toArray(), AllocationEntryPo.class);
	}
	
	
	/**
	 * 获取商品信息
	 */
	public GoodsInfoPo getGoodsInfoPo(GoodsInfoPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("SELECT top 1 B_GI_GoodsID                AS bgigoodsid, ");
		sb.append("       B_GI_GoodsBarCode           AS bgigoodsbarcode, ");
		sb.append("       B_GI_ViewGoodsName              AS bgigoodsname, ");
		sb.append("       B_GI_GoodsCategoryID        AS bgigoodscategoryid, ");
		sb.append("       B_GI_SupplierID             AS bgisupplierid, ");
		sb.append("       B_GI_BrandID                AS bgibrandid, ");
		sb.append("       B_GI_UnitId                 AS bgiunitid, ");
		sb.append("       B_GI_RetailPrice            AS bgiretailprice, ");
		sb.append("       B_GI_CostPrice              AS bgicostprice, ");
		sb.append("       B_GI_NotTaxRate             AS bginottaxrate, ");
		sb.append("       B_GI_TaxRate                AS bgitaxrate, ");
		sb.append("       B_GI_Spec                   AS bgispec, ");
		sb.append("       B_GI_Color                  AS bgicolor, ");
		sb.append("       B_GI_isCustomize            AS bgiiscustomize, ");
		sb.append("       B_GI_Sph                    AS bgisph, ");
		sb.append("       B_GI_SphUL                  AS bgisphul, ");
		sb.append("       B_GI_SphUP                  AS bgisphup, ");
		sb.append("       B_GI_Cyl                    AS bgicyl, ");
		sb.append("       B_GI_CylUL                  AS bgicylul, ");
		sb.append("       B_GI_CylUP                  AS bgicylup, ");
		sb.append("       B_GI_BelowPlusLuminosity    AS bgibelowplusluminosity, ");
		sb.append("       B_GI_BelowPlusLuminosityUL  AS bgibelowplusluminosityul, ");
		sb.append("       B_GI_BelowPlusLuminosityUP  AS bgibelowplusluminosityup, ");
		sb.append("       B_GI_Axis                   AS bgiaxis, ");
		sb.append("       B_GI_AxisUL                 AS bgiaxisul, ");
		sb.append("       B_GI_AxisUP                 AS bgiaxisup, ");
		sb.append("       B_GI_Curvature1             AS bgicurvature1, ");
		sb.append("       B_GI_Curvature1UL           AS bgicurvature1ul, ");
		sb.append("       B_GI_Curvature1UP           AS bgicurvature1up, ");
		sb.append("       B_GI_Curvature2             AS bgicurvature2, ");
		sb.append("       B_GI_Curvature2UL           AS bgicurvature2ul, ");
		sb.append("       B_GI_Curvature2UP           AS bgicurvature2up, ");
		sb.append("       B_GI_Dia                    AS bgidia, ");
		sb.append("       B_GI_DiaUL                  AS bgidiaul, ");
		sb.append("       B_GI_DiaUP                  AS bgidiaup, ");
		sb.append("       B_GI_isMutiLuminosity       AS bgiismutiluminosity, ");
		sb.append("       B_GI_MutiLuminosityNum      AS bgimutiluminositynum, ");
		sb.append("       B_GI_MutiLuminosityAddPrice AS bgimutiluminosityaddprice, ");
		sb.append("       B_GI_EyeGlassMaterialType   AS bgieyeglassmaterialtype, ");
		sb.append("       B_GI_isPlating              AS bgiisplating, ");
		sb.append("       B_GI_orderCycle             AS bgiordercycle, ");
		sb.append("       B_GI_FinishedGlassesType    AS bgifinishedglassestype, ");
		sb.append("       B_GI_frameProcessCraftType  AS bgiframeprocesscrafttype, ");
		sb.append("       B_GI_CylMin                 AS bgicylmin, ");
		sb.append("       B_GI_CylDegreeIncrease      AS bgicyldegreeincrease, ");
		sb.append("       B_GI_CylMinAddPrice         AS bgicylminaddprice, ");
		sb.append("       B_GI_CylAddPrice            AS bgicyladdprice, ");
		sb.append("       B_GI_PrismAddPrice          AS bgiprismaddprice, ");
		sb.append("       B_GI_cyl25CanNotDo          AS bgicyl25cannotdo, ");
		sb.append("       B_GI_ThrowingCycle          AS bgithrowingcycle, ");
		sb.append("       B_GI_StealthType            AS bgistealthtype, ");
		sb.append("       B_GI_OtherGoodsBigClass     AS bgiothergoodsbigclass, ");
		sb.append("       B_GI_OtherGoodsSmallClass   AS bgiothergoodssmallclass, ");
		sb.append("       B_GI_Flag                   AS bgiflag, ");
		sb.append("       B_GI_Refractive             AS bgirefractive, ");
		sb.append("       B_GI_FrameMaterialType      AS bgiframematerialtype ");
		sb.append("FROM   B_GoodsInfo ");
		sb.append("WHERE  B_GI_GoodsBarCode = ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getBgigoodsbarcode());
		
		return (GoodsInfoPo)queryForObject(sb.toString(), params.toArray(), GoodsInfoPo.class);
	}

	public void updateAllocationEntryOutStorageFlag(InventoryEntryPo entryPo){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("UPDATE C_SHA_AllocationEntry set C_SHA_AE_OutStorageFlag = ? WHERE C_SHA_AE_ID = ? ");
		
		params.add(Utility.getName(entryPo.getCstieoutstorageflag()));
		params.add(Utility.getName(entryPo.getCstieid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 收货时判断当前调拨单是否存在
	 */
	public int isExistAllocationBillByID(String billID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(C_SHA_A_billID) from C_SHA_Allocation where C_SHA_A_billID = ? ");
		
		params.add(Utility.getName(billID));
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	//判断当前库存是否满足调拨条件
	public List<GoodsInfoPo> checkNumber(GoodsInfoPo po) {
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT Isnull(SUM(C_SH_SL_GoodsQuantity), 0) AS bgigoodsquantity ");
		sb.append("FROM   dbo.C_SH_StorageLog ");
		sb.append("WHERE  C_SH_SL_StockId = ? ");
		sb.append("       AND C_SH_SL_GoodsBarCode = ? ");
		sb.append("UNION ALL ");
		sb.append("SELECT Isnull(SUM(C_SH_TSE_GoodsNum), 0) AS bgigoodsquantity ");
		sb.append("FROM   dbo.C_SH_InTransitStorageEntry ");
		sb.append("WHERE  C_SH_TSE_OutStockID = ? ");
		sb.append("       AND C_SH_TSE_GoodsBarCode = ? ");
		
		params.add(po.getBgiwarehouseid());
		params.add(po.getBgigoodsbarcode());
		params.add(po.getBgiwarehouseid());
		params.add(po.getBgigoodsbarcode());
		
		if(!Utility.getName(po.getBgiallBillid()).equals("")){
			sb.append("       AND C_SH_TSE_BillID <> ? ");
			params.add(po.getBgiallBillid());
		}
		
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	/**
	 * 更新调拨申请单的核销状态
	 */
	public void updateAllocationAppStatus(AllocationPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update C_SHA_ApplyAllocation set C_SHA_AA_AllocationStatus='0' where C_SHA_AA_billID in (select distinct C_SHA_StatusApplyBillID from C_SHA_Status where C_SHA_StatusBillID=?) ");
		
		params.add(po.getCshaabillid());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 删除调拨申请单的核销状态
	 */
	public void deleteAllocationAppStatus(AllocationPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from C_SHA_Status where C_SHA_StatusBillID=? ");
		
		params.add(po.getCshaabillid());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void updateAllocationPrintType(AllocationPo po){
		
		String sql="update C_SHA_Allocation set C_SHA_A_PrintType = '1' where C_SHA_A_billID=?";	
		List<String> params = new ArrayList<String>();
		params.add(po.getCshaabillid());
		getJdbcTemplate().update(sql,params.toArray());
	}
	
	public List<InventoryEntryPo> getAlllyList(String allbillid,String outstockid,String supplieriD){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT C_SHA_AE_goodsId                                           AS cstiegoodsid, ");
		sb.append("       B_GI_Spec                                                  AS cstiespec, ");
		sb.append("		  B_GI_NotTaxRate 											 AS cstienottaxrate, ");
		sb.append("		  B_GI_TaxRate 												 AS cstietaxrate, ");
		sb.append("		  B_GI_CostPrice 										     AS cstiecostprice, ");
		sb.append("       C_SHA_AE_goodsbarcode                                      AS cstiebarcode, ");
		sb.append("       B_GI_ViewGoodsName                                         AS cstiegoodsname, ");
		sb.append("       C_SHA_AE_allocationQuantity                                AS cstiegoodsquantity, ");
		sb.append("       Isnull(kucun.GoodsQuantity, 0) + Isnull(zaitu.GoodsNum, 0) AS cstiemaxquantity, ");		
		sb.append("       (Isnull(C_SHA_AE_allocationQuantity, 0) * Isnull(B_GI_NotTaxRate, 0)) AS cstienottaxrateamount, ");
		sb.append("       (Isnull(C_SHA_AE_allocationQuantity, 0) * Isnull(B_GI_RetailPrice, 0)) AS cstiecostpriceamount, ");	
		sb.append("       ((Isnull(C_SHA_AE_allocationQuantity, 0) * Isnull(B_GI_CostPrice, 0)) - cast((Isnull(C_SHA_AE_allocationQuantity, 0) * Isnull(B_GI_NotTaxRate, 0))  as numeric(18,2)) ) AS cstietaxamount, ");
		sb.append("       Isnull(B_UT_unitName,'') AS cstieunitname ");	
		sb.append("FROM   C_SHA_Allocation ");
		sb.append("       INNER JOIN C_SHA_AllocationEntry ");
		sb.append("         ON C_SHA_A_billID = C_SHA_AE_billId ");
		sb.append("       INNER JOIN B_GoodsInfo ");
		sb.append("         ON C_SHA_AE_goodsId = B_GoodsInfo.B_GI_GoodsID ");		
		sb.append("       left JOIN B_Unit ");
		sb.append("         ON B_GI_UnitId = B_UT_id ");		
		sb.append("left JOIN B_Brand ON B_GI_SupplierID = B_BD_SupplierID and B_GI_BrandID = B_BD_ID ");
		sb.append("       LEFT JOIN (SELECT GoodsId            AS GoodsId, ");
		sb.append("                         SUM(GoodsQuantity) AS GoodsQuantity, ");
		sb.append("                         StockId            AS StockId, ");
		sb.append("                         B_WH_warehouseName AS StockName ");
		sb.append("                  FROM   (SELECT C_SH_SB_GoodsId       AS GoodsId, ");
		sb.append("                                 C_SH_SB_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                                 C_SH_SB_StockId       AS StockId ");
		sb.append("                          FROM   C_SH_StorageBeginning ");
		sb.append("                          UNION ALL ");
		sb.append("                          SELECT C_SH_SC_GoodsId       AS GoodsId, ");
		sb.append("                                 C_SH_SC_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                                 C_SH_SC_StockId       AS StockId ");
		sb.append("                          FROM   C_SH_StorageChange)ktemp ");
		sb.append("                         INNER JOIN B_Warehouse ");
		sb.append("                           ON ktemp.StockId = B_WH_ID ");
		sb.append(" and StockId = ? ");
		sb.append("                  GROUP  BY GoodsId, ");
		sb.append("                            StockId, ");
		sb.append("                            B_WH_warehouseName) kucun ");
		sb.append("         ON C_SHA_AE_goodsId = kucun.GoodsId ");
		sb.append("       LEFT JOIN (SELECT C_SH_TSE_GoodsID       AS GoodsId, ");
		sb.append("                         SUM(C_SH_TSE_GoodsNum) AS GoodsNum ");
		sb.append("                  FROM   C_SH_InTransitStorageEntry ");
		sb.append("                  WHERE  1 = 1 ");
		sb.append(" and C_SH_TSE_OUTStockID = ? ");
		sb.append("                  GROUP  BY C_SH_TSE_GoodsID)zaitu ");
		sb.append("         ON C_SHA_AE_goodsId = zaitu.GoodsId ");
		sb.append("WHERE  C_SHA_A_billID = ? ");
		
		params.add(outstockid);
		params.add(outstockid);
		params.add(allbillid);			
		
		if (!"".equals(supplieriD)){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(supplieriD);
			
		}
		
		sb.append("ORDER  BY C_SHA_AE_goodsId ");
		
		return queryForObjectList(sb.toString(), params.toArray(),InventoryEntryPo.class);
	}
	
	/**
	 * 根据条码获取效期、批号和注册证号
	 */
	public AllocationEntryPo getGoodsRegistrationNumByBarcode(AllocationEntryPo epo){
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select top 1 isnull(C_SH_BC_GuaranteePeriod,'') as cshaaeguaranteeperiod,isnull(C_SH_BC_Batch,'') as cshaaebatch,isnull(C_SH_BC_RegistrationNum,'') as cshaaeregistrationnum FROM C_SH_BatchCompare where C_SH_BC_Barcode = ? ");

		params.add(epo.getCshaaGoodsBarCode());
		
		return (AllocationEntryPo)queryForObject(sb.toString(), params.toArray(), AllocationEntryPo.class);	
	}
	
	public int getAllocationSettlementCount(AllocationPo po,DepartmentsPo departmentsPo){
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(distinct C_SHA_Allocation.C_SHA_A_billID) from C_SHA_Allocation ");
		
		if(!"".equals(Utility.getName(po.getChaasupplier())) || !"".equals(Utility.getName(po.getChaabrand())) || !"".equals(Utility.getName(po.getChaagoodsname())) || !"".equals(Utility.getName(po.getChaagoodsid()))){
			sb.append("inner join C_SHA_AllocationEntry on C_SHA_A_billID=C_SHA_AE_billId inner join B_GoodsInfo on C_SHA_AE_goodsId=B_GI_GoodsID ");
		}		

		sb.append("left join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)d on C_SHA_Allocation.C_SHA_A_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)x on C_SHA_Allocation.C_SHA_A_outDepartmentId=x.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_Allocation.C_SHA_A_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_Allocation.C_SHA_A_auditPerson=b.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)c on C_SHA_Allocation.C_SHA_A_consignee=c.ID ");
		sb.append("where C_SHA_A_consignState = '1'  ");
		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    sb.append(" and (d.B_DP_CompanysID = ? or x.B_DP_CompanysID = ?) ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_outDepartmentId=?  ");
			params.add(po.getCshaaoutdepartmentid());
		}
		
		if (departmentsPo.getBdptype().equals("1") || departmentsPo.getBdptype().equals("2")){
			sb.append("and ((C_SHA_Allocation.C_SHA_A_inDepartmentId=? and C_SHA_Allocation.C_SHA_A_auditState = '1') or C_SHA_Allocation.C_SHA_A_outDepartmentId=?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
		}
		
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and isnull(C_SHA_A_FinanceAuditState,'0') = ? ");
			params.add(po.getCshaaauditstate());
		}
		
		if(!"".equals(Utility.getName(po.getCshaacreateperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_createPerson=? ");
			params.add(po.getCshaacreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_auditPerson=? ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignee()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignee=? ");
			params.add(po.getCshaaconsignee());
		}
		
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and substring(C_SHA_AllocationEntry.C_SHA_AE_goodsId,3,2)=? ");
			params.add(Utility.getName(po.getChaasupplier()));
		}

		if(!"".equals(Utility.getName(po.getChaabrand()))){
			sb.append("and substring(C_SHA_AllocationEntry.C_SHA_AE_goodsId,6,2)=? ");
			params.add(Utility.getName(po.getChaabrand()));
		}
		
		if(!"".equals(Utility.getName(po.getChaagoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCshaaremark()))){
			sb.append("and C_SHA_A_remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshaaremark()));
		}
		if("0".equals(Utility.getName(po.getChaaautoflag()))){
			sb.append("and isnull(C_SHA_A_AutoAllocationFlag,'') = '0' ");
		}
		if("1".equals(Utility.getName(po.getChaaautoflag()))){
			sb.append("and isnull(C_SHA_A_AutoAllocationFlag,'') = '' ");
		}
		
		if(!"".equals(Utility.getName(po.getChaagoodsid()))){
			sb.append("and C_SHA_AE_goodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsid()));
		}
		
		if(!"".equals(Utility.getName(po.getCshaabillassociation()))){
			sb.append("and C_SHA_A_StatusBillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshaabillassociation()));
		}
		if(!"".equals(Utility.getName(po.getCshaacategoryid()))){
			sb.append("and C_SHA_A_CategoryID = ? ");
			params.add(Utility.getName(po.getCshaacategoryid()));
		}
		
		if(!"".equals(Utility.getName(po.getCshaaindepartmentname()))){
			sb.append("and d.B_DP_DepartmentName like '%'+?+'%' ");
			params.add(Utility.getName(po.getCshaaindepartmentname()));
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());	
	}
	
	public List<AllocationPo> getAllocationSettlementList(AllocationPo po,DepartmentsPo departmentsPo,int start, int size){

		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("SELECT DISTINCT TEMP.cshaabillid AS cshaabillid, ");
		sb.append("TEMP.cshaaoutdepartmentname AS cshaaoutdepartmentname, ");
		sb.append("TEMP.cshaaoutdepartmentid   AS cshaaoutdepartmentid, ");
		sb.append("TEMP.cshaacreatepersonname  AS cshaacreatepersonname, ");
		sb.append("TEMP.cshaabilldate          AS cshaabilldate, ");
		sb.append("TEMP.cshaaauditpersonname   AS cshaaauditpersonname, ");
		sb.append("TEMP.cshaaauditdate         AS cshaaauditdate, ");
		sb.append("TEMP.cshaaconsigneename     AS cshaaconsigneename, ");
		sb.append("TEMP.cshaaconsigndate       AS cshaaconsigndate, ");
		sb.append("TEMP.cshaaauditstate        AS cshaaauditstate, ");
		sb.append("TEMP.cshaacategoryid        AS cshaacategoryid, ");
		sb.append("TEMP.cshaaremark        	   AS cshaaremark, ");
		sb.append("TEMP.goodscategoryname      AS goodscategoryname, ");
		sb.append("TEMP.cshaaprinttype         AS cshaaprinttype, ");
		sb.append("TEMP.cshaaindepartmentname      AS cshaaindepartmentname, ");
		sb.append("TEMP.cshaaindepartmentid     AS cshaaindepartmentid, ");
		sb.append("rowNum FROM  (select  ");
		sb.append("Row_number() OVER(ORDER BY cshaabilldate DESC) AS rowNum, ");
		sb.append("cshaabillid,cshaaoutdepartmentname,cshaaoutdepartmentid,cshaaprinttype, ");
		sb.append("cshaacreatepersonname,cshaabilldate,cshaaauditpersonname,cshaaauditdate, ");
		sb.append("cshaaconsigneename, cshaaconsigndate, cshaaauditstate,cshaaindepartmentname,cshaaindepartmentid,cshaaremark,cshaacategoryid,goodscategoryname  ");
		sb.append("from ( ");
		sb.append("SELECT distinct  C_SHA_Allocation.C_SHA_A_billID AS cshaabillid, ");                                                                         
		sb.append("d.B_DP_DepartmentName AS cshaaindepartmentname, ");
		sb.append("e.B_DP_DepartmentName AS cshaaoutdepartmentname, ");
		sb.append("C_SHA_A_CategoryID as cshaacategoryid, ");
		sb.append("B_GC_GoodsCategoryName as goodscategoryname, ");
		sb.append("C_SHA_Allocation.C_SHA_A_outDepartmentId AS cshaaoutdepartmentid, ");
		sb.append("C_SHA_Allocation.C_SHA_A_inDepartmentId AS cshaaindepartmentid, ");
		sb.append("a.personName                            AS cshaacreatepersonname, ");
		sb.append("C_SHA_Allocation.C_SHA_A_billDate       AS cshaabilldate, ");
		sb.append("b.personName                            AS cshaaauditpersonname, ");
		sb.append("C_SHA_Allocation.C_SHA_A_auditDate      AS cshaaauditdate, ");
		sb.append("c.personName                            AS cshaaconsigneename, ");
		sb.append("C_SHA_Allocation.C_SHA_A_consignDate    AS cshaaconsigndate, ");
		sb.append("isnull(C_SHA_A_FinanceAuditState,'0')     AS cshaaauditstate, ");
		sb.append("C_SHA_Allocation.C_SHA_A_PrintType      AS cshaaprinttype, ");
		sb.append("C_SHA_A_remark   AS cshaaremark ");
		sb.append("FROM   C_SHA_Allocation ");
		
		if(!"".equals(Utility.getName(po.getChaasupplier())) || !"".equals(Utility.getName(po.getChaabrand())) || !"".equals(Utility.getName(po.getChaagoodsname())) || !"".equals(Utility.getName(po.getChaagoodsid()))){
			sb.append("left JOIN C_SHA_AllocationEntry ON C_SHA_A_billID = C_SHA_AE_billId inner join B_GoodsInfo on C_SHA_AE_goodsId=B_GI_GoodsID ");
		}
		
		sb.append("left JOIN (SELECT B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID FROM   B_Departments)d ");
		sb.append("ON C_SHA_Allocation.C_SHA_A_inDepartmentId = d.B_DP_DepartmentID ");
		sb.append("left JOIN (SELECT B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID FROM   B_Departments)e ");
		sb.append("ON C_SHA_Allocation.C_SHA_A_outDepartmentId = e.B_DP_DepartmentID ");
		sb.append("left join B_GoodsCategory on B_GC_ID = C_SHA_A_CategoryID ");
		sb.append("LEFT JOIN (SELECT ID,personName FROM   SYS_PersonInfo)a ON C_SHA_Allocation.C_SHA_A_createPerson = a.ID ");
		sb.append("LEFT JOIN (SELECT ID,personName FROM   SYS_PersonInfo)b ON C_SHA_Allocation.C_SHA_A_auditPerson = b.ID ");
		sb.append("LEFT JOIN (SELECT ID,personName FROM   SYS_PersonInfo)c ON C_SHA_Allocation.C_SHA_A_consignee = c.ID ");

		sb.append("where C_SHA_A_consignState = '1'  ");
		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    sb.append(" and (d.B_DP_CompanysID = ? or e.B_DP_CompanysID = ?) ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");
			params.add(po.getCshaabillid());
		}	
		
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_outDepartmentId=?  ");
			params.add(po.getCshaaoutdepartmentid());
		}
		
		if (departmentsPo.getBdptype().equals("1") || departmentsPo.getBdptype().equals("2")){
			sb.append("and ((C_SHA_Allocation.C_SHA_A_inDepartmentId=? and C_SHA_Allocation.C_SHA_A_auditState = '1') or C_SHA_Allocation.C_SHA_A_outDepartmentId=?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
		}
		
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and isnull(C_SHA_A_FinanceAuditState,'0') = ? ");
			params.add(po.getCshaaauditstate());
		}
		
		if(!"".equals(Utility.getName(po.getCshaacreateperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_createPerson=? ");
			params.add(po.getCshaacreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_auditPerson=? ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getCshaaconsignee()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignee=? ");
			params.add(po.getCshaaconsignee());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and substring(C_SHA_AllocationEntry.C_SHA_AE_goodsId,3,2)=? ");
			params.add(Utility.getName(po.getChaasupplier()));
		}
		if(!"".equals(Utility.getName(po.getChaabrand()))){
			sb.append("and substring(C_SHA_AllocationEntry.C_SHA_AE_goodsId,6,2)=? ");
			params.add(Utility.getName(po.getChaabrand()));
		}
		if(!"".equals(Utility.getName(po.getChaagoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCshaaremark()))){
			sb.append("and C_SHA_A_remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshaaremark()));
		}
		if("0".equals(Utility.getName(po.getChaaautoflag()))){
			sb.append("and isnull(C_SHA_A_AutoAllocationFlag,'') = '0' ");
		}
		if("1".equals(Utility.getName(po.getChaaautoflag()))){
			sb.append("and isnull(C_SHA_A_AutoAllocationFlag,'') = '' ");
		}
		if(!"".equals(Utility.getName(po.getChaagoodsid()))){
			sb.append("and C_SHA_AE_goodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsid()));
		}
		if(!"".equals(Utility.getName(po.getCshaabillassociation()))){
			sb.append("and C_SHA_A_StatusBillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshaabillassociation()));
		}
		if(!"".equals(Utility.getName(po.getCshaacategoryid()))){
			sb.append("and C_SHA_A_CategoryID = ? ");
			params.add(Utility.getName(po.getCshaacategoryid()));
		}
		
		if(!"".equals(Utility.getName(po.getCshaaindepartmentname()))){
			sb.append("and d.B_DP_DepartmentName like '%'+?+'%' ");
			params.add(Utility.getName(po.getCshaaindepartmentname()));
		}
	
		sb.append(" )temp1  ) TEMP where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(), AllocationPo.class);	
	}
	
	public AllocationPo getAllocationSettlement(AllocationPo po){
		
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1  C_SHA_Allocation.C_SHA_A_billID as cshaabillid,d.B_DP_DepartmentName as cshaaoutdepartmentname,u.B_DP_DepartmentName as cshaaindepartmentname,");
		sb.append("a.personName as cshaacreatepersonname,C_SHA_Allocation.C_SHA_A_billDate as cshaabilldate,b.personName as cshaaauditpersonname,");
		sb.append("C_SHA_A_CategoryID as cshaacategoryid,B_GC_GoodsCategoryName as goodscategoryname,C_SHA_A_StatusBillID as cshastatusorderid , ");
		sb.append("c.personName as cshaaconsigneename,C_SHA_Allocation.C_SHA_A_consignDate as cshaaconsigndate,");
		sb.append("C_SHA_Allocation.C_SHA_A_createPerson as cshaacreateperson,C_SHA_Allocation.C_SHA_A_auditPerson as cshaaauditperson,C_SHA_Allocation.C_SHA_A_auditDate as cshaaauditdate,");
		sb.append("C_SHA_Allocation.C_SHA_A_auditState as cshaaauditstate,C_SHA_Allocation.C_SHA_A_consignState as cshaaconsignstate,");
		sb.append("C_SHA_Allocation.C_SHA_A_outStockId as cshaaoutstockid,C_SHA_Allocation.C_SHA_A_inStockId as cshaainstockid,C_SHA_Allocation.C_SHA_A_remark as cshaaremark,");
		sb.append("C_SHA_Allocation.C_SHA_A_inDepartmentId as cshaaindepartmentid,C_SHA_Allocation.C_SHA_A_outDepartmentId as cshaaoutdepartmentid,C_SHA_A_StatusBillID as cshaabillassociation, ");
		sb.append("e.B_WH_warehouseName as cshaaoutstockname,f.B_WH_warehouseName as cshaainstockname,C_SHA_Allocation.C_SHA_A_supplier as chaasupplier,x.B_SP_SupplierName as chaasuppliername,isnull(C_SHA_A_AutoAllocationFlag,'') as chaaautoflag,isnull(m.personName,'') as cshaafinanceauditpersonname,C_SHA_A_FinanceAuditDate as cshaafinanceauditdate,isnull(C_SHA_A_AmountType,'') as cshaaamounttype  from C_SHA_Allocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_Allocation.C_SHA_A_outDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_Allocation.C_SHA_A_createPerson=a.ID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)x on C_SHA_Allocation.C_SHA_A_supplier=x.B_SP_ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_Allocation.C_SHA_A_auditPerson=b.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)c on C_SHA_Allocation.C_SHA_A_consignee=c.ID ");
		sb.append("left join (select B_WH_ID,B_WH_warehouseName from B_Warehouse)e on C_SHA_Allocation.C_SHA_A_outStockId=e.B_WH_ID ");
		sb.append("left join (select B_WH_ID,B_WH_warehouseName from B_Warehouse)f on C_SHA_Allocation.C_SHA_A_inStockId=f.B_WH_ID ");
		sb.append("left join B_GoodsCategory on B_GC_ID = C_SHA_A_CategoryID ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)u on C_SHA_Allocation.C_SHA_A_inDepartmentId=u.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)m on C_SHA_Allocation.C_SHA_A_FinanceAuditPerson=m.ID ");
		sb.append("where C_SHA_Allocation.C_SHA_A_billID=? ");
		
		params.add(Utility.getName(po.getCshaabillid()));
		
		return (AllocationPo)queryForObject(sb.toString(), params.toArray(), AllocationPo.class);
	}
	
	public List<AllocationEntryPo> getAllocationSettlementEntry(AllocationPo po){

		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("select C_SHA_AE_ID as cshaaeid,C_SHA_AE_allocationQuantity as cshaaeallocationquantity,C_SHA_AE_goodsId as cshaaegoodsid,C_SHA_AE_goodsbarcode as cshaaegoodsBarCode,");
		sb.append("B_GI_ViewGoodsName as cshaaegoodsname,B_GI_Spec as cshaaespec,C_SHA_AE_requirementQuantity as cshaaerequirementquantity,");
		sb.append("isnull(C_SHA_AE_NotTaxRate,isnull(B_GI_NotTaxRate,0)) as cshaaenottaxrate,isnull(C_SHA_AE_CostPrice,isnull(B_GI_CostPrice,0)) as cshaaecostprice,isnull(C_SHA_AE_NotTaxRateAmount,cast((isnull(B_GI_NotTaxRate,0) * C_SHA_AE_allocationQuantity) as numeric(18,2))) as cshaaenottaxrateamount,isnull(C_SHA_AE_CostPriceAmount,(isnull(B_GI_CostPrice,0) * C_SHA_AE_allocationQuantity)) as cshaaecostpriceamount,isnull(C_SHA_AE_WholesalePrice,isnull(B_GI_WholesalePrice,0)) as cshaaewholesaleprice,isnull(C_SHA_AE_WholesalePriceAmount,(isnull(B_GI_WholesalePrice,0) * C_SHA_AE_allocationQuantity)) as cshaaewholesalepriceamount ");
		
		sb.append("from C_SHA_AllocationEntry ");
		sb.append("inner join B_GoodsInfo on C_SHA_AllocationEntry.C_SHA_AE_goodsId=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("where C_SHA_AE_billId=? ");	

		params.add(Utility.getName(po.getCshaabillid()));
		
		return queryForObjectList(sb.toString(), params.toArray(), AllocationEntryPo.class);	
	}
	
	public void updateAllocationSettlementEntry(List<InventoryEntryPo> eList){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		for (InventoryEntryPo epo : eList){
			sb.append("update C_SHA_AllocationEntry set  ");
			sb.append("	C_SHA_AE_NotTaxRate = ?, ");
			sb.append("	C_SHA_AE_NotTaxRateAmount = ?, ");
			sb.append("	C_SHA_AE_CostPrice = ?, ");
			sb.append("	C_SHA_AE_CostPriceAmount = ?, ");
			sb.append("	C_SHA_AE_WholesalePrice = ?, ");
			sb.append("	C_SHA_AE_WholesalePriceAmount = ? ");
			sb.append("  where C_SHA_AE_ID = ? ");

			params.add(Utility.getName(epo.getCstienottaxrate()));
			params.add(Utility.getName(epo.getCstienottaxrateamount()));
			params.add(Utility.getName(epo.getCstiecostprice()));
			params.add(Utility.getName(epo.getCstiecostpriceamount()));
			params.add(Utility.getName(epo.getCstiewholesaleprice()));
			params.add(Utility.getName(epo.getCstiewholesalepriceamount()));			
			params.add(Utility.getName(epo.getCstieid()));
			
			sb.append("update C_ST_InventoryEntry set  ");
			sb.append("	C_ST_IE_NotTaxRate = ?, ");
			sb.append("	C_ST_IE_NotTaxRateAmount = ?, ");
			sb.append("	C_ST_IE_CostPrice = ?, ");
			sb.append("	C_ST_IE_CostPriceAmount = ?, ");
			sb.append("	C_ST_IE_TaxAmount = ?, ");
			sb.append("	C_ST_IE_WholesalePrice = ?, ");
			sb.append("	C_ST_IE_WholesalePriceAmount = ? ");
			sb.append("  where C_ST_IE_BillID = ? and C_ST_IE_BarCode = ? ");

			params.add(Utility.getName(epo.getCstienottaxrate()));
			params.add(Utility.getName(epo.getCstienottaxrateamount()));
			params.add(Utility.getName(epo.getCstiecostprice()));
			params.add(Utility.getName(epo.getCstiecostpriceamount()));			
			params.add("0");			
			params.add(Utility.getName(epo.getCstiewholesaleprice()));
			params.add(Utility.getName(epo.getCstiewholesalepriceamount()));			
			params.add(Utility.getName(epo.getCstiebillid()));
			params.add(Utility.getName(epo.getCstiebarcode()));
			
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void updateAllocationSettlement(AllocationPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update top (1) C_SHA_Allocation set C_SHA_A_FinanceAuditPerson = ?,C_SHA_A_FinanceAuditState = '1',C_SHA_A_FinanceAuditDate = getdate() where C_SHA_A_billID = ? ");
		
		sb.append("update top (1) C_ST_Inventory set C_ST_I_FinanceAuditPerson = ?,C_ST_I_FinanceAuditState = '1',C_ST_I_FinanceAuditDate = getdate() where C_ST_I_BillID = ? ");
		
		params.add(Utility.getName(po.getCshaafinanceauditperson()));
		params.add(Utility.getName(po.getCshaabillid()));
		
		params.add(Utility.getName(po.getCshaafinanceauditperson()));
		params.add(Utility.getName(po.getCshaabillid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public List<AllocationEntryPo> getAllocationEntryList2(AllocationPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("select C_SHA_AE_ID as cshaaeid,C_SHA_AllocationEntry.C_SHA_AE_billId as cshaaebillid,C_SHA_AllocationEntry.C_SHA_AE_allocationQuantity as cshaaeallocationquantity,C_SHA_AllocationEntry.C_SHA_AE_goodsId as cshaaegoodsid,C_SHA_AE_goodsbarcode as cshaaegoodsBarCode,");
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cshaaegoodsname,B_GoodsInfo.B_GI_Spec as cshaaespec,C_SHA_AllocationEntry.C_SHA_A_outStockId as cshaaoutstockid,");
		sb.append("C_SHA_AllocationEntry.C_SHA_A_inStockId as cshaainstockid,C_SHA_AllocationEntry.C_SHA_AE_requirementQuantity as cshaaerequirementquantity,");
		sb.append("isnull(C_SHA_AE_OutStorageFlag,'1') as cshaaeoutstorageflag, ");
		sb.append("(select top 1 C_SH_BC_GuaranteePeriod from C_SH_BatchCompare where C_SH_BC_Barcode = C_SHA_AE_goodsbarcode ) as cshaaeguaranteeperiod, ");
		sb.append("(select top 1 C_SH_BC_Batch from C_SH_BatchCompare where C_SH_BC_Barcode = C_SHA_AE_goodsbarcode ) as cshaaebatch, ");
		
		sb.append("       case ");
		sb.append("       	when B_GI_GoodsCategoryID = '8' then B_GI_Sph ");
		sb.append("       	else B_GI_Color                   ");
		sb.append("       end 						  AS cshaaecolor, ");
		
		if("2".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceA as cshaaebgiretailprice, ");
		}else if("3".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceB as cshaaebgiretailprice, ");
		}else if("4".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceC as cshaaebgiretailprice, ");
		}else if("5".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceD as cshaaebgiretailprice, ");
		}else if("6".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceE as cshaaebgiretailprice, ");
		}else if("7".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceF as cshaaebgiretailprice, ");
		}else if("8".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceG as cshaaebgiretailprice, ");
		}else if("9".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceH as cshaaebgiretailprice, ");
		}else if("10".equals(po.getWhichretail())){
			sb.append("B_GI_RetailPriceI as cshaaebgiretailprice, ");
		}else{
			sb.append("B_GI_RetailPrice as cshaaebgiretailprice, ");
		}
		
		sb.append("B_BD_Place as cshaaesource, ");
		sb.append("B_GI_TaxRate as cshaaetaxrate, ");
		sb.append("B_BD_brandName as cshaaebrandname, ");
		sb.append("(isnull(kucun.GoodsQuantity,0)+isnull(zaitu.GoodsNum,0)) as cshaaemaxquantity, ");
		sb.append("C_SHA_AE_RegistrationNum as cshaaeregistrationnum, ");
		
		sb.append("isnull(C_SHA_AE_NotTaxRate,0) as cshaaenottaxrate, ");
		sb.append("isnull(C_SHA_AE_NotTaxRateAmount,0) as cshaaenottaxrateamount, ");
		sb.append("isnull(C_SHA_AE_CostPrice,0) as cshaaecostprice, ");
		sb.append("isnull(C_SHA_AE_CostPriceAmount,0) as cshaaecostpriceamount, ");
		sb.append("isnull(C_SHA_AE_WholesalePrice,0) as cshaaewholesaleprice, ");
		sb.append("isnull(C_SHA_AE_WholesalePriceAmount,0) as cshaaewholesalepriceamount, ");	
		
		sb.append("isnull(C_SHA_AE_NotTaxRate,0) as bginottaxrate, ");
		sb.append("isnull(C_SHA_AE_CostPrice,0) as bgicostprice, ");
		sb.append("isnull(C_SHA_AE_WholesalePrice,0) as bgiwholesaleprice ");
		
		sb.append("from C_SHA_AllocationEntry ");
		sb.append("inner join B_GoodsInfo on C_SHA_AllocationEntry.C_SHA_AE_goodsId=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("left JOIN B_Brand ON B_GI_SupplierID = B_BD_SupplierID and B_GI_BrandID = B_BD_ID ");
		sb.append("LEFT JOIN (SELECT C_SH_SL_GoodsBarCode  AS GoodsBarCode, ");
		sb.append("        isnull(sum(C_SH_Sl_GoodsQuantity),0) AS GoodsQuantity, ");
		sb.append("        C_SH_Sl_StockId       AS StockId ");
		sb.append(" FROM   C_SH_StorageLog ");
		sb.append(" WHERE  1 = 1 ");
		sb.append(" AND C_SH_SL_StockId = (select C_SHA_A_outStockId from C_SHA_Allocation where C_SHA_A_billID = ?) ");
		params.add(po.getCshaabillid());
		sb.append(" GROUP  BY C_SH_SL_GoodsBarCode, ");
		sb.append("   C_SH_Sl_StockId) kucun ");
		sb.append(" ON C_SHA_AE_goodsbarcode = kucun.GoodsBarCode ");
		sb.append(" LEFT JOIN (SELECT C_SH_TSE_GoodsBarCode  AS GoodsBarCode, ");
		sb.append(" isnull(SUM(C_SH_TSE_GoodsNum),0) AS GoodsNum ");
        sb.append(" FROM   C_SH_InTransitStorageEntry ");
        sb.append(" WHERE  1 = 1 ");
        sb.append("        AND C_SH_TSE_OUTStockID = (select C_SHA_A_outStockId from C_SHA_Allocation where C_SHA_A_billID = ?) ");
        params.add(po.getCshaabillid());
        if (!"".equals(Utility.getName(po.getCshaabillid()))) {
			sb.append(" and C_SH_TSE_BillID <> ? ");
			params.add(po.getCshaabillid());
		}
        sb.append(" GROUP  BY C_SH_TSE_GoodsBarCode)zaitu ");
        sb.append("ON C_SHA_AE_goodsbarcode = zaitu.GoodsBarCode ");
		
		sb.append("where C_SHA_AE_billId=? ");	
		
		params.add(po.getCshaabillid());
		
		return queryForObjectList(sb.toString(), params.toArray(), AllocationEntryPo.class);
	}
	
}
