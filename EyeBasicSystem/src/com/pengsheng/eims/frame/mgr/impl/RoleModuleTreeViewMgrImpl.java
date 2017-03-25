package com.pengsheng.eims.frame.mgr.impl;

import java.util.List;

import com.pengsheng.eims.frame.dao.RoleModuleTreeViewDao;
import com.pengsheng.eims.frame.mgr.RoleModuleTreeViewMgr;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public class RoleModuleTreeViewMgrImpl implements RoleModuleTreeViewMgr {

	private RoleModuleTreeViewDao roleModuleTreeViewDao;

	public RoleModuleTreeViewDao getRoleModuleTreeViewDao() {
		return roleModuleTreeViewDao;
	}

	public void setRoleModuleTreeViewDao(
			RoleModuleTreeViewDao roleModuleTreeViewDao) {
		this.roleModuleTreeViewDao = roleModuleTreeViewDao;
	}

	public List<ModulePo> getChildModules(String applicationID,String parentModuleID, PersonInfoPo po) {
		return roleModuleTreeViewDao.getChildModules(applicationID,parentModuleID,po);
	}

	public int getRolesWithApplication(String personID, String applicationID) {
		// TODO Auto-generated method stub
		return roleModuleTreeViewDao.getRolesWithApplication(personID,
				applicationID);
	}

	public List<ModulePo> getRootModules(String applicationID) {
		// TODO Auto-generated method stub
		return roleModuleTreeViewDao.getRootModules(applicationID);
	}

	public List<ModulePo> getChildProjectModules(String applicationID,
			String parentModuleID, String personID, String projectID) {
		// TODO Auto-generated method stub
		return roleModuleTreeViewDao.getChildProjectModules(applicationID,
				parentModuleID, personID, projectID);
	}

}
