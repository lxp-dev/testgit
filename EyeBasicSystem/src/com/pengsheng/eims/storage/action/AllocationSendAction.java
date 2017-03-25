package com.pengsheng.eims.storage.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.WindowsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.DoorStoreDeliveryMgr;
import com.pengsheng.eims.sales.mgr.InvisibleDistributionMgr;
import com.pengsheng.eims.sales.mgr.ProcessDistributionMgr;
import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
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

public class AllocationSendAction extends BaseAction {
	private List<SalesBasicPo> salesBasicPoList;
	private DoorStoreDeliveryMgr doorStoreDeliveryMgr;
	private CustomerInfoPo customerInfoPo;
	private SalesBasicPo salesBasicPo;
	private PersonPermissionMgr personPermissionMgr;
    private WindowsMgr windowsMgr;
    private PersonInfoMgr personInfoMgr;
	private SystemParameterMgr systemParameterMgr;
	private FittingTemplateTypeMgr fittingTemplateTypeMgr = null;    	
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<DistributionPo> distributionList;
	private DistributionPo distributionPo = null;
	private List<DistributionEntryPo> distributionEntryList;
	private String type;
	private List<DepartmentsPo> departmentsList;
	private DepartmentsMgr departmentsMgr;
	private ProcessDistributionMgr processDistributionMgr;
	private InvisibleDistributionMgr invisibleDistributionMgr;
	private List<WarehousePo> warehouseList;
	private BillKeyMgr billKeyMgr;
	private List<AllocationPo> allocationPos;
	
	public List<AllocationPo> getAllocationPos() {
		return allocationPos;
	}
	public void setAllocationPos(List<AllocationPo> allocationPos) {
		this.allocationPos = allocationPos;
	}
	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}
	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}
	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}
	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}
	public ProcessDistributionMgr getProcessDistributionMgr() {
		return processDistributionMgr;
	}
	public void setProcessDistributionMgr(
			ProcessDistributionMgr processDistributionMgr) {
		this.processDistributionMgr = processDistributionMgr;
	}
	public InvisibleDistributionMgr getInvisibleDistributionMgr() {
		return invisibleDistributionMgr;
	}
	public void setInvisibleDistributionMgr(
			InvisibleDistributionMgr invisibleDistributionMgr) {
		this.invisibleDistributionMgr = invisibleDistributionMgr;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<DistributionEntryPo> getDistributionEntryList() {
		return distributionEntryList;
	}
	public void setDistributionEntryList(
			List<DistributionEntryPo> distributionEntryList) {
		this.distributionEntryList = distributionEntryList;
	}
	public DistributionPo getDistributionPo() {
		return distributionPo;
	}
	public void setDistributionPo(DistributionPo distributionPo) {
		this.distributionPo = distributionPo;
	}
	public List<DistributionPo> getDistributionList() {
		return distributionList;
	}
	public void setDistributionList(List<DistributionPo> distributionList) {
		this.distributionList = distributionList;
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
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}
	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}
	public WindowsMgr getWindowsMgr() {
		return windowsMgr;
	}
	public void setWindowsMgr(WindowsMgr windowsMgr) {
		this.windowsMgr = windowsMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public List<SalesBasicPo> getSalesBasicPoList() {
		return salesBasicPoList;
	}

	public void setSalesBasicPoList(List<SalesBasicPo> salesBasicPoList) {
		this.salesBasicPoList = salesBasicPoList;
	}

	public DoorStoreDeliveryMgr getDoorStoreDeliveryMgr() {
		return doorStoreDeliveryMgr;
	}

	public void setDoorStoreDeliveryMgr(
			DoorStoreDeliveryMgr doorStoreDeliveryMgr) {
		this.doorStoreDeliveryMgr = doorStoreDeliveryMgr;
	}

	/**
	 * 初始化查询调拨配送信息
	 * 
	 * @return
	 */
	public String initSelectAllocationSend() throws Exception {
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
		/** ********************** 权限设置 ***************************** */
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String starttime = df.format(new Date());
		String endtime   = df.format(new Date());
		
		request.setAttribute("outdepartment", personInfoPo.getDepartmentID());
		request.setAttribute("starttime", starttime);
		request.setAttribute("endtime", endtime);		
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectAllocationSend";
		}
		
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartmentsList(deppo);
		
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				departmentsList.add(dpo);
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 *查询调拨配送信息
	 * 
	 * @return
	 */
	public String selectAllocationSend() throws Exception {

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
		/** ********************** 权限设置 ***************************** */
		String allocationid = Utility.getName(request.getParameter("allocationid"));
		String auditpersonid = Utility.getName(request.getParameter("auditpersonid"));
		String starttime = Utility.getName(request.getParameter("starttime"));
		String endtime = Utility.getName(request.getParameter("endtime"));
		String outdepartment = Utility.getName(request.getParameter("outdepartment"));
		String indepartment = Utility.getName(request.getParameter("indepartment"));
		
		AllocationPo allocationPo = new AllocationPo();
		
		allocationPo.setCshaabillid(allocationid);
		allocationPo.setCshaaauditperson(auditpersonid);
		allocationPo.setCshaaauditdatestart(starttime);
		allocationPo.setCshaaauditdateend(endtime);
		allocationPo.setCshaaoutdepartmentid(outdepartment);
		allocationPo.setCshaaindepartmentid(indepartment);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			allocationPo.setCshaaindptcompanyid(personInfoPo.getPersoncompanyid());
		}
			
		request.setAttribute("allocationid",allocationid);
		request.setAttribute("auditpersonid",auditpersonid);
		request.setAttribute("starttime",starttime);
		request.setAttribute("endtime",endtime);
		request.setAttribute("outdepartment",outdepartment);
		request.setAttribute("indepartment",indepartment);
		
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
		
		int count = doorStoreDeliveryMgr.selectAllocationSendOrSendedsCount(allocationPo);
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
			allocationPos = doorStoreDeliveryMgr.selectAllocationSendOrSendeds(allocationPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			allocationPos = null;
		}
		
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartmentsList(deppo);

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				departmentsList.add(dpo);
			}
		}
		
		return SUCCESS;		
	}
	
	/**
	 * 加载员工卡扫描页
	 */
	public String initAllocationSendPensonScan() throws Exception {
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
		/** ********************** 权限设置 ***************************** */
		
		return SUCCESS;
	}
	
	/**
	 * 修改调拨配送
	 */
	public String updateAllocationSend() throws Exception {

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
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		String personcardid = Utility.getName(request.getParameter("personcardid"));
		
		PersonInfoPo po = new PersonInfoPo();
		po.setCardid(personcardid);
		
		PersonInfoPo ppo = new PersonInfoPo();
		ppo = personInfoMgr.getPersonInfo(po);
		
		if("".equals(Utility.getName(ppo.getId()))){
			this.addActionMessage(getText("不存在该员工信息！")); 
			return "error"; 
		}else{
			String[] ssesbsalesid = request.getParameter("ssesbsalesid").split(",");
			String personid = ppo.getId();
			
			String errorsalesid = "以下调拨单号：\\n";
			String errortype = "";
			for (int i = 0; i < ssesbsalesid.length; i++){
				int istake = billKeyMgr.selectAllocationIsSend(ssesbsalesid[i]);
				if(istake == 1){
					errorsalesid = errorsalesid + ssesbsalesid[i]+"\\n";
					errortype = "1";
				}
			}
			if(errortype.equals("1")){
				this.clearMessages();
				this.addActionMessage(errorsalesid+"已被调拨配送，不能进行重复操作！");
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				
				return SUCCESS;
			}
			
			DistributionPo distributionPo = new DistributionPo();
			distributionPo.setSdndnlogonperson(createPerson);
			distributionPo.setSdndnPerson(personid);
			distributionPo.setSdndntype("4");// 配送类型：调拨配送
			distributionPo.setSdndnid("PS"+GenerateNumber.getInstance().getGenerageNumber());   //主键
			distributionPo.setSdndndepartmentid(personInfoPo.getDepartmentID());
			
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 模块ID
			logPo.setsLogOpID("3");    //修改	
			
			doorStoreDeliveryMgr.updateAllocationSends(ssesbsalesid,distributionPo,logPo);
	
			this.addActionMessage(getText("struts.messages.update.sucess"));			
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
	}
	
	/**
	 * 初始化查询已配送配镜单
	 */
	public String initSelectAllocationSended() throws Exception {
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
		/** ********************** 权限设置 ***************************** */
		
		return SUCCESS;
	}
	
	/**
	 * 查询已配送配镜单
	 */
	public String selectAllocationSended() throws Exception {
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
		/** ********************** 权限设置 ***************************** */
		
		String deliverySalesBillID = Utility.getName(request.getParameter("deliverySalesBillID"));
		String deliveryBillID = Utility.getName(request.getParameter("deliveryBillID"));
		String deliveryStartDate = Utility.getName(request.getParameter("deliveryStartDate"));
		String deliveryEndDate = Utility.getName(request.getParameter("deliveryEndDate"));
		String deliveryPerson = Utility.getName(request.getParameter("deliveryPerson"));

		request.setAttribute("deliverySalesBillID",deliverySalesBillID);
		request.setAttribute("deliveryBillID",deliveryBillID);
		request.setAttribute("deliveryStartDate",deliveryStartDate);
		request.setAttribute("deliveryEndDate",deliveryEndDate);
		request.setAttribute("deliveryPerson",deliveryPerson);
		
		distributionPo = new DistributionPo();
		distributionPo.setSdndnid(deliveryBillID);
		distributionPo.setSdndnPerson(deliveryPerson);
		distributionPo.setSdndncreatebgndate(deliveryStartDate);
		distributionPo.setSdndncreateenddate(deliveryEndDate);
		distributionPo.setSdndnsalesid(deliverySalesBillID);
		distributionPo.setSdndndepartmentid(personInfoPo.getDepartmentID());
				
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
		
		int count = doorStoreDeliveryMgr.selectAllocationSendedCount(distributionPo);
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
			distributionList = doorStoreDeliveryMgr.selectAllocationSendedList(distributionPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			distributionList = null;
		}
	
		return SUCCESS;
	}
	
	/**
	 * 查询已配送配镜单详情
	 */
	public String selectAllocationSendedDetail() throws Exception {
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
		/** ********************** 权限设置 ***************************** */
		
		String hid = Utility.getName(request.getParameter("hid"));
		String type = Utility.getName(request.getParameter("type"));
		
		DistributionPo po = new DistributionPo();
		po.setSdndnid(hid);
		po.setSdndntype(type);
		
		distributionPo = doorStoreDeliveryMgr.getDoorStoreYetDeliveryDetail(po);
		distributionEntryList = doorStoreDeliveryMgr.getAllocationSendedEntryDetail(po);
		
		return SUCCESS;
	}
	public FittingTemplateTypeMgr getFittingTemplateTypeMgr() {
		return fittingTemplateTypeMgr;
	}
	public void setFittingTemplateTypeMgr(
			FittingTemplateTypeMgr fittingTemplateTypeMgr) {
		this.fittingTemplateTypeMgr = fittingTemplateTypeMgr;
	}
}
