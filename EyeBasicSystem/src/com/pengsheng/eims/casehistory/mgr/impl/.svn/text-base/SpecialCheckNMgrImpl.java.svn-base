package com.pengsheng.eims.casehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.casehistory.dao.OptometryBasicNDao;
import com.pengsheng.eims.casehistory.dao.SpecialCheckNDao;
import com.pengsheng.eims.casehistory.mgr.SpecialCheckNMgr;
import com.pengsheng.eims.casehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.casehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPhotoPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.tools.Utility;

public class SpecialCheckNMgrImpl implements SpecialCheckNMgr {

	private SpecialCheckNDao specialCheckNDao;	
	private OptometryBasicNDao optometryBasicNDao;
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public SpecialCheckNDao getSpecialCheckNDao() {
		return specialCheckNDao;
	}

	public void setSpecialCheckNDao(SpecialCheckNDao specialCheckNDao) {
		this.specialCheckNDao = specialCheckNDao;
	}

	public OptometryBasicNDao getOptometryBasicNDao() {
		return optometryBasicNDao;
	}

	public void setOptometryBasicNDao(OptometryBasicNDao optometryBasicNDao) {
		this.optometryBasicNDao = optometryBasicNDao;
	}

	/**
	 * 查询特殊功能检查
	 */
	public HealthCheckPo getSpecialCheck(HealthCheckPo healthCheckPo) {
		return specialCheckNDao.getSpecialCheck(healthCheckPo);
	}

	/**
	 * 新增特殊功能检查
	 */
	public void insertSpecialCheck(HealthCheckPo healthCheckPo,OptometryBasicPo optometryBasicPo,OptometryPo optometryPo) {

		if(optometryBasicPo!=null){
			if(this.optometryBasicNDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicNDao.optometryBasicInsert(optometryBasicPo);
			}
		}
		if(this.optometryBasicNDao.getOptometryCount2(optometryPo)==0){
			this.optometryBasicNDao.optometryInsert(optometryPo);
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		specialCheckNDao.insertSpecialCheck(healthCheckPo);
	}

	/**
	 * 更新验光基表
	 */
	public void updateOptometryBasicCheck(OptometryBasicPo optometryBasicPo) {
		specialCheckNDao.updateOptometryBasicCheck(optometryBasicPo);
	}

	/**
	 * 更新验光表
	 */
	public void updateOptometryCheck(OptometryPo optometryPo) {
		specialCheckNDao.updateOptometryCheck(optometryPo);
	}

	/**
	 * 更新特殊功能检查
	 */
	public void updateSpecialCheck(HealthCheckPo healthCheckPo) {
		specialCheckNDao.updateSpecialCheck(healthCheckPo);
	}


	public void insertSpecialCheck(HealthCheckPo healthCheckPo) {
		specialCheckNDao.insertSpecialCheck(healthCheckPo);
	}

	
	public int getSpecialCheckCount(OptometryPo optometryPo) {
		return this.specialCheckNDao.getSpecailCheckCount(optometryPo);
	}
	

	public void updateSpecialCheck(HealthCheckPo healthCheckPo,
			OptometryBasicPo optometryBasicPo, OptometryPo optometryPo) {
		if(optometryBasicPo!=null){
			if(this.optometryBasicNDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicNDao.optometryBasicInsert(optometryBasicPo);
			}else{
				
			}
		}	
		if(optometryPo!=null){
			if(this.optometryBasicNDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicNDao.optometryInsert(optometryPo);
			}else{	
				specialCheckNDao.updateOptometryCheck(optometryPo);
			}
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		specialCheckNDao.updateSpecialCheck(healthCheckPo);
		
	}
	
	public List<OptometryPhotoPo> getOptometryPhotoList(OptometryPo optometryPo){
		return specialCheckNDao.getOptometryPhotoList(optometryPo);
	}
	
	public void insertOptometryPhoto(OptometryBasicPo optometryBasicPo,OptometryPo optometryPo,OptometryPhotoPo oppo,LogisticsLogPo logPo){
		
		if(optometryBasicPo != null){
			if(this.optometryBasicNDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicNDao.optometryBasicInsert(optometryBasicPo);
			}
		}
		if(optometryPo != null && this.optometryBasicNDao.getOptometryCount2(optometryPo)==0){
			this.optometryBasicNDao.optometryInsert(optometryPo);
		}
		
		specialCheckNDao.deleteOptometryPhoto(oppo);
		
		String[] picUrlArray = Utility.getName(oppo.getSopoppicurlarray()).split(",");
		String[] fixArray = null;
		
		for (int i = 0; i < picUrlArray.length; i++){
			
			fixArray = Utility.getName(picUrlArray[i]).split("_");
			
			if (fixArray.length > 1){
				oppo.setSopoppicurl(fixArray[0]);
				oppo.setSopopfixid(fixArray[1]);		
				specialCheckNDao.insertOptometryPhoto(oppo);
			}
		}
		
		logisticsLogDao.insertLog(logPo);

	}
	

}
