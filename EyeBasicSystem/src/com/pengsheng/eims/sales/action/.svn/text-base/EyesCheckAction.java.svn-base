package com.pengsheng.eims.sales.action;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.EyesCheckMgr;
import com.pengsheng.eims.sales.persistence.EyesCheckPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class EyesCheckAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;
	
	private EyesCheckPo eyesCheckPo;

	private EyesCheckMgr eyesCheckMgr;

	private List<EyesCheckPo> eyesChecklist;

	private List<RegisteredCategoryPo> eyeslist;

	private CustomerInfoPo customerInfoPo;

	private CustomerInfoMgr customerInfoMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
		
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

	public List<RegisteredCategoryPo> getEyeslist() {
		return eyeslist;
	}

	public void setEyeslist(List<RegisteredCategoryPo> eyeslist) {
		this.eyeslist = eyeslist;
	}

	public EyesCheckPo getEyesCheckPo() {
		return eyesCheckPo;
	}

	public void setEyesCheckPo(EyesCheckPo eyesCheckPo) {
		this.eyesCheckPo = eyesCheckPo;
	}

	public EyesCheckMgr getEyesCheckMgr() {
		return eyesCheckMgr;
	}

	public void setEyesCheckMgr(EyesCheckMgr eyesCheckMgr) {
		this.eyesCheckMgr = eyesCheckMgr;
	}

	public List<EyesCheckPo> getEyesChecklist() {
		return eyesChecklist;
	}

	public void setEyesChecklist(List<EyesCheckPo> eyesChecklist) {
		this.eyesChecklist = eyesChecklist;
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

	/**
	 * 初始化眼部健康检查查询
	 */
	public String initEyesCheckSel() throws Exception {

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
			return "eyescSel";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询眼部健康检查
	 */
	public String selEyesCheck() throws Exception {
		
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
		
		String memberid = Utility.getName(request.getParameter("memberid"));
		String customername = Utility.getName(request.getParameter("customername"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		
		EyesCheckPo po = new EyesCheckPo();
		po.setSopeccustomerpostcode(memberid);
		po.setSopeccustomername(customername);
		po.setStartTime(startTime);
		po.setEndTime(endTime);
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
		
		int count = eyesCheckMgr.getEyesCheckCount(po);
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
			eyesChecklist = eyesCheckMgr.getEyesCheckList(po, page.getStart(),
					page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			eyesChecklist = null;
		}
		request.setAttribute("memberid", memberid);
		request.setAttribute("customername", customername);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);

		return SUCCESS;
	}

	/**
	 * 初始化眼部健康检查新增
	 */
	public String initEyesCheckInsert() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		return SUCCESS;
	}

	/**
	 * 查询眼部健康检查人员
	 */
	public String selEyesCheckForCustomer() throws Exception {
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
		
		String id = Utility.getName(request.getParameter("smecimemberid"));

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		CustomerInfoPo po = new CustomerInfoPo();
		po.setSmecimemberid(id);
		po.setSmeciflag("1");
		po.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
		
		customerInfoPo = customerInfoMgr.getCustomerInfo(po);
		
		if (customerInfoPo.getSmecicustomerid() == null) {
			this.clearMessages();
			this.addActionMessage("查无此会员或该会员卡已被停用!");
			return SUCCESS;
		}
		if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
			String birthdayYear = customerInfoPo.getSmecibirthday()
					.substring(0, 4);
			int age = Calendar.getInstance().get(Calendar.YEAR)
					- Integer.parseInt(birthdayYear);
			customerInfoPo.setFmmage(Integer.toString(age));
		}
		EyesCheckPo po1 = new EyesCheckPo();
		po1.setSmecimemberid(id);
		
		eyesCheckPo = eyesCheckMgr.getEyesCheck(po1);
		
		return SUCCESS;
	}

	/**
	 * 新增眼部健康检查
	 */
	public String insertEyesCheck() throws Exception {
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
		
		eyesCheckPo.setSopecshopcode(personInfoPo.getDepartmentID());
		eyesCheckPo.setSopecpersonid(personInfoPo.getId());

		String smecimemberid = request.getParameter("smecimemberid");
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 眼部检查新增
		logPo.setsLogContent("眼部健康检查会员卡号："+smecimemberid+" 新增");

		eyesCheckMgr.insertEyesCheck(eyesCheckPo,logPo);

//		this.clearMessages();
//		this.addActionMessage(getText("struts.messages.insert.sucess"));
//		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("url", "'initEyesCheckInsert.action?moduleID="+moduleID+"'");
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}

	/**
	 * 眼部健康检查详细
	 */
	public String detailEyesCheck() throws Exception {
		String id = Utility.getName(request.getParameter("hid"));
		String sopecid = Utility.getName(request.getParameter("sopecid"));
		EyesCheckPo po = new EyesCheckPo();
		po.setSopecid(sopecid);
		po.setSopeccustomerid(id);
		eyesCheckPo = eyesCheckMgr.getEyesCheck(po);
		return SUCCESS;
	}

	/**
	 * 初始化眼部健康查询费用提交
	 */
	public String initEyesChargePutInsert() throws Exception {

		return SUCCESS;
	}

	/**
	 * 查询费用提交
	 */
	public String selEyesChargePut() throws Exception {

		String memberid = Utility.getName(request.getParameter("memberid"));
		// String
		// customername=Utility.getName(request.getParameter("customername"));

		String feeType = Utility.getName(request.getParameter("feeType"));

		// MydriasisPo po=new MydriasisPo();
		// po.setSopmdcustomerpostcode(memberid);
		// po.setSopmdcustomername(customername);
		RegisteredCategoryPo po = new RegisteredCategoryPo();
		po.setFrcfeetype(feeType);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = eyesCheckMgr.getEyesChargePutCount(po);
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
			eyeslist = eyesCheckMgr.getEyesChargePutList(po, page.getStart(),
					page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			eyeslist = null;
		}
		request.setAttribute("memberid", memberid);
		// request.setAttribute("customername",customername);
		request.setAttribute("feeType", feeType);

		return SUCCESS;
	}
}
