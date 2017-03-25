package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.PhotoPo;
/**
 * 镜架dao 接口
 */
public interface GlassesFrameDao {
	/**
	 * 获取镜架数量
	 * @param po 商品po
	 * @return int 数量
	 */
	public int getGlassesFrameCount(GoodsInfoPo po);
	public void updateFAQFile(PhotoPo faqFilePo); 
	public void insertFAQFile(PhotoPo faqFilePo); 
	public void deleteFAQFile(String uuid); 
	public PhotoPo selectpath(PhotoPo faqFilePo);  
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
	public void insertGlassesFrame(GoodsInfoPo po);
	/**
	 * 修改镜架
	 * @param po 商品po
	 */
	public void updateGlassesFrame(GoodsInfoPo po);
	
	public List<PhotoPo> getPhotoList(GoodsInfoPo po);
	
	public int getPhotoListAllCount(GoodsInfoPo po);
	
	public List<GoodsInfoPo> getPhotoListAll(GoodsInfoPo po,int start, int size);
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
	public void deleteGlassesFrame(GoodsInfoPo po);
	/**
	 * 修改镜架的停用/启用状态
	 * @param po 商品po
	 */	
	public void updateGlassesFrameDisable(GoodsInfoPo po);	
	
	/**
	 * 修改镜架批发的停用/启用状态
	 * 
	 * @param po
	 *            商品po
	 */
	public void updateAllWholeDisable(GoodsInfoPo po);
}
