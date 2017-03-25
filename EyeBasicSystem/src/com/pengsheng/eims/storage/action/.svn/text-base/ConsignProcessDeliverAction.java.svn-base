package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.ConsignProcessDeliverMgr;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsTempPo;
import com.pengsheng.eims.storage.persistence.DeliverEntryPo;
import com.pengsheng.eims.storage.persistence.DeliverPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * 委外送货action
 */
public class ConsignProcessDeliverAction extends BaseAction {

	private DeliverPo deliverPo;

	private List<DeliverPo> deliverList;

	private List<DeliverEntryPo> deliverEntryList;

	private PersonPermissionMgr personPermissionMgr;

	private ConsignProcessDeliverMgr consignProcessDeliverMgr;

	List<ConsignProcessOrderDetailsPo> consignProcessOrderDetailsList;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	
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

	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderDetailsList() {
		return consignProcessOrderDetailsList;
	}

	public void setConsignProcessOrderDetailsList(
			List<ConsignProcessOrderDetailsPo> consignProcessOrderDetailsList) {
		this.consignProcessOrderDetailsList = consignProcessOrderDetailsList;
	}

	public List<DeliverEntryPo> getDeliverEntryList() {
		return deliverEntryList;
	}

	public void setDeliverEntryList(List<DeliverEntryPo> deliverEntryList) {
		this.deliverEntryList = deliverEntryList;
	}

	private ConsignProcessOrderDetailsTempPo consignProcessOrderDetailsTempPo;

	public ConsignProcessOrderDetailsTempPo getConsignProcessOrderDetailsTempPo() {
		return consignProcessOrderDetailsTempPo;
	}

	public void setConsignProcessOrderDetailsTempPo(
			ConsignProcessOrderDetailsTempPo consignProcessOrderDetailsTempPo) {
		this.consignProcessOrderDetailsTempPo = consignProcessOrderDetailsTempPo;
	}

	public DeliverPo getDeliverPo() {
		return deliverPo;
	}

	public void setDeliverPo(DeliverPo deliverPo) {
		this.deliverPo = deliverPo;
	}

	public List<DeliverPo> getDeliverList() {
		return deliverList;
	}

	public void setDeliverList(List<DeliverPo> deliverList) {
		this.deliverList = deliverList;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public ConsignProcessDeliverMgr getConsignProcessDeliverMgr() {
		return consignProcessDeliverMgr;
	}

	public void setConsignProcessDeliverMgr(
			ConsignProcessDeliverMgr consignProcessDeliverMgr) {
		this.consignProcessDeliverMgr = consignProcessDeliverMgr;
	}

	/**
	 * 初始化委外送货查询
	 */
	public String initConsignProcessDeliverSel() throws Exception {

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

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selConsignProcessDeliver";
		}
		
		return SUCCESS;
	}

	/**
	 * 委外送货查询
	 */
	public String selConsignProcessDeliver() throws Exception {

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

		String billID = Utility.getName(request.getParameter("billID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String createPersonName = Utility.getName(request
				.getParameter("createPersonName"));
		String auditPersonName = Utility.getName(request
				.getParameter("auditPersonName"));


		deliverPo = new DeliverPo();

		deliverPo.setCstddeliverbillid(billID);
		deliverPo.setCstdstarttime(startTime);
		deliverPo.setCstdendtime(endTime);
		deliverPo.setCstdauditstate(auditState);
		deliverPo.setCstdcreateperson(createPersonName);
		deliverPo.setCstdauditperson(auditPersonName);
		deliverPo.setCstdauditstate(auditState);

		int count = consignProcessDeliverMgr
				.getConsignProcessDeliverCount(deliverPo);

		if (count > 0) {
			
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
			deliverList = consignProcessDeliverMgr
					.getConsignProcessDeliverList(deliverPo, page.getStart(),
							page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			deliverList = null;
		}

		request.setAttribute("billID", billID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("auditState", auditState);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("auditPersonName", auditPersonName);
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));

		return SUCCESS;
	}

	/**
	 * 初始化委外送货新增
	 */
	public String initConsignProcessDeliverInsert() throws Exception {
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
		String billID = "SH" + GenerateNumber.getInstance().getGenerageNumber();

		deliverPo = new DeliverPo();
		deliverPo.setCstddeliverbillid(billID);

		return SUCCESS;
	}

	/**
	 * 委外送货新增
	 */
	public String insertConsignProcessDeliver() throws Exception {
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
		if ("1".equals(request.getParameter("stateFlag"))) {
			deliverPo.setCstdauditstate("1");
			deliverPo.setCstdauditperson(((PersonInfoPo) session.get("person"))
					.getId());
		} else {
			deliverPo.setCstdauditstate("0");
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent(deliverPo.getCstddeliverbillid());
		int lenth = consignProcessOrderDetailsTempPo.getCstcpodglassesbillid().length;

		deliverEntryList = new ArrayList<DeliverEntryPo>();

		for (int i = 0; i < lenth; i++) {

			DeliverEntryPo deliverEntryPo = new DeliverEntryPo();

			deliverEntryPo.setCstdedeliverbillid(deliverPo
					.getCstddeliverbillid());
			deliverEntryPo
					.setCstdereceiptbillid(consignProcessOrderDetailsTempPo
							.getCstcprdreceiptbilld()[i]);
			deliverEntryPo
					.setCstdeorderdetailsid(consignProcessOrderDetailsTempPo
							.getCstcpodid()[i]);
			deliverEntryPo
					.setCstdeglassesbillid(consignProcessOrderDetailsTempPo
							.getCstcpodglassesbillid()[i]);
			deliverEntryPo.setCstdegoodsid(consignProcessOrderDetailsTempPo
					.getCstcpodgoodsid()[i]);
			deliverEntryPo.setCstdebarcode(consignProcessOrderDetailsTempPo
					.getCstcpodgoodsbarcode()[i]);
			deliverEntryPo.setCstdenum(consignProcessOrderDetailsTempPo
					.getCstcpodnum()[i]);

			deliverEntryList.add(deliverEntryPo);
		}
		consignProcessDeliverMgr.insertConsignProcessDeliver(deliverPo,deliverEntryList,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化委外送货修改
	 */
	public String initConsignProcessDeliverUpdate() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));

		DeliverPo po = new DeliverPo();
		po.setCstddeliverbillid(id);

		deliverPo = consignProcessDeliverMgr.getConsignProcessDeliver(po);

		consignProcessOrderDetailsList = consignProcessDeliverMgr
				.getConsignProcessDeliverEntryList(po);

		return SUCCESS;
	}

	/**
	 * 修改委外送货
	 */
	public String updateConsignProcessDeliver() throws Exception {
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
		if ("1".equals(request.getParameter("stateFlag"))) {
			deliverPo.setCstdauditstate("1");
			deliverPo.setCstdauditperson(((PersonInfoPo) session.get("person"))
					.getId());
		} else {
			deliverPo.setCstdauditstate("0");
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent(deliverPo.getCstddeliverbillid());
		int lenth = consignProcessOrderDetailsTempPo.getCstcpodglassesbillid().length;

		deliverEntryList = new ArrayList<DeliverEntryPo>();

		for (int i = 0; i < lenth; i++) {

			DeliverEntryPo deliverEntryPo = new DeliverEntryPo();

			deliverEntryPo.setCstdedeliverbillid(deliverPo
					.getCstddeliverbillid());
			deliverEntryPo
					.setCstdereceiptbillid(consignProcessOrderDetailsTempPo
							.getCstcprdreceiptbilld()[i]);
			deliverEntryPo
					.setCstdeorderdetailsid(consignProcessOrderDetailsTempPo
							.getCstcpodid()[i]);
			deliverEntryPo
					.setCstdeglassesbillid(consignProcessOrderDetailsTempPo
							.getCstcpodglassesbillid()[i]);
			deliverEntryPo.setCstdegoodsid(consignProcessOrderDetailsTempPo
					.getCstcpodgoodsid()[i]);
			deliverEntryPo.setCstdebarcode(consignProcessOrderDetailsTempPo
					.getCstcpodgoodsbarcode()[i]);
			deliverEntryPo.setCstdenum(consignProcessOrderDetailsTempPo
					.getCstcpodnum()[i]);

			deliverEntryList.add(deliverEntryPo);
		}

		consignProcessDeliverMgr.updateConsignProcessDeliver(deliverPo,
				deliverEntryList,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化委外送货删除
	 */
	public String initConsignProcessDeliverDelete() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));

		deliverPo = new DeliverPo();
		deliverPo.setCstddeliverbillid(id);
		deliverPo = consignProcessDeliverMgr
				.getConsignProcessDeliver(deliverPo);

		return SUCCESS;
	}

	/**
	 * 删除委外送货
	 */
	public String deleteConsignProcessDeliver() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent(id);

		deliverPo = new DeliverPo();
		deliverPo.setCstddeliverbillid(id);

		consignProcessDeliverMgr.deleteConsignProcessDeliver(deliverPo,logPo);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 查看委外送货明细
	 */
	public String consignProcessDeliverDetails() throws Exception {

		String id = Utility.getName(request.getParameter("hid"));

		DeliverPo po = new DeliverPo();
		po.setCstddeliverbillid(id);

		deliverPo = consignProcessDeliverMgr.getConsignProcessDeliver(po);

		consignProcessOrderDetailsList = consignProcessDeliverMgr
				.getConsignProcessDeliverEntryList(po);

		return SUCCESS;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}
}
