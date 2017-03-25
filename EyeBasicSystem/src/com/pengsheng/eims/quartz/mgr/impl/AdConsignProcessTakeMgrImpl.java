package com.pengsheng.eims.quartz.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.quartz.dao.AdConsignProcessTakeDao;
import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.mgr.AdConsignProcessTakeMgr;
import com.pengsheng.eims.report.dao.ReportQuartzDao;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;

public class AdConsignProcessTakeMgrImpl implements AdConsignProcessTakeMgr {

	public AdConsignProcessTakeDao adConsignProcessTakeDao;
	private AdSalesInInventoryDao adSalesInInventoryDao;
	private SystemParameterDao systemParameterDao = null;
	private SystemParameterPo systemParameterPo = null;
	private ReportQuartzDao reportQuartzDao = null;
	
	public ReportQuartzDao getReportQuartzDao() {
		return reportQuartzDao;
	}

	public void setReportQuartzDao(ReportQuartzDao reportQuartzDao) {
		this.reportQuartzDao = reportQuartzDao;
	}

	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}

	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}

	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}

	public AdConsignProcessTakeDao getAdConsignProcessTakeDao() {
		return adConsignProcessTakeDao;
	}

	public void setAdConsignProcessTakeDao(
			AdConsignProcessTakeDao adConsignProcessTakeDao) {
		this.adConsignProcessTakeDao = adConsignProcessTakeDao;
	}

	/**
	 * 汇总委外收货单生产委外结算
	 */
	public void insertInventory(QuartzLogPo logPo) {
		
		// 取出所有的制造商代码
		List<InventoryPo> supplierIdList = new ArrayList<InventoryPo>();
		supplierIdList = adConsignProcessTakeDao.getSupplierid();
		
		for (InventoryPo inventoryPo : supplierIdList) {

			String supplierid = Utility.getName(inventoryPo.getCstisupplierid());   // 制造商
			String companyID = Utility.getName(inventoryPo.getCsticompanyid());   // 公司
			String subsupplierid = Utility.getName(inventoryPo.getCstisubsupplierid());   // 供应商
			
			inventoryPo = adConsignProcessTakeDao.getbillid(subsupplierid,supplierid,companyID);
  
			// 生成新的委外收货结算单号
			String billid = Utility.getName(inventoryPo.getCstibillid());
			String producedid = "CPIN"+ GenerateNumber.getInstance().getGenerageNumber();

			adConsignProcessTakeDao.insertInventory(producedid, billid);

			adConsignProcessTakeDao.insertInventoryEntry(subsupplierid,producedid, supplierid,companyID);

			// 汇总委外收货明细
			adConsignProcessTakeDao.updateInventoryTemp(subsupplierid,supplierid,companyID);

		}
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}

}
