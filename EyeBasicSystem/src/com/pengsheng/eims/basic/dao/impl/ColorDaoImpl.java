package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.ColorDao;
import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ColorDaoImpl extends BaseJdbcDaoSupport implements ColorDao {

	public void deleteColor(ColorPo colorPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM B_Color ");
		buffer.append("WHERE B_C_id = ?");

		List<String> params = new ArrayList<String>();
		params.add(colorPo.getBcid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public ColorPo getColor(ColorPo colorPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  B_C_id as bcid ");
		buffer.append(",isnull(B_C_colorName,'')  as bccolorname ");
		buffer.append("FROM B_Color ");
		buffer.append("WHERE 1 = 1");
		
		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(colorPo.getBcid()))) {
			buffer.append(" AND B_C_id = ?");
			params.add(colorPo.getBcid());
		}else if (!"".equals(Utility.getName(colorPo.getBccolorname()))) {
			buffer.append(" AND B_C_colorName = ?");
			params.add(colorPo.getBccolorname());
		}else{
			buffer.append(" AND 1 = 2");
		}
		

		return (ColorPo) queryForObject(buffer.toString(), params
				.toArray(), ColorPo.class);
	}

	public int getColorName(ColorPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(B_C_id)");
		buffer.append("   from B_Color where B_C_colorName = ? ");
		params.add(Utility.getName(po.getBccolorname()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int getColorNameUpdate(ColorPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(B_C_id)");
		buffer.append("   from B_Color where B_C_colorName = ? and B_C_id <> ? ");
		params.add(Utility.getName(po.getBccolorname()));
		params.add(Utility.getName(po.getBcid()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public List<ColorPo> getColorList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_C_id as bcid ");
		buffer.append(",B_C_colorName  as bccolorname ");
		buffer.append("FROM B_Color ");

		return queryForObjectList(buffer.toString(), null, ColorPo.class);
	}
	
	public int getColorCount() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_C_id)");
		buffer.append("   from B_Color");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	public List<ColorPo> getColorsList(int start, int size) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_C_id) as rowNum, B_C_id as bcid,B_C_colorName  as bccolorname from B_Color ");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,ColorPo.class);
	}

	public void insertColor(ColorPo colorPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO B_Color ");
		buffer.append("(B_C_ID ");
		buffer.append(",B_C_ColorName) ");
		buffer.append("VALUES (?,?)");

		List<String> params = new ArrayList<String>();
		params.add(colorPo.getBcid());
		params.add(colorPo.getBccolorname());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateColor(ColorPo colorPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE B_Color ");
		buffer.append("SET B_C_ColorName = ? ");
		buffer.append("WHERE B_C_ID = ?");

		List<String> params = new ArrayList<String>();

		params.add(colorPo.getBccolorname());
		params.add(colorPo.getBcid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int getGoodsCount(ColorPo colorPo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select count(b_gi_goodsid) from b_goodsinfo where 1=1 ");
		if(colorPo.getBcid()!=null){
			sb.append(" and b_gi_colorid=?");
			params.add(colorPo.getBcid());
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}	
	
	public ColorPo getFrameStyle(ColorPo colorPo) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select F_OP_ParamID 		as bfsid, ");
		buffer.append("		  F_OP_ParamName 	as bfsname ");
		buffer.append("from F_OptionParam ");
		buffer.append("where F_OP_ParentID = 'ks' ");
		
		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(colorPo.getBfsid()))) {
			buffer.append(" AND F_OP_ParamID = ?");
			params.add(colorPo.getBcid());
		}else if (!"".equals(Utility.getName(colorPo.getBfsname()))) {
			buffer.append(" AND F_OP_ParamName = ?");
			params.add(colorPo.getBfsname());
		}else{
			buffer.append(" AND 1 = 2");
		}
		

		return (ColorPo) queryForObject(buffer.toString(), params
				.toArray(), ColorPo.class);
	}
}
