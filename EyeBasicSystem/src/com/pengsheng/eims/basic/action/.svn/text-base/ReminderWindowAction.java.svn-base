package com.pengsheng.eims.basic.action;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.DepartmentTypeMgr;
import com.pengsheng.eims.basic.mgr.ReminderWindowMgr;
import com.pengsheng.eims.basic.persistence.DepartmentTypePo;
import com.pengsheng.eims.basic.persistence.ReminderWindowPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.RoleMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.RolesPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 提醒窗口管理
 * @author moyongsheng 2014 11 14
 *
 */
public class ReminderWindowAction extends BaseAction
{
	private List<ReminderWindowPo> reminderWindowList;
	private List<DepartmentTypePo> departmentTypeList;
	private List<RolePo> roleList;
	
	private DepartmentTypeMgr departmentTypeMgr;
	private ReminderWindowMgr reminderWindowMgr;
	private ReminderWindowPo reminderWindowPo;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr;
	private PersonPermissionMgr personPermissionMgr;	
	private RoleMgr roleMgr;
	
	/**
	 * 初始化提醒窗口设置页面
	 */
	public String initReminderWindowSel() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		String frwsid = Utility.getName(request.getParameter("frwsid"));
		
		reminderWindowList = reminderWindowMgr.getAllReminderWindows();
		
		if(!frwsid.equals("")){
			departmentTypeList = departmentTypeMgr.getAllDepartmentTypes();
			RolePo rolePo = new RolePo();
			rolePo.setModuleapplicationid("1");
			roleList = roleMgr.getSysRoleList(rolePo);
			
			reminderWindowPo = reminderWindowMgr.getRemainderWindowByid(frwsid);
		}		
		
		return SUCCESS;
	}

	/**
	 * 更新提醒窗口设置
	 */
	public String updateReminderWindow() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		String frwsid = Utility.getName(request.getParameter("frwsid"));
		String[] departmenttypeidArray = request.getParameterValues("departmenttypeids");
		String departmenttypeids = "";
		if(departmenttypeidArray!=null && departmenttypeidArray.length>0){
			for (int i = 0; i < departmenttypeidArray.length; i++) {
				if ("".equals(departmenttypeids)) {
					departmenttypeids = departmenttypeidArray[i];
				} else {
					departmenttypeids = departmenttypeids + "," + departmenttypeidArray[i];
				}
			}
		}
		
		String[] roleidArray = request.getParameterValues("roleids");
		String roleids = "";
		if(roleidArray!=null && roleidArray.length>0){
			for (int i = 0; i < roleidArray.length; i++) {
				if ("".equals(roleids)) {
					roleids = roleidArray[i];
				} else {
					roleids = roleids + "," + roleidArray[i];
				}
			}
		}else{
			roleids = "no";
		}

		ReminderWindowPo tmpReminderWindowPo = new ReminderWindowPo();
		tmpReminderWindowPo.setFrwsid(frwsid);
		tmpReminderWindowPo.setFrwsdepartmenttypeid(departmenttypeids);
		tmpReminderWindowPo.setFrwsroleid(roleids);
		reminderWindowMgr.updateReminderWindow(tmpReminderWindowPo);
		
		reminderWindowList = reminderWindowMgr.getAllReminderWindows();
		departmentTypeList = departmentTypeMgr.getAllDepartmentTypes();
		RolePo rolePo = new RolePo();
		rolePo.setModuleapplicationid("1");
		roleList = roleMgr.getSysRoleList(rolePo);
		
		reminderWindowPo = reminderWindowMgr.getRemainderWindowByid(frwsid);
		this.addActionMessage("更新成功！");
		return SUCCESS;
	}
	public List<ReminderWindowPo> getReminderWindowList() {
		return reminderWindowList;
	}

	public void setReminderWindowList(List<ReminderWindowPo> reminderWindowList) {
		this.reminderWindowList = reminderWindowList;
	}

	public ReminderWindowMgr getReminderWindowMgr() {
		return reminderWindowMgr;
	}

	public void setReminderWindowMgr(ReminderWindowMgr reminderWindowMgr) {
		this.reminderWindowMgr = reminderWindowMgr;
	}

	public ReminderWindowPo getReminderWindowPo() {
		return reminderWindowPo;
	}

	public void setReminderWindowPo(ReminderWindowPo reminderWindowPo) {
		this.reminderWindowPo = reminderWindowPo;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<DepartmentTypePo> getDepartmentTypeList() {
		return departmentTypeList;
	}

	public void setDepartmentTypeList(List<DepartmentTypePo> departmentTypeList) {
		this.departmentTypeList = departmentTypeList;
	}

	public DepartmentTypeMgr getDepartmentTypeMgr() {
		return departmentTypeMgr;
	}

	public void setDepartmentTypeMgr(DepartmentTypeMgr departmentTypeMgr) {
		this.departmentTypeMgr = departmentTypeMgr;
	}

	public RoleMgr getRoleMgr() {
		return roleMgr;
	}

	public void setRoleMgr(RoleMgr roleMgr) {
		this.roleMgr = roleMgr;
	}

	public List<RolePo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RolePo> roleList) {
		this.roleList = roleList;
	}

}
