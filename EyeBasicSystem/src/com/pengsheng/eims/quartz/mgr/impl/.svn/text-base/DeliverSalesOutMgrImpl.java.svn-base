package com.pengsheng.eims.quartz.mgr.impl;

import java.util.List;

import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.dao.DeliverSalesOutDao;
import com.pengsheng.eims.quartz.mgr.DeliverSalesOutMgr;
import com.pengsheng.eims.storage.persistence.DeliverEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.tools.GenerateNumber;

public class DeliverSalesOutMgrImpl implements DeliverSalesOutMgr {

	private DeliverSalesOutDao deliverSalesOutDao;
	private AdSalesInInventoryDao adSalesInInventoryDao;
	
	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}

	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}

	public DeliverSalesOutDao getDeliverSalesOutDao() {
		return deliverSalesOutDao;
	}

	public void setDeliverSalesOutDao(DeliverSalesOutDao deliverSalesOutDao) {
		this.deliverSalesOutDao = deliverSalesOutDao;
	}
	

	public void insertDeliverSalesOut(QuartzLogPo logPo) {
		
		//未处理 的送货单明细
		List<InventoryEntryPo> deliverEntryList=deliverSalesOutDao.getDeliverEntryList();
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
		deliverSalesOutDao.insertDeliverSalesOut(inventoryPo);

		//拼装出库单明细表

		for(InventoryEntryPo inventoryEntryPo:deliverEntryList){
			//insert出库单明细表
			inventoryEntryPo.setCstiebillid(billid);
			inventoryEntryPo.setCstieoutstockid("yybdzpc");
			deliverSalesOutDao.insertDeliverSalesOutEntry(inventoryEntryPo);
		}
		//送货单主表标识传输
		deliverSalesOutDao.updateDeliverFlag();
		System.out.println("送货单转销售出库单成功。。。");
		}
		
		adSalesInInventoryDao.updateQuartzExecLog(logPo);
	}
		
}
