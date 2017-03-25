package com.pengsheng.weixin.mgr.impl;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.weixin.dao.WeiXinAutoReplyDao;
import com.pengsheng.weixin.mgr.WeiXinAutoReplyMgr;
import com.pengsheng.weixin.persistence.WeiXinAutoReplyPo;

public class WeiXinAutoReplyMgrImpl implements WeiXinAutoReplyMgr {
	
	private WeiXinAutoReplyDao weiXinAutoReplyDao;
	private LogisticsLogDao logisticsLogDao;

	public void updateWeiXinAutoReply(WeiXinAutoReplyPo po,
			LogisticsLogPo logPo) {
		weiXinAutoReplyDao.deleteWeiXinAutoReply();
		weiXinAutoReplyDao.insertWeiXinAutoReply(po);
		logisticsLogDao.insertLog(logPo);

	}

	public WeiXinAutoReplyPo getWeiXinAutoReplyPo() {
		// TODO Auto-generated method stub
		return weiXinAutoReplyDao.getWeiXinAutoReplyPo();
	}
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public WeiXinAutoReplyDao getWeiXinAutoReplyDao() {
		return weiXinAutoReplyDao;
	}

	public void setWeiXinAutoReplyDao(WeiXinAutoReplyDao weiXinAutoReplyDao) {
		this.weiXinAutoReplyDao = weiXinAutoReplyDao;
	}
}
