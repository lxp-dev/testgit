package com.pengsheng.eims.system.action;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.PersonJobTypePo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonDiscountMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.RoleDiscountMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class PersonInfoAction extends BaseAction {
	
	private final String CHANGE_DISCOUNT = "changeDiscount";//是否随人员角色更改而更改人员打折权限
	private PersonInfoMgr personInfoMgr;
	private DepartmentsMgr departmentsMgr;
	private List<PersonInfoPo> persons;
	private List<RolePo> roles;
	private List<DepartmentsPo> departments;
	private PersonInfoPo personInfoPo;
	private List<PersonDepartmentsPo> personDepartments;
	private PersonPermissionMgr personPermissionMgr;	
	private InputStream inputStream = null;
	private String fileName = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private RoleDiscountMgr roleDiscountMgr;
	private RoleDiscountPo roleDiscountPo;
	private PersonDiscountMgr personDiscountMgr;
	private List<PersonJobTypePo> personJobTypePos;
	private List<CompanyNamePo> companyNamePos;
	private CompanyNameMgr companyNameMgr;
	
	public List<CompanyNamePo> getCompanyNamePos() {
		return companyNamePos;
	}

	public void setCompanyNamePos(List<CompanyNamePo> companyNamePos) {
		this.companyNamePos = companyNamePos;
	}

	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}

	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}

	public List<PersonJobTypePo> getPersonJobTypePos() {
		return personJobTypePos;
	}

	public void setPersonJobTypePos(List<PersonJobTypePo> personJobTypePos) {
		this.personJobTypePos = personJobTypePos;
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public List<PersonInfoPo> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonInfoPo> persons) {
		this.persons = persons;
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

	public PersonInfoPo getPersonInfoPo() {
		return personInfoPo;
	}

	public void setPersonInfoPo(PersonInfoPo personInfoPo) {
		this.personInfoPo = personInfoPo;
	}

	public List<PersonDepartmentsPo> getPersonDepartments() {
		return personDepartments;
	}

	public void setPersonDepartments(List<PersonDepartmentsPo> personDepartments) {
		this.personDepartments = personDepartments;
	}

	public String initPersonInfoSel() {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		
		// 取得所有角色
		roles = personInfoMgr.getRoles();

		// 取所有部门
		departments = departmentsMgr.getDepartments();

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		RolePo tpo = new RolePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			tpo.setRolecompanyid(personInfoPo.getPersoncompanyid());
		}		
		roles = personInfoMgr.getRolesByCompanyType(tpo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selPersonInfo";
		}
		
		return SUCCESS;
	}

	/**
	 * 
	 * 
	 */
	public String selPersonInfo() {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		PersonInfoPo personInfo = new PersonInfoPo();
		personInfo.setId(request.getParameter("selId"));
		personInfo.setPersonName(request.getParameter("selPersonName"));
		personInfo.setDepartmentID(request.getParameter("selDepartmentID"));
		personInfo.setRoleid(request.getParameter("selRoleid"));
		personInfo.setIsinvocation(request.getParameter("isinvocation"));		
		personInfo.setPersoncompanytype(personInfoPo1.getPersoncompanytype());
		
		String companysid = Utility.getName(request.getParameter("companysid"));
		personInfo.setPersoncompanyid(companysid);
		
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			personInfo.setPersoncompanyid(personInfoPo1.getPersoncompanyid());
		}	

		// 取得所有角色
		RolePo tpo = new RolePo();
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			tpo.setRolecompanyid(personInfoPo1.getPersoncompanyid());
		}		
		roles = personInfoMgr.getRolesByCompanyType(tpo);

		// 取所有部门
		PersonInfoPo dpersonInfo = new PersonInfoPo();
		dpersonInfo.setPersoncompanyid(personInfoPo1.getPersoncompanyid());
		dpersonInfo.setPersoncompanytype(personInfoPo1.getPersoncompanytype());
		
		departments = departmentsMgr.getDepartments(dpersonInfo);
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);

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
		
		int count = personInfoMgr.getPersoninfosCount(personInfo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			persons = personInfoMgr.getPersonInfos(personInfo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		
		request.setAttribute("companysid", companysid);
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		setRequest();
		
		return SUCCESS;
	}

	public String initPersonInfoInsert() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
				
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			RolePo tpo = new RolePo();
			tpo.setRolecompanyid(personInfoPo1.getPersoncompanyid());
			roles = personInfoMgr.getRolesByCompanyType(tpo);
		}
				
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String deptid = Utility.getName(request.getParameter("deptid"));
		String deptName = Utility.getName(request.getParameter("deptName"));
		String roleid = Utility.getName(request.getParameter("roleid"));
		String roleName = Utility.getName(request.getParameter("roleName"));
		
		personInfoPo = new PersonInfoPo();
		personInfoPo.setRoleid(roleid);
		personInfoPo.setRolename(roleName);		
		personInfoPo.setBdpdepartmentname(deptName);
		personInfoPo.setDepartmentID(deptid);
		
		personJobTypePos = personInfoMgr.getPersonJobTypeList();
			
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		
		return SUCCESS;
	}

	/**
	 * 人员新增
	 * 
	 * @param personInfoPo
	 */
	public String insertPersonInfo() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1= (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String[] departmentIDS = personInfoPo.getDepartmentID().split(",");
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		personDepartments = new ArrayList<PersonDepartmentsPo>();
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		for (int i = 0; i < departmentIDS.length; i++) {
			PersonDepartmentsPo personDepartmentsPo = new PersonDepartmentsPo();
			personDepartmentsPo.setPersonID(personInfoPo.getId());
			personDepartmentsPo.setDepartmentID(departmentIDS[i]);
			personDepartments.add(personDepartmentsPo);
		}
		
		PersonInfoPo temp = new PersonInfoPo();
		temp.setId(personInfoPo.getId());
		
		temp.setAllocationFlag(personInfoPo.getAllocationFlag());

		if (!"".equals(Utility.getName(personInfoMgr.getPersonInfo(temp).getId()))) {

			// 取得所有角色
			roles = personInfoMgr.getRoles();

			// 取所有部门
			departments = departmentsMgr.getDepartments();
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			this.clearMessages();
			this.addActionMessage(getText("no.repeat"));

			return "NoRepeat";
		}

		// 初始化密码
		personInfoPo.setUserState("0");
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("人员 :" + personInfoPo.getId() + "新增!");
		roles = personInfoMgr.getRoles();
		this.clearMessages();
		
		if(personInfoPo.getId().equals("admin")){
			this.addActionMessage(getText("员工ID不能为admin!")); 
			return "error"; 
		}
		
		int flagName=0;
		if(!Utility.getName(personInfoPo.getCardid()).equals(""))	
		{
			flagName=personInfoMgr.getPersonInfoPoName(personInfoPo);
		}
		
		LogisticsLogPo logPo1 = new LogisticsLogPo();
		logPo1.setsLogName(createPerson);
		logPo1.setsLogIP(request.getRemoteAddr());
		logPo1.setsLogResult(moduleID); // 表示模块名称 
		logPo1.setsLogOpID("1");    // 表示状态
		logPo1.setsLogContent("人员 :" + personInfoPo.getId() + "新增!,添加折扣权限");
		
		PersonDiscountPo personDiscountPo = new PersonDiscountPo();
		
		if(flagName==0){ 
			roleDiscountPo = new RoleDiscountPo();
			roleDiscountPo.setFrdroleid(personInfoPo.getRoleid());
			roleDiscountPo = roleDiscountMgr.getRoleDiscount(roleDiscountPo);
			
			personInfoMgr.insertPersonInfo(systemParameterPo,personInfoPo,personDepartments,roleDiscountPo,personDiscountPo,logPo,logPo1);
			
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			if(goodsTree.equals("1"))
			{
				if(parent.equals("1"))
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
				}else
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
				}
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			}

			return SUCCESS;
		}else 
		{ 
			// 取得所有角色
			roles = personInfoMgr.getRoles();

			// 取所有部门
			departments = departmentsMgr.getDepartments();
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			this.addActionMessage(getText("员工卡号重复")); 
			return "error"; 
		}
		
		
	}

	/**
	 * 初始化更新人员
	 * 
	 * @param personInfoPo
	 */
	public String initPersonInfoUpdate() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		personInfoPo = new PersonInfoPo();
		personInfoPo.setId(request.getParameter("hid"));		
		personInfoPo = personInfoMgr.getPersonInfo(personInfoPo);
				
		RolePo tpo = new RolePo();
		tpo.setRolecompanyid(personInfoPo.getPersoncompanyid());	
		roles = personInfoMgr.getRolesByCompanyType(tpo);
		
		personJobTypePos = personInfoMgr.getPersonJobTypeList();
		
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));

		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		
		return SUCCESS;
	}

	/**
	 * 更新人员
	 * 
	 * @param personInfoPo
	 */
	public String updatePersonInfo() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		String[] departmentIDS = personInfoPo.getDepartmentID().split(",");
		String[] departmentIDName = personInfoPo.getBdpdepartmentname().split(",");
		personDepartments = new ArrayList<PersonDepartmentsPo>();
		
		for (int i = 0; i < departmentIDS.length; i++) {
			PersonDepartmentsPo personDepartmentsPo = new PersonDepartmentsPo();
			personDepartmentsPo.setPersonID(personInfoPo.getId());
			personDepartmentsPo.setDepartmentID(departmentIDS[i]);
			personDepartmentsPo.setDepartmentName(departmentIDName[i]);
			personDepartments.add(personDepartmentsPo);
		}
		
		personInfoPo.setUserState("0");
		personInfoPo.setUpdatepersonid(personInfoPo1.getId());
		personInfoPo.setUpdatepersonname(personInfoPo1.getPersonName());
		
		// 添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("人员 :" + personInfoPo.getId() + "修改!");
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		this.clearMessages();
		
		int flagName=0;
		if(!Utility.getName(personInfoPo.getCardid()).equals(""))	
		{
			flagName=personInfoMgr.getPersonInfoPoNameUpdate(personInfoPo);
		}
		
		PersonDiscountPo tempPo = null;
		PersonDiscountPo personDiscountPo = new PersonDiscountPo();
		
		LogisticsLogPo logPo1 = new LogisticsLogPo();
		logPo1.setsLogName(createPerson);
		logPo1.setsLogIP(request.getRemoteAddr());
		logPo1.setsLogResult(moduleID); // 表示模块名称 
		logPo1.setsLogOpID("1");    // 表示状态
		logPo1.setsLogContent("人员 :" + personInfoPo.getId() + "修改!修改折扣权限!");
		
		if(flagName==0){ 
			String changeDiscount = Utility.getName(request.getParameter("changeDiscount"));
			if(CHANGE_DISCOUNT.equals(changeDiscount)) {
				PersonInfoPo currentPerson = personInfoMgr.getPersonInfo(personInfoPo);
				
				RoleDiscountPo oldRoleDiscountPo = new RoleDiscountPo();
				oldRoleDiscountPo.setFrdroleid(currentPerson.getRoleid());
				oldRoleDiscountPo = roleDiscountMgr.getRoleDiscount(oldRoleDiscountPo);
				
				roleDiscountPo = new RoleDiscountPo();
				roleDiscountPo.setFrdroleid(personInfoPo.getRoleid());
				roleDiscountPo = roleDiscountMgr.getRoleDiscount(roleDiscountPo);
								
				personDiscountPo.setFpdpersonid(personInfoPo.getId());
				personDiscountPo.setFpddiscount(roleDiscountPo.getFrddiscount());
				
				tempPo = personDiscountMgr.getPersonDiscountDetail(personDiscountPo);
				personDiscountPo.setFpdspecialdiscount(Utility.getName(tempPo.getFpdspecialdiscount()));
				personDiscountPo.setFpdspecialdiscountnumber(Utility.getName(tempPo.getFpdspecialdiscountnumber()));
			}
			
			personInfoMgr.updatePersonInfo(systemParameterPo,personInfoPo,personDepartments,roleDiscountPo,tempPo,personDiscountPo,logPo,logPo1);
			
			this.addActionMessage(getText("struts.messages.update.sucess"));
			if(goodsTree.equals("1"))
			{
				if(parent.equals("1"))
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
				}else
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
				}
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			}

			return SUCCESS;
		}else 
		{ 
			// 取得所有角色
			roles = personInfoMgr.getRoles();
			this.addActionMessage(getText("员工卡号重复")); 
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			return "error"; 
		}
		
		
	}

	public String initPersonInfoDelete() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		personInfoPo = new PersonInfoPo();
		personInfoPo.setId(request.getParameter("hid"));

		personInfoPo = personInfoMgr.getPersonInfo(personInfoPo);
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));

		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		return SUCCESS;
	}

	public String deletePersonInfo() {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("人员 :" + Utility.getName(request.getParameter("hid")) + "删除!");
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		int flagName=0;
		flagName=personInfoMgr.getPersonInfoPoNameSelect(Utility.getName(request.getParameter("hid")));
		if(flagName>0)
		{
			this.clearMessages();
			this.addActionMessage(getText("对不起，该人员已经使用过业务单据，不能进行删除。"));
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}else
		{
			personInfoMgr.delPerson(systemParameterPo,Utility.getName(request.getParameter("hid")),logPo);
	
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			if(goodsTree.equals("1"))
			{
				if(parent.equals("1"))
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
				}else
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
				}
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			}

			return SUCCESS;
		}
	}

	private void setRequest() {
		request.setAttribute("selId", request.getParameter("selId"));
		request.setAttribute("selPersonName", request
				.getParameter("selPersonName"));
		request.setAttribute("selDepartmentID", request
				.getParameter("selDepartmentID"));
		request.setAttribute("selDepartmentName", Utility.getName(request.getParameter("selDepartmentName")));
		request.setAttribute("selRoleid", request.getParameter("selRoleid"));
		request.setAttribute("isinvocation", request.getParameter("isinvocation"));
	}
	
	public String initUpdatePersonInfoInvocation() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String cid = Utility.getName(request.getParameter("cid"));
		PersonInfoPo personInfo1 = new PersonInfoPo();
		personInfo1.setId(cid);
		
		PersonInfoPo personInfo = personInfoMgr.getPersonInfo(personInfo1);
		
		request.setAttribute("personInfo", personInfo);
		return SUCCESS;
	}
	
	
	public String updatePersonInfoInvocation() {
		
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
		String invocation = Utility.getName(request.getParameter("invocation"));
		String cid = Utility.getName(request.getParameter("cid"));
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		if("0".equals(invocation)){
			logPo.setsLogOpID("39");    // 停用
			logPo.setsLogContent("人员 :" + cid + "停用!");
		}else if("1".equals(invocation)){
			logPo.setsLogOpID("38");    // 启用
			logPo.setsLogContent("人员 :" + cid + "启用!");
		}
		
		PersonInfoPo personInfoPo1 = new PersonInfoPo();
		personInfoPo1.setIsinvocation(invocation);
		personInfoPo1.setId(cid);
		personInfoPo1.setUpdatepersonid(personInfoPo.getId());
		personInfoPo1.setUpdatepersonname(personInfoPo.getPersonName());
		
		personInfoMgr.isInvocationUpdate(personInfoPo1,logPo);
	
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
	
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	public String exportPersonInfo() throws Exception {

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
		
		PersonInfoPo personInfo = new PersonInfoPo();
		personInfo.setId(request.getParameter("selId"));
		personInfo.setPersonName(request.getParameter("selPersonName"));
		personInfo.setDepartmentID(request.getParameter("selDepartmentID"));
		personInfo.setRoleid(request.getParameter("selRoleid"));
		personInfo.setIsinvocation(request.getParameter("isinvocation"));
		personInfo.setPersoncompanyid(Utility.getName(request.getParameter("companysid")));
	    
		setFileName(java.net.URLEncoder.encode("员工信息导出表.xls", "UTF-8"));
		
		try {
			inputStream = personInfoMgr.bulidPersonInfoExcel(personInfo);
		} catch (Exception e) {
			System.out.println("员工信息导出失败：" + e.getMessage());
		}

		return SUCCESS;
	}
	
	/**
	 * 人员详情
	 * @return
	 */
	public String initPersonInfoDetail(){
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		personInfoPo = new PersonInfoPo();
		personInfoPo.setId(Utility.getName(request.getParameter("selId")));
		
		personInfoPo = personInfoMgr.getPersonInfo(personInfoPo);
		
		personJobTypePos = personInfoMgr.getPersonJobTypeList();
		
		return SUCCESS;
	}
	
	public String initPersonInfoInsertSupplier() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		RolePo tpo = new RolePo();
				
		roles = personInfoMgr.getRolesByCompanyType(tpo);
		personInfoPo=new PersonInfoPo();
		// 取所有部门
		departments = departmentsMgr.getDepartments();
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String deptid = Utility.getName(request.getParameter("deptid"));
		String deptName = Utility.getName(request.getParameter("deptName"));
		String roleid = Utility.getName(request.getParameter("roleid"));
		String roleName = Utility.getName(request.getParameter("roleName"));
		String hid = Utility.getName(request.getParameter("hid"));
		
		personInfoPo.setRoleid(roleid);
		personInfoPo.setRolename(roleName);
		
		personInfoPo.setBdpdepartmentname(deptName);
		personInfoPo.setDepartmentID(deptid);
		
		personJobTypePos = personInfoMgr.getPersonJobTypeList();
			
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		request.setAttribute("hid", hid);
		return SUCCESS;
	}
	


	/**
	 * 制造商人员新增
	 * 
	 * @param personInfoPo
	 */
	public String insertPersonInfoSupplier() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1= (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String[] departmentIDS = personInfoPo.getDepartmentID().split(",");
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		personDepartments = new ArrayList<PersonDepartmentsPo>();
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		String hid = Utility.getName(request.getParameter("hid"));
		personInfoPo.setSyspsupplierid(hid);
		
		request.setAttribute("hid", hid);
		
		for (int i = 0; i < departmentIDS.length; i++) {
			PersonDepartmentsPo personDepartmentsPo = new PersonDepartmentsPo();
			personDepartmentsPo.setPersonID(personInfoPo.getId());
			personDepartmentsPo.setDepartmentID(departmentIDS[i]);
			personDepartments.add(personDepartmentsPo);
		}
		
		PersonInfoPo temp = new PersonInfoPo();
		temp.setId(personInfoPo.getId());
		
		temp.setAllocationFlag(personInfoPo.getAllocationFlag());

		if (!"".equals(Utility.getName(personInfoMgr.getPersonInfo(temp).getId()))) {

			// 取得所有角色
			roles = personInfoMgr.getRoles();

			// 取所有部门
			departments = departmentsMgr.getDepartments();
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			this.clearMessages();
			this.addActionMessage(getText("no.repeat"));

			return "NoRepeat";
		}

		// 初始化密码
		personInfoPo.setUserState("0");
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("制造商人员 :" + personInfoPo.getId() + "新增!");
		roles = personInfoMgr.getRoles();
		this.clearMessages();
		
		if(personInfoPo.getId().equals("admin")){
			this.addActionMessage(getText("员工ID不能为admin!")); 
			return "error"; 
		}
		
		int flagName=0;
		if(!Utility.getName(personInfoPo.getCardid()).equals("")){
			flagName=personInfoMgr.getPersonInfoPoName(personInfoPo);
		}
		
		LogisticsLogPo logPo1 = new LogisticsLogPo();
		logPo1.setsLogName(createPerson);
		logPo1.setsLogIP(request.getRemoteAddr());
		logPo1.setsLogResult(moduleID); // 表示模块名称 
		logPo1.setsLogOpID("1");    // 表示状态
		logPo1.setsLogContent("人员 :" + personInfoPo.getId() + "新增!,添加折扣权限");
		
		PersonDiscountPo personDiscountPo = new PersonDiscountPo();
		
		if(flagName==0){ 
			roleDiscountPo = new RoleDiscountPo();
			roleDiscountPo.setFrdroleid(personInfoPo.getRoleid());
			roleDiscountPo = roleDiscountMgr.getRoleDiscount(roleDiscountPo);
			personInfoMgr.insertPersonInfoSupplier(systemParameterPo,personInfoPo,personDepartments,roleDiscountPo,personDiscountPo,logPo,logPo1);
			
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			if(goodsTree.equals("1")){
				if(parent.equals("1")){
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
				}else{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
				}
			}else{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			}

			return SUCCESS;
		}else { 
			// 取得所有角色
			roles = personInfoMgr.getRoles();

			// 取所有部门
			departments = departmentsMgr.getDepartments();
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			this.addActionMessage(getText("员工卡号重复")); 
			return "error"; 
		}
	}
	
	/**
	 * 初始化更新人员
	 * 
	 * @param personInfoPo
	 */
	public String initPersonInfoUpdateSupplier() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		RolePo tpo = new RolePo();
				
		roles = personInfoMgr.getRolesByCompanyType(tpo);
		
		personInfoPo = new PersonInfoPo();
		personInfoPo.setSyspsupplierid(request.getParameter("hid"));
		
		personInfoPo = personInfoMgr.getPersonInfoSupplier(personInfoPo);
		
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String hid = Utility.getName(request.getParameter("hid"));
		
		request.setAttribute("hid", hid);
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		return SUCCESS;
	}

	/**
	 * 更新人员
	 * 
	 * @param personInfoPo
	 */
	public String updatePersonInfoSupplier() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		String[] departmentIDS = personInfoPo.getDepartmentID().split(",");
		personDepartments = new ArrayList<PersonDepartmentsPo>();
		
		for (int i = 0; i < departmentIDS.length; i++) {
			PersonDepartmentsPo personDepartmentsPo = new PersonDepartmentsPo();
			personDepartmentsPo.setPersonID(personInfoPo.getId());
			personDepartmentsPo.setDepartmentID(departmentIDS[i]);
			personDepartments.add(personDepartmentsPo);
		}
		
		personInfoPo.setUserState("0");
		personInfoPo.setUpdatepersonid(personInfoPo1.getId());
		personInfoPo.setUpdatepersonname(personInfoPo1.getPersonName());
		
		// 添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("人员 :" + personInfoPo.getId() + "修改!");
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		this.clearMessages();
		
		int flagName=0;
		if(!Utility.getName(personInfoPo.getCardid()).equals(""))	
		{
			flagName=personInfoMgr.getPersonInfoPoNameUpdate(personInfoPo);
		}
		
		PersonDiscountPo tempPo = null;
		PersonDiscountPo personDiscountPo = new PersonDiscountPo();
		
		LogisticsLogPo logPo1 = new LogisticsLogPo();
		logPo1.setsLogName(createPerson);
		logPo1.setsLogIP(request.getRemoteAddr());
		logPo1.setsLogResult(moduleID); // 表示模块名称 
		logPo1.setsLogOpID("1");    // 表示状态
		logPo1.setsLogContent("人员 :" + personInfoPo.getId() + "修改!修改折扣权限!");
		
		if(flagName==0){ 
			String changeDiscount = Utility.getName(request.getParameter("changeDiscount"));
			if(CHANGE_DISCOUNT.equals(changeDiscount)) {
				PersonInfoPo currentPerson = personInfoMgr.getPersonInfo(personInfoPo);
				
				RoleDiscountPo oldRoleDiscountPo = new RoleDiscountPo();
				oldRoleDiscountPo.setFrdroleid(currentPerson.getRoleid());
				oldRoleDiscountPo = roleDiscountMgr.getRoleDiscount(oldRoleDiscountPo);
				
				roleDiscountPo = new RoleDiscountPo();
				roleDiscountPo.setFrdroleid(personInfoPo.getRoleid());
				roleDiscountPo = roleDiscountMgr.getRoleDiscount(roleDiscountPo);
								
				personDiscountPo.setFpdpersonid(personInfoPo.getId());
				personDiscountPo.setFpddiscount(roleDiscountPo.getFrddiscount());
				
				tempPo = personDiscountMgr.getPersonDiscountDetail(personDiscountPo);
				personDiscountPo.setFpdspecialdiscount(Utility.getName(tempPo.getFpdspecialdiscount()));
				personDiscountPo.setFpdspecialdiscountnumber(Utility.getName(tempPo.getFpdspecialdiscountnumber()));
			}
			
			personInfoMgr.updatePersonInfoSupplier(systemParameterPo,personInfoPo,personDepartments,roleDiscountPo,tempPo,personDiscountPo,logPo,logPo1);
			
			this.addActionMessage(getText("struts.messages.update.sucess"));
			if(goodsTree.equals("1"))
			{
				if(parent.equals("1"))
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
				}else
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
				}
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			}

			return SUCCESS;
		}else{ 
			// 取得所有角色
			roles = personInfoMgr.getRoles();
			this.addActionMessage(getText("员工卡号重复")); 
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			return "error"; 
		}
	}
	
	public void getAjaxRole() throws Exception {

		String companyID = Utility.getName(request.getParameter("companyID"));
		
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(companyID.equals("")){
			out.println("<option value=''>----请选择----</option>");
		}else{
			
			RolePo tpo = new RolePo();
			tpo.setRolecompanyid(companyID);
			roles = personInfoMgr.getRolesByCompanyType(tpo);

			Iterator<RolePo> it = roles.iterator();		
			if (it.hasNext()) {
				while (it.hasNext()) {
					RolePo po = it.next();
					out.println("<option value='" + po.getRoleid()+ "' "+(po.getRoleid().equals(companyID)? "selected":"")+">"+po.getRolename()+"</option>");
				}
			}
		}
		
		out.close();
	}

	public RoleDiscountMgr getRoleDiscountMgr() {
		return roleDiscountMgr;
	}

	public void setRoleDiscountMgr(RoleDiscountMgr roleDiscountMgr) {
		this.roleDiscountMgr = roleDiscountMgr;
	}

	public RoleDiscountPo getRoleDiscountPo() {
		return roleDiscountPo;
	}

	public void setRoleDiscountPo(RoleDiscountPo roleDiscountPo) {
		this.roleDiscountPo = roleDiscountPo;
	}

	public PersonDiscountMgr getPersonDiscountMgr() {
		return personDiscountMgr;
	}

	public void setPersonDiscountMgr(PersonDiscountMgr personDiscountMgr) {
		this.personDiscountMgr = personDiscountMgr;
	}
	
}
