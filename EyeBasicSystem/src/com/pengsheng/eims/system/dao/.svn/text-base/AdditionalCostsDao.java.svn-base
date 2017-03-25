package com.pengsheng.eims.system.dao;

import java.util.List;

import com.pengsheng.eims.system.persistence.AdditionalCostsPo;

public interface AdditionalCostsDao {
	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 附加费用数量
	 */
	public int getAdditionalCostsCount(AdditionalCostsPo po);

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 附加费用结果集
	 */
	public List getAdditionalCostsList(AdditionalCostsPo po,int start, int size);

	/**
	 * 查询附加费用的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 附加费用详细信息
	 */
	public AdditionalCostsPo getAdditionalCostsPo(AdditionalCostsPo po);
	
	/**
	 * 查询附加费用ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getAdditionalCostsId(AdditionalCostsPo po);
	
	
	/**
	 * 查询附加费用在   表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTAdditionalCostsWithGoods(AdditionalCostsPo po);
	
	
	/**
	 * 新增附加费用
	 * 
	 * @param po 附加费用po
	 * @return void
	 */
	public void insertAdditionalCosts(AdditionalCostsPo po);
	
	/**
	 * 修改附加费用
	 * 
	 * @param po 附加费用po
	 * @return void
	 */
	public void updateAdditionalCosts(AdditionalCostsPo po);
	
	/**
	 * 删除附加费用
	 * 
	 * @param po 附加费用po
	 * @return void
	 */
	public void deleteAdditionalCosts(AdditionalCostsPo po);
	
	public List<AdditionalCostsPo> getAdditionalCostsList();
	/**
	 * 添加时查询附加费用名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getAdditionalCostsName(AdditionalCostsPo po) ;
	/**
	 * 修改时查询附加费用名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getAdditionalCostsNameUpdate(AdditionalCostsPo po);
	
	public List<AdditionalCostsPo> getAdditionalCostsListForAjax(String[] supplierids);
}
