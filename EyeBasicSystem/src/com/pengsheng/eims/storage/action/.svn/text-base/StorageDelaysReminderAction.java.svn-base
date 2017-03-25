package com.pengsheng.eims.storage.action;

import java.util.List;

import com.pengsheng.eims.components.mgr.SalesBasicMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.DelaysReminderPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.mgr.StorageDelaysReminderMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class StorageDelaysReminderAction extends BaseAction {

	private DelaysReminderPo po;

	private PersonPermissionMgr personPermissionMgr;

	private StorageDelaysReminderMgr storageDelaysReminderMgr;

	private List<DelaysReminderPo> delaysReminderPoList;

	private SalesBasicPo salesODPo;

	private SalesBasicPo salesOSPo;

	private SalesBasicPo salesBasicPo;

	private SalesBasicMgr salesBasicMgr;

	private DelaysReminderPo delaysReminderPo;

	private List<DelaysReminderPo> orderList;
	
private SystemParameterMgr systemParameterMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private String isFirstExec;
	
	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}
	
	
	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}


	public List<DelaysReminderPo> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<DelaysReminderPo> orderList) {
		this.orderList = orderList;
	}

	public DelaysReminderPo getDelaysReminderPo() {
		return delaysReminderPo;
	}

	public void setDelaysReminderPo(DelaysReminderPo delaysReminderPo) {
		this.delaysReminderPo = delaysReminderPo;
	}

	public SalesBasicMgr getSalesBasicMgr() {
		return salesBasicMgr;
	}

	public void setSalesBasicMgr(SalesBasicMgr salesBasicMgr) {
		this.salesBasicMgr = salesBasicMgr;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public SalesBasicPo getSalesODPo() {
		return salesODPo;
	}

	public void setSalesODPo(SalesBasicPo salesODPo) {
		this.salesODPo = salesODPo;
	}

	public SalesBasicPo getSalesOSPo() {
		return salesOSPo;
	}

	public void setSalesOSPo(SalesBasicPo salesOSPo) {
		this.salesOSPo = salesOSPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public StorageDelaysReminderMgr getStorageDelaysReminderMgr() {
		return storageDelaysReminderMgr;
	}

	public void setStorageDelaysReminderMgr(
			StorageDelaysReminderMgr storageDelaysReminderMgr) {
		this.storageDelaysReminderMgr = storageDelaysReminderMgr;
	}

	public DelaysReminderPo getPo() {
		return po;
	}

	public void setPo(DelaysReminderPo po) {
		this.po = po;
	}

	public List<DelaysReminderPo> getDelaysReminderPoList() {
		return delaysReminderPoList;
	}

	public void setDelaysReminderPoList(
			List<DelaysReminderPo> delaysReminderPoList) {
		this.delaysReminderPoList = delaysReminderPoList;
	}

	/**
	 * 初始化误期查询
	 * 
	 * @return
	 */
	public String initStorageDelaysReminder() {

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
			return "selectStorageDelaysReminder";
		}

		return SUCCESS;
	}

	/**
	 * 根据条件查询误期信息
	 * 
	 * @return
	 */
	public String selectStorageDelaysReminder() throws Exception {

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

		String salesid = Utility.getName(request.getParameter("salesid"));
		String customerName = Utility.getName(request
				.getParameter("customerName"));
		String mirrorcheckstartdate = Utility.getName(request
				.getParameter("mirrorcheckstartdate"));
		String mirrorcheckenddate = Utility.getName(request
				.getParameter("mirrorcheckenddate"));
		String expectedcheckstartdate = Utility.getName(request
				.getParameter("expectedcheckstartdate"));
		String expectedcheckenddate = Utility.getName(request
				.getParameter("expectedcheckenddate"));
		String noticeperson = Utility.getName(request
				.getParameter("noticeperson"));
		String noticestartdate = Utility.getName(request
				.getParameter("noticestartdate"));
		String noticeenddate = Utility.getName(request
				.getParameter("noticeenddate"));
		String noticestatus = Utility.getName(request
				.getParameter("noticestatus"));

		DelaysReminderPo po = new DelaysReminderPo();
		po.setSsedrsalesid(salesid);
		po.setSsedrcustomerName(customerName);
		po.setSsedrmirrorcheckstartdate(mirrorcheckstartdate);
		po.setSsedrmirrorcheckenddate(mirrorcheckenddate);
		po.setSsedrexpectedcheckstartdate(expectedcheckstartdate);
		po.setSsedrexpectedcheckenddate(expectedcheckenddate);
		po.setSsedrnoticeperson(noticeperson);
		po.setSsedrnoticestartdate(noticestartdate);
		po.setSsedrnoticeenddate(noticeenddate);
		po.setSsedrnoticestatus(noticestatus);
		
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

		int count = storageDelaysReminderMgr
				.getStoragetDelaysRemindertCount(po);
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
			delaysReminderPoList = storageDelaysReminderMgr
					.getStorageDelaysRemindertList(po, page.getStart(), page
							.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			delaysReminderPoList = null;
		}
		request.setAttribute("salesid", salesid);
		request.setAttribute("customerName", customerName);
		request.setAttribute("ssedrmirrorcheckstartdate", mirrorcheckstartdate);
		request.setAttribute("ssedrmirrorcheckenddate", mirrorcheckenddate);
		request.setAttribute("ssedrexpectedcheckstartdate",
				expectedcheckstartdate);
		request.setAttribute("ssedrexpectedcheckenddate", expectedcheckenddate);
		request.setAttribute("noticeperson", noticeperson);
		request.setAttribute("ssedrnoticestartdate", noticestartdate);
		request.setAttribute("ssedrnoticeenddate", noticeenddate);
		request.setAttribute("noticestatus", noticestatus);

		return SUCCESS;
	}

	/**
	 * 初始化误期登记
	 * 
	 * @return
	 */
	public String initStorageDelaysReminderRegistration() {
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
	 * 传值并显示左右眼信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selectSalesBasicODOS() throws Exception {
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
		String salesid = Utility.getName(request.getParameter("salesid"));
		// String mirrorcheckdate = Utility.getName(request
		// .getParameter("mirrorcheckdate"));

		// String shopName = Utility.getName(request.getParameter("shopName"));
		// String shopcode = Utility.getName(request.getParameter("shopcode"));
		// String customerid =
		// Utility.getName(request.getParameter("customerid"));

		SalesBasicPo salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbsalesid(salesid);

		salesBasicPo = storageDelaysReminderMgr.getSalesBasic(salesBasicPo);
		request.setAttribute("salesBasicPo", salesBasicPo);

		// DelaysReminderPo po = new DelaysReminderPo();
		// po.setSsedrsalesid(salesid);
		// po.setSsedrmirrorcheckdate(salesBasicPo.getSsesbtakeglassdata());
		// po.setSsedrshopcode(salesBasicPo.getSsesbshopcode());
		// po.setSsedrcustomerid(customerid);
		// request.setAttribute("ssesbsalesid", salesid);
		// request.setAttribute("ssesbtakeglassdata", mirrorcheckdate);
		// request.setAttribute("ssesbshopName", shopName);
		// request.setAttribute("ssesbshopcode", shopcode);
		// request.setAttribute("ssesbcustomerid", customerid);

		SalesBasicPo ODPo = new SalesBasicPo();
		ODPo.setSsesbsalesid(salesid);

		SalesBasicPo OSPo = new SalesBasicPo();
		OSPo.setSsesbsalesid(salesid);

		// //右眼信息
		salesODPo = new SalesBasicPo();
		salesODPo = storageDelaysReminderMgr.getODDetailInfo(ODPo);

		// 左眼信息
		salesOSPo = new SalesBasicPo();
		salesOSPo = storageDelaysReminderMgr.getOSDetailInfo(OSPo);
		// salesBasicPo=salesBasicMgr.getSalesBasic(salesBasicPo);
		// if (salesBasicPo != null ) {
		// salesBasicPo.setSsesbsalesid("");
		// salesBasicPo = salesBasicMgr.getSalesBasic(salesBasicPo);
		//
		// if (StringUtils.isNotEmpty(salesBasicPo.getSsesbsalesid())) {
		//
		//					
		// salesBasicPo=new SalesBasicPo();
		// salesBasicPo=salesBasicMgr.getSalesBasic(salesBasicPo);
		//					
		// //右眼信息
		// salesODPo=new SalesBasicPo();
		// salesODPo=storageDelaysReminderMgr.getODDetailInfo(ODPo);
		//					
		// //左眼信息
		// salesOSPo=new SalesBasicPo();
		// salesOSPo=storageDelaysReminderMgr.getOSDetailInfo(OSPo);
		// salesBasicPo=salesBasicMgr.getSalesBasic(salesBasicPo);
		// }
		// }
		return SUCCESS;
	}

	/**
	 * 新增误期登记信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertDelaysReminder() throws Exception {
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
		
		String salesid = Utility.getName(request.getParameter("salesid"));
		String shopcode = Utility.getName(request.getParameter("shopcode"));
		String mirrorcheckdate = Utility.getName(request
				.getParameter("mirrorcheckdate"));
		String expectedcheckdate = Utility.getName(request
				.getParameter("expectedcheckdate"));
		String noticedate = Utility.getName(request.getParameter("noticedate"));
		String causesdelays = Utility.getName(request
				.getParameter("causesdelays"));
		String customerid = Utility.getName(request.getParameter("customerid"));

		delaysReminderPo = new DelaysReminderPo();
		delaysReminderPo.setSsedrsalesid(salesid);
		delaysReminderPo.setSsedrmirrorcheckdate(mirrorcheckdate);
		delaysReminderPo.setSsedrshopcode(shopcode);
		delaysReminderPo.setSsedrexpectedcheckdate(expectedcheckdate);
		delaysReminderPo.setSsedrnoticedate(noticedate);
		delaysReminderPo.setSsedrcausesdelays(causesdelays);
		delaysReminderPo.setSsedrnoticeperson(customerid);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("41");    // 表示状态
		logPo.setsLogContent("误期登记："+salesid+"新增");

		// 判断是否选中审核复选框
		// if ("1".equals(request.getParameter("auditstatus"))) {
		delaysReminderPo.setSsedrauditstatus("1");
		delaysReminderPo.setSsedrauditperson(((PersonInfoPo) session
				.get("person")).getId());

		// } else {
		// delaysReminderPo.setSsedrauditstatus("0");
		// }

		storageDelaysReminderMgr.insertDelaysRemindert(delaysReminderPo,logPo);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	/**
	 * 初始化误期查询删除
	 * 
	 * @return
	 */
	public String initDelaysReminderDel() {
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
		String salesid = Utility.getName(request.getParameter("ssedrsalesid"));
		request.setAttribute("ssedrsalesid", salesid);
		String id = Utility.getName(request.getParameter("hid"));
		request.setAttribute("ssedrid", id);
		return SUCCESS;
	}

	/**
	 * 删除误期查询信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteDelaysReminder() throws Exception {
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
		request.setAttribute("ssedrid", id);
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("误期登记："+id+"删除");
		storageDelaysReminderMgr.deleteStorageDelaysRemindert(id,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	/**
	 * 初始化订单查询开窗
	 * 
	 * @return
	 */
	public String initOrderDelaysRemindert() {

		return SUCCESS;
	}

	/**
	 * 误期订单查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selectOrderDelaysRemindert() throws Exception {

		String salesid = Utility.getName(request.getParameter("salesid"));
		String customerName = Utility.getName(request
				.getParameter("customerName"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));

		DelaysReminderPo delaysReminderPo = new DelaysReminderPo();
		delaysReminderPo.setSsedrsalesid(salesid);
		delaysReminderPo.setSsedrcustomerName(customerName);
		delaysReminderPo.setSsedrmirrorcheckstartdate(startTime);
		delaysReminderPo.setSsedrmirrorcheckenddate(endTime);

//		CustomerContextHolder.setCustomerType(CustomerType.orders);

		int count = storageDelaysReminderMgr
				.getOrderDelaysRemindertCount(delaysReminderPo);
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
			orderList = storageDelaysReminderMgr.getOrderDelaysRemindertList(
					delaysReminderPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			orderList = null;
		}

//		CustomerContextHolder.setCustomerType(CustomerType.eims);

		request.setAttribute("salesid", salesid);
		request.setAttribute("customerName", customerName);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);

		return SUCCESS;
	}

}
