package com.pengsheng.eims.personnel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.personnel.dao.EducationDao;
import com.pengsheng.eims.personnel.persistence.EducationPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class EducationDaoImpl extends BaseJdbcDaoSupport implements EducationDao {

	public void deleteEducation(EducationPo educationPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM M_Education ");
		buffer.append("WHERE M_ET_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(educationPo.getMetid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public EducationPo getEducation(EducationPo educationPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  M_ET_ID as metid ");
		buffer.append(",M_ET_Name  as metname ");
		buffer.append(",M_ET_Salary  as metsalary ");		
		buffer.append("FROM M_Education ");
		buffer.append("WHERE 1 = 1");
		
		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(educationPo.getMetid()))) {
			buffer.append(" AND M_ET_ID = ?");
			params.add(educationPo.getMetid());
		}
		

		return (EducationPo) queryForObject(buffer.toString(), params
				.toArray(), EducationPo.class);
	}

	public int getEducationName(EducationPo educationPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(M_ET_ID)");
		buffer.append("   from M_Education where M_ET_Name = ? ");
		params.add(Utility.getName(educationPo.getMetname()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int getEducationNameUpdate(EducationPo educationPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(M_ET_ID)");
		buffer.append("   from M_Education where M_ET_Name = ? and M_ET_ID <> ? ");
		params.add(Utility.getName(educationPo.getMetname()));
		params.add(Utility.getName(educationPo.getMetid()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public List<EducationPo> getEducationList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT M_ET_ID as metid ");
		buffer.append(",M_ET_Name  as metname ");
		buffer.append(",M_ET_Salary  as metsalary ");		
		buffer.append("FROM M_Education ");

		return queryForObjectList(buffer.toString(), null, EducationPo.class);
	}
	
	public int getEducationCount() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(M_ET_ID)");
		buffer.append("   from M_Education");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	public List<EducationPo> getEducationsList(int start, int size) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by M_ET_ID) as rowNum, M_ET_ID as metid,M_ET_Name  as metname,M_ET_Salary  as metsalary from M_Education ");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,EducationPo.class);
	}

	public void insertEducation(EducationPo educationPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO M_Education ");
		buffer.append("(M_ET_ID ");
		buffer.append(",M_ET_Name ");
		buffer.append(",M_ET_Salary) ");
		buffer.append("VALUES (?,?,?)");

		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(educationPo.getMetname());
		params.add(educationPo.getMetsalary());		

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateEducation(EducationPo educationPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE M_Education ");
		buffer.append("SET M_ET_Name = ?,M_ET_Salary=? ");
		buffer.append("WHERE M_ET_ID = ?");

		List<String> params = new ArrayList<String>();

		params.add(educationPo.getMetname());
		params.add(educationPo.getMetsalary());
		params.add(educationPo.getMetid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 判断是否有人员使用该学历
	 * @return
	 */
	public int getBeUsed(EducationPo educationPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT count(ID) FROM SYS_PersonInfo ");
		buffer.append("WHERE maxSchoolLevel = ?");

		List<String> params = new ArrayList<String>();
		params.add(educationPo.getMetid());
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}	
}
