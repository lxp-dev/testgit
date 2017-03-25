/**
 * 
 */
package com.pengsheng.eims.components.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;

/**
 * @author canying123
 * 
 */
public interface ConLensDao {
	/**
	 * 取隐形商品数量
	 * 
	 * @param goodsInfoTempPo
	 * @return
	 */
	public int getConLensCount(GoodsInfoTempPo goodsInfoTempPo,WarehouseConfigurationPo warehouseConfigurationPo);

	/**
	 * 取隐形商品POs
	 * 
	 * @param goodsInfoTempPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> getConLensList(GoodsInfoTempPo goodsInfoTempPo,WarehouseConfigurationPo warehouseConfigurationPo,
			int start, int size);
	
	public List<GoodsInfoPo> getOConLensList(GoodsInfoTempPo goodsInfoTempPo,
			int start, int size) ;
	
	public int getOConLensCount(GoodsInfoTempPo goodsInfoTempPo) ;
}
