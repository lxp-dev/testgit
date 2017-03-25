package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.storage.mgr.FinancialSettlementMgr;
import com.pengsheng.eims.storage.mgr.ProcurementOrdersMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class FinancialSettlementAction extends BaseAction {
	
    private SystemParameterMgr systemParameterMgr;	
	private SystemParameterPo systemParameterPo;	
	private List<GoodsCategoryPo> goodsCategorys;	
	private ProcurementOrdersMgr procurementOrdersMgr;
	private ReportQuartzMgr reportQuartzMgr;
	private FquartzSwitchPo fquartzSwitchPo;
	
	public FquartzSwitchPo getFquartzSwitchPo() {
		return fquartzSwitchPo;
	}

	public void setFquartzSwitchPo(FquartzSwitchPo fquartzSwitchPo) {
		this.fquartzSwitchPo = fquartzSwitchPo;
	}

	public ReportQuartzMgr getReportQuartzMgr() {
		return reportQuartzMgr;
	}

	public void setReportQuartzMgr(ReportQuartzMgr reportQuartzMgr) {
		this.reportQuartzMgr = reportQuartzMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public ProcurementOrdersMgr getProcurementOrdersMgr() {
		return procurementOrdersMgr;
	}

	public void setProcurementOrdersMgr(ProcurementOrdersMgr procurementOrdersMgr) {
		this.procurementOrdersMgr = procurementOrdersMgr;
	}


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


	private PersonPermissionMgr personPermissionMgr;

	private FinancialSettlementMgr financialSettlementMgr;

	private WarehouseMgr warehouseMgr;

	private InventoryPo inventoryPo;

	private GoodsInfoTempPo goodsInfoTempPo;

	private List<InventoryEntryPo> inventoryEntryList;

	private List<InventoryPo> financialSettlementList;

	private List<WarehousePo> warehouseList;

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}

	public FinancialSettlementMgr getFinancialSettlementMgr() {
		return financialSettlementMgr;
	}

	public void setFinancialSettlementMgr(
			FinancialSettlementMgr financialSettlementMgr) {
		this.financialSettlementMgr = financialSettlementMgr;
	}

	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}

	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}

	public List<InventoryPo> getFinancialSettlementList() {
		return financialSettlementList;
	}

	public void setFinancialSettlementList(
			List<InventoryPo> financialSettlementList) {
		this.financialSettlementList = financialSettlementList;
	}

	/**
	 * 初始化财务结算查询
	 */
	public String initFinancialSettlementSel() throws Exception {

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

		// 取得登陆人允许操作的仓位 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(deppo);
		request.setAttribute("auditState", "0");
		// 取得登陆人允许操作的仓位 End
		request.setAttribute("makeinvoiceflag", 1);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selFinancialSettlement";
		}	
		return SUCCESS;
	}

	/**
	 * 查询财务结算
	 */
	public String selFinancialSettlement() throws Exception {

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

		String billID = Utility.getName(request.getParameter("billID"));
		String sourceBillID = Utility.getName(request.getParameter("sourceBillID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String instockID = Utility.getName(request.getParameter("instockID"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String selcstpsupplierid = Utility.getName(request.getParameter("selcstpsupplierid"));
		String selbspsuppliername = Utility.getName(request.getParameter("selbspsuppliername"));
		String financeAuditPersonName = Utility.getName(request.getParameter("financeAuditPersonName"));
		String financeAuditPersonID = Utility.getName(request.getParameter("financeAuditPersonID"));
		String receiptpersonname = Utility.getName(request.getParameter("receiptpersonname"));
		String cstpgoodscategory = Utility.getName(request.getParameter("selbspcategoryid"));
		String deliveryid = Utility.getName(request.getParameter("deliveryid"));
		String createStartTime = Utility.getName(request.getParameter("createStartTime"));
		String createEndTime = Utility.getName(request.getParameter("createEndTime"));
		
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		request.setAttribute("goodsName", goodsName);
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		request.setAttribute("goodsID", goodsID);
		String makeinvoiceflag = Utility.getName(request.getParameter("makeinvoiceflag"));
		request.setAttribute("makeinvoiceflag", makeinvoiceflag);
		
		FquartzSwitchPo fspo = reportQuartzMgr.getFquartzSwitchPo();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		InventoryPo po = new InventoryPo();
		po.setCstibillid(billID);
		po.setCstisourcebillid(sourceBillID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstiinstockid(instockID);
		po.setCstisupplierid(selcstpsupplierid);
		po.setCstifinanceauditstate(auditState);
		po.setCstibilltypeid("1");
		po.setCstifinanceauditpersonname(financeAuditPersonName);
		po.setCstifinanceauditperson(financeAuditPersonID);
		po.setCstigoodsname(goodsName);
		po.setCstiauditpersonname(receiptpersonname);
		po.setCstigoodscategory(cstpgoodscategory);
		po.setCstigoodsid(goodsID);
		po.setDeliveryID(deliveryid);
		po.setMakeinvoiceflag(makeinvoiceflag);
		po.setMakeinvoiceflags(fspo.getFqswzhzstd());
		po.setCreateendtime(createEndTime);
		po.setCreatestarttime(createStartTime);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setCsticompanyid(personInfoPo.getPersoncompanyid());
		}
		
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

		int count = financialSettlementMgr.getFinancialSettlementCount(po);
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
			financialSettlementList = financialSettlementMgr
					.getFinancialSettlementList(po, page.getStart(), page
							.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			financialSettlementList = null;
		}
		
		// 得到商品类型
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		request.setAttribute("billID", billID);
		request.setAttribute("sourceBillID", sourceBillID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("instockID", instockID);
		request.setAttribute("auditState", auditState);
		request.setAttribute("selcstpsupplierid", selcstpsupplierid);
		request.setAttribute("selbspsuppliername", selbspsuppliername);
		request.setAttribute("selbspcategoryid", cstpgoodscategory);
		request.setAttribute("financeAuditPersonName", financeAuditPersonName);
		request.setAttribute("financeAuditPersonID", financeAuditPersonID);
		request.setAttribute("receiptpersonname", receiptpersonname);
		request.setAttribute("deliveryid", deliveryid);
		request.setAttribute("createStartTime", createStartTime);
		request.setAttribute("createEndTime", createEndTime);
		
		// 取得登陆人允许操作的仓位 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(deppo);
		// 取得登陆人允许操作的仓位 End
		
		return SUCCESS;
	}

	/**
	 * 财务结算详细
	 */
	public String initFinancialSettlementDetails() throws Exception {
		getFinancialSettlementData();
		return SUCCESS;
	}

	/**
	 * 初始化财务结算修改
	 */
	public String initFinancialSettlementUpdate() throws Exception {
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
		getFinancialSettlementData();
		return SUCCESS;
	}
	private void getFinancialSettlementData(){
		String id = Utility.getName(request.getParameter("hid"));
		inventoryPo = new InventoryPo();
		inventoryPo.setCstibillid(id);
		inventoryPo = financialSettlementMgr.getFinancialSettlement(inventoryPo);
		inventoryEntryList = financialSettlementMgr.getFinancialSettlementEntryList(inventoryPo);
		request.setAttribute("hid",id);
	}
	/**
	 * 修改财务结算
	 */
	public String updateFinancialSettlement() throws Exception {
		
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
		if ("1".equals(Utility.getName(inventoryPo
				.getCstifinanceauditstate()))) {
			inventoryPo.setCstifinanceauditstate("1");
			inventoryPo.setCstifinanceauditdate(inventoryPo
					.getCstifinanceauditdate());
			inventoryPo.setCstifinanceauditperson(personInfoPo.getId());
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("24");    // 表示状态
		logPo.setsLogContent("采购收货单:" + inventoryPo.getCstibillid() + "结算!");

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
		financialSettlementMgr.updateFinancialSettlement(inventoryPo,inventoryEntryList,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		String cstifinanceauditstate = Utility.getName(request.getParameter("cstifinanceauditstate"));
		getFinancialSettlementData();
		//if (cstifinanceauditstate.equals("0")){
		//	return INPUT;
		//}		
		return SUCCESS;
	}
	
	/**
	 * 初始化批量结算
	 * @return
	 */
	public String initFinancialSettlementBatch(){
		
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
	 * 批量结算
	 * @return
	 */
	public String insertFinancialSettlementBatch(){
		
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
		List<InventoryPo> strList = new ArrayList<InventoryPo>();
		String[] salesidarray = null;
        String msg = "结算成功!";
		String salesbillid = Utility.getName(request.getParameter("salesid"));
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("33");    // 表示状态
		logPo.setsLogContent("批量结算: ");		

		if (salesbillid.indexOf(",") >= 0){
			salesidarray = salesbillid.split(",");
			
			for (int v = 0; v < salesidarray.length; v++){				
				InventoryPo ipo = new InventoryPo();
				ipo.setCstibillid(salesidarray[v]);
				ipo.setCstifinanceauditperson(createPerson);
				
				strList.add(ipo);
			}
			
			financialSettlementMgr.insertFinancialSettlementBatch(strList,logPo);
		}else{
			msg = "结算失败!";
		}
		
		this.clearMessages();
		this.addActionMessage(msg);
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;

	}

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	public List<InventoryEntryPo> getInventoryEntryList() {
		return inventoryEntryList;
	}

	public void setInventoryEntryList(List<InventoryEntryPo> inventoryEntryList) {
		this.inventoryEntryList = inventoryEntryList;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
}
