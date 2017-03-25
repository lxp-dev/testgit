package com.pengsheng.eims.logistics.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.mgr.InvoiceMgr;
import com.pengsheng.eims.logistics.mgr.ProofSelectBillMgr;
import com.pengsheng.eims.logistics.mgr.VoucherMgr;
import com.pengsheng.eims.logistics.persistence.InvoiceTypePo;
import com.pengsheng.eims.logistics.persistence.SalesShopPo;
import com.pengsheng.eims.logistics.persistence.VoucherTypePo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ProofSelectBillAction extends BaseAction {

	private ProofSelectBillMgr proofSelectBillMgr;	
	private List<InventoryPo> selectBillList;	
	private InventoryPo inventoryPo;	
	private List<InventoryEntryPo> proofInEntryList;	
	private VoucherMgr voucherMgr = null;
	private List<VoucherTypePo> voucherTopIDList = null;
	private List<VoucherTypePo> voucherSubsetIDList = null;
	private List<SalesShopPo> salesShopList = null;	   
	private List<WarehousePo> warehouselist;	
	private WarehouseMgr warehouseMgr;	
	private List<InventoryPo> overagelossesList;	
	private List<InventoryEntryPo> inventoryEntryList;	
	private InventoryPo overagelossesPo;
	private PersonPermissionMgr personPermissionMgr = null;
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

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public List<InvoiceTypePo> getInvoiceTypeList() {
		return invoiceTypeList;
	}

	public void setInvoiceTypeList(List<InvoiceTypePo> invoiceTypeList) {
		this.invoiceTypeList = invoiceTypeList;
	}

	public InvoiceMgr getInvoiceMgr() {
		return invoiceMgr;
	}

	public void setInvoiceMgr(InvoiceMgr invoiceMgr) {
		this.invoiceMgr = invoiceMgr;
	}

	private List<InvoiceTypePo> invoiceTypeList = null;
	private InvoiceMgr invoiceMgr = null;
	
	public List<SalesShopPo> getSalesShopList() {
		return salesShopList;
	}

	public void setSalesShopList(List<SalesShopPo> salesShopList) {
		this.salesShopList = salesShopList;
	}

	public List<InventoryEntryPo> getInventoryEntryList() {
		return inventoryEntryList;
	}

	public void setInventoryEntryList(List<InventoryEntryPo> inventoryEntryList) {
		this.inventoryEntryList = inventoryEntryList;
	}

	public InventoryPo getOveragelossesPo() {
		return overagelossesPo;
	}

	public void setOveragelossesPo(InventoryPo overagelossesPo) {
		this.overagelossesPo = overagelossesPo;
	}

	public List<InventoryPo> getOveragelossesList() {
		return overagelossesList;
	}

	public void setOveragelossesList(List<InventoryPo> overagelossesList) {
		this.overagelossesList = overagelossesList;
	}

	public List<WarehousePo> getWarehouselist() {
		return warehouselist;
	}

	public void setWarehouselist(List<WarehousePo> warehouselist) {
		this.warehouselist = warehouselist;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public List<VoucherTypePo> getVoucherSubsetIDList() {
		return voucherSubsetIDList;
	}

	public void setVoucherSubsetIDList(List<VoucherTypePo> voucherSubsetIDList) {
		this.voucherSubsetIDList = voucherSubsetIDList;
	}

	public VoucherMgr getVoucherMgr() {
		return voucherMgr;
	}

	public void setVoucherMgr(VoucherMgr voucherMgr) {
		this.voucherMgr = voucherMgr;
	}

	public List<VoucherTypePo> getVoucherTopIDList() {
		return voucherTopIDList;
	}

	public void setVoucherTopIDList(List<VoucherTypePo> voucherTopIDList) {
		this.voucherTopIDList = voucherTopIDList;
	}
	
	private VoucherPo po = null;


	public ProofSelectBillMgr getProofSelectBillMgr() {
		return proofSelectBillMgr;
	}

	public void setProofSelectBillMgr(ProofSelectBillMgr proofSelectBillMgr) {
		this.proofSelectBillMgr = proofSelectBillMgr;
	}

	public List<InventoryPo> getSelectBillList() { 
		return selectBillList;
	}

	public void setSelectBillList(List<InventoryPo> selectBillList) {
		this.selectBillList = selectBillList;
	}

	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}

	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}

	public List<InventoryEntryPo> getProofInEntryList() {
		return proofInEntryList;
	}

	public void setProofInEntryList(List<InventoryEntryPo> proofInEntryList) {
		this.proofInEntryList = proofInEntryList;
	}
	public VoucherPo getPo() {
		return po;
	}
	public void setPo(VoucherPo po) {
		this.po = po;
	}
	
	/**
	 * 初始化选择单据开窗
	 * @return
	 */
	public String initSelectBillSels(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String bVoucherType = Utility.getName(request.getParameter("bVoucherType"));
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		String voucherDate = Utility.getName(request.getParameter("voucherDate"));
		String createPerson = Utility.getName(request.getParameter("createPerson"));
		String remark = Utility.getName(request.getParameter("remark"));
		
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("supplierName" , supplierName);
	    request.setAttribute("billstype",bVoucherType);
	    request.setAttribute("billtype",bVoucherType);
	    request.setAttribute("sVoucherType" , sVoucherType);
	    request.setAttribute("bVoucherType" , bVoucherType);
	    request.setAttribute("voucherID" , voucherID);
	    request.setAttribute("voucherDate" , voucherDate);
	    request.setAttribute("createPerson" , createPerson);
	    request.setAttribute("remark" , remark);
	    
	    invoiceTypeList = invoiceMgr.getInvoiceTypeList();
	    
	    String type = Utility.getName(request.getParameter("type"));	    
	    request.setAttribute("type" , type);
	    
	    po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
	    //request.setAttribute("startTime" ,Utility.getName(po.getsLvvDateTopLimit()));
	    request.setAttribute("endTime" , Utility.getName(po.getsLvvDateLowerLimit()));
	    
	    if("D".equalsIgnoreCase(Utility.getName(request.getParameter("type")))){	    	
	    	return SUCCESS;	    	
	    }
	    if("7".equalsIgnoreCase(Utility.getName(request.getParameter("type")))){
	    	WarehousePo warehouse = new WarehousePo();			
			warehouselist = proofSelectBillMgr.getWarehouseList(warehouse);
	    	return SUCCESS;	    	
	    }
	    if("8".equalsIgnoreCase(Utility.getName(request.getParameter("type")))){
	    	WarehousePo warehouse = new WarehousePo();
			salesShopList = voucherMgr.getSalesShopList();
	    	return SUCCESS;	    	
	    }
	    if("3".equalsIgnoreCase(Utility.getName(request.getParameter("type")))){
	    	salesShopList = voucherMgr.getSalesShopList();
	    	return SUCCESS;
	    	
	    }
	    if("F".equalsIgnoreCase(Utility.getName(request.getParameter("type")))){
	    	request.setAttribute("typeID" , sVoucherType.equals("103") ? "c1" : "c2");	    	
	    	return ERROR;	    	
	    }
	    if("C".equalsIgnoreCase(Utility.getName(request.getParameter("type")))){	    	
	    	return INPUT;	    	
	    }
	    if("5".equalsIgnoreCase(Utility.getName(request.getParameter("type"))) 
	    		|| "6".equalsIgnoreCase(Utility.getName(request.getParameter("type")))){
	    	
	    	request.setAttribute("billType" , type);
	    	
	    	WarehousePo warehouse = new WarehousePo();
			warehouselist = proofSelectBillMgr.getWarehouseList(warehouse);
			request.setAttribute("usingWarehouse","0");
			
	    	return NONE;	    	
	    }
		
		return SUCCESS;
	}
	
	/**
	 * 查询选择单据信息
	 * @return
	 */
	public String selectSelectBills(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String billid = Utility.getName(request.getParameter("billid"));
		String begintime = Utility.getName(request.getParameter("startTime"));
		String endtime = Utility.getName(request.getParameter("endTime"));
		String billtype = Utility.getName(request.getParameter("savebilltype"));
		String invoiceState = Utility.getName(request.getParameter("invoiceState"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
	    String supplierName = Utility.getName(request.getParameter("supplierName"));
	    
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		String voucherDate = Utility.getName(request.getParameter("voucherDate"));
		String createPerson = Utility.getName(request.getParameter("createPerson"));
		String remark = Utility.getName(request.getParameter("remark"));
	    
		String shopCode = Utility.getName(request.getParameter("shopCode"));
		String typeID = Utility.getName(request.getParameter("typeID"));
		
		salesShopList = voucherMgr.getSalesShopList();
		
	    InventoryPo inPo = new InventoryPo();
	    inPo.setCstibillid(billid);
	    inPo.setCstistartTime(begintime);
	    inPo.setCstiendTime(endtime);
	    inPo.setCstibilltypeid(billtype);
	    inPo.setCstifinanceauditstate(invoiceState);
	    inPo.setSalesOutBillType(sVoucherType);
	    if (!supplierID.equals("")){
	    	inPo.setCstisupplierid(supplierID);
	    }	    
	    if (!shopCode.equals("")){
	    	inPo.setCstidepartmentid(shopCode);
	    }
	    
	    request.setAttribute("billid" , billid);
	    request.setAttribute("startTime" , begintime);
	    request.setAttribute("endTime" , endtime);
	    request.setAttribute("billtype" , billtype);
	    request.setAttribute("invoiceState" , invoiceState);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("supplierName" , supplierName);
	    
	    request.setAttribute("sVoucherType" , sVoucherType);
	    request.setAttribute("voucherID" , voucherID);
	    request.setAttribute("voucherDate" , voucherDate);
	    request.setAttribute("createPerson" , createPerson);
	    request.setAttribute("remark" , remark);
	    
	    request.setAttribute("shopNum" , shopCode);
	    request.setAttribute("type" , typeID);
	    
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
	 // 总数、分页
		int count = proofSelectBillMgr.getSelectBillCount(inPo);
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
			// 取详细信息
			selectBillList = proofSelectBillMgr.selectSelectBill(inPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			selectBillList = null;
		}
				
		return SUCCESS;
	}
	
	/**
	 * 查询选择发票信息
	 * @return
	 */
	public String selectSelectInvoice(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String billid = Utility.getName(request.getParameter("billid"));
		String begintime = Utility.getName(request.getParameter("startTime"));
		String endtime = Utility.getName(request.getParameter("endTime"));
		String billtype = Utility.getName(request.getParameter("billtype"));
		String billstype = Utility.getName(request.getParameter("billstype"));//单据类型
		String invoiceState = Utility.getName(request.getParameter("invoiceState"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
	    String supplierName = Utility.getName(request.getParameter("supplierName"));
	    
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		String voucherDate = Utility.getName(request.getParameter("voucherDate"));
		String createPerson = Utility.getName(request.getParameter("createPerson"));
		String remark = Utility.getName(request.getParameter("remark"));
		String invoiceType = Utility.getName(request.getParameter("invoiceType"));
		
	    InventoryPo inPo = new InventoryPo();
	    inPo.setCstibillid(billid);
	    inPo.setCstistartTime(begintime);
	    inPo.setCstiendTime(endtime);
	    inPo.setCstibilltypeid(billtype);
	    inPo.setCstifinanceauditdate(invoiceState);
	    inPo.setCstisupplierid(supplierID);
	    inPo.setInvoiceType(invoiceType);
	    
	    invoiceTypeList = invoiceMgr.getInvoiceTypeList();
	    
	    request.setAttribute("billid" , billid);
	    request.setAttribute("startTime" , begintime);
	    request.setAttribute("endTime" , endtime);
	    request.setAttribute("billtype" , billtype);
	    request.setAttribute("billstype" , billstype);
	    request.setAttribute("invoiceState" , invoiceState);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("supplierName" , supplierName);
	    
	    request.setAttribute("sVoucherType" , sVoucherType);
	    request.setAttribute("voucherID" , voucherID);
	    request.setAttribute("voucherDate" , voucherDate);
	    request.setAttribute("createPerson" , createPerson);
	    request.setAttribute("remark" , remark);
	    request.setAttribute("typeID" , invoiceType);
	    
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
	 // 总数、分页
		int count = proofSelectBillMgr.getSelectInvoice(inPo);
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
			// 取详细信息
			selectBillList = proofSelectBillMgr.selectSelectInvoice(inPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			selectBillList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询选择冲回信息
	 * @return
	 */
	public String selectSelectReversal(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String billid = Utility.getName(request.getParameter("billid"));
		String begintime = Utility.getName(request.getParameter("startTime"));
		String endtime = Utility.getName(request.getParameter("endTime"));
		String billtype = Utility.getName(request.getParameter("billtype"));
		String invoiceState = Utility.getName(request.getParameter("invoiceState"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
	    String supplierName = Utility.getName(request.getParameter("supplierName"));
	    
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));
		String bVoucherType = Utility.getName(request.getParameter("bVoucherType"));
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		String voucherDate = Utility.getName(request.getParameter("voucherDate"));
		String createPerson = Utility.getName(request.getParameter("createPerson"));
		String remark = Utility.getName(request.getParameter("remark"));
	    
	    InventoryPo inPo = new InventoryPo();
	    inPo.setCstibillid(billid);
	    inPo.setCstistartTime(begintime);
	    inPo.setCstiendTime(endtime);
	    inPo.setCstibilltypeid(billtype);
	    inPo.setCstifinanceauditstate(invoiceState);
	    inPo.setCstisupplierid(supplierID);
	    inPo.setCstibilltypeid(bVoucherType);
	    
	    request.setAttribute("billid" , billid);
	    request.setAttribute("startTime" , begintime);
	    request.setAttribute("endTime" , endtime);
	    request.setAttribute("billtype" , billtype);
	    request.setAttribute("invoiceState" , invoiceState);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("supplierName" , supplierName);	    
	    request.setAttribute("sVoucherType" , sVoucherType);
	    request.setAttribute("bVoucherType" , bVoucherType);
	    request.setAttribute("voucherID" , voucherID);
	    request.setAttribute("voucherDate" , voucherDate);
	    request.setAttribute("createPerson" , createPerson);
	    request.setAttribute("remark" , remark);
	    
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
	 // 总数、分页
		int count = proofSelectBillMgr.getSelectReversal(inPo);
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
			// 取详细信息
			selectBillList = proofSelectBillMgr.selectSelectReversal(inPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			selectBillList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化详细页面
	 * @return
	 */
	public String initBillInfoSels(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String billid = Utility.getName(request.getParameter("hid"));
		String billType = Utility.getName(request.getParameter("billType"));
		
		InventoryPo inPo = new InventoryPo();
		inPo.setCstibillid(billid);
		inPo.setCstibilltypeid(billType);
		
		InventoryEntryPo inEntryPo = new InventoryEntryPo();
		inEntryPo.setCstiebillid(billid);
		
		inventoryPo = proofSelectBillMgr.getBill(inPo);		
		proofInEntryList = proofSelectBillMgr.getBillEntry(inEntryPo);
				
		return SUCCESS;
	}
	
	/**
	 * 初始化发票详细页面
	 * @return
	 */
	public String initInvoiceInfoSel(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String billid = Utility.getName(request.getParameter("hid"));
		
		InventoryPo inPo = new InventoryPo();
		inPo.setCstibillid(billid);
		
		InventoryEntryPo inEntryPo = new InventoryEntryPo();
		inEntryPo.setCstiebillid(billid);
		
		inventoryPo = proofSelectBillMgr.getInvoice(inPo);		
		proofInEntryList = proofSelectBillMgr.getInvoiceEntry(inEntryPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化冲回详细页面
	 * @return
	 */
	public String initReversalInfoSel(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String billid = Utility.getName(request.getParameter("hid"));
		
		InventoryPo inPo = new InventoryPo();
		inPo.setCstibillid(billid);
		
		InventoryEntryPo inEntryPo = new InventoryEntryPo();
		inEntryPo.setCstiebillid(billid);
		
		inventoryPo = proofSelectBillMgr.getReversal(inPo);		
		proofInEntryList = proofSelectBillMgr.getReversalEntry(inEntryPo);
		
		return SUCCESS;
	}
	
	
	/**
	 * 单据选择商品
	 * @return
	 */
	public String selectProofGoods(){	
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String[] bills = request.getParameter("billID").split(",");
		
		proofInEntryList = proofSelectBillMgr.getBillGoods(bills);
		
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String bVoucherType = Utility.getName(request.getParameter("bVoucherType"));
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		String voucherDate = Utility.getName(request.getParameter("voucherDate"));
		String createPerson = Utility.getName(request.getParameter("createPerson"));
		String remark = Utility.getName(request.getParameter("remark"));
		
	    request.setAttribute("supplierName" , supplierName);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("parentID" , bVoucherType);
	    request.setAttribute("subID" , sVoucherType);
	    request.setAttribute("voucherID" , voucherID);
	    request.setAttribute("voucherDate" , voucherDate);
	    request.setAttribute("createPerson" , createPerson);
	    request.setAttribute("remark" , remark);	    
		
	    voucherTopIDList = voucherMgr.getVoucherTypeByID("0");
	    voucherSubsetIDList = voucherMgr.getVoucherTypeByID(bVoucherType);
	    
		this.clearMessages();
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 发票选择商品
	 * @return
	 */
	public String selectInvoiceGoods(){	
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String[] bills = request.getParameter("billID").split(",");
		
		proofInEntryList = proofSelectBillMgr.getBillGoods(bills);
		
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String bVoucherType = Utility.getName(request.getParameter("bVoucherType"));
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		String voucherDate = Utility.getName(request.getParameter("voucherDate"));
		String createPerson = Utility.getName(request.getParameter("createPerson"));
		String remark = Utility.getName(request.getParameter("remark"));
		
	    request.setAttribute("supplierName" , supplierName);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("parentID" , bVoucherType);
	    request.setAttribute("subset" , sVoucherType);
	    request.setAttribute("voucherID" , voucherID);
	    request.setAttribute("voucherDate" , voucherDate);
	    request.setAttribute("createPerson" , createPerson);
	    request.setAttribute("remark" , remark);	    
		
	    voucherTopIDList = voucherMgr.getVoucherTypeByID("0");
	    voucherSubsetIDList = voucherMgr.getVoucherTypeByID(bVoucherType);
	    
		this.clearMessages();
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 冲回选择商品
	 * @return
	 */
	public String selectReversalGoods(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String[] bills = request.getParameter("billID").split(",");
		
		proofInEntryList = proofSelectBillMgr.getBillGoods(bills);
		
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String bVoucherType = Utility.getName(request.getParameter("bVoucherType"));
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		String voucherDate = Utility.getName(request.getParameter("voucherDate"));
		String createPerson = Utility.getName(request.getParameter("createPerson"));
		String remark = Utility.getName(request.getParameter("remark"));
		
	    request.setAttribute("supplierName" , supplierName);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("parentID" , bVoucherType);
	    request.setAttribute("subset" , sVoucherType);
	    request.setAttribute("voucherID" , voucherID);
	    request.setAttribute("voucherDate" , voucherDate);
	    request.setAttribute("createPerson" , createPerson);
	    request.setAttribute("remark" , remark);	    
		
	    voucherTopIDList = voucherMgr.getVoucherTypeByID("0");
	    voucherSubsetIDList = voucherMgr.getVoucherTypeByID(bVoucherType);
	    
		this.clearMessages();
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	
	/**
	 * 查询盘点信息
	 * @return
	 */
	public String selectCheckStorageSum(){
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
		
		String billID = Utility.getName(request.getParameter("billID"));
		String sourceBillID = Utility.getName(request.getParameter("sourceBillID"));
		String billType = Utility.getName(request.getParameter("checksType"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String stockID = Utility.getName(request.getParameter("stockID"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String createPersonName = Utility.getName(request.getParameter("createPersonName"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));

		InventoryPo po = new InventoryPo();
		po.setCstibillid(billID);
		po.setCstisourcebillid(sourceBillID);
		po.setCstibilltypeid(billType);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstiinstockid(stockID);
		po.setCstiauditstate(auditState);
		po.setCstiauditperson(auditPersonID);
		po.setCsticreateperson(createPersonID);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		int count = proofSelectBillMgr.getOveragelossesCount(po);
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
			overagelossesList = proofSelectBillMgr.getOveragelossesList(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			overagelossesList = null;
		}

		request.setAttribute("billID", billID);
		request.setAttribute("sourceBillID", sourceBillID);
		request.setAttribute("billType", billType);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("stockID", stockID);
		request.setAttribute("auditState", auditState);
		request.setAttribute("selcreatePersonID", createPersonID);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("selauditPersonID", auditPersonID);
		request.setAttribute("auditPersonName", auditPersonName);

		WarehousePo warehouse = new WarehousePo();		
		warehouselist = proofSelectBillMgr.getWarehouseList(warehouse);
		
		String usingWarehouse = Utility.getName(request.getParameter("usingWarehouse"));
		request.setAttribute("usingWarehouse",usingWarehouse);
		
		return SUCCESS;
	}
	
	/**
	 * 盘点详细开窗
	 * @return
	 */
	public String initCheckStorageSumDetails(){
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String id = Utility.getName(request.getParameter("hid"));
		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);

		overagelossesPo = proofSelectBillMgr.getOveragelosses(po);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		int count = proofSelectBillMgr.getOveragelossesEntryCount(po);
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
			inventoryEntryList = proofSelectBillMgr.getOveragelossesEntryList(po,
					page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			inventoryEntryList = null;
		}
		
		return SUCCESS;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	
	
}
