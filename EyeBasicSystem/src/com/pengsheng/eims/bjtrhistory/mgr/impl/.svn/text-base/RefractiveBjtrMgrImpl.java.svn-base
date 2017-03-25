package com.pengsheng.eims.bjtrhistory.mgr.impl;

import com.pengsheng.eims.bjtrhistory.dao.DoubleEyeFunBjtrDao;
import com.pengsheng.eims.bjtrhistory.dao.OptometryBasicBjtrDao;
import com.pengsheng.eims.bjtrhistory.dao.RefractiveBjtrDao;
import com.pengsheng.eims.bjtrhistory.mgr.RefractiveBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;
import com.pengsheng.eims.bjtrhistory.persistence.RefractivePo;
import com.pengsheng.eims.sales.dao.DoubleEyeFunDao;
import com.pengsheng.eims.util.tools.Utility;

public class RefractiveBjtrMgrImpl implements RefractiveBjtrMgr {
	private RefractiveBjtrDao refractiveBjtrDao;
	private OptometryBasicBjtrDao optometryBasicBjtrDao;
	private DoubleEyeFunBjtrDao doubleEyeFunBjtrDao;
	
	public DoubleEyeFunBjtrDao getDoubleEyeFunBjtrDao() {
		return doubleEyeFunBjtrDao;
	}

	public void setDoubleEyeFunBjtrDao(DoubleEyeFunBjtrDao doubleEyeFunBjtrDao) {
		this.doubleEyeFunBjtrDao = doubleEyeFunBjtrDao;
	}

	public RefractiveBjtrDao getRefractiveBjtrDao() {
		return refractiveBjtrDao;
	}

	public void setRefractiveBjtrDao(RefractiveBjtrDao refractiveBjtrDao) {
		this.refractiveBjtrDao = refractiveBjtrDao;
	}

	public OptometryBasicBjtrDao getOptometryBasicBjtrDao() {
		return optometryBasicBjtrDao;
	}

	public void setOptometryBasicBjtrDao(OptometryBasicBjtrDao optometryBasicBjtrDao) {
		this.optometryBasicBjtrDao = optometryBasicBjtrDao;
	}

	public void insertRefractivePo(RefractivePo refractivePo, OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,DoubleEyeFunPo doubleEyeFunPo){
		if(optometryBasicPo!=null){
			if(this.optometryBasicBjtrDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicBjtrDao.optometryBasicInsert(optometryBasicPo);
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
		
		refractiveBjtrDao.insertRefractivePo(refractivePo);
		
		// 一个顾客一天的验光次数只算一次，并且计算到第一次验光的验光师
		int refractivecount = refractiveBjtrDao.getRefractiveCount(refractivePo);
		if(refractivecount==0){
			refractiveBjtrDao.insertRefractiveTempPo(refractivePo);
		}
		
		doubleEyeFunBjtrDao.insertDoubleEyeFun(doubleEyeFunPo);
	}
	
	public void updateRefractive(RefractivePo po,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,DoubleEyeFunPo doubleEyeFunPo){
		refractiveBjtrDao.updateRefractive(po);
		
		// 一个顾客一天的验光次数只算一次，并且计算到第一次验光的验光师
		refractiveBjtrDao.updateRefractiveTemp(po);
		
		optometryPo.setSopoyoptometryid(po.getSoproptometryid());
		refractiveBjtrDao.updateOptometry(optometryPo);
		doubleEyeFunBjtrDao.updateDoubleEyeFunAtRefractive(doubleEyeFunPo);
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		refractiveBjtrDao.updateOptometryBasic(optometryBasicPo);
		if(!Utility.getName(optometryBasicPo.getSopoboptometrybasicid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime(optometryBasicPo.getSopoboptometrybasicid());
		}
	}
	
	public int getRefractiveCount(OptometryPo optometryPo){
		return refractiveBjtrDao.getRefractiveCount(optometryPo);
	}
	

	/**
	 * 显示屈光检查
	 * @param po
	 * @return
	 */
	public RefractivePo getRefractive(RefractivePo po) {
		return refractiveBjtrDao.getRefractive(po);
	}

}
