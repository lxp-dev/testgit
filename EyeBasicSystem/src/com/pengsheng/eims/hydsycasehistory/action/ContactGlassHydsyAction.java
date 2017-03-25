package com.pengsheng.eims.hydsycasehistory.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.components.mgr.CustomerOptometryMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.ContactGlassHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.DoubleEyeFunHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.EyesCheckHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.OptometryBasicHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.RefractiveHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.ContactGlassPo;
import com.pengsheng.eims.hydsycasehistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.hydsycasehistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.hydsycasehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.hydsycasehistory.persistence.InspectionPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.hydsycasehistory.persistence.RefractivePo;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class ContactGlassHydsyAction extends BaseAction {
	private LogisticsLogMgr logisticsLogMgr = null;

	private List<CornealContactlLensPo> cornealContactlLensPos;
	private CornealContactlLensPo cornealContactlLensPo;

	private OptometryBasicPo optometryBasicPo;

	private InspectionPo inspectionPo;

	private List<InspectionPo> inspectionPos;
	private RefractivePo refractivePo;

	private DoubleEyeFunHydsyMgr doubleEyeFunHydsyMgr;

	private PersonPermissionMgr personPermissionMgr;

	private CustomerInfoPo customerInfoPo;

	private OptometryPo optometryPo;

	private OptometryBasicHydsyMgr optometryBasicHydsyMgr;

	private RefractiveHydsyMgr refractiveHydsyMgr;

	private ContactGlassPo contactGlassPo;
	private List<ContactGlassPo> contactGlassPos;

	private CustomerOptometryMgr customerOptometryMgr;

	private ContactGlassHydsyMgr contactGlassHydsyMgr;

	private EyesCheckHydsyMgr eyesCheckHydsyMgr;

	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;

	private CustomerInfoMgr customerInfoMgr;

	private DoubleEyeFunPo doubleEyeFunPo;

	private HealthCheckPo healthCheckPo;
	private UnitMgr unitMgr;

	/*
	 * 初始化接触镜评估
	 */
	public String initContactGlassInsertN() {
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
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号
		String chuyanfuyan = request.getParameter("chuyanfuyan"); // 初验0复验1

		/*
		 * 复制处方移动到复验里,yiwuyong.
		 */
		if ("1".equals(chuyanfuyan)) {
			request.setAttribute("oldOptometryIDFirst", request
					.getParameter("oldOptometryID"));
			request.setAttribute("copyBasicOptometryID", request
					.getParameter("optometryBasicID"));
		}
		int doublecount = doubleEyeFunHydsyMgr.getDoubleEyeFunCount(optometryPo);
		RefractivePo po = new RefractivePo();
		po.setSoproptometryid(optometryID);
		refractivePo = refractiveHydsyMgr.getRefractive(po);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("chuyanfuyan", chuyanfuyan);

		// 获取下拉列表值
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr
				.getOptionParamMinList(optionParamPoTmp);

		if (!"".equals(optometryBasicID)) { //
			request.setAttribute("optometryBasicID", optometryBasicID);
		} else {
			SimpleDateFormat numHeadFormat = new SimpleDateFormat(
					"yyyyMMddHHmmss");
			String numHead = "O" + personInfoPo.getDepartmentID()
					+ personInfoPo.getMachinery()
					+ numHeadFormat.format(new Date());
			request.setAttribute("optometryBasicID", numHead);
		}
		request.setAttribute("doublecount", doublecount);
		request.setAttribute("customerID", customerID);
		request.setAttribute("readOnly", "readOnly");
		return SUCCESS;
	}

	/*
	 * 接触镜评估新增
	 */
	public String contactGlassInsertN() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号
		String chuyanfuyan = request.getParameter("chuyanfuyan"); // 初验0复验1
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " "
				+ "HH:mm:ss");
		String nowTime = tempDate.format(new Date()); // 取得当前日期

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 12 表示开始
		logPo.setsLogOpID("1"); // 1 表示新增
		logPo.setsLogContent("接触镜评估：" + optometryID + " 新增");

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		contactGlassPo.setSopcgcustomerid(customerID);
		contactGlassPo.setSopcgoptometryid(optometryID);
		contactGlassPo.setSopcgoptometrybasicid(optometryBasicID);
		if (contactGlassPos != null && contactGlassPos.size() > 0) {
			int listcount = contactGlassPos.size();
			for (int i = 0; i < listcount; i++) {
				if (i == contactGlassPos.size()) {
					break;
				}
				if (contactGlassPos.get(i) == null) {
					contactGlassPos.remove(i);
					i--;
				} else {

					contactGlassPos.get(i).setSopcgoptometryid(optometryID);
					contactGlassPos.get(i).setSopcgcustomerid(customerID);
					contactGlassPos.get(i).setSopcgoptometrybasicid(
							optometryBasicID);
					contactGlassPos.get(i).setSopcgtryin(
							contactGlassPo.getSopcgtryin());
					contactGlassPos.get(i).setSopcgtype(
							contactGlassPo.getSopcgtype());

				}
			}
		} else {
			contactGlassPos = new ArrayList<ContactGlassPo>();
			contactGlassPos.add(contactGlassPo);
		}
		/**
		 * optometry从表新增
		 */
		String nw = Utility.getName(request.getParameter("nw"));
		optometryPo.setSopoyoptometrybasicid(optometryBasicID);
		optometryPo.setSopoycustomerid(customerID);
		optometryPo.setSopoyshopcode(personInfoPo.getDepartmentID());
		optometryPo.setSopoypersonid(personInfoPo.getId());
		optometryPo.setSopoytime(nowTime);
		optometryPo.setSopoyflag("0");
		optometryPo.setSopoyupdateuserid("");
		optometryPo.setSopoyrecipeupdatetime("");
		optometryPo.setSopoyisinternal(nw);
		optometryPo.setSopoyisinternal("N");
		optometryPo.setSopoyoneormany(chuyanfuyan);

		/**
		 * optometry基表新增
		 */

		OptometryBasicPo optometryBasicPo = null;
		if ("0".equals(chuyanfuyan)) {

			optometryBasicPo = new OptometryBasicPo();
			optometryBasicPo.setSopobcustomerid(customerID);
			optometryBasicPo
					.setSopobcustomername(customerInfoPo.getSmeciname());
			optometryBasicPo.setSopobmedicalendtime(nowTime);
			optometryBasicPo.setSopobmedicalstarttime(nowTime);
			optometryBasicPo.setSopoboptometrybasicid(optometryBasicID);
		}

		String isSend = Utility.getName(request.getParameter("isSend"));
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo = new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);

		this.contactGlassHydsyMgr.contactGlassInsertMessage(contactGlassPos,
				optometryPo, optometryBasicPo, smsRecordPo, isSend,
				personInfoPo, customerID, logPo);

		request.setAttribute("flag", GlobalConstants.OPENUPDATE3);
		request.setAttribute("url", "'initOptometryBasicSel.action?moduleID="
				+ moduleID + "'");
		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		return SUCCESS;
	}

	public String contactGlassInsertDetailsOpenN() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		// systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号
		String ruleFlag = Utility.getName(request.getParameter("ruleFlag"));

		if ("1".equals(ruleFlag)) {

			CustomerInfoPo cpo = contactGlassHydsyMgr.getCustomerInfo(optometryID);

			// SendNotePo snpo = new SendNotePo();
			// snpo.setSnpersonid(personInfoPo1.getId());
			// snpo.setSndepartmentid(personInfoPo1.getDepartmentID());
			// snpo.setSnnotetypeid("5");
			// snpo.setSnbillid(optometryID);
			// snpo.setSncustomername(Utility.getName(cpo.getSmeciname()));
			// snpo.setSnsex(Utility.getName(cpo.getSmecisex()).equals("0") ?
			// "先生" : "女士");
			// snpo.setSncustomerid(Utility.getName(cpo.getSmecicustomerid()));
			// snpo.setSnshopcodephone(Utility.getName(cpo.getSmeciphone()));
			// snpo.setSnoptometrydate(Utility.getName(cpo.getSmecioptometrydate()));
			// snpo.setSnfurtherdate(Utility.getName(cpo.getSmecifurtherdate()));
			// snpo.setSnoptometryshopcodename(Utility.getName(cpo.getSmecioptometrydpt()));

			if (!Utility.getName(cpo.getSmecifurtherdate()).equals("")) {
				Calendar cal = Calendar.getInstance();
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Utility
						.getName(cpo.getSmecifurtherdate()));
				cal.setTime(date);
				cal.add(Calendar.DATE, -1); // 时间延迟 1天

				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd 09:20:00");
				// snpo.setSnsenddate(dateFormat.format(cal.getTime()));
			}

			// this.contactGlassHydsyMgr.updateContactGlassFlag(optometryID,null);
		}

		request.setAttribute("flag", GlobalConstants.OPENUPDATE3);
		request.setAttribute("url", "'initOptometryBasicSel.action?moduleID="
				+ moduleID + "'");
		return "RuleSubmit";
	}

	/*
	 * 初始化修改接触镜评估
	 */
	public String initContactGlassUpdateN() {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		// systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号
		String chuyanfuyan = request.getParameter("chuyanfuyan"); // 初验0复验1
		ContactGlassPo contact = new ContactGlassPo();
		contact.setSopcgoptometryid(optometryID);
		if (!"".equals(Utility.getName(request.getParameter("oldOptometryID")))) {
			contact.setSopcgoptometryid(request.getParameter("oldOptometryID"));
		}
		contactGlassPos = this.contactGlassHydsyMgr.getContactGlassList(contact);
		List<ContactGlassPo> cons = new ArrayList<ContactGlassPo>();
		if (contactGlassPos.size() > 0) {
			for (int i = 0; i < contactGlassPos.size(); i++) {
				contactGlassPo = contactGlassPos.get(0);
				cons.add(contactGlassPos.get(i));
			}
		}
		String isshow = "0";

		// 获取下拉列表值
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr
				.getOptionParamMinList(optionParamPoTmp);

		request.setAttribute("cons", cons);
		request.setAttribute("isshow", isshow);
		String glassType = null;
		request.setAttribute("glassType", glassType);
		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);

		return SUCCESS;
	}

	/*
	 * 修改接触镜评估
	 */
	public String contactGlassUpdateN() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		// systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		optometryPo.setSopoyflag(Utility.getName(request
				.getParameter("ruleFlag")));
		optometryPo.setSopoypersonid((personInfoPo.getId()));
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号
		String chuyanfuyan = request.getParameter("chuyanfuyan"); // 初验0复验1

		String isSend = Utility.getName(request.getParameter("isSend"));
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo = new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID);
		logPo.setsLogOpID("3"); // 3 表示修改
		logPo.setsLogContent("验光验光号：" + optometryID + " 修改");

		logisticsLogMgr.insertLog(logPo); // 新增日志
		if (contactGlassPos != null) {
			int listcount = contactGlassPos.size();
			for (int i = 0; i < listcount; i++) {
				if (i == contactGlassPos.size()) {
					break;
				}
				if (contactGlassPos.get(i) == null) {
					contactGlassPos.remove(i);
					i--;
				} else {

					contactGlassPos.get(i).setSopcgoptometryid(optometryID);
					contactGlassPos.get(i).setSopcgcustomerid(customerID);
					contactGlassPos.get(i).setSopcgoptometrybasicid(
							optometryBasicID);
					contactGlassPos.get(i).setSopcgtryin(
							contactGlassPo.getSopcgtryin());
					contactGlassPos.get(i).setSopcgtype(
							contactGlassPo.getSopcgtype());

				}
			}
		}
		this.contactGlassHydsyMgr.contactGlassUpdateMessage(contactGlassPos,
				optometryPo, smsRecordPo, isSend, personInfoPo, customerID);

		logPo.setsLogResult("11"); // 11 表示成功
		logisticsLogMgr.insertLog(logPo);

		request.setAttribute("flag", GlobalConstants.OPENUPDATE3);

		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		request.setAttribute("url", "'initOptometryBasicSelN.action?moduleID="
				+ moduleID + "'");
		return SUCCESS;
	}

	/*
	 * 初始化接触镜评估查询
	 */
	public String initContactGlassSelectN() {

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

		// 获取下拉列表值
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr
				.getOptionParamMinList(optionParamPoTmp);

		contactGlassPo = new ContactGlassPo();
		contactGlassPo.setSopcgoptometryid(Utility.getName(request
				.getParameter("optometryID")));
		contactGlassPos = this.contactGlassHydsyMgr
				.getContactGlassList(contactGlassPo);

		request.setAttribute("readOnly", "readOnly");
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号

		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);

		String chuyanfuyan = Utility.getName(request
				.getParameter("chuyanfuyan"));
		request.setAttribute("chuyanfuyan", chuyanfuyan);

		ContactGlassPo contact = new ContactGlassPo();
		contact.setSopcgoptometryid(optometryID);
		if (!"".equals(Utility.getName(request.getParameter("oldOptometryID")))) {
			contact.setSopcgoptometryid(request.getParameter("oldOptometryID"));
		}
		contactGlassPos = this.contactGlassHydsyMgr.getContactGlassList(contact);
		List<ContactGlassPo> cons = new ArrayList<ContactGlassPo>();
		if (contactGlassPos.size() > 0) {
			for (int i = 0; i < contactGlassPos.size(); i++) {
				contactGlassPo = contactGlassPos.get(0);
				cons.add(contactGlassPos.get(i));
			}
		}
		
		request.setAttribute("cons", cons);
		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);
		return SUCCESS;
	}

	/*
	 * 复制处方
	 */
	public String contactGlassCopyN() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		// systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号
		String chuyanfuyan = request.getParameter("chuyanfuyan"); // 初验0复验1
		OptometryPo po1 = optometryBasicHydsyMgr.getOptometryPo(optometryBasicID);
		contactGlassPo = new ContactGlassPo();
		contactGlassPo.setSopcgoptometryid(po1.getSopoyoptometryid());
		contactGlassPos = contactGlassHydsyMgr.getContactGlassList(contactGlassPo);

		// String glassType=null;
		// if(contactGlassPos.size()==1){
		// if("2".equals(contactGlassPos.get(0).getSopipglasstype())){
		// contactGlassPos.add(0,null);
		// glassType="2";
		// }else if("1".equals(contactGlassPos.get(0).getSopipglasstype())){
		//
		// glassType="1";
		// }else if("3".equals(contactGlassPos.get(0).getSopipglasstype())){
		// contactGlassPos.add(0,null);
		// contactGlassPos.add(1,null);
		// glassType="3";
		// }else if("4".equals(contactGlassPos.get(0).getSopipglasstype())){
		// contactGlassPos.add(0,null);
		// contactGlassPos.add(1,null);
		// contactGlassPos.add(2,null);
		// glassType="4";
		// }
		// }else if(contactGlassPos.size()==2){
		// if("1".equals(contactGlassPos.get(0).getSopipglasstype())&&"3".equals(contactGlassPos.get(1).getSopipglasstype())){
		// contactGlassPos.add(1, null);
		// glassType="9";
		// }else
		// if("1".equals(contactGlassPos.get(0).getSopipglasstype())&&"4".equals(contactGlassPos.get(1).getSopipglasstype())){
		// contactGlassPos.add(1, null);
		// contactGlassPos.add(2, null);
		// glassType="6";
		// }else
		// if("1".equals(contactGlassPos.get(0).getSopipglasstype())&&"2".equals(contactGlassPos.get(1).getSopipglasstype())){
		// glassType="5";
		// }else
		// if("2".equals(contactGlassPos.get(0).getSopipglasstype())&&"3".equals(contactGlassPos.get(1).getSopipglasstype())){
		// contactGlassPos.add(0, null);
		// glassType="10";
		// }else
		// if("2".equals(contactGlassPos.get(0).getSopipglasstype())&&"4".equals(contactGlassPos.get(1).getSopipglasstype())){
		// contactGlassPos.add(0, null);
		// contactGlassPos.add(2,null);
		// glassType="7";
		// }else
		// if("3".equals(contactGlassPos.get(0).getSopipglasstype())&&"4".equals(contactGlassPos.get(1).getSopipglasstype())){
		// contactGlassPos.add(0, null);
		// contactGlassPos.add(1, null);
		// glassType="8";
		// }
		// }

		request.setAttribute("oldOptometryID", po1.getSopoyoptometryid());
		request.setAttribute("optometryBasicID", optometryBasicID);
		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		// request.setAttribute("glassType", glassType);
		return SUCCESS;
	}

	/*
	 * 接触镜评估调度
	 */
	public String contactGlassToolN() {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		// systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String source = Utility.getName(request.getParameter("source"));
		int count = 0;
		optometryPo = new OptometryPo();
		optometryPo.setSopoyoptometrybasicid(request
				.getParameter("optometryBasicID"));
		optometryPo.setSopoyoptometryid(request.getParameter("optometryID"));
		if (!"".equals(Utility.getName(request.getParameter("oldOptometryID")))) {
			optometryPo.setSopoyoptometryid(request
					.getParameter("oldOptometryID"));
			request.setAttribute("oldOptometryID", request
					.getParameter("oldOptometryID"));
		}
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecicustomerid(request.getParameter("customerID"));
		if ("contactGlassiou".equals(source)) {
			count = this.contactGlassHydsyMgr.getcontactGlassCount(optometryPo);

			if (count > 0) {
				return "contactGlassiouu";
			} else {
				return "contactGlassioui";
			}
		} else {
			optometryPo.setSopoyoptometryid(request
					.getParameter("oldOptometryID"));
			count = this.contactGlassHydsyMgr.getcontactGlassCount(optometryPo);
			return "contactGlasscopy";
		}
	}

	// /**
	// * 打印处方UPDATE
	// *
	// * */
	//	
	// public void contactGlassPrintN(){
	// String[] dayin = request.getParameterValues("dayin");
	// contactGlassHydsyMgr.contactGlassprint(dayin[0]);
	// }

	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}

	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}

	public DoubleEyeFunHydsyMgr getDoubleEyeFunHydsyMgr() {
		return doubleEyeFunHydsyMgr;
	}

	public void setDoubleEyeFunHydsyMgr(DoubleEyeFunHydsyMgr doubleEyeFunHydsyMgr) {
		this.doubleEyeFunHydsyMgr = doubleEyeFunHydsyMgr;
	}

	public RefractivePo getRefractivePo() {
		return refractivePo;
	}

	public void setRefractivePo(RefractivePo refractivePo) {
		this.refractivePo = refractivePo;
	}

	public RefractiveHydsyMgr getRefractiveHydsyMgr() {
		return refractiveHydsyMgr;
	}

	public void setRefractiveHydsyMgr(RefractiveHydsyMgr refractiveHydsyMgr) {
		this.refractiveHydsyMgr = refractiveHydsyMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public OptometryPo getOptometryPo() {
		return optometryPo;
	}

	public void setOptometryPo(OptometryPo optometryPo) {
		this.optometryPo = optometryPo;
	}

	public CustomerOptometryMgr getCustomerOptometryMgr() {
		return customerOptometryMgr;
	}

	public void setCustomerOptometryMgr(
			CustomerOptometryMgr customerOptometryMgr) {
		this.customerOptometryMgr = customerOptometryMgr;
	}

	public OptometryBasicHydsyMgr getOptometryBasicHydsyMgr() {
		return optometryBasicHydsyMgr;
	}

	public void setOptometryBasicHydsyMgr(OptometryBasicHydsyMgr optometryBasicHydsyMgr) {
		this.optometryBasicHydsyMgr = optometryBasicHydsyMgr;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public DoubleEyeFunPo getDoubleEyeFunPo() {
		return doubleEyeFunPo;
	}

	public void setDoubleEyeFunPo(DoubleEyeFunPo doubleEyeFunPo) {
		this.doubleEyeFunPo = doubleEyeFunPo;
	}

	public HealthCheckPo getHealthCheckPo() {
		return healthCheckPo;
	}

	public void setHealthCheckPo(HealthCheckPo healthCheckPo) {
		this.healthCheckPo = healthCheckPo;
	}

	// public SystemParameterPo getSystemParameterPo() {
	// return systemParameterPo;
	// }
	// public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
	// this.systemParameterPo = systemParameterPo;
	// }
	// public SystemParameterMgr getSystemParameterMgr() {
	// return systemParameterMgr;
	// }
	// public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr)
	// {
	// this.systemParameterMgr = systemParameterMgr;
	// }

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public ContactGlassHydsyMgr getContactGlassHydsyMgr() {
		return contactGlassHydsyMgr;
	}

	public void setContactGlassHydsyMgr(ContactGlassHydsyMgr contactGlassHydsyMgr) {
		this.contactGlassHydsyMgr = contactGlassHydsyMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	public List<ContactGlassPo> getContactGlassPos() {
		return contactGlassPos;
	}

	public void setContactGlassPos(List<ContactGlassPo> contactGlassPos) {
		this.contactGlassPos = contactGlassPos;
	}

	public ContactGlassPo getContactGlassPo() {
		return contactGlassPo;
	}

	public void setContactGlassPo(ContactGlassPo contactGlassPo) {
		this.contactGlassPo = contactGlassPo;
	}

	public OptometryBasicPo getOptometryBasicPo() {
		return optometryBasicPo;
	}

	public void setOptometryBasicPo(OptometryBasicPo optometryBasicPo) {
		this.optometryBasicPo = optometryBasicPo;
	}

	public InspectionPo getInspectionPo() {
		return inspectionPo;
	}

	public void setInspectionPo(InspectionPo inspectionPo) {
		this.inspectionPo = inspectionPo;
	}

	public List<InspectionPo> getInspectionPos() {
		return inspectionPos;
	}

	public void setInspectionPos(List<InspectionPo> inspectionPos) {
		this.inspectionPos = inspectionPos;
	}

	public List<CornealContactlLensPo> getCornealContactlLensPos() {
		return cornealContactlLensPos;
	}

	public void setCornealContactlLensPos(
			List<CornealContactlLensPo> cornealContactlLensPos) {
		this.cornealContactlLensPos = cornealContactlLensPos;
	}

	public CornealContactlLensPo getCornealContactlLensPo() {
		return cornealContactlLensPo;
	}

	public void setCornealContactlLensPo(
			CornealContactlLensPo cornealContactlLensPo) {
		this.cornealContactlLensPo = cornealContactlLensPo;
	}

	public EyesCheckHydsyMgr getEyesCheckHydsyMgr() {
		return eyesCheckHydsyMgr;
	}

	public void setEyesCheckHydsyMgr(EyesCheckHydsyMgr eyesCheckHydsyMgr) {
		this.eyesCheckHydsyMgr = eyesCheckHydsyMgr;
	}

	public List<OptionParamPo> getOptionParamPolist() {
		return optionParamPolist;
	}

	public void setOptionParamPolist(List<OptionParamPo> optionParamPolist) {
		this.optionParamPolist = optionParamPolist;
	}

	public OptionParamMgr getOptionParamMgr() {
		return optionParamMgr;
	}

	public void setOptionParamMgr(OptionParamMgr optionParamMgr) {
		this.optionParamMgr = optionParamMgr;
	}
}
