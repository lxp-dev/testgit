/**
 * 
 */
package com.pengsheng.eims.components.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;

/**
 * @author canying123
 * 
 */
public interface SellLensDao {
	public int getSellLensCount(GoodsInfoTempPo goodsInfoTempPo);
	public List<GoodsInfoPo> getSellLensList(GoodsInfoTempPo goodsInfoTempPo,int start,int size);	
}
