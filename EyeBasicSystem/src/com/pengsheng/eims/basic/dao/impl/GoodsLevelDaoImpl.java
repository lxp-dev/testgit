package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.GoodsLevelDao;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.system.dao.WorkTypeDao;
import com.pengsheng.eims.system.persistence.PersonTypePo;
import com.pengsheng.eims.system.persistence.WorkTypePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * TeachnologyTypeDaoImpl 职业Dao实现类
 * 
 * @author GuanZiGang
 * @version 1.0
 * @see BaseJdbcDaoSupport
 * @see WorkTypeDao
 */
public class GoodsLevelDaoImpl extends BaseJdbcDaoSupport implements GoodsLevelDao {

	/**
	 * 删除商品级别
	 * 
	 * @param po 商品级别po
	 * @return void
	 */
	public void deleteGoodsLevel(GoodsLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBglid()));
		buffer.append(" delete from B_GoodsLevel where B_GL_ID = ? ");
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 商品级别数量
	 */
	public int getGoodsLevelCount(GoodsLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_GL_ID)");
		buffer.append("   from B_GoodsLevel");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询级别ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getGoodsLevelId(GoodsLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBglid()));
		buffer.append(" select count(B_GL_ID)");
		buffer.append("   from B_GoodsLevel where B_GL_ID = ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	/**
	 * 添加时查询职业名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getGoodsLevelName(GoodsLevelPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBglname()));
		buffer.append(" select count(B_GL_ID)");
		buffer.append("   from B_GoodsLevel where B_GL_Name = ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	
	
	/**
	 * 修改时查询商品级别名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getGoodsLevelNameUpdate(GoodsLevelPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBglname()));
		params.add(Utility.getName(po.getBglid()));
		//params.add(Utility.getName(po.getBgldiscount()));
		buffer.append(" select count(B_GL_ID)");
		buffer.append("   from B_GoodsLevel where B_GL_Name = ?   and  B_GL_ID <> ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 职业结果集
	 */
	public List getGoodsLevelList(GoodsLevelPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_GL_ID) as rowNum, B_GL_ID as bglid,B_GL_Name as bglname,B_GL_Discount as bgldiscount from B_GoodsLevel");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				GoodsLevelPo.class);
	}

	/**
	 * 新增商品级别
	 * 
	 * @param po 商品级别po
	 * @return void
	 */
	public void insertGoodsLevel(GoodsLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" INSERT INTO B_GoodsLevel");
		buffer.append("            (B_GL_UUID");
		buffer.append("            ,B_GL_ID");
		buffer.append("            ,B_GL_Name");
		buffer.append("            ,B_GL_Discount");
		buffer.append("            ,B_GL_CategoryID)");
		buffer.append("      VALUES");
		buffer.append("            (?,");
		buffer.append("            ?,");
		buffer.append("            ?,");
		buffer.append("            ?,");
		buffer.append("            ?)");
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getBglid()));
		params.add(Utility.getName(po.getBglname()));
		params.add(Utility.getName(po.getBgldiscount()));
		params.add(Utility.getName(""));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 修改级别
	 * 
	 * @param po 级别po
	 * @return void
	 */
	public void updateGoodsLevel(GoodsLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" UPDATE B_GoodsLevel");
		buffer.append("    SET  B_GL_Name = ?");
		buffer.append("   ,B_GL_Discount = ?");
		buffer.append("    where B_GL_ID = ? ");
		params.add(Utility.getName(po.getBglname()));
		params.add(Utility.getName(po.getBgldiscount())); 
		params.add(Utility.getName(po.getBglid()));
		
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 查询职业在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getGoodsLevelWithGoods(GoodsLevelPo po){
		StringBuffer buffer = new StringBuffer();
		//buffer.append(" select count(B_GI_frameProcessCraftType) from S_ME_CustomerInfo");
		//buffer.append(" where B_GI_frameProcessCraftType = '"+Utility.getName(po.getBwtid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询职业的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 职业详细信息
	 */
	public GoodsLevelPo getGoodsLevelPo(GoodsLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select top 1  B_GL_ID as bglid,B_GL_Name as bglname,B_GL_Discount as bgldiscount from B_GoodsLevel");
		buffer.append(" where B_GL_ID = ? ");
		params.add(Utility.getName(po.getBglid()));
		return (GoodsLevelPo) queryForObject(buffer.toString(), params.toArray(), GoodsLevelPo.class);
	}
	
	public List getGoodsLevelList() {

        String sql="select B_GL_ID as bglid,B_GL_Name as bglname,B_GL_Discount as bgldiscount from B_GoodsLevel";
		return queryForObjectList(sql, null,GoodsLevelPo.class);
	}


	public int getGoodsLevelDiscountUpdate(GoodsLevelPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		params.add(Utility.getName(po.getBglid()));
		params.add(Utility.getName(po.getBgldiscount()));
		buffer.append(" select count(B_GL_ID)");
		buffer.append("   from B_GoodsLevel where B_GL_Discount = ?  and  B_GL_ID = ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}






}
