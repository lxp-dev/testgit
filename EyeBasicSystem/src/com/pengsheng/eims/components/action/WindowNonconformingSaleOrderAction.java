package com.pengsheng.eims.components.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.components.mgr.WindowNonconformingSaleOrderMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class WindowNonconformingSaleOrderAction extends BaseAction {
	
	private DepartmentsMgr departmentsMgr;
	
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

	private List<DepartmentsPo> departmentList;
	
	private SalesBasicPo salesBasicPo;
	
	private WindowNonconformingSaleOrderMgr windowNonconformingSaleOrderMgr;
	
	private List<SalesDetailPo> getSaleList;
	
	private SalesDetailPo salesDetailPo;
	
	private List<SalesBasicPo> getSalesOrderList;
	
	public List<SalesBasicPo> getGetSalesOrderList() {
		return getSalesOrderList;
	}

	public void setGetSalesOrderList(List<SalesBasicPo> getSalesOrderList) {
		this.getSalesOrderList = getSalesOrderList;
	}

	public List<SalesDetailPo> getGetSaleList() {
		return getSaleList;
	}

	public void setGetSaleList(List<SalesDetailPo> getSaleList) {
		this.getSaleList = getSaleList;
	}

	public SalesDetailPo getSalesDetailPo() {
		return salesDetailPo;
	}

	public void setSalesDetailPo(SalesDetailPo salesDetailPo) {
		this.salesDetailPo = salesDetailPo;
	}

	public WindowNonconformingSaleOrderMgr getWindowNonconformingSaleOrderMgr() {
		return windowNonconformingSaleOrderMgr;
	}

	public void setWindowNonconformingSaleOrderMgr(
			WindowNonconformingSaleOrderMgr windowNonconformingSaleOrderMgr) {
		this.windowNonconformingSaleOrderMgr = windowNonconformingSaleOrderMgr;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public List<DepartmentsPo> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<DepartmentsPo> departmentList) {
		this.departmentList = departmentList;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	/**
	 * 初始化显示商品详细信息
	 * @return
	 */
	public String initWindowNonformingOrderSel(){
		String ssesbshopcode=Utility.getName(request.getParameter("cshandepartmentid"));
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		request.setAttribute("cshandepartmentid", ssesbshopcode);
		
		return SUCCESS;
	}
	
	/**
	 * 显示商品详细信息
	 * @return
	 */
	public String selectWindowNonformingOrder(){
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		
		//销售单号
		String ssesbsalesid=Utility.getName(request.getParameter("poID"));
		request.setAttribute("ssesbsalesid", ssesbsalesid);
		
		salesBasicPo=new SalesBasicPo();
		salesBasicPo.setSsesbsalesid(ssesbsalesid);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			salesBasicPo.setSsesbcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		salesDetailPo=new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(ssesbsalesid);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			salesDetailPo.setSsesdcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());

		//查询销售单中商品信息个数
		int count = windowNonconformingSaleOrderMgr.getNonconformingSaleCount(salesDetailPo);
		//分页
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
			//得到销售单中商品详细信息
			getSaleList=windowNonconformingSaleOrderMgr.getNonconformingSaleList(salesDetailPo, page.getStart(), page.getPageSize());
			
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			getSaleList = null;
		}
		
		//得到顾客信息
		salesBasicPo=windowNonconformingSaleOrderMgr.getCustmorInfo(salesBasicPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化查询配镜单号
	 * @return
	 */
	public String initWindowNonformingSaleOrderSel(){
		//得到部门信息
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		DepartmentsPo departmentsPo=new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		departmentsPo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsPo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsPo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		//部门LIst
		departmentList=departmentsMgr.getDepartments(departmentsPo);
		
		return SUCCESS;
	}
	
	/**
	 * 查询配镜单号
	 * @return
	 */
	public String selectWindowNonformingSaleOrder(){
		//条件查询
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("saleStartTime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("saleEndTime"));
		String ssesbtakeglassstartdata=Utility.getName(request.getParameter("takeStartTime"));
		String ssesbtakeglassenddata=Utility.getName(request.getParameter("takeEndTime"));
		String ssesbshopcode=Utility.getName(request.getParameter("salesBasicPo.ssesbshopcode"));
		String ssesbsalesid=Utility.getName(request.getParameter("poID"));
		String memberid=Utility.getName(request.getParameter("memberid"));
		String customerphone=Utility.getName(request.getParameter("customerphone"));
		
		request.setAttribute("poID", ssesbsalesid);
		request.setAttribute("ssesbshopcode", ssesbshopcode);
		request.setAttribute("saleStartTime", ssesbsalesdatestarttime);
		request.setAttribute("saleEndTime", ssesbsalesdateendtime);
		request.setAttribute("takeStartTime", ssesbtakeglassstartdata);
		request.setAttribute("memberid", memberid);
		request.setAttribute("customerphone", customerphone);
		
		
		//部门信息
		DepartmentsPo departmentsPo=new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		departmentsPo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsPo.setBdptype(personInfoPo.getDepartmenttype());
		departmentsPo.setBdpisalldepartments("all");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsPo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		departmentList=departmentsMgr.getDepartments(departmentsPo);
		
		salesBasicPo=new SalesBasicPo();
		salesBasicPo.setSsesbshopcode(ssesbshopcode);
		salesBasicPo.setSsesbphone(customerphone);
		salesBasicPo.setSsesbMemberId(memberid);
		salesBasicPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesBasicPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesBasicPo.setSsesbtakeglassstartdata(ssesbtakeglassstartdata);
		salesBasicPo.setSsesbtakeglassenddata(ssesbtakeglassenddata);
		salesBasicPo.setSsesbsalesid(ssesbsalesid);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			salesBasicPo.setSsesbcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//王磊 05-27
		salesBasicPo.setSsesbdepid(personInfoPo.getDepartmenttype());
		//王磊 05-27
		
		//查询销售单个数
		int count = windowNonconformingSaleOrderMgr.getSaleOrderCount(salesBasicPo);
		//分页
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
			//得到销售单号
			getSalesOrderList=windowNonconformingSaleOrderMgr.getSaleOrderList(salesBasicPo, page.getStart(), page.getPageSize());
			
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			getSalesOrderList = null;
		}
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));
		
		return SUCCESS;
	}

}
