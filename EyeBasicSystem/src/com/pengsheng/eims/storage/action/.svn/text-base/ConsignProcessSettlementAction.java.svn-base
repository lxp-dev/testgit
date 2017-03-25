package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.ConsignProcessSettlementMgr;
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

public class ConsignProcessSettlementAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;

	private ConsignProcessSettlementMgr consignProcessSettlementMgr;

	private WarehouseMgr warehouseMgr;

	private InventoryPo inventoryPo;

	private GoodsInfoTempPo goodsInfoTempPo;

	private List<InventoryEntryPo> inventoryEntryList;

	private List<InventoryPo> consignProcessSettlementList;
	
	private SystemParameterMgr systemParameterMgr;
	
	private FittingTemplateTypeMgr fittingTemplateTypeMgr = null;
	
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


	public ConsignProcessSettlementMgr getConsignProcessSettlementMgr() {
		return consignProcessSettlementMgr;
	}

	public void setConsignProcessSettlementMgr(
			ConsignProcessSettlementMgr consignProcessSettlementMgr) {
		this.consignProcessSettlementMgr = consignProcessSettlementMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<InventoryPo> getConsignProcessSettlementList() {
		return consignProcessSettlementList;
	}

	public void setConsignProcessSettlementList(
			List<InventoryPo> consignProcessSettlementList) {
		this.consignProcessSettlementList = consignProcessSettlementList;
	}

	private List<WarehousePo> warehouseList;

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}

	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}

	public List<InventoryEntryPo> getInventoryEntryList() {
		return inventoryEntryList;
	}

	public void setInventoryEntryList(List<InventoryEntryPo> inventoryEntryList) {
		this.inventoryEntryList = inventoryEntryList;
	}

	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}

	/**
	 * 初始化委外收货结算查询
	 */
	public String initConsignProcessSettlementSel() throws Exception {

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
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(deppo);
		request.setAttribute("auditState", "0");
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		
		//获得打印结算单信息----------------------------
		String actionTypeID = "21";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------
		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selConsignProcessSettlement";
		}
		return SUCCESS;
	}

	/**
	 * 委外收货结算查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selConsignProcessSettlement() throws Exception {

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

		String billID = Utility.getName(request.getParameter("selbillID"));
		String sourceBillID = Utility.getName(request.getParameter("sourceBillID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String instockID = Utility.getName(request.getParameter("instockID"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String selcstpsupplierid = Utility.getName(request.getParameter("selcstpsupplierid"));
		String selbspsuppliername = Utility.getName(request.getParameter("selbspsuppliername"));
		String financeAuditPersonName = Utility.getName(request.getParameter("financeAuditPersonName"));
		String financeAuditPersonID = Utility.getName(request.getParameter("financeAuditPersonID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String categoryid=Utility.getName(request.getParameter("categoryid"));
		String createStartTime = Utility.getName(request.getParameter("createStartTime"));
		String createEndTime = Utility.getName(request.getParameter("createEndTime"));
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("selbillID", billID);
		request.setAttribute("sourceBillID", sourceBillID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("instockID", instockID);
		request.setAttribute("auditState", auditState);
		request.setAttribute("selcstpsupplierid", selcstpsupplierid);
		request.setAttribute("selbspsuppliername", selbspsuppliername);
		request.setAttribute("financeAuditPersonName", financeAuditPersonName);
		request.setAttribute("financeAuditPersonID", financeAuditPersonID);
		request.setAttribute("categoryid", categoryid);
		request.setAttribute("createStartTime", createStartTime);
		request.setAttribute("createEndTime", createEndTime);
		InventoryPo po = new InventoryPo();
		po.setCstibillid(billID);
		po.setCstisourcebillid(sourceBillID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstiinstockid(instockID);
		po.setCstisupplierid(selcstpsupplierid);
		po.setCstifinanceauditstate(auditState);
		po.setCstibilltypeid("9");
		po.setCstifinanceauditpersonname(financeAuditPersonName);
		po.setCstifinanceauditperson(financeAuditPersonID);
		po.setCstigoodsname(goodsName);
		po.setCstigoodsid(goodsID);
		po.setCstigoodscategory(categoryid);
		po.setCreateendtime(createEndTime);
		po.setCreatestarttime(createStartTime);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setCsticompanyid(personInfoPo.getPersoncompanyid());
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

		int count = consignProcessSettlementMgr
				.getConsignProcessSettlementCount(po);
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
			consignProcessSettlementList = consignProcessSettlementMgr
					.getConsignProcessSettlementList(po, page.getStart(), page
							.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			consignProcessSettlementList = null;
		}
		
		// 取得登陆人允许操作的仓位 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(deppo);
		// 取得登陆人允许操作的仓位 End

		
		//获得打印结算单信息----------------------------
		String actionTypeID = "21";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);		
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------
		
		return SUCCESS;
	}
	
	/**
	 * 初始化委外收货结算修改
	 */
	public String initConsignProcessSettlementUpdate() throws Exception {
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
		getConsignProcessSettlementData();
		return SUCCESS;
	}

	/**
	 * 修改委外收货结算
	 */
	public String updateConsignProcessSettlement() throws Exception {
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

		inventoryPo.setCstibillid(inventoryPo.getCstibillid());
		if ("".equals(Utility.getName(inventoryPo.getCstifinanceauditstate()))) {
			inventoryPo.setCstifinanceauditstate("0");
		} else if ("1".equals(Utility.getName(inventoryPo.getCstifinanceauditstate()))) {
			inventoryPo.setCstifinanceauditstate("1");
			inventoryPo.setCstifinanceauditdate(inventoryPo.getCstifinanceauditdate());
			inventoryPo.setCstifinanceauditperson(personInfoPo.getId());
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("24");    // 表示状态
		logPo.setsLogContent("委外收货单:" + inventoryPo.getCstibillid() + "结算!");

		int lenth = goodsInfoTempPo.getId().length;

		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		for (int i = 0; i < lenth; i++) {
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstieid(goodsInfoTempPo.getId()[i]);

			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);// 单位成本(不含税)
			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);// 成本合计(不含税)
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);// 税率
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);// 含税单价
			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);// 价税合计
			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);// 税额合计

			inventoryEntryList.add(inventoryEntryPo);
		}
		consignProcessSettlementMgr.updateConsignProcessSettlement(inventoryPo,inventoryEntryList,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		String cstifinanceauditstate = Utility.getName(request.getParameter("cstifinanceauditstate"));
		getConsignProcessSettlementData();
		//if (cstifinanceauditstate.equals("0")){
		//	return INPUT;
		//}
		return SUCCESS;
	}
	/**
	 * 财务结算详细
	 */
	public String initConsignProcessSettlementDetails() throws Exception {
		getConsignProcessSettlementData();
		return SUCCESS;
	}
	
	private void getConsignProcessSettlementData(){
		String id = Utility.getName(request.getParameter("hid"));
		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);
		inventoryPo = consignProcessSettlementMgr.getConsignProcessSettlement(po);
		inventoryEntryList = consignProcessSettlementMgr.getConsignProcessSettlementDetailsList(po);
		request.setAttribute("hid",id);
	}

	public FittingTemplateTypeMgr getFittingTemplateTypeMgr() {
		return fittingTemplateTypeMgr;
	}

	public void setFittingTemplateTypeMgr(
			FittingTemplateTypeMgr fittingTemplateTypeMgr) {
		this.fittingTemplateTypeMgr = fittingTemplateTypeMgr;
	}
}
