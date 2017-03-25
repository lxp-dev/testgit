package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ProcessDistributionDaoImpl extends BaseJdbcDaoSupport implements
		com.pengsheng.eims.sales.dao.ProcessDistributionDao {

	/**
	 * 查询加工配送
	 */
	public List<SalesBasicPo> getSalesBasicPos(SalesBasicPo po) {
		
		StringBuffer buffer= new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('9') ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid, ");
		buffer.append("S_SE_SB_Location as ssesblocation, ");
		buffer.append("B_DP_DepartmentName as ssesbtakeshopname , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName, ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata, ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_Location = B_Departments.B_DP_DepartmentID  ");
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID  ");
		buffer.append("where S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) ");
		buffer.append("and S_SE_SB_OrdersType in ('1','2')  ");
		buffer.append("and ((S_SE_SB_ShopCode in  (select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) and isnull(S_SE_SB_ProcessDepartment,'')='') or S_SE_SB_ProcessDepartment=?) ");

		params.add(po.getSsesbshopcode());
		params.add(po.getSsesbshopcode());
		
		if(!"".equals(Utility.getName(po.getSsesbworrytype()))){
			buffer.append("and S_SE_SB_WorryType = ? ");
			params.add(po.getSsesbworrytype());
		}
		
		if(!"".equals(Utility.getName(po.getSsesblocation()))){
			buffer.append(" and S_SE_SB_Location = ? ");
			params.add(Utility.getName(po.getSsesblocation()));
		}
		
		if (!"".equals(Utility.getName(po.getSsesbtakeglassstartdata()))){
			buffer.append("and convert(varchar(10),S_SE_SB_TakeGlassData,120) >= ? ");
			params.add(Utility.getName(po.getSsesbtakeglassstartdata()));
		}
		if (!"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10),S_SE_SB_TakeGlassData,120) <= ? ");
			params.add(Utility.getName(po.getSsesbtakeglassenddata()));
		}
		if (!"".equals(Utility.getName(po.getSsesbsalesdatestarttime()))){
			buffer.append("and convert(varchar(10),S_SE_SB_PosDatetime,120) >= ? ");
			params.add(Utility.getName(po.getSsesbsalesdatestarttime()));
		}
		if (!"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10),S_SE_SB_PosDatetime,120) <= ? ");
			params.add(Utility.getName(po.getSsesbsalesdateendtime()));
		}
		if (!"".equals(Utility.getName(po.getSsesbMemberId()))){
			buffer.append("and S_ME_CI_MemberId = ? ");
			params.add(Utility.getName(po.getSsesbMemberId()));
		}
		if (!"".equals(Utility.getName(po.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSsesbpersonName()));
		}
		if (!"".equals(Utility.getName(po.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(Utility.getName(po.getSsesbsalesid()));
		}
		buffer.append("order by S_SE_SB_TakeGlassData desc ");
		
		buffer.append(" drop table #dpt ");
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesBasicPo.class);		
	}
	
	/**
	 * 查询门店
	 */
	public List<WarehousePo> getWarehouseList(SalesBasicPo po) {
		
		StringBuffer buffer= new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('9') ");
		buffer.append("select ");
		buffer.append("S_SE_SB_Location as bwhdeptid, ");
		buffer.append("B_DP_DepartmentName as bdpdepartmentname ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_Location = B_Departments.B_DP_DepartmentID  ");
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID  ");
		buffer.append("where S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) ");
		buffer.append("and S_SE_SB_OrdersType in ('1','2')  ");
		buffer.append("and ((S_SE_SB_ShopCode in  (select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) and isnull(S_SE_SB_ProcessDepartment,'')='') or S_SE_SB_ProcessDepartment=?) ");

		params.add(po.getSsesbshopcode());
		params.add(po.getSsesbshopcode());
		buffer.append("group by S_SE_SB_Location,B_DP_DepartmentName ");
		buffer.append("order by S_SE_SB_Location ");
	    
		buffer.append(" drop table #dpt ");
		
		return queryForObjectList(buffer.toString(), params.toArray(),WarehousePo.class);		
	}

	/**
	 * 查询门店
	 */
	public List<WarehousePo> getWarehouseList(DepartmentsPo po) {
		
		 StringBuffer buffer = new StringBuffer();
		 List<String> params = new ArrayList<String>();

		 buffer.append("select bwhdeptid as bwhdeptid, ");
		 buffer.append("bdpdepartmentname as bdpdepartmentname from ( ");		 
		 buffer.append("select B_DP_DepartmentID as bwhdeptid, ");
		 buffer.append("B_DP_DepartmentName as bdpdepartmentname ");
		 buffer.append("from B_Departments ");
		 buffer.append("where B_DP_DepartmentID in (select B_DP_DepartmentID from b_departments where B_DP_RegID=? and B_DP_IsClosed='0') ");
		 
		 params.add(po.getBdpdepartmentid());
		 
		 if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
		     buffer.append(" and B_DP_CompanysID = ? ");
			 params.add(Utility.getName(po.getBdpcompanysid()));	
		 }
			
		 buffer.append("union ");
		 buffer.append("select B_DP_DepartmentID as bwhdeptid, ");
		 buffer.append("B_DP_DepartmentName as bdpdepartmentname ");
		 buffer.append("from S_SE_SalesBasic inner join B_Departments on S_SE_SB_Location=B_DP_DepartmentID ");
		 buffer.append("where S_SE_SB_ProcessDepartment=? ");
		 
		 params.add(po.getBdpdepartmentid());
		 
		 if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
		     buffer.append(" and B_DP_CompanysID = ? ");
			 params.add(Utility.getName(po.getBdpcompanysid()));	
		 }
		 
		 buffer.append(" )t order by bwhdeptid ");	 
		 
		 return queryForObjectList(buffer.toString(), params.toArray(),WarehousePo.class);
	}

	/**
	 * 新增配送记录主表
	 */
	public String insertDistribution(DistributionPo distributionPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_DN_Distribution( ");
	    buffer.append("S_DN_DN_ID, ");
		buffer.append("S_DN_DN_Person, ");
		buffer.append("S_DN_DN_CreateDate, ");
		buffer.append("S_DN_DN_Type,S_DN_DN_LogonPerson,S_DN_DN_DepartmentID )  ");
		buffer.append("values(?,?,getdate(),?,?,?) ");
		List<String> params = new ArrayList<String>();
		params.add(distributionPo.getSdndnid());
		params.add(distributionPo.getSdndnPerson());
		params.add(distributionPo.getSdndntype());
		params.add(Utility.getName(distributionPo.getSdndnlogonperson()));
		params.add(Utility.getName(distributionPo.getSdndndepartmentid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		return params.get(0);
	}

	/**
	 * 新增配送记录明细表
	 */
	public void insertDistributionEntry(DistributionPo distributionPo,
			DistributionEntryPo distributionEntryPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_DN_DistributionEntry ( ");
		buffer.append("S_DN_DE_ID, ");
		buffer.append("S_DN_DE_DistributionID, ");
		buffer.append("S_DN_DE_SalesID, ");
		buffer.append("S_DN_DE_OrdersType ) ");
		buffer.append("select ?,?,?,S_SE_SB_OrdersType from S_SE_SalesBasic where S_SE_SB_SalesID=?");
        List<String> params = new ArrayList<String>();   
		params.add(uuid.getInstance().generate());       
		params.add(distributionEntryPo.getSdndedistributionid());       
		params.add(distributionEntryPo.getSdndesalesid());       
		params.add(distributionEntryPo.getSdndesalesid());   
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
		
	}

	/**
	 * 新增在途查询明细表
	 */
	public void insertInTransit(InTransitPo inTransitPo) {
		
        StringBuffer buffer = new StringBuffer();
		
		buffer.append("insert into S_SE_InTransit ");
		buffer.append("(S_SE_IT_ID, ");
		buffer.append("S_SE_IT_SalesID, ");
		buffer.append("S_SE_IT_State,  ");
		buffer.append("S_SE_IT_Date, ");
		buffer.append("S_SE_IT_CreatePerson, ");
		buffer.append("S_SE_IT_Department)  ");
		buffer.append("values (?,?,'10',getdate(),?,?) ");
		List<String> params = new ArrayList<String>();
	    params.add(uuid.getInstance().generate());
	    params.add(inTransitPo.getSseitsalesid());
	    params.add(inTransitPo.getSseitcreateperson());
	    params.add(inTransitPo.getSseitdepartment());
		
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}

	/**
	 * 修改加工配送状态
	 */
	public void updateSalesBasicPos(SalesBasicPo salesBasicPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update S_SE_SalesBasic set  ");
		buffer.append("S_SE_SB_InTransit='10' ");
		buffer.append("where S_SE_SB_SalesID= ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(salesBasicPo.getSsesbsalesid());
		
	    getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}

}
