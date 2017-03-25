package com.pengsheng.eims.basic.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.DelayWarningMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.DelayNoticePo;
import com.pengsheng.eims.basic.persistence.DelayWarningPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class DelayWarningAction extends BaseAction{
	
	private PersonPermissionMgr personPermissionMgr;	
	private DelayWarningPo delayWarningPo;	
	private DelayWarningMgr delayWarningMgr;	
	private List<DelayWarningPo> delayWarningPos;	
	private List<DepartmentsPo> departmentsList;	
	private DepartmentsMgr departmentsMgr;	
	private DelayNoticePo delayNoticePo; 
	private UnitMgr unitMgr;
	private SystemParameterPo systemParameterPo;	
	private SystemParameterMgr systemParameterMgr;
	private String isFirstExec;
	
	public String initDelayWarning() throws Exception {
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
		
		delayWarningPo = delayWarningMgr.selectDelayWarningPo();
		
		return SUCCESS;
	}
	
	public String insertDelayWarning() throws Exception {
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
		
		DelayWarningPo po = new DelayWarningPo();
		
		po = delayWarningMgr.selectDelayWarningPo();
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		
		if(Utility.getName(po.getBdwuuid()) != ""){
			logPo.setsLogContent("预误期提醒设定更新!");
			
			delayWarningMgr.updateDelayWarning(delayWarningPo,logPo);
			this.clearMessages();
			this.addActionMessage("更新成功！");
		}else{
			logPo.setsLogContent("预误期提醒设定新增!");
			
			delayWarningMgr.insertDelayWarning(delayWarningPo,logPo);
			this.clearMessages();
			this.addActionMessage("新增成功！");
		}
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	public String updateDelayWarning() throws Exception {
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
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("预误期提醒设定更新!");
		
		delayWarningMgr.updateDelayWarning(delayWarningPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	public String initSelectWillDelayWarning() throws Exception {
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
		request.setAttribute("personInfoPo", personInfoPo);
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String[] str = {"1"};
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(str,"0",Utility.getName(deppo.getBdpcompanysid()));		
		delayWarningPo = delayWarningMgr.selectDelayWarningPo();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectWillDelayWarning";
		}
		
		return SUCCESS;
	}
	
	
	public String selectWillDelayWarning() throws Exception {
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
		request.setAttribute("personInfoPo", personInfoPo);
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String bdwwarningdate = request.getParameter(Utility.getName("bdwwarningdate"));
		String bdwnoticetype = request.getParameter(Utility.getName("bdwnoticetype"));
		String bdwqshopcodeid = request.getParameter(Utility.getName("bdwqshopcodeid"));
		String intransittype=Utility.getName(request.getParameter("intransittype")); 
    	String intransittype2=Utility.getName(request.getParameter("intransittype2")); 
    	String intransit=Utility.getName(request.getParameter("intransit"));  
    	String intransit2=Utility.getName(request.getParameter("intransit2")); 
    	String bdwminwarningdate=Utility.getName(request.getParameter("bdwminwarningdate")); 
    	String salesbillid=Utility.getName(request.getParameter("salesbillid")); 
    	String selbbdsupplierid=Utility.getName(request.getParameter("selbbdsupplierid")); 
    	String selbspsuppliername=Utility.getName(request.getParameter("selbspsuppliername")); 
		
		DelayWarningPo po = new DelayWarningPo();
		po.setBdwwarningdate(bdwwarningdate);
		po.setBdwminwarningdate(bdwminwarningdate);
		po.setBdwnoticetype(bdwnoticetype);
		po.setBdwqshopcodeid(bdwqshopcodeid);
		if (personInfoPo.getDepartmenttype().equals("1")){
			po.setBdwqshopcodeid(personInfoPo.getDepartmentID());
		}		
		po.setBdintransittype(intransittype);
		po.setBdintransit(intransit);
    	po.setBdintransittype2(intransittype2);
    	po.setBdintransit2(intransit2);
    	po.setBdwsalesid(salesbillid);
    	po.setSelbbdsupplierid(selbbdsupplierid);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBdwcompanyid(personInfoPo.getPersoncompanyid());
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
		
		int count = delayWarningMgr.selectDelayWarningCount(po);
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
			delayWarningPos = delayWarningMgr.selectDelayWarningList(po,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			delayWarningPos = null;
		}

		String[] str = {"1"};
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(str,"0",Utility.getName(deppo.getBdpcompanysid()));		 
		delayWarningPo = delayWarningMgr.selectDelayWarningPo();
		
		request.setAttribute("bdwwarningdate", bdwwarningdate);
		request.setAttribute("bdwnoticetype", bdwnoticetype);
		request.setAttribute("bdwqshopcodeid", bdwqshopcodeid);
		request.setAttribute("intransittype", intransittype);
		request.setAttribute("intransit", intransit);
		request.setAttribute("intransittype2", intransittype2);
		request.setAttribute("intransit2", intransit2);
		request.setAttribute("bdwminwarningdate", bdwminwarningdate);
		request.setAttribute("salesbillid", salesbillid);
		request.setAttribute("selbbdsupplierid", selbbdsupplierid);
		request.setAttribute("selbspsuppliername", selbspsuppliername);		
		
		return SUCCESS;
	}
	
	/**
	 * 委外预误期通知新增加载
	 * @return
	 * @throws Exception
	 */
	public String initInsertDelayNotice() throws Exception {
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
		request.setAttribute("personInfoPo", personInfoPo);
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String sid = request.getParameter(Utility.getName("sid"));
		
		DelayNoticePo po = new DelayNoticePo();
		po.setSmednsalesid(sid);
		delayNoticePo = delayWarningMgr.selectDelayNoticePo(po);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		NoteTypePo npo=unitMgr.getNoteTypePo("4");
		NoteTemplatePo po2 = new NoteTemplatePo();
		po2.setBntname("4");
		po2.setBntautosend("1");
		NoteTemplatePo noteTemplatePo = unitMgr.getNoteTemplateType(po2);
		
		request.setAttribute("first", systemParameterPo.getFspshortmessage());
		request.setAttribute("second", npo.getBntautosend());
		request.setAttribute("content", noteTemplatePo.getBntcontent());
		return SUCCESS;
	}
	
	/**
	 * 委外预误期通知新增
	 * @return
	 * @throws Exception
	 */
	public String insertDelayNotice() throws Exception {
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
		request.setAttribute("personInfoPo", personInfoPo);
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		delayNoticePo.setSmednpersonid(createPerson);
		
		SendNotePo snpo = new SendNotePo();
		snpo.setSnpersonid(personInfoPo.getId());
		snpo.setSndepartmentid(personInfoPo.getDepartmentID());
		snpo.setSnnotetypeid("4");
		snpo.setSnfeedbackcontent(Utility.getName(delayNoticePo.getSmednmessage()));		
		snpo.setSncustomerid(Utility.getName(delayNoticePo.getSmedncustomerid()));
		snpo.setSnbillid(Utility.getName(delayNoticePo.getSmednsalesid()));
		
		delayWarningMgr.insertDelayNotice(delayNoticePo,snpo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 委外预误期通知详细
	 * @return
	 * @throws Exception
	 */
	public String initDelayNoticeDetails() throws Exception {
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
		request.setAttribute("personInfoPo", personInfoPo);
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String sid = request.getParameter(Utility.getName("sid"));
		
		DelayNoticePo po = new DelayNoticePo();
		po.setSmednsalesid(sid);
		delayNoticePo = delayWarningMgr.selectDelayNoticePo(po);
		
		return SUCCESS;
	}
	

	public DelayWarningPo getDelayWarningPo() {
		return delayWarningPo;
	}

	public void setDelayWarningPo(DelayWarningPo delayWarningPo) {
		this.delayWarningPo = delayWarningPo;
	}

	public DelayWarningMgr getDelayWarningMgr() {
		return delayWarningMgr;
	}

	public void setDelayWarningMgr(DelayWarningMgr delayWarningMgr) {
		this.delayWarningMgr = delayWarningMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<DelayWarningPo> getDelayWarningPos() {
		return delayWarningPos;
	}

	public void setDelayWarningPos(List<DelayWarningPo> delayWarningPos) {
		this.delayWarningPos = delayWarningPos;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public DelayNoticePo getDelayNoticePo() {
		return delayNoticePo;
	}

	public void setDelayNoticePo(DelayNoticePo delayNoticePo) {
		this.delayNoticePo = delayNoticePo;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}
	
}
