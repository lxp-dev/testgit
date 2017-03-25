package com.pengsheng.eims.basic.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.RegionalConfigurationMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
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

public class RegionalConfigurationAction extends BaseAction{
	
	private DepartmentsPo departmentsPo;	
	private List<DepartmentsPo> list;		//门店列表List	
	private List<DepartmentsPo> brcregList;		//区域列表List	
	private RegionalConfigurationMgr regionalConfigurationMgr;
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
		
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

	/**
	 * 初始化客户查询
	 */
	public String initRegionalConfigurationSel() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//取得查询条件中的区域List Begin		
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		brcregList = regionalConfigurationMgr.getQuyuList(deppo);
		//取得查询条件中的区域List End	
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selRegionalConfiguration";
		}
		
		return SUCCESS;
	}


	/**
	 * 查询门店列表
	 */
	public String selRegionalConfiguration() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//页面查询条件
		String bdpregid=Utility.getName(request.getParameter("bdpregid"));
		String isConfig=Utility.getName(request.getParameter("isConfig"));
		
		//取得查询条件中的区域List Begin
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		brcregList = regionalConfigurationMgr.getQuyuList(deppo);
		//取得查询条件中的区域List End	
		
		//取得查询结果中的门店List Begin
		departmentsPo=new DepartmentsPo();
		departmentsPo.setBdpregname(isConfig);
		departmentsPo.setBdpregid(bdpregid);			
		departmentsPo.setBdptype("1");
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			departmentsPo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		//取得查询结果中的门店List End
		
		//传回页面变量参数 Begin
		request.setAttribute("isConfig", isConfig);
		request.setAttribute("bdpregid",bdpregid);
		//传回页面变量参数 End
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
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
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//根据查询条件返回相应的结果集数量
		int count = regionalConfigurationMgr.getMendianQuyusCount(departmentsPo);
		
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
			list = regionalConfigurationMgr.getMendianQuyusList(departmentsPo, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			list = null;
		
		}
		
		return SUCCESS;
	}

	/**
	 * 初始化门店所属区域配置
	 */
	public String initUpdateRegionalConfiguration() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//页面参数
		String bdpdepartmentid=Utility.getName(request.getParameter("hid"));
		
		//取得门店对象 Begin
		departmentsPo=new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(bdpdepartmentid);
		departmentsPo = regionalConfigurationMgr.getDepartment(departmentsPo);
		//取得门店对象 End
		
		//取得区域 List Begin
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		brcregList = regionalConfigurationMgr.getQuyuList(deppo);
		//取得区域 List End
				
		return SUCCESS;
	}
	
	/**
	 * 更新门店所属区域配置
	 */
	public String updateRegionalConfiguration() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("加工区域配置:" + departmentsPo.getBdpdepartmentid() + "修改!");
		
		regionalConfigurationMgr.updateDepartment(departmentsPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	
	public RegionalConfigurationMgr getRegionalConfigurationMgr() {
		return regionalConfigurationMgr;
	}

	public void setRegionalConfigurationMgr(
			RegionalConfigurationMgr regionalConfigurationMgr) {
		this.regionalConfigurationMgr = regionalConfigurationMgr;
	}



	public List<DepartmentsPo> getList() {
		return list;
	}

	public void setList(List<DepartmentsPo> list) {
		this.list = list;
	}

	public DepartmentsPo getDepartmentsPo() {
		return departmentsPo;
	}

	public void setDepartmentsPo(DepartmentsPo departmentsPo) {
		this.departmentsPo = departmentsPo;
	}

	public List<DepartmentsPo> getBrcregList() {
		return brcregList;
	}

	public void setBrcregList(List<DepartmentsPo> brcregList) {
		this.brcregList = brcregList;
	}


	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}


	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}


}
