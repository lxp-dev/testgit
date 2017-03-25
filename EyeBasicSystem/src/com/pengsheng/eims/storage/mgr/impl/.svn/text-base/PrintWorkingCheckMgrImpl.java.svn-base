package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.PrintWorkingCheckDao;
import com.pengsheng.eims.storage.mgr.PrintWorkingCheckMgr;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;

public class PrintWorkingCheckMgrImpl implements PrintWorkingCheckMgr {

	private PrintWorkingCheckDao printWorkingCheckDao;
	
	public PrintWorkingCheckDao getPrintWorkingCheckDao() {
		return printWorkingCheckDao;
	}

	public void setPrintWorkingCheckDao(PrintWorkingCheckDao printWorkingCheckDao) {
		this.printWorkingCheckDao = printWorkingCheckDao;
	}

	/**
	 * 得到打印检验单信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getPrintWorkingCheckCount(SalesBasicPo salesBasicPo,
			WorkingCheckPo workingCheckPo) {
		// TODO Auto-generated method stub
		return printWorkingCheckDao.getPrintWorkingCheckCount(salesBasicPo, workingCheckPo);
	}

	/**
	 * 查询打印检验单信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WorkingCheckPo> selectPrintWorkingCheck(
			SalesBasicPo salesBasicPo, WorkingCheckPo workingCheckPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return printWorkingCheckDao.selectPrintWorkingCheck(salesBasicPo, workingCheckPo, start, size);
	}

	/**
	 * 得到部门列表
	 * @param departmentsPo
	 * @return
	 */
	public List<DepartmentsPo> getdepartment(DepartmentsPo departmentsPo) {
		// TODO Auto-generated method stub
		return printWorkingCheckDao.getdepartment(departmentsPo);
	}
	
	public int getSampledCheckCount(SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo){
		return printWorkingCheckDao.getSampledCheckCount(salesBasicPo, workingCheckPo);
	}
	
	public List<WorkingCheckPo> selectSampledCheck(SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo, int start, int size){
		return printWorkingCheckDao.selectSampledCheck(salesBasicPo, workingCheckPo, start, size);
	}
	
	/**
	 * 得到抽检记录
	 * @param salesid
	 * @return WorkingCheckPo
	 */
	public WorkingCheckPo getSampledCheckPo(String salesid){
		return printWorkingCheckDao.getSampledCheckPo(salesid);
	}
}
