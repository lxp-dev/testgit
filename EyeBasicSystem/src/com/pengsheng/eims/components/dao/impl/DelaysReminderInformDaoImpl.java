package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class DelaysReminderInformDaoImpl extends BaseJdbcDaoSupport implements
		DelaysReminderInformDao {

	/**
	 * 新增短信记录表
	 */
	public CustomerInfoPo getCustomerInfo(String salesid) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_ME_CI_Phone,S_ME_CI_Name ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("inner join S_SE_SalesBasic on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SalesBasic.S_SE_SB_CustomerID");
		buffer.append("where S_SE_SB_SalesID = ? ");
		params.add(salesid);
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),
				CustomerInfoPo.class);
	}

	/**
	 * 查询顾客信息
	 */
	public void insertSmsRecord(SmsRecordPo smsRecordPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into F_SmsRecord ");
		buffer.append("(F_SR_id,F_SR_ReceiptPerson,F_SR_ReceiptTel, ");
		buffer.append("F_SR_SendPerson,F_SR_SendContext,F_SR_SendDate,F_SR_SendFlag )");
		buffer.append("values(? , ? , ? , ? , ? , ?, '0' ) ");
		
		params.add(this.uuid.generate());
		params.add(smsRecordPo.getFsrreceiptperson());
		params.add(smsRecordPo.getFsrreceipttel());
		params.add(smsRecordPo.getFsrsendperson());		
		params.add(smsRecordPo.getFsrsendcontext());
		params.add(smsRecordPo.getFsrsenddate());
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

}
