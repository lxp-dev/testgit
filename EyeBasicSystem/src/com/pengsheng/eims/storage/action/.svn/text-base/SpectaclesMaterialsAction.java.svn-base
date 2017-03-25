package com.pengsheng.eims.storage.action;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.components.mgr.WindowsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.mgr.SpectaclesMaterialsMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class SpectaclesMaterialsAction extends BaseAction {

	private WindowsMgr windowsMgr;	
	private SystemParameterMgr systemParameterMgr;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private SystemParameterPo systemParameterPo;	
	private String isFirstExec;	
	private SpectaclesMaterialsMgr spectaclesMaterialsMgr;
	private FittingTemplateTypeMgr fittingTemplateTypeMgr = null;
	
	private List<WarehousePo> warehouseList;	
	private WarehouseMgr warehouseMgr;
	private List<SalesBasicPo> spectaclesMaterialsList;	
	private SalesBasicPo salesBasicPo;	
	private SalesBasicPo oDPo;	
	private SalesBasicPo oSPo;	
	private List<DepartmentsPo> departmentsList;	
	private SalesDetailPo salesDetailPo;	
	private List<SalesDetailPo> goodsInfoList;	
	private StrogeChangePo strogeChangePo;
	private PersonPermissionMgr personPermissionMgr;
	private DepartmentsMgr departmentsMgr = null;
	private BillKeyMgr billKeyMgr;
	
	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}

	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
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

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public SalesBasicPo getoDPo() {
		return oDPo;
	}

	public void setoDPo(SalesBasicPo oDPo) {
		this.oDPo = oDPo;
	}

	public SalesBasicPo getoSPo() {
		return oSPo;
	}

	public void setoSPo(SalesBasicPo oSPo) {
		this.oSPo = oSPo;
	}

	public StrogeChangePo getStrogeChangePo() {
		return strogeChangePo;
	}

	public void setStrogeChangePo(StrogeChangePo strogeChangePo) {
		this.strogeChangePo = strogeChangePo;
	}

	public List<SalesDetailPo> getGoodsInfoList() {
		return goodsInfoList;
	}

	public void setGoodsInfoList(List<SalesDetailPo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}

	public SalesDetailPo getSalesDetailPo() {
		return salesDetailPo;
	}

	public void setSalesDetailPo(SalesDetailPo salesDetailPo) {
		this.salesDetailPo = salesDetailPo;
	}

	public SpectaclesMaterialsMgr getSpectaclesMaterialsMgr() {
		return spectaclesMaterialsMgr;
	}

	public void setSpectaclesMaterialsMgr(
			SpectaclesMaterialsMgr spectaclesMaterialsMgr) {
		this.spectaclesMaterialsMgr = spectaclesMaterialsMgr;
	}

	public List<SalesBasicPo> getSpectaclesMaterialsList() {
		return spectaclesMaterialsList;
	}

	public void setSpectaclesMaterialsList(
			List<SalesBasicPo> spectaclesMaterialsList) {
		this.spectaclesMaterialsList = spectaclesMaterialsList;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}
	
	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public WindowsMgr getWindowsMgr() {
		return windowsMgr;
	}

	public void setWindowsMgr(WindowsMgr windowsMgr) {
		this.windowsMgr = windowsMgr;
	}

	/**
	 * 初始化配镜发料页面
	 * @return
	 */
	public String initSpectaclesMaterialsSel(){
		

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
		
		
		// 取得登陆人允许操作的仓位&部门 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpregid(personInfoPo1.getDepartmentID());
		deppo.setBdptype(personInfoPo1.getDepartmenttype());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}		
		departmentsList = spectaclesMaterialsMgr.getdepartment(deppo);
		// 取得登陆人允许操作的仓位&部门 End
						
		int count = windowsMgr.isEnabledInTransit("6");
		request.setAttribute("InTransitCount", count);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectSpectaclesMaterials";
		}
		return SUCCESS;
	}
	
	/**
	 * 配镜发料查询
	 * @return
	 */
	public String selectSpectaclesMaterials(){
		
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
		String departmentid = personInfoPo1.getDepartmentID();
		
		String ssesbsalesid=Utility.getName(request.getParameter("salesid"));
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("salesStartTime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("salesEndTime"));
		String ssesbpersonName=Utility.getName(request.getParameter("personName"));
		String ssesborderstype=Utility.getName(request.getParameter("orderstype"));
		String ssesbshopcode=Utility.getName(request.getParameter("shopcode"));
		String djsbm=Utility.getName(request.getParameter("djsbm"));
		
		//制造商 、品种 id及name
		String supplierID=Utility.getName(request.getParameter("supplierID"));
		String supplierName=Utility.getName(request.getParameter("supplierName"));
		String brandID=Utility.getName(request.getParameter("brandID"));
		String brandName=Utility.getName(request.getParameter("brandName"));
		String worrytype=Utility.getName(request.getParameter("worrytype"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,personInfoPo1.getDepartmentID());		
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbdepartmentid(departmentid);
		salesPo.setSsesbsalesid(ssesbsalesid);
		salesPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesPo.setSsesbpersonName(ssesbpersonName);
		salesPo.setSsesborderstype(ssesborderstype);
		salesPo.setSsesbshopcode(ssesbshopcode);
		salesPo.setSsesbdepartmenttype(personInfoPo1.getDepartmenttype());		
		salesPo.setSsesbsupplierid(supplierID);
		salesPo.setSsesbsuppliername(supplierName);
		salesPo.setSsesbbrandid(brandID);
		salesPo.setSsesbbrandname(brandName);
		salesPo.setSsesbworrytype(worrytype);
		salesPo.setDjsbm(djsbm);
		if (Utility.getName(systemParameterPo.getFspautospectaclesmaterials()).equals("2")){
			salesPo.setSsesbspectaclesmaterialsdpt(departmentid);
		}
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			salesPo.setSsesbcompanyid(personInfoPo1.getPersoncompanyid());
		}		
				
		request.setAttribute("salesid", ssesbsalesid);
		request.setAttribute("salesStartTime", ssesbsalesdatestarttime);
		request.setAttribute("salesEndTime", ssesbsalesdateendtime);
		request.setAttribute("personName", ssesbpersonName);
		request.setAttribute("orderstype", ssesborderstype);
		request.setAttribute("shopcode", ssesbshopcode);
		
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("worrytype", worrytype);
		request.setAttribute("djsbm", djsbm);
		
		// 取得登陆人允许操作的仓位&部门 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpregid(personInfoPo1.getDepartmentID());
		deppo.setBdptype(personInfoPo1.getDepartmenttype());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		departmentsList = spectaclesMaterialsMgr.getdepartment(deppo);
		// 取得登陆人允许操作的仓位&部门 End
		
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
		//总数、分页
		int count=spectaclesMaterialsMgr.getSpectaclesMaterialsCount(salesPo);
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
	    //取详细信息
	    spectaclesMaterialsList=spectaclesMaterialsMgr.selectSpectaclesMaterials(salesPo , page.getStart() , page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			spectaclesMaterialsList = null;
		}
		
		request.setAttribute("InTransitCount", windowsMgr.isEnabledInTransit("6"));	
		
		return SUCCESS;
	}
	
	/**
	 * 配镜发料查询
	 * @return
	 */
	public String selectSpectaclesMaterialsAuto(){
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String departmentid=personInfoPo1.getDepartmentID();
		
		String ssesbsalesid=Utility.getName(request.getParameter("salesid"));
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("salesStartTime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("salesEndTime"));
		String ssesbpersonName=Utility.getName(request.getParameter("personName"));
		String ssesborderstype=Utility.getName(request.getParameter("orderstype"));
		String ssesbshopcode=Utility.getName(request.getParameter("shopcode"));
		
		//制造商 、品种 id及name
		String supplierID=Utility.getName(request.getParameter("supplierID"));
		String supplierName=Utility.getName(request.getParameter("supplierName"));
		String brandID=Utility.getName(request.getParameter("brandID"));
		String brandName=Utility.getName(request.getParameter("brandName"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,personInfoPo1.getDepartmentID());		
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbdepartmentid(departmentid);
		salesPo.setSsesbsalesid(ssesbsalesid);
		salesPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesPo.setSsesbpersonName(ssesbpersonName);
		salesPo.setSsesborderstype(ssesborderstype);
		salesPo.setSsesbshopcode(ssesbshopcode);
		salesPo.setSsesbdepartmenttype(personInfoPo1.getDepartmenttype());		
		salesPo.setSsesbsupplierid(supplierID);
		salesPo.setSsesbsuppliername(supplierName);
		salesPo.setSsesbbrandid(brandID);
		salesPo.setSsesbbrandname(brandName);
		if (Utility.getName(systemParameterPo.getFspautospectaclesmaterials()).equals("2")){
			salesPo.setSsesbspectaclesmaterialsdpt(departmentid);
		}
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			salesPo.setSsesbcompanyid(personInfoPo1.getPersoncompanyid());
		}
		
		request.setAttribute("salesid", ssesbsalesid);
		request.setAttribute("salesStartTime", ssesbsalesdatestarttime);
		request.setAttribute("salesEndTime", ssesbsalesdateendtime);
		request.setAttribute("personName", ssesbpersonName);
		request.setAttribute("orderstype", ssesborderstype);
		request.setAttribute("shopcode", ssesbshopcode);
		
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);
		
		// 取得登陆人允许操作的仓位&部门 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpregid(personInfoPo1.getDepartmentID());
		deppo.setBdptype(personInfoPo1.getDepartmenttype());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		departmentsList = spectaclesMaterialsMgr.getdepartment(deppo);
		// 取得登陆人允许操作的仓位&部门 End
		
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
		//总数、分页
		int count=spectaclesMaterialsMgr.getSpectaclesMaterialsCount(salesPo);
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
	    //取详细信息
	    spectaclesMaterialsList=spectaclesMaterialsMgr.selectSpectaclesMaterials(salesPo , page.getStart() , page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			spectaclesMaterialsList = null;
		}
				
		return SUCCESS;
	}
	
	/**
	 * 初始化新增配镜发料页面
	 * @return
	 */
	public String initSpectaclesMaterialsIns(){
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
		
		String salesId=Utility.getName(request.getParameter("ssesbsalesid"));
		String hid=Utility.getName(request.getParameter("hid"));
		
		request.setAttribute("ssesbsalesid", salesId);
		request.setAttribute("hid", hid);
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbsalesid(salesId);
		
		SalesBasicPo oDBasicPo=new SalesBasicPo();
		oDBasicPo.setSsesbsalesid(salesId);
		
		SalesBasicPo oSBasicPo=new SalesBasicPo();
		oSBasicPo.setSsesbsalesid(salesId);

		// 取得登陆人允许操作的仓位&部门 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseMgr.getWarehouseAllList(deppo);
		
		SalesDetailPo salesDetailPo=new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(salesId);
		
		salesBasicPo=spectaclesMaterialsMgr.getSalesDetailInfo(salesPo);
		oDPo=spectaclesMaterialsMgr.getODDetailInfo(oDBasicPo);
		oSPo=spectaclesMaterialsMgr.getOSDetailInfo(oSBasicPo);
		
		goodsInfoList=spectaclesMaterialsMgr.selectGoodsDetailInfoes(salesDetailPo);
		
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(salesBasicPo.getSsesbshopcode());
		po = departmentsMgr.getDepartment(po);
		request.setAttribute("bdpregid",Utility.getName(po.getBdpregid()));
	
		DepartmentsPo dpo = new DepartmentsPo();
		dpo.setBdptype("2");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments2(deppo);
		
		return SUCCESS;
	}
	
	/**
	 * 新增配镜发料
	 * @return
	 */
	public String insertSpectaclesMaterials(){
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
		
		String departmentId = personInfoPo.getDepartmentID();		
		String salesId=Utility.getName(request.getParameter("salesid"));
		String[] goodsid=request.getParameterValues("goodssalesid");
		String[] stockid=request.getParameterValues("ss");
		String[] number=request.getParameterValues("ssesdnumber");
		String[] costsprive=request.getParameterValues("ssesdcostsprive");
		String[] unitprice=request.getParameterValues("ssesdunitprice");
		String[] goodsCode=request.getParameterValues("goodsItemId");
		String[] ssesdid=request.getParameterValues("ssesdid");

		if (goodsid==null){
			goodsid = new String[0];
		}
		int issend = spectaclesMaterialsMgr.selectIsSend(salesId);
		
		if(issend > 0){
			
			int count = 1;  //镜片每次发料一片
			String hid = "";
			BigDecimal sNum = null;
			BigDecimal dNum = null;
			if(goodsCode != null){
				if (goodsCode.length > 0){
					if (Utility.getName(systemParameterPo.getFspsalestype()).equals("0")){ //不允许负库存销售
						
						List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
						for (int i = 0; i < goodsCode.length; i++){   
							if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //按商品代码和商品条码及数量合并镜片
								
								BigDecimal t1 = new BigDecimal(number[i]);  //累计
								for (int j = i + 1; j < goodsCode.length; j++){
									if (goodsid[i].equals(goodsid[j]) && goodsCode[i].substring(0,18).equals(goodsCode[j].substring(0,18))){
										t1 = t1.add(new BigDecimal(number[j]));
									}
								}
								
								int tcount = 0;
								for (int k = 0; k < inventoryEntryList.size(); k++){
									if (inventoryEntryList.get(k).getCstiegoodsid().equals(goodsid[i]) && inventoryEntryList.get(k).getCstiebarcode().equals(goodsCode[i].substring(0,18))){
										tcount++;
										break;
									}
								}
								if (tcount == 0){
									InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
									inventoryEntryPo.setCstiegoodsid(goodsid[i]);
									inventoryEntryPo.setCstiebarcode(goodsCode[i]);
									inventoryEntryPo.setCstiegoodsquantity(t1.toString());
									inventoryEntryPo.setCstieoutstockid(stockid[i]);
									inventoryEntryPo.setCstiebillid(salesId);
									inventoryEntryPo.setCstieisexitsintransit("1");
									
									inventoryEntryList.add(inventoryEntryPo);
								}
								
							}
							
							if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //按商品代码和数量合并镜片
								
								BigDecimal t1 = new BigDecimal(number[i]);  //累计
								for (int j = i + 1; j < goodsCode.length; j++){
									if (goodsid[i].equals(goodsid[j])){
										t1 = t1.add(new BigDecimal(number[j]));
									}
								}
								
								int tcount = 0;
								for (int k = 0; k < inventoryEntryList.size(); k++){
									if (inventoryEntryList.get(k).getCstiegoodsid().equals(goodsid[i])){
										tcount++;
										break;
									}
								}
								if (tcount == 0){
									
									InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
									inventoryEntryPo.setCstiegoodsid(goodsid[i]);
									inventoryEntryPo.setCstiegoodsquantity(t1.toString());
									inventoryEntryPo.setCstieoutstockid(stockid[i]);
									inventoryEntryPo.setCstiebillid(salesId);
									inventoryEntryPo.setCstieisexitsintransit("1");
									
									inventoryEntryList.add(inventoryEntryPo);
								}
								
							}
						}
						
						for (int i = 0; i < inventoryEntryList.size(); i++){   //验证负库存						
							
							int goodsNums = 0;
							if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //使用条码
								goodsNums = inTransitDetailsMgr.getStorageNumByNotBatch(inventoryEntryList.get(i));
							}
							if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //不使用条码
								goodsNums = inTransitDetailsMgr.getStorageNumByGoodsID(inventoryEntryList.get(i));
							}						
							
							sNum = new BigDecimal(goodsNums);
							dNum = new BigDecimal(inventoryEntryList.get(i).getCstiegoodsquantity());
							sNum = sNum.subtract(dNum);
							
							if (sNum.intValue() < 0){
								count = 0;
								hid = ssesdid[i];
								break;
							}
							
						}
						
					}
				}
			}
			
			if (count == 0){
				this.clearMessages();
				this.addActionMessage(getText("配镜单发料失败!\\n部分商品库存不足,未能出库!"));
				
				String url = "''initSpectaclesMaterialsIns.action?ssesbsalesid={0}&moduleID={1}&hid={2}''";
				List<String> params = new ArrayList<String>();
				params.add(salesId);
				params.add(moduleID);
				params.add(hid);
				
				request.setAttribute("url", MessageFormat.format(url, params.toArray()));
				request.setAttribute("flag", GlobalConstants.UPADTE);
				
				return SUCCESS;
			}
			
			InTransitPo inTransitPo=new InTransitPo();
			inTransitPo.setSseitsalesid(salesId);
			inTransitPo.setSseitdepartment(departmentId);
			inTransitPo.setSseitcreateperson(createPerson);
			
			SalesBasicPo salesPo=new SalesBasicPo();
			salesPo.setSsesbsalesid(salesId);
			salesPo.setSsesbprocessdepartment(Utility.getName(request.getParameter("ssesbprocessdepartment")));
			
			//添加日志
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("33");    // 表示状态
			logPo.setsLogContent("配镜单："+salesPo.getSsesbsalesid()+"发料!");
	

			int istake = billKeyMgr.selectProcurementOrderForType("6",salesId);
			if(istake == 1){
				this.clearMessages();
				this.addActionMessage("该配镜单已发料，不能进行重复操作！");
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				
				return SUCCESS;
			}
			
			spectaclesMaterialsMgr.insertMaterials(systemParameterPo,inTransitPo, salesPo, goodsid, stockid,number, costsprive, unitprice, goodsCode, salesId,logPo,ssesdid);
		
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}else{
			this.clearMessages();
			this.addActionMessage("该配镜单不能发料！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
	}
	
	/**
	 * 初始化打印配镜发料单页面
	 * @return
	 */
	public String initPrintSpectaclesMaterialsBillSel(){	

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

		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdptype("2");
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}		
		departmentsList = departmentsMgr.getDepartments(deppo);
						
		int count = windowsMgr.isEnabledInTransit("6");
		request.setAttribute("InTransitCount", count);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1") && Utility.getName(permissionPo.getKeya()).equals("1")){
			this.setIsFirstExec("1");
			return "selectPrintSpectaclesMaterialsBill";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 打印配镜发料单查询
	 * @return
	 */
	public String selectPrintSpectaclesMaterialsBill(){
		
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

		String departmentid=personInfoPo.getDepartmentID();
		
		String ssesbsalesid=Utility.getName(request.getParameter("salesid"));
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("salesStartTime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("salesEndTime"));
		String ssesbpersonName=Utility.getName(request.getParameter("personName"));
		String ssesborderstype=Utility.getName(request.getParameter("orderstype"));
		String ssesbshopcode=Utility.getName(request.getParameter("shopcode"));
		String supplierID=Utility.getName(request.getParameter("supplierID"));
		String supplierName=Utility.getName(request.getParameter("supplierName"));
		String brandID=Utility.getName(request.getParameter("brandID"));
		String brandName=Utility.getName(request.getParameter("brandName"));
		String worrytype=Utility.getName(request.getParameter("worrytype"));
		String printorderby = Utility.getName(request.getParameter("printorderby"));
		String queryClassif = Utility.getName(request.getParameter("queryClassif"));
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbdepartmentid(departmentid);
		salesPo.setSsesbsalesid(ssesbsalesid);
		salesPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesPo.setSsesbpersonName(ssesbpersonName);
		salesPo.setSsesborderstype(ssesborderstype);
		salesPo.setSsesbprocessdpt(ssesbshopcode);		
		salesPo.setSsesbdepartmenttype(personInfoPo.getDepartmenttype());		
		salesPo.setSsesbsupplierid(supplierID);
		salesPo.setSsesbsuppliername(supplierName);
		salesPo.setSsesbbrandid(brandID);
		salesPo.setSsesbbrandname(brandName);
		salesPo.setSsesbworrytype(worrytype);
		salesPo.setSsesborderby(printorderby.equals("") ? "1" : printorderby);
		salesPo.setSsesbqueryclassif(queryClassif);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			salesPo.setSsesbcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		request.setAttribute("salesid", ssesbsalesid);
		request.setAttribute("salesStartTime", ssesbsalesdatestarttime);
		request.setAttribute("salesEndTime", ssesbsalesdateendtime);
		request.setAttribute("personName", ssesbpersonName);
		request.setAttribute("orderstype", ssesborderstype);
		request.setAttribute("shopcode", ssesbshopcode);
		request.setAttribute("printPerson", personInfoPo.getId());
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("worrytype", worrytype);
		request.setAttribute("printorderby", printorderby);
		request.setAttribute("queryClassif", queryClassif);
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdptype("2");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);
		
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
		//总数、分页
		int count=spectaclesMaterialsMgr.getPrintSpectaclesMaterialsBillCount(salesPo);
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
	    //取详细信息
	    spectaclesMaterialsList=spectaclesMaterialsMgr.selectPrintSpectaclesMaterialsBill(salesPo , page.getStart() , page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			spectaclesMaterialsList = null;
		}
		
		request.setAttribute("InTransitCount", windowsMgr.isEnabledInTransit("6"));	
		
		//获得打印结算单信息----------------------------
		String actionTypeID = "39";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------
		
		return SUCCESS;
	}
	
	/**
	 * 初始化批量发料
	 * @return
	 */
	public String initSpectaclesMaterialsBatch(){
		
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
	 * 批量发料
	 * @return
	 */
	public String insertSpectaclesMaterialsBatch(){
		
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
		String departmentId = personInfoPo.getDepartmentID();
		spectaclesMaterialsList = new ArrayList<SalesBasicPo>();
		
		String salesbillid = Utility.getName(request.getParameter("salesid"));
		
		String[] goodsid = null ;
		String[] stockid = null;
		String[] number = null;
		String[] goodsCode = null;
        String msg = "";
		
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("33");    // 表示状态
		logPo.setsLogContent("配镜单批量发料: ");
		
		String[] salesidarray = null;
		if (salesbillid.indexOf(",") >= 0){
			salesidarray = salesbillid.split(",");
			
			for (int v = 0; v < salesidarray.length; v++){
				SalesBasicPo spo = new SalesBasicPo();
				spo.setSsesbsalesid(salesidarray[v]);
				
				SalesBasicPo bpo = spectaclesMaterialsMgr.getSalesDetailInfo(spo);
				spo.setSsesbshopcode(bpo.getSsesbshopcode());
				
				DepartmentsPo po = new DepartmentsPo();
				po.setBdpdepartmentid(spo.getSsesbshopcode());
				po = departmentsMgr.getDepartment(po);
				spo.setSsesbprocessdepartment(Utility.getName(po.getBdpregid()));				
				
				goodsInfoList = spectaclesMaterialsMgr.selectGoodsDetailInfo(spo);
				
				int issend = spectaclesMaterialsMgr.selectIsSend(salesidarray[v]);
				if(issend > 0){
					
					int goodscount = goodsInfoList.size();
					
					goodsid = new String[goodscount] ;
					stockid = new String[goodscount];
					number = new String[goodscount];
					goodsCode = new String[goodscount];
					
					for (int n = 0; n < goodscount; n++){
						goodsid[n] = goodsInfoList.get(n).getSsesdsalesitemid();
						stockid[n] = goodsInfoList.get(n).getSsesdstockid();
						number[n] = goodsInfoList.get(n).getSsesdnumber();
						goodsCode[n] = goodsInfoList.get(n).getGoodscode();
					}
					
					int count = 1;  //镜片每次发料一片
					String hid = "";
					BigDecimal sNum = null;
					BigDecimal dNum = null;
					if(goodsCode != null){
						if (goodsCode.length > 0){
							if (Utility.getName(systemParameterPo.getFspsalestype()).equals("0")){ //不允许负库存销售
								
								List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
								for (int i = 0; i < goodsCode.length; i++){   
									if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //按商品代码和商品条码及数量合并镜片
										
										BigDecimal t1 = new BigDecimal(number[i]);  //累计
										for (int j = i + 1; j < goodsCode.length; j++){
											if (goodsid[i].equals(goodsid[j]) && goodsCode[i].substring(0,18).equals(goodsCode[j].substring(0,18))){
												t1 = t1.add(new BigDecimal(number[j]));
											}
										}
										
										int tcount = 0;
										for (int k = 0; k < inventoryEntryList.size(); k++){
											if (inventoryEntryList.get(k).getCstiegoodsid().equals(goodsid[i]) && inventoryEntryList.get(k).getCstiebarcode().equals(goodsCode[i].substring(0,18))){
												tcount++;
												break;
											}
										}
										if (tcount == 0){
											InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
											inventoryEntryPo.setCstiegoodsid(goodsid[i]);
											inventoryEntryPo.setCstiebarcode(goodsCode[i]);
											inventoryEntryPo.setCstiegoodsquantity(t1.toString());
											inventoryEntryPo.setCstieoutstockid(stockid[i]);
											inventoryEntryPo.setCstiebillid(salesidarray[v]);
											inventoryEntryPo.setCstieisexitsintransit("1");
											
											inventoryEntryList.add(inventoryEntryPo);
										}
										
									}
									
									if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //按商品代码和数量合并镜片
										
										BigDecimal t1 = new BigDecimal(number[i]);  //累计
										for (int j = i + 1; j < goodsCode.length; j++){
											if (goodsid[i].equals(goodsid[j])){
												t1 = t1.add(new BigDecimal(number[j]));
											}
										}
										
										int tcount = 0;
										for (int k = 0; k < inventoryEntryList.size(); k++){
											if (inventoryEntryList.get(k).getCstiegoodsid().equals(goodsid[i])){
												tcount++;
												break;
											}
										}
										if (tcount == 0){
											
											InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
											inventoryEntryPo.setCstiegoodsid(goodsid[i]);
											inventoryEntryPo.setCstiegoodsquantity(t1.toString());
											inventoryEntryPo.setCstieoutstockid(stockid[i]);
											inventoryEntryPo.setCstiebillid(salesidarray[v]);
											inventoryEntryPo.setCstieisexitsintransit("1");
											
											inventoryEntryList.add(inventoryEntryPo);
										}
										
									}
								}
								
								for (int i = 0; i < inventoryEntryList.size(); i++){   //验证负库存						
									
									int goodsNums = 0;
									if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //使用条码
										goodsNums = inTransitDetailsMgr.getStorageNumByNotBatch(inventoryEntryList.get(i));
									}
									if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //不使用条码
										goodsNums = inTransitDetailsMgr.getStorageNumByGoodsID(inventoryEntryList.get(i));
									}						
									
									sNum = new BigDecimal(goodsNums);
									dNum = new BigDecimal(inventoryEntryList.get(i).getCstiegoodsquantity());
									sNum = sNum.subtract(dNum);
									
									if (sNum.intValue() < 0){
										count = 0;
//										hid = ssesdid[i];
										break;
									}
									
								}
								
							}
						}
					}
					
					boolean flag = true;
					if (count == 0){				
						msg = "部分配镜单发料失败!\\n商品库存不足,未能出库!";
						flag = false;
					}				
			
					SalesBasicPo salesPo=new SalesBasicPo();
					salesPo.setSsesbsalesid(salesidarray[v]);
					salesPo.setSsesbprocessdepartment(Utility.getName(request.getParameter("ssesbprocessdepartment")));

					int istake = billKeyMgr.selectProcurementOrderForType("6",salesidarray[v]);
					if(istake == 1){			
						msg = "部分配镜单已发料，不能进行重复操作！";	
						flag = false;
					}
					
					if (flag){
						spectaclesMaterialsList.add(spo);
					}
                    
				}else{
					msg = "部分配镜单不能进行发料操作！";
				}
				
			}
			
			InTransitPo inTransitPo=new InTransitPo();
			inTransitPo.setSseitdepartment(departmentId);
			inTransitPo.setSseitcreateperson(createPerson);
			
			if (spectaclesMaterialsList.size() > 0){
				spectaclesMaterialsMgr.insertMaterialsBatch(systemParameterPo,inTransitPo,spectaclesMaterialsList, logPo);
				msg = msg.equals("") ? "所选配镜单全部发料成功!" : "所选部分配镜单发料成功!";
			}

		}
		
		this.clearMessages();
		this.addActionMessage(msg);
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;

	}

	public FittingTemplateTypeMgr getFittingTemplateTypeMgr() {
		return fittingTemplateTypeMgr;
	}

	public void setFittingTemplateTypeMgr(
			FittingTemplateTypeMgr fittingTemplateTypeMgr) {
		this.fittingTemplateTypeMgr = fittingTemplateTypeMgr;
	}
	
}
