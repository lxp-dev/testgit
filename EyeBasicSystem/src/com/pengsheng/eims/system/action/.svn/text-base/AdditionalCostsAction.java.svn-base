package com.pengsheng.eims.system.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.AdditionalCostsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.AdditionalCostsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class AdditionalCostsAction extends BaseAction{

	//页面List
	private List list;
	
	private AdditionalCostsMgr additionalCostsMgr; 	
	private AdditionalCostsPo additionalCostsPo; 	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public AdditionalCostsPo getAdditionalCostsPo() {
		return additionalCostsPo;
	}

	public void setAdditionalCostsPo(AdditionalCostsPo additionalCostsPo) {
		this.additionalCostsPo = additionalCostsPo;
	}

	public AdditionalCostsMgr getAdditionalCostsMgr() {
		return additionalCostsMgr;
	}

	public void setAdditionalCostsMgr(AdditionalCostsMgr additionalCostsMgr) {
		this.additionalCostsMgr = additionalCostsMgr;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	/**
	 * 查询页面初始化
	 * 
	 * @return 
	 */
	public String initAdditionalCostsList() {
		
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
		
		AdditionalCostsPo po = new AdditionalCostsPo();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		//根据查询条件返回相应的结果集数量
		int count = additionalCostsMgr.getAdditionalCostsCount(po);
		
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
			list = additionalCostsMgr.getAdditionalCostsList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			list = null;
		
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始新增工艺类型页面
	 * 
	 * @return
	 */
	public String initInsertAdditionalCosts(){
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
	 * 新增工艺类型
	 * 
	 * @return
	 */
	public String insertAdditionalCosts() {
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

		//查询工艺类型ID是否存在
		int flag = additionalCostsMgr.getAdditionalCostsId(additionalCostsPo);
		int flagname=additionalCostsMgr.getAdditionalCostsName(additionalCostsPo);		
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{
			if(flagname==0)
			{
				//添加日志
				LogisticsLogPo logPo = new LogisticsLogPo();
				logPo.setsLogName(createPerson);
				logPo.setsLogIP(request.getRemoteAddr());
				logPo.setsLogResult(moduleID); // 表示模块名称 
				logPo.setsLogOpID("1");    // 表示状态
				logPo.setsLogContent("附加费:" + additionalCostsPo.getFacid() + "新增!");			
				additionalCostsMgr.insertAdditionalCosts(additionalCostsPo,logPo);
				
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return SUCCESS;
			}else
			{
				this.addActionMessage(getText("附加费用名称重复!"));
				return ERROR;
			}
			
		}else{//否则弹出消息
			this.addActionMessage(getText("附加费用编号重复!"));
			return ERROR;
		}
		
	}
	
	
	
	/**
	 * 初始修改工艺类型页面
	 * 
	 * @return
	 */
	public String initUpdateAdditionalCosts(){
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
		
		AdditionalCostsPo param = new AdditionalCostsPo();
		param.setFacid(request.getParameter("hid"));
		
		additionalCostsPo = additionalCostsMgr.getAdditionalCostsPo(param);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 修改工艺类型
	 * 
	 * @return
	 */
	public String updateAdditionalCosts() {
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
		
		//查询工艺类型在goods表中是否已经使用
		int flag = additionalCostsMgr.getTAdditionalCostsWithGoods(additionalCostsPo);
		int flagname=additionalCostsMgr.getAdditionalCostsNameUpdate(additionalCostsPo);		
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{
			if(flagname==0)
			{
				//添加日志
				LogisticsLogPo logPo = new LogisticsLogPo();
				logPo.setsLogName(createPerson);
				logPo.setsLogIP(request.getRemoteAddr());
				logPo.setsLogResult(moduleID); // 表示模块名称 
				logPo.setsLogOpID("3");    // 表示状态
				logPo.setsLogContent("附加费:" + additionalCostsPo.getFacid() + "修改!");
				
				additionalCostsMgr.updateAdditionalCosts(additionalCostsPo,logPo);
				this.addActionMessage(getText("struts.messages.update.sucess"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return SUCCESS;
			}else
			{
				this.addActionMessage(getText("附加费用名称重复!"));
				return ERROR;
			}
			
		}else{//否则弹出消息
			this.addActionMessage(getText("struts.messages.update.sucess"));
			return ERROR;
		}
		
	}
	
	
	/**
	 * 初始删除工艺类型页面
	 * 
	 * @return
	 */
	public String initDeleteAdditionalCosts() {
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
		
		AdditionalCostsPo param = new AdditionalCostsPo();
		param.setFacid(request.getParameter("hid"));
		
		additionalCostsPo = additionalCostsMgr.getAdditionalCostsPo(param);
		return SUCCESS;
	}
	
	
	
	/**
	 * 删除工艺类型
	 * 
	 * @return
	 */
	public String deleteAdditionalCosts() {
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
		
		AdditionalCostsPo param = new AdditionalCostsPo();
		param.setFacid(request.getParameter("hid"));
		
		//查询工艺类型在goods表中是否已经使用
		int flag = additionalCostsMgr.getTAdditionalCostsWithGoods(param);
		
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0){
			
			//添加日志
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("2");    // 表示状态
			logPo.setsLogContent("附加费:" + param.getFacid() + "删除!");
			
			//删除工艺类型
			additionalCostsMgr.deleteAdditionalCosts(param,logPo);
			
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return SUCCESS;
			
		}else{//否则弹出消息
			
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			return ERROR;
		}
		
	}
	
}
