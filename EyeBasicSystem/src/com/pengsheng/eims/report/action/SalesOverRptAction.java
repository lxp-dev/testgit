package com.pengsheng.eims.report.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.dao.impl.TechnologyTypePo;
import com.pengsheng.eims.basic.mgr.NonconformingProductMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.NonconformingProductPo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.report.mgr.LeaderBoardMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.mgr.StoreGoodsMgr;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.FrameMaterialMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class SalesOverRptAction extends BaseAction {
	
	private List<DepartmentsPo> departmentsList;	
    private VarietyMgr varietyMgr;	
    private UnitMgr unitMgr;
    private FrameMaterialMgr frameMaterialMgr;
	private List<GoodsCategoryPo> goodsCategorys;	
	private DepartmentsMgr departmentsMgr;	
	private List<DepartmentsPo> departmentsPos;	
	private StoreGoodsMgr storeGoodsMgr;	
	private SystemParameterPo systemParameterPo;	
	private SystemParameterMgr systemParameterMgr;
	private PersonPermissionMgr personPermissionMgr;
	private List<TechnologyTypePo> teachnologyList;
	private List<FrameMaterialPo> frameMaterialList;
	private List<RefractiveSetPo> refractiveSetPos;
	private LeaderBoardMgr leaderBoardMgr;
	private WarehouseMgr warehouseMgr;
	
	private List<NonconformingProductPo> nonconformingProductMaxList; // 不合格品原因List
	private NonconformingProductMgr nonconformingProductMgr;

	private List<WarehousePo> warehouselist;
	
	private CompanyNameMgr companyNameMgr;
	private List<CompanyNamePo> companyNamePos;
	
    public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}
	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}
	public List<CompanyNamePo> getCompanyNamePos() {
		return companyNamePos;
	}
	public void setCompanyNamePos(List<CompanyNamePo> companyNamePos) {
		this.companyNamePos = companyNamePos;
	}
	public List<NonconformingProductPo> getNonconformingProductMaxList() {
		return nonconformingProductMaxList;
	}
	public void setNonconformingProductMaxList(
			List<NonconformingProductPo> nonconformingProductMaxList) {
		this.nonconformingProductMaxList = nonconformingProductMaxList;
	}
	public NonconformingProductMgr getNonconformingProductMgr() {
		return nonconformingProductMgr;
	}
	public void setNonconformingProductMgr(
			NonconformingProductMgr nonconformingProductMgr) {
		this.nonconformingProductMgr = nonconformingProductMgr;
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
	public LeaderBoardMgr getLeaderBoardMgr() {
		return leaderBoardMgr;
	}
	public void setLeaderBoardMgr(LeaderBoardMgr leaderBoardMgr) {
		this.leaderBoardMgr = leaderBoardMgr;
	}
	public UnitMgr getUnitMgr() {
		return unitMgr;
	}
	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}
	public FrameMaterialMgr getFrameMaterialMgr() {
		return frameMaterialMgr;
	}
	public void setFrameMaterialMgr(FrameMaterialMgr frameMaterialMgr) {
		this.frameMaterialMgr = frameMaterialMgr;
	}
	public List<TechnologyTypePo> getTeachnologyList() {
		return teachnologyList;
	}
	public void setTeachnologyList(List<TechnologyTypePo> teachnologyList) {
		this.teachnologyList = teachnologyList;
	}
	public List<FrameMaterialPo> getFrameMaterialList() {
		return frameMaterialList;
	}
	public void setFrameMaterialList(List<FrameMaterialPo> frameMaterialList) {
		this.frameMaterialList = frameMaterialList;
	}
	public List<RefractiveSetPo> getRefractiveSetPos() {
		return refractiveSetPos;
	}
	public void setRefractiveSetPos(List<RefractiveSetPo> refractiveSetPos) {
		this.refractiveSetPos = refractiveSetPos;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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
	public List<DepartmentsPo> getDepartmentsPos() {
		return departmentsPos;
	}
	public void setDepartmentsPos(List<DepartmentsPo> departmentsPos) {
		this.departmentsPos = departmentsPos;
	}
	public StoreGoodsMgr getStoreGoodsMgr() {
		return storeGoodsMgr;
	}
	public void setStoreGoodsMgr(StoreGoodsMgr storeGoodsMgr) {
		this.storeGoodsMgr = storeGoodsMgr;
	}
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}
	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}
	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}
	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}
	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}
	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	 /**
	  * 销售同期对比报表
	  * @return
	  * @throws Exception
	  */
	public String initSalesOver()throws Exception{
		
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
		/** ********************** 权限设置 ******************************/
	
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		List<DepartmentsPo> departmentsList1 = departmentsMgr.getDepartments(deppo);	
		departmentsList=new ArrayList<DepartmentsPo>();
		for(int i=0;i<departmentsList1.size();i++){
			if("1".equals(departmentsList1.get(i).getBdptype()))
			{	
				departmentsList.add(departmentsList1.get(i));
			}
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		return SUCCESS;
	}
	
	 /**
	  * 产品批售任意时段
	  * @return
	  * @throws Exception
	  */
	public String initStoreSalesRpt() throws Exception{
		
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
		/** ********************** 权限设置 ******************************/
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		departmentsPos=storeGoodsMgr.getFranchisees();
		
		return SUCCESS;
	}
	
	/**
	 * 任意时段产品销售金额统计表
	 */
	public String initAnyDateGoodsSalesAmountSel() throws Exception{
		
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
		/** ********************** 权限设置 ******************************/
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
				
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
	
	/**
	 * 任意时段产品销售成本统计表
	 */
	public String initAnyDateGoodsSalesCostPriceSel() throws Exception{
		
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
		/** ********************** 权限设置 ******************************/
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
				
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
	
	/**
	 * 任意时段产品批售成本统计表
	 */
	public String initAnyDateGoodsWholeCostPriceSel() throws Exception{
		
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
		/** ********************** 权限设置 ******************************/
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
				
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
	
	/**
	 * 商品销售分析表
	 */
	public String initGoodsSalesAnalysisNew() throws Exception{
		
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
		/** ********************** 权限设置 ******************************/
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
				
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);

		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		teachnologyList = varietyMgr.getTechnologyType();
		frameMaterialList = frameMaterialMgr.getFrameMaterialList();
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		String isclosed = Utility.getName(request.getParameter("isclosed"));
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdptype("1");
		departmentsPo.setBdpisclosed("0");
		
		int departmentcount = departmentsMgr.getDepartmentCount(departmentsPo);
		request.setAttribute("departmentcount",departmentcount);
		
		
		
		//年份下拉初始化 begin
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		int year=Integer.parseInt(df.format(new Date()).toString());
		List yearList=new ArrayList();
			for(int i=1;i<=4;i++){
				SalesBasicPo sbp=new SalesBasicPo();
				sbp.setYear(String.valueOf(year));
				yearList.add(sbp);
				year--;
		}
		//年份下拉初始化 end
		//月份下拉初始化 begin
		SimpleDateFormat dfm = new SimpleDateFormat("MM");
		int month=Integer.parseInt(dfm.format(new Date()).toString());
		int stratMonth=1;
		List monthList=new ArrayList();
			for(int i=1;i<=Integer.parseInt(dfm.format(new Date()).toString());i++){
				SalesBasicPo sbp=new SalesBasicPo();
				if(String.valueOf(stratMonth).length()==1){
					sbp.setMonth("0"+String.valueOf(stratMonth));
				}else{
					sbp.setMonth(String.valueOf(stratMonth));
				}
				sbp.setMonth1(String.valueOf(stratMonth));
				monthList.add(sbp);
				stratMonth++;
				
		}
		//月份下拉初始化 end
		request.setAttribute("yearList", yearList);
		request.setAttribute("monthList", monthList);
		request.setAttribute("nowYear", df.format(new Date()).toString());
		return SUCCESS;
	}
	
	/**
	 * 框镜销售分析表
	 */
	public String initFrameGoodsSalesAnalysisNew() throws Exception{
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
		/** ********************** 权限设置 ******************************/
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
				
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);

		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		teachnologyList = varietyMgr.getTechnologyType();
		frameMaterialList = frameMaterialMgr.getFrameMaterialList();
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		String isclosed = Utility.getName(request.getParameter("isclosed"));
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdptype("1");
		departmentsPo.setBdpisclosed("0");
		
		int departmentcount = departmentsMgr.getDepartmentCount(departmentsPo);
		
		request.setAttribute("departmentcount",departmentcount);
		
		return SUCCESS;
	}
	
	
	/**
	 * 镜架销售材质统计表
	 */
	public String initFrameGoodsSalesMaterial() throws Exception{
		
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
		/** ********************** 权限设置 ******************************/
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
				
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);

		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		teachnologyList = varietyMgr.getTechnologyType();
		frameMaterialList = frameMaterialMgr.getFrameMaterialList();
		
		String isclosed = Utility.getName(request.getParameter("isclosed"));
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdptype("1");
		departmentsPo.setBdpisclosed("0");
		
		int departmentcount = departmentsMgr.getDepartmentCount(departmentsPo);
		request.setAttribute("departmentcount",departmentcount);
		
		return SUCCESS;
	}
	
	/**
	 * 顾客分析报表
	 */
	public String initCustomerAnalysis() throws Exception{
		
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
		/** ********************** 权限设置 ******************************/
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
				
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);

		
		String isclosed = Utility.getName(request.getParameter("isclosed"));
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdptype("1");
		departmentsPo.setBdpisclosed("0");
		
		int departmentcount = departmentsMgr.getDepartmentCount(departmentsPo);
		request.setAttribute("departmentcount",departmentcount);
		
		return SUCCESS;
	}
	
	/**
	 * 镜片功能统计表
	 */
	public String initLensFunSel() throws Exception{
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
		/** ********************** 权限设置 ******************************/
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
				
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		return SUCCESS;
	}
	
	/**
	 * 商品库存统计表
	 */
	public String initProductStockSum() throws Exception{
		
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
		/** ********************** 权限设置 ******************************/
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
				
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);

		
		String isclosed = Utility.getName(request.getParameter("isclosed"));
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
	/**
	 * 商品周转率统计表
	 */
	public String initProtationRateSum() throws Exception{
		
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
		
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("1")){   // 总公司
			
			if (personInfoPo.getDepartmenttype().equals("3")){    // 库房
				companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
			}
			
		}
	    	
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
	    
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
	
	/**
	 * 商品采购结算方式统计表
	 */
	public String initSpcgjsfstj() throws Exception{
		
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
		/** ********************** 权限设置 ******************************/
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
				
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);

		
		String isclosed = Utility.getName(request.getParameter("isclosed"));
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		warehouselist = warehouseMgr.getWarehouseList(deppo);
		
		return SUCCESS;
	}
	/**
	 * 商品库存统计表
	 */
	public String initSpbhgpfx() throws Exception{
		
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
		
		nonconformingProductMaxList = nonconformingProductMgr.getNonconformingProductMaxList();
		
	    DepartmentsPo po = new DepartmentsPo();
	    po.setBdptype("1,3");
	    po.setBdpisclosed("0");
	    
	    if (personInfoPo.getDepartmenttype().equals("1")){
	    	po.setBdpdepartmentid(personInfoPo.getDepartmentID());
	    }
	    if (personInfoPo.getDepartmenttype().equals("2")){
	    	po.setBdpregid(personInfoPo.getDepartmentID());
	    }
	    departmentsList = leaderBoardMgr.getDepartmentList(po);
	    
	    if (!personInfoPo.getDepartmenttype().equals("1") && !personInfoPo.getDepartmenttype().equals("2")){
	    	DepartmentsPo po2 = new DepartmentsPo();	    	
	    	po2.setBdpdepartmentid("suoyou");
	    	po2.setBdpdepartmentname("所有部门");
	    	
	    	departmentsList.add(po2);
	    }
	    
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
	    
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
}
