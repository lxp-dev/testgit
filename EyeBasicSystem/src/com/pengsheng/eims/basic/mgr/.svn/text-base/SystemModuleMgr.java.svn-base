package com.pengsheng.eims.basic.mgr;

import java.io.File;
import java.util.List;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface SystemModuleMgr {
	
	/**
	 * 取module表List
	 * @return
	 */
	public List<ModulePo> getSystemModuleMaxList();
	
	/**
	 * 取module表List
	 * 
	
	 */
	public List<ModulePo> getSystemModuleMinList(ModulePo po);	

	/**
	 * 取指定module表数据
	 * @return
	 */
	public ModulePo getSystemModule(ModulePo po);

	/**
	 * 插入module表
	 * 
	 */
	public void insertSystemModule(ModulePo po,LogisticsLogPo logPo);

	/**
	 * 更新module表
	 */
	public void updateSystemModule(ModulePo po,LogisticsLogPo logPo);

	/**
	 * 删除module表
	 * 
	 * @param 
	 */
	public void deleteSystemModule(ModulePo po,LogisticsLogPo logPo);
	
	/**停用module表
	 * 
	 * @param 
	 */
	public void disableSystemModule(ModulePo po,LogisticsLogPo logPo);
	
	/**
	 * 启用module表
	 * 
	 * @param 
	 */
	public void ableSystemModule(ModulePo po,LogisticsLogPo logPo);
	   /**
	 * 导入期初权限
	 * 
	 * @param brandPo
	 */
	public void insertImportModuleExcel(File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo);
	
	 /**
	 * 获取Module对应的帮助信息
	 * 
	 * @param brandPo
	 */
	public ModulePo getSystemModuleHelp(ModulePo po);
}
