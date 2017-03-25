/**
 * 
 */
package com.pengsheng.eims.components.mgr.impl;

import com.pengsheng.eims.components.dao.CustomerOptometryDao;
import com.pengsheng.eims.components.mgr.CustomerOptometryMgr;
import com.pengsheng.eims.sales.persistence.OptometryPo;

/**
 * @author Liuqian
 * 
 */
public class CustomerOptometryMgrImpl implements CustomerOptometryMgr {

	private CustomerOptometryDao customerOptometryDao;

	public CustomerOptometryDao getCustomerOptometryDao() {
		return customerOptometryDao;
	}

	public void setCustomerOptometryDao(
			CustomerOptometryDao customerOptometryDao) {
		this.customerOptometryDao = customerOptometryDao;
	}

	
	public OptometryPo getOptometryPo(String optometryID) {
		// TODO Auto-generated method stub
		return customerOptometryDao.getOptometryPo(optometryID);
	}

}
