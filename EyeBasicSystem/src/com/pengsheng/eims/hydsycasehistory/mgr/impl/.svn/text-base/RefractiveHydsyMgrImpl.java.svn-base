package com.pengsheng.eims.hydsycasehistory.mgr.impl;

import com.pengsheng.eims.hydsycasehistory.dao.OptometryBasicHydsyDao;
import com.pengsheng.eims.hydsycasehistory.dao.RefractiveHydsyDao;
import com.pengsheng.eims.hydsycasehistory.mgr.RefractiveHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.hydsycasehistory.persistence.RefractivePo;
import com.pengsheng.eims.util.tools.Utility;

public class RefractiveHydsyMgrImpl implements RefractiveHydsyMgr {
	private RefractiveHydsyDao refractiveHydsyDao;
	private OptometryBasicHydsyDao optometryBasicHydsyDao;
	
	public RefractiveHydsyDao getRefractiveHydsyDao() {
		return refractiveHydsyDao;
	}

	public void setRefractiveHydsyDao(RefractiveHydsyDao refractiveHydsyDao) {
		this.refractiveHydsyDao = refractiveHydsyDao;
	}

	public OptometryBasicHydsyDao getOptometryBasicHydsyDao() {
		return optometryBasicHydsyDao;
	}

	public void setOptometryBasicHydsyDao(OptometryBasicHydsyDao optometryBasicHydsyDao) {
		this.optometryBasicHydsyDao = optometryBasicHydsyDao;
	}

	public void insertRefractivePo(RefractivePo refractivePo, OptometryPo optometryPo,
			OptometryBasicPo optometryBasicPo){
		if(optometryBasicPo!=null){
			if(this.optometryBasicHydsyDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicHydsyDao.optometryBasicInsert(optometryBasicPo);
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
		refractiveHydsyDao.insertRefractivePo(refractivePo);
	}
	
	public void updateRefractive(RefractivePo po,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo){
		refractiveHydsyDao.updateRefractive(po);
		optometryPo.setSopoyoptometryid(po.getSoproptometryid());
		refractiveHydsyDao.updateOptometry(optometryPo);
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		refractiveHydsyDao.updateOptometryBasic(optometryBasicPo);
		if(!Utility.getName(optometryBasicPo.getSopoboptometrybasicid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime(optometryBasicPo.getSopoboptometrybasicid());
		}
	}
	
	public int getRefractiveCount(OptometryPo optometryPo){
		return refractiveHydsyDao.getRefractiveCount(optometryPo);
	}
	

	/**
	 * 显示屈光检查
	 * @param po
	 * @return
	 */
	public RefractivePo getRefractive(RefractivePo po) {
		return refractiveHydsyDao.getRefractive(po);
	}

}
