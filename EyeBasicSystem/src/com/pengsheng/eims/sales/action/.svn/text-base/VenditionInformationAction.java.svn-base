package com.pengsheng.eims.sales.action;


import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.mgr.CustomerReturnVisitMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.CustomerVisitPo;
import com.pengsheng.eims.sales.mgr.VenditionInformationMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class VenditionInformationAction extends BaseAction {
	
	private VenditionInformationMgr venditionInformationMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private List<SalesBasicPo> salesBasicList;	
	private CustomerInfoMgr customerInfoMgr;
	private PersonPermissionMgr personPermissionMgr;
	private CustomerReturnVisitMgr customerReturnVisitMgr;
	private List<SalesBasicPo> customerReturnVisitList;
	
	public List<SalesBasicPo> getCustomerReturnVisitList() {
		return customerReturnVisitList;
	}

	public void setCustomerReturnVisitList(
			List<SalesBasicPo> customerReturnVisitList) {
		this.customerReturnVisitList = customerReturnVisitList;
	}

	public CustomerReturnVisitMgr getCustomerReturnVisitMgr() {
		return customerReturnVisitMgr;
	}

	public void setCustomerReturnVisitMgr(
			CustomerReturnVisitMgr customerReturnVisitMgr) {
		this.customerReturnVisitMgr = customerReturnVisitMgr;
	}


	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public List<SalesBasicPo> getSalesBasicList() {
		return salesBasicList;
	}

	public void setSalesBasicList(List<SalesBasicPo> salesBasicList) {
		this.salesBasicList = salesBasicList;
	}

	public VenditionInformationMgr getVenditionInformationMgr() {
		return venditionInformationMgr;
	}

	public void setVenditionInformationMgr(
			VenditionInformationMgr venditionInformationMgr) {
		this.venditionInformationMgr = venditionInformationMgr;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	/**
	*查看销售信息
	*@return
	*/
	public String selectVenditionInformation() throws Exception{
		
		CustomerInfoPo customerInfoPo=new CustomerInfoPo();
		if(!Utility.getName(request.getParameter("customerID")).equals("")){
			customerInfoPo.setSmecicustomerid(request.getParameter("customerID"));
		}
		if (customerInfoPo != null) {
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
				request.setAttribute("customerID", customerInfoPo.getSmecicustomerid());
			}
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
				systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
				int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
				int count = venditionInformationMgr.getcustomerSalesBasicCount(customerInfoPo.getSmecicustomerid());
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
					salesBasicList = venditionInformationMgr.getcustomerSalesBasicList(customerInfoPo.getSmecicustomerid(), page.getStart(),page.getPageSize());

//					for (SalesBasicPo basic : salesBasicList) {
//						basic.setSalesDetails(venditionInformationMgr.getcustomerSalesBasic(basic.getSsesbsalesid()));
//					}
					request.setAttribute(Pagination.PAGINATION, page);

				} else {
					salesBasicList = null;
				}
			}
			
		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);
		
		return SUCCESS;
	}
	
	/**
	*查看顾客回访
	*@return
	*/
	public String selectReturnVisitInformation()throws Exception{
		SalesBasicPo salesBasicPo = new SalesBasicPo();
		CustomerVisitPo customerVisitPo = new CustomerVisitPo();
		CustomerInfoPo customerInfoPo=new CustomerInfoPo();
		if(!Utility.getName(request.getParameter("customerID")).equals("")){
			customerInfoPo.setSmecicustomerid(request.getParameter("customerID"));
			
		}
		
		if (customerInfoPo != null) {
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
				request.setAttribute("customerID", customerInfoPo.getSmecicustomerid());
				customerVisitPo.setSmecimemberid(Utility.getName(customerInfoPo.getSmecimemberid()));
				customerVisitPo.setSmecvmemberid(Utility.getName(customerInfoPo.getSmecicustomerid()));
				customerVisitPo.setSmecvreturntype(Utility.getName("1"));
			}
		
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
				
				systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
				int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
				// 总数、分页
				int count = customerReturnVisitMgr.getCustomerReturnVisitCount(salesBasicPo, customerVisitPo,systemParameterPo);
				if (count > 0) {
					int perPage = 0;
					if (request.getParameter("perPage") != null) {
						perPage = new Integer((String) request.getParameter("perPage"))
								.intValue();
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
					// 取详细信息
					customerReturnVisitList = customerReturnVisitMgr.selectCustomerReturnVisitList(salesBasicPo,customerVisitPo, page.getStart(), page.getPageSize(),systemParameterPo);
					request.setAttribute(Pagination.PAGINATION, page);
				} else {
					customerReturnVisitList = null;
				}
			}
			
		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);
		
		return SUCCESS;
	}

	/**
	 * 查看积分消费
	 */
	public String integralExpense()throws Exception{
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

		String customerID = Utility.getName(request.getParameter("customerID"));
		request.setAttribute("customerID",customerID);
		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		
		//获取品种总数
		int count = venditionInformationMgr.getIntegralExpenseCount(customerID);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
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
			salesBasicList = venditionInformationMgr.getIntegralExpenseList(customerID, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			salesBasicList = null;
		}

		return SUCCESS;
	}
	/**
	 * 查看储值卡消费
	 */
	public String chuZhiKaExpense()throws Exception{
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

		String customerID = Utility.getName(request.getParameter("customerID"));
		request.setAttribute("customerID",customerID);
		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		
		//获取品种总数
		int count = venditionInformationMgr.getChuZhiKaExpenseCount(customerID);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
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
			salesBasicList = venditionInformationMgr.getChuZhiKaExpenseList(customerID, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			salesBasicList = null;
		}

		return SUCCESS;
	}
}
