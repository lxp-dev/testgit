/**
 * 
 */
package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.StockAlertSettingPo;

/**
 * @author Liuqian
 * 
 */
public interface StockAlertSettingMgr {

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
	List<StockAlertSettingPo> getStrockAlerInfo(
			StockAlertSettingPo stockAlertSettingPo, int start, int size);

	/**
	 * 得到库存预警品种信息数量
	 * 
	 * @param stockAlertSettingPo
	 * @return
	 */
	int getStrockAlerInfoCount(StockAlertSettingPo stockAlertSettingPo);

	/**
	 * 更新商品基础信息库存上下限
	 * 
	 * @param supplierid
	 * @param brandid
	 */
	public void updateGoodsStockAlert(StockAlertSettingPo stockAlertSettingPo,LogisticsLogPo logPo);

	/**
	 * 更新、新增品种库存上下限
	 * 
	 * @param stockAlertSettingPo
	 */
	public void updateStockAlertSettings(StockAlertSettingPo po,LogisticsLogPo logPo);
	
	/**
	 * 批量删除修改
	 * 
	 * @param stockAlertSettingPo
	 */
	public void batchUpdateSettings(StockAlertSettingPo po,LogisticsLogPo logPo);
	
	/**
	 * 批量删除
	 * 
	 * @param stockAlertSettingPo
	 */
	public void batchDeteleSettings(StockAlertSettingPo po,LogisticsLogPo logPo);
	
	public List<GoodsInfoPo> selectDimensionPos(List<GoodsInfoPo> gpoList,String goodsID);
	
	/**
	 * 更新、新增品种库存上下限(二维)
	 */
	public void updateStockAlertSettings2D(List<StockAlertSettingPo> poList,LogisticsLogPo logPo);

}
