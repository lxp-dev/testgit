package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.WarehouseConfigurationDao;
import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class WarehouseConfigurationMgrImpl implements WarehouseConfigurationMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private WarehouseConfigurationDao warehouseConfigurationDao;
	
	public WarehouseConfigurationDao getWarehouseConfigurationDao() {
		return warehouseConfigurationDao;
	}

	public void setWarehouseConfigurationDao(
			WarehouseConfigurationDao warehouseConfigurationDao) {
		this.warehouseConfigurationDao = warehouseConfigurationDao;
	}

	public List<WarehouseConfigurationPo> getWarehouseConfigurationList() {
		
		return warehouseConfigurationDao.getWarehouseConfigurationList();
	}
	
	public WarehouseConfigurationPo getWarehouseConfiguration(
			WarehouseConfigurationPo po) {
		
		return warehouseConfigurationDao.getWarehouseConfiguration(po);
	}
	
	public WarehouseConfigurationPo getInWarehouseConfiguration(WarehouseConfigurationPo po) {
		
		return warehouseConfigurationDao.getInWarehouseConfiguration(po);
	}
	
	public void insertWarehouseConfiguration(WarehouseConfigurationPo po,WarehouseConfigurationPo inpo,LogisticsLogPo logPo) {

		warehouseConfigurationDao.insertWarehouseConfiguration(po);
		if (inpo != null){
			warehouseConfigurationDao.insertInWarehouseConfiguration(inpo);
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void insertInWarehouseConfiguration(WarehouseConfigurationPo po,LogisticsLogPo logPo) {

		warehouseConfigurationDao.insertInWarehouseConfiguration(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void updateWarehouseConfiguration(WarehouseConfigurationPo po,WarehouseConfigurationPo inpo,LogisticsLogPo logPo) {

		warehouseConfigurationDao.updateWarehouseConfiguration(po);
		if (inpo != null){
			warehouseConfigurationDao.updateInWarehouseConfiguration(inpo);
		}	
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void updateInWarehouseConfiguration(WarehouseConfigurationPo po,LogisticsLogPo logPo) {

		warehouseConfigurationDao.updateInWarehouseConfiguration(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public int getWarehouseConfigurationCount(WarehouseConfigurationPo po) {
		
		return warehouseConfigurationDao.getWarehouseConfigurationCount(po);
	}
	
	public int getInWarehouseConfigurationCount(WarehouseConfigurationPo po) {
		
		return warehouseConfigurationDao.getInWarehouseConfigurationCount(po);
	}
	
	public List<WarehousePo> getWarehouseList() {
		
		return warehouseConfigurationDao.getWarehouseList();
	}
	public int getWarehouseConfigurationsCount(DepartmentsPo po)
	{
		return warehouseConfigurationDao.getWarehouseConfigurationsCount(po);
	}
	public List<WarehouseConfigurationPo> getWarehouseConfigurationsList(DepartmentsPo po,int start, int size)
	{
		return warehouseConfigurationDao.getWarehouseConfigurationsList(po,start, size);
	}
	
	public List<WarehousePo> getWarehouseList(DepartmentsPo po){
		return warehouseConfigurationDao.getWarehouseList(po);
	}
}
