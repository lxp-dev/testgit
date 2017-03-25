package com.pengsheng.eims.personnel.action;

import java.util.List;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.mgr.EducationMgr;
import com.pengsheng.eims.personnel.persistence.EducationPo;
import com.pengsheng.eims.personnel.persistence.PostPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class EducationAction extends BaseAction implements ServletRequestAware,
		SessionAware {

	private PersonPermissionMgr personPermissionMgr;	
	private EducationPo educationPo;
	private List<EducationPo> list; // 列表List
	private EducationMgr educationMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	
	/**
	 * 查询学历列表
	 */
	public String selEducation() throws Exception {
		
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

		// 页面查询条件

		// 取得查询结果学历List Begin
		//list = educationMgr.getEducationList();
		// 取得查询结果学历List End
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//根据查询条件返回相应的结果集数量
		int count = educationMgr.getEducationCount();
		
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
			list = educationMgr.getEducationsList(page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			list = null;
		
		}
		
		

		// 传回页面变量参数 End
		return SUCCESS;
	}

	/**
	 * 初始化学历新增
	 */
	public String initInsertEducation() throws Exception {

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
		
		educationPo=new EducationPo();
		return SUCCESS;
	}

	/**
	 * 初始化学历新增
	 */
	public String insertEducation() throws Exception {

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
		
		EducationPo temp = new EducationPo();
		temp.setMetname(educationPo.getMetname());
		this.clearMessages();
		int flagename=educationMgr.getEducationName(educationPo);
		if(flagename==0)
		{
			//添加日志
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); 	// 表示模块名称 
			logPo.setsLogOpID("1");    		// 表示状态
			logPo.setsLogContent("学历:" + educationPo.getMetname() + "新增!");

			educationMgr.insertEducation(educationPo,logPo);
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("学历名称重复!"));
			return "NoRepeat";
		}		
	}

	/**
	 * 初始化学历更新
	 */
	public String initUpdateEducation() throws Exception {
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
		
		// 页面参数：学历Id
		String metid=Utility.getName(request.getParameter("hid"));
		
		//根据学历Id查询学历对象
		educationPo = new EducationPo();
		educationPo.setMetid(metid);
		educationPo=educationMgr.getEducation(educationPo);

		return SUCCESS;
	}
	
	/**
	 * 学历更新
	 */
	public String updateEducation() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("3");    		// 表示状态
		logPo.setsLogContent("学历:" + educationPo.getMetid() + "修改!");
		int flagname=educationMgr.getEducationNameUpdate(educationPo);
		this.clearMessages();
		if(flagname==0)
		{
			educationMgr.updateEducation(educationPo,logPo);				
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);

			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("学历名称重复!"));
			return "NoRepeat";
		}
		
	}
	
	/**
	 * 初始化学历删除
	 */
	public String initDeleteEducation()throws Exception{
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
		
		// 页面参数：学历Id
		String metid=Utility.getName(request.getParameter("hid"));
		
		//根据学历Id查询学历对象
		educationPo = new EducationPo();
		educationPo.setMetid(metid);
		educationPo=educationMgr.getEducation(educationPo);

		return SUCCESS;
	}
	
	/**
	 * 删除学历
	 */
	public String deleteEducation()throws Exception{
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
		
		// 页面参数：学历Id
		String metid=Utility.getName(request.getParameter("hid"));
		
		educationPo = new EducationPo();
		educationPo.setMetid(metid);

		
		int flagName=educationMgr.getBeUsed(educationPo);
		
		if(flagName==0)
		{
			//添加日志
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); 	// 表示模块名称 
			logPo.setsLogOpID("2");    		// 表示状态
			logPo.setsLogContent("学历:" + educationPo.getMetid() + "删除!");
			
			educationMgr.deleteEducation(educationPo,logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);

			return SUCCESS;
		
		}else
		{
			EducationPo tmp = new EducationPo();
			tmp.setMetid(educationPo.getMetid());
			educationPo = educationMgr.getEducation(tmp);	
			
			this.addActionMessage(getText("不允许删除!"));
			return "error";
		}
		

	}
	
	public EducationPo getEducationPo() {
		return educationPo;
	}

	public void setEducationPo(EducationPo educationPo) {
		this.educationPo = educationPo;
	}

	public List<EducationPo> getList() {
		return list;
	}

	public void setList(List<EducationPo> list) {
		this.list = list;
	}

	public EducationMgr getEducationMgr() {
		return educationMgr;
	}

	public void setEducationMgr(EducationMgr educationMgr) {
		this.educationMgr = educationMgr;
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
