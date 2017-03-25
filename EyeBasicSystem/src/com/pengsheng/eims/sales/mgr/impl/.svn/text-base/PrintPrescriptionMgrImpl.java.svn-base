package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.sales.dao.PrintPrescriptionDao;
import com.pengsheng.eims.sales.mgr.PrintPrescriptionMgr;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;


public class PrintPrescriptionMgrImpl implements PrintPrescriptionMgr {

	private PrintPrescriptionDao printPrescriptionDao;
	
	public PrintPrescriptionDao getPrintPrescriptionDao() {
		return printPrescriptionDao;
	}

	public void setPrintPrescriptionDao(PrintPrescriptionDao printPrescriptionDao) {
		this.printPrescriptionDao = printPrescriptionDao;
	}

	/**
	 * 查看打印处方信息
	 */
	public List<InspectionPo> getInspectionPos(String customerID) {
		return printPrescriptionDao.getInspectionPos(customerID);
	}

	
}
