package com.pengsheng.mall.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallBrandDao;
import com.pengsheng.mall.mgr.MallBrandMgr;
import com.pengsheng.mall.po.MallBrandPo;

public class MallBrandMgrImpl implements MallBrandMgr {
	
	private MallBrandDao mallBrandDao;
	private LogisticsLogDao logisticsLogDao;

	public void deleteMallBrandPo(MallBrandPo po,
			LogisticsLogPo logPo) {
		mallBrandDao.deleteMallBrandPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public void insertMallBrandPo(MallBrandPo po,
			LogisticsLogPo logPo) {
		mallBrandDao.insertMallBrandPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public int getMallBrandPoCount(MallBrandPo po) {
		return mallBrandDao.getMallBrandPoCount(po);
	}

	public List<MallBrandPo> getMallBrandPoList(MallBrandPo po,
			int start, int size) {
		return mallBrandDao.getMallBrandPoList(po, start, size);
	}

	public void updateMallBrandPo(MallBrandPo po,
			LogisticsLogPo logPo) {
		mallBrandDao.updateMallBrandPo(po);
		logisticsLogDao.insertLog(logPo);

	}


	public MallBrandPo getMallBrandPo(MallBrandPo po) {
		// TODO Auto-generated method stub
		MallBrandPo returnMallBrandPo = mallBrandDao.getMallBrandPo(po);
		if(!Utility.getName(returnMallBrandPo.getMbpicurl()).equals("")){
			returnMallBrandPo.setMbpicurl2(returnMallBrandPo.getMbpicurl()+",");			
		}
		return returnMallBrandPo;
	}
	
	public List<MallBrandPo> getMallBrandPoList(
			MallBrandPo po) {
		return mallBrandDao.getMallBrandPoList(po);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public MallBrandDao getMallBrandDao() {
		return mallBrandDao;
	}

	public void setMallBrandDao(MallBrandDao mallBrandDao) {
		this.mallBrandDao = mallBrandDao;
	}
}
