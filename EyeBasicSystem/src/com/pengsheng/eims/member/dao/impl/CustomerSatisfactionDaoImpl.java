package com.pengsheng.eims.member.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.dao.CustomerSatisfactionDao;
import com.pengsheng.eims.member.persistence.CustomerSatisfactionPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CustomerSatisfactionDaoImpl extends BaseJdbcDaoSupport implements
		CustomerSatisfactionDao {

	public CustomerSatisfactionPo getCustomerSatisfaction(
			CustomerSatisfactionPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1 ");
		buffer.append("F_CS_ID as fcsid,");
		buffer.append("F_CS_Name as fcsname");
		buffer.append(" FROM F_CustomerSatisfaction ");
		buffer.append(" WHERE ");
		buffer.append("F_CS_ID = '" + po.getFcsid() + "'");
		
		return (CustomerSatisfactionPo) queryForObject(buffer.toString(), null,
				CustomerSatisfactionPo.class);
	}

	public List<CustomerSatisfactionPo> getCustomerSatisfactionList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT ");
		buffer.append("F_CS_ID as fcsid,");
		buffer.append("F_CS_Name as fcsname");
		buffer.append(" FROM F_CustomerSatisfaction ");

		return queryForObjectList(buffer.toString(), null,
				CustomerSatisfactionPo.class);
	}
	public int getCustomerSatisfactionsCount() 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(F_CS_ID)");
		buffer.append("   from F_CustomerSatisfaction");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}


	public List<CustomerSatisfactionPo> getCustomerSatisfactionsList(int start, int size) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by F_CS_ID) as rowNum, F_CS_ID as fcsid,F_CS_Name as fcsname FROM F_CustomerSatisfaction  ");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				CustomerSatisfactionPo.class);
	}
	
	
	
	public void insertCustomerSatisfaction(CustomerSatisfactionPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("INSERT INTO F_CustomerSatisfaction ");
		buffer.append("(");
		buffer.append("F_CS_ID ");
		buffer.append(",F_CS_Name) ");
		buffer.append("VALUES (");
		buffer.append(" ?,");
		buffer.append("? ");
		buffer.append(")");

		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getFcsname()));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void deleteCustomerSatisfaction(CustomerSatisfactionPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM F_CustomerSatisfaction");
		buffer.append(" WHERE ");
		buffer.append("F_CS_ID = '" + po.getFcsid() + "'");

		getJdbcTemplate().update(buffer.toString());
	}
	
	public int getCustomerSatisfactionPoName(CustomerSatisfactionPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(F_CS_ID)");
		buffer.append("   from F_CustomerSatisfaction where F_CS_Name = ? ");

		params.add(Utility.getName(po.getFcsname()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int getCustomerSatisfactionPoNameUpdate(CustomerSatisfactionPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(F_CS_ID)");
		buffer.append("   from F_CustomerSatisfaction where F_CS_Name = ? and F_CS_ID <> ? ");
		params.add(Utility.getName(po.getFcsname()));
		params.add(Utility.getName(po.getFcsid()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
}
