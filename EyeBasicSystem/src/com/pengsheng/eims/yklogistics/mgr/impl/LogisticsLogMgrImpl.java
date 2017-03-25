package com.pengsheng.eims.yklogistics.mgr.impl;

import java.util.List;

import com.pengsheng.eims.yklogistics.dao.LogisticsLogDao;
import com.pengsheng.eims.yklogistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public class LogisticsLogMgrImpl implements LogisticsLogMgr {
	private LogisticsLogDao yklogisticsLogDao = null;

	public LogisticsLogDao getYklogisticsLogDao() {
		return yklogisticsLogDao;
	}

	public void setYklogisticsLogDao(LogisticsLogDao yklogisticsLogDao) {
		this.yklogisticsLogDao = yklogisticsLogDao;
	}

	/**
	 * 模块：物流系统
	 * 描述：新增日志
	 * 参数：po   日志实体
	 * 优化记录：1. szk 2011-08-10
	 */
	public void insertLog(LogisticsLogPo po){
		yklogisticsLogDao.insertLog(po);
	}
	
	/**
	 * 模块：物流系统
	 * 描述：查询财务部所有人员
	 * 优化记录：1. szk 2011-08-10
	 */
	public List<PersonInfoPo> selPersonInfo(){
		return yklogisticsLogDao.selPersonInfo();
	}

	/**
	 * 模块：物流系统
	 * 描述：查询物流日志总数
	 * 参数：po   日志实体
	 * 优化记录：1. szk 2011-08-10
	 */
	public int selLogisticsLogCount(LogisticsLogPo po){
		return yklogisticsLogDao.selLogisticsLogCount(po);
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
		return yklogisticsLogDao.selLogisticsLog(po,start,size);
	}
}
