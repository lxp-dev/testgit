/**
 * 
 */
package com.pengsheng.eims.quartz.mgr;

import com.pengsheng.eims.system.persistence.QuartzLogPo;

/**
 * @author Liuqian
 * 
 */
public interface StockSummaryMgr {

	/**
	 * 库存汇总
	 */
	public void insertStockSummary(QuartzLogPo logPo);
	
	/**
	 * 物流系统汇总销售出库单(专汇总只有附加费的销售单)
	 */
	public void insertSalesOutBill(String billDate,QuartzLogPo logPo);
	
	/**
	 * 删除定时任务日志
	 */
	public void deleteQuartzLog();
	
}
