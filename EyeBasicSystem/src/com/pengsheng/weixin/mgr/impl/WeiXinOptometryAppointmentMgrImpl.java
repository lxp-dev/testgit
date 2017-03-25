package com.pengsheng.weixin.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.weixin.dao.WeiXinOptometryAppointmentDao;
import com.pengsheng.weixin.mgr.WeiXinOptometryAppointmentMgr;
import com.pengsheng.weixin.persistence.WeiXinOptometryAppointmentPo;

public class WeiXinOptometryAppointmentMgrImpl implements WeiXinOptometryAppointmentMgr {
	private WeiXinOptometryAppointmentDao weiXinOptometryAppointmentDao;
	private LogisticsLogDao logisticsLogDao;
	
	/**
	 * 会员新增预约
	 * @param po
	 */
	public void insertWeiXinOptometryAppointmentPo(WeiXinOptometryAppointmentPo po,LogisticsLogPo logPo){
		weiXinOptometryAppointmentDao.insertWeiXinOptometryAppointmentPo(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 更新预约
	 * @param po
	 */
	public void updateWeiXinOptometryAppointmentPo(WeiXinOptometryAppointmentPo po,LogisticsLogPo logPo){
		weiXinOptometryAppointmentDao.updateWeiXinOptometryAppointmentPo(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 获得预约
	 * @param po
	 */
	public WeiXinOptometryAppointmentPo selectWeiXinOptometryAppointmentPo(WeiXinOptometryAppointmentPo po){
		return weiXinOptometryAppointmentDao.selectWeiXinOptometryAppointmentPo(po);
	}
	
	/**
	 * 删除预约
	 * @param po
	 */
	public void deleteWeiXinOptometryAppointmentPo(WeiXinOptometryAppointmentPo po,LogisticsLogPo logPo){
		weiXinOptometryAppointmentDao.deleteWeiXinOptometryAppointmentPo(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 获取预约条数
	 * @param po
	 * @return
	 */
	public int selectWeiXinOptometryAppointmentCount(WeiXinOptometryAppointmentPo po){
		return weiXinOptometryAppointmentDao.selectWeiXinOptometryAppointmentCount(po);
	}
	
	/**
	 * 获取预约List
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WeiXinOptometryAppointmentPo> selectWeiXinOptometryAppointmentList(WeiXinOptometryAppointmentPo po){
		return weiXinOptometryAppointmentDao.selectWeiXinOptometryAppointmentList(po);
	}
	
	/**
	 * 获取预约List
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WeiXinOptometryAppointmentPo> selectWeiXinOptometryAppointmentList(WeiXinOptometryAppointmentPo po, int start,int size){
		return weiXinOptometryAppointmentDao.selectWeiXinOptometryAppointmentList(po, start, size);
	}
	
	public WeiXinOptometryAppointmentDao getWeiXinOptometryAppointmentDao() {
		return weiXinOptometryAppointmentDao;
	}
	public void setWeiXinOptometryAppointmentDao(
			WeiXinOptometryAppointmentDao weiXinOptometryAppointmentDao) {
		this.weiXinOptometryAppointmentDao = weiXinOptometryAppointmentDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	

}
