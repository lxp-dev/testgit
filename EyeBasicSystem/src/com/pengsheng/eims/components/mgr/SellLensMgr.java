/**
 * 
 */
package com.pengsheng.eims.components.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;

/**
 * @author canying123
 * 
 */
public interface SellLensMgr {

	/**
	 * 取镜片商品数量
	 * 
	 * @param goodsInfoTempPo
	 * @return
	 */
	public int getSellLensCount(GoodsInfoTempPo goodsInfoTempPo);

	/**
	 * 取镜片商品POs
	 * 
	 * @param goodsInfoTempPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> getSellLensList(GoodsInfoTempPo goodsInfoTempPo,
			int start, int size);
}
