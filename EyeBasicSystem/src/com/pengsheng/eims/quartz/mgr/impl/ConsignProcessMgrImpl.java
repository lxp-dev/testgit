package com.pengsheng.eims.quartz.mgr.impl;

import java.util.List;


import com.pengsheng.eims.quartz.dao.ConsignProcessDao;
import com.pengsheng.eims.quartz.dao.DeliverSalesOutsDao;
import com.pengsheng.eims.quartz.mgr.ConsignProcessMgr;
import com.pengsheng.eims.quartz.mgr.DeliverSalesOutsMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.tools.GenerateNumber;

public class ConsignProcessMgrImpl implements ConsignProcessMgr {

	private ConsignProcessDao consignProcessDao;
	

	public ConsignProcessDao getConsignProcessDao() {
		return consignProcessDao;
	}


	public void setConsignProcessDao(ConsignProcessDao consignProcessDao) {
		this.consignProcessDao = consignProcessDao;
	}


	public void insertConsignProcess() {
		
		//未处理 的报残单明细
		List<InventoryEntryPo> deliverEntryList=consignProcessDao.getConsignProcessEntryList();
		if(deliverEntryList.size()>0){			

		//拼装退货单主表
		InventoryPo inventoryPo=new InventoryPo();
		String billid="POUT"+GenerateNumber.getInstance().getGenerageNumber();
		inventoryPo.setCstibillid(billid);
		inventoryPo.setCstibilltypeid("2");
		inventoryPo.setCstisupplierid("101");//运营部ID
		inventoryPo.setCstioutstockid("yybdzpc");//订制片仓ID
		inventoryPo.setCstidepartmentid("101");//运营部ID
		inventoryPo.setCsticreateperson("100");//盛
		inventoryPo.setCstiauditstate("0");
		inventoryPo.setCstifinanceauditstate("0");
		inventoryPo.setCstiremark("");
		//insert出库单主表
		consignProcessDao.insertConsignProcess(inventoryPo);

		//拼装出库单明细表

		for(InventoryEntryPo inventoryEntryPo:deliverEntryList){
			//insert出库单明细表
			inventoryEntryPo.setCstiebillid(billid);
			inventoryEntryPo.setCstieoutstockid("yybdzpc");
			consignProcessDao.insertConsignProcessEntry(inventoryEntryPo);
			
			//王磊05-29
			String receiptbillid = inventoryEntryPo.getCstiereceiptbillid();
			
			//送货单主表标识传输
			consignProcessDao.updateConsignProcessReceipt(receiptbillid);
			//王磊05-29
		}
		
		System.out.println("委外退回单转销售退货单成功。。。");
		}
	}

}
