package com.pengsheng.eims.casehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.casehistory.dao.EyesCheckNDao;
import com.pengsheng.eims.casehistory.mgr.EyesCheckNMgr;
import com.pengsheng.eims.casehistory.persistence.EyesCheckPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;

public class EyesCheckNMgrImpl implements EyesCheckNMgr {
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private EyesCheckNDao eyesCheckNDao;

	public EyesCheckNDao getEyesCheckNDao() {
		return eyesCheckNDao;
	}

	public void setEyesCheckNDao(EyesCheckNDao eyesCheckNDao) {
		this.eyesCheckNDao = eyesCheckNDao;
	}

	public int getEyesCheckCount(EyesCheckPo po) {
		
		return eyesCheckNDao.getEyesCheckCount(po);
	}
	
	public List<EyesCheckPo> getEyesCheckList(EyesCheckPo po, int start,
			int size) {

		return eyesCheckNDao.getEyesCheckList(po, start, size);
	}
	
	public void insertEyesCheck(EyesCheckPo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		eyesCheckNDao.insertEyesCheck(po);
		
	}
	public EyesCheckPo getEyesCheck(EyesCheckPo po) {
		return eyesCheckNDao.getEyesCheck(po);
	}

	
	/**
	 * 查询费用提交数量
	 * @param po
	 * @return
	 */
	public int getEyesChargePutCount(RegisteredCategoryPo po) {
		return eyesCheckNDao.getEyecChargePutCount(po);
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
		return eyesCheckNDao.getEyesChargePutList(po, start, size);
	}
}
