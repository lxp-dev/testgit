package com.pengsheng.eims.hydsycasehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.hydsycasehistory.dao.YjCheckHydsyDao;
import com.pengsheng.eims.hydsycasehistory.mgr.YjCheckHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.YjCheckPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public class YjCheckHydsyMgrImpl implements YjCheckHydsyMgr {
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private YjCheckHydsyDao yjCheckHydsyDao;

	public YjCheckHydsyDao getYjCheckHydsyDao() {
		return yjCheckHydsyDao;
	}

	public void setYjCheckHydsyDao(YjCheckHydsyDao yjCheckHydsyDao) {
		this.yjCheckHydsyDao = yjCheckHydsyDao;
	}

	public int getYjCheckCount(YjCheckPo po) {
		
		return yjCheckHydsyDao.getYjCheckCount(po);
	}
	
	public List<YjCheckPo> getEyesCheckList(YjCheckPo po, int start,
			int size) {

		return yjCheckHydsyDao.getYjCheckList(po, start, size);
	}
	
	public void insertYjCheck(YjCheckPo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		yjCheckHydsyDao.insertYjCheck(po);
		
	}
	public void deleteYjCheck(YjCheckPo po,LogisticsLogPo logPo){
		logisticsLogDao.insertLog(logPo);  //新增日志
		yjCheckHydsyDao.deleteYjCheck(po);
	}
	
	public YjCheckPo getEyesCheck(YjCheckPo po) {
		return yjCheckHydsyDao.getYjCheck(po);
	}

	public YjCheckPo getLastYjCheck(YjCheckPo po){
		return yjCheckHydsyDao.getLastYjCheck(po);
	}

	public YjCheckPo getYjCheck(YjCheckPo po) {
		// TODO Auto-generated method stub
		return yjCheckHydsyDao.getYjCheck(po);
	}


	public List<YjCheckPo> getYjCheckList(YjCheckPo po, int start, int size) {
		// TODO Auto-generated method stub
		return yjCheckHydsyDao.getYjCheckList(po, start, size);
	}

}
