package com.pengsheng.eims.system.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.SalesSpecialPo;
import com.pengsheng.eims.system.persistence.SpecialRequirementsPo;

public interface SpecialRequirementsMgr {
	
	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 特殊加工要求数量
	 */
	public int getSpecialRequirementsCount(SpecialRequirementsPo po);

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 特殊加工要求结果集
	 */
	public List<SpecialRequirementsPo> getSpecialRequirementsList(SpecialRequirementsPo po,int start, int size);

	/**
	 * 查询特殊加工要求的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 特殊加工要求详细信息
	 */
	public SpecialRequirementsPo getSpecialRequirementsPo(SpecialRequirementsPo po);
	
	/**
	 * 查询特殊加工要求ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getSpecialRequirementsId(SpecialRequirementsPo po);
	
	
	/**
	 * 查询特殊加工要求在   表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTSpecialRequirementsWithGoods(SpecialRequirementsPo po);
	
	
	/**
	 * 新增特殊加工要求
	 * 
	 * @param po 特殊加工要求po
	 * @return void
	 */
	public void insertSpecialRequirements(SpecialRequirementsPo po,LogisticsLogPo logPo);
	
	/**
	 * 修改特殊加工要求
	 * 
	 * @param po 特殊加工要求po
	 * @return void
	 */
	public void updateSpecialRequirements(SpecialRequirementsPo po,LogisticsLogPo logPo);
	
	/**
	 * 删除特殊加工要求
	 * 
	 * @param po 特殊加工要求po
	 * @return void
	 */
	public void deleteSpecialRequirements(SpecialRequirementsPo po,LogisticsLogPo logPo);
	
	public List<SpecialRequirementsPo> getSpecialRequirementsList();
	
	public List<SalesSpecialPo> getSpecialRequirements1List(String status);
	/**
	 * 添加时查询特殊加工要求名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getSpecialRequirementsName(SpecialRequirementsPo po) ;
	/**
	 * 修改时查询特殊加工要求名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getSpecialRequirementsNameUpdate(SpecialRequirementsPo po) ;
}
