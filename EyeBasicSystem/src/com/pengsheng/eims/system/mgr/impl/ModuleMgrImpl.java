package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.system.dao.ModuleDao;
import com.pengsheng.eims.system.mgr.ModuleMgr;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public class ModuleMgrImpl implements ModuleMgr {

	private ModuleDao moduleDao;

	public ModuleDao getModuleDao() {
		return moduleDao;
	}

	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

	public List getSysModuleList() {
		return moduleDao.getSysModuleList();
	}

	public ModulePo getModulePo(String modulePageCode) {
		return moduleDao.getModulePo(modulePageCode);
	}

	public ModulePo getModulePo(String modulePageCode, String moduleId) {
		return moduleDao.getModulePo(modulePageCode, moduleId);
	}

	public int getSysModuleRoleList(String userId) {
		// TODO Auto-generated method stub
		return moduleDao.getSysModuleRoleList(userId);
	}

	public List<ModulePo> getSysModuleListByWhere(PersonInfoPo po) {
		return moduleDao.getSysModuleListByWhere(po);
	}

	public List<ModulePo> getSysModuleLowerListByWhere(String userID,
			String moduleParentID) {

		return moduleDao.getSysModuleLowerListByWhere(userID, moduleParentID);
	}

	public int getCount(ModulePo whereModulePo) {
		return moduleDao.getCount(whereModulePo);
	}

	public int getCountParent(ModulePo whereModulePo) {
		return moduleDao.getCountParent(whereModulePo);
	}

	public int getSysModuleRoleCount(String roleId) {
		// TODO Auto-generated method stub
		return moduleDao.getSysModuleRoleCount(roleId);
	}

	public List getSysModuleListByWhere(ModulePo whereModulePo) {
		return moduleDao.getSysModuleListByWhere(whereModulePo);
	}

	public void updateSysModuleOrderLevelByWhere(ModulePo whereModulePo,
			String newOrderLeve, String updateKey) {
		moduleDao.updateSysModuleOrderLevelByWhere(whereModulePo, newOrderLeve,
				updateKey);
	}

	public List<ModulePo> getSysModuleLowerNullListByWhere(String userID,
			String moduleParentID) {
		// TODO Auto-generated method stub
		return moduleDao.getSysModuleLowerNullListByWhere(userID,
				moduleParentID);
	}

	public List<ModulePo> getSysModuleNullListByWhere(PersonInfoPo po) {
		// TODO Auto-generated method stub
		return moduleDao.getSysModuleNullListByWhere(po);
	}

	public ModulePo getSysModuleBywhere(ModulePo whereModulePo) {
		return moduleDao.getSysModuleBywhere(whereModulePo);
	}

	public void insertSysModuleByWhere(ModulePo whereModulePo) {
		moduleDao.insertSysModuleByWhere(whereModulePo);
	}

	public void updateSysModuleByWhere(ModulePo whereModulePo) {
		moduleDao.updateSysModuleByWhere(whereModulePo);
	}

	public void deleteSysModuleByWhere(ModulePo whereModulePo) {
		moduleDao.deleteSysModuleByWhere(whereModulePo);
	}

	public ModulePo getSysPerentModuleBywhere(String moduleID) {
		return moduleDao.getSysPerentModuleBywhere(moduleID);
	}

}