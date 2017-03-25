package com.pengsheng.eims.personnel.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.dao.ShiftMaintainDao;
import com.pengsheng.eims.personnel.mgr.ShiftMaintainMgr;
import com.pengsheng.eims.personnel.persistence.ShiftMaintainPo;

public class ShiftMaintainMgrImpl implements ShiftMaintainMgr
{
	private LogisticsLogDao logisticsLogDao;
	private ShiftMaintainDao shiftMaintainDao;
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public ShiftMaintainDao getShiftMaintainDao() {
		return shiftMaintainDao;
	}
	public void setShiftMaintainDao(ShiftMaintainDao shiftMaintainDao) {
		this.shiftMaintainDao = shiftMaintainDao;
	}
	
	public void deleteShiftMaintainPo(ShiftMaintainPo po,LogisticsLogPo logPo) {
		shiftMaintainDao.deleteShiftMaintainPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	
	public void insertShiftMaintainPo(ShiftMaintainPo po,LogisticsLogPo logPo) {
		shiftMaintainDao.insertShiftMaintainPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	
	public int selectShiftMaintainCount(ShiftMaintainPo po) {
		return shiftMaintainDao.selectShiftMaintainCount(po);
	}
	public int getShiftMaintainPoId(ShiftMaintainPo po){
		return shiftMaintainDao.getShiftMaintainPoId(po);
	}
	public int getShiftMaintainPoName(ShiftMaintainPo po){
		return shiftMaintainDao.getShiftMaintainPoName(po);
	}
	public int getShiftMaintainPoIdUpdate(ShiftMaintainPo po)
	{
		return shiftMaintainDao.getShiftMaintainPoIdUpdate(po);
	}
	public int getShiftMaintainPoNameUpdate(ShiftMaintainPo po)
	{
		return shiftMaintainDao.getShiftMaintainPoNameUpdate(po);
	}
	
	public List<ShiftMaintainPo> selectShiftMaintainList(ShiftMaintainPo po, int start, int size) {
		
		return shiftMaintainDao.selectShiftMaintainList(po, start, size);
	}

	
	public ShiftMaintainPo selectShiftMaintainPo(ShiftMaintainPo po) {
		
		return shiftMaintainDao.selectShiftMaintainPo(po);
	}

	
	public void updateShiftMaintainPo(ShiftMaintainPo po,LogisticsLogPo logPo) {
		shiftMaintainDao.updateShiftMaintainPo(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	
}
