package com.pengsheng.eims.system.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

import com.pengsheng.eims.system.persistence.PersonTypePo;
import com.pengsheng.eims.system.persistence.WorkTypePo;

/**
 * TeachnologyTypeMgr 职业Mgr
 * 
 * @author GuanZiGang
 * @version 1.0
 */
public interface WorkTypeMgr {

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 职业数量
	 */
	public int getWorkTypeCount(WorkTypePo po);

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 职业结果集
	 */
	public List<WorkTypePo> getWorkTypeList(WorkTypePo po,int start, int size);

	/**
	 * 查询职业的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 职业详细信息
	 */
	public WorkTypePo getWorkTypePo(WorkTypePo po);
	
	/**
	 * 查询职业ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getWorkTypeId(WorkTypePo po);
	
	/**
	 * 添加时查询职业名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getWorkTypeName(WorkTypePo po) ;
	/**
	 * 修改时查询职业名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getWorkTypeNameUpdate(WorkTypePo po) ;
	
	
	/**
	 * 查询职业在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getWorkTypeWithGoods(WorkTypePo po);
	
	
	/**
	 * 新增职业
	 * 
	 * @param po 职业po
	 * @return void
	 */
	public void insertWorkType(WorkTypePo po,LogisticsLogPo logPo);
	
	/**
	 * 修改职业
	 * 
	 * @param po 职业po
	 * @return void
	 */
	public void updateWorkType(WorkTypePo po,LogisticsLogPo logPo);
	
	/**
	 * 删除职业
	 * 
	 * @param po 职业po
	 * @return void
	 */
	public void deleteWorkType(WorkTypePo po,LogisticsLogPo logPo);
	
	/**
	 * 根据返回相应的结果集
	 * 
	 */
	public List getWorkTypeList();
	
	/**
	 * 删除人群分类
	 * 
	 * @param po 
	 * @return void
	 */
	public void deletePersonType(PersonTypePo po,LogisticsLogPo logPo);

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 人群分类数量
	 */
	public int getPersonTypeCount(PersonTypePo po);

	/**
	 * 查询人群分类ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getPersonTypeId(PersonTypePo po);
	/**
	 * 添加时查询人群分类名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getPersonTypeName(PersonTypePo po);
	
	
	/**
	 * 修改时查询人群分类名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getPersonTypeNameUpdate(PersonTypePo po);

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 人群分类结果集
	 */
	public List getPersonTypeList(PersonTypePo po, int start, int size);

	/**
	 * 新增人群分类
	 * 
	 * @param po 人群分类po
	 * @return void
	 */
	public void insertPersonType(PersonTypePo po,LogisticsLogPo logPo);

	/**
	 * 修改人群分类
	 * 
	 * @param po 人群分类po
	 * @return void
	 */
	public void updatePersonType(PersonTypePo po,LogisticsLogPo logPo);

	/**
	 * 查询人群分类在是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getPersonTypeIsUse(PersonTypePo po);

	/**
	 * 查询人群分类的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 人群分类详细信息
	 */
	public PersonTypePo getPersonTypePo(PersonTypePo po);
	
	public List getPersonTypeList();
}
