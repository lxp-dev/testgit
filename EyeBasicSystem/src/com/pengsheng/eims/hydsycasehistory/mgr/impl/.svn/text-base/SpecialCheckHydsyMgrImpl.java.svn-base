package com.pengsheng.eims.hydsycasehistory.mgr.impl;

import com.pengsheng.eims.hydsycasehistory.dao.OptometryBasicHydsyDao;
import com.pengsheng.eims.hydsycasehistory.dao.SpecialCheckHydsyDao;
import com.pengsheng.eims.hydsycasehistory.mgr.SpecialCheckHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.util.tools.Utility;

public class SpecialCheckHydsyMgrImpl implements SpecialCheckHydsyMgr {

	private SpecialCheckHydsyDao specialCheckHydsyDao;
	
	private OptometryBasicHydsyDao optometryBasicHydsyDao;
	
	public SpecialCheckHydsyDao getSpecialCheckHydsyDao() {
		return specialCheckHydsyDao;
	}

	public void setSpecialCheckHydsyDao(SpecialCheckHydsyDao specialCheckHydsyDao) {
		this.specialCheckHydsyDao = specialCheckHydsyDao;
	}

	public OptometryBasicHydsyDao getOptometryBasicHydsyDao() {
		return optometryBasicHydsyDao;
	}

	public void setOptometryBasicHydsyDao(OptometryBasicHydsyDao optometryBasicHydsyDao) {
		this.optometryBasicHydsyDao = optometryBasicHydsyDao;
	}

	/**
	 * 查询特殊功能检查
	 */
	public HealthCheckPo getSpecialCheck(HealthCheckPo healthCheckPo) {
		return specialCheckHydsyDao.getSpecialCheck(healthCheckPo);
	}

	/**
	 * 新增特殊功能检查
	 */
	public void insertSpecialCheck(HealthCheckPo healthCheckPo,OptometryBasicPo optometryBasicPo,OptometryPo optometryPo) {

		if(optometryBasicPo!=null){
			if(this.optometryBasicHydsyDao.getOptometryBasicCount2(optometryBasicPo)==0){
//				String basicid=optometryBasicHydsyDao.getOptometryBasicPo1(optometryPo.getSopoyoptometryid()).getSopoboptometrybasicid();
//				if(!optometryBasicPo.getSopoboptometrybasicid().equals(basicid)){
//					
//				}else{
					this.optometryBasicHydsyDao.optometryBasicInsert(optometryBasicPo);
//				}
			}
		}
		if(this.optometryBasicHydsyDao.getOptometryCount2(optometryPo)==0){
			this.optometryBasicHydsyDao.optometryInsert(optometryPo);
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		specialCheckHydsyDao.insertSpecialCheck(healthCheckPo);
	}

	/**
	 * 更新验光基表
	 */
	public void updateOptometryBasicCheck(OptometryBasicPo optometryBasicPo) {
		specialCheckHydsyDao.updateOptometryBasicCheck(optometryBasicPo);
	}

	/**
	 * 更新验光表
	 */
	public void updateOptometryCheck(OptometryPo optometryPo) {
		specialCheckHydsyDao.updateOptometryCheck(optometryPo);
	}

	/**
	 * 更新特殊功能检查
	 */
	public void updateSpecialCheck(HealthCheckPo healthCheckPo) {
		specialCheckHydsyDao.updateSpecialCheck(healthCheckPo);
	}


	public void insertSpecialCheck(HealthCheckPo healthCheckPo) {
		specialCheckHydsyDao.insertSpecialCheck(healthCheckPo);
	}

	
	public int getSpecialCheckCount(OptometryPo optometryPo) {
		return this.specialCheckHydsyDao.getSpecailCheckCount(optometryPo);
	}
	

	public void updateSpecialCheck(HealthCheckPo healthCheckPo,
			OptometryBasicPo optometryBasicPo, OptometryPo optometryPo) {
		if(optometryBasicPo!=null){
			if(this.optometryBasicHydsyDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicHydsyDao.optometryBasicInsert(optometryBasicPo);
			}else{
				
			}
		}	
		if(optometryPo!=null){
			if(this.optometryBasicHydsyDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicHydsyDao.optometryInsert(optometryPo);
			}else{	
				specialCheckHydsyDao.updateOptometryCheck(optometryPo);
			}
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		specialCheckHydsyDao.updateSpecialCheck(healthCheckPo);
		
	}
	

}
