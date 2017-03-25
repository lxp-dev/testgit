package com.pengsheng.eims.system.dao.impl;

import java.util.List;

import com.pengsheng.eims.system.dao.SqlIndexRecreateDao;
import com.pengsheng.eims.system.persistence.SqlIndexRecreatePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class SqlIndexRecreateDaoImpl extends BaseJdbcDaoSupport implements SqlIndexRecreateDao {
	
	/**
	 * 得到数据库索引List
	 * 
	 * @param 
	 * @return List 
	 */
	public List<SqlIndexRecreatePo> selectSqlIndexRecreateList(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select ");
		buffer.append(" indexcontent as indexcontent");

		buffer.append(" from L_IndexLog ");

		return this.queryForObjectList(buffer.toString(), null,
				SqlIndexRecreatePo.class);
	}
	
	/**
	 * 新增数据库索引优化日志表;
	 */
	public void sqlIndexCreate(){
		StringBuffer  buffer = new StringBuffer();
		buffer.append("exec Sqlindexcreate");
			
		getJdbcTemplate().update(buffer.toString());
	}
	

}
