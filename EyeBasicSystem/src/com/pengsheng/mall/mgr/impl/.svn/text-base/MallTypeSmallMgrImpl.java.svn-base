package com.pengsheng.mall.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallTypeSmallDao;
import com.pengsheng.mall.mgr.MallTypeSmallMgr;
import com.pengsheng.mall.po.MallTypeSmallPicPo;
import com.pengsheng.mall.po.MallTypeSmallPo;

public class MallTypeSmallMgrImpl implements MallTypeSmallMgr {
	private MallTypeSmallDao mallTypeSmallDao;
	private LogisticsLogDao logisticsLogDao;
	
	public void deleteMallTypeSmallPo(MallTypeSmallPo po,
			LogisticsLogPo logPo) {
		mallTypeSmallDao.deleteMallTypeSmallPo(po);
		mallTypeSmallDao.deleteMallTypeSmallPic(po.getMtsid());
		logisticsLogDao.insertLog(logPo);
	}

	public void insertMallTypeSmallPo(MallTypeSmallPo po,
			LogisticsLogPo logPo) {
		mallTypeSmallDao.insertMallTypeSmallPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public int getMallTypeSmallPoCount(MallTypeSmallPo po) {
		return mallTypeSmallDao.getMallTypeSmallPoCount(po);
	}

	public List<MallTypeSmallPo> getMallTypeSmallPoList(
			MallTypeSmallPo po, int start, int size) {
		return mallTypeSmallDao.getMallTypeSmallPoList(po, start, size);
	}

	public MallTypeSmallPo getMallTypeSmallPo(
			MallTypeSmallPo po) {
		MallTypeSmallPo returnMallTypeSmallPo = mallTypeSmallDao.getMallTypeSmallPo(po);
		if(!Utility.getName(returnMallTypeSmallPo.getMtspicurl()).equals("")){
			returnMallTypeSmallPo.setMtspicurl2(returnMallTypeSmallPo.getMtspicurl()+",");			
		}
		return returnMallTypeSmallPo;
	}
	

	public void updateMallTypeSmallFlag(MallTypeSmallPo po,
			LogisticsLogPo logPo) {
		mallTypeSmallDao.updateMallTypeSmallFlag(po);
		logisticsLogDao.insertLog(logPo);
	}

	public void updateMallTypeSmallPo(MallTypeSmallPo po,
			LogisticsLogPo logPo) {
		mallTypeSmallDao.updateMallTypeSmallPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 获取滚动导航图List
	 * 
	 * @param smallID
	 */
	public List<MallTypeSmallPicPo> getMallTypeSmallPicList(String smallID){
		return mallTypeSmallDao.getMallTypeSmallPicList(smallID);
	}
	
	/**
	 * 更新滚动导航图
	 * 
	 * @param po
	 */
	public void updateMallTypeSmallPic(MallTypeSmallPo po,LogisticsLogPo logPo){
		String mallTypeSmallPicurls = "";
		mallTypeSmallDao.deleteMallTypeSmallPic(po.getMtsid());
		if(!po.getMtspicurls().equals("")){
			String stringarray[]=po.getMtspicurls().split(",");  
			MallTypeSmallPicPo mallTypeSmallPicPo = new MallTypeSmallPicPo();
			mallTypeSmallPicPo.setMtspsmallid(po.getMtsid());
			for(String stemp:stringarray){  
				mallTypeSmallPicPo.setMtsppicUrl(stemp);
				mallTypeSmallDao.insertMallTypeSmallPic(mallTypeSmallPicPo);
			}  
		}
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public MallTypeSmallDao getMallTypeSmallDao() {
		return mallTypeSmallDao;
	}

	public void setMallTypeSmallDao(MallTypeSmallDao mallTypeSmallDao) {
		this.mallTypeSmallDao = mallTypeSmallDao;
	}
}
