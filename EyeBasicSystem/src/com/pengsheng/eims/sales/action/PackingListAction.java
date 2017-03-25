package com.pengsheng.eims.sales.action;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.PackingListMgr;
import com.pengsheng.eims.sales.mgr.PutOptometryOrderMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class PackingListAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;

	private PackingListMgr packingListMgr;

	private List<SalesBasicPo> salesBasicList;

	private SalesBasicPo salesBasicPo;

	private CustomerInfoPo customerInfoPo;

	private CustomerInfoMgr customerInfoMgr;
	
	private List<DepartmentsPo> departmentsList;
	
	private DepartmentsMgr departmentsMgr;

	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
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



	public PackingListMgr getPackingListMgr() {
		return packingListMgr;
	}

	public void setPackingListMgr(PackingListMgr packingListMgr) {
		this.packingListMgr = packingListMgr;
	}



	
	public List<SalesBasicPo> getSalesBasicList() {
		return salesBasicList;
	}

	public void setSalesBasicList(List<SalesBasicPo> salesBasicList) {
		this.salesBasicList = salesBasicList;
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
	public String initPackingListSel() {
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

		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdptype("1");
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments2(deppo);

		return SUCCESS;
	}

	/**
	 * 打印配镜单
	 * 
	 * @return
	 */
	public String selectPackingList() {
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
		request.setAttribute("systemParameterPo", systemParameterPo);
    	
    	//查询条件memberid
		String chooseflag=Utility.getName(request.getParameter("chooseflag"));
		String memberid=Utility.getName(request.getParameter("memberid"));
    	String salesid=Utility.getName(request.getParameter("salesid"));
    	String customerName=Utility.getName(request.getParameter("customerName"));
    	String shopcode=Utility.getName(request.getParameter("departmentid"));
    	String intransit=Utility.getName(request.getParameter("intransit"));
    	
    	String salesdatestarttime=Utility.getName(request.getParameter("salesdatestarttime"));
    	String salesdateendtime=Utility.getName(request.getParameter("salesdateendtime"));
    	
    	String takeglassstartdata=Utility.getName(request.getParameter("takeglassstartdata"));
    	String takeglassenddata=Utility.getName(request.getParameter("takeglassenddata"));
    	String ssesbphone=Utility.getName(request.getParameter("ssesbphone"));
    	String djsbm=Utility.getName(request.getParameter("djsbm"));
    	
    	SalesBasicPo po=new SalesBasicPo();
    	po.setSsesbsalesid(salesid);
    	po.setSsesbcustomerid(customerName);
    	po.setSsesbshopcode(shopcode);
    	po.setSsesbintransit(intransit);
    	po.setSsesbsalesdatestarttime(salesdatestarttime);
    	po.setSsesbsalesdateendtime(salesdateendtime);
    	po.setSsesbtakeglassstartdata(takeglassstartdata);
    	po.setSsesbtakeglassenddata(takeglassenddata);
    	po.setSsesbdepid(personInfoPo.getDepartmentID());
    	po.setSsesbdepartmenttype(personInfoPo.getDepartmenttype());
    	po.setSsesbchooseflag(chooseflag);
    	po.setSsesbMemberId(memberid);
    	po.setSsesbphone(ssesbphone);
    	po.setDjsbm(djsbm);
    	
    	//查询分页
    	int count=packingListMgr.getPackingListCount(po);
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
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
				
	    Pagination page = new Pagination(request, count, perPage);
	    salesBasicList=packingListMgr.selectPackingList(po, page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			salesBasicList = null;
		}
		//显示查询条件
		request.setAttribute("salesid", salesid);
		request.setAttribute("departmentid", shopcode);
		request.setAttribute("customerName", customerName);
		request.setAttribute("ssesbsalesdatestarttime", salesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime",salesdateendtime);
		request.setAttribute("ssesbtakeglassstartdata", takeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata", takeglassenddata);
		request.setAttribute("intransit", intransit);
		request.setAttribute("smecimemberid", memberid);
		request.setAttribute("chooseflag", chooseflag);
		request.setAttribute("ssesbphones", ssesbphone);
		request.setAttribute("djsbm", djsbm);
		
		// 取得登陆人允许操作的仓位&部门 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);
		// 取得登陆人允许操作的仓位&部门 End
		return SUCCESS;
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
