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
import com.pengsheng.eims.system.mgr.FrameMaterialMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * TeachnologyTypeAction 镜架材质Action
 * 
 * @author GuanZiGang
 * @version 1.0
 */
public class FrameMaterialAction extends BaseAction implements ServletRequestAware, SessionAware{

	//注入request对象
	private HttpServletRequest request;
	
	//注入seesion对象
	private Map session;
	
	//注入镜架材质Mgr
	private FrameMaterialMgr frameMaterialMgr;

	//页面List
	private List list;
	
	//页面Po
	private FrameMaterialPo frameMaterialPo; 
	
	public FrameMaterialMgr getFrameMaterialMgr() {
		return frameMaterialMgr;
	}

	public void setFrameMaterialMgr(FrameMaterialMgr frameMaterialMgr) {
		this.frameMaterialMgr = frameMaterialMgr;
	}

	public FrameMaterialPo getFrameMaterialPo() {
		return frameMaterialPo;
	}

	public void setFrameMaterialPo(FrameMaterialPo frameMaterialPo) {
		this.frameMaterialPo = frameMaterialPo;
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
	public String initFrameMaterialList() {
		
		

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
		
		FrameMaterialPo po = new FrameMaterialPo();
		
		//根据查询条件返回相应的结果集数量
		int count = frameMaterialMgr.getFrameMaterialCount(po);
		
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
			list = frameMaterialMgr.getFrameMaterialList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			list = null;
		
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始新增镜架材质页面
	 * 
	 * @return
	 */
	public String initInsertFrameMaterial(){
		
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
	 * 新增镜架材质
	 * 
	 * @return
	 */
	public String insertFrameMaterial() {
		
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
		logPo.setsLogContent("镜架材质：" + Utility.getName(frameMaterialPo.getBfmid()) + "新增!");
		
		//查询镜架材质ID是否存在
		int flag = frameMaterialMgr.getFrameMaterialId(frameMaterialPo);
		int flagName=frameMaterialMgr.getFrameMaterialName(frameMaterialPo);
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{
			if(flagName==0)
			{
				frameMaterialMgr.insertFrameMaterial(frameMaterialPo,logPo);			
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				return SUCCESS;
			}else
			{
				this.addActionMessage(getText("镜架材质名称重复!"));
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
	 * 初始修改镜架材质页面
	 * 
	 * @return
	 */
	public String initUpdateFrameMaterial(){
		
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
		
		FrameMaterialPo param = new FrameMaterialPo();
		param.setBfmid(request.getParameter("hid"));
		
		frameMaterialPo = frameMaterialMgr.getFrameMaterialPo(param);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 修改镜架材质
	 * 
	 * @return
	 */
	public String updateFrameMaterial() {
		
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
		logPo.setsLogContent("镜架材质：" + Utility.getName(frameMaterialPo.getBfmid()) + "修改!");
		int flagName=frameMaterialMgr.getFrameMaterialNameUpdate(frameMaterialPo);
		this.clearMessages();
		if(flagName==0)
		{
			frameMaterialMgr.updateFrameMaterial(frameMaterialPo,logPo);		
			this.addActionMessage(getText("struts.messages.update.sucess"));		
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);		
			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("镜架材质名称重复!"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return "error";
		}
				
	}
	
	
	/**
	 * 初始删除镜架材质页面
	 * 
	 * @return
	 */
	public String initDeleteFrameMaterial() {
		
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
		
		FrameMaterialPo param = new FrameMaterialPo();
		param.setBfmid(request.getParameter("hid"));
		
		frameMaterialPo = frameMaterialMgr.getFrameMaterialPo(param);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 删除镜架材质
	 * 
	 * @return
	 */
	public String deleteFrameMaterial() {
		
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
		
		FrameMaterialPo param = new FrameMaterialPo();
		param.setBfmid(Utility.getName(request.getParameter("hid")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("镜架材质：" + Utility.getName(request.getParameter("hid")) + "删除!");
		
		//查询镜架材质在goods表中是否已经使用
		int flag =0; //frameMaterialMgr.getFrameMaterialWithGoods(param);
		
		//清空message
		this.clearMessages();
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0){
			
			//删除镜架材质
			frameMaterialMgr.deleteFrameMaterial(param,logPo);
			
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			
		}else{//否则弹出消息			
			this.addActionMessage(getText("镜架材质删除失败!"));
				
		}
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
		
	}
	
}
