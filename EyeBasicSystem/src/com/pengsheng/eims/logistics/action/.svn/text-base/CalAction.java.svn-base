package com.pengsheng.eims.logistics.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.mgr.CalMgr;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.mgr.VoucherMgr;
import com.pengsheng.eims.logistics.persistence.AutoCostAccountPo;
import com.pengsheng.eims.logistics.persistence.LCTCostingTempPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class CalAction extends BaseAction {

	private LogisticsLogMgr logisticsLogMgr = null;	
	private PersonPermissionMgr personPermissionMgr = null;	
	private CalMgr calMgr;	
	private List<LCTCostingTempPo> resultList;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private VoucherMgr voucherMgr = null;
	private List<GoodsCategoryPo> goodsCategoryList = null;
	private String isFirstExec;
	private BrandMgr brandMgr = null;
	private List<InventoryPo> inventoryList = null;
	private InventoryPo inventoryPo = null;
	private List<AutoCostAccountPo> acapList = null;
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
	public List<AutoCostAccountPo> getAcapList() {
		return acapList;
	}
	public void setAcapList(List<AutoCostAccountPo> acapList) {
		this.acapList = acapList;
	}
	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}
	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}
	public List<InventoryPo> getInventoryList() {
		return inventoryList;
	}
	public void setInventoryList(List<InventoryPo> inventoryList) {
		this.inventoryList = inventoryList;
	}
	public String getIsFirstExec() {
		return isFirstExec;
	}
	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}
	public BrandMgr getBrandMgr() {
		return brandMgr;
	}
	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}
	public List<GoodsCategoryPo> getGoodsCategoryList() {
		return goodsCategoryList;
	}
	public void setGoodsCategoryList(List<GoodsCategoryPo> goodsCategoryList) {
		this.goodsCategoryList = goodsCategoryList;
	}
	public VoucherMgr getVoucherMgr() {
		return voucherMgr;
	}
	public void setVoucherMgr(VoucherMgr voucherMgr) {
		this.voucherMgr = voucherMgr;
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
	
	/**
	 * 初始化成本计算
	 * @return
	 * @throws Exception
	 */
	public String initCalSel() throws Exception {
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
		
		getCurrentDate();
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
		String date = "";
		if (Utility.getName(po.getsLvvDateTopLimit()).length() > 0){
			date = Utility.getName(po.getsLvvDateTopLimit()).substring(0,7);
		}else{
			date = Utility.getName(po.getsLvvDateTopLimit());
		}
		request.setAttribute("switchAmountMonth",date);	

		if (Utility.getName(permissionPo.getKeyd()).equals("1")){
			acapList = voucherMgr.selectAutoCostAccountList(personInfoPo.getPersoncompanyid(),systemParameterPo);
		}		
		
		// 获取期初账期
		String companyID = personInfoPo.getPersoncompanyid();
		if (Utility.getName(systemParameterPo.getFspcbjstype()).equals("1")){
			companyID = "";
		}
		request.setAttribute("qcAccountPeriod", voucherMgr.getCurrentAccountPeriodByDate(companyID));
		
		return SUCCESS;
	}

	private void getCurrentDate(){
   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));
	}
	
	/**
	 * 加权平均
	 * @return
	 * @throws Exception
	 */
	public String realCalStorage() throws Exception {

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
		
		String currDate = Utility.getName(request.getParameter("currDate"));
		String lastDate = Utility.getName(request.getParameter("lastDate"));
		String isAvgCal = Utility.getName(request.getParameter("isAvgCal"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());

		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");   // 
		logPo.setsLogContent("加权平均计算时间：" + currDate);		
		logisticsLogMgr.insertLog(logPo);  //新增日志

		getCurrentDate();
		request.setAttribute("date", currDate);
		
		int count = calMgr.selCurrentDate(lastDate);
		if (count > 0){
			calMgr.insertRealCalStorage(currDate,logPo);
		}else{	
			
			this.clearMessages();
			this.addActionMessage(getText("无法进行成本计算!"));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
		
		request.setAttribute("isAvgCal",isAvgCal);
		
		this.clearMessages();
		this.addActionMessage(getText("加权平均计算完毕!"));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}
	
	/**
	 * 计算单位成本
	 * @return
	 * @throws Exception
	 */
	public String moniCalRetrun() throws Exception {

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
	
		String date = Utility.getName(request.getParameter("date"));
		String isCostCal = Utility.getName(request.getParameter("isCostCal"));
		String isAvgCal = Utility.getName(request.getParameter("isAvgCal"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");   // 
		logPo.setsLogContent("计算单位成本时间：" + date);		
		logisticsLogMgr.insertLog(logPo);  //新增日志
		
		calMgr.insertMoniCalRetrun(logPo);
		getCurrentDate();
		
		this.clearMessages();
		this.addActionMessage(getText("单位成本计算完毕!"));
		
		request.setAttribute("date", date);
		request.setAttribute("isCostCal", isCostCal);		
		request.setAttribute("isAvgCal",isAvgCal);
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}
	
	/**
	 * 成本回填
	 * @return
	 * @throws Exception
	 */
	public String realCalReturn() throws Exception {

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
		
		String date=Utility.getName(request.getParameter("date"));	
		getCurrentDate();
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());

		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");
		logPo.setsLogContent("单位成本回填时间：" + date);		
		logisticsLogMgr.insertLog(logPo);  //新增日志
		
		//回填
		calMgr.insertRealCalRetrun(date,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("单位成本回填完毕!"));
		request.setAttribute("date", date);
		request.setAttribute("flag", GlobalConstants.UPADTE);
		return SUCCESS;
	}
	
	/**
	 * 初始化加权平均计算
	 * @return
	 * @throws Exception
	 */
	public String initWeightingCal() throws Exception {
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
		
		getCurrentDate();
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");   // 
		logPo.setsLogContent("初始化加权平均计算!");
		
		calMgr.updateWeightingCal(logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("初始化加权平均计算完毕!"));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}
	
	public String moniSelect() throws Exception {
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
		
		getCurrentDate();
		
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String year = Utility.getName(request.getParameter("year"));
		String month = Utility.getName(request.getParameter("month"));
		String companyID = Utility.getName(request.getParameter("companyID"));
		
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("companyID", companyID);
		
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodscategoryid(goodsCategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);	
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		if (!year.equals("") && !month.equals("")){
			goodsInfoPo.setSettleaccountsdate(year+"-"+month);
		}
		goodsInfoPo.setBgicompanyid(companyID);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		int count=calMgr.getResultCount(goodsInfoPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
				
		    Pagination page = new Pagination(request, count, perPage);
		    resultList=calMgr.getResultList(goodsInfoPo,page.getStart(),page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			resultList = null;
		}

		goodsCategoryList = brandMgr.getGoodsCategorys();
		
    	CompanyNamePo cpo = new CompanyNamePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
		}
    	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
		
		return SUCCESS;
	}
	
	public String initMoniSelect() throws Exception {
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
		
		getCurrentDate();		
		goodsCategoryList = brandMgr.getGoodsCategorys();
		
    	CompanyNamePo cpo = new CompanyNamePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
		}
    	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
		
		return SUCCESS;
	}
	
	public String initAutoCostAccount() throws Exception {
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
			
		String dqmonth = Utility.getName(request.getParameter("dqmonth"));
		request.setAttribute("dqmonth",dqmonth);
		
		return SUCCESS;
	}
	
	/**
	 * 自动进行加权平均计算
	 * @return
	 * @throws Exception
	 */
	public String insertAutoCostAccount() throws Exception {
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
		
		getCurrentDate();
		String dqmonth = Utility.getName(request.getParameter("dqmonth"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");   // 
		
		if (Utility.getName(systemParameterPo.getFspcbjstype()).equals("1")){
			logPo.setsLogContent("【" + dqmonth + "】进行成本计算!");
		}else{
			logPo.setsLogContent("公司：" + personInfoPo.getPersoncompanyid() + "【" + dqmonth + "】进行成本计算!");
		}
			
		List<String> dateList = new ArrayList<String>();            
        dateList.add(dqmonth);

		calMgr.insertAutoCostAccount(personInfoPo.getPersoncompanyid(),dateList,systemParameterPo,logPo);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
		request.setAttribute("switchAmountMonth",Utility.getName(po.getsLvvDateTopLimit()).substring(0,7));	

		if (Utility.getName(permissionPo.getKeyd()).equals("1")){
			acapList = voucherMgr.selectAutoCostAccountList(personInfoPo.getPersoncompanyid(),systemParameterPo);
		}	
		
		// 获取期初账期
		String companyID = personInfoPo.getPersoncompanyid();
		if (Utility.getName(systemParameterPo.getFspcbjstype()).equals("1")){
			companyID = "";
		}
		request.setAttribute("qcAccountPeriod", voucherMgr.getCurrentAccountPeriodByDate(companyID));
		
		this.clearMessages();
		this.addActionMessage(getText("当晚进行加权平均计算!"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化成本计算回填单据查询
	 * @return
	 * @throws Exception
	 */
	public String initCalBillSel() throws Exception {
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
		
		goodsCategoryList = brandMgr.getGoodsCategorys();
		
		if (Utility.getName(permissionPo.getKeya()).equals("1")){
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "calBillSel";
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * 成本计算回填单据查询
	 * @return
	 * @throws Exception
	 */
	public String calBillSel() throws Exception {
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
		
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String billType = Utility.getName(request.getParameter("billType"));
		String billID = Utility.getName(request.getParameter("billID"));
		String createStartTime = Utility.getName(request.getParameter("createStartTime"));
		String createEndTime = Utility.getName(request.getParameter("createEndTime"));		
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime"));
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));
		String fillbillType = Utility.getName(request.getParameter("fillbillType"));
		
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("billType", billType);
		request.setAttribute("billID", billID);
		request.setAttribute("createStartTime", createStartTime);
		request.setAttribute("createEndTime", createEndTime);
		request.setAttribute("auditStartTime", auditStartTime);
		request.setAttribute("auditEndTime", auditEndTime);
		request.setAttribute("createPersonID", createPersonID);
		request.setAttribute("auditPersonID", auditPersonID);
		request.setAttribute("fillbillType", fillbillType);
		
		inventoryPo = new InventoryPo();
		inventoryPo.setCstigoodscategory(goodsCategoryID);
		inventoryPo.setCstisupplierid(supplierID);
		inventoryPo.setCstibrandid(brandID);
		inventoryPo.setCstigoodsid(goodsID);
		inventoryPo.setCstigoodsname(goodsName);
		inventoryPo.setCstibillid(billID);
		inventoryPo.setCstiendTime(createEndTime);
		inventoryPo.setCstistartTime(createStartTime);
		inventoryPo.setCstiauditperson(auditPersonID);
		inventoryPo.setCstibilltypeid(billType);
		inventoryPo.setCsticreateperson(createPersonID);
		inventoryPo.setCstiauditenddate(auditEndTime);
		inventoryPo.setCstiauditstartdate(auditStartTime);
		inventoryPo.setCstiisfillcostprice(fillbillType);
		
		goodsCategoryList = brandMgr.getGoodsCategorys();
		
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

		int count = calMgr.getCostResultBillCount(inventoryPo);
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
			inventoryList = calMgr.getCostResultBillList(inventoryPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			inventoryList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化，只进行成本计算，不回填单据
	 */
	public String initCostAccountNotBill() throws Exception {
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
		
		String dqmonth = Utility.getName(request.getParameter("dqmonth"));
		request.setAttribute("dqmonth",dqmonth);
		
		return SUCCESS;
	}
	
	/**
	 * 只进行成本计算，不回填单据
	 */
	public String insertCostAccountNotBill() throws Exception {
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
		
		getCurrentDate();
		String dqmonth = Utility.getName(request.getParameter("dqmonth"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");   // 
		
		if (Utility.getName(systemParameterPo.getFspcbjstype()).equals("1")){
			logPo.setsLogContent("【" + dqmonth + "】计算加权平均成本!");
		}else{
			logPo.setsLogContent("公司：" + personInfoPo.getPersoncompanyid() + "【" + dqmonth + "】计算加权平均成本!");
		}

		List<String> dateList = new ArrayList<String>();	   
        dateList.add(dqmonth);

        calMgr.insertAutoCostAccount(personInfoPo.getPersoncompanyid(),dateList,systemParameterPo,null);
        
		calMgr.insertCostAccountNotBill(personInfoPo.getPersoncompanyid(),systemParameterPo,logPo);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
		request.setAttribute("switchAmountMonth",Utility.getName(po.getsLvvDateTopLimit()).substring(0,7));	

		if (Utility.getName(permissionPo.getKeyd()).equals("1")){
			acapList = voucherMgr.selectAutoCostAccountList(personInfoPo.getPersoncompanyid(),systemParameterPo);
		}
		
		// 获取期初账期
		String companyID = personInfoPo.getPersoncompanyid();
		if (Utility.getName(systemParameterPo.getFspcbjstype()).equals("1")){
			companyID = "";
		}
		request.setAttribute("qcAccountPeriod", voucherMgr.getCurrentAccountPeriodByDate(companyID));
				
		this.clearMessages();
		this.addActionMessage(getText("计算加权平均成本成功!"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化，立即执行进行成本计算，并回填单据
	 */
	public String initCostAccountBill() throws Exception {
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
				
		String dqmonth = Utility.getName(request.getParameter("dqmonth"));
		request.setAttribute("dqmonth",dqmonth);
		
		return SUCCESS;
	}
	
	/**
	 * 立即执行进行成本计算，并回填单据
	 */
	public String insertCostAccountBill() throws Exception {
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
		
		getCurrentDate();
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");   // 
		logPo.setsLogContent("立即进行加权平均计算!");
		
		String dqmonth = Utility.getName(request.getParameter("dqmonth"));
		
		List<String> dateList = new ArrayList<String>();
        dateList.add(dqmonth);

        calMgr.insertAutoCostAccount(personInfoPo.getPersoncompanyid(),dateList,systemParameterPo,null);
        
		calMgr.insertCostAccountBill(personInfoPo.getPersoncompanyid(),systemParameterPo,logPo);
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());
		request.setAttribute("switchAmountMonth",Utility.getName(po.getsLvvDateTopLimit()).substring(0,7));	

		if (Utility.getName(permissionPo.getKeyd()).equals("1")){
			acapList = voucherMgr.selectAutoCostAccountList(personInfoPo.getPersoncompanyid(),systemParameterPo);
		}	
		
		// 获取期初账期
		String companyID = personInfoPo.getPersoncompanyid();
		if (Utility.getName(systemParameterPo.getFspcbjstype()).equals("1")){
			companyID = "";
		}
		request.setAttribute("qcAccountPeriod", voucherMgr.getCurrentAccountPeriodByDate(companyID));
				
		this.clearMessages();
		this.addActionMessage(getText("计算成功!"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				
		return SUCCESS;
	}
	
	/**
	 * 初始化   --- 初始化账期
	 */
	public String initAccountPeriodSet() throws Exception {
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
	
    	CompanyNamePo cpo = new CompanyNamePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
		}
    	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
    	
		return SUCCESS;
	}
	
	/**
	 * 初始化账期
	 */
	public String updateAccountPeriodSet() throws Exception {
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
		
    	CompanyNamePo cpo = new CompanyNamePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
		}
    	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
		
		String year = Utility.getName(request.getParameter("year"));
		String month = Utility.getName(request.getParameter("month"));
		String companyID = Utility.getName(request.getParameter("companyID"));
    	
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");   // 
		logPo.setsLogContent("公司：【" + companyID + "】" + "的账期初始化为：【" + year + "-" + month + "】!");
		
		calMgr.updateAccountPeriodSet(companyID, year, month, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("更新成功!"));
		request.setAttribute("flag", GlobalConstants.MOVE);
	
		return SUCCESS;
	}
		
	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}
	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public List<LCTCostingTempPo> getResultList() {
		return resultList;
	}
	public void setResultList(List<LCTCostingTempPo> resultList) {
		this.resultList = resultList;
	}
	public CalMgr getCalMgr() {
		return calMgr;
	}
	public void setCalMgr(CalMgr calMgr) {
		this.calMgr = calMgr;
	}	

}
