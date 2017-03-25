package com.pengsheng.eims.basic.mgr;

import java.io.File;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.PhotoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
/**
 * 镜架mgr 接口
 */
public interface GlassesFrameMgr {
	/**
	 * 获取镜架数量
	 * @param po 商品po
	 * @return int 数量
	 */
	public int getGlassesFrameCount(GoodsInfoPo po);
	/**
	 * 获取镜架list
	 * @param po 商品po
	 * @param start
	 * @param size
	 * @return list 镜架list
	 */	
	public List<GoodsInfoPo> getGlassesFrameList(GoodsInfoPo po,int start, int size);
	/**
	 * 新增镜架
	 * @param po 商品po
	 */	
	public void insertGlassesFrame(GoodsInfoPo po,LogisticsLogPo logPo);
	/**
	 * 修改镜架
	 * @param po 商品po
	 */	
	public void updateGlassesFrame(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public List<PhotoPo> getPhotoList(GoodsInfoPo po);
	
	public int getPhotoListAllCount(GoodsInfoPo po);
	
	public List<GoodsInfoPo> getPhotoListAll(GoodsInfoPo po,int start, int size);
	
	public void deleteGlassesFramePhoto(String filePath,String uuids);
	public void insertGlassesFramePhoto(GoodsInfoPo po,File[] upload, String filePath, String[] fFullName,String[] ContentType);
	/**
	 * 获取镜架po
	 * @param po 商品po
	 * @return po 商品po
	 */	
	public GoodsInfoPo getGlassesFrame(GoodsInfoPo po);
	public GoodsInfoPo getGlassesFrameCode(GoodsInfoPo po);
	/**
	 * 删除镜架
	 * @param po 商品po
	 */	
	public void deleteGlassesFrame(GoodsInfoPo po,LogisticsLogPo logPo);
	/**
	 * 修改镜架的停用/启用状态
	 * @param po 商品po
	 */		
	public void updateGlassesFrameDisable(GoodsInfoPo po,LogisticsLogPo logPo);
	
	/**
	 * 修改镜架批发的停用/启用状态
	 * 
	 * @param po
	 *            商品po
	 */
	public void updateAllWholeDisable(GoodsInfoPo po,LogisticsLogPo logPo);
	
	/**
	 * 批量修改批发的停用/启用状态
	 */
	public void updateAllWholeDisableBatch(List<GoodsInfoPo> poList,LogisticsLogPo logPo);
	
	/**
	 * 批量修改商品停用/启用状态
	 */
	public void updateGlassesFrameDisableBatch(List<GoodsInfoPo> poList,LogisticsLogPo logPo);
	
	/**
	 * 批量删除商品信息
	 */
	public void deleteGlassesFrameBatch(List<GoodsInfoPo> poList,LogisticsLogPo logPo);
	
}
