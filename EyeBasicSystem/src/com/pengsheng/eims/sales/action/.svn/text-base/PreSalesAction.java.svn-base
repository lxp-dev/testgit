package com.pengsheng.eims.sales.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.PreSalesMgr;
import com.pengsheng.eims.sales.persistence.PreBrandPo;
import com.pengsheng.eims.sales.persistence.PreDepPo;
import com.pengsheng.eims.sales.persistence.PrePersonSalesPo;
import com.pengsheng.eims.sales.persistence.PrePlanPo;
import com.pengsheng.eims.sales.persistence.PreSalesPo;
import com.pengsheng.eims.sales.persistence.PreShopSalesPo;
import com.pengsheng.eims.sales.persistence.PreShopSalesTempPo;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class PreSalesAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	private PreSalesMgr preSalesMgr;
	private PreSalesPo preSalesPo;
	private PrePlanPo prePlanPo;
	private PreDepPo preDepPo;
	private PreBrandPo preBrandPo;
	private List<PrePlanPo> prePlanPoList;
	private List<PreDepPo> preDepPoList;
	private List<PreBrandPo> preBrandPoList;
	private List<PreSalesPo> preSalesPoList;
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private DepartmentsMgr departmentsMgr;
	private List<DepartmentsPo> departmentsList;
	private String isFirstExec;
	private CustomerInfoPo customerInfoPo;
	private CustomerInfoMgr customerInfoMgr;
	private List<PersonInfoPo> salers;
	private List<PersonInfoPo> posers;
	private PersonInfoMgr personInfoMgr;
	private List<PreShopSalesPo> preShopSalesList;
	private PreShopSalesPo preShopSalesPo;
	private PrePersonSalesPo prePersonSalesPo;
	private PreShopSalesTempPo preShopSalesTempPo;
	private List<PrePersonSalesPo> prePersonSalesList;
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

	public PrePersonSalesPo getPrePersonSalesPo() {
		return prePersonSalesPo;
	}

	public void setPrePersonSalesPo(PrePersonSalesPo prePersonSalesPo) {
		this.prePersonSalesPo = prePersonSalesPo;
	}

	public List<PrePersonSalesPo> getPrePersonSalesList() {
		return prePersonSalesList;
	}

	public void setPrePersonSalesList(List<PrePersonSalesPo> prePersonSalesList) {
		this.prePersonSalesList = prePersonSalesList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 初始化门店预销售设置查询
	 */
	public String initSetPreSales() {
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
		departmentsList = departmentsMgr.getDepartments("1", "0");
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selSetPreSales";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 门店预销售设置查询
	 */
	public String selSetPreSales() {
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
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		departmentsList = departmentsMgr.getDepartments("1", "0");	
		
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
		
		if(null != preSalesPo && !"".equals(Utility.getName(preSalesPo.getDepartmentId()))) {
			preSalesPo.setDepartmentIds(preSalesPo.getDepartmentId().split(","));
		}

		int count = preSalesMgr.getPreSalesPoListCount(preSalesPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request
						.getParameter("perPage")).intValue();
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
			preSalesPoList = preSalesMgr.getPreSalesPoList(preSalesPo, page.getStart(), page.getPageSize());
		
			request.setAttribute(Pagination.PAGINATION, page);
		} 
		return SUCCESS;
	}
	
	/**
	 * 初始化门店预销售设置新增
	 */
	public String initInsertSetPreSales() {
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
		departmentsList = departmentsMgr.getDepartments("1", "0");
		
		if(null != prePlanPo && !"".equals(Utility.getName(prePlanPo.getPlanId()))) {
			prePlanPo = preSalesMgr.getPrePlanPo(prePlanPo);
			preDepPoList = preSalesMgr.getPreDepPoList(prePlanPo);
		}
		
		if(null != preDepPoList && preDepPoList.size() > 0) {
			preBrandPoList = preSalesMgr.getPreBrandPoList(preDepPoList.get(0));
		}
		
		return SUCCESS;
	}
	
	/**
	 * 门店预销售设置新增
	 */
	public String insertSetPreSales() {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		
		departmentsList = departmentsMgr.getDepartments("1", "0");
		preSalesPoList = new ArrayList<PreSalesPo>();
		StringBuffer preSalesIds = new StringBuffer();
		
//		List<PreSalesPo> repeatPreSalesPoList = preSalesMgr.getIntersectionPreSalesList(preSalesPo);
//		
//		if(null != repeatPreSalesPoList && repeatPreSalesPoList.size() > 0) {
//			this.clearMessages();
//			this.addActionMessage("设置时间段有冲突,请核对!");
//			return "repeat";
//		}
		preDepPoList = new ArrayList<PreDepPo>();
		preBrandPoList = new ArrayList<PreBrandPo>();
		if(null != preSalesPo && null != preSalesPo.getDepartmentIds()) {
			for (int departmentIndex = 0; departmentIndex < preSalesPo.getDepartmentIds().length; departmentIndex++) {
				
				PreDepPo tempDepPo = new PreDepPo();
				
				tempDepPo.setPrePlanDepId(UUIDHexGenerator.getInstance().generate());
				tempDepPo.setPrePlanId(prePlanPo.getPlanId());
				tempDepPo.setPreDepId(preSalesPo.getDepartmentIds()[departmentIndex]);
				preDepPoList.add(tempDepPo);
					
				for(int brandIndex = 0; brandIndex < preSalesPo.getBrandIds().length; brandIndex++) {
					
					PreBrandPo tempBrandPo = new PreBrandPo();
					
					tempBrandPo.setPreBrandId(UUIDHexGenerator.getInstance().generate());
					tempBrandPo.setPreDepId(tempDepPo.getPrePlanDepId());
					tempBrandPo.setSupplierAndBrandId(preSalesPo.getSupplierAndBrandIds()[brandIndex]);
					tempBrandPo.setBrandId(preSalesPo.getBrandIds()[brandIndex]);
					tempBrandPo.setSupplierId(preSalesPo.getSupplierIds()[brandIndex]);
					tempBrandPo.setSalesQuantity(preSalesPo.getSalesQuantities()[brandIndex]);
					
					preBrandPoList.add(tempBrandPo);
					
					PreSalesPo tempPreSalesPo = new PreSalesPo();
					
					tempPreSalesPo.setPreSalesId(UUIDHexGenerator.getInstance().generate());
					tempPreSalesPo.setDepartmentId(preSalesPo.getDepartmentIds()[departmentIndex]);
					tempPreSalesPo.setBrandId(preSalesPo.getBrandIds()[brandIndex]);
					tempPreSalesPo.setSupplierId(preSalesPo.getSupplierIds()[brandIndex]);
					tempPreSalesPo.setStartDate(preSalesPo.getStartDate());
					tempPreSalesPo.setEndDate(preSalesPo.getEndDate());
					tempPreSalesPo.setSalesQuantity(preSalesPo.getSalesQuantities()[brandIndex]);
					tempPreSalesPo.setAddedPersonId(personInfoPo.getId());
					tempPreSalesPo.setBrandName(preSalesPo.getBrandNames()[brandIndex]);
					tempPreSalesPo.setSupplierName(preSalesPo.getSupplierNames()[brandIndex]);
					tempPreSalesPo.setSupplierAndBrandId(preSalesPo.getSupplierAndBrandIds()[brandIndex]);
					
					preSalesPoList.add(tempPreSalesPo);
					preSalesIds.append(tempPreSalesPo.getPreSalesId());
				}
			}
		}
		logPo.setsLogContent("门店预销售设置:" + preSalesIds + "新增!");
		
		if(preSalesPoList.size() > 0) {
			preSalesMgr.insertPreDepPoAndPreBrandPo(preDepPoList, preBrandPoList);
		}
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化门店预销售设置修改
	 */
	public String initUpdateSetPreSales() {
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
		String planId = Utility.getName(request.getParameter("planId"));
		
		prePlanPo = new PrePlanPo();
		prePlanPo.setPlanId(planId);
		
		prePlanPo = preSalesMgr.getPrePlanPo(prePlanPo);
		preDepPoList = preSalesMgr.getPreDepPoList(prePlanPo);
		
		if(null != preDepPoList && preDepPoList.size() > 0) {
			if(null == preDepPo) {
				preDepPo = preDepPoList.get(0);
			}
			preBrandPoList = preSalesMgr.getPreBrandPoList(preDepPo);
		}
		request.setAttribute("planId", planId);
		return SUCCESS;
	}
	
	/**
	 * 门店预销售设置修改
	 */
	public String updateSetPreSales() {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("门店预销售设置,单店修改:" + preDepPo.getPreDepId() + "修改!");
		
		preBrandPoList = new ArrayList<PreBrandPo>();
		for (int i = 0; i < preBrandPo.getBrandIds().length; i++) {
			PreBrandPo tempPo = new PreBrandPo();
			
			tempPo.setPreBrandId(UUIDHexGenerator.getInstance().generate());
			tempPo.setPreDepId(preDepPo.getPreDepId());
			tempPo.setBrandId(preBrandPo.getBrandIds()[i]);
			tempPo.setSupplierId(preBrandPo.getSupplierIds()[i]);
			tempPo.setSalesQuantity(preBrandPo.getSalesQuantitys()[i]);
			tempPo.setSupplierAndBrandId(preBrandPo.getSupplierAndBrandIds()[i]);
			
			preBrandPoList.add(tempPo);
		}
		//清空
		preSalesMgr.deletePreBrandPoByPreDepPoId(preDepPo);
		//新增
		preSalesMgr.insertPreBrandPoList(preBrandPoList);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化门店预销售设置修改
	 */
	public String initDetailPreSales() {
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
		String planId = Utility.getName(request.getParameter("planId"));
		
		prePlanPo = new PrePlanPo();
		prePlanPo.setPlanId(planId);
		
		prePlanPo = preSalesMgr.getPrePlanPo(prePlanPo);
		preDepPoList = preSalesMgr.getPreDepPoList(prePlanPo);
		
		if(null != preDepPoList && preDepPoList.size() > 0) {
			if(null == preDepPo) {
				preDepPo = preDepPoList.get(0);
			}
			preBrandPoList = preSalesMgr.getPreBrandPoList(preDepPo);
		}
		request.setAttribute("planId", planId);
		return SUCCESS;
	}
	
	/**
	 * 初始化门店预销售设置删除
	 */
	public String initDeleteSetPreSales() {
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

//		preSalesPo = preSalesMgr.getPreSalesPo(preSalesPo);
		prePlanPo = preSalesMgr.getPrePlanPo(prePlanPo);
		
		return SUCCESS;
	}
	
	/**
	 * 门店预销售设置删除
	 */
	public String deleteSetPreSales() {
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
		
		preDepPoList = preSalesMgr.getPreDepPoList(prePlanPo);
		
		for (PreDepPo temp : preDepPoList) {
			preSalesMgr.deletePreBrandPoByPreDepPoId(temp);
		}
		preSalesMgr.deletePreDepPoList(preDepPoList);
		preSalesMgr.deletePrePlanPo(prePlanPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	/**
	 * 初始化预销售门店删除
	 */
	public String initDeletePreDep() {
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

//		preSalesPo = preSalesMgr.getPreSalesPo(preSalesPo);
		preDepPo = preSalesMgr.getPreDepPo(preDepPo);
		
		return SUCCESS;
	}
	
	/**
	 * 预销售门店删除
	 */
	public String deletePreDep() {
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
		
		//删除门店下的品种
		preSalesMgr.deletePreBrandPoByPreDepPoId(preDepPo);
		//删除门店
		preSalesMgr.deletePreDepPo(preDepPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化批量修改
	 * @return
	 */
	public String initBatchUpdatePreSales() {
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

		String ids = request.getParameter("ids");
		
		request.setAttribute("ids", ids);
		
		return SUCCESS;
	}
	
	/**
	 * 批量修改
	 * @return
	 */
	public String batchUpdatePreSales() {
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

		String ids = request.getParameter("ids");
		
		String[] preSalesIds = ids.split(",");
		for (int i = 0; i < preSalesIds.length; i++) {
			preSalesMgr.updatePreSalesPoQuantity(preSalesIds[i], preSalesPo.getSalesQuantity());
		}

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	/**
	 * 初始化批量删除
	 * @return
	 */
	public String initBatchDeletePreSales() {
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
		
		String ids = request.getParameter("ids");
		request.setAttribute("ids", ids);
		
		return SUCCESS;
	}

	/**
	 * 批量修改
	 * @return
	 */
	public String batchDeletePreSales() {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		
		String ids = request.getParameter("ids");
		
		String[] preSalesPoIds = ids.split(",");
		
		for (int i = 0; i < preSalesPoIds.length; i++) {
			PreSalesPo tempPo = new PreSalesPo();
			tempPo.setPreSalesId(preSalesPoIds[i]);
			logPo.setsLogContent("门店预销售设置:" + tempPo.getPreSalesId() + "批量删除!");
			preSalesMgr.deletePreSales(tempPo, logPo);
		}

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	

	/**
	 * 初始化查询计划名称表
	 */
	public String initSelPrePlan() {
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
			return "selPrePlan";
		}
//		request.setAttribute("overdue", prePlanPo.getOverdue());
		return SUCCESS;
	}
	
	/**
	 * 查询计划名称表
	 */
	public String selPrePlan() {
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
		
		int count = preSalesMgr.getPrePlanPoListCount(prePlanPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request
						.getParameter("perPage")).intValue();
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
			prePlanPoList = preSalesMgr.getPrePlanPoList(prePlanPo, page.getStart(), page.getPageSize());
		
			request.setAttribute(Pagination.PAGINATION, page);
		}
		return SUCCESS;
	}
	
	/**
	 * 查询计划名称表
	 */
	public String selPrePlanOpen() {
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
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		if(null == prePlanPo) {
			prePlanPo = new PrePlanPo();
		}
		prePlanPo.setOverdue("0");
		
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
		
		int count = preSalesMgr.getPrePlanPoListCount(prePlanPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request
						.getParameter("perPage")).intValue();
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
			prePlanPoList = preSalesMgr.getPrePlanPoList(prePlanPo, page.getStart(), page.getPageSize());
		
			request.setAttribute(Pagination.PAGINATION, page);
		}
		return SUCCESS;
	}
	
	/**
	 * 查询计划名称表(报表开窗)
	 */
	public String selPrePlanOpenForRpt() {
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
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		if(null == prePlanPo) {
			prePlanPo = new PrePlanPo();
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
		}
		
		int count = preSalesMgr.getPrePlanPoListCount(prePlanPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request
						.getParameter("perPage")).intValue();
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
			prePlanPoList = preSalesMgr.getPrePlanPoList(prePlanPo, page.getStart(), page.getPageSize());
		
			request.setAttribute(Pagination.PAGINATION, page);
		}
		return SUCCESS;
	}
	
	/**
	 * 计划销售表选择
	 * @return
	 */
	public String prePlanOpenSelect() {
		prePlanPo = preSalesMgr.getPrePlanPo(prePlanPo);
		preDepPoList = preSalesMgr.getPreDepPoList(prePlanPo);
		
		if(null != preDepPoList && preDepPoList.size() > 0) {
			preBrandPoList = preSalesMgr.getPreBrandPoList(preDepPoList.get(0));
		}

		this.clearMessages();
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化新增计划名称表
	 */
	public String initInsertPrePlan() {
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
	 * 新增计划名称表
	 */
	public String insertPrePlan() {
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
		prePlanPo.setPlanId(UUIDHexGenerator.getInstance().generate());
		
		preSalesMgr.insertPrePlanPo(prePlanPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化修改计划名称表
	 */
	public String initUpdatePrePlan() {
		//TODO
		
		return SUCCESS;
	}
	
	/**
	 * 新增修改名称表
	 */
	public String updatePrePlan() {
		//TODO
		
		return SUCCESS;
	}

	/**
	 * 初始化修改计划名称表
	 */
	public String initDelPrePlan() {
		//TODO
		
		return SUCCESS;
	}
	
	/**
	 * 新增修改名称表
	 */
	public String delPrePlan() {
		//TODO
		
		return SUCCESS;
	}
	
	public String initInsertPreSalesS() {
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
		
		request.setAttribute("moduleID", moduleID);
		
		 //判断跳转哪个界面
		String isGO = Utility.getName(request.getParameter("isGO"));
		if("".equals(isGO)){
		if("2".equals(systemParameterPo.getFsphisflag())){//系统连接HIS
			
			if("0".equals(personInfoPo.getBdplinkhisflag())&&"initSCIHISsaomaWin.action".equals(personInfoPo.getBdpreadcardform())){
				request.setAttribute("isGO","0");//现有是界面
			}else{
				request.setAttribute("isGO","1");//读卡扫码界面
			}
		}else if("0".equals(systemParameterPo.getFsphisflag())){//系统不连接HIS
			
			 if("initSCIHISsaomaWin.action".equals(personInfoPo.getBdpreadcardform())){
				 request.setAttribute("isGO","0");//现有是界面
			 }else{
				 request.setAttribute("isGO","1");//读卡界面
			 }
		}
		}
		return SUCCESS;
	}

	public String initInsertPreSalesCustomerS() {
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

		if (StringUtils.isNotEmpty(request.getParameter("memberid"))) {
			
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			
			// 查询顾客信息
			CustomerInfoPo customerInfoPo1 = new CustomerInfoPo();
			customerInfoPo1.setSmecimemberid(request.getParameter("memberid"));
			customerInfoPo1.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
			
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo1);
			// 年龄
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}
		}
		
		salers = personInfoMgr.getPersoninfoPoListByJobType("1",personInfoPo.getDepartmentID(),systemParameterPo);
		posers = personInfoMgr.getPersoninfoPoListByJobType("2",personInfoPo.getDepartmentID(),systemParameterPo);
		
		String salseID = Utility.getName(request.getParameter("salseID"));
		request.setAttribute("salseID", salseID);
		
		return SUCCESS;
	}
	
	
	public String insertPreSalesCustomerS() {
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
		
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String preid = "PRE" + personInfoPo.getDepartmentID() + personInfoPo.getMachinery() + numHeadFormat.format(new Date());		
		request.setAttribute("preid", preid);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("门店预销售收款:" + preid + "新增!");
		
		PreSalesPo salespo = preSalesMgr.selectPreSalesPoSerialNumber();
		String serialNumber = "1";
		if(salespo != null){
			serialNumber = salespo.getSsepsserialnumber();
		}
		
		preSalesPo.setSsepsid(preid);
		preSalesPo.setSsepsshopcode(personInfoPo.getDepartmentID());
		preSalesPo.setSsepsserialnumber(serialNumber);
		
		preSalesMgr.insertPreSalesS(preSalesPo,logPo);
		
		String url = "'initInsertPreSalesS.action?smecimemberid="
			+ request.getParameter("smecimemberid") + "&print=1&salseID="+preid+"&checkoutFlag="+request.getParameter("checkoutFlag")+"&moduleID=" + moduleID + "'";
		
		this.clearMessages();
		this.addActionMessage("缴费成功!");
		request.setAttribute("url", url);
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	public String initSelectPreSalesCustomerS() {
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
			return "select";
		}
		
		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo);
		
		return SUCCESS;
	}
	
	public String selectPreSalesCustomerS() {
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
		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo);
		
		String ssepsid = Utility.getName(request.getParameter("ssepsid"));				
		String ssepsserialnumber = Utility.getName(request.getParameter("ssepsserialnumber"));
		String ssepsshopcode = Utility.getName(request.getParameter("ssepsshopcode"));
		String ssepsmemberid = Utility.getName(request.getParameter("ssepsmemberid"));
		String ssepssalername = Utility.getName(request.getParameter("ssepssalername"));
		String ssepsposername = Utility.getName(request.getParameter("ssepsposername"));
		String ssepscustomername = Utility.getName(request.getParameter("ssepscustomername"));
		String ssepsbgntime = Utility.getName(request.getParameter("ssepsbgntime"));
		String ssepsendtime = Utility.getName(request.getParameter("ssepsendtime"));
		
		PreSalesPo po = new PreSalesPo();
		po.setSsepsid(ssepsid);
		po.setSsepsserialnumber(ssepsserialnumber);
		po.setSsepsshopcode(ssepsshopcode);
		po.setSsepsmemberid(ssepsmemberid);
		po.setSsepssalername(ssepssalername);
		po.setSsepsposername(ssepsposername);
		po.setSsepscustomername(ssepscustomername);
		po.setSsepsbgntime(ssepsbgntime);
		po.setSsepsendtime(ssepsendtime);
		po.setSmecishoplist(departmentsList);
		
		request.setAttribute("ssepsid", ssepsid);
		request.setAttribute("ssepsserialnumber", ssepsserialnumber);
		request.setAttribute("ssepsshopcode", ssepsshopcode);
		request.setAttribute("ssepsmemberid", ssepsmemberid);
		request.setAttribute("ssepssalername", ssepssalername);
		request.setAttribute("ssepsposername", ssepsposername);
		request.setAttribute("ssepscustomername", ssepscustomername);
		request.setAttribute("ssepsbgntime", ssepsbgntime);
		request.setAttribute("ssepsendtime", ssepsendtime);
		
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
		
		int count = preSalesMgr.getPreSalesPoListCount(po);
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
			preSalesPoList = preSalesMgr.getPreSalesPoList(po, page.getStart(), page.getPageSize());
		
			request.setAttribute(Pagination.PAGINATION, page);
		}
		return SUCCESS;
	}
	
	/**
	 * 初始化查询门店计划销售金额
	 */
	public String initPreShopSalesSel() {
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
			return "preShopSalesSel";
		}
		
   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));

		return SUCCESS;
	}
	
	/**
	 * 查询门店计划销售金额
	 */
	public String preShopSalesSel() {
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

		String bdpdepartmentname = Utility.getName(request.getParameter("bdpdepartmentname"));
		String ds = Utility.getName(request.getParameter("ds"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String minprice = Utility.getName(request.getParameter("minprice"));
		String maxprice = Utility.getName(request.getParameter("maxprice"));
		
		request.setAttribute("bdpdepartmentname",bdpdepartmentname);
		request.setAttribute("ds",ds);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("minprice",minprice);
		request.setAttribute("maxprice",maxprice);
		
		preShopSalesPo = new PreShopSalesPo();
		preShopSalesPo.setSsepsshopcode(departmentID);
		preShopSalesPo.setSsepsprebgndate(startTime);
		preShopSalesPo.setSsepspreenddate(endTime);
		preShopSalesPo.setSsepsbgnsalesprice(minprice);
		preShopSalesPo.setSsepsendsalesprice(maxprice);
		
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
		
		int count = preSalesMgr.getPreShopSalesCount(preShopSalesPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request
						.getParameter("perPage")).intValue();
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
			preShopSalesList = preSalesMgr.getPreShopSalesList(preShopSalesPo, page.getStart(), page.getPageSize());
		
			request.setAttribute(Pagination.PAGINATION, page);
		}
		
   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));
	    
		return SUCCESS;
	}
	
	/**
	 * 初始化新增门店计划销售金额
	 */
	public String initPreShopSalesInsert() {
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

   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));
	    
		return SUCCESS;
	}
	
	/**
	 * 新增门店计划销售金额
	 */
	public String preShopSalesInsert() {
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

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("新增门店计划金额!");
		
		preShopSalesList = new ArrayList<PreShopSalesPo>();
		
		int count = preShopSalesTempPo.getSsepsshopcode().length;
		for (int i = 0; i < count; i++){
			PreShopSalesPo po = new PreShopSalesPo();
			po.setSsepscreatepersonid(createPerson);
			po.setSsepscreatedptid(personInfoPo.getDepartmentID());			
			po.setSsepsshopcode(Utility.getName(preShopSalesTempPo.getSsepsshopcode()[i]));
			po.setSsepsprebgndate(Utility.getName(preShopSalesTempPo.getSsepsprebgndate()[i]));
			po.setSsepspreenddate(Utility.getName(preShopSalesTempPo.getSsepspreenddate()[i]));
			po.setSsepssalesprice(Utility.getName(preShopSalesTempPo.getSsepssalesprice()[i]));
			
			preShopSalesList.add(po);
		}
		
		preSalesMgr.insertPreShopSales(preShopSalesList, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化修改门店计划销售金额
	 */
	public String initPreShopSalesUpdate() {
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

		preShopSalesPo = new PreShopSalesPo();
		preShopSalesPo.setSsepsid(Utility.getName(request.getParameter("hid")));
		
		preShopSalesPo = preSalesMgr.getPreShopSalesDetail(preShopSalesPo);
		
		return SUCCESS;
	}
	/**
	 * 修改门店计划销售金额
	 */
	public String preShopSalesUpdate() {
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

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("门店：" + Utility.getName(preShopSalesPo.getSsepsshopcode()) +" 修改计划金额!");
		
		preShopSalesPo.setSsepslastupdatepersonid(createPerson);
		preShopSalesPo.setSsepslastupdatedptid(personInfoPo.getDepartmentID());
		
		preSalesMgr.updatePreShopSales(preShopSalesPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化删除门店计划销售金额
	 */
	public String initPreShopSalesDelete() {
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
		
		preShopSalesPo = new PreShopSalesPo();
		preShopSalesPo.setSsepsid(Utility.getName(request.getParameter("hid")));
		
		preShopSalesPo = preSalesMgr.getPreShopSalesDetail(preShopSalesPo);
				
		return SUCCESS;
	}
	
	/**
	 * 删除门店计划销售金额
	 */
	public String preShopSalesDelete() {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("门店：" + Utility.getName(preShopSalesPo.getSsepsshopcode()) +" 删除计划金额!");
		
		preSalesMgr.deletePreShopSales(preShopSalesPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化查询业务进度表
	 */
	public String initPreShopSalesReportSel() {
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
	
	/**
	 * 初始化查询人员计划销售金额
	 */
	public String initPrePersonSalesSel() {
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
			return "prePersonSalesSel";
		}
		
   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));

		return SUCCESS;
	}
	
	/**
	 * 查询人员计划销售金额
	 */
	public String prePersonSalesSel() {
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

		String bdpdepartmentname = Utility.getName(request.getParameter("bdpdepartmentname"));
		String ds = Utility.getName(request.getParameter("ds"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String minprice = Utility.getName(request.getParameter("minprice"));
		String maxprice = Utility.getName(request.getParameter("maxprice"));
		String personID = Utility.getName(request.getParameter("personID"));
		String personName = Utility.getName(request.getParameter("personName"));
		
		request.setAttribute("bdpdepartmentname",bdpdepartmentname);
		request.setAttribute("ds",ds);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("minprice",minprice);
		request.setAttribute("maxprice",maxprice);
		request.setAttribute("personID",personID);
		request.setAttribute("personName",personName);
		
		prePersonSalesPo = new PrePersonSalesPo();
		prePersonSalesPo.setSsepsshopcode(departmentID);
		prePersonSalesPo.setSsepspersonid(personID);
		prePersonSalesPo.setSsepspersonname(personName);
		prePersonSalesPo.setSsepsprebgndate(startTime);
		prePersonSalesPo.setSsepspreenddate(endTime);
		prePersonSalesPo.setSsepsbgnsalesprice(minprice);
		prePersonSalesPo.setSsepsendsalesprice(maxprice);
		
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
		
		int count = preSalesMgr.getPrePersonSalesCount(prePersonSalesPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request
						.getParameter("perPage")).intValue();
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
			prePersonSalesList = preSalesMgr.getPrePersonSalesList(prePersonSalesPo, page.getStart(), page.getPageSize());
		
			request.setAttribute(Pagination.PAGINATION, page);
		}
		
   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));
	    
		return SUCCESS;
	}
	
	/**
	 * 初始化新增人员计划销售金额
	 */
	public String initPrePersonSalesInsert() {
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

   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));
	    
		return SUCCESS;
	}
	
	/**
	 * 新增人员计划销售金额
	 */
	public String prePersonSalesInsert() {
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

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("新增门店计划金额!");
		
		prePersonSalesList = new ArrayList<PrePersonSalesPo>();
		
		int count = preShopSalesTempPo.getSsepsshopcode().length;
		for (int i = 0; i < count; i++){
			PrePersonSalesPo po = new PrePersonSalesPo();
			po.setSsepscreatepersonid(createPerson);
			po.setSsepscreatedptid(personInfoPo.getDepartmentID());			
			po.setSsepspersonid(Utility.getName(preShopSalesTempPo.getSsepspersonid()[i]));
			po.setSsepsshopcode(Utility.getName(preShopSalesTempPo.getSsepsshopcode()[i]));
			po.setSsepsprebgndate(Utility.getName(preShopSalesTempPo.getSsepsprebgndate()[i]));
			po.setSsepspreenddate(Utility.getName(preShopSalesTempPo.getSsepspreenddate()[i]));
			po.setSsepssalesprice(Utility.getName(preShopSalesTempPo.getSsepssalesprice()[i]));
			
			prePersonSalesList.add(po);
		}
		
		preSalesMgr.insertPrePersonSales(prePersonSalesList, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化修改人员计划销售金额
	 */
	public String initPrePersonSalesUpdate() {
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

		prePersonSalesPo = new PrePersonSalesPo();
		prePersonSalesPo.setSsepsid(Utility.getName(request.getParameter("hid")));
		
		prePersonSalesPo = preSalesMgr.getPrePersonSalesDetail(prePersonSalesPo);
		
		return SUCCESS;
	}
	/**
	 * 修改人员计划销售金额
	 */
	public String prePersonSalesUpdate() {
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

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("门店：" + Utility.getName(prePersonSalesPo.getSsepsshopcode()) +" 修改计划金额!");
		
		prePersonSalesPo.setSsepslastupdatepersonid(createPerson);
		prePersonSalesPo.setSsepslastupdatedptid(personInfoPo.getDepartmentID());
		
		preSalesMgr.updatePrePersonSales(prePersonSalesPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化删除人员计划销售金额
	 */
	public String initPrePersonSalesDelete() {
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
		
		prePersonSalesPo = new PrePersonSalesPo();
		prePersonSalesPo.setSsepsid(Utility.getName(request.getParameter("hid")));
		
		prePersonSalesPo = preSalesMgr.getPrePersonSalesDetail(prePersonSalesPo);
				
		return SUCCESS;
	}
	
	/**
	 * 删除门店计划销售金额
	 */
	public String prePersonSalesDelete() {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("门店：" + Utility.getName(prePersonSalesPo.getSsepsshopcode()) +" 删除计划金额!");
		
		preSalesMgr.deletePrePersonSales(prePersonSalesPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public PreSalesMgr getPreSalesMgr() {
		return preSalesMgr;
	}

	public void setPreSalesMgr(PreSalesMgr preSalesMgr) {
		this.preSalesMgr = preSalesMgr;
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

	public PreSalesPo getPreSalesPo() {
		return preSalesPo;
	}

	public void setPreSalesPo(PreSalesPo preSalesPo) {
		this.preSalesPo = preSalesPo;
	}

	public List<PreSalesPo> getPreSalesPoList() {
		return preSalesPoList;
	}

	public void setPreSalesPoList(List<PreSalesPo> preSalesPoList) {
		this.preSalesPoList = preSalesPoList;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public PrePlanPo getPrePlanPo() {
		return prePlanPo;
	}

	public void setPrePlanPo(PrePlanPo prePlanPo) {
		this.prePlanPo = prePlanPo;
	}

	public PreDepPo getPreDepPo() {
		return preDepPo;
	}

	public void setPreDepPo(PreDepPo preDepPo) {
		this.preDepPo = preDepPo;
	}

	public PreBrandPo getPreBrandPo() {
		return preBrandPo;
	}

	public void setPreBrandPo(PreBrandPo preBrandPo) {
		this.preBrandPo = preBrandPo;
	}

	public List<PrePlanPo> getPrePlanPoList() {
		return prePlanPoList;
	}

	public void setPrePlanPoList(List<PrePlanPo> prePlanPoList) {
		this.prePlanPoList = prePlanPoList;
	}

	public List<PreDepPo> getPreDepPoList() {
		return preDepPoList;
	}

	public void setPreDepPoList(List<PreDepPo> preDepPoList) {
		this.preDepPoList = preDepPoList;
	}

	public List<PreBrandPo> getPreBrandPoList() {
		return preBrandPoList;
	}

	public void setPreBrandPoList(List<PreBrandPo> preBrandPoList) {
		this.preBrandPoList = preBrandPoList;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public List<PersonInfoPo> getSalers() {
		return salers;
	}

	public void setSalers(List<PersonInfoPo> salers) {
		this.salers = salers;
	}

	public List<PersonInfoPo> getPosers() {
		return posers;
	}

	public void setPosers(List<PersonInfoPo> posers) {
		this.posers = posers;
	}

	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	public List<PreShopSalesPo> getPreShopSalesList() {
		return preShopSalesList;
	}

	public void setPreShopSalesList(List<PreShopSalesPo> preShopSalesList) {
		this.preShopSalesList = preShopSalesList;
	}

	public PreShopSalesPo getPreShopSalesPo() {
		return preShopSalesPo;
	}

	public void setPreShopSalesPo(PreShopSalesPo preShopSalesPo) {
		this.preShopSalesPo = preShopSalesPo;
	}

	public PreShopSalesTempPo getPreShopSalesTempPo() {
		return preShopSalesTempPo;
	}

	public void setPreShopSalesTempPo(PreShopSalesTempPo preShopSalesTempPo) {
		this.preShopSalesTempPo = preShopSalesTempPo;
	}
}
