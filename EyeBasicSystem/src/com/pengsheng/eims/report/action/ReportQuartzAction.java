package com.pengsheng.eims.report.action;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ReportQuartzAction extends BaseAction{
	
	private ReportQuartzMgr reportQuartzMgr = null;
	private PersonPermissionMgr personPermissionMgr = null;	
    private List<ModulePo> moduleList = null;
    private ModulePo modulePo = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private List<QuartzLogPo> quartzLogList = null;
	private FquartzSwitchPo fquartzSwitchPo;	
	
	public FquartzSwitchPo getFquartzSwitchPo() {
		return fquartzSwitchPo;
	}

	public void setFquartzSwitchPo(FquartzSwitchPo fquartzSwitchPo) {
		this.fquartzSwitchPo = fquartzSwitchPo;
	}

	public List<QuartzLogPo> getQuartzLogList() {
		return quartzLogList;
	}

	public void setQuartzLogList(List<QuartzLogPo> quartzLogList) {
		this.quartzLogList = quartzLogList;
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

	public List<ModulePo> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<ModulePo> moduleList) {
		this.moduleList = moduleList;
	}

	public ModulePo getModulePo() {
		return modulePo;
	}

	public void setModulePo(ModulePo modulePo) {
		this.modulePo = modulePo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public ReportQuartzMgr getReportQuartzMgr() {
		return reportQuartzMgr;
	}

	public void setReportQuartzMgr(ReportQuartzMgr reportQuartzMgr) {
		this.reportQuartzMgr = reportQuartzMgr;
	}

	/**
	 * 查询所有报表时英
	 * @return
	 * @throws Exception
	 */
	public String selectReportQuartzInfo() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar c = Calendar.getInstance();
	    c.add(Calendar.DATE,-1);
	    request.setAttribute("tBgnDate",sdf.format(c.getTime()));
	    request.setAttribute("tEndDate",sdf.format(c.getTime()));
	    
		ModulePo mpo = new ModulePo();
		mpo.setIsflag("1");
	    moduleList = reportQuartzMgr.getReportInfoByQuartz(mpo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化重新生成报表时英
	 */	
	public String initReportQuartzDataUpdate() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/		
		
		String hid = Utility.getName(request.getParameter("hid"));
		String bgndate = Utility.getName(request.getParameter("bgndate"));
		String enddate = Utility.getName(request.getParameter("enddate"));
		String name = Utility.getName(request.getParameter("name"));
		
		request.setAttribute("hid",hid);
		request.setAttribute("bgndate",bgndate);
		request.setAttribute("enddate",enddate);
		request.setAttribute("name",name);
		
		return SUCCESS;
	}
	
	/**
	 * 重新生成报表时英
	 */	
	public String updateReportQuartzData() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID);
		logPo.setsLogOpID("3");
		logPo.setsLogContent(Utility.getName(modulePo.getReportName()) + " 从 " + Utility.getName(modulePo.getReportBgnDate()) + " 至  " +  Utility.getName(modulePo.getReportEndDate()) + " 的数据重新汇总!");
		
		reportQuartzMgr.updateReportQuartzData(modulePo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 时英情况查看
	 */	
	public String initReportQuartzDataDetail() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String bgnDate = Utility.getName(request.getParameter("bgnDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));		
		String quartzID = Utility.getName(request.getParameter("quartzID"));
		String quartzFlag = Utility.getName(request.getParameter("quartzFlag"));
		if (quartzFlag.equals("")){
			quartzFlag = "1";
		}		
		String passsecond = Utility.getName(request.getParameter("passsecond"));
		
		QuartzLogPo logPo = new QuartzLogPo();
		logPo.setSysqllrbgndate(bgnDate);
		logPo.setSysqllrenddate(endDate);
		logPo.setSysqllrquartzid(quartzID);
		logPo.setSysqllrquartzflag(quartzFlag);
		logPo.setSysqllpasssecond(passsecond);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		

		int count = reportQuartzMgr.getReportInfoByQuartzCount(logPo);
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
			quartzLogList = reportQuartzMgr.getReportInfoByQuartzList(logPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}
		
		ModulePo mpo = new ModulePo();
		mpo.setIsflag("1");
		mpo.setIsseelogflag("1");
		moduleList = reportQuartzMgr.getReportInfoByQuartz(mpo);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.MONTH,-1);
		
		request.setAttribute("bgnDate", bgnDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("quartzID",quartzID);
		request.setAttribute("quartzFlag",quartzFlag);
		request.setAttribute("maxlastdate",currMouthFirstDay.format(calendar.getTime()));
		request.setAttribute("passsecond",passsecond);
		
		return SUCCESS;
	}

	/**
	 * 初始化时英情况开关新增
	 */	
	public String initReportQuartzDataInsert() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		fquartzSwitchPo=reportQuartzMgr.getFquartzSwitchPo();
		
		return SUCCESS;
	}
	
	/**
	 * 新增时英情况开关
	 */	
	public String insertReportQuartzData() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		reportQuartzMgr.updateFquartzSwitch(fquartzSwitchPo);
		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		String url = "''initReportQuartzDataInsert.action?moduleID={0}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}
	
}
