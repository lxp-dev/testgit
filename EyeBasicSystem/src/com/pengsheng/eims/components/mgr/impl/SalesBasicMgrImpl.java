package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.components.dao.SalesBasicDao;
import com.pengsheng.eims.components.mgr.SalesBasicMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.dao.DepartmentsDao;

public class SalesBasicMgrImpl implements SalesBasicMgr {
	private SalesBasicDao salesBasicDao;
	
	public SalesBasicDao getSalesBasicDao() {
		return salesBasicDao;
	}
	public void setSalesBasicDao(SalesBasicDao salesBasicDao) {
		this.salesBasicDao = salesBasicDao;
	}
	/**
	 * 查询所有部门信息
	 */
	public List<DepartmentsPo> getDepartments() {
		
		return salesBasicDao.getDepartments();
	}
	/**
	 * 销售结帐基表信息数量
	 */
	public int getSalesBasicCount(SalesBasicPo po) {
		
		return salesBasicDao.getSalesBasicCount(po);
	}

	/**
	 * 销售结帐基表信息数量
	 */
	public List<SalesBasicPo> getSalesBasicList(SalesBasicPo po, int start,
			int size) {
		
		return salesBasicDao.getSalesBasicList(po, start, size);
	}
	
	/**
	 * 查询销售结帐基表信息
	 */
	public SalesBasicPo getSalesBasic(SalesBasicPo po) {
		
		return salesBasicDao.getSalesBasic(po);
	}
}
