package com.pengsheng.eims.system.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.TeachnologyTypePo;

/**
 * TeachnologyTypeMgr 工艺类型Mgr
 * 
 * @author GuanZiGang
 * @version 1.0
 */
public interface TeachnologyTypeMgr {

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 工艺类型数量
	 */
	public int getTeachnologyTypeCount(TeachnologyTypePo po);

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 工艺类型结果集
	 */
	public List<TeachnologyTypePo> getTeachnologyTypeList(TeachnologyTypePo po,int start, int size);

	/**
	 * 查询工艺类型的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 工艺类型详细信息
	 */
	public TeachnologyTypePo getTeachnologyTypePo(TeachnologyTypePo po);
	
	/**
	 * 查询工艺类型ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTeachnologyTypeId(TeachnologyTypePo po);
	
	
	/**
	 * 查询工艺类型在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTeachnologyTypeWithGoods(TeachnologyTypePo po);
	
	
	/**
	 * 新增工艺类型
	 * 
	 * @param po 工艺类型po
	 * @return void
	 */
	public void insertTeachnologyType(TeachnologyTypePo po,LogisticsLogPo logPo);
	
	/**
	 * 修改工艺类型
	 * 
	 * @param po 工艺类型po
	 * @return void
	 */
	public void updateTeachnologyType(TeachnologyTypePo po,LogisticsLogPo logPo);
	
	/**
	 * 删除工艺类型
	 * 
	 * @param po 工艺类型po
	 * @return void
	 */
	public void deleteTeachnologyType(TeachnologyTypePo po,LogisticsLogPo logPo);
	
	/**
	 * 根据返回相应的结果集
	 * 
	 */
	public List getTeachnologyTypeList();
	/**
	 * 添加时查询工艺类型名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTeachnologyTypeName(TeachnologyTypePo po) ;
	/**
	 * 修改时查询工艺类型名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTeachnologyTypeNameUpdate(TeachnologyTypePo po) ;
	
}
