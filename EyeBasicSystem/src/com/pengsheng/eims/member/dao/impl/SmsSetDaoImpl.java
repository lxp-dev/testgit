package com.pengsheng.eims.member.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.pengsheng.eims.member.dao.SmsSetDao;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
public class SmsSetDaoImpl extends BaseJdbcDaoSupport implements SmsSetDao {

	/**
	 * 查询短息维护信息
	 */
	public SmsSetPo getSmsSetPo() {
		
		StringBuffer buffer = new StringBuffer();
		//List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT top 1 ");
		buffer.append("F_SS_id as fssid ,");
		buffer.append("F_SS_BirthdayFlag as fssbirthdayflag ,");
		buffer.append("F_SS_BirthdayDate as fssbirthdaydate ,");
		buffer.append("F_SS_BirthdayTime as fssbirthdaytime ,");
		buffer.append("F_SS_BirthdayContent as fssbirthdaycontent ,");
		buffer.append("F_SS_RemindFlag as fssremindflag ,");
		buffer.append("F_SS_RemindContent as fssremindcontent ,");
		buffer.append("F_SS_DelaysFlag as fssdelaysflag ,");
		buffer.append("F_SS_DelaysContent as fssdelayscontent ,");
		buffer.append("F_SS_VisitFlag as fssvisitflag ,");
		buffer.append("F_SS_VisitDate as fssvisitdate ,");
		buffer.append("F_SS_VisitTime as fssvisittime ,");
		buffer.append("F_SS_VisitContent as fssvisitcontent ");
		buffer.append("FROM F_SmsSet ");
		buffer.append("where 1=1 ");
		
		return (SmsSetPo) queryForObject(buffer.toString(), null,
				SmsSetPo.class);
	}

	/**
	 * 修改短息维护信息
	 */
	public void updateSmsSetPo(SmsSetPo smsSetPo) {

		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update F_SmsSet set ");
		
		buffer.append("F_SS_BirthdayFlag = ? ,");
		buffer.append("F_SS_BirthdayDate = ? ,");
		buffer.append("F_SS_BirthdayTime = ? ,");
		buffer.append("F_SS_BirthdayContent = ? ,");
		buffer.append("F_SS_RemindFlag = ? ,");
		buffer.append("F_SS_RemindContent = ? ,");
		buffer.append("F_SS_DelaysFlag = ? ,");
		buffer.append("F_SS_DelaysContent = ? ,");
		buffer.append("F_SS_VisitFlag = ? ,");
		buffer.append("F_SS_VisitDate = ? ,");
		buffer.append("F_SS_VisitTime = ? ,");
		buffer.append("F_SS_VisitContent = ? ");
		buffer.append("WHERE F_SS_id = ?");	
		params.add(smsSetPo.getFssbirthdayflag());
		params.add(smsSetPo.getFssbirthdaydate());
		params.add(smsSetPo.getFssbirthdaytime());
		params.add(smsSetPo.getFssbirthdaycontent());
		params.add(smsSetPo.getFssremindflag());
		params.add(smsSetPo.getFssremindcontent());
		params.add(smsSetPo.getFssdelaysflag());
		params.add(smsSetPo.getFssdelayscontent());
		params.add(smsSetPo.getFssvisitflag());
		params.add(smsSetPo.getFssvisitdate());
		params.add(smsSetPo.getFssvisittime());
		params.add(smsSetPo.getFssvisitcontent());
		params.add(smsSetPo.getFssid());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	public int selectSmsRecordCount(SmsRecordPo smsRecordPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(*) ");
		buffer.append("FROM   dbo.F_SmsRecord ");
		buffer.append("       left JOIN dbo.SYS_PersonInfo ");
		buffer.append("         ON id = F_SR_SendPerson ");
		buffer.append("  left join S_ME_CustomerInfo on F_SR_ReceiptPerson=S_ME_CI_CustomerID ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(smsRecordPo.getFsrsendpersonnamet()))){
			buffer.append("       AND personName LIKE '%'+?+'%' ");
			params.add(smsRecordPo.getFsrsendpersonnamet());
		}
		
		if("0".equals(Utility.getName(smsRecordPo.getFsrsendflag()))){
			buffer.append("       AND (F_SR_SendFlag = '' or F_SR_SendFlag is null ) ");
		}else if("1".equals(Utility.getName(smsRecordPo.getFsrsendflag()))){
			buffer.append("       AND F_SR_SendFlag like '0,%' ");
		}else if("2".equals(Utility.getName(smsRecordPo.getFsrsendflag()))){
			buffer.append("       AND F_SR_SendFlag like '-%' ");
		}
		
		if(!"".equals(Utility.getName(smsRecordPo.getFsrsendtype()))){
			buffer.append("       AND F_SR_Type  = ? ");
			params.add(smsRecordPo.getFsrsendtype());
		}	
		if(!"".equals(Utility.getName(smsRecordPo.getFsrsendpersont()))){
			buffer.append("       AND F_SR_SendPerson = ? ");
			params.add(smsRecordPo.getFsrsendpersont());
		}
		if(!"".equals(Utility.getName(smsRecordPo.getFsrreceipttelt()))){
			buffer.append("       AND F_SR_ReceiptTel LIKE '%'+?+'%' ");
			params.add(smsRecordPo.getFsrreceipttelt());
		}
		if(!"".equals(Utility.getName(smsRecordPo.getFsrreceiptpersont()))){
			buffer.append("       AND S_ME_CI_Name LIKE '%'+?+'%' ");
			params.add(smsRecordPo.getFsrreceiptpersont());
		}
		if(!"".equals(Utility.getName(smsRecordPo.getFsrbegindate()))){
			buffer.append("       AND CONVERT(VARCHAR(10), F_SR_SendDate, 23) >= ? ");
			params.add(smsRecordPo.getFsrbegindate());
		}
		if(!"".equals(Utility.getName(smsRecordPo.getFsrenddate()))){
			buffer.append("       AND CONVERT(VARCHAR(10), F_SR_SendDate, 23) <= ? ");
			params.add(smsRecordPo.getFsrenddate());
		}
		
		if (!"".equals(Utility.getName(smsRecordPo.getFsrcompanyid()))){
			buffer.append(" and personcompanyid = ? ");
			params.add(Utility.getName(smsRecordPo.getFsrcompanyid()));	
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}

	public List<SmsRecordPo> selectSmsRecordList(SmsRecordPo smsRecordPo,int start ,int size) {
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");	
		buffer.append("select * from ( ");	
		buffer.append("SELECT ROW_NUMBER() Over(ORDER BY F_SR_SendDate desc) AS rowNum, ");
		buffer.append("       F_SR_id            AS fsrid, ");
		buffer.append("       S_ME_CI_Name AS fsrreceiptperson, ");
		buffer.append("       F_SR_ReceiptTel    AS fsrreceipttel, ");
		buffer.append("       F_SR_SendPerson    AS fsrsendperson, ");
		buffer.append("       personName         AS fsrsendpersonname, ");
		buffer.append("       F_SR_SendContext   AS fsrsendcontext, ");
		buffer.append("       F_SR_SendDate      AS fsrsenddate, ");
		buffer.append("       F_SR_SendFlag      AS fsrsendflag, ");
		buffer.append("       F_SR_CreateDate      AS fsrcreatedate, ");
		buffer.append("       F_SR_Type      AS fsrsendtype, ");
		buffer.append("       B_NT_TypeName      AS fsrsendtypename ");
		buffer.append("FROM   dbo.F_SmsRecord ");
		buffer.append("       left JOIN dbo.SYS_PersonInfo ");
		buffer.append("         ON id = F_SR_SendPerson ");
		buffer.append("  left join S_ME_CustomerInfo on F_SR_ReceiptPerson=S_ME_CI_CustomerID left join B_NoteType on F_SR_Type = B_NT_TypeID ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(smsRecordPo.getFsrsendpersonnamet()))){
			buffer.append("       AND personName LIKE '%'+?+'%' ");
			params.add(smsRecordPo.getFsrsendpersonnamet());
		}

		if("0".equals(Utility.getName(smsRecordPo.getFsrsendflag()))){
			buffer.append("       AND (F_SR_SendFlag = '' or F_SR_SendFlag is null ) ");
		}else if("1".equals(Utility.getName(smsRecordPo.getFsrsendflag()))){
			buffer.append("       AND F_SR_SendFlag like '0,%' ");
		}else if("2".equals(Utility.getName(smsRecordPo.getFsrsendflag()))){
			buffer.append("       AND F_SR_SendFlag like '-%' ");
		}
		
		if(!"".equals(Utility.getName(smsRecordPo.getFsrsendtype()))){
			buffer.append("       AND F_SR_Type  = ? ");
			params.add(smsRecordPo.getFsrsendtype());
		}		
		if(!"".equals(Utility.getName(smsRecordPo.getFsrsendpersont()))){
			buffer.append("       AND F_SR_SendPerson = ? ");
			params.add(smsRecordPo.getFsrsendpersont());
		}
		if(!"".equals(Utility.getName(smsRecordPo.getFsrreceipttelt()))){
			buffer.append("       AND F_SR_ReceiptTel LIKE '%'+?+'%' ");
			params.add(smsRecordPo.getFsrreceipttelt());
		}
		if(!"".equals(Utility.getName(smsRecordPo.getFsrreceiptpersont()))){
			buffer.append("       AND S_ME_CI_Name LIKE '%'+?+'%' ");
			params.add(smsRecordPo.getFsrreceiptpersont());
		}
		if(!"".equals(Utility.getName(smsRecordPo.getFsrbegindate()))){
			buffer.append("       AND CONVERT(VARCHAR(10), F_SR_SendDate, 23) >= ? ");
			params.add(smsRecordPo.getFsrbegindate());
		}
		if(!"".equals(Utility.getName(smsRecordPo.getFsrenddate()))){
			buffer.append("       AND CONVERT(VARCHAR(10), F_SR_SendDate, 23) <= ? ");
			params.add(smsRecordPo.getFsrenddate());
		}
		
		if (!"".equals(Utility.getName(smsRecordPo.getFsrcompanyid()))){
			buffer.append(" and personcompanyid = ? ");
			params.add(Utility.getName(smsRecordPo.getFsrcompanyid()));	
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= " + countPage);
		buffer.append("order by fsrcreatedate desc set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), SmsRecordPo.class);
	}
	
	public List<SmsRecordPo> selectSmsRecordList(SmsRecordPo smsRecordPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT ");
		buffer.append("       F_SR_ReceiptPerson    AS fsrreceiptperson, ");		
		buffer.append("       F_SR_ReceiptTel    AS fsrreceipttel, ");
		buffer.append("       F_SR_SendContext   AS fsrsendcontext ");
		buffer.append("FROM   dbo.F_SmsRecord ");
		buffer.append("       left JOIN dbo.SYS_PersonInfo ");
		buffer.append("         ON id = F_SR_SendPerson ");
		buffer.append("  left join S_ME_CustomerInfo on F_SR_ReceiptPerson=S_ME_CI_CustomerID left join B_NoteType on F_SR_Type = B_NT_TypeID ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(smsRecordPo.getFsrsendpersonnamet()))){
			buffer.append("       AND personName LIKE '%'+?+'%' ");
			params.add(smsRecordPo.getFsrsendpersonnamet());
		}

		if("0".equals(Utility.getName(smsRecordPo.getFsrsendflag()))){
			buffer.append("       AND (F_SR_SendFlag = '' or F_SR_SendFlag is null ) ");
		}else if("1".equals(Utility.getName(smsRecordPo.getFsrsendflag()))){
			buffer.append("       AND F_SR_SendFlag like '0,%' ");
		}else if("2".equals(Utility.getName(smsRecordPo.getFsrsendflag()))){
			buffer.append("       AND F_SR_SendFlag like '-%' ");
		}
		
		if(!"".equals(Utility.getName(smsRecordPo.getFsrsendtype()))){
			buffer.append("       AND F_SR_Type  = ? ");
			params.add(smsRecordPo.getFsrsendtype());
		}		
		if(!"".equals(Utility.getName(smsRecordPo.getFsrsendpersont()))){
			buffer.append("       AND F_SR_SendPerson = ? ");
			params.add(smsRecordPo.getFsrsendpersont());
		}
		if(!"".equals(Utility.getName(smsRecordPo.getFsrreceipttelt()))){
			buffer.append("       AND F_SR_ReceiptTel LIKE '%'+?+'%' ");
			params.add(smsRecordPo.getFsrreceipttelt());
		}
		if(!"".equals(Utility.getName(smsRecordPo.getFsrreceiptpersont()))){
			buffer.append("       AND S_ME_CI_Name LIKE '%'+?+'%' ");
			params.add(smsRecordPo.getFsrreceiptpersont());
		}
		if(!"".equals(Utility.getName(smsRecordPo.getFsrbegindate()))){
			buffer.append("       AND CONVERT(VARCHAR(10), F_SR_SendDate, 23) >= ? ");
			params.add(smsRecordPo.getFsrbegindate());
		}
		if(!"".equals(Utility.getName(smsRecordPo.getFsrenddate()))){
			buffer.append("       AND CONVERT(VARCHAR(10), F_SR_SendDate, 23) <= ? ");
			params.add(smsRecordPo.getFsrenddate());
		}
		
		if (!"".equals(Utility.getName(smsRecordPo.getFsrcompanyid()))){
			buffer.append(" and personcompanyid = ? ");
			params.add(Utility.getName(smsRecordPo.getFsrcompanyid()));	
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(), SmsRecordPo.class);
	}	
}
