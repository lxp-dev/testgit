/**
 * 
 */
package com.pengsheng.eims.report.dao.impl;

import java.util.List;
import java.util.Map;

import com.pengsheng.eims.report.dao.QmshPersonWorkingGlassDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class QmshPersonWorkingGlassDaoImpl extends BaseJdbcDaoSupport implements QmshPersonWorkingGlassDao {

	/**
	 * 得到所有结果集
	 */
	public List<Map> getGlassworkData(String begDate,String endDate) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("exec SP_initQmshPersonWorkingGlass ?, ? ");

		return getJdbcTemplate().queryForList(buffer.toString(),new String[] { begDate, endDate });
	}

}
