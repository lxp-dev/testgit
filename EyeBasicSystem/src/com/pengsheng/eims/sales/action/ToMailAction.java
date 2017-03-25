package com.pengsheng.eims.sales.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.MailingListMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.MailingListPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.mgr.ToMailMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.ToMailPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ToMailAction extends BaseAction{
	
	private List<ToMailPo> toMailPos;
	
	private ToMailMgr toMailMgr;
	
	private List<MailingListPo> mailingList;
	
	private List<SalesBasicPo> salesBasicPos;
	
	private PersonPermissionMgr personPermissionMgr;
	
	private ToMailPo toMailPo;
	
	private MailingListMgr mailingListMgr;
	
	private MailingListPo mailingListPo;
	
	private CustomerInfoPo customerInfoPo;
	
	private CustomerInfoMgr customerInfoMgr;
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private UnitMgr unitMgr;
	private List<DepartmentsPo> departmentsList;
	private DepartmentsMgr departmentsMgr;
	
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

	public MailingListMgr getMailingListMgr() {
		return mailingListMgr;
	}

	public void setMailingListMgr(MailingListMgr mailingListMgr) {
		this.mailingListMgr = mailingListMgr;
	}

	public MailingListPo getMailingListPo() {
		return mailingListPo;
	}

	public void setMailingListPo(MailingListPo mailingListPo) {
		this.mailingListPo = mailingListPo;
	}

	public List<MailingListPo> getMailingList() {
		return mailingList;
	}

	public void setMailingList(List<MailingListPo> mailingList) {
		this.mailingList = mailingList;
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

	

	

	public String initToMailSel() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "tailSel";
		}
		return SUCCESS;
	}
	
	public String toMailSel() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */
		String ssetmlinksalesid = Utility.getName(request.getParameter("ssetmlinksalesid"));
		String ssetmmemberid = Utility.getName(request.getParameter("ssetmmemberid"));
		String ssetmcustomername = Utility.getName(request.getParameter("ssetmcustomername"));
		String ssetmcustomerphone = Utility.getName(request.getParameter("ssetmcustomerphone"));
		String ssetmmailid = Utility.getName(request.getParameter("ssetmmailid"));
		String ssetmbegintime = Utility.getName(request.getParameter("ssetmbegintime"));
		String ssetmendtims = Utility.getName(request.getParameter("ssetmendtims"));
		String ssetmmaiilaudit = Utility.getName(request.getParameter("ssetmmaiilaudit"));
		
		ToMailPo po = new ToMailPo();
		po.setSsetmlinksalesid(ssetmlinksalesid);
		po.setSsetmmemberid(ssetmmemberid);
		po.setSsetmcustomername(ssetmcustomername);
		po.setSsetmcustomerphone(ssetmcustomerphone);
		po.setSsetmmailid(ssetmmailid);
		po.setSsetmbegintime(ssetmbegintime);
		po.setSsetmendtims(ssetmendtims);
		po.setSsetmmaiilaudit(ssetmmaiilaudit);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setSsetmshopcode(this.getShopCodeListByCompany(systemParameterPo,personInfoPo));	
		}
				
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
		
		int count = toMailMgr.selectToMailPosCount(po);
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
			toMailPos = toMailMgr.selectToMailPos(po, page.getStart(),
					page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			toMailPos = null;
		}
		
		request.setAttribute("ssetmlinksalesid", ssetmlinksalesid);
		request.setAttribute("ssetmmemberid", ssetmmemberid);
		request.setAttribute("ssetmcustomername", ssetmcustomername);
		request.setAttribute("ssetmcustomerphone", ssetmcustomerphone);
		request.setAttribute("ssetmmailid", ssetmmailid);
		request.setAttribute("ssetmbegintime", ssetmbegintime);
		request.setAttribute("ssetmendtims", ssetmendtims);
		request.setAttribute("ssetmmaiilaudit", ssetmmaiilaudit);
		
		return SUCCESS;
	}
	
	public String initToMailInsert() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */
		String salseID = Utility.getName(request.getParameter("salseID"));
		String smecimemberid = Utility.getName(request.getParameter("smecimemberid"));
		
		CustomerInfoPo po = new CustomerInfoPo();
		po.setSmecimemberid(smecimemberid);
		
		customerInfoPo = customerInfoMgr.getCustomerInfo(po);
		
		mailingList=mailingListMgr.getMailingList();
		
		mailingListPo=mailingListMgr.getMailingListPo();
		
		
		if(!"".equals(salseID)){
			request.setAttribute("salseID",salseID );
			
			ToMailPo po1 = new ToMailPo();
			po1.setSsetmlinksalesid(salseID);
			toMailPo = toMailMgr.selectToMailPo(po1);
			
			if(!"".equals(Utility.getName(toMailPo.getSsetmlinksalesid()))){
				return "update";
			}
			
			return "salesOpen";
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		NoteTypePo npo=unitMgr.getNoteTypePo("8");
		NoteTemplatePo po2 = new NoteTemplatePo();
		po2.setBntname("8");
		po2.setBntautosend("1");
		NoteTemplatePo noteTemplatePo = unitMgr.getNoteTemplateType(po2);
		
		request.setAttribute("first", systemParameterPo.getFspshortmessage());
		request.setAttribute("second", npo.getBntautosend());
		request.setAttribute("content", noteTemplatePo.getBntcontent());	
		
		return SUCCESS;
	}
	
	public String toMailInsert() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
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

		String ssetmcreatepensonid = personInfoPo.getId();
		String ssetmcreatepensonname = personInfoPo.getPersonName();

		if("1".equals(Utility.getName(toMailPo.getSsetmmaiilaudit()))){
			String ssetmsendpensonid = personInfoPo.getId();
			String ssetmsendpensonname = personInfoPo.getPersonName();
			
			toMailPo.setSsetmsendpensonid(ssetmsendpensonid);
			toMailPo.setSsetmsendpensonname(ssetmsendpensonname);
		}
		
		toMailPo.setSsetmcreatepensonid(ssetmcreatepensonid);
		toMailPo.setSsetmcreatepensonname(ssetmcreatepensonname);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("邮寄管理会员卡号："+toMailPo.getSsetmmemberid()+" 新增");
		String isSend = Utility.getName(request.getParameter("isSend"));
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		
		toMailMgr.insertToMailMessage(toMailPo,smsRecordPo,isSend,personInfoPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", "openUpdate");
		
		return SUCCESS;
	}
	
	public String salesOpenToMailInsert() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
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

		String ssetmcreatepensonid = personInfoPo.getId();
		String ssetmcreatepensonname = personInfoPo.getPersonName();

		if("1".equals(Utility.getName(toMailPo.getSsetmmaiilaudit()))){
			String ssetmsendpensonid = personInfoPo.getId();
			String ssetmsendpensonname = personInfoPo.getPersonName();
			
			toMailPo.setSsetmsendpensonid(ssetmsendpensonid);
			toMailPo.setSsetmsendpensonname(ssetmsendpensonname);
		}
		
		toMailPo.setSsetmcreatepensonid(ssetmcreatepensonid);
		toMailPo.setSsetmcreatepensonname(ssetmcreatepensonname);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("邮寄管理会员卡号："+toMailPo.getSsetmmemberid()+" 新增");
		
		toMailMgr.insertToMail(toMailPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", "openUpdate10");
		
		return SUCCESS;
	}
	
	public String initToMailUpdate() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取
		
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		mailingList=mailingListMgr.getMailingList();
		
		String ssetmuuid = Utility.getName(request.getParameter("ssetmuuid"));
		
		ToMailPo po = new ToMailPo();
		po.setSsetmuuid(ssetmuuid);
		
		toMailPo = toMailMgr.selectToMailPo(po);
		
		return SUCCESS;
	}
	
	public String toMailUpdate() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String ssetmcreatepensonid = personInfoPo.getId();
		String ssetmcreatepensonname = personInfoPo.getPersonName();

		if("1".equals(Utility.getName(toMailPo.getSsetmmaiilaudit()))){
			String ssetmsendpensonid = personInfoPo.getId();
			String ssetmsendpensonname = personInfoPo.getPersonName();
			
			toMailPo.setSsetmsendpensonid(ssetmsendpensonid);
			toMailPo.setSsetmsendpensonname(ssetmsendpensonname);
		}else{
			toMailPo.setSsetmmaiilaudit("0");
		}
		
		toMailPo.setSsetmcreatepensonid(ssetmcreatepensonid);
		toMailPo.setSsetmcreatepensonname(ssetmcreatepensonname);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("邮寄管理会员卡号："+toMailPo.getSsetmmemberid()+" 修改");
		
		if (Utility.getName(toMailPo.getSsetmsupportvalue()).equals("") || Utility.getName(toMailPo.getSsetmsupportvalue()).equals("0")){
			toMailPo.setSsetmissupport("");
		}	
		
		toMailMgr.updateToMail(toMailPo,logPo);
		
		this.clearMessages();
		this.addActionMessage("更新成功！");
		request.setAttribute("flag", "openUpdate");
		
		return SUCCESS;
	}
	public String salesOpenToMailUpdate() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String ssetmcreatepensonid = personInfoPo.getId();
		String ssetmcreatepensonname = personInfoPo.getPersonName();

		if("1".equals(Utility.getName(toMailPo.getSsetmmaiilaudit()))){
			String ssetmsendpensonid = personInfoPo.getId();
			String ssetmsendpensonname = personInfoPo.getPersonName();
			
			toMailPo.setSsetmsendpensonid(ssetmsendpensonid);
			toMailPo.setSsetmsendpensonname(ssetmsendpensonname);
		}
		
		toMailPo.setSsetmcreatepensonid(ssetmcreatepensonid);
		toMailPo.setSsetmcreatepensonname(ssetmcreatepensonname);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("邮寄管理会员卡号："+toMailPo.getSsetmmemberid()+" 修改");
		
		toMailMgr.updateToMail(toMailPo,logPo);
		
		this.clearMessages();
		this.addActionMessage("更新成功！");
		request.setAttribute("flag", "openUpdate10");
		
		return SUCCESS;
	}	
	public String toMailDetails() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
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
		
		String ssetmuuid = Utility.getName(request.getParameter("ssetmuuid"));
		String hid = Utility.getName(request.getParameter("hid"));
		
		ToMailPo po = new ToMailPo();
		po.setSsetmuuid(ssetmuuid);
		po.setSsetmlinksalesid(hid);
		
		toMailPo = toMailMgr.selectToMailPo(po);
		
		return SUCCESS;
	}
	
	public String initToMailOpenSalesSel() throws Exception{
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
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsList = this.getShopCodeListByCompany(systemParameterPo,personInfoPo);
		}else{
			String[] str = {"1"};
			departmentsList = departmentsMgr.getDepartments(str,"0","");
		}		
		
		request.setAttribute("departmentname", personInfoPo.getBdpdepartmentname());
		request.setAttribute("shopcode", personInfoPo.getDepartmentID());
		
		request.setAttribute("ssesbmemberid", Utility.getName(request.getParameter("memberid")));
		
		return SUCCESS;
	}
	
	public String toMailOpenSalesSel() throws Exception{
		
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
		
    	String salesid=Utility.getName(request.getParameter("salesid"));
    	String shopcode=Utility.getName(request.getParameter("shopcode"));
    	String shopName=Utility.getName(request.getParameter("shopName"));
    	String customerid=Utility.getName(request.getParameter("customerid"));
    	String ssesbmemberid=Utility.getName(request.getParameter("ssesbmemberid"));
    	String personName=Utility.getName(request.getParameter("personName"));
    	String customerName=Utility.getName(request.getParameter("customerName"));
    	String takeglassstartdata=Utility.getName(request.getParameter("takeglassstartdata"));
    	String takeglassenddata=Utility.getName(request.getParameter("takeglassenddata"));
    	
    	SalesBasicPo po = new SalesBasicPo();
    	po.setSsesbsalesid(salesid);
    	po.setSsesbcustomerid(customerid);
    	po.setSsesbMemberId(ssesbmemberid);
    	po.setSsesbpersonName(personName);
    	po.setSsesbcustomerid(customerName);
    	po.setSsesbshopcode(shopcode);
    	po.setSsesbshopName(shopName);
    	po.setSsesbtakeglassstartdata(takeglassstartdata);
    	po.setSsesbtakeglassenddata(takeglassenddata);
    	
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setSsesbcompanyid(personInfoPo.getPersoncompanyid());	
		}
		
    	systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsList = this.getShopCodeListByCompany(systemParameterPo,personInfoPo);
		}else{
			String[] str = {"1"};
			departmentsList = departmentsMgr.getDepartments(str,"0","");
		}	
    	
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
    	int count=toMailMgr.getSalesBasicCount(po);
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
		    salesBasicPos=toMailMgr.getSalesBasicList(po,page.getStart(),page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			salesBasicPos = null;
		}
		
		request.setAttribute("salesid", salesid);
		request.setAttribute("shopcode", shopcode);
		request.setAttribute("shopName", shopName);
		request.setAttribute("customerName", customerName);
		request.setAttribute("customerid", customerid);
		request.setAttribute("personName", personName);
		request.setAttribute("ssesbtakeglassstartdata", takeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata", takeglassenddata);
		request.setAttribute("departmentname", personInfoPo.getBdpdepartmentname());
		request.setAttribute("ssesbmemberid", ssesbmemberid);
		
		return SUCCESS;
	}
	
	public String initToMailDelete() throws Exception{
		
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
		String ssetmuuid = Utility.getName(request.getParameter("ssetmuuid"));
		String ssetmmemberid = Utility.getName(request.getParameter("ssetmmemberid"));
		
		request.setAttribute("ssetmuuid", ssetmuuid);
		request.setAttribute("ssetmmemberid", ssetmmemberid);
		return SUCCESS;
	}
	
	public String toMailDelete() throws Exception{
		
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
		
		String ssetmuuid = Utility.getName(request.getParameter("ssetmuuid"));
		String memberid = Utility.getName(request.getParameter("ssetmmemberid"));
		ToMailPo po = new ToMailPo();
		
		po.setSsetmuuid(ssetmuuid);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 删除
		logPo.setsLogContent("邮寄管理会员卡号："+memberid+" 删除");
		
		toMailMgr.deleteToMailPo(po,logPo);
		
		this.clearMessages();
		this.addActionMessage("删除成功！");
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initToMailSalesInsert() throws Exception{
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
		
		String ssetmlinksalesid = Utility.getName(request.getParameter("ssetmlinksalesid"));
		String ssetmcustomerphone = Utility.getName(request.getParameter("ssetmcustomerphone"));
		String ssetmcustomername = Utility.getName(request.getParameter("ssetmcustomername"));
		String ssetmmemberid = Utility.getName(request.getParameter("ssetmmemberid"));
		
		request.setAttribute("ssetmlinksalesid", ssetmlinksalesid);
		request.setAttribute("ssetmcustomerphone", ssetmcustomerphone);
		request.setAttribute("ssetmcustomername", ssetmcustomername);
		request.setAttribute("ssetmmemberid", ssetmmemberid);
		
		return SUCCESS;
	}
	
	public String toMailDetailsUpdate() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("邮寄管理会员卡号："+toMailPo.getSsetmmemberid()+" 修改");
		
		toMailMgr.updateToMailDetail(toMailPo,logPo);
		
		this.clearMessages();
		this.addActionMessage("更新成功！");
		request.setAttribute("flag", "openUpdate");
		
		return SUCCESS;
	}	
	
	public String initComplainOpenSalesSel() throws Exception{
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
		
		request.setAttribute("departmentname", personInfoPo.getBdpdepartmentname());
		request.setAttribute("shopcode", personInfoPo.getDepartmentID());
		
		request.setAttribute("ssesbmemberid", Utility.getName(request.getParameter("memberid")));
		
		return SUCCESS;
	}
	
	public String complainOpenSalesSel() throws Exception{
		
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
		
    	String salesid=Utility.getName(request.getParameter("salesid"));
    	String shopcode=Utility.getName(request.getParameter("shopcode"));
    	String shopName=Utility.getName(request.getParameter("shopName"));
    	String customerid=Utility.getName(request.getParameter("customerid"));
    	String ssesbmemberid=Utility.getName(request.getParameter("ssesbmemberid"));
    	String personName=Utility.getName(request.getParameter("personName"));
    	String customerName=Utility.getName(request.getParameter("customerName"));
    	String takeglassstartdata=Utility.getName(request.getParameter("takeglassstartdata"));
    	String takeglassenddata=Utility.getName(request.getParameter("takeglassenddata"));
    	
    	SalesBasicPo po=new SalesBasicPo();
    	po.setSsesbsalesid(salesid);
    	po.setSsesbcustomerid(customerid);
    	po.setSsesbMemberId(ssesbmemberid);
    	po.setSsesbpersonName(personName);
    	po.setSsesbcustomerid(customerName);
    	po.setSsesbshopcode(shopcode);
    	po.setSsesbshopName(shopName);
    	po.setSsesbtakeglassstartdata(takeglassstartdata);
    	po.setSsesbtakeglassenddata(takeglassenddata);
    	po.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
    	    	
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
    	int count=toMailMgr.getComplainSalesBasicCount(po);
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
		    salesBasicPos=toMailMgr.getComplainSalesBasicList(po,page.getStart(),page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			salesBasicPos = null;
		}
		
		request.setAttribute("salesid", salesid);
		request.setAttribute("shopcode", shopcode);
		request.setAttribute("shopName", shopName);
		request.setAttribute("customerName", customerName);
		request.setAttribute("customerid", customerid);
		request.setAttribute("personName", personName);
		request.setAttribute("ssesbtakeglassstartdata", takeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata", takeglassenddata);
		request.setAttribute("departmentname", personInfoPo.getBdpdepartmentname());
		request.setAttribute("ssesbmemberid", ssesbmemberid);
		
		return SUCCESS;
	}
	
	public List<SalesBasicPo> getSalesBasicPos() {
		return salesBasicPos;
	}

	public void setSalesBasicPos(List<SalesBasicPo> salesBasicPos) {
		this.salesBasicPos = salesBasicPos;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<ToMailPo> getToMailPos() {
		return toMailPos;
	}

	public void setToMailPos(List<ToMailPo> toMailPos) {
		this.toMailPos = toMailPos;
	}

	public ToMailMgr getToMailMgr() {
		return toMailMgr;
	}

	public void setToMailMgr(ToMailMgr toMailMgr) {
		this.toMailMgr = toMailMgr;
	}
	
	public ToMailPo getToMailPo() {
		return toMailPo;
	}

	public void setToMailPo(ToMailPo toMailPo) {
		this.toMailPo = toMailPo;
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

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}
	
}

