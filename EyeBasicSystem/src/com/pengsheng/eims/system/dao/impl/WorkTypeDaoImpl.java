package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

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
public class WorkTypeDaoImpl extends BaseJdbcDaoSupport implements WorkTypeDao {

	/**
	 * 删除职业
	 * 
	 * @param po 职业po
	 * @return void
	 */
	public void deleteWorkType(WorkTypePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBwtid()));
		buffer.append(" delete from B_WorkType where B_WT_ID = ? ");
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 职业数量
	 */
	public int getWorkTypeCount(WorkTypePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_WT_ID)");
		buffer.append("   from B_WorkType");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询职业ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getWorkTypeId(WorkTypePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBwtid()));
		buffer.append(" select count(B_WT_ID)");
		buffer.append("   from B_WorkType where B_WT_ID = ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	/**
	 * 添加时查询职业名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getWorkTypeName(WorkTypePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBwtname()));
		buffer.append(" select count(B_WT_ID)");
		buffer.append("   from B_WorkType where B_WT_Name = ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * 修改时查询职业名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getWorkTypeNameUpdate(WorkTypePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBwtname()));
		params.add(Utility.getName(po.getBwtid()));
		buffer.append(" select count(B_WT_ID)");
		buffer.append("   from B_WorkType where B_WT_Name = ? and B_WT_ID <> ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 职业结果集
	 */
	public List getWorkTypeList(WorkTypePo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_WT_ID) as rowNum, B_WT_ID as bwtid,B_WT_Name as bwtname from B_WorkType");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				WorkTypePo.class);
	}

	/**
	 * 新增职业
	 * 
	 * @param po 职业po
	 * @return void
	 */
	public void insertWorkType(WorkTypePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" INSERT INTO B_WorkType");
		buffer.append("            (B_WT_ID");
		buffer.append("            ,B_WT_Name)");
		buffer.append("      VALUES");
		buffer.append("            (? ");
		buffer.append("            ,? ) ");
		params.add(Utility.getName(po.getBwtid()));
		params.add(Utility.getName(po.getBwtname()));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 修改职业
	 * 
	 * @param po 职业po
	 * @return void
	 */
	public void updateWorkType(WorkTypePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" UPDATE B_WorkType");
		buffer.append("    SET  B_WT_Name = ?");
		buffer.append("  WHERE B_WT_ID = ? ");
		params.add(Utility.getName(po.getBwtname()));
		params.add(Utility.getName(po.getBwtid()));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 查询职业在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getWorkTypeWithGoods(WorkTypePo po){
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
	public WorkTypePo getWorkTypePo(WorkTypePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select top 1  B_WT_ID as bwtid,B_WT_Name as bwtname from B_WorkType");
		buffer.append(" where B_WT_ID = ? ");
		params.add(Utility.getName(po.getBwtid()));
		return (WorkTypePo) queryForObject(buffer.toString(), params.toArray(), WorkTypePo.class);
	}
	
	public List getWorkTypeList() {

        String sql="select B_WT_ID as bwtid,B_WT_Name as bwtname from B_WorkType";
		return queryForObjectList(sql, null,WorkTypePo.class);
	}
	
	/**
	 * 删除人群分类
	 * 
	 * @param po 
	 * @return void
	 */
	public void deletePersonType(PersonTypePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from B_PersonType where B_PT_ID = '"+Utility.getName(po.getBptid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 人群分类数量
	 */
	public int getPersonTypeCount(PersonTypePo po) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(" select count(B_PT_ID)");
		buffer.append("   from B_PersonType");
		
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询人群分类ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getPersonTypeId(PersonTypePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBptid()));
		
		buffer.append(" select count(B_PT_ID)");
		buffer.append("   from B_PersonType where B_PT_ID = ? ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	/**
	 * 添加时查询人群分类名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getPersonTypeName(PersonTypePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBptname()));
		
		buffer.append(" select count(B_PT_ID)");
		buffer.append("   from B_PersonType where B_PT_Name = ? ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * 修改时查询人群分类名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getPersonTypeNameUpdate(PersonTypePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBptname()));
		params.add(Utility.getName(po.getBptid()));
		
		buffer.append(" select count(B_PT_ID)");
		buffer.append("   from B_PersonType where B_PT_Name = ? and B_PT_ID <> ? ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 人群分类结果集
	 */
	public List getPersonTypeList(PersonTypePo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_PT_ID) as rowNum, B_PT_ID as bptid,B_PT_Name as bptname from B_PersonType");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				PersonTypePo.class);
	}

	/**
	 * 新增人群分类
	 * 
	 * @param po 人群分类po
	 * @return void
	 */
	public void insertPersonType(PersonTypePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBptid()));
		params.add(Utility.getName(po.getBptname()));
		
		buffer.append(" INSERT INTO B_PersonType");
		buffer.append("            (B_PT_ID");
		buffer.append("            ,B_PT_Name)");
		buffer.append("      VALUES");
		buffer.append("            (?");
		buffer.append("            ,?) ");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 修改人群分类
	 * 
	 * @param po 人群分类po
	 * @return void
	 */
	public void updatePersonType(PersonTypePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBptname()));
		params.add(Utility.getName(po.getBptid()));
		
		buffer.append(" UPDATE B_PersonType");
		buffer.append("    SET  B_PT_Name = ?");
		buffer.append("  WHERE B_PT_ID = ? ");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 查询人群分类在是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getPersonTypeIsUse(PersonTypePo po){
		StringBuffer buffer = new StringBuffer();
		//buffer.append(" select count(B_GI_frameProcessCraftType) from S_ME_CustomerInfo");
		//buffer.append(" where B_GI_frameProcessCraftType = '"+Utility.getName(po.getBwtid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询人群分类的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 人群分类详细信息
	 */
	public PersonTypePo getPersonTypePo(PersonTypePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBptid()));
		
		buffer.append(" select top 1  B_PT_ID as bptid,B_PT_Name as bptname from B_PersonType");
		buffer.append(" where B_PT_ID = ? ");
		
		return (PersonTypePo) queryForObject(buffer.toString(), params.toArray(), PersonTypePo.class);
	}
	
	public List getPersonTypeList() {

        String sql="select B_PT_ID as bptid,B_PT_Name as bptname from B_PersonType";
		return queryForObjectList(sql, null,PersonTypePo.class);
	}
	
}
