package com.pengsheng.eims.storage.action;

import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.mgr.BatchCompareMgr;
import com.pengsheng.eims.storage.mgr.ProcurementOrdersMgr;
import com.pengsheng.eims.storage.mgr.ProcurementReceiptMgr;
import com.pengsheng.eims.storage.persistence.BatchComparePo;
import com.pengsheng.eims.storage.persistence.DeliveryDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersEntryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.storage.persistence.StatusPo;
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

/**
 * 采购收货action
 */
public class ProcurementReceiptAction extends BaseAction {
	
	private StatusPo statusPo;
	
	private AllocationMgr allocationMgr;

	private PersonPermissionMgr personPermissionMgr;
	
	private DepartmentsMgr departmentsMgr;
	
	private WarehouseConfigurationPo warehouseConfigurationPo;
	
	private List<ProcurementOrdersEntryPo> procurementOrdersEntryPos;
	
	private SystemParameterMgr systemParameterMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private String isFirstExec;
	
	private BatchCompareMgr batchCompareMgr;
	
	private List<GoodsInfoPo> goodsInfoPos;
	
	public List<GoodsInfoPo> getGoodsInfoPos() {
		return goodsInfoPos;
	}

	public void setGoodsInfoPos(List<GoodsInfoPo> goodsInfoPos) {
		this.goodsInfoPos = goodsInfoPos;
	}

	public BatchCompareMgr getBatchCompareMgr() {
		return batchCompareMgr;
	}

	public void setBatchCompareMgr(BatchCompareMgr batchCompareMgr) {
		this.batchCompareMgr = batchCompareMgr;
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

	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}

	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	private ProcurementReceiptMgr procurementReceiptMgr;

	private WarehouseMgr warehouseMgr;
	
	private ProcurementOrdersMgr procurementOrdersMgr;
	
	public ProcurementOrdersMgr getProcurementOrdersMgr() {
		return procurementOrdersMgr;
	}

	public void setProcurementOrdersMgr(ProcurementOrdersMgr procurementOrdersMgr) {
		this.procurementOrdersMgr = procurementOrdersMgr;
	}

	private List<GoodsCategoryPo> goodsCategorys;

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	private InventoryPo inventoryPo;

	private GoodsInfoTempPo goodsInfoTempPo;

	private List<InventoryEntryPo> inventoryEntryList;

	private List<WarehousePo> warehouselist;

	private List<InventoryPo> procurementReceiptList;

	private List<GoodsInfoPo> goodsList;

	public ProcurementReceiptMgr getProcurementReceiptMgr() {
		return procurementReceiptMgr;
	}

	public void setProcurementReceiptMgr(
			ProcurementReceiptMgr procurementReceiptMgr) {
		this.procurementReceiptMgr = procurementReceiptMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<GoodsInfoPo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsInfoPo> goodsList) {
		this.goodsList = goodsList;
	}

	/**
	 * 初始化采购收货查询
	 */
	public String initProcurementReceiptSel() throws Exception {

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
		warehouselist = warehouseMgr.getWarehouseList(deppo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selProcurementReceipt";
		}
		return SUCCESS;
	}

	/**
	 * 查询采购收货
	 */
	public String selProcurementReceipt() throws Exception {

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

		String billID = Utility.getName(request.getParameter("billID"));
		String sourceBillID = Utility.getName(request.getParameter("sourceBillID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String instockID = Utility.getName(request.getParameter("instockID"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));
		String auditstartdate = Utility.getName(request.getParameter("auditStartDate"));
		String auditenddate = Utility.getName(request.getParameter("auditEndDate"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));// 制造商
		String goodsName = Utility.getName(request.getParameter("goodsName"));// 制造商
		String categoryid = Utility.getName(request.getParameter("categoryid"));
		String remark = Utility.getName(request.getParameter("remark"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));// 制造商
		String deliveryid = Utility.getName(request.getParameter("deliveryid"));
		
		InventoryPo po = new InventoryPo();
		po.setCstigoodscategory(categoryid);
		po.setCstibillid(billID);
		po.setCstisourcebillid(sourceBillID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstiinstockid(instockID);
		po.setCstiauditstate(auditState);
		po.setCsticreateperson(createPersonID);
		po.setCstiauditperson(auditPersonID);
		po.setCstiauditstartdate(auditstartdate);
		po.setCstiauditenddate(auditenddate);
		po.setCstisupplierid(supplierID);// 制造商
		po.setCstigoodsname(goodsName);
		po.setCstiremark(remark);
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
		
		int count = procurementReceiptMgr.getProcurementReceiptCount(po);
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
			procurementReceiptList = procurementReceiptMgr
					.getProcurementReceiptList(po, page.getStart(), page
							.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			procurementReceiptList = null;
		}
		
		request.setAttribute("categoryid", categoryid);
		request.setAttribute("billID", billID);
		request.setAttribute("sourceBillID", sourceBillID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("instockID", instockID);
		request.setAttribute("auditState", auditState);
		request.setAttribute("createPersonID", createPersonID);
		request.setAttribute("auditPersonID", auditPersonID);
		request.setAttribute("auditStartDate", auditstartdate);
		request.setAttribute("auditEndDate", auditenddate);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("remark", remark);
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("deliveryid", deliveryid);
		
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		
		//制造商
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", Utility.getName(request.getParameter("supplierName")));
		request.setAttribute("systemParameterPo", systemParameterPo);
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouselist = warehouseMgr.getWarehouseList(deppo);
		return SUCCESS;
	}

	/**
	 * 初始化采购收货新增
	 */
	public String initProcurementReceiptInsert() throws Exception {
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
		if (inventoryPo != null
				&& StringUtils.isNotEmpty(inventoryPo.getDeliveryID())) {
			ProcurementOrdersPo procurementorderspo = new ProcurementOrdersPo();
			procurementorderspo.setCstpid(inventoryPo.getCstisourcebillid().split("-")[0]);
			// 取订单明细
			List<GoodsInfoPo> goodsInfo = procurementReceiptMgr.getProcurementOrdersList(procurementorderspo);
			// CustomerContextHolder.setCustomerType(CustomerType.orders);
			// 取发货单明细
			List<DeliveryDetailPo> delivers = procurementReceiptMgr.getDeliverEntryList(inventoryPo.getDeliveryID());
			// CustomerContextHolder.setCustomerType(CustomerType.eims);
			// 页面发货单商品明细
			goodsList = new ArrayList<GoodsInfoPo>();
			for (DeliveryDetailPo deliver : delivers) {
				for (GoodsInfoPo good : goodsInfo) {
					if (deliver.getCstdegoodsid().equals(good.getBgigoodsid())) {
						goodsList.add(good);
						break;
					}
				}
			}
		}
		if (inventoryPo == null) {
			String billID = "PIN"+ GenerateNumber.getInstance().getGenerageNumber();
			inventoryPo = new InventoryPo();
			inventoryPo.setCstibillid(billID);
		}

		request.setAttribute("inventoryPo", inventoryPo);
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouselist = warehouseMgr.getWarehouseList(po);		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		return SUCCESS;
	}
	
	/**
	 * 初始化隐形采购收货新增
	 */
	public String initProcurementReceiptyxInsert() throws Exception {
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
		if (inventoryPo != null
				&& StringUtils.isNotEmpty(inventoryPo.getDeliveryID())) {

			ProcurementOrdersPo procurementorderspo = new ProcurementOrdersPo();
			procurementorderspo.setCstpid(inventoryPo.getCstisourcebillid()
					.split("-")[0]);

			// 取订单明细
			List<GoodsInfoPo> goodsInfo = procurementReceiptMgr.getProcurementOrdersList(procurementorderspo);

			// CustomerContextHolder.setCustomerType(CustomerType.orders);
			// 取发货单明细
			List<DeliveryDetailPo> delivers = procurementReceiptMgr
					.getDeliverEntryList(inventoryPo.getDeliveryID());

			// CustomerContextHolder.setCustomerType(CustomerType.eims);

			// 页面发货单商品明细
			goodsList = new ArrayList<GoodsInfoPo>();

			for (DeliveryDetailPo deliver : delivers) {

				for (GoodsInfoPo good : goodsInfo) {
					if (deliver.getCstdegoodsid().equals(good.getBgigoodsid())) {
						goodsList.add(good);
						break;
					}
				}
			}
		}
		if (inventoryPo == null) {
			String billID = "PIN"
					+ GenerateNumber.getInstance().getGenerageNumber();
			inventoryPo = new InventoryPo();
			inventoryPo.setCstibillid(billID);
		}

		request.setAttribute("inventoryPo", inventoryPo);
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}

		warehouselist = warehouseMgr.getWarehouseList(po);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		return SUCCESS;
	}

	/**
	 * 新增采购收货
	 */
	public String insertProcurementReceipt() throws Exception {
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
		
		int isreceipt = procurementReceiptMgr.selectProcurementIsReceipt(inventoryPo.getCstibillid().trim());
		String cstiauditstate = Utility.getName(inventoryPo.getCstiauditstate());
		
		if(isreceipt > 0){
			this.clearMessages();
			this.addActionMessage("该单据已收货！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}else{
			inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID()); // 默认插入退货部门为操作人部门
			if ("".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
				inventoryPo.setCstiauditstate("0");
			}
			if ("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
				inventoryPo.setCstiauditperson(inventoryPo.getCsticreateperson());
			}
			
			// 根据公司和制造商查询绑定的供应商
			inventoryPo.setCstisubsupplierid(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),Utility.getName(inventoryPo.getCstisupplierid())));
			
			//添加日志
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("1");    // 表示状态
			logPo.setsLogContent("采购收货："+inventoryPo.getCstibillid()+" 新增");
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			
			int lenth = goodsInfoTempPo.getGoodsid().length;
	
			inventoryEntryList = new ArrayList<InventoryEntryPo>();
			for (int i = 0; i < lenth; i++) {
				InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
				inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
				inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
				inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getPcbarcode()[i]);
				inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
				inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
				inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
				inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getPcbarcode()[i]);
				inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
				inventoryEntryPo.setCstieguaranteeperiod("");
				inventoryEntryPo.setCstiebatch("");
				inventoryEntryPo.setCstierksj(goodsInfoTempPo.getBgirksj()[i]);
				
				inventoryEntryList.add(inventoryEntryPo);
			}
			
			int countnumber=procurementReceiptMgr.selectProcurementReceipt(inventoryPo);
			if(countnumber==0)
			{
				procurementReceiptMgr.insertProcurementReceipt(inventoryPo,inventoryEntryList,logPo);
			}
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			if (cstiauditstate.equals("0")){
				getProcurementReceiptData(inventoryPo.getCstibillid(),personInfoPo);
				return INPUT;
			}
			return SUCCESS;
		}
	}
	
	/**
	 * 新增隐形采购收货
	 */
	public String insertProcurementReceiptyx() throws Exception {
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
		
		int isreceipt = procurementReceiptMgr.selectProcurementIsReceipt(inventoryPo.getCstibillid().trim());
		String cstiauditstate = Utility.getName(inventoryPo.getCstiauditstate());
		
		if(isreceipt > 0){
			this.clearMessages();
			this.addActionMessage("该单据已收获！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}else{
			inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID()); // 默认插入退货部门为操作人部门
			if ("".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
				inventoryPo.setCstiauditstate("0");
			}
			if ("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
				inventoryPo.setCstiauditperson(inventoryPo.getCsticreateperson());
			}
			
			// 根据公司和制造商查询绑定的供应商
			inventoryPo.setCstisubsupplierid(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),Utility.getName(inventoryPo.getCstisupplierid())));
						
			//添加日志
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("1");    // 表示状态
			logPo.setsLogContent("采购收货："+inventoryPo.getCstibillid()+" 新增");
			
			int lenth = goodsInfoTempPo.getGoodsid().length;
	
			inventoryEntryList = new ArrayList<InventoryEntryPo>();
			for (int i = 0; i < lenth; i++) {
				InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
				inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
				inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
				inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getPcbarcode()[i]);
				inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
				inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
				inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
				inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getPcbarcode()[i]);
				inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
				inventoryEntryPo.setCstieguaranteeperiod(goodsInfoTempPo.getGuaranteeperiod()[i]);
				inventoryEntryPo.setCstiebatch(goodsInfoTempPo.getBatch()[i]);
				inventoryEntryPo.setCstierksj(goodsInfoTempPo.getBgirksj()[i]);
				
				if (goodsInfoTempPo.getRegistrationnum() != null){
					inventoryEntryPo.setCstieregistrationnum(Utility.getName(goodsInfoTempPo.getRegistrationnum()[i]));
				}else{
					inventoryEntryPo.setCstieregistrationnum("");
				}
				
				inventoryEntryList.add(inventoryEntryPo);
			}
			
			int countnumber=procurementReceiptMgr.selectProcurementReceipt(inventoryPo);
			
			if(countnumber==0)
			{
				procurementReceiptMgr.insertProcurementReceipt(inventoryPo,inventoryEntryList,logPo);
			}
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			if (cstiauditstate.equals("0")){
				getProcurementReceiptData(inventoryPo.getCstibillid(),personInfoPo);
				return INPUT;
			}
			return SUCCESS;
		}
	}

	/**
	 * 取得Ajax数据
	 */
	public void getAjaxSimpleBatch() throws Exception {
		String barcode = Utility.getName(request.getParameter("barcode"));
		String batch = Utility.getName(request.getParameter("batch"));
		BatchComparePo po1= new BatchComparePo();
		po1.setCshbcbarcode(barcode);
		po1.setCshbcbatch(batch);
		PrintWriter out;
		response.setContentType("charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		BatchComparePo po = batchCompareMgr.selectBatchComparePo(po1);
		String[] left = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		if(po.getCshbcbarcode() != null){
			
		}else{
			BatchComparePo tpo= new BatchComparePo();
			tpo.setCshbcbarcode(barcode);
			BatchComparePo maxpo = batchCompareMgr.selectBatchComparePo(tpo);
			if(maxpo.getCshbcbarcode() != null){
				for(int i=0; i<left.length;i++){
					if(Integer.parseInt(maxpo.getCshbcsimplebatch().substring(1, 2)) == 9){
						if(left[i].equals(maxpo.getCshbcsimplebatch().substring(0, 1))){
							po.setCshbcsimplebatch(left[i+1]+"0");
							break;
						}
					}else{
						po.setCshbcsimplebatch(maxpo.getCshbcsimplebatch().substring(0, 1)+(Integer.parseInt(maxpo.getCshbcsimplebatch().substring(1, 2))+1));
						break;
					}
				}
			}else{
				po.setCshbcsimplebatch("A0");
			}
		}
		out.println(po.getCshbcsimplebatch());
		out.close();
	}

	/**
	 * 初始化采购收货修改
	 */
	public String initProcurementReceiptUpdate() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		getProcurementReceiptData(id,personInfoPo);
		
		
		return SUCCESS;
	}
    
	private void getProcurementReceiptData(String id,PersonInfoPo personInfoPo){
		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);
		inventoryPo = procurementReceiptMgr.getProcurementReceipt(po);
		inventoryEntryList = procurementReceiptMgr.getProcurementReceiptEntryList(po);		

		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouselist = warehouseMgr.getWarehouseList(deppo);
	}
	
	/**
	 * 修改采购收货
	 */
	public String updateProcurementReceipt() throws Exception {
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
		
		int isreceipt = procurementReceiptMgr.selectProcurementIsReceipt(inventoryPo.getCstibillid().trim());
		String cstiauditstate = Utility.getName(inventoryPo.getCstiauditstate());
		
		if(isreceipt > 0){
			this.clearMessages();
			this.addActionMessage("该采购收货单已收货！");
			
			String url = "''procurementReceiptDetails.action?hid={0}''";
			List<String> params = new ArrayList<String>();
			params.add(inventoryPo.getCstibillid().trim());

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
			
		}else{
			inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());
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
			logPo.setsLogContent("采购收货："+inventoryPo.getCstibillid()+" 修改");
	
			int lenth = goodsInfoTempPo.getGoodsid().length;
	
			inventoryEntryList = new ArrayList<InventoryEntryPo>();
			for (int i = 0; i < lenth; i++) {
				InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
				inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
				inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
				inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getPcbarcode()[i]);
				inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
				inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
				inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
				inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
				inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getPcbarcode()[i]);
				inventoryEntryPo.setCstieguaranteeperiod("");
				inventoryEntryPo.setCstiebatch("");
				inventoryEntryPo.setCstierksj(goodsInfoTempPo.getBgirksj()[i]);
				
				if (goodsInfoTempPo.getRegistrationnum() != null){
					inventoryEntryPo.setCstieregistrationnum(Utility.getName(goodsInfoTempPo.getRegistrationnum()[i]));
				}else{
					inventoryEntryPo.setCstieregistrationnum("");
				}
				
				inventoryEntryList.add(inventoryEntryPo);
			}
			int countnumber=procurementReceiptMgr.selectProcurementReceipt(inventoryPo);
			if(countnumber==0)
			{
				procurementReceiptMgr.updateProcurementReceipt(inventoryPo,
						inventoryEntryList,logPo);
			}
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			if (cstiauditstate.equals("0")){
				getProcurementReceiptData(inventoryPo.getCstibillid(),personInfoPo);
				return INPUT;
			}
			return SUCCESS;
		}
	}
	
	/**
	 * 初始化隐形采购收货修改
	 */
	public String initProcurementReceiptUpdateyx() throws Exception {
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
		getProcurementReceiptData(id,personInfoPo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		return SUCCESS;
	}

	
	/**
	 * 修改隐形采购收货
	 */
	public String updateProcurementReceiptyx() throws Exception {
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
		int isreceipt = procurementReceiptMgr.selectProcurementIsReceipt(inventoryPo.getCstibillid().trim());
		String cstiauditstate = Utility.getName(inventoryPo.getCstiauditstate());
		
		if(isreceipt > 0){
			this.clearMessages();
			this.addActionMessage("该采购收货单已收获！");
			
			String url = "''procurementReceiptDetails.action?hid={0}''";
			List<String> params = new ArrayList<String>();
			params.add(inventoryPo.getCstibillid().trim());

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
			
		}else{
			inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());
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
			logPo.setsLogContent("采购收货："+inventoryPo.getCstibillid()+" 修改");
	
			int lenth = goodsInfoTempPo.getGoodsid().length;
	
			inventoryEntryList = new ArrayList<InventoryEntryPo>();
			for (int i = 0; i < lenth; i++) {
				InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
				inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
				inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
				inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getPcbarcode()[i]);
				inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
				inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
				inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
				inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
				inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getPcbarcode()[i]);
				inventoryEntryPo.setCstieguaranteeperiod(goodsInfoTempPo.getGuaranteeperiod()[i]);
				inventoryEntryPo.setCstiebatch(goodsInfoTempPo.getBatch()[i]);
				inventoryEntryPo.setCstierksj(goodsInfoTempPo.getBgirksj()[i]);
				
				if (goodsInfoTempPo.getRegistrationnum() != null){
					inventoryEntryPo.setCstieregistrationnum(Utility.getName(goodsInfoTempPo.getRegistrationnum()[i]));
				}else{
					inventoryEntryPo.setCstieregistrationnum("");
				}
				
				inventoryEntryList.add(inventoryEntryPo);
			}
			int countnumber=procurementReceiptMgr.selectProcurementReceipt(inventoryPo);
			if(countnumber==0)
			{
				procurementReceiptMgr.updateProcurementReceipt(inventoryPo,inventoryEntryList,logPo);
			}
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			if (cstiauditstate.equals("0")){
				getProcurementReceiptData(inventoryPo.getCstibillid(),personInfoPo);
				return INPUT;
			}
			return SUCCESS;
		}
	}

	/**
	 * 初始化采购收货删除
	 */
	public String initProcurementReceiptDelete() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);
		inventoryPo = procurementReceiptMgr.getProcurementReceipt(po);

		return SUCCESS;
	}

	/**
	 * 删除采购收货
	 */
	public String deleteProcurementReceipt() throws Exception {
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
		logPo.setsLogContent("采购收货："+id+" 删除");
		
		procurementReceiptMgr.deleteProcurementReceipt(po,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 采购收货详细
	 */
	public String procurementReceiptDetails() throws Exception {
		String whichretail = Utility.getName(request.getParameter("inventoryPo.cstiwhichretail"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		if(!"".equals(Utility.getName(request.getParameter("checkedtype")))){
			systemParameterPo.setFspshowdwandtable(request.getParameter("checkedtype"));
		}
		request.setAttribute("systemParameterPo", systemParameterPo);
		String id = Utility.getName(request.getParameter("hid"));

		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);
		
		inventoryPo = procurementReceiptMgr.getProcurementReceipt(po);
		inventoryPo.setCstiwhichretail(whichretail);
		
		po.setCstiwhichretail(whichretail);
		
		inventoryEntryList = procurementReceiptMgr.getProcurementReceiptEntryList(po);
		goodsList = procurementReceiptMgr.getProBrand(po.getCstibillid());
		StatusPo spo = new StatusPo();
		
		spo.setCshastatusreceiptid(Utility.getName(request.getParameter("hid")));
		
		statusPo = allocationMgr.getStatusPo(spo);
		
		String goodsID = Utility.getName(request.getParameter("goodsID"));//库存综合查询，流水里面的单据明细，商品重点显示。
		request.setAttribute("goodsID", goodsID);	
		if(goodsList.size()!=0){
			if(!"".equals(Utility.getName(request.getParameter("checkedBrandid")))){
				request.setAttribute("bid", request.getParameter("checkedBrandid"));	
			}else{
				request.setAttribute("bid", goodsList.get(0).getBgibrandid());	
			}
		}
		int procurementReceiptIsCustomizeCount = procurementReceiptMgr.getProcurementReceiptIsCustomizeCount(po);
		if(inventoryEntryList.size()==procurementReceiptIsCustomizeCount){
			request.setAttribute("iscustomizeSandH","1");
		}else{
			request.setAttribute("iscustomizeSandH","0");
		}
		return SUCCESS;
	}
	
	/**
	 * 加载按采购订单添加商品
	 */
	/**
	 * @return
	 * @throws Exception
	 */
	public String initInsertProcurementReceipt() throws Exception {
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
		
		ProcurementOrdersPo procurementOrdersPo = new ProcurementOrdersPo();
		
		procurementOrdersPo = new ProcurementOrdersPo();
		procurementOrdersPo.setCstpid(Utility.getName(request
				.getParameter("hid")));

		ProcurementOrdersEntryPo procurementOrdersEntryPo = new ProcurementOrdersEntryPo();

		procurementOrdersPo = procurementOrdersMgr
				.getProcurementOrders(procurementOrdersPo);

		procurementOrdersEntryPo.setCstpepurchaseorderid(procurementOrdersPo
				.getCstpid());
		procurementOrdersEntryPo.setCstpebillid(Utility.getName(request
				.getParameter("cstibillid")));
		procurementOrdersEntryPos = procurementOrdersMgr
				.getProcurementOrdersEntryList(procurementOrdersEntryPo);
		
		request.setAttribute("goodstype", procurementOrdersEntryPos.get(0).getCstpegoodsid().substring(0, 1));
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		warehouselist = warehouseMgr.getWarehouseList(po);
		
		String type = Utility.getName(request.getParameter("type"));
		
		
		
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		if("u".equals(type)){
			String id = Utility.getName(request.getParameter("cstibillid"));
			InventoryPo po1 = new InventoryPo();
			po1.setCstibillid(id);
			inventoryPo = procurementReceiptMgr.getProcurementReceipt(po1);
			for(int i=0;i<procurementOrdersEntryPos.size();i++){
				InventoryEntryPo iepo = new InventoryEntryPo();
				iepo.setBgcretailPrice(Utility.getName(procurementOrdersEntryPos.get(i).getBgiretailprice()));
				iepo.setCstieaxis(Utility.getName(procurementOrdersEntryPos.get(i).getBgiaxis()));
				iepo.setCstiebarcode(Utility.getName(procurementOrdersEntryPos.get(i).getBgiGoodsBarCode()+"00000000"));
				//iepo.setCstiebilltypeid();
				iepo.setCstiecheckgoodsquantity(Utility.getName(procurementOrdersEntryPos.get(i).getCstpeordernumber()));
				iepo.setCstiecolor(Utility.getName(procurementOrdersEntryPos.get(i).getBgicolor()));
				iepo.setCstiecostprice(Utility.getName(procurementOrdersEntryPos.get(i).getBgicostprice()));
				//iepo.setCstiecostpriceamount(procurementOrdersEntryPos.get(i).get);
				iepo.setCstiecurvature1(Utility.getName(procurementOrdersEntryPos.get(i).getBgicurvature1()));
				iepo.setCstiecyl(Utility.getName(procurementOrdersEntryPos.get(i).getBgicyl()));
				iepo.setCstiedia(Utility.getName(procurementOrdersEntryPos.get(i).getBgidia()));
				iepo.setCstiegoodsid(Utility.getName(procurementOrdersEntryPos.get(i).getCstpegoodsid()));
				iepo.setCstiegoodsname(Utility.getName(procurementOrdersEntryPos.get(i).getBgigoodsname()));
				iepo.setCstiegoodsquantity(Utility.getName(procurementOrdersEntryPos.get(i).getCstpeordernumber()));
				//iepo.setCstieinvoicestate();
				iepo.setCstienottaxrate(Utility.getName(procurementOrdersEntryPos.get(i).getBginottaxrate()));
				iepo.setCstiepcbarcode(Utility.getName(procurementOrdersEntryPos.get(i).getBgiGoodsBarCode()));
				inventoryEntryList.add(iepo);
			}

			return "update";
		}else{
			return SUCCESS;
		}
		
		
	}
	
	
	/**
	 * 加载按采购订单添加商品
	 */
	/**
	 * @return
	 * @throws Exception
	 */
	public String initInsertProcurementReceiptyx() throws Exception {
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
		
		ProcurementOrdersPo procurementOrdersPo = new ProcurementOrdersPo();
		
		procurementOrdersPo = new ProcurementOrdersPo();
		procurementOrdersPo.setCstpid(Utility.getName(request
				.getParameter("hid")));

		ProcurementOrdersEntryPo procurementOrdersEntryPo = new ProcurementOrdersEntryPo();

		procurementOrdersPo = procurementOrdersMgr
				.getProcurementOrders(procurementOrdersPo);

		procurementOrdersEntryPo.setCstpepurchaseorderid(procurementOrdersPo
				.getCstpid());
		procurementOrdersEntryPo.setCstpebillid("");
		procurementOrdersEntryPos = procurementOrdersMgr
				.getProcurementOrdersEntryList(procurementOrdersEntryPo);
		
		request.setAttribute("goodstype", procurementOrdersEntryPos.get(0).getCstpegoodsid().substring(0, 1));
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		warehouselist = warehouseMgr.getWarehouseList(po);
		
		String type = Utility.getName(request.getParameter("type"));
		
		
		
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		if("u".equals(type)){
			String id = Utility.getName(request.getParameter("cstibillid"));
			InventoryPo po1 = new InventoryPo();
			po1.setCstibillid(id);
			inventoryPo = procurementReceiptMgr.getProcurementReceipt(po1);
			for(int i=0;i<procurementOrdersEntryPos.size();i++){
				InventoryEntryPo iepo = new InventoryEntryPo();
				iepo.setBgcretailPrice(Utility.getName(procurementOrdersEntryPos.get(i).getBgiretailprice()));
				iepo.setCstieaxis(Utility.getName(procurementOrdersEntryPos.get(i).getBgiaxis()));
				iepo.setCstiebarcode(Utility.getName(procurementOrdersEntryPos.get(i).getBgiGoodsBarCode()+"00000000"));
				//iepo.setCstiebilltypeid();
				iepo.setCstiecheckgoodsquantity(Utility.getName(procurementOrdersEntryPos.get(i).getCstpeordernumber()));
				iepo.setCstiecolor(Utility.getName(procurementOrdersEntryPos.get(i).getBgicolor()));
				iepo.setCstiecostprice(Utility.getName(procurementOrdersEntryPos.get(i).getBgicostprice()));
				//iepo.setCstiecostpriceamount(procurementOrdersEntryPos.get(i).get);
				iepo.setCstiecurvature1(Utility.getName(procurementOrdersEntryPos.get(i).getBgicurvature1()));
				iepo.setCstiecyl(Utility.getName(procurementOrdersEntryPos.get(i).getBgicyl()));
				iepo.setCstiedia(Utility.getName(procurementOrdersEntryPos.get(i).getBgidia()));
				iepo.setCstiegoodsid(Utility.getName(procurementOrdersEntryPos.get(i).getCstpegoodsid()));
				iepo.setCstiegoodsname(Utility.getName(procurementOrdersEntryPos.get(i).getBgigoodsname()));
				iepo.setCstiegoodsquantity(Utility.getName(procurementOrdersEntryPos.get(i).getCstpeordernumber()));
				//iepo.setCstieinvoicestate();
				iepo.setCstienottaxrate(Utility.getName(procurementOrdersEntryPos.get(i).getBginottaxrate()));
				iepo.setCstiepcbarcode(Utility.getName(procurementOrdersEntryPos.get(i).getBgiGoodsBarCode()));
				inventoryEntryList.add(iepo);
			}

			return "update";
		}else{
			return SUCCESS;
		}
		
		
	}
	/**
	 * 加载已核销采购订单添加商品
	 */
	/**
	 * @return
	 * @throws Exception
	 */
	public String initInsertProcurementReceipts() throws Exception {
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
		
		ProcurementOrdersPo procurementOrdersPo = new ProcurementOrdersPo();
		
		procurementOrdersPo = new ProcurementOrdersPo();
		procurementOrdersPo.setCstpid(Utility.getName(request
				.getParameter("hid")));

		

		ProcurementOrdersEntryPo procurementOrdersEntryPo = new ProcurementOrdersEntryPo();

		procurementOrdersPo = procurementOrdersMgr
				.getProcurementOrders(procurementOrdersPo);
		
		procurementOrdersPo.setCstpbillid(Utility.getName(request
				.getParameter("cstibillid")));

		procurementOrdersEntryPo.setCstpepurchaseorderid(procurementOrdersPo.getCstpid());
		
		procurementOrdersEntryPo.setCstpebillid(procurementOrdersPo.getCstpbillid());

		procurementOrdersEntryPos = procurementOrdersMgr.getProcurementOrdersEntryList(procurementOrdersEntryPo);
		procurementOrdersEntryPos.get(0).setCstpepurchaseorderid("");
		request.setAttribute("goodstype", procurementOrdersEntryPos.get(0).getCstpegoodsid().substring(0, 1));
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		warehouselist = warehouseMgr.getWarehouseList(po);
		
		String type = Utility.getName(request.getParameter("type"));
		
		
		
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		if("u".equals(type)){
			String id = Utility.getName(request.getParameter("cstibillid"));
			InventoryPo po1 = new InventoryPo();
			po1.setCstibillid(id);
			inventoryPo = procurementReceiptMgr.getProcurementReceipt(po1);
			for(int i=0;i<procurementOrdersEntryPos.size();i++){
				InventoryEntryPo iepo = new InventoryEntryPo();
				iepo.setBgcretailPrice(Utility.getName(procurementOrdersEntryPos.get(i).getBgiretailprice()));
				iepo.setCstieaxis(Utility.getName(procurementOrdersEntryPos.get(i).getBgiaxis()));
				iepo.setCstiebarcode(Utility.getName(procurementOrdersEntryPos.get(i).getBgiGoodsBarCode()+"00000000"));
				//iepo.setCstiebilltypeid();
				iepo.setCstiecheckgoodsquantity(Utility.getName(procurementOrdersEntryPos.get(i).getCstpeordernumber()));
				iepo.setCstiecolor(Utility.getName(procurementOrdersEntryPos.get(i).getBgicolor()));
				iepo.setCstiecostprice(Utility.getName(procurementOrdersEntryPos.get(i).getBgicostprice()));
				//iepo.setCstiecostpriceamount(procurementOrdersEntryPos.get(i).get);
				iepo.setCstiecurvature1(Utility.getName(procurementOrdersEntryPos.get(i).getBgicurvature1()));
				iepo.setCstiecyl(Utility.getName(procurementOrdersEntryPos.get(i).getBgicyl()));
				iepo.setCstiedia(Utility.getName(procurementOrdersEntryPos.get(i).getBgidia()));
				iepo.setCstiegoodsid(Utility.getName(procurementOrdersEntryPos.get(i).getCstpegoodsid()));
				iepo.setCstiegoodsname(Utility.getName(procurementOrdersEntryPos.get(i).getBgigoodsname()));
				iepo.setCstiegoodsquantity(Utility.getName(procurementOrdersEntryPos.get(i).getCstpeordernumber()));
				//iepo.setCstieinvoicestate();
				iepo.setCstienottaxrate(Utility.getName(procurementOrdersEntryPos.get(i).getBginottaxrate()));
				iepo.setCstiepcbarcode(Utility.getName(procurementOrdersEntryPos.get(i).getBgiGoodsBarCode()));
				inventoryEntryList.add(iepo);
			}

			return "update";
		}else{
			return SUCCESS;
		}
		
		
	}
	
	
	/**
	 * 加载已核销采购订单添加商品
	 */
	/**
	 * @return
	 * @throws Exception
	 */
	public String initInsertProcurementReceiptsyx() throws Exception {
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
		
		ProcurementOrdersPo procurementOrdersPo = new ProcurementOrdersPo();
		
		procurementOrdersPo = new ProcurementOrdersPo();
		procurementOrdersPo.setCstpid(Utility.getName(request
				.getParameter("hid")));

		ProcurementOrdersEntryPo procurementOrdersEntryPo = new ProcurementOrdersEntryPo();

		procurementOrdersPo = procurementOrdersMgr
				.getProcurementOrders(procurementOrdersPo);

		procurementOrdersEntryPo.setCstpepurchaseorderid(procurementOrdersPo.getCstpid());
		procurementOrdersEntryPo.setCstpebillid("");
		procurementOrdersEntryPos = procurementOrdersMgr.getProcurementOrdersEntryList(procurementOrdersEntryPo);
		procurementOrdersEntryPos.get(0).setCstpepurchaseorderid("");
		request.setAttribute("goodstype", procurementOrdersEntryPos.get(0).getCstpegoodsid().substring(0, 1));
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		warehouselist = warehouseMgr.getWarehouseList(po);
		
		String type = Utility.getName(request.getParameter("type"));
		
		
		
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		if("u".equals(type)){
			String id = Utility.getName(request.getParameter("cstibillid"));
			InventoryPo po1 = new InventoryPo();
			po1.setCstibillid(id);
			inventoryPo = procurementReceiptMgr.getProcurementReceipt(po1);
			for(int i=0;i<procurementOrdersEntryPos.size();i++){
				InventoryEntryPo iepo = new InventoryEntryPo();
				iepo.setBgcretailPrice(Utility.getName(procurementOrdersEntryPos.get(i).getBgiretailprice()));
				iepo.setCstieaxis(Utility.getName(procurementOrdersEntryPos.get(i).getBgiaxis()));
				iepo.setCstiebarcode(Utility.getName(procurementOrdersEntryPos.get(i).getBgiGoodsBarCode()+"00000000"));
				//iepo.setCstiebilltypeid();
				iepo.setCstiecheckgoodsquantity(Utility.getName(procurementOrdersEntryPos.get(i).getCstpeordernumber()));
				iepo.setCstiecolor(Utility.getName(procurementOrdersEntryPos.get(i).getBgicolor()));
				iepo.setCstiecostprice(Utility.getName(procurementOrdersEntryPos.get(i).getBgicostprice()));
				//iepo.setCstiecostpriceamount(procurementOrdersEntryPos.get(i).get);
				iepo.setCstiecurvature1(Utility.getName(procurementOrdersEntryPos.get(i).getBgicurvature1()));
				iepo.setCstiecyl(Utility.getName(procurementOrdersEntryPos.get(i).getBgicyl()));
				iepo.setCstiedia(Utility.getName(procurementOrdersEntryPos.get(i).getBgidia()));
				iepo.setCstiegoodsid(Utility.getName(procurementOrdersEntryPos.get(i).getCstpegoodsid()));
				iepo.setCstiegoodsname(Utility.getName(procurementOrdersEntryPos.get(i).getBgigoodsname()));
				iepo.setCstiegoodsquantity(Utility.getName(procurementOrdersEntryPos.get(i).getCstpeordernumber()));
				//iepo.setCstieinvoicestate();
				iepo.setCstienottaxrate(Utility.getName(procurementOrdersEntryPos.get(i).getBginottaxrate()));
				iepo.setCstiepcbarcode(Utility.getName(procurementOrdersEntryPos.get(i).getBgiGoodsBarCode()));
				inventoryEntryList.add(iepo);
			}

			return "update";
		}else{
			return SUCCESS;
		}
	}
	
	public String addProcurementReceiptDimension() throws Exception {
		
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
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		warehouselist = warehouseMgr.getWarehouseList(po);
		
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		
		String[] tdgoodsids = Utility.getName(request.getParameter("tdgoodsids")).split(",");
		String[] tdvs = Utility.getName(request.getParameter("tdvs")).split(",");
		String ioru = Utility.getName(request.getParameter("ioru"));
		if(goodsInfoTempPo != null){
			for (int i = 0; i < goodsInfoTempPo.getGoodsid().length; i++) {
				tdgoodsids =  insert(tdgoodsids, goodsInfoTempPo.getGoodsid()[i]) ;
				tdvs = insert(tdvs,goodsInfoTempPo.getGoodsquantity()[i]);
			}
		}
		
		List<String> goodsidslist = new ArrayList<String>();
		List<String> vslist = new ArrayList<String>();
		for(int i=0; i< tdgoodsids.length; i++){
			if (!goodsidslist.contains(tdgoodsids[i])){
				goodsidslist.add(tdgoodsids[i].toString());
				vslist.add(tdvs[i].toString());
			}
		}
		
		List<GoodsInfoPo> goodsInfoPos = procurementOrdersMgr.selectDimensionPos(goodsidslist, vslist,inventoryPo.getCstibillid());
		
		request.setAttribute("goodsInfoPos", goodsInfoPos);
		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("tdgoodsids", request.getParameter("tdgoodsids"));
		request.setAttribute("tdvs", request.getParameter("tdvs"));
		if(ioru.equals("u")){
			InventoryPo ipo = new InventoryPo();
			ipo.setCstibillid(inventoryPo.getCstibillid());
			inventoryPo = procurementReceiptMgr.getProcurementReceipt(ipo);
		}
		
		return ioru;
	}
	
	public String addProcurementReceiptDimensionyx() throws Exception {
		
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
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		warehouselist = warehouseMgr.getWarehouseList(po);
		
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		
		String[] tdgoodsids = Utility.getName(request.getParameter("tdgoodsids")).split(",");
		String[] tdvs = Utility.getName(request.getParameter("tdvs")).split(",");
		String ioru = Utility.getName(request.getParameter("ioru"));
		if(goodsInfoTempPo != null){
			for (int i = 0; i < goodsInfoTempPo.getGoodsid().length; i++) {
				tdgoodsids =  insert(tdgoodsids, goodsInfoTempPo.getGoodsid()[i]) ;
				tdvs = insert(tdvs,goodsInfoTempPo.getGoodsquantity()[i]);
			}
		}
		
		List<String> goodsidslist = new ArrayList<String>();
		List<String> vslist = new ArrayList<String>();
		for(int i=0; i< tdgoodsids.length; i++){
			if (!goodsidslist.contains(tdgoodsids[i])){
				goodsidslist.add(tdgoodsids[i].toString());
				vslist.add(tdvs[i].toString());
			}
		}
		
		goodsInfoPos = procurementOrdersMgr.selectDimensionPos(goodsidslist, vslist);

		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);
		
		if(ioru.equals("u")){
			InventoryPo ipo = new InventoryPo();
			ipo.setCstibillid(inventoryPo.getCstibillid());
			inventoryPo = procurementReceiptMgr.getProcurementReceipt(ipo);
		}
		
		return ioru;
	}

	private static String[] insert(String[] arr, String str){
		int size = arr.length;
		String[] tmp = new String[size + 1];
		System.arraycopy(arr, 0, tmp, 0, size);
		tmp[size] = str;
		return tmp;
	}
	/**
	 * @return
	 * @throws Exception
	 */
	public String insertProcurementReceiptDeliveryid() throws Exception {
		
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
		inventoryPo.setCstibillid(request.getParameter("hid"));
		inventoryPo.getCstideliveryid();
		procurementReceiptMgr.updateOrderDeliveryID(inventoryPo);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
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

	public List<WarehousePo> getWarehouselist() {
		return warehouselist;
	}

	public void setWarehouselist(List<WarehousePo> warehouselist) {
		this.warehouselist = warehouselist;
	}

	public List<InventoryPo> getProcurementReceiptList() {
		return procurementReceiptList;
	}

	public void setProcurementReceiptList(
			List<InventoryPo> procurementReceiptList) {
		this.procurementReceiptList = procurementReceiptList;
	}

	public StatusPo getStatusPo() {
		return statusPo;
	}

	public void setStatusPo(StatusPo statusPo) {
		this.statusPo = statusPo;
	}

	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}

	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
	}

	public List<ProcurementOrdersEntryPo> getProcurementOrdersEntryPos() {
		return procurementOrdersEntryPos;
	}

	public void setProcurementOrdersEntryPos(
			List<ProcurementOrdersEntryPo> procurementOrdersEntryPos) {
		this.procurementOrdersEntryPos = procurementOrdersEntryPos;
	}

	
}
