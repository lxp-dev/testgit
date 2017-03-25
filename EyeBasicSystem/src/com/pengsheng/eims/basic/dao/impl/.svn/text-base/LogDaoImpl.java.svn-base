package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.LogDao;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.LogPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.system.persistence.ModulePo;

public class LogDaoImpl extends BaseJdbcDaoSupport implements LogDao {
	/**
	 * 日志总页数查询
	 */
	public int getLogpageCount(LogPo logPo) {
		List<String> params = new ArrayList<String>();
		StringBuffer  varname1 = new StringBuffer();
		
		varname1.append("SELECT count(*) ");
		varname1.append("FROM   dbo.L_LogisticsLog ");
		varname1.append("       left JOIN L_LogOperationType ");
		varname1.append("         ON opid = logOpID ");
		varname1.append("       left JOIN dbo.SYS_Module ");
		varname1.append("         ON moduleId = logResult ");
		varname1.append("       left JOIN SYS_PersonInfo ");
		varname1.append("         ON logname = id ");
		varname1.append("WHERE  1=1 ");
		
		if (!"".equals(Utility.getName(logPo.getLogbegindate()))) {
			varname1.append(" and CONVERT(VARCHAR(10), logDate, 23) >= ? "); 
			params.add(logPo.getLogbegindate());
		}
		
		if (!"".equals(Utility.getName(logPo.getLogenddate()))) {
			varname1.append("       AND CONVERT(VARCHAR(10), logDate, 23) <= ? "); 
			params.add(logPo.getLogenddate());
		}
		
		if (!"".equals(Utility.getName(logPo.getLogname()))) {
			varname1.append("       AND logName = ? "); 
			params.add(logPo.getLogname());
		}
		
		if (!"".equals(Utility.getName(logPo.getLogusername()))) {
			varname1.append("       AND personName like '%'+?+'%' "); 
			params.add(logPo.getLogusername());
		}
		
		if (!"".equals(Utility.getName(logPo.getLogcontent()))) {
			varname1.append("       AND logcontent LIKE '%'+?+'%' "); 
			params.add(logPo.getLogcontent());
		}

		if (!"".equals(Utility.getName(logPo.getLogresult()))) {
			varname1.append("       AND logResult = ? "); 
			params.add(logPo.getLogresult());
		}
		
		return getJdbcTemplate().queryForInt(varname1.toString(),
				params.toArray());
	}
	/**
	 * 日志详细查询
	 */
	public List<LogPo> getLogpageList(LogPo logPo, int start, int size) {
		List<String> params = new ArrayList<String>();
		StringBuffer  varname1 = new StringBuffer();
		int countPage = start + size;
		
		varname1.append(" set rowcount " + countPage + " \n");
		varname1.append(" select * from (select ROW_NUMBER() ");
		varname1.append("       Over(order by logDate desc) as 'rowNum', ");
		varname1.append("       logID       AS logid, ");
		varname1.append("       logDate     AS logdate, ");
		varname1.append("       logName     AS logname, ");
		varname1.append("       personName  AS logusername, ");
		varname1.append("       logIP       AS logip, ");
		varname1.append("       logOpID     AS logopid, ");
		varname1.append("       opname      AS logopidname, ");
		varname1.append("       logContent  AS logcontent, ");
		varname1.append("       logResult   AS logresult, ");
		varname1.append("       modulecname AS logresultname, ");
		varname1.append("       logBillList AS logBillList ");
		varname1.append("FROM   dbo.L_LogisticsLog ");
		varname1.append("       left JOIN L_LogOperationType ");
		varname1.append("         ON opid = logOpID ");
		varname1.append("       left JOIN dbo.SYS_Module ");
		varname1.append("         ON moduleId = logResult ");
		varname1.append("       left JOIN SYS_PersonInfo ");
		varname1.append("         ON logname = id ");
		varname1.append("WHERE  1=1 ");
		
		if (!"".equals(Utility.getName(logPo.getLogbegindate()))) {
			varname1.append(" and CONVERT(VARCHAR(10), logDate, 23) >= ? "); 
			params.add(logPo.getLogbegindate());
		}
		
		if (!"".equals(Utility.getName(logPo.getLogenddate()))) {
			varname1.append("       AND CONVERT(VARCHAR(10), logDate, 23) <= ? "); 
			params.add(logPo.getLogenddate());
		}
		
		if (!"".equals(Utility.getName(logPo.getLogname()))) {
			varname1.append("       AND logName = ? "); 
			params.add(logPo.getLogname());
		}
		
		if (!"".equals(Utility.getName(logPo.getLogusername()))) {
			varname1.append("       AND personName like '%'+?+'%' "); 
			params.add(logPo.getLogusername());
		}
		
		if (!"".equals(Utility.getName(logPo.getLogcontent()))) {
			varname1.append("       AND logcontent LIKE '%'+?+'%' "); 
			params.add(logPo.getLogcontent());
		}

		if (!"".equals(Utility.getName(logPo.getLogresult()))) {
			varname1.append("       AND logResult = ? "); 
			params.add(logPo.getLogresult());
		}
		
		varname1.append(") table1 where rowNum > ");
		varname1.append(start + " and rowNum <=" + countPage);
		varname1.append("set rowcount 0");
		
		return queryForObjectList(varname1.toString(), params.toArray(),
				LogPo.class);
	}

	/**
	 * Description :获取功能设置列表
	 * @return :功能设置的列表
	 */
	public List<ModulePo> getModuleList() {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("SELECT moduleID AS moduleid, moduleCname AS modulecname ");
		buffer.append("FROM SYS_Module ");
		buffer.append("WHERE moduleParentID != '0' AND moduleClose = '0'");
		buffer.append("ORDER BY moduleID ");

		return queryForObjectList(buffer.toString(), null, ModulePo.class);
	}

}
