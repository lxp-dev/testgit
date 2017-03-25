package com.pengsheng.eims.basic.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.CustomerAgeGroupMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.persistence.CustomerAgeGroupPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class CustomerAgeGroupAction extends BaseAction{
	private CustomerAgeGroupPo customerAgeGroupPo;
	private List<CustomerAgeGroupPo> customerAgeGroupPos;
	private PersonPermissionMgr personPermissionMgr;
	private CustomerAgeGroupMgr customerAgeGroupMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private List<GoodsCategoryPo> goodsCategorys;
	private VarietyMgr varietyMgr;
	
	public String selectCustomerAgeGroup() throws Exception {
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
		//根据查询条件返回相应的结果集数量
		int count = customerAgeGroupMgr.selectCustomerAgeGroupCount();
		
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
			customerAgeGroupPos = customerAgeGroupMgr.selectCustomerAgeGroupList(null,page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			customerAgeGroupPos = null;
		
		}
		
		return SUCCESS;
	}
	
	public String initInsertCustomerAgeGroupPo() throws Exception {
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
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		return SUCCESS;
	}
	
	public String insertCustomerAgeGroupPo() throws Exception {
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
		goodsCategorys = varietyMgr.getGoodsCategorys();
		int count = customerAgeGroupMgr.selectCustomerAge(customerAgeGroupPo);
		this.clearMessages();
		if(count > 0)
		{
			this.addActionMessage("该商品类别已设置,保存失败！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);			
			return "error";
		}else
		{
			customerAgeGroupMgr.insertCustomerAgeGroupPo(customerAgeGroupPo);						
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
			
		}
		
	}
	
	public String initUpdateCustomerAgeGroupPo() throws Exception {
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
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		String categoryid = Utility.getName(request.getParameter("hid"));
		
		CustomerAgeGroupPo po = new CustomerAgeGroupPo();
		
		po.setBcggoodscategory(categoryid);
		
		customerAgeGroupPos = customerAgeGroupMgr.selectCustomerAgeGroupPos(po);
		
		return SUCCESS;
	}
	
	public String updateCustomerAgeGroupPo() throws Exception {
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
		
		this.clearMessages();
		
		customerAgeGroupMgr.updateCustomerAgeGroupPo(customerAgeGroupPo);	
		this.addActionMessage("更新成功！");
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);		
		return SUCCESS;
				
	}
	
	public String initDeleteCustomerAgeGroupPo() throws Exception {
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
		
		String categoryid = Utility.getName(request.getParameter("hid"));
		
		CustomerAgeGroupPo po = new CustomerAgeGroupPo();
		
		po.setBcggoodscategory(categoryid);
		
		customerAgeGroupPos = customerAgeGroupMgr.selectCustomerAgeGroupPos(po);
		
		return SUCCESS;
	}
	
	public String deleteCustomerAgeGroupPo() throws Exception {
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
		
		String categoryid = Utility.getName(request.getParameter("hid"));
		
		CustomerAgeGroupPo po = new CustomerAgeGroupPo();
		
		po.setBcggoodscategory(categoryid);
		
		customerAgeGroupMgr.deleteCustomerAgeGroupPo(po);
		
		this.clearMessages();
		this.addActionMessage("删除成功！");
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	public CustomerAgeGroupPo getCustomerAgeGroupPo() {
		return customerAgeGroupPo;
	}

	public void setCustomerAgeGroupPo(CustomerAgeGroupPo customerAgeGroupPo) {
		this.customerAgeGroupPo = customerAgeGroupPo;
	}

	public List<CustomerAgeGroupPo> getCustomerAgeGroupPos() {
		return customerAgeGroupPos;
	}

	public void setCustomerAgeGroupPos(List<CustomerAgeGroupPo> customerAgeGroupPos) {
		this.customerAgeGroupPos = customerAgeGroupPos;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public CustomerAgeGroupMgr getCustomerAgeGroupMgr() {
		return customerAgeGroupMgr;
	}

	public void setCustomerAgeGroupMgr(CustomerAgeGroupMgr customerAgeGroupMgr) {
		this.customerAgeGroupMgr = customerAgeGroupMgr;
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

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}
	
}
