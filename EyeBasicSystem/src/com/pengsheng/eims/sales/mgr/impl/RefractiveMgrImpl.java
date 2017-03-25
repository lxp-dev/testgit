package com.pengsheng.eims.sales.mgr.impl;

import com.pengsheng.eims.sales.dao.OptometryBasicDao;
import com.pengsheng.eims.sales.dao.RefractiveDao;
import com.pengsheng.eims.sales.mgr.RefractiveMgr;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.sales.persistence.RefractivePo;
import com.pengsheng.eims.util.tools.Utility;


public class RefractiveMgrImpl implements RefractiveMgr {
	private RefractiveDao refractiveDao;
	private OptometryBasicDao optometryBasicDao;
	
	public OptometryBasicDao getOptometryBasicDao() {
		return optometryBasicDao;
	}
	public void setOptometryBasicDao(OptometryBasicDao optometryBasicDao) {
		this.optometryBasicDao = optometryBasicDao;
	}
	
	public RefractiveDao getRefractiveDao() {
		return refractiveDao;
	}


	public void setRefractiveDao(RefractiveDao refractiveDao) {
		this.refractiveDao = refractiveDao;
	}
	
	public void insertRefractivePo(RefractivePo refractivePo, OptometryPo optometryPo,
			OptometryBasicPo optometryBasicPo){
		if(optometryBasicPo!=null){
			if(this.optometryBasicDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicDao.optometryBasicInsert(optometryBasicPo);
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
		refractiveDao.insertRefractivePo(refractivePo);
	}
	
	public void updateRefractive(RefractivePo po,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo){
		refractiveDao.updateRefractive(po);
		optometryPo.setSopoyoptometryid(po.getSoproptometryid());
		refractiveDao.updateOptometry(optometryPo);
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		refractiveDao.updateOptometryBasic(optometryBasicPo);
		if(!Utility.getName(optometryBasicPo.getSopoboptometrybasicid()).equals("")){
			this.optometryBasicDao.updateOptoTime(optometryBasicPo.getSopoboptometrybasicid());
		}
	}
	
	public int getRefractiveCount(OptometryPo optometryPo){
		return refractiveDao.getRefractiveCount(optometryPo);
	}
	

	/**
	 * 显示屈光检查
	 * @param po
	 * @return
	 */
	public RefractivePo getRefractive(RefractivePo po) {
		return refractiveDao.getRefractive(po);
	}

}
