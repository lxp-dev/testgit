package com.pengsheng.eims.basic.action;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.InitSystemMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.PeriodBeginClearPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class InitSystemAction extends BaseAction{

	private PersonPermissionMgr personPermissionMgr;
	private InitSystemMgr initSystemMgr = null;
	private GoodsInfoPo goodsInfoPo = null;
	private List<GoodsInfoPo> goodsInfoList = null;
	private DepartmentsMgr departmentsMgr;
	private List<DepartmentsPo> departmentsList;
	private List<WarehousePo> warehouseList;
	private WarehouseMgr warehouseMgr;
	private GoodsInfoTempPo goodsInfoTempPo = null;
	private ReportQuartzMgr reportQuartzMgr;
	private File myFile;
	private File[] upload;
	private String[] uploadContentType;
	private String[] uploadFileName;
	private String savePath;
	private String fileName;
	private String contentType;
	private InputStream inputStream;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private List<GoodsCategoryPo> goodsCategorys;
	private VarietyMgr varietyMgr;
	private PeriodBeginClearPo periodBeginClearPo;
	private CompanyNameMgr companyNameMgr;
	private List<CompanyNamePo> companyNamePos;
	private List<PeriodBeginClearPo> periodBeginClearList;
	private FquartzSwitchPo fquartzSwitchPo;
	private String fileTemplet;
	
	/**
	 * 初始化导入期初商品的查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initImportFile() throws Exception {
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
		
		DepartmentsPo dpo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			dpo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		departmentsList = departmentsMgr.getDepartments(dpo);
		
		return SUCCESS;
	}
	
	/**
	 * Description：根据部门查询所属仓位
	 */
	public void selWarehouseByDepartment() throws Exception {		
		
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		request.setAttribute("departmentID" , departmentID);
		
		departmentsList = departmentsMgr.getDepartments();
		
		PrintWriter out = null;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(departmentID.equals("")){
			out.println("<option value=''>----请选择----</option>");
		}else{
			DepartmentsPo departmentsPo = new DepartmentsPo();
			departmentsPo.setBdpdepartmentid(departmentID);
			
			warehouseList = warehouseMgr.getWarehouseList(departmentsPo);
			Iterator<WarehousePo> it = warehouseList.iterator();	
			if (it.hasNext()) {
				while (it.hasNext()) {
					WarehousePo po = it.next();
					out.println("<option value='" + po.getBwhid() + "'>" + po.getBwhwarehouseName() + "</option>");
				}
			}
		}
		//释放流
		out.flush();
		out.close();
		
		//释放资源
		departmentID = null;
		out = null;
	}
	
	/**
	 * 导入期初商品
	 * 
	 * @return
	 * @throws Exception
	 */
	public String importFile() throws Exception {
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
		logPo.setsLogOpID("1");    // 表示状态
		
		String sjtype = Utility.getName(request.getParameter("sjtype"));
		
		initSystemMgr.insertImportExcel(goodsInfoPo,sjtype,upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType(),systemParameterPo,ServletActionContext.getServletContext().getRealPath(this.getFileTemplet()),logPo);
		
		this.clearMessages(); 
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		String url = "''initImportFile.action?moduleID={0}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化导出商品信息页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initExportFile() throws Exception {
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
	 * 导出商品信息页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exportFile() throws Exception {
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
		
		setFileName(java.net.URLEncoder.encode("期初商品信息.xlsx", "UTF-8"));
		
		try {
			goodsInfoPo = new GoodsInfoPo();
			String url = ServletActionContext.getServletContext().getRealPath(this.getSavePath());
			inputStream = initSystemMgr.insertExportExcel(goodsInfoPo,url,logPo);
		} catch (Exception e) {
			System.out.println("商品信息导出失败：" + e.getMessage());
		}
			
		return SUCCESS;
	}
	
	/**
	 * 初始化条码打印页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initBarCodePrint() throws Exception {
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
		
		String bgiwarehouseid = Utility.getName(request.getParameter("bgiwarehouseid"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String isprint = Utility.getName(request.getParameter("isprint"));
		String bgnDate = Utility.getName(request.getParameter("bgnDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String whichretail = Utility.getName(request.getParameter("whichretail"));
		
		String whichretailname = "";
		if("".equals(whichretail) || "1".equals(whichretail)){
			whichretailname = "标准零售价";
		}else{
			whichretailname = "零售价格"+whichretail;
		}
		
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgiwarehouseid(bgiwarehouseid);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgiisprint(isprint);
		goodsInfoPo.setBgnDate(bgnDate);
		goodsInfoPo.setEndDate(endDate);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		
		if("".equals(Utility.getName(whichretail))){
			goodsInfoPo.setBgiwhichretail("1");
		}else{
			goodsInfoPo.setBgiwhichretail(whichretail);
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		int count = initSystemMgr.getPrintGoodsBarCodeCount(goodsInfoPo);
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
			
			goodsInfoList = initSystemMgr.getPrintGoodsBarCodeList(goodsInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}	
		
		request.setAttribute("bgiwarehouseid",bgiwarehouseid);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("isprint",isprint);
		request.setAttribute("bgnDate",bgnDate);
		request.setAttribute("endDate",endDate);
		request.setAttribute("goodscategoryID",goodscategoryID);
		request.setAttribute("whichretail",whichretail);
		request.setAttribute("whichretailname",whichretailname);
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
	
	/**
	 * 条码打印页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String barCodePrint() throws Exception {
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
		
		String barCodeList = Utility.getName(request.getParameter("barCodeList"));
		String bgiwarehouseid = Utility.getName(request.getParameter("bgiwarehouseid"));
		String isprint = Utility.getName(request.getParameter("isprint"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String bgnDate = Utility.getName(request.getParameter("bgnDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("打印商品条码!");
		logPo.setsLogBillList(barCodeList);
		
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsbarcode(barCodeList);
		goodsInfoPo.setBgiwarehouseid(bgiwarehouseid);
		
		initSystemMgr.updatePrintGoodsBarCodeStatus(goodsInfoPo, logPo);
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		this.addActionMessage("打印完成！");
		String url = "''initBarCodePrint.action?bgiwarehouseid={0}&moduleID={1}&isprint="+isprint+"&goodsID="+goodsID+"&goodsName="+goodsName+"&bgnDate="+bgnDate+"&endDate="+endDate+"&goodscategoryID="+goodscategoryID+"''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(bgiwarehouseid));
		params.add(Utility.getName(moduleID));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始默认化加权平均成本设置
	 */
	public String initDefaultAverageCostSet() throws Exception {		
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
	 * 默认加权平均成本设置
	 */
	public String defaultAverageCostSet() throws Exception {
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
		logPo.setsLogContent("默认加权平均成本设置!");
		logPo.setsLogBillList("");
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		FquartzSwitchPo fspo = reportQuartzMgr.getFquartzSwitchPo();

		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgiaverageflag(Utility.getName(fspo.getFqscbjs()));
		
		initSystemMgr.updateGoodsAvgCost(po, logPo);
		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		String url = "''initDefaultAverageCostSet.action?moduleID={0}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化导入期初成本
	 */
	public String initPeriodBeginLogistics() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		
        if (Utility.getName(systemParameterPo.getFspcbjstype()).equals("2")){
        	
        	CompanyNamePo cpo = new CompanyNamePo();
    		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
    			cpo.setFcnId(personInfoPo.getPersoncompanyid());
    		}
        	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
        }else{
        	request.setAttribute("bgnDate", initSystemMgr.getQcDateByCompany(""));	
        }  	
		
		return SUCCESS;
	}
		
	/**
	 * 导入期初成本
	 */
	public String insertPeriodBeginLogistics() throws Exception {
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		
		String bgnDate = Utility.getName(request.getParameter("bgnDate"));
		String companyID = Utility.getName(request.getParameter("companyID"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String companyID2 = Utility.getName(request.getParameter("companyID2"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		
		if (companyID.equals("")){
			if (companyID2.equals("")){
				logPo.setsLogContent("按 " + bgnDate + " 汇总所有公司的期初成本!");
			}else{
				companyID = companyID2;
				logPo.setsLogContent("按 " + bgnDate + " 汇总【"+ companyID +"】的期初成本!");
			}
		}else{
			logPo.setsLogContent("按 " + bgnDate + " 汇总【"+ companyID +"】下的【" + departmentID + "】的期初成本!");
		}
		
		initSystemMgr.insertGoodsAvgCost(bgnDate,companyID,departmentID,Utility.getName(fquartzSwitchPo.getFqscbjs()),Utility.getName(systemParameterPo.getFspcbjstype()),logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化清除试用数据
	 */
	public String initPeriodBeginClearData() throws Exception {
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
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		return SUCCESS;
	}
	
	/**
	 * 清除试用数据
	 */
	public String insertPeriodBeginClearData() throws Exception {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("清除试用数据!");
		
		periodBeginClearPo.setPbcoppersonid(createPerson);
		periodBeginClearPo.setPbcdepartmentid(personInfoPo.getDepartmentID());
		
		initSystemMgr.deletePeriodBeginData(periodBeginClearPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化清除试用数据日志
	 */
	public String initPeriodBeginClearDataLog() throws Exception {
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
		
		periodBeginClearList = initSystemMgr.selectPeriodBeginData();
		
		return SUCCESS;
	}
	
	/**
	 * 初始化期初成本查询
	 */
	public String initPeriodBeginQccbSelect() throws Exception {
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
		
    	CompanyNamePo cpo = new CompanyNamePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
		}
    	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);

		return SUCCESS;
	}
	
	/**
	 * 期初成本查询
	 */
	public String selectPeriodBeginQccb() throws Exception {
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
		
		String companyID = Utility.getName(request.getParameter("companyID"));
		String dptID = Utility.getName(request.getParameter("dptID"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
				
		request.setAttribute("companyID",companyID);
		request.setAttribute("dptID",dptID);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		
    	CompanyNamePo cpo = new CompanyNamePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
		}
    	companyNamePos = companyNameMgr.getCompanyNameForSelect(cpo);
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		GoodsInfoPo gpo = new GoodsInfoPo();
		gpo.setBgigoodsid(goodsID);
		gpo.setBgigoodsname(goodsName);
		gpo.setBgidepartmentid(dptID);
		gpo.setBgicompanyid(companyID);
		gpo.setBgiqcpricetype(Utility.getName(fquartzSwitchPo.getFqscbjs()));
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			gpo.setBgicompanyid(personInfoPo.getPersoncompanyid());
		}
		
		int count = initSystemMgr.getQccbCount(gpo);
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
		    goodsInfoList = initSystemMgr.getQccbList(gpo,page.getStart(),page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			goodsInfoList = null;
		}	
		
		gpo = initSystemMgr.getQccbTotal(gpo);
		request.setAttribute("totalnum",Utility.getName(gpo.getBgiqcnum()));
		request.setAttribute("totalamount",Utility.getName(gpo.getBgiqcaouumt()));
		
		return SUCCESS;
	}
	
	/**
	 * 初始化期初成本修改
	 */
	public String initPeriodBeginQccbUpdate() throws Exception {
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
		
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgiqcid(Utility.getName(request.getParameter("hid")));
		goodsInfoPo.setBgiqcpricetype(Utility.getName(fquartzSwitchPo.getFqscbjs()));

		goodsInfoPo = initSystemMgr.getQccbDetail(goodsInfoPo);	
		
		return SUCCESS;
	}
	
	/**
	 * 修改期初成本
	 */
	public String updatePeriodBeginQccb() throws Exception {
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
		
		String qcaouumt = Utility.getName(request.getParameter("qcaouumt"));
		String qcnum = Utility.getName(request.getParameter("qcnum"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("商品代码：【" + Utility.getName(goodsInfoPo.getBgigoodsid()) + "】的" + (Utility.getName(goodsInfoPo.getBgiqcpricetype()).equals("1") ? "【不含税】" : "【含税】") + "期初成本由:【" + qcaouumt + "】 调整为:【" + Utility.getName(goodsInfoPo.getBgiqcaouumt()) + "】,期初数量由:【" + qcnum + "】 调整为:【" + Utility.getName(goodsInfoPo.getBgiqcnum()) + "】!");
		
		initSystemMgr.updateQccb(goodsInfoPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("更改成功！\\n由于期初数量和成本的变更，将以后各个账期的加权平均成本不准确，请从期初账期开始重新进行成本计算！"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public InitSystemMgr getInitSystemMgr() {
		return initSystemMgr;
	}
	public void setInitSystemMgr(InitSystemMgr initSystemMgr) {
		this.initSystemMgr = initSystemMgr;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFileName()throws Exception  {
		return new String(fileName.getBytes(), "ISO8859-1");
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
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

	public List<GoodsInfoPo> getGoodsInfoList() {
		return goodsInfoList;
	}

	public void setGoodsInfoList(List<GoodsInfoPo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
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

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
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

	public PeriodBeginClearPo getPeriodBeginClearPo() {
		return periodBeginClearPo;
	}

	public void setPeriodBeginClearPo(PeriodBeginClearPo periodBeginClearPo) {
		this.periodBeginClearPo = periodBeginClearPo;
	}

	public ReportQuartzMgr getReportQuartzMgr() {
		return reportQuartzMgr;
	}

	public void setReportQuartzMgr(ReportQuartzMgr reportQuartzMgr) {
		this.reportQuartzMgr = reportQuartzMgr;
	}

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

	public List<PeriodBeginClearPo> getPeriodBeginClearList() {
		return periodBeginClearList;
	}

	public void setPeriodBeginClearList(
			List<PeriodBeginClearPo> periodBeginClearList) {
		this.periodBeginClearList = periodBeginClearList;
	}

	public FquartzSwitchPo getFquartzSwitchPo() {
		return fquartzSwitchPo;
	}

	public void setFquartzSwitchPo(FquartzSwitchPo fquartzSwitchPo) {
		this.fquartzSwitchPo = fquartzSwitchPo;
	}

	public String getFileTemplet() {
		return fileTemplet;
	}

	public void setFileTemplet(String fileTemplet) {
		this.fileTemplet = fileTemplet;
	}
	
}
