package com.pengsheng.eims.system.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.ApplicationsMgr;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.ModuleMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.RoleMgr;
import com.pengsheng.eims.system.persistence.ApplicationsPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PermissionPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.RolePermissionPo;
import com.pengsheng.eims.system.persistence.RoleTemplatePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class RoleAction extends BaseAction implements ServletRequestAware {

	private RoleMgr roleMgr;

	private RolePo rolePo;

	private ApplicationsMgr applicationsMgr;

	private ModuleMgr moduleMgr;

	public List<ModulePo> moduleParents;

	private PersonPermissionMgr personPermissionMgr;

	private List<RoleTemplatePo> roleTemplateList = null;

	private List<RoleTemplatePo> roleTypeList = null;
	
	private List<ModulePo> rootModules = null;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	private String fileName;
	
	private String savePath;
	
	private InputStream inputStream;
	
	private CompanyNameMgr companyNameMgr;
	private List<CompanyNamePo> companyNameList;
	private List<CompanyNamePo> companyNamePos;
	
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

	public List<CompanyNamePo> getCompanyNameList() {
		return companyNameList;
	}

	public void setCompanyNameList(List<CompanyNamePo> companyNameList) {
		this.companyNameList = companyNameList;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<ModulePo> getRootModules() {
		return rootModules;
	}

	public void setRootModules(List<ModulePo> rootModules) {
		this.rootModules = rootModules;
	}

	public List<RoleTemplatePo> getRoleTemplateList() {
		return roleTemplateList;
	}

	public void setRoleTemplateList(List<RoleTemplatePo> roleTemplateList) {
		this.roleTemplateList = roleTemplateList;
	}

	public List<RoleTemplatePo> getRoleTypeList() {
		return roleTypeList;
	}

	public void setRoleTypeList(List<RoleTemplatePo> roleTypeList) {
		this.roleTypeList = roleTypeList;
	}

	public RoleMgr getRoleMgr() {
		return roleMgr;
	}

	public void setRoleMgr(RoleMgr roleMgr) {
		this.roleMgr = roleMgr;
	}

	public RolePo getRolePo() {
		return rolePo;
	}

	public void setRolePo(RolePo rolePo) {
		this.rolePo = rolePo;
	}

	public ApplicationsMgr getApplicationsMgr() {
		return applicationsMgr;
	}

	public void setApplicationsMgr(ApplicationsMgr applicationsMgr) {
		this.applicationsMgr = applicationsMgr;
	}

	public ModuleMgr getModuleMgr() {
		return moduleMgr;
	}

	public void setModuleMgr(ModuleMgr moduleMgr) {
		this.moduleMgr = moduleMgr;
	}

	public List<ModulePo> getModuleParents() {
		return moduleParents;
	}

	public void setModuleParents(List<ModulePo> moduleParents) {
		this.moduleParents = moduleParents;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public String initRoleList() throws Exception {

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

		String applicationID = "1";// 系统管理 应用编号
		
		rolePo = new RolePo();
		rolePo.setModuleapplicationid(applicationID);
		rolePo.setRoleid(Utility.getName(request.getParameter("hid")));
		rolePo.setRolename(Utility.getName(request.getParameter("roleName2")));
		rolePo.setRoledescription(Utility.getName(request.getParameter("roleDescription2")));
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			rolePo.setRolecompanyid(personInfoPo.getPersoncompanyid());
		}else{
			rolePo.setRolecompanyid(Utility.getName(request.getParameter("companyID")));
		}
		
		List<RolePo> jspSysRoleList = roleMgr.getSysRoleList(rolePo);
		
		request.setAttribute("jspSysRoleList", jspSysRoleList);
		request.setAttribute("roleName2", rolePo.getRolename());
		request.setAttribute("roleDescription2", rolePo.getRoledescription());
		request.setAttribute("personid", personInfoPo.getId());
		    	
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("1")){
			CompanyNamePo cpo = new CompanyNamePo();
		    companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
		}
		request.setAttribute("companyID",rolePo.getRolecompanyid());
		
		return SUCCESS;
	}

	public String initSysRolePermissionManager() throws Exception {

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

		String roleID = request.getParameter("roleID");
		String applicationID = "1";

		if (request.getAttribute("roleID") != null
				&& !request.getAttribute("roleID").toString().equals("")) {
			roleID = request.getAttribute("roleID").toString();
			applicationID = request.getAttribute("applicationID").toString();
		}

		RolePo whereSysRolePo = new RolePo();
		whereSysRolePo.setRoleid(roleID);
		whereSysRolePo.setModuleapplicationid(applicationID);

		RolePo rolePo = new RolePo();
		rolePo = roleMgr.getSysRoleByWhere(whereSysRolePo);

		ApplicationsPo whereSysApplicationsPo = new ApplicationsPo();

		whereSysApplicationsPo.setApplicationID(applicationID);

		ApplicationsPo jspSysApplicationsPo = new ApplicationsPo();
		jspSysApplicationsPo = applicationsMgr
				.getSysApplications(whereSysApplicationsPo);

		ModulePo whereModulePo = new ModulePo(); // 设置查询条件：父级模块ID=0；应用模块ID为传入applicationID；
		whereModulePo.setModuleparentid("0");
		whereModulePo.setModuleapplicationid(applicationID);

		List<ModulePo> jspSysModulesList = new ArrayList<ModulePo>(); // 设置返回到Jsp页面显示的List对象为：jspSysModulesList；其内包括属于传入应用模块ID（moduleApplicationID）下所有主模块对象（ModulePo）；
		List sysModuleList = moduleMgr.getSysModuleListByWhere(whereModulePo); // 根据查询条件whereModulePo，取得返回值：sysModuleList；此对象包括属于moduleApplicationID应用的所有主模块。

		Iterator it = sysModuleList.iterator();// 对返回sysModuleList进行循环处理，对每一个主模块对象添加所属子模块数量；
		while (it.hasNext()) {
			ModulePo sysModulePo = (ModulePo) it.next();

			ModulePo tmpModulePo = new ModulePo(); // 设置查询条件：父级模块ID=0；应用模块ID为传入applicationID；
			tmpModulePo.setModuleparentid(sysModulePo.getModuleid());
			tmpModulePo.setModuleapplicationid(sysModulePo
					.getModuleapplicationid());

			List tmpList = moduleMgr.getSysModuleListByWhere(tmpModulePo);
			List returnList = new ArrayList();
			Iterator tmpIt = tmpList.iterator();
			while (tmpIt.hasNext()) {
				ModulePo tmpModulePo1 = (ModulePo) tmpIt.next();

				RolePermissionPo whereSysRolePermissionPo = new RolePermissionPo();
				whereSysRolePermissionPo.setRoleID(roleID);
				whereSysRolePermissionPo.setApplicationID(applicationID);
				whereSysRolePermissionPo
						.setModuleID(tmpModulePo1.getModuleid());

				if (roleMgr.getPermissionForRole(roleID, applicationID) > 0) {
					List permisionList = roleMgr
							.getSysRolePermissionListByWhere(whereSysRolePermissionPo);
					if (permisionList == null || permisionList.size() == 0) {// 如果sys_rolepermission
						// 没有角色权限，取sys_permission默认权限

						PermissionPo sysPermissionPo = new PermissionPo();
						sysPermissionPo
								.setModuleApplicationID(whereSysRolePermissionPo
										.getApplicationID());
						sysPermissionPo.setModuleID(whereSysRolePermissionPo
								.getModuleID());

						permisionList = roleMgr
								.getSysPermissionListByWhere(sysPermissionPo);
					}
					tmpModulePo1.setRolePermissionList(permisionList);
				} else {
					PermissionPo sysPermissionPo = new PermissionPo();
					sysPermissionPo.setModuleApplicationID(applicationID);
					sysPermissionPo.setModuleID(tmpModulePo1.getModuleid());

					tmpModulePo1.setRolePermissionList(roleMgr
							.getSysPermissionListByWhere(sysPermissionPo));
				}

				returnList.add(tmpModulePo1);
			}

			sysModulePo.setChildList(returnList);
			jspSysModulesList.add(sysModulePo); // 把带有子模块个数的主模块对象添加到返回Jsp页面显示的List对象中；
		}

		request.setAttribute("jspSysModulesList", jspSysModulesList); // 把拼装好的sysModuleList作为属性参数传入到Jsp；
		request.setAttribute("rolePo", rolePo);
		request.setAttribute("jspSysApplicationsPo", jspSysApplicationsPo);

		return SUCCESS;
	}

	public String initRolePermissionModify() throws Exception {

		/** ********************** 权限设置 ***************************** */
		 String moduleID = Utility.getName(request.getParameter("moduleID"));
		 request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */

		String roleID = Utility.getName(request.getParameter("roleID"));		

		RolePo whereSysRolePo = new RolePo();
		whereSysRolePo.setRoleid(roleID);

		rolePo = roleMgr.getSysRoleByWhere(whereSysRolePo);

//		roleTypeList = roleMgr.getRoleTypeList();		
//		roleTypeList = getRoleTypeList(roleTypeList, Utility.getName(rolePo.getRoletypeid()));
//		roleTemplateList = roleMgr.getRoleTemplate();
	
		rootModules = roleMgr.getRootModules();//获取所有根菜单
		if (rootModules != null && rootModules.size() != 0){
			for (ModulePo modulePo : rootModules) {
				List<ModulePo> childModules = roleMgr.getChildModules(modulePo.getModuleid());	//获取某一个菜单下的所有子菜单

				if (childModules != null && childModules.size() != 0){
					for (ModulePo childModulePo : childModules) {
						rolePo.setModuleID(Utility.getName(childModulePo.getModuleid()));
						List<RolePermissionPo> lstRolePermissionPo = roleMgr.getRolePermission(rolePo);	//获取某一个子菜单下的所有权限列表
						
						int rolePermissionCount = 0;
						if (lstRolePermissionPo != null){
							rolePermissionCount = lstRolePermissionPo.size();        					

							List<RolePermissionPo> lstPo = new ArrayList<RolePermissionPo>();
							List<PermissionPo> lstPermission = null;
							String[] sPermissionBuffer = null;
							int sPermissionBufferCount = 0;

							for (int i = 0; i < rolePermissionCount; i++) {					
								lstPermission = new ArrayList<PermissionPo>();
								RolePermissionPo po = (RolePermissionPo)lstRolePermissionPo.get(i);
								if (Utility.getName(po.getsPermissionBuffer()).equals("")){
									continue;
								}
								sPermissionBuffer = po.getsPermissionBuffer().split("@");

								sPermissionBufferCount = sPermissionBuffer.length;
								for (int j = 0; j < sPermissionBufferCount; j++){
									PermissionPo permissionPo = new PermissionPo();						
									permissionPo.setPageValue(sPermissionBuffer[j].substring(0,sPermissionBuffer[j].indexOf(",")));
									permissionPo.setPageName(sPermissionBuffer[j].substring(sPermissionBuffer[j].indexOf(",") + 1,sPermissionBuffer[j].lastIndexOf(",")));
									permissionPo.setPageKey(sPermissionBuffer[j].substring(sPermissionBuffer[j].lastIndexOf(",") + 1,sPermissionBuffer[j].length()));

									lstPermission.add(permissionPo);						
									permissionPo = null;
								}

								po.setLstPermissionPo(lstPermission);
								lstPo.add(po);

								lstPermission = null;
							}

							childModulePo.setLstRolePermissionPo(lstPo);				

							lstRolePermissionPo.clear();
							lstRolePermissionPo = null;				
							lstPo = null;        					
						}

					}
				}
				modulePo.setChildModules(childModules);
			}
		}
		
		return SUCCESS;
	}
	
	public String initRolePermissionModifyNew() throws Exception {

		/** ********************** 权限设置 ***************************** */
		 String moduleID = Utility.getName(request.getParameter("moduleID"));
		 request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */

		String roleID = Utility.getName(request.getParameter("roleID"));		

		RolePo whereSysRolePo = new RolePo();
		whereSysRolePo.setRoleid(roleID);

		rolePo = roleMgr.getSysRoleByWhere(whereSysRolePo);
		rootModules = roleMgr.getRootModules();//获取所有根菜单
		List<ModulePo> moduleList = roleMgr.getAllModules();	//获取某一个菜单下的所有子菜单
		List<PermissionPo> permissionList = roleMgr.getRolePermissionListByRoleID(roleID);
		
		request.setAttribute("moduleList", moduleList);
		request.setAttribute("permissionList", permissionList);
		return SUCCESS;
	}
	
	public String initRolePermissionSet() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo2 = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo2);
		/** ********************** 权限设置 ***************************** */


		rolePo = new RolePo();
	
		rootModules = roleMgr.getInitRootModules();//获取所有根菜单
		if (rootModules != null && rootModules.size() != 0){
			for (ModulePo modulePo : rootModules) {
				List<ModulePo> childModules = roleMgr.getInitChildModules(modulePo.getModuleid());	//获取某一个菜单下的所有子菜单

				if (childModules != null && childModules.size() != 0){
					for (ModulePo childModulePo : childModules) {
						rolePo.setModuleID(Utility.getName(childModulePo.getModuleid()));
						
						List<RolePermissionPo> lstRolePermissionPo = roleMgr.getInitRolePermission(rolePo);	//获取某一个子菜单下的所有权限列表
						
						int rolePermissionCount = 0;
						if (lstRolePermissionPo != null){
							rolePermissionCount = lstRolePermissionPo.size();        					

							List<RolePermissionPo> lstPo = new ArrayList<RolePermissionPo>();
							List<PermissionPo> lstPermission = null;
							String[] sPermissionBuffer = null;
							int sPermissionBufferCount = 0;

							for (int i = 0; i < rolePermissionCount; i++) {					
								lstPermission = new ArrayList<PermissionPo>();
								RolePermissionPo po = (RolePermissionPo)lstRolePermissionPo.get(i);
								if (Utility.getName(po.getsPermissionBuffer()).equals("")){
									continue;
								}
								sPermissionBuffer = po.getsPermissionBuffer().split("@");

								sPermissionBufferCount = sPermissionBuffer.length;
								for (int j = 0; j < sPermissionBufferCount; j++){
									PermissionPo permissionPo = new PermissionPo();						
									permissionPo.setPageValue(sPermissionBuffer[j].substring(0,sPermissionBuffer[j].indexOf(",")));
									permissionPo.setPageName(sPermissionBuffer[j].substring(sPermissionBuffer[j].indexOf(",") + 1,sPermissionBuffer[j].lastIndexOf(",")));
									permissionPo.setPageKey(sPermissionBuffer[j].substring(sPermissionBuffer[j].lastIndexOf(",") + 1,sPermissionBuffer[j].length()));

									lstPermission.add(permissionPo);						
									permissionPo = null;
								}

								po.setLstPermissionPo(lstPermission);
								lstPo.add(po);

								lstPermission = null;
							}

							childModulePo.setLstRolePermissionPo(lstPo);				

							lstRolePermissionPo.clear();
							lstRolePermissionPo = null;				
							lstPo = null;        					
						}

					}
				}
				modulePo.setChildModules(childModules);
			}
		}
		
		return SUCCESS;
	}

	public String rolePermissionSet() throws Exception {
		
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
		logPo.setsLogOpID("40");    // 表示状态
		logPo.setsLogContent("系统模块调整!");
		
		roleMgr.insertInitSysPermission(rolePo,moduleParents,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("url", "'initRolePermissionSet.action?moduleID="+moduleID+"&companyAdmin="+request.getParameter("companyAdmin")+"'");
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	/**
	 * Description :初始化修改角色时对“角色类型”进行处理
	 * @param：list “角色类型”集合
	 * @param：roleTypeID “角色类型ID”字符串
	 * @return :“角色类型”集合
	 */
	private List<RoleTemplatePo> getRoleTypeList(List<RoleTemplatePo> list, String roleTypeID) {

		List<RoleTemplatePo> glist = new ArrayList<RoleTemplatePo>();
		Iterator<RoleTemplatePo> it = list.iterator();
		
		while (it.hasNext()) {
			RoleTemplatePo po = (RoleTemplatePo) it.next();
			String[] roleTypeIDs = roleTypeID.split(",");
			for (int i = 0; i < roleTypeIDs.length; i++) {
				if (po.getTemplateID().equals(roleTypeIDs[i])) {
					po.setTemplateFlag("1");
					break;
				} else {
					po.setTemplateFlag("0");
				}
			}
			glist.add(po);
		}
		return glist;
	}
	
	public String rolePermissionModify() throws Exception {

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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("40");    // 表示状态
		logPo.setsLogContent("角色:" + Utility.getName(rolePo.getRoleid()) + "修改!");
		
		roleMgr.insertSysRolePermission(rolePo,moduleParents,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	/**
	 * Description :修改制造商时对“提供的商品类别”进行处理
	 * @param：goodsCategoryID “商品类别代码”数组
	 * @return :“提供的商品类别”字符串
	 */
	private String getRoleType(String[] roletypeids) {

		String roletypeid = "";
		if (roletypeids != null) {
			for (int i = 0; i < roletypeids.length; i++) {

				if ("".equals(roletypeid)) {
					roletypeid = roletypeids[i];
				} else {
					roletypeid = roletypeid + "," + roletypeids[i];
				}
			}
		}

		return roletypeid;
	}
	
	public String initSysRoleManager() throws Exception {

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

		String roleID = request.getParameter("roleID");
		String applicationID = "1";

		RolePo whereSysRolePo = new RolePo();
		whereSysRolePo.setRoleid(roleID);
		whereSysRolePo.setModuleapplicationid(applicationID);

		RolePo rolePo = new RolePo();
		rolePo = roleMgr.getSysRoleByWhere(whereSysRolePo);

		request.setAttribute("rolePo", rolePo);

		return SUCCESS;
	}

	public String initRoleAdd() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		/** ********************** 权限设置 ***************************** */
		
		rolePo = new RolePo();
		rootModules = roleMgr.getRootModules();//获取所有根菜单
		
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("1")){
			CompanyNamePo cpo = new CompanyNamePo();
			companyNameList = companyNameMgr.getCompanyNameForSelect(cpo);
		}

		if (rootModules != null && rootModules.size() != 0){
		    for (ModulePo modulePo : rootModules) {
			    List<ModulePo> childModules = roleMgr.getChildModules(modulePo.getModuleid());	//获取某一个菜单下的所有子菜单

				if (childModules != null && childModules.size() != 0){
				    for (ModulePo childModulePo : childModules) {

           			    List<RolePermissionPo> lstRolePermissionPo = roleMgr.getModulePermission(childModulePo);	//获取某一个子菜单下的所有权限列表
			    	    int rolePermissionCount = 0;
					    if (lstRolePermissionPo != null){
						    rolePermissionCount = lstRolePermissionPo.size();        					

						    List<RolePermissionPo> lstPo = new ArrayList<RolePermissionPo>();
						    List<PermissionPo> lstPermission = null;
						    String[] sPermissionBuffer = null;
						    int sPermissionBufferCount = 0;

						    for (int i = 0; i < rolePermissionCount; i++) {					
							    lstPermission = new ArrayList<PermissionPo>();
							    RolePermissionPo po = (RolePermissionPo)lstRolePermissionPo.get(i);
							    if (Utility.getName(po.getsPermissionBuffer()).equals("")){
								    continue;
							    }
							    sPermissionBuffer = po.getsPermissionBuffer().split("@");

						        sPermissionBufferCount = sPermissionBuffer.length;
						        for (int j = 0; j < sPermissionBufferCount; j++){
						            PermissionPo permissionPo = new PermissionPo();						
							        permissionPo.setPageValue(sPermissionBuffer[j].substring(0,sPermissionBuffer[j].indexOf(",")));
							        permissionPo.setPageName(sPermissionBuffer[j].substring(sPermissionBuffer[j].indexOf(",") + 1,sPermissionBuffer[j].length()));

							        lstPermission.add(permissionPo);						
							        permissionPo = null;
						        }

						        po.setLstPermissionPo(lstPermission);
						        lstPo.add(po);

 						        lstPermission = null;
				            }

							childModulePo.setLstRolePermissionPo(lstPo);				

							lstRolePermissionPo.clear();
							lstRolePermissionPo = null;				
							lstPo = null;        					
						}

					}
				}
				modulePo.setChildModules(childModules);
			}
		}
			
		return SUCCESS;
	}

	public String roleAdd() throws Exception {
		/** ********************** 权限设置 ***************************** */
		 String moduleID = Utility.getName(request.getParameter("moduleID"));
		 request.setAttribute("moduleID", moduleID);
		 PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		 String createPerson = personInfoPo.getId();
		/** ********************** 权限设置 ***************************** */

		String[] roletypeids = request.getParameterValues("roletypeids");
		String roletypeid = getRoleType(roletypeids);			
		rolePo.setRoletypeid(roletypeid);
		
		String applicationID = "1";
		rolePo.setModuleapplicationid(applicationID);
		rolePo.setRoleid(uuid.generate());
	
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("角色:" + Utility.getName(rolePo.getRoleid()) + "新增!");
		
		roleMgr.insertSysRole(rolePo,moduleParents,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	public String initRoleModify() throws Exception {

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

		String roleID = request.getParameter("roleID");

		RolePo whereSysRolePo = new RolePo();
		whereSysRolePo.setRoleid(roleID);

		RolePo rolePo = new RolePo();
		rolePo = roleMgr.getSysRoleByWhere(whereSysRolePo);

		request.setAttribute("rolePo", rolePo);

		return SUCCESS;
	}

	public String roleModify() throws Exception {

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
			logPo.setsLogContent("角色:" + Utility.getName(rolePo.getRoleid()) + "修改!");
			
		roleMgr.updateSysRole(rolePo,logPo);
		String roleID = rolePo.getRoleid();

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		// String url = "''initSysRoleManager.action?roleID=" + roleID
		// + "&moduleID={0}''";
		//
		// List<String> params = new ArrayList<String>();
		// params.add(moduleID);
		//
		// request
		// .setAttribute("url", MessageFormat
		// .format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	public String initRoleDelete() throws Exception {
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
		 
		String roleID = request.getParameter("roleID");

		RolePo whereSysRolePo = new RolePo();
		whereSysRolePo.setRoleid(roleID);

		rolePo = roleMgr.getSysRoleByWhere(whereSysRolePo);

		return SUCCESS;
	}

	public String roleDelete() throws Exception {

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

		String roleID = request.getParameter("roleID");
		String applicationID = "1";
		RolePo whereSysRolePo = new RolePo();
		whereSysRolePo.setRoleid(roleID);
		this.clearMessages();
		
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent(roleID);
		logPo.setsLogContent("角色:" + Utility.getName(roleID) + "删除!");
		
		int count = roleMgr.getPersonForRole(roleID, applicationID);
		if (count == 0) {
			whereSysRolePo.setModuleapplicationid(applicationID);
			roleMgr.deleteSysRole(whereSysRolePo,logPo);
			this.addActionMessage(getText("struts.messages.delete.sucess"));
		} else {
			this.addActionMessage(getText("struts.messages.delete.error"));
		}

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	/**
	 * 导出excel信息页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exportFileExcel() throws Exception {
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
		
		SystemParameterPo systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		
		setFileName(java.net.URLEncoder.encode("期初权限信息.xls", "UTF-8"));
		
		try {
			
			String url = ServletActionContext.getServletContext().getRealPath(this.getSavePath());
			inputStream = roleMgr.insertExportExcel(systemParameterPo,url,logPo);
		} catch (Exception e) {
			System.out.println("期初权限信息导出失败：" + e.getMessage());
		}
			
		return SUCCESS;
	}
	
	public String initRoleCopyInsert() throws Exception {
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
		
		CompanyNamePo cpo = new CompanyNamePo();
	    companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
	    
		return SUCCESS;
	}
	
	public String insertRoleCopyInfo() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("复制公司【" + Utility.getName(rolePo.getRolecompanyid()) + "】下的角色及权限，至公司【" + Utility.getName(rolePo.getRoleothercompanyid()) + "】下!");
		
		roleMgr.insertRoleCopyInfo(rolePo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
}
