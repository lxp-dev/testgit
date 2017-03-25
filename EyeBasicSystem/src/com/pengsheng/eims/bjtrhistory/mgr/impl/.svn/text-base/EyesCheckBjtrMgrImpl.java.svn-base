package com.pengsheng.eims.bjtrhistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.bjtrhistory.dao.EyesCheckBjtrDao;
import com.pengsheng.eims.bjtrhistory.mgr.EyesCheckBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.EyesCheckPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;

public class EyesCheckBjtrMgrImpl implements EyesCheckBjtrMgr {
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private EyesCheckBjtrDao eyesCheckBjtrDao;

	public EyesCheckBjtrDao getEyesCheckBjtrDao() {
		return eyesCheckBjtrDao;
	}

	public void setEyesCheckBjtrDao(EyesCheckBjtrDao eyesCheckBjtrDao) {
		this.eyesCheckBjtrDao = eyesCheckBjtrDao;
	}

	public int getEyesCheckCount(EyesCheckPo po) {
		
		return eyesCheckBjtrDao.getEyesCheckCount(po);
	}
	
	public List<EyesCheckPo> getEyesCheckList(EyesCheckPo po, int start,
			int size) {

		return eyesCheckBjtrDao.getEyesCheckList(po, start, size);
	}
	
	public void insertEyesCheck(EyesCheckPo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		eyesCheckBjtrDao.insertEyesCheck(po);
	}
	
	public EyesCheckPo getEyesCheck(EyesCheckPo po) {
		return eyesCheckBjtrDao.getEyesCheck(po);
	}

	
	/**
	 * 查询费用提交数量
	 * @param po
	 * @return
	 */
	public int getEyesChargePutCount(RegisteredCategoryPo po) {
		return eyesCheckBjtrDao.getEyecChargePutCount(po);
	}

	/**
	 * 显示费用提交信息并分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<RegisteredCategoryPo> getEyesChargePutList(RegisteredCategoryPo po,
			int start, int size) {
		return eyesCheckBjtrDao.getEyesChargePutList(po, start, size);
	}
}
