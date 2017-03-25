package com.pengsheng.eims.basic.mgr;

import java.io.File;
import java.util.List;

import com.pengsheng.eims.basic.dao.impl.TechnologyTypePo;
import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoManyPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;

/**
 * 镜架批量新增
 */
public interface GlassesFrameManyMgr {
	public List<GoodsInfoManyPo> insertImportGlassesFrameManyExcel(GoodsInfoPo goodsInfoPo,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo);
	
	/**
	 * 批量新增镜架
	 * @param po 商品po
	 */	
	public void insertGlassesManyFrame(List<GoodsInfoPo> po,LogisticsLogPo logPo);
	
	/**
	 * 批量新增太阳镜
	 * @param po 商品po
	 */
	public void insertGlassesFinishFrame(List<GoodsInfoPo> po,LogisticsLogPo logPo);
	
	public List<GoodsInfoManyPo> insertImportGlassesFinishManyExcel(GoodsInfoPo goodsInfoPo,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo);
	
	/**
	 * 批量新增老花镜
	 * @param po 商品po
	 */
	public void insertGlassesPresbyopicFrame(List<GoodsInfoPo> po,LogisticsLogPo logPo);
	
	public List<GoodsInfoManyPo> insertImportGlassesPresbyopicManyExcel(GoodsInfoPo goodsInfoPo,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo);
	
	public List<ColorPo> getColorList();
	public List<FrameMaterialPo> getFrameMaterialList();
	public List<TechnologyTypePo> getTeachnologyTypeList();
	public List<OptionParamPo> getFrameStyleList(String str);
}
