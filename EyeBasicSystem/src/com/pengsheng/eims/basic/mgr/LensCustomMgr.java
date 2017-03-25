package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
/**
 * 订做镜片mgr 接口
 */
public interface LensCustomMgr {
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
	public void insertLensCustom(GoodsInfoPo po,LogisticsLogPo logPo);

	/**
	 * 更新订做镜片
	 * 
	 * @param po
	 */
	public void updateLensCustom(GoodsInfoPo po,LogisticsLogPo logPo);

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
	public void updateLendsCustomDisable(GoodsInfoPo po,LogisticsLogPo logPo);

	/**
	 * 删除订做镜片
	 * 
	 * @param po
	 */
	public void deleteLensCustom(GoodsInfoPo po,LogisticsLogPo logPo);

}
