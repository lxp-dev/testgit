package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.dao.InterestDao;
import com.pengsheng.eims.system.persistence.InterestPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * TeachnologyTypeDaoImpl 兴趣爱好Dao实现类
 * 
 */
public class InterestDaoImpl extends BaseJdbcDaoSupport implements InterestDao {

	/**
	 * 删除兴趣爱好
	 * 
	 * @param po 兴趣爱好po
	 * @return void
	 */
	public void deleteInterest(InterestPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBirid()));
		buffer.append(" delete from B_Interest where B_IR_ID = ? ");
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 兴趣爱好数量
	 */
	public int getInterestCount(InterestPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_IR_ID)");
		buffer.append("   from B_Interest");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询兴趣爱好ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getInterestId(InterestPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBirid()));
		buffer.append(" select count(B_IR_ID)");
		buffer.append("   from B_Interest where B_IR_ID = ?");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 添加时查询兴趣爱好名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getInterestName(InterestPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBirname()));
		buffer.append(" select count(B_IR_ID)");
		buffer.append("   from B_Interest where B_IR_Name = ?");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 修改时查询兴趣爱好名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getInterestNameUpdate(InterestPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBirname()));
		params.add(Utility.getName(po.getBirid()));
		buffer.append(" select count(B_IR_ID)");
		buffer.append("   from B_Interest where B_IR_Name = ? and B_IR_ID <> ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 兴趣爱好结果集
	 */
	public List getInterestList(InterestPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_IR_ID) as rowNum, B_IR_ID as birid,B_IR_Name as birname from B_Interest");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				InterestPo.class);
	}

	/**
	 * 新增兴趣爱好
	 * 
	 * @param po 兴趣爱好po
	 * @return void
	 */
	public void insertInterest(InterestPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBirid()));
		params.add(Utility.getName(po.getBirname()));
		buffer.append(" INSERT INTO B_Interest");
		buffer.append("            (B_IR_ID");
		buffer.append("            ,B_IR_Name)");
		buffer.append("      VALUES");
		buffer.append("            (?");
		buffer.append("            ,?)");
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 修改兴趣爱好
	 * 
	 * @param po 兴趣爱好po
	 * @return void
	 */
	public void updateInterest(InterestPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBirname()));
		params.add(Utility.getName(po.getBirid()));
		buffer.append(" UPDATE B_Interest");
		buffer.append("    SET  B_IR_Name = ?");
		buffer.append("  WHERE B_IR_ID = ?");
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 查询兴趣爱好在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getInterestWithGoods(InterestPo po){
		StringBuffer buffer = new StringBuffer();
//		buffer.append(" select count(B_GI_frameProcessCraftType) from B_GoodsInfo");
//		buffer.append(" where B_GI_frameProcessCraftType = '"+Utility.getName(po.getFttid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询兴趣爱好的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 兴趣爱好详细信息
	 */
	public InterestPo getInterestPo(InterestPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBirid()));
		buffer.append(" select top 1  B_IR_ID as birid,B_IR_Name as birname from B_Interest");
		buffer.append(" where B_IR_ID = ?");
		return (InterestPo) queryForObject(buffer.toString(), params.toArray(), InterestPo.class);
	}
	
	public List getInterestList() {

        String sql="select B_IR_ID as birid,B_IR_Name as birname from B_Interest";
		return queryForObjectList(sql, null,InterestPo.class);
	}
}
