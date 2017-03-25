package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.WindowConsignProcessOrderMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.storage.mgr.ConsignProcessTakeMgr;
import com.pengsheng.eims.storage.mgr.ProcurementReceiptMgr;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.InventoryTempPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersEntryPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public class ConsignProcessTakeAction extends BaseAction {
	
	private List<DepartmentsPo> deptList;
	private WindowConsignProcessOrderMgr windowConsignProcessOrderMgr;
	private List<SupplierPo> supplierList;
	private BillKeyMgr billKeyMgr;
	private ProcurementReceiptMgr procurementReceiptMgr;
	private ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo;
	private ConsignProcessTakeMgr consignProcessTakeMgr;	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private WarehouseConfigurationPo warehouseConfigurationPo;
	private DepartmentsMgr departmentsMgr;
	private List<ProcurementOrdersEntryPo> procurementOrdersEntryPos;
	private ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo;	
	private List<ConsignProcessReceiptDetailsPo> consignProcessReceiptDetailsList;
	private List<ConsignProcessOrderDetailsPo> getGoodsList;
	private List<ConsignProcessOrderDetailsPo> getGoodsWarehouseList;
	private List<WarehousePo> getWarehouseList;	
	private ConsignProcessReceiptPo consignProcessReceiptPo;	
	private List<ConsignProcessReceiptPo> consignProcessReceipts;
	private ConsignProcessOrderDetailsPo oDPo;
	private List<ConsignProcessOrderDetailsPo> oDPoList;	
	private ConsignProcessOrderDetailsPo oSPo;
	private List<ConsignProcessOrderDetailsPo> oSPoList;	
	private List<ConsignProcessOrderDetailsPo> list;
	private List<ConsignProcessReceiptDetailsPo> receiptList;	
	private List<ConsignProcessOrderDetailsPo> salesidList;	
	private List<ConsignProcessReceiptPo> deliveryidLIst;
	private PersonPermissionMgr personPermissionMgr;
	private List<ConsignProcessOrderDetailsPo> framePoList;
	
	public List<ConsignProcessOrderDetailsPo> getFramePoList() {
		return framePoList;
	}

	public void setFramePoList(List<ConsignProcessOrderDetailsPo> framePoList) {
		this.framePoList = framePoList;
	}

	public ConsignProcessReceiptDetailsPo getConsignProcessReceiptDetailsPo() {
		return consignProcessReceiptDetailsPo;
	}

	public void setConsignProcessReceiptDetailsPo(
			ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo) {
		this.consignProcessReceiptDetailsPo = consignProcessReceiptDetailsPo;
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

	public List<DepartmentsPo> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<DepartmentsPo> deptList) {
		this.deptList = deptList;
	}

	public WindowConsignProcessOrderMgr getWindowConsignProcessOrderMgr() {
		return windowConsignProcessOrderMgr;
	}

	public void setWindowConsignProcessOrderMgr(
			WindowConsignProcessOrderMgr windowConsignProcessOrderMgr) {
		this.windowConsignProcessOrderMgr = windowConsignProcessOrderMgr;
	}

	public List<SupplierPo> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<SupplierPo> supplierList) {
		this.supplierList = supplierList;
	}

	public List<ProcurementOrdersEntryPo> getProcurementOrdersEntryPos() {
		return procurementOrdersEntryPos;
	}

	public void setProcurementOrdersEntryPos(
			List<ProcurementOrdersEntryPo> procurementOrdersEntryPos) {
		this.procurementOrdersEntryPos = procurementOrdersEntryPos;
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

	public List<ConsignProcessReceiptDetailsPo> getConsignProcessReceiptDetailsList() {
		return consignProcessReceiptDetailsList;
	}

	public void setConsignProcessReceiptDetailsList(
			List<ConsignProcessReceiptDetailsPo> consignProcessReceiptDetailsList) {
		this.consignProcessReceiptDetailsList = consignProcessReceiptDetailsList;
	}

	public List<ConsignProcessReceiptPo> getConsignProcessReceipts() {
		return consignProcessReceipts;
	}

	public void setConsignProcessReceipts(
			List<ConsignProcessReceiptPo> consignProcessReceipts) {
		this.consignProcessReceipts = consignProcessReceipts;
	}
	
	public ConsignProcessReceiptPo getConsignProcessReceiptPo() {
		return consignProcessReceiptPo;
	}

	public void setConsignProcessReceiptPo(
			ConsignProcessReceiptPo consignProcessReceiptPo) {
		this.consignProcessReceiptPo = consignProcessReceiptPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	
	public List<ConsignProcessReceiptPo> getDeliveryidLIst() {
		return deliveryidLIst;
	}

	public void setDeliveryidLIst(List<ConsignProcessReceiptPo> deliveryidLIst) {
		this.deliveryidLIst = deliveryidLIst;
	}

	public List<ConsignProcessOrderDetailsPo> getSalesidList() {
		return salesidList;
	}

	public void setSalesidList(List<ConsignProcessOrderDetailsPo> salesidList) {
		this.salesidList = salesidList;
	}

	public List<ConsignProcessReceiptDetailsPo> getReceiptList() {
		return receiptList;
	}

	public void setReceiptList(List<ConsignProcessReceiptDetailsPo> receiptList) {
		this.receiptList = receiptList;
	}

	public List<ConsignProcessOrderDetailsPo> getList() {
		return list;
	}

	public void setList(List<ConsignProcessOrderDetailsPo> list) {
		this.list = list;
	}

	public ConsignProcessOrderDetailsPo getoDPo() {
		return oDPo;
	}

	public void setoDPo(ConsignProcessOrderDetailsPo oDPo) {
		this.oDPo = oDPo;
	}

	public ConsignProcessOrderDetailsPo getoSPo() {
		return oSPo;
	}

	public void setoSPo(ConsignProcessOrderDetailsPo oSPo) {
		this.oSPo = oSPo;
	}

	public ConsignProcessTakeMgr getConsignProcessTakeMgr() {
		return consignProcessTakeMgr;
	}

	public void setConsignProcessTakeMgr(
			ConsignProcessTakeMgr consignProcessTakeMgr) {
		this.consignProcessTakeMgr = consignProcessTakeMgr;
	}

	public ConsignProcessOrderDetailsPo getConsignProcessOrderDetailsPo() {
		return consignProcessOrderDetailsPo;
	}

	public void setConsignProcessOrderDetailsPo(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		this.consignProcessOrderDetailsPo = consignProcessOrderDetailsPo;
	}

	public List<ConsignProcessOrderDetailsPo> getGetGoodsList() {
		return getGoodsList;
	}

	public void setGetGoodsList(List<ConsignProcessOrderDetailsPo> getGoodsList) {
		this.getGoodsList = getGoodsList;
	}

	public List<ConsignProcessOrderDetailsPo> getGetGoodsWarehouseList() {
		return getGoodsWarehouseList;
	}

	public void setGetGoodsWarehouseList(
			List<ConsignProcessOrderDetailsPo> getGoodsWarehouseList) {
		this.getGoodsWarehouseList = getGoodsWarehouseList;
	}

	public List<WarehousePo> getGetWarehouseList() {
		return getWarehouseList;
	}

	public void setGetWarehouseList(List<WarehousePo> getWarehouseList) {
		this.getWarehouseList = getWarehouseList;
	}

	/**
	 * 初始化收货查询
	 */
	public String initConsignProcessTakeSel() throws Exception {
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

		WarehousePo warehousePo = new WarehousePo();
		warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		// 得到部门对应仓位
		getWarehouseList = consignProcessTakeMgr.getWarehouse(warehousePo);
		///////////////////系统配置//////////////////
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	

		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selConsignProcessTake";
		}
		///////////////////系统配置//////////////////

		return SUCCESS;
	}

	/**
	 * 查询委外收货
	 */
	public String selConsignProcessTake() throws Exception {
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
		String sourceBillID = Utility.getName(request
				.getParameter("sourceBillID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String instockID = Utility.getName(request.getParameter("instockID"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String remark = Utility.getName(request.getParameter("remark"));
		String cstcprAuditPersonName = Utility.getName(request.getParameter("cstcprAuditPersonName"));
		String cstcprAuditPersonID = Utility.getName(request.getParameter("cstcprAuditPersonID"));
		String cstcprCreatePersonName = Utility.getName(request.getParameter("cstcprCreatePersonName"));
		String cstcprCreatePersonID = Utility.getName(request.getParameter("cstcprCreatePersonID"));
		String auditstartdate=Utility.getName(request.getParameter("auditStartDate"));
		String auditenddate=Utility.getName(request.getParameter("auditEndDate"));
		String djsbm=Utility.getName(request.getParameter("djsbm"));
		
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		request.setAttribute("goodsName", goodsName);
		
		ConsignProcessReceiptPo po = new ConsignProcessReceiptPo();
		po.setCstcprreceiptbillid(billID);
		po.setCstcprsourcebillid(sourceBillID);
		po.setCstcprstartTime(startTime);
		po.setCstcprendTime(endTime);
		po.setCstcprinstockid(instockID);
		po.setCstcprauditstate(auditState);
		po.setCstcprauditstartdate(auditstartdate);
		po.setCstcprauditenddate(auditenddate);
		po.setCstcprauditperson(cstcprAuditPersonName);
		po.setCstcprcreateperson(cstcprCreatePersonName);
		po.setCstcprgoodsname(goodsName);
		po.setCstcprremark(remark);
		po.setSalesdjsbm(djsbm);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setCstcprcompanyid(personInfoPo.getPersoncompanyid());
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
		request.setAttribute("systemParameterPo", systemParameterPo);
			///////////////////系统配置//////////////////

		int count = consignProcessTakeMgr.getConsignProcessReceiptCount(po);
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
			consignProcessReceipts = consignProcessTakeMgr
					.getConsignProcessReceiptList(po, page.getStart(), page
							.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			consignProcessReceipts = null;
		}

		request.setAttribute("billID", billID);
		request.setAttribute("sourceBillID", sourceBillID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("instockID", instockID);
		request.setAttribute("auditState", auditState);

		request.setAttribute("cstcprAuditPersonID", cstcprAuditPersonID);
		request.setAttribute("cstcprAuditPersonName", cstcprAuditPersonName);
		request.setAttribute("cstcprCreatePersonID", cstcprCreatePersonID);
		request.setAttribute("cstcprCreatePersonName", cstcprCreatePersonName);
		request.setAttribute("auditStartDate", auditstartdate);
		request.setAttribute("auditEndDate", auditenddate);
		request.setAttribute("remark", remark);
		request.setAttribute("djsbm", djsbm);
		WarehousePo warehousePo = new WarehousePo();
		warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
		}

		// 得到部门对应仓位
		getWarehouseList = consignProcessTakeMgr.getWarehouse(warehousePo);
		

		return SUCCESS;
	}
	
	/**
	 * 初始化委外收货新增
	 * 
	 * @return
	 */
	public String initConsignProcessTakeInsert() {
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

		return SUCCESS;
	}

	/**
	 * 委外收货新增查询
	 * 
	 * @return
	 */
	public String consignProcessTakeInsert() {
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

		String receiptid = "CPIN" + GenerateNumber.getInstance().getGenerageNumber();

		WarehousePo warehousePo = new WarehousePo();
		warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
		}

		String billID = Utility.getName(request.getParameter("billID"));

		String salesid = Utility.getName(request.getParameter("salesid"));
		
		String ordersdeliveryid = Utility.getName(request.getParameter("deliveryid"));
		
		request.setAttribute("billID", billID);
		request.setAttribute("salesid", salesid);
		request.setAttribute("receiptid", receiptid);
		request.setAttribute("ordersdeliveryid", ordersdeliveryid);

		ConsignProcessOrderDetailsPo consignProcessPo = new ConsignProcessOrderDetailsPo();
		consignProcessPo.setCstcpodglassesbillid(salesid);
		consignProcessPo.setCstcpodorderbilld(billID);

		// 顾客信息
		consignProcessOrderDetailsPo = consignProcessTakeMgr.getCustomer(consignProcessPo);
		// 商品信息
		getGoodsList = consignProcessTakeMgr.getGoods(consignProcessPo);
		// 商品信息--代码-条码
		getGoodsWarehouseList = consignProcessTakeMgr.getGoodsWarehouse(consignProcessPo);
		// 得到部门对应仓位
		getWarehouseList = consignProcessTakeMgr.getWarehouse(warehousePo);
		// 在页面显示右眼及左眼信息
		oDPo = new ConsignProcessOrderDetailsPo();
		oSPo = new ConsignProcessOrderDetailsPo();
		oDPoList = new ArrayList<ConsignProcessOrderDetailsPo>();
		oSPoList = new ArrayList<ConsignProcessOrderDetailsPo>();
		// 遍历左眼右眼信息
		for (ConsignProcessOrderDetailsPo detailPo : getGoodsList) {
			if ("R".equals(detailPo.getCstcpodglassflag())) {
				oDPo = detailPo;
				oDPoList.add(oDPo);
			} else if ("L".equals(detailPo.getCstcpodglassflag())) {
				oSPo = detailPo;
				oSPoList.add(oSPo);
			}
		}

		list = new ArrayList<ConsignProcessOrderDetailsPo>();

		// 遍历代码 增加批号
		for (ConsignProcessOrderDetailsPo po : getGoodsWarehouseList) {
			String barcode = po.getCstcpodgoodsid().replace(".", "")+ "00000000";
			po.setCstcpodgoodsbarcode(barcode);
			list.add(po);
		}

		//默认仓位
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);

		// 遍历配镜单中的镜架、太阳镜、老花镜
		framePoList = consignProcessTakeMgr.getFrameGoods(consignProcessPo);
		
		return SUCCESS;
	}

	/**
	 * 新增收货单
	 * 
	 * @return
	 */
	public String insertConsignProcessTake() {
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
		
		String departmentid = personInfoPo.getDepartmentID();
		String personid = personInfoPo.getId();

		String goodscategory = Utility.getName(request.getParameter("goodscategory"));
		String supplierid = Utility.getName(request.getParameter("supplierid"));

		String salesid = Utility.getName(request.getParameter("salesid"));// 原销售单号 销售主表更新用
		
		int isintransit = billKeyMgr.selectProcurementOrderForType("5",salesid);
		if(isintransit == 1){
			this.clearMessages();
			this.addActionMessage("该配镜单已被收货，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		String cstcprsalesid = Utility.getName(request.getParameter("cstcprsalesid"));//配镜单号
		String id = Utility.getName(request.getParameter("id"));// 收货单号
		String instockid = Utility.getName(request.getParameter("instockid"));
		
		String ordersdeliveryid = Utility.getName(request.getParameter("deliveryid"));//发货单号
		String billID = Utility.getName(request.getParameter("billID"));//委外订单编号
		
		String waybillid=Utility.getName(request.getParameter("waybillid"));//委外订单编号
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("委外收货单：" + id + " 新增!");
		
		// 新增收货主表
		ConsignProcessReceiptPo consignReceiptPo = new ConsignProcessReceiptPo();
		consignReceiptPo.setCstcprreceiptbillid(id);
		consignReceiptPo.setCstcprsourcebillid(billID);
		consignReceiptPo.setCstcprsalesid(cstcprsalesid);
		consignReceiptPo.setCstcprgoodscategory(goodscategory);
		consignReceiptPo.setCstcprsupplierid(supplierid);
		consignReceiptPo.setCstcprinstockid(instockid);
		consignReceiptPo.setCstcprdepartmentid(departmentid);
		consignReceiptPo.setCstcprcreateperson(personid);
		consignReceiptPo.setCstcprauditperson(personid);
		consignReceiptPo.setCstcprwaybillid(waybillid);
		
		// 根据公司和制造商查询绑定的供应商
		consignReceiptPo.setCstcprsubsupplierid(procurementReceiptMgr.getSupplierByModeAndCompany(Utility.getName(personInfoPo.getPersoncompanyid()),Utility.getName(supplierid)));
				
		if (!"".equals(ordersdeliveryid)) {
			consignReceiptPo.setCstcprordersdeliveryid(ordersdeliveryid);
		}
		
		// 新增在途明细表
		InTransitPo inTransitPo = new InTransitPo();
		inTransitPo.setSseitsalesid(salesid);
		inTransitPo.setSseitcreateperson(personid);
		inTransitPo.setSseitdepartment(departmentid);

		// 收货明细表、当月库存变更表、库存日志表传receiptList遍历得到

		// 新增信息到业务单据临时表中
		InventoryTempPo inventoryTempPo = new InventoryTempPo();
		inventoryTempPo.setCstitbillid(id);
		inventoryTempPo.setCstitbilltypeid("9");
		inventoryTempPo.setCstitsourcebillid(salesid);
		inventoryTempPo.setCstitdeliveryid(ordersdeliveryid);
		inventoryTempPo.setCstitsupplierid(supplierid);
		inventoryTempPo.setCstitinstockid(instockid);
		inventoryTempPo.setCstitdepartmentid(departmentid);
		inventoryTempPo.setCstitcreateperson(personid);
		inventoryTempPo.setCstitauditperson(personid);
		inventoryTempPo.setCstitsubsupplierid(consignReceiptPo.getCstcprsubsupplierid());
		
		int lenth = consignProcessReceiptDetailsPo.getCstcprdgoodsids().length;		
		receiptList = new ArrayList<ConsignProcessReceiptDetailsPo>();
		for(int i=0; i<lenth; i++){
			ConsignProcessReceiptDetailsPo addpo = new ConsignProcessReceiptDetailsPo();
			
			addpo.setCstcprflag(consignProcessReceiptDetailsPo.getCstcprflags()[i]);
			addpo.setCstcprdgoodsid(consignProcessReceiptDetailsPo.getCstcprdgoodsids()[i]);
			addpo.setCstcprdnum(consignProcessReceiptDetailsPo.getCstcprdnums()[i]);
			addpo.setCstcprdnottaxrate(consignProcessReceiptDetailsPo.getCstcprdnottaxrates()[i]);
			addpo.setCstcprdtaxrate(consignProcessReceiptDetailsPo.getCstcprdtaxrates()[i]);
			addpo.setCstcprdcostprice(consignProcessReceiptDetailsPo.getCstcprdcostprices()[i]);
			addpo.setCstcprdorderdetailsid(consignProcessReceiptDetailsPo.getCstcprdorderdetailsids()[i]);
			addpo.setCstcpodsalesid(consignProcessReceiptDetailsPo.getCstcpodsalesids()[i]);
			addpo.setCstcprdbarcode(consignProcessReceiptDetailsPo.getCstcprdbarcodes()[i]);
			
			if("4".equals(goodscategory)){
				addpo.setCstcpguaranteeperiod(Utility.getName(consignProcessReceiptDetailsPo.getCstcpguaranteeperiods()[i]));
				addpo.setCstcpbatch(Utility.getName(consignProcessReceiptDetailsPo.getCstcpbatchs()[i]));
				addpo.setCstcpregistrationnum(Utility.getName(consignProcessReceiptDetailsPo.getCstcpregistrationnums()[i]));
			}
			
			receiptList.add(addpo);
		}

		consignProcessTakeMgr.insertReceipt(systemParameterPo,salesid, receiptList, consignReceiptPo, inTransitPo, inventoryTempPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	/**
	 * 委外收货详细
	 */
	public String consignProcessTakeDetails() throws Exception {
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String id = Utility.getName(request.getParameter("hid"));
		String sid = Utility.getName(request.getParameter("sid"));
		ConsignProcessReceiptPo po = new ConsignProcessReceiptPo();
		po.setCstcprreceiptbillid(id);
		po.setCstcprsalesid(sid);
		consignProcessReceiptPo = consignProcessTakeMgr.getConsignProcessReceipt(po);
		consignProcessReceiptDetailsList = consignProcessTakeMgr.getConsignProcessReceiptEntryList(po);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化委外单按钮开窗
	 * 
	 * @return
	 */
	public String initSalesIdSel() {
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
				.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置  ***************************** */
		return SUCCESS;
	}

	/**
	 * 查询委外配镜单信息
	 * 
	 * @return
	 */
	public String selectSalesId() {
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
				.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String billid = Utility.getName(request.getParameter("billid"));
		String selsuppliername = Utility.getName(request.getParameter("selsuppliername"));
		String selsupplierid = Utility.getName(request.getParameter("selsupplierid"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String billtype = Utility.getName(request.getParameter("billtype"));
		String glassid = Utility.getName(request.getParameter("glassid"));
		
		String brandID = Utility.getName(request.getParameter("brandID"));
		String qjv = Utility.getName(request.getParameter("qjv"));
		String zjv = Utility.getName(request.getParameter("zjv"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		
		ConsignProcessOrderDetailsPo Po = new ConsignProcessOrderDetailsPo();
		Po.setCstcpodorderbilld(billid);
		Po.setCstcposupplierid(selsupplierid);
		Po.setCstcpodarrivedstart(startTime);
		Po.setCstcpodarrivedstart(endTime);
		Po.setCstcpodordertype(billtype);
		Po.setCstcpodglassesbillid(glassid);
		Po.setCstcpodballglass(qjv);
		Po.setCstcpodpostglass(zjv);
		Po.setCstcpobrandid(brandID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			Po.setCstcpcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		request.setAttribute("billid", billid);
		request.setAttribute("selsuppliername", selsuppliername);
		request.setAttribute("selsupplierid", selsupplierid);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("billtype", billtype);
		request.setAttribute("glassid", glassid);
		
		request.setAttribute("brandID", brandID);
		request.setAttribute("qjv", qjv);
		request.setAttribute("zjv", zjv);
		request.setAttribute("brandName", brandName);
		
		int count = consignProcessTakeMgr.getSalesid(Po);
		if (count > 0) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
			salesidList = consignProcessTakeMgr.selectSalesid(Po , page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			salesidList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化委外单按钮开窗
	 * 
	 * @return
	 */
	public String initSalesIdsSel() {
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
		deppo.setBdptype("1");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		deptList = departmentsMgr.getSalesAndStorageDepartment(deppo);
		supplierList = windowConsignProcessOrderMgr.getSupplierOrdersalse(deppo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	

		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectSalesIds";
		}

		return SUCCESS;
	}

	/**
	 * 查询委外配镜单信息
	 * 
	 * @return
	 */
	public String selectSalesIds() {
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
		String selsupplierid = Utility.getName(request.getParameter("supplierID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String cstcpoordergoodscategory = Utility.getName(request.getParameter("cstcpoordergoodscategory"));
		String glassid = Utility.getName(request.getParameter("glassid"));		
		String deptID = Utility.getName(request.getParameter("deptID"));
		String ssesbsalesdatestarttime = Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime = Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String qjv = Utility.getName(request.getParameter("qjv"));
		String zjv = Utility.getName(request.getParameter("zjv"));
		
		request.setAttribute("goodsName", goodsName);
		
		
		String minSphjp = Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp = Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp = Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp = Utility.getName(request.getParameter("maxCyljp"));
		
		String djsbm=Utility.getName(request.getParameter("djsbm"));
		
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		request.setAttribute("qjv", qjv);
		request.setAttribute("zjv", zjv);
		
		ConsignProcessOrderDetailsPo Po = new ConsignProcessOrderDetailsPo();
		Po.setCstcpoddepartmentid(deptID);
		Po.setCstcposupplierid(selsupplierid);
		Po.setCstcpodarrivedstart(startTime);
		Po.setCstcpodarrivedend(endTime);
		Po.setCstcpodbilltype(cstcpoordergoodscategory);
		Po.setCstcpodglassesbillid(glassid);
		Po.setCstcpodsalesdatetime(ssesbsalesdatestarttime);
		Po.setCstcpodsalesdateendtime(ssesbsalesdateendtime);
		Po.setCstcpodgoodsname(goodsName);
		Po.setMaxSph(maxSphjp);
		Po.setMinSph(minSphjp);
		Po.setMaxCyl(maxCyljp);
		Po.setMinCyl(minCyljp);
		Po.setCstcpodballglass(qjv);
		Po.setCstcpodpostglass(zjv);
		Po.setSalesdjsbm(djsbm);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			Po.setCstcpcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		request.setAttribute("deptID", deptID);
		request.setAttribute("supplierID", selsupplierid);
		request.setAttribute("selsupplierid", selsupplierid);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("cstcpoordergoodscategory", cstcpoordergoodscategory);
		request.setAttribute("glassid", glassid);
		request.setAttribute("ssesbsalesdatestarttime", ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime", ssesbsalesdateendtime);
		request.setAttribute("djsbm", djsbm);
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdptype("1");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		deptList = departmentsMgr.getSalesAndStorageDepartment(deppo);
		supplierList = windowConsignProcessOrderMgr.getSupplierOrdersalse(deppo);
		
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
		
		int count = consignProcessTakeMgr.getSalesids(Po);
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
			salesidList = consignProcessTakeMgr.selectSalesids(Po , page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			salesidList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化委外单按钮开窗
	 * 
	 * @return
	 */
	public String initSalesIdsSelW() {
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
		deppo.setBdptype("1");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		deptList = departmentsMgr.getSalesAndStorageDepartment(deppo);
		supplierList = windowConsignProcessOrderMgr.getSupplierOrdersalse(deppo);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	

		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectSalesIdsW";
		}

		return SUCCESS;
	}

	/**
	 * 查询委外配镜单信息
	 * 
	 * @return
	 */
	public String selectSalesIdsW() {
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
		String selsupplierid = Utility.getName(request.getParameter("supplierID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String cstcpoordergoodscategory = Utility.getName(request.getParameter("cstcpoordergoodscategory"));
		String glassid = Utility.getName(request.getParameter("glassid"));		
		String deptID = Utility.getName(request.getParameter("deptID"));
		String ssesbsalesdatestarttime = Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime = Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String remark = Utility.getName(request.getParameter("remark"));
		request.setAttribute("remark", remark);
		request.setAttribute("goodsName", goodsName);
		
		String minSphjp = Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp = Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp = Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp = Utility.getName(request.getParameter("maxCyljp"));
		String djsbm = Utility.getName(request.getParameter("djsbm"));
		
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		
		ConsignProcessOrderDetailsPo Po = new ConsignProcessOrderDetailsPo();
		Po.setCstcpoddepartmentid(deptID);
		Po.setCstcposupplierid(selsupplierid);
		Po.setCstcpodarrivedstart(startTime);
		Po.setCstcpodarrivedend(endTime);
		Po.setCstcpodbilltype(cstcpoordergoodscategory);
		Po.setCstcpodglassesbillid(glassid);
		Po.setCstcpodsalesdatetime(ssesbsalesdatestarttime);
		Po.setCstcpodsalesdateendtime(ssesbsalesdateendtime);
		Po.setCstcpodgoodsname(goodsName);
		Po.setCstcporemark(remark);
		Po.setMaxSph(maxSphjp);
		Po.setMinSph(minSphjp);
		Po.setMaxCyl(maxCyljp);
		Po.setMinCyl(minCyljp);
		Po.setSalesdjsbm(djsbm);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			Po.setCstcpcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		request.setAttribute("deptID", deptID);
		request.setAttribute("selsupplierid", selsupplierid);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("cstcpoordergoodscategory", cstcpoordergoodscategory);
		request.setAttribute("glassid", glassid);
		request.setAttribute("ssesbsalesdatestarttime", ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime", ssesbsalesdateendtime);
		request.setAttribute("djsbm", djsbm);
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdptype("1");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		deptList = departmentsMgr.getSalesAndStorageDepartment(deppo);
		supplierList = windowConsignProcessOrderMgr.getSupplierOrdersalse(deppo);
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
		
		int count = consignProcessTakeMgr.getSalesidsW(Po);
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
			salesidList = consignProcessTakeMgr.selectSalesidsW(Po , page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			salesidList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化查询发货单号
	 * @return
	 */
	public String initdeliveryid(){
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
		return SUCCESS;
	}
	
	/**
	 * 查询发货单号
	 * @return
	 */
	public String selectdeliveryid(){
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
		String billid = Utility.getName(request.getParameter("billid"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String send = Utility.getName(request.getParameter("deliveryid"));
		
		request.setAttribute("billid", billid);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("send", send);
		
		ConsignProcessReceiptPo Po = new ConsignProcessReceiptPo();
		Po.setCstcprsalesid(billid);
		Po.setCstcprdeliverystart(startTime);
		Po.setCstcprdeliveryend(endTime);
		Po.setCstcprordersdeliveryid(send);
		
		//切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.orders);//设置为orders数据源
		
		int count = consignProcessTakeMgr.getdeliveryCount(Po);
		if (count > 0) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
			deliveryidLIst = consignProcessTakeMgr.selectdeliveryList(Po , page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			deliveryidLIst = null;
		}
		
		//切换数据库
		//CustomerContextHolder.setCustomerType(CustomerType.eims);//设置为eims数据源
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		return SUCCESS;
	}

	public List<ConsignProcessOrderDetailsPo> getoDPoList() {
		return oDPoList;
	}

	public void setoDPoList(List<ConsignProcessOrderDetailsPo> oDPoList) {
		this.oDPoList = oDPoList;
	}

	public List<ConsignProcessOrderDetailsPo> getoSPoList() {
		return oSPoList;
	}

	public void setoSPoList(List<ConsignProcessOrderDetailsPo> oSPoList) {
		this.oSPoList = oSPoList;
	}

}
