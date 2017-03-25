package com.pengsheng.eims.hydsycasehistory.action;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.hydsycasehistory.mgr.EyesCheckHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.EyesCheckPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
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

public class EyesCheckHydsyAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;
	
	private EyesCheckPo eyesCheckPo;

	private EyesCheckHydsyMgr eyesCheckHydsyMgr;

	private List<EyesCheckPo> eyesChecklist;
	
	private List<OptionParamPo> optionParamPolist;

	private OptionParamMgr optionParamMgr;;

	private List<RegisteredCategoryPo> eyeslist;

	private CustomerInfoPo customerInfoPo;

	private CustomerInfoMgr customerInfoMgr;

	private String isFirstExec;

	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
	/**
	 * 初始化眼部健康检查查询
	 */
	public String initEyesCheckSelN() throws Exception {

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
		
		String smecimemberid = request.getParameter("smecimemberid");
		
		request.setAttribute("smecimemberid", smecimemberid);
		
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
	public String selEyesCheckN() throws Exception {
		
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

		String memberid = Utility.getName(request.getParameter("memberid"));
		String customername = Utility.getName(request.getParameter("customername"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String personid = Utility.getName(request.getParameter("personid"));
		
		EyesCheckPo po = new EyesCheckPo();
		po.setSopeccustomerpostcode(memberid);
		po.setSopeccustomername(customername);
		po.setStartTime(startTime);
		po.setEndTime(endTime);
		po.setSopecpersonid(personid);
		
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
		
		int count = eyesCheckHydsyMgr.getEyesCheckCount(po);
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
			eyesChecklist = eyesCheckHydsyMgr.getEyesCheckList(po, page.getStart(),
					page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			eyesChecklist = null;
		}
		request.setAttribute("memberid", memberid);
		request.setAttribute("customername", customername);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("personid", personid);
		
		String smecimemberid = request.getParameter("smecimemberid");
		request.setAttribute("smecimemberid", smecimemberid);

		return SUCCESS;
	}

	/**
	 * 初始化眼部健康检查新增
	 */
	public String initEyesCheckInsertN() throws Exception 
	{
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		request.setAttribute("moduleID", moduleID);
		return SUCCESS;
	}

	/**
	 * 查询眼部健康检查人员
	 */
	public String selEyesCheckForCustomerN() throws Exception {
		String id = Utility.getName(request.getParameter("smecimemberid"));
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		if (id.equals("")){
			customerInfoPo = new CustomerInfoPo();
		}else{
			CustomerInfoPo po = new CustomerInfoPo();
			po.setSmecimemberid(id);
			customerInfoPo = customerInfoMgr.getCustomerInfo(po);
		}

		if (customerInfoPo.getSmecicustomerid() == null) {
			this.clearMessages();
			this.addActionMessage(getText("customer.select.err"));
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
		
		eyesCheckPo = eyesCheckHydsyMgr.getEyesCheck(po1);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 新增眼部健康检查
	 */
	public String insertEyesCheckN() throws Exception {
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

		if(eyesCheckPo.getSopecfruit().equals("0")){
			eyesCheckPo.setSopecillstype("");
			eyesCheckPo.setSopecills("");
			eyesCheckPo.setSopecillsConent("");
		}else if(eyesCheckPo.getSopecfruit().equals("1")){
			if(Utility.getName(eyesCheckPo.getSopecillstype()).equals("")){
				eyesCheckPo.setSopecills("");
				eyesCheckPo.setSopecillsConent("");
			}else if(Utility.getName(eyesCheckPo.getSopecillstype()).equals("1")){
				eyesCheckPo.setSopecillsConent("");
			}else{
				eyesCheckPo.setSopecills("");		
			}
		}
		eyesCheckHydsyMgr.insertEyesCheck(eyesCheckPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("url", "'initEyesCheckInsertHydsy.action?moduleID="+moduleID+"'");
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}

	/**
	 * 眼部健康检查详细
	 */
	public String detailEyesCheckN() throws Exception {
		String id = Utility.getName(request.getParameter("hid"));
		String sopecid = Utility.getName(request.getParameter("sopecid"));
		EyesCheckPo po = new EyesCheckPo();
		po.setSopecid(sopecid);
		po.setSopeccustomerid(id);
		eyesCheckPo = eyesCheckHydsyMgr.getEyesCheck(po);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 初始化眼部健康查询费用提交
	 */
	public String initEyesChargePutInsertN() throws Exception {

		return SUCCESS;
	}

	/**
	 * 查询费用提交
	 */
	public String selEyesChargePutN() throws Exception {

		String memberid = Utility.getName(request.getParameter("memberid"));
		String feeType = Utility.getName(request.getParameter("feeType"));

		RegisteredCategoryPo po = new RegisteredCategoryPo();
		po.setFrcfeetype(feeType);
//		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
//		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = eyesCheckHydsyMgr.getEyesChargePutCount(po);
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
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
			Pagination page = new Pagination(request, count, perPage);
			eyeslist = eyesCheckHydsyMgr.getEyesChargePutList(po, page.getStart(),
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
	
	public List<OptionParamPo> getOptionParamPolist() {
		return optionParamPolist;
	}

	public void setOptionParamPolist(List<OptionParamPo> optionParamPolist) {
		this.optionParamPolist = optionParamPolist;
	}

	public OptionParamMgr getOptionParamMgr() {
		return optionParamMgr;
	}

	public void setOptionParamMgr(OptionParamMgr optionParamMgr) {
		this.optionParamMgr = optionParamMgr;
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

	public EyesCheckHydsyMgr getEyesCheckHydsyMgr() {
		return eyesCheckHydsyMgr;
	}

	public void setEyesCheckHydsyMgr(EyesCheckHydsyMgr eyesCheckHydsyMgr) {
		this.eyesCheckHydsyMgr = eyesCheckHydsyMgr;
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
