package com.pengsheng.weixin.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.CustomerComplainPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinCmsContentDao;
import com.pengsheng.weixin.mgr.WeiXinCmsContentMgr;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;

public class WeiXinCmsContentMgrImpl implements WeiXinCmsContentMgr {
	private WeiXinCmsContentDao weiXinCmsContentDao;
	private LogisticsLogDao logisticsLogDao;
	
	public void deleteWeiXinCmsContentPo(WeiXinCmsContentPo po,
			LogisticsLogPo logPo) {
		weiXinCmsContentDao.deleteWeiXinCmsContentPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public void insertWeiXinCmsContentPo(WeiXinCmsContentPo po,
			LogisticsLogPo logPo) {
		weiXinCmsContentDao.insertWeiXinCmsContentPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public int selectWeiXinCmsContentCount(WeiXinCmsContentPo po) {
		return weiXinCmsContentDao.selectWeiXinCmsContentCount(po);
	}

	public List<WeiXinCmsContentPo> selectWeiXinCmsContentList(
			WeiXinCmsContentPo po, int start, int size) {
		return weiXinCmsContentDao.selectWeiXinCmsContentList(po, start, size);
	}

	public WeiXinCmsContentPo selectWeiXinCmsContentPo(
			WeiXinCmsContentPo po) {
		WeiXinCmsContentPo returnWeiXinCmsContentPo = weiXinCmsContentDao.selectWeiXinCmsContentPo(po);
		if(!Utility.getName(returnWeiXinCmsContentPo.getWcmscpicurl()).equals("")){
			returnWeiXinCmsContentPo.setWcmscpicurl2(returnWeiXinCmsContentPo.getWcmscpicurl()+",");			
		}
		return returnWeiXinCmsContentPo;
	}
	
	/**
	 * 获取几条文章的title，并以逗号分割返回
	 * @param ids
	 * @return
	 */
	public String getWeiXinCmsContentTitles(String ids){
		return weiXinCmsContentDao.getWeiXinCmsContentTitles(ids);
	}

	public void updateWeiXinCmsContentFlag(WeiXinCmsContentPo po,
			LogisticsLogPo logPo) {
		weiXinCmsContentDao.updateWeiXinCmsContentFlag(po);
		logisticsLogDao.insertLog(logPo);
	}

	public void updateWeiXinCmsContentPo(WeiXinCmsContentPo po,
			LogisticsLogPo logPo) {
		weiXinCmsContentDao.updateWeiXinCmsContentPo(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	public List<WeiXinCmsContentPo> selectWeiXinCmsContentListForView(
			WeiXinCmsContentPo po) {
		return weiXinCmsContentDao.selectWeiXinCmsContentListForView(po);
	}

	
	public CustomerComplainPo selectCustomerComplainPo(CustomerComplainPo po){
		return weiXinCmsContentDao.selectCustomerComplainPo(po);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public WeiXinCmsContentDao getWeiXinCmsContentDao() {
		return weiXinCmsContentDao;
	}

	public void setWeiXinCmsContentDao(WeiXinCmsContentDao weiXinCmsContentDao) {
		this.weiXinCmsContentDao = weiXinCmsContentDao;
	}


}
