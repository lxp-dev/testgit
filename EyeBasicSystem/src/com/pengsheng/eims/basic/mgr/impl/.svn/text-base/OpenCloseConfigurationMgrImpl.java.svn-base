package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.OpenCloseConfigurationDao;
import com.pengsheng.eims.basic.mgr.OpenCloseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.StatusModulePo;

public class OpenCloseConfigurationMgrImpl implements OpenCloseConfigurationMgr {

	private OpenCloseConfigurationDao openCloseConfigurationDao;



	public OpenCloseConfigurationDao getOpenCloseConfigurationDao() {
		return openCloseConfigurationDao;
	}



	public void setOpenCloseConfigurationDao(
			OpenCloseConfigurationDao openCloseConfigurationDao) {
		this.openCloseConfigurationDao = openCloseConfigurationDao;
	}



	public List<StatusModulePo> getStatusList() {
		return openCloseConfigurationDao.getStatusList();
	}

	

	public void updateStatusModule(StatusModulePo statusModulePo) {
		this.openCloseConfigurationDao.updateStatusModule(statusModulePo);
	}
}
