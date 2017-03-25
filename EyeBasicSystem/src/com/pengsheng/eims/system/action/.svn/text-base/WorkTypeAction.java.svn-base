package com.pengsheng.eims.system.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.mgr.WorkTypeMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.PersonTypePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.system.persistence.WorkTypePo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * TeachnologyTypeAction 职业Action
 * 
 * @author GuanZiGang
 * @version 1.0
 */
public class WorkTypeAction extends BaseAction implements ServletRequestAware, SessionAware{

	//注入request对象
	private HttpServletRequest request;
	
	//注入seesion对象
	private Map session;
	
	//注入职业Mgr
	private WorkTypeMgr workTypeMgr;

	//页面List
	private List list;
	
	//页面Po
	private WorkTypePo workTypePo; 
	
	private PersonTypePo personTypePo; 
	
	public PersonTypePo getPersonTypePo() {
		return personTypePo;
	}

	public void setPersonTypePo(PersonTypePo personTypePo) {
		this.personTypePo = personTypePo;
	}

	public WorkTypeMgr getWorkTypeMgr() {
		return workTypeMgr;
	}

	public void setWorkTypeMgr(WorkTypeMgr workTypeMgr) {
		this.workTypeMgr = workTypeMgr;
	}

	public WorkTypePo getWorkTypePo() {
		return workTypePo;
	}

	public void setWorkTypePo(WorkTypePo workTypePo) {
		this.workTypePo = workTypePo;
	}



	private PersonPermissionMgr personPermissionMgr;
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public Map getSession() {
		return session;
	}


	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public void setSession(Map session) {
		this.session = session;
	}
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

	/**
	 * 查询页面初始化
	 * 
	 * @return 
	 */
	public String initWorkTypeList() {
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
		
		WorkTypePo po = new WorkTypePo();
		
		//根据查询条件返回相应的结果集数量
		int count = workTypeMgr.getWorkTypeCount(po);
		
		//查询结果>0 查询出结果
		if (count > 0) {
			
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
			list = workTypeMgr.getWorkTypeList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			list = null;
		
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始新增职业页面
	 * 
	 * @return
	 */
	public String initInsertWorkType(){
		
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
	 * 新增职业
	 * 
	 * @return
	 */
	public String insertWorkType() {
		
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
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("职业：" + Utility.getName(workTypePo.getBwtid()) + "新增!");
		
		//查询职业ID是否存在
		int flag = workTypeMgr.getWorkTypeId(workTypePo);
		int flagName=workTypeMgr.getWorkTypeName(workTypePo);
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{
			if(flagName==0)
			{
				workTypeMgr.insertWorkType(workTypePo,logPo);			
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return SUCCESS;
			}else
			{
				this.addActionMessage(getText("职业名称重复!"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return ERROR;
			}
			
					
		}else{//否则弹出消息			
			this.addActionMessage(getText("struts.messages.repeat"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return ERROR;
		}
		
		
	}
	
	
	
	/**
	 * 初始修改职业页面
	 * 
	 * @return
	 */
	public String initUpdateWorkType(){
		
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
		
		WorkTypePo param = new WorkTypePo();
		param.setBwtid(request.getParameter("hid"));
		
		workTypePo = workTypeMgr.getWorkTypePo(param);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 修改职业
	 * 
	 * @return
	 */
	public String updateWorkType() {
		
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
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("职业：" + Utility.getName(workTypePo.getBwtid()) + "修改!");
		int flagName=workTypeMgr.getWorkTypeNameUpdate(workTypePo);
		this.clearMessages();
		if(flagName==0)
		{
			workTypeMgr.updateWorkType(workTypePo,logPo);		
			this.addActionMessage(getText("struts.messages.update.sucess"));		
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);		
			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("职业名称重复!"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return "error";
		}
				
	}
	
	
	/**
	 * 初始删除职业页面
	 * 
	 * @return
	 */
	public String initDeleteWorkType() {
		
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
		
		WorkTypePo param = new WorkTypePo();
		param.setBwtid(request.getParameter("hid"));
		
		workTypePo = workTypeMgr.getWorkTypePo(param);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 删除职业
	 * 
	 * @return
	 */
	public String deleteWorkType() {
		
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
		
		WorkTypePo param = new WorkTypePo();
		param.setBwtid(Utility.getName(request.getParameter("hid")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("职业：" + Utility.getName(request.getParameter("hid")) + "删除!");
		
		//查询职业在goods表中是否已经使用
		int flag =0; //workTypeMgr.getWorkTypeWithGoods(param);
		
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0){
			
			//删除职业
			workTypeMgr.deleteWorkType(param,logPo);
			
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			
		}else{//否则弹出消息			
			this.addActionMessage(getText("职业删除失败!"));
				
		}
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
		
	}
	
	
	/**
	 * 查询页面初始化
	 * 
	 * @return 
	 */
	public String initSelectPersonType() {
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
		
		PersonTypePo po = new PersonTypePo();
		
		//根据查询条件返回相应的结果集数量
		int count = workTypeMgr.getPersonTypeCount(po);
		
		//查询结果>0 查询出结果
		if (count > 0) {
			
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
			list = workTypeMgr.getPersonTypeList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			list = null;
		
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始新增人群分类页面
	 * 
	 * @return
	 */
	public String initInsertPersonType(){
		
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
	 * 新增人群分类
	 * 
	 * @return
	 */
	public String insertPersonType() {
		
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
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("人群分类：" + Utility.getName(personTypePo.getBptid()) + "新增!");
		
		//查询职业ID是否存在
		int flag = workTypeMgr.getPersonTypeId(personTypePo);
		int flagName=workTypeMgr.getPersonTypeName(personTypePo);
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{
			if(flagName==0)
			{
				workTypeMgr.insertPersonType(personTypePo,logPo);			
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return SUCCESS;
			}else
			{
				this.addActionMessage(getText("人群分类名称重复!"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return ERROR;
			}
			
					
		}else{//否则弹出消息			
			this.addActionMessage(getText("struts.messages.repeat"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return ERROR;
		}
		
		
	}
	
	
	
	/**
	 * 初始修改人群分类页面
	 * 
	 * @return
	 */
	public String initUpdatePersonType(){
		
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
		
		PersonTypePo param = new PersonTypePo();
		param.setBptid(request.getParameter("hid"));
		
		personTypePo = workTypeMgr.getPersonTypePo(param);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 修改人群分类
	 * 
	 * @return
	 */
	public String updatePersonType() {
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
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("人群分类：" + Utility.getName(personTypePo.getBptid()) + "修改!");
		int flagName=workTypeMgr.getPersonTypeNameUpdate(personTypePo);
		this.clearMessages();
		if(flagName==0){
			workTypeMgr.updatePersonType(personTypePo,logPo);		
			this.addActionMessage(getText("struts.messages.update.sucess"));		
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);		
			return SUCCESS;
		}else{
			this.addActionMessage(getText("人群分类名称重复!"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return "error";
		}
				
	}
	
	
	/**
	 * 初始删除人群分类页面
	 * 
	 * @return
	 */
	public String initDeletePersonType() {
		
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
		
		PersonTypePo param = new PersonTypePo();
		param.setBptid(request.getParameter("hid"));
		
		personTypePo = workTypeMgr.getPersonTypePo(param);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 删除人群分类
	 * 
	 * @return
	 */
	public String deletePersonType() {
		
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
		
		PersonTypePo param = new PersonTypePo();
		param.setBptid(Utility.getName(request.getParameter("hid")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("人群分类：" + Utility.getName(request.getParameter("hid")) + "删除!");
		
		int flag =0;
		
		this.clearMessages();
		
		if(flag == 0){
			
			workTypeMgr.deletePersonType(param,logPo);
			
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			
		}else{		
			this.addActionMessage(getText("人群分类删除失败!"));
				
		}
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
		
	}
	
}
