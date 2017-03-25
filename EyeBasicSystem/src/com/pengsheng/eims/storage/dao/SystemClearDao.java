package com.pengsheng.eims.storage.dao;

public interface SystemClearDao {
	
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
	 * 清除库存(第一张)
	 * 
	 */
	public void deleteStorageData_Beginning();
	
	/**
	 * 清除库存(第三张)
	 * 
	 */
	public void deleteStorageData_Change();
	
	/**
	 * 清除库存(第四张)
	 * 
	 */
	public void deleteStorageData_Log();
	
	/**
	 * 根据商品的实盘数导入库存
	 * 
	 */
	public void insertStorageData();
	
	/**
	 * 更新系统正式上线日期
	 * 
	 */
	public void updateSystemOnLineDate(String systemOnLineDate);
	
	/**
	 * 更新系统正式上线日期
	 * 
	 */
	public void insertPayMentYear(String payMentYear);
	
	/**
	 * 更新系统正式上线日期(月份)
	 * 
	 */
	public void updatePayMentMonth();
	
	/**
	 * 更新系统正式上线日期
	 * 
	 */
	public void insertPayMentMonth(String payMentMonth);
	
	/**
	 * 清除业务数据
	 * 
	 */
	public void deleteInventoryData();
	
	/**
	 * 备份数据库
	 * 
	 */
	public void dataBaseBackup(String databaseName,String backupPath);
	
	/**
	 * 删除系统正式上线日期
	 * 
	 */
	public void deleteSystemOnLineDate();
	
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
	
	/**
	 * 确定是否存在系统正式上线日期
	 * 
	 */
	public int getSystemOnLineDateCount();
}
