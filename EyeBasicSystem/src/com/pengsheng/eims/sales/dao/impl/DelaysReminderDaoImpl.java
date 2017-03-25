package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.dao.DelaysReminderDao;
import com.pengsheng.eims.sales.persistence.DelaysReminderPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class DelaysReminderDaoImpl extends BaseJdbcDaoSupport implements DelaysReminderDao {

	/**
	 * 误期提醒信息数量
	 */
	public int getDelaysRemindertCount(DelaysReminderPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select count(S_SE_DR_ID)  ");
	
		buffer.append("from S_SE_DelaysReminder ");		

		buffer.append("inner join B_Departments on S_SE_DelaysReminder.S_SE_DR_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("inner join S_SE_SalesBasic on S_SE_DelaysReminder.S_SE_DR_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		buffer.append("left join SYS_PersonInfo notice on S_SE_DR_NoticePerson = notice.ID ");
		
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getSsedrcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsedrcompanyid()));	
		}
		
		if(!"3".equals(Utility.getName(po.getSsedrdepartmenttype()))){//判断是不是营运部
			buffer.append("and S_SE_DR_ShopCode = ? ");
			params.add(po.getSsedrshopcode());
		}
		
		if(!"".equals(Utility.getName(po.getSsedrsalesid()))){	//配镜单号
			buffer.append("and S_SE_DR_SalesID like '%'+ ? +'%' ");//quyanping
			params.add(po.getSsedrsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getSsedrcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsedrcustomerid());
		} 
		
		//原取镜日期
		if(!"".equals(Utility.getName(po.getSsedrmirrorcheckstartdate())) && !"".equals(Utility.getName(po.getSsedrmirrorcheckenddate()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) <= ? ");
			params.add(po.getSsedrmirrorcheckstartdate());
			params.add(po.getSsedrmirrorcheckenddate());
		}else if(!"".equals(Utility.getName(po.getSsedrmirrorcheckstartdate())) && "".equals(Utility.getName(po.getSsedrmirrorcheckenddate()))){
			buffer.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) >=  ? ");
			params.add(po.getSsedrmirrorcheckstartdate());
		}else if("".equals(Utility.getName(po.getSsedrmirrorcheckstartdate())) && !"".equals(Utility.getName(po.getSsedrmirrorcheckenddate()))){
			buffer.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) <= ? ");
			params.add(po.getSsedrmirrorcheckenddate());
		}		
		
		//预计取镜日期
		if(!"".equals(Utility.getName(po.getSsedrexpectedcheckstartdate())) && !"".equals(Utility.getName(po.getSsedrexpectedcheckenddate()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) <= ? ");
			params.add(po.getSsedrexpectedcheckstartdate());
			params.add(po.getSsedrexpectedcheckenddate());
		}else if(!"".equals(Utility.getName(po.getSsedrexpectedcheckstartdate())) && "".equals(Utility.getName(po.getSsedrexpectedcheckenddate()))){
			buffer.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) >=  ? ");
			params.add(po.getSsedrexpectedcheckstartdate());
		}else if("".equals(Utility.getName(po.getSsedrexpectedcheckstartdate())) && !"".equals(Utility.getName(po.getSsedrexpectedcheckenddate()))){
			buffer.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) <= ? ");
			params.add(po.getSsedrexpectedcheckenddate());
		}
		
		if(!"".equals(Utility.getName(po.getSsedrnoticeperson()))){	//通知人
			buffer.append("and notice.personName like '%' + ? + '%' ");
			params.add(po.getSsedrnoticeperson());
		}
		
		//通知日期
		if(!"".equals(Utility.getName(po.getSsedrnoticestartdate())) && !"".equals(Utility.getName(po.getSsedrnoticeenddate()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) <= ? ");
			params.add(po.getSsedrnoticestartdate());
			params.add(po.getSsedrnoticeenddate());
		}else if(!"".equals(Utility.getName(po.getSsedrnoticestartdate())) && "".equals(Utility.getName(po.getSsedrnoticeenddate()))){
			buffer.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) >=  ? ");
			params.add(po.getSsedrnoticestartdate());
		}else if("".equals(Utility.getName(po.getSsedrnoticestartdate())) && !"".equals(Utility.getName(po.getSsedrnoticeenddate()))){
			buffer.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) <= ? ");
			params.add(po.getSsedrnoticeenddate());
		}
		
		if(!"".equals(Utility.getName(po.getSsedrnoticestatus()))){	//通知状态
			buffer.append("and S_SE_DR_NoticeStatus = ?  ");
			params.add(po.getSsedrnoticestatus());
		}

		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 遍历误期提醒信息
	 */
	public List<DelaysReminderPo> getDelaysRemindertList(DelaysReminderPo po,
			int start, int size) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from(select ROW_NUMBER() Over (order by S_SE_DR_MirrorCheckDate desc) as rowNum, ");
		buffer.append("S_SE_DR_ID as ssedrid, ");
		buffer.append("S_ME_CI_Name as ssedrname, ");
		buffer.append("S_SE_DR_SalesID as ssedrsalesid, ");
		buffer.append("B_DP_DepartmentName as ssedrshopcode, ");
		buffer.append("S_ME_CI_CustomerID as ssedrcustomerid, ");
		buffer.append("S_SE_DR_MirrorCheckDate as ssedrmirrorcheckdate, ");
		buffer.append("S_SE_DR_ExpectedCheckDate as ssedrexpectedcheckdate, ");
		buffer.append("S_SE_DR_CausesDelays as ssedrcausesdelays, ");
		buffer.append("audit.personName as ssedrauditperson, ");
		buffer.append("S_SE_DR_AuditDate as ssedrauditdate, ");
		buffer.append("S_SE_DR_AuditStatus as ssedrauditstatus, ");
		buffer.append("notice.personName as ssedrnoticeperson, ");
		buffer.append("S_SE_DR_NoticeDate as ssedrnoticedate, ");
		buffer.append("S_SE_DR_NoticeStatus as ssedrnoticestatus, ");
		buffer.append("S_SE_DR_CreateDate as ssedrCreatedate ");
		buffer.append("from S_SE_DelaysReminder ");

		buffer.append("inner join B_Departments on S_SE_DelaysReminder.S_SE_DR_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("left join SYS_PersonInfo notice on S_SE_DR_NoticePerson = notice.ID ");
		buffer.append("left join SYS_PersonInfo audit on S_SE_DR_AuditPerson = audit.ID ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_DelaysReminder.S_SE_DR_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getSsedrcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsedrcompanyid()));	
		}
		
		if(!"3".equals(Utility.getName(po.getSsedrdepartmenttype()))){//判断是不是营运部
			buffer.append("and S_SE_DR_ShopCode = ? ");
			params.add(po.getSsedrshopcode());
		}
		
		if(!"".equals(Utility.getName(po.getSsedrsalesid()))){	//配镜单号
			buffer.append("and S_SE_DR_SalesID like '%' + ? + '%' ");//quyanping
			params.add(po.getSsedrsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getSsedrcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsedrcustomerid());
		} 
		
		//原取镜日期
		if(!"".equals(Utility.getName(po.getSsedrmirrorcheckstartdate())) && !"".equals(Utility.getName(po.getSsedrmirrorcheckenddate()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) <= ? ");
			params.add(po.getSsedrmirrorcheckstartdate());
			params.add(po.getSsedrmirrorcheckenddate());
		}else if(!"".equals(Utility.getName(po.getSsedrmirrorcheckstartdate())) && "".equals(Utility.getName(po.getSsedrmirrorcheckenddate()))){
			buffer.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) >=  ? ");
			params.add(po.getSsedrmirrorcheckstartdate());
		}else if("".equals(Utility.getName(po.getSsedrmirrorcheckstartdate())) && !"".equals(Utility.getName(po.getSsedrmirrorcheckenddate()))){
			buffer.append("and convert(varchar(10), S_SE_DR_MirrorCheckDate, 23) <= ? ");
			params.add(po.getSsedrmirrorcheckenddate());
		}		
		
		//预计取镜日期
		if(!"".equals(Utility.getName(po.getSsedrexpectedcheckstartdate())) && !"".equals(Utility.getName(po.getSsedrexpectedcheckenddate()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) <= ? ");
			params.add(po.getSsedrexpectedcheckstartdate());
			params.add(po.getSsedrexpectedcheckenddate());
		}else if(!"".equals(Utility.getName(po.getSsedrexpectedcheckstartdate())) && "".equals(Utility.getName(po.getSsedrexpectedcheckenddate()))){
			buffer.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) >=  ? ");
			params.add(po.getSsedrexpectedcheckstartdate());
		}else if("".equals(Utility.getName(po.getSsedrexpectedcheckstartdate())) && !"".equals(Utility.getName(po.getSsedrexpectedcheckenddate()))){
			buffer.append("and convert(varchar(10), S_SE_DR_ExpectedCheckDate, 23) <= ? ");
			params.add(po.getSsedrexpectedcheckenddate());
		}
		
		if(!"".equals(Utility.getName(po.getSsedrnoticeperson()))){	//通知人
			buffer.append("and notice.personName like '%' + ? + '%' ");
			params.add(po.getSsedrnoticeperson());
		}
		
		//通知日期
		if(!"".equals(Utility.getName(po.getSsedrnoticestartdate())) && !"".equals(Utility.getName(po.getSsedrnoticeenddate()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) <= ? ");
			params.add(po.getSsedrnoticestartdate());
			params.add(po.getSsedrnoticeenddate());
		}else if(!"".equals(Utility.getName(po.getSsedrnoticestartdate())) && "".equals(Utility.getName(po.getSsedrnoticeenddate()))){
			buffer.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) >=  ? ");
			params.add(po.getSsedrnoticestartdate());
		}else if("".equals(Utility.getName(po.getSsedrnoticestartdate())) && !"".equals(Utility.getName(po.getSsedrnoticeenddate()))){
			buffer.append("and convert(varchar(10), S_SE_DR_NoticeDate, 23) <= ? ");
			params.add(po.getSsedrnoticeenddate());
		}
		
		if(!"".equals(Utility.getName(po.getSsedrnoticestatus()))){	//通知状态
			buffer.append("and S_SE_DR_NoticeStatus = ?  ");
			params.add(po.getSsedrnoticestatus());
		}
		
		buffer.append(" ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),
				DelaysReminderPo.class);
	}

	/**
	 * 查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfo(String salesid) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_ME_CI_CustomerID as smecicustomerid,S_ME_CI_Phone as smeciphone,S_ME_CI_Name as smeciname ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("inner join S_SE_SalesBasic on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		params.add(salesid);
		
		return (CustomerInfoPo) queryForObject(buffer.toString(), params.toArray(),
				CustomerInfoPo.class);
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
		buffer.append("values(? , ? , ? , ? , ? , getdate() , '1' ) ");
		
		params.add(this.uuid.generate());
		params.add(smsRecordPo.getFsrreceiptperson());
		params.add(smsRecordPo.getFsrreceipttel());
		params.add(smsRecordPo.getFsrsendperson());
		params.add(smsRecordPo.getFsrsendcontext());
//		params.add(smsRecordPo.getFsrsenddate());
//		params.add(smsRecordPo.getFsrsendflag());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
		
	}

	/**
	 * 获取短信平台维护表信息
	 */
	public SmsSetPo getSmsSet() {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  F_SS_DelaysFlag as fssdelaysflag, F_SS_DelaysContent as fssdelayscontent ");
		buffer.append("from F_SmsSet ");
		
		return (SmsSetPo) queryForObject(buffer.toString(),null,SmsSetPo.class);
	}

	/**
	 * 修改通知状态
	 */
	public void updateDelaysRemindert(String salesid, String noticePerson) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update S_SE_DelaysReminder set ");
		buffer.append("S_SE_DR_NoticeStatus = '1', ");
		buffer.append("S_SE_DR_NoticeDate = GETDATE(), ");
		buffer.append("S_SE_DR_NoticePerson = ? ");
		
		buffer.append("where S_SE_DR_SalesID = ? ");

		params.add(noticePerson);
		params.add(salesid);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 获取误期的天数
	 */
	public DelaysReminderPo getDelaysReminder(String salesid) {
		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  datediff(dd,S_SE_DR_ExpectedCheckDate,getdate()) as days ");
		sb.append("from S_SE_DelaysReminder ");
		sb.append(" where S_SE_DR_SalesID = ? ");
		List<String> params = new ArrayList<String>();
		params.add(salesid);
		return (DelaysReminderPo) queryForObject(sb.toString(), params.toArray(),
				DelaysReminderPo.class);
	}
}
