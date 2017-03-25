package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.ProcurementOrdersMgr;
import com.pengsheng.eims.storage.mgr.ProcurementReceiptMgr;
import com.pengsheng.eims.storage.mgr.ProcurementWaitMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
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

public class ProcurementWaitAction extends BaseAction {
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private BillKeyMgr billKeyMgr;
	private DepartmentsMgr departmentsMgr;	
	private WarehouseConfigurationPo warehouseConfigurationPo;

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

	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}

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

	private List<GoodsCategoryPo> goodsCategorys;

	private ProcurementOrdersMgr procurementOrdersMgr;

	private SupplierMgr supplierMgr;

	private InventoryEntryPo inventoryEntryPo;

	private List<WarehousePo> warehouselist;

	private WarehouseMgr warehouseMgr;

	private ProcurementReceiptMgr procurementReceiptMgr;

	private List<InventoryEntryPo> procurementInventoryEntryList;

	private ProcurementOrdersPo procurementOrdersPo;

	private ProcurementWaitMgr procurementWaitMgr;

	private List<ProcurementOrdersPo> procurementWaitList;

	private InventoryPo inventoryPo;

	private GoodsInfoTempPo goodsInfoTempPo;

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}

	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
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

	public void setProcurementOrdersMgr(
			ProcurementOrdersMgr procurementOrdersMgr) {
		this.procurementOrdersMgr = procurementOrdersMgr;
	}

	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}

	public InventoryEntryPo getInventoryEntryPo() {
		return inventoryEntryPo;
	}

	public void setInventoryEntryPo(InventoryEntryPo inventoryEntryPo) {
		this.inventoryEntryPo = inventoryEntryPo;
	}

	public List<WarehousePo> getWarehouselist() {
		return warehouselist;
	}

	public void setWarehouselist(List<WarehousePo> warehouselist) {
		this.warehouselist = warehouselist;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public ProcurementReceiptMgr getProcurementReceiptMgr() {
		return procurementReceiptMgr;
	}

	public void setProcurementReceiptMgr(
			ProcurementReceiptMgr procurementReceiptMgr) {
		this.procurementReceiptMgr = procurementReceiptMgr;
	}

	public List<InventoryEntryPo> getProcurementInventoryEntryList() {
		return procurementInventoryEntryList;
	}

	public void setProcurementInventoryEntryList(
			List<InventoryEntryPo> procurementInventoryEntryList) {
		this.procurementInventoryEntryList = procurementInventoryEntryList;
	}

	public ProcurementOrdersPo getProcurementOrdersPo() {
		return procurementOrdersPo;
	}

	public void setProcurementOrdersPo(ProcurementOrdersPo procurementOrdersPo) {
		this.procurementOrdersPo = procurementOrdersPo;
	}

	public ProcurementWaitMgr getProcurementWaitMgr() {
		return procurementWaitMgr;
	}

	public void setProcurementWaitMgr(ProcurementWaitMgr procurementWaitMgr) {
		this.procurementWaitMgr = procurementWaitMgr;
	}

	public List<ProcurementOrdersPo> getProcurementWaitList() {
		return procurementWaitList;
	}

	public void setProcurementWaitList(
			List<ProcurementOrdersPo> procurementWaitList) {
		this.procurementWaitList = procurementWaitList;
	}

	/**
	 * 初始化待收货订单查询页面
	 * 
	 * @return
	 */
	public String initProcurementWaitSel() {

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

		// 得到商品类型
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		///////////////////系统配置//////////////////
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		request.setAttribute("systemParameterPo", systemParameterPo);
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selProcurementWait";
		}
		///////////////////系统配置//////////////////
		return SUCCESS;
	}

	/**
	 * 待收货订单查询
	 * 
	 * @return
	 */
	public String selProcurementWait() {

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

		// 取得页面查询条件填入的值
		String cstpid = Utility.getName(request.getParameter("billID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String bspsuppliername = Utility.getName(request.getParameter("selbspsuppliername"));
		String cstpsupplierid = Utility.getName(request.getParameter("selcstpsupplierid"));
		String cstpcreateperson = Utility.getName(request.getParameter("cstpcreateperson"));
		String cstpauditperson = Utility.getName(request.getParameter("cstpauditperson"));
		String cstpgoodscategory = Utility.getName(request.getParameter("selbspcategoryid"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		
		// 把取得的查询条件放入订单PO中
		procurementOrdersPo = new ProcurementOrdersPo();
		procurementOrdersPo.setCstpid(cstpid);
		procurementOrdersPo.setCstpstarttime(startTime);
		procurementOrdersPo.setCstpendtime(endTime);
		procurementOrdersPo.setCstpsupplierid(cstpsupplierid);
		procurementOrdersPo.setCstpcreateperson(cstpcreateperson);
		procurementOrdersPo.setCstpauditperson(cstpauditperson);
		procurementOrdersPo.setBspsuppliername(bspsuppliername);
		procurementOrdersPo.setCstpgoodscategory(cstpgoodscategory);
		procurementOrdersPo.setCstpgoodsname(goodsName);
		procurementOrdersPo.setCstpgoodsid(goodsID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			procurementOrdersPo.setCstpcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		///////////////////系统配置//////////////////
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
			///////////////////系统配置//////////////////
		// 取待收货订单的总数
		int count = procurementWaitMgr.getProcurementWaitCount(procurementOrdersPo);
		// 分页
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

			// 取出待收货订单的信息
			procurementWaitList = procurementWaitMgr.getProcurementWaitList(
					procurementOrdersPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			procurementWaitList = null;
		}
		// 得到商品类型
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();

		request.setAttribute("billID", cstpid);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("selcstpsupplierid", cstpsupplierid);
		request.setAttribute("cstpcreateperson", cstpcreateperson);
		request.setAttribute("cstpauditperson", cstpauditperson);
		request.setAttribute("selbspcategoryid", cstpgoodscategory);
		request.setAttribute("selbspsuppliername", bspsuppliername);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodsID", goodsID);

		return SUCCESS;
	}

	/**
	 * 初始化待收货订单修改
	 * 
	 * @return
	 */
	public String initProcurementWaitUpdate() {
		
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
		// 自动生成订货ID
		String billID = "PIN"
				+ GenerateNumber.getInstance().getGenerageNumber();

		String cstpid = Utility.getName(request.getParameter("cstpid"));

		inventoryPo = new InventoryPo();
		inventoryPo.setCstibillid(billID);
		inventoryPo.setCstisourcebillid(cstpid);
		inventoryPo.setCstigoodscategory(request.getParameter("categoryID"));

		inventoryEntryPo = new InventoryEntryPo();
		inventoryEntryPo.setCstiebillid(cstpid);
		inventoryEntryPo.setBillid(billID);

		String cstpsupplierid = Utility.getName(request
				.getParameter("cstpsupplierid"));
		request.setAttribute("cstpsupplierid", cstpsupplierid);

		// 获取制造商ID 、名字
		SupplierPo supplierPo = new SupplierPo();
		supplierPo.setBspid(cstpsupplierid);
		// 查询制造商信息（需要制造商名字）
		supplierPo = supplierMgr.getSupplier(supplierPo);

		request.setAttribute("supplierPo", supplierPo);
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		departmentsPo.setBdptype("3");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsPo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		// 根据单据编号查询出该编号下面所有的商品及商品详细信息
		warehouselist = warehouseMgr.getWarehouseList(departmentsPo);

		// 取出待收货订单的信息
		procurementInventoryEntryList = procurementWaitMgr
				.getProcurementInventoryEntryList(inventoryEntryPo);
		
		warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);

		warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		
		return SUCCESS;
	}

	/**
	 * 待收货订单修改
	 * 
	 * @return
	 */
	public String updateProcurementWait() {
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
		request.setAttribute("systemParameterPo", systemParameterPo);

		inventoryPo.setCsticreateperson(createPerson);

		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID()); // 默认插入退货部门为操作人部门

		if ("".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			inventoryPo.setCstiauditstate("0");
		}
		if ("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			inventoryPo.setCstiauditperson(inventoryPo.getCsticreateperson());
		}
		
		// 根据公司和制造商查询绑定的供应商
		inventoryPo.setCstisubsupplierid(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),Utility.getName(inventoryPo.getCstisupplierid())));
		
		String cstiinstockid = Utility.getName(request.getParameter("inventoryPo.cstiinstockid"));

		inventoryEntryPo = new InventoryEntryPo();

		request.setAttribute("cstiinstockid", cstiinstockid);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("待采购收货单："+inventoryPo.getCstibillid()+"新增");

		int lenth = goodsInfoTempPo.getGoodsid().length;

		procurementInventoryEntryList = new ArrayList<InventoryEntryPo>();
		
		int istake = billKeyMgr.selectProcurementOrderForType(inventoryPo.getCstisourcebillid());
		if(istake == 1){
			this.clearMessages();
			this.addActionMessage("该订单已被使用，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		// 循环得到待收货订单中的每条产品信息

		for (int i = 0; i < lenth; i++) {
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstieinstockid(cstiinstockid);
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
			inventoryEntryPo.setCstieguaranteeperiod("");
			inventoryEntryPo.setCstiebatch("");
			inventoryEntryPo.setCstierksj(goodsInfoTempPo.getBgirksj()[i]);
			procurementInventoryEntryList.add(inventoryEntryPo);
		}
		// 表头表体一起填入数据库
		procurementWaitMgr.insertProcurementWaitAll(inventoryPo,procurementInventoryEntryList,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 初始化待收货隐形订单修改
	 * 
	 * @return
	 */
	public String initProcurementWaityxUpdate() {
		
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
		// 自动生成订货ID
		String billID = "PIN"
				+ GenerateNumber.getInstance().getGenerageNumber();

		String cstpid = Utility.getName(request.getParameter("cstpid"));

		inventoryPo = new InventoryPo();
		inventoryPo.setCstibillid(billID);
		inventoryPo.setCstisourcebillid(cstpid);
		inventoryPo.setCstigoodscategory(request.getParameter("categoryID"));

		inventoryEntryPo = new InventoryEntryPo();
		inventoryEntryPo.setCstiebillid(cstpid);

		String cstpsupplierid = Utility.getName(request
				.getParameter("cstpsupplierid"));
		request.setAttribute("cstpsupplierid", cstpsupplierid);

		// 获取制造商ID 、名字
		SupplierPo supplierPo = new SupplierPo();
		supplierPo.setBspid(cstpsupplierid);
		// 查询制造商信息（需要制造商名字）
		supplierPo = supplierMgr.getSupplier(supplierPo);
		request.setAttribute("supplierPo", supplierPo);
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		departmentsPo.setBdptype("3");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsPo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}

		warehouselist = warehouseMgr.getWarehouseList(departmentsPo);
		
		// 取出待收货订单的信息
		procurementInventoryEntryList = procurementWaitMgr
				.getProcurementInventoryEntryList(inventoryEntryPo);

		return SUCCESS;
	}

	/**
	 * 待收货隐形订单修改
	 * 
	 * @return
	 */
	public String updateProcurementWaityx() {
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
		request.setAttribute("systemParameterPo", systemParameterPo);

		inventoryPo.setCsticreateperson(createPerson);

		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID()); // 默认插入退货部门为操作人部门

		if ("".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			inventoryPo.setCstiauditstate("0");
		}
		if ("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			inventoryPo.setCstiauditperson(inventoryPo.getCsticreateperson());
		}
		
		// 根据公司和制造商查询绑定的供应商
		inventoryPo.setCstisubsupplierid(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),Utility.getName(inventoryPo.getCstisupplierid())));
		
		String cstiinstockid = Utility.getName(request
				.getParameter("inventoryPo.cstiinstockid"));

		inventoryEntryPo = new InventoryEntryPo();

		request.setAttribute("cstiinstockid", cstiinstockid);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("待采购收货单："+inventoryPo.getCstibillid()+"新增");

		int lenth = goodsInfoTempPo.getGoodsid().length;

		procurementInventoryEntryList = new ArrayList<InventoryEntryPo>();

		// 循环得到待收货订单中的每条产品信息

		for (int i = 0; i < lenth; i++) {
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstieinstockid(cstiinstockid);
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
			inventoryEntryPo.setCstieguaranteeperiod(goodsInfoTempPo.getGuaranteeperiod()[i]);
			inventoryEntryPo.setCstiebatch(goodsInfoTempPo.getBatch()[i]);
			inventoryEntryPo.setCstierksj(goodsInfoTempPo.getBgirksj()[i]);
			inventoryEntryPo.setCstieregistrationnum(goodsInfoTempPo.getRegistrationnum()[i]);
			
			procurementInventoryEntryList.add(inventoryEntryPo);
		}
		// 表头表体一起填入数据库
		procurementWaitMgr.insertProcurementWaitAll(inventoryPo,procurementInventoryEntryList,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
}
