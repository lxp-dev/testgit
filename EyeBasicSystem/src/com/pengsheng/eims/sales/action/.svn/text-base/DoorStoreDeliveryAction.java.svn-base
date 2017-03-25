package com.pengsheng.eims.sales.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.WindowsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.DoorStoreDeliveryMgr;
import com.pengsheng.eims.sales.mgr.InvisibleDistributionMgr;
import com.pengsheng.eims.sales.mgr.ProcessDistributionMgr;
import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
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

public class DoorStoreDeliveryAction extends BaseAction {

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
	 * 初始化查询门店配送信息
	 * 
	 * @return
	 */
	public String selectDoorStoreDelivery() throws Exception {
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
	
		int count = windowsMgr.isEnabledInTransit("3");
		request.setAttribute("InTransitCount", count);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "queryDoorStoreDelivery";
		}
		
		return SUCCESS;
	}
	
	/**
	 *查询门店配送信息
	 * 
	 * @return
	 */
	public String queryDoorStoreDelivery() throws Exception {

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
		int InTransitCount = windowsMgr.isEnabledInTransit("3");
		String shopsalesid = Utility.getName(request.getParameter("shopsalesid"));
		String memberId = Utility.getName(request.getParameter("memberId"));
		String shoppersonName = Utility.getName(request.getParameter("shoppersonName"));
		String ssesbsalesdatestarttime = Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime = Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String [] shoporderstypes = request.getParameterValues("shoporderstype");
		String startDate = Utility.getName(request.getParameter("startDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		
		request.setAttribute("shopsalesid",shopsalesid);
		request.setAttribute("memberId",memberId);
		request.setAttribute("shoppersonName",shoppersonName);
		request.setAttribute("ssesbsalesdatestarttime",ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime",ssesbsalesdateendtime);
		request.setAttribute("startDate",startDate);
		request.setAttribute("shoporderstypes",shoporderstypes);
		
		if(shoporderstypes == null){
			shoporderstypes = new String[]{""};
		}
		
		salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbsalesid(shopsalesid);
		salesBasicPo.setSsesbMemberId(memberId);
		salesBasicPo.setSsesbpersonName(shoppersonName);
		salesBasicPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesBasicPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesBasicPo.setSsesborderstypes(shoporderstypes);
		salesBasicPo.setSsesbshopcode(personInfoPo.getDepartmentID());
		salesBasicPo.setSsesbtakeglassstartdata(startDate);
		salesBasicPo.setSsesbtakeglassenddata(endDate);
		
		salesBasicPoList = doorStoreDeliveryMgr.getSalesBasicPos(salesBasicPo,"");
		
		request.setAttribute("InTransitCount", InTransitCount);
		
		//获得打印结算单信息----------------------------
		String actionTypeID = "38";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------
		
		return SUCCESS;		
	}
	
	/**
	 * 加载员工卡扫描页
	 */
	public String initPensonScan() throws Exception {
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
	 * 修改门店配送
	 */
	public String updateDoorStoreDelivery() throws Exception {

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
			String[] ssesbdragstype = request.getParameter("ssesbdragstype").split(",");
			String personid = ppo.getId();
			
			String errorsalesid = "以下销售单号：\\n";
			String errortype = "";
			for (int i = 0; i < ssesbsalesid.length; i++){
				int istake = billKeyMgr.selectProcurementOrderForType("3",ssesbsalesid[i]);
				if(istake == 1){
					errorsalesid = errorsalesid + ssesbsalesid[i]+"\\n";
					errortype = "1";
				}
			}
			if(errortype.equals("1")){
				this.clearMessages();
				this.addActionMessage(errorsalesid+"已被门店配送，不能进行重复操作！");
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				
				return SUCCESS;
			}

			
			InTransitPo inTransitPo = new InTransitPo();
			inTransitPo.setSseitcreateperson(createPerson);
			inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
			
			DistributionPo distributionPo = new DistributionPo();
			distributionPo.setSdndnlogonperson(createPerson);
			distributionPo.setSdndnPerson(personid);
			distributionPo.setSdndntype("1");// 配送类型：门店配送
			distributionPo.setSdndnid("PS"+GenerateNumber.getInstance().getGenerageNumber());   //主键
			distributionPo.setSdndndepartmentid(personInfoPo.getDepartmentID());
			
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 模块ID
			logPo.setsLogOpID("3");    //修改	
			
			doorStoreDeliveryMgr.updateSalesBasicPos(systemParameterPo,ssesbsalesid,ssesbdragstype, inTransitPo,distributionPo,logPo);
	
			this.addActionMessage(getText("struts.messages.update.sucess"));			
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
	}
	
	/**
	 * 初始化查询已配送配镜单
	 */
	public String initSelectedDoorStoreDelivery() throws Exception {
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
				
		String type = Utility.getName(request.getParameter("type"));
		request.setAttribute("type",type);
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		WarehousePo po = new WarehousePo();
		po.setBwhdeptid(personInfoPo.getDepartmentID());
		po.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		
		if (type.equals("1")){
			warehouseList = new ArrayList<WarehousePo>();
			warehouseList.add(po);
		}else if (type.equals("2")){
			warehouseList = processDistributionMgr.getWarehouseList(deppo);
		}else if (type.equals("3")){
			warehouseList = invisibleDistributionMgr.getWarehouseList(deppo);	
		}
		
	    request.setAttribute("deliveryShopCode",personInfoPo.getDepartmentID());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			this.setType(type);
			return "selectedDoorStoreDelivery";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询已配送配镜单
	 */
	public String selectedDoorStoreDelivery() throws Exception {
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
		
		String type = Utility.getName(request.getParameter("type"));
		request.setAttribute("type",type);
		this.setType(type);
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());	
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		WarehousePo po = new WarehousePo();
		po.setBwhdeptid(personInfoPo.getDepartmentID());
		po.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		
		if (type.equals("1")){
			warehouseList = new ArrayList<WarehousePo>();
			warehouseList.add(po);
		}else if (type.equals("2")){
			warehouseList = processDistributionMgr.getWarehouseList(deppo);
		}else if (type.equals("3")){
			warehouseList = invisibleDistributionMgr.getWarehouseList(deppo);	
		}
		
		String deliverySalesBillID = Utility.getName(request.getParameter("deliverySalesBillID"));
		String deliveryBillID = Utility.getName(request.getParameter("deliveryBillID"));
		String deliveryStartDate = Utility.getName(request.getParameter("deliveryStartDate"));
		String deliveryEndDate = Utility.getName(request.getParameter("deliveryEndDate"));
		String deliveryPerson = Utility.getName(request.getParameter("deliveryPerson"));
		String deliveryShopCode = Utility.getName(request.getParameter("deliveryShopCode"));
		String [] shoporderstypes = request.getParameterValues("shoporderstype");
		
		if(shoporderstypes == null){
			shoporderstypes = new String[]{""};
		}
		if (deliveryShopCode.equals("")){
			deliveryShopCode = warehouseList.size()>=1 ? warehouseList.get(0).getBwhdeptid() : "";
		}
		request.setAttribute("deliverySalesBillID",deliverySalesBillID);
		request.setAttribute("deliveryBillID",deliveryBillID);
		request.setAttribute("deliveryStartDate",deliveryStartDate);
		request.setAttribute("deliveryEndDate",deliveryEndDate);
		request.setAttribute("deliveryPerson",deliveryPerson);
		request.setAttribute("deliveryShopCode",deliveryShopCode);
		request.setAttribute("shoporderstypes",shoporderstypes);
		
		distributionPo = new DistributionPo();
		distributionPo.setSdndnid(deliveryBillID);
		distributionPo.setSdndnPerson(deliveryPerson);
		distributionPo.setSdndncreatebgndate(deliveryStartDate);
		distributionPo.setSdndncreateenddate(deliveryEndDate);
		distributionPo.setSdndnshopcode(deliveryShopCode);
		distributionPo.setSdndntype(type);
		distributionPo.setSdndnsalesid(deliverySalesBillID);
		distributionPo.setSdndnorderstypes(shoporderstypes);
		
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
		
		int count = doorStoreDeliveryMgr.getDoorStoreYetDeliveryCount(distributionPo);
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
			distributionList = doorStoreDeliveryMgr.getDoorStoreYetDeliveryList(distributionPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			distributionList = null;
		}
		
		request.setAttribute("InTransitCount", Utility.getName(request.getParameter("InTransitCount")));
		

		
		return SUCCESS;
	}
	
	/**
	 * 查询已配送配镜单详情
	 */
	public String doorStoreDeliveryDetail() throws Exception {
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
		distributionEntryList = doorStoreDeliveryMgr.getDoorStoreYetDeliveryEntryDetail(po);
		
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
