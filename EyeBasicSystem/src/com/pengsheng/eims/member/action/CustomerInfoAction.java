package com.pengsheng.eims.member.action;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.dao.impl.TechnologyTypePo;
import com.pengsheng.eims.basic.mgr.AreaMgr;
import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.mgr.MemberOriginMgr;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.persistence.AreaPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.basic.persistence.MemberOriginPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.MemberExportPo;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.FrameMaterialMgr;
import com.pengsheng.eims.system.mgr.InterestMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.mgr.WorkTypeMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.system.persistence.InterestPo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.PersonTypePo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.system.persistence.WorkTypePo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class CustomerInfoAction extends BaseAction {

	private CustomerInfoPo customerInfoPo;
	private List<MemberManagementPo> memberManagementList = null;
	private InputStream inputStream = null;
	private String fileName = null;
	private List<TechnologyTypePo> technologyType;	
	private List<FrameMaterialPo> frameMateriallist;
	private FrameMaterialMgr frameMaterialMgr;
	private VarietyMgr varietyMgr;
	private CompanyNameMgr companyNameMgr;
	private CompanyNamePo companyNamePo;
	private List<RefractiveSetPo> refractiveSetList = null;
	private UnitMgr unitMgr;
	private DepartmentsMgr departmentsMgr;	
	private ProcurementOrdersDao procurementOrdersDao;
	private SystemParameterMgr systemParameterMgr;
	private FittingTemplateTypeMgr fittingTemplateTypeMgr = null;	
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<DepartmentsPo> departmentsList;
	private List<CustomerInfoPo> customerInfoList; // 顾客基本资料列表List	
	private List<InterestPo> interestpolist;
	private InterestMgr interestMgr;	
	private List<MemberOriginPo> memberoriginpolist;
	private MemberOriginMgr memberOriginMgr;	
	private List<WorkTypePo> worktypepolist;
	private WorkTypeMgr workTypeMgr;
	private CustomerInfoMgr customerInfoMgr;	
	private PersonPermissionMgr personPermissionMgr;
	private List<MemberExportPo> memberExportList = null;
	private MemberExportPo memberExportPo = null;
	private List<PersonTypePo> persontypepolist;
	List<CustomerInfoPo> gxlist = null;
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	
	// ----------5级地区 moyongsheng 2014-11-08-------------		
	private List<AreaPo> area1List;
	private List<AreaPo> area2List;
	private List<AreaPo> area3List;
	private List<AreaPo> area4List;
	private List<AreaPo> area5List;
	private AreaMgr areaMgr;
	// ----------5级地区 moyongsheng 2014-11-08-------------		
	
	public List<PersonTypePo> getPersontypepolist() {
		return persontypepolist;
	}
	public List<OptionParamPo> getOptionParamPolist() {
		return optionParamPolist;
	}
	public void setOptionParamPolist(List<OptionParamPo> optionParamPolist) {
		this.optionParamPolist = optionParamPolist;
	}
	public OptionParamMgr getOptionParamMgr() {
		return optionParamMgr;
	}
	public void setOptionParamMgr(OptionParamMgr optionParamMgr) {
		this.optionParamMgr = optionParamMgr;
	}
	public void setPersontypepolist(List<PersonTypePo> persontypepolist) {
		this.persontypepolist = persontypepolist;
	}
	public List<MemberExportPo> getMemberExportList() {
		return memberExportList;
	}
	public void setMemberExportList(List<MemberExportPo> memberExportList) {
		this.memberExportList = memberExportList;
	}
	public MemberExportPo getMemberExportPo() {
		return memberExportPo;
	}
	public void setMemberExportPo(MemberExportPo memberExportPo) {
		this.memberExportPo = memberExportPo;
	}
	public List<MemberManagementPo> getMemberManagementList() {
		return memberManagementList;
	}
	public void setMemberManagementList(
			List<MemberManagementPo> memberManagementList) {
		this.memberManagementList = memberManagementList;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<FrameMaterialPo> getFrameMateriallist() {
		return frameMateriallist;
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
	
	public ProcurementOrdersDao getProcurementOrdersDao() {
		return procurementOrdersDao;
	}

	public void setProcurementOrdersDao(ProcurementOrdersDao procurementOrdersDao) {
		this.procurementOrdersDao = procurementOrdersDao;
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

	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}

	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}

	public CompanyNamePo getCompanyNamePo() {
		return companyNamePo;
	}

	public void setCompanyNamePo(CompanyNamePo companyNamePo) {
		this.companyNamePo = companyNamePo;
	}
	public List<MemberOriginPo> getMemberoriginpolist() {
		return memberoriginpolist;
	}

	public void setMemberoriginpolist(List<MemberOriginPo> memberoriginpolist) {
		this.memberoriginpolist = memberoriginpolist;
	}
	public List<InterestPo> getInterestpolist() {
		return interestpolist;
	}

	public void setInterestpolist(List<InterestPo> interestpolist) {
		this.interestpolist = interestpolist;
	}

	public InterestMgr getInterestMgr() {
		return interestMgr;
	}

	public void setInterestMgr(InterestMgr interestMgr) {
		this.interestMgr = interestMgr;
	}

	public MemberOriginMgr getMemberOriginMgr() {
		return memberOriginMgr;
	}

	public void setMemberOriginMgr(MemberOriginMgr memberOriginMgr) {
		this.memberOriginMgr = memberOriginMgr;
	}

	public List<WorkTypePo> getWorktypepolist() {
		return worktypepolist;
	}

	public void setWorktypepolist(List<WorkTypePo> worktypepolist) {
		this.worktypepolist = worktypepolist;
	}

	public WorkTypeMgr getWorkTypeMgr() {
		return workTypeMgr;
	}

	public void setWorkTypeMgr(WorkTypeMgr workTypeMgr) {
		this.workTypeMgr = workTypeMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	/**
	 * 初始化顾客基本资料查询
	 */
	public String initSelCustomerInfo() throws Exception {

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

    	systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
    	
		//获得打印结算单信息----------------------------
		String actionTypeID = "36";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------
		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selCustomer";
		}
		
		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo1);
		
		request.setAttribute("departmentIDgsl", personInfoPo1.getDepartmentID());	
		
		return SUCCESS;
	}

	/**
	 * 查询顾客基本资料列表
	 */
	public String selCustomerInfo() throws Exception {
		
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

		String memberid = Utility.getName(request.getParameter("memberid"));
		String name = Utility.getName(request.getParameter("name"));
		String phone = Utility.getName(request.getParameter("phone"));
		String sex = Utility.getName(request.getParameter("sex"));
		String agemin = Utility.getName(request.getParameter("agemin"));
		String agemax = Utility.getName(request.getParameter("agemax"));
		String integralmin = Utility.getName(request.getParameter("integralmin"));
		String integralmax = Utility.getName(request.getParameter("integralmax"));
		String openid=Utility.getName(request.getParameter("openid"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String customerenable = Utility.getName(request.getParameter("customerenable"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo1);
		
		CustomerInfoPo po = new CustomerInfoPo();
		po.setSmecimemberid(memberid);
		po.setSmeciname(name);
		po.setSmeciphone(phone);
		po.setSmecisex(sex);
		po.setSmeciagemin(agemin);
		po.setSmeciagemax(agemax);
		po.setSmecishopcode(departmentID);
		po.setIntegralmin(integralmin);
		po.setIntegralmax(integralmax);
		po.setSmeciopenid(openid);
		po.setSmeciflag(customerenable);
		po.setSmecishoplist(getDepartmentListBySystemParameter(systemParameterPo,departmentsList));
		
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
				
		int count = customerInfoMgr.getCustomerInfoCount(po);
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
			customerInfoList = customerInfoMgr.getCustomerInfoList(po, page
					.getStart(), page.getPageSize());

			for (CustomerInfoPo customer : customerInfoList) {
				if (StringUtils.isNotEmpty(customer.getSmecibirthday())) {
					String birthdayYear = customer.getSmecibirthday().substring(0,4);
					int age = Calendar.getInstance().get(Calendar.YEAR)- Integer.parseInt(birthdayYear);
					customer.setFmmage(Integer.toString(age));
				}
			}

			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			customerInfoList = null;
		}
		
		request.setAttribute("memberid", memberid);
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("sex", sex);
		request.setAttribute("agemin", agemin);
		request.setAttribute("agemax", agemax);
		request.setAttribute("departmentID", departmentID);
		request.setAttribute("integralmin",integralmin);
		request.setAttribute("integralmax",integralmax);
		request.setAttribute("openid", openid);
		request.setAttribute("customerenable", customerenable);
		
		request.setAttribute("departmentIDgsl", personInfoPo1.getDepartmentID());
		
		//获得打印结算单信息----------------------------
		String actionTypeID = "36";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------
		return SUCCESS;
	}
	
	/**
	 * 初始化顾客高级查询
	 */
	public String initSelCustomerHighLevelInfo() throws Exception {
		
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

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo1);
    	
    	interestpolist = interestMgr.getInterestList();
    	frameMateriallist = frameMaterialMgr.getFrameMaterialList();
    	refractiveSetList = unitMgr.getRefractiveSetList();
    	technologyType = varietyMgr.getTechnologyType();
		worktypepolist = workTypeMgr.getWorkTypeList();
		memberoriginpolist = memberOriginMgr.selectMemberOriginList();
		memberManagementList = customerInfoMgr.getMemberCardTypeList();
    			
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selCustomerHighLevelInfo";
		}
		persontypepolist = workTypeMgr.getPersonTypeList();
		request.setAttribute("departmentid",personInfoPo1.getDepartmentID()+",");
		
		area1List = areaMgr.getAjaxAreaData("1", "000000000000");
		area2List = areaMgr.getAjaxAreaData("2", systemParameterPo.getFsparea1());
		area3List = areaMgr.getAjaxAreaData("3", systemParameterPo.getFsparea2());
		area4List = areaMgr.getAjaxAreaData("4", systemParameterPo.getFsparea3());
		area5List = areaMgr.getAjaxAreaData("5", systemParameterPo.getFsparea4());
		
		// 得到系统参数的信息
		CompanyNamePo tcpo = new CompanyNamePo(); 
		tcpo.setFcnId(personInfoPo1.getPersoncompanyid());
		companyNamePo = companyNameMgr.getCompanyName(tcpo);
		
		return SUCCESS;
	}

	/**
	 * 查询顾客高级基本资料列表
	 */
	public String selCustomerHighLevelInfo() throws Exception {
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
		persontypepolist = workTypeMgr.getPersonTypeList();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		departmentsList = this.getDepartmentListByCompany(systemParameterPo, personInfoPo1);
		
		interestpolist = interestMgr.getInterestList();
		worktypepolist = workTypeMgr.getWorkTypeList();
		memberoriginpolist = memberOriginMgr.selectMemberOriginList();
		memberManagementList = customerInfoMgr.getMemberCardTypeList();
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
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
		String phoneflag = Utility.getName(request.getParameter("phoneflag"));
		String work = Utility.getName(request.getParameter("work"));
		String memberoRigin = Utility.getName(request.getParameter("memberoRigin"));
		String cardtype = Utility.getName(request.getParameter("cardtype"));
		String openid=Utility.getName(request.getParameter("openid"));
		String salesType=Utility.getName(request.getParameter("salestypeid"));
		String persontype=Utility.getName(request.getParameter("persontype"));		
		String srStartTime=Utility.getName(request.getParameter("srStartTime"));
		String srEndTime=Utility.getName(request.getParameter("srEndTime"));
		String customerenable=Utility.getName(request.getParameter("customerenable"));
		String hyremark=Utility.getName(request.getParameter("hyremark"));		
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		
		String t1=Utility.getName(request.getParameter("t1"));		
		String t2=Utility.getName(request.getParameter("t2"));
		String t3=Utility.getName(request.getParameter("t3"));
		String t4=Utility.getName(request.getParameter("t4"));
		String t5=Utility.getName(request.getParameter("t5"));
		
		String zone1=Utility.getName(request.getParameter("zone1"));	
		String zone2=Utility.getName(request.getParameter("zone2"));
		String zone3=Utility.getName(request.getParameter("zone3"));
		if(zone1.equals("")){
			zone1 = "---请选择---";
		}
		if(zone2.equals("")){
			zone2 = "---请选择---";
		}
		if(zone3.equals("")){
			zone3 = "---请选择---";
		}
		
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
			
			request.setAttribute("departmentid", departmentid);			
		}
		
		CustomerInfoPo po = new CustomerInfoPo();
		if(!"".equals((request.getParameterValues("interestpolists")))&& null !=(request.getParameterValues("interestpolists")))
		{
			String[] interestpolists = request.getParameterValues("interestpolists");
			String smeciinterest = getinterestpolist(interestpolists);
			po.setSmeciinterest(smeciinterest);
		}
		po.setSrStartTime(srStartTime);
		po.setSrEndTime(srEndTime);
		po.setSmecimemberid(memberid);
		po.setSmeciname(name);
		po.setSmeciphone(phone);
		po.setSmecisex(sex);
		po.setSmeciagemin(agemin);
		po.setSmeciagemax(agemax);
		po.setSmecishopcode(departmentid);
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
		po.setPhoneflag(phoneflag);		
		po.setSmeciwork(work);
		po.setSmecimemberorigin(memberoRigin);
		po.setSmecicardtype(cardtype);		
		po.setSmeciopenid(openid);
		po.setSalsepersonname(request.getParameter("salsepersonname"));
		po.setHuifangcishu(request.getParameter("huifangcishu"));
		po.setSalestype(salesType);
		po.setPersontype(persontype);
		po.setSmeciflag(customerenable);
		po.setSmecishoplist(departmentsList);
		po.setSmeciaddress(address);
		po.setSmeciarea1(t1);
		po.setSmeciarea2(t2);
		po.setSmeciarea3(t3);
		po.setSmeciarea4(t4);
		po.setSmeciarea5(t5);
		po.setSmeciremark(hyremark);
		
		int count = customerInfoMgr.getCustomerInfoCount1(po);
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
			customerInfoList = customerInfoMgr.getCustomerInfoList1(po, page
					.getStart(), page.getPageSize());

			for (CustomerInfoPo customer : customerInfoList) {
				if (StringUtils.isNotEmpty(customer.getSmecibirthday())) {			
					String birthdayYear = customer.getSmecibirthday().substring(0,
							4);
					int age = Calendar.getInstance().get(Calendar.YEAR)
							- Integer.parseInt(birthdayYear);
					customer.setFmmage(Integer.toString(age));
				}				
			}

			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			customerInfoList = null;
		}
		
		if(!"".equals((request.getParameterValues("interestpolists")))&& null !=(request.getParameterValues("interestpolists")))
		{
			interestpolist = getInterestList(interestpolist, po.getSmeciinterest());
		}
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
		request.setAttribute("phoneflag",phoneflag);
		request.setAttribute("work",work);
		request.setAttribute("memberoRigin",memberoRigin);
		request.setAttribute("cardtype",cardtype);
		request.setAttribute("openid", openid);
		request.setAttribute("salestypeid", salesType);
		request.setAttribute("salsepersonname", request.getParameter("salsepersonname"));
		request.setAttribute("huifangcishu", request.getParameter("huifangcishu"));
		
		request.setAttribute("srStartTime", srStartTime);
		request.setAttribute("srEndTime", srEndTime);
		request.setAttribute("persontype", persontype);
		request.setAttribute("customerenable", customerenable);
		request.setAttribute("address", address);
		request.setAttribute("t1", t1);
		request.setAttribute("t2", t2);
		request.setAttribute("t3", t3);
		request.setAttribute("t4", t4);
		request.setAttribute("t5", t5);
		request.setAttribute("hyremark",hyremark);

    	refractiveSetList = unitMgr.getRefractiveSetList();
    	technologyType = varietyMgr.getTechnologyType();
    	frameMateriallist = frameMaterialMgr.getFrameMaterialList();
    	
    	area1List = areaMgr.getAjaxAreaData("1", "000000000000");
		area2List = areaMgr.getAjaxAreaData("2", !"".equals(t1) ? t1 : systemParameterPo.getFsparea1());
		area3List = areaMgr.getAjaxAreaData("3", !"".equals(t2) ? t2 : systemParameterPo.getFsparea2());
		area4List = areaMgr.getAjaxAreaData("4", !"".equals(t3) ? t3 : systemParameterPo.getFsparea3());
		area5List = areaMgr.getAjaxAreaData("5", !"".equals(t4) ? t4 : systemParameterPo.getFsparea4());
		
		// 得到系统参数的信息
		CompanyNamePo tcpo = new CompanyNamePo(); 
		tcpo.setFcnId(personInfoPo1.getPersoncompanyid());
		companyNamePo = companyNameMgr.getCompanyName(tcpo);

		return SUCCESS;
	}
	
	/**
	 * 查询顾客高级基本资料列表
	 */
	public String selCustomerSendMessage() throws Exception {

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
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		departmentsList = this.getDepartmentListByCompany(systemParameterPo, personInfoPo1);
		
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
		String phoneflag = Utility.getName(request.getParameter("phoneflag"));
		String work = Utility.getName(request.getParameter("work"));
		String memberoRigin = Utility.getName(request.getParameter("memberoRigin"));
		String cardtype = Utility.getName(request.getParameter("cardtype"));
		String openid=Utility.getName(request.getParameter("openid"));
		String salesType=Utility.getName(request.getParameter("salestypeid"));
		String persontype=Utility.getName(request.getParameter("persontype"));		
		String srStartTime=Utility.getName(request.getParameter("srStartTime"));
		String srEndTime=Utility.getName(request.getParameter("srEndTime"));
		String customerenable=Utility.getName(request.getParameter("customerenable"));
		String address=Utility.getName(request.getParameter("address"));
		String hyremark=Utility.getName(request.getParameter("hyremark"));	
		
		customerInfoPo = new CustomerInfoPo();

		if(!"".equals((request.getParameterValues("interestpolists")))&& null !=(request.getParameterValues("interestpolists"))){
			String[] interestpolists = request.getParameterValues("interestpolists");
			String smeciinterest = getinterestpolist(interestpolists);
			customerInfoPo.setSmeciinterest(smeciinterest);
		}
		
		customerInfoPo.setSmeciaddress(address);
		customerInfoPo.setSmecimemberid(memberid);
		customerInfoPo.setSmeciname(name);
		customerInfoPo.setSmeciphone(phone);
		customerInfoPo.setSmecisex(sex);
		customerInfoPo.setSmeciagemin(agemin);
		customerInfoPo.setSmeciagemax(agemax);
		customerInfoPo.setSmecishopcode(departmentid);
		customerInfoPo.setStarttime(startTime);
		customerInfoPo.setEndtime(endTime);
		customerInfoPo.setStarttimes(startTime1);
		customerInfoPo.setEndtimes(endTime1);
		customerInfoPo.setIntegralmin(integralmin);
		customerInfoPo.setIntegralmax(integralmax);
		customerInfoPo.setNumbermin(numbermin);
		customerInfoPo.setNumbermax(numbermax);
		customerInfoPo.setPricemin(pricemin);
		customerInfoPo.setPricemax(pricemax);
		customerInfoPo.setAllpricemin(allpricemin);
		customerInfoPo.setAllpricemax(allpricemax);
		customerInfoPo.setSelbspsuppliername(selbspsuppliername);
		customerInfoPo.setSelcstpsupplierid(selcstpsupplierid);
		customerInfoPo.setBrandName(brandName);
		customerInfoPo.setBrandID(brandID);
		customerInfoPo.setGoodsname(goodsname);
		customerInfoPo.setGoodsid(goodsid);
		customerInfoPo.setTechnologytypeid(technologyTypeID);
		customerInfoPo.setBbdframematerialtype(bbdframematerialtype);
		customerInfoPo.setBbdmaterialclass(bbdmaterialclass);
		customerInfoPo.setBbdrefractive(bbdrefractive);
		customerInfoPo.setBbdluminosityclass(bbdluminosityclass);
		customerInfoPo.setBbdfunctionclass(bbdfunctionclass);
		customerInfoPo.setBbdusetype(bbdusetype);
		customerInfoPo.setBbdstealthclass(bbdstealthclass);
		customerInfoPo.setPhoneflag(phoneflag);
		customerInfoPo.setSmeciwork(work);
		customerInfoPo.setSmecimemberorigin(memberoRigin);
		customerInfoPo.setSmecicardtype(cardtype);		
		customerInfoPo.setSrStartTime(srStartTime);
		customerInfoPo.setSrEndTime(srEndTime);		
		customerInfoPo.setSmeciopenid(openid);
		customerInfoPo.setSalsepersonname(request.getParameter("salsepersonname"));
		customerInfoPo.setHuifangcishu(request.getParameter("huifangcishu"));
		customerInfoPo.setSalestype(salesType);
		customerInfoPo.setPersontype(persontype);
		customerInfoPo.setSmeciflag(customerenable);
		customerInfoPo.setSmecishoplist(departmentsList);
		customerInfoPo.setSmeciremark(hyremark);
		
		int count = customerInfoMgr.getCustomerInfoCount1(customerInfoPo);
		request.setAttribute("count",count);

		return SUCCESS;
	}
	/**
	 * 发送短信
	 */
	public String insertCustomerInfoMessage() throws Exception {
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
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("发送短信");
		
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
		String phoneflag = Utility.getName(request.getParameter("phoneflag"));
		String work = Utility.getName(request.getParameter("work"));
		String memberoRigin = Utility.getName(request.getParameter("memberoRigin"));
		String cardtype = Utility.getName(request.getParameter("cardtype"));
		String smeciinterest = Utility.getName(request.getParameter("interestpolists"));
		
		String openid=Utility.getName(request.getParameter("openid"));
		String salesType=Utility.getName(request.getParameter("salestypeid"));
		String persontype=Utility.getName(request.getParameter("persontype"));
		
		String srStartTime=Utility.getName(request.getParameter("srStartTime"));
		String srEndTime=Utility.getName(request.getParameter("srEndTime"));
		String customerenable=Utility.getName(request.getParameter("customerenable"));
		String address=Utility.getName(request.getParameter("address"));
		
		CustomerInfoPo po = new CustomerInfoPo();
		po.setSmeciaddress(address);
		po.setSmeciinterest(smeciinterest);
		po.setSmecimemberid(memberid);
		po.setSmeciname(name);
		po.setSmeciphone(phone);
		po.setSmecisex(sex);
		po.setSmeciagemin(agemin);
		po.setSmeciagemax(agemax);
		po.setSmecishopcode(departmentid);
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
		po.setPhoneflag(phoneflag);
		po.setSmeciwork(work);
		po.setSmecimemberorigin(memberoRigin);
		po.setSmecicardtype(cardtype);		
		po.setSrStartTime(srStartTime);
		po.setSrEndTime(srEndTime);		
		po.setSmeciopenid(openid);
		po.setSalsepersonname(request.getParameter("salsepersonname"));
		po.setHuifangcishu(request.getParameter("huifangcishu"));
		po.setSalestype(salesType);
		po.setPersontype(persontype);
		po.setSmeciflag(customerenable);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		departmentsList = this.getDepartmentListByCompany(systemParameterPo, personInfoPo1);
		po.setSmecishoplist(departmentsList);
		
	    String msg = "";
		List<CustomerInfoPo> cps = customerInfoMgr.getCustomerInfoListMessage(po);
					
		SendNotePo snpo = new SendNotePo();
		snpo.setSnpersonid(personInfoPo1.getId());
		snpo.setSndepartmentid(personInfoPo1.getDepartmentID());
		snpo.setSnnotetypeid("14");
		snpo.setSnnotecontent(Utility.getName(request.getParameter("content")));
		
		if(null != cps && cps.size() > 0){
			
			customerInfoMgr.insertCustomerInfoMessage(cps,snpo,logPo);
			
			msg = "发送短信成功！";	
		}else{
			msg = "没有会员接收短信！";			
		}
		
		this.clearMessages();
		this.addActionMessage(getText(msg));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;		
	}
	
	public String initExportCustomerInfo() throws Exception {

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
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());		
		
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
		String phoneflag = Utility.getName(request.getParameter("phoneflag"));
		String work = Utility.getName(request.getParameter("work"));
		String memberoRigin = Utility.getName(request.getParameter("memberoRigin"));
		String cardtype = Utility.getName(request.getParameter("cardtype"));
		String openid=Utility.getName(request.getParameter("openid"));
		String salesType=Utility.getName(request.getParameter("salestypeid"));
		String persontype=Utility.getName(request.getParameter("persontype"));
		String address=Utility.getName(request.getParameter("address"));		
		String srStartTime=Utility.getName(request.getParameter("srStartTime"));
		String srEndTime=Utility.getName(request.getParameter("srEndTime"));
		String customerenable=Utility.getName(request.getParameter("customerenable"));
		String hyremark=Utility.getName(request.getParameter("hyremark"));			
		
		customerInfoPo = new CustomerInfoPo();
		if(!"".equals((request.getParameterValues("interestpolists")))&& null !=(request.getParameterValues("interestpolists"))){
			String[] interestpolists = request.getParameterValues("interestpolists");
			String smeciinterest = getinterestpolist(interestpolists);
			customerInfoPo.setSmeciinterest(smeciinterest);
		}
		customerInfoPo.setSmecimemberid(memberid);
		customerInfoPo.setSmeciname(name);
		customerInfoPo.setSmeciaddress(address);
		customerInfoPo.setSmeciphone(phone);
		customerInfoPo.setSmecisex(sex);
		customerInfoPo.setSmeciagemin(agemin);
		customerInfoPo.setSmeciagemax(agemax);
		customerInfoPo.setSmecishopcode(departmentid);
		customerInfoPo.setStarttime(startTime);
		customerInfoPo.setEndtime(endTime);
		customerInfoPo.setStarttimes(startTime1);
		customerInfoPo.setEndtimes(endTime1);
		customerInfoPo.setIntegralmin(integralmin);
		customerInfoPo.setIntegralmax(integralmax);
		customerInfoPo.setNumbermin(numbermin);
		customerInfoPo.setNumbermax(numbermax);
		customerInfoPo.setPricemin(pricemin);
		customerInfoPo.setPricemax(pricemax);
		customerInfoPo.setAllpricemin(allpricemin);
		customerInfoPo.setAllpricemax(allpricemax);
		customerInfoPo.setSelbspsuppliername(selbspsuppliername);
		customerInfoPo.setSelcstpsupplierid(selcstpsupplierid);
		customerInfoPo.setBrandName(brandName);
		customerInfoPo.setBrandID(brandID);
		customerInfoPo.setGoodsname(goodsname);
		customerInfoPo.setGoodsid(goodsid);
		customerInfoPo.setTechnologytypeid(technologyTypeID);
		customerInfoPo.setBbdframematerialtype(bbdframematerialtype);
		customerInfoPo.setBbdmaterialclass(bbdmaterialclass);
		customerInfoPo.setBbdrefractive(bbdrefractive);
		customerInfoPo.setBbdluminosityclass(bbdluminosityclass);
		customerInfoPo.setBbdfunctionclass(bbdfunctionclass);
		customerInfoPo.setBbdusetype(bbdusetype);
		customerInfoPo.setBbdstealthclass(bbdstealthclass);
		customerInfoPo.setPhoneflag(phoneflag);
		customerInfoPo.setSmeciwork(work);
		customerInfoPo.setSmecimemberorigin(memberoRigin);
		customerInfoPo.setSmecicardtype(cardtype);		
		customerInfoPo.setSrStartTime(srStartTime);
		customerInfoPo.setSrEndTime(srEndTime);		
		customerInfoPo.setSmeciopenid(openid);
		customerInfoPo.setSalsepersonname(request.getParameter("salsepersonname"));
		customerInfoPo.setHuifangcishu(request.getParameter("huifangcishu"));
		customerInfoPo.setSalestype(salesType);
		customerInfoPo.setPersontype(persontype);
		customerInfoPo.setSmeciflag(customerenable);
		customerInfoPo.setSmeciremark(hyremark);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo);
		customerInfoPo.setSmecishoplist(getDepartmentListBySystemParameter(systemParameterPo,departmentsList));
		
		int count = customerInfoMgr.getCustomerInfoCount1(customerInfoPo);
		request.setAttribute("count",count);
		
		return SUCCESS;
	}
	
	public String exportCustomerInfo() throws Exception {

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
		String phoneflag = Utility.getName(request.getParameter("phoneflag"));
		String work = Utility.getName(request.getParameter("work"));
		String memberoRigin = Utility.getName(request.getParameter("memberoRigin"));
		String cardtype = Utility.getName(request.getParameter("cardtype"));
		String openid=Utility.getName(request.getParameter("openid"));
		String salesType=Utility.getName(request.getParameter("salestypeid"));
		String persontype=Utility.getName(request.getParameter("persontype"));		
		String srStartTime=Utility.getName(request.getParameter("srStartTime"));
		String srEndTime=Utility.getName(request.getParameter("srEndTime"));
		String customerenable=Utility.getName(request.getParameter("customerenable"));
		String address=Utility.getName(request.getParameter("address"));
		String hyremark=Utility.getName(request.getParameter("hyremark"));	
		
		customerInfoPo = new CustomerInfoPo();
		if(!"".equals((request.getParameterValues("interestpolists")))&& null !=(request.getParameterValues("interestpolists"))){
			String[] interestpolists = request.getParameterValues("interestpolists");
			String smeciinterest = getinterestpolist(interestpolists);
			customerInfoPo.setSmeciinterest(smeciinterest);
		}
		customerInfoPo.setSmeciaddress(address);
		customerInfoPo.setSmecimemberid(memberid);
		customerInfoPo.setSmeciname(name);
		customerInfoPo.setSmeciphone(phone);
		customerInfoPo.setSmecisex(sex);
		customerInfoPo.setSmeciagemin(agemin);
		customerInfoPo.setSmeciagemax(agemax);
		customerInfoPo.setSmecishopcode(departmentid);
		customerInfoPo.setStarttime(startTime);
		customerInfoPo.setEndtime(endTime);
		customerInfoPo.setStarttimes(startTime1);
		customerInfoPo.setEndtimes(endTime1);
		customerInfoPo.setIntegralmin(integralmin);
		customerInfoPo.setIntegralmax(integralmax);
		customerInfoPo.setNumbermin(numbermin);
		customerInfoPo.setNumbermax(numbermax);
		customerInfoPo.setPricemin(pricemin);
		customerInfoPo.setPricemax(pricemax);
		customerInfoPo.setAllpricemin(allpricemin);
		customerInfoPo.setAllpricemax(allpricemax);
		customerInfoPo.setSelbspsuppliername(selbspsuppliername);
		customerInfoPo.setSelcstpsupplierid(selcstpsupplierid);
		customerInfoPo.setBrandName(brandName);
		customerInfoPo.setBrandID(brandID);
		customerInfoPo.setGoodsname(goodsname);
		customerInfoPo.setGoodsid(goodsid);
		customerInfoPo.setTechnologytypeid(technologyTypeID);
		customerInfoPo.setBbdframematerialtype(bbdframematerialtype);
		customerInfoPo.setBbdmaterialclass(bbdmaterialclass);
		customerInfoPo.setBbdrefractive(bbdrefractive);
		customerInfoPo.setBbdluminosityclass(bbdluminosityclass);
		customerInfoPo.setBbdfunctionclass(bbdfunctionclass);
		customerInfoPo.setBbdusetype(bbdusetype);
		customerInfoPo.setBbdstealthclass(bbdstealthclass);
		customerInfoPo.setPhoneflag(phoneflag);
		customerInfoPo.setSmeciwork(work);
		customerInfoPo.setSmecimemberorigin(memberoRigin);
		customerInfoPo.setSmecicardtype(cardtype);		
		customerInfoPo.setSrStartTime(srStartTime);
		customerInfoPo.setSrEndTime(srEndTime);		
		customerInfoPo.setSmeciopenid(openid);
		customerInfoPo.setSalsepersonname(request.getParameter("salsepersonname"));
		customerInfoPo.setHuifangcishu(request.getParameter("huifangcishu"));
		customerInfoPo.setSalestype(salesType);
		customerInfoPo.setPersontype(persontype);
		customerInfoPo.setSmeciflag(customerenable);
		customerInfoPo.setSmeciremark(hyremark);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo);
		customerInfoPo.setSmecishoplist(getDepartmentListBySystemParameter(systemParameterPo,departmentsList));
		
		setFileName(java.net.URLEncoder.encode("顾客信息导出表.xlsx", "UTF-8"));

		try {

			inputStream = customerInfoMgr.bulidCustomerInfoExcel(customerInfoPo);
			
		} catch (Exception e) {
			System.out.println(inputStream);
			System.out.println("顾客信息导出失败：" + e.getMessage());
		}
	
		return SUCCESS;
	}

	/**
	 * 初始化顾客基本资料新增
	 */
	public String initInsertCustomerInfo() throws Exception {
		
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
		
		String cid = "";
		if(session.get("cid") != null){
			cid = session.get("cid").toString();
			session.remove("cid");
		}
		
		if("".equals(cid)){
			//年龄下拉列表
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			int endy = Integer.parseInt(sdf.format(new Date()));
			int beginy = endy-100;
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			request.setAttribute("endy", endy);
			request.setAttribute("beginy", beginy);
			request.setAttribute("moduleID", moduleID);
			
			// 得到系统参数的信息
			CompanyNamePo tcpo = new CompanyNamePo(); 
			tcpo.setFcnId(personInfoPo.getPersoncompanyid());
			companyNamePo = companyNameMgr.getCompanyName(tcpo);
			
			worktypepolist = workTypeMgr.getWorkTypeList();
			persontypepolist = workTypeMgr.getPersonTypeList();
			interestpolist = interestMgr.getInterestList();
			memberoriginpolist = memberOriginMgr.selectMemberOriginList();
			memberManagementList = customerInfoMgr.getMemberCardTypeList();
			
			area1List = areaMgr.getAjaxAreaData("1", "000000000000");
			area2List = areaMgr.getAjaxAreaData("2", systemParameterPo.getFsparea1());
			area3List = areaMgr.getAjaxAreaData("3", systemParameterPo.getFsparea2());
			area4List = areaMgr.getAjaxAreaData("4", systemParameterPo.getFsparea3());
			area5List = areaMgr.getAjaxAreaData("5", systemParameterPo.getFsparea4());
			
			customerInfoPo = new CustomerInfoPo();
			request.setAttribute("arg0", request.getParameter("arg0"));
		}else{
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			
			customerInfoPo = new CustomerInfoPo();
			customerInfoPo.setSmecimemberid(cid);
			customerInfoPo = customerInfoMgr.noGetCustomerInfoDownload(customerInfoPo);
			
			interestpolist = interestMgr.getInterestList();
			worktypepolist = workTypeMgr.getWorkTypeList();
			persontypepolist = workTypeMgr.getPersonTypeList();
			memberoriginpolist = memberOriginMgr.selectMemberOriginList();
			
			if(!"".equalsIgnoreCase(Utility.getName(customerInfoPo.getSmeciinterest()))){
				interestpolist = getInterestList(interestpolist, customerInfoPo.getSmeciinterest());
			}
			
			//年龄下拉列表
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			int endy = Integer.parseInt(sdf.format(new Date()));
			int beginy = endy-100;
				
			request.setAttribute("endy", endy);
			request.setAttribute("beginy", beginy);
			
			//生日下拉列表
			String birthday=Utility.getName(customerInfoPo.getSmecibirthday());
			
			String year = birthday.equals("") ? "" : birthday.substring(0 , 4);
			String month = birthday.equals("") ? "" : birthday.substring(5 , 7);
			String day = birthday.equals("") ? "" : birthday.substring(8 , 10);
			
			if(!day.equals("") && Integer.valueOf(Utility.getName(day)) < 10){
				day = day.substring(1);
			}
			
			request.setAttribute("year", year);
			request.setAttribute("month", month.startsWith("0") ? month.substring(1) : month);
			request.setAttribute("day", day.startsWith("0") ? day.substring(1) : day);
			request.setAttribute("zones", Utility.getName(customerInfoPo.getSmecizone()).equals("") ? "" : Utility.getName(customerInfoPo.getSmecizone()).replaceAll(" ", "").split(","));
			
			memberManagementList = customerInfoMgr.getMemberCardTypeList();
			
			area1List = areaMgr.getAjaxAreaData("1", "000000000000");
			area2List = areaMgr.getAjaxAreaData("2", customerInfoPo.getSmeciarea1());
			area3List = areaMgr.getAjaxAreaData("3", customerInfoPo.getSmeciarea2());
			area4List = areaMgr.getAjaxAreaData("4", customerInfoPo.getSmeciarea3());
			area5List = areaMgr.getAjaxAreaData("5", customerInfoPo.getSmeciarea4());
		}
		
		return SUCCESS;
	}

	/**
	 * 顾客基本资料新增
	 */
	public String insertCustomerInfo() throws Exception {
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		//年龄下拉列表
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int endy = Integer.parseInt(sdf.format(new Date()));
		int beginy = endy-100;
			
		request.setAttribute("endy", endy);
		request.setAttribute("beginy", beginy);
		
		String year = Utility.getName(request.getParameter("birthYear"));
		String month = Utility.getName(request.getParameter("birthMonth"));
		String day = Utility.getName(request.getParameter("birthday"));
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		
		if (month.length() == 1){
			month = "0" + month;
		}
		if (day.length() == 1){
			day = "0" + day;
		}
		
		String birthday = year + "-" + month + "-" + day;
		
		customerInfoPo.setSmecibirthday(birthday);

		customerInfoPo.setSmeciintegral("0");
		// 取得登陆人允许操作的仓位&部门 Begin
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		customerInfoPo.setSmecishopcode(personInfoPo.getDepartmentID());
		worktypepolist = workTypeMgr.getWorkTypeList();
		persontypepolist = workTypeMgr.getPersonTypeList();
		interestpolist = interestMgr.getInterestList();
		memberoriginpolist = memberOriginMgr.selectMemberOriginList();
		// 取得登陆人允许操作的仓位&部门 End
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		customerInfoPo.setSmeciregister(personInfoPo.getId());
		
		memberManagementList = customerInfoMgr.getMemberCardTypeList();
		
		if(customerInfoPo.getCtype().equals("1"))
		{
			CustomerInfoPo cpo=customerInfoMgr.getCustomerInfoByH();
			if(null!=cpo && null!=cpo.getSmecicustomerid())
			{
				String temp="1"+cpo.getSmecimemberid().substring(1);
				long aa=Long.parseLong(temp)+1;
				String bb="H"+(aa+"").substring(1);
				customerInfoPo.setSmecimemberid(bb);
			}else
			{
				customerInfoPo.setSmecimemberid("H0000000001");
			}
		}
		
		//用姓名以及电话匹配是否存在该用户
		CustomerInfoPo customerInfoPo1 = new CustomerInfoPo();
		customerInfoPo1 = customerInfoMgr.getCustomerInfocall(customerInfoPo);
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("会员卡号："+customerInfoPo.getSmecimemberid()+" 新增");
		String[] interestpolist = request.getParameterValues("interestpolists");
		String smeciinterest = getinterestpolist(interestpolist);
		customerInfoPo.setSmeciinterest(smeciinterest);
		if(!"".equals(Utility.getName(customerInfoPo1.getSmecimemberid()))){
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.person.repeated")+customerInfoPo1.getSmecimemberid());
			request.setAttribute("repeat", "1");
			
			return ERROR;
		}
		
		int count = customerInfoMgr.getCount(customerInfoPo);
		
		int Membercount = customerInfoMgr.getCount();
		if(count > 0){
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.person.repeat"));
			request.setAttribute("repeat", "1");
			
			return ERROR;
			
		}else if(count == 0){
			if(Membercount == 0 && !Utility.getName(permissionPo.getKeyf()).equals("1")){
				
				this.clearMessages();
				this.addActionMessage(getText("请设置默认的会员卡类型!"));
				request.setAttribute("repeat", "1");
				
				return ERROR;
				
		}
			//----------用于照片上传 moyongsheng 2012-12-12-18:39			
			String rootPath = request.getRealPath("/");
			if(customerInfoPo.getMemberPicPath()!=null&&!customerInfoPo.getMemberPicPath().equals("")){
				customerInfoPo.setRootPath(rootPath);
			}
			//----------用于照片上传 moyongsheng 2012-12-12-18:39
			
			customerInfoMgr.insertCustomerInfo(customerInfoPo,logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			
			if(!"".equals(Utility.getName(request.getParameter("arg0")))){
				if("registered".equals(Utility.getName(request.getParameter("arg0"))))
				{
					request.setAttribute("url", "'initRegistered.action?arg0=registered&regMemberID="+customerInfoPo.getSmecimemberid()+"'");
					request.setAttribute("flag", GlobalConstants.OPENUPDATE3);
				}else if("salseall".equals(Utility.getName(request.getParameter("arg0")))){				
					request.setAttribute("url", "'initSalesAll.action?arg0=salseall&moduleID="+moduleID+"&regMemberID="+customerInfoPo.getSmecimemberid()+"&customerprinttype=1"+"'");
					request.setAttribute("flag", GlobalConstants.OPENUPDATE3);
				}else{
					request.setAttribute("url", "'queryShopSalesMain.action?arg0=salseallnew&moduleID="+moduleID+"&regMemberID="+customerInfoPo.getSmecimemberid()+"&customerprinttype=1"+"'");
					request.setAttribute("flag", GlobalConstants.OPENUPDATE3);
				}
				
			}else{
				request.setAttribute("memberid", customerInfoPo.getSmecimemberid());
				request.setAttribute("departmentID", personInfoPo.getDepartmentID());
				request.setAttribute("flag", GlobalConstants.OPENUPDATE12);
			}
		}
		
		return SUCCESS;
	}
	
	private String getinterestpolist(String[] interestpolist) {
		String interest = "";
		if(null!=interestpolist && !"".equals(interestpolist))
		{
			for (int i = 0; i < interestpolist.length; i++) {

				if ("".equals(interest)) {
					interest = interestpolist[i];
				} else {
					interest = interest + "," + interestpolist[i];
				}
			}
		}

		return interest;
	}

	/**
	 * 顾客基本资料详细
	 */
	public String initDetailsCustomerInfo() throws Exception {
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String id = Utility.getName(request.getParameter("hid"));
		String menid = Utility.getName(request.getParameter("menid"));
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecicustomerid(id);
		customerInfoPo.setSmecimemberid(menid);
		customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
		interestpolist = interestMgr.getInterestList();

		if(!"".equalsIgnoreCase(Utility.getName(customerInfoPo.getSmeciinterest())))
		{
			interestpolist = getInterestList(interestpolist, customerInfoPo.getSmeciinterest());
		}
		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);
		
		gxlist = customerInfoMgr.selectGXList(customerInfoPo);
		
		return SUCCESS;
	}

	/**
	 * 初始化顾客基本资料更新
	 */
	public String initUpdateCustomerInfo() throws Exception {
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
		
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String id = Utility.getName(request.getParameter("hid"));
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecicustomerid(id);
		customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
		
		interestpolist = interestMgr.getInterestList();
		worktypepolist = workTypeMgr.getWorkTypeList();
		persontypepolist = workTypeMgr.getPersonTypeList();
		memberoriginpolist = memberOriginMgr.selectMemberOriginList();
		
		if(!"".equalsIgnoreCase(Utility.getName(customerInfoPo.getSmeciinterest()))){
			interestpolist = getInterestList(interestpolist, customerInfoPo.getSmeciinterest());
		}
		
		//年龄下拉列表
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int endy = Integer.parseInt(sdf.format(new Date()));
		int beginy = endy-100;
			
		request.setAttribute("endy", endy);
		request.setAttribute("beginy", beginy);
		
		//生日下拉列表
		String birthday=Utility.getName(customerInfoPo.getSmecibirthday());
		
		String year = birthday.equals("") ? "" : birthday.substring(0 , 4);
		String month = birthday.equals("") ? "" : birthday.substring(5 , 7);
		String day = birthday.equals("") ? "" : birthday.substring(8 , 10);
		
		if(!day.equals("") && Integer.valueOf(Utility.getName(day)) < 10){
			day = day.substring(1);
		}
		
		request.setAttribute("year", year);
		request.setAttribute("month", month.startsWith("0") ? month.substring(1) : month);
		request.setAttribute("day", day.startsWith("0") ? day.substring(1) : day);
		request.setAttribute("zones", Utility.getName(customerInfoPo.getSmecizone()).equals("") ? "" : Utility.getName(customerInfoPo.getSmecizone()).replaceAll(" ", "").split(","));
		
		memberManagementList = customerInfoMgr.getMemberCardTypeList();
		
		area1List = areaMgr.getAjaxAreaData("1", "000000000000");
		area2List = areaMgr.getAjaxAreaData("2", customerInfoPo.getSmeciarea1());
		area3List = areaMgr.getAjaxAreaData("3", customerInfoPo.getSmeciarea2());
		area4List = areaMgr.getAjaxAreaData("4", customerInfoPo.getSmeciarea3());
		area5List = areaMgr.getAjaxAreaData("5", customerInfoPo.getSmeciarea4());
		
		return SUCCESS;
	}
	
	private List<InterestPo> getInterestList(List<InterestPo> list, String interest) {
		List<InterestPo> glist = new ArrayList();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			InterestPo po = (InterestPo) it.next();
			String[] interests = interest.split(",");
			for (int i = 0; i < interests.length; i++) {
				if (po.getBirid().equals(interests[i])) {
					po.setFlag("1");
					break;
				} else {
					po.setFlag("0");
				}
			}
			glist.add(po);
		}
		return glist;
	}

	/**
	 * 顾客基本资料更新
	 */
	public String updateCustomerInfo() throws Exception {
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
	
		String year = Utility.getName(request.getParameter("birthYear"));
		String month = Utility.getName(request.getParameter("birthMonth"));
		String day = Utility.getName(request.getParameter("birthday"));
		
		CustomerInfoPo customerInfoPo1 = customerInfoMgr.getCustomerInfo(customerInfoPo);
		String memberid = Utility.getName(customerInfoPo1.getSmecimemberid());  // 当前会员的会员卡号		

		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		
		if (month.length() == 1){
			month = "0" + month;
		}
		if (day.length() == 1){
			day = "0" + day;
		}
		
		String birthday = year + "-" + month + "-" + day;
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		customerInfoPo.setSmeciupdater(personInfoPo.getId());
		customerInfoPo.setSmecibirthday(birthday);		
		
		memberManagementList = customerInfoMgr.getMemberCardTypeList();
		
		request.setAttribute("zones", Utility.getName(customerInfoPo.getSmecizone()).equals("") ? "" : Utility.getName(customerInfoPo.getSmecizone()).replaceAll(" ", "").split(","));
		
		//用电话匹配是否存在该用户
		customerInfoPo.setSmeciiscustomerid("0");  // 不包含当前会员ID
		int cinfo = customerInfoMgr.getCustomerInfoByPhone(customerInfoPo);
		if(cinfo > 0){
			
			CustomerInfoPo customerInfoPo2 = new CustomerInfoPo();			
			customerInfoPo2 = customerInfoMgr.getCustomerInfocall(customerInfoPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.person.repeated")+customerInfoPo2.getSmecimemberid());
			request.setAttribute("repeat", "1");
			
			
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			customerInfoPo.setSmecimemberid(customerInfoPo.getSmecimemberoldid());
			
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			interestpolist = interestMgr.getInterestList();
			worktypepolist = workTypeMgr.getWorkTypeList();
			persontypepolist = workTypeMgr.getPersonTypeList();
			memberoriginpolist = memberOriginMgr.selectMemberOriginList();
			
			if(!"".equalsIgnoreCase(Utility.getName(customerInfoPo.getSmeciinterest()))){
				interestpolist = getInterestList(interestpolist, customerInfoPo.getSmeciinterest());
			}
			
			return ERROR;
		}
				
		String[] interestpolist2 = request.getParameterValues("interestpolists");
		String smeciinterest = getinterestpolist(interestpolist2);
		customerInfoPo.setSmeciinterest(smeciinterest);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("会员卡号："+customerInfoPo.getSmecimemberid()+" 修改");
				
		
		
		//----------用于照片上传 moyongsheng 2012-12-12-18:39			
		String rootPath = request.getRealPath("/");
		if(customerInfoPo.getMemberPicPath()!=null&&!customerInfoPo.getMemberPicPath().equals("")){
			customerInfoPo.setRootPath(rootPath);
		}
		//----------用于照片上传 moyongsheng 2012-12-12-18:39
		
		customerInfoPo.setUpgradeperson(createPerson);
		customerInfoPo.setUpgradeshopcode(personInfoPo1.getDepartmentID());
		
		int count = 0;
		if (!memberid.trim().equals(Utility.getName(customerInfoPo.getSmecimemberid()).trim())){
			count = customerInfoMgr.getCount(customerInfoPo);  //判断新的会员卡号是否被占用
		}
		int Membercount = customerInfoMgr.getCount();    // 判断是否存在默认的会员卡类型
		if(count > 0){			
			interestpolist = interestMgr.getInterestList();
			worktypepolist = workTypeMgr.getWorkTypeList();
			persontypepolist = workTypeMgr.getPersonTypeList();
			memberoriginpolist = memberOriginMgr.selectMemberOriginList();			
			if(!"".equalsIgnoreCase(Utility.getName(customerInfoPo.getSmeciinterest()))){
				interestpolist = getInterestList(interestpolist, customerInfoPo.getSmeciinterest());
			}
			request.setAttribute("zones", customerInfoPo.getSmecizone().replaceAll(" ", "").split(","));
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.person.repeat"));
			request.setAttribute("repeat", "1");
			
			return ERROR;
			
		}else if(count == 0){
			if(Membercount == 0 && !Utility.getName(permissionPo.getKeyf()).equals("1")){
				interestpolist = interestMgr.getInterestList();
				worktypepolist = workTypeMgr.getWorkTypeList();
				persontypepolist = workTypeMgr.getPersonTypeList();
				memberoriginpolist = memberOriginMgr.selectMemberOriginList();			
				if(!"".equalsIgnoreCase(Utility.getName(customerInfoPo.getSmeciinterest()))){
					interestpolist = getInterestList(interestpolist, customerInfoPo.getSmeciinterest());
				}
				request.setAttribute("zones", customerInfoPo.getSmecizone().replaceAll(" ", "").split(","));
				
				this.clearMessages();
				this.addActionMessage(getText("请设置默认的会员卡类型!"));
				request.setAttribute("repeat", "1");
				
				return ERROR;				
		    }
		}
		customerInfoMgr.updateCustomerInfo(customerInfoPo,logPo );
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化顾客基本资料删除
	 */
	public String initDeleteCustomerInfo() throws Exception {	
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
		
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String id = Utility.getName(request.getParameter("hid"));
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecicustomerid(id);		
		
		customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);

		return SUCCESS;
	}

	/**
	 * 删除顾客基本资料
	 */
	public String deleteCustomerInfo() throws Exception {
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
		String smecimemberid = request.getParameter("smecimemberid");
		
		int isdeletecustomer = customerInfoMgr.selectCustomerInfoIsDelete(customerInfoPo);
		
		if(isdeletecustomer > 0){
			this.clearMessages();
			this.addActionMessage("该顾客在系统中已经存在 子卡、验光记录、销售记录、挂号、积分、储值等相关信息，因此不能被删除！");
			request.setAttribute("hid", customerInfoPo.getSmecicustomerid());
			return ERROR;
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 删除
		logPo.setsLogContent("会员卡号："+smecimemberid+" 删除!");	
		
		//----------用于删除照片 moyongsheng 2012-12-12-18:39			
		String rootPath = request.getRealPath("/");
		customerInfoPo.setRootPath(rootPath);
		//----------用于删除照片 moyongsheng 2012-12-12-18:39		
		customerInfoMgr.deleteCustomerInfo(customerInfoPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 清楚指定会员积分
	 */
	public String updateCustomerInfoAppointCredit() throws Exception {
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
		String[] chks = request.getParameterValues("chk");
		
		List<CustomerInfoPo> clist = new ArrayList<CustomerInfoPo>();
		String logmessage = "";
		for(int i=0; i<chks.length; i++){
			CustomerInfoPo cpo = new CustomerInfoPo();
			cpo.setSmecicustomerid(chks[i]);
			logmessage = logmessage+chks[i]+",";
			clist.add(cpo);
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");
		logPo.setsLogContent("会员卡号："+logmessage+" 积分被恢复为初始状态(0)!");	
		
		customerInfoMgr.updateCustomerInfoAppointCredit(clist, logPo);
		
		this.clearMessages();
		request.setAttribute("url", "'selCustomerInfo.action?moduleID="+moduleID+"'");
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.MOVE);
		return SUCCESS;
	}
	
	/**
	 * 清除所有会员积分
	 */
	public String updateCustomerInfoAllCredit() throws Exception {
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
		logPo.setsLogOpID("2");
		logPo.setsLogContent("将操作日期之前的所有会员积分恢复初始状态(0)!");	
		
		customerInfoMgr.updateCustomerInfoAllCredit(logPo);
		
		this.clearMessages();
		request.setAttribute("url", "'selCustomerInfo.action?moduleID="+moduleID+"'");
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}

	/**
	 * 查询会员导出信息配置项
	 */
	public String selCustomerExportProperty() throws Exception {		
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
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		memberExportList = customerInfoMgr.getCustomerInfoForExportList("");
		
		return SUCCESS;
	}
	
	/**
	 * 更新会员导出信息配置项
	 */
	public String saveCustomerExportProperty() throws Exception {
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
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("配置会员导出信息!");	
		
		String name = Utility.getName(request.getParameter("name"));
		String isauto = Utility.getName(request.getParameter("isauto"));
		
		memberExportPo = new MemberExportPo();
		memberExportPo.setBmeid(name);
		memberExportPo.setBmeexportflag(isauto);
		
		customerInfoMgr.updateCustomerExportInfoProperty(memberExportPo,logPo);
		
		this.clearMessages();
		request.setAttribute("url", "'selCustomerExportProperty.action?moduleID="+moduleID+"'");
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化会员停用启用
	 */
	public String initCustomerEnableUpdate() throws Exception {
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

		String chkarray = Utility.getName(request.getParameter("chkarray"));
		String enableflag = Utility.getName(request.getParameter("enableflag"));

		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecicustomerid(chkarray);
		customerInfoPo.setSmeciflag(enableflag);

		return SUCCESS;
	}
	
	/**
	 * 会员停用启用
	 */
	public String updateCustomerEnable() throws Exception {
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
		logPo.setsLogOpID("2");

		customerInfoMgr.updateCustomerEnable(customerInfoPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化集团端顾客基本资料列表
	 */
	public String initCustomerInfoDownloadSel() throws Exception {
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
		
		String type = Utility.getName(request.getParameter("type"));
		String isnullfcustomerid = Utility.getName(request.getParameter("isnullfcustomerid"));
		request.setAttribute("type", type);
		request.setAttribute("isnullfcustomerid", isnullfcustomerid);
		
		String customerjsp = Utility.getName(request.getParameter("customerjsp"));
		request.setAttribute("customerjsp", customerjsp);
		
		return SUCCESS;
	}
	
	/**
	 * 查询集团端顾客基本资料列表
	 */
	public String selCustomerInfoDownload() throws Exception {
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

		String memberid = Utility.getName(request.getParameter("memberid"));
		String name = Utility.getName(request.getParameter("name"));
		String phone = Utility.getName(request.getParameter("phone"));
		String sex = Utility.getName(request.getParameter("sex"));
		String type = Utility.getName(request.getParameter("type"));
		String customerjsp = Utility.getName(request.getParameter("customerjsp"));
		request.setAttribute("customerjsp", customerjsp);
		String isnullfcustomerid = Utility.getName(request.getParameter("isnullfcustomerid"));

		List<DepartmentsPo> departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo);
		
		CustomerInfoPo po = new CustomerInfoPo();
		po.setSmecimemberid(memberid);
		po.setSmeciname(name);
		po.setSmeciphone(phone);
		po.setSmecisex(sex);
		po.setSmeciflag("1");
		po.setIsnullfcustomerid(isnullfcustomerid);//设置仅仅查询主卡会员
		po.setSmecishoplist(getDepartmentListBySystemParameter(systemParameterPo,departmentsList));
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = customerInfoMgr.noGetCustomerInfoDownloadCount(po);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
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
			customerInfoList = customerInfoMgr.noGetCustomerInfoDownloadList(po, page
					.getStart(), page.getPageSize());
			
			//计算顾客年龄
			for (CustomerInfoPo customer : customerInfoList) {
				if (!Utility.getName(customer.getSmecibirthday()).equals("")){
					String birthdayYear = customer.getSmecibirthday().substring(0,4);
					int age = Calendar.getInstance().get(Calendar.YEAR)	- Integer.parseInt(birthdayYear);
					customer.setFmmage(Integer.toString(age));	
				}
			}

			
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			customerInfoList = null;
		}

		request.setAttribute("memberid", memberid);
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("sex", sex);
		request.setAttribute("type", type);
		request.setAttribute("isnullfcustomerid", isnullfcustomerid);

		return SUCCESS;
	}
	
	/**
	 * 初始化顾客基本资料更新
	 */
	public String initInsertCustomerInfoDownload() throws Exception {
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
		
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String cid = Utility.getName(request.getParameter("cid"));
		session.put("cid", cid);
		
		this.clearMessages();
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public List<CustomerInfoPo> getCustomerInfoList() {
		return customerInfoList;
	}

	public void setCustomerInfoList(List<CustomerInfoPo> customerInfoList) {
		this.customerInfoList = customerInfoList;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}
	public List<CustomerInfoPo> getGxlist() {
		return gxlist;
	}
	public void setGxlist(List<CustomerInfoPo> gxlist) {
		this.gxlist = gxlist;
	}

	public AreaMgr getAreaMgr() {
		return areaMgr;
	}
	public void setAreaMgr(AreaMgr areaMgr) {
		this.areaMgr = areaMgr;
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
	public FittingTemplateTypeMgr getFittingTemplateTypeMgr() {
		return fittingTemplateTypeMgr;
	}
	public void setFittingTemplateTypeMgr(
			FittingTemplateTypeMgr fittingTemplateTypeMgr) {
		this.fittingTemplateTypeMgr = fittingTemplateTypeMgr;
	}

}
