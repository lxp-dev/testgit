/**
 * 
 */
package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;

/**
 * @author Liuqian
 * 
 */
public interface RegisteredDao {

	/**
	 * 按条件检索检查费用项目进行管理
	 * 
	 * @param flag
	 *            启用停用标示位 1:启用 0：停用
	 * @param feeType
	 *            收费类型 1:缴费 2：退费
	 * @return List
	 */
	public List<RegisteredCategoryPo> getSelValue(String flag, String feeType);
	
	/**
	 * 查询所有收费项目
	 */
	public List<RegisteredCategoryPo> getRepairsCostList();

	/**
	 * 检索当天顾客挂号未结款所有挂号费用
	 * 
	 * @param customerid
	 * @return
	 */
	public List<RegisteredDetailsPo> getRegisteredDetails(String customerid);

	/**
	 * 检索当天顾客挂号未结款所有挂号费用
	 * 
	 * @param customerid
	 * @param typeFlag:1:挂号;2:退挂号；
	 * @return
	 */
	public List<RegisteredDetailsPo> getRegisteredDetails(String customerid,String typeFlag);
	
	/**
	 * 新增挂号明细表信息
	 * 
	 * @param po
	 */
	public void insertRegisteredDetails(RegisteredDetailsPo po);

	/**
	 * 更新挂号明细表信息
	 * 
	 * @param po
	 */
	public void updateRegisteredDetails(RegisteredDetailsPo po);
	
	/**
	 * 新增维修明细表信息
	 * 
	 * @param po
	 */
	public void insertRepairsCostDetails(RegisteredDetailsPo po);
	/**
	 * 查询当日个人挂号金额汇总
	 */
	public RegisteredDetailsPo getRegisteredPersonSumToday(String departmentID,String personID);		
}
