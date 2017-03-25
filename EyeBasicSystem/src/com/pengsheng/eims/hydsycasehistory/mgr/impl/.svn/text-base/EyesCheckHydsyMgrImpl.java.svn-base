package com.pengsheng.eims.hydsycasehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.hydsycasehistory.dao.EyesCheckHydsyDao;
import com.pengsheng.eims.hydsycasehistory.mgr.EyesCheckHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.EyesCheckPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;

public class EyesCheckHydsyMgrImpl implements EyesCheckHydsyMgr {
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private EyesCheckHydsyDao eyesCheckHydsyDao;

	public EyesCheckHydsyDao getEyesCheckHydsyDao() {
		return eyesCheckHydsyDao;
	}

	public void setEyesCheckHydsyDao(EyesCheckHydsyDao eyesCheckHydsyDao) {
		this.eyesCheckHydsyDao = eyesCheckHydsyDao;
	}

	public int getEyesCheckCount(EyesCheckPo po) {
		
		return eyesCheckHydsyDao.getEyesCheckCount(po);
	}
	
	public List<EyesCheckPo> getEyesCheckList(EyesCheckPo po, int start,
			int size) {

		return eyesCheckHydsyDao.getEyesCheckList(po, start, size);
	}
	
	public void insertEyesCheck(EyesCheckPo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		eyesCheckHydsyDao.insertEyesCheck(po);
		
	}
	public EyesCheckPo getEyesCheck(EyesCheckPo po) {
		return eyesCheckHydsyDao.getEyesCheck(po);
	}

	
	/**
	 * 查询费用提交数量
	 * @param po
	 * @return
	 */
	public int getEyesChargePutCount(RegisteredCategoryPo po) {
		return eyesCheckHydsyDao.getEyecChargePutCount(po);
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
		return eyesCheckHydsyDao.getEyesChargePutList(po, start, size);
	}
}
