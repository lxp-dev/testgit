package com.pengsheng.eims.casehistory.mgr.impl;

import com.pengsheng.eims.casehistory.dao.OptometryBasicNDao;
import com.pengsheng.eims.casehistory.dao.RefractiveNDao;
import com.pengsheng.eims.casehistory.mgr.RefractiveNMgr;
import com.pengsheng.eims.casehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.casehistory.persistence.RefractivePo;
import com.pengsheng.eims.util.tools.Utility;

public class RefractiveNMgrImpl implements RefractiveNMgr {
	private RefractiveNDao refractiveNDao;
	private OptometryBasicNDao optometryBasicNDao;
	
	public RefractiveNDao getRefractiveNDao() {
		return refractiveNDao;
	}

	public void setRefractiveNDao(RefractiveNDao refractiveNDao) {
		this.refractiveNDao = refractiveNDao;
	}

	public OptometryBasicNDao getOptometryBasicNDao() {
		return optometryBasicNDao;
	}

	public void setOptometryBasicNDao(OptometryBasicNDao optometryBasicNDao) {
		this.optometryBasicNDao = optometryBasicNDao;
	}

	public void insertRefractivePo(RefractivePo refractivePo, OptometryPo optometryPo,OptometryBasicPo optometryBasicPo){
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
		refractiveNDao.insertRefractivePo(refractivePo);
	}
	
	public void updateRefractive(RefractivePo po,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo){
		refractiveNDao.updateRefractive(po);
		optometryPo.setSopoyoptometryid(po.getSoproptometryid());
		refractiveNDao.updateOptometry(optometryPo);
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		refractiveNDao.updateOptometryBasic(optometryBasicPo);
		if(!Utility.getName(optometryBasicPo.getSopoboptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(optometryBasicPo.getSopoboptometrybasicid());
		}
	}
	
	public int getRefractiveCount(OptometryPo optometryPo){
		return refractiveNDao.getRefractiveCount(optometryPo);
	}
	

	/**
	 * 显示屈光检查
	 * @param po
	 * @return
	 */
	public RefractivePo getRefractive(RefractivePo po) {
		RefractivePo rpo = refractiveNDao.getRefractive(po);
		
		
		
		return rpo;
	}

	/**
	 * 根据顾客ID获取最后一次屈光检查信息
	 * @param customerID
	 * @return
	 */
	public RefractivePo getLastRefractive(String customerID){
		return refractiveNDao.getLastRefractive(customerID);
	}
}
