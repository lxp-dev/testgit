package com.pengsheng.eims.report.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class AttenceAction extends BaseAction
{
	//声明部门mgr的对象 
	private DepartmentsMgr departmentsMgr;
	//声明部门Po的对象
	private DepartmentsPo departmentsPo;

	private PersonPermissionMgr personPermissionMgr;
	
	
	
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}



	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}



	public DepartmentsPo getDepartmentsPo() {
		return departmentsPo;
	}



	public void setDepartmentsPo(DepartmentsPo departmentsPo) {
		this.departmentsPo = departmentsPo;
	}



	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}



	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}



	/**
	 * 考勤打卡明细表
	 * @return
	 * @throws Exception
	 */
	public String initAttenceDetails() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//调用mgr中查询部门信息的方法并装如LIS<DepartmentsPo>中
		List<DepartmentsPo> departments = departmentsMgr.getDepartments();
		request.setAttribute("departments", departments);

		return SUCCESS;
	}
	
	/**
	 * 考勤日表
	 * @return
	 * @throws Exception
	 */
	public String initAttenceDay() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//调用mgr中查询部门信息的方法并装如LIS<DepartmentsPo>中
		List<DepartmentsPo> departments = departmentsMgr.getDepartments();

		request.setAttribute("departments", departments);

		return SUCCESS;
	}
	/**
	 * 考勤加班表
	 * @return
	 * @throws Exception
	 */
	public String initAttenceOvertime() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//调用mgr中查询部门信息的方法并装如LIS<DepartmentsPo>中
		List<DepartmentsPo> departments = departmentsMgr.getDepartments();

		request.setAttribute("departments", departments);

		return SUCCESS;
	}
	
	/**
	 * 考勤缺勤表
	 * @return
	 * @throws Exception
	 */
	public String initAttenceAbsence() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//调用mgr中查询部门信息的方法并装如LIS<DepartmentsPo>中
		List<DepartmentsPo> departments = departmentsMgr.getDepartments();

		request.setAttribute("departments", departments);

		return SUCCESS;
	}
	
	/**
	 * 请假/出差/休假
	 * @return
	 * @throws Exception
	 */
	public String initAttenceQcx() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//调用mgr中查询部门信息的方法并装如LIS<DepartmentsPo>中
		List<DepartmentsPo> departments = departmentsMgr.getDepartments();

		request.setAttribute("departments", departments);

		return SUCCESS;
	}
	
	/**
	 * 考勤月表
	 * @return
	 * @throws Exception
	 */
	public String initAttenceMonth() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//调用mgr中查询部门信息的方法并装如LIS<DepartmentsPo>中
		List<DepartmentsPo> departments = departmentsMgr.getDepartments();

		request.setAttribute("departments", departments);

		return SUCCESS;
	}
}
