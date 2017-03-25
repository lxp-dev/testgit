package com.pengsheng.eims.casehistory.mgr.impl;

import com.pengsheng.eims.casehistory.dao.DoubleEyeFunNDao;
import com.pengsheng.eims.casehistory.dao.OptometryBasicNDao;
import com.pengsheng.eims.casehistory.mgr.DoubleEyeFunNMgr;
import com.pengsheng.eims.casehistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.casehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.util.tools.Utility;

public class DoubleEyeFunNMgrIpml implements DoubleEyeFunNMgr { 

	private DoubleEyeFunNDao doubleEyeFunNDao;
	private OptometryBasicNDao optometryBasicNDao;
	
	public DoubleEyeFunNDao getDoubleEyeFunNDao() {
		return doubleEyeFunNDao;
	}
	public void setDoubleEyeFunNDao(DoubleEyeFunNDao doubleEyeFunNDao) {
		this.doubleEyeFunNDao = doubleEyeFunNDao;
	}
	public OptometryBasicNDao getOptometryBasicNDao() {
		return optometryBasicNDao;
	}
	public void setOptometryBasicNDao(OptometryBasicNDao optometryBasicNDao) {
		this.optometryBasicNDao = optometryBasicNDao;
	}
	/**
	 * 显示双眼视功能检查
	 * @param po
	 * @return
	 */
	public DoubleEyeFunPo getDoubleEyeFun(DoubleEyeFunPo po) {
		return doubleEyeFunNDao.getDoubleEyeFun(po);
	}
	/**
	 * 新增双眼视功能检查
	 * @param po
	 */
	public void insertDoubleEyeFun(DoubleEyeFunPo po) {
		doubleEyeFunNDao.insertDoubleEyeFun(po);
	}

	/**
	 * 修改双眼视功能检查
	 * @param po
	 */
	public void updateDoubleEyeFun(DoubleEyeFunPo po,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		doubleEyeFunNDao.updateDoubleEyeFun(po);
		optometryPo.setSopoyoptometryid(po.getSopdeoptometryid());
		doubleEyeFunNDao.updateOptometry(optometryPo);
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		doubleEyeFunNDao.updateOptometryBasic(optometryBasicPo);
		if(!Utility.getName(optometryBasicPo.getSopoboptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(optometryBasicPo.getSopoboptometrybasicid());
		}
	}
	/**
	 * 更新验光表
	 * @param optometryPo
	 */
	public void updateOptometry(OptometryPo po) {

		doubleEyeFunNDao.updateOptometry(po);
		if(!Utility.getName(po.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(po.getSopoyoptometryid());
		}
	}
	/**
	 * 更新验光基表
	 * @param optometryBasicPo
	 */
	public void updateOptometryBasic(OptometryBasicPo po) {

		doubleEyeFunNDao.updateOptometryBasic(po);
		if(!Utility.getName(po.getSopoboptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(po.getSopoboptometrybasicid());
		}
	}
	
	public int getDoubleEyeFunCount(OptometryPo optometryPo) {
		return this.doubleEyeFunNDao.getDoubleEyeFunCount(optometryPo);		
	}

	public void insertDoubleEyeFun(DoubleEyeFunPo po, OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
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
		    this.doubleEyeFunNDao.insertDoubleEyeFun(po);
	}
}
