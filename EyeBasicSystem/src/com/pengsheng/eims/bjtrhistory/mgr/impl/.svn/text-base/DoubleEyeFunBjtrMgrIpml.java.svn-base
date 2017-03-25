package com.pengsheng.eims.bjtrhistory.mgr.impl;

import com.pengsheng.eims.bjtrhistory.dao.DoubleEyeFunBjtrDao;
import com.pengsheng.eims.bjtrhistory.dao.OptometryBasicBjtrDao;
import com.pengsheng.eims.bjtrhistory.mgr.DoubleEyeFunBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;
import com.pengsheng.eims.util.tools.Utility;

public class DoubleEyeFunBjtrMgrIpml implements DoubleEyeFunBjtrMgr { 

	private DoubleEyeFunBjtrDao doubleEyeFunBjtrDao;
	private OptometryBasicBjtrDao optometryBasicBjtrDao;

	public DoubleEyeFunBjtrDao getDoubleEyeFunBjtrDao() {
		return doubleEyeFunBjtrDao;
	}
	public void setDoubleEyeFunBjtrDao(DoubleEyeFunBjtrDao doubleEyeFunBjtrDao) {
		this.doubleEyeFunBjtrDao = doubleEyeFunBjtrDao;
	}
	public OptometryBasicBjtrDao getOptometryBasicBjtrDao() {
		return optometryBasicBjtrDao;
	}
	public void setOptometryBasicBjtrDao(OptometryBasicBjtrDao optometryBasicBjtrDao) {
		this.optometryBasicBjtrDao = optometryBasicBjtrDao;
	}
	
	/**
	 * 显示双眼视功能检查
	 * @param po
	 * @return
	 */
	public DoubleEyeFunPo getDoubleEyeFun(DoubleEyeFunPo po) {
		return doubleEyeFunBjtrDao.getDoubleEyeFun(po);
	}
	/**
	 * 新增双眼视功能检查
	 * @param po
	 */
	public void insertDoubleEyeFun(DoubleEyeFunPo po) {
		doubleEyeFunBjtrDao.insertDoubleEyeFun(po);
	}

	/**
	 * 修改双眼视功能检查
	 * @param po
	 */
	public void updateDoubleEyeFun(DoubleEyeFunPo po,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		doubleEyeFunBjtrDao.updateDoubleEyeFun(po);
		optometryPo.setSopoyoptometryid(po.getSopdeoptometryid());
		doubleEyeFunBjtrDao.updateOptometry(optometryPo);
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		doubleEyeFunBjtrDao.updateOptometryBasic(optometryBasicPo);
		if(!Utility.getName(optometryBasicPo.getSopoboptometrybasicid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime(optometryBasicPo.getSopoboptometrybasicid());
		}
	}
	/**
	 * 更新验光表
	 * @param optometryPo
	 */
	public void updateOptometry(OptometryPo po) {

		doubleEyeFunBjtrDao.updateOptometry(po);
		if(!Utility.getName(po.getSopoyoptometryid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime1(po.getSopoyoptometryid());
		}
	}
	/**
	 * 更新验光基表
	 * @param optometryBasicPo
	 */
	public void updateOptometryBasic(OptometryBasicPo po) {

		doubleEyeFunBjtrDao.updateOptometryBasic(po);
		if(!Utility.getName(po.getSopoboptometrybasicid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime(po.getSopoboptometrybasicid());
		}
	}
	
	public int getDoubleEyeFunCount(OptometryPo optometryPo) {
		return this.doubleEyeFunBjtrDao.getDoubleEyeFunCount(optometryPo);		
	}

	public void insertDoubleEyeFun(DoubleEyeFunPo po, OptometryPo optometryPo,
			OptometryBasicPo optometryBasicPo) {
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
		
		this.doubleEyeFunBjtrDao.insertDoubleEyeFun(po);
	}
}
