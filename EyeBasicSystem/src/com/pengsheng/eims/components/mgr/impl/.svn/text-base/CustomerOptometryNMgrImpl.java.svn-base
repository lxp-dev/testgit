/**
 * 
 */
package com.pengsheng.eims.components.mgr.impl;

import com.pengsheng.eims.components.dao.CustomerOptometryNDao;
import com.pengsheng.eims.components.mgr.CustomerOptometryNMgr;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;

/**
 * @author Liuqian
 * 
 */
public class CustomerOptometryNMgrImpl implements CustomerOptometryNMgr {

	private CustomerOptometryNDao customerOptometryNDao;

	public CustomerOptometryNDao getCustomerOptometryNDao() {
		return customerOptometryNDao;
	}

	public void setCustomerOptometryNDao(CustomerOptometryNDao customerOptometryNDao) {
		this.customerOptometryNDao = customerOptometryNDao;
	}


	public OptometryPo getOptometryPo(String optometryID) {
		return customerOptometryNDao.getOptometryPo(optometryID);
	}

}
