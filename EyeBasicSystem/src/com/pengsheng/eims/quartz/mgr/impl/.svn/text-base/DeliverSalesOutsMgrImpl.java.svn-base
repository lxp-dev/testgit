package com.pengsheng.eims.quartz.mgr.impl;

import java.util.List;


import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.dao.DeliverSalesOutsDao;
import com.pengsheng.eims.quartz.mgr.DeliverSalesOutsMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.tools.GenerateNumber;

public class DeliverSalesOutsMgrImpl implements DeliverSalesOutsMgr {

	private DeliverSalesOutsDao deliverSalesOutsDao;
	private AdSalesInInventoryDao adSalesInInventoryDao;
	
	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}

	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}

	public DeliverSalesOutsDao getDeliverSalesOutsDao() {
		return deliverSalesOutsDao;
	}

	public void setDeliverSalesOutsDao(DeliverSalesOutsDao deliverSalesOutsDao) {
		this.deliverSalesOutsDao = deliverSalesOutsDao;
	}
	

	public void insertDeliverSalesOuts(QuartzLogPo po) {
		
		//未处理 的报残单明细
		List<InventoryEntryPo> deliverEntryList=deliverSalesOutsDao.getDeliverEntryList();
		if(deliverEntryList.size()>0){			

		//拼装出库单主表
		InventoryPo inventoryPo=new InventoryPo();
		String billid="SOUT"+GenerateNumber.getInstance().getGenerageNumber();
		inventoryPo.setCstibillid(billid);
		inventoryPo.setCstibilltypeid("3");
		inventoryPo.setCstisupplierid("101");//运营部ID
		inventoryPo.setCstioutstockid("yybdzpc");//订制片仓ID
		inventoryPo.setCstidepartmentid("101");//运营部ID
		inventoryPo.setCsticreateperson("100");//盛
		inventoryPo.setCstiauditstate("0");
		inventoryPo.setCstifinanceauditstate("0");
		inventoryPo.setCstiremark("");
		//insert出库单主表
		deliverSalesOutsDao.insertDeliverSalesOuts(inventoryPo);

		//拼装出库单明细表

		for(InventoryEntryPo inventoryEntryPo:deliverEntryList){
			//insert出库单明细表
			inventoryEntryPo.setCstiebillid(billid);
			inventoryEntryPo.setCstieoutstockid("yybdzpc");
			deliverSalesOutsDao.insertDeliverSalesOutEntry(inventoryEntryPo);
			
			
			String receiptbillid = inventoryEntryPo.getCstiereceiptbillid();
			
			
			deliverSalesOutsDao.updateConsignProcessReceipt(receiptbillid);
			
			
		}
		
		System.out.println("委外报残转销售出库单成功。。。");
		}
		
		adSalesInInventoryDao.updateQuartzExecLog(po);
	}
}
