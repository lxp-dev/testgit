package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;

public interface GlassesFinishDao {

	public int getGlassesFinishCount(GoodsInfoPo po);
	
	public List<GoodsInfoPo> getGlassesFinishList(GoodsInfoPo po,int start, int size);
	
	public void insertGlassesFinish(GoodsInfoPo po);
	
	public void updateGlassesFinish(GoodsInfoPo po);
	
	public GoodsInfoPo getGlassesFinish(GoodsInfoPo po);
	
	public void deleteGlassesFinish(GoodsInfoPo po);
	
	public void updateGlassesFinishDisable(GoodsInfoPo po);
}
