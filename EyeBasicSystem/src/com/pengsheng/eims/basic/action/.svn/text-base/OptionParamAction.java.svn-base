package com.pengsheng.eims.basic.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.LogMgr;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class OptionParamAction extends BaseAction {

	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	private OptionParamPo optionParamPo;

	private List<OptionParamPo> optionParamMaxList; // 下拉值List
	private List<OptionParamPo> optionParamMinList; // 下拉值List

	private OptionParamMgr optionParamMgr;
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
	private LogMgr logMgr;	
	private List<ModulePo> moduleList;
	
	public LogMgr getLogMgr() {
		return logMgr;
	}

	public void setLogMgr(LogMgr logMgr) {
		this.logMgr = logMgr;
	}

	public List<ModulePo> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<ModulePo> moduleList) {
		this.moduleList = moduleList;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	/**
	 * 查询页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initOptionParamSel() throws Exception {
		
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
		
		//optionParamMaxList=optionParamMgr.getOptionParamMaxList();
		OptionParamPo po = new OptionParamPo();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//根据查询条件返回相应的结果集数量
		int count = optionParamMgr.getOptionParamCount(po);
		
		//查询结果>0 查询出结果
		if (count > 0) {
			
			//页面显示数量
			int perPage = 0;
			
			//获取页面参数  
			//perPage:页面显示数量
			//如果不为空获取当前参数的值
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				//如果
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
			
			//根据查询条件返回相应的结果集
			optionParamMaxList = optionParamMgr.getOptionParamList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			optionParamMaxList = null;
		
		}
		
		moduleList = logMgr.getModuleList();		
		
		return SUCCESS;
	}

	/**
	 * 查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selOptionParam() throws Exception {
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
		String fopparamid=Utility.getName(request.getParameter("fopparamid"));		
		String opModule = Utility.getName(request.getParameter("opModule"));
		String opname = Utility.getName(request.getParameter("opname"));
		
		OptionParamPo po = new OptionParamPo();
		po.setFopmoduleid(opModule);
		po.setFopparamname(opname);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());

		//根据查询条件返回相应的结果集数量
		int count = optionParamMgr.getOptionParamCount(po);
		
		//查询结果>0 查询出结果
		if (count > 0) {
			
			//页面显示数量
			int perPage = 0;
			
			//获取页面参数  
			//perPage:页面显示数量
			//如果不为空获取当前参数的值
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				//如果
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
			
			//根据查询条件返回相应的结果集
			optionParamMaxList = optionParamMgr.getOptionParamList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			optionParamMaxList = null;
		
		}
		if(!fopparamid.equals("")){
			OptionParamPo tmp=  new OptionParamPo();
			tmp.setFopparentid(fopparamid);
			optionParamMinList=optionParamMgr.getOptionParamMinList(tmp);
		}
		
		moduleList = logMgr.getModuleList();
		
		request.setAttribute("fopparamidpage", fopparamid);
		request.setAttribute("opModule", opModule);
		request.setAttribute("opname", opname);
		
		return SUCCESS;
	}
	
	/**
	 * 新增页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initOptionParamInsert() throws Exception {
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
		
		optionParamPo = new OptionParamPo();
		optionParamMaxList=optionParamMgr.getOptionParamMaxList();
		
		moduleList = logMgr.getModuleList();
		
		return SUCCESS;
	}

	/**
	 * 新增下拉值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertOptionParam() throws Exception {
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
		
		if(optionParamPo.getFoptype().equals("1")){
			optionParamPo.setFopparentid("");
		}else{
			optionParamPo.setFopmoduleid("");
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("下拉值:" + optionParamPo.getFopparamid() + "新增!");
		this.clearMessages();
		int flagID=optionParamMgr.getOptionParamID(optionParamPo);//判断是否重复ID
		if(flagID==0)
		{
			optionParamMgr.insertOptionParam(optionParamPo,logPo);
			optionParamPo = new OptionParamPo();
			optionParamMaxList=optionParamMgr.getOptionParamMaxList();				
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("编号重复!"));
			optionParamMaxList=optionParamMgr.getOptionParamMaxList();
			moduleList = logMgr.getModuleList();
			return "error";
		}

		
	}

	/**
	 * 更新下拉值初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initOptionParamUpdate() throws Exception {	
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
		
		String fopparamid=Utility.getName(request.getParameter("fopparamid"));
		OptionParamPo tmp = new OptionParamPo();
		tmp.setFopparamid(fopparamid);
		optionParamPo = optionParamMgr.getOptionParam(tmp);
		
		moduleList = logMgr.getModuleList();
		
		return SUCCESS;
	}

	/**
	 * 更新下拉值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateOptionParam() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 1 表示状态
		logPo.setsLogContent("下拉值:" + optionParamPo.getFopparamid() + "修改!");
	
		

		this.clearMessages();
		
		int flagName=optionParamMgr.getOptionParamNameUpdate(optionParamPo);
		
		if(flagName==0)
		{
			optionParamMgr.updateOptionParam(optionParamPo,logPo);
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		
		}else
		{
			this.addActionMessage(getText("内容重复!"));
			moduleList = logMgr.getModuleList();
			return "error";
		}
	}	
		

	/**
	 * 刪除页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initOptionParamDelete() throws Exception {
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
		
		String fopparamid=Utility.getName(request.getParameter("hid"));
		OptionParamPo tmp = new OptionParamPo();
		tmp.setFopparamid(fopparamid);
		optionParamPo = optionParamMgr.getOptionParam(tmp);
		return SUCCESS;
	}

	/**
	 * 刪除下拉值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteOptionParam() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 1 表示状态
		logPo.setsLogContent("下拉值:" + optionParamPo.getFopparamid() + "删除!");
		
		optionParamMgr.deleteOptionParam(optionParamPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public OptionParamPo getOptionParamPo() {
		return optionParamPo;
	}

	public void setOptionParamPo(
			OptionParamPo optionParamPo) {
		this.optionParamPo = optionParamPo;
	}

	public List<OptionParamPo> getOptionParamMaxList() {
		return optionParamMaxList;
	}

	public void setOptionParamMaxList(
			List<OptionParamPo> optionParamMaxList) {
		this.optionParamMaxList = optionParamMaxList;
	}

	public OptionParamMgr getOptionParamMgr() {
		return optionParamMgr;
	}

	public void setOptionParamMgr(
			OptionParamMgr optionParamMgr) {
		this.optionParamMgr = optionParamMgr;
	}

	public List<OptionParamPo> getOptionParamMinList() {
		return optionParamMinList;
	}

	public void setOptionParamMinList(
			List<OptionParamPo> optionParamMinList) {
		this.optionParamMinList = optionParamMinList;
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
