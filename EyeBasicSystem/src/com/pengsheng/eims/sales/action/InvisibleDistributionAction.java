package com.pengsheng.eims.sales.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.WindowsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.mgr.InvisibleDistributionMgr;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
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

public class InvisibleDistributionAction extends BaseAction {
	
	private List<WarehousePo> warehouseList;
	private InvisibleDistributionMgr invisibleDistributionMgr;
	private SalesBasicPo salesBasicPo;
	private List<SalesBasicPo> saList;
	private PersonPermissionMgr personPermissionMgr;
	private WarehouseConfigurationPo warehouseConfigurationPo;
	private DepartmentsMgr departmentsMgr;
	private FittingTemplateTypeMgr fittingTemplateTypeMgr = null;   
    private WindowsMgr windowsMgr;	
    private PersonInfoMgr personInfoMgr;
    private GuitarManagementMgr guitarManagementMgr;
	private SystemParameterMgr systemParameterMgr;	
	private SystemParameterPo systemParameterPo;
	private BillKeyMgr billKeyMgr;
    
	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}
	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
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
	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}
	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
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
	
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}

	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
	}

	private WarehouseMgr warehouseMgr;

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public List<SalesBasicPo> getSaList() {
		return saList;
	}

	public void setSaList(List<SalesBasicPo> saList) {
		this.saList = saList;
	}

	public InvisibleDistributionMgr getInvisibleDistributionMgr() {
		return invisibleDistributionMgr;
	}

	public void setInvisibleDistributionMgr(
			InvisibleDistributionMgr invisibleDistributionMgr) {
		this.invisibleDistributionMgr = invisibleDistributionMgr;
	}

	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}

	/**
	 * 初始化隐形订做片信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initInvisibleDistributionSel() throws Exception {

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

		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = invisibleDistributionMgr.getDistributionStoreList(deppo);
		
		int count = windowsMgr.isEnabledInTransit("11");
		request.setAttribute("InTransitCount", count);
		
		return SUCCESS;
	}

	/**
	 * 根据条件查询信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selectInvisibleDistribution() throws Exception {

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

		String shopsalesid = Utility.getName(request.getParameter("shopsalesid"));
		String memberId = Utility.getName(request.getParameter("memberId"));
		String shoppersonName = Utility.getName(request.getParameter("shoppersonName"));
		String ssesbsalesdatestarttime = Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime = Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String ssesblocation = Utility.getName(request.getParameter("ssesblocation"));
		String startDate = Utility.getName(request.getParameter("startDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		
		request.setAttribute("shopsalesid",shopsalesid);
		request.setAttribute("memberId",memberId);
		request.setAttribute("shoppersonName",shoppersonName);
		request.setAttribute("ssesbsalesdatestarttime",ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime",ssesbsalesdateendtime);
		request.setAttribute("startDate",startDate);
		request.setAttribute("endDate",endDate);
		request.setAttribute("ssesblocation", ssesblocation);
		
		salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbsalesid(shopsalesid);
		salesBasicPo.setSsesbMemberId(memberId);
		salesBasicPo.setSsesbpersonName(shoppersonName);
		salesBasicPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesBasicPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesBasicPo.setSsesbtakeglassstartdata(startDate);
		salesBasicPo.setSsesbtakeglassenddata(endDate);
		salesBasicPo.setSsesblocation(ssesblocation);
		
		saList = invisibleDistributionMgr.getSalesBasicPos(salesBasicPo);
		
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = invisibleDistributionMgr.getDistributionStoreList(deppo);		
		
		request.setAttribute("InTransitCount", Utility.getName(request.getParameter("InTransitCount")));
		
		//获得打印结算单信息----------------------------
		String actionTypeID = "40";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------
		
		return SUCCESS;
	}
	
	/**
	 * 加载员工卡扫描页
	 */
	public String initPensonScanInvisible() throws Exception {
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
		
		
		String ssesblocation = Utility.getName(request.getParameter("ssesblocation"));
		
		request.setAttribute("ssesblocation", ssesblocation);
		
		return SUCCESS;
	}

	/**
	 * 修改隐形订做片配送
	 */
	public String updateInvisibleDistribution() throws Exception {
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
		
		String personcardid = Utility.getName(request.getParameter("personcardid"));
		
		PersonInfoPo po = new PersonInfoPo();
		po.setCardid(personcardid);
		
		PersonInfoPo ppo = new PersonInfoPo();
		ppo = personInfoMgr.getPersonInfo(po);
		
		if("".equals(Utility.getName(ppo.getId()))){
			this.addActionMessage(getText("不存在该员工信息！")); 
			return "error"; 
		}else{
			String errortype = "";
			String[] ssesbsalesid = request.getParameter("ssesbsalesid").split(",");
			String errorsalesid = "以下销售单号：\\n";
			for(int i=0; i<ssesbsalesid.length; i++){
				int istake = billKeyMgr.selectProcurementOrderForType("11",ssesbsalesid[i]);
				if(istake == 1){
					errorsalesid = errorsalesid + ssesbsalesid[i]+"\\n";
					errortype = "1";
				}
			}
			if(errortype.equals("1")){
				this.clearMessages();
				this.addActionMessage(errorsalesid+"已被配送，不能进行重复操作！");
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				
				return SUCCESS;
			}
			
			InTransitPo inTransitPo = new InTransitPo();
			inTransitPo.setSseitcreateperson(createPerson);
			inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
			
			DistributionPo distributionPo = new DistributionPo();
			distributionPo.setSdndnlogonperson(createPerson);
			distributionPo.setSdndnPerson(ppo.getId());
			distributionPo.setSdndntype("3");// 配送类型：隐形配送
			distributionPo.setSdndnid("PS"+GenerateNumber.getInstance().getGenerageNumber());   //主键
			distributionPo.setSdndndepartmentid(personInfoPo.getDepartmentID());
			
			AllocationPo allocationPo = new AllocationPo();
			allocationPo.setCshaaoutdepartmentid(personInfoPo.getDepartmentID());
			allocationPo.setCshaacreateperson(personInfoPo.getId());
			allocationPo.setCshaaauditperson(personInfoPo.getId());
			
			//添加日志
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("1");    // 表示状态
			logPo.setsLogContent("隐形配送单:" + distributionPo.getSdndnid() + "新增!");
			
			String message = invisibleDistributionMgr.updateSalesBasicPosCheck(systemParameterPo,allocationPo,ssesbsalesid, inTransitPo, distributionPo,logPo);
	
			this.clearMessages();
			this.addActionMessage(message);	
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
	}
	public FittingTemplateTypeMgr getFittingTemplateTypeMgr() {
		return fittingTemplateTypeMgr;
	}
	public void setFittingTemplateTypeMgr(
			FittingTemplateTypeMgr fittingTemplateTypeMgr) {
		this.fittingTemplateTypeMgr = fittingTemplateTypeMgr;
	}

}
