package com.pengsheng.eims.quartz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.quartz.dao.SmsSetBirthdayDao;
import com.pengsheng.eims.system.persistence.CompanyNamePo;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class SmsSetBirthdayDaoImpl extends BaseJdbcDaoSupport implements
		SmsSetBirthdayDao {

	


	/**
	 * 查询顾客信息
	 */

	public List<CustomerInfoPo> getCustomerInfo() {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select S_ME_CI_memberID as smecimemberid,S_ME_CI_CustomerID as smecicustomerid,");
		buffer.append("S_ME_CI_Phone as smeciphone,S_ME_CI_Name as smeciname, ");
		buffer.append("convert(varchar(10), S_ME_CustomerInfo.S_ME_CI_Birthday, 120)  as smecibirthday,S_ME_CI_Sex as smecisex  ");
		buffer.append("from S_ME_CustomerInfo  ");
		buffer.append("where year(S_ME_CI_Birthday)<>'1900' and (cast(year(getdate()) as varchar)+(substring(convert(varchar(10),dateAdd(day,0,S_ME_CI_Birthday),120),5,10))) = convert(varchar(10),getdate(),120)  ");
		buffer.append("and (");
		buffer.append("(substring(S_ME_CI_Phone,1,1)='1' ");
		buffer.append("and len(S_ME_CI_Phone)=11) ");		
		buffer.append("or (substring(S_ME_CI_Phone2,1,1)='1' ");
		buffer.append("and len(S_ME_CI_Phone2)=11) ");		
		buffer.append("or (substring(S_ME_CI_Phone3,1,1)='1' ");
		buffer.append("and len(S_ME_CI_Phone3)=11) ");		
		buffer.append(") ");
		
		return  queryForObjectList(buffer.toString(),null,CustomerInfoPo.class);
	}

	/**
	 * 获取短信平台维护表信息
	 */
	public SmsSetPo getSmsSet() {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  F_SS_BirthdayFlag as fssbirthdayflag , F_SS_BirthdayDate as fssbirthdaydate,F_SS_BirthdayTime as fssbirthdaytime,F_SS_BirthdayContent as fssbirthdaycontent ");
		buffer.append("from F_SmsSet ");
		
		return (SmsSetPo) queryForObject(buffer.toString(),null,SmsSetPo.class);
	}

	/**
	 * 新增短信记录表 
	 */
	public void insertSmsRecord(SmsRecordPo smsRecordPo) {
		
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into F_SmsRecord ");
		buffer.append("(F_SR_id,F_SR_ReceiptPerson,F_SR_ReceiptTel, ");
		buffer.append("F_SR_SendPerson,F_SR_SendContext,F_SR_SendDate,F_SR_SendFlag )");
		buffer.append("values(? , ? , ? , '284' , ? , getdate() , '1' ) ");
		
		params.add(this.uuid.generate());
		params.add(smsRecordPo.getFsrreceiptperson());
		params.add(smsRecordPo.getFsrreceipttel());
//		params.add(smsRecordPo.getFsrsendperson());
		params.add(smsRecordPo.getFsrsendcontext());
//		params.add(smsRecordPo.getFsrsenddate());
//		params.add(smsRecordPo.getFsrsendflag());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 查询公司名称
	 */
	public CompanyNamePo getCompanyName() {
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("select top 1 F_CN_ID as fcnId, F_CN_Name as fcnName ");
		buffer.append("from F_CompanyName ");

		return (CompanyNamePo) queryForObject(buffer.toString(), null,
				CompanyNamePo.class);
	}
}
