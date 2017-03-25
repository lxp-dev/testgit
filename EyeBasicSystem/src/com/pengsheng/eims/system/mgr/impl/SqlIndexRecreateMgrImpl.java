package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.system.dao.SqlIndexRecreateDao;
import com.pengsheng.eims.system.mgr.SqlIndexRecreateMgr;
import com.pengsheng.eims.system.persistence.SqlIndexRecreatePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;


/**
 * 数据库索引优化Mgr
 * @author moyongsheng
 *
 */

public class SqlIndexRecreateMgrImpl extends BaseJdbcDaoSupport implements SqlIndexRecreateMgr {
	
	private SqlIndexRecreateDao sqlIndexRecreateDao;
	
	/**
	 * 检索数据库索引优化日志表
	 */
	public List<SqlIndexRecreatePo>  noSelectSqlIndexRecreateList(){
		return sqlIndexRecreateDao.selectSqlIndexRecreateList();
	}
	
	/**
	 * 新增数据库索引优化日志表
	 */
	public void  noSqlIndexCreate(){
		sqlIndexRecreateDao.sqlIndexCreate();
	}

	public SqlIndexRecreateDao getSqlIndexRecreateDao() {
		return sqlIndexRecreateDao;
	}

	public void setSqlIndexRecreateDao(SqlIndexRecreateDao sqlIndexRecreateDao) {
		this.sqlIndexRecreateDao = sqlIndexRecreateDao;
	}

}
