package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentTypePo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.system.dao.DepartmentsDao;
import com.pengsheng.eims.system.persistence.BrankCardPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class DepartmentsDaoImpl extends BaseJdbcDaoSupport implements
		DepartmentsDao {

	/**
	 * 查询部门表所有信息
	 */
	public List<DepartmentsPo> getAllDepartments(DepartmentsPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag,isnull(B_DP_KqDptID,'') as bdpkqDptID ");
		buffer.append("FROM B_Departments ");

		buffer.append("where B_DP_IsClosed=0 ");
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));	
		}
		
		buffer.append(" order by B_DP_DepartmentID");

		return queryForObjectList(buffer.toString(),params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 查询部门表所有信息
	 */
	public List<DepartmentsPo> getAllDepartments() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag,isnull(B_DP_KqDptID,'') as bdpkqDptID ");
		buffer.append("FROM B_Departments ");

		buffer.append("where B_DP_IsClosed=0 order by B_DP_DepartmentID");

		return queryForObjectList(buffer.toString(), null, DepartmentsPo.class);
	}
	
	/**
	 * 查询部门表所有信息
	 */
	public List<DepartmentsPo> getDepartments(DepartmentsPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag,isnull(B_DP_KqDptID,'') as bdpkqDptID ");
		buffer.append("FROM B_Departments ");
		buffer.append("inner join (select distinct(B_WH_deptID) as B_WH_deptID from B_Warehouse where B_WH_IsClosed='0') bw on bw.B_WH_deptID = B_DP_DepartmentID ");

		buffer.append("where B_DP_IsClosed=0 ");
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBdptype()))){
		    buffer.append(" and B_DP_Type = ? ");
			params.add(Utility.getName(po.getBdptype()));	
		}
		
		buffer.append(" order by B_DP_DepartmentID");

		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	public List<DepartmentsPo> getDepartments2(DepartmentsPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag,isnull(B_DP_KqDptID,'') as bdpkqDptID ");
		buffer.append("FROM B_Departments ");
		buffer.append("left join (select distinct(B_WH_deptID) as B_WH_deptID from B_Warehouse where B_WH_IsClosed='0') bw on bw.B_WH_deptID = B_DP_DepartmentID ");

		buffer.append("where B_DP_IsClosed=0 ");
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBdptype()))){
		    buffer.append(" and B_DP_Type = ? ");
			params.add(Utility.getName(po.getBdptype()));	
		}
		
		buffer.append(" order by B_DP_DepartmentID");

		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 查询部门表所有信息
	 */
	public List<DepartmentsPo> getDepartments() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag,isnull(B_DP_KqDptID,'') as bdpkqDptID ");
		buffer.append("FROM B_Departments ");
		buffer.append("inner join (select distinct(B_WH_deptID) as B_WH_deptID from B_Warehouse where B_WH_IsClosed='0') bw on bw.B_WH_deptID = B_DP_DepartmentID ");

		buffer.append("where B_DP_IsClosed=0 order by B_DP_DepartmentID");

		return queryForObjectList(buffer.toString(), null, DepartmentsPo.class);
	}
	
	/**
	 * 查询部门表所有信息
	 */
	public List<DepartmentsPo> getDepartmentwheres(DepartmentsPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT ");
		buffer.append("B_DP_DepartmentID 			as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  		as BDPDepartmentName ");
		buffer.append(",B_DP_Type 					as bdptype ");
		buffer.append(",B_DP_WizardFlag 			as bdpwizardflag  ");
		buffer.append(",isnull(B_DP_WhichRetail,'') as bdpwhichretail  ");
		buffer.append(",F_CN_MasterOrVice 			as bdpcompanystype  ");
		buffer.append(",isnull(F_CN_CompanyType,'1') as bdpcompanynature  ");
		buffer.append(",isnull(B_DP_CompanysID,'') as bdpcompanysid  ");
		buffer.append("FROM B_Departments ");
		buffer.append("inner join (select distinct(B_WH_deptID) as B_WH_deptID from B_Warehouse where B_WH_IsClosed='0') bw on bw.B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("left join F_CompanyName on F_CN_ID = B_DP_CompanysID ");
		buffer.append(" where B_DP_IsClosed=0 ");
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));	
		}
		
		buffer.append(" order by B_DP_DepartmentID");

		return queryForObjectList(buffer.toString(),params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 查询部门表所有信息根据条件
	 */
	public List<DepartmentsPo> getDepartments(String departmenttype) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_TakeGlassDate as bdptakeglassdate ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag ");
		buffer.append(",isnull(F_CN_CompanyType,'1') as bdpcompanynature  ");
		buffer.append(",isnull(B_DP_CompanysID,'') as bdpcompanysid  ");
		buffer.append("FROM B_Departments ");
		buffer.append(" left join F_CompanyName on B_DP_CompanysID = F_CN_ID ");
		buffer.append("where  B_DP_IsClosed = '0' ");
		
		List<String> params = new ArrayList<String>();
		buffer.append(" AND B_DP_Type = ? ");
		params.add(departmenttype);
	
		buffer.append(" order by B_DP_DepartmentID");

		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 查询部门表所有信息根据条件
	 */
	public List<DepartmentsPo> getDepartments(String[] departmenttype, String isClosed, String companyID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_TakeGlassDate as bdptakeglassdate ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag ");
		buffer.append(",isnull(F_CN_CompanyType,'') as bdpcompanynature ");
		buffer.append(",isnull(B_DP_CompanysID,'') as bdpcompanysid ");
		buffer.append("FROM B_Departments inner join F_CompanyName on B_DP_CompanysID = F_CN_ID ");
		buffer.append(" where 1=1 ");
		List<String> params = new ArrayList<String>();
		
		StringBuffer sb = new StringBuffer();
		if(null != departmenttype) {
			sb.append("(");
			String str = "";
			for (int i = 0; i < departmenttype.length; i++) {
				str += "'" + departmenttype[i] + "',";
			}
			sb.append(str.substring(0, str.length()-1) + ")");
			buffer.append(" AND B_DP_Type IN " + sb.toString());
		}
		if(null != isClosed) {
			buffer.append(" AND B_DP_IsClosed = ? ");
			params.add(isClosed);
		}
		
		if (!Utility.getName(companyID).equals("")){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(companyID));
		}		
		
		buffer.append(" order by B_DP_DepartmentID");

		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 取所有部门根据本门类型
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartments(String departmenttype,String isclosed){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_TakeGlassDate as bdptakeglassdate ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag ");
		buffer.append("FROM B_Departments");
		buffer.append(" where B_DP_Type=? and B_DP_IsClosed=? ");
		buffer.append(" order by B_DP_DepartmentID");
		
		params.add(departmenttype);
		params.add(isclosed);

		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 条件查询部门信息
	 */

	public DepartmentsPo getDepartment(DepartmentsPo departmentsPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  "); 
		buffer.append("a.B_DP_DepartmentID 			as bdpdepartmentid, ");
		buffer.append("a.B_DP_CompanyName 			as bdpcompanyname ");
		buffer.append(",a.B_DP_DepartmentName  		as bdpdepartmentname ");
		buffer.append(",a.B_DP_Type 				as bdptype ");
		buffer.append(",a.B_DP_RegID 				as bdpregid ");
		buffer.append(",a.B_DP_IsClosed 			as bdpisclosed ");
		buffer.append(",a.B_DP_Phone 				as bdpphone ");
		buffer.append(",a.B_DP_Person 				as bdpperson ");
		buffer.append(",b.B_DP_DepartmentName 		as bdpregname ");
		buffer.append(",SYS_PersonInfo.personName 	as bdppersonname ");
		buffer.append(",a.B_DP_Address 				as bdpaddress ");
		buffer.append(",a.B_DP_FullName 			as bdpfullname ");
		buffer.append(",a.B_DP_TakeGlassDate 		as bdptakeglassdate ");
		buffer.append(",a.B_DP_BankCard 			as bdpbankcard ");
		buffer.append(",a.B_DP_SalesType 			as bdpsalestype ");
		buffer.append(",B_BC_Name 					as bdpbankcardname ");
		buffer.append(",a.B_DP_WhichRetail  		as bdpwhichretail ");
		buffer.append(",isnull(a.B_DP_StealthFlag,'') as bdpstealthflag ");
		buffer.append(",isnull(a.B_DP_PrintHistoryFlag,'') as bdpprintmedicalhistory ");
		buffer.append(",isnull(a.B_DP_KqDptID,'') 	as bdpkqDptID ");
		buffer.append(",Isnull(a.B_DP_CloseDate, '') AS bdpclosedate ");		
		buffer.append(",a.B_DP_CompanysID 			AS bdpcompanysid ");
		buffer.append(",F_CN_Name 					AS bdpcompanysname ");
		buffer.append(",B_DT_Name 					AS bdptypename ");		
		buffer.append(",a.B_DP_QcDate 				AS bdpqcdate ");
		buffer.append(",a.B_DP_OnlineDate 			AS bdponlinedatre ");		
		buffer.append(",isnull(a.B_DP_LinkHisFlag,'') 			AS bdplinkhisflag ");
		buffer.append(",isnull(a.B_DP_LinkHis,'') 			    AS bdplinkhis ");
		buffer.append(",isnull(a.B_DP_NotPayFeeForm,'') 	    AS bdpnotpayfeeform ");
		buffer.append(",isnull(a.B_DP_ReadCardForm,'') 			AS bdpreadcardform ");
		buffer.append(",isnull(a.B_DP_ChargingItemID,'') 		AS bdpchargingitemid ");
		buffer.append(",isnull(B_H_HisName,'') 			        AS bdplinkhisname ");
		buffer.append(",isnull(B_H_HisUrl,'') 			    AS bdplinkhisurl ");
		buffer.append(",isnull(F_CN_CompanyType,'1') as bdpcompanynature  ");
		buffer.append(" FROM B_Departments a ");
		buffer.append(" left join SYS_PersonInfo on a.B_DP_Person=id ");
		buffer.append(" left join B_Departments b on a.B_DP_RegID=b.B_DP_DepartmentID ");
		buffer.append(" left join B_BrankCard on B_BC_ID=a.B_DP_BankCard ");
		buffer.append(" left join F_CompanyName on a.B_DP_CompanysID = F_CN_ID ");
		buffer.append(" left join B_DepartmentType on a.B_DP_Type = B_DT_ID ");
		buffer.append(" left join B_His on a.B_DP_LinkHis = B_H_ID ");
		
		buffer.append(" WHERE 1 = 1 ");
		
		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(departmentsPo.getBdpdepartmentid()))) {
			buffer.append("AND a.B_DP_DepartmentID = ? ");
			params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));
		}

		if (!"".equals(Utility.getName(departmentsPo.getBdptype()))) {
			buffer.append("AND a.B_DP_Type = ? ");
			params.add(Utility.getName(departmentsPo.getBdptype()));
		}
		
		if (!"".equals(Utility.getName(departmentsPo.getBdpcompanysid()))) {
			buffer.append("AND a.B_DP_CompanysID = ? ");
			params.add(Utility.getName(departmentsPo.getBdpcompanysid()));
		}
		
		return (DepartmentsPo) queryForObject(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 添加部门
	 */
	public void insertDepartment(DepartmentsPo departmentsPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO B_Departments ");
		buffer.append("(B_DP_DepartmentID ");
		buffer.append(",B_DP_CompanyName");
		buffer.append(",B_DP_DepartmentName ");
		buffer.append(",B_DP_Type ");
		buffer.append(",B_DP_RegID ");
		buffer.append(",B_DP_WizardFlag,B_DP_IsClosed,B_DP_Phone,B_DP_Person,B_DP_Address,B_DP_FullName,B_DP_TakeGlassDate,B_DP_BankCard,B_DP_SalesType ");
		buffer.append(",B_DP_WhichRetail,B_DP_StealthFlag,B_DP_PrintHistoryFlag,B_DP_CloseDate,B_DP_CompanysID,B_DP_QcDate,B_DP_OnlineDate,B_DP_ReadCardForm,B_DP_LinkHisFlag) ");
		buffer.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,? ,?,convert(varchar(10),getdate(),120) + ' 00:00',convert(varchar(10),getdate(),120) + ' 00:00',?,'0'  ) ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));
		params.add(Utility.getName(departmentsPo.getBdpcompanyname()));
		params.add(Utility.getName(departmentsPo.getBdpdepartmentname()));
		params.add(Utility.getName(departmentsPo.getBdptype()));
		params.add(Utility.getName(departmentsPo.getBdpregid()));
		params.add(Utility.getName(departmentsPo.getBdpwizardflag()));
		params.add(Utility.getName(departmentsPo.getBdpisclosed()));
		params.add(Utility.getName(departmentsPo.getBdpphone()));
		params.add(Utility.getName(departmentsPo.getBdpperson()));
		params.add(Utility.getName(departmentsPo.getBdpaddress()));
		params.add(Utility.getName(departmentsPo.getBdpfullname()));
		params.add(Utility.getName(departmentsPo.getBdptakeglassdate()));
		params.add(Utility.getName(departmentsPo.getBdpbankcard()));
		params.add(Utility.getName(departmentsPo.getBdpsalestype()));
		params.add(Utility.getName(departmentsPo.getBdpwhichretail()));
		params.add(Utility.getName(departmentsPo.getBdpstealthflag()));
		params.add(Utility.getName(departmentsPo.getBdpprintmedicalhistory()));
		params.add(Utility.getName(departmentsPo.getBdpclosedate()));
		params.add(Utility.getName(departmentsPo.getBdpcompanysid()));
		params.add(Utility.getName(departmentsPo.getBdpreadcardform()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新部门
	 */
	public void updateDepartment(DepartmentsPo departmentsPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>(); 
		
		buffer.append("UPDATE B_Departments ");
		buffer.append("SET B_DP_DepartmentName = ?,B_DP_CompanyName= ?");
		buffer.append(",B_DP_IsClosed = ? ,B_DP_Phone=?,B_DP_Person=?,B_DP_RegID=?,B_DP_Address=?,B_DP_FullName=?,B_DP_TakeGlassDate=?,B_DP_BankCard=?,B_DP_SalesType=? ");
		buffer.append(",B_DP_WhichRetail=?,B_DP_StealthFlag = ?,B_DP_PrintHistoryFlag = ?,B_DP_CloseDate=?,B_DP_CompanysID=? ");
		
		if (!"".equals(Utility.getName(departmentsPo.getBdpkqDptID()))){
			buffer.append(",B_DP_KqDptID = ? ");
		}
		
		buffer.append(",B_DP_ReadCardForm = ? ");
		
		buffer.append("WHERE B_DP_DepartmentID = ?");	

		params.add(departmentsPo.getBdpdepartmentname());
		params.add(departmentsPo.getBdpcompanyname());
		params.add(departmentsPo.getBdpisclosed());
		params.add(departmentsPo.getBdpphone());
		params.add(departmentsPo.getBdpperson());		
		params.add(Utility.getName(departmentsPo.getBdpregid()));	
		params.add(Utility.getName(departmentsPo.getBdpaddress()));	
		params.add(Utility.getName(departmentsPo.getBdpfullname()));
		params.add(Utility.getName(departmentsPo.getBdptakeglassdate()));
		params.add(Utility.getName(departmentsPo.getBdpbankcard()));
		params.add(Utility.getName(departmentsPo.getBdpsalestype()));
		params.add(Utility.getName(departmentsPo.getBdpwhichretail()));
		params.add(Utility.getName(departmentsPo.getBdpstealthflag()));
		params.add(Utility.getName(departmentsPo.getBdpprintmedicalhistory()));
		params.add(Utility.getName(departmentsPo.getBdpclosedate()));		
		params.add(Utility.getName(departmentsPo.getBdpcompanysid()));
		
		if (!"".equals(Utility.getName(departmentsPo.getBdpkqDptID()))){
			params.add(Utility.getName(departmentsPo.getBdpkqDptID()));
		}

		params.add(Utility.getName(departmentsPo.getBdpreadcardform()));
		params.add(departmentsPo.getBdpdepartmentid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 初始化各部门打印单据为系统默认设置模版
	 */
	public void updateDepartmentDefaultBill() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("UPDATE B_Departments ");
		buffer.append("SET B_DP_KjID = '',B_DP_YxID='',B_DP_FlID='',B_DP_DjdID='',B_DP_GhdID='',B_DP_TKjID='',B_DP_TYxID='',B_DP_TFlID=''");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 删除部门
	 */
	public void deleteDepartment(String departmentID) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM B_Departments ");
		buffer.append("WHERE B_DP_DepartmentID = ?");

		List<String> params = new ArrayList<String>();
		params.add(departmentID);

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}
	
	/**
	 * 查询区域门店的类型（加工、门店、仓储）
	 */
	public List<DepartmentsPo> getDepartmentsForRegional(DepartmentsPo po) {

		String sql="select B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName  as bdpdepartmentname,isnull(F_CN_CompanyType,'') as bdpcompanynature,isnull(B_DP_CompanysID,'') as bdpcompanysid from B_Departments inner join F_CompanyName on B_DP_CompanysID = F_CN_ID where B_DP_RegID='"+po.getBdpdepartmentid()+"'";
		
		return queryForObjectList(sql, null, DepartmentsPo.class);
	}
	
	/**
	 * 查询是仓储的ID、名字
	 */
	public DepartmentsPo getDepartmentForStorage() {
		String sql="select top 1 B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName  as bdpdepartmentname from B_Departments where B_DP_Type='3'";
		return (DepartmentsPo) queryForObject(sql, null, DepartmentsPo.class);
	}

	/**
	 * 查询部门的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getDepartmentCount(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(a.B_DP_DepartmentID) ");
		buffer.append("  from B_Departments a left join B_Departments b on a.B_DP_RegID=b.B_DP_DepartmentID where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getBdpdepartmentid()))){
			buffer.append("and a.B_DP_DepartmentID = ? ");
			params.add(Utility.getName(po.getBdpdepartmentid()));
		}
		if (!"".equals(Utility.getName(po.getBdpdepartmentname()))){
			buffer.append("and a.B_DP_DepartmentName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBdpdepartmentname()));
		}
		if (!"".equals(Utility.getName(po.getBdptype()))){
			buffer.append("and a.B_DP_Type=? ");
			params.add(Utility.getName(po.getBdptype()));
		}
		if (!"".equals(Utility.getName(po.getBdpregid()))){
			buffer.append("and a.B_DP_RegID=? ");
			params.add(Utility.getName(po.getBdpregid()));
		}
		if (!"".equals(Utility.getName(po.getBdpisclosed()))){
			buffer.append("and a.B_DP_IsClosed=? ");
			params.add(Utility.getName(po.getBdpisclosed()));
		}
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
			buffer.append("and a.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询部门列表
	 * 
	 * @param po
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentList(DepartmentsPo po,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("SELECT * from ( ");
		
		buffer.append("select ROW_NUMBER() Over(order by a.B_DP_DepartmentID) as rowNum,a.B_DP_DepartmentID as bdpdepartmentid,a.B_DP_IsClosed as bdpisclosed,");
		buffer.append("       a.B_DP_DepartmentName as bdpdepartmentname,a.B_DP_Type as bdptype,b.B_DP_DepartmentName as bdpregname,a.B_DP_StealthFlag as bdpstealthflag,isnull(a.B_DP_KqDptID,'') as bdpkqDptID  ");
		buffer.append("  	  ,a.B_DP_CompanysID 	as bdpcompanysid ");
		buffer.append("  	  ,F_CN_Name 			as bdpcompanysname ");
		buffer.append("  	  ,B_DT_Name 			as bdptypename ");		
		buffer.append("  	  ,isnull(a.B_DP_OnlineDate,'') 	as bdponlinedatre ");
		buffer.append("  	  ,isnull(a.B_DP_QcDate,'')  		as bdpqcdate ");
		buffer.append("  from B_Departments a ");
		buffer.append("  left join B_Departments b on a.B_DP_RegID=b.B_DP_DepartmentID ");
		buffer.append("  left join F_CompanyName on a.B_DP_CompanysID = F_CN_ID ");
		buffer.append("  left join B_DepartmentType on a.B_DP_Type = B_DT_ID ");
		buffer.append("  	  where 1=1 ");

		if (!"".equals(Utility.getName(po.getBdpdepartmentid()))){
			buffer.append("and a.B_DP_DepartmentID = ? ");
			params.add(Utility.getName(po.getBdpdepartmentid()));
		}
		if (!"".equals(Utility.getName(po.getBdpdepartmentname()))){
			buffer.append("and a.B_DP_DepartmentName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBdpdepartmentname()));
		}
		if (!"".equals(Utility.getName(po.getBdptype()))){
			buffer.append("and a.B_DP_Type=? ");
			params.add(Utility.getName(po.getBdptype()));
		}
		if (!"".equals(Utility.getName(po.getBdpregid()))){
			buffer.append("and a.B_DP_RegID=? ");
			params.add(Utility.getName(po.getBdpregid()));
		}
		if (!"".equals(Utility.getName(po.getBdpisclosed()))){
			buffer.append("and a.B_DP_IsClosed=? ");
			params.add(Utility.getName(po.getBdpisclosed()));
		}
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
			buffer.append("and a.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));
		}
		
		buffer.append(" ) temp where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 设置默认仓位
	 * 
	 * @param po
	 * @return
	 */
	public int getDefaultWarehouseByDptCount(WarehouseConfigurationPo warehouseConfigurationPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(B_DW_deptID) from B_DefaultWarehouse where B_DW_deptID=? ");

		params.add(Utility.getName(warehouseConfigurationPo.getBwcdeptid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 修改默认仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public void updateDefaultWarehouse(WarehouseConfigurationPo warehouseConfigurationPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_DefaultWarehouse set B_DW_StockID1=?,B_DW_StockID2=?,B_DW_StockID3=?,");
		buffer.append("B_DW_StockID4=?,B_DW_StockID5=?,B_DW_StockID6=?,B_DW_StockID7=?,B_DW_StockID8=?,B_DW_StockID9=?,");
		buffer.append("B_DW_StockID10=?,B_DW_StockID11=? ");
		buffer.append("  where B_DW_deptID=? ");
				
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid1()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid2()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid3()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid4()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid5()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid6()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid7()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid8()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid9()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid10()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid11()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcdeptid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增默认仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public void insertDefaultWarehouse(WarehouseConfigurationPo warehouseConfigurationPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into B_DefaultWarehouse(B_DW_deptID,B_DW_StockID1,B_DW_StockID2,B_DW_StockID3,");
		buffer.append("B_DW_StockID4,B_DW_StockID5,B_DW_StockID6,B_DW_StockID7,B_DW_StockID8,B_DW_StockID9,");
		buffer.append("B_DW_StockID10,B_DW_StockID11) ");
		buffer.append("  values(?,?,?,?,?,?,?,?,?,?,?,?) ");
		
		params.add(Utility.getName(warehouseConfigurationPo.getBwcdeptid()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid1()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid2()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid3()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid4()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid5()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid6()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid7()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid8()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid9()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid10()));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcstockid11()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取默认仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public WarehouseConfigurationPo getDefaultWarehouseByDpt(WarehouseConfigurationPo warehouseConfigurationPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 isnull(B_DW_StockID1,'') as bwcstockid1,isnull(B_DW_StockID2,'') as bwcstockid2,B_DW_StockID3 as bwcstockid3,B_DW_StockID4 as bwcstockid4,");
		buffer.append("B_DW_StockID5 as bwcstockid5,B_DW_StockID6 as bwcstockid6,B_DW_StockID7 as bwcstockid7,B_DW_StockID8 as bwcstockid8,");
		buffer.append("B_DW_StockID9 as bwcstockid9,B_DW_StockID10 as bwcstockid10,B_DW_StockID11 as bwcstockid11, ");
		
		buffer.append("a.B_WH_warehouseName as bwcstockname1,b.B_WH_warehouseName as bwcstockname2 ");
		
		buffer.append(" from B_DefaultWarehouse  ");
		buffer.append(" left join B_Warehouse a on B_DW_StockID1=a.B_WH_ID ");
		buffer.append(" left join B_Warehouse b on B_DW_StockID2=b.B_WH_ID ");
		
		buffer.append(" where B_DW_deptID=? ");
		
		params.add(Utility.getName(warehouseConfigurationPo.getBwcdeptid()));
		
		return (WarehouseConfigurationPo) queryForObject(buffer.toString(), params.toArray(), WarehouseConfigurationPo.class);
	}
	
	/**
	 * 获取默认仓位名称
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public WarehouseConfigurationPo getDefaultWarehouse(WarehouseConfigurationPo warehouseConfigurationPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 isnull(a.B_WH_warehouseName,'') as bwcstockname1,isnull(b.B_WH_warehouseName,'') as bwcstockname2,c.B_WH_warehouseName as bwcstockname3,d.B_WH_warehouseName as bwcstockname4,");
		buffer.append("e.B_WH_warehouseName as bwcstockname5,f.B_WH_warehouseName as bwcstockname6,g.B_WH_warehouseName as bwcstockname7,h.B_WH_warehouseName as bwcstockname8,");
		buffer.append("i.B_WH_warehouseName as bwcstockname9,j.B_WH_warehouseName as bwcstockname10,k.B_WH_warehouseName as bwcstockname11, ");
		buffer.append("B_DW_StockID1 as bwcstockid1,B_DW_StockID2 as bwcstockid2,B_DW_StockID3 as bwcstockid3,B_DW_StockID4 as bwcstockid4,");
		buffer.append("B_DW_StockID5 as bwcstockid5,B_DW_StockID6 as bwcstockid6,B_DW_StockID7 as bwcstockid7,B_DW_StockID8 as bwcstockid8,");
		buffer.append("B_DW_StockID9 as bwcstockid9,B_DW_StockID10 as bwcstockid10,B_DW_StockID11 as bwcstockid11 ");
		
		buffer.append(" from B_DefaultWarehouse  ");
		buffer.append(" left join B_Warehouse a on B_DW_StockID1=a.B_WH_ID ");
		buffer.append(" left join B_Warehouse b on B_DW_StockID2=b.B_WH_ID ");
		buffer.append(" left join B_Warehouse c on B_DW_StockID3=c.B_WH_ID ");
		buffer.append(" left join B_Warehouse d on B_DW_StockID4=d.B_WH_ID ");
		buffer.append(" left join B_Warehouse e on B_DW_StockID5=e.B_WH_ID ");
		buffer.append(" left join B_Warehouse f on B_DW_StockID6=f.B_WH_ID ");
		buffer.append(" left join B_Warehouse g on B_DW_StockID7=g.B_WH_ID ");
		buffer.append(" left join B_Warehouse h on B_DW_StockID8=h.B_WH_ID ");
		buffer.append(" left join B_Warehouse i on B_DW_StockID9=i.B_WH_ID ");
		buffer.append(" left join B_Warehouse j on B_DW_StockID10=j.B_WH_ID ");
		buffer.append(" left join B_Warehouse k on B_DW_StockID11=k.B_WH_ID ");
		
		buffer.append(" where B_DW_deptID=? ");
		
		params.add(Utility.getName(warehouseConfigurationPo.getBwcdeptid()));
		
		return (WarehouseConfigurationPo) queryForObject(buffer.toString(), params.toArray(), WarehouseConfigurationPo.class);
	}	
	
	/**
	 * 获取出仓仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public WarehouseConfigurationPo getOutWarehouseByDpt(WarehouseConfigurationPo warehouseConfigurationPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 a.B_WH_warehouseName as bwcstockname1,b.B_WH_warehouseName as bwcstockname2,c.B_WH_warehouseName as bwcstockname3,d.B_WH_warehouseName as bwcstockname4,");
		buffer.append("e.B_WH_warehouseName as bwcstockname5,f.B_WH_warehouseName as bwcstockname6,g.B_WH_warehouseName as bwcstockname7,h.B_WH_warehouseName as bwcstockname8,");
		buffer.append("i.B_WH_warehouseName as bwcstockname9,j.B_WH_warehouseName as bwcstockname10,k.B_WH_warehouseName as bwcstockname11,l.B_WH_warehouseName as bwcstockname12,m.B_WH_warehouseName as bwcstockname13,n.B_WH_warehouseName as bwcstockname14,B_WC_xiaocangzp as bwcxiaocangzp,B_WC_xiaocangww as bwcxiaocangww ");
		
		buffer.append(" from B_WarehouseConfiguration  ");
		buffer.append(" left join B_Warehouse a on B_WC_StockID1=a.B_WH_ID ");
		buffer.append(" left join B_Warehouse b on B_WC_StockID2=b.B_WH_ID ");
		buffer.append(" left join B_Warehouse c on B_WC_StockID3=c.B_WH_ID ");
		buffer.append(" left join B_Warehouse d on B_WC_StockID4=d.B_WH_ID ");
		buffer.append(" left join B_Warehouse e on B_WC_StockID5=e.B_WH_ID ");
		buffer.append(" left join B_Warehouse f on B_WC_StockID6=f.B_WH_ID ");
		buffer.append(" left join B_Warehouse g on B_WC_StockID7=g.B_WH_ID ");
		buffer.append(" left join B_Warehouse h on B_WC_StockID8=h.B_WH_ID ");
		buffer.append(" left join B_Warehouse i on B_WC_StockID9=i.B_WH_ID ");
		buffer.append(" left join B_Warehouse j on B_WC_StockID10=j.B_WH_ID ");
		buffer.append(" left join B_Warehouse k on B_WC_StockID11=k.B_WH_ID ");
		buffer.append(" left join B_Warehouse l on B_WC_StockID12=l.B_WH_ID ");
		buffer.append(" left join B_Warehouse m on B_WC_StockID13=m.B_WH_ID ");
		buffer.append(" left join B_Warehouse n on B_WC_StockID14=n.B_WH_ID ");
		
		buffer.append(" where B_WC_deptID=? ");
		
		params.add(Utility.getName(warehouseConfigurationPo.getBwcdeptid()));
		
		return (WarehouseConfigurationPo) queryForObject(buffer.toString(), params.toArray(), WarehouseConfigurationPo.class);
	}
	
	/**
	 * 获取退款仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public WarehouseConfigurationPo getInWarehouseByDpt(WarehouseConfigurationPo warehouseConfigurationPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 a.B_WH_warehouseName as bwcstockname1,b.B_WH_warehouseName as bwcstockname2,c.B_WH_warehouseName as bwcstockname3,d.B_WH_warehouseName as bwcstockname4,");
		buffer.append("e.B_WH_warehouseName as bwcstockname5,f.B_WH_warehouseName as bwcstockname6,g.B_WH_warehouseName as bwcstockname7,h.B_WH_warehouseName as bwcstockname8,");
		buffer.append("i.B_WH_warehouseName as bwcstockname9,j.B_WH_warehouseName as bwcstockname10,k.B_WH_warehouseName as bwcstockname11,l.B_WH_warehouseName as bwcstockname12,m.B_WH_warehouseName as bwcstockname13,o.B_WH_warehouseName as bwcstockname14, ");
		buffer.append("B_WC_StockID1 as bwcstockid1,B_WC_StockID2 as bwcstockid2, ");
		buffer.append("B_WC_StockID3 as bwcstockid3,B_WC_StockID4 as bwcstockid4, ");
		buffer.append("B_WC_StockID5 as bwcstockid5,B_WC_StockID6 as bwcstockid6, ");
		buffer.append("B_WC_StockID7 as bwcstockid7,B_WC_StockID8 as bwcstockid8, ");
		buffer.append("B_WC_StockID9 as bwcstockid9,B_WC_StockID10 as bwcstockid10, ");
		buffer.append("B_WC_StockID11 as bwcstockid11,B_WC_StockID12 as bwcstockid12,B_WC_StockID13 as bwcstockid13,B_WC_StockID14 as bwcstockid14  ");
		
		buffer.append(" from B_InWarehouseConfiguration  ");
		buffer.append(" left join B_Warehouse a on B_WC_StockID1=a.B_WH_ID ");
		buffer.append(" left join B_Warehouse b on B_WC_StockID2=b.B_WH_ID ");
		buffer.append(" left join B_Warehouse c on B_WC_StockID3=c.B_WH_ID ");
		buffer.append(" left join B_Warehouse d on B_WC_StockID4=d.B_WH_ID ");
		buffer.append(" left join B_Warehouse e on B_WC_StockID5=e.B_WH_ID ");
		buffer.append(" left join B_Warehouse f on B_WC_StockID6=f.B_WH_ID ");
		buffer.append(" left join B_Warehouse g on B_WC_StockID7=g.B_WH_ID ");
		buffer.append(" left join B_Warehouse h on B_WC_StockID8=h.B_WH_ID ");
		buffer.append(" left join B_Warehouse i on B_WC_StockID9=i.B_WH_ID ");
		buffer.append(" left join B_Warehouse j on B_WC_StockID10=j.B_WH_ID ");
		buffer.append(" left join B_Warehouse k on B_WC_StockID11=k.B_WH_ID ");
		buffer.append(" left join B_Warehouse l on B_WC_StockID12=l.B_WH_ID ");
		buffer.append(" left join B_Warehouse m on B_WC_StockID13=m.B_WH_ID ");
		buffer.append(" left join B_Warehouse o on B_WC_StockID14=o.B_WH_ID ");
		
		buffer.append(" where B_WC_deptID=? ");
		
		params.add(Utility.getName(warehouseConfigurationPo.getBwcdeptid()));
		
		return (WarehouseConfigurationPo) queryForObject(buffer.toString(), params.toArray(), WarehouseConfigurationPo.class);
	}
	
	/**
	 * 停用启用部门
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public void usingDepartment(DepartmentsPo departmentsPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Departments set B_DP_IsClosed=? where B_DP_DepartmentID=? ");
				
		params.add(Utility.getName(departmentsPo.getBdpisclosed()));
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 停用启用部门下的仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public void usingWarehouse(DepartmentsPo departmentsPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Warehouse set B_WH_IsClosed=? where B_WH_deptID=? ");
				
		params.add(Utility.getName(departmentsPo.getBdpisclosed()));
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 根据部门ID查询所属仓位
	 */
	public List<WarehousePo> getWarehouseByDpt(DepartmentsPo departmentsPo) {
		// TODO Auto-generated method stub

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_WH_warehouseName as bwhwarehouseName from B_Warehouse where B_WH_deptID=? ");		

		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));

		return queryForObjectList(buffer.toString(),params.toArray(), WarehousePo.class);
	}
	
	/**
	 * 根据部门ID查询是否存在所属的仓位和人员
	 */
	public int getWarehouseOrPersonCountByDpt(String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select sum(count1) from ( ");
		buffer.append("select count(SYS_PD_PersonID) as count1 from SYS_PersonDepartments inner join SYS_PersonInfo on SYS_PD_PersonID=ID ");
		buffer.append("  where SYS_PD_DepartmentID=? and userState = '0' and visibleFlag='1' ");
		buffer.append("union all ");
		buffer.append("select count(B_WH_ID) as count1 from B_Warehouse ");
		buffer.append("  where B_WH_deptID=? ");
		buffer.append(")temp ");

		params.add(Utility.getName(departmentID));
		params.add(Utility.getName(departmentID));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除部门与人员的对应关系
	 */
	public void deleteDptPersonRelationship(String departmentID) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM SYS_PersonDepartments ");
		buffer.append("WHERE SYS_PD_DepartmentID = ?");

		List<String> params = new ArrayList<String>();
		params.add(departmentID);

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}
	
	/**
	 * 查询所有门店和配送部门
	 */
	public List<DepartmentsPo> getSalesAndStorageDepartment(){
		
		String sql="select B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName  as bdpdepartmentname from B_Departments where B_DP_Type in ('1','3') and B_DP_IsClosed=0 ";
		
		return queryForObjectList(sql, null, DepartmentsPo.class);
	}
	
	/**
	 * 查询所有门店和配送部门
	 */
	public List<DepartmentsPo> getSalesAndStorageDepartment(DepartmentsPo departmentsPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName  as bdpdepartmentname from B_Departments where B_DP_IsClosed=0 ");
		
		if (!"".equals(Utility.getName(departmentsPo.getBdpcompanysid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(departmentsPo.getBdpcompanysid()));	
		}
		
		if (!"".equals(Utility.getName(departmentsPo.getBdptype()))){
		    buffer.append(" and B_DP_Type = ? ");
			params.add(Utility.getName(departmentsPo.getBdptype()));	
		}else{
			buffer.append(" and B_DP_Type in ('1','3') ");
		}
		
		return queryForObjectList(buffer.toString(),  params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 取所有部门(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getDepartmentsTree(String nodeId,String hrefTarget,String href,String isClosed,String companyID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ('L_'+B_DP_DepartmentID) as id,B_DP_IsClosed as cls,B_DP_DepartmentName as [text],? as hrefTarget,('departmentSel.action?departmentID='+B_DP_DepartmentID+'&goodsTree=1&departmentName='+B_DP_DepartmentName+'&moduleID='+?) as href from B_Departments where 1 = 1 ");
		if(!"".equals(isClosed) && isClosed!=null){
			buffer.append(" and B_DP_IsClosed=? ");
		}
		params.add(hrefTarget);
		params.add(href);
		
		if(!"".equals(isClosed) && isClosed!=null){
			params.add(isClosed);
		}
		
		if (!"".equals(Utility.getName(companyID))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(companyID));	
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(), FuctionTreeNode.class);	
	}
	
	/**
	 * 根据部门编号查询角色(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getRoleByDptTree(String nodeId,String hrefTarget,String href,String isPerson,String companyID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select distinct ('R_'+?+'_'+SYS_Roles.roleID) as id,roleName as [text],? as hrefTarget,('initRoleList.action?moduleID='+?+'&goodsTree=1&hid='+SYS_Roles.roleID+'&roleName2='+roleName) as href from SYS_PersonDepartments  ");
		buffer.append(" inner join SYS_PersonRoles on SYS_PD_PersonID=personID inner join SYS_Roles on SYS_PersonRoles.roleID=SYS_Roles.roleID inner join SYS_PersonInfo on SYS_PD_PersonID=SYS_PersonInfo.id ");
		buffer.append(" where 'L_' + SYS_PD_DepartmentID=? ");
		if(!"".equals(isPerson) && isPerson!=null)
		{
			buffer.append("  and SYS_PersonInfo.userState ='"+isPerson+"' ");
		}
		params.add(nodeId);
		params.add(hrefTarget);
		params.add(href);
		params.add(nodeId);
		
		return queryForObjectList(buffer.toString(), params.toArray(), FuctionTreeNode.class);	
	}
	
	/**
	 * 根据部门编号查询人员(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getPersonByDptTree(String nodeId,String hrefTarget,String href,String isPerson,String companyID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select distinct SYS_PD_PersonID as id,personName  as [text],isInvocation as cls,'true' as leaf,? as hrefTarget,('selPersonInfo.action?selId='+SYS_PD_PersonID+'&goodsTree=1&selPersonName='+personName+'&moduleID='+?) as href from SYS_PersonDepartments inner join SYS_PersonInfo on SYS_PD_PersonID=SYS_PersonInfo.id ");
		buffer.append("  inner join SYS_PersonRoles on SYS_PersonInfo.id=personID where SYS_PD_DepartmentID=? and userState='0' and roleID=?  and visibleFlag='1' ");
		if(!"".equals(isPerson) && isPerson!=null)
		{
			buffer.append("  and SYS_PersonInfo.isInvocation ='"+isPerson+"' ");
		}
		String[] nodes = nodeId.split("_");
		
		params.add(hrefTarget);
		params.add(href);
		params.add(Utility.getName(nodes[2]));
		params.add(Utility.getName(nodes[3]));
		
		return queryForObjectList(buffer.toString(), params.toArray(), FuctionTreeNode.class);	
	}
	
	
	/**
	 * 根据部门编号查询人员(组织结构)(没有角色)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getPersonTree(String nodeId,String hrefTarget,String href,String isPerson,String companyID)
	{
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select distinct SYS_PD_PersonID as id,personName  as [text],isInvocation as cls,'true' as leaf,? as hrefTarget,('selPersonInfo.action?selId='+SYS_PD_PersonID+'&goodsTree=1&selPersonName='+personName+'&moduleID='+?) as href from SYS_PersonDepartments inner join SYS_PersonInfo on SYS_PD_PersonID=SYS_PersonInfo.id ");
		buffer.append(" inner join SYS_PersonRoles on SYS_PersonInfo.id=personID   where SYS_PD_DepartmentID=?  and userState='0' and visibleFlag='1' ");
		if(!"".equals(isPerson) && isPerson!=null)
		{
			buffer.append("  and SYS_PersonInfo.isInvocation ='"+isPerson+"' ");
		}
		String[] nodes = nodeId.split("_");
		
		params.add(hrefTarget);
		params.add(href);
		params.add(Utility.getName(nodes[1]));
		return queryForObjectList(buffer.toString(), params.toArray(), FuctionTreeNode.class);	
	}
	/**
	 * 取所有银行卡名称
	 * 
	 * @return
	 */
	public List<BrankCardPo> getBankCardList(){
		
		StringBuffer buffer = new StringBuffer();
				
		buffer.append(" select B_BC_ID as bbcid,B_BC_Name as bbcname from B_BrankCard ");
		
		return queryForObjectList(buffer.toString(), null, BrankCardPo.class);	
	}
		
	/**
	 * 查询客户的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getFranchiseeCount(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(B_FS_StoreID) from B_Franchisee where 1=1 ");

		if (!"".equals(Utility.getName(po.getBdpdepartmentid()))){
			buffer.append(" and B_FS_StoreID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBdpdepartmentid()));
		}
		if (!"".equals(Utility.getName(po.getBdpdepartmentname()))){
			buffer.append(" and B_FS_StoreName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBdpdepartmentname()));
		}
		
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询客户列表
	 * 
	 * @param po
	 * @return
	 */
	public List<DepartmentsPo> getFranchiseeList(DepartmentsPo po,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("SELECT * from ( ");		

		buffer.append(" SELECT ROW_NUMBER() Over(order by B_FS_StoreID) as rowNum,B_FS_StoreID as bdpdepartmentid,B_FS_StoreName as bdpdepartmentname,B_FS_StorePerson as bdpperson  ,B_FS_StorePhone as bdpphone ");
		buffer.append("  ,B_FS_StoreFax as bdpfax ,B_FS_StoreAddress as bdpaddress,B_FS_StoreRemark as bdpremark,isnull(B_FS_IsClosed,'0') as bdpisclosed FROM B_Franchisee where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getBdpdepartmentid()))){
			buffer.append(" and B_FS_StoreID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBdpdepartmentid()));
		}
		if (!"".equals(Utility.getName(po.getBdpdepartmentname()))){
			buffer.append(" and B_FS_StoreName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBdpdepartmentname()));
		}
		
		buffer.append(" ) temp where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}

	/**
	 * 插入客户
	 * 
	 * @param departmentsPo
	 */
	public void insertFranchisee(DepartmentsPo departmentsPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into B_Franchisee(B_FS_StoreID,B_FS_StoreName,B_FS_StorePerson,B_FS_StorePhone,");
		buffer.append("B_FS_StoreFax,B_FS_StoreAddress,B_FS_StoreRemark,B_FS_BeginReceivable,B_FS_IsClosed) ");
		buffer.append("  values(?,?,?,?,?,?,?,?,'0') ");
		
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));
		params.add(Utility.getName(departmentsPo.getBdpdepartmentname()));
		params.add(Utility.getName(departmentsPo.getBdpperson()));
		params.add(Utility.getName(departmentsPo.getBdpphone()));
		params.add(Utility.getName(departmentsPo.getBdpfax()));
		params.add(Utility.getName(departmentsPo.getBdpaddress()));
		params.add(Utility.getName(departmentsPo.getBdpremark()));
		params.add(Utility.getName(departmentsPo.getBdppayables()).equals("") ? "0.00" : Utility.getName(departmentsPo.getBdppayables()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新客户
	 * 
	 * @param departmentsPo
	 */
	public void updateFranchisee(DepartmentsPo departmentsPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Franchisee set B_FS_StoreName=?,B_FS_StorePerson=?,B_FS_StorePhone=?,");
		buffer.append("B_FS_StoreFax=?,B_FS_StoreAddress=?,B_FS_StoreRemark=?");
		
		if( !Utility.getName(departmentsPo.getBdppayables()).equals("") ) {
			buffer.append(",B_FS_BeginReceivable=?");
		} else {
			buffer.append(",B_FS_BeginReceivable= NULL");
		}
		
		buffer.append("  where B_FS_StoreID=? ");		
		
		params.add(Utility.getName(departmentsPo.getBdpdepartmentname()));
		params.add(Utility.getName(departmentsPo.getBdpperson()));
		params.add(Utility.getName(departmentsPo.getBdpphone()));
		params.add(Utility.getName(departmentsPo.getBdpfax()));
		params.add(Utility.getName(departmentsPo.getBdpaddress()));
		params.add(Utility.getName(departmentsPo.getBdpremark()));

		if( !Utility.getName(departmentsPo.getBdppayables()).equals("") ) {
			params.add( Utility.getName(departmentsPo.getBdppayables()) );
		}
		
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 删除客户
	 * 
	 * @param departmentID
	 */
	public void deleteFranchisee(String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from B_Franchisee where B_FS_StoreID=? ");
		
		params.add(Utility.getName(departmentID));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 取指定客户
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */
	public DepartmentsPo getFranchisee(DepartmentsPo departmentsPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" SELECT top 1 B_FS_StoreID as bdpdepartmentid,B_FS_StoreName as bdpdepartmentname,B_FS_StorePerson as bdpperson  ,B_FS_StorePhone as bdpphone ");
		buffer.append("  ,B_FS_StoreFax as bdpfax ,B_FS_StoreAddress as bdpaddress,B_FS_StoreRemark as bdpremark,B_FS_BeginReceivable as bdppayables,(isnull(B_FS_BeginReceivable,0)+isnull(temp.damount,0)) as bdpcontactamount ");		
		buffer.append(" FROM B_Franchisee left join (select L_FA_DA_DealingsUnit as did,(isnull(sum(isnull(L_FA_DA_CostPriceAmount,0)),0)+isnull(sum(isnull(L_FA_DA_ReceiptMentAmount,0)),0)) as damount from L_FA_DA_DealingsAccounts where L_FA_DA_DealingsUnit=? group by L_FA_DA_DealingsUnit )temp on B_FS_StoreID=temp.did ");
		buffer.append(" where B_FS_StoreID=? ");
		
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));
		
		return (DepartmentsPo) queryForObject(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 为默认人员新增部门
	 * @param departmentsPo 部门对象
	 */
	public void insertPersonDepartment(DepartmentsPo departmentsPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into SYS_PersonDepartments(SYS_PD_ID,SYS_PD_PersonID,SYS_PD_DepartmentID) values(?,?,?) ");
		
		params.add(Utility.getName(uuid.generate()));
		params.add(Utility.getName(departmentsPo.getBdpperson()));
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除部门设置的默认仓位
	 */
	public void deleteDefaultWarehouseByDpt(String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from B_DefaultWarehouse where B_DW_deptID=? ");
		
		params.add(Utility.getName(departmentID));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除部门设置的出仓仓位
	 */
	public void deleteOutWarehouseByDpt(String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from B_WarehouseConfiguration where B_WC_deptID=? ");
		
		params.add(Utility.getName(departmentID));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除部门设置的退款仓位
	 */
	public void deleteInWarehouseByDpt(String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from B_InWarehouseConfiguration where B_WC_deptID=? ");
		
		params.add(Utility.getName(departmentID));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除部门下的所属仓位
	 */
	public void deleteWarehouseByDpt(String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from B_Warehouse where B_WH_deptID=? ");
		
		params.add(Utility.getName(departmentID));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 调拨查询页面使用
	 */
	public List<DepartmentsPo> getDepartmentsList(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_TakeGlassDate as bdptakeglassdate ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag ");
		buffer.append("FROM B_Departments ");
		buffer.append("inner join (select distinct(B_WH_deptID) as B_WH_deptID from B_Warehouse where B_WH_IsClosed='0') bw on bw.B_WH_deptID = B_DP_DepartmentID ");
		
		buffer.append(" where B_DP_IsClosed='0' ");
		
		if (!"".equals(Utility.getName(po.getBdpdepartmentid()))){
			buffer.append(" and B_DP_DepartmentID=? ");
			params.add(Utility.getName(po.getBdpdepartmentid()));
		}
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));	
		}		
		
		buffer.append(" order by B_DP_DepartmentID");
		
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 取部门对应的配镜单模版
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */
	public DepartmentsPo getBillTemplate(String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" select B_DP_DepartmentID as bdpdepartmentid,B_DP_Type as bdptype,");
		buffer.append(" a.B_FT_FIleUrl as bdpkjurl,b.B_FT_FIleUrl as bdpyxurl,c.B_FT_FIleUrl as bdpflurl,d.B_FT_FIleUrl as bdpdjdurl,e.B_FT_FIleUrl as bdpghdurl,f.B_FT_FIleUrl as bdptkjurl,g.B_FT_FIleUrl as bdptyxurl,h.B_FT_FIleUrl as bdptflurl,");		
		buffer.append(" a.B_FT_ID as bdpkjid,b.B_FT_ID as bdpyxid,c.B_FT_ID as bdpflid,d.B_FT_ID as bdpdjdid,e.B_FT_ID as bdpghdid,f.B_FT_ID as bdptkjid,g.B_FT_ID as bdptyxid,h.B_FT_ID as bdptflid,");
		buffer.append(" a.B_FT_Server as bdpkjserver,b.B_FT_Server as bdpyxserver,c.B_FT_Server as bdpflserver,d.B_FT_Server as bdpdjdserver,e.B_FT_Server as bdpghdserver,f.B_FT_Server as bdptkjserver,g.B_FT_Server as bdptyxserver,h.B_FT_Server as bdptflserver,");
		buffer.append(" a.B_FT_FileName as bdpkjfilename,b.B_FT_FileName as bdpyxfilename,c.B_FT_FileName as bdpflfilename,d.B_FT_FileName as bdpdjdfilename,e.B_FT_FileName as bdpghdfilename,f.B_FT_FileName as bdptkjfilename,g.B_FT_FileName as bdptyxfilename,h.B_FT_FileName as bdptflfilename,");
		buffer.append(" a.B_FT_Rmark as bdpkjremark,b.B_FT_Rmark as bdpyxremark,c.B_FT_Rmark as bdpflremark,d.B_FT_Rmark as bdpdjdremark,e.B_FT_Rmark as bdpghdremark,f.B_FT_Rmark as bdptkjremark,g.B_FT_Rmark as bdptyxremark,h.B_FT_Rmark as bdptremark ");		
		buffer.append(" FROM B_Departments ");
		buffer.append(" left join B_FittingTemplate a on B_DP_KjID = a.B_FT_ID ");
		buffer.append(" left join B_FittingTemplate b on B_DP_YxID = b.B_FT_ID ");
		buffer.append(" left join B_FittingTemplate c on B_DP_FlID = c.B_FT_ID ");
		buffer.append(" left join B_FittingTemplate d on B_DP_DjdID = d.B_FT_ID ");
		buffer.append(" left join B_FittingTemplate e on B_DP_GhdID = e.B_FT_ID ");
		buffer.append(" left join B_FittingTemplate f on B_DP_TKjID = f.B_FT_ID ");
		buffer.append(" left join B_FittingTemplate g on B_DP_TYxID = g.B_FT_ID ");	
		buffer.append(" left join B_FittingTemplate h on B_DP_TFlID = h.B_FT_ID ");	
		buffer.append(" where B_DP_DepartmentID=? ");
		
		params.add(Utility.getName(departmentID));;
		
		return (DepartmentsPo) queryForObject(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}	
	
	/**
	 * 更新部门对应的配镜单模版
	 */
	public void updateBillTemplate(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Departments set B_DP_KjID=?,B_DP_YxID=?,B_DP_FlID=?,");
		buffer.append("B_DP_DjdID=?,B_DP_GhdID=?,B_DP_TKjID=?,B_DP_TYxID=?,B_DP_TFlID=?");
		
		buffer.append(" where B_DP_DepartmentID=? ");		
		
		params.add(Utility.getName(po.getBdpkjid()));
		params.add(Utility.getName(po.getBdpyxid()));
		params.add(Utility.getName(po.getBdpflid()));
		params.add(Utility.getName(po.getBdpdjdid()));
		params.add(Utility.getName(po.getBdpghdid()));

		params.add(Utility.getName(po.getBdptkjid()));
		params.add(Utility.getName(po.getBdptyxid()));
		params.add(Utility.getName(po.getBdptflid()));
		params.add(Utility.getName(po.getBdpdepartmentid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 启用停用客户
	 */
	public void updateFranchiseeEnable(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Franchisee set B_FS_IsClosed=?");
		buffer.append(" where B_FS_StoreID=? ");		

		params.add(Utility.getName(po.getBdpisclosed()));
		params.add(Utility.getName(po.getBdpdepartmentid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public String getDepartmentByWarehouseID(String warehouseid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_WH_deptID from B_Warehouse where B_WH_ID = ? ");

		params.add(Utility.getName(warehouseid));
		
		return (String)getJdbcTemplate().queryForObject(buffer.toString(), params.toArray(),String.class);
	}

	/**
	 * 根据部门ID查询相同公司的部门
	 */
	public List<DepartmentsPo> getDepartmentListByCompany(String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName as bdpdepartmentname,isnull(F_CN_CompanyType,'') as bdpcompanynature,isnull(B_DP_CompanysID,'') as bdpcompanysid from B_Departments inner join F_CompanyName on B_DP_CompanysID = F_CN_ID where isnull(B_DP_CompanysID,'') in ( ");
		buffer.append("  select companysID from (select isnull(B_DP_CompanysID,'') as companysID from dbo.B_Departments where B_DP_DepartmentID = ? )t ");
		buffer.append(") and B_DP_Type = '1' ");
		
		params.add(departmentID);	
		
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 根据部门ID查询其他公司的部门
	 */
	public List<DepartmentsPo> getDepartmentListByOtherCompany(String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName as bdpdepartmentname,isnull(F_CN_CompanyType,'') as bdpcompanynature,isnull(B_DP_CompanysID,'') as bdpcompanysid from B_Departments inner join F_CompanyName on B_DP_CompanysID = F_CN_ID where isnull(B_DP_CompanysID,'') not in ( ");
		buffer.append("  select companysID from (select isnull(B_DP_CompanysID,'') as companysID from dbo.B_Departments where B_DP_DepartmentID = ? )t ");
		buffer.append(") and B_DP_Type = '1' ");
		buffer.append("union ");
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName as bdpdepartmentname,isnull(F_CN_CompanyType,'') as bdpcompanynature,isnull(B_DP_CompanysID,'') as bdpcompanysid from B_Departments inner join F_CompanyName on B_DP_CompanysID = F_CN_ID where B_DP_DepartmentID = ? and B_DP_Type = '1' ");
		
		params.add(departmentID);
		params.add(departmentID);	
		
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}	
	
	/**
	 * 根据部门ID查询当前公司
	 */
	public CompanyNamePo getCompanyInfoByDpt(String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
        buffer.append("select F_CN_Name as fcnName,F_CN_MasterOrVice as fcnmasterorvice from B_Departments inner join F_CompanyName on B_DP_CompanysID = F_CN_ID where B_DP_DepartmentID = ? ");
		
		params.add(departmentID);
		
		return (CompanyNamePo) queryForObject(buffer.toString(), params.toArray(), CompanyNamePo.class);
	}
	
	/**
	 * 查询当前会员卡号与部门是同属一个公司
	 */
	public int getCustomerCount(String memberID,String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(S_ME_CI_CustomerID)  ");
		buffer.append("  from S_ME_CustomerInfo inner join B_Departments on S_ME_CI_ShopCode = B_DP_DepartmentID ");
		buffer.append("  where S_ME_CI_MemberId = ? and S_ME_CI_ShopCode in ( ");
		buffer.append("		select B_DP_DepartmentID from B_Departments  ");
		buffer.append("		 where isnull(B_DP_CompanysID,'') in (   ");
		buffer.append("			 select companysID from ( ");
		buffer.append("			   select isnull(B_DP_CompanysID,'') as companysID from dbo.B_Departments where B_DP_DepartmentID = ? )t )  ");
		buffer.append("  ) ");
		
		params.add(Utility.getName(memberID));
		params.add(Utility.getName(departmentID));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 查询部门表所有信息(通过登录人员取出人员公司下的部门)
	 */
	public List<DepartmentsPo> getDepartments(PersonInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag,isnull(B_DP_KqDptID,'') as bdpkqDptID ");
		buffer.append("FROM B_Departments ");
		buffer.append("where B_DP_IsClosed=0 ");
		if(!"1".equals(po.getPersoncompanytype())){
			buffer.append("and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getPersoncompanyid()));
		}
		
		buffer.append("order by B_DP_DepartmentID ");

		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 根据公司ID查询公司下的部门ID（报表使用）
	 */
	public List<DepartmentsPo> getDepartmentIDByCompanysID(DepartmentsPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid, ");
		buffer.append("	 	  B_DP_DepartmentName as bdpdepartmentname,isnull(B_DP_QcDate,'') as bdpqcdate ");
		buffer.append("from dbo.B_Departments where B_DP_IsClosed = '0' ");
		
		if(!"".equals(Utility.getName(po.getBdpcompanysid()))){
			buffer.append("and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));	
		}
		
		if(!"".equals(Utility.getName(po.getBdptype()))){
			buffer.append("and B_DP_Type = ? ");
			params.add(Utility.getName(po.getBdptype()));	
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 取得当前公司下的所有门店
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsByCompanyID(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_TakeGlassDate as bdptakeglassdate ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag ");
		buffer.append("FROM B_Departments");
		buffer.append(" where B_DP_Type = '1' and B_DP_IsClosed = '0' ");
		buffer.append(" and B_DP_CompanysID = ? ");
		
		params.add(Utility.getName(po.getBdpcompanysid()));	
		
		buffer.append(" order by B_DP_DepartmentID");
		
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	public List<WarehousePo> getWarehouseByDptCompany(DepartmentsPo departmentsPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select distinct B_WH_ID as bwhid,B_WH_warehouseName as bwhwarehouseName from B_Warehouse inner join B_Departments on B_WH_deptID = B_DP_DepartmentID where B_DP_CompanysID=? ");		

		params.add(Utility.getName(departmentsPo.getBdpcompanysid()));

		return queryForObjectList(buffer.toString(),params.toArray(), WarehousePo.class);
	}
	
	/**
	 * 查询所有部门
	 */
	public List<DepartmentsPo> getDepartmentsInfo(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_TakeGlassDate as bdptakeglassdate ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag ");
		buffer.append(",isnull(F_CN_CompanyType,'1') as bdpcompanynature  ");
		buffer.append(",isnull(B_DP_CompanysID,'') as bdpcompanysid  ");
		buffer.append("FROM B_Departments ");
		buffer.append(" left join F_CompanyName on B_DP_CompanysID = F_CN_ID ");
		buffer.append("where  B_DP_IsClosed = '0' ");

		buffer.append(" AND B_DP_Type = ? ");
		params.add(Utility.getName(po.getBdptype()));
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));	
		}
		
		buffer.append(" order by B_DP_DepartmentID");

		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 取总公司库房
	 */
	public List<DepartmentsPo> getParentCompanyDepartments(String flag){
		
		StringBuffer buffer = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",isnull(F_CN_CompanyType,'1') as bdpcompanynature  ");
		buffer.append(",isnull(B_DP_CompanysID,'') as bdpcompanysid  ");
		buffer.append("FROM B_Departments ");
		buffer.append(" left join F_CompanyName on B_DP_CompanysID = F_CN_ID ");
		buffer.append("where  B_DP_IsClosed = '0' AND B_DP_Type = '3' and F_CN_MasterOrVice = ? ");
		buffer.append(" order by B_DP_DepartmentID ");
		
		params.add(Utility.getName(flag));	

		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 获取部门类型
	 */
	public List<DepartmentTypePo> getDepartmentTypeList(){
		
		StringBuffer buffer = new StringBuffer();		
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_DT_ID as bdtid,B_DT_Name as bdtname from B_DepartmentType ");

		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentTypePo.class);
	}
	
	/**
	 * 设置部门期初日期和上线日期
	 */
	public void updateDepartmentDate(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Departments set B_DP_QcDate = ? , B_DP_OnlineDate = ? ");
		
		params.add(Utility.getName(po.getBdpqcdate()));
		params.add(Utility.getName(po.getBdponlinedatre()));
		
		String[] str = Utility.getName(po.getBdpdepartmentid()).split(",");
		
		buffer.append(" where B_DP_DepartmentID in ( ? ");		
		params.add(str[0]);
		
		for (int i = 1; i < str.length; i++){
			buffer.append(" ,? ");		
			params.add(str[i]);
		}

		buffer.append(" ) ");	

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取门店配置的HIS信息
	 */
	public DepartmentsPo getDepartmentSetHisInfo(String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT top 1  "); 
		buffer.append("B_DP_DepartmentID 			    as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName 			as bdpdepartmentname ");
		buffer.append(",isnull(B_DP_LinkHisFlag,'0') 	as bdplinkhisflag ");
		buffer.append(",isnull(B_DP_LinkHis,'')  		as bdplinkhis ");
		buffer.append(",isnull(B_DP_NotPayFeeForm,'') 	as bdpnotpayfeeform ");
		buffer.append(",isnull(B_DP_ChargingItemID,'') 	as bdpchargingitemid ");
		buffer.append(",isnull(B_DP_ReadCardForm,'') 	as bdpreadcardform ");
		buffer.append(",isnull(B_H_HisUrl,'') 			as bdplinkhisurl ");
		
		buffer.append(" FROM B_Departments left join B_His on B_DP_LinkHis = B_H_ID ");
		buffer.append(" WHERE B_DP_DepartmentID = ? ");
		
		params.add(Utility.getName(departmentID));
		
		return (DepartmentsPo) queryForObject(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 更新门店配置的HIS信息
	 */
	public void updateDepartmentSetHisInfo(DepartmentsPo po){
				
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update top (1) B_Departments set ");
		buffer.append("B_DP_LinkHisFlag = ? ");
		buffer.append(",B_DP_LinkHis = ? ");
		buffer.append(",B_DP_NotPayFeeForm = ? ");
		buffer.append(",B_DP_ChargingItemID = ? ");
		buffer.append(" WHERE B_DP_DepartmentID = ? ");
		
		params.add(Utility.getName(po.getBdplinkhisflag()));
		params.add(Utility.getName(po.getBdplinkhis()));
		params.add(Utility.getName(po.getBdpnotpayfeeform()));
		params.add(Utility.getName(po.getBdpchargingitemid()));
		params.add(Utility.getName(po.getBdpdepartmentid()));
		
		if ("1".equals(Utility.getName(po.getBdplinkhisflag()))){
			buffer.append("update top (1) B_Departments set B_DP_SalesType = '2' WHERE B_DP_DepartmentID = ?");
			params.add(Utility.getName(po.getBdpdepartmentid()));
		}
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());		
	}
	
}
