package com.pengsheng.eims.components.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.components.mgr.WindowOrderMgr;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * 商品开窗action
 */
public class WindowOrderAction extends BaseAction {

	private WindowOrderMgr windowOrderMgr;

	private SupplierMgr supplierMgr;

	private CompanyNameMgr companyNameMgr;

	private List<GoodsInfoPo> goodsList;

	private List<ProcurementOrdersPo> procurementOrdersList;

	private List<ConsignProcessOrderPo> consignProcessReceiptList;
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

	public List<ProcurementOrdersPo> getProcurementOrdersList() {
		return procurementOrdersList;
	}

	public void setProcurementOrdersList(
			List<ProcurementOrdersPo> procurementOrdersList) {
		this.procurementOrdersList = procurementOrdersList;
	}

	public List<ConsignProcessOrderPo> getConsignProcessReceiptList() {
		return consignProcessReceiptList;
	}

	public void setConsignProcessReceiptList(
			List<ConsignProcessOrderPo> consignProcessReceiptList) {
		this.consignProcessReceiptList = consignProcessReceiptList;
	}

	public List<GoodsInfoPo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsInfoPo> goodsList) {
		this.goodsList = goodsList;
	}

	public WindowOrderMgr getWindowOrderMgr() {
		return windowOrderMgr;
	}

	public void setWindowOrderMgr(WindowOrderMgr windowOrderMgr) {
		this.windowOrderMgr = windowOrderMgr;
	}

	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}

	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}

	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}

	/**
	 * 初始化采购订单开窗查询
	 */
	public String initProcurementOrdersOpen() throws Exception {

		String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);
		return SUCCESS;
	}

	/**
	 * 采购订单开窗初始化
	 */
	public String initProcurementOrdersForOpen() throws Exception {

		String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String updatepage = Utility.getName(request.getParameter("updatepage"));
		String categoryID = Utility.getName(request.getParameter("category"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("updatepage", updatepage);
		request.setAttribute("categoryID", categoryID);

		return SUCCESS;
	}

	/**
	 * 采购订单开窗查询
	 */
	public String selProcurementOrdersForOpen() throws Exception {

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String poID = Utility.getName(request.getParameter("poID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String category = Utility.getName(request.getParameter("category"));
		String categoryID = Utility.getName(request.getParameter("categoryID"));
		String updatepage = Utility.getName(request.getParameter("updatepage"));
		

		ProcurementOrdersPo ordersPo = new ProcurementOrdersPo();
		ordersPo.setCstpid(poID);
		ordersPo.setCstpstarttime(startTime);
		ordersPo.setCstpendtime(endTime);
		ordersPo.setCstpsupplierid(supplierID);
		ordersPo.setCstpbilltypeid(poType);
		ordersPo.setCstpgoodscategory(category);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			ordersPo.setCstpcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowOrderMgr.getProcurementOrdersForCount(ordersPo);

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
			procurementOrdersList = windowOrderMgr.getProcurementOrdersForList(
					ordersPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			procurementOrdersList = null;
		}
		request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("poID", poID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("category", category);
		request.setAttribute("categoryID", categoryID);
		request.setAttribute("updatepage", updatepage);
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));
		
		return SUCCESS;
	}
	
	/**
	 * 隐形采购订单开窗初始化
	 */
	public String initProcurementOrdersForOpenyx() throws Exception {

		String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String updatepage = Utility.getName(request.getParameter("updatepage"));
		String categoryID = Utility.getName(request.getParameter("category"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("updatepage", updatepage);
		request.setAttribute("categoryID", categoryID);

		return SUCCESS;
	}

	/**
	 * 隐形采购订单开窗查询
	 */
	public String selProcurementOrdersForOpenyx() throws Exception {

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String poID = Utility.getName(request.getParameter("poID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String category = Utility.getName(request.getParameter("category"));
		String categoryID = Utility.getName(request.getParameter("categoryID"));
		String updatepage = Utility.getName(request.getParameter("updatepage"));
		

		ProcurementOrdersPo ordersPo = new ProcurementOrdersPo();
		ordersPo.setCstpid(poID);
		ordersPo.setCstpstarttime(startTime);
		ordersPo.setCstpendtime(endTime);
		ordersPo.setCstpsupplierid(supplierID);
		ordersPo.setCstpbilltypeid(poType);
		ordersPo.setCstpgoodscategory(category);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			ordersPo.setCstpcompanyid(personInfoPo.getPersoncompanyid());
		}

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowOrderMgr.getProcurementOrdersForyxCount(ordersPo);

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
			procurementOrdersList = windowOrderMgr.getProcurementOrdersForyxList(
					ordersPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			procurementOrdersList = null;
		}
		request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("poID", poID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("category", category);
		request.setAttribute("categoryID", categoryID);
		request.setAttribute("updatepage", updatepage);
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));
		
		return SUCCESS;
	}
	
	/**
	 * 采购订单开窗初始化
	 */
	public String initProcurementOrdersForOpens() throws Exception {

		String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String updatepage = Utility.getName(request.getParameter("updatepage"));
		String categoryID = Utility.getName(request.getParameter("category"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("updatepage", updatepage);
		request.setAttribute("categoryID", categoryID);

		return SUCCESS;
	}

	/**
	 * 采购订单开窗查询
	 */
	public String selProcurementOrdersForOpens() throws Exception {

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String poID = Utility.getName(request.getParameter("poID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String category = Utility.getName(request.getParameter("category"));
		String categoryID = Utility.getName(request.getParameter("categoryID"));
		String updatepage = Utility.getName(request.getParameter("updatepage"));
		
		ProcurementOrdersPo ordersPo = new ProcurementOrdersPo();
		ordersPo.setCstpid(poID);
		ordersPo.setCstpstarttime(startTime);
		ordersPo.setCstpendtime(endTime);
		ordersPo.setCstpsupplierid(supplierID);
		ordersPo.setCstpbilltypeid(poType);
		ordersPo.setCstpgoodscategory(category);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			ordersPo.setCstpcompanyid(personInfoPo.getPersoncompanyid());
		}

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		ordersPo.setFspstealtheffective(systemParameterPo.getFspstealtheffective());
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowOrderMgr.getProcurementOrdersForCount1(ordersPo);

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
			procurementOrdersList = windowOrderMgr.getProcurementOrdersForList1(
					ordersPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			procurementOrdersList = null;
		}
		request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("poID", poID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("category", category);
		request.setAttribute("categoryID", categoryID);
		request.setAttribute("updatepage", updatepage);
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));

		return SUCCESS;
	}
	
	/**
	 * 采购订单开窗初始化
	 */
	public String initProcurementOrdersForOpensyx() throws Exception {

		String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String updatepage = Utility.getName(request.getParameter("updatepage"));
		String categoryID = Utility.getName(request.getParameter("category"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("updatepage", updatepage);
		request.setAttribute("categoryID", categoryID);

		return SUCCESS;
	}

	/**
	 * 采购订单开窗查询
	 */
	public String selProcurementOrdersForOpensyx() throws Exception {

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String poID = Utility.getName(request.getParameter("poID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String category = Utility.getName(request.getParameter("category"));
		String categoryID = Utility.getName(request.getParameter("categoryID"));
		String updatepage = Utility.getName(request.getParameter("updatepage"));
		

		ProcurementOrdersPo ordersPo = new ProcurementOrdersPo();
		ordersPo.setCstpid(poID);
		ordersPo.setCstpstarttime(startTime);
		ordersPo.setCstpendtime(endTime);
		ordersPo.setCstpsupplierid(supplierID);
		ordersPo.setCstpbilltypeid(poType);
		ordersPo.setCstpgoodscategory(category);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			ordersPo.setCstpcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowOrderMgr.getProcurementOrdersForyxCount1(ordersPo);

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
			procurementOrdersList = windowOrderMgr.getProcurementOrdersForyxList1(
					ordersPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			procurementOrdersList = null;
		}
		request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("poID", poID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("category", category);
		request.setAttribute("categoryID", categoryID);
		request.setAttribute("updatepage", updatepage);
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));

		return SUCCESS;
	}

	/**
	 * 采购订单开窗查询
	 */
	public String openProcurementOrders() throws Exception {

		String poID = Utility.getName(request.getParameter("poID"));
		String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request
				.getParameter("supplierName"));
		ProcurementOrdersPo po = new ProcurementOrdersPo();
		po.setCstpid(poID);
		po.setCstpbilltypeid(poType);
		po.setCstpsupplierid(supplierID);

		int count = windowOrderMgr.getProcurementOrdersCount(po);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
			goodsList = windowOrderMgr.getProcurementOrdersList(po, page
					.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		request.setAttribute("poID", poID);
		request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		return SUCCESS;
	}

	/**
	 * 初始化委外订单开窗查询
	 */
	public String initConsignProcessReceiptOpen() throws Exception {

		String supplierID = Utility.getName(request.getParameter("supplierID"));

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}

		request.setAttribute("supplierID", supplierID);
		return SUCCESS;
	}

	/**
	 * 委外订单开窗初始化
	 */
	public String initConsignProcessReceiptForOpen() throws Exception {

		String supplierID = Utility.getName(request.getParameter("supplierID"));
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}

		request.setAttribute("supplierID", supplierID);

		return SUCCESS;
	}

	/**
	 * 委外订单开窗查询
	 */
	public String selConsignProcessReceiptForOpen() throws Exception {

		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String poID = Utility.getName(request.getParameter("poID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String supplierName = Utility.getName(request
				.getParameter("supplierName"));

		ConsignProcessOrderPo ordersPo = new ConsignProcessOrderPo();
		ordersPo.setCstcpoorderbillid(poID);
		ordersPo.setCstcpostarttime(startTime);
		ordersPo.setCstcpoendtime(endTime);
		ordersPo.setCstcposupplierid(supplierID);
		ordersPo.setCstcpoauditstate("1");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowOrderMgr.getConsignProcessOrderForCount(ordersPo);

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
			consignProcessReceiptList = windowOrderMgr
					.getConsignProcessOrderForList(ordersPo, page.getStart(),
							page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			consignProcessReceiptList = null;
		}

		request.setAttribute("supplierID", supplierID);
		request.setAttribute("poID", poID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("supplierName", supplierName);

		return SUCCESS;
	}

	/**
	 * 委外订单开窗查询
	 */
	public String openConsignProcessReceipt() throws Exception {

		String poID = Utility.getName(request.getParameter("poID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request
				.getParameter("supplierName"));

		ConsignProcessOrderPo ordersPo = new ConsignProcessOrderPo();
		ordersPo.setCstcpoorderbillid(poID);
		ordersPo.setCstcposupplierid(supplierID);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowOrderMgr.getConsignProcessOrderCount(ordersPo);

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
			goodsList = windowOrderMgr.getConsignProcessOrderList(ordersPo,
					page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		request.setAttribute("poID", poID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		return SUCCESS;
	}

	/**
	 * 取订单系统发货单单信息
	 */
	public String initInvoiceOpen() throws Exception {

		String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);
		return SUCCESS;
	}

	/**
	 * 取订单系统未处理发货单总数
	 */
	public String initInvoiceForOpen() throws Exception {

		// String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		// request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);

		return SUCCESS;
	}

	/**
	 * 采购订单开窗查询
	 */
	public String selInvoiceForOpen() throws Exception {

		String poType = Utility.getName(request.getParameter("poType"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String poID = Utility.getName(request.getParameter("poID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String supplierName = Utility.getName(request
				.getParameter("supplierName"));

		// 订单制造商编码
		SupplierPo supplierPo = new SupplierPo();
		supplierPo.setBspid(supplierID);
		supplierPo = supplierMgr.getSupplier(supplierPo);

		// 取公司别名
		CompanyNamePo companyNamePo = companyNameMgr.getCompanyName(null);

		ProcurementOrdersPo ordersPo = new ProcurementOrdersPo();
		ordersPo.setCstpid(poID);
		ordersPo.setCstpstarttime(startTime);
		ordersPo.setCstpendtime(endTime);
		ordersPo.setCstpsupplierid(supplierPo.getBspordersupplierid());
		ordersPo.setCstpbilltypeid(poType);
		ordersPo.setCstpcustomerid(companyNamePo.getFcnId());

		// 切换换数据库
//		CustomerContextHolder.setCustomerType(CustomerType.orders);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowOrderMgr.getInvoiceForCount(ordersPo);

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
			procurementOrdersList = windowOrderMgr.getInvoiceForList(ordersPo,
					page.getStart(), page.getPageSize());

			for (ProcurementOrdersPo po : procurementOrdersList) {
				po.setCstpid(po.getCstpid().replace(
						companyNamePo.getFcnId() + "-", ""));
			}

			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			procurementOrdersList = null;
		}
		request.setAttribute("poType", poType);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("poID", poID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("supplierName", supplierName);

//		CustomerContextHolder.setCustomerType(CustomerType.eims);

		return SUCCESS;
	}
}
