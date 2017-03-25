package com.pengsheng.eims.personnel.action;

import java.util.List;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.mgr.AttendanceManageMgr;
import com.pengsheng.eims.personnel.mgr.MPersonInfoMgr;
import com.pengsheng.eims.personnel.persistence.AttendanceManagePo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class AttendanceManageAction extends BaseAction
{

	private List<AttendanceManagePo> attendanceManagePos;
	private MPersonInfoMgr mpersonInfoMgr;
	private DepartmentsMgr departmentsMgr;
	private AttendanceManageMgr attendanceManageMgr;
	private PersonPermissionMgr personPermissionMgr;
	private AttendanceManagePo attendanceManagePo;
	private List<PersonDepartmentsPo> personDepartments;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;

	public String initAttendanceManageSel() 
	{

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "templatechange";
		}
		
		return SUCCESS;
	}
	/**
	 * 
	 * 
	 */
	public String selAttendanceManage()
	{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		AttendanceManagePo po = new AttendanceManagePo();
		po.setMampersonid(request.getParameter("selId"));
		po.setMampersonname(request.getParameter("selPersonName"));
		po.setMamdepartmentid(request.getParameter("selDepartmentID"));
		po.setMamyear(request.getParameter("selyear"));
		po.setMammonth(request.getParameter("selmonth"));		
		
		request.setAttribute("selId", request.getParameter("selId"));
		request.setAttribute("selPersonName", request.getParameter("selPersonName"));
		request.setAttribute("selRoleid", request.getParameter("selRoleid"));
		request.setAttribute("selDepartmentID", request.getParameter("selDepartmentID"));
		request.setAttribute("selDepartmentName", request.getParameter("selDepartmentName"));
		request.setAttribute("selyear", request.getParameter("selyear"));
		request.setAttribute("selmonth", request.getParameter("selmonth"));		
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}

		int count = attendanceManageMgr.getAttendanceManageCount(po);

		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			attendanceManagePos = attendanceManageMgr.getAttendanceManages(po, page.getStart(), page.getPageSize());
			
			request.setAttribute(Pagination.PAGINATION, page);
		}		

		return SUCCESS;
	}

	public String initAttendanceManageInsert() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String hid=Utility.getName(request.getParameter("pid"));
		if(!hid.equals(""))
		{
			attendanceManagePo=attendanceManageMgr.getPersonByid(hid);
		}

		return SUCCESS;
	}
	
	public String insertAttendanceManagePo() throws Exception 
	{
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("员工编号：" + Utility.getName(attendanceManagePo.getMampersonid()) + "考勤新增!" );
		
		//查询人员考勤是否重复
		int flag = attendanceManageMgr.getAttendanceManageRepeat(attendanceManagePo);

		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			attendanceManageMgr.insertAttendanceManagePo(attendanceManagePo, logPo)	;		
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			return SUCCESS;				
		}else
		{//否则更新		
			this.addActionMessage(getText("该月已经录入过考勤，如要修改请更新数据！"));			
			return ERROR;
		}
	}
	
	public String initUpdateAttendanceManagePo() throws Exception 
	{
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
		attendanceManagePo=attendanceManageMgr.selectAttendanceManagePo(Utility.getName(request.getParameter("hid")));
			
		return SUCCESS;
	}
	
	public String updateAttendanceManagePo() throws Exception 
	{
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("员工编号：" + Utility.getName(attendanceManagePo.getMampersonid()) + "考勤修改!" );
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		attendanceManageMgr.updateAttendanceManagePo(attendanceManagePo, logPo);
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
		return SUCCESS;
	}
	
	public String initDeleteAttendanceManagePo() throws Exception {
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
		attendanceManagePo=attendanceManageMgr.selectAttendanceManagePo(Utility.getName(request.getParameter("hid")));	
		return SUCCESS;
	}
	
	public String deleteAttendanceManagePo() throws Exception {
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
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("员工编号：" + Utility.getName(attendanceManagePo.getMampersonid()) + "考勤删除!");
		
		
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		attendanceManageMgr.deleteAttendanceManagePo(attendanceManagePo, logPo);	
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		
		return SUCCESS;
	}
	public String detailAttendanceManagePo() throws Exception {
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
		attendanceManagePo=attendanceManageMgr.selectAttendanceManagePo(Utility.getName(request.getParameter("hid")));	
		
		return SUCCESS;
	}

	public MPersonInfoMgr getMpersonInfoMgr() {
		return mpersonInfoMgr;
	}

	public void setMpersonInfoMgr(MPersonInfoMgr mpersonInfoMgr) {
		this.mpersonInfoMgr = mpersonInfoMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public AttendanceManageMgr getAttendanceManageMgr() {
		return attendanceManageMgr;
	}

	public void setAttendanceManageMgr(
			AttendanceManageMgr attendanceManageMgr) {
		this.attendanceManageMgr = attendanceManageMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public List<AttendanceManagePo> getAttendanceManagePos() {
		return attendanceManagePos;
	}

	public void setAttendanceManagePos(
			List<AttendanceManagePo> attendanceManagePos) {
		this.attendanceManagePos = attendanceManagePos;
	}

	public AttendanceManagePo getAttendanceManagePo() {
		return attendanceManagePo;
	}

	public void setAttendanceManagePo(
			AttendanceManagePo attendanceManagePo) {
		this.attendanceManagePo = attendanceManagePo;
	}

	public List<PersonDepartmentsPo> getPersonDepartments() {
		return personDepartments;
	}

	public void setPersonDepartments(List<PersonDepartmentsPo> personDepartments) {
		this.personDepartments = personDepartments;
	}

}
