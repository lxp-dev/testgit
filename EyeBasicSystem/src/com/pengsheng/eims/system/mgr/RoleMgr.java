package com.pengsheng.eims.system.mgr;

import java.io.InputStream;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PermissionPo;
import com.pengsheng.eims.system.persistence.RolePermissionPo;
import com.pengsheng.eims.system.persistence.RoleTemplatePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

/**
 * Function：
 * 
 * @author Mysflying E-mail:mysflying@126.com
 * 
 * @version Create Date：2009-5-15 上午11:46:31
 * 
 */

public interface RoleMgr {
	public List<RolePo> getSysRoleList(RolePo po);
	
	public int getPMpersonCount(String pmName, String applicationID);
	
	public List<RolePermissionPo> getSysPermissionListByWhere(PermissionPo sysPermissionPo);
	
	public void insertSysRole(RolePo sysRolePo,List<ModulePo> moduleParents,LogisticsLogPo logPo);
	
	public RolePo getSysRoleByWhere(RolePo sysRolePo);
	
	public void updateSysRole(RolePo whereSysRolePo,LogisticsLogPo logPo);
	
	public void deleteSysRole(RolePo whereSysRolePo,LogisticsLogPo logPo);
	
	public List<RolePermissionPo> getSysRolePermissionListByWhere(RolePermissionPo whereSysRolePermissionPo);
	
	public void insertSysRolePermissionByWhere(RolePermissionPo whereSysRolePermissionPo);
	
	public void deleteSysRolePermissionByWhere(RolePermissionPo whereSysRolePermissionPo);

	public int getPersonForRole(String roleID, String moduleApplicationID);
	
	public int getPermissionForRole(String roleID, String moduleApplicationID);
	
	public int getProjectForRole(String roleID, String moduleApplicationID);
	
	public void insertSysRolePermission(RolePo rolePo,List<ModulePo> moduleParents,LogisticsLogPo logPo);
	
	public void insertInitSysPermission(RolePo rolePo,List<ModulePo> moduleParents,LogisticsLogPo logPo);
	
	/**
	 * 导出excel
	 * 
	 * @param personInfoPo
	 */
	public InputStream insertExportExcel(SystemParameterPo systemParameterPo,String url,LogisticsLogPo logPo) throws Exception;
	
	/*
	 * 获取角色模板
	 */
	public List<RoleTemplatePo> getRoleTemplate();

	/**
	 * Description :获取角色类型列表
	 * @return :角色类型列表
	 */
	public List<RoleTemplatePo> getRoleTypeList();
	
	/**
	* Description :获取根菜单列表
	* @return :根菜单列表
	*/
	public List<ModulePo> getRootModules();
	
	/**
	* Description :获取所有菜单列表
	* @return :所有菜单列表
	*/
	public List<ModulePo> getAllModules();
	
	/**
	* Description :获取根菜单列表
	* @return :根菜单列表
	*/
	public List<ModulePo> getInitRootModules();
	
	/**
	 * Description :得到父节点下所有的子模块
	 * 
	 * @param parentModuleID 父类模块ID
	 * @return 当前父节点下所有的子模块
	 */
	public List<ModulePo> getChildModules(String parentModuleID);
	
	/**
	 * Description :得到父节点下所有的子模块
	 * 
	 * @param parentModuleID 父类模块ID
	 * @return 当前父节点下所有的子模块
	 */
	public List<ModulePo> getInitChildModules(String parentModuleID);
	
	/**
	 * Description :获取所有权限
	 * 
	 * @param  String roleID
	 * @return 得到所有权限
	 */
	public List<PermissionPo> getRolePermissionListByRoleID(String roleID);
	
	/**
	 * Description :获取当前角色的所有权限
	 * 
	 * @param  模块实体类
	 * @return 得到当前角色的所有权限
	 */
	public List<RolePermissionPo> getRolePermission(RolePo rolesPo);
	
	/**
	 * Description :获取当前角色的所有权限
	 * 
	 * @param  模块实体类
	 * @return 得到当前角色的所有权限
	 */
	public List<RolePermissionPo> getInitRolePermission(RolePo rolesPo);
	
	/**
	 * Description :获取当前模块的所有权限
	 * 
	 * @param  模块实体类
	 * @return 得到当前模块的所有权限
	 */
	public List<RolePermissionPo> getModulePermission(ModulePo childModulePo);
	
	public void insertRoleCopyInfo(RolePo rolePo,LogisticsLogPo logPo);
	
}
