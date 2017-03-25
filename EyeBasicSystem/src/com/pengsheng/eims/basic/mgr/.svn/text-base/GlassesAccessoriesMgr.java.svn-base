package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
/**
 * 配件类mgr 接口
 */
public interface GlassesAccessoriesMgr {
	/**
	 * 获取配件类数量
	 * @param po 商品po
	 * @return int 数量
	 */
	public int getGlassesAccessoriesCount(GoodsInfoPo po);
	/**
	 * 获取配件类list
	 * @param po 商品po
	 * @param start
	 * @param size
	 * @return list 镜架list
	 */		
	public List<GoodsInfoPo> getGlassesAccessoriesList(GoodsInfoPo po,int start, int size);
	/**
	 * 新增配件类
	 * @param po 商品po
	 */		
	public void insertGlassesAccessories(GoodsInfoPo po,LogisticsLogPo logPo);
	/**
	 * 修改配件类
	 * @param po 商品po
	 */	
	public void updateGlassesAccessories(GoodsInfoPo po,LogisticsLogPo logPo);
	/**
	 * 获取配件类po
	 * @param po 商品po
	 * @return po 商品po
	 */
	public GoodsInfoPo getGlassesAccessories(GoodsInfoPo po);
	/**
	 * 删除配件类
	 * @param po 商品po
	 */	
	public void deleteGlassesAccessories(GoodsInfoPo po,LogisticsLogPo logPo);
	/**
	 * 修改配件类的停用/启用状态
	 * @param po 商品po
	 */	
	public void updateGlassesAccessoriesDisable(GoodsInfoPo po,LogisticsLogPo logPo);	
}
