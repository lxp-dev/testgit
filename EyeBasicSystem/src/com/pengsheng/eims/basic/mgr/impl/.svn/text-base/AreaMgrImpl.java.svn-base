package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.AreaDao;
import com.pengsheng.eims.basic.mgr.AreaMgr;
import com.pengsheng.eims.basic.persistence.AreaPo;

public class AreaMgrImpl implements AreaMgr {
	
	private AreaDao areaDao;

	public List<AreaPo> getAjaxAreaData(String level,String pid) {
		return areaDao.getAjaxAreaData(level,pid) ;
	}
	
	public AreaDao getAreaDao() {
		return areaDao;
	}

	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}
}
