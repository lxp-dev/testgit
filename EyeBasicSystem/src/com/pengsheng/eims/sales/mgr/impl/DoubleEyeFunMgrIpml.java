package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.sales.dao.DoubleEyeFunDao;
import com.pengsheng.eims.sales.dao.OptometryBasicDao;
import com.pengsheng.eims.sales.mgr.DoubleEyeFunMgr;
import com.pengsheng.eims.sales.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.util.tools.Utility;

public class DoubleEyeFunMgrIpml implements DoubleEyeFunMgr { 

	private DoubleEyeFunDao doubleEyeFunDao;
	public DoubleEyeFunDao getDoubleEyeFunDao() {
		return doubleEyeFunDao;
	}
	public void setDoubleEyeFunDao(DoubleEyeFunDao doubleEyeFunDao) {
		this.doubleEyeFunDao = doubleEyeFunDao;
	}
	private OptometryBasicDao optometryBasicDao;
	public OptometryBasicDao getOptometryBasicDao() {
		return optometryBasicDao;
	}
	public void setOptometryBasicDao(OptometryBasicDao optometryBasicDao) {
		this.optometryBasicDao = optometryBasicDao;
	}
	/**
	 * 显示双眼视功能检查
	 * @param po
	 * @return
	 */
	public DoubleEyeFunPo getDoubleEyeFun(DoubleEyeFunPo po) {
		return doubleEyeFunDao.getDoubleEyeFun(po);
	}
	/**
	 * 新增双眼视功能检查
	 * @param po
	 */
	public void insertDoubleEyeFun(DoubleEyeFunPo po) {
		doubleEyeFunDao.insertDoubleEyeFun(po);
	}

	/**
	 * 修改双眼视功能检查
	 * @param po
	 */
	public void updateDoubleEyeFun(DoubleEyeFunPo po,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		doubleEyeFunDao.updateDoubleEyeFun(po);
		optometryPo.setSopoyoptometryid(po.getSopdeoptometryid());
		doubleEyeFunDao.updateOptometry(optometryPo);
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		doubleEyeFunDao.updateOptometryBasic(optometryBasicPo);
		if(!Utility.getName(optometryBasicPo.getSopoboptometrybasicid()).equals("")){
			this.optometryBasicDao.updateOptoTime(optometryBasicPo.getSopoboptometrybasicid());
		}
	}
	/**
	 * 更新验光表
	 * @param optometryPo
	 */
	public void updateOptometry(OptometryPo po) {

		doubleEyeFunDao.updateOptometry(po);
		if(!Utility.getName(po.getSopoyoptometryid()).equals("")){
			this.optometryBasicDao.updateOptoTime1(po.getSopoyoptometryid());
		}
	}
	/**
	 * 更新验光基表
	 * @param optometryBasicPo
	 */
	public void updateOptometryBasic(OptometryBasicPo po) {

		doubleEyeFunDao.updateOptometryBasic(po);
		if(!Utility.getName(po.getSopoboptometrybasicid()).equals("")){
			this.optometryBasicDao.updateOptoTime(po.getSopoboptometrybasicid());
		}
	}
	
	public int getDoubleEyeFunCount(OptometryPo optometryPo) {
		// TODO Auto-generated method stub
		return this.doubleEyeFunDao.getDoubleEyeFunCount(optometryPo);
	}

	public void insertDoubleEyeFun(DoubleEyeFunPo po, OptometryPo optometryPo,
			OptometryBasicPo optometryBasicPo) {
		// TODO Auto-generated method stub
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
		    this.doubleEyeFunDao.insertDoubleEyeFun(po);
	}
}
