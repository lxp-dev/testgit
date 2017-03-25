package com.pengsheng.eims.hydsycasehistory.mgr.impl;

import com.pengsheng.eims.hydsycasehistory.dao.DoubleEyeFunHydsyDao;
import com.pengsheng.eims.hydsycasehistory.dao.OptometryBasicHydsyDao;
import com.pengsheng.eims.hydsycasehistory.mgr.DoubleEyeFunHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.util.tools.Utility;

public class DoubleEyeFunHydsyMgrIpml implements DoubleEyeFunHydsyMgr { 

	private DoubleEyeFunHydsyDao doubleEyeFunHydsyDao;
	private OptometryBasicHydsyDao optometryBasicHydsyDao;
	
	public DoubleEyeFunHydsyDao getDoubleEyeFunHydsyDao() {
		return doubleEyeFunHydsyDao;
	}
	public void setDoubleEyeFunHydsyDao(DoubleEyeFunHydsyDao doubleEyeFunHydsyDao) {
		this.doubleEyeFunHydsyDao = doubleEyeFunHydsyDao;
	}
	public OptometryBasicHydsyDao getOptometryBasicHydsyDao() {
		return optometryBasicHydsyDao;
	}
	public void setOptometryBasicHydsyDao(OptometryBasicHydsyDao optometryBasicHydsyDao) {
		this.optometryBasicHydsyDao = optometryBasicHydsyDao;
	}
	/**
	 * 显示双眼视功能检查
	 * @param po
	 * @return
	 */
	public DoubleEyeFunPo getDoubleEyeFun(DoubleEyeFunPo po) {
		return doubleEyeFunHydsyDao.getDoubleEyeFun(po);
	}
	/**
	 * 新增双眼视功能检查
	 * @param po
	 */
	public void insertDoubleEyeFun(DoubleEyeFunPo po) {
		doubleEyeFunHydsyDao.insertDoubleEyeFun(po);
	}

	/**
	 * 修改双眼视功能检查
	 * @param po
	 */
	public void updateDoubleEyeFun(DoubleEyeFunPo po,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		doubleEyeFunHydsyDao.updateDoubleEyeFun(po);
		optometryPo.setSopoyoptometryid(po.getSopdeoptometryid());
		doubleEyeFunHydsyDao.updateOptometry(optometryPo);
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		doubleEyeFunHydsyDao.updateOptometryBasic(optometryBasicPo);
		if(!Utility.getName(optometryBasicPo.getSopoboptometrybasicid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime(optometryBasicPo.getSopoboptometrybasicid());
		}
	}
	/**
	 * 更新验光表
	 * @param optometryPo
	 */
	public void updateOptometry(OptometryPo po) {

		doubleEyeFunHydsyDao.updateOptometry(po);
		if(!Utility.getName(po.getSopoyoptometryid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime1(po.getSopoyoptometryid());
		}
	}
	/**
	 * 更新验光基表
	 * @param optometryBasicPo
	 */
	public void updateOptometryBasic(OptometryBasicPo po) {

		doubleEyeFunHydsyDao.updateOptometryBasic(po);
		if(!Utility.getName(po.getSopoboptometrybasicid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime(po.getSopoboptometrybasicid());
		}
	}
	
	public int getDoubleEyeFunCount(OptometryPo optometryPo) {
		return this.doubleEyeFunHydsyDao.getDoubleEyeFunCount(optometryPo);		
	}

	public void insertDoubleEyeFun(DoubleEyeFunPo po, OptometryPo optometryPo,
			OptometryBasicPo optometryBasicPo) {
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
		    this.doubleEyeFunHydsyDao.insertDoubleEyeFun(po);
	}
}
