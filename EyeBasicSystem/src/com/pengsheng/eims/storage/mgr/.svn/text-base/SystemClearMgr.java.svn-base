package com.pengsheng.eims.storage.mgr;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface SystemClearMgr {
	
	/**
	 * 判断系统是否正式上线
	 * @return 0： 未上线    1 ：以上线
	 */
	public int isSystemOnLine();
	
	/**
	 * 判断是否可以清除库存
	 * @return 0： 没有库存    >0 ：存在库存
	 */
	public int getStorageCount();
	
	/**
	 * 清除库存
	 * 
	 */
	public void deleteStorageData(LogisticsLogPo logPo);
	
	/**
	 * 根据商品的实盘数导入库存
	 * 
	 */
	public void insertStorageData(LogisticsLogPo logPo);
	
	/**
	 * 更新系统正式上线日期
	 * 
	 */
	public void updateSystemOnLineDate(String systemOnLineDate,LogisticsLogPo logPo);
	
	/**
	 * 更新系统正式上线日期
	 * 
	 */
	public void insertPayMentDate(String payMentDate,LogisticsLogPo logPo);
	
	/**
	 * 清除业务数据
	 * 
	 */
	public void deleteInventoryData(LogisticsLogPo logPo);
	
	/**
	 * 清除数据库
	 * 
	 */
	public void deleteDataBase(LogisticsLogPo logPo);
	
	/**
	 * 备份数据库
	 * 
	 */
	public void dataBaseBackup(String databaseName,String backupPath,LogisticsLogPo logPo);
	
	/**
	 * 查询系统正式上线日期
	 * 
	 */
	public String getSystemOnLineDate();
	
	/**
	 * 查询当前账期
	 * 
	 */
	public String getCurrentPayMentDate();
}
