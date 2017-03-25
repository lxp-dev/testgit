package com.pengsheng.eims.member.action;

import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.mgr.MemberUpGradeMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.UpgradeRecordPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class MemberUpGradeAction extends BaseAction {

	private MemberUpGradeMgr memberUpGradeMgr;	
	private CustomerInfoPo customerInfoPo;	
	private List<CustomerInfoPo> memberUpGradeList;	
	private List<MemberManagementPo> memberManageMentList;	
	private MemberManagementPo memberManagementPo;	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private UnitMgr	unitMgr;
	private UpgradeRecordPo upgradeRecordPo = null;
	private List<UpgradeRecordPo> upgradeRecordList = null;
	private CustomerInfoMgr customerInfoMgr;
	private DepartmentsMgr departmentsMgr;	
	private List<DepartmentsPo> departmentsList;
	private List<MemberManagementPo> memberManagementList = null;
	
	public List<MemberManagementPo> getMemberManagementList() {
		return memberManagementList;
	}

	public void setMemberManagementList(
			List<MemberManagementPo> memberManagementList) {
		this.memberManagementList = memberManagementList;
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

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public UpgradeRecordPo getUpgradeRecordPo() {
		return upgradeRecordPo;
	}

	public void setUpgradeRecordPo(UpgradeRecordPo upgradeRecordPo) {
		this.upgradeRecordPo = upgradeRecordPo;
	}

	public List<UpgradeRecordPo> getUpgradeRecordList() {
		return upgradeRecordList;
	}

	public void setUpgradeRecordList(List<UpgradeRecordPo> upgradeRecordList) {
		this.upgradeRecordList = upgradeRecordList;
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
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public MemberManagementPo getMemberManagementPo() {
		return memberManagementPo;
	}

	public void setMemberManagementPo(MemberManagementPo memberManagementPo) {
		this.memberManagementPo = memberManagementPo;
	}

	public List<MemberManagementPo> getMemberManageMentList() {
		return memberManageMentList;
	}

	public void setMemberManageMentList(
			List<MemberManagementPo> memberManageMentList) {
		this.memberManageMentList = memberManageMentList;
	}

	public MemberUpGradeMgr getMemberUpGradeMgr() {
		return memberUpGradeMgr;
	}

	public void setMemberUpGradeMgr(MemberUpGradeMgr memberUpGradeMgr) {
		this.memberUpGradeMgr = memberUpGradeMgr;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public List<CustomerInfoPo> getMemberUpGradeList() {
		return memberUpGradeList;
	}

	public void setMemberUpGradeList(List<CustomerInfoPo> memberUpGradeList) {
		this.memberUpGradeList = memberUpGradeList;
	}

	/**
	 * 初始化会员卡升级页面
	 * @return
	 */
	public String initMemberUpGradeSel(){
		
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
		
		//查询会员卡类型
		memberManageMentList=memberUpGradeMgr.getMemberManageMentList(memberManagementPo);
		
		if(!"1".equals(Utility.getName(permissionPo.getKeyc()))) {
			
			if("1".equals(Utility.getName(permissionPo.getKeyd()))) {
				return "initMemberHandUpGradeSel";
			}
			
			if("1".equals(Utility.getName(permissionPo.getKeye()))) {
				return "initUpGradeRecordSel";
			}
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "memberUp";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询需要升级的会员卡
	 * @return
	 */
	public String selectMemberUpGrade(){
		
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
		
		//查询会员卡类型
		memberManageMentList=memberUpGradeMgr.getMemberManageMentList(memberManagementPo);
		
		//取查询条件
		String smecimemberid=Utility.getName(request.getParameter("memberid"));
		String smeciname=Utility.getName(request.getParameter("membername"));
		String smecicardtype=Utility.getName(request.getParameter("smecicardtype"));
		String fmmup=Utility.getName(request.getParameter("fmmup"));
		String fmmdown=Utility.getName(request.getParameter("fmmdown"));
		
		customerInfoPo=new CustomerInfoPo();
		customerInfoPo.setSmecimemberid(smecimemberid);
		customerInfoPo.setSmeciname(smeciname);
		customerInfoPo.setSmecicardtype(smecicardtype);
		customerInfoPo.setFmmup(fmmup);
		customerInfoPo.setFmmdown(fmmdown);
		customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo1));
		
		request.setAttribute("memberid", smecimemberid);
		request.setAttribute("membername", smeciname);
		request.setAttribute("smecicardtype", smecicardtype);
		request.setAttribute("fmmup", fmmup);
		request.setAttribute("fmmdown", fmmdown);
				
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
		
		//总数、分页
		int count=memberUpGradeMgr.getMemberUpGradeCount(customerInfoPo);
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
	    //取详细信息
	    memberUpGradeList=memberUpGradeMgr.selectMemberUpGrade(customerInfoPo , page.getStart() , page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			memberUpGradeList = null;
		}
		return SUCCESS;
	}
	
	
	public String initupdateMemberUpGrade(){
		
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
		
		String mid=Utility.getName(request.getParameter("mid"));
		request.setAttribute("mid", mid);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		NoteTypePo npo=unitMgr.getNoteTypePo("3");
		NoteTemplatePo po2 = new NoteTemplatePo();
		po2.setBntname("3");
		po2.setBntautosend("1");
		NoteTemplatePo noteTemplatePo = unitMgr.getNoteTemplateType(po2);
		String only=Utility.getName(request.getParameter("only"));
		
		request.setAttribute("first", systemParameterPo.getFspshortmessage());
		request.setAttribute("second", npo.getBntautosend());
		request.setAttribute("content", noteTemplatePo.getBntcontent());
		request.setAttribute("only", only);
		return SUCCESS;
	}
	
	/**
	 * 更新需要升级的会员卡
	 * @return
	 */
	public String updateMemberUpGrade(){
		
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
		
		String memberUpGradeID=Utility.getName(request.getParameter("memberUpGradeID"));
		
		customerInfoPo=new CustomerInfoPo();
		customerInfoPo.setSmecimemberid(memberUpGradeID);
		
		//查询会员卡类型
		memberManageMentList=memberUpGradeMgr.getMemberManageMentList(memberManagementPo);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("会员卡号："+customerInfoPo.getSmecimemberid()+" 升级");

		customerInfoPo.setUpgradeperson(createPerson);
		customerInfoPo.setUpgradeshopcode(personInfoPo1.getDepartmentID());
		
		memberUpGradeMgr.updateMemberUpGrade(customerInfoPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 批量升级会员卡
	 * @return
	 */
	public String updateAllMemberUpGrade(){
		
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
		logPo.setsLogOpID("3");    // 会员升级		
		logPo.setsLogContent("");
		
		String mid=Utility.getName(request.getParameter("mid"));
		String isSend = Utility.getName(request.getParameter("isSend"));
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		String[] smecimemberid=mid.split(",");
		
		memberUpGradeMgr.updateAllMember(smecimemberid,smsRecordPo,isSend,personInfoPo1,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("会员卡升级成功！"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化会员卡升级记录页面
	 * @return
	 */
	public String initUpGradeRecordSel(){
		
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
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectUpGradeRecord";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询会员卡升级记录
	 * @return
	 */
	public String selectUpGradeRecord(){
		
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
		
		//取查询条件
		String smecimemberid=Utility.getName(request.getParameter("memberid"));
		String smeciname=Utility.getName(request.getParameter("membername"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		
		upgradeRecordPo=new UpgradeRecordPo();
		upgradeRecordPo.setSmecumemberid(smecimemberid);
		upgradeRecordPo.setSmecucustomername(smeciname);
		upgradeRecordPo.setSmecubgnupgradedate(startTime);
		upgradeRecordPo.setSmecuendupgradedate(endTime);
		upgradeRecordPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo1));
		
		request.setAttribute("memberid", smecimemberid);
		request.setAttribute("membername", smeciname);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		
		
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
		
		//总数、分页
		int count=memberUpGradeMgr.getUpGradeRecordCount(upgradeRecordPo);
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
	    //取详细信息
	    upgradeRecordList=memberUpGradeMgr.selectUpGradeRecordList(upgradeRecordPo , page.getStart() , page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			upgradeRecordList = null;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询会员卡升级记录详细
	 * @return
	 */
	public String upGradeRecordDetail(){
		
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
		
		String hid=Utility.getName(request.getParameter("hid"));
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		upgradeRecordPo=new UpgradeRecordPo();
		upgradeRecordPo.setSmecuid(hid);
		upgradeRecordPo = memberUpGradeMgr.getUpGradeRecordDetail(upgradeRecordPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化查询会员信息进行会员卡升级
	 */
	public String initMemberHandUpGradeSel() throws Exception {
		
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
		
    	systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "memberHandUpGradeSel";
		}
		return SUCCESS;
	}

	/**
	 * 查询会员信息进行会员卡升级
	 */
	public String memberHandUpGradeSel() throws Exception {
		
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
		
		String memberid = Utility.getName(request.getParameter("memberid"));
		String name = Utility.getName(request.getParameter("name"));
		String phone = Utility.getName(request.getParameter("phone"));
		String sex = Utility.getName(request.getParameter("sex"));
		String agemin = Utility.getName(request.getParameter("agemin"));
		String agemax = Utility.getName(request.getParameter("agemax"));
		
		String departmentID = Utility.getName(request.getParameter("departmentID"));

		CustomerInfoPo po = new CustomerInfoPo();
		po.setSmecimemberid(memberid);
		po.setSmeciname(name);
		po.setSmeciphone(phone);
		po.setSmecisex(sex);
		po.setSmeciagemin(agemin);
		po.setSmeciagemax(agemax);
		po.setSmecishopcode(departmentID);
		po.setSmecishoplist(departmentsList);

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
			memberUpGradeList = customerInfoMgr.getCustomerInfoList(po, page.getStart(), page.getPageSize());

			for (CustomerInfoPo customer : memberUpGradeList) {
				if (customer.getSmecibirthday() != null && !Utility.getName(customer.getSmecibirthday()).equals("")){
					String birthdayYear = customer.getSmecibirthday().substring(0,4);
					int age = Calendar.getInstance().get(Calendar.YEAR)- Integer.parseInt(birthdayYear);
					customer.setFmmage(Integer.toString(age));
				}
			}

			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			memberUpGradeList = null;
		}
				
		request.setAttribute("memberid", memberid);
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("sex", sex);
		request.setAttribute("agemin", agemin);
		request.setAttribute("agemax", agemax);
		request.setAttribute("departmentID", departmentID);

		return SUCCESS;
	}
	
	/**
	 * 初始化会员进行会员卡升级
	 */
	public String initMemberHandUpGradeUpdate() throws Exception {
		
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
		
		String id = Utility.getName(request.getParameter("hid"));
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecicustomerid(id);
		customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);		
		
		memberManagementList = customerInfoMgr.getMemberCardTypeList();

		return SUCCESS;
	}
	
	/**
	 * 会员进行会员卡升级
	 */
	public String memberHandUpGradeUpdate() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		customerInfoPo.setUpgradeshopcode(personInfoPo1.getDepartmentID());
		customerInfoPo.setUpgradeperson(createPerson);

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("会员卡号："+ customerInfoPo.getSmecimemberid() +"直接升级!");
		
		memberUpGradeMgr.updateMemberCardTypeUpGrade(customerInfoPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
}
