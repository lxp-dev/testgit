package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.sales.dao.OptometryBasicDao;
import com.pengsheng.eims.sales.dao.OptometryInformationDao;
import com.pengsheng.eims.sales.mgr.OptometryInformationMgr;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;

public class OptometryInformationMgrImpl implements OptometryInformationMgr {
	
//	private OptometryBasicDao optometryBasicDao;
	private OptometryInformationDao optometryInformationDao;


	public OptometryInformationDao getOptometryInformationDao() {
		return optometryInformationDao;
	}

	public void setOptometryInformationDao(
			OptometryInformationDao optometryInformationDao) {
		this.optometryInformationDao = optometryInformationDao;
	}

//	public OptometryBasicDao getOptometryBasicDao() {
//		return optometryBasicDao;
//	}
//
//	public void setOptometryBasicDao(OptometryBasicDao optometryBasicDao) {
//		this.optometryBasicDao = optometryBasicDao;
//	}

	/**
	 * 得到顾客所有验光基表明细
	 */
	public int getcustomerOptometryBasicCount(String customerID) {
		
		return optometryInformationDao.getcustomerOptometryBasicCount(customerID);
	}

	/**
	 * 得到顾客验光基表
	 */
	public List<OptometryBasicPo> getcustomerOptometryBasics(String customerID,
			int start, int size) {
		
		return optometryInformationDao.getcustomerOptometryBasics(customerID, start,
				size);
	}

	/**
	 * 得到所有顾客验光病历,验光基表对应的
	 */
	public List<OptometryPo> getcustomerOptometrys(String basicID) {

		return optometryInformationDao.getcustomerOptometrys(basicID);
	}

}
