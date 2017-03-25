package com.pengsheng.eims.quartz.mgr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.dao.FlysheetDao;
import com.pengsheng.eims.quartz.mgr.FlysheetMgr;
import com.pengsheng.eims.report.dao.ReportQuartzDao;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.ExternalAccountParameterMgr;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;

public class FlysheetMgrImpl implements FlysheetMgr {
	
	private ExternalAccountParameterMgr externalAccountParameterMgr = null;
	private SystemParameterDao systemParameterDao;
	private GuitarManagementMgr guitarManagementMgr;
	private AdSalesInInventoryDao adSalesInInventoryDao;
	private FlysheetDao flysheetDao;
	private ReportQuartzDao reportQuartzDao = null;
	
	/**
	 * 外帐汇总采购收货单和退货单
	 */
	public void insertFlysheet(String billdate){

		ExternalAccountParameterPo epo = new ExternalAccountParameterPo();
		epo = externalAccountParameterMgr.getExternalAccountParameterPo(epo);
		
		if (Utility.getName(epo.getFeaaccessname()).equals("") || Utility.getName(epo.getFeaaccessname()).equals("")){
			System.out.println("请先配置传递配镜单所需参数!");
			return;
		}
		
		FquartzSwitchPo fspo = reportQuartzDao.getFquartzSwitchPo();
		
		if (Utility.getName(fspo.getFqscdpjd()).equals("1")){  // 开启外帐
			if (Utility.getName(fspo.getFqswzhzstd()).equals("1")){  // 正式系统
				
				System.out.println("开始传递配镜单,日期为:"+billdate);
				
				SalesBasicPo spo = new SalesBasicPo();
				spo.setSsesbsalesdatestarttime(billdate);
				spo.setSsesbsalesdateendtime(billdate);
				
				flysheetDao.insertGoodsInfo();
				
				try {					
					guitarManagementMgr.insertSalesData_Flysheet(spo,epo,null);
				} catch (Exception e) {
					System.out.println("传递配镜单异常：" + e.getMessage());
				}
				
				System.out.println("传递配镜单结束,日期为:"+billdate);
			}else{
				
				System.out.println("开始同步数据,日期为:"+billdate);
				
				// 配镜单
				flysheetDao.updateSalesBill();
				// 销售商品
				flysheetDao.updateSalesGoods();
				// 附加费
				flysheetDao.updateAdditionalCDetail();
				// 加工要求
				flysheetDao.updateSpecialPDetail();
				// 在途	
				flysheetDao.updateInTransit();
				// 付款记录
				flysheetDao.updateSalesLog();
				// 当日配镜单
				flysheetDao.updateSalesBillToday();
				// 当日销售商品	
				flysheetDao.updateSalesGoodsToday();
				// 当月库存	
				flysheetDao.updateStorageChange();
				// 库存流水
				flysheetDao.updateStorageLog();
				// 商品信息
				flysheetDao.updateGoodsInfo();
				// 更新商品零售价
				//flysheetDao.updateGoodsInfoAdjustmentPrice(epo);
								
				System.out.println("同步数据结束,日期为:"+billdate);				
				System.out.println("外帐开始汇总采购收货单和退货单,日期为:"+billdate);
				
				List<SalesDetailPo> salesDetailList = adSalesInInventoryDao.getSalesDetailList("1");
				autoPurchaseBillFromSalesBill(salesDetailList,epo);  // 配镜单转采购收货单
				
				salesDetailList = adSalesInInventoryDao.getSalesDetailList("2");	
				autoPurchaseReturnBillFromSalesBill(salesDetailList,epo);  // 配镜单转采购退货单
				
				//更新汇总采购单据的标识位
				adSalesInInventoryDao.insertCollectPurchaseBillBySalesBill(epo);
				
				adSalesInInventoryDao.updateSalesDetail("1");
				adSalesInInventoryDao.updateSalesDetail("2");				
				
				System.out.println("外帐汇总采购收货单和退货单结束,日期为:"+billdate);
			}
		}

	}
	
	/**
	 * 根据配镜单汇总生成采购收货单
	 */
	private void autoPurchaseBillFromSalesBill(List<SalesDetailPo> salesDetailList,ExternalAccountParameterPo epo){
			
		List<InventoryPo> inventoryList = new ArrayList<InventoryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		
		BigDecimal nottaxrateamount = null;  //成本合计
		BigDecimal costpriceamount = null;   //价税合计
		BigDecimal goodsNum = null;          //商品数量
		BigDecimal taxamount = null;         //税额合计
		
		List<String> stockList = new ArrayList<String>();              //入仓仓位的集合
		List<String> supplierList = new ArrayList<String>();              //制造商码集合
		String supplierID = "";             //当前商品的商品类型及制造商
		String goodsCategoryID = "";             //当前商品的商品类型
		String tbillid = "";                //临时业务单号
		String secondStock = "";            //临时仓位
		
		for (SalesDetailPo po : salesDetailList){

			secondStock = Utility.getName(po.getSsesdstockid());
			supplierID = Utility.getName(po.getSsesdsalesitemid()).substring(0, 4);

			goodsCategoryID = Utility.getName(po.getSsesdsalesitemid()).substring(0, 1);
			
			if (!stockList.contains(secondStock) || !supplierList.contains(supplierID)){
				
				tbillid = "PIN" + GenerateNumber.getInstance().getGenerageNumber();
				
				InventoryPo inventoryPo=new InventoryPo();
				inventoryPo.setCstiinstockid(Utility.getName(po.getSsesdstockid()));
				inventoryPo.setCstibillid(tbillid);
				inventoryPo.setCstibilltypeid("1");
				inventoryPo.setCstisupplierid(Utility.getName(po.getSsesdsupplierid()));
				
				inventoryPo.setCstidepartmentid(Utility.getName(epo.getFeadepartmentsid()));  //制单部门
				inventoryPo.setCsticreateperson(Utility.getName(epo.getFeaprocreateid()));
				inventoryPo.setCstiauditperson(Utility.getName(epo.getFeaproaduiteid()));
				inventoryPo.setCstigoodscategory(goodsCategoryID);
				
				inventoryList.add(inventoryPo);
				
				stockList.add(secondStock);
				supplierList.add(supplierID);
			}
			
			if (!tbillid.equals("")){
				
				nottaxrateamount = new BigDecimal(po.getSsesdunitprice());
				costpriceamount = new BigDecimal(po.getSsesdcostsprive());
				goodsNum = new BigDecimal(po.getSsesdnumber());
				
				nottaxrateamount = nottaxrateamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
				costpriceamount = costpriceamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
				taxamount = costpriceamount.subtract(nottaxrateamount).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
				inventoryEntryPo.setCstiebillid(tbillid);
				inventoryEntryPo.setCstiegoodsid(po.getSsesdsalesitemid());
				inventoryEntryPo.setCstiegoodsquantity(po.getSsesdnumber());
				inventoryEntryPo.setCstienottaxrate(po.getSsesdunitprice());
				inventoryEntryPo.setCstienottaxrateamount(nottaxrateamount.toString());
				inventoryEntryPo.setCstietaxrate(po.getSsesdtaxRate());
				inventoryEntryPo.setCstiecostprice(po.getSsesdcostsprive());
				inventoryEntryPo.setCstiecostpriceamount(costpriceamount.toString());
				inventoryEntryPo.setCstietaxamount(taxamount.toString());
				inventoryEntryPo.setCstieinstockid(Utility.getName(po.getSsesdstockid()));
				inventoryEntryPo.setCstiebarcode(Utility.getName(po.getSsesditemid()));
				
				inventoryEntryList.add(inventoryEntryPo);
			}
		}
		
		for (InventoryPo po : inventoryList){
			adSalesInInventoryDao.inertAutoPurchaseBillFromSalesBill(po);
			adSalesInInventoryDao.inertAutoInventoryBillFromSalesBill(po);
		}

		for (InventoryEntryPo po : inventoryEntryList){
			
			adSalesInInventoryDao.inertAutoPurchaseBillEntryFromSalesBill(po);
			adSalesInInventoryDao.inertAutoInventoryBillEntryFromSalesBill(po);
			
			//门店仓位增加库存
			adSalesInInventoryDao.inertAutoPurchaseBillToStrogeChange(po);
			adSalesInInventoryDao.inertAutoPurchaseBillToStrogeLog(po);
		}
		
	}
	
	/**
	 * 根据配镜单汇总生成采购收货单
	 */
	private void autoPurchaseReturnBillFromSalesBill(List<SalesDetailPo> salesDetailList,ExternalAccountParameterPo epo){
		
		List<InventoryPo> inventoryList = new ArrayList<InventoryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		
		BigDecimal nottaxrateamount = null;  //成本合计
		BigDecimal costpriceamount = null;   //价税合计
		BigDecimal goodsNum = null;          //商品数量
		BigDecimal taxamount = null;         //税额合计
		
		List<String> stockList = new ArrayList<String>();              //入仓仓位的集合
		List<String> supplierList = new ArrayList<String>();              //制造商码集合
		String supplierID = "";             //当前商品的商品类型及制造商
		String tbillid = "";                //临时业务单号
		String secondStock = "";            //临时仓位
		
		for (SalesDetailPo po : salesDetailList){

			secondStock = Utility.getName(po.getSsesdinstockid());
			supplierID = Utility.getName(po.getSsesdsupplierid());
			
			if (!stockList.contains(secondStock) || !supplierList.contains(supplierID)){
				
				tbillid = "POUT" + GenerateNumber.getInstance().getGenerageNumber();
				
				InventoryPo inventoryPo=new InventoryPo();
				inventoryPo.setCstioutstockid(Utility.getName(po.getSsesdinstockid()));
				inventoryPo.setCstibillid(tbillid);
				inventoryPo.setCstibilltypeid("2");
				inventoryPo.setCstisupplierid(Utility.getName(po.getSsesdsupplierid()));
			
				inventoryPo.setCstidepartmentid(Utility.getName(epo.getFeadepartmentsid()));  //制单部门
				inventoryPo.setCsticreateperson(Utility.getName(epo.getFeaprocreateid()));
				inventoryPo.setCstiauditperson(Utility.getName(epo.getFeaproaduiteid()));
				
				inventoryList.add(inventoryPo);
				
				stockList.add(secondStock);
				supplierList.add(supplierID);
			}
			
			if (!tbillid.equals("")){
				
				nottaxrateamount = new BigDecimal(po.getSsesdunitprice());
				costpriceamount = new BigDecimal(po.getSsesdcostsprive());
				goodsNum = new BigDecimal(po.getSsesdnumber());
				
				nottaxrateamount = nottaxrateamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
				costpriceamount = costpriceamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
				taxamount = costpriceamount.subtract(nottaxrateamount).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
				inventoryEntryPo.setCstiebillid(tbillid);
				inventoryEntryPo.setCstiegoodsid(po.getSsesdsalesitemid());
				inventoryEntryPo.setCstiegoodsquantity(po.getSsesdnumber());
				inventoryEntryPo.setCstienottaxrate(po.getSsesdunitprice());
				inventoryEntryPo.setCstienottaxrateamount(nottaxrateamount.toString());
				inventoryEntryPo.setCstietaxrate(po.getSsesdtaxRate());
				inventoryEntryPo.setCstiecostprice(po.getSsesdcostsprive());
				inventoryEntryPo.setCstiecostpriceamount(costpriceamount.toString());
				inventoryEntryPo.setCstietaxamount(taxamount.toString());
				inventoryEntryPo.setCstieoutstockid(Utility.getName(po.getSsesdinstockid()));
				inventoryEntryPo.setCstiebarcode(Utility.getName(po.getSsesditemid()));
				
				inventoryEntryList.add(inventoryEntryPo);
			}
		}
		
		for (InventoryPo po : inventoryList){
			adSalesInInventoryDao.inertAutoPurchaseBillFromSalesBill(po);
			adSalesInInventoryDao.inertAutoInventoryBillFromSalesBill(po);
		}

		for (InventoryEntryPo po : inventoryEntryList){
			
			adSalesInInventoryDao.inertAutoPurchaseBillEntryFromSalesBill(po);
			adSalesInInventoryDao.inertAutoInventoryBillEntryFromSalesBill(po);
			
			//门店仓位增加库存
			po.setCstiegoodsquantity("-"+po.getCstiegoodsquantity());
			po.setCstieinstockid(po.getCstieoutstockid());
			
			adSalesInInventoryDao.inertAutoPurchaseBillToStrogeChange(po);
			adSalesInInventoryDao.inertAutoPurchaseBillToStrogeLog(po);
		}
		
	}

	public ExternalAccountParameterMgr getExternalAccountParameterMgr() {
		return externalAccountParameterMgr;
	}

	public void setExternalAccountParameterMgr(
			ExternalAccountParameterMgr externalAccountParameterMgr) {
		this.externalAccountParameterMgr = externalAccountParameterMgr;
	}

	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}

	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}

	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}

	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}

	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}

	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}

	public FlysheetDao getFlysheetDao() {
		return flysheetDao;
	}

	public void setFlysheetDao(FlysheetDao flysheetDao) {
		this.flysheetDao = flysheetDao;
	}

	public ReportQuartzDao getReportQuartzDao() {
		return reportQuartzDao;
	}

	public void setReportQuartzDao(ReportQuartzDao reportQuartzDao) {
		this.reportQuartzDao = reportQuartzDao;
	}
		
}
