/**
 * 
 */
package com.pengsheng.eims.sms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sms.dao.SmsSyncDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

/**
 * @author Liuqian
 * 
 */
public class SmsSyncDaoImpl extends BaseJdbcDaoSupport implements SmsSyncDao {

	public List<SmsRecordPo> getSmsList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select ");
		buffer.append("F_SR_id as fsrid, ");
		buffer.append("F_SR_ReceiptPerson as fsrreceiptperson, ");
		buffer.append("F_SR_ReceiptTel as fsrreceipttel, ");
		buffer.append("F_SR_SendPerson as fsrsendperson, ");
		buffer.append("F_SR_SendContext as fsrsendcontext, ");
		buffer.append("F_SR_SendDate as fsrsenddate, ");
		buffer.append("F_SR_SendFlag as fsrsendflag ");
		buffer.append("from F_SmsRecord ");
		buffer.append("where F_SR_SendFlag = 0 ");

		return queryForObjectList(buffer.toString(), null, SmsRecordPo.class);
	}

	public void updateSmsFlag(String id) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update F_SmsRecord set ");
		buffer.append("F_SR_SendFlag = 1 where F_SR_id = ? ");

		List<String> params = new ArrayList<String>();
		params.add(id);

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}
}
