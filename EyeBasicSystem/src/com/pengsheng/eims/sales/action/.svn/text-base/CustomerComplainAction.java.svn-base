package com.pengsheng.eims.sales.action;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.ComplaintsTypePo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.mgr.CustomerComplainMgr;
import com.pengsheng.eims.sales.mgr.RefundMgr;
import com.pengsheng.eims.sales.persistence.CustomerComplainPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class CustomerComplainAction extends BaseAction{
	private CustomerComplainMgr customerComplainMgr;
	private CustomerComplainPo customerComplainPo;
	private List<CustomerComplainPo> customerComplainPos;
	private PersonPermissionMgr personPermissionMgr;
	private List<ComplaintsTypePo> complaintsTypeList;
	private UnitMgr unitMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private CustomerInfoMgr customerInfoMgr;
	private RefundMgr refundMgr;
	
	/**
	 * 
	 * @return
	 */
	public String initSelectCustomerComplain(){
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
		complaintsTypeList = unitMgr.getComplaintsTypeList();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "customerCompla";
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 */
	public String selectCustomerComplain(){
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
		complaintsTypeList = unitMgr.getComplaintsTypeList();
		
		CustomerComplainPo po = new CustomerComplainPo();
		String complainid = Utility.getName(request.getParameter("complainid"));
		String memberId = Utility.getName(request.getParameter("memberId"));
		String customername = Utility.getName(request.getParameter("customername"));
		String phone = Utility.getName(request.getParameter("phone"));
		String complaintype = Utility.getName(request.getParameter("complaintype"));
		String handlepersonname = Utility.getName(request.getParameter("handlepersonname"));
		String handlestate = Utility.getName(request.getParameter("handlestate"));
		String complainbegindate = Utility.getName(request.getParameter("complainbegindate"));
		String complainenddate = Utility.getName(request.getParameter("complainenddate"));
		String intendhandlebegindate = Utility.getName(request.getParameter("intendhandlebegindate"));
		String intendhandleenddate = Utility.getName(request.getParameter("intendhandleenddate"));
		String handlebegindate = Utility.getName(request.getParameter("handlebegindate"));
		String handleenddate = Utility.getName(request.getParameter("handleenddate"));
		String registerpersonname = Utility.getName(request.getParameter("registerpersonname"));
		String linkSalesID = Utility.getName(request.getParameter("linkSalesID"));
		
		po.setComplainid(complainid);
		po.setMemberId(memberId);
		po.setCustomername(customername);
		po.setPhone(phone);
		po.setComplaintype(complaintype);
		po.setHandlepersonname(handlepersonname);
		po.setHandlestate(handlestate);
		po.setComplainbegindate(complainbegindate);
		po.setComplainenddate(complainenddate);
		po.setIntendhandlebegindate(intendhandlebegindate);
		po.setIntendhandleenddate(intendhandleenddate);
		po.setHandlebegindate(handlebegindate);
		po.setHandleenddate(handleenddate);
		po.setRegisterpersonname(registerpersonname);
		po.setSmecclinksalesid(linkSalesID);
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
		//总数、分页
		int count=customerComplainMgr.selectCustomerComplainCount(po);
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
		    customerComplainPos=customerComplainMgr.selectCustomerComplainList(po , page.getStart() , page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			customerComplainPos = null;
		}
		
		
		request.setAttribute("complainid", complainid);
		request.setAttribute("memberId", memberId);
		request.setAttribute("customername", customername);
		request.setAttribute("phone", phone);
		request.setAttribute("complaintype", complaintype);
		request.setAttribute("handlepersonname", handlepersonname);
		request.setAttribute("handlestate", handlestate);
		request.setAttribute("complainbegindate", complainbegindate);
		request.setAttribute("complainenddate", complainenddate);
		request.setAttribute("intendhandlebegindate", intendhandlebegindate);
		request.setAttribute("intendhandleenddate", intendhandleenddate);
		request.setAttribute("handlebegindate", handlebegindate);
		request.setAttribute("handleenddate", handleenddate);
		request.setAttribute("registerpersonname", registerpersonname);
		request.setAttribute("linkSalesID", linkSalesID);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 */
	public String selectCustomerComplainByCustomer(){
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
		complaintsTypeList = unitMgr.getComplaintsTypeList();
		String customerID= Utility.getName(request.getParameter("customerID"));
		CustomerInfoPo customerInfoPo=new CustomerInfoPo();
		customerInfoPo.setSmecicustomerid(customerID);
		CustomerInfoPo customer= customerInfoMgr.getCustomerInfo(customerInfoPo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		
		
		//总数、分页
		int count=customerComplainMgr.getCustomerComplainCountByCustomer(customer.getSmecimemberid());
		if (count > 0) 
		{
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
		    customerComplainPos=customerComplainMgr.getCustomerComplainListByCustomer(customer.getSmecimemberid() , page.getStart() , page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			customerComplainPos = null;
		}
		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);
		request.setAttribute("customerID", customerID);
		return SUCCESS;
	}
	
	
	
	public String initInsertCustomerComplain(){
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
		
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String complainid = "T" + personInfoPo.getDepartmentID()
		+ personInfoPo.getMachinery() + numHeadFormat.format(new Date());
		
		request.setAttribute("smeccuuid", complainid);
		
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		complaintsTypeList = unitMgr.getComplaintsTypeList();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		NoteTypePo npo=unitMgr.getNoteTypePo("10");
		NoteTemplatePo po2 = new NoteTemplatePo();
		po2.setBntname("10");
		po2.setBntautosend("1");
		NoteTemplatePo noteTemplatePo = unitMgr.getNoteTemplateType(po2);
		
		request.setAttribute("first", systemParameterPo.getFspshortmessage());
		request.setAttribute("second", npo.getBntautosend());
		request.setAttribute("content", noteTemplatePo.getBntcontent());		
		request.setAttribute("personname", personInfoPo.getPersonName());
		
		return SUCCESS;
	}
	
	public String insertCustomerComplain(){
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
		logPo.setsLogResult(moduleID); 
		logPo.setsLogOpID("1");  
		logPo.setsLogContent("顾客投诉单号："+customerComplainPo.getSmeccuuid()+" 新增");
		
		
		//主表填充值
		customerComplainPo.setSmeccregisterpersonid(createPerson);
		
		//子表填充值
		customerComplainPo.setSmechcustomercomplainid(customerComplainPo.getSmeccuuid());
		customerComplainPo.setSmechhandlepersonid(createPerson);
		
		String isSend = Utility.getName(request.getParameter("isSend"));
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		
		int count = 0;		
		if (!Utility.getName(customerComplainPo.getSmecclinksalesid()).equals("")){
			count = customerComplainMgr.getCustomerComplainBySalesBillCount(customerComplainPo);
		}
		
		if (count == 0){
			customerComplainMgr.insertCustomerComplainPo(customerComplainPo,smsRecordPo,isSend,personInfoPo,logPo);
		}else{

			this.clearMessages();
			this.addActionMessage("该配镜单已经生成投诉！");
			
			String url = "''initInsertCustomerComplain.action?moduleID={0}''";
			List<String> params = new ArrayList<String>();
			params.add(moduleID);
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);	
			
			return SUCCESS;
		}
				
		this.clearMessages();
		this.addActionMessage("新增成功！");
		request.setAttribute("flag", "openUpdate");
		
		return SUCCESS;
	}
	
	public String initHandleCustomerComplain(){
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
		
		String smechcustomercomplainid = Utility.getName(request.getParameter("smechcustomercomplainid"));
		
		CustomerComplainPo po = new CustomerComplainPo();
		
		po.setSmeccuuid(smechcustomercomplainid);
		po.setSmechcustomercomplainid(smechcustomercomplainid);
		complaintsTypeList = unitMgr.getComplaintsTypeList();
		customerComplainPo = customerComplainMgr.selectCustomerComplainPo(po);
		customerComplainPos = customerComplainMgr.selectCustomerComplainHandleList(po);
		
		return SUCCESS;
	}
	
	public String handleCustomerComplain(){
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
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 散瞳新增
		logPo.setsLogContent("顾客投诉单号："+customerComplainPo.getSmechuuid()+" 处理");
		
		customerComplainPo.setSmechhandlepersonid(createPerson);
		
		customerComplainMgr.updateCustomerComplainPo(customerComplainPo, logPo);
		
		this.clearMessages();
		this.addActionMessage("处理成功！");
		request.setAttribute("flag", "openUpdate");
		
		return SUCCESS;
	}
	
	public String initCustomerComplainDetails(){
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
		
		String smechcustomercomplainid = Utility.getName(request.getParameter("smechcustomercomplainid"));
		
		CustomerComplainPo po = new CustomerComplainPo();
		
		po.setSmeccuuid(smechcustomercomplainid);
		po.setSmechcustomercomplainid(smechcustomercomplainid);
		complaintsTypeList = unitMgr.getComplaintsTypeList();
		customerComplainPo = customerComplainMgr.selectCustomerComplainPo(po);
		customerComplainPos = customerComplainMgr.selectCustomerComplainHandleList(po);
		
		return SUCCESS;
	}
	
	public String initInsertRefunComplain() {
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
		
		complaintsTypeList = unitMgr.getComplaintsTypeList();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String complainid = "T" + personInfoPo.getDepartmentID()
		+ personInfoPo.getMachinery() + numHeadFormat.format(new Date());
		
		request.setAttribute("personname", personInfoPo.getPersonName());
		
		customerComplainPo = new CustomerComplainPo();
		customerComplainPo.setSmecclinksalesid(Utility.getName(request.getParameter("billID")));
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setFmmsalesid(customerComplainPo.getSmecclinksalesid());
		customerInfoPo = refundMgr.getCustomerInfo(customerInfoPo);
		
		customerComplainPo.setSmecccustomermemberid(Utility.getName(customerInfoPo.getSmecimemberid()));
		customerComplainPo.setSmecccustomername(Utility.getName(customerInfoPo.getSmeciname()));
		customerComplainPo.setSmecccustomerphone(Utility.getName(customerInfoPo.getSmeciphone()));
		customerComplainPo.setSmeccuuid(complainid);
		
		return SUCCESS;
	}
	
	/**
	 * @return
	 */
	public String initDeleteCustomerComplain() {
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

		String hid = Utility.getName(request.getParameter("hid"));
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	
	public String deleteCustomerComplain() {
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
		logPo.setsLogResult(moduleID); 
		logPo.setsLogOpID("1");  
		logPo.setsLogContent("顾客投诉单号："+customerComplainPo.getComplainid()+" 删除!");
		
		customerComplainMgr.deleteCustomerComplain(customerComplainPo,logPo);
		
		this.clearMessages();
		this.addActionMessage("删除成功！");
		request.setAttribute("flag", "openUpdate");
		
		return SUCCESS;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public CustomerComplainMgr getCustomerComplainMgr() {
		return customerComplainMgr;
	}
	public void setCustomerComplainMgr(CustomerComplainMgr customerComplainMgr) {
		this.customerComplainMgr = customerComplainMgr;
	}
	public CustomerComplainPo getCustomerComplainPo() {
		return customerComplainPo;
	}
	public void setCustomerComplainPo(CustomerComplainPo customerComplainPo) {
		this.customerComplainPo = customerComplainPo;
	}
	public List<CustomerComplainPo> getCustomerComplainPos() {
		return customerComplainPos;
	}
	public void setCustomerComplainPos(List<CustomerComplainPo> customerComplainPos) {
		this.customerComplainPos = customerComplainPos;
	}

	public List<ComplaintsTypePo> getComplaintsTypeList() {
		return complaintsTypeList;
	}

	public void setComplaintsTypeList(List<ComplaintsTypePo> complaintsTypeList) {
		this.complaintsTypeList = complaintsTypeList;
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

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public RefundMgr getRefundMgr() {
		return refundMgr;
	}

	public void setRefundMgr(RefundMgr refundMgr) {
		this.refundMgr = refundMgr;
	}
	
}
