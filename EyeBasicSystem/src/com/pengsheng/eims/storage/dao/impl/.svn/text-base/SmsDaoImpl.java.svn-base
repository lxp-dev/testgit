package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.SmsDao;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;


public class SmsDaoImpl extends BaseJdbcDaoSupport implements SmsDao{
	/*
	 * (non-Javadoc)获得消息提醒数量
	 * @see com.pengsheng.orders.ajax.dao.AjaxDao#getSmsCount(com.pengsheng.eims.system.persistence.PersonInfoPo)
	 */

	public int getSmsCount(PersonInfoPo personInfoPo,String flag) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select count(C_ST_SL_ID) from C_ST_SmsLerts ");
		sb.append("where C_ST_SL_ReceiveDepartment=? and C_ST_SL_ReceivePerson=? ");
		sb.append("and C_ST_SL_Flag=?");
		List<String> params = new ArrayList<String>();
		params.add(personInfoPo.getDepartmentID());
		params.add(personInfoPo.getId());
		params.add(flag);
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public int getOrdersSmsCount(PersonInfoPo personInfoPo,String flag) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select count(C_ST_SL_ID) from orders.orders.dbo.C_ST_SmsLerts ");
		sb.append("where C_ST_SL_ReceivePerson=? ");
		sb.append("and C_ST_SL_Flag=?");
		List<String> params = new ArrayList<String>();

		params.add(personInfoPo.getOrderid());
		params.add(flag);
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/*
	 * 获得消息提醒LIST.
	 */
	public List<SmsLertsPo> getSmsList(PersonInfoPo personInfoPo,int start, int size,String flag) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("select * from (select ROW_NUMBER() Over(order by C_ST_SL_Time desc) as rownumber,C_ST_SL_ID as cstslid,");
		sb.append("C_ST_SL_Title as cstsltitle,");
		sb.append("C_ST_SL_Content as cstslcontent,");
		sb.append("convert(varchar(16),C_ST_SL_Time,20) as cstsltime,");
		sb.append("C_ST_SL_SendDepartment as cstslsenddepartment,");
		sb.append("C_ST_SL_ReceiveDepartment as cstslreceivedepartment,");
		sb.append("C_ST_SL_SendPerson as cstslsendperson,");
		sb.append("personName as cstslsendpersonname,");
		sb.append("C_ST_SL_ReceivePerson as cstslreceiveperson,");
		sb.append("C_ST_SL_Flag as cstslflag  ");
		sb.append("from C_ST_SmsLerts inner join sys_personinfo on sys_personinfo.ID=C_ST_SmsLerts.C_ST_SL_SendPerson ");
		sb.append("where C_ST_SL_ReceiveDepartment=? and C_ST_SL_ReceivePerson=? ");
		sb.append("and C_ST_SL_Flag=?");
		sb.append(")temp ");
		sb.append(" where temp.rownumber > "+start+" and temp.rownumber <= "+countPage+" ");
		List<String> params = new ArrayList<String>();
		params.add(personInfoPo.getDepartmentID());
		params.add(personInfoPo.getId());
		params.add(flag);
		return queryForObjectList(sb.toString(), params.toArray(), SmsLertsPo.class);
	}
	
	public List<SmsLertsPo> getOrdersSmsList(PersonInfoPo personInfoPo,int start, int size,String flag) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("select * from (select ROW_NUMBER() Over(order by C_ST_SL_Time desc) as rownumber,C_ST_SL_ID as cstslid,");
		sb.append("C_ST_SL_Title as cstsltitle,");
		sb.append("C_ST_SL_Content as cstslcontent,");
		sb.append("convert(varchar(16),C_ST_SL_Time,20) as cstsltime,");
		sb.append("C_ST_SL_SendDepartment as cstslsenddepartment,");
		sb.append("C_ST_SL_ReceiveDepartment as cstslreceivedepartment,");
		sb.append("C_ST_SL_SendPerson as cstslsendperson,");
		sb.append("personName as cstslsendpersonname,");
		sb.append("C_ST_SL_ReceivePerson as cstslreceiveperson,");
		sb.append("C_ST_SL_Flag as cstslflag  ");
		sb.append("from orders.orders.dbo.C_ST_SmsLerts inner join orders.orders.dbo.sys_personinfo on sys_personinfo.ID=C_ST_SmsLerts.C_ST_SL_SendPerson ");
		sb.append("where  C_ST_SL_ReceivePerson=? ");
		sb.append("and C_ST_SL_Flag=?");
		sb.append(")temp ");
		sb.append(" where temp.rownumber > "+start+" and temp.rownumber <= "+countPage+" ");
		List<String> params = new ArrayList<String>();
		params.add(personInfoPo.getOrderid());
		params.add(flag);
		return queryForObjectList(sb.toString(), params.toArray(), SmsLertsPo.class);
	}
	
	/*
	 * 变更消息为已阅
	 */
	public void smsReaded(SmsLertsPo smsLertsPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("update C_ST_SmsLerts set  C_ST_SL_Flag=1");
		sb.append(" where C_ST_SL_ID=? ");
		List<String> params = new ArrayList<String>();
		params.add(smsLertsPo.getCstslid());
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void smsOrdersReaded(SmsLertsPo smsLertsPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("update orders.orders.dbo.C_ST_SmsLerts set  C_ST_SL_Flag=1");
		sb.append(" where C_ST_SL_ID=? ");
		List<String> params = new ArrayList<String>();
		params.add(smsLertsPo.getCstslid());
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/*
	 * 删除
	 */
	public void smsDelete(SmsLertsPo smsLertsPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("delete from C_ST_SmsLerts ");
		sb.append(" where cstslid=? ");
		List<String> params = new ArrayList<String>();
		params.add(smsLertsPo.getCstslid());
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	
}
