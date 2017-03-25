package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
/**
 * 订做镜片类dao 接口
 */
public interface LensCustomDao {
	/**
	 * 订做镜片数量
	 * 
	 * @param goodsInfoPo
	 * @return
	 */
	public int getLensCustomCount(GoodsInfoPo goodsInfoPo);

	/**
	 * 订做镜片
	 * 
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> getLensCustomList(GoodsInfoPo goodsInfoPo,
			int start, int size);

	/**
	 * 新增订做镜片
	 * 
	 * @param po
	 */
	public void insertLensCustom(GoodsInfoPo po);

	/**
	 * 更新订做镜片
	 * 
	 * @param po
	 */
	public void updateLensCustom(GoodsInfoPo po);

	/**
	 * 取订做镜片PO
	 * 
	 * @param po
	 * @return
	 */
	public GoodsInfoPo getLensCustom(GoodsInfoPo po);

	/**
	 * 停用
	 * 
	 * @param po
	 */
	public void updateLendsCustomDisable(GoodsInfoPo po);

	/**
	 * 删除订做镜片
	 * 
	 * @param po
	 */
	public void deleteLensCustom(GoodsInfoPo po);
}
