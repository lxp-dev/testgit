package com.pengsheng.eims.storage.action;

import java.util.List;

import com.pengsheng.eims.storage.mgr.ProcurementOrdersStatusMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.orders.storage.persistence.ProcurementOrderEntryPo;
import com.pengsheng.orders.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.orders.storage.persistence.ProcurementSendEntryPo;
import com.pengsheng.orders.storage.persistence.ProcurementSendPo;

public class ProcurementOrdersStatusAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;

	private ProcurementOrdersStatusMgr procurementOrdersStatusMgr;

	private List<ProcurementOrdersPo> procurementOrdersStatusList;

	private ProcurementOrdersPo procurementOrdersPo;

	private ProcurementSendPo procurementSendPo;

	private List<ProcurementSendPo> procurementSendList;

	private List<ProcurementOrderEntryPo> orderEntryList;

	private List<ProcurementSendEntryPo> sendEntryList;

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
	public ProcurementOrdersPo getProcurementOrdersPo() {
		return procurementOrdersPo;
	}

	public void setProcurementOrdersPo(ProcurementOrdersPo procurementOrdersPo) {
		this.procurementOrdersPo = procurementOrdersPo;
	}

	public ProcurementSendPo getProcurementSendPo() {
		return procurementSendPo;
	}

	public void setProcurementSendPo(ProcurementSendPo procurementSendPo) {
		this.procurementSendPo = procurementSendPo;
	}

	public List<ProcurementSendPo> getProcurementSendList() {
		return procurementSendList;
	}

	public void setProcurementSendList(
			List<ProcurementSendPo> procurementSendList) {
		this.procurementSendList = procurementSendList;
	}

	public List<ProcurementOrderEntryPo> getOrderEntryList() {
		return orderEntryList;
	}

	public void setOrderEntryList(List<ProcurementOrderEntryPo> orderEntryList) {
		this.orderEntryList = orderEntryList;
	}

	public List<ProcurementSendEntryPo> getSendEntryList() {
		return sendEntryList;
	}

	public void setSendEntryList(List<ProcurementSendEntryPo> sendEntryList) {
		this.sendEntryList = sendEntryList;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public ProcurementOrdersStatusMgr getProcurementOrdersStatusMgr() {
		return procurementOrdersStatusMgr;
	}

	public void setProcurementOrdersStatusMgr(
			ProcurementOrdersStatusMgr procurementOrdersStatusMgr) {
		this.procurementOrdersStatusMgr = procurementOrdersStatusMgr;
	}

	public List<ProcurementOrdersPo> getProcurementOrdersStatusList() {
		return procurementOrdersStatusList;
	}

	public void setProcurementOrdersStatusList(
			List<ProcurementOrdersPo> procurementOrdersStatusList) {
		this.procurementOrdersStatusList = procurementOrdersStatusList;
	}

	/**
	 * 初始化订单状态查询页面
	 * 
	 * @return
	 */
	public String initProcurementOrdersStatusSel() {

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
	 * 查询订单状态信息
	 * 
	 * @return
	 */
	public String selectProcurementOrdersStatus() {

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

		CompanyNamePo companyNamePo = new CompanyNamePo();
		companyNamePo = procurementOrdersStatusMgr.getCompanyId(companyNamePo);

		String billID = Utility.getName(request.getParameter("billID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String suppliername = Utility.getName(request
				.getParameter("suppliername"));
		String supplierid = Utility.getName(request.getParameter("supplierid"));
		String auditstate = Utility.getName(request.getParameter("auditstate"));

		ProcurementOrdersPo procurementOrdersPo = new ProcurementOrdersPo();
		procurementOrdersPo.setCstpid(billID);
		procurementOrdersPo.setCstpbillstartdate(startTime);
		procurementOrdersPo.setCstpbillenddate(endTime);
		procurementOrdersPo.setCstpsuppliername(suppliername);
		procurementOrdersPo.setCstpsupplierid(supplierid);
		procurementOrdersPo.setCstpauditstate(auditstate);
		procurementOrdersPo.setCstpcompanyid(companyNamePo.getFcnId());

		request.setAttribute("billID", billID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("suppliername", suppliername);
		request.setAttribute("supplierid", supplierid);
		request.setAttribute("auditstate", auditstate);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.orders);// 设置为orders数据源

		int count = procurementOrdersStatusMgr
				.getProcurementOrdersStatusCount(procurementOrdersPo);
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
			procurementOrdersStatusList = procurementOrdersStatusMgr
					.selectProcurementOrdersStatus(procurementOrdersPo, page
							.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			procurementOrdersStatusList = null;
		}

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.eims);// 设置为eims数据源

		return SUCCESS;
	}

	/**
	 * 采购订单详细开窗
	 * 
	 * @return
	 */
	public String selectProcurementSend() {
		String ordersid = Utility.getName(request.getParameter("hid"));
		String deliveryid = Utility.getName(request.getParameter("deliveryid"));

		ProcurementOrdersPo ordersPo = new ProcurementOrdersPo();
		ordersPo.setCstpid(ordersid);

		ProcurementSendPo sendPo = new ProcurementSendPo();
		sendPo.setCstdpoid(ordersid);

		procurementOrdersPo = new ProcurementOrdersPo();

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.orders);// 设置为orders数据源

		procurementOrdersPo = procurementOrdersStatusMgr
				.getProcurementOrderStatus(ordersPo);

		procurementSendList = procurementOrdersStatusMgr
				.selectProcurementSend(sendPo);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.eims);// 设置为eims数据源

		return SUCCESS;
	}

	/**
	 * 采购订单明细开窗
	 * 
	 * @return
	 */
	public String selectProcurementOrdersDetaile() {
		String ordersid = Utility.getName(request.getParameter("hid"));

		ProcurementOrdersPo ordersPo = new ProcurementOrdersPo();
		ordersPo.setCstpid(ordersid);

		ProcurementOrderEntryPo orderEntryPo = new ProcurementOrderEntryPo();
		orderEntryPo.setCstpepoid(ordersid);

		procurementOrdersPo = new ProcurementOrdersPo();

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.orders);// 设置为orders数据源

		procurementOrdersPo = procurementOrdersStatusMgr
				.getProcurementOrderStatus(ordersPo);

		orderEntryList = procurementOrdersStatusMgr
				.selectOrderDetaile(orderEntryPo);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.eims);// 设置为eims数据源

		return SUCCESS;
	}

	/**
	 * 采购订单发货明细开窗
	 * 
	 * @return
	 */
	public String selectProcurementSendDetaile() {
		String sendid = Utility.getName(request.getParameter("hid"));

		ProcurementSendPo sendPo = new ProcurementSendPo();
		sendPo.setCstdid(sendid);

		ProcurementSendEntryPo sendEntryPo = new ProcurementSendEntryPo();
		sendEntryPo.setCstdedeliveryid(sendid);

		procurementSendPo = new ProcurementSendPo();

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.orders);// 设置为orders数据源

		procurementSendPo = procurementOrdersStatusMgr
				.getProcurementSend(sendPo);

		sendEntryList = procurementOrdersStatusMgr
				.selectSendDetaile(sendEntryPo);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.eims);// 设置为eims数据源

		return SUCCESS;
	}

}
