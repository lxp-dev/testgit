package com.pengsheng.eims.hydsycasehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.hydsycasehistory.dao.OptometryCaseHydsyDao;
import com.pengsheng.eims.hydsycasehistory.mgr.OptometryCaseHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;

public class OptometryCaseHydsyMgrImpl implements OptometryCaseHydsyMgr{
	
	private OptometryCaseHydsyDao optometryCaseHydsyDao;

	public OptometryCaseHydsyDao getOptometryCaseHydsyDao() {
		return optometryCaseHydsyDao;
	}

	public void setOptometryCaseHydsyDao(OptometryCaseHydsyDao optometryCaseHydsyDao) {
		this.optometryCaseHydsyDao = optometryCaseHydsyDao;
	}

	public int getOptometryCaseCount(OptometryPo po){
		return optometryCaseHydsyDao.getOptometryCaseCount(po);
	}
	
	public List<OptometryPo> getOptometryCases(OptometryPo po,
			int start, int size){
		return optometryCaseHydsyDao.getOptometryCases(po, start, size);
	}
	
		
}
