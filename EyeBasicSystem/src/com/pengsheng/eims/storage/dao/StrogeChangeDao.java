package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;

public interface StrogeChangeDao {
	
	public void insertStrogeChange(StrogeChangePo po);
	
	public void insertStrogeChangeLog(StrogeChangePo po,String pcBarcode);
	
	public GoodsInfoPo getGoodsBatch(String goodsBarID);
	// 商品库存当月库存变更表(9张新表)
	public void insertStrogeChangeLogTemp(StrogeChangePo po,String pcBarcode);
	
	public StrogeChangePo getStrogeChangePoBarCode(StrogeChangePo po);
	
	public GoodsInfoPo getGoodsInfoPoBarCode(String goodsID);
	
	public void insertStrogeChangeLogTemp(List<SalesDetailPo> po,String warehouseID);
	
	/**
	 * 删除库存信息By变更单据号
	 * @param cid
	 */
	public void deleteStockByChangeID(String cid);
}
