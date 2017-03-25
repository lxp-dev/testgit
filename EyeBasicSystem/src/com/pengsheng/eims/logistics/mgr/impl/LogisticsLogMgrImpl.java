package com.pengsheng.eims.logistics.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public class LogisticsLogMgrImpl implements LogisticsLogMgr {
	private LogisticsLogDao logisticsLogDao = null;
		
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	/**
	 * 模块：物流系统
	 * 描述：新增日志
	 * 参数：po   日志实体
	 * 优化记录：1. szk 2011-08-10
	 */
	public void insertLog(LogisticsLogPo po){
		logisticsLogDao.insertLog(po);
	}
	
	/**
	 * 模块：物流系统
	 * 描述：查询财务部所有人员
	 * 优化记录：1. szk 2011-08-10
	 */
	public List<PersonInfoPo> selPersonInfo(){
		return logisticsLogDao.selPersonInfo();
	}

	/**
	 * 模块：物流系统
	 * 描述：查询物流日志总数
	 * 参数：po   日志实体
	 * 优化记录：1. szk 2011-08-10
	 */
	public int selLogisticsLogCount(LogisticsLogPo po){
		return logisticsLogDao.selLogisticsLogCount(po);
	}

	/**
	 * 模块：物流系统
	 * 描述：查询物流日志
	 * 参数：po   日志实体
	 *      start 开始行数
	 *      size  每页行数
	 * 优化记录：1. szk 2011-08-10
	 */
	public List<LogisticsLogPo> selLogisticsLog(LogisticsLogPo po,int start,int size){
		return logisticsLogDao.selLogisticsLog(po,start,size);
	}
}
