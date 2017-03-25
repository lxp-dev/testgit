package com.pengsheng.eims.system.dao;

import java.util.List;

import com.pengsheng.eims.system.persistence.FrameMaterialPo;

/**
 * TeachnologyTypeDao 镜架材质Dao
 * 
 * @author GuanZiGang
 * @version 1.0
 */
public interface FrameMaterialDao {

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 镜架材质数量
	 */
	public int getFrameMaterialCount(FrameMaterialPo po);

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 镜架材质结果集
	 */
	public List getFrameMaterialList(FrameMaterialPo po,int start, int size);

	
	/**
	 * 查询镜架材质的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 镜架材质详细信息
	 */
	public FrameMaterialPo getFrameMaterialPo(FrameMaterialPo po);
	
	
	/**
	 * 查询镜架材质ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getFrameMaterialId(FrameMaterialPo po);
	
	/**
	 * 添加时查询职业名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getFrameMaterialName(FrameMaterialPo po) ;
	
	/**
	 * 修改时查询职业名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getFrameMaterialNameUpdate(FrameMaterialPo po) ;
	
	/**
	 * 查询镜架材质在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getFrameMaterialWithGoods(FrameMaterialPo po);
	
	
	/**
	 * 新增镜架材质
	 * 
	 * @param po 镜架材质po
	 * @return void
	 */
	public void insertFrameMaterial(FrameMaterialPo po);
	
	/**
	 * 修改镜架材质
	 * 
	 * @param po 镜架材质po
	 * @return void
	 */
	public void updateFrameMaterial(FrameMaterialPo po);
	
	/**
	 * 删除职业
	 * 
	 * @param po 职业po
	 * @return void
	 */
	public void deleteFrameMaterial(FrameMaterialPo po);
	
	public List<FrameMaterialPo> getFrameMaterialList();
	
}
