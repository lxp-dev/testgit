package com.pengsheng.eims.system.action;


import java.util.List;
import com.pengsheng.eims.system.mgr.MacMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.system.persistence.MacPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;


public class MacAction extends BaseAction {
	private final String UPDATE_PERSON_CHECK_MAC = "update";//新增mac地址例外人员

	public List<RolePo> getRoles() {
		return roles;
	}

	public void setRoles(List<RolePo> roles) {
		this.roles = roles;
	}

	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	private PersonPermissionMgr personPermissionMgr;	
	private MacPo macPo;
	private DepartmentsMgr departmentsMgr;
	private List<MacPo> list; // 客户机列表List
	private List<DepartmentsPo> departmentsList; // 部门List
	private MacMgr macMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<RolePo> roles;
	private PersonInfoMgr personInfoMgr;
	
	private PersonInfoPo personPo;
	private List<PersonInfoPo> personInfoList;
	
	
	public PersonInfoPo getPersonPo() {
		return personPo;
	}
	
	public void setPersonPo(PersonInfoPo personPo) {
		this.personPo = personPo;
	}
	
	public List<PersonInfoPo> getPersonInfoList() {
		return personInfoList;
	}
	
	public void setPersonInfoList(List<PersonInfoPo> personInfoList) {
		this.personInfoList = personInfoList;
	}
	
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	
	public List<MacPo> getList() {
		return list;
	}

	public void setList(List<MacPo> list) {
		this.list = list;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	
	public MacPo getMacPo() {
		return macPo;
	}

	public void setMacPo(MacPo macPo) {
		this.macPo = macPo;
	}
	
	public MacMgr getMacMgr() {
		return macMgr;
	}

	public void setMacMgr(MacMgr macMgr) {
		this.macMgr = macMgr;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	/**
	 * 初始化客户机查询
	 */
	public String initMacSel() throws Exception {
		
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

		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpisalldepartments("all");
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);	
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selMac";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询客户机列表
	 */
	public String selMac() throws Exception {
		
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

		// 页面查询条件
		String pg_sysmacname = Utility.getName(request.getParameter("pg_sysmacname"));
		String pg_sysmackey = Utility.getName(request.getParameter("pg_sysmackey"));
		String pg_sysmacdepartmentid = Utility.getName(request.getParameter("pg_sysmacdepartmentid"));
		String pg_sysmacisable = Utility.getName(request.getParameter("pg_sysmacisable"));
		String pg_sysmaccurrentloginpersonid = Utility.getName(request.getParameter("pg_sysmaccurrentloginpersonid"));

		// 取得部门List
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpisalldepartments("all");
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);	
		
		// 取得查询结果客户机
		macPo = new MacPo();
		macPo.setSysmacname(pg_sysmacname);
		macPo.setSysmackey(pg_sysmackey);
		macPo.setSysmacdepartmentid(pg_sysmacdepartmentid);
		macPo.setSysmacisable(pg_sysmacisable);
		macPo.setSysmaccurrentloginpersonid(pg_sysmaccurrentloginpersonid);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			macPo.setSysmaccompanyid(personInfoPo.getPersoncompanyid());
		}
		
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
		
		int count = macMgr.getMacCount(macPo);
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
			list = macMgr.getMacList(macPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			list = null;
		}	

		request.setAttribute("pg_sysmacname", pg_sysmacname);
		request.setAttribute("pg_sysmackey", pg_sysmackey);
		request.setAttribute("pg_sysmacdepartmentid", pg_sysmacdepartmentid);
		request.setAttribute("pg_sysmacisable", pg_sysmacisable);
		request.setAttribute("pg_sysmaccurrentloginpersonid", pg_sysmaccurrentloginpersonid);
		
		return SUCCESS;
	}

	/**
	 * 初始化客户机新增
	 */
	public String initInsertMac() throws Exception {
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
		macPo = new MacPo();
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpisalldepartments("all");
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);	

		return SUCCESS;
	}

	/**
	 * 客户机新增
	 */
	public String insertMac() throws Exception {
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

		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("客户机:" + macPo.getSysmacname() + "新增!");
		
		
		if (macMgr.getISMacrepeat(macPo)>0) 
		{		
			// 取得部门List
			request.setAttribute("sysmacdepartmentid", macPo.getSysmacdepartmentid());
			departmentsList = departmentsMgr.getDepartments();
			this.addActionMessage(getText("客户机名称或Mac重复!"));						
			return "error";			

		}else{
			macMgr.insertMac(macPo,logPo);
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);

			return SUCCESS;
		}		
	}

	/**
	 * 初始化客户机更新
	 */
	public String initUpdateMac() throws Exception {
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
		// 页面参数：客户机Id
		String sysmacid=Utility.getName(request.getParameter("hid"));
		
		// 获取已启用的所有部门
		departmentsList = departmentsMgr.getAllDepartments();
		
		//根据客户机Id查询客户机对象
		macPo = new MacPo();
		macPo.setSysmacid(sysmacid);
		macPo=macMgr.getMac(macPo);

		String departmentID = Utility.getName(request.getParameter("departmentID"));
		request.setAttribute("departmentID",departmentID);
		
		return SUCCESS;
	}
	
	/**
	 * 客户机更新
	 */
	public String updateMac() throws Exception {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("客户机:" + macPo.getSysmacname() +"修改!");
		this.clearMessages();
		
		if (macMgr.getISMacrepeat(macPo)>0) 
		{			
			departmentsList = departmentsMgr.getDepartments();
			this.addActionMessage(getText("客户机名称或Mac重复!"));						
			return "error";			

		}else{
			macMgr.updateMac(macPo,logPo);
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}
	}
	
	/**
	 * 初始化客户机删除
	 */
	public String initDeleteMac()throws Exception{
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
		// 页面参数：客户机Id
		String sysmacid=Utility.getName(request.getParameter("hid"));
		
		//根据客户机Id查询客户机对象
		macPo = new MacPo();
		macPo.setSysmacid(sysmacid);
		macPo=macMgr.getMac(macPo);

		return SUCCESS;
	}
	
	/**
	 * 删除客户机
	 */
	public String deleteMac()throws Exception{
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
		// 页面参数：客户机Id
		String sysmacid=Utility.getName(request.getParameter("hid"));		
		
		macPo = new MacPo();
		macPo.setSysmacid(sysmacid);
		macPo=macMgr.getMac(macPo);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("客户机:" + macPo.getSysmacname() +"删除!");
		
		macMgr.deleteMac(sysmacid,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	public String initMacForPerson() {
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
		
		RolePo rpo = new RolePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			rpo.setRolecompanyid(personInfoPo.getPersoncompanyid());
		}
		roles = personInfoMgr.getRolesByCompanyType(rpo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selMacForPerson";
		}
		
		return SUCCESS;
	}

	public String selMacForPerson() {
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

		// 取得所有角色
		RolePo rpo = new RolePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			rpo.setRolecompanyid(personInfoPo.getPersoncompanyid());
		}
		roles = personInfoMgr.getRolesByCompanyType(rpo);
		
		String del = request.getParameter("del");

		this.clearMessages();
		if(null != del && del.equals("del")) {
			this.addActionMessage(getText("struts.messages.delete.sucess"));
		}
		if(null != del && del.equals("update")) {
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		}
		
		// 页面查询条件
		String selPersonID = Utility.getName(request.getParameter("selPersonID"));
		String selPersonName = Utility.getName(request.getParameter("selPersonName"));
		String selDepartmentName = Utility.getName(request.getParameter("selDepartmentName"));
		String selDepartmentID = Utility.getName(request.getParameter("selDepartmentID"));
		String selRoleid = Utility.getName(request.getParameter("selRoleid"));
		String pg_sysmacisable = Utility.getName(request.getParameter("pg_sysmacisable"));
		String pg_sysmaccurrentloginpersonid = Utility.getName(request.getParameter("pg_sysmaccurrentloginpersonid"));

		request.setAttribute("selPersonID", selPersonID);
		request.setAttribute("selPersonName", selPersonName);
		request.setAttribute("selDepartmentName", selDepartmentName);
		request.setAttribute("selDepartmentID", selDepartmentID);
		request.setAttribute("selRoleid", selRoleid);

		// 取得查询结果客户机
		personPo = new PersonInfoPo();
		personPo.setId(selPersonID);
		personPo.setPersonName(selPersonName);
		personPo.setBdpdepartmentname(selDepartmentName);
		personPo.setDepartmentID(selDepartmentID);
		personPo.setRoleid(selRoleid);

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
		
		int count = macMgr.getPersoninfosForMacCount(personPo);
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
			personInfoList = macMgr.getPersonInfosForMac(personPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			personInfoList = null;
		}	

		return SUCCESS;
	}
	
	
	/**
	 * 客户机更新
	 */
	public String updatePersonCheckMac() throws Exception {
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
		String updateOrDelFlag = Utility.getName(request.getParameter("updateOrDelFlag"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		this.clearMessages();
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		
		if(updateOrDelFlag.equals(UPDATE_PERSON_CHECK_MAC)) {
			String str = request.getParameter("insertPersonIDs");
			String [] insertPersonIDs = (null != str ? str.split(",") : null);
			
			if(null != insertPersonIDs) {
				macMgr.updatePersonCheckMac(insertPersonIDs, updateOrDelFlag, logPo);
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				
				insertPersonIDs = null;
				return updateOrDelFlag;
			}
		} else {
			
			String [] insertPersonIDs = request.getParameterValues("insertPersonIDs");
			
			if(null != insertPersonIDs) {

				macMgr.updatePersonCheckMac(insertPersonIDs, updateOrDelFlag, logPo);
				this.addActionMessage(getText("struts.messages.delete.sucess"));
				
				String selPersonID = Utility.getName(request.getParameter("selPersonID"));
				String selPersonName = Utility.getName(request.getParameter("selPersonName"));
				String selDepartmentName = Utility.getName(request.getParameter("selDepartmentName"));
				String selDepartmentID = Utility.getName(request.getParameter("selDepartmentID"));
				String selRoleid = Utility.getName(request.getParameter("selRoleid"));
				
				request.setAttribute("selPersonID", selPersonID);
				request.setAttribute("selPersonName", selPersonName);
				request.setAttribute("selDepartmentName", selDepartmentName);
				request.setAttribute("selDepartmentID", selDepartmentID);
				request.setAttribute("selRoleid", selRoleid);
				// 取得所有角色
				roles = personInfoMgr.getRoles();
				
				// 取得查询结果客户机
				personPo = new PersonInfoPo();
				personPo.setId(selPersonID);
				personPo.setPersonName(selPersonName);
				personPo.setBdpdepartmentname(selDepartmentName);
				personPo.setDepartmentID(selDepartmentID);
				personPo.setRoleid(selRoleid);
				int count = macMgr.getPersoninfosForMacCount(personPo);
				int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
					personInfoList = macMgr.getPersonInfosForMac(personPo, page.getStart(), page.getPageSize());
					request.setAttribute(Pagination.PAGINATION, page);
				} else {
					personInfoList = null;
				}	

				return updateOrDelFlag;
			}
		}
		return ERROR;
	}

	public String initDelMacForPerson() {
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
		
		return SUCCESS;
	}

	public String initInsertMacForPerson() {
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
		
		return SUCCESS;
	}
}
