package com.pengsheng.eims.bjtrhistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.bjtrhistory.dao.OptometryCaseBjtrDao;
import com.pengsheng.eims.bjtrhistory.mgr.OptometryCaseBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;

public class OptometryCaseBjtrMgrImpl implements OptometryCaseBjtrMgr{
	
	private OptometryCaseBjtrDao optometryCaseBjtrDao;

	public OptometryCaseBjtrDao getOptometryCaseBjtrDao() {
		return optometryCaseBjtrDao;
	}

	public void setOptometryCaseBjtrDao(OptometryCaseBjtrDao optometryCaseBjtrDao) {
		this.optometryCaseBjtrDao = optometryCaseBjtrDao;
	}

	public int getOptometryCaseCount(OptometryPo po){
		return optometryCaseBjtrDao.getOptometryCaseCount(po);
	}
	
	public List<OptometryPo> getOptometryCases(OptometryPo po,
			int start, int size){
		return optometryCaseBjtrDao.getOptometryCases(po, start, size);
	}
	
		
}
