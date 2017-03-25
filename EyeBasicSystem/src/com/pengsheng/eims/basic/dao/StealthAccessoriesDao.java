package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;

public interface StealthAccessoriesDao {

	public int getStealthAccessoriesCount(GoodsInfoPo po);
	
	public List<GoodsInfoPo> getStealthAccessoriesList(GoodsInfoPo po,int start, int size);
	
	public void insertStealthAccessories(GoodsInfoPo po);
	
	public void updateStealthAccessories(GoodsInfoPo po);
	
	public GoodsInfoPo getStealthAccessories(GoodsInfoPo po);
	
	public void deleteStealthAccessories(GoodsInfoPo po);
	
	public void updateStealthAccessoriesDisable(GoodsInfoPo po);	
}
