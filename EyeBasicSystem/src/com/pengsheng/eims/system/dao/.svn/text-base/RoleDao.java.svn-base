package com.pengsheng.eims.system.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PermissionPo;
import com.pengsheng.eims.system.persistence.RolePermissionPo;
import com.pengsheng.eims.system.persistence.RoleTemplatePo;

public interface RoleDao {

	public List<RolePo> getSysRoleList(RolePo po);
	
	public int getPMpersonCount(String pmName, String applicationID);

	public void insertSysRole(RolePo sysRolePo);

	public RolePo getSysRoleByWhere(RolePo sysRolePo);

	public void updateSysRole(RolePo whereSysRolePo);

	public void updateRole(RolePo rolePo);

	public void deleteSysRole(RolePo whereSysRolePo);

	public void insertSysRolePermissionByWhere(RolePermissionPo whereSysRolePermissionPo);
	
	public void insertSysRolePermissions(String roleID , List<ModulePo> moduleParents);

	public void deleteSysRolePermissionByWhere(RolePermissionPo whereSysRolePermissionPo);

	public int getPersonForRole(String roleID, String moduleApplicationID);
	
	public int getPermissionForRole(String roleID, String moduleApplicationID);
	
	public int getProjectForRole(String roleID, String moduleApplicationID);
	
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
	 * Description :删除角色权限对应关系
	 */
	public void deleteRolePersonRelationShip(RolePo rolesPo);
	
	/**
	 * Description :获取当前模块的所有权限
	 * 
	 * @param  模块实体类
	 * @return 得到当前模块的所有权限
	 */
	public List<RolePermissionPo> getModulePermission(ModulePo childModulePo);
		
	/**
	 * Description :新增角色权限
	 *
	 * @param 角色权限实体类
	 */
	public void rolePermissionInsert(RolePermissionPo rolePermissionPo);
	
	/**
	 * 删除权限
	 */
	public void deleteSyStemPermission(ModulePo po);
	
	/**
	 * 删除节点
	 */
	public void deleteSyStemModule(ModulePo po);
	
	/**
	 * 新增权限
	 */
	public void insertSyStemPermission(RolePermissionPo po);
	
	/**
	 * 新增节点
	 */
	public void insertSyStemModule(ModulePo po);
	
	public List<ModulePo> getModuleList();
	
	public List<PermissionPo> getPermissionList();
	
	public void insertRoleCopyInfo(RolePo rolePo);
	
}