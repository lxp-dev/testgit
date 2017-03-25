package com.pengsheng.eims.basic.dao;

import java.util.List;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PermissionPo;

public interface SystemModuleDao {
	
	/**
	 * 取module中的父节点List
	 * @return
	 */
	public List<ModulePo> getSystemModuleMaxList();
	
	/**
	 * 取module中子节点List
	 * @return
	 */
	public List<ModulePo> getSystemModuleMinList(ModulePo po);	

	/**
	 * 取指定modile节点
	 * @return
	 */
	public ModulePo getSystemModule(ModulePo po);

	/**
	 * 插入modile节点
	 * 
	 */
	public void insertSystemModule(ModulePo po);

	/**
	 * 更新modile节点
	 * 
	 */
	public void updateSystemModule(ModulePo po);

	/**
	 * 删除modile节点
	 * 
	 */
	public void deleteSystemModule(ModulePo po);
	
	/**
	 * 停用modile节点
	 * 
	 */
	public void disableSystemModule(ModulePo po);
	
	/**
	 * 启用modile节点
	 * 
	 */
	public void ableSystemModule(ModulePo po);
	
	public void insertModule(ModulePo modulePo);
	
	public void insertPermission(PermissionPo permissionPo);
	
	public void deleteModule();
	
	public void deletePermission();
	
}
