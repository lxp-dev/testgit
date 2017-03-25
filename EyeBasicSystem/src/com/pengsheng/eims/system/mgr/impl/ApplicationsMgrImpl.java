package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.system.dao.ApplicationsDao;
import com.pengsheng.eims.system.mgr.ApplicationsMgr;
import com.pengsheng.eims.system.persistence.ApplicationsPo;

public class ApplicationsMgrImpl implements ApplicationsMgr {
	private ApplicationsDao applicationsDao;

	public ApplicationsDao getApplicationsDao() {
		return applicationsDao;
	}

	public void setApplicationsDao(ApplicationsDao applicationsDao) {
		this.applicationsDao = applicationsDao;
	}

	public List<ApplicationsPo> getSysApplicationsList() {
		return applicationsDao.getSysApplicationsList();
	}

	public ApplicationsPo getSysApplications(
			ApplicationsPo whereSysApplicationsPo) {
		return applicationsDao.getSysApplications(whereSysApplicationsPo);
	}

	public void insertSysApplications(ApplicationsPo sysApplicationsPo) {
		applicationsDao.insertSysApplications(sysApplicationsPo);
	}

	public void updateSysApplications(ApplicationsPo sysApplicationsPo) {
		applicationsDao.updateSysApplications(sysApplicationsPo);
	}

	public void deleteSysApplications(ApplicationsPo sysApplicationsPo) {
		applicationsDao.deleteSysApplications(sysApplicationsPo);
	}

}