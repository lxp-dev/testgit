/**
 * 
 */
package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.StockAlertSettingPo;

/**
 * @author Liuqian
 * 
 */
public interface StockAlertSettingDao {

	/**
	 * 删除指定品种
	 * 
	 * @param stockAlertSettingPo
	 */
	public void deleteStockAlertSetting(StockAlertSettingPo stockAlertSettingPo);

	/**
	 * 删除商品库存(批量)
	 * 
	 * @param stockAlertSettingPo
	 */
	public void delStockAlertSettings(StockAlertSettingPo stockAlertSettingPo);

	/**
	 * 得到库存上下限po
	 * 
	 * @param id
	 */
	public StockAlertSettingPo getStockAlertSettingPo(String id);

	/**
	 * 得到库存预警品种信息
	 * 
	 * @param stockAlertSettingPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<StockAlertSettingPo> getStrockAlerInfo(
			StockAlertSettingPo stockAlertSettingPo, int start, int size);

	/**
	 * 得到库存预警品种信息数量
	 * 
	 * @param stockAlertSettingPo
	 * @return
	 */
	public int getStrockAlerInfoCount(StockAlertSettingPo stockAlertSettingPo);

	/**
	 * 新增品种库存上下限
	 * 
	 * @param stockAlertSettingPo
	 */
	public void insertStockAlertSetting(StockAlertSettingPo stockAlertSettingPo);

	/**
	 * 新增品种库存上下限(批量)
	 * 
	 * @param stockAlertSettingPo
	 */
	public void insertStockAlertSettings(StockAlertSettingPo stockAlertSettingPo);

	/**
	 * 更新商品基础信息库存上下限
	 * 
	 * @param supplierid
	 * @param brandid
	 */
	public void updateGoodsStockAlert(StockAlertSettingPo stockAlertSettingPo);	
	
	/**
	 * 批量删除
	 * 
	 * @param stockAlertSettingPo
	 */
	public void batchDeteleSettings(String id);

	public GoodsInfoPo selectDimensionPos(GoodsInfoPo gpo);
	
	/**
	 * 删除已设置的库存预警
	 */
	public void deleteStockAlertSetting2D(StockAlertSettingPo stockAlertSettingPo);
	
}
