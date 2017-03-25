package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.dao.TeachnologyTypeDao;
import com.pengsheng.eims.system.persistence.TeachnologyTypePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * TeachnologyTypeDaoImpl 工艺类型Dao实现类
 * 
 * @author GuanZiGang
 * @version 1.0
 * @see BaseJdbcDaoSupport
 * @see TeachnologyTypeDao
 */
public class TeachnologyTypeDaoImpl extends BaseJdbcDaoSupport implements TeachnologyTypeDao {

	/**
	 * 删除工艺类型
	 * 
	 * @param po 工艺类型po
	 * @return void
	 */
	public void deleteTeachnologyType(TeachnologyTypePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from f_technologytype where F_TT_ID = '"+Utility.getName(po.getFttid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 工艺类型数量
	 */
	public int getTeachnologyTypeCount(TeachnologyTypePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(f_tt_id)");
		buffer.append("   from f_technologytype");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询工艺类型ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTeachnologyTypeId(TeachnologyTypePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(f_tt_id)");
		buffer.append("   from f_technologytype where f_tt_id = '"+Utility.getName(po.getFttid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 添加时查询工艺类型名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTeachnologyTypeName(TeachnologyTypePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(f_tt_id)");
		buffer.append("   from f_technologytype where F_TT_Name = '"+Utility.getName(po.getFttname())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	/**
	 * 修改时查询工艺类型名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTeachnologyTypeNameUpdate(TeachnologyTypePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(f_tt_id)");
		buffer.append("   from f_technologytype where F_TT_Name = '"+Utility.getName(po.getFttname())+"' and f_tt_id <> '"+Utility.getName(po.getFttid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 工艺类型结果集
	 */
	public List getTeachnologyTypeList(TeachnologyTypePo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by f_tt_id) as rowNum, f_tt_id as fttid,f_tt_name as fttname from f_technologytype");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				TeachnologyTypePo.class);
	}

	/**
	 * 新增工艺类型
	 * 
	 * @param po 工艺类型po
	 * @return void
	 */
	public void insertTeachnologyType(TeachnologyTypePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" INSERT INTO F_TechnologyType");
		buffer.append("            (F_TT_ID");
		buffer.append("            ,F_TT_Name)");
		buffer.append("      VALUES");
		buffer.append("            ('"+Utility.getName(po.getFttid())+"'");
		buffer.append("            ,'"+Utility.getName(po.getFttname())+"')");
		getJdbcTemplate().update(buffer.toString());
	}

	/**
	 * 修改工艺类型
	 * 
	 * @param po 工艺类型po
	 * @return void
	 */
	public void updateTeachnologyType(TeachnologyTypePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" UPDATE F_TechnologyType");
		buffer.append("    SET  F_TT_Name = '"+Utility.getName(po.getFttname())+"'");
		buffer.append("  WHERE F_TT_ID = '"+Utility.getName(po.getFttid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}

	/**
	 * 查询工艺类型在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTeachnologyTypeWithGoods(TeachnologyTypePo po){
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_GI_frameProcessCraftType) from B_GoodsInfo");
		buffer.append(" where B_GI_frameProcessCraftType = '"+Utility.getName(po.getFttid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询工艺类型的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 工艺类型详细信息
	 */
	public TeachnologyTypePo getTeachnologyTypePo(TeachnologyTypePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select top 1  f_tt_id as fttid,f_tt_name as fttname from f_technologytype");
		buffer.append(" where 1=1 ");
		
		if(!"".equals(Utility.getName(Utility.getName(po.getFttid())))){
			buffer.append(" and f_tt_id = ? ");
			params.add(Utility.getName(po.getFttid()));
		}else if(!"".equals(Utility.getName(Utility.getName(po.getFttname())))){
			buffer.append(" and f_tt_name = ? ");
			params.add(Utility.getName(po.getFttname()));
		}else{
			buffer.append(" and 2 = 1 ");
		}
		
		return (TeachnologyTypePo) queryForObject(buffer.toString(), params.toArray(), TeachnologyTypePo.class);
	}
	
	public List getTeachnologyTypeList() {

        String sql="select f_tt_id as fttid,f_tt_name as fttname from f_technologytype";
		return queryForObjectList(sql, null,TeachnologyTypePo.class);
	}
}
