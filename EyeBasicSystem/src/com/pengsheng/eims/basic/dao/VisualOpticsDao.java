package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;

public interface VisualOpticsDao {

	public int getVisualOpticsCount(GoodsInfoPo po);
	
	public List<GoodsInfoPo> getVisualOpticsList(GoodsInfoPo po,int start, int size);
	
	public void insertVisualOptics(GoodsInfoPo po);
	
	public void updateVisualOptics(GoodsInfoPo po);
	
	public GoodsInfoPo getVisualOptics(GoodsInfoPo po);
	
	public void deleteVisualOptics(GoodsInfoPo po);
	
	public void updateVisualOpticsDisable(GoodsInfoPo po);	
	
	/**
	 * 	获取商品库存数量
	 */
	
	public int getGoodsNumber(GoodsInfoPo po);
}
