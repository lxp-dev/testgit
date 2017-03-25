package com.pengsheng.eims.member.action;

import java.util.List;

import com.pengsheng.eims.basic.dao.impl.TechnologyTypePo;
import com.pengsheng.eims.basic.mgr.AreaMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.persistence.AreaPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CrowdCategoriesMgr;
import com.pengsheng.eims.member.mgr.CustomerReturnVisitMgr;
import com.pengsheng.eims.member.mgr.CustomerSatisfactionMgr;
import com.pengsheng.eims.member.persistence.CrowdCategoriesPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.CustomerSatisfactionPo;
import com.pengsheng.eims.member.persistence.CustomerVisitPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.FrameMaterialMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class CustomerReturnVisitAction extends BaseAction {
	
	private List<FrameMaterialPo> frameMateriallist;
	private FrameMaterialMgr frameMaterialMgr;
	// ----------5级地区 moyongsheng 2014-11-08-------------		
	private List<AreaPo> area1List;
	private List<AreaPo> area2List;
	private List<AreaPo> area3List;
	private List<AreaPo> area4List;
	private List<AreaPo> area5List;
	private AreaMgr areaMgr;
	// ----------5级地区 moyongsheng 2014-11-08-------------		
	
	public List<FrameMaterialPo> getFrameMateriallist() {
		return frameMateriallist;
	}

	public List<AreaPo> getArea1List() {
		return area1List;
	}

	public void setArea1List(List<AreaPo> area1List) {
		this.area1List = area1List;
	}

	public List<AreaPo> getArea2List() {
		return area2List;
	}

	public void setArea2List(List<AreaPo> area2List) {
		this.area2List = area2List;
	}

	public List<AreaPo> getArea3List() {
		return area3List;
	}

	public void setArea3List(List<AreaPo> area3List) {
		this.area3List = area3List;
	}

	public List<AreaPo> getArea4List() {
		return area4List;
	}

	public void setArea4List(List<AreaPo> area4List) {
		this.area4List = area4List;
	}

	public List<AreaPo> getArea5List() {
		return area5List;
	}

	public void setArea5List(List<AreaPo> area5List) {
		this.area5List = area5List;
	}

	public AreaMgr getAreaMgr() {
		return areaMgr;
	}

	public void setAreaMgr(AreaMgr areaMgr) {
		this.areaMgr = areaMgr;
	}

	public void setFrameMateriallist(List<FrameMaterialPo> frameMateriallist) {
		this.frameMateriallist = frameMateriallist;
	}

	public FrameMaterialMgr getFrameMaterialMgr() {
		return frameMaterialMgr;
	}

	public void setFrameMaterialMgr(FrameMaterialMgr frameMaterialMgr) {
		this.frameMaterialMgr = frameMaterialMgr;
	}

	private DepartmentsMgr departmentsMgr;
	
	private NoteTemplatePo noteTemplatePo;	
	
	public NoteTemplatePo getNoteTemplatePo() {
		return noteTemplatePo;
	}

	public void setNoteTemplatePo(NoteTemplatePo noteTemplatePo) {
		this.noteTemplatePo = noteTemplatePo;
	}

	private List<DepartmentsPo> departmentsList;
	
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	private ProcurementOrdersDao procurementOrdersDao;
	
	private List<RefractiveSetPo> refractiveSetList = null;
	private UnitMgr unitMgr;

	private List<CrowdCategoriesPo> categoriesList; // 会员人群分类列表List

	private CrowdCategoriesMgr crowdCategoriesMgr;

	private List<CustomerSatisfactionPo> satisfactionList; // 回访满意度列表List

	private CustomerSatisfactionMgr customerSatisfactionMgr;

	private List<SalesBasicPo> customerReturnVisitList;

	private CustomerReturnVisitMgr customerReturnVisitMgr;

	private SalesBasicPo salesBasicPo;

	private SalesBasicPo salesODPo;

	private SalesBasicPo salesOSPo;

	private List<SalesDetailPo> goodsInfoList;

	private List<AdditionalCDetailPo> addititonalCDetailList;

	private List<SpecialPDetailPo> specialPDetailList;

	private CustomerVisitPo visitPo;

	private PersonPermissionMgr personPermissionMgr;

	private CustomerInfoPo customerInfoPo;

	private SmsSetPo smsSetPo;
	
	
	private List<CustomerVisitPo> visitPoList;
	
	private List<TechnologyTypePo> technologyType;
	private VarietyMgr varietyMgr;
	
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public ProcurementOrdersDao getProcurementOrdersDao() {
		return procurementOrdersDao;
	}

	public void setProcurementOrdersDao(ProcurementOrdersDao procurementOrdersDao) {
		this.procurementOrdersDao = procurementOrdersDao;
	}

	public List<RefractiveSetPo> getRefractiveSetList() {
		return refractiveSetList;
	}

	public void setRefractiveSetList(List<RefractiveSetPo> refractiveSetList) {
		this.refractiveSetList = refractiveSetList;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	public List<TechnologyTypePo> getTechnologyType() {
		return technologyType;
	}

	public void setTechnologyType(List<TechnologyTypePo> technologyType) {
		this.technologyType = technologyType;
	}

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}

	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
		
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

	public List<CustomerVisitPo> getVisitPoList() {
		return visitPoList;
	}

	public void setVisitPoList(List<CustomerVisitPo> visitPoList) {
		this.visitPoList = visitPoList;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public SmsSetPo getSmsSetPo() {
		return smsSetPo;
	}

	public void setSmsSetPo(SmsSetPo smsSetPo) {
		this.smsSetPo = smsSetPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public CustomerVisitPo getVisitPo() {
		return visitPo;
	}

	public void setVisitPo(CustomerVisitPo visitPo) {
		this.visitPo = visitPo;
	}

	public List<SalesDetailPo> getGoodsInfoList() {
		return goodsInfoList;
	}

	public void setGoodsInfoList(List<SalesDetailPo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}

	public List<AdditionalCDetailPo> getAddititonalCDetailList() {
		return addititonalCDetailList;
	}

	public void setAddititonalCDetailList(
			List<AdditionalCDetailPo> addititonalCDetailList) {
		this.addititonalCDetailList = addititonalCDetailList;
	}

	public List<SpecialPDetailPo> getSpecialPDetailList() {
		return specialPDetailList;
	}

	public void setSpecialPDetailList(List<SpecialPDetailPo> specialPDetailList) {
		this.specialPDetailList = specialPDetailList;
	}

	public SalesBasicPo getSalesODPo() {
		return salesODPo;
	}

	public void setSalesODPo(SalesBasicPo salesODPo) {
		this.salesODPo = salesODPo;
	}

	public SalesBasicPo getSalesOSPo() {
		return salesOSPo;
	}

	public void setSalesOSPo(SalesBasicPo salesOSPo) {
		this.salesOSPo = salesOSPo;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public List<CrowdCategoriesPo> getCategoriesList() {
		return categoriesList;
	}

	public void setCategoriesList(List<CrowdCategoriesPo> categoriesList) {
		this.categoriesList = categoriesList;
	}

	public CrowdCategoriesMgr getCrowdCategoriesMgr() {
		return crowdCategoriesMgr;
	}

	public void setCrowdCategoriesMgr(CrowdCategoriesMgr crowdCategoriesMgr) {
		this.crowdCategoriesMgr = crowdCategoriesMgr;
	}

	public List<CustomerSatisfactionPo> getSatisfactionList() {
		return satisfactionList;
	}

	public void setSatisfactionList(
			List<CustomerSatisfactionPo> satisfactionList) {
		this.satisfactionList = satisfactionList;
	}

	public CustomerSatisfactionMgr getCustomerSatisfactionMgr() {
		return customerSatisfactionMgr;
	}

	public void setCustomerSatisfactionMgr(
			CustomerSatisfactionMgr customerSatisfactionMgr) {
		this.customerSatisfactionMgr = customerSatisfactionMgr;
	}

	public List<SalesBasicPo> getCustomerReturnVisitList() {
		return customerReturnVisitList;
	}

	public void setCustomerReturnVisitList(
			List<SalesBasicPo> customerReturnVisitList) {
		this.customerReturnVisitList = customerReturnVisitList;
	}

	public CustomerReturnVisitMgr getCustomerReturnVisitMgr() {
		return customerReturnVisitMgr;
	}

	public void setCustomerReturnVisitMgr(
			CustomerReturnVisitMgr customerReturnVisitMgr) {
		this.customerReturnVisitMgr = customerReturnVisitMgr;
	}

	/**
	 * 初始化顾客回访页面
	 * 
	 * @return
	 */
	public String initCustomerReturnVisitSel() {

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

		refractiveSetList = unitMgr.getRefractiveSetList();
    	technologyType = varietyMgr.getTechnologyType();
    	frameMateriallist = frameMaterialMgr.getFrameMaterialList();

		// 取得查询结果回访满意度List Begin
		satisfactionList = customerSatisfactionMgr.getCustomerSatisfactionList();
		// 取得查询结果回访满意度List End
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo);
		
		area1List = areaMgr.getAjaxAreaData("1", "000000000000");
		area2List = areaMgr.getAjaxAreaData("2", systemParameterPo.getFsparea1());
		area3List = areaMgr.getAjaxAreaData("3", systemParameterPo.getFsparea2());
		area4List = areaMgr.getAjaxAreaData("4", systemParameterPo.getFsparea3());
		area5List = areaMgr.getAjaxAreaData("5", systemParameterPo.getFsparea4());
		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "returnVis";
		}
		return SUCCESS;
	}

	/**
	 * 顾客回访查询
	 * 
	 * @return
	 */
	public String selectCustomerReturnVisit() {

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

		// 取得查询结果回访满意度List Begin
		satisfactionList = customerSatisfactionMgr.getCustomerSatisfactionList();
		// 取得查询结果回访满意度List End

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo1);
		
		String smecvcustomertype = Utility.getName(request.getParameter("smecvcustomertype"));
		String smecvreturntype = Utility.getName(request.getParameter("smecvreturntype"));
		String smecvcontentment = Utility.getName(request.getParameter("smecvcontentment"));
		String takeTimeStart = Utility.getName(request.getParameter("takeTimeStart"));
		String takeTimeEnd = Utility.getName(request.getParameter("takeTimeEnd"));
		String returnDateStart = Utility.getName(request.getParameter("returnDateStart"));
		String returnDateEnd = Utility.getName(request.getParameter("returnDateEnd"));
		String memberid = Utility.getName(request.getParameter("memberid"));
		String name = Utility.getName(request.getParameter("name"));
		String phone = Utility.getName(request.getParameter("phone"));
		String sex = Utility.getName(request.getParameter("sex"));
		String agemin = Utility.getName(request.getParameter("agemin"));
		String agemax = Utility.getName(request.getParameter("agemax"));
		String departmentid = Utility.getName(request.getParameter("departmentid"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String startTime1 = Utility.getName(request.getParameter("startTime1"));
		String endTime1 = Utility.getName(request.getParameter("endTime1"));
		String integralmin = Utility.getName(request.getParameter("integralmin"));
		String integralmax = Utility.getName(request.getParameter("integralmax"));
		String numbermin = Utility.getName(request.getParameter("numbermin"));
		String numbermax = Utility.getName(request.getParameter("numbermax"));
		String pricemin = Utility.getName(request.getParameter("pricemin"));
		String pricemax = Utility.getName(request.getParameter("pricemax"));
		String allpricemin = Utility.getName(request.getParameter("allpricemin"));
		String allpricemax = Utility.getName(request.getParameter("allpricemax"));
		String selbspsuppliername = Utility.getName(request.getParameter("selbspsuppliername"));
		String selcstpsupplierid = Utility.getName(request.getParameter("selcstpsupplierid"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsname = Utility.getName(request.getParameter("goodsname"));
		String goodsid = Utility.getName(request.getParameter("goodsid"));
		String technologyTypeID = Utility.getName(request.getParameter("technologyTypeID"));
		String bbdframematerialtype = Utility.getName(request.getParameter("bbdframematerialtype"));
		String bbdmaterialclass = Utility.getName(request.getParameter("bbdmaterialclass"));
		String bbdrefractive = Utility.getName(request.getParameter("bbdrefractive"));
		String bbdluminosityclass = Utility.getName(request.getParameter("bbdluminosityclass"));
		String bbdfunctionclass = Utility.getName(request.getParameter("bbdfunctionclass"));
		String bbdusetype = Utility.getName(request.getParameter("bbdusetype"));
		String bbdstealthclass = Utility.getName(request.getParameter("bbdstealthclass"));
		String saleid = Utility.getName(request.getParameter("saleid"));
		String salesType=Utility.getName(request.getParameter("salestypeid"));
		String t1=Utility.getName(request.getParameter("t1"));		
		String t2=Utility.getName(request.getParameter("t2"));
		String t3=Utility.getName(request.getParameter("t3"));
		String t4=Utility.getName(request.getParameter("t4"));
		String t5=Utility.getName(request.getParameter("t5"));
		
		String zone1=Utility.getName(request.getParameter("zone1"));		
		String zone2=Utility.getName(request.getParameter("zone2"));
		String zone3=Utility.getName(request.getParameter("zone3"));
		
		String address = "";
		if("0".equals(systemParameterPo.getFspaddresstype())){
			if(!"---请选择---".equals(zone1)){
				address = zone1;
				if(!"---请选择---".equals(zone2)){
					address = address + ","+ zone2;
					if(!"---请选择---".equals(zone3)){
						address = address + ","+ zone3;
					}
				}
			}
		}
		
		CustomerVisitPo po = new CustomerVisitPo();
		po.setSmecvcustomertype(smecvcustomertype);
		po.setSmecvreturntype(smecvreturntype);
		po.setSmecvcontentment(smecvcontentment);
		po.setSmecvfeedbackdatestart(returnDateStart);
		po.setSmecvfeedbackdateend(returnDateEnd);
		po.setSmecimemberid(memberid);
		po.setSmeciname(name);
		po.setSmeciphone(phone);
		po.setSmecisex(sex);
		po.setSmeciagemin(agemin);
		po.setSmeciagemax(agemax);
		po.setSmecishopcode(departmentid);		
		po.setSmecvsalesid(saleid);		
		po.setStarttime(startTime);
		po.setEndtime(endTime);
		po.setStarttimes(startTime1);
		po.setEndtimes(endTime1);
		po.setIntegralmin(integralmin);
		po.setIntegralmax(integralmax);
		po.setNumbermin(numbermin);
		po.setNumbermax(numbermax);
		po.setPricemin(pricemin);
		po.setPricemax(pricemax);
		po.setAllpricemin(allpricemin);
		po.setAllpricemax(allpricemax);
		po.setSelbspsuppliername(selbspsuppliername);
		po.setSelcstpsupplierid(selcstpsupplierid);
		po.setBrandName(brandName);
		po.setBrandID(brandID);
		po.setGoodsname(goodsname);
		po.setGoodsid(goodsid);
		po.setTechnologytypeid(technologyTypeID);
		po.setBbdframematerialtype(bbdframematerialtype);
		po.setBbdmaterialclass(bbdmaterialclass);
		po.setBbdrefractive(bbdrefractive);
		po.setBbdluminosityclass(bbdluminosityclass);
		po.setBbdfunctionclass(bbdfunctionclass);
		po.setBbdusetype(bbdusetype);
		po.setBbdstealthclass(bbdstealthclass);
		po.setSalsepersonname(request.getParameter("salsepersonname"));
		po.setHuifangcishu(request.getParameter("huifangcishu"));
		po.setSalestype(salesType);		
		po.setSmecishoplist(departmentsList);		
		po.setSmeciaddress(address);
		po.setSmeciarea1(t1);
		po.setSmeciarea2(t2);
		po.setSmeciarea3(t3);
		po.setSmeciarea4(t4);
		po.setSmeciarea5(t5);
		
		SalesBasicPo salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbtakeglassstartdata(takeTimeStart);
		salesBasicPo.setSsesbtakeglassenddata(takeTimeEnd);		
		
		request.setAttribute("saleid", saleid);
		request.setAttribute("smecvcustomertype", smecvcustomertype);
		request.setAttribute("smecvreturntype", smecvreturntype);
		request.setAttribute("smecvcontentment", smecvcontentment);
		request.setAttribute("returnDateStart", returnDateStart);
		request.setAttribute("returnDateEnd", returnDateEnd);
		request.setAttribute("takeTimeStart", takeTimeStart);
		request.setAttribute("takeTimeEnd", takeTimeEnd);
		request.setAttribute("memberid", memberid);
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("sex", sex);
		request.setAttribute("agemin", agemin);
		request.setAttribute("agemax", agemax);
		request.setAttribute("departmentid", departmentid);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("startTime1",startTime1);
		request.setAttribute("endTime1",endTime1);
		request.setAttribute("integralmin",integralmin);
		request.setAttribute("integralmax",integralmax);
		request.setAttribute("numbermin",numbermin);
		request.setAttribute("numbermax",numbermax);
		request.setAttribute("pricemin",pricemin);
		request.setAttribute("pricemax",pricemax);
		request.setAttribute("allpricemin",allpricemin);
		request.setAttribute("allpricemax",allpricemax);
		request.setAttribute("selbspsuppliername",selbspsuppliername);
		request.setAttribute("selcstpsupplierid",selcstpsupplierid);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("goodsname",goodsname);
		request.setAttribute("goodsid",goodsid);
		request.setAttribute("technologyTypeID",technologyTypeID);
		request.setAttribute("bbdframematerialtype",bbdframematerialtype);
		request.setAttribute("bbdmaterialclass",bbdmaterialclass);
		request.setAttribute("bbdrefractive",bbdrefractive);
		request.setAttribute("bbdluminosityclass",bbdluminosityclass);
		request.setAttribute("bbdfunctionclass",bbdfunctionclass);
		request.setAttribute("bbdusetype",bbdusetype);
		request.setAttribute("bbdstealthclass",bbdstealthclass);
		request.setAttribute("salestypeid", salesType);
		request.setAttribute("salsepersonname", request.getParameter("salsepersonname"));
		request.setAttribute("address", address);
		request.setAttribute("t1", t1);
		request.setAttribute("t2", t2);
		request.setAttribute("t3", t3);
		request.setAttribute("t4", t4);
		request.setAttribute("t5", t5);
		request.setAttribute("huifangcishu", request.getParameter("huifangcishu"));
    	refractiveSetList = unitMgr.getRefractiveSetList();
    	technologyType = varietyMgr.getTechnologyType();
    	frameMateriallist = frameMaterialMgr.getFrameMaterialList();
    	
    	area1List = areaMgr.getAjaxAreaData("1", "000000000000");
		area2List = areaMgr.getAjaxAreaData("2", !"".equals(t1) ? t1 : systemParameterPo.getFsparea1());
		area3List = areaMgr.getAjaxAreaData("3", !"".equals(t2) ? t2 : systemParameterPo.getFsparea2());
		area4List = areaMgr.getAjaxAreaData("4", !"".equals(t3) ? t3 : systemParameterPo.getFsparea3());
		area5List = areaMgr.getAjaxAreaData("5", !"".equals(t4) ? t4 : systemParameterPo.getFsparea4());
		
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
		int count = customerReturnVisitMgr.getCustomerReturnVisitCount(salesBasicPo, po,systemParameterPo);
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
			customerReturnVisitList = customerReturnVisitMgr.selectCustomerReturnVisitList(salesBasicPo,po, page.getStart(), page.getPageSize(),systemParameterPo);
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			customerReturnVisitList = null;
		}

		return SUCCESS;
	}

	/**
	 * 初始化顾客回访页面
	 * 
	 * @return
	 */
	public String initCustomerReturnVisitIns() {
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
		smsSetPo = customerReturnVisitMgr.getSmsSet();
		
		// 取得查询结果回访满意度List Begin
		satisfactionList = customerSatisfactionMgr
				.getCustomerSatisfactionList();
		// 取得查询结果回访满意度List End

		String salesId = Utility.getName(request.getParameter("smecvsalesid"));
		request.setAttribute("smecvsalesid", salesId);
	
		SalesBasicPo salesPo = new SalesBasicPo();
		salesPo.setSsesbsalesid(salesId);

		SalesBasicPo ODPo = new SalesBasicPo();
		ODPo.setSsesbsalesid(salesId);

		SalesBasicPo OSPo = new SalesBasicPo();
		OSPo.setSsesbsalesid(salesId);

		// 顾客详细信息
		salesBasicPo = new SalesBasicPo();
		salesBasicPo = customerReturnVisitMgr.getReturnCustomerInfo(salesPo);

		// 右眼信息
		salesODPo = new SalesBasicPo();
		salesODPo = customerReturnVisitMgr.getODDetailInfo(ODPo);

		// 左眼信息
		salesOSPo = new SalesBasicPo();
		salesOSPo = customerReturnVisitMgr.getOSDetailInfo(OSPo);

		// 商品详细信息List
		SalesDetailPo salesDetailPo = new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(salesId);

		goodsInfoList = customerReturnVisitMgr.getGoodsInfo(salesDetailPo);

		// 附加费用List
		AdditionalCDetailPo additionalCDetailPo = new AdditionalCDetailPo();
		additionalCDetailPo.setSsesalesid(salesId);

		addititonalCDetailList = customerReturnVisitMgr
				.getAddititonalCDetail(additionalCDetailPo);

		// 特殊加工要求List
		SpecialPDetailPo specialPDetailPo = new SpecialPDetailPo();
		specialPDetailPo.setSsesdsalesid(salesId);

		specialPDetailList = customerReturnVisitMgr
				.getSpecialPDetail(specialPDetailPo);

		// 顾客回访信息
		CustomerVisitPo customerVisitPo = new CustomerVisitPo();
		customerVisitPo.setSmecvsalesid(salesId);
		String smecvcontent="";
		//短信开关判断
		NoteTemplatePo po = new NoteTemplatePo();
		po.setBntname("1");
		po.setBntautosend("1");
		noteTemplatePo = unitMgr.getNoteTemplateType(po);
		if(!"".equals(Utility.getName(noteTemplatePo.getBntid()))){
			smecvcontent = smecvcontent + salesBasicPo.getSsesbpersonName()+" 您好！";
			smecvcontent = smecvcontent + noteTemplatePo.getBntcontent();
		}
		request.setAttribute("smecvcontent", smecvcontent);
		//visitPo = new CustomerVisitPo();
		//visitPo = customerReturnVisitMgr.getCustomerVisitInfo(customerVisitPo);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		NoteTypePo npo=unitMgr.getNoteTypePo("1");
		NoteTemplatePo po2 = new NoteTemplatePo();
		po2.setBntname("1");
		po2.setBntautosend("1");
		NoteTemplatePo noteTemplatePo = unitMgr.getNoteTemplateType(po2);
		
		request.setAttribute("first", systemParameterPo.getFspshortmessage());
		request.setAttribute("second", npo.getBntautosend());
		request.setAttribute("content", noteTemplatePo.getBntcontent());	
		
		return SUCCESS;
	}

	/**
	 * 新增顾客回访信息
	 * 
	 * @return
	 */
	public String insertCustomerReturnVisit() {
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
		
		String personid = personInfoPo.getId();

		String salesId = Utility.getName(request.getParameter("salesid"));
		
		String ReturnVisits = Utility.getName(request.getParameter("ReturnVisits"));
		
		

		String personName = Utility.getName(request.getParameter("personName"));

		String smecvcustomertype = Utility.getName(request.getParameter("smecvcustomertype"));

		String smecvcontentment = Utility.getName(request.getParameter("smecvcontentment"));

		String smecvfeedbackcontent = Utility.getName(request.getParameter("smecvfeedbackcontent"));

		String smecvresolvent = Utility.getName(request.getParameter("smecvresolvent"));

		String smecvremark = Utility.getName(request.getParameter("smecvremark"));
		
		String smecvssd = Utility.getName(request.getParameter("smecvssd"));
		
		String smecvcprzd = Utility.getName(request.getParameter("smecvcprzd"));
		
		String smecvzcxz = Utility.getName(request.getParameter("smecvzcxz"));
		
		String isSend = Utility.getName(request.getParameter("isSend"));
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		
		CustomerVisitPo visitPo = new CustomerVisitPo();
		visitPo.setSmecvsalesid(salesId);
		visitPo.setSmecvreturntype(ReturnVisits);
		visitPo.setSmecvcustomername(personName);
		visitPo.setSmecvcustomertype(smecvcustomertype);
		visitPo.setSmecvcontentment(smecvcontentment);
		visitPo.setSmecvfeedbackcontent(smecvfeedbackcontent);
		visitPo.setSmecvresolvent(smecvresolvent);
		visitPo.setSmecvremark(smecvremark);
		visitPo.setSmecvpersonid(personid);
		visitPo.setSmecvssd(smecvssd);
		visitPo.setSmecvcprzd(smecvcprzd);
		visitPo.setSmecvzcxz(smecvzcxz);
		if("1".equals(ReturnVisits))
		{
			String smecvpersonphone = Utility.getName(request.getParameter("ssesbphone"));
			String smecvcontent = Utility.getName(request.getParameter("smecvcontent"));
			visitPo.setSmecvpersonphone(smecvpersonphone);
			visitPo.setSmecvcontent(smecvcontent);
		}else
		{
			visitPo.setSmecvpersonphone("");
			visitPo.setSmecvcontent("");
		}
		customerInfoPo = customerReturnVisitMgr.getCustomerInfo(salesId);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 回访
		logPo.setsLogContent("顾客回访管理会员卡号："+customerInfoPo.getSmecimemberid()+" 新增");

		
		customerReturnVisitMgr.insertCustomerVisit(visitPo,customerInfoPo,personInfoPo,smsRecordPo,isSend,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.save.sucess"));
		request.setAttribute("flag", "openUpdate");

		return SUCCESS;
	}
	
	
	
	/**
	 * 顾客回访信息详细
	 * 
	 * @return
	 */
	public String insertCustomerReturnDetails() {
		
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
		
		String salesId = Utility.getName(request.getParameter("smecvsalesid"));
		SalesBasicPo salesPo = new SalesBasicPo();
		salesPo.setSsesbsalesid(salesId);

		SalesBasicPo ODPo = new SalesBasicPo();
		ODPo.setSsesbsalesid(salesId);

		SalesBasicPo OSPo = new SalesBasicPo();
		OSPo.setSsesbsalesid(salesId);

		// 顾客详细信息
		salesBasicPo = new SalesBasicPo();
		salesBasicPo = customerReturnVisitMgr.getReturnCustomerInfo(salesPo);

		// 右眼信息
		salesODPo = new SalesBasicPo();
		salesODPo = customerReturnVisitMgr.getODDetailInfo(ODPo);

		// 左眼信息
		salesOSPo = new SalesBasicPo();
		salesOSPo = customerReturnVisitMgr.getOSDetailInfo(OSPo);

		// 商品详细信息List
		SalesDetailPo salesDetailPo = new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(salesId);

		goodsInfoList = customerReturnVisitMgr.getGoodsInfo(salesDetailPo);

		// 附加费用List
		AdditionalCDetailPo additionalCDetailPo = new AdditionalCDetailPo();
		additionalCDetailPo.setSsesalesid(salesId);

		addititonalCDetailList = customerReturnVisitMgr
				.getAddititonalCDetail(additionalCDetailPo);

		// 特殊加工要求List
		SpecialPDetailPo specialPDetailPo = new SpecialPDetailPo();
		specialPDetailPo.setSsesdsalesid(salesId);

		specialPDetailList = customerReturnVisitMgr
				.getSpecialPDetail(specialPDetailPo);
		
		CustomerVisitPo po = new CustomerVisitPo();
		
		po.setSmecvsalesid(salesId);
		
		visitPoList = customerReturnVisitMgr.getCustomerVisitInfo(po);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		
		return SUCCESS;
		
	}
	
	
	

	public String initCustomerReturnVisitSms() {
		String salesid = Utility.getName(request.getParameter("salesid"));

		smsSetPo = customerReturnVisitMgr.getSmsSet();
		String[] text = smsSetPo.getFssvisitcontent().split("/D");

		customerInfoPo = customerReturnVisitMgr.getCustomerInfo(salesid);

		request.setAttribute("content", smsSetPo.getFssvisitcontent().replace(
				"/D", customerInfoPo.getSmeciname()));

		request.setAttribute("salesid", Utility.getName(request
				.getParameter("salesid")));

		return SUCCESS;
	}

	public String smsCustomerReturnVisit() {

		String salesid = Utility.getName(request.getParameter("salesid"));

		customerInfoPo = customerReturnVisitMgr.getCustomerInfo(salesid);

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");

		SmsRecordPo smsRecordPo = new SmsRecordPo();

		// 短信记录表
		smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmeciname());//
		// 接收人员
		smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());//
		// 接收人员电话
		smsRecordPo.setFsrsendperson(personInfoPo.getId());// 发送人员
		smsRecordPo.setFsrsendperson(personInfoPo.getPersonName());// 发送人员
		smsRecordPo.setFsrsendcontext(Utility.getName(request
				.getParameter("content")));// 发送内容

		customerReturnVisitMgr.insertSmsRecord(smsRecordPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.send.sms.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

}
