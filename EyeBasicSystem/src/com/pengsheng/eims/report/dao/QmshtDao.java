/**
 * 
 */
package com.pengsheng.eims.report.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;

/**
 * @author Liuqian
 * 
 */
public interface QmshtDao {
	/**
	 * 得到所有结果集
	 * 
	 * @param ShopCode
	 * @param begDate
	 * @param endDate
	 * @return
	 */
	public List<InventoryEntryPo> getGlassData(String ShopCode, String begDate,
			String endDate);

	/**
	 * 得到隐形所有结果集
	 * 
	 * @param ShopCode
	 * @param begDate
	 * @param endDate
	 * @return
	 */
	public List<Map> getGlassDataYX(String ShopCode, String begDate,
			String endDate);
	
	/**
	 * 得到销售金额和销售数量
	 * 
	 * @param ShopCode
	 * @param begDate
	 * @param endDate
	 * @return
	 */
	public SalesDetailPo getSalesData(String ShopCode,String begDate,String endDate);
}
