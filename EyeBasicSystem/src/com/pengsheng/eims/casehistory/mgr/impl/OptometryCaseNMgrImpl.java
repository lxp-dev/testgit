package com.pengsheng.eims.casehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.casehistory.dao.OptometryCaseNDao;
import com.pengsheng.eims.casehistory.mgr.OptometryCaseNMgr;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;

public class OptometryCaseNMgrImpl implements OptometryCaseNMgr{
	
	private OptometryCaseNDao optometryCaseNDao;

	public OptometryCaseNDao getOptometryCaseNDao() {
		return optometryCaseNDao;
	}

	public void setOptometryCaseNDao(OptometryCaseNDao optometryCaseNDao) {
		this.optometryCaseNDao = optometryCaseNDao;
	}

	public int getOptometryCaseCount(OptometryPo po){
		return optometryCaseNDao.getOptometryCaseCount(po);
	}
	
	public List<OptometryPo> getOptometryCases(OptometryPo po,
			int start, int size){
		return optometryCaseNDao.getOptometryCases(po, start, size);
	}
	
		
}
