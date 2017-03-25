package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.ComplaintsTypePo;
import com.pengsheng.eims.basic.persistence.ForeignRecipelPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface ColorDao {
	
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
	public void insertColor(ColorPo colorPo);

	/**
	 * 更新商品颜色
	 * 
	 * @param colorPo
	 *            商品颜色参数集
	 */
	public void updateColor(ColorPo colorPo);

	/**
	 * 删除仓位
	 * 
	 * @param colorPo
	 *            商品颜色参数集
	 */
	public void deleteColor(ColorPo colorPo);
	
	public int getGoodsCount(ColorPo colorPo);
	
	public int getColorName(ColorPo po);
	
	public int getColorNameUpdate(ColorPo po);
	
	public ColorPo getFrameStyle(ColorPo colorPo);
}
