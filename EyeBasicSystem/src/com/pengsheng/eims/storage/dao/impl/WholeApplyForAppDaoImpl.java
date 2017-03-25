package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.storage.dao.WholeApplyForAppDao;
import com.pengsheng.eims.storage.persistence.WholeBarcodePo;
import com.pengsheng.eims.storage.persistence.WholeEntryPo;
import com.pengsheng.eims.storage.persistence.WholePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class WholeApplyForAppDaoImpl extends BaseJdbcDaoSupport implements WholeApplyForAppDao {
	
	/**
	 * 获取调拨单据数量
	 */
	public int getWholeCount(WholePo po,DepartmentsPo departmentsPo) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(distinct C_SH_ApplyWhole.C_SH_AW_billID) from C_SH_ApplyWhole inner join C_SH_ApplyWholeEntry on C_SH_AW_billID=C_SH_AWE_billId left join B_GoodsInfo on C_SH_AWE_goodsId=B_GI_GoodsID ");
		sb.append("left join (select B_FS_StoreID,B_FS_StoreName from B_Franchisee)d on C_SH_ApplyWhole.C_SH_AW_inDepartmentId=d.B_FS_StoreID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SH_ApplyWhole.C_SH_AW_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SH_ApplyWhole.C_SH_AW_auditPerson=b.ID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SH_ApplyWhole.C_SH_AW_supplier=c.B_SP_ID ");
		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)e on C_SH_ApplyWhole.C_SH_AW_goodscategory=e.B_GC_ID ");
		sb.append("where C_SH_AW_ForAppFlag = '1' AND C_SH_AW_flag=? and (substring(C_SH_AWE_goodsId,1,1) <> '4' and substring(C_SH_AWE_goodsId,1,1) <> '5') ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getCshawflag());
		
		if(!"".equals(Utility.getName(po.getCshawauditperson()))){
			sb.append("and C_SH_AW_auditPerson = ? ");
			params.add(po.getCshawauditperson());
		}
		
		if(!"".equals(Utility.getName(po.getCshawcreateperson()))){
			sb.append("and C_SH_AW_createPerson = ? ");
			params.add(po.getCshawcreateperson());
		}
		
		if(!"3".equals(departmentsPo.getBdptype())){
			sb.append("and (C_SH_ApplyWhole.C_SH_AW_inDepartmentId=? or C_SH_AW_outDepartmentId = ?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
		}else
		{
			if(!"".equals(po.getCshawindepartmentid()))
			{
				sb.append("and (C_SH_ApplyWhole.C_SH_AW_inDepartmentId=?) ");
				params.add(po.getCshawindepartmentid());
			}
		}
		if(!"".equals(Utility.getName(po.getCshawbillid()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshawbillid());
		}
		if(!"".equals(Utility.getName(po.getCshawindepartmentid()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_inDepartmentId=? ");
			params.add(po.getCshawindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshawstartTime())) && !"".equals(Utility.getName(po.getCshawendTime()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) >= ? ");
			params.add(po.getCshawstartTime());
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) <= ? ");
			params.add(po.getCshawendTime());
		}else if(!"".equals(Utility.getName(po.getCshawstartTime())) && "".equals(Utility.getName(po.getCshawendTime()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) >= ? ");
			params.add(po.getCshawstartTime());
			
		}else if("".equals(Utility.getName(po.getCshawstartTime())) && !"".equals(Utility.getName(po.getCshawendTime()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) <= ? ");
			params.add(po.getCshawendTime());
		}
		
		if(!"".equals(Utility.getName(po.getCshawauditdatestart())) && !"".equals(Utility.getName(po.getCshawauditdateend()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_auditDate, 23) >= ? ");
			params.add(po.getCshawauditdatestart());
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_auditDate, 23) <= ? ");
			params.add(po.getCshawauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshawauditdatestart())) && "".equals(Utility.getName(po.getCshawauditdateend()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_auditDate, 23) >= ? ");
			params.add(po.getCshawauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshawauditdatestart())) && !"".equals(Utility.getName(po.getCshawauditdateend()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_auditDate, 23) <= ? ");
			params.add(po.getCshawauditdateend());
		}
		
		if(!"".equals(Utility.getName(po.getCshawauditstate()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_auditState=? ");
			params.add(po.getCshawauditstate());
		}	
		
		if(!"".equals(Utility.getName(po.getCshawcreateperson()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_createPerson like '%'+?+'%' ");
			params.add(po.getCshawcreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshawauditperson()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_auditPerson like '%'+?+'%' ");
			params.add(po.getCshawauditperson());
		}
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and B_GI_GoodsCategoryID = ? ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and substring(C_SH_AWE_goodsId,3,2) like '%'+?+'%' ");
			params.add(po.getChaasupplier());
		}
		if(!"".equals(Utility.getName(po.getChaagoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getChaagoodsname()));
		}
		if(!"".equals(Utility.getName(po.getCshawremark()))){
			sb.append("and C_SH_AW_remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshawremark()));
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
	public List<WholePo> getWholeList(WholePo po,DepartmentsPo departmentsPo, int start,
			int size) {

		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select temp.cshawbillid as cshawbillid,temp.cshawindepartmentname as cshawindepartmentname,temp.cshawoutdepartmentname,");
		sb.append("temp.cshawcreatepersonname as cshawcreatepersonname,temp.cshawbilldate as cshawbilldate,");
		sb.append("temp.cshawauditpersonname as cshawauditpersonname,temp.cshawauditdate as cshawauditdate,");
		sb.append("temp.chaasuppliername as chaasuppliername,temp.goodscategoryname as goodscategoryname,temp.cshawaindepartmentid as cshawoutdepartmentid, ");
		sb.append("temp.cshawauditstate as cshawauditstate,temp.cshastatusorderid as cshastatusorderid,temp.cshawremark as cshawremark,TEMP.isWriteoffs  ");
		sb.append("from(select ROW_NUMBER() Over(order by temp.cshawbilldate desc) as rowNum,");		
		
		sb.append("temp.cshawbillid as cshawbillid,temp.cshawindepartmentname as cshawindepartmentname,temp.cshawoutdepartmentname,temp.cshawaindepartmentid,");
		sb.append("temp.cshawcreatepersonname as cshawcreatepersonname,temp.cshawbilldate as cshawbilldate,");
		sb.append("temp.cshawauditpersonname as cshawauditpersonname,temp.cshawauditdate as cshawauditdate,");
		sb.append("temp.chaasuppliername as chaasuppliername,temp.goodscategoryname as goodscategoryname,");
		sb.append("temp.cshawauditstate as cshawauditstate,temp.cshastatusorderid as cshastatusorderid,temp.cshawremark as cshawremark,TEMP.isWriteoffs from ( ");
		
		sb.append("select distinct C_SH_ApplyWhole.C_SH_AW_billID as cshawbillid,d.B_FS_StoreName as cshawindepartmentname,dd.B_DP_DepartmentName as cshawoutdepartmentname,C_SH_AW_inDepartmentId as cshawaindepartmentid,");
		sb.append("a.personName as cshawcreatepersonname,C_SH_ApplyWhole.C_SH_AW_billDate as cshawbilldate,b.personName as cshawauditpersonname,C_SH_ApplyWhole.C_SH_AW_auditDate as cshawauditdate,");
		sb.append("c.B_SP_SupplierName as chaasuppliername,f.B_GC_GoodsCategoryName as goodscategoryname,e.C_SHA_StatusOrderID as cshastatusorderid,C_SH_AW_remark as cshawremark,ISNULL(gg.C_SHA_StatusApplyBillID, '0') AS isWriteoffs,");
		sb.append("C_SH_ApplyWhole.C_SH_AW_auditState as cshawauditstate from C_SH_ApplyWhole inner join C_SH_ApplyWholeEntry on C_SH_AW_billID=C_SH_AWE_billId left join B_GoodsInfo on C_SH_AWE_goodsId=B_GI_GoodsID ");
		sb.append("left join (select B_FS_StoreID,B_FS_StoreName from B_Franchisee)d on C_SH_ApplyWhole.C_SH_AW_inDepartmentId=d.B_FS_StoreID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SH_ApplyWhole.C_SH_AW_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SH_ApplyWhole.C_SH_AW_auditPerson=b.ID ");
		sb.append("       LEFT JOIN (SELECT B_DP_DepartmentID,");
		sb.append("                          B_DP_DepartmentName");
		sb.append("                   FROM   B_Departments)dd");
		sb.append("        ON C_SH_ApplyWhole.C_SH_AW_outDepartmentId = dd.B_DP_DepartmentID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SH_ApplyWhole.C_SH_AW_supplier=c.B_SP_ID ");
		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)f on C_SH_ApplyWhole.C_SH_AW_goodscategory=f.B_GC_ID ");
		sb.append("left join (select * from C_SHA_Status)e on C_SH_ApplyWhole.C_SH_AW_billID=e.C_SHA_StatusApplyBillID ");
		sb.append(" LEFT JOIN (select C_SHA_StatusApplyBillID from C_SHA_Status WHERE (ISNULL(C_SHA_StatusBillID,'')<>'' OR ISNULL(C_SHA_StatusOrderID,'')<>'' OR ISNULL(C_SHA_StatusReceiptID,'')<>''))gg ON gg.C_SHA_StatusApplyBillID = C_SH_AW_billID ");
		sb.append(" where C_SH_AW_ForAppFlag = '1' AND C_SH_AW_flag=? and (substring(C_SH_AWE_goodsId,1,1) <> '4' and substring(C_SH_AWE_goodsId,1,1) <> '5') ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshawflag());
		
		if(!"".equals(Utility.getName(po.getCshawauditperson()))){
			sb.append("and C_SH_AW_auditPerson = ? ");
			params.add(po.getCshawauditperson());
		}
		
		if(!"".equals(Utility.getName(po.getCshawcreateperson()))){
			sb.append("and C_SH_AW_createPerson = ? ");
			params.add(po.getCshawcreateperson());
		}
		
		if(!"".equals(Utility.getName(po.getChaabrand()))){
			sb.append("and substring(C_SH_AWE_goodsId,6,2) like '%'+?+'%' ");
			params.add(po.getChaabrand());
		}
		
		if(!"3".equals(departmentsPo.getBdptype())){
			sb.append("and (C_SH_ApplyWhole.C_SH_AW_inDepartmentId=? or C_SH_AW_outDepartmentId = ?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
		}else
		{
			if(!"".equals(po.getCshawindepartmentid()))
			{
				sb.append("and (C_SH_ApplyWhole.C_SH_AW_inDepartmentId=?) ");
				params.add(po.getCshawindepartmentid());
			}
		}
		if(!"".equals(Utility.getName(po.getCshawbillid()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshawbillid());
		}
		if(!"".equals(Utility.getName(po.getCshawoutdepartmentid()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_outDepartmentId=? ");
			params.add(po.getCshawoutdepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshawstartTime())) && !"".equals(Utility.getName(po.getCshawendTime()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) >= ? ");
			params.add(po.getCshawstartTime());
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) <= ? ");
			params.add(po.getCshawendTime());
		}else if(!"".equals(Utility.getName(po.getCshawstartTime())) && "".equals(Utility.getName(po.getCshawendTime()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) >= ? ");
			params.add(po.getCshawstartTime());
			
		}else if("".equals(Utility.getName(po.getCshawstartTime())) && !"".equals(Utility.getName(po.getCshawendTime()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) <= ? ");
			params.add(po.getCshawendTime());
		}
		
		if(!"".equals(Utility.getName(po.getCshawauditdatestart())) && !"".equals(Utility.getName(po.getCshawauditdateend()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_auditDate, 23) >= ? ");
			params.add(po.getCshawauditdatestart());
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_auditDate, 23) <= ? ");
			params.add(po.getCshawauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshawauditdatestart())) && "".equals(Utility.getName(po.getCshawauditdateend()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_auditDate, 23) >= ? ");
			params.add(po.getCshawauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshawauditdatestart())) && !"".equals(Utility.getName(po.getCshawauditdateend()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_auditDate, 23) <= ? ");
			params.add(po.getCshawauditdateend());
		}
		
		if(!"".equals(Utility.getName(po.getCshawauditstate()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_auditState=? ");
			params.add(po.getCshawauditstate());
		}	
		
		if(!"".equals(Utility.getName(po.getCshawcreateperson()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_createPerson like '%'+?+'%' ");
			params.add(po.getCshawcreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshawauditperson()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_auditPerson like '%'+?+'%' ");
			params.add(po.getCshawauditperson());
		}
		
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and B_GI_GoodsCategoryID = ? ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and substring(C_SH_AWE_goodsId,3,2) like '%'+?+'%' ");
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
		if(!"".equals(Utility.getName(po.getCshawremark()))){
			sb.append("and C_SH_AW_remark like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCshawremark()));
		}
		
		sb.append(" )temp ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), WholePo.class);
	}
	
	/**
	 * 获取调拨单据数量
	 */
	public int getReWholeCount(WholePo po,DepartmentsPo departmentsPo) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(C_SH_ApplyWhole.C_SH_AW_billID) from C_SH_ApplyWhole ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SH_ApplyWhole.C_SH_AW_outDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SH_ApplyWhole.C_SH_AW_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SH_ApplyWhole.C_SH_AW_auditPerson=b.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)c on C_SH_ApplyWhole.C_SH_AW_consignee=c.ID ");
		sb.append("where C_SH_AW_ForAppFlag = '1' AND  C_SH_AW_flag=?  ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshawflag());
		
		if(!"3".equals(departmentsPo.getBdptype())){
			sb.append("and (C_SH_ApplyWhole.C_SH_AW_outDepartmentId=? or C_SH_ApplyWhole.C_SH_AW_inDepartmentId=?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
			
		}
		if(!"".equals(Utility.getName(po.getCshawbillid()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshawbillid());
		}
		if(!"".equals(Utility.getName(po.getCshawindepartmentid()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_inDepartmentId=? ");
			params.add(po.getCshawindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshawstartTime())) && !"".equals(Utility.getName(po.getCshawendTime()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) >= ? ");
			params.add(po.getCshawstartTime());
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) <= ? ");
			params.add(po.getCshawendTime());
		}else if(!"".equals(Utility.getName(po.getCshawstartTime())) && "".equals(Utility.getName(po.getCshawendTime()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) >= ? ");
			params.add(po.getCshawstartTime());
			
		}else if("".equals(Utility.getName(po.getCshawstartTime())) && !"".equals(Utility.getName(po.getCshawendTime()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) <= ? ");
			params.add(po.getCshawendTime());
		}
		if(!"".equals(Utility.getName(po.getCshawauditstate()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_auditState=? ");
			params.add(po.getCshawauditstate());
		}
		if(!"".equals(Utility.getName(po.getCshawconsignstate()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_consignState=? ");
			params.add(po.getCshawconsignstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshawcreateperson()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_createPerson like '%'+?+'%' ");
			params.add(po.getCshawcreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshawauditperson()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_auditPerson like '%'+?+'%' ");
			params.add(po.getCshawauditperson());
		}
		if(!"".equals(Utility.getName(po.getCshawconsignee()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_consignee like '%'+?+'%' ");
			params.add(po.getCshawconsignee());
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	/**
	 * 获取负调拨单据
	 */
	public List<WholePo> getReWholeList(WholePo po,DepartmentsPo departmentsPo, int start,
			int size) {

		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select temp.cshawbillid as cshawbillid,temp.cshawoutdepartmentname as cshawoutdepartmentname,temp.cshawoutdepartmentid as cshawoutdepartmentid,");
		sb.append("temp.cshawcreatepersonname as cshawcreatepersonname,temp.cshawbilldate as cshawbilldate,");
		sb.append("temp.cshawauditpersonname as cshawauditpersonname,temp.cshawauditdate as cshawauditdate,");
		sb.append("temp.cshawconsigneename as cshawconsigneename,temp.cshawconsigndate as cshawconsigndate,");
		sb.append("temp.cshawauditstate as cshawauditstate,temp.cshawconsignstate as cshawconsignstate ");
		sb.append("from(select ROW_NUMBER() Over(order by C_SH_ApplyWhole.C_SH_AW_billDate desc,C_SH_ApplyWhole.C_SH_AW_billID desc) as rowNum,");
		sb.append("C_SH_ApplyWhole.C_SH_AW_billID as cshawbillid,d.B_DP_DepartmentName as cshawoutdepartmentname,C_SH_ApplyWhole.C_SH_AW_outDepartmentId as cshawoutdepartmentid,");
		sb.append("a.personName as cshawcreatepersonname,C_SH_ApplyWhole.C_SH_AW_billDate as cshawbilldate,b.personName as cshawauditpersonname,C_SH_ApplyWhole.C_SH_AW_auditDate as cshawauditdate,");
		sb.append("c.personName as cshawconsigneename,C_SH_ApplyWhole.C_SH_AW_consignDate as cshawconsigndate,");
		sb.append("C_SH_ApplyWhole.C_SH_AW_auditState as cshawauditstate,C_SH_ApplyWhole.C_SH_AW_consignState as cshawconsignstate from C_SH_ApplyWhole ");
		sb.append("left join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SH_ApplyWhole.C_SH_AW_outDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SH_ApplyWhole.C_SH_AW_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SH_ApplyWhole.C_SH_AW_auditPerson=b.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)c on C_SH_ApplyWhole.C_SH_AW_consignee=c.ID ");
		sb.append(" where C_SH_AW_ForAppFlag = '1' AND  C_SH_AW_flag=? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCshawflag());
		if(!"3".equals(departmentsPo.getBdptype())){
			sb.append("and (C_SH_ApplyWhole.C_SH_AW_outDepartmentId=? or C_SH_ApplyWhole.C_SH_AW_inDepartmentId=?) ");
			params.add(departmentsPo.getBdpdepartmentid());
			params.add(departmentsPo.getBdpdepartmentid());
			
		}
		if(!"".equals(Utility.getName(po.getCshawbillid()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshawbillid());
		}
		if(!"".equals(Utility.getName(po.getCshawoutdepartmentid()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_outDepartmentId=? ");
			params.add(po.getCshawoutdepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshawstartTime())) && !"".equals(Utility.getName(po.getCshawendTime()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) >= ? ");
			params.add(po.getCshawstartTime());
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) <= ? ");
			params.add(po.getCshawendTime());
		}else if(!"".equals(Utility.getName(po.getCshawstartTime())) && "".equals(Utility.getName(po.getCshawendTime()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) >= ? ");
			params.add(po.getCshawstartTime());
			
		}else if("".equals(Utility.getName(po.getCshawstartTime())) && !"".equals(Utility.getName(po.getCshawendTime()))){
			sb.append("and convert(varchar(10), C_SH_ApplyWhole.C_SH_AW_billDate, 23) <= ? ");
			params.add(po.getCshawendTime());
		}
		if(!"".equals(Utility.getName(po.getCshawauditstate()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_auditState=? ");
			params.add(po.getCshawauditstate());
		}
		if(!"".equals(Utility.getName(po.getCshawconsignstate()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_consignState=? ");
			params.add(po.getCshawconsignstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshawcreateperson()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_createPerson like '%'+?+'%' ");
			params.add(po.getCshawcreateperson());
		}
		if(!"".equals(Utility.getName(po.getCshawauditperson()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_auditPerson like '%'+?+'%' ");
			params.add(po.getCshawauditperson());
		}
		if(!"".equals(Utility.getName(po.getCshawconsignee()))){
			sb.append("and C_SH_ApplyWhole.C_SH_AW_consignee like '%'+?+'%' ");
			params.add(po.getCshawconsignee());
		}
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), WholePo.class);
	}
	
	/**
	 * 新增调拨单
	 */
	public void insertWhole(WholePo po) {
		
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		sb1.append("insert into C_SH_ApplyWhole(C_SH_AW_billID,C_SH_AW_billDate,C_SH_AW_inDepartmentId,");
		sb1.append("C_SH_AW_createPerson,C_SH_AW_auditState,C_SH_AW_remark,C_SH_AW_flag,C_SH_AW_ForAppFlag,C_SH_AW_outDepartmentId ");
		sb1.append(",C_SH_AW_goodscategory ");
		sb2.append("?,getdate(),?,?,?,?,");
		sb2.append("?,1,?,? ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getCshawbillid()));
		params.add(Utility.getName(po.getCshawindepartmentid()));
		params.add(Utility.getName(po.getCshawcreateperson()));
		params.add(Utility.getName(po.getCshawauditstate()));
		params.add(Utility.getName(po.getCshawremark()));
		params.add(Utility.getName(po.getCshawflag()));
		params.add(Utility.getName(po.getCshawoutdepartmentid()));
		params.add(Utility.getName(po.getGoodscategoryid()));
		
		if(!"".equals(Utility.getName(po.getCshawauditperson()))){
			sb1.append(",C_SH_AW_auditPerson,C_SH_AW_auditDate");
			sb2.append(",?,getdate()");
			params.add(po.getCshawauditperson());
		}		
		
		String sql=sb1.toString()+")values("+sb2.toString()+")";
		getJdbcTemplate().update(sql,params.toArray());
		
	}
	
	/**
	 * 调拨明细新增
	 */
	public void insertWholeEntry(WholeEntryPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		sb.append("insert into C_SH_ApplyWholeEntry(C_SH_AWE_ID,C_SH_AWE_billId,C_SH_AWE_goodsId");
		sb.append(",C_SH_AWE_requirementQuantity)values");
		sb.append("(?,?,?,?)");
		params.add(this.uuid.generate());
		params.add(po.getCshawebillid());
		params.add(po.getCshawegoodsid());
		params.add(po.getCshawerequirementquantity());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 更改调拨单 
	 */
	public void updateWhole(WholePo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("update C_SH_ApplyWhole set C_SH_AW_inDepartmentId=?,");
		sb.append("C_SH_AW_auditState=?,C_SH_AW_remark=? ");
		params.add(po.getCshawindepartmentid());
		params.add(po.getCshawauditstate());
		params.add(po.getCshawremark());
		if(!"".equals(Utility.getName(po.getCshawauditperson()))){
			sb.append(",C_SH_AW_auditPerson=?,C_SH_AW_auditDate=getdate() ");
			params.add(po.getCshawauditperson());
		}
		sb.append(" where C_SH_AW_billID=?");
		params.add(po.getCshawbillid());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除调拨单
	 */
	public void deleteWhole(WholePo po) {
		
		String sql="delete from C_SH_ApplyWhole where C_SH_AW_billID=?";	
		List<String> params = new ArrayList<String>();
		params.add(po.getCshawbillid());
		getJdbcTemplate().update(sql,params.toArray());
	}
	
	/**
	 * 删除调拨明细
	 */
	public void deleteWholeEntry(WholePo po) {
		
		String sql="delete from C_SH_ApplyWholeEntry where C_SH_AWE_billId=?";	
		List<String> params = new ArrayList<String>();
		params.add(po.getCshawbillid());
		getJdbcTemplate().update(sql,params.toArray());
	}
	
	/**
	 * 获取调拨单
	 */
	public WholePo getWhole(WholePo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT TOP 1 C_SH_ApplyWhole.C_SH_AW_billID          AS cshawbillid,");
		sb.append("             d.B_FS_StoreName 	                           AS cshawoutdepartmentname,");//申请部门名称
		sb.append("             dd.B_DP_DepartmentName                         AS cshawindepartmentname,");//接收部门名称
		sb.append("             d.B_FS_StoreID                            AS cshawoutdepartmentid,");
		sb.append("             a.personName                                   AS cshawcreatepersonname,");
		sb.append("             C_SH_ApplyWhole.C_SH_AW_billDate        AS cshawbilldate,");
		sb.append("             b.personName                                   AS cshawauditpersonname,");
		sb.append("             C_SH_ApplyWhole.C_SH_AW_createPerson    AS cshawcreateperson,");
		sb.append("             C_SH_ApplyWhole.C_SH_AW_auditPerson     AS cshawauditperson,");
		sb.append("             C_SH_ApplyWhole.C_SH_AW_auditDate       AS cshawauditdate,");
		sb.append("             C_SH_ApplyWhole.C_SH_AW_auditState      AS cshawauditstate,");
		 sb.append("            C_SH_ApplyWhole.C_SH_AW_remark          AS cshawremark,");
		sb.append("             C_SH_ApplyWhole.C_SH_AW_inDepartmentId  AS cshawindepartmentid,");//申请部门ID
		sb.append("             C_SH_ApplyWhole.C_SH_AW_outDepartmentId  AS cshawoutdepartmentid,");//接收部门ID
		sb.append("             C_SH_ApplyWhole.C_SH_AW_supplier        AS chaasupplier,");
		sb.append("             x.B_SP_SupplierName                            AS chaasuppliername,");
		sb.append("			    e.B_GC_GoodsCategoryName                       as goodscategoryname,");
		sb.append("			    e.B_GC_ID                                      as goodscategoryid ");
		sb.append("FROM   C_SH_ApplyWhole ");
		sb.append(" left join (select B_FS_StoreID,B_FS_StoreName from B_Franchisee)d on C_SH_ApplyWhole.C_SH_AW_inDepartmentId=d.B_FS_StoreID ");
		sb.append("       left JOIN (SELECT B_DP_DepartmentID,");
		sb.append("                          B_DP_DepartmentName");
		sb.append("                   FROM   B_Departments)dd");
		sb.append("        ON C_SH_ApplyWhole.C_SH_AW_outDepartmentId = dd.B_DP_DepartmentID ");
		sb.append("      LEFT JOIN (SELECT ID,");
		sb.append("                         personName");
		 sb.append("                 FROM   SYS_PersonInfo)a");
		 sb.append("        ON C_SH_ApplyWhole.C_SH_AW_createPerson = a.ID");
		 sb.append("      LEFT JOIN (SELECT B_SP_ID,");
		 sb.append("                        B_SP_SupplierName");
		 sb.append("                 FROM   B_Supplier)x");
		 sb.append("        ON C_SH_ApplyWhole.C_SH_AW_supplier = x.B_SP_ID");
		  sb.append("     LEFT JOIN (SELECT ID,");
		  sb.append("                       personName");
		  sb.append("                FROM   SYS_PersonInfo)b");
		  sb.append("       ON C_SH_ApplyWhole.C_SH_AW_auditPerson = b.ID");
		  sb.append("     LEFT JOIN (SELECT B_GC_ID,");
		  sb.append("                       B_GC_GoodsCategoryName");
		  sb.append("                FROM   B_GoodsCategory)e");
		  sb.append("       ON C_SH_ApplyWhole.C_SH_AW_goodscategory = e.B_GC_ID");
		  sb.append("      WHERE  C_SH_ApplyWhole.C_SH_AW_billID = ?");

		List<String> params = new ArrayList<String>();
		params.add(po.getCshawbillid());
		
		return (WholePo)queryForObject(sb.toString(), params.toArray(), WholePo.class);
	}
	/**
	 * 获取调拨明细
	 */
	public List<WholeEntryPo> getWholeEntryList(WholePo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT C_SH_ApplyWholeEntry.C_SH_AWE_billId                   AS cshawebillid, ");
		sb.append("       C_SH_ApplyWholeEntry.C_SH_AWE_goodsId                  AS cshawegoodsid, ");
		sb.append("       B_GoodsInfo.B_GI_GoodsBarCode                                AS cshawegoodsBarCode, ");
		sb.append("       B_GoodsInfo.B_GI_ViewGoodsName                                   AS cshawegoodsname, ");
		sb.append("       B_GoodsInfo.B_GI_Spec                                        AS cshawespec, ");
		sb.append("       SUM(C_SH_ApplyWholeEntry.C_SH_AWE_requirementQuantity) AS cshawerequirementquantity, ");
		sb.append("       B_GoodsInfo.B_GI_NotTaxRate                                  AS cshawenottaxrate, ");
		sb.append("       B_GoodsInfo.B_GI_TaxRate                                     AS cshawetaxrate, ");
		sb.append("       B_GoodsInfo.B_GI_CostPrice                                   AS cshawecostprice,");
		sb.append("       B_GoodsInfo.B_GI_RetailPrice                                 AS cshawebgiretailprice ");
		sb.append("FROM   C_SH_ApplyWholeEntry ");
		sb.append("       INNER JOIN B_GoodsInfo ");
		sb.append("         ON C_SH_ApplyWholeEntry.C_SH_AWE_goodsId = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("WHERE  C_SH_AWE_billId = ? ");
		sb.append("GROUP  BY C_SH_ApplyWholeEntry.C_SH_AWE_goodsId, ");
		sb.append("          C_SH_ApplyWholeEntry.C_SH_AWE_billId, ");
		sb.append("          B_GoodsInfo.B_GI_GoodsBarCode, ");
		sb.append("          B_GoodsInfo.B_GI_ViewGoodsName, ");
		sb.append("          B_GoodsInfo.B_GI_Spec, ");
		sb.append("          B_GoodsInfo.B_GI_NotTaxRate, ");
		sb.append("          B_GoodsInfo.B_GI_TaxRate, ");
		sb.append("         B_GoodsInfo.B_GI_CostPrice, ");
		sb.append("         B_GoodsInfo.B_GI_RetailPrice  ");
		
		params.add(po.getCshawbillid());
		return queryForObjectList(sb.toString(), params.toArray(), WholeEntryPo.class);
	}
	/**
	 * 调拨收货
	 */
	public void updateWholeReceive(WholePo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("update C_SH_ApplyWhole set C_SH_AW_consignee=?,C_SH_AW_consignState=?,C_SH_AW_consignDate=getdate() where C_SH_AW_billID=?");
		params.add(po.getCshawconsignee());
		params.add(po.getCshawconsignstate());
		params.add(po.getCshawbillid());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	/**
	 * 调拨后业务单据新增
	 */
	public void insertWholeForInventory(InventoryPo po) {
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
	public void insertWholeForInventoryEntry(InventoryEntryPo po) {
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
		sb.append("update C_SH_ApplyWhole set C_SH_AW_auditState='0',C_SH_AW_auditPerson='',C_SH_AW_auditDate=null where C_SH_AW_billID=?");
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
	
	public void insertWholeStatus(WholePo po) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into C_SHA_Status (C_SHA_StatusUUID,C_SHA_StatusApplyBillID) ");
		sb.append("values(?,?)");
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(po.getCshawbillid());
		
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void deleteWholeBarcode(WholePo wholePo) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from  C_SH_ApplyWholeBarcode ");
		sb.append("where C_SHA_B_billID=?");
		List<String> params = new ArrayList<String>();
		params.add(wholePo.getCshawbillid());
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public List<WholeBarcodePo> getWholeBarcode(WholePo wholePo){
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("select C_SHA_B_GoodsID as cshabgoodsid,C_SHA_B_GoodsBarcode as cshabgoodsbarcode from C_SH_ApplyWholeBarcode where C_SHA_B_billID=? and 1=1 ");
		params.add(wholePo.getCshawbillid());
		
		return queryForObjectList(sb.toString(), params.toArray(), WholeBarcodePo.class);
	}

	public List<WholeBarcodePo> getWholeBarcode(WholePo wholePo,String goodsID){
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("select C_SHA_B_GoodsID as cshabgoodsid,C_SHA_B_GoodsBarcode as cshabgoodsbarcode from C_SHA_WholeBarcode where C_SHA_B_billID=? and 1=1 ");
		params.add(wholePo.getCshawbillid());
		if(!"".equals(goodsID)){
			sb.append(" and C_SHA_B_GoodsID=? ");
			params.add(goodsID);//此处代表商品代码
		}
		
		return queryForObjectList(sb.toString(), params.toArray(), WholeBarcodePo.class);
	}
	
	//查询库存数量
	public int getWholeCount(WholePo wholePo) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(C_SH_SC_UUID) from C_SH_StorageChange ");
		sb.append("where C_SH_SC_ChangeID=?");
		List<String> params = new ArrayList<String>();
		params.add(wholePo.getCshawbillid());
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public void insertWholeBarcode(WholeBarcodePo wholeBarcodePo) {
		
		
	}
	
	

}
