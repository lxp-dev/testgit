package com.pengsheng.eims.sales.action;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.mgr.DelaysReminderMgr;
import com.pengsheng.eims.sales.persistence.DelaysReminderPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class DelaysReminderAction extends BaseAction {

	private DelaysReminderPo po;
	private DelaysReminderMgr delaysReminderMgr;
	private List<DelaysReminderPo> delaysReminderPoList;
	private PersonPermissionMgr personPermissionMgr;
	
	private CustomerInfoPo customerInfoPo;

	private SmsSetPo smsSetPo;

	private DelaysReminderPo delaysReminderPo;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}
	
	public DelaysReminderPo getDelaysReminderPo() {
		return delaysReminderPo;
	}

	public void setDelaysReminderPo(DelaysReminderPo delaysReminderPo) {
		this.delaysReminderPo = delaysReminderPo;
	}

	public SmsSetPo getSmsSetPo() {
		return smsSetPo;
	}

	public void setSmsSetPo(SmsSetPo smsSetPo) {
		this.smsSetPo = smsSetPo;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public DelaysReminderPo getPo() {
		return po;
	}

	public void setPo(DelaysReminderPo po) {
		this.po = po;
	}

	public List<DelaysReminderPo> getDelaysReminderPoList() {
		return delaysReminderPoList;
	}

	public void setDelaysReminderPoList(
			List<DelaysReminderPo> delaysReminderPoList) {
		this.delaysReminderPoList = delaysReminderPoList;
	}

	public DelaysReminderMgr getDelaysReminderMgr() {
		return delaysReminderMgr;
	}

	public void setDelaysReminderMgr(DelaysReminderMgr delaysReminderMgr) {
		this.delaysReminderMgr = delaysReminderMgr;
	}

	/**
	 * 初始化误期查询
	 * 
	 * @return
	 */
	public String initDelaysReminder() {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		return SUCCESS;
	}

	/**
	 * 根据条件查询误期信息
	 * 
	 * @return
	 */
	public String selectDelaysReminder() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		// 页面查询条件
		String salesid = Utility.getName(request.getParameter("salesid"));
		String customerName = Utility.getName(request
				.getParameter("customerName"));
		String mirrorcheckstartdate = Utility.getName(request
				.getParameter("mirrorcheckstartdate"));
		String mirrorcheckenddate = Utility.getName(request
				.getParameter("mirrorcheckenddate"));
		String expectedcheckstartdate = Utility.getName(request
				.getParameter("expectedcheckstartdate"));
		String expectedcheckenddate = Utility.getName(request
				.getParameter("expectedcheckenddate"));
		String noticeperson = Utility.getName(request
				.getParameter("noticeperson"));
		String noticestartdate = Utility.getName(request
				.getParameter("noticestartdate"));
		String noticeenddate = Utility.getName(request
				.getParameter("noticeenddate"));
		String noticestatus = Utility.getName(request
				.getParameter("noticestatus"));
		
		//王磊07-21
		String departmenttype = personInfoPo.getDepartmenttype();
		String departmentid = personInfoPo.getDepartmentID();
		//王磊07-21

		DelaysReminderPo po = new DelaysReminderPo();
		po.setSsedrsalesid(salesid);
		po.setSsedrcustomerid(customerName);
		po.setSsedrmirrorcheckstartdate(mirrorcheckstartdate);
		po.setSsedrmirrorcheckenddate(mirrorcheckenddate);
		po.setSsedrexpectedcheckstartdate(expectedcheckstartdate);
		po.setSsedrexpectedcheckenddate(expectedcheckenddate);
		po.setSsedrnoticeperson(noticeperson);
		po.setSsedrnoticestartdate(noticestartdate);
		po.setSsedrnoticeenddate(noticeenddate);
		po.setSsedrnoticestatus(noticestatus);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setSsedrcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		//王磊07-21
		po.setSsedrshopcode(departmentid);
		po.setSsedrdepartmenttype(departmenttype);
		//王磊07-21
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		// 查询误期信息数量
		int count = delaysReminderMgr.getDelaysRemindertCount(po);
		// 分页
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			delaysReminderPoList = delaysReminderMgr.getDelaysRemindertList(po,
					page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			delaysReminderPoList = null;
		}
		// 显示查询条件
		request.setAttribute("salesid", salesid);
		request.setAttribute("ssedrcustomerName", customerName);
		request.setAttribute("ssedrmirrorcheckstartdate", mirrorcheckstartdate);
		request.setAttribute("ssedrmirrorcheckenddate", mirrorcheckenddate);
		request.setAttribute("ssedrexpectedcheckstartdate",expectedcheckstartdate);
		request.setAttribute("ssedrexpectedcheckenddate", expectedcheckenddate);
		request.setAttribute("noticeperson", noticeperson);
		request.setAttribute("ssedrnoticestartdate", noticestartdate);
		request.setAttribute("ssedrnoticeenddate", noticeenddate);
		request.setAttribute("noticestatus", noticestatus);

		return SUCCESS;
	}

	/**
	 * 初始化误期查询通知开窗
	 * 
	 * @return
	 */
	public String initDelaysReminderInformSel() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		po = new DelaysReminderPo();
		po.setSsedrsalesid(request.getParameter("hid"));

		return SUCCESS;
	}

	/**
	 * 修改通知状态
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String updateDelaysReminder() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		// String departmentId = personInfoPo.getDepartmentID();
		// String createPerson = personInfoPo.getId();
		
		// 修改通知状态
		String salesid = Utility.getName(request.getParameter("ssedrsalesid"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("36");    // 误期通知
		logPo.setsLogContent(salesid);
		
		delaysReminderMgr.updateDelaysRemindert(salesid, personInfoPo.getId(),logPo);
		String ssedrexpectedcheckdate=Utility.getName(request.getParameter("ssedrexpectedcheckdate"));
		
		// 获取客户名称和电话
		customerInfoPo = delaysReminderMgr.getCustomerInfo(salesid);

		smsSetPo = delaysReminderMgr.getSmsSet();
		//获取误期天数
		delaysReminderPo=delaysReminderMgr.getDelaysReminder(salesid);
		
		
		
		if ("1".equals(Utility.getName(smsSetPo.getFssdelaysflag()))) {
			// 短信记录表
			SmsRecordPo smsRecordPo = new SmsRecordPo();
			smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmeciname());// 接收人员
			smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());// 接收人员电话
			smsRecordPo.setFsrsendperson(personInfoPo.getId());// 发送人员
			smsRecordPo.setFsrsendperson(personInfoPo.getPersonName());// 发送人员
			// smsRecordPo.setFsrsendcontext(smsSetPo.getFssremindcontent());//发送内容

			String[] text = smsSetPo.getFssdelayscontent().split("/D");
			String customerName = customerInfoPo.getSmeciname();//客户名称
			String salesID = request.getParameter("ssedrsalesid");//配镜单号
			String days=delaysReminderPo.getDays();
			
			for (int i = 0; i < text.length; i++) {
				String sms = customerName + text[1] + salesID + text[2] + days +text[3];
				smsRecordPo.setFsrsendcontext(sms);// 发送内容
			}
			
			delaysReminderMgr.insertSmsRecord(smsRecordPo);
		}

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
}
