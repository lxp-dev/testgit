package com.pengsheng.eims.components.action;

import java.util.List;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.components.mgr.SalesBasicMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;

public class SalesBasicAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	private List<DepartmentsPo> deptList;
	
	private SupplierMgr supplierMgr;
	
	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}

	private List<GoodsCategoryPo> goodsCategoryList;
	
	public List<GoodsCategoryPo> getGoodsCategoryList() {
		return goodsCategoryList;
	}

	public void setGoodsCategoryList(List<GoodsCategoryPo> goodsCategoryList) {
		this.goodsCategoryList = goodsCategoryList;
	}

	private DepartmentsPo departmentsPo;
	
	public DepartmentsPo getDepartmentsPo() {
		return departmentsPo;
	}

	public void setDepartmentsPo(DepartmentsPo departmentsPo) {
		this.departmentsPo = departmentsPo;
	}

	private SalesBasicMgr salesBasicMgr;
	
	private List<SalesBasicPo> salesBasicList;
	
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
	
	public List<SalesBasicPo> getSalesBasicList() {
		return salesBasicList;
	}

	public void setSalesBasicList(List<SalesBasicPo> salesBasicList) {
		this.salesBasicList = salesBasicList;
	}

	public SalesBasicMgr getSalesBasicMgr() {
		return salesBasicMgr;
	}

	public void setSalesBasicMgr(SalesBasicMgr salesBasicMgr) {
		this.salesBasicMgr = salesBasicMgr;
	}

	public List<DepartmentsPo> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<DepartmentsPo> deptList) {
		this.deptList = deptList;
	}

	/**
	 * 初始化销售结帐基表信息
	 * @return
	 */
    public String initSalesBasicSel(){
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
    	deptList=salesBasicMgr.getDepartments();
		return SUCCESS;
	}
    
    /**
     * 查询配镜单信息
     * @return
     * @throws Exception
     */
    public String selectSalesBasic()throws Exception{	
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
    	String salesid=Utility.getName(request.getParameter("salesid"));
    	String shopcode=Utility.getName(request.getParameter("shopcode"));
    	String shopName=Utility.getName(request.getParameter("shopName"));
    	String customerid=Utility.getName(request.getParameter("customerid"));
    	String personName=Utility.getName(request.getParameter("personName"));
    	String customerName=Utility.getName(request.getParameter("customerName"));
    	String takeglassstartdata=Utility.getName(request.getParameter("takeglassstartdata"));
    	String takeglassenddata=Utility.getName(request.getParameter("takeglassenddata"));
    	
    	SalesBasicPo po=new SalesBasicPo();
    	po.setSsesbsalesid(salesid);
    	po.setSsesbcustomerid(customerid);
    	po.setSsesbpersonName(personName);
    	po.setSsesbcustomerid(customerName);
    	po.setSsesbshopcode(shopcode);
    	po.setSsesbshopName(shopName);
    	po.setSsesbtakeglassdata(takeglassstartdata);
    	po.setSsesbtakeglassenddata(takeglassenddata);
    	systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
    	int count=salesBasicMgr.getSalesBasicCount(po);
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
	    salesBasicList=salesBasicMgr.getSalesBasicList(po,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			salesBasicList = null;
		}	
		request.setAttribute("salesid", salesid);
		request.setAttribute("shopcode", shopcode);
		request.setAttribute("shopName", shopName);
		request.setAttribute("customerName", customerName);
		request.setAttribute("customerid", customerid);
		request.setAttribute("personName", personName);
		request.setAttribute("ssesbtakeglassstartdata", takeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata", takeglassenddata);
		deptList=salesBasicMgr.getDepartments();
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));
		
    	return SUCCESS;
    }
    
    /**
     * 各公司月销售成本
     * @return
     * @throws Exception
     */
    public String initEachCompanySalesContrast()throws Exception{
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 Calendar c = Calendar.getInstance();
    	 goodsCategoryList = supplierMgr.getGoodsCategoryList();
    	 request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));
    	return SUCCESS;
    }

}
