package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.EyesCheckDao;
import com.pengsheng.eims.sales.mgr.EyesCheckMgr;
import com.pengsheng.eims.sales.persistence.EyesCheckPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;

public class EyesCheckMgrImpl implements EyesCheckMgr {
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private EyesCheckDao eyesCheckDao;

	public EyesCheckDao getEyesCheckDao() {
		return eyesCheckDao;
	}

	public void setEyesCheckDao(EyesCheckDao eyesCheckDao) {
		this.eyesCheckDao = eyesCheckDao;
	}

	public int getEyesCheckCount(EyesCheckPo po) {
		
		return eyesCheckDao.getEyesCheckCount(po);
	}
	
	public List<EyesCheckPo> getEyesCheckList(EyesCheckPo po, int start,
			int size) {

		return eyesCheckDao.getEyesCheckList(po, start, size);
	}
	
	public void insertEyesCheck(EyesCheckPo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		eyesCheckDao.insertEyesCheck(po);
		
	}
	public EyesCheckPo getEyesCheck(EyesCheckPo po) {

		return eyesCheckDao.getEyesCheck(po);
	}

	
	/**
	 * 查询费用提交数量
	 * @param po
	 * @return
	 */
	public int getEyesChargePutCount(RegisteredCategoryPo po) {
		return eyesCheckDao.getEyecChargePutCount(po);
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
		return eyesCheckDao.getEyesChargePutList(po, start, size);
	}
}
