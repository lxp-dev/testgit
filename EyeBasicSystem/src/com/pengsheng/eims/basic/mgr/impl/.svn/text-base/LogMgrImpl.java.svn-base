package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.LogDao;
import com.pengsheng.eims.basic.mgr.LogMgr;
import com.pengsheng.eims.basic.persistence.LogPo;
import com.pengsheng.eims.system.persistence.ModulePo;

public class LogMgrImpl implements LogMgr {
	private LogDao logDao;

	/**
	 * 日志总页数查询
	 */
	public int getLogpageCount(LogPo logPo) {
		return logDao.getLogpageCount(logPo);
	}

	/**
	 * 日志详细查询
	 */
	public List<LogPo> getLogpageList(LogPo logPo, int start, int size) {
		return logDao.getLogpageList(logPo, start, size);
	}

	/**
	 * Description :获取功能设置列表
	 * @return :功能设置的列表
	 */
	public List<ModulePo> getModuleList() {
		return logDao.getModuleList();
	}
	
	public LogDao getLogDao() {
		return logDao;
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
}
