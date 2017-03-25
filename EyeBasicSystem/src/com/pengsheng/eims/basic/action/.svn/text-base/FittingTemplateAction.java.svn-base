package com.pengsheng.eims.basic.action;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.FittingTemplateMgr;
import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.persistence.FittingTemplatePo;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class FittingTemplateAction extends BaseAction {

	private FittingTemplateMgr fittingTemplateMgr = null;
	private FittingTemplateTypeMgr fittingTemplateTypeMgr = null;
	private SystemParameterMgr systemParameterMgr = null;
	private SystemParameterPo systemParameterPo = null;
	private PersonPermissionMgr personPermissionMgr = null;
	private File myFile = null;
	private File[] upload = null;
	private String[] uploadContentType = null;
	private String[] uploadFileName = null;
	private String savePath = null;
	private String fileName = null;
	private String contentType = null;
	private InputStream inputStream = null;
	private String isFirstExec;
	private List<FittingTemplatePo> fittingTemplateList = null;
	private List<FittingTemplateTypePo> fittingTemplateTypeList = null;
	private FittingTemplatePo fittingTemplatePo = null;
	
	/**
	 *  初始化打印单据模板查询
	 */
	public String initPrintBillTemplateSel() throws Exception{
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
		
		if (Utility.getName(permissionPo.getKeyd()).equals("1")){
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "printBillTemplateSel";
			}
		}
		
		fittingTemplateTypeList = fittingTemplateTypeMgr.getFittingTemplateTypeList(null);
		
		return SUCCESS;
	}
	
	/**
	 *  打印单据模板查询
	 */
	public String printBillTemplateSel() throws Exception{
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
		
		String printbilltype = Utility.getName(request.getParameter("printbilltype"));
		String cstartTime = Utility.getName(request.getParameter("cstartTime"));
		String cendTime = Utility.getName(request.getParameter("cendTime"));
		String isused = Utility.getName(request.getParameter("isused"));
		String serverid = Utility.getName(request.getParameter("serverid"));
		String isenabled = Utility.getName(request.getParameter("isenabled"));
		String templatename = Utility.getName(request.getParameter("templatename"));
		
		request.setAttribute("printbilltype",printbilltype);
		request.setAttribute("cstartTime",cstartTime);
		request.setAttribute("cendTime",cendTime);
		request.setAttribute("isused",isused);
		request.setAttribute("serverid",serverid);
		request.setAttribute("isenabled",isenabled);
		request.setAttribute("templatename",templatename);
		
		fittingTemplatePo = new FittingTemplatePo();
		fittingTemplatePo.setBftbgndate(cstartTime);
		fittingTemplatePo.setBftenddate(cendTime);
		fittingTemplatePo.setBftserver(serverid);
		fittingTemplatePo.setBftflag(isenabled);
		fittingTemplatePo.setBftcurrentflag(isused);
		fittingTemplatePo.setBfttype(printbilltype);
		fittingTemplatePo.setBfttemplatename(templatename);
		
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

		int count = fittingTemplateMgr.getPrintBillTemplateCount(fittingTemplatePo);
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
			fittingTemplateList = fittingTemplateMgr.getPrintBillTemplateList(fittingTemplatePo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			fittingTemplateList = null;
		}
		
		fittingTemplateTypeList = fittingTemplateTypeMgr.getFittingTemplateTypeList(null);
		
		return SUCCESS;
	}
	
	/**
	 *  初始化打印单据模板修改
	 */
	public String initPrintBillTemplateUpdate() throws Exception{
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
		
		String hid = Utility.getName(request.getParameter("hid"));
		
		fittingTemplatePo = new FittingTemplatePo();
		fittingTemplatePo.setBftid(hid);
		
		fittingTemplatePo = fittingTemplateMgr.getPrintBillTemplateDetail(fittingTemplatePo);
		fittingTemplateTypeList = fittingTemplateTypeMgr.getFittingTemplateTypeList(null);
		
		return SUCCESS;
	}
	
	/**
	 *  打印单据模板修改
	 */
	public String printBillTemplateUpdate() throws Exception{
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
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("报表样式:" + Utility.getName(fittingTemplatePo.getBftid()) + "修改!");
		
		if (Utility.getName(fittingTemplatePo.getBftflag()).equals("")){
			fittingTemplatePo.setBftflag("0");
		}else{
			fittingTemplatePo.setBftflag("1");
		}	
		
		fittingTemplateMgr.updatePrintBillTemplate(fittingTemplatePo,upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(),this.getSavePath(),logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 *  初始化打印单据模板删除
	 */
	public String initPrintBillTemplateDelete() throws Exception{
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
		
		String hid = Utility.getName(request.getParameter("hid"));
		String title = Utility.getName(request.getParameter("title"));

		request.setAttribute("hid",hid);
		request.setAttribute("title",title);
		
		return SUCCESS;
	}
	
	/**
	 *  打印单据模板删除
	 */
	public String printBillTemplateDelete() throws Exception{
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
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("报表样式:" + Utility.getName(fittingTemplatePo.getBftid()) + "删除!");
		
		fittingTemplateMgr.deletePrintBillTemplate(fittingTemplatePo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 *  初始化打印单据模板新增
	 */
	public String initPrintBillTemplateInsert() throws Exception{
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
		
		fittingTemplateTypeList = fittingTemplateTypeMgr.getFittingTemplateTypeList(null);
		return SUCCESS;
	}
	
	/**
	 *  打印单据模板新增
	 */
	public String printBillTemplateInsert() throws Exception{
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
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("报表样式:" + Utility.getName(fittingTemplatePo.getBftid()) + "新增!");
		
		String logoPath = Utility.getName(fittingTemplatePo.getBftlogo());
		String bgPath = Utility.getName(fittingTemplatePo.getBftfileurl());
		if (logoPath.equals("")){
			if (bgPath.equals("b")){
				fittingTemplatePo.setBftpicflag("b");
			}
			if (bgPath.equals("")){
				fittingTemplatePo.setBftpicflag("");
			}
		}
		if (logoPath.equals("l")){
			if (bgPath.equals("")){
				fittingTemplatePo.setBftpicflag("l");
			}
			if (bgPath.equals("b")){
				fittingTemplatePo.setBftpicflag("all");
			}	
		}
		
		if (Utility.getName(fittingTemplatePo.getBftflag()).equals("")){
			fittingTemplatePo.setBftflag("0");
		}else{
			fittingTemplatePo.setBftflag("1");
		}			
		fittingTemplatePo.setBftcurrentflag("0");
		fittingTemplatePo.setBftpersonid(createPerson);
		fittingTemplateMgr.insertPrintBillTemplate(fittingTemplatePo,upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(),this.getSavePath(),logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 *  初始化打印单据模板停用启用
	 */
	public String initPrintBillTemplateEnable() throws Exception{
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
				
		String hid = Utility.getName(request.getParameter("hid"));
		String title = Utility.getName(request.getParameter("title"));
		String flag = Utility.getName(request.getParameter("flag"));

		request.setAttribute("hid",hid);
		request.setAttribute("title",title);
		request.setAttribute("flag",flag);
		
		return SUCCESS;
	}
	
	/**
	 *  打印单据模板停用启用
	 */
	public String printBillTemplateEnable() throws Exception{
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
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("报表样式:" + Utility.getName(fittingTemplatePo.getBftid()) + "启用/停用!");
		
		fittingTemplateMgr.updatePrintBillTemplateEnable(fittingTemplatePo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 *  初始化打印单据模板详细
	 */
	public String initPrintBillTemplateDetail() throws Exception{
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
				
		String hid = Utility.getName(request.getParameter("hid"));
		
		fittingTemplatePo = new FittingTemplatePo();
		fittingTemplatePo.setBftid(hid);
		
		fittingTemplateTypeList = fittingTemplateTypeMgr.getFittingTemplateTypeList(null);
		fittingTemplatePo = fittingTemplateMgr.getPrintBillTemplateDetail(fittingTemplatePo);
		
		return SUCCESS;
	}

	/**
	 *  系统参数设置模块中报表样式开窗
	 */
	public String initBillTemplateDepartmentOpen() throws Exception{
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
				
		String typeID = Utility.getName(request.getParameter("typeID"));
		String id = Utility.getName(request.getParameter("id"));

		fittingTemplatePo = new FittingTemplatePo();
		fittingTemplatePo.setBfttype(typeID);
		
		fittingTemplateList = fittingTemplateMgr.getPrintBillTemplateList(fittingTemplatePo);
		
		BigDecimal fittingTemplateCount = new BigDecimal(fittingTemplateList.size());
		fittingTemplateCount = fittingTemplateCount.divide(new BigDecimal(4),1);		
		double rowCount = fittingTemplateCount.doubleValue() + 1;
		request.setAttribute("rowCount",Math.round(rowCount));
		request.setAttribute("id",id);
		
		return SUCCESS;
	}
	
	/**
	 *  系统参数设置模块中报表样式开窗
	 */
	public String initBillTemplateOpen() throws Exception{
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
				
		String typeID = Utility.getName(request.getParameter("typeID"));
		String id = Utility.getName(request.getParameter("id"));

		fittingTemplatePo = new FittingTemplatePo();
		fittingTemplatePo.setBfttype(typeID);
		
		fittingTemplateList = fittingTemplateMgr.getPrintBillTemplateList(fittingTemplatePo);
		
		BigDecimal fittingTemplateCount = new BigDecimal(fittingTemplateList.size());
		fittingTemplateCount = fittingTemplateCount.divide(new BigDecimal(4),1);		
		double rowCount = fittingTemplateCount.doubleValue() + 1;
		request.setAttribute("rowCount",Math.round(rowCount));
		request.setAttribute("id",id);
		
		return SUCCESS;
	}
	
	public FittingTemplateMgr getFittingTemplateMgr() {
		return fittingTemplateMgr;
	}

	public void setFittingTemplateMgr(FittingTemplateMgr fittingTemplateMgr) {
		this.fittingTemplateMgr = fittingTemplateMgr;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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

	public String getFileName() {
		return fileName;
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

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public List<FittingTemplatePo> getFittingTemplateList() {
		return fittingTemplateList;
	}

	public void setFittingTemplateList(List<FittingTemplatePo> fittingTemplateList) {
		this.fittingTemplateList = fittingTemplateList;
	}

	public FittingTemplatePo getFittingTemplatePo() {
		return fittingTemplatePo;
	}

	public void setFittingTemplatePo(FittingTemplatePo fittingTemplatePo) {
		this.fittingTemplatePo = fittingTemplatePo;
	}

	public FittingTemplateTypeMgr getFittingTemplateTypeMgr() {
		return fittingTemplateTypeMgr;
	}

	public void setFittingTemplateTypeMgr(
			FittingTemplateTypeMgr fittingTemplateTypeMgr) {
		this.fittingTemplateTypeMgr = fittingTemplateTypeMgr;
	}

	public List<FittingTemplateTypePo> getFittingTemplateTypeList() {
		return fittingTemplateTypeList;
	}

	public void setFittingTemplateTypeList(
			List<FittingTemplateTypePo> fittingTemplateTypeList) {
		this.fittingTemplateTypeList = fittingTemplateTypeList;
	}	
}