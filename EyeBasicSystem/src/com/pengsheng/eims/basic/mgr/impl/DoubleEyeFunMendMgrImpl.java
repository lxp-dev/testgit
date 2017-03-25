package com.pengsheng.eims.basic.mgr.impl;

import com.pengsheng.eims.basic.mgr.DoubleEyeFunMendMgr;
import com.pengsheng.eims.basic.persistence.DoubleEyeFunMendPo;
import com.pengsheng.eims.basic.dao.DoubleEyeFunMendDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public class DoubleEyeFunMendMgrImpl implements DoubleEyeFunMendMgr{
	private DoubleEyeFunMendDao doubleEyeFunMendDao;
	private LogisticsLogDao logisticsLogDao;
	
	/**
	 * 获取双眼视功能参数设置信息
	 * @return
	 */
	public DoubleEyeFunMendPo selectDoubleEyeFunMendPo(){
		return doubleEyeFunMendDao.selectDoubleEyeFunMendPo();
	}
	
	/**
	 * 新增双眼视功能参数设置信息
	 * @return
	 */
	public void insertDoubleEyeFunMendPo(DoubleEyeFunMendPo po,LogisticsLogPo logPo){
		doubleEyeFunMendDao.deleteDoubleEyeFunMendPo();
		doubleEyeFunMendDao.insertDoubleEyeFunMendPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public DoubleEyeFunMendDao getDoubleEyeFunMendDao() {
		return doubleEyeFunMendDao;
	}

	public void setDoubleEyeFunMendDao(DoubleEyeFunMendDao doubleEyeFunMendDao) {
		this.doubleEyeFunMendDao = doubleEyeFunMendDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
}
