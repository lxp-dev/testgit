package com.pengsheng.eims.sales.mgr.impl;

import com.pengsheng.eims.sales.dao.OptometryBasicDao;
import com.pengsheng.eims.sales.dao.SpecialCheckDao;
import com.pengsheng.eims.sales.mgr.SpecialCheckMgr;
import com.pengsheng.eims.sales.persistence.HealthCheckPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.util.tools.Utility;

public class SpecialCheckMgrImpl implements SpecialCheckMgr {

	private SpecialCheckDao specialCheckDao;
		
	
	public SpecialCheckDao getSpecialCheckDao() {
		return specialCheckDao;
	}

	public void setSpecialCheckDao(SpecialCheckDao specialCheckDao) {
		this.specialCheckDao = specialCheckDao;
	}
	
	private OptometryBasicDao optometryBasicDao;

	public OptometryBasicDao getOptometryBasicDao() {
		return optometryBasicDao;
	}

	public void setOptometryBasicDao(OptometryBasicDao optometryBasicDao) {
		this.optometryBasicDao = optometryBasicDao;
	}

	/**
	 * 查询特殊功能检查
	 */
	public HealthCheckPo getSpecialCheck(HealthCheckPo healthCheckPo) {
		// TODO Auto-generated method stub
		return specialCheckDao.getSpecialCheck(healthCheckPo);
	}

	/**
	 * 新增特殊功能检查
	 */
	public void insertSpecialCheck(HealthCheckPo healthCheckPo,OptometryBasicPo optometryBasicPo,OptometryPo optometryPo) {
		// TODO Auto-generated method stub

		if(optometryBasicPo!=null){
			if(this.optometryBasicDao.getOptometryBasicCount2(optometryBasicPo)==0){
//				String basicid=optometryBasicDao.getOptometryBasicPo1(optometryPo.getSopoyoptometryid()).getSopoboptometrybasicid();
//				if(!optometryBasicPo.getSopoboptometrybasicid().equals(basicid)){
//					
//				}else{
					this.optometryBasicDao.optometryBasicInsert(optometryBasicPo);
//				}
			}
		}
		if(this.optometryBasicDao.getOptometryCount2(optometryPo)==0){
			this.optometryBasicDao.optometryInsert(optometryPo);
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		specialCheckDao.insertSpecialCheck(healthCheckPo);
	}

	/**
	 * 更新验光基表
	 */
	public void updateOptometryBasicCheck(OptometryBasicPo optometryBasicPo) {
		// TODO Auto-generated method stub
		specialCheckDao.updateOptometryBasicCheck(optometryBasicPo);
	}

	/**
	 * 更新验光表
	 */
	public void updateOptometryCheck(OptometryPo optometryPo) {
		// TODO Auto-generated method stub
		specialCheckDao.updateOptometryCheck(optometryPo);
	}

	/**
	 * 更新特殊功能检查
	 */
	public void updateSpecialCheck(HealthCheckPo healthCheckPo) {
		// TODO Auto-generated method stub
		specialCheckDao.updateSpecialCheck(healthCheckPo);
	}


	public void insertSpecialCheck(HealthCheckPo healthCheckPo) {
		// TODO Auto-generated method stub
		specialCheckDao.insertSpecialCheck(healthCheckPo);
	}

	
	public int getSpecialCheckCount(OptometryPo optometryPo) {
		// TODO Auto-generated method stub
		return this.specialCheckDao.getSpecailCheckCount(optometryPo);
	}
	

	public void updateSpecialCheck(HealthCheckPo healthCheckPo,
			OptometryBasicPo optometryBasicPo, OptometryPo optometryPo) {
		if(optometryBasicPo!=null){
			if(this.optometryBasicDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicDao.optometryBasicInsert(optometryBasicPo);
			}else{
				
			}
		}	
		if(optometryPo!=null){
			if(this.optometryBasicDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicDao.optometryInsert(optometryPo);
			}else{	
				specialCheckDao.updateOptometryCheck(optometryPo);
			}
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		specialCheckDao.updateSpecialCheck(healthCheckPo);
		
	}
	

}
