package com.pengsheng.eims.storage.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.text.MessageFormat;

import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.StatusPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class AllocationAction extends BaseAction{ 
	
	private AllocationPo allocationPo;
	private SystemParameterMgr systemParameterMgr;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private SystemParameterPo systemParameterPo;	
	private AllocationMgr allocationMgr;	
	private WarehouseMgr warehouseMgr;	
	private DepartmentsMgr departmentsMgr;	
	private List<WarehousePo> inwarehouselist;	
	private List<WarehousePo> outwarehouselist;	
	private List<WarehousePo> inwarehouselist1;
	private String isFirstExec;
	private List<WarehousePo> outwarehouselist1;	
	private GoodsInfoTempPo goodsInfoTempPo;	
	private List<AllocationEntryPo> allocationEntryList;	
	private List<DepartmentsPo> departmentsList;	
	private List<AllocationPo> allocationList;	
	private List<DepartmentsPo> indepartmentsList;	
	private List<DepartmentsPo> indepartmentsList1;
	private List<AllocationBarcodePo> allocationBarcodeLists;	
	private PersonPermissionMgr personPermissionMgr;	
	private StatusPo statusPo;	
	private WarehouseConfigurationPo warehouseConfigurationPo;
	private PersonInfoMgr personInfoMgr;
	private List<GoodsCategoryPo> goodsCategorys;
	private VarietyMgr varietyMgr;
	private FquartzSwitchPo fquartzSwitchPo;
	private ReportQuartzMgr reportQuartzMgr;
	
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

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
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
	
	public List<WarehousePo> getInwarehouselist1() {
		return inwarehouselist1;
	}

	public void setInwarehouselist1(List<WarehousePo> inwarehouselist1) {
		this.inwarehouselist1 = inwarehouselist1;
	}

	public List<WarehousePo> getOutwarehouselist1() {
		return outwarehouselist1;
	}

	public void setOutwarehouselist1(List<WarehousePo> outwarehouselist1) {
		this.outwarehouselist1 = outwarehouselist1;
	}
	public List<DepartmentsPo> getIndepartmentsList1() {
		return indepartmentsList1;
	}

	public void setIndepartmentsList1(List<DepartmentsPo> indepartmentsList1) {
		this.indepartmentsList1 = indepartmentsList1;
	}

	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}

	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
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
	public List<AllocationBarcodePo> getAllocationBarcodeLists() {
		return allocationBarcodeLists;
	}
	public void setAllocationBarcodeLists(
			List<AllocationBarcodePo> allocationBarcodeLists) {
		this.allocationBarcodeLists = allocationBarcodeLists;
	}		
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}
	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}
	public List<AllocationPo> getAllocationList() {
		return allocationList;
	}
	public void setAllocationList(List<AllocationPo> allocationList) {
		this.allocationList = allocationList;
	}
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}
	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}
	public List<AllocationEntryPo> getAllocationEntryList() {
		return allocationEntryList;
	}
	public void setAllocationEntryList(List<AllocationEntryPo> allocationEntryList) {
		this.allocationEntryList = allocationEntryList;
	}
	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}
	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}
	public AllocationPo getAllocationPo() {
		return allocationPo;
	}
	public void setAllocationPo(AllocationPo allocationPo) {
		this.allocationPo = allocationPo;
	}
	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}
	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
	}	
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	public List<WarehousePo> getInwarehouselist() {
		return inwarehouselist;
	}
	public void setInwarehouselist(List<WarehousePo> inwarehouselist) {
		this.inwarehouselist = inwarehouselist;
	}
	public List<WarehousePo> getOutwarehouselist() {
		return outwarehouselist;
	}
	public void setOutwarehouselist(List<WarehousePo> outwarehouselist) {
		this.outwarehouselist = outwarehouselist;
	}
	public List<DepartmentsPo> getIndepartmentsList() {
		return indepartmentsList;
	}
	public void setIndepartmentsList(List<DepartmentsPo> indepartmentsList) {
		this.indepartmentsList = indepartmentsList;
	}
	/**
	 * 查询商品调拨初始化
	 */
	public String initAllocationSel() {

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
		
		goodsCategorys = varietyMgr.getGoodsCategorys();

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		DepartmentsPo po = new DepartmentsPo();		
		if (personInfoPo1.getDepartmenttype().equals("1") || personInfoPo1.getDepartmenttype().equals("2")){			
			po.setBdpdepartmentid(personInfoPo1.getDepartmentID());	
		}
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
		    po.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}

		departmentsList = departmentsMgr.getDepartmentsList(po);
		
		if (departmentsList == null){
			departmentsList = new ArrayList<DepartmentsPo>();
		}
		
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				departmentsList.add(dpo);
			}
		}
		
		indepartmentsList1 = departmentsList;
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("allactionflag","1"); // 负调拨标识位	
			
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selAlloca";
		}
		
		return SUCCESS;
	}	
	/**
	 * 商品调拨查询
	 */
	public String selAllocation() {
		
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
		request.setAttribute("personInfoPo1", personInfoPo1);
		/** ********************** 权限设置 ***************************** */
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		String billID=Utility.getName(request.getParameter("billID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String departmentIDout = Utility.getName(request.getParameter("departmentIDout"));
		String auditState=Utility.getName(request.getParameter("auditState"));
		String consignState = Utility.getName(request.getParameter("consignState"));
		String cshaacreateperson=Utility.getName(request.getParameter("createPersonID"));//制单人
		String cshaaauditperson=Utility.getName(request.getParameter("auditPersonID"));//审核人
		String cshaaconsignee=Utility.getName(request.getParameter("consigneePersonID"));//收货人		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName=Utility.getName(request.getParameter("supplierName"));
		String brandName=Utility.getName(request.getParameter("brandName"));
		String brandID=Utility.getName(request.getParameter("brandID"));
		String goodsName=Utility.getName(request.getParameter("goodsName"));
		String remark=Utility.getName(request.getParameter("remark"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String statusBillID = Utility.getName(request.getParameter("statusBillID"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String allactionflag = Utility.getName(request.getParameter("allactionflag"));   // 负调拨标识位	
		String departmentname = Utility.getName(request.getParameter("departmentname"));
		String printtype = Utility.getName(request.getParameter("printtype"));
		
		request.setAttribute("departmentname", departmentname);
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("statusBillID", statusBillID);
		request.setAttribute("allactionflag",allactionflag.equals("") ? "1" : allactionflag); // 负调拨标识位	
		request.setAttribute("printtype",printtype);
		
		String autoAllocationFlag=Utility.getName(request.getParameter("autoAllocationFlag"));
		if (autoAllocationFlag.equals("")){
			autoAllocationFlag = "1";
		}
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		deppo.setBdptype(personInfoPo1.getDepartmenttype());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		DepartmentsPo po = new DepartmentsPo();		
		if (!personInfoPo1.getDepartmenttype().equals("3")){			
			po.setBdpdepartmentid(personInfoPo1.getDepartmentID());	
		}
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
		    po.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		
		// 接收部门
		departmentsList = departmentsMgr.getDepartmentsList(po);
		
		if (departmentsList == null){
			departmentsList = new ArrayList<DepartmentsPo>();
		}
		
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				departmentsList.add(dpo);
			}
		}	
		
		// 发出部门
		indepartmentsList1 = departmentsList;
		
		AllocationPo allocationPo = new AllocationPo();
		allocationPo.setCshaacategoryid(goodscategoryID);
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaindepartmentid(departmentID);
		allocationPo.setCshaaoutdepartmentid(departmentIDout);
		allocationPo.setCshaastartTime(startTime);
		allocationPo.setCshaaendTime(endTime);
		allocationPo.setCshaaauditstate(auditState);
		allocationPo.setCshaaconsignstate(consignState);		
		allocationPo.setCshaacreateperson(cshaacreateperson);
		allocationPo.setCshaaauditperson(cshaaauditperson);
		allocationPo.setCshaaconsignee(cshaaconsignee);
		allocationPo.setCshaaflag(allactionflag);//正调拨
		allocationPo.setChaasupplier(supplierID);//制造商代码	
		allocationPo.setChaabrand(brandID);//品种代码
		allocationPo.setChaagoodsname(goodsName);//商品名称	
		allocationPo.setCshaaremark(remark);
		allocationPo.setChaaautoflag(autoAllocationFlag);
		allocationPo.setChaagoodsid(goodsID);//商品名称	
		allocationPo.setCshaabillassociation(statusBillID);
		allocationPo.setCshaaindepartmentname(departmentname);
		allocationPo.setCshaaprinttype(printtype);
		allocationPo.setCshaaindptcompanyid(personInfoPo1.getPersoncompanyid());   // 所属公司
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			allocationPo.setChaaautoflag("1");
			allocationPo.setCshaaflag("1");
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
		
		int count=allocationMgr.getAllocationCount(allocationPo,deppo);
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
		    allocationList=allocationMgr.getAllocationList(allocationPo,deppo,page.getStart(),page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			allocationList = null;
		}
		
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("billID",billID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("auditState",auditState);
		request.setAttribute("consignState",consignState);
		request.setAttribute("departmenttype", Utility.getName(request.getParameter("departmenttype")).equals("") ? personInfoPo1.getDepartmenttype() : Utility.getName(request.getParameter("departmenttype")));
		request.setAttribute("selcreatePersonID",cshaacreateperson);
		request.setAttribute("selauditPersonID",cshaaauditperson);
		request.setAttribute("selconsigneePersonID",cshaaconsignee);
		request.setAttribute("auditPersonName", request.getParameter("auditPersonName"));
		request.setAttribute("createPersonName",request.getParameter("createPersonName") );
		request.setAttribute("consigneePersonName",request.getParameter("consigneePersonName") );		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("departmentIDout",departmentIDout);
		request.setAttribute("departmentIDFlag",personInfoPo1.getDepartmentID());
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("remark",remark);
		request.setAttribute("autoAllocationFlag",autoAllocationFlag);
		
		return SUCCESS;
	}
	/**
	 * 新增商品调拨初始化
	 */
	public String initAllocationInsert() {
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
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		String billID="ALL"+GenerateNumber.getInstance().getGenerageNumber();
		allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaoutdepartmentid(personInfoPo.getDepartmentID());
		allocationPo.setCshaaoutdepartmentname(personInfoPo.getBdpdepartmentname());
		allocationPo.setCshaaoutdepartmentid(personInfoPo.getDepartmentID());
		allocationPo.setCshaaflag(Utility.getName(request.getParameter("allactionflag")));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !personInfoPo.getDepartmenttype().equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}		
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);		
		////默认仓位////		
				
		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 总公司获取所有已启用的部门，分公司获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}
		
		outwarehouselist = warehouseMgr.getWarehouseForSalesList(personInfoPo.getDepartmentID());		
		inwarehouselist = warehouseMgr.getWarehouseForAllocationList(deppo);

		if (Utility.getName(personInfoPo.getDepartmenttype()).equals("1") && outwarehouselist.size() > 0){
			warehouseConfigurationPo.setBwcstockid9(outwarehouselist.get(0).getBwhid());
		}	
		
		return SUCCESS;
	}	
	/**
	 * 商品调拨新增
	 */
	public String insertAllocation() {
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
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
		    deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////		
				
		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}
		
		outwarehouselist=warehouseMgr.getWarehouseForSalesList(personInfoPo.getDepartmentID());			
		inwarehouselist=warehouseMgr.getWarehouseForAllocationList(deppo);

        if("".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
        	allocationPo.setCshaaauditstate("0");
        }
        
        List<PersonInfoPo> personInfoList=null;
        SmsLertsPo smsLertsPo=new SmsLertsPo();
        PersonInfoPo tempPersonInfoPo = new PersonInfoPo();
    	tempPersonInfoPo.setAllocationFlag("1");
    	WarehousePo tempWarehousePo = new WarehousePo();
    	tempWarehousePo.setBwhid(allocationPo.getCshaaoutstockid());
    	DepartmentsPo departmentsPo=warehouseMgr.getDepartments(tempWarehousePo);
    	
    	WarehousePo inWarehousePo = new WarehousePo();
    	inWarehousePo.setBwhid(allocationPo.getCshaainstockid());
    	WarehousePo outWarehousePo = new WarehousePo();
    	outWarehousePo.setBwhid(allocationPo.getCshaaoutstockid());
    	outWarehousePo=warehouseMgr.getWarehouse(outWarehousePo);
    	inWarehousePo=warehouseMgr.getWarehouse(inWarehousePo);
    	
    	smsLertsPo.setCstslcontent("<a href='initAllocationUpdate.action?hid="+allocationPo.getCshaabillid()+"&smsFlag=1'>点击查看详情</a>");
    	smsLertsPo.setCstsltitle(inWarehousePo.getBwhwarehouseName()+"向"+outWarehousePo.getBwhwarehouseName()+"申请调拨,调拨单号!"+allocationPo.getCshaabillid());
    	if(((PersonInfoPo)session.get("person")).getDepartmentID().equals(departmentsPo.getBdpdepartmentid())&&"1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){ //如果出仓时自己本门店,并审核，往收入仓位关联部门
    		tempWarehousePo.setBwhid(allocationPo.getCshaainstockid());
    		departmentsPo=warehouseMgr.getDepartments(tempWarehousePo);
    		smsLertsPo.setCstslcontent("<a href='allocationDetails.action?hid="+allocationPo.getCshaabillid()+"&smsFlag=1'>点击查看详情</a>");
    		smsLertsPo.setCstsltitle(outWarehousePo.getBwhwarehouseName()+"给"+inWarehousePo.getBwhwarehouseName()+"做一调拨单号!"+allocationPo.getCshaabillid());
    	}
    	
    	
    	tempPersonInfoPo.setDepartmentID(departmentsPo.getBdpdepartmentid());
    	
    	personInfoList = personInfoMgr.getPersonInfos(tempPersonInfoPo, 0, personInfoMgr.getPersoninfosCount(tempPersonInfoPo));
    	 
    	if(((PersonInfoPo)session.get("person")).getDepartmentID().equals(departmentsPo.getBdpdepartmentid())&&"0".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
    		 personInfoList=null;
     	}
    	    	
    	smsLertsPo.setCstslsendperson(((PersonInfoPo)session.get("person")).getId());
    	smsLertsPo.setCstslsenddepartment(((PersonInfoPo)session.get("person")).getDepartmentID());
    	
        if("1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
        	allocationPo.setCshaaauditperson(allocationPo.getCshaacreateperson());
        	allocationPo.setCshaafinanceauditperson(createPerson);
        }
        
        WarehousePo warehousePo=new WarehousePo();
        warehousePo.setBwhid(allocationPo.getCshaainstockid());
                
		int lenth=goodsInfoTempPo.getGoodsid().length;
		allocationEntryList=new ArrayList<AllocationEntryPo>();
		for(int i=0;i<lenth;i++){
			AllocationEntryPo allocationEntryPo=new AllocationEntryPo();
			allocationEntryPo.setCshaaebillid(allocationPo.getCshaabillid());
			allocationEntryPo.setCshaaegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			allocationEntryPo.setCshaaoutstockid(allocationPo.getCshaaoutstockid());
			allocationEntryPo.setCshaainstockid(allocationPo.getCshaainstockid());
			allocationEntryPo.setCshaaegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			allocationEntryPo.setCshaaeallocationquantity(goodsInfoTempPo.getGoodsquantity()!=null?goodsInfoTempPo.getGoodsquantity()[i]:"0");
			allocationEntryPo.setCshaaegoodsBarCode(goodsInfoTempPo.getGoodsbarcode()!=null?goodsInfoTempPo.getGoodsbarcode()[i]:""); // 新增时加入商品条码
			allocationEntryPo.setCshaaGoodsBarCode(goodsInfoTempPo.getGoodsbarcode()!=null?goodsInfoTempPo.getGoodsbarcode()[i]:""); // 新增时加入商品条码
			allocationEntryPo.setCshaaerequirementquantity(Utility.getName(goodsInfoTempPo.getCshaaerequirequantity()[i]));
			allocationEntryPo.setCshaaespec(goodsInfoTempPo.getSpec()[i]);
			allocationEntryPo.setCshaaemaxquantity(goodsInfoTempPo.getCshaaemaxquantity()[i]);
			
			allocationEntryPo.setCshaaeamounttype(Utility.getName(allocationPo.getCshaaamounttype()));
			
			if (Utility.getName(allocationPo.getCshaaamounttype()).equals("1")){
				allocationEntryPo.setCshaaecostprice(Utility.getName(goodsInfoTempPo.getAllinstoargeprice()[i]));
				allocationEntryPo.setCshaaecostpriceamount(Utility.getName(goodsInfoTempPo.getAllinstoargepriceamount()[i]));
			}else if (Utility.getName(allocationPo.getCshaaamounttype()).equals("2")){
				allocationEntryPo.setCshaaenottaxrate(Utility.getName(goodsInfoTempPo.getAllinstoargeprice()[i]));
				allocationEntryPo.setCshaaenottaxrateamount(Utility.getName(goodsInfoTempPo.getAllinstoargepriceamount()[i]));
			}else if (Utility.getName(allocationPo.getCshaaamounttype()).equals("3")){
				allocationEntryPo.setCshaaewholesaleprice(Utility.getName(goodsInfoTempPo.getAllinstoargeprice()[i]));
				allocationEntryPo.setCshaaewholesalepriceamount(Utility.getName(goodsInfoTempPo.getAllinstoargepriceamount()[i]));
			}
			
			allocationEntryList.add(allocationEntryPo);
		}
		
		if(systemParameterPo.getFspsalestype().equals("0")){
			String errorBarcode = "";
			for(int i=0;i<allocationEntryList.size(); i++){
				GoodsInfoPo goodspo = new GoodsInfoPo();
				goodspo.setBgiwarehouseid(allocationEntryList.get(i).getCshaaoutstockid());
				goodspo.setBgigoodsbarcode(allocationEntryList.get(i).getCshaaGoodsBarCode());
				goodspo.setBgiallBillid(allocationPo.getCshaabillid());
				List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
				if((Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity()))<Integer.parseInt(allocationEntryList.get(i).getCshaaeallocationquantity())){
					errorBarcode = errorBarcode + allocationEntryList.get(i).getCshaaGoodsBarCode()+"\\n";
				}
			}
			
			if(!errorBarcode.equals("")){
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				return "error";
			}
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(((PersonInfoPo)session.get("person")).getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("商品调拨："+allocationPo.getCshaabillid()+"新增!");
		
		allocationPo.setCshaaisautoreceipt(Utility.getName(systemParameterPo.getFspallocationautoreceipt()));

		allocationMgr.insertAllocation(allocationPo, allocationEntryList,smsLertsPo,personInfoList,null,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		
		if("1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
			String url = "''allocationDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(allocationPo.getCshaabillid());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			String url = "''initAllocationUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(allocationPo.getCshaabillid());
			params.add(moduleID);
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
		
	}
	/**
	 * 修改商品调拨初始化
	 */
	public String initAllocationUpdate() {
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
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		goodsCategorys = varietyMgr.getGoodsCategorys();

		String id=Utility.getName(request.getParameter("hid"));
		AllocationPo apo=new AllocationPo();
		apo.setCshaabillid(id);
		allocationPo=allocationMgr.getAllocation(apo);
		allocationEntryList=allocationMgr.getAllocationEntryList2(apo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
		    deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}		
		
		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}
		
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
				List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
				for (DepartmentsPo dpo : dList){
					indepartmentsList.add(dpo);
				}
			}
		}
		
		outwarehouselist=warehouseMgr.getWarehouseForSalesList(allocationPo.getCshaaoutdepartmentid());		
		
		request.setAttribute("systemParameterPo", systemParameterPo);		
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		return SUCCESS;
	}	
	/**
	 * 商品调拨修改
	 */
	public String updateAllocation() {
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
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
        if("".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
        	allocationPo.setCshaaauditstate("0");
        }
        List<PersonInfoPo> personInfoList=null;
        SmsLertsPo smsLertsPo=new SmsLertsPo();
        PersonInfoPo tempPersonInfoPo = new PersonInfoPo();
    	tempPersonInfoPo.setAllocationFlag("1");
    	WarehousePo tempWarehousePo = new WarehousePo();
    	tempWarehousePo.setBwhid(allocationPo.getCshaaoutstockid());
    	
    	WarehousePo inWarehousePo = new WarehousePo();
    	inWarehousePo.setBwhid(allocationPo.getCshaainstockid());
    	WarehousePo outWarehousePo = new WarehousePo();
    	outWarehousePo.setBwhid(allocationPo.getCshaaoutstockid());
    	outWarehousePo=warehouseMgr.getWarehouse(outWarehousePo);
    	inWarehousePo=warehouseMgr.getWarehouse(inWarehousePo);
    	
    	DepartmentsPo departmentsPo=warehouseMgr.getDepartments(tempWarehousePo);
    	DepartmentsPo indepartmentsPo=warehouseMgr.getDepartments(inWarehousePo);
		tempPersonInfoPo.setDepartmentID(indepartmentsPo.getBdpdepartmentid());
    	if("1".equals(personInfoPo.getDepartmenttype())){ //如果是门店
    		if(Utility.getName(allocationPo.getCshaaauditstate()).equals("1")){ //如果审核
    			if(personInfoPo.getDepartmentID().equals(departmentsPo.getBdpdepartmentid())){ //如果发出仓位是自己本门店
    				smsLertsPo.setCstsltitle(outWarehousePo.getBwhwarehouseName()+"给"+inWarehousePo.getBwhwarehouseName()+"做一调拨,调拨单号!"+allocationPo.getCshaabillid());
    		    	smsLertsPo.setCstslcontent("<a href='initAllocationUpdate.action?hid="+allocationPo.getCshaabillid()+"&smsFlag=1'>点击查看详情</a>");
    		    	 personInfoList = personInfoMgr.getPersonInfos(tempPersonInfoPo, 0, personInfoMgr.getPersoninfosCount(tempPersonInfoPo));
    			}
    		}
    	}else if("3".equals(personInfoPo.getDepartmenttype())){//如果是仓储
    		if(Utility.getName(allocationPo.getCshaaauditstate()).equals("1")){ //如果审核
    			smsLertsPo.setCstsltitle(outWarehousePo.getBwhwarehouseName()+"同意了"+inWarehousePo.getBwhwarehouseName()+"的采购申请,调拨单号"+allocationPo.getCshaabillid());
		    	smsLertsPo.setCstslcontent("<a href='allocationDetails.action?hid="+allocationPo.getCshaabillid()+"&smsFlag=1'>点击查看详情</a>");
		    	 personInfoList = personInfoMgr.getPersonInfos(tempPersonInfoPo, 0, personInfoMgr.getPersoninfosCount(tempPersonInfoPo));
    		}
    	}
    	
    	smsLertsPo.setCstslsendperson(((PersonInfoPo)session.get("person")).getId());
    	smsLertsPo.setCstslsenddepartment(((PersonInfoPo)session.get("person")).getDepartmentID());
    	
        if("1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
        	allocationPo.setCshaaauditperson(personInfoPo.getId());
        	allocationPo.setCshaafinanceauditperson(createPerson);
        }
        
        WarehousePo warehousePo=new WarehousePo();
        warehousePo.setBwhid(allocationPo.getCshaainstockid());
        
		int lenth=goodsInfoTempPo.getGoodsid().length;		
		allocationEntryList=new ArrayList<AllocationEntryPo>();
		for(int i=0;i<lenth;i++){
			AllocationEntryPo allocationEntryPo=new AllocationEntryPo();
			allocationEntryPo.setCshaaebillid(allocationPo.getCshaabillid());
			allocationEntryPo.setCshaaegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			allocationEntryPo.setCshaaoutstockid(allocationPo.getCshaaoutstockid());
			allocationEntryPo.setCshaainstockid(allocationPo.getCshaainstockid());
			allocationEntryPo.setCshaaegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			allocationEntryPo.setCshaaeallocationquantity(goodsInfoTempPo.getGoodsquantity()!=null?goodsInfoTempPo.getGoodsquantity()[i]:"0");
			allocationEntryPo.setCshaaegoodsBarCode(goodsInfoTempPo.getGoodsbarcode()!=null?goodsInfoTempPo.getGoodsbarcode()[i]:""); // 新增时加入商品条码
			allocationEntryPo.setCshaaGoodsBarCode(goodsInfoTempPo.getGoodsbarcode()!=null?goodsInfoTempPo.getGoodsbarcode()[i]:""); // 新增时加入商品条码
			allocationEntryPo.setCshaaerequirementquantity(Utility.getName(goodsInfoTempPo.getCshaaerequirequantity()[i]));
			allocationEntryPo.setCshaaespec(goodsInfoTempPo.getSpec()[i]);
			allocationEntryPo.setCshaaemaxquantity(goodsInfoTempPo.getCshaaemaxquantity()[i]);

			allocationEntryPo.setCshaaeamounttype(Utility.getName(allocationPo.getCshaaamounttype()));
			
			if (Utility.getName(allocationPo.getCshaaamounttype()).equals("1")){
				allocationEntryPo.setCshaaecostprice(Utility.getName(goodsInfoTempPo.getAllinstoargeprice()[i]));
				allocationEntryPo.setCshaaecostpriceamount(Utility.getName(goodsInfoTempPo.getAllinstoargepriceamount()[i]));
			}else if (Utility.getName(allocationPo.getCshaaamounttype()).equals("2")){
				allocationEntryPo.setCshaaenottaxrate(Utility.getName(goodsInfoTempPo.getAllinstoargeprice()[i]));
				allocationEntryPo.setCshaaenottaxrateamount(Utility.getName(goodsInfoTempPo.getAllinstoargepriceamount()[i]));
			}else if (Utility.getName(allocationPo.getCshaaamounttype()).equals("3")){
				allocationEntryPo.setCshaaewholesaleprice(Utility.getName(goodsInfoTempPo.getAllinstoargeprice()[i]));
				allocationEntryPo.setCshaaewholesalepriceamount(Utility.getName(goodsInfoTempPo.getAllinstoargepriceamount()[i]));
			}

			allocationEntryList.add(allocationEntryPo);
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		if(systemParameterPo.getFspsalestype().equals("0")){
			String errorBarcode = "";
			for(int i=0;i<allocationEntryList.size(); i++){
				GoodsInfoPo goodspo = new GoodsInfoPo();
				goodspo.setBgiwarehouseid(allocationEntryList.get(i).getCshaaoutstockid());
				goodspo.setBgigoodsbarcode(allocationEntryList.get(i).getCshaaGoodsBarCode());
				goodspo.setBgiallBillid(allocationPo.getCshaabillid());
				List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
				if(Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity())<Integer.parseInt(allocationEntryList.get(i).getCshaaeallocationquantity())){
					errorBarcode = errorBarcode + allocationEntryList.get(i).getCshaaGoodsBarCode()+"\\n";
				}
			}
			
			if(!errorBarcode.equals("")){
				String id=Utility.getName(request.getParameter("hid"));
				AllocationPo apo=new AllocationPo();
				apo.setCshaabillid(id);
				allocationPo=allocationMgr.getAllocation(apo);
				allocationEntryList=allocationMgr.getAllocationEntryList(apo);
				
				systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
				
				DepartmentsPo deppo=new DepartmentsPo();
				deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
				deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
				deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
				deppo.setBdpcompanynature(personInfoPo.getCompanynature());
				deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
				if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
				    deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
				}				
				
				if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
					if("3".equals(personInfoPo.getDepartmenttype())){
						indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 获取当前公司下所有已启用的部门
					}else{
						String[] str = {"3"};
						indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
					}
				}else{
					indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
				}
				
				if (indepartmentsList == null){
					indepartmentsList = new ArrayList<DepartmentsPo>();
				}

				if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
					List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
					for (DepartmentsPo dpo : dList){
						indepartmentsList.add(dpo);
					}
				}
				
				outwarehouselist=warehouseMgr.getWarehouseForSalesList(allocationPo.getCshaaoutdepartmentid());		
				
				request.setAttribute("systemParameterPo", systemParameterPo);		
				request.setAttribute("smsFlag", request.getParameter("smsFlag"));
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				return "error";
			}
		}
		
		request.setAttribute("moduleID", moduleID);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("商品调拨："+allocationPo.getCshaabillid()+"修改");
		
		allocationPo.setCshaaisautoreceipt(Utility.getName(systemParameterPo.getFspallocationautoreceipt()));
		
		allocationMgr.updateAllocation(allocationPo, allocationEntryList, smsLertsPo,personInfoList,null,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
		if(Utility.getName(request.getParameter("smsFlag")).equals("1")){
			request.setAttribute("flag",GlobalConstants.MOVE);
			request.setAttribute("url", "'selectSms.action'");
		}else{
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		}
		if("1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
			String url = "''allocationDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(allocationPo.getCshaabillid());
			params.add(moduleID);
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			String url = "''initAllocationUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(allocationPo.getCshaabillid());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
	}
	/**
	 * 删除商品调拨初始化
	 */
	public String initAllocationDelete() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id=Utility.getName(request.getParameter("hid"));
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		allocationPo=allocationMgr.getAllocation(po);
		
		return SUCCESS;
	}	
	/**
	 * 商品调拨删除
	 */
	public String deleteAllocation() {
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String id=Utility.getName(request.getParameter("hid"));
		
		List<PersonInfoPo> personInfoList=null;
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		AllocationPo tempAllocationPo = new AllocationPo();
		tempAllocationPo=allocationMgr.getAllocation(po);
		if("1".equals(personInfoPo.getDepartmenttype())){
			WarehousePo warehousePo=new WarehousePo();
			warehousePo.setBwhid(tempAllocationPo.getCshaaoutstockid());
			DepartmentsPo departmentsPo=warehouseMgr.getDepartments(warehousePo);
			PersonInfoPo tempPersonInfoPo = new PersonInfoPo();
	    	tempPersonInfoPo.setAllocationFlag("1");
	    	tempPersonInfoPo.setDepartmentID(departmentsPo.getBdpdepartmentid());
	    	personInfoList = personInfoMgr.getPersonInfos(tempPersonInfoPo, 0, personInfoMgr.getPersoninfosCount(tempPersonInfoPo));
		}
		
		SmsLertsPo smsLertsPo = new SmsLertsPo();
		smsLertsPo.setCstsltitle("调拨单"+id+"已删除");
    	smsLertsPo.setCstslcontent("调拨单"+id+"已删除");
    	smsLertsPo.setCstslsenddepartment(personInfoPo.getDepartmentID());
    	smsLertsPo.setCstslsendperson(personInfoPo.getId());
    	
    	String moduleID = Utility.getName(request.getParameter("moduleID"));
    	request.setAttribute("moduleID", moduleID);

    	LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 删除
		logPo.setsLogContent("商品调拨单："+po.getCshaabillid()+"删除");

    	if ("1".equals(Utility.getName(tempAllocationPo.getCshaaconsignstate()))){
    		this.clearMessages();
    		this.addActionMessage(getText("当前调拨单已收货,删除失败!"));
    		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

    		return SUCCESS;
    	}
    	
		allocationMgr.deleteAllocation(po,personInfoList,smsLertsPo,logPo,tempAllocationPo);
				
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	/**
	 * 商品调拨明细
	 */
	public String allocationDetails() {
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

		String id=Utility.getName(request.getParameter("hid"));
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		allocationPo=allocationMgr.getAllocation(po);
		
		DepartmentsPo dpo = new DepartmentsPo();
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(allocationPo.getCshaaindepartmentid());
		
		dpo = departmentsMgr.getDepartment(tdpo);
		
		po.setWhichretail(dpo.getBdpwhichretail());
		
		if("1".equals(dpo.getBdpwhichretail())){
			allocationPo.setWhichretailname("标准零售价");
		}else{
			allocationPo.setWhichretailname("零售价格"+dpo.getBdpwhichretail());
		}
		
		allocationEntryList=allocationMgr.getAllocationEntryList2(po);
	
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		inwarehouselist=warehouseMgr.getWarehouseList(deppo);
		outwarehouselist=warehouseMgr.getWarehouseList(deppo);
		
		StatusPo spo = new StatusPo();
		
		spo.setCshastatusbillid(id);
		
		statusPo = allocationMgr.getStatusPo(spo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		
		String goodsID = Utility.getName(request.getParameter("goodsID"));//库存综合查询，流水里面的单据明细，商品重点显示。
		request.setAttribute("goodsID", goodsID);		
		return SUCCESS;
	}
	/**
	 * 商品调拨收货
	 */
	public String receiveAllocation() {
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

		String cshaabillid=Utility.getName(request.getParameter("cshaabillid"));
		
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(cshaabillid);
		po.setCshaaconsignee(personInfoPo.getId());
		po.setCshaaconsignstate("1");
		po.setCshaainstockid(allocationPo.getCshaainstockid());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
    	if (allocationMgr.isExistAllocationBillByID(cshaabillid) <= 0){
    		this.clearMessages();
    		this.addActionMessage(getText("当前调拨单已被删除,收货失败!"));
    		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

    		return SUCCESS;
    	}
		
		int countnumber = allocationMgr.getAllocationCount(po);
		if(countnumber>0){
			this.clearMessages();
			this.addActionMessage("该调拨单已收货！");
			
			String url = "''allocationDetails.action?hid={0}''";
			List<String> params = new ArrayList<String>();
			params.add(cshaabillid);
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
			
		}else{
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(personInfoPo.getId());
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 模块ID
			logPo.setsLogOpID("37");    // 确认收货
			logPo.setsLogContent("商品调拨单："+cshaabillid+"收货!");

			List<InventoryEntryPo> inventoryEntryList = null;
			
			if (Utility.getName(systemParameterPo.getFspsalestype()).equals("0")){ //不允许负库存销售
				inventoryEntryList = new ArrayList<InventoryEntryPo>();
				allocationEntryList = allocationMgr.getAllocationEntryList(po);
				
				String errorBarcode = "";
				for(int j = 0; j < allocationEntryList.size(); j++){
					GoodsInfoPo goodspo = new GoodsInfoPo();
					goodspo.setBgiwarehouseid(allocationPo.getCshaaoutstockid());
					goodspo.setBgigoodsbarcode(allocationEntryList.get(j).getCshaaegoodsBarCode());
					goodspo.setBgiallBillid(cshaabillid);
					List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
					if((Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity()))<Integer.parseInt(allocationEntryList.get(j).getCshaaeallocationquantity())){
						errorBarcode = errorBarcode + allocationEntryList.get(j).getCshaaegoodsBarCode()+"\\n";
					}
				}
				
				if(!errorBarcode.equals("")){
					errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
					this.addActionMessage(errorBarcode);
					return "error";
				}
				
				String goodsID = null;
				int lenth = allocationEntryList.size();
				
				for (int i = 0; i < lenth; i++) {			
					goodsID = allocationEntryList.get(i).getCshaaegoodsid();
					
					InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();	
					inventoryEntryPo.setCstieid(allocationEntryList.get(i).getCshaaeid());
					inventoryEntryPo.setCstiegoodsid(goodsID);			
					inventoryEntryPo.setCstieoutstockid(Utility.getName(allocationPo.getCshaaoutstockid()));
					inventoryEntryPo.setCstieoutstorageflag("1");
					inventoryEntryPo.setCstiegoodsquantity(allocationEntryList.get(i).getCshaaeallocationquantity());
					inventoryEntryPo.setCstiebarcode(allocationEntryList.get(i).getCshaaGoodsBarCode());
					
					inventoryEntryList.add(inventoryEntryPo);
				}
			}
			
			this.clearMessages();
			
			allocationMgr.updateAllocationReceive(po,inventoryEntryList,logPo);
			this.addActionMessage(getText("struts.messages.update.sucess"));
			
			if(Utility.getName(request.getParameter("smsFlag")).equals("1")){
				request.setAttribute("flag",GlobalConstants.MOVE);
				request.setAttribute("url", "'selectSms.action'");
			}else{
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			}
		}
		return SUCCESS;
	}
	
	public String selApplyAllocationBills() throws Exception { 
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
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);		

		goodsCategorys = varietyMgr.getGoodsCategorys();
		if(null == allocationPo) {
			allocationPo = new AllocationPo();
			String billID="ALL"+GenerateNumber.getInstance().getGenerageNumber();
			allocationPo.setCshaabillid(billID);
			allocationPo.setCshaaoutdepartmentid(personInfoPo.getDepartmentID());
			allocationPo.setCshaaoutdepartmentname(personInfoPo.getBdpdepartmentname());
		}
		String id=Utility.getName(request.getParameter("billID"));
		if("".equals(Utility.getName(allocationPo.getCshaaoutstockid()))){
			allocationPo.setCshaaoutstockid(warehouseConfigurationPo.getBwcstockid9());
		}
		allocationPo.setCshaabillassociation(id);
		allocationEntryList = new ArrayList<AllocationEntryPo>();
		allocationEntryList = allocationMgr.getApplyList(allocationPo);
		allocationPo.setCshaacategoryid(allocationEntryList.get(0).getCshaaebgiretailprice());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !personInfoPo.getDepartmenttype().equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 总公司获取所有已启用的部门，分公司获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}

		outwarehouselist = warehouseMgr.getWarehouseForSalesList(personInfoPo.getDepartmentID());		
		
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
		
		String isShowBarcode = Utility.getName(request.getParameter("isShowBarcode"));
		request.setAttribute("isShowBarcode", isShowBarcode);
		
		if (Utility.getName(personInfoPo.getDepartmenttype()).equals("1") && outwarehouselist.size() > 0){
			warehouseConfigurationPo.setBwcstockid9(outwarehouselist.get(0).getBwhid());
		}else{
			if(!"".equals(Utility.getName(allocationPo.getCshaaoutstockid()))){
				warehouseConfigurationPo.setBwcstockid9(allocationPo.getCshaaoutstockid());
			}else{
				
				warehouseConfigurationPo.setBwcstockid9(warehouseConfigurationPo.getBwcstockid9());
			}
		}
		
		return SUCCESS;
	}
	public String selGoodsAllocationBills() throws Exception { 
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
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		if(null == allocationPo) {
			allocationPo = new AllocationPo();
			String billID="ALL"+GenerateNumber.getInstance().getGenerageNumber();
			allocationPo.setCshaabillid(billID);
			allocationPo.setCshaaoutdepartmentid(personInfoPo.getDepartmentID());
			allocationPo.setCshaaoutdepartmentname(personInfoPo.getBdpdepartmentname());
		}
		String id=Utility.getName(request.getParameter("billID"));
		allocationPo.setCshaabillassociation(id);
		allocationEntryList = new ArrayList<AllocationEntryPo>();
		allocationEntryList = allocationMgr.getAlllyList(allocationPo);
		allocationPo.setCshaacategoryid(allocationEntryList.get(0).getCshaaebgiretailprice());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !personInfoPo.getDepartmenttype().equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
	
		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 总公司获取所有已启用的部门，分公司获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);		

		outwarehouselist=warehouseMgr.getWarehouseForSalesList(personInfoPo.getDepartmentID());
		
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
		
		String isShowBarcode = Utility.getName(request.getParameter("isShowBarcode"));
		request.setAttribute("isShowBarcode", isShowBarcode);
		
		if (Utility.getName(personInfoPo.getDepartmenttype()).equals("1") && outwarehouselist.size() > 0){
			warehouseConfigurationPo.setBwcstockid9(outwarehouselist.get(0).getBwhid());
		}	
		//allocationPo.setCshaabillassociation("");
		
		return SUCCESS;
	}
	
	
	
	public String selApplyAllocationBillsUpdate() throws Exception { 
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
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		String id=Utility.getName(request.getParameter("billID"));
		allocationPo.setCshaabillassociation(id);
		allocationEntryList = new ArrayList<AllocationEntryPo>();
		allocationEntryList = allocationMgr.getApplyList(allocationPo);
		
		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !personInfoPo.getDepartmenttype().equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
	
		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 总公司获取所有已启用的部门，分公司获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}
		
		outwarehouselist=warehouseMgr.getWarehouseForSalesList(allocationPo.getCshaaoutdepartmentid());	

		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
		
		String isShowBarcode = Utility.getName(request.getParameter("isShowBarcode"));
		request.setAttribute("isShowBarcode", isShowBarcode);
		
		return SUCCESS;

	}
	
	public String selAllocationBillsUpdate() throws Exception { 
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
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		String id=Utility.getName(request.getParameter("billID"));
		allocationPo.setCshaabillassociation(id);
		allocationEntryList = new ArrayList<AllocationEntryPo>();
		allocationEntryList = allocationMgr.getAlllyList(allocationPo);
		
		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !personInfoPo.getDepartmenttype().equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
	
		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 总公司获取所有已启用的部门，分公司获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}
		outwarehouselist=warehouseMgr.getWarehouseForSalesList(allocationPo.getCshaaoutdepartmentid());	

		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
		
		String isShowBarcode = Utility.getName(request.getParameter("isShowBarcode"));
		request.setAttribute("isShowBarcode", isShowBarcode);
		allocationPo.setCshaabillassociation("");
		return SUCCESS;

	}
	//调拨选择负调拨单（调拨单新增页面使用）
	public String selReAllocationBills() throws Exception { 
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
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		String id=Utility.getName(request.getParameter("billID"));
		allocationPo.setCshaabillassociation(id);
		allocationEntryList = new ArrayList<AllocationEntryPo>();
		allocationEntryList = allocationMgr.getReallocationList(allocationPo);
		
		List<AllocationEntryPo> barcodes = allocationMgr.getAllocationBarcode(id);
		
		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !personInfoPo.getDepartmenttype().equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
	
		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 总公司获取所有已启用的部门，分公司获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		
		outwarehouselist=warehouseMgr.getWarehouseForAllocationList(deppo);		
		
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
		request.setAttribute("barcodes", barcodes);
		
		return SUCCESS;

	}
	
	
	//调拨选择负调拨单（调拨单修改页面使用）
	public String selReAllocationBillsUpdate() throws Exception { 
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
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		String id=Utility.getName(request.getParameter("billID"));
		allocationPo.setCshaabillassociation(id);
		allocationEntryList = new ArrayList<AllocationEntryPo>();
		allocationEntryList = allocationMgr.getReallocationList(allocationPo);
		
		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !personInfoPo.getDepartmenttype().equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
	
		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 总公司获取所有已启用的部门，分公司获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}
		outwarehouselist=warehouseMgr.getWarehouseForAllocationList(deppo);		

		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
		return SUCCESS;

	}
	
	
	//调拨选择收货单（调拨单新增页面使用）
	public String selReceiptBills() throws Exception {
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
	
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		
		String id = Utility.getName(request.getParameter("billID"));
		String did = Utility.getName(request.getParameter("did"));
		
		allocationPo.setCshaabillassociation(id);
		allocationPo.setCshaaindepartmentid((!did.equals("") ? did : allocationPo.getCshaaindepartmentid()));

		allocationEntryList = new ArrayList<AllocationEntryPo>();
		allocationEntryList = allocationMgr.getReceiptList(allocationPo);
		
		if (allocationBarcodeLists == null){
			allocationBarcodeLists = new ArrayList<AllocationBarcodePo>();
		}
		if (allocationEntryList != null){
			
			 for(int i=0;i <allocationEntryList.size();i++){ 
				 AllocationEntryPo allocationEntryPo1 = new AllocationEntryPo();
				 allocationEntryPo1=allocationEntryList.get(i);
				 String number = allocationEntryPo1.getCshaaeallocationquantity();
				 for(int j=0;j <Integer.parseInt(number);j++)
				 { 
					 AllocationBarcodePo allocationBarcodePo = new AllocationBarcodePo();
					 allocationBarcodePo.setCshabgoodsid(allocationEntryPo1.getCshaaegoodsid().split(",")[0].trim());
					 allocationBarcodePo.setCshabgoodsbarcode(allocationEntryPo1.getCshabgoodsbarcode().split(",")[0].trim());
					 allocationBarcodeLists.add(allocationBarcodePo);
				 }
			 }
		}
		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !personInfoPo.getDepartmenttype().equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
	
		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 总公司获取所有已启用的部门，分公司获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		
		outwarehouselist=warehouseMgr.getWarehouseForSalesList(deppo.getBdpdepartmentid());
		
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "1");
		return SUCCESS;

	}
	
	//调拨选择收货单（调拨单修改页面使用）
	public String selReceiptBillsUpdate() throws Exception { 
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		String id=Utility.getName(request.getParameter("billID"));
		allocationPo.setCshaabillassociation(id);
		allocationEntryList = new ArrayList<AllocationEntryPo>();
		allocationEntryList = allocationMgr.getReceiptList(allocationPo);
		
		if (allocationBarcodeLists == null){
			allocationBarcodeLists = new ArrayList<AllocationBarcodePo>();
		}
		if (allocationEntryList != null){
			
			 for(int i=0;i <allocationEntryList.size();i++){ 
				 AllocationEntryPo allocationEntryPo1 = new AllocationEntryPo();
				 allocationEntryPo1=allocationEntryList.get(i);
				 String number = allocationEntryPo1.getCshaaeallocationquantity();
				 for(int j=0;j <Integer.parseInt(number);j++)
				 { 
					 AllocationBarcodePo allocationBarcodePo = new AllocationBarcodePo();
					 allocationBarcodePo.setCshabgoodsid(allocationEntryPo1.getCshaaegoodsid().split(",")[0].trim());
					 allocationBarcodePo.setCshabgoodsbarcode(allocationEntryPo1.getCshabgoodsbarcode().split(",")[0].trim());
					 allocationBarcodeLists.add(allocationBarcodePo);
				 }
			 }
		}	
		
		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !personInfoPo.getDepartmenttype().equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
	
		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 总公司获取所有已启用的部门，分公司获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}
		outwarehouselist=warehouseMgr.getWarehouseForSalesList(personInfoPo.getDepartmentID());		
		
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "1");
		
		String isShowBarcode = Utility.getName(request.getParameter("isShowBarcode"));
		request.setAttribute("isShowBarcode", isShowBarcode);
		
		return SUCCESS;

	}
	
	/**
	 * 取得Ajax数据
	 */
	public void getAjaxStock() throws Exception {
		String instockid = request.getParameter("instockid");
		String id = Utility.getName(request.getParameter("id"));
		
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(id.equals("")){
			out.println("<option value=''>----请选择----</option>");
		}else{
			out.println("<option value=''>----请选择----</option>");
			DepartmentsPo departmentsPo=new DepartmentsPo();
			departmentsPo.setBdpdepartmentid(id);
			List<WarehousePo> inwarehouselist=warehouseMgr.getWarehouseForAjaxList(departmentsPo);
			Iterator<WarehousePo> it = inwarehouselist.iterator();		
			if (it.hasNext()) {
				while (it.hasNext()) {
					WarehousePo warehousePo=it.next();
					out.println("<option dptid='" + warehousePo.getBwhdeptid()+ "' value='" + warehousePo.getBwhid()+ "' "+(warehousePo.getBwhid().equals(instockid)? "selected":"")+">"+warehousePo.getBwhwarehouseName()+"</option>");
				}
			}
		}
		out.close();			
	}
	
	public String returnAudit() throws Exception{
		String cshaabillid=Utility.getName(request.getParameter("cshaabillid"));
		this.allocationMgr.returnAudit(cshaabillid);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	public StatusPo getStatusPo() {
		return statusPo;
	}
	public void setStatusPo(StatusPo statusPo) {
		this.statusPo = statusPo;
	}
	
	public String addGoodsInfoForTable() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !personInfoPo.getDepartmenttype().equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
	
		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 总公司获取所有已启用的部门，分公司获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////		

		outwarehouselist=warehouseMgr.getWarehouseForSalesList(personInfoPo.getDepartmentID());		
				
		List<AllocationEntryPo> barcodes =new ArrayList<AllocationEntryPo>();;
		allocationEntryList=new ArrayList<AllocationEntryPo>();
		
		String scancode = Utility.getName(request.getParameter("scancode"));
		
		GoodsInfoPo tpo = new GoodsInfoPo();
		
		tpo.setBgigoodsbarcode(scancode.substring(0, 18));
		
		GoodsInfoPo gpo = allocationMgr.getGoodsInfoPo(tpo);
		
		AllocationEntryPo apo = new AllocationEntryPo();
		apo.setCshaaebillid(allocationPo.getCshaabillid());
		apo.setCshaaegoodsid(gpo.getBgigoodsid());
		apo.setCshaaoutstockid(allocationPo.getCshaaoutstockid());
		apo.setCshaainstockid(allocationPo.getCshaainstockid());
		apo.setCshaaerequirementquantity("0");
		apo.setCshaaeallocationquantity("0");
		apo.setCshaaegoodsname(gpo.getBgigoodsname());
		apo.setCshaaespec(gpo.getBgispec());
		
		String jumptype = Utility.getName(request.getParameter("jumptype"));
		if(goodsInfoTempPo != null){
			int lenth=goodsInfoTempPo.getGoodsid().length;
			for(int i=0;i<lenth;i++){
				AllocationEntryPo allocationEntryPo=new AllocationEntryPo();
				allocationEntryPo.setCshaaebillid(allocationPo.getCshaabillid());
				allocationEntryPo.setCshaaegoodsid(goodsInfoTempPo.getGoodsid()[i]);
				allocationEntryPo.setCshaaoutstockid(allocationPo.getCshaaoutstockid());
				allocationEntryPo.setCshaainstockid(allocationPo.getCshaainstockid());
				allocationEntryPo.setCshaaerequirementquantity(request.getParameterValues("needNumber")!=null?request.getParameterValues("needNumber")[i]:"0");
				allocationEntryPo.setCshaaeallocationquantity(goodsInfoTempPo.getGoodsquantity()!=null?goodsInfoTempPo.getGoodsquantity()[i]:"0");
				allocationEntryPo.setCshaaegoodsname(goodsInfoTempPo.getGoodsname()[i]);
				allocationEntryPo.setCshaaespec(goodsInfoTempPo.getSpec()[i]);
				
				allocationEntryList.add(allocationEntryPo);
				
				if(!"u".equals(jumptype)){
					if(goodsInfoTempPo.getGoodsbarcode()!=null){
						String barcode=goodsInfoTempPo.getGoodsid()[i].replace(".", "");
						for(int k=0;k<goodsInfoTempPo.getGoodsbarcode().length;k++){
							if(goodsInfoTempPo.getGoodsbarcode()[k].substring(0,18).equals(barcode.toUpperCase())){
								AllocationEntryPo bpo = new AllocationEntryPo();
								       
								bpo.setCshaaegoodsBarCode(goodsInfoTempPo.getGoodsbarcode()[k]);
								barcodes.add(bpo);
							}
						}
					}
				}
				
	
			}
		}
		
		
		String id=Utility.getName(request.getParameter("allocationPo.cshaabillid"));
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		
		allocationBarcodeLists=allocationMgr.getAllocationBarcode(po);
		
		AllocationEntryPo gapo = new AllocationEntryPo();
		gapo.setCshaaegoodsBarCode(scancode);
		
		if(apo != null){
			allocationEntryList.add(apo);
			barcodes.add(gapo);
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		request.setAttribute("barcodes", barcodes);
		request.setAttribute("StatusID", "1");
		
		
		if("u".equals(jumptype)){
			return "update";
		}else{
			return SUCCESS;
		}
		
		
	}
	
	public String initAllocationReSel() {

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
		
		goodsCategorys = varietyMgr.getGoodsCategorys();

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		DepartmentsPo po = new DepartmentsPo();		
		
		if (personInfoPo1.getDepartmenttype().equals("1") || personInfoPo1.getDepartmenttype().equals("2")){			
			po.setBdpdepartmentid(personInfoPo1.getDepartmentID());	
		}
		departmentsList = departmentsMgr.getDepartmentsList(po);
		indepartmentsList1 = departmentsList;
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("allactionflag","2"); // 负调拨标识位	
				
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selAlloca";
		}
		
		return SUCCESS;
	}	
	
	/**
	 * 商品调拨打印状态更新
	 */
	public String updateAllocationPrintType() {
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
		
		String id=Utility.getName(request.getParameter("hid"));
		String[] ids = id.trim().split(",");
		
		for(int i=0; i<ids.length; i++){
			AllocationPo apo = new AllocationPo();
			apo.setCshaabillid(ids[i]);
			allocationMgr.updateAllocationPrintType(apo);
		}
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		String billID=Utility.getName(request.getParameter("billID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String departmentIDout = Utility.getName(request.getParameter("departmentIDout"));
		String auditState=Utility.getName(request.getParameter("auditState"));
		String consignState = Utility.getName(request.getParameter("consignState"));
		String cshaacreateperson=Utility.getName(request.getParameter("createPersonID"));//制单人
		String cshaaauditperson=Utility.getName(request.getParameter("auditPersonID"));//审核人
		String cshaaconsignee=Utility.getName(request.getParameter("consigneePersonID"));//收货人		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName=Utility.getName(request.getParameter("supplierName"));
		String brandName=Utility.getName(request.getParameter("brandName"));
		String brandID=Utility.getName(request.getParameter("brandID"));
		String goodsName=Utility.getName(request.getParameter("goodsName"));
		String remark=Utility.getName(request.getParameter("remark"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String statusBillID = Utility.getName(request.getParameter("statusBillID"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String allactionflag = Utility.getName(request.getParameter("allactionflag"));   // 负调拨标识位	
		String departmentname = Utility.getName(request.getParameter("departmentname"));
		String printtype = Utility.getName(request.getParameter("printtype"));
		
		request.setAttribute("departmentname", departmentname);
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("statusBillID", statusBillID);
		request.setAttribute("allactionflag",allactionflag.equals("") ? "1" : allactionflag); // 负调拨标识位	
		request.setAttribute("printtype",printtype);
		
		String autoAllocationFlag=Utility.getName(request.getParameter("autoAllocationFlag"));
		if (autoAllocationFlag.equals("")){
			autoAllocationFlag = "1";
		}
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		deppo.setBdptype(personInfoPo1.getDepartmenttype());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		DepartmentsPo po = new DepartmentsPo();		
		
		if (personInfoPo1.getDepartmenttype().equals("1") || personInfoPo1.getDepartmenttype().equals("2")){			
			po.setBdpdepartmentid(personInfoPo1.getDepartmentID());	
		}
		departmentsList = departmentsMgr.getDepartmentsList(po);
		indepartmentsList1 = departmentsList;
		
		AllocationPo allocationPo = new AllocationPo();
		allocationPo.setCshaacategoryid(goodscategoryID);
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaindepartmentid(departmentID);
		allocationPo.setCshaaoutdepartmentid(departmentIDout);
		allocationPo.setCshaastartTime(startTime);
		allocationPo.setCshaaendTime(endTime);
		allocationPo.setCshaaauditstate(auditState);
		allocationPo.setCshaaconsignstate(consignState);		
		allocationPo.setCshaacreateperson(cshaacreateperson);
		allocationPo.setCshaaauditperson(cshaaauditperson);
		allocationPo.setCshaaconsignee(cshaaconsignee);
		allocationPo.setCshaaflag("1");//正调拨
		allocationPo.setChaasupplier(supplierID);//制造商代码	
		allocationPo.setChaabrand(brandID);//品种代码
		allocationPo.setChaagoodsname(goodsName);//商品名称	
		allocationPo.setCshaaremark(remark);
		allocationPo.setChaaautoflag(autoAllocationFlag);
		allocationPo.setChaagoodsid(goodsID);//商品名称	
		allocationPo.setCshaabillassociation(statusBillID);
		allocationPo.setCshaaindepartmentname(departmentname);
		allocationPo.setCshaaprinttype(printtype);
		
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
		
		int count=allocationMgr.getAllocationCount(allocationPo,deppo);
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
	    allocationList=allocationMgr.getAllocationList(allocationPo,deppo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			allocationList = null;
		}
		
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("billID",billID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("auditState",auditState);
		request.setAttribute("consignState",consignState);
		request.setAttribute("departmenttype", Utility.getName(request.getParameter("departmenttype")).equals("") ? personInfoPo1.getDepartmenttype() : Utility.getName(request.getParameter("departmenttype")));
		request.setAttribute("selcreatePersonID",cshaacreateperson);
		request.setAttribute("selauditPersonID",cshaaauditperson);
		request.setAttribute("selconsigneePersonID",cshaaconsignee);
		request.setAttribute("auditPersonName", request.getParameter("auditPersonName"));
		request.setAttribute("createPersonName",request.getParameter("createPersonName") );
		request.setAttribute("consigneePersonName",request.getParameter("consigneePersonName") );		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("departmentIDout",departmentIDout);
		request.setAttribute("departmentIDFlag",personInfoPo1.getDepartmentID());
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("remark",remark);
		request.setAttribute("autoAllocationFlag",autoAllocationFlag);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化调拨结算
	 */
	public String initAllocationSettlementSel() {
		
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
		
		goodsCategorys = varietyMgr.getGoodsCategorys();

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		DepartmentsPo po = new DepartmentsPo();		
		if (personInfoPo1.getDepartmenttype().equals("1") || personInfoPo1.getDepartmenttype().equals("2")){			
			po.setBdpdepartmentid(personInfoPo1.getDepartmentID());	
		}
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
		    po.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		
		departmentsList = departmentsMgr.getDepartmentsList(po);
		
		if (departmentsList == null){
			departmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				departmentsList.add(dpo);
			}
		}
		
		indepartmentsList1 = departmentsList;
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
			
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selAllocationSettlement";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询调拨结算
	 */
	public String selAllocationSettlement() {
		
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
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		String billID=Utility.getName(request.getParameter("billID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String departmentIDout = Utility.getName(request.getParameter("departmentIDout"));
		String auditState=Utility.getName(request.getParameter("auditState"));
		String cshaacreateperson=Utility.getName(request.getParameter("createPersonID"));//制单人
		String cshaaauditperson=Utility.getName(request.getParameter("auditPersonID"));//审核人
		String cshaaconsignee=Utility.getName(request.getParameter("consigneePersonID"));//收货人		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName=Utility.getName(request.getParameter("supplierName"));
		String brandName=Utility.getName(request.getParameter("brandName"));
		String brandID=Utility.getName(request.getParameter("brandID"));
		String goodsName=Utility.getName(request.getParameter("goodsName"));
		String remark=Utility.getName(request.getParameter("remark"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String statusBillID = Utility.getName(request.getParameter("statusBillID"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String departmentname = Utility.getName(request.getParameter("departmentname"));
		
		request.setAttribute("departmentname", departmentname);
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("statusBillID", statusBillID);
		
		String autoAllocationFlag=Utility.getName(request.getParameter("autoAllocationFlag"));
		if (autoAllocationFlag.equals("")){
			autoAllocationFlag = "1";
		}
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		deppo.setBdptype(personInfoPo1.getDepartmenttype());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		DepartmentsPo po = new DepartmentsPo();		
		if (personInfoPo1.getDepartmenttype().equals("1") || personInfoPo1.getDepartmenttype().equals("2")){			
			po.setBdpdepartmentid(personInfoPo1.getDepartmentID());	
		}
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
		    po.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartmentsList(po);
		
		if (departmentsList == null){
			departmentsList = new ArrayList<DepartmentsPo>();
		}
		
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				departmentsList.add(dpo);
			}
		}
		
		indepartmentsList1 = departmentsList;
		
		AllocationPo allocationPo = new AllocationPo();
		allocationPo.setCshaacategoryid(goodscategoryID);
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaindepartmentid(departmentID);
		allocationPo.setCshaaoutdepartmentid(departmentIDout);
		allocationPo.setCshaastartTime(startTime);
		allocationPo.setCshaaendTime(endTime);
		allocationPo.setCshaaauditstate(auditState);
		allocationPo.setCshaacreateperson(cshaacreateperson);
		allocationPo.setCshaaauditperson(cshaaauditperson);
		allocationPo.setCshaaconsignee(cshaaconsignee);
		allocationPo.setChaasupplier(supplierID);//制造商代码	
		allocationPo.setChaabrand(brandID);//品种代码
		allocationPo.setChaagoodsname(goodsName);//商品名称	
		allocationPo.setCshaaremark(remark);
		allocationPo.setChaaautoflag(autoAllocationFlag);
		allocationPo.setChaagoodsid(goodsID);//商品名称	
		allocationPo.setCshaabillassociation(statusBillID);
		allocationPo.setCshaaindepartmentname(departmentname);
		allocationPo.setCshaaindptcompanyid(personInfoPo1.getPersoncompanyid());
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			allocationPo.setChaaautoflag("1");
			allocationPo.setCshaaflag("1");
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
		
		int count=allocationMgr.getAllocationSettlementCount(allocationPo,deppo);
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
	    allocationList=allocationMgr.getAllocationSettlementList(allocationPo,deppo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			allocationList = null;
		}
		
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("billID",billID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("auditState",auditState);
		request.setAttribute("departmenttype", Utility.getName(request.getParameter("departmenttype")).equals("") ? personInfoPo1.getDepartmenttype() : Utility.getName(request.getParameter("departmenttype")));
		request.setAttribute("selcreatePersonID",cshaacreateperson);
		request.setAttribute("selauditPersonID",cshaaauditperson);
		request.setAttribute("selconsigneePersonID",cshaaconsignee);
		request.setAttribute("auditPersonName", request.getParameter("auditPersonName"));
		request.setAttribute("createPersonName",request.getParameter("createPersonName") );
		request.setAttribute("consigneePersonName",request.getParameter("consigneePersonName") );		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("departmentIDout",departmentIDout);
		request.setAttribute("departmentIDFlag",personInfoPo1.getDepartmentID());
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("remark",remark);
		request.setAttribute("autoAllocationFlag",autoAllocationFlag);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化新增调拨结算详细
	 */
	public String initAllocationSettlementDetail() {
		
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

		AllocationPo po=new AllocationPo();
		po.setCshaabillid(Utility.getName(request.getParameter("hid")));
		
		allocationPo = allocationMgr.getAllocationSettlement(po);
		allocationEntryList = allocationMgr.getAllocationSettlementEntry(po);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化新增调拨结算
	 */
	public String initAllocationSettlementInsert() {
		
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

		AllocationPo po=new AllocationPo();
		po.setCshaabillid(Utility.getName(request.getParameter("hid")));
		
		allocationPo = allocationMgr.getAllocationSettlement(po);
		allocationEntryList = allocationMgr.getAllocationSettlementEntry(po);
		
		return SUCCESS;
	}
		
	/**
	 * 新增调拨结算
	 */
	public String insertAllocationSettlement() {
		
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
		logPo.setsLogOpID("37");    // 确认收货
		logPo.setsLogContent("调拨结算单："+allocationPo.getCshaabillid()+" 修改!");
				
		List<InventoryEntryPo> entryList = new ArrayList<InventoryEntryPo>();
		
		if("1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
			allocationPo.setCshaafinanceauditperson(createPerson);
		}		
		
		if (goodsInfoTempPo == null){
			goodsInfoTempPo = new GoodsInfoTempPo();
		}
		
		int count = goodsInfoTempPo.getId().length;		
		if (count > 0){
			for (int i = 0; i < count; i++){
				InventoryEntryPo epo = new InventoryEntryPo();
				
				epo.setCstieid(Utility.getName(goodsInfoTempPo.getId()[i]));
				epo.setCstiebarcode(Utility.getName(goodsInfoTempPo.getPcbarcode()[i]));
				
				if (Utility.getName(allocationPo.getCshaaamounttype()).equals("1")){
					epo.setCstiecostprice(Utility.getName(goodsInfoTempPo.getCostprice()[i]));
					epo.setCstiecostpriceamount(Utility.getName(goodsInfoTempPo.getCostpriceamount()[i]));
					
					epo.setCstienottaxrate("0");
					epo.setCstienottaxrateamount("0");
					epo.setCstiewholesaleprice("0");
					epo.setCstiewholesalepriceamount("0");
				}else if (Utility.getName(allocationPo.getCshaaamounttype()).equals("2")){
					epo.setCstienottaxrate(Utility.getName(goodsInfoTempPo.getNottaxrate()[i]));
					epo.setCstienottaxrateamount(Utility.getName(goodsInfoTempPo.getNottaxrateamount()[i]));
					
					epo.setCstiewholesaleprice("0");
					epo.setCstiewholesalepriceamount("0");
					epo.setCstiecostprice("0");
					epo.setCstiecostpriceamount("0");
				}else if (Utility.getName(allocationPo.getCshaaamounttype()).equals("3")){
					epo.setCstiewholesaleprice(Utility.getName(goodsInfoTempPo.getWholesaleprice()[i]));
					epo.setCstiewholesalepriceamount(Utility.getName(goodsInfoTempPo.getWholesalepriceamount()[i]));
					
					epo.setCstienottaxrate("0");
					epo.setCstienottaxrateamount("0");
					epo.setCstiecostprice("0");
					epo.setCstiecostpriceamount("0");
				}
				
				epo.setCstiebillid(Utility.getName(allocationPo.getCshaabillid()));
				
				entryList.add(epo);
			}
		}
		
		allocationMgr.updateAllocationSettlementEntry(allocationPo,entryList,logPo);
		
		if("1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
			String url = "''initAllocationSettlementDetail.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(allocationPo.getCshaabillid());
			params.add(moduleID);
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			String url = "''initAllocationSettlementInsert.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(allocationPo.getCshaabillid());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}

	}
	
		
}
