package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface LensFinishedMgr {
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
	public void insertLensFinished(GoodsInfoPo po,LogisticsLogPo logPo);

	/**
	 * 更新成品镜片
	 * 
	 * @param po
	 */
	public void updateLensFinished(GoodsInfoPo po,LogisticsLogPo logPo);

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
	public void updateLendsFinishedDisable(GoodsInfoPo po,LogisticsLogPo logPo);

	/**
	 * 删除成品镜片
	 * 
	 * @param po
	 */
	public void deleteLensFinished(GoodsInfoPo po,LogisticsLogPo logPo);

	/**
	 * 成品镜片批量新增
	 * 
	 * @param po
	 */
	public void insertLensFinishedBulk(SystemParameterPo systemParameterPo,GoodsInfoPo po,LogisticsLogPo logPo);
	
	/**
	 * 获取商品库存数量
	 * 
	 * @param po
	 */
	public int getGoodsCount(GoodsInfoPo po);
	
	/**
	 * 按二维表添加成品镜片
	 */
	public void insertLensFinisheds(List<GoodsInfoPo> pos,List<LogisticsLogPo> logPos);
}
