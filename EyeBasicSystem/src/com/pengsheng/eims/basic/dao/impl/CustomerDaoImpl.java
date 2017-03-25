package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.CustomerDao;
import com.pengsheng.eims.basic.persistence.CustomerPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CustomerDaoImpl extends BaseJdbcDaoSupport implements
		CustomerDao {

	public void deleteCustomer(CustomerPo customerPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM B_Customer ");
		buffer.append("WHERE B_CT_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(customerPo.getBctid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public CustomerPo getCustomer(CustomerPo customerPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  B_CT_ID as bctid ");
		buffer.append(",B_CT_CustomerName  as bctcustomername ");
		buffer.append(",B_CT_ContactPerson as bctcontactperson ");
		buffer.append(",B_CT_ContactPhone as bctcontactphone ");
		buffer.append(",B_CT_Fax as bctfax ");
		buffer.append(",B_CT_Address as bctaddress ");
		buffer.append(",B_CT_Remark as bctremark ");
		buffer.append("FROM B_Customer ");
		buffer.append("WHERE 1 = 1");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(customerPo.getBctid()))) {
			buffer.append(" AND B_CT_ID = ?");
			params.add(customerPo.getBctid());
		}

		if (!"".equals(Utility.getName(customerPo.getBctcustomername()))) {
			buffer.append(" AND B_CT_CustomerName = ?");
			params.add(customerPo.getBctcustomername());
		}

		return (CustomerPo) queryForObject(buffer.toString(), params
				.toArray(), CustomerPo.class);
	}

	public int getCustomerPoName(CustomerPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_CT_ID)");
		buffer.append("   from B_Customer where B_CT_CustomerName = '"+Utility.getName(po.getBctcustomername())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public int getCustomerPoNameUpdate(CustomerPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_CT_ID)");
		buffer.append("   from B_Customer where B_CT_CustomerName = '"+Utility.getName(po.getBctcustomername())+"' and B_CT_ID <> '"+Utility.getName(po.getBctid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	public int getCustomerCount(CustomerPo customerPo) 
	{		
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT count(B_CT_ID) ");		
		buffer.append("FROM B_Customer ");
		buffer.append("WHERE 1 = 1");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(customerPo.getBctid()))) {
			buffer.append(" AND B_CT_ID = ?");
			params.add(customerPo.getBctid());
		}

		if (!"".equals(Utility.getName(customerPo.getBctcustomername()))) {
			buffer.append(" AND B_CT_CustomerName like '%' + ? + '%' ");
			params.add(customerPo.getBctcustomername());
		}
		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}


	public List getCustomerPoList(CustomerPo po, int start, int size) 
	{
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by B_CT_ID) as 'rowNum' ");
		buffer.append(", B_CT_ID as bctid ");
		buffer.append(",B_CT_CustomerName  as bctcustomername ");
		buffer.append(",B_CT_ContactPerson as bctcontactperson ");
		buffer.append(",B_CT_ContactPhone as bctcontactphone ");
		buffer.append(",B_CT_Fax as bctfax ");
		buffer.append(",B_CT_Address as bctaddress ");
		buffer.append(",B_CT_Remark as bctremark ");
		buffer.append("FROM B_Customer ");
		buffer.append("WHERE 1 = 1");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getBctid()))) {
			buffer.append(" AND B_CT_ID = ?");
			params.add(po.getBctid());
		}

		if (!"".equals(Utility.getName(po.getBctcustomername()))) {
			buffer.append(" AND B_CT_CustomerName like '%' + ? + '%' ");
			params.add(po.getBctcustomername());
		}

		
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), CustomerPo.class);
	}
	
	
	public List<CustomerPo> getCustomerList(CustomerPo customerPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_CT_ID as bctid ");
		buffer.append(",B_CT_CustomerName  as bctcustomername ");
		buffer.append(",B_CT_ContactPerson as bctcontactperson ");
		buffer.append(",B_CT_ContactPhone as bctcontactphone ");
		buffer.append(",B_CT_Fax as bctfax ");
		buffer.append(",B_CT_Address as bctaddress ");
		buffer.append(",B_CT_Remark as bctremark ");
		buffer.append("FROM B_Customer ");
		buffer.append("WHERE 1 = 1");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(customerPo.getBctid()))) {
			buffer.append(" AND B_CT_ID = ?");
			params.add(customerPo.getBctid());
		}

		if (!"".equals(Utility.getName(customerPo.getBctcustomername()))) {
			buffer.append(" AND B_CT_CustomerName like '%' + ? + '%' ");
			params.add(customerPo.getBctcustomername());
		}
		return queryForObjectList(buffer.toString(), params.toArray(), CustomerPo.class);
	}

	public void insertCustomer(CustomerPo customerPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO B_Customer ");
		buffer.append("(B_CT_ID");
		buffer.append(",B_CT_CustomerName");
		buffer.append(",B_CT_ContactPerson");
		buffer.append(",B_CT_ContactPhone");
		buffer.append(",B_CT_Fax");
		buffer.append(",B_CT_Address");
		buffer.append(",B_CT_Remark)");
		buffer.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

		List<String> params = new ArrayList<String>();
		params.add(customerPo.getBctid());
		params.add(customerPo.getBctcustomername());
		params.add(customerPo.getBctcontactperson());
		params.add(customerPo.getBctcontactphone());
		params.add(customerPo.getBctfax());
		params.add(customerPo.getBctaddress());
		params.add(customerPo.getBctremark());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateCustomer(CustomerPo customerPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE B_Customer ");
		buffer.append("SET B_CT_CustomerName = ? ");
		buffer.append(",B_CT_ContactPerson = ? ");
		buffer.append(",B_CT_ContactPhone = ? ");
		buffer.append(",B_CT_Fax = ? ");
		buffer.append(",B_CT_Address = ? ");
		buffer.append(",B_CT_Remark = ? ");
		buffer.append("WHERE B_CT_ID = ?");

		List<String> params = new ArrayList<String>();

		params.add(customerPo.getBctcustomername());
		params.add(customerPo.getBctcontactperson());
		params.add(customerPo.getBctcontactphone());
		params.add(customerPo.getBctfax());
		params.add(customerPo.getBctaddress());
		params.add(customerPo.getBctremark());
		params.add(customerPo.getBctid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}	
	public int getCustomerCountForDel(CustomerPo customerPo){
		StringBuffer sb =new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select count(*) from C_ST_Inventory where 1=1 ");
		if(customerPo.getBctid()!=null){
			sb.append("and C_ST_I_SupplierId=? and C_ST_I_BillID like 'SOUT%'");
			params.add(customerPo.getBctid());
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
}
