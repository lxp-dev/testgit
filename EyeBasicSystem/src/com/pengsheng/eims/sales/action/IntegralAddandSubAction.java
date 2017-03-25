package com.pengsheng.eims.sales.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.components.mgr.DelaysReminderMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.mgr.IntegralAddandSubMgr;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class IntegralAddandSubAction extends BaseAction{
	
	private IntegralAddandSubPo integralAddandSubPo;
	private IntegralAddandSubMgr integralAddandSubMgr;
	private List<IntegralAddandSubPo> integralAddandSubPos;
	private PersonPermissionMgr personPermissionMgr;
	private UnitMgr unitMgr;
	private NoteTemplatePo noteTemplatePo;	
	private CustomerInfoMgr customerInfoMgr;
	private DelaysReminderMgr delaysReminderInformMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	
	public String initSelectIntegralAddandSub(){
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
			return "selecttype";
		}
		
		return SUCCESS;
	}
	
	public String selectIntegralAddandSub(){
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
		
		String smeasmemberidt = Utility.getName(request.getParameter("smeasmemberidt"));
		String smeascustomernamet = Utility.getName(request.getParameter("smeascustomernamet"));
		String smeascustomerphonet = Utility.getName(request.getParameter("smeascustomerphonet"));
		String smeasdopersonnamet = Utility.getName(request.getParameter("smeasdopersonnamet"));
		String smeasdobegindatet = Utility.getName(request.getParameter("smeasdobegindatet"));
		String smeasdoenddatet = Utility.getName(request.getParameter("smeasdoenddatet"));
		String smeasissendmessaget = Utility.getName(request.getParameter("smeasissendmessaget"));
		String smeasaddorsubt = Utility.getName(request.getParameter("smeasaddorsubt"));
		String smeassalesbillt = Utility.getName(request.getParameter("smeassalesbillt"));
		
		request.setAttribute("smeassalesbillt", smeassalesbillt);
		
		IntegralAddandSubPo po = new IntegralAddandSubPo();
		po.setSmeasmemberid(smeasmemberidt);
		po.setSmeascustomername(smeascustomernamet);
		po.setSmeascustomerphone(smeascustomerphonet);
		po.setSmeasdopersonname(smeasdopersonnamet);
		po.setSmeasdobegindate(smeasdobegindatet);
		po.setSmeasdoenddate(smeasdoenddatet);
		po.setSmeasissendmessage(smeasissendmessaget);
		po.setSmeasaddorsub(smeasaddorsubt);
		po.setSmeassalesbill(smeassalesbillt);
		po.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));

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
		
		int count = integralAddandSubMgr.selectIntegralAddandSubCount(po);
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
		    integralAddandSubPos = integralAddandSubMgr.selectIntegralAddandSubList(po,page.getStart(),page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			integralAddandSubPos = null;
		}
		
		request.setAttribute("smeasmemberidt", smeasmemberidt);
		request.setAttribute("smeascustomernamet", smeascustomernamet);
		request.setAttribute("smeascustomerphonet", smeascustomerphonet);
		request.setAttribute("smeasdopersonnamet", smeasdopersonnamet);
		request.setAttribute("smeasdobegindatet", smeasdobegindatet);
		request.setAttribute("smeasdoenddatet", smeasdoenddatet);
		request.setAttribute("smeasissendmessaget", smeasissendmessaget);
		request.setAttribute("smeasaddorsubt", smeasaddorsubt);
		
		return SUCCESS;
	}
	
	public String initInsertIntegralAddandSub() throws Exception{
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
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		NoteTypePo npo=unitMgr.getNoteTypePo("2");
		NoteTemplatePo po2 = new NoteTemplatePo();
		po2.setBntname("2");
		po2.setBntautosend("1");
		NoteTemplatePo noteTemplatePo = unitMgr.getNoteTemplateType(po2);
		
		request.setAttribute("first", systemParameterPo.getFspshortmessage());
		request.setAttribute("second", npo.getBntautosend());
		request.setAttribute("content", noteTemplatePo.getBntcontent());
		return SUCCESS;
	}
	
	public String insertIntegralAddandSub() throws Exception{
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
		
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String uuid = personInfoPo.getDepartmentID()
		+ personInfoPo.getMachinery() + numHeadFormat.format(new Date());
		
		String isSend = Utility.getName(request.getParameter("isSend"));
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		integralAddandSubPo.setSmeasuuid(uuid);
		integralAddandSubPo.setSmeasdopersonid(createPerson);
		
		BigDecimal yintegral = new BigDecimal(integralAddandSubPo.getSmeasyintegral());
		BigDecimal cintegral = new BigDecimal(integralAddandSubPo.getSmeascintegral());
		yintegral = yintegral.add(cintegral);
		yintegral = yintegral.setScale(2, BigDecimal.ROUND_HALF_UP);
		integralAddandSubPo.setSmeasxintegral(yintegral.toString());
		
		if(cintegral.intValue() > 0){
			integralAddandSubPo.setSmeasaddorsub("1");
		}else{
			integralAddandSubPo.setSmeasaddorsub("2");
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecicustomerid(Utility.getName(integralAddandSubPo.getSmeascustomerid()));
		customerInfoPo.setSmecimemberid(Utility.getName(integralAddandSubPo.getSmeasmemberid()));
		
		int count = customerInfoMgr.getCustomerInfoCount2(customerInfoPo);		
		if (count == 0){
			request.setAttribute("errormsg","2");
			return ERROR;
		}
				
		//插入积分增减表
		integralAddandSubMgr.insertIntegralAddandSubPo(integralAddandSubPo,personInfoPo,smsRecordPo,isSend,logPo);
		
		this.clearMessages();
		this.addActionMessage("积分赠送成功！");
		request.setAttribute("flag", "openUpdate");
		
		return SUCCESS;
	}
	
	public String initSelectIntegralAddandSubDetails() throws Exception{
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
		
		String smeasuuid = Utility.getName(request.getParameter("smeasuuid"));
		
		IntegralAddandSubPo po = new IntegralAddandSubPo();
		po.setSmeasuuid(smeasuuid);
		
		integralAddandSubPo = integralAddandSubMgr.selectIntegralAddandSubPo(po);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		
		return SUCCESS;
	}
	
	/**
	 * 新增页面回车查询会员
	 * @return
	 * @throws Exception
	 */
	public String integralCustomerSel() throws Exception{
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
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		CustomerInfoPo po = new CustomerInfoPo();
		po.setSmecimemberid(Utility.getName(integralAddandSubPo.getSmeasmemberid()));
		int count = customerInfoMgr.getCount(po);
		if (count == 0){
			request.setAttribute("errormsg","1");
			return SUCCESS;
		}
		CustomerInfoPo customerInfoPo = customerInfoMgr.getCustomerInfo(po);
		
		if(!customerInfoPo.getSmecifcustomerid().equals("")){
			po = new CustomerInfoPo();
			po.setSmecicustomerid(customerInfoPo.getSmecifcustomerid());
			customerInfoPo = customerInfoMgr.getCustomerInfo(po);
			request.setAttribute("errormsg","3");
		}

		integralAddandSubPo.setSmeasyintegral(Utility.getName(customerInfoPo.getSmeciintegral()));
		integralAddandSubPo.setSmeascustomerid(Utility.getName(customerInfoPo.getSmecicustomerid()));
		integralAddandSubPo.setSmeascustomername(Utility.getName(customerInfoPo.getSmeciname()));
		integralAddandSubPo.setSmeascustomerphone(Utility.getName(customerInfoPo.getSmeciphone()));
		integralAddandSubPo.setSmeasmemberid(Utility.getName(customerInfoPo.getSmecimemberid()));		
		
		return SUCCESS;
	}
	
	public IntegralAddandSubPo getIntegralAddandSubPo() {
		return integralAddandSubPo;
	}

	public void setIntegralAddandSubPo(IntegralAddandSubPo integralAddandSubPo) {
		this.integralAddandSubPo = integralAddandSubPo;
	}

	public IntegralAddandSubMgr getIntegralAddandSubMgr() {
		return integralAddandSubMgr;
	}

	public void setIntegralAddandSubMgr(IntegralAddandSubMgr integralAddandSubMgr) {
		this.integralAddandSubMgr = integralAddandSubMgr;
	}

	public List<IntegralAddandSubPo> getIntegralAddandSubPos() {
		return integralAddandSubPos;
	}

	public void setIntegralAddandSubPos(
			List<IntegralAddandSubPo> integralAddandSubPos) {
		this.integralAddandSubPos = integralAddandSubPos;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	public NoteTemplatePo getNoteTemplatePo() {
		return noteTemplatePo;
	}

	public void setNoteTemplatePo(NoteTemplatePo noteTemplatePo) {
		this.noteTemplatePo = noteTemplatePo;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public DelaysReminderMgr getDelaysReminderInformMgr() {
		return delaysReminderInformMgr;
	}

	public void setDelaysReminderInformMgr(DelaysReminderMgr delaysReminderInformMgr) {
		this.delaysReminderInformMgr = delaysReminderInformMgr;
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
	
}
