package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.MailingListDao;
import com.pengsheng.eims.basic.persistence.MailingListPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class MailingListDaoImpl  extends BaseJdbcDaoSupport implements MailingListDao {
	
	public int getMailingListCount(MailingListPo mailingListPo) {
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(B_TML_ID) ");
		buffer.append("from B_ToMailList ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}
	
	public List<MailingListPo> getMailingList(MailingListPo mailingListPo,
			int start, int size) {
		
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;

		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from ( ");
		buffer.append("select ROW_NUMBER() Over(order by B_TML_ID) as 'rowNum', ");
		buffer.append("B_TML_ID as btmlid, ");
		buffer.append("B_TML_Name as btmlname, ");
		buffer.append("B_TML_ReportName as btmlreportname, ");
		buffer.append("B_TML_Company as btmlcompany, ");
		buffer.append("B_TML_Address as btmladdress, ");
		buffer.append("B_TML_AreaCode as btmlareacode, ");
		buffer.append("B_TML_Phone as btmlphone, ");
		buffer.append("B_TML_Remark as btmlremark, ");
		buffer.append("B_TML_UseFlag as btmluseflag ");
		buffer.append("from B_ToMailList ");
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				MailingListPo.class);
	}
	
	public MailingListPo getMailingListPo(MailingListPo mailingListPo) {
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_TML_ID as btmlid, ");
		buffer.append("B_TML_Name as btmlname, ");
		buffer.append("B_TML_ReportName as btmlreportname, ");
		buffer.append("B_TML_Company as btmlcompany, ");
		buffer.append("B_TML_Address as btmladdress, ");
		buffer.append("B_TML_AreaCode as btmlareacode, ");
		buffer.append("B_TML_Phone as btmlphone, ");
		buffer.append("B_TML_Remark as btmlremark, ");
		buffer.append("B_TML_UseFlag as btmluseflag ");
		buffer.append("from B_ToMailList ");
		buffer.append("where B_TML_ID=? ");
		
		params.add(mailingListPo.getBtmlid());
		return (MailingListPo)queryForObject(buffer.toString(), params.toArray(),
				MailingListPo.class);
	}
	
	public void insertMailingListPo(MailingListPo mailingListPo) {
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into B_ToMailList ");
		buffer.append("(B_TML_ID, ");
		buffer.append("B_TML_Name, ");
		buffer.append("B_TML_ReportName, ");
		buffer.append("B_TML_Company, ");
		buffer.append("B_TML_Address, ");
		buffer.append("B_TML_AreaCode, ");
		buffer.append("B_TML_Phone, ");
		buffer.append("B_TML_Remark, ");
		buffer.append("B_TML_UseFlag) ");
		buffer.append("values(?,?,?,?,?,?,?,?,?) ");
		
		params.add(uuid.getInstance().generate());
		params.add(mailingListPo.getBtmlname());
		params.add(mailingListPo.getBtmlreportname());
		params.add(mailingListPo.getBtmlcompany());
		params.add(mailingListPo.getBtmladdress());
		params.add(mailingListPo.getBtmlareacode());
		params.add(mailingListPo.getBtmlphone());
		params.add(mailingListPo.getBtmlremark());
		params.add(mailingListPo.getBtmluseflag());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
	public void updateMailingListPo(MailingListPo mailingListPo) {
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_ToMailList ");
		buffer.append("set B_TML_Name=?, ");
		buffer.append("B_TML_ReportName=?, ");
		buffer.append("B_TML_Company=?, ");
		buffer.append("B_TML_Address=?, ");
		buffer.append("B_TML_AreaCode=?, ");
		buffer.append("B_TML_Phone=?, ");
		buffer.append("B_TML_Remark=?, ");
		buffer.append("B_TML_UseFlag=? ");
		buffer.append("where B_TML_ID=? ");
		
		params.add(mailingListPo.getBtmlname());
		params.add(mailingListPo.getBtmlreportname());
		params.add(mailingListPo.getBtmlcompany());
		params.add(mailingListPo.getBtmladdress());
		params.add(mailingListPo.getBtmlareacode());
		params.add(mailingListPo.getBtmlphone());
		params.add(mailingListPo.getBtmlremark());
		params.add(mailingListPo.getBtmluseflag());
		params.add(mailingListPo.getBtmlid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
	public void deleteMailingListPo(MailingListPo mailingListPo) {
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from B_ToMailList ");
		buffer.append("where B_TML_ID=? "); 

		List<String> params = new ArrayList<String>();

		params.add(mailingListPo.getBtmlid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	public void updateMailingListUseFlag(MailingListPo mailingListPo) {
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_ToMailList set B_TML_UseFlag='0' ");
		buffer.append("where B_TML_ID not in(?) ");

		params.add(mailingListPo.getBtmlid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
	public List<MailingListPo> getMailingList() {
		
		StringBuffer buffer = new StringBuffer();
		
		List<String> params = new ArrayList<String>();

		buffer.append("select ");
		buffer.append("B_TML_ID as btmlid, ");
		buffer.append("B_TML_Name as btmlname, ");
		buffer.append("B_TML_ReportName as btmlreportname, ");
		buffer.append("B_TML_Company as btmlcompany, ");
		buffer.append("B_TML_Address as btmladdress, ");
		buffer.append("B_TML_AreaCode as btmlareacode, ");
		buffer.append("B_TML_Phone as btmlphone, ");
		buffer.append("B_TML_Remark as btmlremark, ");
		buffer.append("B_TML_UseFlag as btmluseflag ");
		buffer.append("from B_ToMailList ");

		return queryForObjectList(buffer.toString(), params.toArray(),
				MailingListPo.class);
	}
	
	public MailingListPo getMailingListPo() {
		
		StringBuffer buffer = new StringBuffer();
		
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 ");
		buffer.append("B_TML_ID as btmlid, ");
		buffer.append("B_TML_Name as btmlname, ");
		buffer.append("B_TML_ReportName as btmlreportname, ");
		buffer.append("B_TML_Company as btmlcompany, ");
		buffer.append("B_TML_Address as btmladdress, ");
		buffer.append("B_TML_AreaCode as btmlareacode, ");
		buffer.append("B_TML_Phone as btmlphone, ");
		buffer.append("B_TML_Remark as btmlremark, ");
		buffer.append("B_TML_UseFlag as btmluseflag ");
		buffer.append("from B_ToMailList ");
		buffer.append("where B_TML_UseFlag='1' ");

		return (MailingListPo)queryForObject(buffer.toString(), params.toArray(),
				MailingListPo.class);
	}
	
}
