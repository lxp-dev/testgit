package com.pengsheng.mall.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallTypeLargeDao;
import com.pengsheng.mall.mgr.MallTypeLargeMgr;
import com.pengsheng.mall.po.MallTypeLargePo;

public class MallTypeLargeMgrImpl implements MallTypeLargeMgr {
	
	private MallTypeLargeDao mallTypeLargeDao;
	private LogisticsLogDao logisticsLogDao;

	public void deleteMallTypeLargePo(MallTypeLargePo po,
			LogisticsLogPo logPo) {
		mallTypeLargeDao.deleteMallTypeLargePo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public void insertMallTypeLargePo(MallTypeLargePo po,
			LogisticsLogPo logPo) {
		mallTypeLargeDao.insertMallTypeLargePo(po);
		logisticsLogDao.insertLog(logPo);
	}

	public int getMallTypeLargePoCount(MallTypeLargePo po) {
		return mallTypeLargeDao.getMallTypeLargePoCount(po);
	}

	public List<MallTypeLargePo> getMallTypeLargePoList(MallTypeLargePo po,
			int start, int size) {
		return mallTypeLargeDao.getMallTypeLargePoList(po, start, size);
	}

	public void updateMallTypeLargePo(MallTypeLargePo po,
			LogisticsLogPo logPo) {
		mallTypeLargeDao.updateMallTypeLargePo(po);
		logisticsLogDao.insertLog(logPo);

	}


	public MallTypeLargePo getMallTypeLargePo(MallTypeLargePo po) {
		// TODO Auto-generated method stub
		MallTypeLargePo returnMallTypeLargePo = mallTypeLargeDao.getMallTypeLargePo(po);
		if(!Utility.getName(returnMallTypeLargePo.getMtlpicurl()).equals("")){
			returnMallTypeLargePo.setMtlpicurl2(returnMallTypeLargePo.getMtlpicurl()+",");			
		}
		return returnMallTypeLargePo;
	}
	
	public List<MallTypeLargePo> getMallTypeLargePoList(
			MallTypeLargePo po) {
		return mallTypeLargeDao.getMallTypeLargePoList(po);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public MallTypeLargeDao getMallTypeLargeDao() {
		return mallTypeLargeDao;
	}

	public void setMallTypeLargeDao(MallTypeLargeDao mallTypeLargeDao) {
		this.mallTypeLargeDao = mallTypeLargeDao;
	}
}
