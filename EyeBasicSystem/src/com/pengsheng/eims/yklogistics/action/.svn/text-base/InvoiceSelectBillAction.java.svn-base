package com.pengsheng.eims.yklogistics.action;

import java.util.List;

import com.pengsheng.eims.yklogistics.mgr.InvoiceSelectBillMgr;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

@SuppressWarnings("serial")
public class InvoiceSelectBillAction extends BaseAction {

	private InvoiceSelectBillMgr ykinvoiceSelectBillMgr = null;	
	private List<InventoryPo> selectBillList = null;	
	private InventoryPo inventoryPo = null;	
	private List<InventoryEntryPo> invoiceInEntryList = null;
	private InvoicePo invoicePo = null;	
	private PersonPermissionMgr personPermissionMgr = null;	
	
	/**
	 * 模块：发票管理
	 * 描述：单据查询中查看单据
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String initBillInfoSel(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String billid = Utility.getName(request.getParameter("hid"));
		
		InventoryPo inPo = new InventoryPo();
		inPo.setCstibillid(billid);		
		InventoryEntryPo inEntryPo = new InventoryEntryPo();
		inEntryPo.setCstiebillid(billid);
		
		inventoryPo = ykinvoiceSelectBillMgr.getBill(inPo);		
		invoiceInEntryList = ykinvoiceSelectBillMgr.getBillEntry(inEntryPo);
		
		billid = null;
		inPo = null;
		inEntryPo = null;
		
		return SUCCESS;
	}
	
	/**
	 * 模块：发票管理
	 * 描述：新增发票查询需核销的单据开窗
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String initSelectBillSel(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
	    String supplierName = Utility.getName(request.getParameter("supplierName"));
		String billID = Utility.getName(request.getParameter("billID"));
	    String billStringID = Utility.getName(request.getParameter("billStringID"));
	    String billtype = Utility.getName(request.getParameter("typeid"));
	    String invoiceType = Utility.getName(request.getParameter("invoiceType"));
	    
	    String invoiceStartDate = Utility.getName(request.getParameter("invoiceStartDate"));
	    String invoiceEndDate = Utility.getName(request.getParameter("invoiceEndDate"));
		request.setAttribute("invoiceStartDate", invoiceStartDate);
		request.setAttribute("invoiceEndDate", invoiceEndDate);
		
		request.setAttribute("billID",billID);		
		request.setAttribute("billStringID",billStringID);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("supplierName" , supplierName);
	    request.setAttribute("billtype" , billtype);
	    request.setAttribute("invoiceType" , invoiceType);
	    
	    supplierID = null;
	    supplierName = null;
	    billID = null;
	    billStringID = null;
	    billtype = null;
	    invoiceType = null;
	    
		return SUCCESS;
	}	
	
	/**
	 * 模块：发票管理
	 * 描述：新增发票时查询需核销的单据
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String selectSelectBill(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String billid = Utility.getName(request.getParameter("billid"));
		String begintime = Utility.getName(request.getParameter("begintime"));
		String endtime = Utility.getName(request.getParameter("endtime"));
		String billtype = Utility.getName(request.getParameter("billtype"));
		String invoiceState = Utility.getName(request.getParameter("invoiceState"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
	    String supplierName = Utility.getName(request.getParameter("supplierName"));
	    String invoiceType = Utility.getName(request.getParameter("invoiceType"));
	    
	    String invoiceStartDate = Utility.getName(request.getParameter("invoiceStartDate"));
	    String invoiceEndDate = Utility.getName(request.getParameter("invoiceEndDate"));
		request.setAttribute("invoiceStartDate", invoiceStartDate);
		request.setAttribute("invoiceEndDate", invoiceEndDate);
		
	    InventoryPo inPo = new InventoryPo();
	    inPo.setCstibillid(billid);
	    inPo.setCstistartTime(begintime);
	    inPo.setCstiendTime(endtime);
	    inPo.setCstibilltypeid(billtype);
	    inPo.setCstiinvoicestate(invoiceState);
	    inPo.setCstisupplierid(supplierID);
	    
	    request.setAttribute("billStringID" , billid);
	    request.setAttribute("billID" , billid);
	    request.setAttribute("begintime" , begintime);
	    request.setAttribute("endtime" , endtime);
	    request.setAttribute("billtype" , billtype);
	    request.setAttribute("invoiceState" , invoiceState);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("supplierName" , supplierName);
	    request.setAttribute("invoiceType" , invoiceType);
	    
		int count = ykinvoiceSelectBillMgr.getSelectBillCount(inPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = 100;
				}
			} else {
				perPage = 100;
			}
			Pagination page = new Pagination(request, count, perPage);			
			selectBillList = ykinvoiceSelectBillMgr.selectSelectBill(inPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			selectBillList = null;
		}
		
		billid = null;
		begintime =  null;
		endtime = null;
		billtype = null;
		invoiceState = null;
		supplierID = null;
	    supplierName = null;
	    inPo = null;
	    
		return SUCCESS;
	}
	
	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}
	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}
	public List<InventoryEntryPo> getInvoiceInEntryList() {
		return invoiceInEntryList;
	}
	public void setInvoiceInEntryList(List<InventoryEntryPo> invoiceInEntryList) {
		this.invoiceInEntryList = invoiceInEntryList;
	}
	public List<InventoryPo> getSelectBillList() {
		return selectBillList;
	}
	public void setSelectBillList(List<InventoryPo> selectBillList) {
		this.selectBillList = selectBillList;
	}
	public InvoicePo getInvoicePo() {
		return invoicePo;
	}
	public void setInvoicePo(InvoicePo invoicePo) {
		this.invoicePo = invoicePo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public InvoiceSelectBillMgr getYkinvoiceSelectBillMgr() {
		return ykinvoiceSelectBillMgr;
	}

	public void setYkinvoiceSelectBillMgr(
			InvoiceSelectBillMgr ykinvoiceSelectBillMgr) {
		this.ykinvoiceSelectBillMgr = ykinvoiceSelectBillMgr;
	}
	
}
