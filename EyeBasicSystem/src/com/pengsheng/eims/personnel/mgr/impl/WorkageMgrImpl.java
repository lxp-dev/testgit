package com.pengsheng.eims.personnel.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.dao.WorkageDao;
import com.pengsheng.eims.personnel.mgr.WorkageMgr;
import com.pengsheng.eims.personnel.persistence.EducationPo;
import com.pengsheng.eims.personnel.persistence.WorkagePo;

public class WorkageMgrImpl implements WorkageMgr {

	private WorkageDao workageDao;
	private LogisticsLogDao logisticsLogDao;
	
	public void deleteWorkage(WorkagePo workagePo,LogisticsLogPo logPo) {
		this.workageDao.deleteWorkage(workagePo);
		logisticsLogDao.insertLog(logPo);
	}

	public WorkagePo getWorkage(WorkagePo workagePo) {
		return this.workageDao.getWorkage(workagePo);
	}

	public List<WorkagePo> getWorkageList() {
		return this.workageDao.getWorkageList();
	}
	
	public int getWorkageCount() 
	{
		return this.workageDao.getWorkageCount();
	}	
	public List<WorkagePo> getWorkagesList(int start, int size) 
	{
		return this.workageDao.getWorkagesList(start, size);
	}

	public void insertWorkage(WorkagePo workagePo,LogisticsLogPo logPo) {
		this.workageDao.insertWorkage(workagePo);
		logisticsLogDao.insertLog(logPo);
	}

	public void updateWorkage(WorkagePo workagePo,LogisticsLogPo logPo) {
		this.workageDao.updateWorkage(workagePo);
		logisticsLogDao.insertLog(logPo);
	}
	
	public WorkageDao getWorkageDao() {
		return workageDao;
	}

	public void setWorkageDao(WorkageDao workageDao) {
		this.workageDao = workageDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public int getWorkageName(WorkagePo workagePo)
	{
		return workageDao.getWorkageName(workagePo);
	}
	public int getWorkageNameUpdate(WorkagePo workagePo)
	{
		return workageDao.getWorkageNameUpdate(workagePo);
	}
}
