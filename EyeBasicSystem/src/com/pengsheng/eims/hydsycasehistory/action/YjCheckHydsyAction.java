package com.pengsheng.eims.hydsycasehistory.action;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.hydsycasehistory.mgr.YjCheckHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.EyesCheckPo;
import com.pengsheng.eims.hydsycasehistory.persistence.YjCheckPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.ColorPo;
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

public class YjCheckHydsyAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;

	private CustomerInfoPo customerInfoPo;
	
	private YjCheckPo yjCheckPo;
	
	private List<YjCheckPo> yjChecklist;

	private YjCheckHydsyMgr yjCheckHydsyMgr;
	
	private CustomerInfoMgr customerInfoMgr;

	private String isFirstExec;

	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private List<OptionParamPo> optionParamPolist;

	private OptionParamMgr optionParamMgr;
	/**
	 * 初始化眼肌检查查询
	 */
	public String initYJCheckSel() throws Exception {

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
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "yjCheckSel";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 眼肌检查查询
	 */
	public String yjCheckSel() throws Exception {

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
		String customerphone = Utility.getName(request.getParameter("customerphone"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		
		YjCheckPo po = new YjCheckPo();
		po.setSopyjcustomerid(memberid);
		po.setSopyjcustomername(customername);
		po.setStartTime(startTime);
		po.setEndTime(endTime);
		po.setSopyjcustomerphone(customerphone);
		
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
		
		int count = yjCheckHydsyMgr.getYjCheckCount(po);
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
			yjChecklist = yjCheckHydsyMgr.getYjCheckList(po, page.getStart(),
					page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			yjChecklist = null;
		}
		request.setAttribute("memberid", memberid);
		request.setAttribute("customername", customername);
		request.setAttribute("customerphone", customerphone);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		return SUCCESS;		
	}
	/**
	 * 初始化眼肌检查新增
	 */
	public String initYjCheckInsert() throws Exception 
	{
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		request.setAttribute("moduleID", moduleID);
		return SUCCESS;
	}

	/**
	 * 初始化眼部健康检查中的眼肌检查新增
	 */
	public String selectYjCheckEyesCheck() throws Exception 
	{
		String id = Utility.getName(request.getParameter("smecimemberid"));
		if(!id.equals("")){
			CustomerInfoPo po = new CustomerInfoPo();
			po.setSmecimemberid(id);
			customerInfoPo = customerInfoMgr.getCustomerInfo(po);
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
			
			YjCheckPo yjCheckPoTmp = new YjCheckPo();
			yjCheckPoTmp.setSopyjcustomerid(customerInfoPo.getSmecicustomerid());

			yjCheckPo = yjCheckHydsyMgr.getLastYjCheck(yjCheckPoTmp);	
		}
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}
	
	/**
	 * 查询眼肌检查人员
	 */
	public String selYjCheckForCustomer() throws Exception {
		String id = Utility.getName(request.getParameter("smecimemberid"));
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		CustomerInfoPo po = new CustomerInfoPo();
		po.setSmecimemberid(id);
		customerInfoPo = customerInfoMgr.getCustomerInfo(po);
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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 新增眼肌检查
	 */
	public String insertYjCheck() throws Exception {
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
		
		yjCheckPo.setSopyjshopcode(personInfoPo.getDepartmentID());
		yjCheckPo.setSopyjpersonid(personInfoPo.getId());

		String smecimemberid = request.getParameter("smecimemberid");
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 眼肌检查新增
		logPo.setsLogContent("眼肌检查会员卡号："+smecimemberid+" 新增");

		yjCheckHydsyMgr.insertYjCheck(yjCheckPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	/**
	 * 新增眼部健康中的眼肌检查
	 */
	public String insertEyeCheckYjCheck() throws Exception {
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
		
		yjCheckPo.setSopyjshopcode(personInfoPo.getDepartmentID());
		yjCheckPo.setSopyjpersonid(personInfoPo.getId());

		String smecimemberid = request.getParameter("smecimemberid");
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 眼肌检查新增
		logPo.setsLogContent("眼肌检查会员卡号："+smecimemberid+" 新增");

		yjCheckHydsyMgr.insertYjCheck(yjCheckPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		request.setAttribute("moduleID", moduleID);
		request.setAttribute("smecimemberid", smecimemberid);
		return "yjcheckSel";
	}
	
	/**
	 * 眼肌检查详细
	 */
	public String detailYjCheck() throws Exception {
		String id = Utility.getName(request.getParameter("hid"));

		YjCheckPo po = new YjCheckPo();
		po.setSopyjid(id);

		yjCheckPo = yjCheckHydsyMgr.getYjCheck(po);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化删除
	 */
	public String initDeleteYjCheck()throws Exception{
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
		
		String id = Utility.getName(request.getParameter("hid"));

		YjCheckPo po = new YjCheckPo();
		po.setSopyjid(id);
		
		yjCheckPo = yjCheckHydsyMgr.getYjCheck(po);

		return SUCCESS;
	}
	
	/**
	 * 删除
	 */
	public String deleteYjCheck()throws Exception{
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
		

		String id = Utility.getName(request.getParameter("hid"));

		YjCheckPo po = new YjCheckPo();
		po.setSopyjid(id);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("2");    		// 表示状态
		logPo.setsLogContent("眼肌数据ID："+id+"删除。");
		
		yjCheckHydsyMgr.deleteYjCheck(po, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

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

	public YjCheckPo getYjCheckPo() {
		return yjCheckPo;
	}

	public void setYjCheckPo(YjCheckPo yjCheckPo) {
		this.yjCheckPo = yjCheckPo;
	}

	public YjCheckHydsyMgr getYjCheckHydsyMgr() {
		return yjCheckHydsyMgr;
	}

	public void setYjCheckHydsyMgr(YjCheckHydsyMgr yjCheckHydsyMgr) {
		this.yjCheckHydsyMgr = yjCheckHydsyMgr;
	}

	public List<YjCheckPo> getYjChecklist() {
		return yjChecklist;
	}

	public void setYjChecklist(List<YjCheckPo> yjChecklist) {
		this.yjChecklist = yjChecklist;
	}
}
