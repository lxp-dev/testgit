package com.pengsheng.eims.system.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.DownloadRegionMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.frame.mgr.LoginMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class CompanyNameAction extends BaseAction {

	private File[] upload;
	private String[] uploadFileName;
	private String savePath;	
	private PersonPermissionMgr personPermissionMgr;
	private CompanyNameMgr companyNameMgr;
	private CompanyNamePo companyNamePo;
	private String defaultLogoPath;
	private String defaultBgPath;
	private String defaultDepPath;
	private String picPath;
	private String topDefaultLogoPath;
	private String topDefaultBgPath;
	private String rootPath;
	private LoginMgr loginMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<CompanyNamePo> companyNamePos;
	private List<CompanyNamePo> regionPos;
	private List<CompanyNamePo> companySupplierList;
	private List<SupplierPo> companySupplierAgentList;
	private DownloadRegionMgr downloadRegionMgr;
	
	public DownloadRegionMgr getDownloadRegionMgr() {
		return downloadRegionMgr;
	}
	public void setDownloadRegionMgr(DownloadRegionMgr downloadRegionMgr) {
		this.downloadRegionMgr = downloadRegionMgr;
	}
	public List<CompanyNamePo> getCompanySupplierList() {
		return companySupplierList;
	}
	public void setCompanySupplierList(List<CompanyNamePo> companySupplierList) {
		this.companySupplierList = companySupplierList;
	}
	public List<SupplierPo> getCompanySupplierAgentList() {
		return companySupplierAgentList;
	}
	public void setCompanySupplierAgentList(
			List<SupplierPo> companySupplierAgentList) {
		this.companySupplierAgentList = companySupplierAgentList;
	}
	public List<CompanyNamePo> getRegionPos() {
		return regionPos;
	}
	public void setRegionPos(List<CompanyNamePo> regionPos) {
		this.regionPos = regionPos;
	}
	public List<CompanyNamePo> getCompanyNamePos() {
		return companyNamePos;
	}
	public void setCompanyNamePos(List<CompanyNamePo> companyNamePos) {
		this.companyNamePos = companyNamePos;
	}
	public String getIsFirstExec() {
		return isFirstExec;
	}
	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}
	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}
	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}
	public File[] getUpload() {
		return upload;
	}
	public String getDefaultDepPath() {
		return defaultDepPath;
	}
	public void setDefaultDepPath(String defaultDepPath) {
		this.defaultDepPath = defaultDepPath;
	}
	public void setUpload(File[] upload) {
		this.upload = upload;
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
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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
	public String getDefaultLogoPath() {
		return defaultLogoPath;
	}
	public void setDefaultLogoPath(String defaultLogoPath) {
		this.defaultLogoPath = defaultLogoPath;
	}
	public String getDefaultBgPath() {
		return defaultBgPath;
	}
	public void setDefaultBgPath(String defaultBgPath) {
		this.defaultBgPath = defaultBgPath;
	}	
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}	
	public String getTopDefaultLogoPath() {
		return topDefaultLogoPath;
	}
	public void setTopDefaultLogoPath(String topDefaultLogoPath) {
		this.topDefaultLogoPath = topDefaultLogoPath;
	}
	public String getTopDefaultBgPath() {
		return topDefaultBgPath;
	}
	public void setTopDefaultBgPath(String topDefaultBgPath) {
		this.topDefaultBgPath = topDefaultBgPath;
	}	
	public LoginMgr getLoginMgr() {
		return loginMgr;
	}
	public void setLoginMgr(LoginMgr loginMgr) {
		this.loginMgr = loginMgr;
	}	
	public String getRootPath() {
		return rootPath;
	}
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	
	/**
	 * 初始化公司名称查询
	 */
	public String initCompanyNameSel() {
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
		
		regionPos = companyNameMgr.getRegionListForSelect();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "companyNameSel";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 公司名称查询
	 */
	public String companyNameSel() {
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
		
		regionPos = companyNameMgr.getRegionListForSelect();
		
		String companyname = Utility.getName(request.getParameter("companyname"));
		String cid = Utility.getName(request.getParameter("cid"));
		String rid = Utility.getName(request.getParameter("rid"));
		
		request.setAttribute("companyname",companyname);
		request.setAttribute("cid",cid);
		request.setAttribute("rid",rid);
		
		CompanyNamePo po = new CompanyNamePo();
		po.setFcnName(companyname);
		po.setFcncompanyid(cid);  // 查询条件
		po.setFcnregionid(rid);
		
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setFcnId(personInfoPo.getPersoncompanyid());
		}
		
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
		
		int count = companyNameMgr.getCompanyNameCount(po);
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
			companyNamePos = companyNameMgr.getCompanyNameList(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			companyNamePos = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化新增公司名称
	 */
	public String initInsertCompanyName() {
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
		
		regionPos = companyNameMgr.getRegionListForSelect();

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		return SUCCESS;
	}
	
	/**
	 * 初始化新增公司名称
	 */
	public String initUpdateCompanyName() {
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
		
		regionPos = companyNameMgr.getRegionListForSelect();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String cid = Utility.getName(request.getParameter("cid"));
		
		CompanyNamePo po = new CompanyNamePo();
		po.setFcnId(cid);
		companyNamePo = companyNameMgr.getCompanyName(po);
		
		return SUCCESS;
	}
	
	public String initSaveCompanyName() {

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
		
		regionPos = companyNameMgr.getRegionListForSelect();

        String fcnID = Utility.getName(request.getParameter("fcnID"));
        String fcnName = Utility.getName(request.getParameter("fcnName"));
        String showSystem = Utility.getName(request.getParameter("showSystem"));
        String logoPath = Utility.getName(request.getParameter("logoPath"));
        String backgroundPath = Utility.getName(request.getParameter("backgroundPath"));
        String fcnleftnum = Utility.getName(request.getParameter("fcnleftnum"));        
        String loginShowSystem = Utility.getName(request.getParameter("loginShowSystem"));
        String changeDptShowSystem = Utility.getName(request.getParameter("changeDptShowSystem"));
        String fcnLoginShowFooter = Utility.getName(request.getParameter("fcnLoginShowFooter"));
        
        request.setAttribute("fcnID",fcnID);
        request.setAttribute("fcnName",fcnName);
        request.setAttribute("showSystem",showSystem);
        request.setAttribute("logoPath",logoPath);
        request.setAttribute("backgroundPath",backgroundPath);
        request.setAttribute("fcnleftnum",fcnleftnum);
        request.setAttribute("loginShowSystem",loginShowSystem);
        request.setAttribute("changeDptShowSystem",changeDptShowSystem);
        request.setAttribute("fcnLoginShowFooter",fcnLoginShowFooter);
        
		return SUCCESS;
	}
	
	public String saveCompanyName(){

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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("公司名称:" + Utility.getName(companyNamePo.getFcnName()) + "新增!");		
		
		String insertorupdate = Utility.getName(request.getParameter("insertorupdate"));
		String logoPath = Utility.getName(companyNamePo.getFcnLogoPath());
		String bgPath = Utility.getName(companyNamePo.getFcnbackGroundPath());
		String dpPath = Utility.getName(companyNamePo.getFcndepground());
		
		regionPos = companyNameMgr.getRegionListForSelect();
		
		if (logoPath.equals("")){
			if (bgPath.equals("b")){
				if(dpPath.equals("")){
					companyNamePo.setFcnflag("b");
				}
				if(dpPath.equals("d")){
					companyNamePo.setFcnflag("bd");
				}
			}
			if (bgPath.equals("")){
				if(dpPath.equals("")){
					companyNamePo.setFcnflag("");
				}
				if(dpPath.equals("d")){
					companyNamePo.setFcnflag("d");
				}
			}
		}
		if (logoPath.equals("l")){
			if (bgPath.equals("")){
				if(dpPath.equals("")){
					companyNamePo.setFcnflag("l");
				}
				if(dpPath.equals("d")){
					companyNamePo.setFcnflag("ld");
				}
			}
			if (bgPath.equals("b")){
				if(dpPath.equals("")){
					companyNamePo.setFcnflag("lb");
				}
				if(dpPath.equals("d")){
					companyNamePo.setFcnflag("all");
				}
			}	
		}
		
		companyNamePo.setFcnissyncompanysupplier(systemParameterPo.getFspsyncompanysupplier());
		companyNameMgr.insertCompanyName(companyNamePo,upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(),this.getPicPath(),logPo);			
		this.addActionMessage(getText("struts.messages.save.sucess"));
		
		this.clearMessages();
		this.addActionMessage("保存成功！");
		request.setAttribute("flag", GlobalConstants.OPENUPDATE13);
		
		return "success";
	}

	public String initDefaultCompanyInfo() throws Exception {

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
		
		regionPos = companyNameMgr.getRegionListForSelect();
		
		String fcnID = Utility.getName(request.getParameter("fcnID"));
		String flag = Utility.getName(request.getParameter("flag"));
        String fcnName = Utility.getName(request.getParameter("fcnName"));
        String showSystem = Utility.getName(request.getParameter("showSystem"));
        
		request.setAttribute("flag",flag);
		request.setAttribute("fcnID",fcnID);
		request.setAttribute("fcnName",fcnName);
		request.setAttribute("showSystem",showSystem);
		
		return SUCCESS;
	}
	
	public String defaultCompanyInfo() throws Exception {

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
		
		regionPos = companyNameMgr.getRegionListForSelect();
		
		String fcnID = Utility.getName(request.getParameter("fcnID"));
		String flag = Utility.getName(request.getParameter("flag"));
        String fcnName = Utility.getName(request.getParameter("fcnName"));
        String showSystem = Utility.getName(request.getParameter("showSystem"));
        
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("公司名称:" + fcnID + " 使用默认" + (flag.equals("b") ? "背景" : "logo") + "!");
		
		companyNamePo = new CompanyNamePo();
		companyNamePo.setFcnId(fcnID);
		companyNamePo.setFcnLogoPath(this.getDefaultLogoPath());
		companyNamePo.setFcnbackGroundPath(this.getDefaultBgPath());
		companyNamePo.setFcndepgroundPath(this.getDefaultDepPath());
		companyNamePo.setFcnflag(flag);
		
		companyNameMgr.updateCompanyInfo(companyNamePo, logPo);
		
		this.clearMessages();
		request.setAttribute("companyName",fcnName);
		request.setAttribute("showSystem",showSystem);
		request.setAttribute("tBgPath",this.getTopDefaultBgPath());
		request.setAttribute("tLogoPath",this.getTopDefaultLogoPath());
		request.setAttribute("tflag",flag);
		request.setAttribute("flag", "openUpdate11");
		
		return SUCCESS;
	}
	
	public String initDeleteCompanyName(){

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
		
		String fcnID = Utility.getName(request.getParameter("fcnID"));
        
        CompanyNamePo po = new CompanyNamePo();
		po.setFcnId(fcnID);
		companyNamePo = companyNameMgr.getCompanyName(po);
        
		return "success";
	}
	
	public String deleteCompanyName(){
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
		
		String fcnId = Utility.getName(request.getParameter("fcnId"));
		String fcnName = Utility.getName(request.getParameter("fcnName"));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("公司名称:" + fcnName + "删除!");		
		
		CompanyNamePo po = new CompanyNamePo();
		po.setFcnId(fcnId);
		
        String message = companyNameMgr.deleteCompanyName(po,logPo);
        
		if("".equals(message)){
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}else{
			this.clearMessages();
			this.addActionMessage(message);
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}
	}
	
	//------------------------------------------------区域维护--------------------------------------------------
	/**
	 * 初始化公司名称查询
	 */
	public String initRegionSel() {
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
			return "regionSel";
		}
		
		
		
		return SUCCESS;
	}
	
	/**
	 * 区域名称查询
	 */
	public String regionSel() {
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
		
		String id = Utility.getName(request.getParameter("id"));
		String name = Utility.getName(request.getParameter("name"));
		
		request.setAttribute("id",id);
		request.setAttribute("name",name);
		
		CompanyNamePo po = new CompanyNamePo();
		po.setFcnjrid(id);
		po.setFcnjrname(name);
		
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
		
		int count = companyNameMgr.getRegionCount(po);
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
			companyNamePos = companyNameMgr.getRegionList(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			companyNamePos = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化新增区域名称
	 */
	public String initInsertRegion() {
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
		
		return SUCCESS;
	}
	
	/**
	 * 初始化新增区域名称
	 */
	public String initUpdateRegion() {
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
		
		String cid = Utility.getName(request.getParameter("cid"));
		
		CompanyNamePo po = new CompanyNamePo();
		po.setFcnjrid(cid);
		companyNamePo = companyNameMgr.getRegion(po);
		
		return SUCCESS;
	}
	
	public String insertRegion(){

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
		logPo.setsLogContent("区域名称:" + Utility.getName(companyNamePo.getFcnjrname()) + "新增!");		
		
		CompanyNamePo cpo = companyNameMgr.getRegion(companyNamePo);
		
		if(!"".equals(Utility.getName(cpo.getFcnjrid()))){
			String message = "区域编码重复！";
			this.clearMessages();
			this.addActionMessage(message);
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return "error";
		}else{
			companyNameMgr.insertRegion(companyNamePo,logPo);			
			this.addActionMessage(getText("struts.messages.save.sucess"));
	
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE13);
			
			return SUCCESS;
		}
	}
	
	public String updateRegion(){

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
		logPo.setsLogContent("区域名称:" + Utility.getName(companyNamePo.getFcnjrname()) + "修改!");
		
		companyNameMgr.updateRegion(companyNamePo,logPo);			
		this.addActionMessage(getText("struts.messages.save.sucess"));

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE13);
		
		return SUCCESS;
	}

	public String initDeleteRegion(){

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
		
		String fcnjrid = Utility.getName(request.getParameter("cid"));
        
        CompanyNamePo po = new CompanyNamePo();
		po.setFcnjrid(fcnjrid);
		companyNamePo = companyNameMgr.getRegion(po);
        
		return "success";
	}
	
	public String deleteRegion(){
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
		
		String fcnjrid = Utility.getName(request.getParameter("fcnjrid"));
		String fcnjrname = Utility.getName(request.getParameter("fcnjrname"));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("区域名称:" + fcnjrname + "删除!");		
		
		CompanyNamePo po = new CompanyNamePo();
		po.setFcnregionid(fcnjrid);
		
        String message = companyNameMgr.deleteRegion(po,logPo);
        
		if("".equals(message)){
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}else{
			this.clearMessages();
			this.addActionMessage(message);
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}
	}
	
	/**
	 * 区域下载加载信息
	 * @return
	 */
	public String initDownloadRegion(){

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
		
		String fcnjrid = Utility.getName(request.getParameter("cid"));
        
        CompanyNamePo po = new CompanyNamePo();
		po.setFcnId(fcnjrid);
		companyNamePo = companyNameMgr.getCompanyName(po);
        
		return "success";
	}
	
	/**
	 * 区域下载
	 * @return
	 */
	public String downloadRegion(){
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
		
		String fcnjrid = Utility.getName(request.getParameter("fcnjrid"));
		String fcnjrname = Utility.getName(request.getParameter("fcnjrname"));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("公司名称:" + fcnjrname + "下载!");		
		
		CompanyNamePo po = new CompanyNamePo();
		po.setFcnId(fcnjrid);
		
        String message = companyNameMgr.noInsertCompanyPoForDownload(po, logPo);
        
		if("".equals(message)){
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}else{
			this.clearMessages();
			this.addActionMessage(message);
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}
	}
	
	/**
	 * 初始化公司制造商配置
	 */
	public String initUpdateCompanyAgent() {
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
		
		String cid = Utility.getName(request.getParameter("cid"));
		
		CompanyNamePo po = new CompanyNamePo();
		po.setFcnId(cid);
		companyNamePo = companyNameMgr.getCompanyName(po);
		
		regionPos = companyNameMgr.getRegionListForSelect();
		
		CompanyNamePo tpo = new CompanyNamePo();
		tpo.setFcnId(cid);
		companySupplierList = companyNameMgr.getCompanySupplierList(tpo);
		
		SupplierPo spo = new SupplierPo();
		companySupplierAgentList = companyNameMgr.getCompanySupplierAgentList(spo);
		
		return SUCCESS;
	}
	
	
	/**
	 * 公司制造商配置
	 */
	public String updateCompanyAgent() {
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
		
		
		List<CompanyNamePo> cpos = new ArrayList<CompanyNamePo>();
		
		for(int i=0; i<companyNamePo.getFcnjcssupplieragentids().length; i++){
			if(!"".equals(Utility.getName(companyNamePo.getFcnjcssupplieragentids()[i]))){
				CompanyNamePo cpo = new CompanyNamePo();
				cpo.setFcnjcscompanyid(companyNamePo.getFcnId());
				cpo.setFcnjcssupplierid(companyNamePo.getFcnjcssupplierids()[i]);
				cpo.setFcnjcssupplieragentid(companyNamePo.getFcnjcssupplieragentids()[i]);
				cpo.setFcnjcsqc(companyNamePo.getFcnjcsqcs()[i]);
				cpo.setFcnjcsyf(companyNamePo.getFcnjcsyfs()[i]);
				cpo.setFcnjcszq(companyNamePo.getFcnjcszqs()[i]);
				
				cpos.add(cpo);
			}
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("公司供货商配置:" + Utility.getName(companyNamePo.getFcnName()) + "配置!");		
		
		companyNameMgr.insertCompanyAgent(cpos, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE13);
		
		return SUCCESS;
	}
	
	/**
	 * 区域下载加载信息
	 * @return
	 */
	public String initDownloadRegionAndCompany(){
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
		
		CompanyNamePo tcpo = new CompanyNamePo();
		
		List<CompanyNamePo> regionPos = downloadRegionMgr.noGetRegionList(tcpo);
		
		request.setAttribute("regionPos",regionPos);
        
		return "success";
	}
	
	/**
	 * 区域下载
	 * @return
	 */
	public String downloadRegionAndCompany(){
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
		logPo.setsLogContent("区域与公司绑定关系下载!");		
		
        String message = companyNameMgr.noInsertRegionAndCompany(companyNamePo, logPo);
        
		this.clearMessages();
		this.addActionMessage(message);
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void getAjaxCompanyPos() throws Exception {
		String rid = request.getParameter("rid");
		
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(rid.equals("")){
			out.println("<option value=''>----请选择----</option>");
		}else{

			CompanyNamePo tcpo = new CompanyNamePo();
			tcpo.setFcnjrid(rid);
			List<CompanyNamePo> companyNamePos = downloadRegionMgr.noGetCompanyList(tcpo);
			Iterator<CompanyNamePo> it = companyNamePos.iterator();
			out.println("<option value=''>---请选择("+ companyNamePos.size() + ")---</option>");
			if (it.hasNext()) {
				while (it.hasNext()) {
					CompanyNamePo companyNamePo=it.next();
					out.println("<option value='" + companyNamePo.getFcnId()+ "' >"+companyNamePo.getFcnName()+"</option>");
				}
			}
		}
		out.close();			
	}
}
