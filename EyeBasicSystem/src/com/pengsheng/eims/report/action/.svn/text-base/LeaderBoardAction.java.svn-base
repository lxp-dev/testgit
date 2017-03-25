package com.pengsheng.eims.report.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.report.mgr.LeaderBoardMgr;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class LeaderBoardAction extends BaseAction {
	
	private List<DepartmentsPo> departmentsList;
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private LeaderBoardMgr leaderBoardMgr;
	private List<GoodsCategoryPo> goodsCategoryList;
	private VarietyMgr varietyMgr;	
	private List<CompanyNamePo> companyNamePos;
	private CompanyNameMgr companyNameMgr;
	
	public List<CompanyNamePo> getCompanyNamePos() {
		return companyNamePos;
	}

	public void setCompanyNamePos(List<CompanyNamePo> companyNamePos) {
		this.companyNamePos = companyNamePos;
	}

	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}

	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
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

	private List<GoodsCategoryPo> goodsCategorys; 
	/**
	 * 经营流水统计表
	 */
	public String initEachStoreBusinessLog() throws Exception{
		
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
		
   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));
		
		return SUCCESS;
	}
	
	/**
	 * 年汇总表
	 */
	public String initYearCollectSel() throws Exception{
		
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
		
   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));
		
	    DepartmentsPo po = new DepartmentsPo();
	    po.setBdptype("1");
	    po.setBdpisclosed("0");
	    
	    if (personInfoPo.getDepartmenttype().equals("1")){
	    	po.setBdpdepartmentid(personInfoPo.getDepartmentID());
	    }
	    if (personInfoPo.getDepartmenttype().equals("2")){
	    	po.setBdpregid(personInfoPo.getDepartmentID());
	    }
	    departmentsList = leaderBoardMgr.getDepartmentList(po);
	    
	    companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
	    
		return SUCCESS;
	}
	
	/**
	 * 制造商排名表
	 */
	public String initLeaderSupplierRankingSel() throws Exception{
		
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
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
				
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
	    DepartmentsPo po = new DepartmentsPo();
	    po.setBdptype("1");
	    po.setBdpisclosed("0");
	    
	    if (personInfoPo.getDepartmenttype().equals("1")){
	    	po.setBdpdepartmentid(personInfoPo.getDepartmentID());
	    }
	    if (personInfoPo.getDepartmenttype().equals("2")){
	    	po.setBdpregid(personInfoPo.getDepartmentID());
	    }
	    departmentsList = leaderBoardMgr.getDepartmentList(po);
	    
	    goodsCategoryList = leaderBoardMgr.getGoodsCategoryList();
	    
		return SUCCESS;
	}
	
	/**
	 * 特殊折扣表
	 */
	public String initSpecialDiscountSel() throws Exception{
		
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
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
	    DepartmentsPo po = new DepartmentsPo();
	    po.setBdptype("1");
	    po.setBdpisclosed("0");
	    
	    if (personInfoPo.getDepartmenttype().equals("1")){
	    	po.setBdpdepartmentid(personInfoPo.getDepartmentID());
	    }
	    if (personInfoPo.getDepartmenttype().equals("2")){
	    	po.setBdpregid(personInfoPo.getDepartmentID());
	    }
	    departmentsList = leaderBoardMgr.getDepartmentList(po);
	    
		String[] strArray = super.getReportDefultDate(systemParameterPo);		
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		return SUCCESS;
	}
	
	/**
	 * 门店销售业绩统计表
	 */
	public String initStoreSalesResultsSel() throws Exception{
		
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
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
	    
		return SUCCESS;
	}
	
	/**
	 * 商品进销存表
	 */
	public String initGoodsInOrOutStorageSel() throws Exception{
		
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
	
	/**
	 * 各店独立核算报表
	 */
	public String initEachStoreAloneCheck() throws Exception{
		
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
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		departmentsList = leaderBoardMgr.getEachStoreList();
		
		return SUCCESS;
	}
	
	/**
	 * 销售业绩分析对比报表
	 */
	public String selectXsyjfxdb() throws Exception{
		
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
	 * 制造商销售业绩排名报表
	 */
	public String selectGysxsyjpm() throws Exception{
		
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
	 * 框镜销售区间分析表
	 */
	public String initFrameSalesAreaAnalysisSel() throws Exception{
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
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
	    
		return SUCCESS;
	}
	
	/**
	 * 存货产品预期销售毛利率统计
	 */
	public String initStorageEstimateSalesGrossProfitRate() throws Exception{
		
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
		
	    goodsCategoryList = leaderBoardMgr.getGoodsCategoryList();
	    systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
	    
		return SUCCESS;
	}
	
	/**
	 * 门店销售收款方式明细表(单店\多店)
	 */
	public String initStoreSalesReceiptFormEntry() throws Exception{
		
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
	 * 收银员交易明细表
	 */
	public String initCashierExchageEntry() throws Exception{	
		
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
	 * 批发销售毛利统计表（客户批发调货）
	 */
	public String initWholesaleGrossStatistics() throws Exception{	
		
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
	 * 制造商进货/退货单据汇总表
	 */
	public String initSupplierInOrOutStorageCollect() throws Exception{	
		
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
		
	    goodsCategoryList = leaderBoardMgr.getGoodsCategoryList();
	    
		return SUCCESS;
	}
	
	/**
	 * 储值卡消费明细表\储值卡流通明细表\储值卡消费汇总表
	 */
	public String initValueCardSalesEntry() throws Exception{	
		
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
	 * 员工销售业绩统计表
	 */
	public String initStaffSalesResultsStatistics() throws Exception{	
		
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
	 * 商品进销存表
	 */
	public String initStorageTurnoverRate() throws Exception{
		
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
		
		if (!Utility.getName(permissionPo.getKeya()).equals("1")){
			return "success2";
		}		
		
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
	 * 销售业绩递增比表
	 */
	public String initSalesResultsIncrementalSel() throws Exception{
		
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
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
	    
		return SUCCESS;
	}
	
	/**
	 * 大光明隐形业绩统计表
	 */
	public String initStealthSalesResultsSel() throws Exception{
		
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
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
	    DepartmentsPo po = new DepartmentsPo();
	    po.setBdptype("1");
	    po.setBdpisclosed("0");
	    departmentsList = leaderBoardMgr.getDepartmentList(po);
	    
		return SUCCESS;
	}
	
	/**
	 * 大光明门店收入统计表
	 */
	public String initStoreSalesIncomeSel() throws Exception{
		
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
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
	    
		return SUCCESS;
	}
	
	/**
	 * 客单统计表(大光明)
	 */
	public String initCustomerStatistical() throws Exception{
		
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
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		return SUCCESS;
	}
	
	public String initYearCollectSelTr() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));
	    
	    companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
	    
		return SUCCESS;
	}
	
	/**
	 *  促销费用表
	 */
	public String initBrandPromotionSel() throws Exception{
		
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
		
		return SUCCESS;
	}
	
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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

	public LeaderBoardMgr getLeaderBoardMgr() {
		return leaderBoardMgr;
	}

	public void setLeaderBoardMgr(LeaderBoardMgr leaderBoardMgr) {
		this.leaderBoardMgr = leaderBoardMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategoryList() {
		return goodsCategoryList;
	}

	public void setGoodsCategoryList(List<GoodsCategoryPo> goodsCategoryList) {
		this.goodsCategoryList = goodsCategoryList;
	}
		
}
