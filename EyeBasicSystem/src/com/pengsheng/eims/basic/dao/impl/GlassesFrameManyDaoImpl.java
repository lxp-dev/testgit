package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.GlassesFrameManyDao;
import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class GlassesFrameManyDaoImpl extends BaseJdbcDaoSupport implements GlassesFrameManyDao{
	
	public int getIsColorCount(GoodsInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(*) from B_Color ");
		buffer.append("where B_C_ColorName = ? ");
		
		params.add(Utility.getName(po.getBgichinesecolorname()));

		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int getIsFrameMaterialCount(GoodsInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(*) from B_FrameMaterial ");
		buffer.append("where B_FM_Name = ? ");
		
		params.add(Utility.getName(po.getBgiframematerialtypename()));

		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int getIsFrameStyleCount(GoodsInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(*) from F_OptionParam ");
		buffer.append("where F_OP_ParamName = ? and F_OP_ParentID = 'ks' ");
		
		params.add(Utility.getName(po.getBgiframestylename()));

		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int getisTeachnologyTypeCount(GoodsInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(*) from f_technologytype ");
		buffer.append("where f_tt_name = ? ");
		
		params.add(Utility.getName(po.getBgiframeprocesscrafttype()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<OptionParamPo> getFrameStyleList(String str) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select F_OP_ParamName as fopparamname from F_OptionParam ");
		buffer.append("where F_OP_ParentID = ? ");
		
		params.add(str);
		
		return queryForObjectList(buffer.toString(), params.toArray(),OptionParamPo.class);
		
	}

	public List<ColorPo> getColorList() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select B_C_ColorName as bccolorname from B_Color ");
		
		return queryForObjectList(buffer.toString(), null,ColorPo.class);
		
	}

	public List<FrameMaterialPo> getFrameMaterialList() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select B_FM_Name as bfmname from B_FrameMaterial ");
		
		return queryForObjectList(buffer.toString(), null,FrameMaterialPo.class);
	}

	public List<TechnologyTypePo> getTeachnologyTypeList() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select f_tt_name as fttname from f_technologytype ");
		
		return queryForObjectList(buffer.toString(), null,TechnologyTypePo.class);
	}
}
