package com.pengsheng.weixin.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinDoctorDao;
import com.pengsheng.weixin.mgr.WeiXinDoctorMgr;
import com.pengsheng.weixin.persistence.WeiXinDoctorPo;

public class WeiXinDoctorMgrImpl implements WeiXinDoctorMgr {
	private WeiXinDoctorDao weiXinDoctorDao;
	private LogisticsLogDao logisticsLogDao;
	
	public void deleteWeiXinDoctorPo(WeiXinDoctorPo po,
			LogisticsLogPo logPo) {
		weiXinDoctorDao.deleteWeiXinDoctorPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public void insertWeiXinDoctorPo(WeiXinDoctorPo po,
			LogisticsLogPo logPo) {
		weiXinDoctorDao.insertWeiXinDoctorPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public int selectWeiXinDoctorCount(WeiXinDoctorPo po) {
		return weiXinDoctorDao.selectWeiXinDoctorCount(po);
	}

	public List<WeiXinDoctorPo> selectWeiXinDoctorList(
			WeiXinDoctorPo po, int start, int size) {
		return weiXinDoctorDao.selectWeiXinDoctorList(po, start, size);
	}
	
	/**
	 * 获取验光师信息List
	 * @param po
	 * @return
	 */
	public List<WeiXinDoctorPo> selectWeiXinDoctorList(WeiXinDoctorPo po){
		return weiXinDoctorDao.selectWeiXinDoctorList(po);
	}

	public WeiXinDoctorPo selectWeiXinDoctorPo(
			WeiXinDoctorPo po) {
		WeiXinDoctorPo returnWeiXinDoctorPo = weiXinDoctorDao.selectWeiXinDoctorPo(po);
		if(!Utility.getName(returnWeiXinDoctorPo.getWdpicurl()).equals("")){
			returnWeiXinDoctorPo.setWdpicurl2(returnWeiXinDoctorPo.getWdpicurl()+",");			
		}
		return returnWeiXinDoctorPo;
	}
	
	/**
	 * 获得验光师信息
	 * @param String personID
	 */
	public WeiXinDoctorPo selectWeiXinDoctorPo(String personID){
		return weiXinDoctorDao.selectWeiXinDoctorPo(personID);
	}

	public void updateWeiXinDoctorPo(WeiXinDoctorPo po, LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		weiXinDoctorDao.updateWeiXinDoctorPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public WeiXinDoctorDao getWeiXinDoctorDao() {
		return weiXinDoctorDao;
	}

	public void setWeiXinDoctorDao(WeiXinDoctorDao weiXinDoctorDao) {
		this.weiXinDoctorDao = weiXinDoctorDao;
	}
}
