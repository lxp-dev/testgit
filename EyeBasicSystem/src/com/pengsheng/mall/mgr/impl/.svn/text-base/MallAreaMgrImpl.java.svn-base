package com.pengsheng.mall.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallAreaDao;
import com.pengsheng.mall.mgr.MallAreaMgr;
import com.pengsheng.mall.po.MallAreaPo;

public class MallAreaMgrImpl implements MallAreaMgr {
	
	private MallAreaDao mallAreaDao;
	private LogisticsLogDao logisticsLogDao;

	public void deleteMallAreaPo(MallAreaPo po,
			LogisticsLogPo logPo) {
		mallAreaDao.deleteMallAreaPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public void insertMallAreaPo(MallAreaPo po,
			LogisticsLogPo logPo) {
		mallAreaDao.insertMallAreaPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public int getMallAreaPoCount(MallAreaPo po) {
		return mallAreaDao.getMallAreaPoCount(po);
	}

	public List<MallAreaPo> getMallAreaPoList(MallAreaPo po,
			int start, int size) {
		return mallAreaDao.getMallAreaPoList(po, start, size);
	}

	public void updateMallAreaPo(MallAreaPo po,
			LogisticsLogPo logPo) {
		mallAreaDao.updateMallAreaPo(po);
		logisticsLogDao.insertLog(logPo);

	}


	public MallAreaPo getMallAreaPo(MallAreaPo po) {
		// TODO Auto-generated method stub
		MallAreaPo returnMallAreaPo = mallAreaDao.getMallAreaPo(po);
		if(!Utility.getName(returnMallAreaPo.getMapicurl()).equals("")){
			returnMallAreaPo.setMapicurl2(returnMallAreaPo.getMapicurl()+",");			
		}
		return returnMallAreaPo;
	}
	
	public List<MallAreaPo> getMallAreaPoList(
			MallAreaPo po) {
		return mallAreaDao.getMallAreaPoList(po);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public MallAreaDao getMallAreaDao() {
		return mallAreaDao;
	}

	public void setMallAreaDao(MallAreaDao mallAreaDao) {
		this.mallAreaDao = mallAreaDao;
	}
}
