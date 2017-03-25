package com.pengsheng.eims.basic.action;

import java.util.List;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.pengsheng.eims.basic.mgr.ColorMgr;
import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ColorAction extends BaseAction implements ServletRequestAware,
		SessionAware {

	private PersonPermissionMgr personPermissionMgr;	
	private ColorPo colorPo;
	private List<ColorPo> list; // 门店列表List
	private ColorMgr colorMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	
	/**
	 * 查询商品颜色列表
	 */
	public String selColor() throws Exception {
		
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

		// 取得查询结果商品颜色List Begin
		//list = colorMgr.getColorList();
		// 取得查询结果商品颜色List End
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//根据查询条件返回相应的结果集数量
		int count = colorMgr.getColorCount();
		
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
			list = colorMgr.getColorsList(page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			list = null;
		
		}
		
		

		// 传回页面变量参数 End
		return SUCCESS;
	}

	/**
	 * 初始化商品颜色新增
	 */
	public String initInsertColor() throws Exception {

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
		
		colorPo=new ColorPo();
		return SUCCESS;
	}

	/**
	 * 初始化商品颜色新增
	 */
	public String insertColor() throws Exception {

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
		
		ColorPo temp = new ColorPo();
		temp.setBcid(colorPo.getBcid());
		this.clearMessages();
		int flagename=colorMgr.getColorName(colorPo);
		if (!"".equals(Utility.getName(colorMgr.getColor(temp).getBcid()))) 
		{			
			this.addActionMessage(getText("商品颜色编码重复!"));
			return "NoRepeat";
		}else
		{
			if(flagename==0)
			{
				//添加日志
				LogisticsLogPo logPo = new LogisticsLogPo();
				logPo.setsLogName(createPerson);
				logPo.setsLogIP(request.getRemoteAddr());
				logPo.setsLogResult(moduleID); 	// 表示模块名称 
				logPo.setsLogOpID("1");    		// 表示状态
				logPo.setsLogContent("商品颜色:" + colorPo.getBcid() + "新增!");

				colorMgr.insertColor(colorPo,logPo);
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				return SUCCESS;
			}else
			{
				this.addActionMessage(getText("商品颜色名称重复!"));
				return "NoRepeat";
			}
		}
		
		
	}

	/**
	 * 初始化商品颜色更新
	 */
	public String initUpdateColor() throws Exception {
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
		
		// 页面参数：商品颜色Id
		String butid=Utility.getName(request.getParameter("hid"));
		
		//根据商品颜色Id查询商品颜色对象
		colorPo = new ColorPo();
		colorPo.setBcid(butid);
		colorPo=colorMgr.getColor(colorPo);

		return SUCCESS;
	}
	
	/**
	 * 商品颜色更新
	 */
	public String updateColor() throws Exception {
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
		logPo.setsLogContent("商品颜色:" + colorPo.getBcid() + "修改!");
		int flagname=colorMgr.getColorNameUpdate(colorPo);
		this.clearMessages();
		if(flagname==0)
		{
			colorMgr.updateColor(colorPo,logPo);				
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);

			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("商品颜色名称重复!"));
			return "NoRepeat";
		}
		
	}
	
	/**
	 * 初始化商品颜色删除
	 */
	public String initDeleteColor()throws Exception{
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
		
		// 页面参数：商品颜色Id
		String butid=Utility.getName(request.getParameter("hid"));
		
		//根据商品颜色Id查询商品颜色对象
		colorPo = new ColorPo();
		colorPo.setBcid(butid);
		colorPo=colorMgr.getColor(colorPo);

		return SUCCESS;
	}
	
	/**
	 * 删除商品颜色
	 */
	public String deleteColor()throws Exception{
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
		
		// 页面参数：商品颜色Id
		String bcid=Utility.getName(request.getParameter("hid"));
		
		colorPo = new ColorPo();
		colorPo.setBcid(bcid);
		/*int count=colorMgr.getGoodsCount(colorPo);
		if(count>0){
			this.clearMessages();
			this.addActionMessage(getText("data.have.been.used.remove.failed"));
			return "dataUsed";
		}*/
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("2");    		// 表示状态
		logPo.setsLogContent("商品颜色:" + colorPo.getBcid() + "删除!");
		
		colorMgr.deleteColor(colorPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	public ColorPo getColorPo() {
		return colorPo;
	}

	public void setColorPo(ColorPo colorPo) {
		this.colorPo = colorPo;
	}

	public List<ColorPo> getList() {
		return list;
	}

	public void setList(List<ColorPo> list) {
		this.list = list;
	}

	public ColorMgr getColorMgr() {
		return colorMgr;
	}

	public void setColorMgr(ColorMgr colorMgr) {
		this.colorMgr = colorMgr;
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
