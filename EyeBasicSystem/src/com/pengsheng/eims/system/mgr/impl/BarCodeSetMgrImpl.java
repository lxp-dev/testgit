package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.BarCodeSetDao;
import com.pengsheng.eims.system.mgr.BarCodeSetMgr;
import com.pengsheng.eims.system.persistence.BarCodeSetPo;

public class BarCodeSetMgrImpl implements BarCodeSetMgr {
	
	private BarCodeSetDao barCodeSetDao;
	
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public BarCodeSetDao getBarCodeSetDao() {
		return barCodeSetDao;
	}

	public void setBarCodeSetDao(BarCodeSetDao barCodeSetDao) {
		this.barCodeSetDao = barCodeSetDao;
	}

	public int getBarCodeSetCount(BarCodeSetPo barCodeSetPo) {
		
		return barCodeSetDao.getBarCodeSetCount(barCodeSetPo);
	}
	
	public List<BarCodeSetPo> getBarCodeSetList(BarCodeSetPo barCodeSetPo,
			int start, int size) {
		
		return barCodeSetDao.getBarCodeSetList(barCodeSetPo, start, size);
	}
	
	public void insertBarCodeSet(BarCodeSetPo barCodeSetPo, LogisticsLogPo logPo) {
		
		barCodeSetDao.insertBarCodeSet(barCodeSetPo);
		
		barCodeSetDao.insertBarCodeSetForGoods(barCodeSetPo);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	public void updateBarCodeSet(BarCodeSetPo barCodeSetPo, LogisticsLogPo logPo) {
		
		barCodeSetDao.updateBarCodeSet(barCodeSetPo);		
		
		BarCodeSetPo barCodePo=barCodeSetDao.getBarCodeSetPo(barCodeSetPo);
		
		barCodeSetDao.insertBarCodeSetForGoods(barCodePo);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	public void deleteBarCodeSet(BarCodeSetPo barCodeSetPo, LogisticsLogPo logPo) {
		
		BarCodeSetPo barCodePo=barCodeSetDao.getBarCodeSetPo(barCodeSetPo);
		
		barCodePo.setFbcsbarcodeflag("0");
		
		barCodeSetDao.deleteBarCodeSet(barCodeSetPo);
		
		barCodeSetDao.insertBarCodeSetForGoods(barCodePo);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	
	public int isBarCodeSet(BarCodeSetPo barCodeSetPo) {
		
		return barCodeSetDao.isBarCodeSet(barCodeSetPo);
	}
	
	
	public BarCodeSetPo getBarCodeSetPo(BarCodeSetPo barCodeSetPo) {
		
		return barCodeSetDao.getBarCodeSetPo(barCodeSetPo);
	}
	
}
