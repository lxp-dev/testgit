/**
 * 
 */
package com.pengsheng.eims.quartz.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.dao.StockSummaryDao;
import com.pengsheng.eims.quartz.mgr.StockSummaryMgr;
import com.pengsheng.eims.system.dao.DepartmentsDao;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class StockSummaryMgrImpl implements StockSummaryMgr {

	private StockSummaryDao stockSummaryDao;
	private DepartmentsDao departmentsDao;
	private AdSalesInInventoryDao adSalesInInventoryDao;
	
	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}
	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}
	public StockSummaryDao getStockSummaryDao() {
		return stockSummaryDao;
	}
	public void setStockSummaryDao(StockSummaryDao stockSummaryDao) {
		this.stockSummaryDao = stockSummaryDao;
	}
	public DepartmentsDao getDepartmentsDao() {
		return departmentsDao;
	}
	public void setDepartmentsDao(DepartmentsDao departmentsDao) {
		this.departmentsDao = departmentsDao;
	}
	
	public void insertStockSummary(QuartzLogPo logPo) {

		stockSummaryDao.strogeBeginningClear();
		stockSummaryDao.strogeChangeClear();
		stockSummaryDao.strogeBeginningSummary();
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}

	/**
	 * 掰轨系统删除当月库存流水
	 */
	public void insertSalesOutBill(String billDate,QuartzLogPo logPo){
		
		// 删除外帐当月库存
		stockSummaryDao.strogeChangeFlySheetClear();
		
		adSalesInInventoryDao.updateQuartzExecLog(logPo);		
	}
	
	/**
	 * 删除定时任务日志
	 */
	public void deleteQuartzLog(){
		stockSummaryDao.deleteQuartzLog();
	}
	
}
