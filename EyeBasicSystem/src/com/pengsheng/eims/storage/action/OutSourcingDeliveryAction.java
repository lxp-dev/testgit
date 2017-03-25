package com.pengsheng.eims.storage.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.mgr.OutSourcingDeliveryMgr;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;

public class OutSourcingDeliveryAction extends BaseAction  {

	private OutSourcingDeliveryMgr outSourcingDeliveryMgr;
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<SalesBasicPo> salesBasicPoList;
	private ConsignProcessReceiptPo consignProcessReceiptPo;
	private WarehouseMgr warehouseMgr;
	private List<WarehousePo> warehouseList;
	private DepartmentsMgr departmentsMgr;
	
	/**
	 * 初始化委外配送查询
	 */
	public String initConsignProcessDelivery() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getRegWarehouseAllList(deppo);
		
		return SUCCESS;
	}
	
	/**
	 * 委外配送查询
	 */
	public String selectConsignProcessDelivery() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String createpersonid = Utility.getName(request.getParameter("createpersonid"));  // 委外收货单制单人ID
		String billbgndate = Utility.getName(request.getParameter("billbgndate"));        // 收货起始时间
		String billenddate = Utility.getName(request.getParameter("billenddate"));        // 收货截止时间
		String processwarehouseid = Utility.getName(request.getParameter("processwarehouseid"));  // 发料仓位
		
		request.setAttribute("createpersonid",createpersonid);
		request.setAttribute("billbgndate",billbgndate);
		request.setAttribute("billenddate",billenddate);
		request.setAttribute("processwarehouseid",processwarehouseid);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getRegWarehouseAllList(deppo);
		
		ConsignProcessReceiptPo crpo = new ConsignProcessReceiptPo();
		crpo.setCstcprcreateperson(createpersonid);
		crpo.setCstcprdeliverystart(billbgndate);
		crpo.setCstcprdeliveryend(billenddate);
		crpo.setCstcprfaliaostockid(processwarehouseid);
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			crpo.setCstcprcompanyid(personInfoPo1.getPersoncompanyid());
		}
		
		salesBasicPoList = outSourcingDeliveryMgr.getNotMaterialsSalesBillList(crpo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化委外配送修改
	 */
	public String initConsignProcessDeliveryUpdate() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		request.setAttribute("billArray",Utility.getName(request.getParameter("billArray")));
		request.setAttribute("ystock",Utility.getName(request.getParameter("ystock")));
		request.setAttribute("xstock",Utility.getName(request.getParameter("xstock")));
		
		return SUCCESS;
	}
	
	/**
	 * 委外配送修改
	 */
	public String updateConsignProcessDelivery() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("配镜单："+Utility.getName(consignProcessReceiptPo.getCstcprsalesid())+" 委外配送!");
		
		String ystock = Utility.getName(request.getParameter("ystock"));
		String xstock = Utility.getName(request.getParameter("xstock"));
		
		String indpt = departmentsMgr.getDepartmentByWarehouseID(xstock);
		String outdpt = departmentsMgr.getDepartmentByWarehouseID(ystock);
		
        AllocationPo apo = new AllocationPo();
        apo.setCshaabillid("ALL" + GenerateNumber.getInstance().getGenerageNumber());  // 调拨单号
        apo.setCshaacreateperson(createPerson); //制单人
        apo.setCshaaauditperson(createPerson);  //审核人        
        apo.setCshaaoutdepartmentid(outdpt);   //发出部门
        apo.setCshaaoutstockid(ystock);    //发出仓位
        apo.setCshaainstockid(xstock);    //接收仓位
        apo.setCshaaindepartmentid(indpt);   // 接收部门
        
        consignProcessReceiptPo.setCstcpralloctionbillid(apo.getCshaabillid());
        
		outSourcingDeliveryMgr.updateNotMaterialsSalesBill(apo,consignProcessReceiptPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	public OutSourcingDeliveryMgr getOutSourcingDeliveryMgr() {
		return outSourcingDeliveryMgr;
	}

	public void setOutSourcingDeliveryMgr(
			OutSourcingDeliveryMgr outSourcingDeliveryMgr) {
		this.outSourcingDeliveryMgr = outSourcingDeliveryMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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

	public List<SalesBasicPo> getSalesBasicPoList() {
		return salesBasicPoList;
	}

	public void setSalesBasicPoList(List<SalesBasicPo> salesBasicPoList) {
		this.salesBasicPoList = salesBasicPoList;
	}

	public ConsignProcessReceiptPo getConsignProcessReceiptPo() {
		return consignProcessReceiptPo;
	}

	public void setConsignProcessReceiptPo(
			ConsignProcessReceiptPo consignProcessReceiptPo) {
		this.consignProcessReceiptPo = consignProcessReceiptPo;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

}
