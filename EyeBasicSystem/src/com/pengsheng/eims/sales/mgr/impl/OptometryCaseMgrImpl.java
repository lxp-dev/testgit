package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.sales.dao.OptometryCaseDao;
import com.pengsheng.eims.sales.mgr.OptometryCaseMgr;
import com.pengsheng.eims.sales.persistence.OptometryPo;

public class OptometryCaseMgrImpl implements OptometryCaseMgr{
	
	private OptometryCaseDao optometryCaseDao;
	
	public OptometryCaseDao getOptometryCaseDao() {
		return optometryCaseDao;
	}

	public void setOptometryCaseDao(OptometryCaseDao optometryCaseDao) {
		this.optometryCaseDao = optometryCaseDao;
	}

	public int getOptometryCaseCount(OptometryPo po){
		return optometryCaseDao.getOptometryCaseCount(po);
	}
	
	public List<OptometryPo> getOptometryCases(OptometryPo po,
			int start, int size){
		return optometryCaseDao.getOptometryCases(po, start, size);
	}
	
		
}
