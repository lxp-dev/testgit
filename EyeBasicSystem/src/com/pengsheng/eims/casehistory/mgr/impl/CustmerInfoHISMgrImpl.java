package com.pengsheng.eims.casehistory.mgr.impl;

import com.pengsheng.eims.casehistory.dao.CustmerInfoHISDao;
import com.pengsheng.eims.casehistory.mgr.CustmerInfoHISMgr;
import com.pengsheng.eims.casehistory.persistence.CustmerInfoHISPo;

public class CustmerInfoHISMgrImpl implements CustmerInfoHISMgr{

	private CustmerInfoHISDao custmerInfoHISDao;

	public int queryCustHIS(CustmerInfoHISPo po) {
		return custmerInfoHISDao.queryCustHIS(po);
	}

 
	public void updateCustHIS(CustmerInfoHISPo po) {
		custmerInfoHISDao.updateCustHIS(po);
		
	}
	
	public void insertCustHIS(CustmerInfoHISPo po) {
		 
		custmerInfoHISDao.insertCustHIS(po);
	}
	
	
	public CustmerInfoHISDao getCustmerInfoHISDao() {
		return custmerInfoHISDao;
	}
	public void setCustmerInfoHISDao(CustmerInfoHISDao custmerInfoHISDao) {
		this.custmerInfoHISDao = custmerInfoHISDao;
	}

 
	public int queryTodayIDHIS(CustmerInfoHISPo po) {
		return custmerInfoHISDao.queryTodayIDHIS(po);
	}


	



	

	
}
