package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.dao.impl.TechnologyTypePo;
import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;

public interface GlassesFrameManyDao {
	public int getIsColorCount(GoodsInfoPo po);
	
	public int getIsFrameMaterialCount(GoodsInfoPo po);
	
	public int getIsFrameStyleCount(GoodsInfoPo po);
	
	public int getisTeachnologyTypeCount(GoodsInfoPo po);
	
	public List<ColorPo> getColorList();
	public List<FrameMaterialPo> getFrameMaterialList();
	public List<TechnologyTypePo> getTeachnologyTypeList();
	public List<OptionParamPo> getFrameStyleList(String str);
}
