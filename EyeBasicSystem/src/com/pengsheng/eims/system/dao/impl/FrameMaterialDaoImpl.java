package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.dao.FrameMaterialDao;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * TeachnologyTypeDaoImpl 镜架材质Dao实现类
 * 
 * @author GuanZiGang
 * @version 1.0
 * @see BaseJdbcDaoSupport
 * @see FrameMaterialDao
 */
public class FrameMaterialDaoImpl extends BaseJdbcDaoSupport implements FrameMaterialDao {

	/**
	 * 删除镜架材质
	 * 
	 * @param po 镜架材质po
	 * @return void
	 */
	public void deleteFrameMaterial(FrameMaterialPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBfmid()));
		buffer.append(" delete from B_FrameMaterial where B_FM_ID = ? ");
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 镜架材质数量
	 */
	public int getFrameMaterialCount(FrameMaterialPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_FM_ID)");
		buffer.append("   from B_FrameMaterial");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询镜架材质ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getFrameMaterialId(FrameMaterialPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBfmid()));
		buffer.append(" select count(B_FM_ID)");
		buffer.append("   from B_FrameMaterial where B_FM_ID = ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	/**
	 * 添加时查询镜架材质名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getFrameMaterialName(FrameMaterialPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBfmname()));
		buffer.append(" select count(B_FM_ID)");
		buffer.append("   from B_FrameMaterial where B_FM_Name = ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * 修改时查询镜架材质名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getFrameMaterialNameUpdate(FrameMaterialPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBfmname()));
		params.add(Utility.getName(po.getBfmid()));
		buffer.append(" select count(B_FM_ID)");
		buffer.append("   from B_FrameMaterial where B_FM_Name = ? and B_FM_ID <> ? ");
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 镜架材质结果集
	 */
	public List getFrameMaterialList(FrameMaterialPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_FM_ID) as rowNum, B_FM_ID as bfmid,B_FM_Name as bfmname from B_FrameMaterial");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				FrameMaterialPo.class);
	}

	/**
	 * 新增镜架材质
	 * 
	 * @param po 镜架材质po
	 * @return void
	 */
	public void insertFrameMaterial(FrameMaterialPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBfmid()));
		params.add(Utility.getName(po.getBfmname()));
		buffer.append(" INSERT INTO B_FrameMaterial");
		buffer.append("            (B_FM_ID");
		buffer.append("            ,B_FM_Name)");
		buffer.append("      VALUES");
		buffer.append("            (?");
		buffer.append("            ,? )");
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 修改镜架材质
	 * 
	 * @param po 镜架材质po
	 * @return void
	 */
	public void updateFrameMaterial(FrameMaterialPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBfmname()));
		params.add(Utility.getName(po.getBfmid()));
		buffer.append(" UPDATE B_FrameMaterial");
		buffer.append("    SET  B_FM_Name = ?");
		buffer.append("  WHERE B_FM_ID = ? ");
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 查询镜架材质在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getFrameMaterialWithGoods(FrameMaterialPo po){
		StringBuffer buffer = new StringBuffer();
		//buffer.append(" select count(B_GI_frameProcessCraftType) from S_ME_CustomerInfo");
		//buffer.append(" where B_GI_frameProcessCraftType = '"+Utility.getName(po.getBwtid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询镜架材质的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 镜架材质详细信息
	 */
	public FrameMaterialPo getFrameMaterialPo(FrameMaterialPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select top 1  B_FM_ID as bfmid,isnull(B_FM_Name,'') as bfmname from B_FrameMaterial");
		buffer.append(" where 1=1 ");
		
		if(!"".equals(Utility.getName(Utility.getName(po.getBfmid())))){
			buffer.append(" and B_FM_ID = ? ");
			params.add(Utility.getName(po.getBfmid()));
		}else if(!"".equals(Utility.getName(Utility.getName(po.getBfmname())))){
			buffer.append(" and B_FM_Name = ? ");
			params.add(Utility.getName(po.getBfmname()));
		}else{
			buffer.append(" and 2 = 1 ");
		}
		
		return (FrameMaterialPo) queryForObject(buffer.toString(), params.toArray(), FrameMaterialPo.class);
	}
	
	public List<FrameMaterialPo> getFrameMaterialList() {

        String sql="select B_FM_ID as bfmid,B_FM_Name as bfmname from B_FrameMaterial ";
		return queryForObjectList(sql, null,FrameMaterialPo.class);
	}

}
