/**
 * 
 */
package com.pengsheng.eims.hydsycasehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.hydsycasehistory.dao.OptometryBasicHydsyDao;
import com.pengsheng.eims.hydsycasehistory.mgr.OptometryBasicHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

/**
 * @author Liuqian
 * 
 */
public class OptometryBasicHydsyMgrImpl implements OptometryBasicHydsyMgr {
	private LogisticsLogDao logisticsLogDao;
	
	private OptometryBasicHydsyDao optometryBasicHydsyDao;

	public OptometryBasicHydsyDao getOptometryBasicHydsyDao() {
		return optometryBasicHydsyDao;
	}


	public void setOptometryBasicHydsyDao(OptometryBasicHydsyDao optometryBasicHydsyDao) {
		this.optometryBasicHydsyDao = optometryBasicHydsyDao;
	}


	public int getcustomerOptometryBasicCount(String customerID) {
		return optometryBasicHydsyDao.getcustomerOptometryBasicCount(customerID);
	}


	public List<OptometryBasicPo> getcustomerOptometryBasics(String customerID,
			int start, int size) {
		return optometryBasicHydsyDao.getcustomerOptometryBasics(customerID, start,
				size);
	}

	
	public List<OptometryPo> getcustomerOptometrys(String basicID) {
		return optometryBasicHydsyDao.getcustomerOptometrys(basicID);
	}

	
	public void delOptometryData(String basicID, String optometryID,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		if (optometryBasicHydsyDao.getOptometryCount(basicID) == 1) {
			// 删除验光基表
			optometryBasicHydsyDao.delOptometryBasic(basicID);
		}

		// 删除验光病历表
		optometryBasicHydsyDao.delOptometry(optometryID);

		// 删除双眼视功能
		optometryBasicHydsyDao.delDoubleEyeFun(optometryID);

		// 删除特殊功能检查
		optometryBasicHydsyDao.delHealthCheck(optometryID);

		// 删除检查结论
		optometryBasicHydsyDao.delInspection(optometryID);
		
		// 删除屈光检查
		optometryBasicHydsyDao.delRefractive(optometryID);
	}

	
	public int getOptometryCount2(OptometryPo optometryPo) {
		return this.optometryBasicHydsyDao.getOptometryCount2(optometryPo);
	}
	
	public int getOptometryBasicCount2(OptometryBasicPo optometryBasicPo){
		return this.optometryBasicHydsyDao.getOptometryBasicCount2(optometryBasicPo);
	}
	
	public OptometryPo getOptometryPo(String optometryBasicID){
		return this.optometryBasicHydsyDao.getOptometryPo(optometryBasicID);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	public OptometryPo selectOptometryPo(String optometryid){
		return this.optometryBasicHydsyDao.selectOptometryPo(optometryid);
	}
}
