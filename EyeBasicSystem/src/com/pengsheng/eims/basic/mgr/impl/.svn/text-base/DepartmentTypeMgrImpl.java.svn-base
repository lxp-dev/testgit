package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;
import com.pengsheng.eims.basic.dao.DepartmentTypeDao;
import com.pengsheng.eims.basic.mgr.DepartmentTypeMgr;
import com.pengsheng.eims.basic.persistence.DepartmentTypePo;

/**
 * 部门类型MgrImpl
 * @author moyongsheng 2014 11 14
 *
 */
public class DepartmentTypeMgrImpl implements DepartmentTypeMgr{
	
	private DepartmentTypeDao departmentTypeDao;
	
	/**
	 * 查询所有部门类型List<DepartmentTypePo>；
	 */
	public List<DepartmentTypePo> getAllDepartmentTypes(){
		return departmentTypeDao.getAllDepartmentTypes();
	}

	public DepartmentTypeDao getDepartmentTypeDao() {
		return departmentTypeDao;
	}

	public void setDepartmentTypeDao(DepartmentTypeDao departmentTypeDao) {
		this.departmentTypeDao = departmentTypeDao;
	}

}
