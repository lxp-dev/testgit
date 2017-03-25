package com.pengsheng.eims.logistics.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.logistics.mgr.InvoiceMgr;
import com.pengsheng.eims.logistics.mgr.InvoiceSelectBillMgr;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.mgr.VoucherMgr;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.logistics.persistence.InvoiceTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.storage.mgr.ProcurementReceiptMgr;
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

@SuppressWarnings("serial")
public class InvoiceAction extends BaseAction {
	
	private LogisticsLogMgr logisticsLogMgr = null;
	private PersonPermissionMgr personPermissionMgr = null;	
	private BrandMgr brandMgr = null;
	private List<GoodsCategoryPo> goodsCategorys = null;
	private InventoryPo inventoryPo = null;
	private InvoicePo invoicePo = null;	
	private InvoiceMgr invoiceMgr = null;	
	private List<InvoicePo> invoiceList = null;	
	private List<InvoiceEntryPo> invoiceEntryList = null;	
	private InvoiceEntryPo invoiceEntryPo = null;	
	private InvoiceSelectBillMgr invoiceSelectBillMgr = null;	
	private List<InventoryEntryPo> inventoryEntryList = null;
	private List<InvoiceTypePo> invoiceTypeList = null;
	private List<InventoryPo> selectBillList = null;
	private VoucherMgr voucherMgr = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private ProcurementReceiptMgr procurementReceiptMgr;
	
	/**
	 * 模块：发票管理
	 * 描述：初始化发票查询
	 * 优化记录：1. szk 2011-08-10
	 */
	public String initInvoiceSel() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		invoiceTypeList = invoiceMgr.getInvoiceTypeList();	//获取发票类型
		request.setAttribute("invoiceCreatePersonID", createPerson);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
		
		/*
		 *释放资源
		 */
		moduleID = null;
		createPerson = null;
		personInfoPo = null;
		personPermissionPo = null;
		permissionPo = null;

		if ("1".equals(Utility.getName(request.getParameter("openWin")))){
			return SUCCESS;
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selInvoice";
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 模块：发票管理
	 * 描述：根据查询条件查询发票
	 * 优化记录：1. szk 2011-08-10
	 */
	public String selInvoice() throws Exception {	
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String invoiceCreatePersonID = Utility.getName(request.getParameter("invoiceCreatePersonID"));
		String invoiceAuditStatue = Utility.getName(request.getParameter("invoiceAuditStatue"));
		String invoiceType = Utility.getName(request.getParameter("invoiceType"));		
		String invoiceStartAuditDate = Utility.getName(request.getParameter("invoiceStartAuditDate"));
		String invoiceEndAuditDate = Utility.getName(request.getParameter("invoiceEndAuditDate"));
		String invoiceStartDate = Utility.getName(request.getParameter("invoiceStartDate"));
		String invoiceEndDate = Utility.getName(request.getParameter("invoiceEndDate"));
		String invoiceAuditDate = Utility.getName(request.getParameter("invoiceAuditDate"));
		String isPaymentFlag = Utility.getName(request.getParameter("isPaymentFlag"));
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
		
		InvoicePo invoicePo = new InvoicePo();
		invoicePo.setLiisupplierid(supplierID);
		invoicePo.setLiistartauditdate(invoiceStartAuditDate);
		invoicePo.setLiiendauditdate(invoiceEndAuditDate);
		invoicePo.setLiistartdate(invoiceStartDate.equals("") ? Utility.getName(po.getsLvvDateTopLimit()) : invoiceStartDate);
		invoicePo.setLiienddate(invoiceEndDate.equals("") ? Utility.getName(po.getsLvvDateLowerLimit()) : invoiceEndDate);
		invoicePo.setLiiauditstatue(invoiceAuditStatue);
		invoicePo.setLiiid(invoiceID);
		invoicePo.setLiicreatepersonid(invoiceCreatePersonID.equals("") ? createPerson : invoiceCreatePersonID);
		invoicePo.setLiitypeName(invoiceType);
		invoicePo.setLiiispayment(isPaymentFlag);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			invoicePo.setLiiCompanyID(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}
		
		int count = invoiceMgr.getInvoiceCount(invoicePo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
				
	    Pagination page = new Pagination(request, count, perPage);
	    invoiceList = invoiceMgr.getInvoiceList(invoicePo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			invoiceList = null;
		}
		
		invoiceTypeList = invoiceMgr.getInvoiceTypeList();
		invoiceEntryPo = invoiceMgr.getInvoiceAmountBySupplierID(invoicePo);
		
		request.setAttribute("invoiceID", invoiceID);
		request.setAttribute("supplierID",supplierID );
		request.setAttribute("supplierName",supplierName );
		request.setAttribute("invoiceAuditStatue",invoiceAuditStatue);
		request.setAttribute("invoiceCreatePersonID",invoiceCreatePersonID.equals("") ? createPerson : invoiceCreatePersonID  );		
		request.setAttribute("invoiceStartAuditDate",invoiceStartAuditDate);
		request.setAttribute("invoiceEndAuditDate",invoiceEndAuditDate);
		request.setAttribute("invoiceStartDate",invoiceStartDate.equals("") ? Utility.getName(po.getsLvvDateTopLimit()) : invoiceStartDate );
		request.setAttribute("invoiceEndDate",invoiceEndDate.equals("") ? Utility.getName(po.getsLvvDateLowerLimit()) : invoiceEndDate );
		request.setAttribute("invoiceTypeID", invoiceType);
		request.setAttribute("invoiceAuditDate", invoiceAuditDate.equals("") ? Utility.getName(po.getsLvvDateTopLimit()) : invoiceAuditDate);
		request.setAttribute("isPaymentFlag", isPaymentFlag);		
		
		moduleID = null;
		createPerson = null;
		personInfoPo = null;
		personPermissionPo = null;
		permissionPo = null;		
		invoicePo = null;		
		invoiceID = null;
		supplierID = null;
		supplierName = null;
		invoiceAuditStatue = null;
		invoiceCreatePersonID = null;
		invoiceStartAuditDate = null;
		invoiceType = null;
		invoiceEndAuditDate = null;
		invoiceStartDate = null;
		invoiceEndDate = null;		
		invoiceAuditDate = null;
		
		return SUCCESS;
	}	
	
	/**
	 * 模块：发票管理
	 * 描述：初始化单据查询
	 * 优化记录：1. szk 2011-08-10
	 *          
	 */
	public String initInvoiceSelectBill(){		
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
		
		goodsCategorys = brandMgr.getGoodsCategorys(); //获取商品类别
		return SUCCESS;
	}
	
	/**
	 * 模块：发票管理
	 * 描述：单据查询
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String invoiceSelectBill() throws Exception {
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
	    String goodstype = Utility.getName(request.getParameter("goodstype"));
		
	    InventoryPo inPo = new InventoryPo();
	    inPo.setCstibillid(billid);
	    inPo.setCstistartTime(begintime);
	    inPo.setCstiendTime(endtime);
	    inPo.setCstibilltypeid(billtype);
	    inPo.setCstiinvoicestate(invoiceState);
	    inPo.setCstisupplierid(supplierID);
	    inPo.setCstigoodstype(goodstype);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			inPo.setCsticompanyid(personInfoPo.getPersoncompanyid());
		}
		
	    request.setAttribute("billid" , billid);
	    request.setAttribute("begintime" , begintime);
	    request.setAttribute("endtime" , endtime);
	    request.setAttribute("billtype" , billtype);
	    request.setAttribute("invoiceState" , invoiceState);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("supplierName" , supplierName);
	    request.setAttribute("selbspcategoryid" , goodstype);
	    
	    inventoryPo = invoiceSelectBillMgr.getBillSum(inPo);
	    
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
	    int count = invoiceSelectBillMgr.getSelBillCount(inPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);			
			selectBillList = invoiceSelectBillMgr.selSelectBill(inPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			selectBillList = null;
		}
		
		goodsCategorys = brandMgr.getGoodsCategorys();
		
	    return SUCCESS;
	}
	
	/**
	 * 模块：发票管理
	 * 描述：初始化发票新增页面
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String initInvoiceInsert() throws Exception {

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
		
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String invoiceID = "I" + personInfoPo.getDepartmentID() + personInfoPo.getMachinery() + numHeadFormat.format(new Date());
		
		numHeadFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String invoiceStartDate = numHeadFormat.format(new Date());
		
		invoiceTypeList = invoiceMgr.getInvoiceTypeList();
		
		request.setAttribute("invoiceStartDate", invoiceStartDate);
		request.setAttribute("invoiceEndDate", invoiceStartDate);
		request.setAttribute("invoiceID", invoiceID);
		
		personInfoPo = null;
		numHeadFormat = null;
		invoiceID = null;
		
		return SUCCESS;
	}
	
	/**
	 * 模块：发票管理
	 * 描述：新增发票时选择需核销的单据
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String selBills() throws Exception {		
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
		
		String billStringID = Utility.getName(request.getParameter("billStringID"));
		String invoiceType = Utility.getName(request.getParameter("invoiceType"));
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String remark = Utility.getName(request.getParameter("remark"));
		
	    String invoiceStartDate = Utility.getName(request.getParameter("invoiceStartDate"));
	    String invoiceEndDate = Utility.getName(request.getParameter("invoiceEndDate"));
		request.setAttribute("invoiceStartDate", invoiceStartDate);
		request.setAttribute("invoiceEndDate", invoiceEndDate);
		
		if (inventoryEntryList == null){
			inventoryEntryList = new ArrayList<InventoryEntryPo>();
		}

		if (invoiceEntryPo != null){
			String[] goodsid = invoiceEntryPo.getLieiegoodsid().split(",");
			int length = goodsid.length;
			if (length != 0){
				for (int i = 0; i < length; i++){
					InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
					inventoryEntryPo.setCstieid(invoiceEntryPo.getLieieid().split(",")[i].trim());
					inventoryEntryPo.setCstiebillid(invoiceEntryPo.getLieiebillid().split(",")[i].trim());
					inventoryEntryPo.setCstiecheckgoodsquantity(invoiceEntryPo.getLieiecheckgoodsquantity().split(",")[i].trim());
					inventoryEntryPo.setCstiecostprice(invoiceEntryPo.getLieiecostprice().split(",")[i].trim());
					inventoryEntryPo.setCstiecostpriceamount(invoiceEntryPo.getLieiecostpriceamount().split(",")[i].trim());
					inventoryEntryPo.setCstiegoodsid(goodsid[i].trim());
					inventoryEntryPo.setCstiegoodsname(invoiceEntryPo.getLieiegoodsname().split(",")[i].trim());
					inventoryEntryPo.setCstiegoodsquantity(invoiceEntryPo.getLieiegoodsquantity().split(",")[i].trim());				
					inventoryEntryPo.setCstienottaxrate(invoiceEntryPo.getLieienottaxrate().split(",")[i].trim());
					inventoryEntryPo.setCstienottaxrateamount(invoiceEntryPo.getLieienottaxrateamount().split(",")[i].trim());
					inventoryEntryPo.setCstiespec(invoiceEntryPo.getLieiespec().split(",")[i].trim());
					inventoryEntryPo.setCstietaxamount(invoiceEntryPo.getLieietaxamount().split(",")[i].trim());
					inventoryEntryPo.setCstietaxrate(invoiceEntryPo.getLieietaxrate().split(",")[i].trim());
					inventoryEntryPo.setCstiebilltypeid(invoiceEntryPo.getCstiebilltypeid().split(",")[i].trim());
					
					inventoryEntryList.add(inventoryEntryPo);
				}
			}
			goodsid = null;
		}
		
		if(!"".equals(Utility.getName(request.getParameter("billID")))){
			String[] bills = Utility.getName(request.getParameter("billID")).split(",");
			inventoryEntryList = invoiceSelectBillMgr.getBillGoods(inventoryEntryList,bills,invoiceType);
			bills = null;
		}
		invoiceTypeList = invoiceMgr.getInvoiceTypeList();
		
		request.setAttribute("typeID", invoiceType);
		request.setAttribute("invoiceID", invoiceID);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("remark",remark);
		request.setAttribute("billStringID", billStringID);
		
		billStringID = null;
		invoiceType = null;
		invoiceID = null;
		supplierID = null;
		supplierName = null;
		remark = null;
		
		return SUCCESS;
	}
	
	/**
	 * 模块：发票管理
	 * 描述：新增发票
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String invoiceInsert() throws Exception {
		
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
		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String remark = Utility.getName(request.getParameter("remark"));
		String invoiceType = Utility.getName(request.getParameter("invoiceType"));
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
//		logPo.setsLogResult("12"); // 12 表示开始 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("发票：" + invoiceID + "新增!");
		
//		logisticsLogMgr.insertLog(logPo);  //新增日志
		
		invoicePo.setLiicreatepersonid(createPerson);
		invoicePo.setLiisupplierid(supplierID);		
		invoicePo.setLiiremark(remark);
		invoicePo.setLiitypeID(invoiceType);
		invoicePo.setLiiid(invoiceID);
				
		String auditState = Utility.getName(request.getParameter("auditState"));
		if (auditState.equals("1")){
			invoicePo.setLiiauditstatue("1");
			invoicePo.setLiiauditpersonid(createPerson);
		}else{
			invoicePo.setLiiauditstatue("0");
		}
		
		// 根据公司和制造商查询绑定的供应商
		invoicePo.setLiisubsupplierid(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),invoicePo.getLiisupplierid()));
				
		invoicePo.setLiiisinvoiceform("3");
		invoiceMgr.insertInvoice(invoicePo,invoiceEntryPo,personInfoPo.getPersoncompanyid(),logPo);
		
//		logPo.setsLogResult("11"); // 11 表示成功 
//		logisticsLogMgr.insertLog(logPo);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
		
		personInfoPo = null;
		supplierID = null;
		remark = null;
		invoiceType = null;
		invoiceID = null;		
		logPo = null;
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 模块：发票管理
	 * 描述：初始化发票删除页面
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String initInvoiceDelete() throws Exception {

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
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		
		request.setAttribute("invoiceID",invoiceID);
		
		invoiceID = null;
		
		return SUCCESS;
	}
	
	/**
	 * 模块：发票管理
	 * 描述：删除发票
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String invoiceDelete() throws Exception {

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
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
//		logPo.setsLogResult("12"); // 12 表示开始 
		logPo.setsLogOpID("2");    // 2表示删除
		logPo.setsLogContent("发票：" + invoiceID + "删除!");
//		logisticsLogMgr.insertLog(logPo);
		
		invoiceMgr.deleteInvoice(invoiceID, logPo);
		
//		logPo.setsLogResult("11"); // 11 表示成功
//		logisticsLogMgr.insertLog(logPo);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
		
		invoiceID = null;
		logPo = null;
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 模块：发票管理
	 * 描述：初始化打印发票页面
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String initInvoicePrint() throws Exception {
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
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		String statue = Utility.getName(request.getParameter("statue"));
		
		request.setAttribute("invoiceID",invoiceID);
		request.setAttribute("statue",statue);
		
		invoiceID = null;
		statue = null;
		
		return SUCCESS;
	}
	
	/**
	 * 模块：发票管理
	 * 描述：查询发票详细信息
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String initInvoiceDetail() throws Exception {	
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
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		invoicePo = new InvoicePo();
		invoicePo.setLiiid(invoiceID);
		invoicePo = invoiceMgr.getInvocePo(invoicePo);
		
		invoiceEntryPo = new InvoiceEntryPo();
		invoiceEntryPo.setLieieinvoiceid(invoiceID);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
	    int count = invoiceMgr.getInvoiceEntryCount(invoiceEntryPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);			
			invoiceEntryList=invoiceMgr.getInvoiceEntryPoList(invoiceEntryPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			invoiceEntryList = null;
		}
				
		invoiceEntryPo = invoiceMgr.getInvoceSum(invoicePo);
		
		invoiceID = null;
		
		return SUCCESS;
	}
	
	/**
	 * 模块：发票管理
	 * 描述：初始化发票修改页面
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String initInvoiceUpdate() throws Exception {	
		
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
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		
		invoicePo = new InvoicePo();
		invoicePo.setLiiid(invoiceID);
		invoicePo = invoiceMgr.getInvocePo(invoicePo);
		
		InvoiceEntryPo invoiceEntryPo = new InvoiceEntryPo();
		invoiceEntryPo.setLieieinvoiceid(invoiceID);		
		invoiceEntryList=invoiceMgr.getInvoiceEntryPoList(invoiceEntryPo);
		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		
		personInfoPo = null;
		createPerson = null;
		personPermissionPo = null;
		permissionPo = null;
		moduleID = null;
		invoiceID = null;
		supplierID = null;
		supplierName = null;
		invoiceEntryPo = null;
		
		return SUCCESS;
	}	
	
	/**
	 * 模块：发票管理
	 * 描述：修改发票
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public String invoiceUpdate() throws Exception {
		
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
		
		if (invoicePo == null){
			invoicePo = new InvoicePo();
		}
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		invoicePo.setLiiauditpersonid(createPerson);		
		invoicePo.setLiisupplierid(Utility.getName(request.getParameter("supplierID")));
		invoicePo.setLiidepartmentid(personInfoPo.getDepartmentID());
		invoicePo.setLiicreatepersonid(Utility.getName(request.getParameter("liicreatepersonid")));
		invoicePo.setLiiid(invoiceID);
		invoicePo.setLiiremark(Utility.getName(request.getParameter("remark")));
		invoicePo.setLiitypeID(Utility.getName(request.getParameter("liitypeID")));
		invoicePo.setLiidate(Utility.getName(request.getParameter("liidate")));
		invoicePo.setIsupdate("1");	
		invoicePo.setLiiauditstatue(Utility.getName(request.getParameter("auditState")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
//		logPo.setsLogResult("12"); // 12 表示开始 
		logPo.setsLogOpID("3");    // 3表示修改
		logPo.setsLogContent("发票：" + invoiceID + "修改!");
//		logisticsLogMgr.insertLog(logPo);
		
		// 根据公司和制造商查询绑定的供应商
		invoicePo.setLiisubsupplierid(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),invoicePo.getLiisupplierid()));
		
		invoicePo.setLiiisinvoiceform("3");
		invoiceMgr.updateInvoice(invoicePo,invoiceEntryPo,personInfoPo.getPersoncompanyid(),logPo);
		
//		logPo.setsLogResult("11"); // 11 表示成功
//		logisticsLogMgr.insertLog(logPo);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initAllAuditOrUnAuditInvoice() throws Exception {
		
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
		
		String auditStatue = Utility.getName(request.getParameter("auditStatue"));	
		String msg = Utility.getName(request.getParameter("msg"));
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));	
		
		request.setAttribute("auditStatue",auditStatue);
		request.setAttribute("msg",msg);
		request.setAttribute("invoiceID",invoiceID);
		
		return SUCCESS;
	}
	
	public String allAuditOrUnAuditInvoice() throws Exception {
		
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
		
		String auditStatue = Utility.getName(request.getParameter("auditStatue"));	
		
		InvoicePo invoicePo = new InvoicePo();
		invoicePo.setLiiauditpersonid(createPerson);
		invoicePo.setLiiid(Utility.getName(request.getParameter("invoiceID")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		
		if (auditStatue.equalsIgnoreCase("q")){
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("5");    // 5 表示全部审核
			logPo.setsLogContent("全部审核发票：" + "all invoices");	
			
			invoiceMgr.auditAll(invoicePo,logPo);
			
		}else if (auditStatue.equalsIgnoreCase("f")){
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("3");    // 5 表示全部反审核
			if (invoicePo.getLiiid().equals("")){
				logPo.setsLogContent("全部反审核发票：" + "all invoices");	
			}else{
				logPo.setsLogContent("发票：" + invoicePo.getLiiid() + "反审核!");	
			}
			
			invoiceMgr.auditUnAll(invoicePo,logPo);

		}
		
		request.setAttribute("invoiceCreatePersonID",createPerson);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initPartAuditOrUnAuditInvoice() throws Exception {
		
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
		
		String auditStatue = Utility.getName(request.getParameter("auditStatue"));
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));	
		
		request.setAttribute("auditStatue",auditStatue);
		request.setAttribute("invoiceID",invoiceID);
		
		return SUCCESS;
	}
	
	public String partAuditOrUnAuditInvoice() throws Exception {
		
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
		
		String auditStatue = Utility.getName(request.getParameter("auditStatue"));	
		
		InvoicePo invoicePo = new InvoicePo();
		invoicePo.setLiiauditpersonid(createPerson);
		invoicePo.setLiiid(Utility.getName(request.getParameter("invoiceID")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		
		if (auditStatue.equalsIgnoreCase("q")){
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("5");    // 5 表示全部审核
			logPo.setsLogContent("部分审核发票：" + invoicePo.getLiiid());	
			
			invoiceMgr.auditPart(invoicePo,logPo);
			
		}else if (auditStatue.equalsIgnoreCase("f")){
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("3");    // 5 表示全部反审核
			if (invoicePo.getLiiid().equals("")){
				logPo.setsLogContent("部分反审核发票：" + invoicePo.getLiiid());	
			}
			
			invoiceMgr.auditUnPart(invoicePo,logPo);

		}
		
		request.setAttribute("invoiceCreatePersonID",createPerson);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String selectInventoryEntry(){
//		String[] bills = request.getParameter("billID").split(",");
//		
//		inventoryEntryList=invoiceSelectBillMgr.getBillGoods(inventoryEntryList,bills);
//		this.clearMessages();
//		request.setAttribute("url", "'initInvoiceInsert.action'");
//		request.setAttribute("flag", GlobalConstants.MOVE);
		return SUCCESS;
	}
	
	public String initInvoiceBillSel(){
		return SUCCESS;
	}
	
	public String invoiceBillSel(){
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
		request.setAttribute("billID",billID);
		
		invoiceEntryList = invoiceMgr.getInvoiceBillList(billID);
		
		return SUCCESS;
	}

	/**********************************************************************************************************************************************/
	
	/**
	 * 根据系统参数设置判断创建发票的方式
	 */
	public String initInvoiceSwitchSel() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String invoiceForm = Utility.getName(systemParameterPo.getFspinvoicetype());		
				
		if (invoiceForm.equals("1")){
			return "selInvoiceBySalesInvoice";
		}
		if (invoiceForm.equals("2")){
			return "selInvoiceByBill";
		}
		
		return "selInvoice";
	}
	
	/**
	 * 
	 */
	public String initInvoiceByBillSel() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
				
		invoiceTypeList = invoiceMgr.getInvoiceTypeList();	//获取发票类型
		request.setAttribute("invoiceCreatePersonID", createPerson);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selInvoiceByBill";
		}
		
		return SUCCESS;
	}
	
    /**
	 * 
	 */
	public String selInvoiceByBill() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String invoiceCreatePersonID = Utility.getName(request.getParameter("invoiceCreatePersonID"));
		String invoiceAuditStatue = Utility.getName(request.getParameter("invoiceAuditStatue"));
		String invoiceType = Utility.getName(request.getParameter("invoiceType"));		
		String invoiceStartAuditDate = Utility.getName(request.getParameter("invoiceStartAuditDate"));
		String invoiceEndAuditDate = Utility.getName(request.getParameter("invoiceEndAuditDate"));
		String invoiceStartDate = Utility.getName(request.getParameter("invoiceStartDate"));
		String invoiceEndDate = Utility.getName(request.getParameter("invoiceEndDate"));
		String invoiceAuditDate = Utility.getName(request.getParameter("invoiceAuditDate"));
		String isPaymentFlag = Utility.getName(request.getParameter("isPaymentFlag"));
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
		
		InvoicePo invoicePo = new InvoicePo();
		invoicePo.setLiisupplierid(supplierID);
		invoicePo.setLiistartauditdate(invoiceStartAuditDate);
		invoicePo.setLiiendauditdate(invoiceEndAuditDate);
		invoicePo.setLiistartdate(invoiceStartDate.equals("") ? Utility.getName(po.getsLvvDateTopLimit()) : invoiceStartDate);
		invoicePo.setLiienddate(invoiceEndDate.equals("") ? Utility.getName(po.getsLvvDateLowerLimit()) : invoiceEndDate);
		invoicePo.setLiiauditstatue(invoiceAuditStatue);
		invoicePo.setLiiid(invoiceID);
		invoicePo.setLiicreatepersonid(invoiceCreatePersonID.equals("") ? createPerson : invoiceCreatePersonID);
		invoicePo.setLiitypeName(invoiceType);
		invoicePo.setLiiispayment(isPaymentFlag);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			invoicePo.setLiiCompanyID(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}
		
		int count = invoiceMgr.getInvoiceCount(invoicePo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
				
	    Pagination page = new Pagination(request, count, perPage);
	    invoiceList = invoiceMgr.getInvoiceList(invoicePo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			invoiceList = null;
		}
		
		invoiceTypeList = invoiceMgr.getInvoiceTypeList();
		invoiceEntryPo = invoiceMgr.getInvoiceAmountBySupplierID(invoicePo);		
		
		request.setAttribute("invoiceID", invoiceID);
		request.setAttribute("supplierID",supplierID );
		request.setAttribute("supplierName",supplierName );
		request.setAttribute("invoiceAuditStatue",invoiceAuditStatue);
		request.setAttribute("invoiceCreatePersonID",invoiceCreatePersonID.equals("") ? createPerson : invoiceCreatePersonID  );		
		request.setAttribute("invoiceStartAuditDate",invoiceStartAuditDate);
		request.setAttribute("invoiceEndAuditDate",invoiceEndAuditDate);
		request.setAttribute("invoiceStartDate",invoiceStartDate.equals("") ? Utility.getName(po.getsLvvDateTopLimit()) : invoiceStartDate );
		request.setAttribute("invoiceEndDate",invoiceEndDate.equals("") ? Utility.getName(po.getsLvvDateLowerLimit()) : invoiceEndDate );
		request.setAttribute("invoiceTypeID", invoiceType);
		request.setAttribute("invoiceAuditDate", invoiceAuditDate.equals("") ? Utility.getName(po.getsLvvDateTopLimit()) : invoiceAuditDate);
		request.setAttribute("isPaymentFlag", isPaymentFlag);		
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String initInvoiceByBillInsert() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String invoiceID = "I" + personInfoPo.getDepartmentID() + personInfoPo.getMachinery() + numHeadFormat.format(new Date());
		
		numHeadFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String invoiceStartDate = numHeadFormat.format(new Date());
		
		invoiceTypeList = invoiceMgr.getInvoiceTypeList();
		
		request.setAttribute("invoiceStartDate", invoiceStartDate);
		request.setAttribute("invoiceEndDate", invoiceStartDate);
		request.setAttribute("invoiceID", invoiceID);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String invoiceByBillInsert() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String remark = Utility.getName(request.getParameter("remark"));
		String invoiceType = Utility.getName(request.getParameter("invoiceType"));
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("发票：" + invoiceID + "新增!");
		
		invoicePo.setLiicreatepersonid(createPerson);
		invoicePo.setLiisupplierid(supplierID);		
		invoicePo.setLiiremark(remark);
		invoicePo.setLiitypeID(invoiceType);
		invoicePo.setLiiid(invoiceID);
				
		String auditState = Utility.getName(request.getParameter("auditState"));
		if (auditState.equals("1")){
			invoicePo.setLiiauditstatue("1");
			invoicePo.setLiiauditpersonid(createPerson);
		}else{
			invoicePo.setLiiauditstatue("0");
		}
		
		// 根据公司和制造商查询绑定的供应商
		invoicePo.setLiisubsupplierid(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),invoicePo.getLiisupplierid()));
		
		invoicePo.setLiiisinvoiceform("2");
		invoiceMgr.insertInvoiceByBill(invoicePo,invoiceEntryPo,personInfoPo.getPersoncompanyid(),logPo);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
    /**
	 * 
	 */
	public String initInvoiceByBillDetail() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		invoicePo = new InvoicePo();
		invoicePo.setLiiid(invoiceID);
		invoicePo = invoiceMgr.getInvocePo(invoicePo);
		
		invoiceEntryPo = new InvoiceEntryPo();
		invoiceEntryPo.setLieieinvoiceid(invoiceID);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
	    int count = invoiceMgr.getInvoiceEntryCount(invoiceEntryPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);			
			invoiceEntryList=invoiceMgr.getInvoiceEntryPoList(invoiceEntryPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			invoiceEntryList = null;
		}
				
		invoiceEntryPo = invoiceMgr.getInvoceSum(invoicePo);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String initInvoiceByBillDelete() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));		
		request.setAttribute("invoiceID",invoiceID);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String invoiceByBillDelete() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2表示删除
		logPo.setsLogContent("发票：" + invoiceID + "删除!");
		
		InvoicePo ipo = new InvoicePo();
		ipo.setLiiid(invoiceID);		
		invoiceMgr.deleteInvoiceByBill(ipo, logPo);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
				
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String initInvoiceByBillUpdate() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
			
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		
		invoicePo = new InvoicePo();
		invoicePo.setLiiid(invoiceID);
		invoicePo = invoiceMgr.getInvocePo(invoicePo);
		
		InvoiceEntryPo invoiceEntryPo = new InvoiceEntryPo();
		invoiceEntryPo.setLieieinvoiceid(invoiceID);		
		invoiceEntryList=invoiceMgr.getInvoiceEntryPoList(invoiceEntryPo);
		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String invoiceByBillUpdate() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		if (invoicePo == null){
			invoicePo = new InvoicePo();
		}
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		invoicePo.setLiiauditpersonid(createPerson);		
		invoicePo.setLiisupplierid(Utility.getName(request.getParameter("supplierID")));
		invoicePo.setLiidepartmentid(personInfoPo.getDepartmentID());
		invoicePo.setLiicreatepersonid(Utility.getName(request.getParameter("liicreatepersonid")));
		invoicePo.setLiiid(invoiceID);
		invoicePo.setLiiremark(Utility.getName(request.getParameter("remark")));
		invoicePo.setLiitypeID(Utility.getName(request.getParameter("liitypeID")));
		invoicePo.setLiidate(Utility.getName(request.getParameter("liidate")));
		invoicePo.setIsupdate("1");	
		invoicePo.setLiiauditstatue(Utility.getName(request.getParameter("auditState")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 3表示修改
		logPo.setsLogContent("发票：" + invoiceID + "修改!");
		
		// 根据公司和制造商查询绑定的供应商
		invoicePo.setLiisubsupplierid(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),invoicePo.getLiisupplierid()));
		
		invoicePo.setLiiisinvoiceform("2");
		invoiceMgr.updateInvoiceByBill(invoicePo,invoiceEntryPo,personInfoPo.getPersoncompanyid(),logPo);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	
	/**
	 * 
	 */
	public String initDealingBillByInvoiceOpenSel() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String typeid = Utility.getName(request.getParameter("typeid"));
		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("typeid",typeid);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String dealingBillByInvoiceOpenSel() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		

		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));		
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String createBgnDate = Utility.getName(request.getParameter("createBgnDate"));
		String createEndDate = Utility.getName(request.getParameter("createEndDate"));		
		String auditBgnDate = Utility.getName(request.getParameter("auditBgnDate"));
		String auditEndDate = Utility.getName(request.getParameter("auditEndDate"));
		String billType = Utility.getName(request.getParameter("billType"));
		String billID = Utility.getName(request.getParameter("billID"));
		String typeid = Utility.getName(request.getParameter("typeid"));

		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("createPersonID", createPersonID);
		request.setAttribute("createBgnDate", createBgnDate);
		request.setAttribute("createEndDate", createEndDate);
		request.setAttribute("auditBgnDate", auditBgnDate);
		request.setAttribute("auditEndDate", auditEndDate);
		request.setAttribute("billType", billType);	
		request.setAttribute("billID", billID);	
		request.setAttribute("typeid",typeid);
		
		InvoicePo invoicePo = new InvoicePo();
		invoicePo.setLiisupplierid(supplierID);
		invoicePo.setLiistartauditdate(auditBgnDate);
		invoicePo.setLiiendauditdate(auditEndDate);
		invoicePo.setLiistartdate(createBgnDate);
		invoicePo.setLiienddate(createEndDate);
		invoicePo.setLiiBillID(billID);
		invoicePo.setLiicreatepersonid(createPersonID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			invoicePo.setLiiCompanyID(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}
		
		int count = invoiceMgr.getProcurementBillCount(invoicePo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
				
	    Pagination page = new Pagination(request, count, perPage);
	    invoiceEntryList = invoiceMgr.getProcurementBillList(invoicePo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			invoiceList = null;
		}	
		
		return SUCCESS;
	}
	
	/**********************************************************************************************************************************************/
		
	/**
	 * 
	 */
	public String initInvoiceBySalesInvoiceSel() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/			
		
		invoiceTypeList = invoiceMgr.getInvoiceTypeList();	//获取发票类型
		request.setAttribute("invoiceCreatePersonID", createPerson);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selInvoiceBySalesInvoice";
		}
		
		return SUCCESS;
	}
	
    /**
	 * 
	 */
	public String selInvoiceBySalesInvoice() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String invoiceCreatePersonID = Utility.getName(request.getParameter("invoiceCreatePersonID"));
		String invoiceAuditStatue = Utility.getName(request.getParameter("invoiceAuditStatue"));
		String invoiceType = Utility.getName(request.getParameter("invoiceType"));		
		String invoiceStartAuditDate = Utility.getName(request.getParameter("invoiceStartAuditDate"));
		String invoiceEndAuditDate = Utility.getName(request.getParameter("invoiceEndAuditDate"));
		String invoiceStartDate = Utility.getName(request.getParameter("invoiceStartDate"));
		String invoiceEndDate = Utility.getName(request.getParameter("invoiceEndDate"));
		String invoiceAuditDate = Utility.getName(request.getParameter("invoiceAuditDate"));
		String isPaymentFlag = Utility.getName(request.getParameter("isPaymentFlag"));
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			invoiceCreatePersonID = invoiceCreatePersonID.equals("") ? createPerson : invoiceCreatePersonID ;
			invoiceStartDate = invoiceStartDate.equals("") ? Utility.getName(po.getsLvvDateTopLimit()) : invoiceStartDate;
			invoiceEndDate = invoiceEndDate.equals("") ? Utility.getName(po.getsLvvDateLowerLimit()) : invoiceEndDate;
			invoiceAuditDate = invoiceAuditDate.equals("") ? Utility.getName(po.getsLvvDateTopLimit()) : invoiceAuditDate;
		}
		
		InvoicePo invoicePo = new InvoicePo();
		invoicePo.setLiisupplierid(supplierID);
		invoicePo.setLiistartauditdate(invoiceStartAuditDate);
		invoicePo.setLiiendauditdate(invoiceEndAuditDate);
		invoicePo.setLiistartdate(invoiceStartDate);
		invoicePo.setLiienddate(invoiceEndDate);
		invoicePo.setLiiauditstatue(invoiceAuditStatue);
		invoicePo.setLiiid(invoiceID);
		invoicePo.setLiicreatepersonid(invoiceCreatePersonID);
		invoicePo.setLiitypeName(invoiceType);
		invoicePo.setLiiispayment(isPaymentFlag);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			invoicePo.setLiiCompanyID(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}
		
		int count = invoiceMgr.getInvoiceCount(invoicePo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
				
	    Pagination page = new Pagination(request, count, perPage);
	    invoiceList = invoiceMgr.getInvoiceList(invoicePo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			invoiceList = null;
		}
		
		invoiceTypeList = invoiceMgr.getInvoiceTypeList();
		invoiceEntryPo = invoiceMgr.getInvoiceAmountBySupplierID(invoicePo);		
		
		request.setAttribute("invoiceID", invoiceID);
		request.setAttribute("supplierID",supplierID );
		request.setAttribute("supplierName",supplierName );
		request.setAttribute("invoiceAuditStatue",invoiceAuditStatue);
		request.setAttribute("invoiceCreatePersonID",invoiceCreatePersonID);		
		request.setAttribute("invoiceStartAuditDate",invoiceStartAuditDate);
		request.setAttribute("invoiceEndAuditDate",invoiceEndAuditDate);
		request.setAttribute("invoiceStartDate",invoiceStartDate);
		request.setAttribute("invoiceEndDate",invoiceEndDate);
		request.setAttribute("invoiceTypeID", invoiceType);
		request.setAttribute("invoiceAuditDate", invoiceAuditDate);
		request.setAttribute("isPaymentFlag", isPaymentFlag);	
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String initInvoiceBySalesInvoiceInsert() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String invoiceID = "I" + personInfoPo.getDepartmentID() + personInfoPo.getMachinery() + numHeadFormat.format(new Date());
		
		numHeadFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String invoiceStartDate = numHeadFormat.format(new Date());
		
		invoiceTypeList = invoiceMgr.getInvoiceTypeList();
		
		request.setAttribute("invoiceStartDate", invoiceStartDate);
		request.setAttribute("invoiceEndDate", invoiceStartDate);
		request.setAttribute("invoiceID", invoiceID);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String invoiceBySalesInvoiceInsert() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String remark = Utility.getName(request.getParameter("remark"));
		String invoiceType = Utility.getName(request.getParameter("invoiceType"));
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("发票：" + invoiceID + "新增!");
		
		invoicePo.setLiicreatepersonid(createPerson);
		invoicePo.setLiisupplierid(supplierID);		
		invoicePo.setLiiremark(remark);
		invoicePo.setLiitypeID(invoiceType);
		invoicePo.setLiiid(invoiceID);
		
		// 根据公司和制造商查询绑定的供应商
		invoicePo.setLiisubsupplierid(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),supplierID));
						
		String auditState = Utility.getName(request.getParameter("auditState"));
		if (auditState.equals("1")){
			invoicePo.setLiiauditstatue("1");
			invoicePo.setLiiauditpersonid(createPerson);
		}else{
			invoicePo.setLiiauditstatue("0");
		}
		
		invoicePo.setLiiisinvoiceform("1");
		invoiceMgr.insertInvoiceByBill(invoicePo,invoiceEntryPo,personInfoPo.getPersoncompanyid(),logPo);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
    /**
	 * 
	 */
	public String initInvoiceBySalesInvoiceDetail() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		invoicePo = new InvoicePo();
		invoicePo.setLiiid(invoiceID);
		invoicePo = invoiceMgr.getInvocePo(invoicePo);
		
		invoiceEntryPo = new InvoiceEntryPo();
		invoiceEntryPo.setLieieinvoiceid(invoiceID);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
	    int count = invoiceMgr.getInvoiceEntryCount(invoiceEntryPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);			
			invoiceEntryList=invoiceMgr.getInvoiceEntryPoList(invoiceEntryPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			invoiceEntryList = null;
		}
				
		invoiceEntryPo = invoiceMgr.getInvoceSum(invoicePo);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String initInvoiceBySalesInvoiceDelete() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));		
		request.setAttribute("invoiceID",invoiceID);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String invoiceBySalesInvoiceDelete() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2表示删除
		logPo.setsLogContent("发票：" + invoiceID + "删除!");
		
		InvoicePo ipo = new InvoicePo();
		ipo.setLiiid(invoiceID);		
		invoiceMgr.deleteInvoiceByBill(ipo, logPo);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
				
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String initInvoiceBySalesInvoiceUpdate() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/				
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		
		invoicePo = new InvoicePo();
		invoicePo.setLiiid(invoiceID);
		invoicePo = invoiceMgr.getInvocePo(invoicePo);
		
		InvoiceEntryPo invoiceEntryPo = new InvoiceEntryPo();
		invoiceEntryPo.setLieieinvoiceid(invoiceID);		
		invoiceEntryList=invoiceMgr.getInvoiceEntryPoList(invoiceEntryPo);
		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String invoiceBySalesInvoiceUpdate() throws Exception {		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
	
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
	
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);
	
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		if (invoicePo == null){
			invoicePo = new InvoicePo();
		}
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));
		invoicePo.setLiiauditpersonid(createPerson);		
		invoicePo.setLiisupplierid(Utility.getName(request.getParameter("supplierID")));
		invoicePo.setLiidepartmentid(personInfoPo.getDepartmentID());
		invoicePo.setLiicreatepersonid(Utility.getName(request.getParameter("liicreatepersonid")));
		invoicePo.setLiiid(invoiceID);
		invoicePo.setLiiremark(Utility.getName(request.getParameter("remark")));
		invoicePo.setLiitypeID(Utility.getName(request.getParameter("liitypeID")));
		invoicePo.setLiidate(Utility.getName(request.getParameter("liidate")));
		invoicePo.setIsupdate("1");	
		invoicePo.setLiiauditstatue(Utility.getName(request.getParameter("auditState")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 3表示修改
		logPo.setsLogContent("发票：" + invoiceID + "修改!");
		
		// 根据公司和制造商查询绑定的供应商
		invoicePo.setLiisubsupplierid(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),invoicePo.getLiisupplierid()));

		invoicePo.setLiiisinvoiceform("1");
		invoiceMgr.updateInvoiceByBill(invoicePo,invoiceEntryPo,personInfoPo.getPersoncompanyid(),logPo);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**********************************************************************************************************************************************/
	
	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}
	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public BrandMgr getBrandMgr() {
		return brandMgr;
	}
	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}
	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}
	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}
	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}
	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}
	public List<InventoryPo> getSelectBillList() {
		return selectBillList;
	}
	public void setSelectBillList(List<InventoryPo> selectBillList) {
		this.selectBillList = selectBillList;
	}
	public List<InvoiceTypePo> getInvoiceTypeList() {
		return invoiceTypeList;
	}
	public void setInvoiceTypeList(List<InvoiceTypePo> invoiceTypeList) {
		this.invoiceTypeList = invoiceTypeList;
	}
	public List<InventoryEntryPo> getInventoryEntryList() {
		return inventoryEntryList;
	}
	public void setInventoryEntryList(List<InventoryEntryPo> inventoryEntryList) {
		this.inventoryEntryList = inventoryEntryList;
	}
	public InvoiceSelectBillMgr getInvoiceSelectBillMgr() {
		return invoiceSelectBillMgr;
	}
	public void setInvoiceSelectBillMgr(InvoiceSelectBillMgr invoiceSelectBillMgr) {
		this.invoiceSelectBillMgr = invoiceSelectBillMgr;
	}
	public InvoiceEntryPo getInvoiceEntryPo() {
		return invoiceEntryPo;
	}
	public void setInvoiceEntryPo(InvoiceEntryPo invoiceEntryPo) {
		this.invoiceEntryPo = invoiceEntryPo;
	}
	public List<InvoiceEntryPo> getInvoiceEntryList() {
		return invoiceEntryList;
	}
	public void setInvoiceEntryList(List<InvoiceEntryPo> invoiceEntryList) {
		this.invoiceEntryList = invoiceEntryList;
	}
	public List<InvoicePo> getInvoiceList() {
		return invoiceList;
	}
	public void setInvoiceList(List<InvoicePo> invoiceList) {
		this.invoiceList = invoiceList;
	}
	public InvoiceMgr getInvoiceMgr() {
		return invoiceMgr;
	}
	public void setInvoiceMgr(InvoiceMgr invoiceMgr) {
		this.invoiceMgr = invoiceMgr;
	}
	public InvoicePo getInvoicePo() {
		return invoicePo;
	}
	public void setInvoicePo(InvoicePo invoicePo) {
		this.invoicePo = invoicePo;
	}
	public VoucherMgr getVoucherMgr() {
		return voucherMgr;
	}
	public void setVoucherMgr(VoucherMgr voucherMgr) {
		this.voucherMgr = voucherMgr;
	}
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
	public ProcurementReceiptMgr getProcurementReceiptMgr() {
		return procurementReceiptMgr;
	}
	public void setProcurementReceiptMgr(ProcurementReceiptMgr procurementReceiptMgr) {
		this.procurementReceiptMgr = procurementReceiptMgr;
	}
	
}
