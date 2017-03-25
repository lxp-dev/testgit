package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
/**
 * 成品镜片dao 接口
 */
public interface LensFinishedDao {
	public int getLensFinishedCountNV(GoodsInfoPo po);
	/**
	 * 成品镜片数量
	 * 
	 * @param goodsInfoPo
	 * @return
	 */
	public int getLensFinishedCount(GoodsInfoPo goodsInfoPo);

	/**
	 * 成品镜片
	 * 
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> getLensFinishedList(GoodsInfoPo goodsInfoPo,
			int start, int size);

	/**
	 * 新增成品镜片
	 * 
	 * @param po
	 */
	public void insertLensFinished(GoodsInfoPo po);

	/**
	 * 更新成品镜片
	 * 
	 * @param po
	 */
	public void updateLensFinished(GoodsInfoPo po);

	/**
	 * 取成品镜片PO
	 * 
	 * @param po
	 * @return
	 */
	public GoodsInfoPo getLensFinished(GoodsInfoPo po);

	/**
	 * 停用
	 * 
	 * @param po
	 */
	public void updateLendsFinishedDisable(GoodsInfoPo po);
	
	/**
	 * 删除成品镜片
	 * @param po
	 */
	public void deleteLensFinished(GoodsInfoPo po);
	
	/**
	 * 获取商品库存数量
	 * 
	 * @param po
	 */
	public int getGoodsCount(GoodsInfoPo po);
}
