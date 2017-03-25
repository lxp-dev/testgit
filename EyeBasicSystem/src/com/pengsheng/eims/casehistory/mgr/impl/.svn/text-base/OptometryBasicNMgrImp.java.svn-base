/**
 * 
 */
package com.pengsheng.eims.casehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.casehistory.dao.OptometryBasicNDao;
import com.pengsheng.eims.casehistory.mgr.OptometryBasicNMgr;
import com.pengsheng.eims.casehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;

/**
 * @author Liuqian
 * 
 */
public class OptometryBasicNMgrImp implements OptometryBasicNMgr {
	private LogisticsLogDao logisticsLogDao;
	
	private OptometryBasicNDao optometryBasicNDao;

	public OptometryBasicNDao getOptometryBasicNDao() {
		return optometryBasicNDao;
	}


	public void setOptometryBasicNDao(OptometryBasicNDao optometryBasicNDao) {
		this.optometryBasicNDao = optometryBasicNDao;
	}


	public int getcustomerOptometryBasicCount(CustomerInfoPo po) {
		return optometryBasicNDao.getcustomerOptometryBasicCount(po);
	}


	public List<OptometryBasicPo> getcustomerOptometryBasics(CustomerInfoPo po,
			int start, int size) {
		return optometryBasicNDao.getcustomerOptometryBasics(po, start,
				size);
	}

	
	public List<OptometryPo> getcustomerOptometrys(String basicID) {
		return optometryBasicNDao.getcustomerOptometrys(basicID);
	}

	
	public void delOptometryData(String basicID, String optometryID,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		if (optometryBasicNDao.getOptometryCount(basicID) == 1) {
			// 删除验光基表
			optometryBasicNDao.delOptometryBasic(basicID);
		}

		// 删除验光病历表
		optometryBasicNDao.delOptometry(optometryID);

		// 删除双眼视功能
		optometryBasicNDao.delDoubleEyeFun(optometryID);

		// 删除特殊功能检查
		optometryBasicNDao.delHealthCheck(optometryID);

		// 删除检查结论
		optometryBasicNDao.delInspection(optometryID);
		
		// 删除屈光检查
		optometryBasicNDao.delRefractive(optometryID);
		
		// 删除验光设备上传的图片
		optometryBasicNDao.delOptometryPhoto(optometryID);
		
	}

	
	public int getOptometryCount2(OptometryPo optometryPo) {
		return this.optometryBasicNDao.getOptometryCount2(optometryPo);
	}
	
	public int getOptometryBasicCount2(OptometryBasicPo optometryBasicPo){
		return this.optometryBasicNDao.getOptometryBasicCount2(optometryBasicPo);
	}
	
	public OptometryPo getOptometryPo(String optometryBasicID){
		return this.optometryBasicNDao.getOptometryPo(optometryBasicID);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	public OptometryPo selectOptometryPo(String optometryid){
		return this.optometryBasicNDao.selectOptometryPo(optometryid);
	}
}
