package com.pengsheng.eims.storage.action;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.mgr.ProcurementOrdersMgr;
import com.pengsheng.eims.storage.mgr.ProcurementReceiptMgr;
import com.pengsheng.eims.storage.mgr.ProcurementReturnMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ProcurementReturnAction extends BaseAction {

	private ProcurementReturnMgr procurementReturnMgr;
	private PersonPermissionMgr personPermissionMgr;
	private WarehouseMgr warehouseMgr;
	private DepartmentsMgr departmentsMgr;
	private InventoryPo inventoryPo;
	private GoodsInfoTempPo goodsInfoTempPo;
	private List<InventoryEntryPo> inventoryEntryList;
	private List<InventoryPo> procurementReturnList;
	private FittingTemplateTypeMgr fittingTemplateTypeMgr = null;	
	private List<WarehousePo> warehouseList;
	private List<DepartmentsPo> departmentsList;
	private List<AllocationBarcodePo> allocationBarcodeLists;	
	private WarehouseConfigurationPo warehouseConfigurationPo;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private List<GoodsCategoryPo> goodsCategorys;
	private AllocationMgr allocationMgr;
	private BillKeyMgr billKeyMgr;
	private ProcurementReceiptMgr procurementReceiptMgr;
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

	public ProcurementReceiptMgr getProcurementReceiptMgr() {
		return procurementReceiptMgr;
	}

	public void setProcurementReceiptMgr(ProcurementReceiptMgr procurementReceiptMgr) {
		this.procurementReceiptMgr = procurementReceiptMgr;
	}

	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}

	private ProcurementOrdersMgr procurementOrdersMgr;
		
	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}

	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
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

	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}

	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
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

	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}

	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
	}
	
	public List<AllocationBarcodePo> getAllocationBarcodeLists() {
		return allocationBarcodeLists;
	}

	public void setAllocationBarcodeLists(
			List<AllocationBarcodePo> allocationBarcodeLists) {
		this.allocationBarcodeLists = allocationBarcodeLists;
	}

	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}

	public ProcurementReturnMgr getProcurementReturnMgr() {
		return procurementReturnMgr;
	}

	public void setProcurementReturnMgr(
			ProcurementReturnMgr procurementReturnMgr) {
		this.procurementReturnMgr = procurementReturnMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}

	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}

	public List<InventoryPo> getProcurementReturnList() {
		return procurementReturnList;
	}

	public void setProcurementReturnList(List<InventoryPo> procurementReturnList) {
		this.procurementReturnList = procurementReturnList;
	}

	/**
	 * 初始化采购退货查询
	 */
	public String initProcurementReturnSel() throws Exception {

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
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		
		//获得打印结算单信息----------------------------
		String actionTypeID = "27";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------
		
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		// 取得登陆人允许操作的仓位&部门 End
		request.setAttribute("makeinvoiceflag", 1);
		 systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "selProcurementReturn";
			}

		return SUCCESS;
	}

	/**
	 * 查询采购退货
	 */
	public String selProcurementReturn() throws Exception {
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

		// 条件查询
		String billID = Utility.getName(request.getParameter("billID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String startTime1 = Utility.getName(request.getParameter("startTime1"));
		String endTime1 = Utility.getName(request.getParameter("endTime1"));
		String departmentid = Utility.getName(request.getParameter("cstidepartmentid"));
		String outstockID = Utility.getName(request.getParameter("cstioutstockid"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String selcstpsupplierid = Utility.getName(request.getParameter("selcstpsupplierid"));
		String selbspsuppliername = Utility.getName(request.getParameter("selbspsuppliername"));
		String createPersonName = Utility.getName(request.getParameter("createPersonName"));
		String csticreateperson = Utility.getName(request.getParameter("csticreateperson"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String cstiauditperson = Utility.getName(request.getParameter("cstiauditperson"));
		String cstpgoodscategory = Utility.getName(request.getParameter("selbspcategoryid"));
		String deliveryid = Utility.getName(request.getParameter("deliveryid"));
		
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodsID", goodsID);
		String makeinvoiceflag = Utility.getName(request.getParameter("makeinvoiceflag"));
		request.setAttribute("makeinvoiceflag", makeinvoiceflag);
		// 将取出的条件放入Po中
		InventoryPo po = new InventoryPo();
		po.setCstibillid(billID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstistartTime1(startTime1);
		po.setCstiendTime1(endTime1);
		po.setCstioutstockid(outstockID);
		po.setCstisupplierid(selcstpsupplierid);
		po.setCstiauditstate(auditState);
		po.setCstidepartmentid(departmentid);
		po.setCsticreatepersonname(createPersonName);
		po.setCsticreateperson(csticreateperson);
		po.setCstiauditpersonname(auditPersonName);
		po.setCstiauditperson(cstiauditperson);
		po.setCstigoodscategory(cstpgoodscategory);
		po.setCstigoodsid(goodsID);
		po.setCstigoodsname(goodsName);
		po.setDeliveryID(deliveryid);
		po.setMakeinvoiceflag(makeinvoiceflag);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setCsticompanyid(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		FquartzSwitchPo fspo = reportQuartzMgr.getFquartzSwitchPo();
		po.setMakeinvoiceflags(fspo.getFqswzhzstd());
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

		// 总数、分页
		int count = procurementReturnMgr.getProcurementReturnCount(po);
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
			// 取详细信息
			procurementReturnList = procurementReturnMgr.getProcurementReturnList(po, page.getStart(), page
							.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			procurementReturnList = null;
		}

		// 得到商品类型
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		request.setAttribute("billID", billID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("startTime1", startTime1);
		request.setAttribute("endTime1", endTime1);
		request.setAttribute("outstockID", outstockID);
		request.setAttribute("departmentid", departmentid);
		request.setAttribute("auditState", auditState);
		request.setAttribute("selcstpsupplierid", selcstpsupplierid);
		request.setAttribute("selbspsuppliername", selbspsuppliername);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("csticreateperson", csticreateperson);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("cstiauditperson", cstiauditperson);
		request.setAttribute("selbspcategoryid", cstpgoodscategory);
		request.setAttribute("deliveryid", deliveryid);

		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		// 取得登陆人允许操作的仓位&部门 End.
		
		//获得打印结算单信息----------------------------
		String actionTypeID = "27";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------
		
		return SUCCESS;
	}

	/**
	 * 初始化采购退货查询
	 */
	public String initProcurementReturnStorageSel() throws Exception {
		
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
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);
		
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		warehouseList = warehouseMgr.getWarehouseList(deppo);

		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selprocurementReturnStorages";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询采购退货
	 */
	public String selProcurementReturnStorage() throws Exception {
		
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

		// 条件查询
		String billID = Utility.getName(request.getParameter("billID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String departmentid = Utility.getName(request.getParameter("cstidepartmentid"));
		String outstockID = Utility.getName(request.getParameter("cstioutstockid"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String selcstpsupplierid = Utility.getName(request.getParameter("selcstpsupplierid"));
		String selbspsuppliername = Utility.getName(request.getParameter("selbspsuppliername"));
		String createPersonName = Utility.getName(request.getParameter("createPersonName"));
		String csticreateperson = Utility.getName(request.getParameter("csticreateperson"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String cstiauditperson = Utility.getName(request.getParameter("cstiauditperson"));
		String remark = Utility.getName(request.getParameter("remark"));
		String cstpgoodscategory = Utility.getName(request.getParameter("selbspcategoryid"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String deliveryid = Utility.getName(request.getParameter("deliveryid"));
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodsID", goodsID);
		
		// 将取出的条件放入Po中
		InventoryPo po = new InventoryPo();
		po.setCstibillid(billID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstioutstockid(outstockID);
		po.setCstisupplierid(selcstpsupplierid);
		po.setCstiauditstate(auditState);
		po.setCstidepartmentid(departmentid);
		po.setCsticreatepersonname(createPersonName);
		po.setCsticreateperson(csticreateperson);
		po.setCstiauditpersonname(auditPersonName);
		po.setCstiauditperson(cstiauditperson);
		po.setCstiremark(remark);
		po.setCsticheckgoodsquantity(cstpgoodscategory);
		po.setCstigoodscategory(cstpgoodscategory);
		po.setCstigoodsname(goodsName);
		po.setCstigoodsid(goodsID);
		po.setDeliveryID(deliveryid);
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
		
		
		// 总数、分页
		int count = procurementReturnMgr.getProcurementReturnStorageCount(po);
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
			// 取详细信息
			procurementReturnList = procurementReturnMgr
					.getProcurementReturnStorageList(po, page.getStart(), page
							.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			procurementReturnList = null;
		}
		// 得到商品类型
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();

		request.setAttribute("billID", billID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("outstockID", outstockID);
		request.setAttribute("departmentid", departmentid);
		request.setAttribute("auditState", auditState);
		request.setAttribute("selcstpsupplierid", selcstpsupplierid);
		request.setAttribute("selbspsuppliername", selbspsuppliername);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("csticreateperson", csticreateperson);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("cstiauditperson", cstiauditperson);
		request.setAttribute("remark", remark);
		request.setAttribute("selbspcategoryid", cstpgoodscategory);
		request.setAttribute("deliveryid", deliveryid);

		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);
		
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		warehouseList = warehouseMgr.getWarehouseList(deppo);

		return SUCCESS;
	}

	/**
	 * 初始化商品退货新增
	 */
	public String initProcurementReturnStorageInsert() throws Exception {
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
		String billID = "POUT"
				+ GenerateNumber.getInstance().getGenerageNumber();
		inventoryPo = new InventoryPo();
		inventoryPo.setCstibillid(billID);
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(po);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		return SUCCESS;
	}

	/**
	 * 新增商品退货
	 */
	public String insertProcurementReturnStorage() throws Exception {
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
		
		int isreceipt = procurementReceiptMgr.selectProcurementIsReceipt(Utility.getName(inventoryPo.getCstibillid()).trim());
		if (isreceipt > 0){
			this.clearMessages();
			this.addActionMessage("该采购退货单已退货！");
			
			String url = "''initProcurementReturnStorageDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(inventoryPo.getCstibillid().trim());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
			
		}
		
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(po);
		
		inventoryPo.setCstisourcebillid(request.getParameter("cstisourcebillid"));
		DepartmentsPo departmentsPo = inTransitDetailsMgr.getDepartmentByWarehouse(inventoryPo);
		if (Utility.getName(departmentsPo.getBdpdepartmentid()).equals("")){
			inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID()); // 默认插入退货部门为操作人部门
		}else{
			inventoryPo.setCstidepartmentid(Utility.getName(departmentsPo.getBdpdepartmentid()));
		}
		
		if ("".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			inventoryPo.setCstiauditstate("0");
		}
		if ("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			inventoryPo.setCstiauditperson(inventoryPo.getCsticreateperson());
		}
		
		// 根据公司和制造商查询绑定的供应商
		inventoryPo.setCstisubsupplierid(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),Utility.getName(inventoryPo.getCstisupplierid())));
		
		int lenth = goodsInfoTempPo.getGoodsid().length;
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("采购退货单:" + inventoryPo.getCstibillid() + "新增!");
		
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		String goodsID = null;
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		for (int i = 0; i < lenth; i++) {
			goodsID = goodsInfoTempPo.getGoodsid()[i];
			
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsID);			
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
			inventoryEntryPo.setCstieoutstockid(inventoryPo.getCstioutstockid());
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			
			if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
				inventoryEntryPo.setCstieoutstorageflag("1");
			}else{
				inventoryEntryPo.setCstieoutstorageflag("0");
			}
				
			inventoryEntryPo.setCstiegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			inventoryEntryPo.setCstiespec(goodsInfoTempPo.getSpec()[i]);
			inventoryEntryPo.setCstiemaxquantity(goodsInfoTempPo.getCshaaemaxquantity()[i]);
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		
		if(systemParameterPo.getFspsalestype().equals("0")){
			String errorBarcode = "";
			for(int i=0;i<inventoryEntryList.size(); i++){
				GoodsInfoPo goodspo = new GoodsInfoPo();
				goodspo.setBgiwarehouseid(inventoryPo.getCstioutstockid());
				goodspo.setBgigoodsbarcode(inventoryEntryList.get(i).getCstiebarcode());
				goodspo.setBgiallBillid(inventoryPo.getCstibillid());
				List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
				if(Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity())<Integer.parseInt(inventoryEntryList.get(i).getCstiegoodsquantity())){
					errorBarcode = errorBarcode + inventoryEntryList.get(i).getCstiebarcode()+"\\n";
				}
			}
			
			if(!errorBarcode.equals("")){
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				return "error";
			}
		}
		
		int countnumber = procurementReceiptMgr.selectProcurementReceipt(inventoryPo);
		if (countnumber == 0){
		    procurementReturnMgr.insertProcurementReturnStorage(inventoryPo,inventoryEntryList,null,logPo);
	    }
	
		if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
			String url = "''initProcurementReturnStorageDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(inventoryPo.getCstibillid());
			params.add(moduleID);
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			String url = "''initProcurementReturnStorageUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(inventoryPo.getCstibillid());
			params.add(moduleID);
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
	}

	/**
	 * 初始化采购退货新增
	 */
	public String initProcurementReturnInsert() throws Exception {
		inventoryPo = new InventoryPo();
		// 自动生成编号
		inventoryPo.setCstibillid("POUT"
				+ GenerateNumber.getInstance().getGenerageNumber());

		// 取得登陆人允许操作的仓位&部门 Begin
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehouseList = warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		// 取得登陆人允许操作的仓位&部门 End

		return SUCCESS;
	}

	/**
	 * 新增采购退货
	 */
	public String insertProcurementReturn() throws Exception {

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());
		if ("".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			inventoryPo.setCstiauditstate("0");
		}
		if ("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			inventoryPo.setCstiauditperson(inventoryPo.getCsticreateperson());
		}

		int lenth = goodsInfoTempPo.getGoodsid().length;

		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		for (int i = 0; i < lenth; i++) {
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo
					.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo
					.getGoodsquantity()[i]);
			inventoryEntryPo
					.setCstieoutstockid(inventoryPo.getCstioutstockid());

			inventoryEntryPo
					.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);// 单位成本(不含税)
			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo
					.getNottaxrateamount()[i]);// 成本合计(不含税)

			inventoryEntryPo
					.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);// 含税单价
			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo
					.getCostpriceamount()[i]);// 价税合计

			inventoryEntryPo
					.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);// 税额合计

			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);// 税率

			inventoryEntryList.add(inventoryEntryPo);
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		procurementReturnMgr.insertProcurementReturn(inventoryPo,
				inventoryEntryList);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	/**
	 * 采购退货详细
	 */
	public String initProcurementReturnDetails() throws Exception {

		String id = Utility.getName(request.getParameter("hid"));
		inventoryPo = new InventoryPo();
		inventoryPo.setCstibillid(id);
		inventoryPo = procurementReturnMgr.getProcurementReturn(inventoryPo);
		inventoryEntryList = procurementReturnMgr
				.getProcurementReturnEntryList(inventoryPo);

		for (InventoryEntryPo inventoryEntryPo : inventoryEntryList) {
			BigDecimal priceAmount = null;// 成本合计

			BigDecimal taxAmount = null;// 税额合计

			BigDecimal taxPriceAmount = null;// 价税合计

			priceAmount = new BigDecimal(inventoryEntryPo
					.getCstienottaxrateamount());

			taxPriceAmount = new BigDecimal(inventoryEntryPo
					.getCstiecostpriceamount());
			taxAmount = taxPriceAmount.subtract(priceAmount);

			inventoryEntryPo.setCstietaxamount(taxAmount.toString());
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		return SUCCESS;
	}

	/**
	 * 初始化采购结算退货修改
	 */
	public String initProcurementReturnUpdate() throws Exception {
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
		inventoryPo = new InventoryPo();
		inventoryPo.setCstibillid(id);
		inventoryPo = procurementReturnMgr.getProcurementReturn(inventoryPo);
		inventoryEntryList = procurementReturnMgr
				.getProcurementReturnEntryList(inventoryPo);

		for (InventoryEntryPo inventoryEntryPo : inventoryEntryList) {
			BigDecimal priceAmount = null;// 成本合计

			BigDecimal taxAmount = null;// 税额合计

			BigDecimal taxPriceAmount = null;// 价税合计

			priceAmount = new BigDecimal(inventoryEntryPo
					.getCstienottaxrateamount());

			taxPriceAmount = new BigDecimal(inventoryEntryPo
					.getCstiecostpriceamount());
			taxAmount = taxPriceAmount.subtract(priceAmount);

			inventoryEntryPo.setCstietaxamount(taxAmount.toString());
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		return SUCCESS;
	}

	/**
	 * 修改结算采购退货
	 */
	public String updateProcurementReturn() throws Exception {
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
		
		DepartmentsPo departmentsPo = inTransitDetailsMgr.getDepartmentByWarehouse(inventoryPo);
		if (Utility.getName(departmentsPo.getBdpdepartmentid()).equals("")){
			inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID()); // 默认插入退货部门为操作人部门
		}else{
			inventoryPo.setCstidepartmentid(Utility.getName(departmentsPo.getBdpdepartmentid()));
		}		
		
		if ("".equals(Utility.getName(inventoryPo.getCstifinanceauditstate()))) {
			inventoryPo.setCstifinanceauditstate("0");
		}
		if ("1".equals(Utility.getName(inventoryPo.getCstifinanceauditstate()))) {
			inventoryPo.setCstiauditperson(personInfoPo.getId());
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("24");    // 表示状态
		logPo.setsLogContent("采购退货单:" + inventoryPo.getCstibillid() + "结算!");
		
		int lenth = goodsInfoTempPo.getGoodsid().length;
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		for (int i = 0; i < lenth; i++) {
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);// 单位成本(不含税)
			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);// 成本合计(不含税)
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);// 含税单价
			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);// 价税合计
			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);// 税额合计
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);// 税率
			inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getGoodsbarcode()[i]); // 条码
			inventoryEntryPo.setCstieoutstorageflag("1"); // 条码
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		procurementReturnMgr.updateProcurementReturn(inventoryPo,inventoryEntryList,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		String url = "''initProcurementReturnDetails.action?hid={0}''";
		List<String> params = new ArrayList<String>();
		params.add(inventoryPo.getCstibillid());

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		
		return SUCCESS;
	}

	/**
	 * 初始化采购退货修改
	 */
	public String initProcurementReturnStorageUpdate() throws Exception {
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
		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);
		inventoryPo = procurementReturnMgr.getProcurementReturn(po);
		po.setCstioutstockid(inventoryPo.getCstioutstockid());
		inventoryEntryList = procurementReturnMgr.getProcurementReturnEntryList(po);

		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(deppo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		return SUCCESS;
	}

	/**
	 * 修改采购退货
	 */
	public String updateProcurementReturnStorage() throws Exception {
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
		
		int isaudit = billKeyMgr.selectInventoryForAuditType(inventoryPo.getCstibillid());
		if(isaudit == 1){
			this.clearMessages();
			this.addActionMessage("该单据已被审核，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(po);
		
		DepartmentsPo departmentsPo = inTransitDetailsMgr.getDepartmentByWarehouse(inventoryPo);
		if (Utility.getName(departmentsPo.getBdpdepartmentid()).equals("")){
			inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID()); // 默认插入退货部门为操作人部门
		}else{
			inventoryPo.setCstidepartmentid(Utility.getName(departmentsPo.getBdpdepartmentid()));
		}
		
		if ("".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			inventoryPo.setCstiauditstate("0");
		}
		if ("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			inventoryPo.setCstiauditperson(personInfoPo.getId());
		}		

		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("采购退货单:" + inventoryPo.getCstibillid() + "修改!");

		int lenth = goodsInfoTempPo.getGoodsid().length;

		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		String goodsID = null;
		int count = 0;
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		for (int i = 0; i < lenth; i++) {
			
			goodsID = goodsInfoTempPo.getGoodsid()[i];
			
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsID);			
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
			inventoryEntryPo.setCstieoutstockid(inventoryPo.getCstioutstockid());
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			
			if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
				inventoryEntryPo.setCstieoutstorageflag("1");
			}else{
				inventoryEntryPo.setCstieoutstorageflag("0");
			}
	
			inventoryEntryPo.setCstiegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			inventoryEntryPo.setCstiespec(goodsInfoTempPo.getSpec()[i]);
			//inventoryEntryPo.setCstieunitname(goodsInfoTempPo.getUnitname()[i]);
			inventoryEntryPo.setCstiemaxquantity(goodsInfoTempPo.getCshaaemaxquantity()[i]);
			inventoryEntryPo.setCstiemaxquantity2(String.valueOf(Integer.parseInt(goodsInfoTempPo.getCshaaemaxquantity()[i])-Integer.parseInt(goodsInfoTempPo.getGoodsquantity()[i])));
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		
		if(systemParameterPo.getFspsalestype().equals("0")){
			String errorBarcode = "";
			for(int i=0;i<inventoryEntryList.size(); i++){
				GoodsInfoPo goodspo = new GoodsInfoPo();
				goodspo.setBgiwarehouseid(inventoryPo.getCstioutstockid());
				goodspo.setBgigoodsbarcode(inventoryEntryList.get(i).getCstiebarcode());
				goodspo.setBgiallBillid(inventoryPo.getCstibillid());
				List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
				if(Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity())<Integer.parseInt(inventoryEntryList.get(i).getCstiegoodsquantity())){
					errorBarcode = errorBarcode + inventoryEntryList.get(i).getCstiebarcode()+"\\n";
				}
			}
			
			if(!errorBarcode.equals("")){
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				return "error";
			}
		}
		
		int countnumber = procurementReceiptMgr.selectProcurementReceipt(inventoryPo);
		if (countnumber == 0){
			procurementReturnMgr.updateProcurementReturnStorage(inventoryPo,inventoryEntryList,null,logPo);
	    }		
		
		request.setAttribute("systemParameterPo", systemParameterPo);
		if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
			String url = "''initProcurementReturnStorageDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(inventoryPo.getCstibillid());
			params.add(moduleID);
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			String url = "''initProcurementReturnStorageUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(inventoryPo.getCstibillid());
			params.add(moduleID);
			this.clearMessages();			
			if (count > 0){
				this.addActionMessage(getText("修改成功!\\n部分商品库存不足,未能出库!"));
			}else{
				this.addActionMessage(getText("struts.messages.update.sucess"));
			}	
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
	}

	/**
	 * 初始化采购退货查看
	 */
	public String initProcurementReturnStorageDetails() throws Exception {

		String id = Utility.getName(request.getParameter("hid"));
		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);
		inventoryPo = procurementReturnMgr.getProcurementReturn(po);
		po.setCstioutstockid(inventoryPo.getCstioutstockid());
		inventoryEntryList = procurementReturnMgr.getProcurementReturnEntryList(po);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");

		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(deppo);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String goodsID = Utility.getName(request.getParameter("goodsID"));//库存综合查询，流水里面的单据明细，商品重点显示。
		request.setAttribute("goodsID", goodsID);				
		return SUCCESS;
	}

	/**
	 * 初始化采购退货删除
	 */
	public String initProcurementReturnDelete() throws Exception {
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
		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);
		inventoryPo = procurementReturnMgr.getProcurementReturn(po);

		return SUCCESS;
	}

	/**
	 * 删除采购退货
	 */
	public String deleteProcurementReturn() throws Exception {
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
		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("采购退货单:" + po.getCstibillid() + "删除!");
		
		procurementReturnMgr.deleteProcurementReturn(po,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	//退货选择负调拨单（退货单新增页面使用）
	public String selReAllocationBillsTui() throws Exception { 
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
		
		
		String id=Utility.getName(request.getParameter("billID"));
		inventoryPo.setCstisourcebillid(id);
		inventoryPo.getCstibillid();
		inventoryPo.getCstibilldate();
		inventoryPo.getCstisuppliername();
		inventoryPo.getCstisupplierid();
		inventoryPo.getCstioutstockid();
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		inventoryEntryList = procurementReturnMgr.getReallocationList(inventoryPo);
		
		List<InventoryEntryPo> barcodes = procurementReturnMgr.getAllocationBarcode(id);
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		warehouseList = warehouseMgr.getWarehouseList(po);

		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
		request.setAttribute("barcodes", barcodes);
		request.setAttribute("cstisourcebillid", id);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		return SUCCESS;

	}
	
	public String selStockGoodsForBrandInsert() throws Exception { 
		/* ********************** 权限设置 ***************************** */
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
		
		
		String brandid=Utility.getName(request.getParameter("brandid"));
		String outstockid=Utility.getName(request.getParameter("outstockid"));
		
		inventoryPo.setCstigoodsid(brandid);
		inventoryPo.setCstioutstockid(outstockid);
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		inventoryEntryList = procurementReturnMgr.getStockGoodsForBrand(inventoryPo);
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(po);

		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		return SUCCESS;

	}
	
	public String selStockGoodsForBrandUpdate() throws Exception { 
		/* ********************** 权限设置 ***************************** */
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
		
		
		String brandid=Utility.getName(request.getParameter("brandid"));
		String outstockid=Utility.getName(request.getParameter("outstockid"));
		
		inventoryPo.setCstigoodsid(brandid);
		inventoryPo.setCstioutstockid(outstockid);
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		inventoryEntryList = procurementReturnMgr.getStockGoodsForBrand(inventoryPo);
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseList(po);

		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		InventoryPo ipo = new InventoryPo();
		ipo.setCstibillid(inventoryPo.getCstibillid());
		inventoryPo = procurementReturnMgr.getProcurementReturn(ipo);
		
		return SUCCESS;

	}
	
	//退货选择负调拨单（退货单修改页面使用）
	public String selReAllocationBillsUpdateTui() throws Exception { 
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
		
		
		String id=Utility.getName(request.getParameter("billID"));
		inventoryPo.setCstibillid(id);
		inventoryPo.getCstibilldate();
		inventoryPo.getCstisuppliername();
		inventoryPo.getCstisupplierid();
		inventoryPo.getCstioutstockid();
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		inventoryEntryList = procurementReturnMgr.getReallocationList(inventoryPo);
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		warehouseList = warehouseMgr.getWarehouseList(po);

		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
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

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public FittingTemplateTypeMgr getFittingTemplateTypeMgr() {
		return fittingTemplateTypeMgr;
	}

	public void setFittingTemplateTypeMgr(
			FittingTemplateTypeMgr fittingTemplateTypeMgr) {
		this.fittingTemplateTypeMgr = fittingTemplateTypeMgr;
	}
}
