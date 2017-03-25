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
import com.pengsheng.eims.system.mgr.InterestMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.mgr.TeachnologyTypeMgr;
import com.pengsheng.eims.system.persistence.InterestPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.system.persistence.TeachnologyTypePo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * InterestAction 兴趣爱好Action
 * 
 * @author liujing
 * @version 1.0
 */
public class InterestAction extends BaseAction implements ServletRequestAware, SessionAware{

	//注入request对象
	private HttpServletRequest request;
	
	//注入seesion对象
	private Map session;
	
	//注入兴趣爱好Mgr
	private InterestMgr interestMgr;

	public InterestMgr getInterestMgr() {
		return interestMgr;
	}

	public void setInterestMgr(InterestMgr interestMgr) {
		this.interestMgr = interestMgr;
	}

	public InterestPo getInterestPo() {
		return interestPo;
	}

	public void setInterestPo(InterestPo interestPo) {
		this.interestPo = interestPo;
	}



	//页面List
	private List list;
	
	//页面Po
	private InterestPo interestPo; 
	
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
	
	/**
	 * 查询页面初始化
	 * 
	 * @return 
	 */
	public String initInterestList() {
		
		

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
		
		InterestPo po = new InterestPo();
		
		//根据查询条件返回相应的结果集数量
		int count = interestMgr.getInterestCount(po);
		
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
			list = interestMgr.getInterestList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			list = null;
		
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始新增兴趣爱好页面
	 * 
	 * @return
	 */
	public String initInsertInterest(){
		
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
	 * 新增兴趣爱好
	 * 
	 * @return
	 */
	public String insertInterest() {
		
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
		logPo.setsLogContent("兴趣爱好：" + Utility.getName(interestPo.getBirid()) + "新增!");
		
		//查询兴趣爱好ID是否存在
		int flag = interestMgr.getInterestId(interestPo);
		int flagName=interestMgr.getInterestName(interestPo);
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{
			if(flagName==0)
			{
				interestMgr.insertInterest(interestPo,logPo);			
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return SUCCESS;
			}else
			{
				this.addActionMessage(getText("兴趣爱好名称重复!"));
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
	 * 初始修改兴趣爱好页面
	 * 
	 * @return
	 */
	public String initUpdateInterest(){
		
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
		
		InterestPo param = new InterestPo();
		param.setBirid(request.getParameter("hid"));
		
		interestPo = interestMgr.getInterestPo(param);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 修改兴趣爱好
	 * 
	 * @return
	 */
	public String updateInterest() {
		
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
		logPo.setsLogContent("兴趣爱好：" + Utility.getName(interestPo.getBirid()) + "修改!");
		
		this.clearMessages();
		int flagName=interestMgr.getInterestNameUpdate(interestPo);
		
		if(flagName==0)
		{
			interestMgr.updateInterest(interestPo,logPo);				
			this.addActionMessage(getText("struts.messages.update.sucess"));		
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);		
			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("兴趣爱好名称重复!"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return ERROR;
		}
		
		
		
	}
	
	
	/**
	 * 初始删除兴趣爱好页面
	 * 
	 * @return
	 */
	public String initDeleteInterest() {
		
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
		
		InterestPo param = new InterestPo();
		param.setBirid(request.getParameter("hid"));
		
		interestPo = interestMgr.getInterestPo(param);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 删除兴趣爱好
	 * 
	 * @return
	 */
	public String deleteInterest() {
		
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
		
		InterestPo param = new InterestPo();
		param.setBirid(Utility.getName(request.getParameter("hid")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("兴趣爱好：" + Utility.getName(request.getParameter("hid")) + "删除!");
		
		//查询兴趣爱好在goods表中是否已经使用
		int flag = 0;//interestMgr.getInterestWithGoods(param);
		
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0){
			
			//删除兴趣爱好
			interestMgr.deleteInterest(param,logPo);
			
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			
		}else{//否则弹出消息			
			this.addActionMessage(getText("兴趣爱好删除失败!"));
				
		}
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
		
	}
	
}
