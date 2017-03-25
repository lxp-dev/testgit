package com.pengsheng.eims.storage.action;

import java.util.List;

import com.pengsheng.eims.storage.mgr.OrdersStatusReturnMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.orders.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.orders.storage.persistence.ReturnsEntryPo;
import com.pengsheng.orders.storage.persistence.ReturnsPo;

public class OrdersStatusReturnAction extends BaseAction {

	private OrdersStatusReturnMgr ordersStatusReturnMgr;

	private PersonPermissionMgr personPermissionMgr;

	private List<ReturnsPo> ordersStatusReturnList;

	private ReturnsPo rePo;

	private List<ReturnsEntryPo> reEntryList;
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

	public OrdersStatusReturnMgr getOrdersStatusReturnMgr() {
		return ordersStatusReturnMgr;
	}

	public void setOrdersStatusReturnMgr(
			OrdersStatusReturnMgr ordersStatusReturnMgr) {
		this.ordersStatusReturnMgr = ordersStatusReturnMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<ReturnsPo> getOrdersStatusReturnList() {
		return ordersStatusReturnList;
	}

	public void setOrdersStatusReturnList(List<ReturnsPo> ordersStatusReturnList) {
		this.ordersStatusReturnList = ordersStatusReturnList;
	}

	public ReturnsPo getRePo() {
		return rePo;
	}

	public void setRePo(ReturnsPo rePo) {
		this.rePo = rePo;
	}

	public List<ReturnsEntryPo> getReEntryList() {
		return reEntryList;
	}

	public void setReEntryList(List<ReturnsEntryPo> reEntryList) {
		this.reEntryList = reEntryList;
	}

	/**
	 * 初始化退货状态查询页面
	 * 
	 * @return
	 */
	public String initOrdersStatusReturnSel() {
		
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
	 * 查询退货状态信息
	 * 
	 * @return
	 */
	public String selectOrdersStatusReturn() {

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
		companyNamePo = ordersStatusReturnMgr.getCompanyId(companyNamePo);

		String billID = Utility.getName(request.getParameter("billID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String suppliername = Utility.getName(request
				.getParameter("suppliername"));
		String supplierid = Utility.getName(request.getParameter("supplierid"));
		String auditstate = Utility.getName(request.getParameter("auditstate"));

		ReturnsPo returnsPo = new ReturnsPo();
		returnsPo.setCstrid(billID);
		returnsPo.setCstrbillstartdate(startTime);
		returnsPo.setCstrbillenddate(endTime);
		returnsPo.setCstrsuppliername(suppliername);
		returnsPo.setCstrsupplierid(supplierid);
		returnsPo.setCstrauditstate(auditstate);
		returnsPo.setCstrcompanyid(companyNamePo.getFcnId());

		request.setAttribute("billID", billID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("suppliername", suppliername);
		request.setAttribute("supplierid", supplierid);
		request.setAttribute("auditstate", auditstate);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.orders);// 设置为orders数据源

		int count = ordersStatusReturnMgr.getOrdersStatusReturnCount(returnsPo);
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
			ordersStatusReturnList = ordersStatusReturnMgr
					.selectOrdersStatusReturn(returnsPo, page.getStart(), page
							.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			ordersStatusReturnList = null;
		}

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.eims);// 设置为eims数据源

		return SUCCESS;
	}

	/**
	 * 退货状态明细查询
	 * 
	 * @return
	 */
	public String selectOrdersStatusReturnDetaile() {

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

		String ordersid = Utility.getName(request.getParameter("hid"));

		ReturnsPo returnsPo = new ReturnsPo();
		returnsPo.setCstrid(ordersid);

		ReturnsEntryPo returnsEntryPo = new ReturnsEntryPo();
		returnsEntryPo.setCstrereturnsid(ordersid);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.orders);// 设置为orders数据源

		rePo = ordersStatusReturnMgr.getOrdersStatusDetaile(returnsPo);

		reEntryList = ordersStatusReturnMgr
				.selectOrdersStatusDetaile(returnsEntryPo);

		// 切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.eims);// 设置为eims数据源

		return SUCCESS;
	}

}
