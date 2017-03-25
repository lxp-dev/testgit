package com.pengsheng.eims.storage.action;

import java.io.PrintWriter;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.NonconformingProductMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.NonconformingProductPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.mgr.NonconformingMgr;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.NonconformingEntryArrayPo;
import com.pengsheng.eims.storage.persistence.NonconformingEntryPo;
import com.pengsheng.eims.storage.persistence.NonconformingPo;
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

public class NonconformingAction extends BaseAction {
	
    private AllocationMgr allocationMgr = null;
    private WarehouseConfigurationMgr warehouseConfigurationMgr;
	private WarehouseConfigurationPo warehouseConfigurationPo;    
    private List<GoodsCategoryPo> goodsCategorys;
	private PersonInfoMgr personInfoMgr;	
	private List<PersonInfoPo> responsibilityList;
	private NonconformingMgr nonconformingMgr;
	private DepartmentsMgr departmentsMgr;
	private WarehouseMgr warehouseMgr;	
	private List<WarehousePo> warehousePos;
	private NonconformingPo nonconformingPo;
	private NonconformingEntryArrayPo nonconformingEntryArrayPo;
	private List<NonconformingEntryPo> nonconformingEntryList;
	private List<NonconformingPo> nonconformingList;
	private List<DepartmentsPo> departmentsList;
	private NonconformingProductPo nonconformingProductPo;
	private List<NonconformingProductPo> nonconformingProductMaxList; // 不合格品原因List
	private List<NonconformingProductPo> nonconformingProductMinList; // 不合格品原因List
	private NonconformingProductMgr nonconformingProductMgr;
	private PersonPermissionMgr personPermissionMgr;
	private String[] cshanbillid;
	private VarietyMgr varietyMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
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
	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}
	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
	}   
	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}
	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}
	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}
	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
	}
	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}	
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}
	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}
	public List<PersonInfoPo> getResponsibilityList() {
		return responsibilityList;
	}
	public void setResponsibilityList(List<PersonInfoPo> responsibilityList) {
		this.responsibilityList = responsibilityList;
	}
	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
	}
	public List<WarehousePo> getWarehousePos() {
		return warehousePos;
	}
	public void setWarehousePos(List<WarehousePo> warehousePos) {
		this.warehousePos = warehousePos;
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
	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}
	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public NonconformingProductPo getNonconformingProductPo() {
		return nonconformingProductPo;
	}
	public void setNonconformingProductPo(
			NonconformingProductPo nonconformingProductPo) {
		this.nonconformingProductPo = nonconformingProductPo;
	}
	public List<NonconformingProductPo> getNonconformingProductMaxList() {
		return nonconformingProductMaxList;
	}
	public void setNonconformingProductMaxList(
			List<NonconformingProductPo> nonconformingProductMaxList) {
		this.nonconformingProductMaxList = nonconformingProductMaxList;
	}
	public List<NonconformingProductPo> getNonconformingProductMinList() {
		return nonconformingProductMinList;
	}
	public void setNonconformingProductMinList(
		List<NonconformingProductPo> nonconformingProductMinList) {
		this.nonconformingProductMinList = nonconformingProductMinList;
	}
	public NonconformingProductMgr getNonconformingProductMgr() {
		return nonconformingProductMgr;
	}
	public void setNonconformingProductMgr(
		NonconformingProductMgr nonconformingProductMgr) {
		this.nonconformingProductMgr = nonconformingProductMgr;
	}
	public NonconformingMgr getNonconformingMgr() {
		return nonconformingMgr;
	}
	public void setNonconformingMgr(NonconformingMgr nonconformingMgr) {
		this.nonconformingMgr = nonconformingMgr;
	}
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	public NonconformingPo getNonconformingPo() {
		return nonconformingPo;
	}
	public void setNonconformingPo(NonconformingPo nonconformingPo) {
		this.nonconformingPo = nonconformingPo;
	}
	public List<NonconformingEntryPo> getNonconformingEntryList() {
		return nonconformingEntryList;
	}
	public void setNonconformingEntryList(
			List<NonconformingEntryPo> nonconformingEntryList) {
		this.nonconformingEntryList = nonconformingEntryList;
	}
	public List<NonconformingPo> getNonconformingList() {
		return nonconformingList;
	}
	public void setNonconformingList(List<NonconformingPo> nonconformingList) {
		this.nonconformingList = nonconformingList;
	}
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}
	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}
	public String[] getCshanbillid() {
		return cshanbillid;
	}
	public void setCshanbillid(String[] cshanbillid) {
		this.cshanbillid = cshanbillid;
	}
	
	/**
	 * 初始化不合格品单查询
	 */
	public String initNonconformingSel() throws Exception {

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
		if (!Utility.getName(personInfoPo.getDepartmenttype()).equals("3")){
			deppo.setBdptype(personInfoPo.getDepartmenttype());
		}
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !Utility.getName(personInfoPo.getDepartmenttype()).equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);
		goodsCategorys = varietyMgr.getGoodsCategorys();
		// 取得登陆人允许操作的仓位&部门 End

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "formingSel";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询不合格品单
	 */
	public String selNonconforming() throws Exception {

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

		// 得到查询条件
		String billID = Utility.getName(request.getParameter("billID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String consignMode = Utility.getName(request.getParameter("consignMode"));  // 处理状态
		String departmentid = Utility.getName(request.getParameter("departmentid"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String createPersonName = Utility.getName(request.getParameter("createPersonName"));
		String cstpcreateperson = Utility.getName(request.getParameter("cstpcreateperson"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String cstpauditperson = Utility.getName(request.getParameter("cstpauditperson"));
		String responsibility = Utility.getName(request.getParameter("responsibility"));
		String responsibilityID = Utility.getName(request.getParameter("responsibilityID"));

		// 制造商 、品种 id及name
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));

		// 获取镜片类型
		String iscustomize = Utility.getName(request.getParameter("iscustomize"));
		String cshanlinkbillID = Utility.getName(request.getParameter("cshanlinkbillID"));
		String cshaneconsignmode = Utility.getName(request.getParameter("cshaneconsignmode"));
		// 放入PO 中
		NonconformingPo po = new NonconformingPo();
		po.setCshanbillid(billID);
		po.setCshanstartTime(startTime);
		po.setCshanendTime(endTime);
		po.setCshanconsignmode(cshaneconsignmode);
		po.setCshanauditstate(auditState);
		po.setCshancreatepersonname(createPersonName);
		po.setCshancreateperson(cstpcreateperson);
		po.setCshanauditpersonname(auditPersonName);
		po.setCshanauditperson(cstpauditperson);
		po.setCshansupplierid(supplierID);
		po.setCshanbrandid(brandID);
		po.setCshandepartmentname(personInfoPo.getDepartmenttype() + "," + personInfoPo.getDepartmentID());
		po.setIscustomize(iscustomize);
		po.setCshanlinkbillID(cshanlinkbillID);
		po.setCshanresponsibilityperson(responsibility);
		if (!Utility.getName(personInfoPo.getDepartmenttype()).equals("3")){
			po.setCshandepartmentid(personInfoPo.getDepartmentID());
		}else{
			po.setCshandepartmentid(departmentid);
		}
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !Utility.getName(personInfoPo.getDepartmenttype()).equals("3")){
			po.setCshancompanyid(personInfoPo.getPersoncompanyid());
		}
		po.setCshanchulistate(consignMode);
		
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

		// 查询分页
		int count = nonconformingMgr.getNonconformingCount(po);
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
			nonconformingList = nonconformingMgr.getNonconformingList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			nonconformingList = null;
		}

		request.setAttribute("billID", billID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("cshaneconsignmode", cshaneconsignmode);
		request.setAttribute("departmentid", departmentid);
		request.setAttribute("auditState", auditState);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("cstpcreateperson", cstpcreateperson);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("cstpauditperson", cstpauditperson);
		request.setAttribute("cshanlinkbillID", cshanlinkbillID);
		request.setAttribute("responsibility", responsibility);
		request.setAttribute("responsibilityID", responsibilityID);
		// 页面存制造商及品种的id和name
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("consignMode", consignMode);
		
		// 页面存镜片类型
		request.setAttribute("iscustomize", iscustomize);

		// 取得登陆人允许操作的仓位&部门 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		if (!Utility.getName(personInfoPo.getDepartmenttype()).equals("3")){
			deppo.setBdptype(personInfoPo.getDepartmenttype());
		}		
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !Utility.getName(personInfoPo.getDepartmenttype()).equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);
		goodsCategorys = varietyMgr.getGoodsCategorys();
	
		return SUCCESS;
	}

	/**
	 * 初始化不合格品单新增
	 */
	public String initNonconformingInsert() throws Exception {
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
		
		nonconformingPo = new NonconformingPo();
		nonconformingPo.setCshanbillid("NCP" + GenerateNumber.getInstance().getGenerageNumber());

		// 取得登陆人允许操作的仓位&部门 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype("2");
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehousePos = warehouseMgr.getWarehouseList(deppo);
		
		request.setAttribute("departmenttype",personInfoPo.getDepartmenttype() );

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		nonconformingProductPo = new NonconformingProductPo();
		nonconformingProductMaxList = nonconformingProductMgr.getNonconformingProductMaxList();
		//获得本部门下的人员（责任人）
		responsibilityList = personInfoMgr.getResponsibility(personInfoPo.getDepartmentID());
		
		return SUCCESS;
	}

	/**
	 * 新增不合格品单
	 */
	public String insertNonconforming() throws Exception {
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
		
		request.setAttribute("departmenttype",personInfoPo.getDepartmenttype() );
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		// 判断是否选中审核复选框
		if ("".equals(Utility.getName(nonconformingPo.getCshanauditstate()))) {
			nonconformingPo.setCshanauditstate("0");
		}
		if ("1".equals(Utility.getName(nonconformingPo.getCshanauditstate()))) {
			nonconformingPo.setCshanauditperson(nonconformingPo.getCshancreateperson());
		}
		nonconformingPo.setCshandepartmentid(personInfoPo.getDepartmentID());

		String cshanlinkbillID = Utility.getName(request.getParameter("bsalesid"));
		nonconformingPo.setCshanlinkbillID(cshanlinkbillID);
		nonconformingEntryList = new ArrayList<NonconformingEntryPo>();
		
		// 生成负调拨单1--------------------------------------------------------------------------
		AllocationPo allocationPo = new AllocationPo();
		allocationPo.setCshaaauditstate("1");
		warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		if("3".equals(personInfoPo.getDepartmenttype())){
			warehouseConfigurationPo = departmentsMgr.getDefaultWarehouse(warehouseConfigurationPo);
		}else{
			warehouseConfigurationPo = warehouseConfigurationMgr.getInWarehouseConfiguration(warehouseConfigurationPo);
		}
		
		allocationPo.setCshaaauditperson(nonconformingPo.getCshancreateperson());
		
		nonconformingEntryList = new ArrayList<NonconformingEntryPo>();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowtime = sdf.format(now);
		allocationPo.setCshaabillid("ALLN"+nonconformingPo.getCshanbillid().substring(4));
		allocationPo.setCshaabilldate(nowtime);
		allocationPo.setCshaaoutdepartmentid(nonconformingPo.getCshandepartmentid());
		WarehousePo warehousePo = nonconformingMgr.getWarehousePo(nonconformingPo.getCshandepartmentid());
		allocationPo.setCshaaoutstockid(nonconformingPo.getCshanoutstockid());
		
		WarehousePo inpo = new WarehousePo();
		if("3".equals(personInfoPo.getDepartmenttype())){
			inpo.setBwhid(warehouseConfigurationPo.getBwcstockid11());
		}else{
			inpo.setBwhid(warehouseConfigurationPo.getBwcstockid14());
		}
		WarehousePo inwarehousepo = warehouseMgr.getWarehouse(inpo);
		
		allocationPo.setCshaaindepartmentid(inwarehousepo.getBwhdeptid());
		
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(inwarehousepo.getBwhdeptid());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		if ("1".equals(dpo.getBdpcompanynature())){
            if ("1".equals(fquartzSwitchPo.getFqscbjs())){
            	allocationPo.setCshaaamounttype("2");
            }else{
            	allocationPo.setCshaaamounttype("1");
            }
        }else if ("2".equals(fquartzSwitchPo.getFqscbjs())){
        	allocationPo.setCshaaamounttype("3");
        }
		
		if("3".equals(personInfoPo.getDepartmenttype())){
			allocationPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid11());
		}else{
			allocationPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid14());
		}
		allocationPo.setCshaacreateperson(personInfoPo.getId());
		allocationPo.setCshaaauditperson("");
		allocationPo.setCshaaauditstate("0");
		allocationPo.setCshaaauditdate("");
		allocationPo.setCshaaconsignee("");
		allocationPo.setCshaaconsignstate("");
		allocationPo.setCshaaremark("不合格品自动导入单据");
		allocationPo.setCshaaflag("1");
		allocationPo.setChaasupplier("");
		allocationPo.setCshaabillassociation(nonconformingPo.getCshanbillid());
		allocationPo.setCshaaconsignee(personInfoPo.getId().trim());

		List<AllocationEntryPo> list = new ArrayList<AllocationEntryPo>();
		
		// 生成负调拨单1--------------------------------------------------------------------------
		

		// 循环取出隐藏域中的值
		int lenth = nonconformingEntryArrayPo.getCshanegoodsid().length;
		for (int i = 0; i < lenth; i++) {
			NonconformingEntryPo nonconformingEntryPo = new NonconformingEntryPo();
			nonconformingEntryPo.setCshanebillid(nonconformingPo.getCshanbillid());
			nonconformingEntryPo.setCshanegoodsid(nonconformingEntryArrayPo.getCshanegoodsid()[i]);
			nonconformingEntryPo.setCshanegoodsname(nonconformingEntryArrayPo.getCshanegoodsname()[i]);
			nonconformingEntryPo.setCshanebarcode(nonconformingEntryArrayPo.getCshanebarcode()[i]);
			nonconformingEntryPo.setCshanegoodstype("123");
			nonconformingEntryPo.setCshanereasons1(nonconformingEntryArrayPo.getCshanereasons1()[i]);
			nonconformingEntryPo.setCshanereasons2(nonconformingEntryArrayPo.getCshanereasons2()[i]);
			nonconformingEntryPo.setCshaneremark(nonconformingEntryArrayPo.getCshaneremark()[i]);
			nonconformingEntryPo.setCshanesalesdetailid(nonconformingEntryArrayPo.getCshanesalesdetailid()[i]);
			nonconformingEntryPo.setCshaneconsignmode(nonconformingEntryArrayPo.getCshaneconsignmode()[i]);
			nonconformingEntryPo.setCshanegoodsquantity(nonconformingEntryArrayPo.getCshanesgoodsquantity()[i]);
			nonconformingEntryList.add(nonconformingEntryPo);
			// 生成负调拨单2--------------------------------------------------------------------------
			AllocationEntryPo allocationEntryPo = new AllocationEntryPo();
			allocationEntryPo.setCshaaebillid("ALLN"+nonconformingPo.getCshanbillid().substring(4));
			allocationEntryPo.setCshaaegoodsid(nonconformingEntryArrayPo.getCshanegoodsid()[i]);
			allocationEntryPo.setCshaaGoodsBarCode(nonconformingEntryArrayPo.getCshanebarcode()[i]);
			allocationEntryPo.setCshaaoutstockid(nonconformingPo.getCshanoutstockid());
			
			if("3".equals(personInfoPo.getDepartmenttype())){
				allocationEntryPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid11());
			}else{
				allocationEntryPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid14());
			}
			
			allocationEntryPo.setCshaaerequirementquantity(nonconformingEntryPo.getCshanegoodsquantity());
			allocationEntryPo.setCshaaeallocationquantity(nonconformingEntryPo.getCshanegoodsquantity());
			
			list.add(allocationEntryPo);
		}
		
		// 生成负调拨单3--------------------------------------------------------------------------
		SmsLertsPo smsLertsPo=new SmsLertsPo();
		
		LogisticsLogPo logPo1 = new LogisticsLogPo();
		logPo1.setsLogName(personInfoPo.getId());
		logPo1.setsLogIP(request.getRemoteAddr());
		logPo1.setsLogResult(moduleID); // 模块ID
		logPo1.setsLogOpID("1");    //新增
		logPo1.setsLogContent("不合格品转调拨："+allocationPo.getCshaabillid()+"新增");
		
		// 生成负调拨单3--------------------------------------------------------------------------
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		if("1".equals(nonconformingPo.getCshanauditstate())){
			logPo.setsLogOpID("4");    // 审核
		}else{
			logPo.setsLogOpID("1");    // 新增
		}
		
		logPo.setsLogContent("不合格品单："+nonconformingPo.getCshanbillid()+"新增");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		
		nonconformingMgr.insertNonconforming(nonconformingPo,nonconformingEntryList,logPo,allocationPo, list, smsLertsPo, null,logPo1);
		
		this.clearMessages();
		if ("1".equals(Utility.getName(nonconformingPo.getCshanauditstate()))) {
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			String url = "''initNonconformingDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(nonconformingPo.getCshanbillid().trim());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			String url = "''initNonconformingUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(nonconformingPo.getCshanbillid().trim());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
	}

	/**
	 * 不合格品单详细
	 */
	public String initNonconformingDetails() throws Exception {

		String id = Utility.getName(request.getParameter("hid"));

		nonconformingPo = new NonconformingPo();
		nonconformingPo.setCshanbillid(id);
		nonconformingPo = nonconformingMgr.getNonconforming(nonconformingPo);

		nonconformingEntryList = nonconformingMgr.getNonconformingEntryList(nonconformingPo);
		SalesBasicPo salesBasicPo = nonconformingMgr.getSalesBasicPo(nonconformingPo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		request.setAttribute("salesBasicPo", salesBasicPo);
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(nonconformingPo.getCshandepartmentid());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehousePos = warehouseMgr.getWarehouseList(deppo);
		
		return SUCCESS;
	}

	/**
	 * 初始化不合格品单修改
	 */
	public String initNonconformingUpdate() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		
		String id = Utility.getName(request.getParameter("hid"));
		nonconformingPo = new NonconformingPo();
		nonconformingPo.setCshanbillid(id);
		nonconformingPo = nonconformingMgr.getNonconforming(nonconformingPo);
		nonconformingEntryList = nonconformingMgr
				.getNonconformingEntryList(nonconformingPo);

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());

		warehousePos = warehouseMgr.getWarehouseList(deppo);
		nonconformingProductPo = new NonconformingProductPo();
		nonconformingProductMaxList = nonconformingProductMgr.getNonconformingProductMaxList();
		
		//获得本部门下的人员（责任人）
		responsibilityList = personInfoMgr.getResponsibility(nonconformingPo.getCshandepartmentid());
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		request.setAttribute("departmenttype",personInfoPo.getDepartmenttype() );

		return SUCCESS;
	}

	/**
	 * 修改不合格品单
	 */
	public String updateNonconforming() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		if ("".equals(Utility.getName(nonconformingPo.getCshanauditstate()))) {
			nonconformingPo.setCshanauditstate("0");
		}
		if ("1".equals(Utility.getName(nonconformingPo.getCshanauditstate()))) {
			nonconformingPo.setCshanauditperson(personInfoPo.getId());
		}
		// 生成负调拨单1--------------------------------------------------------------------------
		AllocationPo allocationPo = new AllocationPo();
		allocationPo.setCshaaauditstate("1");
		warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		if("3".equals(personInfoPo.getDepartmenttype())){
			warehouseConfigurationPo = departmentsMgr.getDefaultWarehouse(warehouseConfigurationPo);
		}else{
			warehouseConfigurationPo = warehouseConfigurationMgr.getInWarehouseConfiguration(warehouseConfigurationPo);
		}
		allocationPo.setCshaaauditperson(nonconformingPo.getCshancreateperson());
		
		nonconformingEntryList = new ArrayList<NonconformingEntryPo>();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowtime = sdf.format(now);
		allocationPo.setCshaabillid("ALLN"+nonconformingPo.getCshanbillid().substring(4));
		allocationPo.setCshaabilldate(nowtime);
		allocationPo.setCshaaoutdepartmentid(nonconformingPo.getCshandepartmentid());
		allocationPo.setCshaaoutstockid(nonconformingPo.getCshanoutstockid());
		
		WarehousePo inpo = new WarehousePo();
		if("3".equals(personInfoPo.getDepartmenttype())){
			inpo.setBwhid(warehouseConfigurationPo.getBwcstockid11());
		}else{
			inpo.setBwhid(warehouseConfigurationPo.getBwcstockid14());
		}
		WarehousePo inwarehousepo = warehouseMgr.getWarehouse(inpo);
		
		allocationPo.setCshaaindepartmentid(inwarehousepo.getBwhdeptid());
		if("3".equals(personInfoPo.getDepartmenttype())){
			allocationPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid11());
		}else{
			allocationPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid14());
		}
		allocationPo.setCshaacreateperson(personInfoPo.getId());
		allocationPo.setCshaaauditperson("");
		allocationPo.setCshaaauditstate("0");
		allocationPo.setCshaaauditdate("");
		allocationPo.setCshaaconsignee("");
		allocationPo.setCshaaconsignstate("");
		allocationPo.setCshaaremark("不合格品自动导入单据");
		allocationPo.setCshaaflag("1");
		allocationPo.setChaasupplier("");
		allocationPo.setCshaabillassociation(nonconformingPo.getCshanbillid());
		allocationPo.setCshaaconsignee(personInfoPo.getId().trim());

		List<AllocationEntryPo> list = new ArrayList<AllocationEntryPo>();
		
		nonconformingEntryList = new ArrayList<NonconformingEntryPo>();
		// 循环取隐藏域中的值
		int lenth = nonconformingEntryArrayPo.getCshanegoodsid().length;
		for (int i = 0; i < lenth; i++) {
			NonconformingEntryPo nonconformingEntryPo = new NonconformingEntryPo();
			nonconformingEntryPo.setCshanebillid(nonconformingPo
					.getCshanbillid());
			nonconformingEntryPo.setCshanegoodsid(nonconformingEntryArrayPo
					.getCshanegoodsid()[i]);
			nonconformingEntryPo.setCshanegoodsname(nonconformingEntryArrayPo
					.getCshanegoodsname()[i]);
			nonconformingEntryPo.setCshanebarcode(nonconformingEntryArrayPo
					.getCshanebarcode()[i]);
			nonconformingEntryPo.setCshanegoodstype("123");
			nonconformingEntryPo.setCshanereasons1(nonconformingEntryArrayPo
					.getCshanereasons1()[i]);
			nonconformingEntryPo.setCshanereasons2(nonconformingEntryArrayPo
					.getCshanereasons2()[i]);
			nonconformingEntryPo.setCshaneremark(nonconformingEntryArrayPo
					.getCshaneremark()[i]);
			nonconformingEntryPo
					.setCshanesalesdetailid(nonconformingEntryArrayPo
							.getCshanesalesdetailid()[i]);
			nonconformingEntryPo.setCshaneconsignmode(nonconformingEntryArrayPo
					.getCshaneconsignmode()[i]);
			nonconformingEntryPo.setCshanegoodsquantity(nonconformingEntryArrayPo
					.getCshanesgoodsquantity()[i]);
			nonconformingEntryList.add(nonconformingEntryPo);
			// 生成负调拨单2--------------------------------------------------------------------------
			AllocationEntryPo allocationEntryPo = new AllocationEntryPo();
			allocationEntryPo.setCshaaebillid("ALLN"+nonconformingPo.getCshanbillid().substring(4));
			allocationEntryPo.setCshaaegoodsid(nonconformingEntryArrayPo
					.getCshanegoodsid()[i]);
			allocationEntryPo.setCshaaGoodsBarCode(nonconformingEntryArrayPo
					.getCshanebarcode()[i]);
			allocationEntryPo.setCshaaoutstockid(nonconformingPo.getCshanoutstockid());
			
			if("3".equals(personInfoPo.getDepartmenttype())){
				allocationEntryPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid11());
			}else{
				allocationEntryPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid14());
			}
			
			allocationEntryPo.setCshaaerequirementquantity(nonconformingEntryPo.getCshanegoodsquantity());
			allocationEntryPo.setCshaaeallocationquantity(nonconformingEntryPo.getCshanegoodsquantity());
			list.add(allocationEntryPo);
			
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		// 生成负调拨单3--------------------------------------------------------------------------
		SmsLertsPo smsLertsPo=new SmsLertsPo();
		
		LogisticsLogPo logPo1 = new LogisticsLogPo();
		logPo1.setsLogName(personInfoPo.getId());
		logPo1.setsLogIP(request.getRemoteAddr());
		logPo1.setsLogResult(moduleID); // 模块ID
		logPo1.setsLogOpID("1");    //新增
		logPo1.setsLogContent("不合格品转调拨："+allocationPo.getCshaabillid()+"新增");
		
		// 生成负调拨单3--------------------------------------------------------------------------
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		if("1".equals(nonconformingPo.getCshanauditstate())){
			logPo.setsLogOpID("4");    // 修改
		}else{
			logPo.setsLogOpID("3");    // 修改
		}
		
		logPo.setsLogContent("不合格品单："+nonconformingPo.getCshanbillid()+"修改");
		
		nonconformingMgr.updateNonconforming(nonconformingPo,nonconformingEntryList, "0",logPo,allocationPo, list, smsLertsPo, null,logPo1);
	
		this.clearMessages();
		if ("1".equals(Utility.getName(nonconformingPo.getCshanauditstate()))) {
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			String url = "''initNonconformingDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(nonconformingPo.getCshanbillid().trim());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			String url = "''initNonconformingUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(nonconformingPo.getCshanbillid().trim());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
	}

	/**
	 * 初始化不合格品单删除
	 */
	public String initNonconformingDelete() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id = Utility.getName(request.getParameter("hid"));
		NonconformingPo po = new NonconformingPo();
		po.setCshanbillid(id);
		nonconformingPo = nonconformingMgr.getNonconforming(po);

		return SUCCESS;
	}

	/**
	 * 删除不合格品单
	 */
	public String deleteNonconforming() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		String id = Utility.getName(request.getParameter("hid"));
		NonconformingPo po = new NonconformingPo();
		po.setCshanbillid(id);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 删除
		logPo.setsLogContent("不合格品单："+nonconformingPo.getCshanbillid()+"删除");
		
		nonconformingMgr.deleteNonconforming(po,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 取得Ajax数据
	 */
	public void getAjaxDate() throws Exception {

		String fnpid = Utility.getName(request.getParameter("fnpid"));
		String id = Utility.getName(request.getParameter("id"));
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();

		if (fnpid.equals("")) {
			out.println("<option value=''>请选择所属现象(0)</option>");
		} else {
			NonconformingProductPo tmp = new NonconformingProductPo();
			tmp.setFnpparented(fnpid);
			nonconformingProductMinList = nonconformingProductMgr
					.getNonconformingProductMinList(tmp);
			Iterator it = nonconformingProductMinList.iterator();
			out.println("<option value=''>请选择所属现象("
					+ nonconformingProductMinList.size() + ")</option>");
			if (it.hasNext()) {
				while (it.hasNext()) {
					NonconformingProductPo tmpPo = (NonconformingProductPo) it
							.next();
					out.println("<option value='" + tmpPo.getFnpid() + "'>"
							+ tmpPo.getFnpcontent() + "</option>");
				}
			}
		}
		out.close();
	}

	public String initNonconformingDo() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id = Utility.getName(request.getParameter("hid"));
		nonconformingPo = new NonconformingPo();
		nonconformingPo.setCshanbillid(id);
		nonconformingPo = nonconformingMgr.getNonconforming(nonconformingPo);
		nonconformingEntryList = nonconformingMgr.getNonconformingEntryList(nonconformingPo);

		// 取得登陆人允许操作的仓位&部门 Begin
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);
		// 取得登陆人允许操作的仓位&部门 End

		nonconformingProductPo = new NonconformingProductPo();
		nonconformingProductMaxList = nonconformingProductMgr.getNonconformingProductMaxList();
		
		return SUCCESS;
	}

	public String doNonconforming() throws Exception {
		
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		WarehouseConfigurationPo wpo = new WarehouseConfigurationPo();
		wpo.setBwcdeptid(personInfoPo.getDepartmentID());
		wpo = departmentsMgr.getDefaultWarehouseByDpt(wpo);
		
		nonconformingEntryList = new ArrayList<NonconformingEntryPo>();
		List<AllocationEntryPo> elist = new ArrayList<AllocationEntryPo>();
		
		int lenth = nonconformingEntryArrayPo.getCshanegoodsid().length;
		for (int i = 0; i < lenth; i++) {
			NonconformingEntryPo nonconformingEntryPo = new NonconformingEntryPo();
			nonconformingEntryPo.setCshanebillid(nonconformingPo.getCshanbillid());
			nonconformingEntryPo.setCshanegoodsid(nonconformingEntryArrayPo.getCshanegoodsid()[i]);
			nonconformingEntryPo.setCshanegoodsname(nonconformingEntryArrayPo.getCshanegoodsname()[i]);
			nonconformingEntryPo.setCshanebarcode(nonconformingEntryArrayPo.getCshanebarcode()[i]);
			nonconformingEntryPo.setCshanegoodstype("123");
			nonconformingEntryPo.setCshanereasons1(nonconformingEntryArrayPo.getCshanereasons1()[i]);
			nonconformingEntryPo.setCshanereasons2(nonconformingEntryArrayPo.getCshanereasons2()[i]);
			nonconformingEntryPo.setCshaneremark(nonconformingEntryArrayPo.getCshaneremark()[i]);
			nonconformingEntryPo.setCshaneconsignmode(nonconformingEntryArrayPo.getCshaneconsignmode()[i]);
			nonconformingEntryPo.setCshanesalesdetailid(nonconformingEntryArrayPo.getCshanesalesdetailid()[i]);
			nonconformingEntryPo.setCshanegoodsquantity(nonconformingEntryArrayPo.getCshanesgoodsquantity()[i]);
			
			nonconformingEntryList.add(nonconformingEntryPo);
			
			AllocationEntryPo epo = new AllocationEntryPo();
			epo.setCshaaebillid(nonconformingPo.getCshanbillid().replaceFirst("NCP", "ALLN"));
			epo.setCshaaegoodsid(nonconformingEntryArrayPo.getCshanegoodsid()[i]);
			epo.setCshaaegoodsBarCode(nonconformingEntryArrayPo.getCshanebarcode()[i]);
			epo.setCshaaoutstockid(Utility.getName(nonconformingPo.getCshanoutstockid()));
			epo.setCshaainstockid(Utility.getName(wpo.getBwcstockid11()));
			epo.setCshaaeallocationquantity(nonconformingEntryArrayPo.getCshanesgoodsquantity()[i]);		
			epo.setCshaaeoutstorageflag("1");			
			
			elist.add(epo);
		}
		
		if(Utility.getName(systemParameterPo.getFspsalestype()).equals("0") && Utility.getName(systemParameterPo.getFspnongallocation()).equals("1")){   // 不允许负库存
			String errorBarcode = "";
			for(int i = 0; i < elist.size(); i++){
				GoodsInfoPo goodspo = new GoodsInfoPo();
				goodspo.setBgiwarehouseid(elist.get(i).getCshaaoutstockid());
				goodspo.setBgigoodsbarcode(elist.get(i).getCshaaegoodsBarCode());
				goodspo.setBgiallBillid(elist.get(i).getCshaaebillid());
				
				List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
				
				if(Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity())<Integer.parseInt(elist.get(i).getCshaaeallocationquantity())){
					errorBarcode = errorBarcode + elist.get(i).getCshaaegoodsBarCode() + "\\n";
				}
			}
			
			if(!errorBarcode.equals("")){
				String id = Utility.getName(nonconformingPo.getCshanbillid());
				nonconformingPo = new NonconformingPo();
				nonconformingPo.setCshanbillid(id);
				nonconformingPo = nonconformingMgr.getNonconforming(nonconformingPo);
				nonconformingEntryList = nonconformingMgr.getNonconformingEntryList(nonconformingPo);

				// 取得登陆人允许操作的仓位&部门 Begin
				DepartmentsPo deppo = new DepartmentsPo();
				deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
				deppo.setBdptype(personInfoPo.getDepartmenttype());
				deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
				departmentsList = departmentsMgr.getDepartments(deppo);
				// 取得登陆人允许操作的仓位&部门 End

				nonconformingProductPo = new NonconformingProductPo();
				nonconformingProductMaxList = nonconformingProductMgr.getNonconformingProductMaxList();
			
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				
				return "error";
			}
		}
				
		nonconformingPo.setCshanconsignperson(personInfoPo.getId());
		nonconformingPo.setCshanconsigndeparmentid(personInfoPo.getDepartmentID());
		nonconformingPo.setCshanautoallocation(systemParameterPo.getFspnongallocation()); // 不合格品自动调拨
		nonconformingPo.setCshaninstockid(Utility.getName(wpo.getBwcstockid11()));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("30");    //处理  
		logPo.setsLogContent("不合格品单："+nonconformingPo.getCshanbillid()+"处理");
		
		nonconformingMgr.updateNonconforming(nonconformingPo,nonconformingEntryList, "1",logPo,elist);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	/**
	 * 不合格品汇总初始化页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initNonconformingSummarySel() throws Exception {

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

		return SUCCESS;// nonconformingList
	}

	/**
	 * 不合格品汇总查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selNonconformingSummary() throws Exception {

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

		String cshanstartTime = Utility.getName(request
				.getParameter("cshanstartTime"));
		String cshanendTime = Utility.getName(request
				.getParameter("cshanendTime"));

		nonconformingList = nonconformingMgr.getNonconformingList(personInfoPo
				.getDepartmentID(), cshanstartTime, cshanendTime);

		request.setAttribute("cshanstartTime", cshanstartTime);
		request.setAttribute("cshanendTime", cshanendTime);

		return SUCCESS;
	}

	/**
	 * 不合格品汇总汇总
	 * 
	 * @return
	 * @throws Exception
	 */
	public String summaryNonconforming() throws Exception {

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

		String cshanstartTime = Utility.getName(request
				.getParameter("cshanstartTime"));
		String cshanendTime = Utility.getName(request
				.getParameter("cshanendTime"));

		WarehousePo warehousePo = new WarehousePo();
		warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
		List<WarehousePo> warehouseList = warehouseMgr
				.getWarehouseList(warehousePo);

		String billID = "ALL"
				+ GenerateNumber.getInstance().getGenerageNumber();
		AllocationPo allocationPo = new AllocationPo();
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaoutdepartmentid(personInfoPo.getDepartmentID());
		allocationPo.setCshaaoutstockid(warehouseList.get(0).getBwhid());
		allocationPo.setCshaacreateperson(personInfoPo.getId());
		allocationPo.setCshaaauditperson(personInfoPo.getId());

		nonconformingMgr.summaryAllocation(allocationPo, cshanbillid);

		request.setAttribute("cshanstartTime", cshanstartTime);
		request.setAttribute("cshanendTime", cshanendTime);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.nonconforming.summary.update",new String[] { billID }));

		return SUCCESS;
	}
	
	/**
	 * 初始化不合格品单查询
	 */
	public String initNonconformingSelTR() throws Exception {

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

		// 取得登陆人允许操作的仓位&部门 Begin
		// PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);
		goodsCategorys = varietyMgr.getGoodsCategorys();
		// 取得登陆人允许操作的仓位&部门 End

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "formingSel";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询不合格品单
	 */
	public String selNonconformingTR() throws Exception {

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

		// 得到查询条件
		String billID = Utility.getName(request.getParameter("billID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
//		String consignMode = Utility.getName(request.getParameter("consignMode"));
		String departmentid = Utility.getName(request.getParameter("departmentid"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String createPersonName = Utility.getName(request.getParameter("createPersonName"));
		String cstpcreateperson = Utility.getName(request.getParameter("cstpcreateperson"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String cstpauditperson = Utility.getName(request.getParameter("cstpauditperson"));
		String responsibility = Utility.getName(request.getParameter("responsibility"));
		String responsibilityID = Utility.getName(request.getParameter("responsibilityID"));

		// 制造商 、品种 id及name
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));

		// 获取镜片类型
		String iscustomize = Utility.getName(request.getParameter("iscustomize"));
		String cshanlinkbillID = Utility.getName(request.getParameter("cshanlinkbillID"));
		String cshaneconsignmode = Utility.getName(request.getParameter("cshaneconsignmode"));
		// 放入PO 中
		NonconformingPo po = new NonconformingPo();
		po.setCshanbillid(billID);
		po.setCshanstartTime(startTime);
		po.setCshanendTime(endTime);
		po.setCshanconsignmode(cshaneconsignmode);
		po.setCshandepartmentid(departmentid);
		po.setCshanauditstate(auditState);
		po.setCshancreatepersonname(createPersonName);
		po.setCshancreateperson(cstpcreateperson);
		po.setCshanauditpersonname(auditPersonName);
		po.setCshanauditperson(cstpauditperson);
		po.setCshansupplierid(supplierID);
		po.setCshanbrandid(brandID);
		po.setCshandepartmentname(personInfoPo.getDepartmenttype() + "," + personInfoPo.getDepartmentID());
		po.setIscustomize(iscustomize);
		po.setCshanlinkbillID(cshanlinkbillID);
		po.setCshanresponsibilityperson(responsibility);
		
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

		// 查询分页
		int count = nonconformingMgr.getNonconformingCount(po);
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
			nonconformingList = nonconformingMgr.getNonconformingList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			nonconformingList = null;
		}

		request.setAttribute("billID", billID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("cshaneconsignmode", cshaneconsignmode);
		request.setAttribute("departmentid", departmentid);
		request.setAttribute("auditState", auditState);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("cstpcreateperson", cstpcreateperson);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("cstpauditperson", cstpauditperson);
		request.setAttribute("cshanlinkbillID", cshanlinkbillID);
		request.setAttribute("responsibility", responsibility);
		request.setAttribute("responsibilityID", responsibilityID);
		// 页面存制造商及品种的id和name
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);

		// 页面存镜片类型
		request.setAttribute("iscustomize", iscustomize);

		// 取得登陆人允许操作的仓位&部门 Begin
		// PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);
		goodsCategorys = varietyMgr.getGoodsCategorys();
		// 取得登陆人允许操作的仓位&部门 End

		
		return SUCCESS;
	}

	/**
	 * 初始化不合格品单新增
	 */
	public String initNonconformingInsertTR() throws Exception {
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
		
		nonconformingPo = new NonconformingPo();

		nonconformingPo.setCshanbillid("NCP" + GenerateNumber.getInstance().getGenerageNumber());

		// 取得登陆人允许操作的仓位&部门 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype("2");
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		
		request.setAttribute("departmenttype",personInfoPo.getDepartmenttype() );
		
		warehousePos = warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		// 取得登陆人允许操作的仓位&部门 End
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		nonconformingProductPo = new NonconformingProductPo();
		nonconformingProductMaxList = nonconformingProductMgr.getNonconformingProductMaxList();
		//获得本部门下的人员（责任人）
		responsibilityList = personInfoMgr.getResponsibility(personInfoPo.getDepartmentID());
		
		return SUCCESS;
	}

	/**
	 * 新增不合格品单
	 */
	public String insertNonconformingTR() throws Exception {
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
		
		request.setAttribute("departmenttype",personInfoPo.getDepartmenttype() );
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		// 判断是否选中审核复选框
		if ("".equals(Utility.getName(nonconformingPo.getCshanauditstate()))) {
			nonconformingPo.setCshanauditstate("0");
		}
		if ("1".equals(Utility.getName(nonconformingPo.getCshanauditstate()))) {
			nonconformingPo.setCshanauditperson(nonconformingPo
					.getCshancreateperson());
		}
		nonconformingPo.setCshandepartmentid(personInfoPo.getDepartmentID());

		String cshanlinkbillID = Utility.getName(request
				.getParameter("bsalesid"));
		nonconformingPo.setCshanlinkbillID(cshanlinkbillID);
		nonconformingEntryList = new ArrayList<NonconformingEntryPo>();
		
		// 生成负调拨单1--------------------------------------------------------------------------
		AllocationPo allocationPo = new AllocationPo();
		allocationPo.setCshaaauditstate("1");
		warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		if("3".equals(personInfoPo.getDepartmenttype())){
			warehouseConfigurationPo = departmentsMgr.getDefaultWarehouse(warehouseConfigurationPo);
		}else{
			warehouseConfigurationPo = warehouseConfigurationMgr.getInWarehouseConfiguration(warehouseConfigurationPo);
		}
		
		allocationPo.setCshaaauditperson(nonconformingPo.getCshancreateperson());
		
		nonconformingEntryList = new ArrayList<NonconformingEntryPo>();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowtime = sdf.format(now);
		allocationPo.setCshaabillid("ALLN"+nonconformingPo.getCshanbillid().substring(4));
		allocationPo.setCshaabilldate(nowtime);
		allocationPo.setCshaaoutdepartmentid(nonconformingPo.getCshandepartmentid());
		WarehousePo warehousePo = nonconformingMgr.getWarehousePo(nonconformingPo.getCshandepartmentid());
		allocationPo.setCshaaoutstockid(nonconformingPo.getCshanoutstockid());
		
		WarehousePo inpo = new WarehousePo();
		if("3".equals(personInfoPo.getDepartmenttype())){
			inpo.setBwhid(warehouseConfigurationPo.getBwcstockid11());
		}else{
			inpo.setBwhid(warehouseConfigurationPo.getBwcstockid14());
		}
		WarehousePo inwarehousepo = warehouseMgr.getWarehouse(inpo);
		
		allocationPo.setCshaaindepartmentid(inwarehousepo.getBwhdeptid());
		if("3".equals(personInfoPo.getDepartmenttype())){
			allocationPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid11());
		}else{
			allocationPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid14());
		}
		allocationPo.setCshaacreateperson(personInfoPo.getId());
		allocationPo.setCshaaauditperson("");
		allocationPo.setCshaaauditstate("0");
		allocationPo.setCshaaauditdate("");
		allocationPo.setCshaaconsignee("");
		allocationPo.setCshaaconsignstate("");
		allocationPo.setCshaaremark("不合格品自动导入单据");
		allocationPo.setCshaaflag("2");
		allocationPo.setChaasupplier("");
		allocationPo.setCshaabillassociation(nonconformingPo.getCshanbillid());
		allocationPo.setCshaaconsignee(personInfoPo.getId().trim());

		List<AllocationEntryPo> list = new ArrayList<AllocationEntryPo>();
		
		// 生成负调拨单1--------------------------------------------------------------------------
		

		// 循环取出隐藏域中的值
		int lenth = nonconformingEntryArrayPo.getCshanegoodsid().length;
		for (int i = 0; i < lenth; i++) {
			NonconformingEntryPo nonconformingEntryPo = new NonconformingEntryPo();
			nonconformingEntryPo.setCshanebillid(nonconformingPo
					.getCshanbillid());
			nonconformingEntryPo.setCshanegoodsid(nonconformingEntryArrayPo
					.getCshanegoodsid()[i]);
			nonconformingEntryPo.setCshanegoodsname(nonconformingEntryArrayPo
					.getCshanegoodsname()[i]);
			nonconformingEntryPo.setCshanebarcode(nonconformingEntryArrayPo
					.getCshanebarcode()[i]);
			nonconformingEntryPo.setCshanegoodstype("123");
			nonconformingEntryPo.setCshanereasons1(nonconformingEntryArrayPo
					.getCshanereasons1()[i]);
			nonconformingEntryPo.setCshanereasons2(nonconformingEntryArrayPo
					.getCshanereasons2()[i]);
			nonconformingEntryPo.setCshaneremark(nonconformingEntryArrayPo
					.getCshaneremark()[i]);
			nonconformingEntryPo
					.setCshanesalesdetailid(nonconformingEntryArrayPo
							.getCshanesalesdetailid()[i]);
			nonconformingEntryPo.setCshaneconsignmode(nonconformingEntryArrayPo
							.getCshaneconsignmode()[i]);
			
			nonconformingEntryPo.setCshanegoodsquantity(nonconformingEntryArrayPo
					.getCshanesgoodsquantity()[i]);
			nonconformingEntryList.add(nonconformingEntryPo);
			// 生成负调拨单2--------------------------------------------------------------------------
			AllocationEntryPo allocationEntryPo = new AllocationEntryPo();
			allocationEntryPo.setCshaaebillid("ALLN"+nonconformingPo.getCshanbillid().substring(4));
			allocationEntryPo.setCshaaegoodsid(nonconformingEntryArrayPo
					.getCshanegoodsid()[i]);
			allocationEntryPo.setCshaaGoodsBarCode(nonconformingEntryArrayPo
					.getCshanebarcode()[i]);
			allocationEntryPo.setCshaaoutstockid(nonconformingPo.getCshanoutstockid());
			
			if("3".equals(personInfoPo.getDepartmenttype())){
				allocationEntryPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid11());
			}else{
				allocationEntryPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid14());
			}
			
			allocationEntryPo.setCshaaerequirementquantity(nonconformingEntryPo.getCshanegoodsquantity());
			allocationEntryPo.setCshaaeallocationquantity(nonconformingEntryPo.getCshanegoodsquantity());
			
			list.add(allocationEntryPo);
		}
		
		if(systemParameterPo.getFspsalestype().equals("0") && Utility.getName(nonconformingPo.getCshanisallocation()).equals("1")){
			String errorBarcode = "";
			for(int i=0;i<list.size(); i++){
				GoodsInfoPo goodspo = new GoodsInfoPo();
				goodspo.setBgiwarehouseid(list.get(i).getCshaaoutstockid());
				goodspo.setBgigoodsbarcode(list.get(i).getCshaaGoodsBarCode());
				goodspo.setBgiallBillid(allocationPo.getCshaabillid());
				List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
				if(Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity())<Integer.parseInt(list.get(i).getCshaaeallocationquantity())){
					errorBarcode = errorBarcode + list.get(i).getCshaaGoodsBarCode()+"\\n";
				}
			}
			
			if(!errorBarcode.equals("")){
				// 取得登陆人允许操作的仓位&部门 Begin
				DepartmentsPo deppo = new DepartmentsPo();
				deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
				deppo.setBdptype("2");
				deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
				
				request.setAttribute("departmenttype",personInfoPo.getDepartmenttype() );
				
				warehousePos = warehouseMgr.getWarehouseList(deppo);
				departmentsList = departmentsMgr.getDepartments(deppo);
				// 取得登陆人允许操作的仓位&部门 End
				systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
				request.setAttribute("systemParameterPo", systemParameterPo);
				nonconformingProductPo = new NonconformingProductPo();
				nonconformingProductMaxList = nonconformingProductMgr.getNonconformingProductMaxList();
				//获得本部门下的人员（责任人）
				responsibilityList = personInfoMgr.getResponsibility(personInfoPo.getDepartmentID());
				
				NonconformingProductPo tmp = new NonconformingProductPo();
				nonconformingProductMinList = nonconformingProductMgr.getNonconformingProductMinList(tmp);				
				
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				return "error";
			}
		}
		
		// 生成负调拨单3--------------------------------------------------------------------------
		SmsLertsPo smsLertsPo=new SmsLertsPo();
		
		LogisticsLogPo logPo1 = new LogisticsLogPo();
		logPo1.setsLogName(personInfoPo.getId());
		logPo1.setsLogIP(request.getRemoteAddr());
		logPo1.setsLogResult(moduleID); // 模块ID
		logPo1.setsLogOpID("1");    //新增
		logPo1.setsLogContent("不合格品转调拨："+allocationPo.getCshaabillid()+"新增");
		
		// 生成负调拨单3--------------------------------------------------------------------------
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		if("1".equals(nonconformingPo.getCshanauditstate())){
			logPo.setsLogOpID("4");    // 审核
		}else{
			logPo.setsLogOpID("1");    // 新增
		}
		
		logPo.setsLogContent("不合格品单："+nonconformingPo.getCshanbillid()+"新增");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		
		nonconformingMgr.insertNonconforming(nonconformingPo,nonconformingEntryList,logPo,allocationPo, list, smsLertsPo, null,logPo1);
		
		this.clearMessages();
		if ("1".equals(Utility.getName(nonconformingPo.getCshanauditstate()))) {
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			String url = "''initNonconformingDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(nonconformingPo.getCshanbillid().trim());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			String url = "''initNonconformingUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(nonconformingPo.getCshanbillid().trim());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
	}
	
	/**
	 * 初始化不合格品单修改
	 */
	public String initNonconformingUpdateTR() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		
		String id = Utility.getName(request.getParameter("hid"));
		nonconformingPo = new NonconformingPo();
		nonconformingPo.setCshanbillid(id);
		nonconformingPo = nonconformingMgr.getNonconforming(nonconformingPo);
		nonconformingEntryList = nonconformingMgr
				.getNonconformingEntryList(nonconformingPo);

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());

		warehousePos = warehouseMgr.getWarehouseList(deppo);
		nonconformingProductPo = new NonconformingProductPo();
		nonconformingProductMaxList = nonconformingProductMgr.getNonconformingProductMaxList();
		
		//获得本部门下的人员（责任人）
		responsibilityList = personInfoMgr.getResponsibility(nonconformingPo.getCshandepartmentid());
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		request.setAttribute("departmenttype",personInfoPo.getDepartmenttype() );

		return SUCCESS;
	}

	/**
	 * 修改不合格品单
	 */
	public String updateNonconformingTR() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		if ("".equals(Utility.getName(nonconformingPo.getCshanauditstate()))) {
			nonconformingPo.setCshanauditstate("0");
		}
		if ("1".equals(Utility.getName(nonconformingPo.getCshanauditstate()))) {
			nonconformingPo.setCshanauditperson(personInfoPo.getId());
		}
		// 生成负调拨单1--------------------------------------------------------------------------
		AllocationPo allocationPo = new AllocationPo();
		allocationPo.setCshaaauditstate("1");
		warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		if("3".equals(personInfoPo.getDepartmenttype())){
			warehouseConfigurationPo = departmentsMgr.getDefaultWarehouse(warehouseConfigurationPo);
		}else{
			warehouseConfigurationPo = warehouseConfigurationMgr.getInWarehouseConfiguration(warehouseConfigurationPo);
		}
		allocationPo.setCshaaauditperson(nonconformingPo.getCshancreateperson());
		
		nonconformingEntryList = new ArrayList<NonconformingEntryPo>();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowtime = sdf.format(now);
		allocationPo.setCshaabillid("ALLN"+nonconformingPo.getCshanbillid().substring(4));
		allocationPo.setCshaabilldate(nowtime);
		allocationPo.setCshaaoutdepartmentid(nonconformingPo.getCshandepartmentid());
		allocationPo.setCshaaoutstockid(nonconformingPo.getCshanoutstockid());
		
		WarehousePo inpo = new WarehousePo();
		if("3".equals(personInfoPo.getDepartmenttype())){
			inpo.setBwhid(warehouseConfigurationPo.getBwcstockid11());
		}else{
			inpo.setBwhid(warehouseConfigurationPo.getBwcstockid14());
		}
		WarehousePo inwarehousepo = warehouseMgr.getWarehouse(inpo);
		
		allocationPo.setCshaaindepartmentid(inwarehousepo.getBwhdeptid());
		if("3".equals(personInfoPo.getDepartmenttype())){
			allocationPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid11());
		}else{
			allocationPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid14());
		}
		allocationPo.setCshaacreateperson(personInfoPo.getId());
		allocationPo.setCshaaauditperson("");
		allocationPo.setCshaaauditstate("0");
		allocationPo.setCshaaauditdate("");
		allocationPo.setCshaaconsignee("");
		allocationPo.setCshaaconsignstate("");
		allocationPo.setCshaaremark("不合格品自动导入单据");
		allocationPo.setCshaaflag("2");
		allocationPo.setChaasupplier("");
		allocationPo.setCshaabillassociation(nonconformingPo.getCshanbillid());
		allocationPo.setCshaaconsignee(personInfoPo.getId().trim());

		List<AllocationEntryPo> list = new ArrayList<AllocationEntryPo>();
		
		nonconformingEntryList = new ArrayList<NonconformingEntryPo>();
		// 循环取隐藏域中的值
		int lenth = nonconformingEntryArrayPo.getCshanegoodsid().length;
		for (int i = 0; i < lenth; i++) {
			NonconformingEntryPo nonconformingEntryPo = new NonconformingEntryPo();
			nonconformingEntryPo.setCshanebillid(nonconformingPo
					.getCshanbillid());
			nonconformingEntryPo.setCshanegoodsid(nonconformingEntryArrayPo
					.getCshanegoodsid()[i]);
			nonconformingEntryPo.setCshanegoodsname(nonconformingEntryArrayPo
					.getCshanegoodsname()[i]);
			nonconformingEntryPo.setCshanebarcode(nonconformingEntryArrayPo
					.getCshanebarcode()[i]);
			nonconformingEntryPo.setCshanegoodstype("123");
			nonconformingEntryPo.setCshanereasons1(nonconformingEntryArrayPo
					.getCshanereasons1()[i]);
			nonconformingEntryPo.setCshanereasons2(nonconformingEntryArrayPo
					.getCshanereasons2()[i]);
			nonconformingEntryPo.setCshaneremark(nonconformingEntryArrayPo
					.getCshaneremark()[i]);
			nonconformingEntryPo
					.setCshanesalesdetailid(nonconformingEntryArrayPo
							.getCshanesalesdetailid()[i]);
			nonconformingEntryPo.setCshaneconsignmode(nonconformingEntryArrayPo
					.getCshaneconsignmode()[i]);
			nonconformingEntryPo.setCshanegoodsquantity(nonconformingEntryArrayPo
					.getCshanesgoodsquantity()[i]);
			nonconformingEntryList.add(nonconformingEntryPo);
			// 生成负调拨单2--------------------------------------------------------------------------
			AllocationEntryPo allocationEntryPo = new AllocationEntryPo();
			allocationEntryPo.setCshaaebillid("ALLN"+nonconformingPo.getCshanbillid().substring(4));
			allocationEntryPo.setCshaaegoodsid(nonconformingEntryArrayPo
					.getCshanegoodsid()[i]);
			allocationEntryPo.setCshaaGoodsBarCode(nonconformingEntryArrayPo
					.getCshanebarcode()[i]);
			allocationEntryPo.setCshaaoutstockid(nonconformingPo.getCshanoutstockid());
			
			if("3".equals(personInfoPo.getDepartmenttype())){
				allocationEntryPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid11());
			}else{
				allocationEntryPo.setCshaainstockid(warehouseConfigurationPo.getBwcstockid14());
			}
			
			allocationEntryPo.setCshaaerequirementquantity(nonconformingEntryPo.getCshanegoodsquantity());
			allocationEntryPo.setCshaaeallocationquantity(nonconformingEntryPo.getCshanegoodsquantity());
			list.add(allocationEntryPo);
			
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		if(systemParameterPo.getFspsalestype().equals("0") && Utility.getName(nonconformingPo.getCshanisallocation()).equals("1")){
			String errorBarcode = "";
			for(int i=0;i<list.size(); i++){
				GoodsInfoPo goodspo = new GoodsInfoPo();
				goodspo.setBgiwarehouseid(list.get(i).getCshaaoutstockid());
				goodspo.setBgigoodsbarcode(list.get(i).getCshaaGoodsBarCode());
				goodspo.setBgiallBillid(allocationPo.getCshaabillid());
				List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
				if(Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity())<Integer.parseInt(list.get(i).getCshaaeallocationquantity())){
					errorBarcode = errorBarcode + list.get(i).getCshaaGoodsBarCode()+"\\n";
				}
			}
			
			if(!errorBarcode.equals("")){
				// 取得登陆人允许操作的仓位&部门 Begin
				DepartmentsPo deppo = new DepartmentsPo();
				deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
				deppo.setBdptype("2");
				deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
				
				request.setAttribute("departmenttype",personInfoPo.getDepartmenttype() );
				
				warehousePos = warehouseMgr.getWarehouseList(deppo);
				departmentsList = departmentsMgr.getDepartments(deppo);
				// 取得登陆人允许操作的仓位&部门 End
				systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
				request.setAttribute("systemParameterPo", systemParameterPo);
				nonconformingProductPo = new NonconformingProductPo();
				nonconformingProductMaxList = nonconformingProductMgr.getNonconformingProductMaxList();
				//获得本部门下的人员（责任人）
				responsibilityList = personInfoMgr.getResponsibility(personInfoPo.getDepartmentID());
				
				NonconformingProductPo tmp = new NonconformingProductPo();
				nonconformingProductMinList = nonconformingProductMgr.getNonconformingProductMinList(tmp);				
				
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);

				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				
				String url = "''initNonconformingUpdate.action?hid={0}&moduleID={1}''";
				List<String> params = new ArrayList<String>();
				params.add(nonconformingPo.getCshanbillid().trim());
				params.add(moduleID);

				request.setAttribute("url", MessageFormat.format(url, params.toArray()));
				request.setAttribute("flag", GlobalConstants.UPADTE);
				return SUCCESS;
			}
		}
		
		// 生成负调拨单3--------------------------------------------------------------------------
		SmsLertsPo smsLertsPo=new SmsLertsPo();
		
		LogisticsLogPo logPo1 = new LogisticsLogPo();
		logPo1.setsLogName(personInfoPo.getId());
		logPo1.setsLogIP(request.getRemoteAddr());
		logPo1.setsLogResult(moduleID); // 模块ID
		logPo1.setsLogOpID("1");    //新增
		logPo1.setsLogContent("不合格品转调拨："+allocationPo.getCshaabillid()+"新增");
		
		// 生成负调拨单3--------------------------------------------------------------------------
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		if("1".equals(nonconformingPo.getCshanauditstate())){
			logPo.setsLogOpID("4");    // 修改
		}else{
			logPo.setsLogOpID("3");    // 修改
		}
		
		logPo.setsLogContent("不合格品单："+nonconformingPo.getCshanbillid()+"修改");
		
		nonconformingMgr.updateNonconforming(nonconformingPo,nonconformingEntryList, "0",logPo,allocationPo, list, smsLertsPo, null,logPo1);
	
		this.clearMessages();
		if ("1".equals(Utility.getName(nonconformingPo.getCshanauditstate()))) {
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			String url = "''initNonconformingDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(nonconformingPo.getCshanbillid().trim());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			String url = "''initNonconformingUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(nonconformingPo.getCshanbillid().trim());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
	}

	public NonconformingEntryArrayPo getNonconformingEntryArrayPo() {
		return nonconformingEntryArrayPo;
	}

	public void setNonconformingEntryArrayPo(
			NonconformingEntryArrayPo nonconformingEntryArrayPo) {
		this.nonconformingEntryArrayPo = nonconformingEntryArrayPo;
	}
}
