package com.pengsheng.weixin.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.weixin.dao.WeiXinCmsTypeDao;
import com.pengsheng.weixin.mgr.WeiXinCmsTypeMgr;
import com.pengsheng.weixin.persistence.WeiXinCmsTypePo;

public class WeiXinCmsTypeMgrImpl implements WeiXinCmsTypeMgr {
	
	private WeiXinCmsTypeDao weiXinCmsTypeDao;
	private LogisticsLogDao logisticsLogDao;

	public void deleteWeiXinCmsType(WeiXinCmsTypePo po,
			LogisticsLogPo logPo) {
		weiXinCmsTypeDao.deleteWeiXinCmsType(po);
		logisticsLogDao.insertLog(logPo);
	}

	public void insertWeiXinCmsType(WeiXinCmsTypePo po,
			LogisticsLogPo logPo) {
		weiXinCmsTypeDao.insertWeiXinCmsType(po);
		logisticsLogDao.insertLog(logPo);
	}

	public int selectWeiXinCmsTypeCount(WeiXinCmsTypePo po) {
		return weiXinCmsTypeDao.selectWeiXinCmsTypeCount(po);
	}

	public List<WeiXinCmsTypePo> selectWeiXinCmsTypes(WeiXinCmsTypePo po,
			int start, int size) {
		return weiXinCmsTypeDao.selectWeiXinCmsTypes(po, start, size);
	}

	public void updateWeiXinCmsType(WeiXinCmsTypePo po,
			LogisticsLogPo logPo) {
		weiXinCmsTypeDao.updateWeiXinCmsType(po);
		logisticsLogDao.insertLog(logPo);

	}

	public WeiXinCmsTypePo getWeiXinCmsTypePo(WeiXinCmsTypePo po) {
		// TODO Auto-generated method stub
		return weiXinCmsTypeDao.getWeiXinCmsTypePo(po);
	}
	
	public List<WeiXinCmsTypePo> getWeiXinCmsTypeList(
			WeiXinCmsTypePo po) {
		return weiXinCmsTypeDao.getWeiXinCmsTypeList(po);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public WeiXinCmsTypeDao getWeiXinCmsTypeDao() {
		return weiXinCmsTypeDao;
	}

	public void setWeiXinCmsTypeDao(WeiXinCmsTypeDao weiXinCmsTypeDao) {
		this.weiXinCmsTypeDao = weiXinCmsTypeDao;
	}
}
