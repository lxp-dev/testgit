package com.pengsheng.eims.sales.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.mgr.SetMealMgr;
import com.pengsheng.eims.sales.persistence.SetMealChildPropertyPo;
import com.pengsheng.eims.sales.persistence.SetMealEntryPo;
import com.pengsheng.eims.sales.persistence.SetMealEntryTempPo;
import com.pengsheng.eims.sales.persistence.SetMealParentPropertyPo;
import com.pengsheng.eims.sales.persistence.SetMealPo;
import com.pengsheng.eims.sales.persistence.SetMealPropertyValuePo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.FrameMaterialMgr;
import com.pengsheng.eims.system.mgr.MemberManagementMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.mgr.TeachnologyTypeMgr;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.system.persistence.IntegralPo;
import com.pengsheng.eims.system.persistence.MaxDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.MaxDiscountPo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.system.persistence.TeachnologyTypePo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class SetMealAction extends BaseAction {
	private BrandMgr brandMgr;
	private List<GoodsLevelPo> selectGoodsLevelList;
	private PersonPermissionMgr personPermissionMgr;
	private MemberManagementMgr memberManagementMgr;
	private List<MemberManagementPo> memberManagementlist;
	private SetMealPo setMealPo;
	private List<SetMealPo> setMealList;
	private List<SetMealEntryPo> salesGoodsArrayList;
	private List<SetMealEntryPo> creditGoodsArrayList;
	private SetMealEntryTempPo salesGoodsArray;
	private SetMealEntryTempPo creditGoodsArray;
	private SetMealEntryPo setMealEntryPo;
	private DepartmentsMgr departmentsMgr;	
	private DepartmentsPo departmentsPo;
	private List<DepartmentsPo> departmentList = null;
	private SetMealMgr setMealMgr;
	private UnitMgr unitMgr;
	private List<RefractiveSetPo> refractiveSetList = null;
	private List<GoodsInfoPo> goodsList = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private GoodsInfoTempPo goodsInfoTempPo = null;
	private IntegralPo integralPo = null;
	private List<IntegralPo> integralList = null;
	private TeachnologyTypeMgr teachnologyTypeMgr;
	private List<TeachnologyTypePo> teachnologyTypeList;
	private List<MaxDiscountPo> maxDiscountList;
	private MaxDiscountPo maxDiscountPo;
	private FrameMaterialMgr frameMaterialMgr = null;	
	private List<FrameMaterialPo> frameMateriallist = null;
	private List<SetMealParentPropertyPo> setMealParentPropertyList = null;
	private List<SetMealChildPropertyPo> setMealChildPropertyList = null;
	private List<SetMealPropertyValuePo> setMealPropertyValueList = null;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	private MaxDiscountDetailsPo maxDiscountDetailsPo;
	private List<MaxDiscountDetailsPo> maxDiscountDetailsPos;
	
	
	
	public MemberManagementMgr getMemberManagementMgr() {
		return memberManagementMgr;
	}

	public void setMemberManagementMgr(MemberManagementMgr memberManagementMgr) {
		this.memberManagementMgr = memberManagementMgr;
	}

	public List<MemberManagementPo> getMemberManagementlist() {
		return memberManagementlist;
	}

	public void setMemberManagementlist(
			List<MemberManagementPo> memberManagementlist) {
		this.memberManagementlist = memberManagementlist;
	}

	public MaxDiscountDetailsPo getMaxDiscountDetailsPo() {
		return maxDiscountDetailsPo;
	}

	public void setMaxDiscountDetailsPo(MaxDiscountDetailsPo maxDiscountDetailsPo) {
		this.maxDiscountDetailsPo = maxDiscountDetailsPo;
	}

	public List<MaxDiscountDetailsPo> getMaxDiscountDetailsPos() {
		return maxDiscountDetailsPos;
	}

	public void setMaxDiscountDetailsPos(
			List<MaxDiscountDetailsPo> maxDiscountDetailsPos) {
		this.maxDiscountDetailsPos = maxDiscountDetailsPos;
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}

	public List<GoodsLevelPo> getSelectGoodsLevelList() {
		return selectGoodsLevelList;
	}

	public void setSelectGoodsLevelList(List<GoodsLevelPo> selectGoodsLevelList) {
		this.selectGoodsLevelList = selectGoodsLevelList;
	}

	public List<SetMealParentPropertyPo> getSetMealParentPropertyList() {
		return setMealParentPropertyList;
	}

	public void setSetMealParentPropertyList(
			List<SetMealParentPropertyPo> setMealParentPropertyList) {
		this.setMealParentPropertyList = setMealParentPropertyList;
	}

	public List<SetMealChildPropertyPo> getSetMealChildPropertyList() {
		return setMealChildPropertyList;
	}

	public void setSetMealChildPropertyList(
			List<SetMealChildPropertyPo> setMealChildPropertyList) {
		this.setMealChildPropertyList = setMealChildPropertyList;
	}

	public List<SetMealPropertyValuePo> getSetMealPropertyValueList() {
		return setMealPropertyValueList;
	}

	public void setSetMealPropertyValueList(
			List<SetMealPropertyValuePo> setMealPropertyValueList) {
		this.setMealPropertyValueList = setMealPropertyValueList;
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

	public List<MaxDiscountPo> getMaxDiscountList() {
		return maxDiscountList;
	}

	public void setMaxDiscountList(List<MaxDiscountPo> maxDiscountList) {
		this.maxDiscountList = maxDiscountList;
	}

	public MaxDiscountPo getMaxDiscountPo() {
		return maxDiscountPo;
	}

	public void setMaxDiscountPo(MaxDiscountPo maxDiscountPo) {
		this.maxDiscountPo = maxDiscountPo;
	}

	/**
	 * 初始化套餐查询
	 * @return
	 * @throws Exception
	 */
	public String initSetMealSel() throws Exception {
		
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
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "setMealSel";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 套餐查询
	 * @return
	 * @throws Exception
	 */
	public String setMealSel() throws Exception {
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
		
		String setMealTitle = Utility.getName(request.getParameter("setMealTitle"));
		String cstartTime = Utility.getName(request.getParameter("cstartTime"));
		String cendTime = Utility.getName(request.getParameter("cendTime"));
		String sstartTime = Utility.getName(request.getParameter("sstartTime"));
		String sendTime = Utility.getName(request.getParameter("sendTime"));
		String setMealClassif = Utility.getName(request.getParameter("setMealClassif"));
		String auditstate = Utility.getName(request.getParameter("auditstate"));
		String isenabled = Utility.getName(request.getParameter("isenabled"));
		
		request.setAttribute("setMealTitle",setMealTitle);
		request.setAttribute("cstartTime",cstartTime);
		request.setAttribute("cendTime",cendTime);
		request.setAttribute("sstartTime",sstartTime);
		request.setAttribute("sendTime",sendTime);
		request.setAttribute("setMealClassif",setMealClassif);
		request.setAttribute("auditstate",auditstate);
		request.setAttribute("isenabled",isenabled);
		
		setMealPo = new SetMealPo();
		setMealPo.setSsmsmclassify(setMealClassif);
		setMealPo.setSsmsmcreatebegindate(cstartTime);
		setMealPo.setSsmsmcreateenddate(cendTime);
		setMealPo.setSsmsmeffectivebegindate(sstartTime);
		setMealPo.setSsmsmeffectiveenddate(sendTime);
		setMealPo.setSsmsmtitle(setMealTitle);
		setMealPo.setSsmsmauditstate(auditstate);
		setMealPo.setSsmsmisenabled(isenabled);
		
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
		
		int count = setMealMgr.getSetMealCount(setMealPo);
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
			setMealList = setMealMgr.getSetMealList(setMealPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			setMealList = null;
		}
	
		return SUCCESS;
	}
	
	/**
	 * 套餐查询
	 * @return
	 * @throws Exception
	 */
	public String setMealSalesAllSel() throws Exception {
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
		
		String setMealTitle = Utility.getName(request.getParameter("setMealTitle"));
		String cstartTime = Utility.getName(request.getParameter("cstartTime"));
		String cendTime = Utility.getName(request.getParameter("cendTime"));
		String sstartTime = Utility.getName(request.getParameter("sstartTime"));
		String sendTime = Utility.getName(request.getParameter("sendTime"));
		String setMealClassif = Utility.getName(request.getParameter("setMealClassif"));
		String isenabled = Utility.getName(request.getParameter("isenabled"));
		String auditstate = "1";
		
		request.setAttribute("setMealTitle",setMealTitle);
		request.setAttribute("cstartTime",cstartTime);
		request.setAttribute("cendTime",cendTime);
		request.setAttribute("sstartTime",sstartTime);
		request.setAttribute("sendTime",sendTime);
		request.setAttribute("setMealClassif",setMealClassif);
		request.setAttribute("auditstate",auditstate);
		request.setAttribute("isenabled",isenabled);
		
		setMealPo = new SetMealPo();
		setMealPo.setSsmsmclassify(setMealClassif);
		setMealPo.setSsmsmcreatebegindate(cstartTime);
		setMealPo.setSsmsmcreateenddate(cendTime);
		setMealPo.setSsmsmeffectivebegindate(sstartTime);
		setMealPo.setSsmsmeffectiveenddate(sendTime);
		setMealPo.setSsmsmtitle(setMealTitle);
		setMealPo.setSsmsmauditstate(auditstate);
		setMealPo.setSsmsmisenabled(isenabled);
		setMealPo.setSsmsmshopcode(personInfoPo.getDepartmentID());
		
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
		
		int count = setMealMgr.getSetMealCount(setMealPo);
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
			setMealList = setMealMgr.getSetMealList(setMealPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			setMealList = null;
		}
	
		return SUCCESS;
	}
	
	/**
	 * 初始化套餐新增
	 * @return
	 * @throws Exception
	 */
	public String initSetMealInsert() throws Exception {
		
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
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = currMouthFirstDay.format(calendar.getTime());			
        request.setAttribute("createDate",createDate);
		
        departmentList = departmentsMgr.getDepartments("1","0");
        StringBuffer allDepartmentID = new StringBuffer();
        StringBuffer allDepartmentName = new StringBuffer();
		for (int i = 0; i < departmentList.size(); i++){
			allDepartmentID.append(Utility.getName(departmentList.get(i).getBdpdepartmentid())+",");
			allDepartmentName.append(Utility.getName(departmentList.get(i).getBdpdepartmentname())+",");
		}
		if (departmentList.size() > 0){
		    request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
		    request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));
		}
		
		refractiveSetList = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList(); 
		
		return SUCCESS;
	}
	
	/**
	 * 套餐新增
	 * @return
	 * @throws Exception
	 */
	public String insertSetMeal() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("套餐:" + Utility.getName(setMealPo.getSsmsmtitle()) + "新增!");
		
		setMealPo.setSsmsmcreateperson(createPerson);
		
		if (!"".equals(Utility.getName(setMealPo.getSsmsmauditstate()))){
			setMealPo.setSsmsmauditstate("1");
			setMealPo.setSsmsmauditperson(createPerson);
		}else{
			setMealPo.setSsmsmauditstate("0");
			setMealPo.setSsmsmauditperson("");
		}
		
		String[] goodscategoryID = request.getParameterValues("goodscategoryID");

		salesGoodsArrayList = new ArrayList<SetMealEntryPo>();
		String[] propertyArray = null;
		int count = 0;
		if (salesGoodsArray != null){
			count = salesGoodsArray.getSsmsggoodscategory().length;
		}
		for (int i = 0; i < count; i++){
			SetMealEntryPo entryPo = new SetMealEntryPo();
			String ssmsggoodscategory = goodscategoryID[i];
			String[] tmp = null;
			if (ssmsggoodscategory.indexOf("_") > 0){
				tmp = ssmsggoodscategory.split("_");
				ssmsggoodscategory = tmp[0];
			}else{
				tmp = new String[2];
				tmp[0] = ssmsggoodscategory;
				tmp[1] = "";
			}
			
			if (tmp[0].equals("6")){
				ssmsggoodscategory = tmp[1];
			}else{
				ssmsggoodscategory = tmp[0];
			}			
			
			entryPo.setSsmsgsetmealid(Utility.getName(setMealPo.getSsmsmid()));
			entryPo.setSsmsggoodscategory(ssmsggoodscategory);
			if (tmp[0].equals("3") || tmp[0].equals("4")){
				entryPo.setSsmsgiscustomize(Utility.getName(tmp[1]));
			}else{
				entryPo.setSsmsgiscustomize("");
			}
			entryPo.setSsmsgbrand(Utility.getName(salesGoodsArray.getSsmsgbrand()[i]));
			entryPo.setSsmsgsupplier(Utility.getName(salesGoodsArray.getSsmsgsupplier()[i]));
			entryPo.setSsmsggoodsid(Utility.getName(salesGoodsArray.getSsmsggoodsid()[i]));
			entryPo.setSsmsggoodsname(Utility.getName(salesGoodsArray.getSsmsggoodsname()[i]));
			entryPo.setSsmsgoodsclass(Utility.getName(salesGoodsArray.getSsmsgoodsclass()[i]).equals("") ? "1" : Utility.getName(salesGoodsArray.getSsmsgoodsclass()[i]));
			entryPo.setSsmsgmincostPrice(Utility.getName(salesGoodsArray.getSsmsgmincostPrice()[i]));
			entryPo.setSsmsgmaxcostPrice(Utility.getName(salesGoodsArray.getSsmsgmaxcostPrice()[i]));
			entryPo.setSsmsggoodsquantity(Utility.getName(salesGoodsArray.getSsmsggoodsquantity()[i]));			
			entryPo.setSsmsgexpensespendup(Utility.getName(salesGoodsArray.getSsmsgexpensespendup()[i]));
			entryPo.setSsmsgexpensespendul(Utility.getName(salesGoodsArray.getSsmsgexpensespendul()[i]));
			
			if (Utility.getName(setMealPo.getSsmsmdetailform()).equals("11") || Utility.getName(setMealPo.getSsmsmdetailform()).equals("12") || Utility.getName(setMealPo.getSsmsmdetailform()).equals("21")){
				entryPo.setSsmsgfavorableflag(Utility.getName(salesGoodsArray.getSsmsgfavorableflag()[i]));
				entryPo.setSsmsgdiscountrate(Utility.getName(salesGoodsArray.getSsmsgdiscountrate()[i]));			
				entryPo.setSsmsgspecialoffer(Utility.getName(salesGoodsArray.getSsmsgspecialoffer()[i]));
				entryPo.setSsmsgexpensecredit(Utility.getName(salesGoodsArray.getSsmsgexpensecredit()[i]));
				entryPo.setSsmsgretailPrice(Utility.getName(salesGoodsArray.getSsmsgretailPrice()[i]));	
			}else{
				entryPo.setSsmsgfavorableflag("1");
			}
			
			entryPo.setSsmsgflag("1");
			entryPo.setSsmsgbeginAmount(Utility.getName(salesGoodsArray.getSsmsgbeginAmount()[i]));
			entryPo.setSsmsgendAmount(Utility.getName(salesGoodsArray.getSsmsgendAmount()[i]));
			entryPo.setSsmsgsmallclass(Utility.getName(salesGoodsArray.getSsmsgoodspropertyarray()[i]));
			entryPo.setSsmsgbigclass(Utility.getName(salesGoodsArray.getSsmspropertyvaluearray()[i]));
						
			if (Utility.getName(entryPo.getSsmsgbigclass()).indexOf(",") > 0){
				propertyArray = Utility.getName(entryPo.getSsmsgbigclass()).split(",");
			}else{
				propertyArray = new String[1];
				propertyArray[0] = Utility.getName(entryPo.getSsmsgbigclass());
			}
			
			if (ssmsggoodscategory.equals("1")){	
				
				for (int j = 0; j < propertyArray.length; j++){
					if (propertyArray[j].indexOf(";") > 0 && propertyArray[j].split(";").length > 1){
						entryPo.setSsmsgjjcz(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}					
				}
			}
			if (ssmsggoodscategory.equals("3")){
				
				for (int j = 0; j < propertyArray.length; j++){
					
					if (propertyArray[j].indexOf(";") < 0){
						continue;
					}
					
					if (propertyArray[j].split(";")[0].equals("5")){ //球镜
						entryPo.setSsmsgsphul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgsphup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("6")){ //柱镜
						entryPo.setSsmsgcylul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgcylup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("1")){ //材料分类
						entryPo.setSsmsgclfl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("2")){ //折射率
						entryPo.setSsmsgzsl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("3")){ //光度分类
						entryPo.setSsmsggdfl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("4")){ //功能分类
						entryPo.setSsmsggndl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
				}
				
			}
			if (ssmsggoodscategory.equals("4")){
				
				for (int j = 0; j < propertyArray.length; j++){
					
					if (propertyArray[j].indexOf(";") < 0){
						continue;
					}
					
					if (propertyArray[j].split(";")[0].equals("5")){ //球镜
						entryPo.setSsmsgsphul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgsphup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("6")){ //柱镜
						entryPo.setSsmsgcylul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgcylup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("1")){ //使用类型
						entryPo.setSsmsgsylx(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("2")){ //抛弃周期
						entryPo.setSsmsgpqlx(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
				}

			}
			if (ssmsggoodscategory.equals("6")){
				
				for (int j = 0; j < propertyArray.length; j++){
					if (propertyArray[j].indexOf(";") > 0 && propertyArray[j].split(";").length > 1){
						entryPo.setSsmsgtyjgn(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}	
				}
			}
			
			salesGoodsArrayList.add(entryPo);
		}
		
		int count1 = 0;
		if (creditGoodsArray != null){
			count1 = creditGoodsArray.getSsmsggoodscategory().length;
		}
		for (int i = 0; i < count1; i++){
			SetMealEntryPo entryPo = new SetMealEntryPo();
			String ssmsggoodscategory = goodscategoryID[i+count];
			String[] tmp = null;
			if (ssmsggoodscategory.indexOf("_") > 0){
				tmp = ssmsggoodscategory.split("_");
				ssmsggoodscategory = tmp[0];
			}else{
				tmp = new String[2];
				tmp[0] = ssmsggoodscategory;
				tmp[1] = "";
			}
			
			if (tmp[0].equals("6")){
				ssmsggoodscategory = tmp[1];
			}else{
				ssmsggoodscategory = tmp[0];
			}			

			entryPo.setSsmsgsetmealid(Utility.getName(setMealPo.getSsmsmid()));
			entryPo.setSsmsggoodscategory(ssmsggoodscategory);
			if (tmp[0].equals("3") || tmp[0].equals("4")){
				entryPo.setSsmsgiscustomize(Utility.getName(tmp[1]));
			}else{
				entryPo.setSsmsgiscustomize("");				
			}
			entryPo.setSsmsgbrand(Utility.getName(creditGoodsArray.getSsmsgbrand()[i]));
			entryPo.setSsmsgsupplier(Utility.getName(creditGoodsArray.getSsmsgsupplier()[i]));
			entryPo.setSsmsggoodsid(Utility.getName(creditGoodsArray.getSsmsggoodsid()[i]));
			entryPo.setSsmsggoodsname(Utility.getName(creditGoodsArray.getSsmsggoodsname()[i]));
			entryPo.setSsmsgoodsclass(Utility.getName(creditGoodsArray.getSsmsgoodsclass()[i]).equals("") ? "1" : Utility.getName(creditGoodsArray.getSsmsgoodsclass()[i]));
			entryPo.setSsmsgmincostPrice(Utility.getName(creditGoodsArray.getSsmsgmincostPrice()[i]));
			entryPo.setSsmsgmaxcostPrice(Utility.getName(creditGoodsArray.getSsmsgmaxcostPrice()[i]));
			entryPo.setSsmsggoodsquantity(Utility.getName(creditGoodsArray.getSsmsggoodsquantity()[i]));
			
			if (Utility.getName(setMealPo.getSsmsmdetailform()).equals("11") || Utility.getName(setMealPo.getSsmsmdetailform()).equals("12") || Utility.getName(setMealPo.getSsmsmdetailform()).equals("21")){
				entryPo.setSsmsgfavorableflag(Utility.getName(creditGoodsArray.getSsmsgfavorableflag()[i]));
				entryPo.setSsmsgdiscountrate(Utility.getName(creditGoodsArray.getSsmsgdiscountrate()[i]));			
				entryPo.setSsmsgspecialoffer(Utility.getName(creditGoodsArray.getSsmsgspecialoffer()[i]));
				entryPo.setSsmsgexpensecredit(Utility.getName(creditGoodsArray.getSsmsgexpensecredit()[i]));
				entryPo.setSsmsgretailPrice(Utility.getName(creditGoodsArray.getSsmsgretailPrice()[i]));
			}			

			entryPo.setSsmsgflag("2");
			entryPo.setSsmsgbeginAmount(Utility.getName(creditGoodsArray.getSsmsgbeginAmount()[i]));
			entryPo.setSsmsgendAmount(Utility.getName(creditGoodsArray.getSsmsgendAmount()[i]));			
			entryPo.setSsmsgsmallclass(Utility.getName(creditGoodsArray.getSsmsgoodspropertyarray()[i]));
			entryPo.setSsmsgbigclass(Utility.getName(creditGoodsArray.getSsmspropertyvaluearray()[i]));
						
			if (Utility.getName(entryPo.getSsmsgbigclass()).indexOf(",") > 0){
				propertyArray = Utility.getName(entryPo.getSsmsgbigclass()).split(",");
			}else{
				propertyArray = new String[1];
				propertyArray[0] = Utility.getName(entryPo.getSsmsgbigclass());
			}
			
			if (ssmsggoodscategory.equals("1")){	
				
				for (int j = 0; j < propertyArray.length; j++){
					if (propertyArray[j].indexOf(";") > 0 && propertyArray[j].split(";").length > 1){
						entryPo.setSsmsgjjcz(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}					
				}
			}
			if (ssmsggoodscategory.equals("3")){
				
				for (int j = 0; j < propertyArray.length; j++){
					
					if (propertyArray[j].indexOf(";") < 0){
						continue;
					}
					
					if (propertyArray[j].split(";")[0].equals("5")){ //球镜
						entryPo.setSsmsgsphul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgsphup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("6")){ //柱镜
						entryPo.setSsmsgcylul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgcylup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("1")){ //材料分类
						entryPo.setSsmsgclfl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("2")){ //折射率
						entryPo.setSsmsgzsl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("3")){ //光度分类
						entryPo.setSsmsggdfl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("4")){ //功能分类
						entryPo.setSsmsggndl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
				}
				
			}
			if (ssmsggoodscategory.equals("4")){
				
				for (int j = 0; j < propertyArray.length; j++){
					
					if (propertyArray[j].indexOf(";") < 0){
						continue;
					}
					
					if (propertyArray[j].split(";")[0].equals("5")){ //球镜
						entryPo.setSsmsgsphul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgsphup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("6")){ //柱镜
						entryPo.setSsmsgcylul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgcylup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("1")){ //使用类型
						entryPo.setSsmsgsylx(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("2")){ //抛弃周期
						entryPo.setSsmsgpqlx(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
				}

			}
			
			if (ssmsggoodscategory.equals("6")){
				
				for (int j = 0; j < propertyArray.length; j++){
					if (propertyArray[j].indexOf(";") > 0 && propertyArray[j].split(";").length > 1){
						entryPo.setSsmsgtyjgn(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}	
				}
			}
			
			salesGoodsArrayList.add(entryPo);
		}
		
		setMealMgr.insertSetMeal(setMealPo,salesGoodsArrayList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));		
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 初始化套餐更新
	 * @return
	 * @throws Exception
	 */
	public String initSetMealUpdate() throws Exception {
		
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
		
		SetMealPo po = new SetMealPo();
		po.setSsmsmid(Utility.getName(request.getParameter("hid")));
		
		setMealPo = setMealMgr.getSetMealDetail(po);
		salesGoodsArrayList = setMealMgr.getSetMealEntryDetail(po);
		
        departmentList = departmentsMgr.getDepartments("1","0");
        StringBuffer allDepartmentID = new StringBuffer();
        StringBuffer allDepartmentName = new StringBuffer();
		for (int i = 0; i < departmentList.size(); i++){
			allDepartmentID.append(Utility.getName(departmentList.get(i).getBdpdepartmentid())+",");
			allDepartmentName.append(Utility.getName(departmentList.get(i).getBdpdepartmentname())+",");
		}
		if (departmentList.size() > 0){
		    request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
		    request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));
		}
		
		refractiveSetList = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList(); 
		
		if (Utility.getName(setMealPo.getSsmsmdetailform()).equals("11")){
			return "success22";
		}
		if (Utility.getName(setMealPo.getSsmsmdetailform()).equals("12")){
			return "success3";
		}
		if (Utility.getName(setMealPo.getSsmsmdetailform()).equals("21")){
			return "success4";
		}
		
		return "success5";
		
	}
	
	/**
	 * 初始化套餐更新
	 * @return
	 * @throws Exception
	 */
	public String initSetMealDepartmentsUpdate() throws Exception {
		
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
		
		SetMealPo po = new SetMealPo();
		po.setSsmsmid(Utility.getName(request.getParameter("hid")));
		
		setMealPo = setMealMgr.getSetMealDetail(po);
		salesGoodsArrayList = setMealMgr.getSetMealEntryDetail(po);
		
        departmentList = departmentsMgr.getDepartments("1","0");
        StringBuffer allDepartmentID = new StringBuffer();
        StringBuffer allDepartmentName = new StringBuffer();
		for (int i = 0; i < departmentList.size(); i++){
			allDepartmentID.append(Utility.getName(departmentList.get(i).getBdpdepartmentid())+",");
			allDepartmentName.append(Utility.getName(departmentList.get(i).getBdpdepartmentname())+",");
		}
		if (departmentList.size() > 0){
		    request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
		    request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));
		}
		
		return SUCCESS;
	}
	
	/**
	 * 套餐更新
	 * @return
	 * @throws Exception
	 */
	public String updateSetMeal() throws Exception {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("套餐：" + Utility.getName(setMealPo.getSsmsmtitle()) +"修改!");
		
		if (!"".equals(Utility.getName(setMealPo.getSsmsmauditstate()))){
			setMealPo.setSsmsmauditstate("1");
			setMealPo.setSsmsmauditperson(createPerson);
		}else{
			setMealPo.setSsmsmauditstate("0");
			setMealPo.setSsmsmauditperson("");
		}
		
		String[] goodscategoryID = request.getParameterValues("goodscategoryID");

		salesGoodsArrayList = new ArrayList<SetMealEntryPo>();
		String[] propertyArray = null;
		int count = 0;
		if (salesGoodsArray != null){
			count = salesGoodsArray.getSsmsggoodscategory().length;
		}
		for (int i = 0; i < count; i++){
			SetMealEntryPo entryPo = new SetMealEntryPo();
			String ssmsggoodscategory = goodscategoryID[i];
			String[] tmp = null;
			if (ssmsggoodscategory.indexOf("_") > 0){
				tmp = ssmsggoodscategory.split("_");
				ssmsggoodscategory = tmp[0];
			}else{
				tmp = new String[2];
				tmp[0] = ssmsggoodscategory;
				tmp[1] = "";
			}
			
			if (tmp[0].equals("6")){
				ssmsggoodscategory = tmp[1];
			}else{
				ssmsggoodscategory = tmp[0];
			}			
			
			entryPo.setSsmsgsetmealid(Utility.getName(setMealPo.getSsmsmid()));
			entryPo.setSsmsggoodscategory(ssmsggoodscategory);
			if (tmp[0].equals("3") || tmp[0].equals("4")){
				entryPo.setSsmsgiscustomize(Utility.getName(tmp[1]));
			}else{
				entryPo.setSsmsgiscustomize("");
			}
			entryPo.setSsmsgbrand(Utility.getName(salesGoodsArray.getSsmsgbrand()[i]));
			entryPo.setSsmsgsupplier(Utility.getName(salesGoodsArray.getSsmsgsupplier()[i]));
			entryPo.setSsmsggoodsid(Utility.getName(salesGoodsArray.getSsmsggoodsid()[i]));
			entryPo.setSsmsggoodsname(Utility.getName(salesGoodsArray.getSsmsggoodsname()[i]));
			entryPo.setSsmsgoodsclass(Utility.getName(salesGoodsArray.getSsmsgoodsclass()[i]).equals("") ? "1" : Utility.getName(salesGoodsArray.getSsmsgoodsclass()[i]));
			entryPo.setSsmsgmincostPrice(Utility.getName(salesGoodsArray.getSsmsgmincostPrice()[i]));
			entryPo.setSsmsgmaxcostPrice(Utility.getName(salesGoodsArray.getSsmsgmaxcostPrice()[i]));
			entryPo.setSsmsggoodsquantity(Utility.getName(salesGoodsArray.getSsmsggoodsquantity()[i]));			
			entryPo.setSsmsgexpensespendup(Utility.getName(salesGoodsArray.getSsmsgexpensespendup()[i]));
			entryPo.setSsmsgexpensespendul(Utility.getName(salesGoodsArray.getSsmsgexpensespendul()[i]));
			
			if (Utility.getName(setMealPo.getSsmsmdetailform()).equals("11") || Utility.getName(setMealPo.getSsmsmdetailform()).equals("12") || Utility.getName(setMealPo.getSsmsmdetailform()).equals("21")){
				entryPo.setSsmsgfavorableflag(Utility.getName(salesGoodsArray.getSsmsgfavorableflag()[i]));
				entryPo.setSsmsgdiscountrate(Utility.getName(salesGoodsArray.getSsmsgdiscountrate()[i]));			
				entryPo.setSsmsgspecialoffer(Utility.getName(salesGoodsArray.getSsmsgspecialoffer()[i]));
				entryPo.setSsmsgexpensecredit(Utility.getName(salesGoodsArray.getSsmsgexpensecredit()[i]));
				entryPo.setSsmsgretailPrice(Utility.getName(salesGoodsArray.getSsmsgretailPrice()[i]));	
			}else{
				entryPo.setSsmsgfavorableflag("1");
			}
			
			entryPo.setSsmsgflag("1");
			entryPo.setSsmsgbeginAmount(Utility.getName(salesGoodsArray.getSsmsgbeginAmount()[i]));
			entryPo.setSsmsgendAmount(Utility.getName(salesGoodsArray.getSsmsgendAmount()[i]));
			entryPo.setSsmsgsmallclass(Utility.getName(salesGoodsArray.getSsmsgoodspropertyarray()[i]));
			entryPo.setSsmsgbigclass(Utility.getName(salesGoodsArray.getSsmspropertyvaluearray()[i]));
						
			if (Utility.getName(entryPo.getSsmsgbigclass()).indexOf(",") > 0){
				propertyArray = Utility.getName(entryPo.getSsmsgbigclass()).split(",");
			}else{
				propertyArray = new String[1];
				propertyArray[0] = Utility.getName(entryPo.getSsmsgbigclass());
			}
			
			if (ssmsggoodscategory.equals("1")){	
				
				for (int j = 0; j < propertyArray.length; j++){
					if (propertyArray[j].indexOf(";") > 0 && propertyArray[j].split(";").length > 1){
						entryPo.setSsmsgjjcz(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}					
				}
			}
			if (ssmsggoodscategory.equals("3")){
				
				for (int j = 0; j < propertyArray.length; j++){
					
					if (propertyArray[j].indexOf(";") < 0){
						continue;
					}
					
					if (propertyArray[j].split(";")[0].equals("5")){ //球镜
						entryPo.setSsmsgsphul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgsphup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("6")){ //柱镜
						entryPo.setSsmsgcylul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgcylup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("1")){ //材料分类
						entryPo.setSsmsgclfl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("2")){ //折射率
						entryPo.setSsmsgzsl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("3")){ //光度分类
						entryPo.setSsmsggdfl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("4")){ //功能分类
						entryPo.setSsmsggndl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
				}
				
			}
			if (ssmsggoodscategory.equals("4")){
				
				for (int j = 0; j < propertyArray.length; j++){
					
					if (propertyArray[j].indexOf(";") < 0){
						continue;
					}
					
					if (propertyArray[j].split(";")[0].equals("5")){ //球镜
						entryPo.setSsmsgsphul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgsphup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("6")){ //柱镜
						entryPo.setSsmsgcylul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgcylup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("1")){ //使用类型
						entryPo.setSsmsgsylx(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("2")){ //抛弃周期
						entryPo.setSsmsgpqlx(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
				}

			}
			if (ssmsggoodscategory.equals("6")){
				
				for (int j = 0; j < propertyArray.length; j++){
					if (propertyArray[j].indexOf(";") > 0 && propertyArray[j].split(";").length > 1){
						entryPo.setSsmsgtyjgn(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}	
				}
			}
			
			salesGoodsArrayList.add(entryPo);
		}
		
		int count1 = 0;
		if (creditGoodsArray != null){
			count1 = creditGoodsArray.getSsmsggoodscategory().length;
		}
		for (int i = 0; i < count1; i++){
			SetMealEntryPo entryPo = new SetMealEntryPo();
			String ssmsggoodscategory = goodscategoryID[i+count];
			String[] tmp = null;
			if (ssmsggoodscategory.indexOf("_") > 0){
				tmp = ssmsggoodscategory.split("_");
				ssmsggoodscategory = tmp[0];
			}else{
				tmp = new String[2];
				tmp[0] = ssmsggoodscategory;
				tmp[1] = "";
			}
			
			if (tmp[0].equals("6")){
				ssmsggoodscategory = tmp[1];
			}else{
				ssmsggoodscategory = tmp[0];
			}			

			entryPo.setSsmsgsetmealid(Utility.getName(setMealPo.getSsmsmid()));
			entryPo.setSsmsggoodscategory(ssmsggoodscategory);
			if (tmp[0].equals("3") || tmp[0].equals("4")){
				entryPo.setSsmsgiscustomize(Utility.getName(tmp[1]));
			}else{
				entryPo.setSsmsgiscustomize("");				
			}
			entryPo.setSsmsgbrand(Utility.getName(creditGoodsArray.getSsmsgbrand()[i]));
			entryPo.setSsmsgsupplier(Utility.getName(creditGoodsArray.getSsmsgsupplier()[i]));
			entryPo.setSsmsggoodsid(Utility.getName(creditGoodsArray.getSsmsggoodsid()[i]));
			entryPo.setSsmsggoodsname(Utility.getName(creditGoodsArray.getSsmsggoodsname()[i]));
			entryPo.setSsmsgoodsclass(Utility.getName(creditGoodsArray.getSsmsgoodsclass()[i]).equals("") ? "1" : Utility.getName(creditGoodsArray.getSsmsgoodsclass()[i]));
			entryPo.setSsmsgmincostPrice(Utility.getName(creditGoodsArray.getSsmsgmincostPrice()[i]));
			entryPo.setSsmsgmaxcostPrice(Utility.getName(creditGoodsArray.getSsmsgmaxcostPrice()[i]));
			entryPo.setSsmsggoodsquantity(Utility.getName(creditGoodsArray.getSsmsggoodsquantity()[i]));
			
			if (Utility.getName(setMealPo.getSsmsmdetailform()).equals("11") || Utility.getName(setMealPo.getSsmsmdetailform()).equals("12") || Utility.getName(setMealPo.getSsmsmdetailform()).equals("21")){
				entryPo.setSsmsgfavorableflag(Utility.getName(creditGoodsArray.getSsmsgfavorableflag()[i]));
				entryPo.setSsmsgdiscountrate(Utility.getName(creditGoodsArray.getSsmsgdiscountrate()[i]));			
				entryPo.setSsmsgspecialoffer(Utility.getName(creditGoodsArray.getSsmsgspecialoffer()[i]));
				entryPo.setSsmsgexpensecredit(Utility.getName(creditGoodsArray.getSsmsgexpensecredit()[i]));
				entryPo.setSsmsgretailPrice(Utility.getName(creditGoodsArray.getSsmsgretailPrice()[i]));
			}			

			entryPo.setSsmsgflag("2");
			entryPo.setSsmsgbeginAmount(Utility.getName(creditGoodsArray.getSsmsgbeginAmount()[i]));
			entryPo.setSsmsgendAmount(Utility.getName(creditGoodsArray.getSsmsgendAmount()[i]));			
			entryPo.setSsmsgsmallclass(Utility.getName(creditGoodsArray.getSsmsgoodspropertyarray()[i]));
			entryPo.setSsmsgbigclass(Utility.getName(creditGoodsArray.getSsmspropertyvaluearray()[i]));
						
			if (Utility.getName(entryPo.getSsmsgbigclass()).indexOf(",") > 0){
				propertyArray = Utility.getName(entryPo.getSsmsgbigclass()).split(",");
			}else{
				propertyArray = new String[1];
				propertyArray[0] = Utility.getName(entryPo.getSsmsgbigclass());
			}
			
			if (ssmsggoodscategory.equals("1")){	
				
				for (int j = 0; j < propertyArray.length; j++){
					if (propertyArray[j].indexOf(";") > 0 && propertyArray[j].split(";").length > 1){
						entryPo.setSsmsgjjcz(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}					
				}
			}
			if (ssmsggoodscategory.equals("3")){
				
				for (int j = 0; j < propertyArray.length; j++){
					
					if (propertyArray[j].indexOf(";") < 0){
						continue;
					}
					
					if (propertyArray[j].split(";")[0].equals("5")){ //球镜
						entryPo.setSsmsgsphul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgsphup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("6")){ //柱镜
						entryPo.setSsmsgcylul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgcylup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("1")){ //材料分类
						entryPo.setSsmsgclfl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("2")){ //折射率
						entryPo.setSsmsgzsl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("3")){ //光度分类
						entryPo.setSsmsggdfl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("4")){ //功能分类
						entryPo.setSsmsggndl(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
				}
				
			}
			if (ssmsggoodscategory.equals("4")){
				
				for (int j = 0; j < propertyArray.length; j++){
					
					if (propertyArray[j].indexOf(";") < 0){
						continue;
					}
					
					if (propertyArray[j].split(";")[0].equals("5")){ //球镜
						entryPo.setSsmsgsphul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgsphup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("6")){ //柱镜
						entryPo.setSsmsgcylul(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[0] : "" ) : "");
						entryPo.setSsmsgcylup(propertyArray[j].split(";").length > 1 ? (propertyArray[j].split(";")[1].split(":").length > 1 ? propertyArray[j].split(";")[1].split(":")[1] : "" ) : "");
					}
					if (propertyArray[j].split(";")[0].equals("1")){ //使用类型
						entryPo.setSsmsgsylx(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
					if (propertyArray[j].split(";")[0].equals("2")){ //抛弃周期
						entryPo.setSsmsgpqlx(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}
				}

			}
			
			if (ssmsggoodscategory.equals("6")){
				
				for (int j = 0; j < propertyArray.length; j++){
					if (propertyArray[j].indexOf(";") > 0 && propertyArray[j].split(";").length > 1){
						entryPo.setSsmsgtyjgn(propertyArray[j].split(";").length > 1 ? propertyArray[j].split(";")[1] : "");
					}	
				}
			}
			
			salesGoodsArrayList.add(entryPo);
		}
		
		setMealMgr.updateSetMeal(setMealPo, salesGoodsArrayList, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	
	/**
	 * 初始化套餐删除
	 * @return
	 * @throws Exception
	 */
	public String initSetMealDelete() throws Exception {
		
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
		
		SetMealPo po = new SetMealPo();
		po.setSsmsmid(Utility.getName(request.getParameter("hid")));
		
		setMealPo = setMealMgr.getSetMealDetail(po);
		
		return SUCCESS;
	}
	
	
	/**
	 * 删除套餐
	 * @return
	 * @throws Exception
	 */
	public String deleteSetMeal() throws Exception {
		
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("套餐：" + Utility.getName(setMealPo.getSsmsmtitle()) + "删除!");
		
		setMealMgr.deleteSetMeal(setMealPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	
	/**
	 * 套餐详细信息
	 * @return
	 * @throws Exception
	 */
	public String initSetmealDetail()throws Exception {
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
		
		SetMealPo po = new SetMealPo();
		po.setSsmsmid(Utility.getName(request.getParameter("hid")));
		
		setMealPo = setMealMgr.getSetMealDetail(po);
		salesGoodsArrayList = setMealMgr.getSetMealEntryDetail(po);
		
		for (int i = 0; i < salesGoodsArrayList.size(); i++){
			SetMealEntryPo epo = salesGoodsArrayList.get(i);
			if (epo.getSsmsggoodscategory().equals("1")){
				FrameMaterialPo tpo = new FrameMaterialPo();
				tpo.setBfmid(epo.getSsmsgsmallclass());			
				tpo = frameMaterialMgr.getFrameMaterialPo(tpo);
				
				epo.setSsmsgsmallclassname(tpo.getBfmname());
			}
		}		
		
		List<DepartmentsPo> departmentList2 = departmentsMgr.getDepartments("1","0");  // 1：门店  2：加工   3：配送
		departmentList2 = getSalesDepartmentList(departmentList2,setMealPo.getSsmsmshopcode());
		
		departmentList = new ArrayList<DepartmentsPo>();
		for (int i = 0; i < departmentList2.size(); i++){
			if (departmentList2.get(i).getBdpwizardflag().equals("1")){
				departmentList.add(departmentList2.get(i));
			}
		}
		
		BigDecimal departmentCount = new BigDecimal(departmentList.size());
		departmentCount = departmentCount.divide(new BigDecimal(6),1);		
		double rowCount = departmentCount.doubleValue() + 1;
		request.setAttribute("rowCount",Math.round(rowCount));
		
		return SUCCESS;
	}

	/**
	 * 初始化商品查询
	 * @return
	 * @throws Exception
	 */
	public String initSetMealGoodsOpenSel() throws Exception {
		
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

		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String pertyvaluearray = Utility.getName(request.getParameter("pertyvaluearray"));
		String goodsflag = Utility.getName(request.getParameter("goodsflag"));
		String salestype = Utility.getName(request.getParameter("salestype"));
		
		request.setAttribute("goodscategoryID",goodscategoryID);
		request.setAttribute("pertyvaluearray",pertyvaluearray);
		request.setAttribute("goodsflag",goodsflag);
		request.setAttribute("salestype",salestype);
		
		String[] propertyArray = null;
		String jjcz = "";
		String sphul = "";
		String sphup = "";
		String cylul = "";
		String cylup = "";
		String clfl = "";
		String zsl = "";
		String gdfl = "";
		String gndl = "";
		String sylx = "";
		String pqlx = "";
		String tyjgn = "";
		
		if (pertyvaluearray.indexOf(",") > 0){
			propertyArray = pertyvaluearray.split(",");
		}else{
			propertyArray = new String[1];
			propertyArray[0] = pertyvaluearray;
		}
		
		if (goodscategoryID.startsWith("1")){	
			
			for (int j = 0; j < propertyArray.length; j++){
				if (propertyArray[j].indexOf(";") > 0 && propertyArray[j].split(";").length > 1){
					jjcz = propertyArray[j].split(";")[1];
				}					
			}
		}
		if (goodscategoryID.startsWith("3")){
			
			for (int j = 0; j < propertyArray.length; j++){
				
				if (propertyArray[j].indexOf(";") < 0){
					continue;
				}
				
				if (propertyArray[j].split(";")[0].equals("5")){ //球镜
					sphul = propertyArray[j].split(";")[1].split(":")[0];
					sphup = propertyArray[j].split(";")[1].split(":")[1];
				}
				if (propertyArray[j].split(";")[0].equals("6")){ //柱镜
					cylul = propertyArray[j].split(";")[1].split(":")[0];
					cylup = propertyArray[j].split(";")[1].split(":")[1];
				}
				if (propertyArray[j].split(";")[0].equals("1")){ //材料分类
					clfl = propertyArray[j].split(";")[1];
				}
				if (propertyArray[j].split(";")[0].equals("2")){ //折射率
					zsl = propertyArray[j].split(";")[1];
				}
				if (propertyArray[j].split(";")[0].equals("3")){ //光度分类
					gdfl = propertyArray[j].split(";")[1];
				}
				if (propertyArray[j].split(";")[0].equals("4")){ //功能分类
					gndl = propertyArray[j].split(";")[1];
				}
			}
			
		}
		if (goodscategoryID.startsWith("4")){
			
			for (int j = 0; j < propertyArray.length; j++){
				if (propertyArray[j].split(";")[0].equals("5")){ //球镜
					sphul = propertyArray[j].split(";")[1].split(":")[0];
					sphup = propertyArray[j].split(";")[1].split(":")[1];
				}
				if (propertyArray[j].split(";")[0].equals("6")){ //柱镜
					cylul = propertyArray[j].split(";")[1].split(":")[0];
					cylup = propertyArray[j].split(";")[1].split(":")[1];
				}
				if (propertyArray[j].split(";")[0].equals("1")){ //使用类型
					sylx = propertyArray[j].split(";")[1];
				}
				if (propertyArray[j].split(";")[0].equals("2")){ //抛弃周期
					pqlx = propertyArray[j].split(";")[1];
				}
			}

		}
		if (goodscategoryID.equals("6_6")){
			
			for (int j = 0; j < propertyArray.length; j++){
				if (propertyArray[j].indexOf(";") > 0 && propertyArray[j].split(";").length > 1){
					tyjgn = propertyArray[j].split(";")[1];
				}	
			}
		}
		
		request.setAttribute("jjcz",jjcz);
		request.setAttribute("sphul",sphul);
		request.setAttribute("sphup",sphup);
		request.setAttribute("cylul",cylul);
		request.setAttribute("cylup",cylup);
		request.setAttribute("clfl",clfl);
		request.setAttribute("zsl",zsl);
		request.setAttribute("gdfl",gdfl);
		request.setAttribute("gndl",gndl);
		request.setAttribute("sylx",sylx);
		request.setAttribute("pqlx",pqlx);
		request.setAttribute("tyjgn",tyjgn);
		
		return SUCCESS;
	}
	
	/**
	 * 商品查询
	 * @return
	 * @throws Exception
	 */
	public String selSetMealGoodsOpen() throws Exception {
		
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
		String goodsBar = Utility.getName(request.getParameter("goodsBar"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String queryType = Utility.getName(request.getParameter("queryType"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String bgiretailbeginprice = Utility.getName(request.getParameter("retailbeginprice"));
		String bgiretailendprice = Utility.getName(request.getParameter("retailendprice"));	
		String goodsflag = Utility.getName(request.getParameter("goodsflag"));	
		String salestype = Utility.getName(request.getParameter("salestype"));
		
		String jjcz = Utility.getName(request.getParameter("jjcz"));
		String sphul = Utility.getName(request.getParameter("sphul"));
		String sphup = Utility.getName(request.getParameter("sphup"));
		String cylul = Utility.getName(request.getParameter("cylul"));
		String cylup = Utility.getName(request.getParameter("cylup"));
		String clfl = Utility.getName(request.getParameter("clfl"));		
		String zsl = Utility.getName(request.getParameter("zsl"));
		String gdfl = Utility.getName(request.getParameter("gdfl"));		
		String gndl = Utility.getName(request.getParameter("gndl"));
		String sylx = Utility.getName(request.getParameter("sylx"));
		String pqlx = Utility.getName(request.getParameter("pqlx"));
		String tyjgn = Utility.getName(request.getParameter("tyjgn"));
		
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsBar",goodsBar);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("queryType",queryType);
		request.setAttribute("goodscategoryID",goodscategoryID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("retailbeginprice",bgiretailbeginprice);
		request.setAttribute("retailendprice",bgiretailendprice);
		request.setAttribute("jjcz",jjcz);
		request.setAttribute("sphul",sphul);
		request.setAttribute("sphup",sphup);
		request.setAttribute("cylul",cylul);
		request.setAttribute("cylup",cylup);
		request.setAttribute("clfl",clfl);
		request.setAttribute("zsl",zsl);
		request.setAttribute("gdfl",gdfl);
		request.setAttribute("gndl",gndl);
		request.setAttribute("sylx",sylx);
		request.setAttribute("pqlx",pqlx);
		request.setAttribute("tyjgn",tyjgn);
		request.setAttribute("goodsflag",goodsflag);
		request.setAttribute("salestype",salestype);
		
		String[] goodscategorys = null;
		if (goodscategoryID.indexOf("_") > 0){
			goodscategorys = goodscategoryID.split("_");
		}else{
			goodscategorys = new String[2];
			goodscategorys[0] = goodscategoryID;
			goodscategorys[1] = "";
		}
		
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setQueryType(queryType);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);	
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		if(!"".equals(Utility.getName(goodsBar))){
			if(goodsBar.length()<=18){
				goodsInfoPo.setBgigoodsbarcode(goodsBar);	
			}else{
				goodsInfoPo.setBgigoodsbarcode(goodsBar.substring(0, 18));
			}
		}else{
			goodsInfoPo.setBgigoodsbarcode(goodsBar);	
		}
				
		if (goodscategorys[0].equals("2")){
			goodsInfoPo.setBgigoodscategoryid(goodscategorys[0]);
			goodsInfoPo.setBgiaccessoriestype(goodscategorys[1]);
		}
		if (goodscategorys[0].equals("3")){
			goodsInfoPo.setBgigoodscategoryid(goodscategorys[0]);
			goodsInfoPo.setBgiiscustomize(goodscategorys[1]);			
			
			goodsInfoPo.setBgieyeglassmaterialtype(clfl);
			goodsInfoPo.setBgirefractive(zsl);
			goodsInfoPo.setBgifunctionclass(gndl);
			
			if (gdfl.indexOf("_") > 0){
				goodsInfoPo.setBbdluminosityclass(gdfl.split("_")[0]);
				goodsInfoPo.setBgigradualclass(gdfl.split("_")[1]);  // 青少年渐进    老年渐进
			}else{
				goodsInfoPo.setBbdluminosityclass(gdfl);
			}

			goodsInfoPo.setBgisphul(sphul);// 球镜上限
			goodsInfoPo.setBgisphup(sphup);// 球镜下限			
			goodsInfoPo.setBgicylul(cylul);// 柱镜上限
			goodsInfoPo.setBgicylup(cylup);// 柱镜下限
		}
		if (goodscategorys[0].equals("4")){
			goodsInfoPo.setBgigoodscategoryid(goodscategorys[0]);
			goodsInfoPo.setBgiiscustomize(goodscategorys[1]);
			
			goodsInfoPo.setBgiusetype(sylx);
			goodsInfoPo.setBgistealthclass(pqlx);
			
			goodsInfoPo.setBgisphul(sphul);// 球镜上限
			goodsInfoPo.setBgisphup(sphup);// 球镜下限			
			goodsInfoPo.setBgicylul(cylul);// 柱镜上限
			goodsInfoPo.setBgicylup(cylup);// 柱镜下限
		}
		if (goodscategorys[0].equals("6")){
			goodsInfoPo.setBgigoodscategoryid(goodscategorys[1]);
			goodsInfoPo.setBgisunglassesfuntion(tyjgn);
		}
		if (goodscategorys[0].equals("1")){
			goodsInfoPo.setBgigoodscategoryid(goodscategorys[0]);
			goodsInfoPo.setBgiframematerialtype(jjcz);
		}
		if (goodscategorys[0].equals("5") || goodscategorys[0].equals("7") || goodscategorys[0].equals("8") || goodscategorys[0].equals("9")){
			goodsInfoPo.setBgigoodscategoryid(goodscategorys[0]);
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		int count = setMealMgr.getGoodsCount(goodsInfoPo);
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
			goodsList = setMealMgr.getGoodsList(goodsInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		
		return SUCCESS;
	}
	
	private String getSalesDepartments(String[] departmentsID) {

		String goodsCategory = "";
		if (departmentsID != null){
			for (int i = 0; i < departmentsID.length; i++) {

				if ("".equals(goodsCategory)) {
					goodsCategory = departmentsID[i];
				} else {
					goodsCategory = goodsCategory + "," + departmentsID[i];
				}
			}	
		}
		
		return goodsCategory;
	}
	
	private List<DepartmentsPo> getSalesDepartmentList(List<DepartmentsPo> list,String goodsCategoryID) {
		List<DepartmentsPo> glist = new ArrayList<DepartmentsPo>();
		Iterator<DepartmentsPo> it = list.iterator();
		while (it.hasNext()) {
			DepartmentsPo po = (DepartmentsPo) it.next();
			String[] departments = goodsCategoryID.split(",");
			for (int i = 0; i < departments.length; i++) {
				if (po.getBdpdepartmentid().equals(departments[i])) {
					po.setBdpwizardflag("1");
					break;
				} else {
					po.setBdpwizardflag("0");
				}
			}
			glist.add(po);
		}
		return glist;
	}
	
	/***************************************************************************************************************************/
	
	/**
	 * 初始化积分累计规则
	 * @return
	 * @throws Exception
	 */
	public String initIntegralSetSel() throws Exception {
		
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
		
        departmentList = departmentsMgr.getDepartments("1","0");
        StringBuffer allDepartmentID = new StringBuffer();
        StringBuffer allDepartmentName = new StringBuffer();
		for (int i = 0; i < departmentList.size(); i++){
			allDepartmentID.append(Utility.getName(departmentList.get(i).getBdpdepartmentid())+",");
			allDepartmentName.append(Utility.getName(departmentList.get(i).getBdpdepartmentname())+",");
		}
		if (departmentList.size() > 0){
		    request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
		    request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));
		}
		
		memberManagementlist=memberManagementMgr.getMemberManagementList();

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "integralSetSel";
		}
		
		
		return SUCCESS;
	}
	
	/**
	 * 积分累计规则查询
	 * @return
	 * @throws Exception
	 */
	public String integralSetSel() throws Exception {
		
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
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String ds = Utility.getName(request.getParameter("ds"));
		String bdpdepartmentname = Utility.getName(request.getParameter("bdpdepartmentname"));
		String membertype= Utility.getName(request.getParameter("membertype"));
		String membertypename= Utility.getName(request.getParameter("membertypename"));
		String memberds= Utility.getName(request.getParameter("memberds"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("bdpdepartmentname",bdpdepartmentname);
		request.setAttribute("ds",ds);
		request.setAttribute("membertype",membertype);
		request.setAttribute("membertypename",membertypename);
		request.setAttribute("memberds",memberds);
		
		integralPo = new IntegralPo();
		if (goodsCategoryID.startsWith("3") || goodsCategoryID.startsWith("4")){
			integralPo.setFirIscustomize(goodsCategoryID.split("-")[1]);
			integralPo.setFirGoodsCategoryID(goodsCategoryID.split("-")[0]);				
		}else{
			integralPo.setFirGoodsCategoryID(goodsCategoryID);
		}
		
		integralPo.setFirSupplierID(supplierID);
		integralPo.setFirBrandID(brandID);
		integralPo.setFirGoodsID(goodsID);
		integralPo.setFirGoodsName(goodsName);
		integralPo.setFirdepartmentid(departmentID);
		integralPo.setFirmembertype(membertype);
		
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
		
		int count = setMealMgr.getIntegralSetCount(integralPo);
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
			integralList = setMealMgr.getIntegralSetList(integralPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			integralList = null;
		}
        departmentList = departmentsMgr.getDepartments("1","0");
        StringBuffer allDepartmentID = new StringBuffer();
        StringBuffer allDepartmentName = new StringBuffer();
		for (int i = 0; i < departmentList.size(); i++){
			allDepartmentID.append(Utility.getName(departmentList.get(i).getBdpdepartmentid())+",");
			allDepartmentName.append(Utility.getName(departmentList.get(i).getBdpdepartmentname())+",");
		}
		if (departmentList.size() > 0){
		    request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
		    request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));
		}
		
		memberManagementlist=memberManagementMgr.getMemberManagementList();
	
		return SUCCESS;
	}
	
	/**
	 * 初始化积分累计规则新增
	 * @return
	 * @throws Exception
	 */
	public String initIntegralSetInsert() throws Exception {
		
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
		
		
		
        departmentList = departmentsMgr.getDepartments("1","0");
        StringBuffer allDepartmentID = new StringBuffer();
        StringBuffer allDepartmentName = new StringBuffer();
		for (int i = 0; i < departmentList.size(); i++){
			allDepartmentID.append(Utility.getName(departmentList.get(i).getBdpdepartmentid())+",");
			allDepartmentName.append(Utility.getName(departmentList.get(i).getBdpdepartmentname())+",");
		}
		if (departmentList.size() > 0){
		    request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
		    request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));
		}
		
		memberManagementlist=memberManagementMgr.getMemberManagementList();
        StringBuffer memberManagementID = new StringBuffer();
        StringBuffer memberManagementName = new StringBuffer();
		for (int i = 0; i < memberManagementlist.size(); i++){
			memberManagementID.append(Utility.getName(memberManagementlist.get(i).getFmmid())+",");
			memberManagementName.append(Utility.getName(memberManagementlist.get(i).getFmmmembername())+",");
		}
		if (memberManagementlist.size() > 0){
		    request.setAttribute("memberManagementID",memberManagementID.toString().substring(0, memberManagementID.toString().length()-1));
		    request.setAttribute("memberManagementName",memberManagementName.toString().substring(0, memberManagementName.toString().length()-1));
		}
		
		return SUCCESS;
	}
	
	/**
	 * 积分累计规则新增
	 * @return
	 * @throws Exception
	 */
	public String insertIntegralSet() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("积分累计规则:" + Utility.getName(integralPo.getFirID()) + "新增!");
				
		if (integralPo.getFirGoodsCategoryID().equals("3-0")){
			integralPo.setFirGoodsCategoryName("成品片");				
		}
		if (integralPo.getFirGoodsCategoryID().equals("3-D")){
			integralPo.setFirGoodsCategoryName("订做片");				
		}
		if (integralPo.getFirGoodsCategoryID().equals("4-0")){
			integralPo.setFirGoodsCategoryName("隐形成品片");				
		}
		if (integralPo.getFirGoodsCategoryID().equals("4-D")){
			integralPo.setFirGoodsCategoryName("隐形订做片");				
		}
		if (integralPo.getFirGoodsCategoryID().equals("1")){
			integralPo.setFirGoodsCategoryName("镜架");				
		}
		if (integralPo.getFirGoodsCategoryID().equals("2")){
			integralPo.setFirGoodsCategoryName("配件");				
		}
		if (integralPo.getFirGoodsCategoryID().equals("5")){
			integralPo.setFirGoodsCategoryName("隐形护理液");				
		}
		if (integralPo.getFirGoodsCategoryID().equals("6")){
			integralPo.setFirGoodsCategoryName("太阳镜");				
		}
		if (integralPo.getFirGoodsCategoryID().equals("7")){
			integralPo.setFirGoodsCategoryName("耗材");				
		}
		if (integralPo.getFirGoodsCategoryID().equals("8")){
			integralPo.setFirGoodsCategoryName("老花镜");				
		}
		if (integralPo.getFirGoodsCategoryID().equals("9")){
			integralPo.setFirGoodsCategoryName("视光");				
		}			
		if (integralPo.getFirGoodsCategoryID().startsWith("3") || integralPo.getFirGoodsCategoryID().startsWith("4")){
			integralPo.setFirIscustomize(integralPo.getFirGoodsCategoryID().split("-")[1]);
			integralPo.setFirGoodsCategoryID(integralPo.getFirGoodsCategoryID().split("-")[0]);				
		}
		
		int count = setMealMgr.isExistIntegralSet(integralPo);
		if (count == 0){

			setMealMgr.insertIntegralSet(integralPo, logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));		
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
		}else{
					
			this.clearMessages();
			this.addActionMessage(getText("积分累计规则重复!"));
			
	        departmentList = departmentsMgr.getDepartments("1","0");
	        StringBuffer allDepartmentID = new StringBuffer();
	        StringBuffer allDepartmentName = new StringBuffer();
			for (int i = 0; i < departmentList.size(); i++){
				allDepartmentID.append(Utility.getName(departmentList.get(i).getBdpdepartmentid())+",");
				allDepartmentName.append(Utility.getName(departmentList.get(i).getBdpdepartmentname())+",");
			}
			if (departmentList.size() > 0){
			    request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
			    request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));
			}
			
			memberManagementlist=memberManagementMgr.getMemberManagementList();
	        StringBuffer memberManagementID = new StringBuffer();
	        StringBuffer memberManagementName = new StringBuffer();
			for (int i = 0; i < memberManagementlist.size(); i++){
				memberManagementID.append(Utility.getName(memberManagementlist.get(i).getFmmid())+",");
				memberManagementName.append(Utility.getName(memberManagementlist.get(i).getFmmmembername())+",");
			}
			if (memberManagementlist.size() > 0){
			    request.setAttribute("memberManagementID",memberManagementID.toString().substring(0, memberManagementID.toString().length()-1));
			    request.setAttribute("memberManagementName",memberManagementName.toString().substring(0, memberManagementName.toString().length()-1));
			}
			
			if (count != 0){
				request.setAttribute("focusMsg","");
				return "NoRepeat";
			}
			if (!Utility.getName(integralPo.getFirGoodsID()).equals("")){
				request.setAttribute("focusMsg","4");
			}else if (!Utility.getName(integralPo.getFirBrandID()).equals("")){
				request.setAttribute("focusMsg","3");
			}else if (!Utility.getName(integralPo.getFirSupplierID()).equals("")){
				request.setAttribute("focusMsg","2");
			}else if (!Utility.getName(integralPo.getFirGoodsCategoryID()).equals("")){
				request.setAttribute("focusMsg","1");
			}else{
				request.setAttribute("focusMsg","");
			}			
			return "NoRepeat";
		}

		return SUCCESS;
	}
	
	/**
	 * 初始化积分累计规则更新
	 * @return
	 * @throws Exception
	 */
	public String initIntegralSetUpdate() throws Exception {
		
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

		integralPo = new IntegralPo();
		integralPo.setFirID(Utility.getName(request.getParameter("hid")));
		
		integralPo = setMealMgr.getIntegralSetDetail(integralPo);
		
		return SUCCESS;
	}
	
	
	/**
	 * 积分累计规则更新
	 * @return
	 * @throws Exception
	 */
	public String updateIntegralSet() throws Exception {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("积分累计规则：" + Utility.getName(integralPo.getFirID()) +"修改!");
		
		setMealMgr.updateIntegralSet(integralPo, logPo);		
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}	
	
	/**
	 * 初始化积分累计规则删除
	 * @return
	 * @throws Exception
	 */
	public String initIntegralSetDelete() throws Exception {
		
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
	 * 删除积分累计规则
	 * @return
	 * @throws Exception
	 */
	public String deleteIntegralSet() throws Exception {
		
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("积分累计规则：" + Utility.getName(integralPo.getFirID()) + "删除!");
		
		setMealMgr.deleteIntegralSet(integralPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	
	/**
	 * 初始化积分累计规则批量删除
	 * @return
	 * @throws Exception
	 */
	public String initIntegralSetBatchDelete() throws Exception {
		
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
	 * 批量删除积分累计规则
	 * @return
	 * @throws Exception
	 */
	public String deleteBatchIntegralSet() throws Exception {
		
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("积分累计规则：" + Utility.getName(integralPo.getFirID()) + "批量删除!");
		
		setMealMgr.deleteBatchIntegralSet(integralPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	
	/**
	 * 初始化积分累计规则批量修改
	 * @return
	 * @throws Exception
	 */
	public String initIntegralSetBatchUpdate() throws Exception {
		
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
	 * 批量修改积分累计规则
	 * @return
	 * @throws Exception
	 */
	public String updateBatchIntegralSet() throws Exception {
		
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("积分累计规则：" + Utility.getName(integralPo.getFirID()) + "批量修改!");
		
		setMealMgr.updateBatchIntegralSet(integralPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	
	/**
	 * 初始化商品开窗
	 * @return
	 * @throws Exception
	 */
	public String initGoodsOpen() throws Exception {
		
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
		
		String categoryID_open = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID_open = Utility.getName(request.getParameter("supplierID_open"));
		String brand_open = Utility.getName(request.getParameter("brand_open"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		
		if (categoryID_open.startsWith("3") || categoryID_open.startsWith("4")){
			request.setAttribute("iscustomize",categoryID_open.split("-")[1]);
		}else{
			request.setAttribute("iscustomize","");
		}
		
		request.setAttribute("goodsCategoryID",categoryID_open);
		request.setAttribute("supplierID",supplierID_open);
		request.setAttribute("brandID",brand_open);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandName",brandName);		
		
		return SUCCESS;
	}
	
	/**
	 * 商品开窗
	 * @return
	 * @throws Exception
	 */
	public String goodsOpen() throws Exception {
		
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
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String iscustomize = Utility.getName(request.getParameter("iscustomize"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("iscustomize",iscustomize);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		integralPo = new IntegralPo();
		if (goodsCategoryID.startsWith("3") || goodsCategoryID.startsWith("4")){
			integralPo.setFirGoodsCategoryID(goodsCategoryID.split("-")[0]);
		}else{
			integralPo.setFirGoodsCategoryID(goodsCategoryID);
		}		
		integralPo.setFirBrandID(brandID);
		integralPo.setFirSupplierID(supplierID);
		integralPo.setFirGoodsID(goodsID);
		integralPo.setFirGoodsName(goodsName);
		integralPo.setFirIscustomize(iscustomize);
		
		int count = setMealMgr.getGoodsCount(integralPo);
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
			goodsList = setMealMgr.getGoodsList(integralPo,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		
		return SUCCESS;
	}
	/***************************************************************************************************************************/
	
	/***************************************************************************************************************************/
	/***************************************************************************************************************************/
	

	/***************************************************************************************************************************/
	
	/**
	 * 初始化最大折扣设置
	 * @return
	 * @throws Exception
	 */
	public String initMaxDiscountSetSel() throws Exception {
		
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
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "maxDiscountSetSel";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 最大折扣设置查询
	 * @return
	 * @throws Exception
	 */
	public String maxDiscountSetSel() throws Exception {
		
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
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);

		maxDiscountPo = new MaxDiscountPo();
		if (goodsCategoryID.startsWith("3") || goodsCategoryID.startsWith("4")){
			maxDiscountPo.setFmdiscustomize(goodsCategoryID.split("_")[1]);
			maxDiscountPo.setFmdgoodscategoryid(goodsCategoryID.split("_")[0]);				
		}else{
			maxDiscountPo.setFmdgoodscategoryid(goodsCategoryID);
		}
		
		maxDiscountPo.setFmdsupplierid(supplierID);
		maxDiscountPo.setFmdbrandid(brandID);
		maxDiscountPo.setFmdgoodsid(goodsID);
		maxDiscountPo.setFmdgoodsname(goodsName);
		
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
		
		int count = setMealMgr.getMaxDiscountSetCount(maxDiscountPo);
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
			maxDiscountList = setMealMgr.getMaxDiscountSetList(maxDiscountPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			maxDiscountList = null;
		}
	
		return SUCCESS;
	}
	
	/**
	 * 初始化最大折扣设置新增
	 * @return
	 * @throws Exception
	 */
	public String initMaxDiscountSetInsert() throws Exception {
		
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
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		return SUCCESS;
	}
	
	/**
	 * 最大折扣设置新增
	 * @return
	 * @throws Exception
	 */
	public String insertMaxDiscountSet() throws Exception {
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
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		if (maxDiscountPo.getFmdgoodscategoryid().equals("3-0")){
			maxDiscountPo.setFmdgoodscategoryname("成品片");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("3-D")){
			maxDiscountPo.setFmdgoodscategoryname("订做片");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("4-0")){
			maxDiscountPo.setFmdgoodscategoryname("隐形成品片");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("4-D")){
			maxDiscountPo.setFmdgoodscategoryname("隐形订做片");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("1")){
			maxDiscountPo.setFmdgoodscategoryname("镜架");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("2")){
			maxDiscountPo.setFmdgoodscategoryname("配件");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("5")){
			maxDiscountPo.setFmdgoodscategoryname("隐形护理液");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("6")){
			maxDiscountPo.setFmdgoodscategoryname("太阳镜");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("7")){
			maxDiscountPo.setFmdgoodscategoryname("耗材");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("8")){
			maxDiscountPo.setFmdgoodscategoryname("老花镜");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("9")){
			maxDiscountPo.setFmdgoodscategoryname("视光");				
		}			
		if (maxDiscountPo.getFmdgoodscategoryid().startsWith("3") || maxDiscountPo.getFmdgoodscategoryid().startsWith("4")){
			maxDiscountPo.setFmdiscustomize(maxDiscountPo.getFmdgoodscategoryid().split("-")[1]);
			maxDiscountPo.setFmdgoodscategoryid(maxDiscountPo.getFmdgoodscategoryid().split("-")[0]);				
		}
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("最大折扣设置:" + Utility.getName(maxDiscountPo.getFmdid()) + "新增!");
		
		int count = setMealMgr.isExistMaxDiscountSet(maxDiscountPo);
		if (count == 0){

			setMealMgr.insertMaxDiscountSet(maxDiscountPo, maxDiscountDetailsPo, logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));		
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
		}else{
			this.clearMessages();
			this.addActionMessage(getText("最大折扣设置不能重复!"));
			
			return "NoRepeat";
		}

		return SUCCESS;
	}
	
	/**
	 * 初始化最大折扣设置更新
	 * @return
	 * @throws Exception
	 */
	public String initMaxDiscountSetUpdate() throws Exception {
		
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
		maxDiscountPo = new MaxDiscountPo();
		maxDiscountPo.setFmdid(Utility.getName(request.getParameter("hid")));
		MaxDiscountDetailsPo dpo = new MaxDiscountDetailsPo();
		dpo.setFmddmaxid(Utility.getName(request.getParameter("hid")));
		
		maxDiscountPo = setMealMgr.getMaxDiscountSetDetail(maxDiscountPo);
		maxDiscountDetailsPos = setMealMgr.selectMaxDiscountDetails(dpo);
		
		return SUCCESS;
	}
	
	
	/**
	 * 最大折扣设置更新
	 * @return
	 * @throws Exception
	 */
	public String updateMaxDiscountSet() throws Exception {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("最大折扣设置：" + Utility.getName(maxDiscountPo.getFmdid()) +"修改!");
		
		setMealMgr.updateMaxDiscountSet(maxDiscountPo, maxDiscountDetailsPo, logPo);		
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}	
	
	/**
	 * 初始化最大折扣设置删除
	 * @return
	 * @throws Exception
	 */
	public String initMaxDiscountSetDelete() throws Exception {
		
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
	 * 删除最大折扣设置
	 * @return
	 * @throws Exception
	 */
	public String deleteMaxDiscountSet() throws Exception {
		
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("最大折扣设置：" + Utility.getName(maxDiscountPo.getFmdid()) + "删除!");
		
		setMealMgr.deleteMaxDiscountSet(maxDiscountPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	
	/**
	 * 初始化最大折扣设置批量删除
	 * @return
	 * @throws Exception
	 */
	public String initMaxDiscountSetBatchDelete() throws Exception {
		
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
	 * 批量删除最大折扣设置
	 * @return
	 * @throws Exception
	 */
	public String deleteBatchMaxDiscountSet() throws Exception {
		
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("最大折扣设置：" + Utility.getName(maxDiscountPo.getFmdid()) + "批量删除!");
		
		setMealMgr.deleteBatchMaxDiscountSet(maxDiscountPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	
	/**
	 * 初始化最大折扣设置批量修改
	 * @return
	 * @throws Exception
	 */
	public String initMaxDiscountSetBatchUpdate() throws Exception {
		
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
	 * 批量修改最大折扣设置
	 * @return
	 * @throws Exception
	 */
	public String updateBatchMaxDiscountSet() throws Exception {
		
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("最大折扣设置：" + Utility.getName(maxDiscountPo.getFmdid()) + "批量修改!");

		setMealMgr.updateBatchMaxDiscountSet(maxDiscountPo, maxDiscountDetailsPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	
	/**
	 * 初始化商品开窗
	 * @return
	 * @throws Exception
	 */
	public String initGoodsMaxDiscountOpen() throws Exception {
		
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
		
		String categoryID_open = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID_open = Utility.getName(request.getParameter("supplierID_open"));
		String brand_open = Utility.getName(request.getParameter("brand_open"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		
		if (categoryID_open.startsWith("3") || categoryID_open.startsWith("4")){
			request.setAttribute("iscustomize",categoryID_open.split("-")[1]);
		}else{
			request.setAttribute("iscustomize","");
		}
		
		request.setAttribute("goodsCategoryID",categoryID_open);
		request.setAttribute("supplierID",supplierID_open);
		request.setAttribute("brandID",brand_open);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandName",brandName);		
		
		return SUCCESS;
	}
	
	/**
	 * 商品开窗
	 * @return
	 * @throws Exception
	 */
	public String goodsMaxDiscountOpen() throws Exception {
		
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
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String iscustomize = Utility.getName(request.getParameter("iscustomize"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("iscustomize",iscustomize);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		integralPo = new IntegralPo();
		if (goodsCategoryID.startsWith("3") || goodsCategoryID.startsWith("4")){
			integralPo.setFirGoodsCategoryID(goodsCategoryID.split("-")[0]);
		}else{
			integralPo.setFirGoodsCategoryID(goodsCategoryID);
		}		
		integralPo.setFirBrandID(brandID);
		integralPo.setFirSupplierID(supplierID);
		integralPo.setFirGoodsID(goodsID);
		integralPo.setFirGoodsName(goodsName);
		integralPo.setFirIscustomize(iscustomize);
		
		int count = setMealMgr.getGoodsCount(integralPo);
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
			goodsList = setMealMgr.getGoodsList(integralPo,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		
		return SUCCESS;
	}
	/***************************************************************************************************************************/
	/***************************************************************************************************************************/
	/***************************************************************************************************************************/
	/***************************************************************************************************************************/
	
	/**
	 * 积分兑换查询
	 * @return
	 * @throws Exception
	 */
	public String integralExchangeSetSel() throws Exception {
		
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
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String jfmin = Utility.getName(request.getParameter("jfmin"));
		String jfmax = Utility.getName(request.getParameter("jfmax"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		integralPo = new IntegralPo();
		
		integralPo.setFirGoodsID(goodsID);
		integralPo.setFirGoodsName(goodsName);
		integralPo.setFirjfmin(jfmin);
		integralPo.setFirjfmax(jfmax);
		
		int count = setMealMgr.getIntegralExchangeSetCount(integralPo);
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
			integralList = setMealMgr.getIntegralExchangeSetList(integralPo,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			integralList = null;
		}
		
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("jfmin", jfmin);
		request.setAttribute("jfmax", jfmax);
	
		return SUCCESS;
	}
	
	/**
	 * 初始化积分兑换新增
	 * @return
	 * @throws Exception
	 */
	public String initIntegralExchangeSetInsert() throws Exception {
		
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
		
		departmentList = departmentsMgr.getDepartments("1","0");
        StringBuffer allDepartmentID = new StringBuffer();
        StringBuffer allDepartmentName = new StringBuffer();
		for (int i = 0; i < departmentList.size(); i++){
			allDepartmentID.append(Utility.getName(departmentList.get(i).getBdpdepartmentid())+",");
			allDepartmentName.append(Utility.getName(departmentList.get(i).getBdpdepartmentname())+",");
		}
		if (departmentList.size() > 0){
			request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
			request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));	        
		}
		
		return SUCCESS;
	}
	
	/**
	 * 积分兑换新增
	 * @return
	 * @throws Exception
	 */
	public String insertIntegralExchangeSet() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态		
		StringBuffer goodsID = new StringBuffer();
		
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		
		List<IntegralPo> list = new ArrayList<IntegralPo>();
		if (goodsInfoTempPo != null){			
			int count = goodsInfoTempPo.getGoodsid().length;
			for (int i = 0; i < count; i++){
				IntegralPo po = new IntegralPo();
				po.setFirGoodsID(goodsInfoTempPo.getGoodsid()[i]);
				po.setFirGoodsName(goodsInfoTempPo.getGoodsname()[i]);
				po.setFirIntegralCount(goodsInfoTempPo.getGoodsquantity()[i]);
				po.setFirFlag("1");
				po.setFirdepartmentid(departmentID);
				po.setFirpersonnum(goodsInfoTempPo.getPersonNum()[i]);
				po.setFirgoodssumnum(goodsInfoTempPo.getSumNum()[i]);
				po.setFirgoodseasyname(goodsInfoTempPo.getEasyName()[i]);
				if (setMealMgr.isExistIntegralExchangeSet(po) > 0){
					departmentList = departmentsMgr.getDepartments("1","0");
			        StringBuffer allDepartmentID = new StringBuffer();
			        StringBuffer allDepartmentName = new StringBuffer();
					for (int j = 0; j < departmentList.size(); j++){
						allDepartmentID.append(Utility.getName(departmentList.get(j).getBdpdepartmentid())+",");
						allDepartmentName.append(Utility.getName(departmentList.get(j).getBdpdepartmentname())+",");
					}
					if (departmentList.size() > 0){
						request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
						request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));	        
					}
					this.clearMessages();
					this.addActionMessage(getText("积分兑换设置重复!"));	
					
					return "NoRepeat";
				}
				
				goodsID.append(po.getFirGoodsID()+",");
				
				list.add(po);
			}
		}
		logPo.setsLogContent("积分兑换设置:" + goodsID + "新增!");
		
		setMealMgr.insertIntegralExchangeSet(list, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));		
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 初始化积分兑换更新
	 * @return
	 * @throws Exception
	 */
	public String initIntegralExchangeSetUpdate() throws Exception {
		
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
		
		integralPo = new IntegralPo();
		integralPo.setFirGoodsID(Utility.getName(request.getParameter("hid")));
		
		integralPo = setMealMgr.getIntegralExchangeSetDetail(integralPo);
		
		departmentList = departmentsMgr.getDepartments("1","0");
        StringBuffer allDepartmentID = new StringBuffer();
        StringBuffer allDepartmentName = new StringBuffer();
		for (int j = 0; j < departmentList.size(); j++){
			allDepartmentID.append(Utility.getName(departmentList.get(j).getBdpdepartmentid())+",");
			allDepartmentName.append(Utility.getName(departmentList.get(j).getBdpdepartmentname())+",");
		}
		if (departmentList.size() > 0){
			request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
			request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));	        
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 积分兑换更新
	 * @return
	 * @throws Exception
	 */
	public String updateIntegralExchangeSet() throws Exception {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("积分兑换设置:" + Utility.getName(integralPo.getFirGoodsID()) + "修改!");
		
		if (!Utility.getName(integralPo.getFirpicurl()).equals("")) {
			integralPo.setFirpicurl(integralPo.getFirpicurl().replaceAll(
					",", ""));
		}
		
		String content = Utility.getName(request.getParameter("content"));
		integralPo.setFircontent(content);
		
		setMealMgr.updateIntegralExchangeSet(integralPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}	
	
	/**
	 * 初始化积分兑换删除
	 * @return
	 * @throws Exception
	 */
	public String initIntegralExchangeSetDelete() throws Exception {
		
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

		integralPo = new IntegralPo();
		integralPo.setFirGoodsID(Utility.getName(request.getParameter("hid")));
		
		integralPo = setMealMgr.getIntegralExchangeSetDetail(integralPo);
		
		return SUCCESS;
	}
	
	
	/**
	 * 删除积分兑换
	 * @return
	 * @throws Exception
	 */
	public String deleteIntegralExchangeSet() throws Exception {
		
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("积分兑换设置:" + Utility.getName(integralPo.getFirGoodsID()) + "删除!");
		
		setMealMgr.deleteIntegralExchangeSet(integralPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	
	/**
	 * 初始化积分兑换停用启用
	 * @return
	 * @throws Exception
	 */
	public String initIntegralExchangeSetEnable() throws Exception {
		
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

		integralPo = new IntegralPo();
		integralPo.setFirGoodsID(Utility.getName(request.getParameter("hid")));
		
		integralPo = setMealMgr.getIntegralExchangeSetDetail(integralPo);
		integralPo.setFirFlag(Utility.getName(request.getParameter("flag")));
		
		return SUCCESS;
	}
	
	
	/**
	 * 停用启用积分兑换
	 * @return
	 * @throws Exception
	 */
	public String enableIntegralExchangeSet() throws Exception {
		
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("积分兑换设置:" + Utility.getName(integralPo.getFirGoodsID()) + (Utility.getName(integralPo.getFirFlag()).equals("1") ? "启用!" : "停用!"));
		
		setMealMgr.enableIntegralExchangeSet(integralPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	
	
	/**
	 * 初始化积分兑换商品开窗
	 * @return
	 * @throws Exception
	 */
	public String initExchangeGoodsOpen() throws Exception {
		
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
		
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		
		return SUCCESS;
	}
	
	/**
	 * 积分兑换商品开窗
	 * @return
	 * @throws Exception
	 */
	public String exchangeGoodsOpen() throws Exception {
		
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
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));		
		String costprice = Utility.getName(request.getParameter("costprice"));
		String retailprice = Utility.getName(request.getParameter("retailprice"));
		String teachnologyType = Utility.getName(request.getParameter("teachnologyType"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("costprice",costprice);
		request.setAttribute("retailprice",retailprice);
		request.setAttribute("teachnologyType",teachnologyType);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		integralPo = new IntegralPo();
		if (goodsCategoryID.startsWith("3") || goodsCategoryID.startsWith("4")){
			integralPo.setFirGoodsCategoryID(goodsCategoryID.split("-")[0]);
			integralPo.setFirIscustomize(goodsCategoryID.split("-")[1]);
		}else{
			integralPo.setFirGoodsCategoryID(goodsCategoryID);
		}
		if (goodsCategoryID.equals("1")){
			integralPo.setFirTeachnologyType(teachnologyType);
		}	
		integralPo.setFirBrandID(brandID);
		integralPo.setFirSupplierID(supplierID);
		integralPo.setFirGoodsID(goodsID);
		integralPo.setFirGoodsName(goodsName);
		integralPo.setFirRetailPrice(retailprice);
		integralPo.setFirCostPrice(costprice);
		
		int count = setMealMgr.getGoodsCount(integralPo);
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
			goodsList = setMealMgr.getGoodsList(integralPo,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
			
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		
		return SUCCESS;
	}
	
	/**
	 * 积分兑换商品开窗
	 * @return
	 * @throws Exception
	 */
	public String queryExchangeGoods() throws Exception {
		
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
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));		
		String costprice = Utility.getName(request.getParameter("costprice"));
		String retailprice = Utility.getName(request.getParameter("retailprice"));
		String teachnologyType = Utility.getName(request.getParameter("teachnologyType"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("costprice",costprice);
		request.setAttribute("retailprice",retailprice);
		request.setAttribute("teachnologyType",teachnologyType);
		
		integralPo = new IntegralPo();
		if (goodsCategoryID.startsWith("3") || goodsCategoryID.startsWith("4")){
			integralPo.setFirGoodsCategoryID(goodsCategoryID.split("-")[0]);
			integralPo.setFirIscustomize(goodsCategoryID.split("-")[1]);
		}else{
			integralPo.setFirGoodsCategoryID(goodsCategoryID);
		}
		if (goodsCategoryID.equals("1")){
			integralPo.setFirTeachnologyType(teachnologyType);
		}	
		integralPo.setFirBrandID(brandID);
		integralPo.setFirSupplierID(supplierID);
		integralPo.setFirGoodsID(goodsID);
		integralPo.setFirGoodsName(goodsName);
		integralPo.setFirRetailPrice(retailprice);
		integralPo.setFirCostPrice(costprice);
		
		goodsList = setMealMgr.getGoodsList(integralPo);		
		teachnologyTypeList = teachnologyTypeMgr.getTeachnologyTypeList();
		
		return SUCCESS;
	}
	
	/**************************************************************************************************************************/
	
	/**
	 * 前台初始化套餐开窗
	 */
	public String initQuerySetMealGoodsOpen() throws Exception {
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
	 * 前台套餐开窗
	 */
	public String querySetMealGoodsOpen() throws Exception {
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
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		String ssmsmid = Utility.getName(request.getParameter("hid"));
		String goodsamount = Utility.getName(request.getParameter("goodsamount"));
		String salestype = Utility.getName(request.getParameter("salestype"));
		
		setMealPo = new SetMealPo();
		setMealPo.setSsmsmid(ssmsmid);
		setMealPo.setSsmsmshopcode(personInfoPo.getDepartmentID());
		setMealPo.setSsmsmsalestype(salestype);
		setMealPo.setSsmsmsalesamount(goodsamount); 
		
		setMealList = setMealMgr.getSetMealOpenCount(setMealPo);
		List<SetMealPo> strList = new ArrayList<SetMealPo>();
		
		for (int i = 0; i < setMealList.size(); i++){
			int count = 0;
			for (int j = 0; j < strList.size(); j++){
				if (Utility.getName(strList.get(j).getSsmsmid()).equals(Utility.getName(setMealList.get(i).getSsmsmid()))){
					continue;
				}
				count++;
			}
			
			if (count == strList.size()){
				setMealList.get(i).setSsmsmshopcode(personInfoPo.getDepartmentID());
				strList.add(setMealList.get(i));			
			}
		}	
		
		int count = strList.size();
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
			setMealList = setMealMgr.getSetMealOpenList(setMealList,strList,goodsamount,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			setMealList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化审核套餐
	 * @return
	 */
	public String initSetmealAudit() throws Exception{
		
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
				
		SetMealPo po = new SetMealPo();
		po.setSsmsmid(Utility.getName(request.getParameter("hid")));
		
		setMealPo = setMealMgr.getSetMealDetail(po);
		salesGoodsArrayList = setMealMgr.getSetMealEntryDetail(po);
		
		return SUCCESS;
	} 
	
	/**
	 * 审核套餐
	 * @return
	 */
	public String auditSetMeal() throws Exception{
		
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("套餐:" +Utility.getName(setMealPo.getSsmsmtitle()) +"审核!");

		setMealPo.setSsmsmid(Utility.getName(request.getParameter("hid")));		
		setMealPo.setSsmsmauditperson(createPerson);
		
		setMealMgr.updateSetMealAudit(setMealPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	} 
	
	/**
	 * 初始化停用套餐
	 * @return
	 */
	public String initSetmealAble() throws Exception{
		
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
				
		setMealPo = new SetMealPo();
		setMealPo.setSsmsmid(Utility.getName(request.getParameter("hid")));
		
		setMealPo = setMealMgr.getSetMealDetail(setMealPo);
		
		return SUCCESS;
	} 
	
	/**
	 * 停用套餐
	 * @return
	 */
	public String ableSetMeal() throws Exception{
		
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("套餐:" +Utility.getName(setMealPo.getSsmsmtitle()) +"停用!");
		
		setMealPo.setSsmsmauditperson(createPerson);
		
		setMealMgr.updateSetMealAble(setMealPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	} 
	
	/**
	 * 初始化复制套餐
	 * @return
	 */
	public String initSetmealCopy() throws Exception{
		
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
	 * 复制套餐
	 * @return
	 */
	public String copySetMeal() throws Exception{
		
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("套餐:" +Utility.getName(setMealPo.getSsmsmtitle()) +"复制!");
		
		String copyid = uuid.generate();
		
		setMealPo.setSsmsmcreateperson(createPerson);
		setMealPo.setSsmsmid(Utility.getName(request.getParameter("hid")));
		setMealPo.setSsmsmcopyid(copyid);
		
		setMealMgr.insertSetMealCopy(setMealPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("套餐复制成功!"));
		
		String url = "''initSetMealUpdate.action?hid={0}&moduleID={1}''";
		List<String> params = new ArrayList<String>();
		params.add(copyid);
		params.add(moduleID);
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);		
		
		return SUCCESS;
	} 
	
	/**
	 * 套餐更新活动部门
	 * @return
	 * @throws Exception
	 */
	public String updateSetMealDepartments() throws Exception {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("套餐：" + Utility.getName(setMealPo.getSsmsmtitle()) +"修改活动部门!");

		setMealPo.setSsmsmauditperson(createPerson);
		
		setMealMgr.updateSetMealDepartments(setMealPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 商品满减链接整单满减
	 * @return
	 * @throws Exception
	 */
	public String fromGoodsFullReductionToBillReduction() throws Exception {
		
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
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = currMouthFirstDay.format(calendar.getTime());			
        request.setAttribute("createDate",createDate);
        
        departmentList = departmentsMgr.getDepartments("1","0");
        StringBuffer allDepartmentID = new StringBuffer();
        StringBuffer allDepartmentName = new StringBuffer();
		for (int i = 0; i < departmentList.size(); i++){
			allDepartmentID.append(Utility.getName(departmentList.get(i).getBdpdepartmentid())+",");
			allDepartmentName.append(Utility.getName(departmentList.get(i).getBdpdepartmentname())+",");
		}
		if (departmentList.size() > 0){
			request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
			request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));	        
		}

		refractiveSetList = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList(); 
		
		return SUCCESS;
	}
	
	/**
	 * 整单满减链接商品满减
	 * @return
	 * @throws Exception
	 */
	public String fromBillReductionToGoodsFullReduction() throws Exception {
		
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
				
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = currMouthFirstDay.format(calendar.getTime());			
        request.setAttribute("createDate",createDate);
		
        departmentList = departmentsMgr.getDepartments("1","0");
        StringBuffer allDepartmentID = new StringBuffer();
        StringBuffer allDepartmentName = new StringBuffer();
		for (int i = 0; i < departmentList.size(); i++){
			allDepartmentID.append(Utility.getName(departmentList.get(i).getBdpdepartmentid())+",");
			allDepartmentName.append(Utility.getName(departmentList.get(i).getBdpdepartmentname())+",");
		}	
		if (departmentList.size() > 0){
			request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
			request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));
		}

		refractiveSetList = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList(); 
		
		return SUCCESS;
	}
	
	/**
	 * 商品特价链接整单特价
	 * @return
	 * @throws Exception
	 */
	public String fromGoodsSpecialToBillSpecial() throws Exception {
		
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
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = currMouthFirstDay.format(calendar.getTime());			
        request.setAttribute("createDate",createDate);
		
        departmentList = departmentsMgr.getDepartments("1","0");
        StringBuffer allDepartmentID = new StringBuffer();
        StringBuffer allDepartmentName = new StringBuffer();
		for (int i = 0; i < departmentList.size(); i++){
			allDepartmentID.append(Utility.getName(departmentList.get(i).getBdpdepartmentid())+",");
			allDepartmentName.append(Utility.getName(departmentList.get(i).getBdpdepartmentname())+",");
		}
		if (departmentList.size() > 0){
			request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
			request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));
		}
	
		refractiveSetList = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList(); 
		
		return SUCCESS;
	}
	
	/**
	 * 整单特价链接商品特价
	 * @return
	 * @throws Exception
	 */
	public String fromBillSpecialToGoodsSpecial() throws Exception {
		
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
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = currMouthFirstDay.format(calendar.getTime());			
        request.setAttribute("createDate",createDate);
		
        departmentList = departmentsMgr.getDepartments("1","0");
        StringBuffer allDepartmentID = new StringBuffer();
        StringBuffer allDepartmentName = new StringBuffer();
		for (int i = 0; i < departmentList.size(); i++){
			allDepartmentID.append(Utility.getName(departmentList.get(i).getBdpdepartmentid())+",");
			allDepartmentName.append(Utility.getName(departmentList.get(i).getBdpdepartmentname())+",");
		}
		if (departmentList.size() > 0){
		    request.setAttribute("allDepartmentID",allDepartmentID.toString().substring(0, allDepartmentID.toString().length()-1));
		    request.setAttribute("allDepartmentName",allDepartmentName.toString().substring(0, allDepartmentName.toString().length()-1));
		}
		
		refractiveSetList = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList(); 
		
		return SUCCESS;
	}
	
	/**
	 * 初始化反审核套餐
	 * @return
	 */
	public String initSetmealUnAudit() throws Exception{
		
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
				
		SetMealPo po = new SetMealPo();
		po.setSsmsmid(Utility.getName(request.getParameter("hid")));
		
		setMealPo = setMealMgr.getSetMealDetail(po);
		
		return SUCCESS;
	} 
	
	/**
	 * 反审核套餐
	 * @return
	 */
	public String unAuditSetMeal() throws Exception{
		
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("套餐:" +Utility.getName(setMealPo.getSsmsmtitle()) +"反审核!");
		
		setMealMgr.updateSetMealUnAudit(setMealPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	} 
	
	/**
	 * 根据商品类型查询商品属性
	 * @return
	 * @throws Exception
	 */
	public void getGoodsCategoryBySetMealClassify() throws Exception {

		String classify = Utility.getName(request.getParameter("classify"));
		
		SetMealPo po = new SetMealPo();
		po.setSsmsmclassify(classify);		
				
		PrintWriter out = null;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(classify.equals("")){
			out.println("<option value=''>----请选择----</option>");
		}else{
			out.println("<option value=''>----请选择----</option>");
			setMealParentPropertyList = setMealMgr.getGoodsCategoryBySetMealClassify(po);
			Iterator<SetMealParentPropertyPo> it = setMealParentPropertyList.iterator();	
			if (it.hasNext()) {
				while (it.hasNext()) {
					SetMealParentPropertyPo epo = it.next();
					out.println("<option value='" + Utility.getName(epo.getSsmpppropertyid()) + "'>" + Utility.getName(epo.getSsmpppropertyname()) + "</option>");
				}
			}
		}
		//释放流
		out.flush();
		out.close();
		
		//释放资源
		classify = null;
		out = null;
		
	}
	
	/**
	 * 根据商品类型查询商品属性
	 * @return
	 * @throws Exception
	 */
	public void getGoodsPropertyByGoodsCategory() throws Exception {

		String goodsCategory = Utility.getName(request.getParameter("goodsCategory"));
		
		SetMealEntryPo epo = new SetMealEntryPo();
		epo.setSsmsggoodscategory(goodsCategory);
		epo.setSsmsgsalestype("1");		
		
		PrintWriter out = null;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(goodsCategory.equals("")){
			out.println("<option value=''>----请选择----</option>");
		}else{
			out.println("<option value=''>----请选择----</option>");
			setMealChildPropertyList = setMealMgr.getGoodsPropertyByGoodsCategory(epo);
			Iterator<SetMealChildPropertyPo> it = setMealChildPropertyList.iterator();	
			if (it.hasNext()) {
				while (it.hasNext()) {
					SetMealChildPropertyPo po = it.next();
					out.println("<option value='" + Utility.getName(po.getSsmcppropertyid()) + "' control='" + Utility.getName(po.getSsmcpcontroltype()) + "'>" + Utility.getName(po.getSsmcppropertyname()) + "</option>");
				}
			}
		}
		//释放流
		out.flush();
		out.close();
		
		//释放资源
		goodsCategory = null;
		out = null;
		
	}
	
	/**
	 * 商品属性查询商品属性值
	 * @return
	 * @throws Exception
	 */
	public void getGoodsPropertyValueByGoodsProperty() throws Exception {

		String propertyID = Utility.getName(request.getParameter("propertyID"));
		
		SetMealEntryPo epo = new SetMealEntryPo();
		epo.setSsmsgbigclass(propertyID);	
		
		PrintWriter out = null;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(propertyID.equals("")){
			out.println("<option value=''>----请选择----</option>");
		}else{
			out.println("<option value=''>----请选择----</option>");
			setMealPropertyValueList = setMealMgr.getGoodsPropertyValueByGoodsProperty(epo);
			Iterator<SetMealPropertyValuePo> it = setMealPropertyValueList.iterator();	
			if (it.hasNext()) {
				while (it.hasNext()) {
					SetMealPropertyValuePo po = it.next();
					out.println("<option value='" + po.getSsmpvvalueid() + "'>" + po.getSsmpvvaluename() + "</option>");
				}
			}
		}
		//释放流
		out.flush();
		out.close();
		
		//释放资源
		propertyID = null;
		out = null;
		
	}
	
	/**
	 * 根据商品类型查询最低和最高的商品原价
	 * @return
	 * @throws Exception
	 */
	public void getMaxOrMinCostPriceByGoodsCategory() throws Exception {

		
	
	}
	
	/**
	 * 初始化套餐查询
	 * @return
	 * @throws Exception
	 */
	public String initSelSetMealReportOpen() throws Exception {
		
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

		/*systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "setMealSel";
		}*/
		
		return SUCCESS;
	}
	
	/**
	 * 套餐查询
	 * @return
	 * @throws Exception
	 */
	public String selSetMealReportOpen() throws Exception {
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
		
		String setMealTitle = Utility.getName(request.getParameter("setMealTitle"));
		String cstartTime = Utility.getName(request.getParameter("cstartTime"));
		String cendTime = Utility.getName(request.getParameter("cendTime"));
		String sstartTime = Utility.getName(request.getParameter("sstartTime"));
		String sendTime = Utility.getName(request.getParameter("sendTime"));
		String setMealClassif = Utility.getName(request.getParameter("setMealClassif"));
		String auditstate = Utility.getName(request.getParameter("auditstate"));
		String isenabled = Utility.getName(request.getParameter("isenabled"));
		
		request.setAttribute("setMealTitle",setMealTitle);
		request.setAttribute("cstartTime",cstartTime);
		request.setAttribute("cendTime",cendTime);
		request.setAttribute("sstartTime",sstartTime);
		request.setAttribute("sendTime",sendTime);
		request.setAttribute("setMealClassif",setMealClassif);
		request.setAttribute("auditstate",auditstate);
		request.setAttribute("isenabled",isenabled);
		
		setMealPo = new SetMealPo();
		setMealPo.setSsmsmclassify(setMealClassif);
		setMealPo.setSsmsmcreatebegindate(cstartTime);
		setMealPo.setSsmsmcreateenddate(cendTime);
		setMealPo.setSsmsmeffectivebegindate(sstartTime);
		setMealPo.setSsmsmeffectiveenddate(sendTime);
		setMealPo.setSsmsmtitle(setMealTitle);
		setMealPo.setSsmsmauditstate(auditstate);
		setMealPo.setSsmsmisenabled(isenabled);
		
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
		
		int count = setMealMgr.getSetMealCount(setMealPo);
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
			setMealList = setMealMgr.getSetMealList(setMealPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			setMealList = null;
		}
	
		return SUCCESS;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public SetMealPo getSetMealPo() {
		return setMealPo;
	}

	public void setSetMealPo(SetMealPo setMealPo) {
		this.setMealPo = setMealPo;
	}
	public SetMealEntryPo getSetMealEntryPo() {
		return setMealEntryPo;
	}

	public void setSetMealEntryPo(SetMealEntryPo setMealEntryPo) {
		this.setMealEntryPo = setMealEntryPo;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public DepartmentsPo getDepartmentsPo() {
		return departmentsPo;
	}

	public void setDepartmentsPo(DepartmentsPo departmentsPo) {
		this.departmentsPo = departmentsPo;
	}

	public List<DepartmentsPo> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<DepartmentsPo> departmentList) {
		this.departmentList = departmentList;
	}

	public SetMealMgr getSetMealMgr() {
		return setMealMgr;
	}

	public void setSetMealMgr(SetMealMgr setMealMgr) {
		this.setMealMgr = setMealMgr;
	}

	public List<SetMealPo> getSetMealList() {
		return setMealList;
	}

	public void setSetMealList(List<SetMealPo> setMealList) {
		this.setMealList = setMealList;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	public List<RefractiveSetPo> getRefractiveSetList() {
		return refractiveSetList;
	}

	public void setRefractiveSetList(List<RefractiveSetPo> refractiveSetList) {
		this.refractiveSetList = refractiveSetList;
	}

	public List<GoodsInfoPo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsInfoPo> goodsList) {
		this.goodsList = goodsList;
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

	public List<SetMealEntryPo> getSalesGoodsArrayList() {
		return salesGoodsArrayList;
	}

	public void setSalesGoodsArrayList(List<SetMealEntryPo> salesGoodsArrayList) {
		this.salesGoodsArrayList = salesGoodsArrayList;
	}

	public List<SetMealEntryPo> getCreditGoodsArrayList() {
		return creditGoodsArrayList;
	}

	public void setCreditGoodsArrayList(List<SetMealEntryPo> creditGoodsArrayList) {
		this.creditGoodsArrayList = creditGoodsArrayList;
	}

	public SetMealEntryTempPo getSalesGoodsArray() {
		return salesGoodsArray;
	}

	public void setSalesGoodsArray(SetMealEntryTempPo salesGoodsArray) {
		this.salesGoodsArray = salesGoodsArray;
	}

	public SetMealEntryTempPo getCreditGoodsArray() {
		return creditGoodsArray;
	}

	public void setCreditGoodsArray(SetMealEntryTempPo creditGoodsArray) {
		this.creditGoodsArray = creditGoodsArray;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	public IntegralPo getIntegralPo() {
		return integralPo;
	}

	public void setIntegralPo(IntegralPo integralPo) {
		this.integralPo = integralPo;
	}

	public List<IntegralPo> getIntegralList() {
		return integralList;
	}

	public void setIntegralList(List<IntegralPo> integralList) {
		this.integralList = integralList;
	}

	public TeachnologyTypeMgr getTeachnologyTypeMgr() {
		return teachnologyTypeMgr;
	}

	public void setTeachnologyTypeMgr(TeachnologyTypeMgr teachnologyTypeMgr) {
		this.teachnologyTypeMgr = teachnologyTypeMgr;
	}

	public List<TeachnologyTypePo> getTeachnologyTypeList() {
		return teachnologyTypeList;
	}

	public void setTeachnologyTypeList(List<TeachnologyTypePo> teachnologyTypeList) {
		this.teachnologyTypeList = teachnologyTypeList;
	}

	
}
