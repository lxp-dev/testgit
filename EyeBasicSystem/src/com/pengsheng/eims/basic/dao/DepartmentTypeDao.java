package com.pengsheng.eims.basic.dao;

import java.util.List;
import com.pengsheng.eims.basic.persistence.DepartmentTypePo;

/**
 * 部门类型Mgr
 * @author moyongsheng 2014 11 14
 *
 */
public interface DepartmentTypeDao {
	
	/**
	 * 查询所有部门类型List<DepartmentTypePo>；
	 */
	public List<DepartmentTypePo> getAllDepartmentTypes();	
	
}
