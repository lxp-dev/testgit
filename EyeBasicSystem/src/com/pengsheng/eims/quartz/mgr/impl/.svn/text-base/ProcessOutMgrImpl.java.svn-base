package com.pengsheng.eims.quartz.mgr.impl;

import java.util.ArrayList;
import java.util.List;


import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.dao.ProcessOutDao;
import com.pengsheng.eims.quartz.mgr.ProcessOutMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.tools.GenerateNumber;

public class ProcessOutMgrImpl implements ProcessOutMgr {

	private ProcessOutDao processOutDao;
	private AdSalesInInventoryDao adSalesInInventoryDao;
	
	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}

	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}

	public ProcessOutDao getProcessOutDao() {
		return processOutDao;
	}

	public void setProcessOutDao(ProcessOutDao processOutDao) {
		this.processOutDao = processOutDao;
	}
	
	public void insertProcessOut(QuartzLogPo logPo) {
		
		//未处理 的不合格品明细
		List<InventoryEntryPo> deliverEntryList=processOutDao.getProcessEntryList();
		if(deliverEntryList.size()>0){			

		//拼装出库单主表
		InventoryPo inventoryPo=new InventoryPo();
		String billid="SOUT"+GenerateNumber.getInstance().getGenerageNumber();
		System.out.println("Billid = " + billid);
		
		inventoryPo.setCstibillid(billid);
		inventoryPo.setCstibilltypeid("3");
		inventoryPo.setCstisupplierid("101");//运营部ID
		inventoryPo.setCstioutstockid("yybbhgpc");//不合格品仓ID
		inventoryPo.setCstidepartmentid("101");//运营部ID
		inventoryPo.setCsticreateperson("100");//盛
		inventoryPo.setCstiauditstate("0");
		inventoryPo.setCstifinanceauditstate("0");
		inventoryPo.setCstiremark("");
		//insert出库单主表
		processOutDao.insertProcessOut(inventoryPo);

		//拼装出库单明细表

		for(InventoryEntryPo inventoryEntryPo:deliverEntryList){
			//insert出库单明细表
			inventoryEntryPo.setCstiebillid(billid);
			inventoryEntryPo.setCstieoutstockid("yybbhgpc");
			processOutDao.insertProcessOutEntry(inventoryEntryPo);
		}
		//送货单主表标识传输
		System.out.println("不合格品报残转销售出库单成功。。。");
		}
		List<InventoryPo> supplierIdList = new ArrayList<InventoryPo>();
		supplierIdList = processOutDao.getSupplierid();
		for (InventoryPo inventoryPo : supplierIdList) {
			
			String supplierid = inventoryPo.getCstisupplierid();

			String producedid = "POUT"+ GenerateNumber.getInstance().getGenerageNumber();

			System.out.println("Billid = " + producedid);

			processOutDao.insertInventory(producedid,supplierid);

			processOutDao.insertInventoryEntry(producedid, supplierid);
			

		}
		System.out.println("不合格品退回转退货单成功。。。");
		
		adSalesInInventoryDao.updateQuartzExecLog(logPo);
	}
}
