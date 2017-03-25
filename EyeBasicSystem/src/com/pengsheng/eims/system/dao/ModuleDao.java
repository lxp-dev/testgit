package com.pengsheng.eims.system.dao;

import java.util.List;

import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface ModuleDao {
	public List getSysModuleList();

	public int getSysModuleRoleList(String userId);
	
	public ModulePo getModulePo(String modulePageCode);
	
	public ModulePo getModulePo(String modulePageCode, String moduleId);
	
	public int getSysModuleRoleCount(String roleId);

	public List<ModulePo> getSysModuleListByWhere(PersonInfoPo po);

	public List<ModulePo> getSysModuleLowerListByWhere(String userID,
			String moduleParentID);

	public int getCount(ModulePo whereModulePo);
	
	public int getCountParent(ModulePo whereModulePo);

	public List getSysModuleListByWhere(ModulePo whereModulePo);

	public void updateSysModuleOrderLevelByWhere(ModulePo whereModulePo,
			String newOrderLeve, String updateKey);

	public ModulePo getSysModuleBywhere(ModulePo whereModulePo);

	public void insertSysModuleByWhere(ModulePo whereModulePo);

	public void updateSysModuleByWhere(ModulePo whereModulePo);

	public void deleteSysModuleByWhere(ModulePo whereModulePo);

	public ModulePo getSysPerentModuleBywhere(String moduleID);
	
	public List<ModulePo> getSysModuleNullListByWhere(PersonInfoPo po);
	
	public List<ModulePo> getSysModuleLowerNullListByWhere(String userID,
			String moduleParentID);
	
	
}