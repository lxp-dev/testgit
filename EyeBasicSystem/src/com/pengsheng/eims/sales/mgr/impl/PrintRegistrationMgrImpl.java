package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.sales.dao.PrintRegistrationDao;
import com.pengsheng.eims.sales.mgr.PrintRegistrationMgr;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;

public class PrintRegistrationMgrImpl implements PrintRegistrationMgr {
	private PrintRegistrationDao printRegistrationDao;

	public PrintRegistrationDao getPrintRegistrationDao() {
		return printRegistrationDao;
	}

	public void setPrintRegistrationDao(PrintRegistrationDao printRegistrationDao) {
		this.printRegistrationDao = printRegistrationDao;
	}

	/**
	 * 打印挂号单
	 */
	public List<RegisteredDetailsPo> getRegisteredDetailsPos(RegisteredDetailsPo registered) {
		
		return printRegistrationDao.getRegisteredDetailsPos(registered);
	}

	
}
