package com.pengsheng.eims.frame.dao;

import java.util.List;

import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface RoleModuleTreeViewDao {

	public int getRolesWithApplication(String personID, String applicationID);

	/**
	 * 得到所有根节点
	 * 
	 * @param applicationID
	 * @return
	 */
	public List<ModulePo> getRootModules(String applicationID);

	/**
	 * 得到父节点下所有的子模块
	 * 
	 * @param applicationID
	 * @param parentModuleID
	 * @return
	 */
	public List<ModulePo> getChildModules(String applicationID,
			String parentModuleID, PersonInfoPo po);

	/**
	 * 得到项目父节点下所有的子模块
	 * 
	 * @param applicationID
	 * @param parentModuleID
	 * @return
	 */
	public List<ModulePo> getChildProjectModules(String applicationID,
			String parentModuleID, String personID, String projectID);

}
