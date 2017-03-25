package com.pengsheng.weixin.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.weixin.dao.WeiXinMenuConfigDao;
import com.pengsheng.weixin.mgr.WeiXinMenuConfigMgr;
import com.pengsheng.weixin.persistence.WeiXinMenuPo;
import com.pengsheng.weixin.persistence.WeiXinMenuTypePo;

public class WeiXinMenuConfigMgrImpl implements WeiXinMenuConfigMgr {
	
	private WeiXinMenuConfigDao weiXinMenuConfigDao;
	private LogisticsLogDao logisticsLogDao;

	public WeiXinMenuPo getWeiXinMenuPo() {
		// TODO Auto-generated method stub
		return weiXinMenuConfigDao.getWeiXinMenuPo();
	}

	public WeiXinMenuConfigDao getWeiXinMenuConfigDao() {
		return weiXinMenuConfigDao;
	}

	public void setWeiXinMenuConfigDao(WeiXinMenuConfigDao weiXinMenuConfigDao) {
		this.weiXinMenuConfigDao = weiXinMenuConfigDao;
	}

	public void insertWeiXinMenuPo(WeiXinMenuPo po, LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		WeiXinMenuPo tmpPo = weiXinMenuConfigDao.getWeiXinMenuPo();
		if(tmpPo.getWmcid1()==null || tmpPo.getWmcid1().equals("")){
			weiXinMenuConfigDao.insertWeiXinMenuPo(po);
		}else{
			weiXinMenuConfigDao.updateWeiXinMenuPo(po);
		}
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 更新配置Menu参数
	 */
	public void updateWeiXinMenuDetail(String menuID,String menuTypeid ,String weburl, LogisticsLogPo logPo){
		weiXinMenuConfigDao.updateWeiXinMenuDetail(menuID, menuTypeid , weburl);
		logisticsLogDao.insertLog(logPo);
	}

	public List<WeiXinMenuTypePo> getWeiXinMenuTypeList() {
		// TODO Auto-generated method stub
		return weiXinMenuConfigDao.getWeiXinMenuTypeList();
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
}
