package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.system.dao.SendNoteDao;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SendNoteDaoImpl extends BaseJdbcDaoSupport implements SendNoteDao {
	
	/**
	 * 获取短信模板数量
	 */
	public int getSendNoteTemplateCount(NoteTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(B_NT_ID) from B_NoteTemplate inner join B_NoteType on B_NT_Name=B_NT_TypeID where B_NT_Name = ? and B_NoteTemplate.B_NT_AutoSend = '1' and B_NoteType.B_NT_AutoSend='1' ");
		
		params.add(Utility.getName(po.getBnttypeid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 获取短信模板
	 */
	public NoteTemplatePo getSendNoteTemplate(NoteTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 isnull(B_NT_Content,'') as bntcontent from B_NoteTemplate inner join B_NoteType on B_NT_Name=B_NT_TypeID where B_NT_Name = ? and B_NoteTemplate.B_NT_AutoSend = '1' and B_NoteType.B_NT_AutoSend='1' ");
		
		params.add(Utility.getName(po.getBnttypeid()));
		
		return (NoteTemplatePo)queryForObject(buffer.toString(), params.toArray(), NoteTemplatePo.class);
	}
	
	/**
	 * 新增短信
	 */
	public void insertSendNoteContent(SendNotePo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into F_SmsRecord ");
		buffer.append("(F_SR_id,F_SR_ReceiptPerson,F_SR_ReceiptTel, ");
		buffer.append("F_SR_SendPerson,F_SR_SendContext,F_SR_SendDate,F_SR_SendFlag,F_SR_CreateDate,F_SR_Type ) ");
		buffer.append("values(? , ? , ? , ? , ? ,  ");
		
		if (!"".equals(Utility.getName(po.getSnsenddate()))){
			buffer.append(" ?,");
		}else{
			buffer.append(" getdate(),");
		}
		buffer.append("  ?,getdate(),? ) ");	
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getSncustomerid()));
		params.add(Utility.getName(po.getSncustomertelphone()));
		params.add(Utility.getName(po.getSnpersonid()));
		params.add(Utility.getName(po.getSnnotecontent()));
		if (!"".equals(Utility.getName(po.getSnsenddate()))){
			params.add(Utility.getName(po.getSnsenddate()));
		}
		
		params.add(Utility.getName(po.getSnsendflag()));
		params.add(Utility.getName(po.getSnnotetypeid()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
		
	}
	
	/**
	 * 根据顾客号查询手机是否存在
	 */
	public int getSendNotePhoneCountByCustomer(SendNotePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();

		buffer.append("select count(S_ME_CI_CustomerID) from S_ME_CustomerInfo where 1=1 ");
		buffer.append(" and (");
		buffer.append("(substring(S_ME_CI_Phone,1,1)='1' ");
		buffer.append("and len(S_ME_CI_Phone)=11) ");
		
		buffer.append("or (substring(S_ME_CI_Phone2,1,1)='1' ");
		buffer.append("and len(S_ME_CI_Phone2)=11) ");
		
		buffer.append("or (substring(S_ME_CI_Phone3,1,1)='1' ");
		buffer.append("and len(S_ME_CI_Phone3)=11) ");
		
		buffer.append(") and S_ME_CI_CustomerID= ? ");
		
		params.add(Utility.getName(po.getSncustomerid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 根据顾客号查询手机
	 */
	public SendNotePo getSendNotePhoneByCustomer(SendNotePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 sncustomertelphone as sncustomertelphone from ( ");
		buffer.append("select S_ME_CI_Phone as sncustomertelphone ");
		buffer.append(" from S_ME_CustomerInfo where S_ME_CI_CustomerID = ? ");
		buffer.append(" and (substring(S_ME_CI_Phone,1,1)='1' and len(S_ME_CI_Phone)=11) ");
		buffer.append(" union all ");
		buffer.append("select S_ME_CI_Phone2 as sncustomertelphone ");
		buffer.append(" from S_ME_CustomerInfo where S_ME_CI_CustomerID = ? ");
		buffer.append(" and (substring(S_ME_CI_Phone2,1,1)='1' and len(S_ME_CI_Phone2)=11) ");
		buffer.append(" union all ");
		buffer.append("select S_ME_CI_Phone3 as sncustomertelphone ");
		buffer.append(" from S_ME_CustomerInfo where S_ME_CI_CustomerID = ? ");
		buffer.append(" and (substring(S_ME_CI_Phone3,1,1)='1' and len(S_ME_CI_Phone3)=11) ");
		buffer.append(" )temp ");
		
		params.add(Utility.getName(po.getSncustomerid()));
		params.add(Utility.getName(po.getSncustomerid()));
		params.add(Utility.getName(po.getSncustomerid()));
		
		return (SendNotePo) queryForObject(buffer.toString(), params.toArray(), SendNotePo.class);
	}
	
	/**
	 * 测试短信接口
	 */
	public int getSendNotePhoneCountTestByCustomer(SendNotePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();

		buffer.append("select count(S_ME_CI_Phone) from S_ME_CustomerPhone where S_ME_CI_Phone = ? ");
		
		params.add(Utility.getName(po.getSncustomertelphone()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 获取短信模板数量
	 */
	public List<NoteTemplatePo> getSendNoteTemplateCount(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select '13' as bntname,count(B_NT_ID) as bnttypecount from B_NoteTemplate inner join B_NoteType on B_NT_Name=B_NT_TypeID where B_NT_Name = '13' and B_NoteTemplate.B_NT_AutoSend = '1' and B_NoteType.B_NT_AutoSend='1' ");
		buffer.append(" union all ");
		buffer.append("select '9' as bntname,count(B_NT_ID) as bnttypecount from B_NoteTemplate inner join B_NoteType on B_NT_Name=B_NT_TypeID where B_NT_Name = '9' and B_NoteTemplate.B_NT_AutoSend = '1' and B_NoteType.B_NT_AutoSend='1' ");
		buffer.append(" union all ");
		buffer.append("select '12' as bntname,count(B_NT_ID) as bnttypecount from B_NoteTemplate inner join B_NoteType on B_NT_Name=B_NT_TypeID where B_NT_Name = '12' and B_NoteTemplate.B_NT_AutoSend = '1' and B_NoteType.B_NT_AutoSend='1' ");
		
		return queryForObjectList(buffer.toString() , null , NoteTemplatePo.class);
	}
	
}
