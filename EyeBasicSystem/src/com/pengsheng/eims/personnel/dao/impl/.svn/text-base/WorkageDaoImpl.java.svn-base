package com.pengsheng.eims.personnel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.personnel.dao.WorkageDao;
import com.pengsheng.eims.personnel.persistence.EducationPo;
import com.pengsheng.eims.personnel.persistence.WorkagePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class WorkageDaoImpl extends BaseJdbcDaoSupport implements WorkageDao {

	public void deleteWorkage(WorkagePo workagePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM M_Workage ");
		buffer.append("WHERE M_WP_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(workagePo.getMwpid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public WorkagePo getWorkage(WorkagePo workagePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  M_WP_ID as mwpid ");
		buffer.append(",M_WP_Name  as mwpname ");
		buffer.append(",M_WP_Salary  as mwpsalary ");		
		buffer.append("FROM M_Workage ");
		buffer.append("WHERE 1 = 1");
		
		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(workagePo.getMwpid()))) {
			buffer.append(" AND M_WP_ID = ?");
			params.add(workagePo.getMwpid());
		}
		

		return (WorkagePo) queryForObject(buffer.toString(), params
				.toArray(), WorkagePo.class);
	}
	
	public List<WorkagePo> getWorkageList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT M_WP_ID as mwpid ");
		buffer.append(",M_WP_Name  as mwpname ");
		buffer.append(",M_WP_Salary  as mwpsalary ");		
		buffer.append("FROM M_Workage ");

		return queryForObjectList(buffer.toString(), null, WorkagePo.class);
	}
	
	public int getWorkageCount() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(M_WP_ID)");
		buffer.append("   from M_Workage");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	public List<WorkagePo> getWorkagesList(int start, int size) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by M_WP_ID) as rowNum, M_WP_ID as mwpid,M_WP_Name  as mwpname,M_WP_Salary  as mwpsalary from M_Workage ");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,WorkagePo.class);
	}

	public void insertWorkage(WorkagePo workagePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO M_Workage ");
		buffer.append("(M_WP_ID ");
		buffer.append(",M_WP_Name ");
		buffer.append(",M_WP_Salary) ");
		buffer.append("VALUES (?,?,?)");

		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(workagePo.getMwpname());
		params.add(workagePo.getMwpsalary());		

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateWorkage(WorkagePo workagePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE M_Workage ");
		buffer.append("SET M_WP_Name = ?,M_WP_Salary=? ");
		buffer.append("WHERE M_WP_ID = ?");

		List<String> params = new ArrayList<String>();

		params.add(workagePo.getMwpname());
		params.add(workagePo.getMwpsalary());
		params.add(workagePo.getMwpid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	

	public int getWorkageName(WorkagePo workagePo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(M_WP_ID)");
		buffer.append("   from M_Workage where M_WP_Name = ? ");
		params.add(Utility.getName(workagePo.getMwpname()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int getWorkageNameUpdate(WorkagePo workagePo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(M_WP_ID)");
		buffer.append("   from M_Workage where M_WP_Name = ? and M_WP_ID <> ? ");
		params.add(Utility.getName(workagePo.getMwpname()));
		params.add(Utility.getName(workagePo.getMwpid()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}	
}
