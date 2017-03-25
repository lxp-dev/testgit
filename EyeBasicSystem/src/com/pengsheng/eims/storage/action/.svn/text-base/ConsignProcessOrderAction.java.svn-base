package com.pengsheng.eims.storage.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.components.mgr.WindowConsignProcessOrderMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.mgr.ConsignProcessOrderMgr;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsTempPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;
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

public class ConsignProcessOrderAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;	
	private SupplierMgr supplierMgr;
	private ConsignProcessOrderMgr consignProcessOrderMgr;	
	private List<ConsignProcessOrderDetailsPo> goodsList;	
	private SupplierPo supplierPo;
	List<ConsignProcessOrderDetailsPo> consignProcessOrderselesDetails;
	private List<DepartmentsPo> deptList;	
	private List<SupplierPo> supplierList;
	private DepartmentsMgr departmentsMgr;
	private WindowConsignProcessOrderMgr windowConsignProcessOrderMgr;
	private List<GoodsCategoryPo> goodsCategorys;
	private List<ConsignProcessOrderPo> consignProcessOrders;
	private ConsignProcessOrderPo consignProcessOrderPo;
	private ConsignProcessOrderDetailsTempPo consignProcessOrderDetailsTemp;
	private List<ConsignProcessOrderDetailsPo> consignProcessOrderDetails;	
	private SystemParameterMgr systemParameterMgr;	
	private SystemParameterPo systemParameterPo;	
	private String isFirstExec;
	private BillKeyMgr billKeyMgr;
	
	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}

	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}

	public SupplierPo getSupplierPo() {
		return supplierPo;
	}

	public void setSupplierPo(SupplierPo supplierPo) {
		this.supplierPo = supplierPo;
	}
	
	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderselesDetails() {
		return consignProcessOrderselesDetails;
	}

	public void setConsignProcessOrderselesDetails(
			List<ConsignProcessOrderDetailsPo> consignProcessOrderselesDetails) {
		this.consignProcessOrderselesDetails = consignProcessOrderselesDetails;
	}

	public List<SupplierPo> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<SupplierPo> supplierList) {
		this.supplierList = supplierList;
	}
	
	public List<DepartmentsPo> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<DepartmentsPo> deptList) {
		this.deptList = deptList;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public List<ConsignProcessOrderDetailsPo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<ConsignProcessOrderDetailsPo> goodsList) {
		this.goodsList = goodsList;
	}

	public WindowConsignProcessOrderMgr getWindowConsignProcessOrderMgr() {
		return windowConsignProcessOrderMgr;
	}

	public void setWindowConsignProcessOrderMgr(
			WindowConsignProcessOrderMgr windowConsignProcessOrderMgr) {
		this.windowConsignProcessOrderMgr = windowConsignProcessOrderMgr;
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

	public ConsignProcessOrderMgr getConsignProcessOrderMgr() {
		return consignProcessOrderMgr;
	}

	public void setConsignProcessOrderMgr(
			ConsignProcessOrderMgr consignProcessOrderMgr) {
		this.consignProcessOrderMgr = consignProcessOrderMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public List<ConsignProcessOrderPo> getConsignProcessOrders() {
		return consignProcessOrders;
	}

	public void setConsignProcessOrders(
			List<ConsignProcessOrderPo> consignProcessOrders) {
		this.consignProcessOrders = consignProcessOrders;
	}

	public ConsignProcessOrderPo getConsignProcessOrderPo() {
		return consignProcessOrderPo;
	}

	public void setConsignProcessOrderPo(
			ConsignProcessOrderPo consignProcessOrderPo) {
		this.consignProcessOrderPo = consignProcessOrderPo;
	}

	public ConsignProcessOrderDetailsTempPo getConsignProcessOrderDetailsTemp() {
		return consignProcessOrderDetailsTemp;
	}

	public void setConsignProcessOrderDetailsTemp(
			ConsignProcessOrderDetailsTempPo consignProcessOrderDetailsTemp) {
		this.consignProcessOrderDetailsTemp = consignProcessOrderDetailsTemp;
	}

	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderDetails() {
		return consignProcessOrderDetails;
	}

	public void setConsignProcessOrderDetails(
			List<ConsignProcessOrderDetailsPo> consignProcessOrderDetails) {
		this.consignProcessOrderDetails = consignProcessOrderDetails;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	/**
	 * 查询委外订单页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initConsignProcessOrderSel() {

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
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selConsignProcessOrder";
		}

		return SUCCESS;
	}

	/**
	 * 查询委外订单页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selConsignProcessOrder() {

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

		goodsCategorys = consignProcessOrderMgr.getGoodsCategorys();

		String billID = Utility.getName(request.getParameter("billID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String createPersonName = Utility.getName(request.getParameter("createPersonName"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String selcategoryid = Utility.getName(request.getParameter("selcategoryid"));
		String selsupplierid = Utility.getName(request.getParameter("selsupplierid"));
		String selsuppliername = Utility.getName(request.getParameter("selsuppliername"));
		String salesid = Utility.getName(request.getParameter("salesid"));
		String djsbm=Utility.getName(request.getParameter("djsbm"));
		
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		request.setAttribute("goodsName", goodsName);
		
		ConsignProcessOrderPo consignProcessOrder = new ConsignProcessOrderPo();
		consignProcessOrder.setCstcpoorderbillid(billID);
		consignProcessOrder.setCstcpostarttime(startTime);
		consignProcessOrder.setCstcpoendtime(endTime);
		consignProcessOrder.setCstcpoordergoodscategory(selcategoryid);
		consignProcessOrder.setCstcposupplierid(selsupplierid);
		consignProcessOrder.setCstcpoauditstate(auditState);
		consignProcessOrder.setCreatePersonName(createPersonName);
		consignProcessOrder.setAuditPersonName(auditPersonName);
		consignProcessOrder.setSalesid(salesid);
		consignProcessOrder.setSalesdjsbm(djsbm );
		consignProcessOrder.setCstcpogoodsname(goodsName);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			consignProcessOrder.setCstcpocompanyid(personInfoPo.getPersoncompanyid());
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

		int count = consignProcessOrderMgr
				.getConsignProcessOrderCount(consignProcessOrder);
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
			consignProcessOrders = consignProcessOrderMgr
					.getConsignProcessOrderList(consignProcessOrder, page
							.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			consignProcessOrders = null;
		}

		request.setAttribute("billID", billID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("auditState", auditState);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("selcategoryid", selcategoryid);
		request.setAttribute("selsupplierid", selsupplierid);
		request.setAttribute("selsuppliername", selsuppliername);
		request.setAttribute("salesid", salesid);
		request.setAttribute("djsbm", djsbm);
		
		return SUCCESS;
	}
	
	
	/**
	 * 查询未生成委外订单页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initUnConsignProcessOrderSel() {

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
		
		deptList = departmentsMgr.getSalesAndStorageDepartment(deppo);
		supplierList = windowConsignProcessOrderMgr.getSuppliersalse(deppo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selUnConsignProcessOrder";
		}

		return SUCCESS;
	}

	/**
	 * 查询未生成委外订单页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selUnConsignProcessOrder() {

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

		String supplierID=Utility.getName(request.getParameter("supplierID"));
		String salesID=Utility.getName(request.getParameter("salesID"));
		String cstcpoordergoodscategory=Utility.getName(request.getParameter("cstcpoordergoodscategory"));
		String deptID=Utility.getName(request.getParameter("deptID"));	
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("ssesbsalesdateendtime"));	
		String ssesbtakeglassstartdata=Utility.getName(request.getParameter("ssesbtakeglassstartdata"));
		String ssesbtakeglassenddata=Utility.getName(request.getParameter("ssesbtakeglassenddata"));	
		String djsbm=Utility.getName(request.getParameter("djsbm"));
		
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		request.setAttribute("goodsName", goodsName);
		
		SalesBasicPo salesBasicPo=new SalesBasicPo();
		salesBasicPo.setSsesbsupplierid(supplierID);
		salesBasicPo.setSsesbsalesid(salesID);
		salesBasicPo.setSsesbshopcode(deptID);
		salesBasicPo.setSsesborderstype(cstcpoordergoodscategory);
		salesBasicPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesBasicPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesBasicPo.setSsesbtakeglassstartdata(ssesbtakeglassstartdata);
		salesBasicPo.setSsesbtakeglassenddata(ssesbtakeglassenddata);
		salesBasicPo.setSsesbgoodsname(goodsName);
		salesBasicPo.setDjsbm(djsbm);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			salesBasicPo.setSsesbcompanyid(personInfoPo.getPersoncompanyid());
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

		int count=windowConsignProcessOrderMgr.getSalesBasicForConsignProcessCount1(salesBasicPo);
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
	    goodsList=windowConsignProcessOrderMgr.getSalesBasicForConsignProcessList1(salesBasicPo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			goodsList = null;
		}	

		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		deptList = departmentsMgr.getSalesAndStorageDepartment(deppo);
		supplierList = windowConsignProcessOrderMgr.getSuppliersalse(deppo);
		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("cstcpoordergoodscategory",cstcpoordergoodscategory);
		
		request.setAttribute("salesID",salesID);
		request.setAttribute("deptID",deptID);
		request.setAttribute("ssesbsalesdatestarttime",ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime",ssesbsalesdateendtime);
		request.setAttribute("ssesbtakeglassstartdata",ssesbtakeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata",ssesbtakeglassenddata);
		request.setAttribute("djsbm", djsbm);
		
		return SUCCESS;
		
	}

	public String initConsignProcessOrderInsert() {
		
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
		
		consignProcessOrderPo = new ConsignProcessOrderPo();
		consignProcessOrderPo.setCstcpoorderbillid("EPO" + GenerateNumber.getInstance().getGenerageNumber());
		consignProcessOrderPo.setCstcpodeliveryaddress(Utility.getName(systemParameterPo.getFsptakeaddress()));
		consignProcessOrderPo.setCstcpodeliveryperson(Utility.getName(systemParameterPo.getFsptakeperson()));
		consignProcessOrderPo.setCstcpodeliveryphone(Utility.getName(systemParameterPo.getFsptakephone()));
		consignProcessOrderPo.setCstcpodeliveryfax(Utility.getName(systemParameterPo.getFsptakeportraiture()));
		return SUCCESS;
	}
	
	public String initConsignProcessOrderInserts() {
		
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
		
		String selesid = Utility.getName(request.getParameter("selesid"));
		String ordertype = Utility.getName(request.getParameter("ordertype"));
		String supplierid = Utility.getName(request.getParameter("supplierid"));
		String suppliername = Utility.getName(request.getParameter("suppliername"));
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		consignProcessOrderPo = new ConsignProcessOrderPo();
		consignProcessOrderPo.setCstcposupplierid(supplierid);
		consignProcessOrderPo.setBspsuppliername(suppliername);
		consignProcessOrderPo.setCstcpoordergoodscategory(ordertype);
		consignProcessOrderPo.setCstcpoorderbillid("EPO"+ GenerateNumber.getInstance().getGenerageNumber());
		consignProcessOrderPo.setSalesid(selesid);
		consignProcessOrderPo.setCstcpodeliveryaddress(Utility.getName(systemParameterPo.getFsptakeaddress()));
		consignProcessOrderPo.setCstcpodeliveryperson(Utility.getName(systemParameterPo.getFsptakeperson()));
		consignProcessOrderPo.setCstcpodeliveryphone(Utility.getName(systemParameterPo.getFsptakephone()));
		consignProcessOrderPo.setCstcpodeliveryfax(Utility.getName(systemParameterPo.getFsptakeportraiture()));
		ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo = new ConsignProcessOrderDetailsPo();
		consignProcessOrderDetailsPo.setCstcpodglassesbillid(consignProcessOrderPo.getSalesid());
		consignProcessOrderDetailsPo.setCstcposupplierid(supplierid);
		consignProcessOrderDetails = consignProcessOrderMgr.getConsignProcessOrderSelesDetailsList(consignProcessOrderDetailsPo);
		
		return SUCCESS;
	}
	
	public String initConsignProcessOrderBatchInserts() {
		
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
		
		String selesid  = Utility.getName(request.getParameter("selesid"));
		String ordertype = Utility.getName(request.getParameter("ordertype"));
		String supplierid = Utility.getName(request.getParameter("supplierid"));
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		SupplierPo supplierPo =new SupplierPo();
		supplierPo.setBspid(supplierid);
		SupplierPo pos = supplierMgr.getSupplier(supplierPo);
		
		consignProcessOrderPo = new ConsignProcessOrderPo();
		consignProcessOrderselesDetails = new ArrayList<ConsignProcessOrderDetailsPo>();
		consignProcessOrderDetails = new ArrayList<ConsignProcessOrderDetailsPo>();		
		ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo = new ConsignProcessOrderDetailsPo();		
		String[] bills = Utility.getName(selesid).split(",");
		if(bills.length==1){
			request.setAttribute("selesCount","1");
		}
		for (int i = 0; i < bills.length; i++){
			consignProcessOrderPo.setSalesid(bills[i]);
			consignProcessOrderDetailsPo.setCstcpodglassesbillid(consignProcessOrderPo.getSalesid());
			
			consignProcessOrderselesDetails = consignProcessOrderMgr.getConsignProcessOrderSelesDetailsList(consignProcessOrderDetailsPo);
			consignProcessOrderDetails.addAll(consignProcessOrderselesDetails);
		}
		consignProcessOrderPo.setCstcposupplierid(supplierid);
		consignProcessOrderPo.setBspsuppliername(pos.getBspsuppliername());
		consignProcessOrderPo.setCstcpoordergoodscategory(ordertype);
		consignProcessOrderPo.setCstcpoorderbillid("EPO"+ GenerateNumber.getInstance().getGenerageNumber());
		consignProcessOrderPo.setCstcpodeliveryaddress(Utility.getName(systemParameterPo.getFsptakeaddress()));
		consignProcessOrderPo.setCstcpodeliveryperson(Utility.getName(systemParameterPo.getFsptakeperson()));
		consignProcessOrderPo.setCstcpodeliveryphone(Utility.getName(systemParameterPo.getFsptakephone()));
		consignProcessOrderPo.setCstcpodeliveryfax(Utility.getName(systemParameterPo.getFsptakeportraiture()));
		return SUCCESS;
	}
	
	public String insertConsignProcessOrders() {
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

		if ("1".equals(request.getParameter("stateFlag"))) {
			consignProcessOrderPo.setCstcpoauditstate("1");
			consignProcessOrderPo.setCstcpoauditperson(((PersonInfoPo) session
					.get("person")).getId());
		} else {
			consignProcessOrderPo.setCstcpoauditstate("0");
		}
		
		consignProcessOrderPo.setCstcpodeparmentid(personInfoPo.getDepartmentID());
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("委外订单："+consignProcessOrderPo.getCstcpoorderbillid()+"新增");

		int lenth = consignProcessOrderDetailsTemp.getCstcpodglassesbillid().length;

		consignProcessOrderDetails = new ArrayList<ConsignProcessOrderDetailsPo>();

		SalesBasicPo sales = new SalesBasicPo();

		sales.setSsesbintransit("4");
		sales.setSsesbposid(personInfoPo.getId());

		InTransitPo inTransitPo = new InTransitPo();

		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		inTransitPo.setSseitstate("4");

		for (int i = 0; i < lenth; i++) {
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo = new ConsignProcessOrderDetailsPo();
			consignProcessOrderDetailsPo.setCstcpodorderbilld(consignProcessOrderPo.getCstcpoorderbillid());// 订单编号
			consignProcessOrderDetailsPo.setCstcpodglassesbillid(consignProcessOrderDetailsTemp.getCstcpodglassesbillid()[i]);
			consignProcessOrderDetailsPo.setCstcpodexpecteddate(consignProcessOrderDetailsTemp.getCstcpodexpecteddate()[i]);
			consignProcessOrderDetailsPo.setCstcpodordertype(consignProcessOrderDetailsTemp.getCstcpodordertype()[i]);
			consignProcessOrderDetailsPo.setCstcpodcustomerid(consignProcessOrderDetailsTemp.getCstcpodcustomerid()[i]);
			consignProcessOrderDetailsPo.setCstcpodcustomername(consignProcessOrderDetailsTemp.getCstcpodcustomername()[i]);
			consignProcessOrderDetailsPo.setCstcpodbilltype(consignProcessOrderPo.getCstcpoordergoodscategory());
			consignProcessOrderDetailsPo.setCstcpodglassflag(consignProcessOrderDetailsTemp.getCstcpodglassflag()[i]);
			consignProcessOrderDetailsPo.setCstcpodgoodsid(consignProcessOrderDetailsTemp.getCstcpodgoodsid()[i]);
			consignProcessOrderDetailsPo.setCstcpodballglass(consignProcessOrderDetailsTemp.getCstcpodballglass()[i]);
			consignProcessOrderDetailsPo.setCstcpodpostglass(consignProcessOrderDetailsTemp.getCstcpodpostglass()[i]);
			consignProcessOrderDetailsPo.setCstcpodaxes(consignProcessOrderDetailsTemp.getCstcpodaxes()[i]);
			consignProcessOrderDetailsPo.setCstcpodadd(consignProcessOrderDetailsTemp.getCstcpodadd()[i]);
			consignProcessOrderDetailsPo.setCstcpodarriseglass(consignProcessOrderDetailsTemp.getCstcpodarriseglass()[i]);
			consignProcessOrderDetailsPo.setCstcpodbasis(consignProcessOrderDetailsTemp.getCstcpodbasis()[i]);
			consignProcessOrderDetailsPo.setCstcpodeyecurvature(consignProcessOrderDetailsTemp.getCstcpodeyecurvature()[i]);
			consignProcessOrderDetailsPo.setCstcpoddiameter(consignProcessOrderDetailsTemp.getCstcpoddiameter()[i]);
			consignProcessOrderDetailsPo.setCstcpodarriveddate(consignProcessOrderDetailsTemp.getCstcpodexpecteddate()[i]);
			consignProcessOrderDetailsPo.setCstcpodrequirement(consignProcessOrderDetailsTemp.getCstcpodrequirement()[i]);
			consignProcessOrderDetailsPo.setCstcpodnum(consignProcessOrderDetailsTemp.getCstcpodnum()[i]);
			consignProcessOrderDetailsPo.setCstcpoddragstype(consignProcessOrderDetailsTemp.getCstcpoddragstype()[i]);
			consignProcessOrderDetailsPo.setCstcpodinter(consignProcessOrderDetailsTemp.getCstcpodinter()[i]);
			consignProcessOrderDetailsPo.setCstcpodinterdistance(consignProcessOrderDetailsTemp.getCstcpodinterdistance()[i]);
			consignProcessOrderDetailsPo.setCstcpodstate("0");

			consignProcessOrderDetailsPo.setCstcpodsalesbillid(consignProcessOrderDetailsTemp.getCstcpodsalesbillid()[i]);
			consignProcessOrderDetailsPo.setCstcpodsalesid(consignProcessOrderDetailsTemp.getCstcpodsalesid()[i]);

			// 修改内部订单在途
			// if ("N"
			// .equals(consignProcessOrderDetailsTemp
			// .getCstcpodordertype()[i])) {
			// sales.setSsesbsalesid(consignProcessOrderDetailsTemp
			// .getCstcpodglassesbillid()[i]);
			//
			// inTransitPo.setSseitsalesid(sales.getSsesbsalesid());
			// }

			consignProcessOrderDetails.add(consignProcessOrderDetailsPo);
		}
		
		String errorsalesid = "以下销售单号：\\n";
		String errortype = "";
		for(int i=0; i < consignProcessOrderDetails.size(); i++){
			int istake = billKeyMgr.selectOrdersForSalesBill(consignProcessOrderDetails.get(i).getCstcpodglassesbillid());
			if(istake > 0){
				errorsalesid = errorsalesid + consignProcessOrderDetails.get(i).getCstcpodglassesbillid() + "\\n";
				errortype = "1";
			}
			
			istake = billKeyMgr.selectProcurementOrderForType("4",consignProcessOrderDetails.get(i).getCstcpodglassesbillid());
			if(istake > 0){
				errorsalesid = errorsalesid + consignProcessOrderDetails.get(i).getCstcpodglassesbillid() + "\\n";
				errortype = "1";
			}
			
			istake = billKeyMgr.selectProcurementOrderForType("14",consignProcessOrderDetails.get(i).getCstcpodglassesbillid());
			if(istake > 0){
				errorsalesid = errorsalesid + consignProcessOrderDetails.get(i).getCstcpodglassesbillid() + "\\n";
				errortype = "1";
			}
		}
		if(errortype.equals("1")){
			this.clearMessages();
			this.addActionMessage(errorsalesid+"已创建委外订单，不能进行重复操作或已退款！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
	
		consignProcessOrderMgr.insertConsignProcessOrder(consignProcessOrderPo,
				consignProcessOrderDetails, sales, inTransitPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));


		String url = "''initConsignProcessOrderView.action?hid={0}''";
		List<String> params = new ArrayList<String>();
		params.add(consignProcessOrderPo.getCstcpoorderbillid());

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);

		return SUCCESS;
	}

	public String insertConsignProcessOrder() {
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

		if ("1".equals(request.getParameter("stateFlag"))) {
			consignProcessOrderPo.setCstcpoauditstate("1");
			consignProcessOrderPo.setCstcpoauditperson(((PersonInfoPo) session
					.get("person")).getId());
		} else {
			consignProcessOrderPo.setCstcpoauditstate("0");
		}
		
		consignProcessOrderPo.setCstcpodeparmentid(personInfoPo.getDepartmentID());
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("委外订单："+consignProcessOrderPo.getCstcpoorderbillid()+"新增");

		int lenth = consignProcessOrderDetailsTemp.getCstcpodglassesbillid().length;

		consignProcessOrderDetails = new ArrayList<ConsignProcessOrderDetailsPo>();

		SalesBasicPo sales = new SalesBasicPo();

		sales.setSsesbintransit("4");
		sales.setSsesbposid(personInfoPo.getId());

		InTransitPo inTransitPo = new InTransitPo();

		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		inTransitPo.setSseitstate("4");

		for (int i = 0; i < lenth; i++) {
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo = new ConsignProcessOrderDetailsPo();
			consignProcessOrderDetailsPo.setCstcpodorderbilld(consignProcessOrderPo.getCstcpoorderbillid());// 订单编号
			consignProcessOrderDetailsPo
					.setCstcpodglassesbillid(consignProcessOrderDetailsTemp
							.getCstcpodglassesbillid()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodexpecteddate(consignProcessOrderDetailsTemp
							.getCstcpodexpecteddate()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodordertype(consignProcessOrderDetailsTemp
							.getCstcpodordertype()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodcustomerid(consignProcessOrderDetailsTemp
							.getCstcpodcustomerid()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodcustomername(consignProcessOrderDetailsTemp
							.getCstcpodcustomername()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodbilltype(consignProcessOrderPo
							.getCstcpoordergoodscategory());
			consignProcessOrderDetailsPo
					.setCstcpodglassflag(consignProcessOrderDetailsTemp
							.getCstcpodglassflag()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodgoodsid(consignProcessOrderDetailsTemp
							.getCstcpodgoodsid()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodballglass(consignProcessOrderDetailsTemp
							.getCstcpodballglass()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodpostglass(consignProcessOrderDetailsTemp
							.getCstcpodpostglass()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodaxes(consignProcessOrderDetailsTemp
							.getCstcpodaxes()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodadd(consignProcessOrderDetailsTemp
							.getCstcpodadd()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodarriseglass(consignProcessOrderDetailsTemp
							.getCstcpodarriseglass()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodbasis(consignProcessOrderDetailsTemp
							.getCstcpodbasis()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodeyecurvature(consignProcessOrderDetailsTemp
							.getCstcpodeyecurvature()[i]);
			consignProcessOrderDetailsPo
					.setCstcpoddiameter(consignProcessOrderDetailsTemp
							.getCstcpoddiameter()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodarriveddate(consignProcessOrderDetailsTemp
							.getCstcpodexpecteddate()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodrequirement(consignProcessOrderDetailsTemp
							.getCstcpodrequirement()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodnum(consignProcessOrderDetailsTemp
							.getCstcpodnum()[i]);
			consignProcessOrderDetailsPo
			.setCstcpoddragstype(consignProcessOrderDetailsTemp
					.getCstcpoddragstype()[i]);
			consignProcessOrderDetailsPo.setCstcpodstate("0");

			consignProcessOrderDetailsPo
			.setCstcpodsalesbillid(consignProcessOrderDetailsTemp
							.getCstcpodsalesbillid()[i]);
			
			consignProcessOrderDetailsPo
			.setCstcpodinter(consignProcessOrderDetailsTemp
							.getCstcpodinter()[i]);
			consignProcessOrderDetailsPo
			.setCstcpodinterdistance(consignProcessOrderDetailsTemp
							.getCstcpodinterdistance()[i]);
			
			consignProcessOrderDetailsPo.setCstcpodsalesid(consignProcessOrderDetailsTemp.getCstcpodsalesid()[i]);

			// 修改内部订单在途
			// if ("N"
			// .equals(consignProcessOrderDetailsTemp
			// .getCstcpodordertype()[i])) {
			// sales.setSsesbsalesid(consignProcessOrderDetailsTemp
			// .getCstcpodglassesbillid()[i]);
			//
			// inTransitPo.setSseitsalesid(sales.getSsesbsalesid());
			// }

			consignProcessOrderDetails.add(consignProcessOrderDetailsPo);
		}

		String errorsalesid = "以下销售单号：\\n";
		String errortype = "";
		for(int i=0; i < consignProcessOrderDetails.size(); i++){
			int istake = billKeyMgr.selectOrdersForSalesBill(consignProcessOrderDetails.get(i).getCstcpodglassesbillid());
			if(istake > 0){
				errorsalesid = errorsalesid + consignProcessOrderDetails.get(i).getCstcpodglassesbillid() + "\\n";
				errortype = "1";
			}
			
			istake = billKeyMgr.selectProcurementOrderForType("4",consignProcessOrderDetails.get(i).getCstcpodglassesbillid());
			if(istake > 0){
				errorsalesid = errorsalesid + consignProcessOrderDetails.get(i).getCstcpodglassesbillid() + "\\n";
				errortype = "1";
			}
			
			istake = billKeyMgr.selectProcurementOrderForType("14",consignProcessOrderDetails.get(i).getCstcpodglassesbillid());
			if(istake > 0){
				errorsalesid = errorsalesid + consignProcessOrderDetails.get(i).getCstcpodglassesbillid() + "\\n";
				errortype = "1";
			}
		}
		if(errortype.equals("1")){
			this.clearMessages();
			this.addActionMessage(errorsalesid+"已创建委外订单，不能进行重复操作或已退款！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		consignProcessOrderMgr.insertConsignProcessOrder(consignProcessOrderPo,
				consignProcessOrderDetails, sales, inTransitPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));


		String url = "''initConsignProcessOrderView.action?hid={0}''";
		List<String> params = new ArrayList<String>();
		params.add(consignProcessOrderPo.getCstcpoorderbillid());

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);

		return SUCCESS;
	}

	/**
	 * 查询委外订单页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initConsignProcessOrderUpdate() {
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
		consignProcessOrderPo = new ConsignProcessOrderPo();
		consignProcessOrderPo.setCstcpoorderbillid(request.getParameter("hid"));
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo = new ConsignProcessOrderDetailsPo();
		consignProcessOrderDetailsPo.setCstcpodorderbilld(consignProcessOrderPo.getCstcpoorderbillid());
		consignProcessOrderPo = consignProcessOrderMgr.getConsignProcessOrder(consignProcessOrderPo);
		consignProcessOrderDetails = consignProcessOrderMgr.getConsignProcessOrderDetailsList(consignProcessOrderDetailsPo);
		
		return SUCCESS;
	}

	/**
	 * 查询委外订单页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateConsignProcessOrder() {
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

		if ("1".equals(request.getParameter("stateFlag"))) {
			consignProcessOrderPo.setCstcpoauditstate("1");
			consignProcessOrderPo.setCstcpoauditperson(((PersonInfoPo) session
					.get("person")).getId());
		} else {
			consignProcessOrderPo.setCstcpoauditstate("0");
		}
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent(consignProcessOrderPo.getCstcpoorderbillid());
		int lenth = consignProcessOrderDetailsTemp.getCstcpodglassesbillid().length;

		consignProcessOrderDetails = new ArrayList<ConsignProcessOrderDetailsPo>();

		SalesBasicPo sales = new SalesBasicPo();

		sales.setSsesbintransit("4");
		sales.setSsesbposid(personInfoPo.getId());

		InTransitPo inTransitPo = new InTransitPo();
		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		inTransitPo.setSseitstate("4");

		for (int i = 0; i < lenth; i++) {
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo = new ConsignProcessOrderDetailsPo();
			consignProcessOrderDetailsPo
					.setCstcpodorderbilld(consignProcessOrderPo
							.getCstcpoorderbillid());// 订单编号
			consignProcessOrderDetailsPo
					.setCstcpodglassesbillid(consignProcessOrderDetailsTemp
							.getCstcpodglassesbillid()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodexpecteddate(consignProcessOrderDetailsTemp
							.getCstcpodexpecteddate()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodordertype(consignProcessOrderDetailsTemp
							.getCstcpodordertype()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodcustomerid(consignProcessOrderDetailsTemp
							.getCstcpodcustomerid()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodcustomername(consignProcessOrderDetailsTemp
							.getCstcpodcustomername()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodbilltype(consignProcessOrderPo
							.getCstcpoordergoodscategory());
			consignProcessOrderDetailsPo
					.setCstcpodglassflag(consignProcessOrderDetailsTemp
							.getCstcpodglassflag()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodgoodsid(consignProcessOrderDetailsTemp
							.getCstcpodgoodsid()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodballglass(consignProcessOrderDetailsTemp
							.getCstcpodballglass()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodpostglass(consignProcessOrderDetailsTemp
							.getCstcpodpostglass()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodaxes(consignProcessOrderDetailsTemp
							.getCstcpodaxes()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodadd(consignProcessOrderDetailsTemp
							.getCstcpodadd()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodarriseglass(consignProcessOrderDetailsTemp
							.getCstcpodarriseglass()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodbasis(consignProcessOrderDetailsTemp
							.getCstcpodbasis()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodeyecurvature(consignProcessOrderDetailsTemp
							.getCstcpodeyecurvature()[i]);
			consignProcessOrderDetailsPo
					.setCstcpoddiameter(consignProcessOrderDetailsTemp
							.getCstcpoddiameter()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodarriveddate(consignProcessOrderDetailsTemp
							.getCstcpodexpecteddate()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodrequirement(consignProcessOrderDetailsTemp
							.getCstcpodrequirement()[i]);
			consignProcessOrderDetailsPo
					.setCstcpodnum(consignProcessOrderDetailsTemp
							.getCstcpodnum()[i]);
			consignProcessOrderDetailsPo
			.setCstcpoddragstype(consignProcessOrderDetailsTemp
					.getCstcpoddragstype()[i]);
			consignProcessOrderDetailsPo.setCstcpodstate("0");

			consignProcessOrderDetailsPo
			.setCstcpodsalesbillid(consignProcessOrderDetailsTemp
							.getCstcpodsalesbillid()[i]);

			consignProcessOrderDetailsPo
			.setCstcpodsalesid(consignProcessOrderDetailsTemp
							.getCstcpodsalesid()[i]);
			
			consignProcessOrderDetailsPo
			.setCstcpodid(consignProcessOrderDetailsTemp
							.getCstcpodid()[i]);
			
			consignProcessOrderDetailsPo
			.setCstcpodinter(consignProcessOrderDetailsTemp
							.getCstcpodinter()[i]);
			consignProcessOrderDetailsPo
			.setCstcpodinterdistance(consignProcessOrderDetailsTemp
							.getCstcpodinterdistance()[i]);
			consignProcessOrderDetails.add(consignProcessOrderDetailsPo);
		}

		String errorsalesid = "以下销售单号：\\n";
		String errortype = "";
		for(int i=0; i < consignProcessOrderDetails.size(); i++){
			int istake = billKeyMgr.selectOrdersForSalesBill(consignProcessOrderDetails.get(i).getCstcpodglassesbillid());
			if(Utility.getName(consignProcessOrderDetails.get(i).getCstcpodid()).equals("") && istake > 0){
				errorsalesid = errorsalesid + consignProcessOrderDetails.get(i).getCstcpodglassesbillid() + "\\n";
				errortype = "1";
			}
			
			istake = billKeyMgr.selectProcurementOrderForType("4",consignProcessOrderDetails.get(i).getCstcpodglassesbillid());
			if(istake > 0){
				errorsalesid = errorsalesid + consignProcessOrderDetails.get(i).getCstcpodglassesbillid() + "\\n";
				errortype = "1";
			}
			
			istake = billKeyMgr.selectProcurementOrderForType("14",consignProcessOrderDetails.get(i).getCstcpodglassesbillid());
			if(istake > 0){
				errorsalesid = errorsalesid + consignProcessOrderDetails.get(i).getCstcpodglassesbillid() + "\\n";
				errortype = "1";
			}
		}
		if(errortype.equals("1")){
			this.clearMessages();
			this.addActionMessage(errorsalesid+"已创建委外订单，不能进行重复操作或已退款！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		consignProcessOrderMgr.updateConsignProcessOrder(consignProcessOrderPo,
				consignProcessOrderDetails, sales, inTransitPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
		String url = "''initConsignProcessOrderView.action?hid={0}''";
		List<String> params = new ArrayList<String>();
		params.add(consignProcessOrderPo.getCstcpoorderbillid());

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);


		return SUCCESS;
	}

	/**
	 * 删除页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initConsignProcessOrderDelete() throws Exception {
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
		consignProcessOrderPo = new ConsignProcessOrderPo();
		consignProcessOrderPo.setCstcpoorderbillid(request.getParameter("hid"));

		ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo = new ConsignProcessOrderDetailsPo();
		consignProcessOrderDetailsPo.setCstcpodorderbilld(consignProcessOrderPo
				.getCstcpoorderbillid());
		consignProcessOrderPo = consignProcessOrderMgr
				.getConsignProcessOrder(consignProcessOrderPo);

		return SUCCESS;
	}

	/**
	 * 删除订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteConsignProcessOrder() throws Exception {
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
		consignProcessOrderPo = new ConsignProcessOrderPo();
		consignProcessOrderPo.setCstcpoorderbillid(request.getParameter("hid"));
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent(consignProcessOrderPo.getCstcpoorderbillid());

		consignProcessOrderMgr.delConsignProcessOrder(consignProcessOrderPo
				.getCstcpoorderbillid(),logPo);
		

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	public String initConsignProcessOrderView() throws Exception {
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

		consignProcessOrderPo = new ConsignProcessOrderPo();
		consignProcessOrderPo.setCstcpoorderbillid(request.getParameter("hid"));

		ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo = new ConsignProcessOrderDetailsPo();
		consignProcessOrderDetailsPo.setCstcpodorderbilld(consignProcessOrderPo
				.getCstcpoorderbillid());
		consignProcessOrderPo = consignProcessOrderMgr
				.getConsignProcessOrder(consignProcessOrderPo);
		consignProcessOrderDetails = consignProcessOrderMgr
				.getConsignProcessOrderDetailsList(consignProcessOrderDetailsPo);
	
		return SUCCESS;
	}

}
