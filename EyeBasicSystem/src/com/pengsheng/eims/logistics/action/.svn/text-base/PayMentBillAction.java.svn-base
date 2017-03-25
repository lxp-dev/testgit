/**
* 项目名称 : EIMS财务物流子系统
* 包 名          ：com.pengsheng.eims.logistics.action
* 文件名称 : PayMentBillAction.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2012-05-04
*/
package com.pengsheng.eims.logistics.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.persistence.InOrOutComeTypePo;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.PayMentBillEntryPo;
import com.pengsheng.eims.logistics.persistence.PayMentBillEntryTempPo;
import com.pengsheng.eims.logistics.persistence.PayMentBillPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryTempPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.persistence.VoucherTempPo;
import com.pengsheng.eims.logistics.persistence.VoucherTypePo;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.mgr.PayMentBillMgr;
import com.pengsheng.eims.logistics.mgr.VoucherMgr;
import com.pengsheng.eims.storage.mgr.ProcurementReceiptMgr;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
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

public class PayMentBillAction extends BaseAction {
	
	private LogisticsLogMgr logisticsLogMgr = null;             //日志接口
	private PersonPermissionMgr personPermissionMgr = null;	
	private PayMentBillMgr  payMentBillMgr = null;              //Mgr接口
	private List<InvoiceEntryPo> invoiceEntryList = null;       //发票基本信息列表	
	private PayMentBillPo payMentBillPo = null;
	private PayMentBillEntryTempPo payMentBillEntryTempPo = null;
	private PayMentBillEntryPo payMentBillEntryPo = null;
	private List<PayMentBillPo> payMentBillList = null;
	private List<PayMentBillEntryPo> payMentBillEntryList = null;
	private VoucherMgr voucherMgr = null;
	private List<VoucherTypePo> voucherTopIDList = null;        //凭证基本类型列表
	private List<VoucherTypePo> voucherSubsetIDList = null;     //凭证基本具体列表
	private List<VoucherPo> voucherList = null;                 //凭证基本信息列表
	private List<VoucherEntryPo> voucherEntryList = null;       //凭证明细信息列表
	private VoucherTempPo voucherTempPo = null;                 //凭证基本信息实体数组
	private VoucherEntryTempPo voucherEntryTempPo = null;       //凭证明细信息实体数组
	private VoucherPo po = null;
	private InOrOutComeTypePo inOrOutComeTypePo = null;
	private List<InOrOutComeTypePo> inOrOutComeTypeList = null;
	private List<SupplierPo> supplierList = null;
	private List<InventoryPo> inventoryList = null;
	private InventoryPo inventoryPo = null;
	private DepartmentsMgr departmentsMgr = null;
	private List<DepartmentsPo> departmentsList = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private ProcurementReceiptMgr procurementReceiptMgr;
	
	/**
	 * 根据系统参数设置判断创建付款单的方式
	 */
	public String initPayMentBillSwitchSel() throws Exception {		
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
		String paymentForm = Utility.getName(systemParameterPo.getFsppaymenttype());		
				
		if (paymentForm.equals("1")){
			return "initPayMentBillSimple";
		}
		if (paymentForm.equals("2")){
			return "initPayMentBillSel";
		}
		
		return "initPayMentBillSimple";
	}
	
	/**
	 * Description：初始化查询付款单
	 */
	public String initPayMentBillSel() throws Exception {
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

		request.setAttribute("createPersonID",createPerson);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("billStartTime",Utility.getName(po.getsLvvDateTopLimit()));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selPayMentBill";
		}
		
		return SUCCESS;
	}
		
	/**
	 * Description：初始化新增付款单
	 */
	public String initPayMentBillInsert() throws Exception {	

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
		
		String createPersonName = ((PersonInfoPo) session.get("person")).getPersonName();                     //获取创建人名称		
		String createPersonID = ((PersonInfoPo) session.get("person")).getId();               //获取创建人名称		
		String payMentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //新增付款单的时间		
		String payMentID = "PB"+GenerateNumber.getInstance().getGenerageNumber();                          //新增付款单的ID	
				
		request.setAttribute("payMentID" , payMentID);
		request.setAttribute("payMentDate" , payMentDate);		
		request.setAttribute("createPerson" , createPersonName);
		request.setAttribute("createPersonID" , createPersonID);
		
		//释放资源
		createPersonName = null;
		payMentDate = null;
		payMentID = null;
		
		return SUCCESS;
	}
	
	/**
	 * Description：新增付款单
	 */
	public String insertPayMentBill() throws Exception {	

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
		
		String auditState = Utility.getName(request.getParameter("auditState"));
		if (!auditState.equals("0")){
			payMentBillPo.setsLpbpbAuditStatue("1");
			payMentBillPo.setsLpbpbAuditPersonID(createPerson);
		}else{
			payMentBillPo.setsLpbpbAuditStatue("0");
		}
		
		payMentBillPo.setsLpbpbDepartmentID(personInfoPo.getDepartmentID());
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("付款单：" + Utility.getName(payMentBillPo.getsLpbpbID())+"新增!");

		payMentBillEntryList = new ArrayList<PayMentBillEntryPo>();
		int payMentBillCount = payMentBillEntryTempPo.getsLpbpbeInvoiceID().length;
		for (int i = 0; i < payMentBillCount; i++){
			PayMentBillEntryPo payMentBillEntryPo = new PayMentBillEntryPo();
			payMentBillEntryPo.setsLpbpbeBillID(Utility.getName(payMentBillPo.getsLpbpbID()));
			payMentBillEntryPo.setsLpbpbeInvoiceID(Utility.getName(payMentBillEntryTempPo.getsLpbpbeInvoiceID()[i]));
			payMentBillEntryPo.setsLpbpbeCostPriceAmount(Utility.getName(payMentBillEntryTempPo.getsLpbpbeCostPriceAmount()[i]));
			payMentBillEntryPo.setsLpbpbePayMentAmount(Utility.getName(payMentBillEntryTempPo.getsLpbpbePayMentAmount()[i]));
			
			payMentBillEntryList.add(payMentBillEntryPo);
		}
		
		payMentBillPo.setsLpbpbCurrentPayMentAmount(payMentBillPo.getsLpbpbPayMentAmount());
		payMentBillPo.setsLpbpbDate(Utility.getName(voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid()).getsLvvDateLowerLimit()));
		
		// 根据公司和制造商查询绑定的供应商
		payMentBillPo.setsLpbpbSubSupplierID(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),Utility.getName(payMentBillPo.getsLpbpbSupplierID())));
			
		payMentBillMgr.insertPayMentBill(payMentBillPo,payMentBillEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询付款单
	 */
	public String selPayMentBill() throws Exception {
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
		
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));   //付款单号		
		String supplierName = Utility.getName(request.getParameter("supplierName"));     //制造商名称
		String supplierID = Utility.getName(request.getParameter("supplierID"));         //制造商ID
		String auditStatue = Utility.getName(request.getParameter("auditStatue"));       //审核状态
		String billStartTime = Utility.getName(request.getParameter("billStartTime"));   //付款单起始时间
		String billEndTime = Utility.getName(request.getParameter("billEndTime"));       //付款单终止时间
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime")); //审核起始时间
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));     //审核终止时间		
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
	
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(payMentBillID);
		payMentBillPo.setsLpbpbAuditStartDate(auditStartTime);
		payMentBillPo.setsLpbpbAuditEndDate(auditEndTime);
		payMentBillPo.setsLpbpbStartDate(billStartTime);
		payMentBillPo.setsLpbpbEndDate(billEndTime);
		payMentBillPo.setsLpbpbSupplierID(supplierID);
		payMentBillPo.setsLpbpbCreatePersonID(createPersonID);
		payMentBillPo.setsLpbpbAuditStatue(auditStatue);
		payMentBillPo.setsLpbpbTypeID("1");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			payMentBillPo.setsLpbpbCompanyID(personInfoPo.getPersoncompanyid());
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
		
		int count = payMentBillMgr.getPayMentBillCount(payMentBillPo);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			payMentBillList = payMentBillMgr.getPayMentBillList(payMentBillPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			payMentBillList = null;
		}
		
		request.setAttribute("payMentBillID" , payMentBillID);
		request.setAttribute("supplierName" , supplierName);
		request.setAttribute("supplierID" , supplierID);
		request.setAttribute("auditStatue" , auditStatue);
		request.setAttribute("billStartTime" , billStartTime);
		request.setAttribute("billEndTime" , billEndTime);
		request.setAttribute("auditStartTime" , auditStartTime);
		request.setAttribute("auditEndTime" , auditEndTime);
		request.setAttribute("createPersonID" , createPersonID);
		
		//释放资源
		payMentBillID = null;
		supplierName = null;
		supplierID = null;
		auditStatue = null;
		billStartTime = null;
		billEndTime = null;
		auditStartTime = null;
		auditEndTime = null;
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询付款单详情信息
	 */
	public String selPayMentBillDetail() throws Exception {

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

		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(payMentBillID);
		
		payMentBillPo = payMentBillMgr.getPayMentBillDetail(payMentBillPo);
		payMentBillEntryList = payMentBillMgr.getPayMentBillEntryDetail(payMentBillPo);
		
		return SUCCESS;		
	}
	
	/**
	 * Description：初始化修改付款单
	 */
	public String initPayMentBillUpdate() throws Exception {

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

		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(payMentBillID);
		
		payMentBillPo = payMentBillMgr.getPayMentBillDetail(payMentBillPo);
		payMentBillEntryList = payMentBillMgr.getPayMentBillEntryDetail(payMentBillPo);
		
		return SUCCESS;	
	}
	
	/**
	 * Description：根据参数修改付款单
	 */
	public String updatePayMentBill() throws Exception {

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
		
		String auditState = Utility.getName(request.getParameter("auditState"));
		if (!auditState.equals("0")){
			payMentBillPo.setsLpbpbAuditStatue("1");
			payMentBillPo.setsLpbpbAuditPersonID(createPerson);
		}else{
			payMentBillPo.setsLpbpbAuditStatue("0");
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("付款单：" + Utility.getName(payMentBillPo.getsLpbpbID()+"修改!"));

		payMentBillEntryList = new ArrayList<PayMentBillEntryPo>();
		int payMentBillCount = payMentBillEntryTempPo.getsLpbpbeInvoiceID().length;
		for (int i = 0; i < payMentBillCount; i++){
			PayMentBillEntryPo payMentBillEntryPo = new PayMentBillEntryPo();
			payMentBillEntryPo.setsLpbpbeBillID(Utility.getName(payMentBillPo.getsLpbpbID()));
			payMentBillEntryPo.setsLpbpbeInvoiceID(Utility.getName(payMentBillEntryTempPo.getsLpbpbeInvoiceID()[i]));
			payMentBillEntryPo.setsLpbpbeCostPriceAmount(Utility.getName(payMentBillEntryTempPo.getsLpbpbeCostPriceAmount()[i]));
			payMentBillEntryPo.setsLpbpbePayMentAmount(Utility.getName(payMentBillEntryTempPo.getsLpbpbePayMentAmount()[i]));
			
			payMentBillEntryList.add(payMentBillEntryPo);
		}		

		payMentBillPo.setsLpbpbCurrentPayMentAmount(payMentBillPo.getsLpbpbPayMentAmount());
		
		payMentBillMgr.updatePayMentBill(payMentBillPo,payMentBillEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化删除付款单
	 */
	public String initPayMentBillDelete() throws Exception {

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
		
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		request.setAttribute("payMentBillID",payMentBillID);
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数删除付款单
	 */
	public String deletePayMentBill() throws Exception {

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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("付款单：" + Utility.getName(payMentBillPo.getsLpbpbID()+"删除!"));

		payMentBillMgr.deletePayMentBill(payMentBillPo, logPo);		

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}	
	
	/**
	 * Description：初始化反审付款单
	 */
	public String initAuditUnPayMentBill() throws Exception {

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
		
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		request.setAttribute("payMentBillID",payMentBillID);
		
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数反审付款单
	 */
	public String auditUnPayMentBill() throws Exception {

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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("付款单：" + Utility.getName(payMentBillPo.getsLpbpbID()+"反审核!"));

		boolean flag = payMentBillMgr.auditUnPayMentBill(payMentBillPo, logPo);
        
		this.clearMessages();
		if (flag){
        	this.addActionMessage(getText("付款单反审核成功!"));
        }else{
        	this.addActionMessage(getText("付款单反审核失败,此单已做凭证!"));
        }		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数反审付款单
	 */
	public String initPartAuditPayMentBill() throws Exception {

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
		
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		request.setAttribute("payMentBillID",payMentBillID);
		
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数反审付款单
	 */
	public String partAuditPayMentBill() throws Exception {

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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("5");    // 2 表示删除
		logPo.setsLogContent("付款单：" + Utility.getName(payMentBillPo.getsLpbpbID()+"审核!"));

		payMentBillMgr.partAuditPayMentBill(payMentBillPo, logPo);
        
		this.clearMessages();
		this.addActionMessage(getText("付款单审核成功!"));		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化查询发票
	 */
	public String initInvoiceOpenSel() throws Exception {
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
		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询发票
	 */
	public String selInvoiceOpen() throws Exception {
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
		
		String invoiceID = Utility.getName(request.getParameter("invoiceID"));   //发票号		
		String supplierName = Utility.getName(request.getParameter("supplierName"));     //制造商名称
		String supplierID = Utility.getName(request.getParameter("supplierID"));         //制造商ID
		
		String billStartTime = Utility.getName(request.getParameter("billStartTime"));   //付款单起始时间
		String billEndTime = Utility.getName(request.getParameter("billEndTime"));       //付款单终止时间
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime")); //审核起始时间
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));     //审核终止时间		
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
	
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(invoiceID);
		payMentBillPo.setsLpbpbAuditStartDate(auditStartTime);
		payMentBillPo.setsLpbpbAuditEndDate(auditEndTime);
		payMentBillPo.setsLpbpbStartDate(billStartTime);
		payMentBillPo.setsLpbpbEndDate(billEndTime);
		payMentBillPo.setsLpbpbSupplierID(supplierID);
		payMentBillPo.setsLpbpbCreatePersonID(createPersonID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			payMentBillPo.setsLpbpbCompanyID(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		int count = payMentBillMgr.getInvoiceCount(payMentBillPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			invoiceEntryList = payMentBillMgr.getInvoiceList(payMentBillPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			invoiceEntryList = null;
		}
		
		request.setAttribute("invoiceID" , invoiceID);
		request.setAttribute("supplierName" , supplierName);
		request.setAttribute("supplierID" , supplierID);
		request.setAttribute("billStartTime" , billStartTime);
		request.setAttribute("billEndTime" , billEndTime);
		request.setAttribute("auditStartTime" , auditStartTime);
		request.setAttribute("auditEndTime" , auditEndTime);
		request.setAttribute("createPersonID" , createPersonID);
		
		//释放资源
		invoiceID = null;
		supplierName = null;
		supplierID = null;
		billStartTime = null;
		billEndTime = null;
		auditStartTime = null;
		auditEndTime = null;
		
		return SUCCESS;
	}
	
   /************* 付款单凭证 ***************************************************************************************************************************/
	
	/**
	 * Description：初始化查询付款单凭证
	 */
	public String initPayMentVoucherSel() throws Exception {
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

		voucherTopIDList = voucherMgr.getVoucherTypeByID("0");
		request.setAttribute("createPersonID",createPerson);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("billStartTime",Utility.getName(po.getsLvvDateTopLimit()));
		
		String softwarePath = voucherMgr.getCurrentFinanceSoftwarePath();
		request.setAttribute("softwarePath",Utility.getName(softwarePath));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selPayMentVoucher";
		}
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询付款单凭证
	 */
	public String selPayMentVoucher() throws Exception {
		
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
		
		String voucherID = Utility.getName(request.getParameter("voucherID"));           //凭证号
		String supplierName = Utility.getName(request.getParameter("supplierName"));     //制造商名称
		String supplierID = Utility.getName(request.getParameter("supplierID"));         //制造商ID
		String auditStatue = Utility.getName(request.getParameter("auditStatue"));       //审核状态
		String postStatue = Utility.getName(request.getParameter("postStatue"));         //过账标识
		String billStartTime = Utility.getName(request.getParameter("billStartTime"));   //凭证起始时间
		String billEndTime = Utility.getName(request.getParameter("billEndTime"));       //凭证终止时间
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime")); //审核起始时间
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));     //审核终止时间
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));     //凭证具体类型
		String bVoucherType = Utility.getName(request.getParameter("bVoucherType"));     //凭证基本类型
		String parentID = Utility.getName(request.getParameter("parentID"));
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String bdpdepartmentname = Utility.getName(request.getParameter("bdpdepartmentname"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		
		String softwarePath = voucherMgr.getCurrentFinanceSoftwarePath();
		request.setAttribute("softwarePath",Utility.getName(softwarePath));
		
		if (!parentID.equals("")){
			voucherSubsetIDList = voucherMgr.getVoucherTypeByID(parentID);
		}
		voucherTopIDList = voucherMgr.getVoucherTypeByID("0");
		
		po = new VoucherPo();
		po.setsLvvID(voucherID);
		po.setsLvvSupplierID(supplierID);
		po.setsLvvAuditStatue(auditStatue);
		po.setsLvvAuditDateTopLimit(auditStartTime);
		po.setsLvvAuditDateLowerLimit(auditEndTime);
		po.setsLvvDateTopLimit(billStartTime);
		po.setsLvvDateLowerLimit(billEndTime);
		po.setsLvvVoucherTypeID(sVoucherType);
		po.setsLvvPosting(postStatue);		
		po.setsLvvPersonID(createPersonID);
		po.setsLvvDepartmentID(departmentID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setsLvvCompanyID(personInfoPo.getPersoncompanyid());
		}
		
		if (sVoucherType.equals("12")){
			po.setsLvvTypeID("3");
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
		
		int count = payMentBillMgr.getVoucherCount(po);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			voucherList = payMentBillMgr.getVoucherList(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			voucherList = null;
		}
		
		request.setAttribute("voucherID" , voucherID);
		request.setAttribute("supplierName" , supplierName);
		request.setAttribute("supplierID" , supplierID);
		request.setAttribute("auditStatue" , auditStatue);
		request.setAttribute("postStatue" , postStatue);
		request.setAttribute("billStartTime" , billStartTime);
		request.setAttribute("billEndTime" , billEndTime);
		request.setAttribute("auditStartTime" , auditStartTime);
		request.setAttribute("auditEndTime" , auditEndTime);
		request.setAttribute("sVoucherType" , sVoucherType);
		request.setAttribute("bVoucherType" , bVoucherType);
		request.setAttribute("parentID" , bVoucherType);
		request.setAttribute("subID" , sVoucherType);
		request.setAttribute("createPersonID" , createPersonID);
		request.setAttribute("departmentID" , departmentID);
		request.setAttribute("bdpdepartmentname" , bdpdepartmentname);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化新增付款单凭证
	 */
	public String initPayMentVoucherInsert() throws Exception {	

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
		
		String createPersonName = personInfoPo.getPersonName();                     //获取创建人名称		
		String voucherDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //新增凭证的时间		
		String voucherID = "V"+GenerateNumber.getInstance().getGenerageNumber();                          //新增凭证的ID	
		
		voucherTopIDList = voucherMgr.getVoucherTypeByID("0");
		
		request.setAttribute("voucherID" , voucherID);
		request.setAttribute("voucherDate" , voucherDate);		
		request.setAttribute("createPerson" , createPersonName);
		request.setAttribute("createPersonID" , createPerson);
		
		return SUCCESS;
	}
	
	/**
	 * Description：新增付款单凭证
	 */
	public String insertPayMentVoucher() throws Exception {	

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

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("凭证：" + Utility.getName(po.getsLvvID()) + "新增!");
		
		int billCount = 0;
        if (voucherEntryTempPo != null){
        	billCount = voucherEntryTempPo.getsLveveBillID().length;
        }
		voucherEntryList = new ArrayList<VoucherEntryPo>();
		for (int i = 0; i < billCount; i++){
			VoucherEntryPo voucherEntryPo = new VoucherEntryPo();
			voucherEntryPo.setsLveveVoucherID(Utility.getName(po.getsLvvID()));
			voucherEntryPo.setsLveveBillID(voucherEntryTempPo.getsLveveBillID()[i]);
			voucherEntryPo.setsCostPriceAmount(voucherEntryTempPo.getsCostPriceAmount()[i]);
			
			voucherEntryList.add(voucherEntryPo);
		}
	
		voucherTopIDList = voucherMgr.getVoucherTypeByID("0");
		
		String auditState = Utility.getName(request.getParameter("auditState"));
		if (!auditState.equals("0")){
			po.setsLvvAuditStatue("1");
			po.setsLvvAuditPersonID(createPerson);
		}else{
			po.setsLvvAuditStatue("0");
		}
		po.setsLvvDate(Utility.getName(voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid()).getsLvvDateLowerLimit()));
		
		po.setsLvvCreateDptID(personInfoPo.getDepartmentID());
		po.setsLvvAuditDptID(personInfoPo.getDepartmentID());
		if ("3".equals(Utility.getName(po.getsLvvTypeID()))){
			po.setsLvvFranchiseeDptID(po.getsLvvSupplierID());
			po.setsLvvSupplierID("");
		}
		
		// 根据公司和制造商查询绑定的供应商
		po.setsLvvSubSupplierID(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),po.getsLvvSupplierID()));
				
		payMentBillMgr.insertVoucher(po,voucherEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询付款单凭证详情信息
	 */
	public String selPayMentVoucherDetail() throws Exception {

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

		String voucherID = Utility.getName(request.getParameter("voucherID"));
		VoucherPo voucherPo = new VoucherPo();
		voucherPo.setsLvvID(voucherID);
		
		po = payMentBillMgr.getPayMentVoucherDetail(voucherPo);
		voucherEntryList = payMentBillMgr.getPayMentVoucherEntryDetail(voucherPo);
		
		return SUCCESS;		
	}
	
	/**
	 * Description：初始化修改付款单凭证
	 */
	public String initPayMentVoucherUpdate() throws Exception {

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

		String voucherID = Utility.getName(request.getParameter("voucherID"));
		VoucherPo voucherPo = new VoucherPo();
		voucherPo.setsLvvID(voucherID);
		
		po = payMentBillMgr.getPayMentVoucherDetail(voucherPo);
		voucherEntryList = payMentBillMgr.getPayMentVoucherEntryDetail(voucherPo);
		
		return SUCCESS;	
	}
	
	/**
	 * Description：根据参数修改付款单凭证
	 */
	public String updatePayMentVoucher() throws Exception {

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
				
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("凭证：" + Utility.getName(po.getsLvvID())+"修改!");
		
		String auditState = Utility.getName(request.getParameter("auditState"));
		if (auditState.equals("1")){
			po.setsLvvAuditStatue("1");
			po.setsLvvAuditPersonID(createPerson);
		}else{
			po.setsLvvAuditStatue("0");
		}
		
		po.setsLvvAuditDptID(personInfoPo.getDepartmentID());
		
		payMentBillMgr.updateVoucher(po, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化删除付款单凭证
	 */
	public String initPayMentVoucherDelete() throws Exception {

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
		
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		request.setAttribute("voucherID",voucherID);
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数删除凭证
	 */
	public String deletePayMentVoucher() throws Exception {

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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("凭证：" + Utility.getName(po.getsLvvID()+"删除!"));

		payMentBillMgr.deleteVoucher(po, logPo);	

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}	
	
	/**
	 * Description：开窗查询付款单
	 */
	public String initPayMentBillOpenSel() throws Exception {
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
		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询付款单
	 */
	public String selPayMentBillOpen() throws Exception {
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
		
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));   //付款单号		
		String supplierName = Utility.getName(request.getParameter("supplierName"));     //制造商名称
		String supplierID = Utility.getName(request.getParameter("supplierID"));         //制造商ID
		String billStartTime = Utility.getName(request.getParameter("billStartTime"));   //付款单起始时间
		String billEndTime = Utility.getName(request.getParameter("billEndTime"));       //付款单终止时间
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime")); //审核起始时间
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));     //审核终止时间
	
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(payMentBillID);
		payMentBillPo.setsLpbpbAuditStartDate(auditStartTime);
		payMentBillPo.setsLpbpbAuditEndDate(auditEndTime);
		payMentBillPo.setsLpbpbStartDate(billStartTime);
		payMentBillPo.setsLpbpbEndDate(billEndTime);
		payMentBillPo.setsLpbpbSupplierID(supplierID);
		payMentBillPo.setsLpbpbAuditStatue("1");
		payMentBillPo.setsLpbpbIsVoucher("0");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			payMentBillPo.setsLpbpbCompanyID(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		int count = payMentBillMgr.getPayMentBillCount(payMentBillPo);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			payMentBillList = payMentBillMgr.getPayMentBillList(payMentBillPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			payMentBillList = null;
		}
		
		request.setAttribute("payMentBillID" , payMentBillID);
		request.setAttribute("supplierName" , supplierName);
		request.setAttribute("supplierID" , supplierID);
		request.setAttribute("billStartTime" , billStartTime);
		request.setAttribute("billEndTime" , billEndTime);
		request.setAttribute("auditStartTime" , auditStartTime);
		request.setAttribute("auditEndTime" , auditEndTime);
		
		//释放资源
		payMentBillID = null;
		supplierName = null;
		supplierID = null;
		billStartTime = null;
		billEndTime = null;
		auditStartTime = null;
		auditEndTime = null;
		
		return SUCCESS;
	}

/************* 制造商往来账查询 ***************************************************************************************************************************/
	
	/**
	 * Description：初始化制造商往来账查询
	 */
	public String initSupplierCurrentAccountSel() throws Exception {
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
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "supplierCurrentAccountSel";
		}
		
		return SUCCESS;
	}
	
	/**
	 * Description：制造商往来账查询
	 */
	public String supplierCurrentAccountSel() throws Exception {
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
		String startDate = Utility.getName(request.getParameter("startDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		String payMentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("startDate",startDate);
		request.setAttribute("endDate",(endDate.equals("") ? payMentDate :endDate));
		
		SupplierPo supplierPo = new SupplierPo();
		supplierPo.setBspid(supplierID);
		supplierPo.setBspsuppliername(supplierName);
		supplierPo.setStartDate(startDate);
		supplierPo.setEndDate(endDate);
		supplierPo.setBspcompanyid(personInfoPo.getPersoncompanyid());
		
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
		
		int count = payMentBillMgr.getSupplierCurrentAccountCount(supplierPo);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			supplierList = payMentBillMgr.getSupplierCurrentAccountList(supplierPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			supplierList = null;
		}
		
		String amountSum = Utility.getName(payMentBillMgr.getSupplierAccount(supplierPo));
		request.setAttribute("amountSum",amountSum);
		
		return SUCCESS;
	}
	
	/**
	 * Description：制造商往来账详情
	 */
	public String supplierCurrentAccountDetail() throws Exception {
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
		String startDate = Utility.getName(request.getParameter("startDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("startDate",startDate);
		request.setAttribute("endDate",endDate);
		
		SupplierPo supplierPo = new SupplierPo();
		supplierPo.setBspid(supplierID);
		supplierPo.setBspsuppliername(supplierName);
		supplierPo.setStartDate(startDate);
		supplierPo.setEndDate(endDate);
		supplierPo.setBspcompanyid(personInfoPo.getPersoncompanyid());
		
		inventoryPo = new InventoryPo();
		inventoryPo.setCsticostpriceamount(payMentBillMgr.getSupplierBeginningAccount(supplierPo));
		inventoryPo.setNotPayMentAmount(payMentBillMgr.getSupplierEndAccount(supplierPo));
		
		inventoryList = payMentBillMgr.getSupplierCurrentAccountDetail(supplierPo);
		
		return SUCCESS;
	}

/************* 收支类型 ***************************************************************************************************************************/
	
	/**
	 * Description：初始化收支类型查询
	 */
	public String initInorOutComeType() throws Exception {
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
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "inorOutComeTypeSel";
		}
		
		return SUCCESS;
	}
	
	/**
	 * Description：收支类型查询
	 */
	public String inorOutComeTypeSel() throws Exception {
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
		
		String sLioioTypeID = Utility.getName(request.getParameter("inOrOutComeTypeID"));   //科目号		
		String sLioioTypeName = Utility.getName(request.getParameter("inOrOutComeTypeName"));     //制造商名称
			
		inOrOutComeTypePo = new InOrOutComeTypePo();
		inOrOutComeTypePo.setsLioioTypeID(sLioioTypeID);
		inOrOutComeTypePo.setsLioioTypeName(sLioioTypeName);
		
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
		
		int count = payMentBillMgr.getInOrOutComeTypeCount(inOrOutComeTypePo);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			inOrOutComeTypeList = payMentBillMgr.getInOrOutComeTypeList(inOrOutComeTypePo,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			inOrOutComeTypeList = null;
		}
		
		request.setAttribute("inOrOutComeTypeID" , sLioioTypeID);
		request.setAttribute("inOrOutComeTypeName" , sLioioTypeName);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化收支类型新增
	 */
	public String initInorOutComeTypeInsert() throws Exception {
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
		
		return SUCCESS;
	}
	
	/**
	 * Description：收支类型新增
	 */
	public String inorOutComeTypeInsert() throws Exception {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("收支类型：" + Utility.getName(inOrOutComeTypePo.getsLioioTypeID()+"新增!"));

		int count = payMentBillMgr.isExistsInOrOutComeType(inOrOutComeTypePo);
		if (count == 0){
			if (Utility.getName(inOrOutComeTypePo.getsLioioInOrOutFlag()).equals("")){
				inOrOutComeTypePo.setsLioioInOrOutFlag("2");//支出类别
			}
			payMentBillMgr.insertInOrOutComeType(inOrOutComeTypePo, logPo);
		}else{
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.repeat"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}	
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化收支类型修改
	 */
	public String initInorOutComeTypeUpdate() throws Exception {
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
		
		String sLioioID = Utility.getName(request.getParameter("typeID"));
		inOrOutComeTypePo = new InOrOutComeTypePo();
		inOrOutComeTypePo.setsLioioID(sLioioID);
		
		inOrOutComeTypePo = payMentBillMgr.getInOrOutComeTypeDetail(inOrOutComeTypePo);
		
		return SUCCESS;
	}
	
	/**
	 * Description：收支类型修改
	 */
	public String inorOutComeTypeUpdate() throws Exception {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("收支类别：" + Utility.getName(inOrOutComeTypePo.getsLioioID()+"修改!"));
			
		payMentBillMgr.updateInOrOutComeType(inOrOutComeTypePo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化收支类型删除
	 */
	public String initInorOutComeTypeDelete() throws Exception {
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
		
		String hid = Utility.getName(request.getParameter("hid"));
		String typeID = Utility.getName(request.getParameter("typeID"));
		String typeName = Utility.getName(request.getParameter("typeName"));
		
		request.setAttribute("hid",hid);
		request.setAttribute("typeID",typeID);
		request.setAttribute("typeName",typeName);
		
		return SUCCESS;
	}
	
	/**
	 * Description：收支类型删除
	 */
	public String inorOutComeTypeDelete() throws Exception {
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
		
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("收支类别：" + Utility.getName(inOrOutComeTypePo.getsLioioTypeID()+"删除!"));

		payMentBillMgr.deleteInOrOutComeType(inOrOutComeTypePo, logPo);		

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

 /************* 付款单(简) ***************************************************************************************************************************/

	/**
	 * Description：初始化查询付款单(简)
	 */
	public String initPayMentBillSimple() throws Exception {
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

		request.setAttribute("createPersonID",createPerson);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("billStartTime",Utility.getName(po.getsLvvDateTopLimit()));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selPayMentBillSimple";
		}
		
		return SUCCESS;
	}
		
	/**
	 * Description：初始化新增付款单(简)
	 */
	public String initPayMentBillSimpleInsert() throws Exception {	

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
		
		String createPersonName = ((PersonInfoPo) session.get("person")).getPersonName();                     //获取创建人名称		
		String createPersonID = ((PersonInfoPo) session.get("person")).getId();               //获取创建人名称		
		String payMentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //新增其他付款单的时间		
		String payMentID = "PB"+GenerateNumber.getInstance().getGenerageNumber();                          //新增其他付款单的ID	
				
		request.setAttribute("payMentID" , payMentID);
		request.setAttribute("payMentDate" , payMentDate);		
		request.setAttribute("createPerson" , createPersonName);
		request.setAttribute("createPersonID" , createPersonID);
		
		//释放资源
		createPersonName = null;
		payMentDate = null;
		payMentID = null;
		
		return SUCCESS;
	}
	
	/**
	 * Description：新增付款单(简)
	 */
	public String insertPayMentBillSimple() throws Exception {	

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
		
		String auditState = Utility.getName(request.getParameter("auditState"));
		if (!auditState.equals("0")){
			payMentBillPo.setsLpbpbAuditStatue("1");
			payMentBillPo.setsLpbpbAuditPersonID(createPerson);
		}else{
			payMentBillPo.setsLpbpbAuditStatue("0");
		}
		
		payMentBillPo.setsLpbpbDepartmentID(personInfoPo.getDepartmentID());
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("付款单：" + Utility.getName(payMentBillPo.getsLpbpbID())+"新增!");

		payMentBillEntryList = new ArrayList<PayMentBillEntryPo>();
		if (payMentBillEntryTempPo != null){
			int payMentBillCount = payMentBillEntryTempPo.getsLpbpbeInvoiceID().length;
			for (int i = 0; i < payMentBillCount; i++){
				PayMentBillEntryPo payMentBillEntryPo = new PayMentBillEntryPo();
				payMentBillEntryPo.setsLpbpbeBillID(Utility.getName(payMentBillPo.getsLpbpbID()));
				payMentBillEntryPo.setsLpbpbeInvoiceID(Utility.getName(payMentBillEntryTempPo.getsLpbpbeInvoiceID()[i]));
				payMentBillEntryPo.setsLpbpbeCostPriceAmount(Utility.getName(payMentBillEntryTempPo.getsLpbpbeCostPriceAmount()[i]));
				payMentBillEntryPo.setsLpbpbePayMentAmount(Utility.getName(payMentBillEntryTempPo.getsLpbpbePayMentAmount()[i]));
				payMentBillEntryPo.setsLpbpbeRemark(Utility.getName(payMentBillEntryTempPo.getsLpbpbeRemark()[i]));
				
				payMentBillEntryList.add(payMentBillEntryPo);
			}				
		}
		payMentBillPo.setsLpbpbDate(Utility.getName(voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid()).getsLvvDateLowerLimit()));
		
		// 根据公司和制造商查询绑定的供应商
		payMentBillPo.setsLpbpbSubSupplierID(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),Utility.getName(payMentBillPo.getsLpbpbSupplierID())));
			
		payMentBillMgr.insertPayMentBillSimple(payMentBillPo,payMentBillEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询付款单(简)
	 */
	public String selPayMentBillSimple() throws Exception {
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
		
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));   //付款单号		
		String supplierName = Utility.getName(request.getParameter("supplierName"));     //制造商名称
		String supplierID = Utility.getName(request.getParameter("supplierID"));         //制造商ID
		String auditStatue = Utility.getName(request.getParameter("auditStatue"));       //审核状态
		String billStartTime = Utility.getName(request.getParameter("billStartTime"));   //付款单起始时间
		String billEndTime = Utility.getName(request.getParameter("billEndTime"));       //付款单终止时间
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime")); //审核起始时间
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));     //审核终止时间		
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String payMentBillType = Utility.getName(request.getParameter("payMentBillType"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String bdpdepartmentname = Utility.getName(request.getParameter("bdpdepartmentname"));
		
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(payMentBillID);
		payMentBillPo.setsLpbpbAuditStartDate(auditStartTime);
		payMentBillPo.setsLpbpbAuditEndDate(auditEndTime);
		payMentBillPo.setsLpbpbStartDate(billStartTime);
		payMentBillPo.setsLpbpbEndDate(billEndTime);
		payMentBillPo.setsLpbpbSupplierID(supplierID);
		payMentBillPo.setsLpbpbCreatePersonID(createPersonID);
		payMentBillPo.setsLpbpbAuditStatue(auditStatue);
		payMentBillPo.setsLpbpbTypeID(payMentBillType);
		payMentBillPo.setsLpbpbPayMentDptID(departmentID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			payMentBillPo.setsLpbpbCompanyID(personInfoPo.getPersoncompanyid());
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
		
		int count = payMentBillMgr.getPayMentBillSimpleCount(payMentBillPo);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			payMentBillList = payMentBillMgr.getPayMentBillSimpleList(payMentBillPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			payMentBillList = null;
		}
		
		request.setAttribute("payMentBillID" , payMentBillID);
		request.setAttribute("supplierName" , supplierName);
		request.setAttribute("supplierID" , supplierID);
		request.setAttribute("auditStatue" , auditStatue);
		request.setAttribute("billStartTime" , billStartTime);
		request.setAttribute("billEndTime" , billEndTime);
		request.setAttribute("auditStartTime" , auditStartTime);
		request.setAttribute("auditEndTime" , auditEndTime);
		request.setAttribute("createPersonID" , createPersonID);
		request.setAttribute("payMentBillType" , payMentBillType);
		request.setAttribute("departmentID" , departmentID);
		request.setAttribute("bdpdepartmentname" , bdpdepartmentname);
		
		//释放资源
		payMentBillID = null;
		supplierName = null;
		supplierID = null;
		auditStatue = null;
		billStartTime = null;
		billEndTime = null;
		auditStartTime = null;
		auditEndTime = null;
		payMentBillType = null;
		bdpdepartmentname = null;
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询付款单(简)详情信息
	 */
	public String selPayMentBillSimpleDetail() throws Exception {

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

		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(payMentBillID);
		
		payMentBillPo = payMentBillMgr.getPayMentBillSimpleDetail(payMentBillPo);
		payMentBillEntryList = payMentBillMgr.getPayMentBillSimpleEntryDetail(payMentBillPo);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化修改付款单(简)
	 */
	public String initPayMentBillSimpleUpdate() throws Exception {

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

		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(payMentBillID);
		
		payMentBillPo = payMentBillMgr.getPayMentBillSimpleDetail(payMentBillPo);
		payMentBillEntryList = payMentBillMgr.getPayMentBillSimpleEntryDetail(payMentBillPo);
		
		return SUCCESS;	
	}
	
	/**
	 * Description：根据参数修改付款单(简)
	 */
	public String updatePayMentBillSimple() throws Exception {

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
		
		String auditState = Utility.getName(request.getParameter("auditState"));
		if (!auditState.equals("0")){
			payMentBillPo.setsLpbpbAuditStatue("1");
			payMentBillPo.setsLpbpbAuditPersonID(createPerson);
		}else{
			payMentBillPo.setsLpbpbAuditStatue("0");
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("付款单：" + Utility.getName(payMentBillPo.getsLpbpbID()+"修改!"));

		payMentBillEntryList = new ArrayList<PayMentBillEntryPo>();
		if (payMentBillEntryTempPo != null){
			int payMentBillCount = payMentBillEntryTempPo.getsLpbpbeInvoiceID().length;
			for (int i = 0; i < payMentBillCount; i++){
				PayMentBillEntryPo payMentBillEntryPo = new PayMentBillEntryPo();
				payMentBillEntryPo.setsLpbpbeBillID(Utility.getName(payMentBillPo.getsLpbpbID()));
				payMentBillEntryPo.setsLpbpbeInvoiceID(Utility.getName(payMentBillEntryTempPo.getsLpbpbeInvoiceID()[i]));
				payMentBillEntryPo.setsLpbpbeCostPriceAmount(Utility.getName(payMentBillEntryTempPo.getsLpbpbeCostPriceAmount()[i]));
				payMentBillEntryPo.setsLpbpbePayMentAmount(Utility.getName(payMentBillEntryTempPo.getsLpbpbePayMentAmount()[i]));
				payMentBillEntryPo.setsLpbpbeRemark(Utility.getName(payMentBillEntryTempPo.getsLpbpbeRemark()[i]));
				
				payMentBillEntryList.add(payMentBillEntryPo);
			}
		}		
		
		payMentBillMgr.updatePayMentBillSimple(payMentBillPo,payMentBillEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化删除付款单(简)
	 */
	public String initPayMentBillSimpleDelete() throws Exception {

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
		
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		request.setAttribute("payMentBillID",payMentBillID);
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数删除付款单(简)
	 */
	public String deletePayMentBillSimple() throws Exception {

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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("付款单：" + Utility.getName(payMentBillPo.getsLpbpbID()+"删除!"));

		payMentBillMgr.deletePayMentBill(payMentBillPo, logPo);		

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}	
	
	/**
	 * Description：初始化反审付款单(简)
	 */
	public String initAuditUnPayMentBillSimple() throws Exception {

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
		
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		request.setAttribute("payMentBillID",payMentBillID);
		
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数反审付款单(简)
	 */
	public String auditUnPayMentBillSimple() throws Exception {

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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("付款单：" + Utility.getName(payMentBillPo.getsLpbpbID()+"反审核!"));

		boolean flag = payMentBillMgr.auditUnPayMentBillSimple(payMentBillPo, logPo);
        
		this.clearMessages();
		if (flag){
        	this.addActionMessage(getText("付款单反审核成功!"));
        }else{
        	this.addActionMessage(getText("付款单反审核失败,此单已做凭证或已预付退款!"));
        }		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化采购单据开窗
	 */
	public String initProcurementBillOpen() throws Exception {

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
	
		String supplierName = Utility.getName(request.getParameter("supplierName"));     //制造商名称
		String supplierID = Utility.getName(request.getParameter("supplierID"));         //制造商ID
		
		request.setAttribute("supplierName" , supplierName);
		request.setAttribute("supplierID" , supplierID);
		request.setAttribute("payMentBillCheckStatus" , "1");
		
		return SUCCESS;
	}
	
	/**
	 * Description：采购单据开窗查询
	 */
	public String selProcurementBillOpen() throws Exception {
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
				
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));   //付款单号		
		String supplierName = Utility.getName(request.getParameter("supplierName"));     //制造商名称
		String supplierID = Utility.getName(request.getParameter("supplierID"));         //制造商ID
		String billStartTime = Utility.getName(request.getParameter("billStartTime"));   //付款单起始时间
		String billEndTime = Utility.getName(request.getParameter("billEndTime"));       //付款单终止时间
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime")); //审核起始时间
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));     //审核终止时间
		String payMentBillCheckStatus = Utility.getName(request.getParameter("payMentBillCheckStatus"));     //审核终止时间
		
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(payMentBillID);
		payMentBillPo.setsLpbpbAuditStartDate(auditStartTime);
		payMentBillPo.setsLpbpbAuditEndDate(auditEndTime);
		payMentBillPo.setsLpbpbStartDate(billStartTime);
		payMentBillPo.setsLpbpbEndDate(billEndTime);
		payMentBillPo.setsLpbpbSupplierID(supplierID);
		payMentBillPo.setsLpbpbTypeID("3");
		payMentBillPo.setsLpbpbCheckStatus(payMentBillCheckStatus);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			payMentBillPo.setsLpbpbCompanyID(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		int count = payMentBillMgr.getProcurementBillCount(payMentBillPo);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			payMentBillList = payMentBillMgr.getProcurementBillList(payMentBillPo,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			payMentBillList = null;
		}
		
		request.setAttribute("payMentBillID" , payMentBillID);
		request.setAttribute("supplierName" , supplierName);
		request.setAttribute("supplierID" , supplierID);
		request.setAttribute("billStartTime" , billStartTime);
		request.setAttribute("billEndTime" , billEndTime);
		request.setAttribute("auditStartTime" , auditStartTime);
		request.setAttribute("auditEndTime" , auditEndTime);
		request.setAttribute("payMentBillCheckStatus" ,payMentBillCheckStatus);
		
		//释放资源
		payMentBillID = null;
		supplierName = null;
		supplierID = null;
		billStartTime = null;
		billEndTime = null;
		auditStartTime = null;
		auditEndTime = null;
		payMentBillCheckStatus = null;
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化预付款开窗
	 */
	public String initAdvancePayMentBillOpenSel() throws Exception {

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
	
		String supplierName = Utility.getName(request.getParameter("supplierName"));     //制造商名称
		String supplierID = Utility.getName(request.getParameter("supplierID"));         //制造商ID
		
		request.setAttribute("supplierName" , supplierName);
		request.setAttribute("supplierID" , supplierID);
		
		return SUCCESS;
	}
	
	/**
	 * Description：预付款开窗查询
	 */
	public String selAdvancePayMentBillOpen() throws Exception {
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
		
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));   //付款单号		
		String supplierName = Utility.getName(request.getParameter("supplierName"));     //制造商名称
		String supplierID = Utility.getName(request.getParameter("supplierID"));         //制造商ID
		String billStartTime = Utility.getName(request.getParameter("billStartTime"));   //付款单起始时间
		String billEndTime = Utility.getName(request.getParameter("billEndTime"));       //付款单终止时间
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime")); //审核起始时间
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));     //审核终止时间
	
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(payMentBillID);
		payMentBillPo.setsLpbpbAuditStartDate(auditStartTime);
		payMentBillPo.setsLpbpbAuditEndDate(auditEndTime);
		payMentBillPo.setsLpbpbStartDate(billStartTime);
		payMentBillPo.setsLpbpbEndDate(billEndTime);
		payMentBillPo.setsLpbpbSupplierID(supplierID);
		payMentBillPo.setsLpbpbTypeID("3");
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		int count = payMentBillMgr.getPayMentBillSimpleCount(payMentBillPo);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			payMentBillList = payMentBillMgr.getPayMentBillSimpleOpenList(payMentBillPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			payMentBillList = null;
		}
		
		request.setAttribute("payMentBillID" , payMentBillID);
		request.setAttribute("supplierName" , supplierName);
		request.setAttribute("supplierID" , supplierID);
		request.setAttribute("billStartTime" , billStartTime);
		request.setAttribute("billEndTime" , billEndTime);
		request.setAttribute("auditStartTime" , auditStartTime);
		request.setAttribute("auditEndTime" , auditEndTime);
		
		//释放资源
		payMentBillID = null;
		supplierName = null;
		supplierID = null;
		billStartTime = null;
		billEndTime = null;
		auditStartTime = null;
		auditEndTime = null;
		
		return SUCCESS;
	}
	
   /************* 其他付款单 ***************************************************************************************************************************/

	/**
	 * Description：初始化查询其他付款单
	 */
	public String initPayMentBillOther() throws Exception {
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

		request.setAttribute("createPersonID",createPerson);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("billStartTime",Utility.getName(po.getsLvvDateTopLimit()));
		
		departmentsList = departmentsMgr.getDepartments();	
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selPayMentBillOther";
		}
		
		return SUCCESS;
	}
		
	/**
	 * Description：初始化新增其他付款单
	 */
	public String initPayMentBillOtherInsert() throws Exception {	

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
		
		String createPersonName = ((PersonInfoPo) session.get("person")).getPersonName();                     //获取创建人名称		
		String createPersonID = ((PersonInfoPo) session.get("person")).getId();               //获取创建人名称		
		String payMentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //新增其他付款单的时间		
		String payMentID = "PB"+GenerateNumber.getInstance().getGenerageNumber();                          //新增其他付款单的ID	
				
		request.setAttribute("payMentID" , payMentID);
		request.setAttribute("payMentDate" , payMentDate);		
		request.setAttribute("createPerson" , createPersonName);
		request.setAttribute("createPersonID" , createPersonID);
		
		//释放资源
		createPersonName = null;
		payMentDate = null;
		payMentID = null;
		
		departmentsList = departmentsMgr.getDepartments();	
		
		return SUCCESS;
	}
	
	/**
	 * Description：新增其他付款单
	 */
	public String insertPayMentBillOther() throws Exception {	

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
		
		String auditState = Utility.getName(request.getParameter("auditState"));
		if (!auditState.equals("0")){
			payMentBillPo.setsLpbpbAuditStatue("1");
			payMentBillPo.setsLpbpbAuditPersonID(createPerson);
		}else{
			payMentBillPo.setsLpbpbAuditStatue("0");
		}
		
		payMentBillPo.setsLpbpbDepartmentID(personInfoPo.getDepartmentID());
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("其他付款单：" + Utility.getName(payMentBillPo.getsLpbpbID())+"新增!");

		payMentBillEntryList = new ArrayList<PayMentBillEntryPo>();
		int payMentBillCount = payMentBillEntryTempPo.getsLpbpbeInvoiceID().length;
		for (int i = 0; i < payMentBillCount; i++){
			PayMentBillEntryPo payMentBillEntryPo = new PayMentBillEntryPo();
			payMentBillEntryPo.setsLpbpbeBillID(Utility.getName(payMentBillPo.getsLpbpbID()));
			payMentBillEntryPo.setsLpbpbeInvoiceID(Utility.getName(payMentBillEntryTempPo.getsLpbpbeInvoiceID()[i]));
			payMentBillEntryPo.setsLpbpbeCostPriceAmount(Utility.getName(payMentBillEntryTempPo.getsLpbpbeCostPriceAmount()[i]));
			payMentBillEntryPo.setsLpbpbeRemark(Utility.getName(payMentBillEntryTempPo.getsLpbpbeRemark()[i]));
			
			payMentBillEntryList.add(payMentBillEntryPo);
		}
		
		payMentBillPo.setsLpbpbDate(Utility.getName(voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid()).getsLvvDateLowerLimit()));
		
		payMentBillMgr.insertPayMentBillOther(payMentBillPo,payMentBillEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询其他付款单
	 */
	public String selPayMentBillOther() throws Exception {
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
		
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));   //付款单号		
		String supplierName = Utility.getName(request.getParameter("supplierName"));     //制造商名称
		String supplierID = Utility.getName(request.getParameter("supplierID"));         //制造商ID
		String auditStatue = Utility.getName(request.getParameter("auditStatue"));       //审核状态
		String billStartTime = Utility.getName(request.getParameter("billStartTime"));   //付款单起始时间
		String billEndTime = Utility.getName(request.getParameter("billEndTime"));       //付款单终止时间
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime")); //审核起始时间
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));     //审核终止时间		
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
	
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(payMentBillID);
		payMentBillPo.setsLpbpbAuditStartDate(auditStartTime);
		payMentBillPo.setsLpbpbAuditEndDate(auditEndTime);
		payMentBillPo.setsLpbpbStartDate(billStartTime);
		payMentBillPo.setsLpbpbEndDate(billEndTime);
		payMentBillPo.setsLpbpbSupplierID(supplierID);
		payMentBillPo.setsLpbpbCreatePersonID(createPersonID);
		payMentBillPo.setsLpbpbAuditStatue(auditStatue);
		payMentBillPo.setsLpbpbPayMentDptID(departmentID);
		
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
		
		int count = payMentBillMgr.getPayMentBillOtherCount(payMentBillPo);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			payMentBillList = payMentBillMgr.getPayMentBillOtherList(payMentBillPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			payMentBillList = null;
		}
		
		request.setAttribute("payMentBillID" , payMentBillID);
		request.setAttribute("supplierName" , supplierName);
		request.setAttribute("supplierID" , supplierID);
		request.setAttribute("auditStatue" , auditStatue);
		request.setAttribute("billStartTime" , billStartTime);
		request.setAttribute("billEndTime" , billEndTime);
		request.setAttribute("auditStartTime" , auditStartTime);
		request.setAttribute("auditEndTime" , auditEndTime);
		request.setAttribute("createPersonID" , createPersonID);
		request.setAttribute("departmentID" , departmentID);
		
		//释放资源
		payMentBillID = null;
		supplierName = null;
		supplierID = null;
		auditStatue = null;
		billStartTime = null;
		billEndTime = null;
		auditStartTime = null;
		auditEndTime = null;
		
		departmentsList = departmentsMgr.getDepartments();	
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询其他付款单详情信息
	 */
	public String selPayMentBillOtherDetail() throws Exception {

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

		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(payMentBillID);
		
		payMentBillPo = payMentBillMgr.getPayMentBillOtherDetail(payMentBillPo);
		payMentBillEntryList = payMentBillMgr.getPayMentBillOtherEntryDetail(payMentBillPo);
		
		return SUCCESS;		
	}
	
	/**
	 * Description：初始化修改其他付款单
	 */
	public String initPayMentBillOtherUpdate() throws Exception {

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

		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		payMentBillPo = new PayMentBillPo();
		payMentBillPo.setsLpbpbID(payMentBillID);
		
		payMentBillPo = payMentBillMgr.getPayMentBillOtherDetail(payMentBillPo);
		payMentBillEntryList = payMentBillMgr.getPayMentBillOtherEntryDetail(payMentBillPo);
		
		departmentsList = departmentsMgr.getDepartments();
		
		return SUCCESS;	
	}
	
	/**
	 * Description：根据参数修改其他付款单
	 */
	public String updatePayMentBillOther() throws Exception {

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
		
		String auditState = Utility.getName(request.getParameter("auditState"));
		if (!auditState.equals("0")){
			payMentBillPo.setsLpbpbAuditStatue("1");
			payMentBillPo.setsLpbpbAuditPersonID(createPerson);
		}else{
			payMentBillPo.setsLpbpbAuditStatue("0");
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("其他付款单：" + Utility.getName(payMentBillPo.getsLpbpbID()+"修改!"));

		payMentBillEntryList = new ArrayList<PayMentBillEntryPo>();
		int payMentBillCount = payMentBillEntryTempPo.getsLpbpbeInvoiceID().length;
		for (int i = 0; i < payMentBillCount; i++){
			PayMentBillEntryPo payMentBillEntryPo = new PayMentBillEntryPo();
			payMentBillEntryPo.setsLpbpbeBillID(Utility.getName(payMentBillPo.getsLpbpbID()));
			payMentBillEntryPo.setsLpbpbeInvoiceID(Utility.getName(payMentBillEntryTempPo.getsLpbpbeInvoiceID()[i]));
			payMentBillEntryPo.setsLpbpbeCostPriceAmount(Utility.getName(payMentBillEntryTempPo.getsLpbpbeCostPriceAmount()[i]));
			payMentBillEntryPo.setsLpbpbeRemark(Utility.getName(payMentBillEntryTempPo.getsLpbpbeRemark()[i]));
			
			payMentBillEntryList.add(payMentBillEntryPo);
		}		
		
		payMentBillMgr.updatePayMentBillOther(payMentBillPo,payMentBillEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化删除其他付款单
	 */
	public String initPayMentBillOtherDelete() throws Exception {

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
		
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		request.setAttribute("payMentBillID",payMentBillID);
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数删除其他付款单
	 */
	public String deletePayMentBillOther() throws Exception {

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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("其他付款单：" + Utility.getName(payMentBillPo.getsLpbpbID()+"删除!"));

		payMentBillMgr.deletePayMentBill(payMentBillPo, logPo);		

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}	
	
	/**
	 * Description：初始化反审其他付款单
	 */
	public String initAuditUnPayMentBillOther() throws Exception {

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
		
		String payMentBillID = Utility.getName(request.getParameter("payMentBillID"));
		request.setAttribute("payMentBillID",payMentBillID);
		
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数反审其他付款单
	 */
	public String auditUnPayMentBillOther() throws Exception {

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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("其他付款单：" + Utility.getName(payMentBillPo.getsLpbpbID()+"反审核!"));

		boolean flag = payMentBillMgr.auditUnPayMentBillOther(payMentBillPo, logPo);
        
		this.clearMessages();
		if (flag){
        	this.addActionMessage(getText("其他付款单反审核成功!"));
        }else{
        	this.addActionMessage(getText("其他付款单反审核失败,此单已做凭证!"));
        }		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化收支类型开窗
	 */
	public String initInOrOutComeTypeOpen() throws Exception {

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
	
		return SUCCESS;
	}
	
	/**
	 * Description：收支类型开窗查询
	 */
	public String selInorOutComeTypeOpen() throws Exception {
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
		
		String sLioioTypeID = Utility.getName(request.getParameter("inOrOutComeTypeID"));   //科目号		
		String sLioioTypeName = Utility.getName(request.getParameter("inOrOutComeTypeName"));     //制造商名称
			
		inOrOutComeTypePo = new InOrOutComeTypePo();
		inOrOutComeTypePo.setsLioioTypeID(sLioioTypeID);
		inOrOutComeTypePo.setsLioioTypeName(sLioioTypeName);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		int count = payMentBillMgr.getInOrOutComeTypeCount(inOrOutComeTypePo);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			inOrOutComeTypeList = payMentBillMgr.getInOrOutComeTypeList(inOrOutComeTypePo,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			inOrOutComeTypeList = null;
		}
		
		request.setAttribute("inOrOutComeTypeID" , sLioioTypeID);
		request.setAttribute("inOrOutComeTypeName" , sLioioTypeName);
		
		return SUCCESS;
	}
	
	/**
	 * Description：查看往来帐页面
	 */
	public String supplierCurrentAccountDetailByReport() throws Exception {		
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
		String bgnDate = Utility.getName(request.getParameter("bgnDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		
		request.setAttribute("supplierID" , supplierID);
		request.setAttribute("bgnDate" , bgnDate);
		request.setAttribute("endDate" , endDate);
		
		return SUCCESS;
	}
	
	/**
	 * Description：查看往来帐页面中付款单详细
	 */
	public String payMentBillDetailByReport() throws Exception {		
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
		
		String hid = Utility.getName(request.getParameter("hid"));
		
		PayMentBillPo po = new PayMentBillPo();
		po.setsLpbpbID(hid);
		po = payMentBillMgr.getPayMentBillDetail(po);

		if (Utility.getName(po.getsLpbpbTypeID()).equals("5")){
			request.setAttribute("url", "'selPayMentBillOtherDetail.action?payMentBillID="+hid+"&moduleID="+moduleID+"'");
		}else{
			request.setAttribute("url", "'selPayMentBillSimpleDetail.action?payMentBillID="+hid+"&moduleID="+moduleID+"'");
		}

		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	
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
	public PayMentBillPo getPayMentBillPo() {
		return payMentBillPo;
	}
	public void setPayMentBillPo(PayMentBillPo payMentBillPo) {
		this.payMentBillPo = payMentBillPo;
	}

	public PayMentBillMgr getPayMentBillMgr() {
		return payMentBillMgr;
	}

	public void setPayMentBillMgr(PayMentBillMgr payMentBillMgr) {
		this.payMentBillMgr = payMentBillMgr;
	}

	public PayMentBillEntryTempPo getPayMentBillEntryTempPo() {
		return payMentBillEntryTempPo;
	}

	public void setPayMentBillEntryTempPo(
			PayMentBillEntryTempPo payMentBillEntryTempPo) {
		this.payMentBillEntryTempPo = payMentBillEntryTempPo;
	}

	public PayMentBillEntryPo getPayMentBillEntryPo() {
		return payMentBillEntryPo;
	}

	public void setPayMentBillEntryPo(PayMentBillEntryPo payMentBillEntryPo) {
		this.payMentBillEntryPo = payMentBillEntryPo;
	}

	public List<PayMentBillPo> getPayMentBillList() {
		return payMentBillList;
	}

	public void setPayMentBillList(List<PayMentBillPo> payMentBillList) {
		this.payMentBillList = payMentBillList;
	}

	public List<PayMentBillEntryPo> getPayMentBillEntryList() {
		return payMentBillEntryList;
	}

	public void setPayMentBillEntryList(
			List<PayMentBillEntryPo> payMentBillEntryList) {
		this.payMentBillEntryList = payMentBillEntryList;
	}

	public VoucherMgr getVoucherMgr() {
		return voucherMgr;
	}

	public void setVoucherMgr(VoucherMgr voucherMgr) {
		this.voucherMgr = voucherMgr;
	}

	public List<InvoiceEntryPo> getInvoiceEntryList() {
		return invoiceEntryList;
	}

	public void setInvoiceEntryList(List<InvoiceEntryPo> invoiceEntryList) {
		this.invoiceEntryList = invoiceEntryList;
	}

	public List<VoucherTypePo> getVoucherTopIDList() {
		return voucherTopIDList;
	}

	public void setVoucherTopIDList(List<VoucherTypePo> voucherTopIDList) {
		this.voucherTopIDList = voucherTopIDList;
	}

	public List<VoucherTypePo> getVoucherSubsetIDList() {
		return voucherSubsetIDList;
	}

	public void setVoucherSubsetIDList(List<VoucherTypePo> voucherSubsetIDList) {
		this.voucherSubsetIDList = voucherSubsetIDList;
	}

	public List<VoucherPo> getVoucherList() {
		return voucherList;
	}

	public void setVoucherList(List<VoucherPo> voucherList) {
		this.voucherList = voucherList;
	}

	public List<VoucherEntryPo> getVoucherEntryList() {
		return voucherEntryList;
	}

	public void setVoucherEntryList(List<VoucherEntryPo> voucherEntryList) {
		this.voucherEntryList = voucherEntryList;
	}

	public VoucherTempPo getVoucherTempPo() {
		return voucherTempPo;
	}

	public void setVoucherTempPo(VoucherTempPo voucherTempPo) {
		this.voucherTempPo = voucherTempPo;
	}

	public VoucherEntryTempPo getVoucherEntryTempPo() {
		return voucherEntryTempPo;
	}

	public void setVoucherEntryTempPo(VoucherEntryTempPo voucherEntryTempPo) {
		this.voucherEntryTempPo = voucherEntryTempPo;
	}

	public VoucherPo getPo() {
		return po;
	}

	public void setPo(VoucherPo po) {
		this.po = po;
	}

	public InOrOutComeTypePo getInOrOutComeTypePo() {
		return inOrOutComeTypePo;
	}

	public void setInOrOutComeTypePo(InOrOutComeTypePo inOrOutComeTypePo) {
		this.inOrOutComeTypePo = inOrOutComeTypePo;
	}

	public List<InOrOutComeTypePo> getInOrOutComeTypeList() {
		return inOrOutComeTypeList;
	}

	public void setInOrOutComeTypeList(List<InOrOutComeTypePo> inOrOutComeTypeList) {
		this.inOrOutComeTypeList = inOrOutComeTypeList;
	}

	public List<SupplierPo> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<SupplierPo> supplierList) {
		this.supplierList = supplierList;
	}

	public List<InventoryPo> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(List<InventoryPo> inventoryList) {
		this.inventoryList = inventoryList;
	}

	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}

	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
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
