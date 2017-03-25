package com.pengsheng.eims.sales.action;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.PutOptometryOrderMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class PutOptometryOrderAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;

	private PutOptometryOrderMgr putOptometryOrderMgr;

	private List<SalesBasicPo> putOptometryOrderList;

	private SalesBasicPo salesBasicPo;

	private CustomerInfoPo customerInfoPo;

	private CustomerInfoMgr customerInfoMgr;
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

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public PutOptometryOrderMgr getPutOptometryOrderMgr() {
		return putOptometryOrderMgr;
	}

	public void setPutOptometryOrderMgr(
			PutOptometryOrderMgr putOptometryOrderMgr) {
		this.putOptometryOrderMgr = putOptometryOrderMgr;
	}

	public List<SalesBasicPo> getPutOptometryOrderList() {
		return putOptometryOrderList;
	}

	public void setPutOptometryOrderList(
			List<SalesBasicPo> putOptometryOrderList) {
		this.putOptometryOrderList = putOptometryOrderList;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	/**
	 * 初始化打印配镜单页面
	 * 
	 * @return
	 */
	public String initPutOptometrySel() {
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
	 * 打印配镜单
	 * 
	 * @return
	 */
	public String selectPutOptometry() {
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
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,personInfoPo.getDepartmentID());		
		
		// 得到当前登录人的部门 根据部门取出仓位
		String departmentId = personInfoPo.getDepartmentID();

		String customerid = Utility.getName(request
				.getParameter("smecicustomerid"));
		String memeberid = Utility.getName(request
				.getParameter("smecimemberid"));
		String salesid = Utility.getName(request.getParameter("fmmsalesid"));

		CustomerInfoPo customerPo = new CustomerInfoPo();
		customerPo.setSmecicustomerid(customerid);
		customerPo.setSmecimemberid(memeberid);
		customerPo.setFmmsalesid(salesid);
		customerPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
		
		CustomerInfoPo tempCustomerPo = new CustomerInfoPo();
		tempCustomerPo.setSmecimemberid(memeberid);
		tempCustomerPo.setFmmsalesid(salesid);
		tempCustomerPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
		
		if (StringUtils.isNotEmpty(salesid)) {
			// 按配镜单号查询顾客信息
			customerInfoPo = putOptometryOrderMgr.getCustmorInfo(customerPo);
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}

		} else if (StringUtils.isNotEmpty(customerPo.getSmecimemberid())) {
			// 查询顾客信息
			customerInfoPo = customerInfoMgr.getCustomerInfo(tempCustomerPo);
			// 年龄
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}
		}

		request.setAttribute("fmmsalesid", salesid);

		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {

			request.setAttribute("smecicustomerid", customerInfoPo
					.getSmecicustomerid());
			request.setAttribute("smecimemberid", memeberid);

			SalesBasicPo salesPo = new SalesBasicPo();
			salesPo.setSsesbshopcode(departmentId);
			salesPo.setSsesbsalesid(salesid);
			salesPo.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
			
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
			int count = putOptometryOrderMgr.getPutOptometryOrderCount(salesPo);
			if (count > 0) {
				int perPage = 0;
				if (request.getParameter("perPage") != null) {
					perPage = new Integer((String) request
							.getParameter("perPage")).intValue();
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
				putOptometryOrderList = putOptometryOrderMgr
						.selectPutOptometryOrder(salesPo, page.getStart(), page
								.getPageSize());
				request.setAttribute(Pagination.PAGINATION, page);
			} else {
				putOptometryOrderList = null;
			}
		}
		request.setAttribute("departmentID", departmentId);
		return SUCCESS;
	}
}
