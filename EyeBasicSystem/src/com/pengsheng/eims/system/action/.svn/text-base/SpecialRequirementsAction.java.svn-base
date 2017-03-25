package com.pengsheng.eims.system.action;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SpecialRequirementsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.AdditionalCostsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SpecialRequirementsPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class SpecialRequirementsAction extends BaseAction{

	//页面List
	private List list;
	
	//特殊加工要求Po
	private SpecialRequirementsPo specialRequirementsPo;	
	//特殊加工要求Mgr
	private SpecialRequirementsMgr specialRequirementsMgr;	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
		
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

	public SpecialRequirementsMgr getSpecialRequirementsMgr() {
		return specialRequirementsMgr;
	}

	public void setSpecialRequirementsMgr(
			SpecialRequirementsMgr specialRequirementsMgr) {
		this.specialRequirementsMgr = specialRequirementsMgr;
	}

	public SpecialRequirementsPo getSpecialRequirementsPo() {
		return specialRequirementsPo;
	}

	public void setSpecialRequirementsPo(SpecialRequirementsPo specialRequirementsPo) {
		this.specialRequirementsPo = specialRequirementsPo;
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
	public String initSpecialRequirementsList() {
		
		

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
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		SpecialRequirementsPo po = new SpecialRequirementsPo();
		
		//根据查询条件返回相应的结果集数量
		int count = specialRequirementsMgr.getSpecialRequirementsCount(po);
		
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
			list = specialRequirementsMgr.getSpecialRequirementsList(po, page.getStart(), page.getPageSize());

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
	public String initInsertSpecialRequirements(){
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
		
		return SUCCESS;
	}
	
	
	/**
	 * 新增工艺类型
	 * 
	 * @return
	 */
	public String insertSpecialRequirements() {
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
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("特殊加工要求:" + specialRequirementsPo.getFsrid() + "新增!");
		
		//查询工艺类型ID是否存在
		int flag = specialRequirementsMgr.getSpecialRequirementsId(specialRequirementsPo);
		int flagname=specialRequirementsMgr.getSpecialRequirementsName(specialRequirementsPo);
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{
			if(flagname==0)
			{
				specialRequirementsMgr.insertSpecialRequirements(specialRequirementsPo,logPo);			
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return SUCCESS;
			}else
			{
				this.addActionMessage(getText("特殊加工要求名称重复!"));
				return ERROR;
			}
			
		}else{//否则弹出消息
			
			this.addActionMessage(getText("特殊加工要求编码重复!"));
			return ERROR;
		}
		
	}
	
	
	
	/**
	 * 初始修改工艺类型页面
	 * 
	 * @return
	 */
	public String initUpdateSpecialRequirements(){
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

		SpecialRequirementsPo param = new SpecialRequirementsPo();
		param.setFsrid(request.getParameter("hid"));
		
		specialRequirementsPo = specialRequirementsMgr.getSpecialRequirementsPo(param);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 修改工艺类型
	 * 
	 * @return
	 */
	public String updateSpecialRequirements() {
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
		logPo.setsLogContent("特殊加工要求:" + specialRequirementsPo.getFsrid() + "修改!");
		
		//查询工艺类型在goods表中是否已经使用
		int flag = specialRequirementsMgr.getTSpecialRequirementsWithGoods(specialRequirementsPo);
		int flagname=specialRequirementsMgr.getSpecialRequirementsNameUpdate(specialRequirementsPo);
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{
			if(flagname==0)
			{
				specialRequirementsMgr.updateSpecialRequirements(specialRequirementsPo,logPo);
				this.addActionMessage(getText("struts.messages.update.sucess"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return SUCCESS;
			}else
			{
				this.addActionMessage(getText("特殊加工要求名称重复!"));
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
	public String initDeleteSpecialRequirements() {
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
		
		SpecialRequirementsPo param = new SpecialRequirementsPo();
		param.setFsrid(request.getParameter("hid"));
		
		specialRequirementsPo = specialRequirementsMgr.getSpecialRequirementsPo(param);
		return SUCCESS;
	}
	
	
	
	/**
	 * 删除工艺类型
	 * 
	 * @return
	 */
	public String deleteSpecialRequirements() {
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
		
		SpecialRequirementsPo param = new SpecialRequirementsPo();
		param.setFsrid(request.getParameter("hid"));
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 1 表示状态
		logPo.setsLogContent("特殊加工要求:" + param.getFsrid() + "删除!");
				
		//查询工艺类型在goods表中是否已经使用
		int flag = specialRequirementsMgr.getTSpecialRequirementsWithGoods(param);
		
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0){
			
			//删除工艺类型
			specialRequirementsMgr.deleteSpecialRequirements(param,logPo);
			
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return SUCCESS;
			
		}else{//否则弹出消息
			
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			return ERROR;
		}
		
	}
	
	
}
