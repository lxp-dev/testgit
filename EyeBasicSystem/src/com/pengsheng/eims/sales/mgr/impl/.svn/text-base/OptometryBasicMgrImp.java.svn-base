/**
 * 
 */
package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.OptometryBasicDao;
import com.pengsheng.eims.sales.mgr.OptometryBasicMgr;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;

/**
 * @author Liuqian
 * 
 */
public class OptometryBasicMgrImp implements OptometryBasicMgr {
	private LogisticsLogDao logisticsLogDao;
	
	private OptometryBasicDao optometryBasicDao;

	public OptometryBasicDao getOptometryBasicDao() {
		return optometryBasicDao;
	}

	public void setOptometryBasicDao(OptometryBasicDao optometryBasicDao) {
		this.optometryBasicDao = optometryBasicDao;
	}

	
	public int getcustomerOptometryBasicCount(CustomerInfoPo customerInfoPo) {
		// TODO Auto-generated method stub
		return optometryBasicDao.getcustomerOptometryBasicCount(customerInfoPo);
	}


	public List<OptometryBasicPo> getcustomerOptometryBasics(CustomerInfoPo customerInfoPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return optometryBasicDao.getcustomerOptometryBasics(customerInfoPo, start,
				size);
	}

	
	public List<OptometryPo> getcustomerOptometrys(String basicID) {
		// TODO Auto-generated method stub
		return optometryBasicDao.getcustomerOptometrys(basicID);
	}

	
	public void delOptometryData(String basicID, String optometryID,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		if (optometryBasicDao.getOptometryCount(basicID) == 1) {
			// 删除验光基表
			optometryBasicDao.delOptometryBasic(basicID);
		}

		// 删除验光病历表
		optometryBasicDao.delOptometry(optometryID);

		// 删除双眼视功能
		optometryBasicDao.delDoubleEyeFun(optometryID);

		// 删除特殊功能检查
		optometryBasicDao.delHealthCheck(optometryID);

		// 删除检查结论
		optometryBasicDao.delInspection(optometryID);
		
		// 删除屈光检查
		optometryBasicDao.delRefractive(optometryID);
	}

	
	public int getOptometryCount2(OptometryPo optometryPo) {
		// TODO Auto-generated method stub
		return this.optometryBasicDao.getOptometryCount2(optometryPo);
	}
	
	public int getOptometryBasicCount2(OptometryBasicPo optometryBasicPo){
		return this.optometryBasicDao.getOptometryBasicCount2(optometryBasicPo);
	}
	
	public OptometryPo getOptometryPo(String optometryBasicID){
		return this.optometryBasicDao.getOptometryPo(optometryBasicID);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
}
