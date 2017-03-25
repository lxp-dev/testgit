package com.pengsheng.eims.basic.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.CorrectingErrorsMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.CorrectingErrorsPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
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

public class CorrectingErrorsAction extends BaseAction {

	private CorrectingErrorsMgr correctingErrorsMgr = null;
	private SystemParameterMgr systemParameterMgr = null;
	private SystemParameterPo systemParameterPo = null;
	private PersonPermissionMgr personPermissionMgr = null;
	private String isFirstExec;
	private CorrectingErrorsPo correctingErrorsPo = null;
	private List<CorrectingErrorsPo> correctingErrorsList = null;
	private InventoryPo inventoryPo = null;
	private List<InventoryEntryPo> inventoryEntryList = null;
	private List<GoodsCategoryPo> goodsCategoryList = null;
	private WarehouseMgr warehouseMgr = null;
	private List<WarehousePo> warehouseList = null;
	private BrandMgr brandMgr = null;

	/**
	 * 初始化库存差异查询
	 */
	public String initInventoryDifferenceSel() throws Exception{
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
		
		DepartmentsPo po = new DepartmentsPo();
		warehouseList = warehouseMgr.getWarehouseAllList(po);		
		goodsCategoryList = brandMgr.getGoodsCategorys();
		
		if (Utility.getName(permissionPo.getKeya()).equals("1")){
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "inventoryDifferenceSel";
			}
		}
		
		request.setAttribute("inventoryType","3");
		
		return SUCCESS;
	}
	
	/**
	 * 库存差异查询
	 */
	public String inventoryDifferenceSel() throws Exception{
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
		
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));		
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String exceptionInventory = Utility.getName(request.getParameter("exceptionInventory"));
		String changeBillID = Utility.getName(request.getParameter("changeBillID"));
		String inventoryType = Utility.getName(request.getParameter("inventoryType"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			inventoryType = "3";
		}
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("exceptionInventory",exceptionInventory);
		request.setAttribute("changeBillID",changeBillID);
		request.setAttribute("inventoryType",inventoryType);
		request.setAttribute("warehouseID",warehouseID);
				
		correctingErrorsPo = new CorrectingErrorsPo();
		correctingErrorsPo.setCerrbrandid(brandID);
		correctingErrorsPo.setCerrchangeid(changeBillID);
		correctingErrorsPo.setCerrenddate(endTime);
		correctingErrorsPo.setCerrbgndate(startTime);
		correctingErrorsPo.setCerrexceptioninventory(exceptionInventory);
		correctingErrorsPo.setCerrgoodscategoryid(goodsCategoryID);
		correctingErrorsPo.setCerrgoodsid(goodsID);
		correctingErrorsPo.setCerrgoodsname(goodsName);
		correctingErrorsPo.setCerrinventorytype(inventoryType);
		correctingErrorsPo.setCerrstockid(warehouseID);
		correctingErrorsPo.setCerrsupplierid(supplierID);
		
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

		int count = correctingErrorsMgr.getInventoryDifferenceCount(correctingErrorsPo);
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
			correctingErrorsList = correctingErrorsMgr.getInventoryDifferenceList(correctingErrorsPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			correctingErrorsList = null;
		}
		
		DepartmentsPo po = new DepartmentsPo();
		warehouseList = warehouseMgr.getWarehouseAllList(po);		
		goodsCategoryList = brandMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
	
	/**
	 * 初始化单据差异明细查询
	 */
	public String initBillDifferenceSel() throws Exception{
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
		
		DepartmentsPo po = new DepartmentsPo();
		warehouseList = warehouseMgr.getWarehouseAllList(po);		
		goodsCategoryList = brandMgr.getGoodsCategorys();
		
		if (Utility.getName(permissionPo.getKeyc()).equals("1")){
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "billDifferenceSel";
			}
		}
		
		request.setAttribute("inventoryType","3");
		
		return SUCCESS;
	}
	
	/**
	 * 单据差异明细查询
	 */
	public String billDifferenceSel() throws Exception{
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
	
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));		
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String exceptionInventory = Utility.getName(request.getParameter("exceptionInventory"));
		String changeBillID = Utility.getName(request.getParameter("changeBillID"));
		String inventoryType = Utility.getName(request.getParameter("inventoryType"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			inventoryType = "3";
		}
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("exceptionInventory",exceptionInventory);
		request.setAttribute("changeBillID",changeBillID);
		request.setAttribute("inventoryType",inventoryType);
		request.setAttribute("warehouseID",warehouseID);
				
		correctingErrorsPo = new CorrectingErrorsPo();
		correctingErrorsPo.setCerrbrandid(brandID);
		correctingErrorsPo.setCerrchangeid(changeBillID);
		correctingErrorsPo.setCerrenddate(endTime);
		correctingErrorsPo.setCerrbgndate(startTime);
		correctingErrorsPo.setCerrexceptioninventory(exceptionInventory);
		correctingErrorsPo.setCerrgoodscategoryid(goodsCategoryID);
		correctingErrorsPo.setCerrgoodsid(goodsID);
		correctingErrorsPo.setCerrgoodsname(goodsName);
		correctingErrorsPo.setCerrinventorytype(inventoryType);
		correctingErrorsPo.setCerrstockid(warehouseID);
		correctingErrorsPo.setCerrsupplierid(supplierID);
		
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

		int count = correctingErrorsMgr.getBillDifferenceCount(correctingErrorsPo);
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
			correctingErrorsList = correctingErrorsMgr.getBillDifferenceList(correctingErrorsPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			correctingErrorsList = null;
		}
		
		DepartmentsPo po = new DepartmentsPo();
		warehouseList = warehouseMgr.getWarehouseAllList(po);		
		goodsCategoryList = brandMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
	
	/**
	 * 单据数量差异明细
	 */
	public String initBillDifferenceDetail() throws Exception{
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
		
		correctingErrorsPo = new CorrectingErrorsPo();
		correctingErrorsPo.setCerrchangeid(Utility.getName(request.getParameter("hid")));
		
		inventoryEntryList = correctingErrorsMgr.getInventoryDifferenceBillEntryDetail(correctingErrorsPo);
		
		return SUCCESS;
	}

	/**
	 * 初始化错误商品条码查询
	 */
	public String initErrorsGoodsBarCodeSel() throws Exception{
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
		
		if (Utility.getName(permissionPo.getKeyb()).equals("1")){
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "errorsGoodsBarCodeSel";
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * 错误商品条码查询
	 */
	public String errorsGoodsBarCodeSel() throws Exception{
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
		
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));		
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String exceptionInventory = Utility.getName(request.getParameter("exceptionInventory"));
		String changeBillID = Utility.getName(request.getParameter("changeBillID"));
		String inventoryType = Utility.getName(request.getParameter("inventoryType"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		String goodsBarCode = Utility.getName(request.getParameter("goodsBarCode"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("exceptionInventory",exceptionInventory);
		request.setAttribute("changeBillID",changeBillID);
		request.setAttribute("inventoryType",inventoryType);
		request.setAttribute("warehouseID",warehouseID);
		request.setAttribute("goodsBarCode",goodsBarCode);
				
		correctingErrorsPo = new CorrectingErrorsPo();
		correctingErrorsPo.setCerrbrandid(brandID);
		correctingErrorsPo.setCerrchangeid(changeBillID);
		correctingErrorsPo.setCerrenddate(endTime);
		correctingErrorsPo.setCerrbgndate(startTime);
		correctingErrorsPo.setCerrexceptioninventory(exceptionInventory);
		correctingErrorsPo.setCerrgoodscategoryid(goodsCategoryID);
		correctingErrorsPo.setCerrgoodsid(goodsID);
		correctingErrorsPo.setCerrgoodsname(goodsName);
		correctingErrorsPo.setCerrinventorytype(inventoryType);
		correctingErrorsPo.setCerrstockid(warehouseID);
		correctingErrorsPo.setCerrsupplierid(supplierID);
		correctingErrorsPo.setCerrgoodsbarcode(goodsBarCode);
		
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

		int count = correctingErrorsMgr.getErrorsGoodsBarCodeCount(correctingErrorsPo);
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
			correctingErrorsList = correctingErrorsMgr.getErrorsGoodsBarCodeList(correctingErrorsPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			correctingErrorsList = null;
		}
		
		DepartmentsPo po = new DepartmentsPo();
		warehouseList = warehouseMgr.getWarehouseAllList(po);		
		goodsCategoryList = brandMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
	
	/**
	 * 初始化在途库存查询
	 */
	public String initGoodsTransitStorageSel() throws Exception{
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
		if (Utility.getName(permissionPo.getKeya()).equals("1") || createPerson.equals("admin")){		
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "goodsTransitStorageSel";
			}
		}
		
		DepartmentsPo po = new DepartmentsPo();
		//门店
		if (Utility.getName(personInfoPo.getDepartmenttype()).equals("1")){
			po.setBdpdepartmentid(Utility.getName(personInfoPo.getDepartmentID()));
			warehouseList = warehouseMgr.getWarehouseList(po);		
		}
		//加工
		if (Utility.getName(personInfoPo.getDepartmenttype()).equals("2")){
			warehouseList = warehouseMgr.getWarehouseListForReg(Utility.getName(personInfoPo.getDepartmentID()));		
		}
		//非门店和加工
		if (!Utility.getName(personInfoPo.getDepartmenttype()).equals("1") && !Utility.getName(personInfoPo.getDepartmenttype()).equals("2")){
			warehouseList = this.getWarehouseListByCompany(systemParameterPo,personInfoPo);
		}
		
		goodsCategoryList = brandMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
	
	/**
	 * 在途库存查询
	 */
	public String goodsTransitStorageSel() throws Exception{
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
		
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));		
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String exceptionInventory = Utility.getName(request.getParameter("exceptionInventory"));
		String changeBillID = Utility.getName(request.getParameter("changeBillID"));
		String inventoryType = Utility.getName(request.getParameter("inventoryType"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		String goodsBarCode = Utility.getName(request.getParameter("goodsBarCode"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("exceptionInventory",exceptionInventory);
		request.setAttribute("changeBillID",changeBillID);
		request.setAttribute("inventoryType",inventoryType);
		request.setAttribute("warehouseID",warehouseID);
		request.setAttribute("goodsBarCode",goodsBarCode);
				
		correctingErrorsPo = new CorrectingErrorsPo();
		correctingErrorsPo.setCerrbrandid(brandID);
		correctingErrorsPo.setCerrchangeid(changeBillID);
		correctingErrorsPo.setCerrenddate(endTime);
		correctingErrorsPo.setCerrbgndate(startTime);
		correctingErrorsPo.setCerrexceptioninventory(exceptionInventory);
		correctingErrorsPo.setCerrgoodscategoryid(goodsCategoryID);
		correctingErrorsPo.setCerrgoodsid(goodsID);
		correctingErrorsPo.setCerrgoodsname(goodsName);
		correctingErrorsPo.setCerrinventorytype(inventoryType);
		correctingErrorsPo.setCerrstockid(warehouseID);
		correctingErrorsPo.setCerrsupplierid(supplierID);
		correctingErrorsPo.setCerrgoodsbarcode(goodsBarCode);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			correctingErrorsPo.setCerrcompanyid(personInfoPo.getPersoncompanyid());
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

		int count = correctingErrorsMgr.getGoodsTransitStorageCount(correctingErrorsPo,personInfoPo);
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
			correctingErrorsList = correctingErrorsMgr.getGoodsTransitStorageList(correctingErrorsPo,personInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			correctingErrorsList = null;
		}
		
		DepartmentsPo po = new DepartmentsPo();
		//门店
		if (Utility.getName(personInfoPo.getDepartmenttype()).equals("1")){
			po.setBdpdepartmentid(Utility.getName(personInfoPo.getDepartmentID()));
			warehouseList = warehouseMgr.getWarehouseList(po);		
		}
		//加工
		if (Utility.getName(personInfoPo.getDepartmenttype()).equals("2")){
			warehouseList = warehouseMgr.getWarehouseListForReg(Utility.getName(personInfoPo.getDepartmentID()));		
		}
		//非门店和加工
		if (!Utility.getName(personInfoPo.getDepartmenttype()).equals("1") && !Utility.getName(personInfoPo.getDepartmenttype()).equals("2")){
			warehouseList =this.getWarehouseListByCompany(systemParameterPo,personInfoPo);
		}	
		goodsCategoryList = brandMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
	
	/**
	 * 初始化未完结单据查询列表
	 */
	public String initNotAuditBillSel() throws Exception{
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
		
		if (Utility.getName(permissionPo.getKeya()).equals("1")){
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "notAuditBillSel";
			}
		}
		
		return SUCCESS;
	}	
	
	/**
	 * 未完结单据查询列表
	 */
	public String notAuditBillSel() throws Exception{
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
		
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String changeBillID = Utility.getName(request.getParameter("changeBillID"));		
		String bdpdepartmentname = Utility.getName(request.getParameter("bdpdepartmentname"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));	
		String billtypea = Utility.getName(request.getParameter("billtypea"));	
		String billtypeb = Utility.getName(request.getParameter("billtypeb"));	
		String billtypec = Utility.getName(request.getParameter("billtypec"));	
		String billtyped = Utility.getName(request.getParameter("billtyped"));	
		String billtypee = Utility.getName(request.getParameter("billtypee"));	
		String billtypef = Utility.getName(request.getParameter("billtypef"));	
		String billtypeg = Utility.getName(request.getParameter("billtypeg"));	
		String billtypeh = Utility.getName(request.getParameter("billtypeh"));	
		String billtypei = Utility.getName(request.getParameter("billtypei"));	
		String billtypej = Utility.getName(request.getParameter("billtypej"));	
		String billtypek = Utility.getName(request.getParameter("billtypek"));	
		String billtypel = Utility.getName(request.getParameter("billtypel"));	
		String billtypem = Utility.getName(request.getParameter("billtypem"));		
		String salesbilltypea = Utility.getName(request.getParameter("salesbilltypea"));	
		String salesbilltypeb = Utility.getName(request.getParameter("salesbilltypeb"));	
		String salesbilltypec = Utility.getName(request.getParameter("salesbilltypec"));	
		String salesbilltyped = Utility.getName(request.getParameter("salesbilltyped"));		
		String chk2s = Utility.getName(request.getParameter("chk2s"));
		String chk3s = Utility.getName(request.getParameter("chk3s"));
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));

		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("changeBillID",changeBillID);		
		request.setAttribute("bdpdepartmentname",bdpdepartmentname);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("billtypea",billtypea);
		request.setAttribute("billtypeb",billtypeb);
		request.setAttribute("billtypec",billtypec);
		request.setAttribute("billtyped",billtyped);		
		request.setAttribute("billtypee",billtypee);
		request.setAttribute("billtypef",billtypef);
		request.setAttribute("billtypeg",billtypeg);
		request.setAttribute("billtypeh",billtypeh);
		request.setAttribute("billtypei",billtypei);		
		request.setAttribute("billtypej",billtypej);
		request.setAttribute("billtypek",billtypek);
		request.setAttribute("billtypel",billtypel);		
		request.setAttribute("billtypem",billtypem);		
		request.setAttribute("salesbilltypea",salesbilltypea);		
		request.setAttribute("salesbilltypeb",salesbilltypeb);
		request.setAttribute("salesbilltypec",salesbilltypec);
		request.setAttribute("salesbilltyped",salesbilltyped);
		request.setAttribute("chk2s",chk2s);
		request.setAttribute("chk3s",chk3s);
		request.setAttribute("createPersonID",createPersonID);
				
		correctingErrorsPo = new CorrectingErrorsPo();
		correctingErrorsPo.setCerrchangeid(changeBillID);
		correctingErrorsPo.setCerrenddate(endTime);
		correctingErrorsPo.setCerrbgndate(startTime);
		correctingErrorsPo.setCerrdepartmentid(departmentID);		
		correctingErrorsPo.setCerrbilltypea(billtypea);
		correctingErrorsPo.setCerrbilltypeb(billtypeb);
		correctingErrorsPo.setCerrbilltypec(billtypec);
		correctingErrorsPo.setCerrbilltyped(billtyped);
		correctingErrorsPo.setCerrbilltypee(billtypee);
		correctingErrorsPo.setCerrbilltypef(billtypef);
		correctingErrorsPo.setCerrbilltypeg(billtypeg);
	    correctingErrorsPo.setCerrbilltypeh(billtypeh);
	    correctingErrorsPo.setCerrbilltypei(billtypei);
	    correctingErrorsPo.setCerrbilltypej(billtypej);
	    correctingErrorsPo.setCerrbilltypek(billtypek);
	    correctingErrorsPo.setCerrbilltypel(billtypel);
	    correctingErrorsPo.setCerrbilltypem(billtypem);	    
	    correctingErrorsPo.setCerrsalesbilltypea(salesbilltypea);    
	    correctingErrorsPo.setCerrsalesbilltypeb(salesbilltypeb);
	    correctingErrorsPo.setCerrsalesbilltypec(salesbilltypec);
	    correctingErrorsPo.setCerrsalesbilltyped(salesbilltyped);
	    correctingErrorsPo.setCerrpersonid(createPersonID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			correctingErrorsPo.setCerrcompanyid(personInfoPo.getPersoncompanyid());
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

		int count = correctingErrorsMgr.getNotAuditBillCount(correctingErrorsPo);
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
			correctingErrorsList = correctingErrorsMgr.getNotAuditBillList(correctingErrorsPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			correctingErrorsList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化配镜单处理
	 */
	public String initSalesBillInTransitUpdate() throws Exception{
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
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	
	/**
	 * 配镜单处理
	 */
	public String updateSalesBillInTransit() throws Exception{
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("配镜单：" + Utility.getName(correctingErrorsPo.getCerrchangeid()) + " 已处理!" );
		
		correctingErrorsPo.setCerrpersonid(createPerson);
		correctingErrorsPo.setCerrdepartmentid(personInfoPo.getDepartmentID());
		correctingErrorsMgr.updateSalesBillInTransit(systemParameterPo,correctingErrorsPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化删除未完结单据查询列表
	 */
	public String initNotAuditBillDetele() throws Exception{
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
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	
	/**
	 * 删除未完结单据查询列表
	 */
	public String deleteNotAuditBill() throws Exception{
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("未完结单据编号：" + Utility.getName(correctingErrorsPo.getCerrchangeid()) + " 删除!" );
		
		correctingErrorsMgr.deleteNotAuditBill(correctingErrorsPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化重新转在途库存
	 */
	public String initGoodsTransitStorageDelete() throws Exception{
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
	 * 重新转在途库存
	 */
	public String goodsTransitStorageDelete() throws Exception{
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("重新创建在途库存!");
		
		correctingErrorsPo = new CorrectingErrorsPo();
		correctingErrorsPo.setCerrisdelete("1");
		correctingErrorsMgr.deleteGoodsTransitStorage(correctingErrorsPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("重新创建在途库存完成!"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 在途库存开窗明细
	 */
	public String getGoodsInTransitDetail() throws Exception{
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

		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsBarCode = Utility.getName(request.getParameter("goodsBarCode"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		String flag = Utility.getName(request.getParameter("flag"));
		
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsBarCode",goodsBarCode);
		request.setAttribute("warehouseID",warehouseID);
		request.setAttribute("flag",flag);
		
		correctingErrorsPo = new CorrectingErrorsPo();
		correctingErrorsPo.setCerrgoodsid(goodsID);
		correctingErrorsPo.setCerrstockid(warehouseID);
		correctingErrorsPo.setCerrgoodsbarcode(goodsBarCode);
		
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

		int count = correctingErrorsMgr.getGoodsTransitStorageCount(correctingErrorsPo,personInfoPo);
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
			correctingErrorsList = correctingErrorsMgr.getGoodsTransitStorageList(correctingErrorsPo,personInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			correctingErrorsList = null;
		}
		
		return SUCCESS;
	}
		
	public CorrectingErrorsMgr getCorrectingErrorsMgr() {
		return correctingErrorsMgr;
	}

	public void setCorrectingErrorsMgr(CorrectingErrorsMgr correctingErrorsMgr) {
		this.correctingErrorsMgr = correctingErrorsMgr;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public CorrectingErrorsPo getCorrectingErrorsPo() {
		return correctingErrorsPo;
	}

	public void setCorrectingErrorsPo(CorrectingErrorsPo correctingErrorsPo) {
		this.correctingErrorsPo = correctingErrorsPo;
	}

	public List<CorrectingErrorsPo> getCorrectingErrorsList() {
		return correctingErrorsList;
	}

	public void setCorrectingErrorsList(
			List<CorrectingErrorsPo> correctingErrorsList) {
		this.correctingErrorsList = correctingErrorsList;
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

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	
	public List<GoodsCategoryPo> getGoodsCategoryList() {
		return goodsCategoryList;
	}

	public void setGoodsCategoryList(List<GoodsCategoryPo> goodsCategoryList) {
		this.goodsCategoryList = goodsCategoryList;
	}

	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}
	
}
