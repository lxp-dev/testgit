package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface ColorMgr {
	
	/**
	 * 取商品颜色List
	 * @return
	 */
	public List<ColorPo> getColorList();
	
	/**
	 * 取商品颜色数量
	 * @return
	 */
	public int getColorCount() ;

	/**
	 * 取商品颜色List
	 * @return
	 */
	public List<ColorPo> getColorsList(int start, int size) ;

	/**
	 * 取指定商品颜色
	 * 
	 * @param colorPo
	 *            商品颜色参数集
	 * @return
	 */
	public ColorPo getColor(ColorPo colorPo);

	/**
	 * 插入商品颜色
	 * 
	 * @param colorPo
	 *            商品颜色参数集
	 */
	public void insertColor(ColorPo colorPo,LogisticsLogPo logPo);

	/**
	 * 更新商品颜色
	 * 
	 * @param colorPo
	 *            商品颜色参数集
	 */
	public void updateColor(ColorPo colorPo,LogisticsLogPo logPo);

	/**
	 * 删除仓位
	 * 
	 * @param colorPo
	 *            商品颜色参数集
	 */
	public void deleteColor(ColorPo colorPo,LogisticsLogPo logPo);
	
	public int getGoodsCount(ColorPo colorPo);
	public int getColorName(ColorPo po);
	public int getColorNameUpdate(ColorPo po);
	
	public ColorPo getFrameStyle(ColorPo colorPo);
}
