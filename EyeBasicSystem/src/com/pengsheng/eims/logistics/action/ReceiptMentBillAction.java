/**
* 项目名称 : EIMS财务物流子系统
* 包 名          ：com.pengsheng.eims.logistics.action
* 文件名称 : ReceiptMentBillAction.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2013-04-28
*/
package com.pengsheng.eims.logistics.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.ReceiptMentBillEntryPo;
import com.pengsheng.eims.logistics.persistence.ReceiptMentBillEntryTempPo;
import com.pengsheng.eims.logistics.persistence.ReceiptMentBillPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.mgr.ReceiptMentBillMgr;
import com.pengsheng.eims.logistics.mgr.VoucherMgr;
import com.pengsheng.eims.storage.mgr.StoreGoodsMgr;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.TracPo;
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

public class ReceiptMentBillAction extends BaseAction {
	
	private LogisticsLogMgr logisticsLogMgr = null;
	private PersonPermissionMgr personPermissionMgr = null;	
	private ReceiptMentBillMgr  receiptMentBillMgr = null;
	private ReceiptMentBillPo receiptMentBillPo = null;
	private ReceiptMentBillEntryTempPo receiptMentBillEntryTempPo = null;
	private ReceiptMentBillEntryPo receiptMentBillEntryPo = null;
	private List<ReceiptMentBillPo> receiptMentBillList = null;
	private List<ReceiptMentBillEntryPo> receiptMentBillEntryList = null;
	private DepartmentsMgr departmentsMgr = null;
	private List<DepartmentsPo> departmentsList = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private VoucherMgr voucherMgr;
	private List<InventoryPo> inventoryList;
	private StoreGoodsMgr storeGoodsMgr;
	private List<DepartmentsPo> departmentsPos;
	private List<TracPo> tracList;
	
	/**
	 * Description：初始化查询收款单
	 */
	public String initReceiptMentBillSel() throws Exception {
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
		departmentsPos = storeGoodsMgr.getFranchisees();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			if (Utility.getName(permissionPo.getKeyd()).equals("1")){
				this.setIsFirstExec("1");
				return "selReceiptMentBill";
			}
		}
		
		return SUCCESS;
	}
		
	/**
	 * Description：初始化新增收款单
	 */
	public String initReceiptMentBillInsert() throws Exception {	

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
		
		String createPersonName = personInfoPo.getPersonName();		
		String receiptMentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //新增收款单的时间		
		String receiptMentID = "RB"+GenerateNumber.getInstance().getGenerageNumber();                          //新增收款单的ID	
				
		request.setAttribute("receiptMentID" , receiptMentID);
		request.setAttribute("receiptMentDate" , receiptMentDate);		
		request.setAttribute("createPerson" , createPersonName);
		request.setAttribute("createPersonID" , createPersonID);
		
		departmentsPos = storeGoodsMgr.getFranchisees();
		
		return SUCCESS;
	}
	
	/**
	 * Description：新增收款单
	 */
	public String insertReceiptMentBill() throws Exception {	

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
			receiptMentBillPo.setsLrbrbAuditStatue("1");
			receiptMentBillPo.setsLrbrbAuditPersonID(createPerson);
		}else{
			receiptMentBillPo.setsLrbrbAuditStatue("0");
			receiptMentBillPo.setsLrbrbAuditPersonID("");
		}
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
		
		receiptMentBillPo.setsLrbrbDepartmentID(personInfoPo.getDepartmentID());
		receiptMentBillPo.setsLrbrbCurtainDealing(Utility.getName(po.getsLvvDateTopLimit()));
		receiptMentBillPo.setsLrbrbTypeID("1");
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("收款单：" + Utility.getName(receiptMentBillPo.getsLrbrbID())+" 新增!");

		String queryClassify = Utility.getName(request.getParameter("queryClassify"));
		if (queryClassify.equals("1")){
			receiptMentBillEntryList = new ArrayList<ReceiptMentBillEntryPo>();
			int receiptMentBillCount = receiptMentBillEntryTempPo.getsLrbrbeAllocateID().length;
			for (int i = 0; i < receiptMentBillCount; i++){
				ReceiptMentBillEntryPo receiptMentBillEntryPo = new ReceiptMentBillEntryPo();
				receiptMentBillEntryPo.setsLrbrbeBillID(Utility.getName(receiptMentBillPo.getsLrbrbID()));
				receiptMentBillEntryPo.setsLrbrbeBillTypeID("客户批发调货单");
				receiptMentBillEntryPo.setsLrbrbeAllocateID(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeAllocateID()[i]));
				receiptMentBillEntryPo.setsLrbrbeBillDate(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeBillDate()[i]));
				receiptMentBillEntryPo.setsLrbrbeCostPriceAmount(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeCostPriceAmount()[i]));
				receiptMentBillEntryPo.setsLrbrbeReceiptedMentAmount(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeReceiptedMentAmount()[i]));			
				receiptMentBillEntryPo.setsLrbrbeNotReceiptedMentAmount(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeNotReceiptedMentAmount()[i]));
				receiptMentBillEntryPo.setsLrbrbeReceiptMentAmount(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeReceiptMentAmount()[i]));
				receiptMentBillEntryPo.setsLrbrbeRemark(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeRemark()[i]));
				
				receiptMentBillEntryList.add(receiptMentBillEntryPo);
			}
		}else{
			receiptMentBillPo.setsLrbrbCurrentReceiptMentAmount(Utility.getName(request.getParameter("sLpbpbCostPriceAmount")));
		}
		
		receiptMentBillPo.setsLrbrbTypeID(queryClassify);
		
		receiptMentBillMgr.insertReceiptMentBill(receiptMentBillPo,receiptMentBillEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询收款单
	 */
	public String selReceiptMentBill() throws Exception {
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
		
		String receiptMentBillID = Utility.getName(request.getParameter("receiptMentBillID"));   //收款单号
		String franchiseeID = Utility.getName(request.getParameter("franchiseeID"));         //制造商ID
		String auditStatue = Utility.getName(request.getParameter("auditStatue"));       //审核状态
		String billStartTime = Utility.getName(request.getParameter("billStartTime"));   //收款单起始时间
		String billEndTime = Utility.getName(request.getParameter("billEndTime"));       //收款单终止时间
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime")); //审核起始时间
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));     //审核终止时间		
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String franchiseeName = Utility.getName(request.getParameter("franchiseeName"));         //制造商ID
		
		receiptMentBillPo = new ReceiptMentBillPo();
		receiptMentBillPo.setsLrbrbID(receiptMentBillID);
		receiptMentBillPo.setsLrbrbAuditStartDate(auditStartTime);
		receiptMentBillPo.setsLrbrbAuditEndDate(auditEndTime);
		receiptMentBillPo.setsLrbrbStartDate(billStartTime);
		receiptMentBillPo.setsLrbrbEndDate(billEndTime);
		receiptMentBillPo.setsLrbrbFranchiseeID(franchiseeID);
		receiptMentBillPo.setsLrbrbCreatePersonID(createPersonID);
		receiptMentBillPo.setsLrbrbAuditStatue(auditStatue);
		
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
		
		int count = receiptMentBillMgr.getReceiptMentBillCount(receiptMentBillPo);		
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
			receiptMentBillList = receiptMentBillMgr.getReceiptMentBillList(receiptMentBillPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			receiptMentBillList = null;
		}
		
		request.setAttribute("receiptMentBillID" , receiptMentBillID);
		request.setAttribute("franchiseeID" , franchiseeID);
		request.setAttribute("auditStatue" , auditStatue);
		request.setAttribute("billStartTime" , billStartTime);
		request.setAttribute("billEndTime" , billEndTime);
		request.setAttribute("auditStartTime" , auditStartTime);
		request.setAttribute("auditEndTime" , auditEndTime);
		request.setAttribute("createPersonID" , createPersonID);
		request.setAttribute("franchiseeName" , franchiseeName);
		
		departmentsPos = storeGoodsMgr.getFranchisees();
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询收款单详情信息
	 */
	public String selReceiptMentBillDetail() throws Exception {

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

		String receiptMentBillID = Utility.getName(request.getParameter("receiptMentBillID"));
		receiptMentBillPo = new ReceiptMentBillPo();
		receiptMentBillPo.setsLrbrbID(receiptMentBillID);
		
		receiptMentBillPo = receiptMentBillMgr.getReceiptMentBillDetail(receiptMentBillPo);
		receiptMentBillEntryList = receiptMentBillMgr.getReceiptMentBillEntryDetail(receiptMentBillPo);
		
		return SUCCESS;		
	}
	
	/**
	 * Description：初始化修改收款单
	 */
	public String initReceiptMentBillUpdate() throws Exception {

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

		String receiptMentBillID = Utility.getName(request.getParameter("receiptMentBillID"));
		receiptMentBillPo = new ReceiptMentBillPo();
		receiptMentBillPo.setsLrbrbID(receiptMentBillID);
		
		receiptMentBillPo = receiptMentBillMgr.getReceiptMentBillDetail(receiptMentBillPo);
		receiptMentBillEntryList = receiptMentBillMgr.getReceiptMentBillEntryDetail(receiptMentBillPo);
		
		return SUCCESS;	
	}
	
	/**
	 * Description：根据参数修改收款单
	 */
	public String updateReceiptMentBill() throws Exception {

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
			receiptMentBillPo.setsLrbrbAuditStatue("1");
			receiptMentBillPo.setsLrbrbAuditPersonID(createPerson);
		}else{
			receiptMentBillPo.setsLrbrbAuditStatue("0");
			receiptMentBillPo.setsLrbrbAuditPersonID("");
		}
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
		receiptMentBillPo.setsLrbrbCurtainDealing(Utility.getName(po.getsLvvDateTopLimit()));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("收款单：" + Utility.getName(receiptMentBillPo.getsLrbrbID()+" 修改!"));

		if (Utility.getName(receiptMentBillPo.getsLrbrbTypeID()).equals("1")){
			receiptMentBillEntryList = new ArrayList<ReceiptMentBillEntryPo>();
			int receiptMentBillCount = receiptMentBillEntryTempPo.getsLrbrbeAllocateID().length;
			for (int i = 0; i < receiptMentBillCount; i++){
				ReceiptMentBillEntryPo receiptMentBillEntryPo = new ReceiptMentBillEntryPo();
				receiptMentBillEntryPo.setsLrbrbeBillID(Utility.getName(receiptMentBillPo.getsLrbrbID()));
				receiptMentBillEntryPo.setsLrbrbeBillTypeID("客户批发调货单");
				receiptMentBillEntryPo.setsLrbrbeAllocateID(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeAllocateID()[i]));
				receiptMentBillEntryPo.setsLrbrbeBillDate(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeBillDate()[i]));
				receiptMentBillEntryPo.setsLrbrbeCostPriceAmount(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeCostPriceAmount()[i]));
				receiptMentBillEntryPo.setsLrbrbeReceiptedMentAmount(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeReceiptedMentAmount()[i]));			
				receiptMentBillEntryPo.setsLrbrbeNotReceiptedMentAmount(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeNotReceiptedMentAmount()[i]));
				receiptMentBillEntryPo.setsLrbrbeReceiptMentAmount(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeReceiptMentAmount()[i]));
				receiptMentBillEntryPo.setsLrbrbeRemark(Utility.getName(receiptMentBillEntryTempPo.getsLrbrbeRemark()[i]));
				
				receiptMentBillEntryList.add(receiptMentBillEntryPo);
			}
		}else{
			receiptMentBillPo.setsLrbrbCurrentReceiptMentAmount(Utility.getName(request.getParameter("sLpbpbCostPriceAmount")));
		}
		
		receiptMentBillMgr.updateReceiptMentBill(receiptMentBillPo,receiptMentBillEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化删除收款单
	 */
	public String initReceiptMentBillDelete() throws Exception {

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
		
		String receiptMentBillID = Utility.getName(request.getParameter("receiptMentBillID"));
		request.setAttribute("receiptMentBillID",receiptMentBillID);
		
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数删除收款单
	 */
	public String deleteReceiptMentBill() throws Exception {

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
		logPo.setsLogContent("收款单：" + Utility.getName(receiptMentBillPo.getsLrbrbID()+"删除!"));

		receiptMentBillMgr.deleteReceiptMentBill(receiptMentBillPo, logPo);		

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}	
	
	/**
	 * Description：初始化反审收款单
	 */
	public String initUnAuditReceiptMentBill() throws Exception {

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
		
		String receiptMentBillID = Utility.getName(request.getParameter("receiptMentBillID"));
		request.setAttribute("receiptMentBillID",receiptMentBillID);
		
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数反审收款单
	 */
	public String unAuditReceiptMentBill() throws Exception {

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
		logPo.setsLogContent("收款单：" + Utility.getName(receiptMentBillPo.getsLrbrbID()+"反审核!"));

		boolean flag = receiptMentBillMgr.unAuditReceiptMentBill(receiptMentBillPo, logPo);
        
		this.clearMessages();
		if (flag){
        	this.addActionMessage(getText("收款单反审核成功!"));
        }else{
        	this.addActionMessage(getText("收款单反审核失败!!"));
        }		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数反审收款单
	 */
	public String initAuditReceiptMentBill() throws Exception {

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
		
		String receiptMentBillID = Utility.getName(request.getParameter("receiptMentBillID"));
		request.setAttribute("receiptMentBillID",receiptMentBillID);
		
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数反审收款单
	 */
	public String auditReceiptMentBill() throws Exception {

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
		logPo.setsLogContent("收款单：" + Utility.getName(receiptMentBillPo.getsLrbrbID()+"审核!"));

		receiptMentBillPo.setsLrbrbAuditPersonID(createPerson);
		receiptMentBillMgr.auditReceiptMentBill(receiptMentBillPo, logPo);
        
		this.clearMessages();
		this.addActionMessage(getText("收款单审核成功!"));		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化查询客户
	 */
	public String initFranchiseeOpenSel() throws Exception {
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
		
		String franchiseeID = Utility.getName(request.getParameter("franchiseeID"));		
		request.setAttribute("franchiseeID",franchiseeID);
		request.setAttribute("receiptMentBillCheckStatus" , "1");
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询客户
	 */
	public String selFranchiseeOpen() throws Exception {
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
		
		String allocationBillID = Utility.getName(request.getParameter("allocationBillID"));		
		String billStartTime = Utility.getName(request.getParameter("billStartTime"));   //收款单起始时间
		String billEndTime = Utility.getName(request.getParameter("billEndTime"));       //收款单终止时间
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime")); //审核起始时间
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));     //审核终止时间		
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String franchiseeID = Utility.getName(request.getParameter("franchiseeID"));
		String receiptMentBillCheckStatus = Utility.getName(request.getParameter("receiptMentBillCheckStatus"));
		
		TracPo po = new TracPo();
		po.setCstibillid(allocationBillID);
		po.setCstiauditstartdate(auditStartTime);
		po.setCstiauditenddate(auditEndTime);
		po.setCstistartTime(billStartTime);
		po.setCstiendTime(billEndTime);
		po.setCsticreateperson(createPersonID);
		po.setCstisupplierid(franchiseeID);
		po.setCstiinvoicestate(receiptMentBillCheckStatus);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());

		int count = receiptMentBillMgr.getFranchiseeAllocationBillCount(po);
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
			tracList = receiptMentBillMgr.getFranchiseeAllocationBillList(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			tracList = null;
		}
		
		request.setAttribute("allocationBillID" , allocationBillID);
		request.setAttribute("billStartTime" , billStartTime);
		request.setAttribute("billEndTime" , billEndTime);
		request.setAttribute("auditStartTime" , auditStartTime);
		request.setAttribute("auditEndTime" , auditEndTime);
		request.setAttribute("createPersonID" , createPersonID);
		request.setAttribute("franchiseeID" , franchiseeID);
		request.setAttribute("receiptMentBillCheckStatus" ,receiptMentBillCheckStatus);
		
		return SUCCESS;
	}

/************* 客户应收往来账查询 ***************************************************************************************************************************/
	
	/**
	 * Description：初始化客户往来账查询
	 */
	public String initFranchiseeCurrentAccountSel() throws Exception {
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
		departmentsPos = storeGoodsMgr.getFranchisees();
		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			if (Utility.getName(permissionPo.getKeya()).equals("1")){
				this.setIsFirstExec("1");
				return "franchiseeCurrentAccountSel";
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * Description：客户往来账查询
	 */
	public String franchiseeCurrentAccountSel() throws Exception {
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
		
		String franchiseeID = Utility.getName(request.getParameter("franchiseeID"));
		String startDate = Utility.getName(request.getParameter("startDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		String payMentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		
		request.setAttribute("franchiseeID",franchiseeID);
		request.setAttribute("startDate",startDate);
		request.setAttribute("endDate",(endDate.equals("") ? payMentDate :endDate));
		
		ReceiptMentBillPo rpo = new ReceiptMentBillPo();
		rpo.setsLrbrbFranchiseeID(franchiseeID);
		rpo.setsLrbrbStartDate(startDate);
		rpo.setsLrbrbEndDate(endDate);
		
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
		
		int count = receiptMentBillMgr.getFranchiseeCount(rpo);		
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
			departmentsList = receiptMentBillMgr.getFranchiseeList(rpo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			departmentsList = null;
		}
		
		departmentsPos = storeGoodsMgr.getFranchisees();
		
		String amountSum = Utility.getName(receiptMentBillMgr.getFranchiseeAccount(rpo));
		request.setAttribute("amountSum",amountSum);
		
		return SUCCESS;
	}
	
	/**
	 * Description：客户往来账详情
	 */
	public String franchiseeCurrentAccountDetail() throws Exception {
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
		
		String franchiseeID = Utility.getName(request.getParameter("franchiseeID"));
		String franchiseeName = Utility.getName(request.getParameter("franchiseeName"));
		String startDate = Utility.getName(request.getParameter("startDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		
		request.setAttribute("franchiseeID",franchiseeID);
		request.setAttribute("franchiseeName",franchiseeName);
		request.setAttribute("startDate",startDate);
		request.setAttribute("endDate",endDate);
		
		ReceiptMentBillPo po = new ReceiptMentBillPo();
		po.setsLrbrbFranchiseeID(franchiseeID);
		po.setsLrbrbStartDate(startDate);
		po.setsLrbrbEndDate(endDate);
	
		inventoryList = receiptMentBillMgr.getFranchiseeCurrentAccountDetail(po);
		
		return SUCCESS;
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

	public ReceiptMentBillMgr getReceiptMentBillMgr() {
		return receiptMentBillMgr;
	}

	public void setReceiptMentBillMgr(ReceiptMentBillMgr receiptMentBillMgr) {
		this.receiptMentBillMgr = receiptMentBillMgr;
	}

	public ReceiptMentBillPo getReceiptMentBillPo() {
		return receiptMentBillPo;
	}

	public void setReceiptMentBillPo(ReceiptMentBillPo receiptMentBillPo) {
		this.receiptMentBillPo = receiptMentBillPo;
	}

	public ReceiptMentBillEntryTempPo getReceiptMentBillEntryTempPo() {
		return receiptMentBillEntryTempPo;
	}

	public void setReceiptMentBillEntryTempPo(
			ReceiptMentBillEntryTempPo receiptMentBillEntryTempPo) {
		this.receiptMentBillEntryTempPo = receiptMentBillEntryTempPo;
	}

	public ReceiptMentBillEntryPo getReceiptMentBillEntryPo() {
		return receiptMentBillEntryPo;
	}

	public void setReceiptMentBillEntryPo(
			ReceiptMentBillEntryPo receiptMentBillEntryPo) {
		this.receiptMentBillEntryPo = receiptMentBillEntryPo;
	}

	public List<ReceiptMentBillPo> getReceiptMentBillList() {
		return receiptMentBillList;
	}

	public void setReceiptMentBillList(List<ReceiptMentBillPo> receiptMentBillList) {
		this.receiptMentBillList = receiptMentBillList;
	}

	public List<ReceiptMentBillEntryPo> getReceiptMentBillEntryList() {
		return receiptMentBillEntryList;
	}

	public void setReceiptMentBillEntryList(
			List<ReceiptMentBillEntryPo> receiptMentBillEntryList) {
		this.receiptMentBillEntryList = receiptMentBillEntryList;
	}

	public VoucherMgr getVoucherMgr() {
		return voucherMgr;
	}

	public void setVoucherMgr(VoucherMgr voucherMgr) {
		this.voucherMgr = voucherMgr;
	}

	public List<InventoryPo> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(List<InventoryPo> inventoryList) {
		this.inventoryList = inventoryList;
	}

	public StoreGoodsMgr getStoreGoodsMgr() {
		return storeGoodsMgr;
	}

	public void setStoreGoodsMgr(StoreGoodsMgr storeGoodsMgr) {
		this.storeGoodsMgr = storeGoodsMgr;
	}

	public List<DepartmentsPo> getDepartmentsPos() {
		return departmentsPos;
	}

	public void setDepartmentsPos(List<DepartmentsPo> departmentsPos) {
		this.departmentsPos = departmentsPos;
	}

	public List<TracPo> getTracList() {
		return tracList;
	}

	public void setTracList(List<TracPo> tracList) {
		this.tracList = tracList;
	}

}
