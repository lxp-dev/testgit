package com.pengsheng.eims.yklogistics.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.yklogistics.mgr.InvoiceMgr;
import com.pengsheng.eims.yklogistics.mgr.InvoiceSelectBillMgr;
import com.pengsheng.eims.yklogistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.yklogistics.mgr.VoucherMgr;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.logistics.persistence.InvoiceTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

@SuppressWarnings("serial")
public class InvoiceAction extends BaseAction {
	
	private LogisticsLogMgr yklogisticsLogMgr = null;
	private PersonPermissionMgr personPermissionMgr = null;	
	private BrandMgr brandMgr = null;
	private List<GoodsCategoryPo> goodsCategorys = null;
	private InventoryPo inventoryPo = null;
	private InvoicePo invoicePo = null;	
	private InvoiceMgr ykinvoiceMgr = null;	
	private List<InvoicePo> invoiceList = null;	
	private List<InvoiceEntryPo> invoiceEntryList = null;	
	private InvoiceEntryPo invoiceEntryPo = null;	
	private InvoiceSelectBillMgr ykinvoiceSelectBillMgr = null;	
	private List<InventoryEntryPo> inventoryEntryList = null;
	private List<InvoiceTypePo> invoiceTypeList = null;
	private List<InventoryPo> selectBillList = null;
	private VoucherMgr ykvoucherMgr = null;
	
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
		
		invoiceTypeList = ykinvoiceMgr.getInvoiceTypeList();	//获取发票类型
		request.setAttribute("invoiceCreatePersonID", createPerson);
		
		VoucherPo po = ykvoucherMgr.selCurrentAccountPeriod();		
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
		
		int count = ykinvoiceMgr.getInvoiceCount(invoicePo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
				
	    Pagination page = new Pagination(request, count, perPage);
	    invoiceList = ykinvoiceMgr.getInvoiceList(invoicePo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			invoiceList = null;
		}
		
		invoiceTypeList = ykinvoiceMgr.getInvoiceTypeList();
		
		request.setAttribute("invoiceID", invoiceID);
		request.setAttribute("supplierID",supplierID );
		request.setAttribute("supplierName",supplierName );
		request.setAttribute("invoiceAuditStatue",invoiceAuditStatue);
		request.setAttribute("invoiceCreatePersonID",invoiceCreatePersonID );		
		request.setAttribute("invoiceStartAuditDate",invoiceStartAuditDate);
		request.setAttribute("invoiceEndAuditDate",invoiceEndAuditDate);
		request.setAttribute("invoiceStartDate",invoiceStartDate);
		request.setAttribute("invoiceEndDate",invoiceEndDate);
		request.setAttribute("invoiceTypeID", invoiceType);
		request.setAttribute("invoiceAuditDate", invoiceAuditDate);
		
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
	    
	    request.setAttribute("billid" , billid);
	    request.setAttribute("begintime" , begintime);
	    request.setAttribute("endtime" , endtime);
	    request.setAttribute("billtype" , billtype);
	    request.setAttribute("invoiceState" , invoiceState);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("supplierName" , supplierName);
	    request.setAttribute("selbspcategoryid" , goodstype);
	    
	    inventoryPo = ykinvoiceSelectBillMgr.getBillSum(inPo);
	    
	    int count = ykinvoiceSelectBillMgr.getSelBillCount(inPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
			Pagination page = new Pagination(request, count, perPage);			
			selectBillList = ykinvoiceSelectBillMgr.selSelectBill(inPo, page.getStart(), page.getPageSize());
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
		
		invoiceTypeList = ykinvoiceMgr.getInvoiceTypeList();
		
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
			inventoryEntryList = ykinvoiceSelectBillMgr.getBillGoods(inventoryEntryList,bills,invoiceType);
			bills = null;
		}
		invoiceTypeList = ykinvoiceMgr.getInvoiceTypeList();
		
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
		
		ykinvoiceMgr.insertInvoice(invoicePo,invoiceEntryPo,logPo);
		
//		logPo.setsLogResult("11"); // 11 表示成功 
//		logisticsLogMgr.insertLog(logPo);
		
		VoucherPo po = ykvoucherMgr.selCurrentAccountPeriod();		
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
		
		ykinvoiceMgr.deleteInvoice(invoiceID, logPo);
		
//		logPo.setsLogResult("11"); // 11 表示成功
//		logisticsLogMgr.insertLog(logPo);
		
		invoiceID = null;
		logPo = null;
		
		VoucherPo po = ykvoucherMgr.selCurrentAccountPeriod();		
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
		invoicePo = ykinvoiceMgr.getInvocePo(invoicePo);
		
		InvoiceEntryPo invoiceEntryPo = new InvoiceEntryPo();
		invoiceEntryPo.setLieieinvoiceid(invoiceID);
		
//	    int count = invoiceMgr.getInvoiceEntryCount(invoiceEntryPo);
//		if (count > 0) {
//			int perPage = 0;
//			if (request.getParameter("perPage") != null) {
//				perPage = new Integer((String) request.getParameter("perPage")).intValue();
//			} else if (request.getParameter("perPageNo") != null) {
//				if (!request.getParameter("perPageNo").equals("")) {
//					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
//				} else {
//					perPage = 10;
//				}
//			} else {
//				perPage = 10;
//			}
//			Pagination page = new Pagination(request, count, perPage);			
//			invoiceEntryList=invoiceMgr.getInvoiceEntryPoList(invoiceEntryPo, page.getStart(), page.getPageSize());
//			request.setAttribute(Pagination.PAGINATION, page);
//		} else {
//			invoiceEntryList = null;
//		}
		
		invoiceEntryList=ykinvoiceMgr.getInvoiceEntryPoList(invoiceEntryPo);
		
		invoiceID = null;
		invoiceEntryPo = null;
		
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
		invoicePo = ykinvoiceMgr.getInvocePo(invoicePo);
		
		InvoiceEntryPo invoiceEntryPo = new InvoiceEntryPo();
		invoiceEntryPo.setLieieinvoiceid(invoiceID);		
		invoiceEntryList=ykinvoiceMgr.getInvoiceEntryPoList(invoiceEntryPo);
		
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
		
		ykinvoiceMgr.updateInvoice(invoicePo,invoiceEntryPo,logPo);
		
//		logPo.setsLogResult("11"); // 11 表示成功
//		logisticsLogMgr.insertLog(logPo);
		
		VoucherPo po = ykvoucherMgr.selCurrentAccountPeriod();		
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
		invoicePo.setLiiid("");
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		
		if (auditStatue.equalsIgnoreCase("q")){
			logPo.setsLogResult(moduleID); // 表示模块名称 
//			logPo.setsLogResult("12"); // 12 表示开始 
			logPo.setsLogOpID("5");    // 5 表示全部审核
			logPo.setsLogContent("全部审核发票：" + "all invoices");			
//			logisticsLogMgr.insertLog(logPo);  //新增日志
			
			ykinvoiceMgr.auditAll(invoicePo,logPo);
			
//			logPo.setsLogResult("11"); // 11 表示成功
//			logPo.setsLogOpID("5");    // 5 表示全部审核
//			logPo.setsLogContent("all invoices");			
//			logisticsLogMgr.insertLog(logPo);  //新增日志
			
		}else if (auditStatue.equalsIgnoreCase("f")){
			logPo.setsLogResult(moduleID); // 表示模块名称 
//			logPo.setsLogResult("12"); // 12 表示开始 
			logPo.setsLogOpID("6");    // 5 表示全部反审核
			logPo.setsLogContent("全部反审核发票：" + "all invoices");			
//			logisticsLogMgr.insertLog(logPo);  //新增日志
			
			ykinvoiceMgr.auditUnAll(logPo);
			
//			logPo.setsLogResult("11"); // 11 表示成功
//			logPo.setsLogOpID("6");    // 5 表示全部反审核
//			logPo.setsLogContent("all invoices");			
//			logisticsLogMgr.insertLog(logPo);  //新增日志
		}
		
		request.setAttribute("invoiceCreatePersonID",createPerson);
		
		VoucherPo po = ykvoucherMgr.selCurrentAccountPeriod();		
		request.setAttribute("invoiceStartDate",Utility.getName(po.getsLvvDateTopLimit()));
		request.setAttribute("invoiceEndDate",Utility.getName(po.getsLvvDateLowerLimit()));
		if (Utility.getName(po.getsLvvDateTopLimit()).length() == 10){
			request.setAttribute("invoiceAuditDate",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
		}
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
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
		
		invoiceEntryList = ykinvoiceMgr.getInvoiceBillList(billID);
		
		return SUCCESS;
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
	public InvoicePo getInvoicePo() {
		return invoicePo;
	}
	public void setInvoicePo(InvoicePo invoicePo) {
		this.invoicePo = invoicePo;
	}


	public LogisticsLogMgr getYklogisticsLogMgr() {
		return yklogisticsLogMgr;
	}


	public void setYklogisticsLogMgr(LogisticsLogMgr yklogisticsLogMgr) {
		this.yklogisticsLogMgr = yklogisticsLogMgr;
	}


	public InvoiceMgr getYkinvoiceMgr() {
		return ykinvoiceMgr;
	}


	public void setYkinvoiceMgr(InvoiceMgr ykinvoiceMgr) {
		this.ykinvoiceMgr = ykinvoiceMgr;
	}


	public InvoiceSelectBillMgr getYkinvoiceSelectBillMgr() {
		return ykinvoiceSelectBillMgr;
	}


	public void setYkinvoiceSelectBillMgr(
			InvoiceSelectBillMgr ykinvoiceSelectBillMgr) {
		this.ykinvoiceSelectBillMgr = ykinvoiceSelectBillMgr;
	}


	public VoucherMgr getYkvoucherMgr() {
		return ykvoucherMgr;
	}


	public void setYkvoucherMgr(VoucherMgr ykvoucherMgr) {
		this.ykvoucherMgr = ykvoucherMgr;
	}

}
