package com.pengsheng.eims.storage.action;

import java.util.List;

import com.pengsheng.eims.storage.mgr.ConsignProcessOrderStatusMgr;
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

public class ConsignProcessOrderStatusAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;

	private ConsignProcessOrderStatusMgr consignProcessOrderStatusMgr;

	private List<ProcurementOrdersPo> consignProcessOrderStatusList;

	private List<ProcurementSendPo> consignProcessSendList;

	private ProcurementOrdersPo procurementOrdersPo;

	private ProcurementSendPo procurementSendPo;

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

	public List<ProcurementSendEntryPo> getSendEntryList() {
		return sendEntryList;
	}

	public void setSendEntryList(List<ProcurementSendEntryPo> sendEntryList) {
		this.sendEntryList = sendEntryList;
	}

	public List<ProcurementOrderEntryPo> getOrderEntryList() {
		return orderEntryList;
	}

	public void setOrderEntryList(List<ProcurementOrderEntryPo> orderEntryList) {
		this.orderEntryList = orderEntryList;
	}

	public ProcurementSendPo getProcurementSendPo() {
		return procurementSendPo;
	}

	public void setProcurementSendPo(ProcurementSendPo procurementSendPo) {
		this.procurementSendPo = procurementSendPo;
	}

	public ProcurementOrdersPo getProcurementOrdersPo() {
		return procurementOrdersPo;
	}

	public void setProcurementOrdersPo(ProcurementOrdersPo procurementOrdersPo) {
		this.procurementOrdersPo = procurementOrdersPo;
	}

	public List<ProcurementSendPo> getConsignProcessSendList() {
		return consignProcessSendList;
	}

	public void setConsignProcessSendList(
			List<ProcurementSendPo> consignProcessSendList) {
		this.consignProcessSendList = consignProcessSendList;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public ConsignProcessOrderStatusMgr getConsignProcessOrderStatusMgr() {
		return consignProcessOrderStatusMgr;
	}

	public void setConsignProcessOrderStatusMgr(
			ConsignProcessOrderStatusMgr consignProcessOrderStatusMgr) {
		this.consignProcessOrderStatusMgr = consignProcessOrderStatusMgr;
	}

	public List<ProcurementOrdersPo> getConsignProcessOrderStatusList() {
		return consignProcessOrderStatusList;
	}

	public void setConsignProcessOrderStatusList(
			List<ProcurementOrdersPo> consignProcessOrderStatusList) {
		this.consignProcessOrderStatusList = consignProcessOrderStatusList;
	}

	/**
	 * 初始化委外订单状态查询页面
	 * 
	 * @return
	 */
	public String initConsignProcessOrderStatusSel() {
		
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
	 * 查询委外订单状态信息
	 * 
	 * @return
	 */
	public String selectConsignProcessOrderStatus() {
		
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
		companyNamePo = consignProcessOrderStatusMgr
				.getCompanyId(companyNamePo);

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

		int count = consignProcessOrderStatusMgr
				.getConsignProcessOrderStatusCount(procurementOrdersPo);
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
			consignProcessOrderStatusList = consignProcessOrderStatusMgr
					.selectConsignProcessOrderStatus(procurementOrdersPo, page
							.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			consignProcessOrderStatusList = null;
		}

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.eims);// 设置为eims数据源

		return SUCCESS;
	}

	/**
	 * 订单详细开窗
	 * 
	 * @return
	 */
	public String selectConsignProcessSend() {
		String ordersid = Utility.getName(request.getParameter("hid"));

		ProcurementOrdersPo ordersPo = new ProcurementOrdersPo();
		ordersPo.setCstpid(ordersid);

		ProcurementSendPo sendPo = new ProcurementSendPo();
		sendPo.setCstdpoid(ordersid);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.orders);// 设置为orders数据源

		procurementOrdersPo = consignProcessOrderStatusMgr
				.getConsignProcessOrderStatus(ordersPo);

		consignProcessSendList = consignProcessOrderStatusMgr
				.selectConsignProcessSend(sendPo);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.eims);// 设置为eims数据源

		return SUCCESS;
	}

	/**
	 * 订单明细开窗
	 * 
	 * @return
	 */
	public String selectConsignProcessOrdersDetaile() {
		String ordersid = Utility.getName(request.getParameter("hid"));

		ProcurementOrdersPo ordersPo = new ProcurementOrdersPo();
		ordersPo.setCstpid(ordersid);

		ProcurementOrderEntryPo orderEntryPo = new ProcurementOrderEntryPo();
		orderEntryPo.setCstpepoid(ordersid);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.orders);// 设置为orders数据源

		procurementOrdersPo = consignProcessOrderStatusMgr
				.getConsignProcessOrderStatus(ordersPo);

		orderEntryList = consignProcessOrderStatusMgr
				.selectOrderDetaile(orderEntryPo);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.eims);// 设置为eims数据源

		return SUCCESS;
	}

	/**
	 * 订单发货明细开窗
	 * 
	 * @return
	 */
	public String selectConsignProcessSendDetaile() {
		String sendid = Utility.getName(request.getParameter("hid"));

		ProcurementSendPo sendPo = new ProcurementSendPo();
		sendPo.setCstdid(sendid);

		ProcurementSendEntryPo sendEntryPo = new ProcurementSendEntryPo();
		sendEntryPo.setCstdedeliveryid(sendid);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.orders);// 设置为orders数据源

		procurementSendPo = consignProcessOrderStatusMgr.getConsginSend(sendPo);

		sendEntryList = consignProcessOrderStatusMgr
				.selectSendDetaile(sendEntryPo);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.eims);// 设置为eims数据源

		return SUCCESS;
	}

}
