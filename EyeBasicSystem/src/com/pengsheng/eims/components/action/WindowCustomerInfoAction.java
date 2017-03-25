/**
 * 
 */
package com.pengsheng.eims.components.action;

import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * @author Liuqian
 * 
 */
public class WindowCustomerInfoAction extends BaseAction {

	private CustomerInfoPo customerInfoPo;
	private List<CustomerInfoPo> customerInfoList; // 顾客基本资料列表List
	private CustomerInfoMgr customerInfoMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private PersonInfoMgr personInfoMgr;
	private List<PersonInfoPo> personInfoPos;
	private PersonPermissionMgr personPermissionMgr;
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	public List<PersonInfoPo> getPersonInfoPos() {
		return personInfoPos;
	}

	public void setPersonInfoPos(List<PersonInfoPo> personInfoPos) {
		this.personInfoPos = personInfoPos;
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

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public List<CustomerInfoPo> getCustomerInfoList() {
		return customerInfoList;
	}

	public void setCustomerInfoList(List<CustomerInfoPo> customerInfoList) {
		this.customerInfoList = customerInfoList;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}
	
	/**
	 * 连接HIS系统初始化会员查询页面-读卡器
	 * 
	 */
	public String initSCIHISdukaWin() throws Exception {
		
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
		
		String pflag = Utility.getName(request.getParameter("pflag"));
		 
		request.setAttribute("pflag", pflag);
		request.setAttribute("personInfoPo", personInfoPo);
		
		return SUCCESS;
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String SCIHISdukaWin() throws Exception {
		

		return SUCCESS;
	}
	
	/**
	 * 连接HIS系统初始化会员查询页面-扫码
	 * @return
	 * @throws Exception
	 */
	public String initSCIHISsaomaWin() throws Exception {
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
		
		String pflag = Utility.getName(request.getParameter("pflag"));
		 
		request.setAttribute("pflag", pflag);
		request.setAttribute("personInfoPo", personInfoPo);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String SCIHISsaomaWin() throws Exception {
		
		return SUCCESS;
	}
	

	/**
	 * 初始化顾客基本资料查询
	 */
	public String initSelCustomerInfoWin() throws Exception {
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
		
		String type = Utility.getName(request.getParameter("type"));
		String isnullfcustomerid = Utility.getName(request.getParameter("isnullfcustomerid"));
		request.setAttribute("type", type);
		request.setAttribute("isnullfcustomerid", isnullfcustomerid);
		
		String customerjsp = Utility.getName(request.getParameter("customerjsp"));
		request.setAttribute("customerjsp", customerjsp);
		
		return SUCCESS;
	}

	/**
	 * 查询顾客基本资料列表
	 */
	public String selCustomerInfoWin() throws Exception {
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

		personInfoPos = personInfoMgr.getModulePersoninfoPoList(moduleID,personInfoPo.getDepartmentID());
		String memberid = Utility.getName(request.getParameter("memberid"));
		String name = Utility.getName(request.getParameter("name"));
		String phone = Utility.getName(request.getParameter("phone"));
		String sex = Utility.getName(request.getParameter("sex"));
		String type = Utility.getName(request.getParameter("type"));
		String customerjsp = Utility.getName(request.getParameter("customerjsp"));
		request.setAttribute("customerjsp", customerjsp);
		String isnullfcustomerid = Utility.getName(request.getParameter("isnullfcustomerid"));

		List<DepartmentsPo> departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo);
		
		CustomerInfoPo po = new CustomerInfoPo();
		po.setSmecimemberid(memberid);
		po.setSmeciname(name);
		po.setSmeciphone(phone);
		po.setSmecisex(sex);
		po.setSmeciflag("1");
		po.setIsnullfcustomerid(isnullfcustomerid);//设置仅仅查询主卡会员
		po.setSmecishoplist(getDepartmentListBySystemParameter(systemParameterPo,departmentsList));
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = customerInfoMgr.getCustomerInfoCount(po);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			customerInfoList = customerInfoMgr.getCustomerInfoList(po, page
					.getStart(), page.getPageSize());
			
			//计算顾客年龄
			for (CustomerInfoPo customer : customerInfoList) {
				if (!Utility.getName(customer.getSmecibirthday()).equals("")){
					String birthdayYear = customer.getSmecibirthday().substring(0,4);
					int age = Calendar.getInstance().get(Calendar.YEAR)	- Integer.parseInt(birthdayYear);
					customer.setFmmage(Integer.toString(age));	
				}
			}

			
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			customerInfoList = null;
		}

		request.setAttribute("memberid", memberid);
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("sex", sex);
		request.setAttribute("type", type);
		request.setAttribute("isnullfcustomerid", isnullfcustomerid);

		return SUCCESS;
	}
}
