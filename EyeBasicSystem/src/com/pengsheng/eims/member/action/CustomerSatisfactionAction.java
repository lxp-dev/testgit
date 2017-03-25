package com.pengsheng.eims.member.action;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerSatisfactionMgr;
import com.pengsheng.eims.member.persistence.CustomerSatisfactionPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class CustomerSatisfactionAction extends BaseAction{

	private CustomerSatisfactionPo customerSatisfactionPo;

	private List<CustomerSatisfactionPo> list; // 回访满意度列表List

	private CustomerSatisfactionMgr customerSatisfactionMgr;
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	/**
	 * 查询回访满意度列表
	 */
	public String initCustomerSatisfactionSel() throws Exception {
				  
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

		// 页面查询条件 Begin
		// 页面查询条件 End

		// 取得查询结果回访满意度List Begin
		//list = customerSatisfactionMgr.getCustomerSatisfactionList();
		// 取得查询结果回访满意度List End

		// 传回页面变量参数 Begin
		// 传回页面变量参数 End
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//根据查询条件返回相应的结果集数量
		int count = customerSatisfactionMgr.getCustomerSatisfactionsCount();
		
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
			list = customerSatisfactionMgr.getCustomerSatisfactionsList(page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			list = null;
		
		}
		
		
		return SUCCESS;
	}

	/**
	 * 初始化回访满意度新增
	 */
	public String initInsertCustomerSatisfaction() throws Exception {
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
		
		customerSatisfactionPo = new CustomerSatisfactionPo();
		return SUCCESS;
	}

	/**
	 * 回访满意度新增
	 */
	public String insertCustomerSatisfaction() throws Exception {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 会员升级
		logPo.setsLogContent("回访满意度维护满意度名称："+customerSatisfactionPo.getFcsname()+" 新增");
		this.clearMessages();
		int flagname=customerSatisfactionMgr.getCustomerSatisfactionPoName(customerSatisfactionPo);
		if(flagname==0)
		{
			customerSatisfactionMgr.insertCustomerSatisfaction(customerSatisfactionPo,logPo);			
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);

			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("回访满意度名称重复"));
			return "error";
		}
		
	}

	/**
	 * 初始化回访满意度删除
	 */
	public String initDeleteCustomerSatisfaction()throws Exception{
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
		
		// 页面查询条件 Begin
		String fcsid=Utility.getName(request.getParameter("hid"));
		// 页面查询条件 End
		
		// 根据回访满意度Id查询回访满意度对象 Begin
		customerSatisfactionPo = new CustomerSatisfactionPo();
		customerSatisfactionPo.setFcsid(fcsid);
		customerSatisfactionPo=customerSatisfactionMgr.getCustomerSatisfaction(customerSatisfactionPo);
		// 根据回访满意度Id查询回访满意度对象 End	
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 会员升级
		logPo.setsLogContent("回访满意度维护满意度名称："+customerSatisfactionPo.getFcsname()+" 新增");
		
		return SUCCESS;
	}
	
	/**
	 * 删除回访满意度
	 */
	public String deleteCustomerSatisfaction()throws Exception{
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
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */
		
		
		// 页面查询条件 Begin
		String fcsid=Utility.getName(request.getParameter("hid"));
		// 页面查询条件 End
		
		//根据回访满意度Id查询回访满意度对象
		customerSatisfactionPo = new CustomerSatisfactionPo();
		customerSatisfactionPo.setFcsid(fcsid);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 会员升级
		logPo.setsLogContent("回访满意度维护满意度名称："+customerSatisfactionPo.getFcsname()+" 新增");
		
		customerSatisfactionMgr.deleteCustomerSatisfaction(customerSatisfactionPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public CustomerSatisfactionPo getCustomerSatisfactionPo() {
		return customerSatisfactionPo;
	}

	public void setCustomerSatisfactionPo(
			CustomerSatisfactionPo customerSatisfactionPo) {
		this.customerSatisfactionPo = customerSatisfactionPo;
	}

	public CustomerSatisfactionMgr getCustomerSatisfactionMgr() {
		return customerSatisfactionMgr;
	}

	public void setCustomerSatisfactionMgr(
			CustomerSatisfactionMgr customerSatisfactionMgr) {
		this.customerSatisfactionMgr = customerSatisfactionMgr;
	}

	public List<CustomerSatisfactionPo> getList() {
		return list;
	}

	public void setList(List<CustomerSatisfactionPo> list) {
		this.list = list;
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
