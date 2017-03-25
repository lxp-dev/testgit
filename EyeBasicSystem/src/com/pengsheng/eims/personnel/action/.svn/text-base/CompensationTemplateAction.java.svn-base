package com.pengsheng.eims.personnel.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.mgr.CompensationTemplateMgr;
import com.pengsheng.eims.personnel.mgr.MPersonInfoMgr;
import com.pengsheng.eims.personnel.persistence.CompensationTemplatePo;
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

public class CompensationTemplateAction extends BaseAction
{
	private List<RolePo> roles;
	private List<DepartmentsPo> departments;
	private List<CompensationTemplatePo> compensationTemplatePos;
	private MPersonInfoMgr mpersonInfoMgr;
	private DepartmentsMgr departmentsMgr;
	private CompensationTemplateMgr compensationTemplateMgr;
	private PersonPermissionMgr personPermissionMgr;
	private CompensationTemplatePo compensationTemplatePo;
	private List<PersonDepartmentsPo> personDepartments;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;

	public String initCompensationTemplateSel() 
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
		
		// 取得所有角色
		roles = mpersonInfoMgr.getRoles();
		
		// 取所有部门
		departments = departmentsMgr.getDepartments();

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
	public String selCompensationTemplate()
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

		CompensationTemplatePo po = new CompensationTemplatePo();
		po.setMctpersonid(request.getParameter("selId"));
		po.setPersonname(request.getParameter("selPersonName"));
		po.setRoleid(request.getParameter("selRoleid"));
		po.setIsinvocation(request.getParameter("isinvocation"));
		po.setBeginentrytime(request.getParameter("begintime"));
		po.setEndentrytime(request.getParameter("endtime"));
		po.setDepartmentid(request.getParameter("selDepartmentID"));
		
		request.setAttribute("selId", request.getParameter("selId"));
		request.setAttribute("selPersonName", request.getParameter("selPersonName"));
		request.setAttribute("selRoleid", request.getParameter("selRoleid"));
		request.setAttribute("isinvocation", request.getParameter("isinvocation"));
		request.setAttribute("begintime", request.getParameter("begintime"));
		request.setAttribute("endtime", request.getParameter("endtime"));
		request.setAttribute("selDepartmentID", request.getParameter("selDepartmentID"));
		request.setAttribute("selDepartmentName", request.getParameter("selDepartmentName"));
		
		// 取得所有角色
		roles = mpersonInfoMgr.getRoles();

		// 取所有部门
		departments = departmentsMgr.getDepartments();
		
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

		int count = compensationTemplateMgr.getCompensationTemplateCount(po);

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

			compensationTemplatePos = compensationTemplateMgr.getCompensationTemplates(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}		

		return SUCCESS;
	}

	public String initCompensationTemplateInsert() {
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
			compensationTemplatePo=compensationTemplateMgr.selectCompensationTemplatePo(hid);
		}

		return SUCCESS;
	}
	
	public String insertCompensationTemplatePo() throws Exception 
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
		logPo.setsLogContent("员工编号：" + Utility.getName(compensationTemplatePo.getMctpersonid()) + "薪酬模板新增!" );
		
		//查询人员薪酬模板是否重复
		int flag = compensationTemplateMgr.getCompensationTemplateRepeat(compensationTemplatePo.getMctpersonid());

		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			compensationTemplateMgr.insertCompensationTemplatePo(compensationTemplatePo, logPo)	;		
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			return SUCCESS;				
		}else
		{//否则更新		
			logPo.setsLogOpID("3");    // 3 表示修改
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			compensationTemplateMgr.updateCompensationTemplatePo(compensationTemplatePo, logPo);
			this.addActionMessage(getText("struts.messages.update.sucess"));
			
			return SUCCESS;
		}

	}
	
	public String initUpdateCompensationTemplatePo() throws Exception 
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
		compensationTemplatePo=compensationTemplateMgr.selectCompensationTemplatePo(Utility.getName(request.getParameter("hid")));
			
		return SUCCESS;
	}
	
	public String updateCompensationTemplatePo() throws Exception 
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
		logPo.setsLogContent("员工编号：" + Utility.getName(compensationTemplatePo.getMctpersonid()) + "薪酬模板修改!" );
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		compensationTemplateMgr.updateCompensationTemplatePo(compensationTemplatePo, logPo);
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
		return SUCCESS;
	}
	
	public String initDeleteCompensationTemplatePo() throws Exception {
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
		compensationTemplatePo=compensationTemplateMgr.selectCompensationTemplatePo(Utility.getName(request.getParameter("hid")));	
		return SUCCESS;
	}
	
	public String deleteCompensationTemplatePo() throws Exception {
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
		logPo.setsLogContent("员工编号：" + Utility.getName(compensationTemplatePo.getMctpersonid()) + "薪酬模板删除!");
		
		
		
		//查询职务表在其他s表中是否已经使用
		int flag =0 ;
		
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		

		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			compensationTemplateMgr.deleteCompensationTemplatePo(compensationTemplatePo, logPo);	
			this.addActionMessage(getText("struts.messages.delete.sucess"));
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("删除失败 这个已被使用！"));
			
		}
		
		return SUCCESS;
	}
	public String detailCompensationTemplatePo() throws Exception {
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
		compensationTemplatePo=compensationTemplateMgr.selectCompensationTemplatePo(Utility.getName(request.getParameter("hid")));	
		return SUCCESS;
	}
	
	
	public List<RolePo> getRoles() {
		return roles;
	}

	public void setRoles(List<RolePo> roles) {
		this.roles = roles;
	}

	public List<DepartmentsPo> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentsPo> departments) {
		this.departments = departments;
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

	public CompensationTemplateMgr getCompensationTemplateMgr() {
		return compensationTemplateMgr;
	}

	public void setCompensationTemplateMgr(
			CompensationTemplateMgr compensationTemplateMgr) {
		this.compensationTemplateMgr = compensationTemplateMgr;
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

	public List<CompensationTemplatePo> getCompensationTemplatePos() {
		return compensationTemplatePos;
	}

	public void setCompensationTemplatePos(
			List<CompensationTemplatePo> compensationTemplatePos) {
		this.compensationTemplatePos = compensationTemplatePos;
	}

	public CompensationTemplatePo getCompensationTemplatePo() {
		return compensationTemplatePo;
	}

	public void setCompensationTemplatePo(
			CompensationTemplatePo compensationTemplatePo) {
		this.compensationTemplatePo = compensationTemplatePo;
	}

	public List<PersonDepartmentsPo> getPersonDepartments() {
		return personDepartments;
	}

	public void setPersonDepartments(List<PersonDepartmentsPo> personDepartments) {
		this.personDepartments = personDepartments;
	}

}
