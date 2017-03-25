package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.storage.mgr.ConsignProcessWaitMgr;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ConsignProcessWaitAction extends BaseAction {
	
	private ConsignProcessOrderPo consignProcessOrderPo;
	
	private ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo;

	private ConsignProcessWaitMgr consignProcessWaitMgr;
	
	private List<ConsignProcessOrderPo> consignProcessOrderList;
	
	private InventoryPo inventoryPo;
	
	private InventoryEntryPo inventoryEntryPo;
	
	private SupplierMgr supplierMgr;
	
	private List<WarehousePo> warehouselist;

	private WarehouseMgr warehouseMgr;
	
	private GoodsInfoTempPo goodsInfoTempPo;
	
	private ConsignProcessReceiptPo consignProcessReceiptPo;
	
	private ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo;
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
	
	public ConsignProcessReceiptDetailsPo getConsignProcessReceiptDetailsPo() {
		return consignProcessReceiptDetailsPo;
	}

	public void setConsignProcessReceiptDetailsPo(
			ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo) {
		this.consignProcessReceiptDetailsPo = consignProcessReceiptDetailsPo;
	}

	private List<ConsignProcessReceiptDetailsPo> consignProcessReceiptDetailList;
	
	public List<ConsignProcessReceiptDetailsPo> getConsignProcessReceiptDetailList() {
		return consignProcessReceiptDetailList;
	}

	public void setConsignProcessReceiptDetailList(
			List<ConsignProcessReceiptDetailsPo> consignProcessReceiptDetailList) {
		this.consignProcessReceiptDetailList = consignProcessReceiptDetailList;
	}

	public ConsignProcessReceiptPo getConsignProcessReceiptPo() {
		return consignProcessReceiptPo;
	}

	public void setConsignProcessReceiptPo(
			ConsignProcessReceiptPo consignProcessReceiptPo) {
		this.consignProcessReceiptPo = consignProcessReceiptPo;
	}

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	private List<ConsignProcessOrderDetailsPo> consignProcessOrderDetailsList;
	
	
	public ConsignProcessOrderDetailsPo getConsignProcessOrderDetailsPo() {
		return consignProcessOrderDetailsPo;
	}

	public void setConsignProcessOrderDetailsPo(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		this.consignProcessOrderDetailsPo = consignProcessOrderDetailsPo;
	}
	
	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderDetailsList() {
		return consignProcessOrderDetailsList;
	}

	public void setConsignProcessOrderDetailsList(
			List<ConsignProcessOrderDetailsPo> consignProcessOrderDetailsList) {
		this.consignProcessOrderDetailsList = consignProcessOrderDetailsList;
	}

	public List<WarehousePo> getWarehouselist() {
		return warehouselist;
	}

	public void setWarehouselist(List<WarehousePo> warehouselist) {
		this.warehouselist = warehouselist;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}

	public InventoryEntryPo getInventoryEntryPo() {
		return inventoryEntryPo;
	}

	public void setInventoryEntryPo(InventoryEntryPo inventoryEntryPo) {
		this.inventoryEntryPo = inventoryEntryPo;
	}

	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}

	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}

	public List<ConsignProcessOrderPo> getConsignProcessOrderList() {
		return consignProcessOrderList;
	}

	public void setConsignProcessOrderList(
			List<ConsignProcessOrderPo> consignProcessOrderList) {
		this.consignProcessOrderList = consignProcessOrderList;
	}

	public ConsignProcessWaitMgr getConsignProcessWaitMgr() {
		return consignProcessWaitMgr;
	}

	public void setConsignProcessWaitMgr(ConsignProcessWaitMgr consignProcessWaitMgr) {
		this.consignProcessWaitMgr = consignProcessWaitMgr;
	}

	public ConsignProcessOrderPo getConsignProcessOrderPo() {
		return consignProcessOrderPo;
	}

	public void setConsignProcessOrderPo(ConsignProcessOrderPo consignProcessOrderPo) {
		this.consignProcessOrderPo = consignProcessOrderPo;
	}

	/**
	 * 初始化待委外收货的订单查询
	 * @return
	 */
	public String initConsignProcessWaitSel(){
		
		return SUCCESS;
	}
	
	/**
	 * 待委外收货的订单查询
	 * @return
	 */
	public String selConsignProcessWait(){
		//得到查询条件
		//得到委外订单id、开始时间、结束时间、订购商品类型
		String billid=Utility.getName(request.getParameter("billid"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String cstcpoordergoodscategory=Utility.getName(request.getParameter("cstcpoordergoodscategory"));
		
		//得到制造商id、制单人id、审核人id
		String cstcposupplierid=Utility.getName(request.getParameter("cstcposupplierid"));	
		String cstcpocreateperson=Utility.getName(request.getParameter("cstcpocreateperson"));
		String cstcpoauditperson=Utility.getName(request.getParameter("cstcpoauditperson"));
		
		//得到制造商名称、制单人名称、审核人名称
		String bspsuppliername=Utility.getName(request.getParameter("bspsuppliername"));
		String createPersonName=Utility.getName(request.getParameter("createPersonName"));
		String auditPersonName=Utility.getName(request.getParameter("auditPersonName"));
		
		consignProcessOrderPo=new ConsignProcessOrderPo();
		
		consignProcessOrderPo.setCstcpoorderbillid(billid);
		consignProcessOrderPo.setCstcpostarttime(startTime);
		consignProcessOrderPo.setCstcpoendtime(endTime);
		consignProcessOrderPo.setCstcpoordergoodscategory(cstcpoordergoodscategory);
		consignProcessOrderPo.setCstcposupplierid(cstcposupplierid);
		consignProcessOrderPo.setCstcpocreateperson(cstcpocreateperson);
		consignProcessOrderPo.setCstcpoauditperson(cstcpoauditperson);
		consignProcessOrderPo.setBspsuppliername(bspsuppliername);
		consignProcessOrderPo.setCreatePersonName(createPersonName);
		consignProcessOrderPo.setAuditPersonName(auditPersonName);
		
		request.setAttribute("billid", billid);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("cstcpoordergoodscategory", cstcpoordergoodscategory);
		request.setAttribute("cstcposupplierid", cstcposupplierid);
		request.setAttribute("cstcpocreateperson", cstcpocreateperson);
		request.setAttribute("cstcpoauditperson", cstcpoauditperson);
		request.setAttribute("bspsuppliername", bspsuppliername);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("auditPersonName", auditPersonName);
		
		// 取待收货订单的总数
		int count=consignProcessWaitMgr.getConsignProcessOrderCount(consignProcessOrderPo);
		
		// 分页
		if (count > 0) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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

			// 取出待收货订单的信息
			consignProcessOrderList = consignProcessWaitMgr.getConsignProcessOrderList(consignProcessOrderPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			consignProcessOrderList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化待委外收货的订单修改
	 * @return
	 */
	public String initConsignProcessWaitUpdate(){
		
		String billID = "CPIN"+ GenerateNumber.getInstance().getGenerageNumber();
		
		String cstcpoorderbillid=Utility.getName(request.getParameter("cstcpoorderbillid"));
		
		String cstcprgoodscategory=Utility.getName(request.getParameter("cstcpoordergoodscategory"));
		
		consignProcessReceiptPo=new ConsignProcessReceiptPo();
		consignProcessReceiptPo.setCstcprreceiptbillid(billID);
		consignProcessReceiptPo.setCstcprsourcebillid(cstcpoorderbillid);
		consignProcessReceiptPo.setCstcprgoodscategory(request.getParameter("cstcprgoodscategory"));
		consignProcessReceiptPo.setCstcprgoodscategory(cstcprgoodscategory);
		request.setAttribute("cstcpoordergoodscategory", cstcprgoodscategory);
		
		consignProcessReceiptDetailsPo=new ConsignProcessReceiptDetailsPo();
		consignProcessReceiptDetailsPo.setCstcprdreceiptbilld(cstcpoorderbillid);
		
		consignProcessOrderDetailsPo=new ConsignProcessOrderDetailsPo();
		consignProcessOrderDetailsPo.setCstcpodorderbilld(cstcpoorderbillid);
		
		String cstcposupplierid=Utility.getName(request.getParameter("cstcposupplierid"));
		request.setAttribute("cstcposupplierid", cstcposupplierid);
		
		//获取制造商ID 、名字
		SupplierPo supplierPo = new SupplierPo();
		supplierPo.setBspid(cstcposupplierid);
		//查询制造商信息（需要制造商名字）
		supplierPo = supplierMgr.getSupplier(supplierPo);
		
		request.setAttribute("supplierPo", supplierPo);
		
		//得到当前登录人信息
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		
		DepartmentsPo departmentsPo=new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		departmentsPo.setBdptype("3");
		
		//根据单据编号查询出该编号下面所有的商品及商品详细信息
		
		warehouselist=warehouseMgr.getWarehouseList(departmentsPo);
		
		//待收货订单中商品详细信息总数
		int count=consignProcessWaitMgr.getConsignProcessOrderDetailsCount(consignProcessOrderDetailsPo);
		// 分页
		if (count > 0) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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

			// 取出待收货订单的信息
			consignProcessOrderDetailsList = consignProcessWaitMgr.getConsignProcessOrderDetailsList(consignProcessOrderDetailsPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			consignProcessOrderDetailsList = null;
		}
		
		return SUCCESS;
	}

	/**
	 * 待委外收货的订单修改
	 * @return
	 */
	public String updateConsignProcessWait(){
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		
		String createPertson=personInfoPo.getId();
		
		consignProcessReceiptPo.setCstcprcreateperson(createPertson);
		
		consignProcessReceiptPo.setCstcprdepartmentid(personInfoPo.getDepartmentID());
		
		if("".equals(Utility.getName(consignProcessReceiptPo.getCstcprauditstate()))){
			consignProcessReceiptPo.setCstcprauditstate("0");
        }
        if("1".equals(Utility.getName(consignProcessReceiptPo.getCstcprauditstate()))){
        	consignProcessReceiptPo.setCstcprauditstate("1");
        	consignProcessReceiptPo.setCstcprauditperson(consignProcessReceiptPo.getCstcprcreateperson());
        }
        
        //取出接受仓位、制造商ID、备注
        String cstcprinstockid=Utility.getName(request.getParameter("consignProcessReceiptPo.cstcpoinstockid"));
        
        String cstcprsupplierid=Utility.getName(request.getParameter("consignProcessReceiptPo.cstcprsupplierid"));
        
        String cstcprremark=Utility.getName(request.getParameter("consignProcessReceiptPo.cstcprremark"));
        
        consignProcessReceiptPo.setCstcprsupplierid(cstcprsupplierid);
        consignProcessReceiptPo.setCstcprremark(cstcprremark);
        
        
        request.setAttribute("cstiinstockid", cstcprinstockid);
        request.setAttribute("cstcprsupplierid", cstcprsupplierid);
        request.setAttribute("cstcprremark", cstcprremark);
        
		int lenth=goodsInfoTempPo.getGoodsid().length;
		
		//循环去出放在转单页面List表体中的信息并放入List中
		consignProcessReceiptDetailList=new ArrayList<ConsignProcessReceiptDetailsPo>();
		
		for (int i = 0; i < lenth; i++) {
			ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo = new ConsignProcessReceiptDetailsPo();
			consignProcessReceiptDetailsPo.setCstcprdreceiptbilld(consignProcessReceiptPo.getCstcprreceiptbillid());
			consignProcessReceiptDetailsPo.setCstcprdinstockid(cstcprinstockid);
			consignProcessReceiptDetailsPo.setCstcprdgoodsid(goodsInfoTempPo.getGoodsid()[i]);
			consignProcessReceiptDetailsPo.setCstcprdbarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			consignProcessReceiptDetailsPo.setCstcprdnum(goodsInfoTempPo.getGoodsquantity()[i]);
			consignProcessReceiptDetailsPo.setCstcprdcostprice(goodsInfoTempPo.getCostprice()[i]);
			consignProcessReceiptDetailsPo.setCstcprdnottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
			consignProcessReceiptDetailsPo.setCstcprdtaxrate(goodsInfoTempPo.getTaxrate()[i]);
//			consignProcessReceiptDetailsPo.setCstcprdorderdetailsid(goodsInfoTempPo.getCstcpodid()[i]);// 核销id

			consignProcessReceiptDetailList.add(consignProcessReceiptDetailsPo);
		}
		consignProcessWaitMgr.insertConsignProcessWaitAll(consignProcessReceiptPo, consignProcessReceiptDetailList);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
}
