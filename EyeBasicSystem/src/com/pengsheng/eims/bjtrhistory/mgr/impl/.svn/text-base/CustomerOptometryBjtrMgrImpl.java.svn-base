package com.pengsheng.eims.bjtrhistory.mgr.impl;

import com.pengsheng.eims.bjtrhistory.dao.CustomerOptometryBjtrDao;
import com.pengsheng.eims.bjtrhistory.mgr.CustomerOptometryBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;

public class CustomerOptometryBjtrMgrImpl implements CustomerOptometryBjtrMgr {
	
	private CustomerOptometryBjtrDao customerOptometryBjtrDao;

	public CustomerOptometryBjtrDao getCustomerOptometryBjtrDao() {
		return customerOptometryBjtrDao;
	}
	public void setCustomerOptometryBjtrDao(
			CustomerOptometryBjtrDao customerOptometryBjtrDao) {
		this.customerOptometryBjtrDao = customerOptometryBjtrDao;
	}
	
	public OptometryPo getOptometryPo(String optometryID) {
		return customerOptometryBjtrDao.getOptometryPo(optometryID);
	}
}
