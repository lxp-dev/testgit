package com.pengsheng.eims.components.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.components.mgr.WindowConsignProcessOrderMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.SalesTempPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
/**
 * 委外管理的开窗action
 */
public class WindowConsignProcessOrderAction extends BaseAction{
	
	private WindowConsignProcessOrderMgr windowConsignProcessOrderMgr;
	
	private SupplierMgr supplierMgr;
	
	private DepartmentsMgr departmentsMgr;
	
	private List<ConsignProcessOrderDetailsPo> goodsList;
	
	private List<SalesBasicPo> salesList;
	
	private List<DepartmentsPo> deptList;
	
	private ConsignProcessReceiptPo consignProcessReceiptPo;
	
	private List<ConsignProcessReceiptPo> consignProcessReceiptList;
	
	private SalesBasicPo salesBasicPo;
	
	private SalesTempPo salesTempPo;	
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
	
	public SalesTempPo getSalesTempPo() {
		return salesTempPo;
	}

	public void setSalesTempPo(SalesTempPo salesTempPo) {
		this.salesTempPo = salesTempPo;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public List<SalesBasicPo> getSalesList() {
		return salesList;
	}

	public void setSalesList(List<SalesBasicPo> salesList) {
		this.salesList = salesList;
	}

	public List<ConsignProcessReceiptPo> getConsignProcessReceiptList() {
		return consignProcessReceiptList;
	}

	public void setConsignProcessReceiptList(
			List<ConsignProcessReceiptPo> consignProcessReceiptList) {
		this.consignProcessReceiptList = consignProcessReceiptList;
	}

	public ConsignProcessReceiptPo getConsignProcessReceiptPo() {
		return consignProcessReceiptPo;
	}

	public void setConsignProcessReceiptPo(
			ConsignProcessReceiptPo consignProcessReceiptPo) {
		this.consignProcessReceiptPo = consignProcessReceiptPo;
	}

	public List<DepartmentsPo> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<DepartmentsPo> deptList) {
		this.deptList = deptList;
	}

	public WindowConsignProcessOrderMgr getWindowConsignProcessOrderMgr() {
		return windowConsignProcessOrderMgr;
	}

	public void setWindowConsignProcessOrderMgr(
			WindowConsignProcessOrderMgr windowConsignProcessOrderMgr) {
		this.windowConsignProcessOrderMgr = windowConsignProcessOrderMgr;
	}

	/**
	 * 初始化委外订单开窗
	 */
	public String initSalesBasicForConsignProcessOpen()throws Exception{		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		String ordersType=Utility.getName(request.getParameter("ordersType"));
		String supplierID=Utility.getName(request.getParameter("supplierID"));	
		if(!"".equals(Utility.getName(supplierID))){
			SupplierPo supplierPo=new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo=supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName",supplierPo.getBspsuppliername());
		}		
		request.setAttribute("ordersType",ordersType);
		request.setAttribute("supplierID",supplierID);
				
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		String[] str = {"1"};
		
		deptList = departmentsMgr.getDepartments(str,"0",Utility.getName(deppo.getBdpcompanysid()));
	
		return SUCCESS;
	}
	
	/**
	 * 查询委外订单开窗
	 */
	public String openSalesBasicForConsignProcess()throws Exception{		
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		String ordersType=Utility.getName(request.getParameter("ordersType"));
		String supplierID=Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String salesID=Utility.getName(request.getParameter("salesID"));
		String ssesbdragstype=Utility.getName(request.getParameter("ssesbdragstype"));
		String deptID=Utility.getName(request.getParameter("deptID"));	
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("ssesbsalesdateendtime"));	
		String ssesbtakeglassstartdata=Utility.getName(request.getParameter("ssesbtakeglassstartdata"));
		String ssesbtakeglassenddata=Utility.getName(request.getParameter("ssesbtakeglassenddata"));	
		
		SalesBasicPo salesBasicPo=new SalesBasicPo();
		salesBasicPo.setSsesbsupplierid(supplierID);
		salesBasicPo.setSsesborderstype(ordersType);
		salesBasicPo.setSsesbsalesid(salesID);
		salesBasicPo.setSsesbshopcode(deptID);
		salesBasicPo.setSsesbdragstype(ssesbdragstype);
		salesBasicPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesBasicPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesBasicPo.setSsesbtakeglassstartdata(ssesbtakeglassstartdata);
		salesBasicPo.setSsesbtakeglassenddata(ssesbtakeglassenddata);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			salesBasicPo.setSsesbcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count=windowConsignProcessOrderMgr.getSalesBasicForConsignProcessCount(salesBasicPo);
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
	    goodsList=windowConsignProcessOrderMgr.getSalesBasicForConsignProcessList(salesBasicPo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			goodsList = null;
		}	

		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		String[] str = {"1"};
		
		deptList = departmentsMgr.getDepartments(str,"0",Utility.getName(deppo.getBdpcompanysid()));
	
		request.setAttribute("ordersType",ordersType);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("ssesbdragstype",ssesbdragstype);
		
		request.setAttribute("salesID",salesID);
		request.setAttribute("deptID",deptID);
		request.setAttribute("ssesbsalesdatestarttime",ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime",ssesbsalesdateendtime);
		request.setAttribute("ssesbtakeglassstartdata",ssesbtakeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata",ssesbtakeglassenddata);
				
		return SUCCESS;
	}
	/**
	 * 初始化手动框镜委外订单开窗
	 */
	public String initGlassForConsignProcessOpen()throws Exception{		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String ordersType=Utility.getName(request.getParameter("ordersType"));
		String billtype=Utility.getName(request.getParameter("billtype"));
		String supplierID=Utility.getName(request.getParameter("supplierID"));	
		String salesID=Utility.getName(request.getParameter("salesID"));
		String deptID=Utility.getName(request.getParameter("deptID"));
		String cstcpodglassesbillid=Utility.getName(request.getParameter("cstcpodglassesbillid"));
		String cstcpodsalesbillid=Utility.getName(request.getParameter("cstcpodsalesbillid"));	
		String cstcpodcustomername=Utility.getName(request.getParameter("cstcpodcustomername"));
		String cstcpodcustomerid=Utility.getName(request.getParameter("cstcpodcustomerid"));
		String cstcpodarriveddate=Utility.getName(request.getParameter("cstcpodarriveddate"));
		String dragsType=Utility.getName(request.getParameter("dragsType"));

		
		if(!"".equals(Utility.getName(supplierID))){
			SupplierPo supplierPo=new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo=supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName",supplierPo.getBspsuppliername());
		}	
		//PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		
		if("".equals(cstcpodglassesbillid)){
			cstcpodglassesbillid="W"+GenerateNumber.getInstance().getGenerageNumber();
		}

		request.setAttribute("cstcpodglassesbillid",cstcpodglassesbillid);
		request.setAttribute("ordersType",ordersType);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("salesID",salesID);
		request.setAttribute("deptID",deptID);
		request.setAttribute("billtype",billtype);
		request.setAttribute("cstcpodsalesbillid",cstcpodsalesbillid);
		request.setAttribute("cstcpodcustomername",cstcpodcustomername);
		request.setAttribute("cstcpodcustomerid",cstcpodcustomerid);
		request.setAttribute("cstcpodarriveddate",cstcpodarriveddate);
		request.setAttribute("dragsType",dragsType);
		
		
		SalesBasicPo salesBasicPo=new SalesBasicPo();
		salesBasicPo.setSsesbsalesid(salesID);
		salesTempPo=windowConsignProcessOrderMgr.getSalesForConsignProcessPo(salesBasicPo);	
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		String[] str = {"1"};
		
		deptList = departmentsMgr.getDepartments(str,"0",Utility.getName(deppo.getBdpcompanysid()));	

		return SUCCESS;
	}
	/**
	 * 初始化手动隐形委外订单开窗
	 */
	public String initStealthForConsignProcessOpen()throws Exception{		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String ordersType=Utility.getName(request.getParameter("ordersType"));
		String billtype=Utility.getName(request.getParameter("billtype"));
		String supplierID=Utility.getName(request.getParameter("supplierID"));	
		String salesID=Utility.getName(request.getParameter("salesID"));
		String deptID=Utility.getName(request.getParameter("deptID"));
		String cstcpodglassesbillid=Utility.getName(request.getParameter("cstcpodglassesbillid"));
		String cstcpodsalesbillid=Utility.getName(request.getParameter("cstcpodsalesbillid"));	
		String cstcpodcustomername=Utility.getName(request.getParameter("cstcpodcustomername"));
		String cstcpodcustomerid=Utility.getName(request.getParameter("cstcpodcustomerid"));
		String cstcpodarriveddate=Utility.getName(request.getParameter("cstcpodarriveddate"));
		String dragsType=Utility.getName(request.getParameter("dragsType"));

		
		if(!"".equals(Utility.getName(supplierID))){
			SupplierPo supplierPo=new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo=supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName",supplierPo.getBspsuppliername());
		}	
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		
		if("".equals(cstcpodglassesbillid)){
			cstcpodglassesbillid="W"+GenerateNumber.getInstance().getGenerageNumber();
		}

		request.setAttribute("cstcpodglassesbillid",cstcpodglassesbillid);
		request.setAttribute("ordersType",ordersType);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("salesID",salesID);
		request.setAttribute("deptID",deptID);
		request.setAttribute("billtype",billtype);
		request.setAttribute("cstcpodsalesbillid",cstcpodsalesbillid);
		request.setAttribute("cstcpodcustomername",cstcpodcustomername);
		request.setAttribute("cstcpodcustomerid",cstcpodcustomerid);
		request.setAttribute("cstcpodarriveddate",cstcpodarriveddate);
		request.setAttribute("dragsType",dragsType);
		
		
		SalesBasicPo salesBasicPo=new SalesBasicPo();
		salesBasicPo.setSsesbsalesid(salesID);
		salesTempPo=windowConsignProcessOrderMgr.getSalesForConsignProcessPo(salesBasicPo);	
		
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		String[] str = {"1"};
		
		deptList = departmentsMgr.getDepartments(str,"0",Utility.getName(deppo.getBdpcompanysid()));	
		
		return SUCCESS;
	}
	/**
	 * 查询委外订单商品开窗
	 */
	public String initGoodsForConsignProcessOpen()throws Exception{		
		
		String glassflag=Utility.getName(request.getParameter("glassflag"));
		String goodscategory=Utility.getName(request.getParameter("goodscategory"));
		String supplierID=Utility.getName(request.getParameter("supplierID"));
		
		if(!"".equals(Utility.getName(supplierID))){
			SupplierPo supplierPo=new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo=supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName",supplierPo.getBspsuppliername());
		}		
		String sph=Utility.getName(request.getParameter("sph"));
		String cyl=Utility.getName(request.getParameter("cyl"));
		String axis=Utility.getName(request.getParameter("axis"));
		String belowplusluminosity=Utility.getName(request.getParameter("belowplusluminosity"));
		String materialType=Utility.getName(request.getParameter("materialType"));
		String arriseglass=Utility.getName(request.getParameter("arriseglass"));
		String basis=Utility.getName(request.getParameter("basis"));
		String curvature1=Utility.getName(request.getParameter("curvature1"));
		String curvature2=Utility.getName(request.getParameter("curvature2"));
		String dia=Utility.getName(request.getParameter("dia"));
		

		request.setAttribute("glassflag",glassflag);
		request.setAttribute("goodscategory",goodscategory);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("sph",sph);
		request.setAttribute("cyl",cyl);
		request.setAttribute("axis",axis);
		request.setAttribute("belowplusluminosity",belowplusluminosity);
		request.setAttribute("materialType",materialType);
		request.setAttribute("arriseglass",arriseglass);
		request.setAttribute("basis",basis);
		request.setAttribute("curvature1",curvature1);
		request.setAttribute("curvature2",curvature2);
		request.setAttribute("dia",dia);		
		return SUCCESS;
	}
	/**
	 * 查询委外订单商品开窗
	 */
	public String selGoodsForConsignProcessOpen()throws Exception{		
		
		String glassflag=Utility.getName(request.getParameter("glassflag"));
		String goodscategory=Utility.getName(request.getParameter("goodscategory"));
		String supplierID=Utility.getName(request.getParameter("supplierID"));
		String supplierName=Utility.getName(request.getParameter("supplierName"));	
		String brandID=Utility.getName(request.getParameter("brandID"));
		String brandName=Utility.getName(request.getParameter("brandName"));		
//		String varietyID=Utility.getName(request.getParameter("varietyID"));
//		String varietyName=Utility.getName(request.getParameter("varietyName"));
		String goodsID=Utility.getName(request.getParameter("goodsID"));
		String goodsName=Utility.getName(request.getParameter("goodsName"));		
		String sph=Utility.getName(request.getParameter("sph"));
		String cyl=Utility.getName(request.getParameter("cyl"));
		String axis=Utility.getName(request.getParameter("axis"));
		String belowplusluminosity=Utility.getName(request.getParameter("belowplusluminosity"));	
		String materialType=Utility.getName(request.getParameter("materialType"));
		String arriseglass=Utility.getName(request.getParameter("arriseglass"));
		String basis=Utility.getName(request.getParameter("basis"));
		String curvature1=Utility.getName(request.getParameter("curvature1"));
		String curvature2=Utility.getName(request.getParameter("curvature2"));
		String dia=Utility.getName(request.getParameter("dia"));
		GoodsInfoPo goodsInfoPo=new GoodsInfoPo();
		goodsInfoPo.setBgigoodscategoryid(goodscategory);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);

		goodsInfoPo.setBgisph(sph);
		goodsInfoPo.setBgicyl(cyl);
		goodsInfoPo.setBgiaxis(axis);
		goodsInfoPo.setBgibelowplusluminosity(belowplusluminosity);
		goodsInfoPo.setBgieyeglassmaterialtype(materialType);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgicurvature1(curvature1);
		goodsInfoPo.setBgicurvature2(curvature2);
		goodsInfoPo.setBgidia(dia);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count=windowConsignProcessOrderMgr.getGoodsForConsignProcessCount(goodsInfoPo);
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
	    goodsList=windowConsignProcessOrderMgr.getGoodsForConsignProcessList(goodsInfoPo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			goodsList = null;
		}
		request.setAttribute("glassflag",glassflag);
		request.setAttribute("goodscategory",goodscategory);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandID",brandID);

		request.setAttribute("brandName",brandName);

		request.setAttribute("sph",sph);
		request.setAttribute("cyl",cyl);
		request.setAttribute("axis",axis);
		request.setAttribute("belowplusluminosity",belowplusluminosity);
		request.setAttribute("materialType",materialType);	
		request.setAttribute("goodsID",goodsID);	
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("arriseglass",arriseglass);
		request.setAttribute("basis",basis);
		request.setAttribute("curvature1",curvature1);
		request.setAttribute("curvature2",curvature2);
		request.setAttribute("dia",dia);	
		
		return SUCCESS;
	}
	/**
	 * 初始化外部的委外收货单开窗
	 */
	public String initGoodsForConsignProcessReceiptOpen()throws Exception{		

		return SUCCESS;
	}
	/**
	 * 外部的委外收货单开窗
	 */
	public String selGoodsForConsignProcessReceiptOpen()throws Exception{		
		
		String receiptbillID=Utility.getName(request.getParameter("billID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		ConsignProcessOrderDetailsPo po=new ConsignProcessOrderDetailsPo();
		po.setCstcpodglassesbillid(receiptbillID);
		po.setCstcpodarrivedstart(startTime);
		po.setCstcpodarrivedend(endTime);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count=windowConsignProcessOrderMgr.getGoodsForConsignProcessReceiptCount(po);
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
	    goodsList=windowConsignProcessOrderMgr.getGoodsForConsignProcessReceiptList(po,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			goodsList = null;
		}		
		
		request.setAttribute("billID",receiptbillID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		return SUCCESS;
	}
	/**
	 * 初始化外部的委外收货单查询开窗
	 */
	public String initConsignProcessReceiptwOpen()throws Exception{		

		return SUCCESS;
	}
	/**
	 * 查询外部的委外收货单开窗
	 */
	public String selConsignProcessReceiptwOpen()throws Exception{		

		
		String billID=Utility.getName(request.getParameter("billID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));

		consignProcessReceiptPo=new ConsignProcessReceiptPo();
		consignProcessReceiptPo.setCstcprreceiptbillid(billID);
		consignProcessReceiptPo.setCstcprstartTime(startTime);
		consignProcessReceiptPo.setCstcprendTime(endTime);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count=windowConsignProcessOrderMgr.getConsignProcessReceiptCount(consignProcessReceiptPo);
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
	    consignProcessReceiptList=windowConsignProcessOrderMgr.getConsignProcessReceiptList(consignProcessReceiptPo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			consignProcessReceiptList = null;
		}		
		
		request.setAttribute("billID",billID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		
		return SUCCESS;
	}
	/**
	 * 初始化查询外部的委外收货单开窗
	 */
	public String initSelSalesConsignProcessReceiptOpen()throws Exception{	
		
		String ordersType=Utility.getName(request.getParameter("ordersType"));
		request.setAttribute("ordersType",ordersType);
		String deptID=Utility.getName(request.getParameter("deptID"));
		request.setAttribute("deptID",deptID);
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		String[] str = {"1"};
		
		deptList = departmentsMgr.getDepartments(str,"0",Utility.getName(deppo.getBdpcompanysid()));	
		
		return SUCCESS;
	}
	/**
	 * 查询外部的委外收货单开窗
	 */
	public String selSalesConsignProcessReceiptOpen()throws Exception{		
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		String ordersType=Utility.getName(request.getParameter("ordersType"));
		String salesID=Utility.getName(request.getParameter("salesID"));
		String deptID=Utility.getName(request.getParameter("deptID"));	
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("ssesbsalesdateendtime"));	
		String ssesbtakeglassstartdata=Utility.getName(request.getParameter("ssesbtakeglassstartdata"));
		String ssesbtakeglassenddata=Utility.getName(request.getParameter("ssesbtakeglassenddata"));	
		SalesBasicPo salesBasicPo=new SalesBasicPo();
		salesBasicPo.setSsesborderstype(ordersType);
		salesBasicPo.setSsesbsalesid(salesID);
		salesBasicPo.setSsesbshopcode(deptID);
		salesBasicPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesBasicPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesBasicPo.setSsesbtakeglassstartdata(ssesbtakeglassstartdata);
		salesBasicPo.setSsesbtakeglassenddata(ssesbtakeglassenddata);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			salesBasicPo.setSsesbcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		
		int count=windowConsignProcessOrderMgr.getSalesForConsignProcessCount(salesBasicPo);
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
	    salesList=windowConsignProcessOrderMgr.getSalesForConsignProcessList(salesBasicPo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			salesList = null;
		}	

		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		String[] str = {"1"};
		
		deptList = departmentsMgr.getDepartments(str,"0",Utility.getName(deppo.getBdpcompanysid()));	
		
		request.setAttribute("ordersType",ordersType);
		request.setAttribute("salesID",salesID);
		request.setAttribute("deptID",deptID);
		request.setAttribute("ssesbsalesdatestarttime",ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime",ssesbsalesdateendtime);
		request.setAttribute("ssesbtakeglassstartdata",ssesbtakeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata",ssesbtakeglassenddata);
		
		return SUCCESS;
	}
	
	public List<ConsignProcessOrderDetailsPo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<ConsignProcessOrderDetailsPo> goodsList) {
		this.goodsList = goodsList;
	}

	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
}
