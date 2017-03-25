package com.pengsheng.eims.personnel.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.dao.EducationDao;
import com.pengsheng.eims.personnel.mgr.EducationMgr;
import com.pengsheng.eims.personnel.persistence.EducationPo;

public class EducationMgrImpl implements EducationMgr {

	private EducationDao educationDao;
	private LogisticsLogDao logisticsLogDao;
	
	public void deleteEducation(EducationPo educationPo,LogisticsLogPo logPo) {
		this.educationDao.deleteEducation(educationPo);
		logisticsLogDao.insertLog(logPo);
	}

	public EducationPo getEducation(EducationPo educationPo) {
		return this.educationDao.getEducation(educationPo);
	}

	public List<EducationPo> getEducationList() {
		return this.educationDao.getEducationList();
	}
	
	public int getEducationCount() 
	{
		return this.educationDao.getEducationCount();
	}	
	public List<EducationPo> getEducationsList(int start, int size) 
	{
		return this.educationDao.getEducationsList(start, size);
	}

	public void insertEducation(EducationPo educationPo,LogisticsLogPo logPo) {
		this.educationDao.insertEducation(educationPo);
		logisticsLogDao.insertLog(logPo);
	}

	public void updateEducation(EducationPo educationPo,LogisticsLogPo logPo) {
		this.educationDao.updateEducation(educationPo);
		logisticsLogDao.insertLog(logPo);
	}

	public int getEducationName(EducationPo po)
	{
		return educationDao.getEducationName(po);
	}
	public int getEducationNameUpdate(EducationPo po)
	{
		return educationDao.getEducationNameUpdate(po);
	}
	
	public EducationDao getEducationDao() {
		return educationDao;
	}

	public void setEducationDao(EducationDao educationDao) {
		this.educationDao = educationDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public int getBeUsed(EducationPo po) {
		return this.educationDao.getBeUsed(po);
	}


}
