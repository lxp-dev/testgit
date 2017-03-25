package com.pengsheng.eims.frame.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pengsheng.eims.frame.mgr.RoleModuleTreeViewMgr;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class RoleModuleTreeViewAction extends BaseAction {
	private final String COMPANY_MODULE = "company_module";
	private final String COMPANY_AND_CUSTOMER_MODULE = "company_and_customer_module";
	private RoleModuleTreeViewMgr roleModuleTreeViewMgr;

	private List<ModulePo> rootModules;
	private Map<String, String> myCompanyModule;

	public Map<String, String> initMyCompanyModule() {
		Map<String, String> map = new HashMap<String, String>();
		
		return map;
	}
	
	public RoleModuleTreeViewMgr getRoleModuleTreeViewMgr() {
		return roleModuleTreeViewMgr;
	}

	public void setRoleModuleTreeViewMgr(
			RoleModuleTreeViewMgr roleModuleTreeViewMgr) {
		this.roleModuleTreeViewMgr = roleModuleTreeViewMgr;
	}

	public List<ModulePo> getRootModules() {
		return rootModules;
	}

	public void setRootModules(List<ModulePo> rootModules) {
		this.rootModules = rootModules;
	}

	public String getTreeView() {
		this.clearMessages();
		//初始化公司实施部模块,对客户管理员隐藏
		myCompanyModule = initMyCompanyModule();

		String applicationID = "1";
		PersonInfoPo po = (PersonInfoPo) session.get("person");

		if (roleModuleTreeViewMgr.getRolesWithApplication(po.getId(),applicationID) == 0) {
			this.addActionMessage(this.getText("您没有此权限"));
			return SUCCESS;
		}

		rootModules = roleModuleTreeViewMgr.getRootModules(applicationID);

		for (ModulePo modulePo : rootModules) {
			List<ModulePo> childList = roleModuleTreeViewMgr.getChildModules(applicationID, modulePo.getModuleid(), po);
			List<ModulePo> tempList = new ArrayList<ModulePo>();
			
			if(null != myCompanyModule.get(modulePo.getModuleid().toUpperCase()) 
					&& !"".equals(myCompanyModule.get(modulePo.getModuleid().toUpperCase()))) {
				for (ModulePo childModule : childList) {
					String showOrHidden = myCompanyModule.get(childModule.getModuleid());
					if(null == showOrHidden || showOrHidden.equals(COMPANY_AND_CUSTOMER_MODULE)) {
						tempList.add(childModule);
					}
				}
				modulePo.setChildModules(tempList);
			} else {
				modulePo.setChildModules(childList);
			}
		}
		
		return SUCCESS;
	}

	public String getTreeViewForAdmin() {
		this.clearMessages();
		//初始化公司实施部模块
		myCompanyModule = initMyCompanyModule();
		
		String applicationID = "1";
		PersonInfoPo po = (PersonInfoPo) session.get("person");

		if (roleModuleTreeViewMgr.getRolesWithApplication(po.getId(),
				applicationID) == 0) {
			this.addActionMessage(this.getText("您没有此权限"));
			// request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}

		rootModules = roleModuleTreeViewMgr.getRootModules(applicationID);

		for (ModulePo modulePo : rootModules) {
			List<ModulePo> childList = roleModuleTreeViewMgr.getChildModules(applicationID, modulePo.getModuleid(), po);
			List<ModulePo> tempList = new ArrayList<ModulePo>();
			
			if(null != myCompanyModule.get(modulePo.getModuleid().toUpperCase()) 
					&& !"".equals(myCompanyModule.get(modulePo.getModuleid().toUpperCase()))) {
				for (ModulePo childModule : childList) {
					String showOrHidden = myCompanyModule.get(childModule.getModuleid());
					if(null != showOrHidden && 
							(showOrHidden.equals(COMPANY_MODULE) || 
									showOrHidden.equals(COMPANY_AND_CUSTOMER_MODULE))) {
						
						tempList.add(childModule);
					}
				}
			}
			modulePo.setChildModules(tempList);
		}

		return SUCCESS;
	}
}
