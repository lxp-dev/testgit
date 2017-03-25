/**
 * 
 */
package com.pengsheng.eims.quartz.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuqian
 * 
 */
public interface StockSummaryDao {
	/**
	 * 清除商品库存当月期初表
	 */
	public void strogeBeginningClear();

	/**
	 * 清除商品库存当月库存变更表
	 */
	public void strogeChangeClear();
	public void strogeChangeFlySheetClear();

	/**
	 * 当月库存汇总
	 */
	public void strogeBeginningSummary();

	/**
	 * 商品库存各月期初记录表汇总
	 */
	public void strogeBeginningRecordSummary();
	
	/**
	 * 物流系统汇总销售出库单(专汇总只有附加费的销售单)
	 */
	public void insertSalesOutBill(String billID,String billDate,String shopCode);
	
	/**
	 * 物流系统汇总销售出库单(专汇总只有附加费的销售单)
	 */
	public void insertSalesOutBillEntry(String billID,String billDate,String shopCode);

	/**
	 * 删除定时任务日志
	 */
	public void deleteQuartzLog();
	
}
