package com.pengsheng.eims.storage.mgr.impl;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.SystemClearDao;
import com.pengsheng.eims.storage.mgr.SystemClearMgr;

public class SystemClearMgrImpl implements SystemClearMgr {

	private SystemClearDao systemClearDao;
	private LogisticsLogDao logisticsLogDao;
	
	/**
	 * 判断系统是否正式上线
	 * @return 0： 未上线    1 ：以上线
	 */
	public int isSystemOnLine(){
		return systemClearDao.isSystemOnLine();
	}
	
	/**
	 * 判断是否可以清除库存
	 * @return 0： 没有库存    >0 ：存在库存
	 */
	public int getStorageCount(){
		return systemClearDao.getStorageCount();
	}
	
	/**
	 * 清除库存
	 * 
	 */
	public void deleteStorageData(LogisticsLogPo logPo){
		
		systemClearDao.deleteStorageData_Beginning();
		systemClearDao.deleteStorageData_Change();
		systemClearDao.deleteStorageData_Log();
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 根据商品的实盘数导入库存
	 * 
	 */
	public void insertStorageData(LogisticsLogPo logPo){
		
		systemClearDao.deleteStorageData_Beginning();
		systemClearDao.deleteStorageData_Change();
		systemClearDao.deleteStorageData_Log();
		
		systemClearDao.insertStorageData();
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 更新系统正式上线日期
	 * 
	 */
	public void updateSystemOnLineDate(String systemOnLineDate,LogisticsLogPo logPo){
		
		systemClearDao.deleteSystemOnLineDate();
		systemClearDao.updateSystemOnLineDate(systemOnLineDate);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 更新系统正式上线日期
	 * 
	 */
	public void insertPayMentDate(String payMentDate,LogisticsLogPo logPo){
		
		String[] payMentDate2 = payMentDate.split("-");
		systemClearDao.insertPayMentYear(payMentDate2[0]);
		systemClearDao.updatePayMentMonth();
		systemClearDao.insertPayMentMonth(payMentDate2[1]);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 清除业务数据
	 * 
	 */
	public void deleteInventoryData(LogisticsLogPo logPo){
		
		systemClearDao.deleteInventoryData();
		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 清除数据库
	 * 
	 */
	public void deleteDataBase(LogisticsLogPo logPo){
		
		systemClearDao.deleteStorageData_Beginning();
		systemClearDao.deleteStorageData_Change();
		//systemClearDao.deleteStorageData_Log();
		
		systemClearDao.insertStorageData();
		
		systemClearDao.deleteInventoryData();
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 备份数据库(不能在事务内部执行备份或还原操作)
	 * 
	 */
	public void dataBaseBackup(String databaseName,String backupPath,LogisticsLogPo logPo){
		
		systemClearDao.dataBaseBackup(databaseName, backupPath);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 查询系统正式上线日期
	 * 
	 */
	public String getSystemOnLineDate(){
		if (systemClearDao.getSystemOnLineDateCount() > 0){
			return systemClearDao.getSystemOnLineDate();
		}
		return "";
	}
	
	/**
	 * 查询当前账期
	 * 
	 */
	public String getCurrentPayMentDate(){
		return systemClearDao.getCurrentPayMentDate();
	}
	
	public SystemClearDao getSystemClearDao() {
		return systemClearDao;
	}

	public void setSystemClearDao(SystemClearDao systemClearDao) {
		this.systemClearDao = systemClearDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	
}
