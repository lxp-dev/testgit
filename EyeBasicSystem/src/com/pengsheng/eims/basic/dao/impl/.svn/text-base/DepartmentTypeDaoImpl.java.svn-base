package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.pengsheng.eims.basic.dao.DepartmentTypeDao;
import com.pengsheng.eims.basic.persistence.DepartmentTypePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;


/**
 * 部门类型DaoImpl
 * @author moyongsheng 2014 11 14
 *
 */
public class DepartmentTypeDaoImpl extends BaseJdbcDaoSupport implements DepartmentTypeDao {
	
	/**
	 * 查询所有部门类型List<DepartmentTypePo>；
	 */
	public List<DepartmentTypePo> getAllDepartmentTypes(){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
				
		buffer.append("SELECT B_DT_ID               AS bdtid, ");
		buffer.append("       B_DT_Name             AS bdtname ");

		buffer.append("FROM   B_DepartmentType ");

		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentTypePo.class);
	}
}
