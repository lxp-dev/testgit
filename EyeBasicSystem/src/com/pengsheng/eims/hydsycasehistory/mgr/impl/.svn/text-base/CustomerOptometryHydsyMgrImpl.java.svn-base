/**
 * 
 */
package com.pengsheng.eims.hydsycasehistory.mgr.impl;

import com.pengsheng.eims.hydsycasehistory.dao.CustomerOptometryHydsyDao;
import com.pengsheng.eims.hydsycasehistory.mgr.CustomerOptometryHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;

/**
 * @author Liuqian
 * 
 */
public class CustomerOptometryHydsyMgrImpl implements CustomerOptometryHydsyMgr {

	private CustomerOptometryHydsyDao customerOptometryHydsyDao;

	public CustomerOptometryHydsyDao getCustomerOptometryHydsyDao() {
		return customerOptometryHydsyDao;
	}

	public void setCustomerOptometryHydsyDao(CustomerOptometryHydsyDao customerOptometryHydsyDao) {
		this.customerOptometryHydsyDao = customerOptometryHydsyDao;
	}


	public OptometryPo getOptometryPo(String optometryID) {
		return customerOptometryHydsyDao.getOptometryPo(optometryID);
	}

}
