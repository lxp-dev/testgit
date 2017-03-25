package com.pengsheng.eims.system.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.RegisteredCategoryMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.RegisteredPrintDetailsPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class RegisteredCategoryAction extends BaseAction {

	// 页面List
	private List list;

	private RegisteredCategoryPo registeredCategoryPo;
	private List<RegisteredPrintDetailsPo> details;
	private RegisteredCategoryMgr registeredCategoryMgr;	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
		
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

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public RegisteredCategoryPo getRegisteredCategoryPo() {
		return registeredCategoryPo;
	}

	public void setRegisteredCategoryPo(
			RegisteredCategoryPo registeredCategoryPo) {
		this.registeredCategoryPo = registeredCategoryPo;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public List<RegisteredPrintDetailsPo> getDetails() {
		return details;
	}

	public void setDetails(List<RegisteredPrintDetailsPo> details) {
		this.details = details;
	}

	public RegisteredCategoryMgr getRegisteredCategoryMgr() {
		return registeredCategoryMgr;
	}

	public void setRegisteredCategoryMgr(
			RegisteredCategoryMgr registeredCategoryMgr) {
		this.registeredCategoryMgr = registeredCategoryMgr;
	}

	/**
	 * 查询页面初始化
	 * 
	 * @return
	 */
	public String initSearchRegisteredCategory() {

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
			return "searchRegisteredCategory";
		}
		
		return SUCCESS;
	}

	/**
	 * 
	 * 
	 */
	public String searchRegisteredCategory() {
		
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

		if (registeredCategoryPo == null)
			registeredCategoryPo = new RegisteredCategoryPo();
		registeredCategoryPo.setFrcfeetype(Utility.getName(request
				.getParameter("frcfeetype")));
		registeredCategoryPo.setFrcregisteredtype(Utility.getName(request
				.getParameter("frcregisteredtype")));
		registeredCategoryPo.setFrcregisteredname(Utility.getName(request
				.getParameter("frcregisteredname")));
		registeredCategoryPo.setFrcflag(Utility.getName(request
				.getParameter("frcflag")));
		
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
				
		// 根据查询条件返回相应的结果集数量
		int count = registeredCategoryMgr
				.getRegisteredCategoryCount(registeredCategoryPo);

		// 查询结果>0 查询出结果
		if (count > 0) {

			// 页面显示数量
			int perPage = 0;

			// 获取页面参数
			// perPage:页面显示数量
			// 如果不为空获取当前参数的值
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				// 如果
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			//
			Pagination page = new Pagination(request, count, perPage);

			// 根据查询条件返回相应的结果集
			list = registeredCategoryMgr.getRegisteredCategoryList(
					registeredCategoryPo, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);

		} else { // 否则查询结果为NULL

			list = null;

		}

		request
				.setAttribute("frcfeetype", registeredCategoryPo
						.getFrcfeetype());
		request.setAttribute("frcregisteredname", registeredCategoryPo
				.getFrcregisteredname());
		request.setAttribute("frcregisteredtype", registeredCategoryPo
				.getFrcregisteredtype());
		request.setAttribute("frcflag", registeredCategoryPo.getFrcflag());
		return SUCCESS;
	}

	/**
	 * 新增页面初始化
	 * 
	 * @return
	 */
	public String initInsertRegisteredCategory() {
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
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 新增操作
	 * 
	 * @return
	 */
	public String insertRegisteredCategory() {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("挂号类别:" + registeredCategoryPo.getFrcid() + "新增!");
		
		// 清空message
		this.clearMessages();

		int flag = registeredCategoryMgr.searchRegisteredId(registeredCategoryPo);
		if (flag == 0) {
			registeredCategoryMgr.insertRegisteredCategory(registeredCategoryPo, details,logPo);
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		} else {
			this.addActionMessage(getText("挂号类别编码重复!"));
			return ERROR;
		}

	}

	/**
	 * 管理页面初始化
	 * 
	 * @return
	 */
	public String initRegisteredCategoryManager() {
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
		return SUCCESS;
	}

	/**
	 * 管理页面查询
	 * 
	 * @return
	 */
	public String searchRegisteredCategoryManager() {
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
		
		String feeType = Utility.getName(request.getParameter("feeType"));

		if (feeType.equals("")) {
			feeType = "1";
		}

		// stop
		List stopList = registeredCategoryMgr.getSelValue("0", feeType);

		// start
		List startList = registeredCategoryMgr.getSelValue("1", feeType);

		request.setAttribute("feeType", feeType);

		request.setAttribute("stopList", stopList);

		request.setAttribute("startList", startList);

		return SUCCESS;

	}

	/**
	 * 管理页面保存
	 * 
	 * @return
	 */
	public String saveRegisteredCategoryManager() {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("挂号类别批量修改!");
		
		// 未启用
		String[] sel1 = request.getParameterValues("sel1");

		// 已使用
		String[] sel2 = request.getParameterValues("sel2");

		registeredCategoryMgr.saveManagerValue(sel1, sel2,logPo);

		return SUCCESS;

	}

	/**
	 * 修改页面初始化
	 * 
	 * @return
	 */
	public String initUpdateRegisteredCategory() {
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
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		RegisteredCategoryPo param = new RegisteredCategoryPo();
		param.setFrcid(request.getParameter("hid"));

		registeredCategoryPo = registeredCategoryMgr
				.getRegisteredCategoryPo(param);
		details = registeredCategoryMgr.getRegisteredPrintDetails(param
				.getFrcid());

		return SUCCESS;
	}

	/**
	 * 修改保存操作
	 * 
	 * @return
	 */
	public String updateRegisteredCategory() {
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
		
		// 清空message
		this.clearMessages();

		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("挂号类别:" + registeredCategoryPo.getFrcid() + "修改!");
		
		registeredCategoryMgr.updateRegisteredCategory(registeredCategoryPo,details,logPo);

		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;

	}

	/**
	 * 初始删除页面
	 * 
	 * @return
	 */
	public String initDeleteRegisteredCategory() {
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
		
		RegisteredCategoryPo param = new RegisteredCategoryPo();
		param.setFrcid(request.getParameter("hid"));

		registeredCategoryPo = registeredCategoryMgr
				.getRegisteredCategoryPo(param);
		return SUCCESS;
	}

	/**
	 * 删除操作
	 * 
	 * @return
	 */
	public String deleteRegisteredCategory() {
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
		
		RegisteredCategoryPo param = new RegisteredCategoryPo();
		param.setFrcid(Utility.getName(request.getParameter("hid")));

		// 查询工艺类型在goods表中是否已经使用
		int flag = registeredCategoryMgr.getRegisteredCategoryWithOther(registeredCategoryPo);

		// 清空message
		this.clearMessages();

		// 如果结果为0，ID不存在继续执行
		if (flag == 0) {

			//添加日志
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("2");    // 表示状态
			logPo.setsLogContent("挂号类别:" + param.getFrcid() + "删除!");
			
			// 删除工艺类型
			registeredCategoryMgr.deleteRegisteredCategory(param,logPo);

			this.addActionMessage(getText("struts.messages.delete.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;

		} else {// 否则弹出消息

			this.addActionMessage(getText("struts.messages.delete.sucess"));
			return ERROR;
		}

	}

}
