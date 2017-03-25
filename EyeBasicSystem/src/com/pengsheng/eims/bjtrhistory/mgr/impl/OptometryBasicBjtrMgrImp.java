/**
 * 
 */
package com.pengsheng.eims.bjtrhistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.bjtrhistory.dao.OptometryBasicBjtrDao;
import com.pengsheng.eims.bjtrhistory.mgr.OptometryBasicBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;

/**
 * @author Liuqian
 * 
 */
public class OptometryBasicBjtrMgrImp implements OptometryBasicBjtrMgr {
	private LogisticsLogDao logisticsLogDao;
	
	private OptometryBasicBjtrDao optometryBasicBjtrDao;

	public OptometryBasicBjtrDao getOptometryBasicBjtrDao() {
		return optometryBasicBjtrDao;
	}


	public void setOptometryBasicBjtrDao(OptometryBasicBjtrDao optometryBasicBjtrDao) {
		this.optometryBasicBjtrDao = optometryBasicBjtrDao;
	}


	public int getcustomerOptometryBasicCount(String customerID) {
		return optometryBasicBjtrDao.getcustomerOptometryBasicCount(customerID);
	}


	public List<OptometryBasicPo> getcustomerOptometryBasics(String customerID,
			int start, int size) {
		return optometryBasicBjtrDao.getcustomerOptometryBasics(customerID, start,
				size);
	}

	
	public List<OptometryPo> getcustomerOptometrys(String basicID) {
		return optometryBasicBjtrDao.getcustomerOptometrys(basicID);
	}

	
	public void delOptometryData(String basicID, String optometryID,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		if (optometryBasicBjtrDao.getOptometryCount(basicID) == 1) {
			// 删除验光基表
			optometryBasicBjtrDao.delOptometryBasic(basicID);
		}

		// 删除验光病历表
		optometryBasicBjtrDao.delOptometry(optometryID);

		// 删除双眼视功能
		optometryBasicBjtrDao.delDoubleEyeFun(optometryID);

		// 删除特殊功能检查
		optometryBasicBjtrDao.delHealthCheck(optometryID);

		// 删除检查结论
		optometryBasicBjtrDao.delInspection(optometryID);
		
		// 删除屈光检查
		optometryBasicBjtrDao.delRefractive(optometryID);
	}

	
	public int getOptometryCount2(OptometryPo optometryPo) {
		return this.optometryBasicBjtrDao.getOptometryCount2(optometryPo);
	}
	
	public int getOptometryBasicCount2(OptometryBasicPo optometryBasicPo){
		return this.optometryBasicBjtrDao.getOptometryBasicCount2(optometryBasicPo);
	}
	
	public OptometryPo getOptometryPo(String optometryBasicID){
		return this.optometryBasicBjtrDao.getOptometryPo(optometryBasicID);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	public OptometryPo selectOptometryPo(String optometryid){
		return this.optometryBasicBjtrDao.selectOptometryPo(optometryid);
	}
}
