package com.pengsheng.eims.bjtrhistory.mgr.impl;

import com.pengsheng.eims.bjtrhistory.dao.OptometryBasicBjtrDao;
import com.pengsheng.eims.bjtrhistory.dao.SpecialCheckBjtrDao;
import com.pengsheng.eims.bjtrhistory.mgr.SpecialCheckBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.HealthCheckPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;
import com.pengsheng.eims.util.tools.Utility;

public class SpecialCheckBjtrMgrImpl implements SpecialCheckBjtrMgr {

	private SpecialCheckBjtrDao specialCheckBjtrDao;
	
	private OptometryBasicBjtrDao optometryBasicBjtrDao;

	public SpecialCheckBjtrDao getSpecialCheckBjtrDao() {
		return specialCheckBjtrDao;
	}

	public void setSpecialCheckBjtrDao(SpecialCheckBjtrDao specialCheckBjtrDao) {
		this.specialCheckBjtrDao = specialCheckBjtrDao;
	}

	public OptometryBasicBjtrDao getOptometryBasicBjtrDao() {
		return optometryBasicBjtrDao;
	}

	public void setOptometryBasicBjtrDao(OptometryBasicBjtrDao optometryBasicBjtrDao) {
		this.optometryBasicBjtrDao = optometryBasicBjtrDao;
	}

	/**
	 * 查询特殊功能检查
	 */
	public HealthCheckPo getSpecialCheck(HealthCheckPo healthCheckPo) {
		return specialCheckBjtrDao.getSpecialCheck(healthCheckPo);
	}

	/**
	 * 新增特殊功能检查
	 */
	public void insertSpecialCheck(HealthCheckPo healthCheckPo,OptometryBasicPo optometryBasicPo,OptometryPo optometryPo) {

		if(optometryBasicPo!=null){
			if(this.optometryBasicBjtrDao.getOptometryBasicCount2(optometryBasicPo)==0){
//				String basicid=optometryBasicBjtrDao.getOptometryBasicPo1(optometryPo.getSopoyoptometryid()).getSopoboptometrybasicid();
//				if(!optometryBasicPo.getSopoboptometrybasicid().equals(basicid)){
//					
//				}else{
					this.optometryBasicBjtrDao.optometryBasicInsert(optometryBasicPo);
//				}
			}
		}
		if(this.optometryBasicBjtrDao.getOptometryCount2(optometryPo)==0){
			this.optometryBasicBjtrDao.optometryInsert(optometryPo);
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		specialCheckBjtrDao.insertSpecialCheck(healthCheckPo);
	}

	/**
	 * 更新验光基表
	 */
	public void updateOptometryBasicCheck(OptometryBasicPo optometryBasicPo) {
		specialCheckBjtrDao.updateOptometryBasicCheck(optometryBasicPo);
	}

	/**
	 * 更新验光表
	 */
	public void updateOptometryCheck(OptometryPo optometryPo) {
		specialCheckBjtrDao.updateOptometryCheck(optometryPo);
	}

	/**
	 * 更新特殊功能检查
	 */
	public void updateSpecialCheck(HealthCheckPo healthCheckPo) {
		specialCheckBjtrDao.updateSpecialCheck(healthCheckPo);
	}


	public void insertSpecialCheck(HealthCheckPo healthCheckPo) {
		specialCheckBjtrDao.insertSpecialCheck(healthCheckPo);
	}

	
	public int getSpecialCheckCount(OptometryPo optometryPo) {
		return this.specialCheckBjtrDao.getSpecailCheckCount(optometryPo);
	}
	

	public void updateSpecialCheck(HealthCheckPo healthCheckPo,
			OptometryBasicPo optometryBasicPo, OptometryPo optometryPo) {
		if(optometryBasicPo!=null){
			if(this.optometryBasicBjtrDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicBjtrDao.optometryBasicInsert(optometryBasicPo);
			}else{
				
			}
		}	
		if(optometryPo!=null){
			if(this.optometryBasicBjtrDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicBjtrDao.optometryInsert(optometryPo);
			}else{	
				specialCheckBjtrDao.updateOptometryCheck(optometryPo);
			}
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		specialCheckBjtrDao.updateSpecialCheck(healthCheckPo);
		
	}
	

}
