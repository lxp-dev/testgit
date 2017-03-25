package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.RegionalConfigurationDao;
import com.pengsheng.eims.basic.mgr.RegionalConfigurationMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public class RegionalConfigurationMgrImpl implements RegionalConfigurationMgr {

	private RegionalConfigurationDao regionalConfigurationDao;
	private LogisticsLogDao logisticsLogDao;
	
	public RegionalConfigurationDao getRegionalConfigurationDao() {
		return regionalConfigurationDao;
	}

	public void setRegionalConfigurationDao(
			RegionalConfigurationDao regionalConfigurationDao) {
		this.regionalConfigurationDao = regionalConfigurationDao;
	}


	public List<DepartmentsPo> getQuyuList(DepartmentsPo po) {
		return regionalConfigurationDao.getQuyuList(po);
	}

	public List<DepartmentsPo> getMendianQuyuList(DepartmentsPo departmentsPo) {
		return regionalConfigurationDao.getMendianQuyuList(departmentsPo);
	}

	public DepartmentsPo getDepartment(DepartmentsPo departmentsPo) {
		// TODO Auto-generated method stub
		return regionalConfigurationDao.getDepartment(departmentsPo);
	}

	public void updateDepartment(DepartmentsPo departmentsPo,LogisticsLogPo logPo) {
		this.regionalConfigurationDao.updateDepartment(departmentsPo);
		logisticsLogDao.insertLog(logPo);
	}

	
	public List<DepartmentsPo> getMendianQuyusList(DepartmentsPo departmentsPo, int start, int size) 
	{
		return regionalConfigurationDao.getMendianQuyusList(departmentsPo, start, size);
	}
	
	
	public int getMendianQuyusCount(DepartmentsPo departmentsPo) 
	{
		return regionalConfigurationDao.getMendianQuyusCount(departmentsPo);
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	
}
