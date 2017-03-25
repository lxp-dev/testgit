package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.PreBrandPo;
import com.pengsheng.eims.sales.persistence.PreDepPo;
import com.pengsheng.eims.sales.persistence.PrePersonSalesEntryPo;
import com.pengsheng.eims.sales.persistence.PrePersonSalesPo;
import com.pengsheng.eims.sales.persistence.PrePlanPo;
import com.pengsheng.eims.sales.persistence.PreSalesPo;
import com.pengsheng.eims.sales.persistence.PreShopSalesEntryPo;
import com.pengsheng.eims.sales.persistence.PreShopSalesPo;

public interface PreSalesDao {
	
	/**
	 * 新增门店预销售设置
	 * @param po PreSalesPo
	 * @return int 操作记录数
	 */
	public int insertPreSales(PreSalesPo po);

	/**
	 * 根据ID删除门店预销售设置
	 * @param po PreSalesPo
	 * @return int 操作记录数
	 */
	public int deletePreSales(PreSalesPo po);

	/**
	 * 修改门店预销售设置
	 */
	public int updatePreSales(PreSalesPo po);
	
	/**
	 * 根据ID获取PreSalesPo对象
	 * @param po
	 * @return
	 */
	public PreSalesPo getPreSalesPo(PreSalesPo po);
	
	/**
	 * 根据部门ID和开始时间获取PreSalesPo集合,新设置开始时间在设置过时间段内</br>
	 * 例如:部门ID为:01 、02 数据库已设置,时间段为:2013-07-01 至 2013-07-15</br>
	 * 新设置部门ID为：01，开始时间为: 2013-07-03</br>
	 * 则会将01的设置记录取出</br>
	 * @param po
	 * @return List<PreSalesPo>
	 */
	public List<PreSalesPo> getIntersectionPreSalesList(PreSalesPo po);
	
	/**
	 * 根据查询条件获取PreSalesPoList
	 */
	public List<PreSalesPo> getPreSalesPoList(PreSalesPo po, int start, int size);
	
	/**
	 * 根据查询条件获取PreSalesPoList条数
	 */
	public int getPreSalesPoListCount(PreSalesPo po);
	
	/**
	 * 根据主键ID修改预销售数量
	 * @param id 主键ID
	 * @param quantity 数量
	 */
	public void updatePreSalesPoQuantity(String id, String quantity);
	
	/**
	 * 查询预销售计划名称表
	 */
	public List<PrePlanPo> getPrePlanPoList(PrePlanPo po, int start, int size);
	
	/**
	 * 查询预销售计划名称表记录数
	 */
	public int getPrePlanPoListCount(PrePlanPo po);
	
	/**
	 * 获取预销售计划表对象
	 * @param PrePlanPo po
	 */
	public PrePlanPo getPrePlanPo(PrePlanPo po);

	/**
	 * 获取预销售计划表对应的部门
	 * @param PrePlanPo po
	 */
	public List<PreDepPo> getPreDepPoList(PrePlanPo po);

	/**
	 * 获取预销售部门对应的品种
	 * @param PreDepPo po
	 */
	public List<PreBrandPo> getPreBrandPoList(PreDepPo po);
	
	/**
	 * 新增预销售计划名称表
	 * @param po
	 */
	public void insertPrePlanPo(PrePlanPo po);
	
	/**
	 * 修改预销售计划名称表
	 * @param po
	 */
	public void updatePrePlanPo(PrePlanPo po);
	
	/**
	 * 删除预销售计划名称表
	 * @param po
	 */
	public void deletePrePlanPo(PrePlanPo po);
	
	/**
	 * 新增预销售计划品种表
	 * @param po PreBrandPo
	 */
	public void insertPreBrandPo(PreBrandPo po);

	/**
	 * 删除预销售计划品种表(根据部门表的外键ID删除)
	 * @param po PreBrandPo
	 */
	public void deletePreBrandPoByPreDepPoId(PreDepPo po);
	
	/**
	 * 新增预销售计划部门表
	 * @param po PreDepPo
	 */
	public void insertPreDepPo(PreDepPo po);

	/**
	 * 获取预销售计划部门表对象(根据ID)
	 * @param po PreDepPo
	 */
	public PreDepPo getPreDepPo(PreDepPo po);
	
	/**
	 * 删除预销售计划部门表(根据主键ID删除)
	 * @param po PreDepPo
	 */
	public void deletePreDepPo(PreDepPo po);
	
	
	/**
	 * 更新过期计划销售表(根据结束日期更新)
	 * @param po PreDepPo
	 */
	public void updatePreDepPoOverdue();	
	
	/**
	 * 查询门店计划销售金额列表
	 */
	public List<PreShopSalesPo> getPreShopSalesList(PreShopSalesPo po, int start, int size);
	
	/**
	 * 查询门店计划销售金额总数
	 */
	public int getPreShopSalesCount(PreShopSalesPo po);
	
	/**
	 * 新增门店计划销售金额列表
	 */
	public void insertPreShopSales(PreShopSalesPo po);
	
	/**
	 * 新增门店计划销售金额明细列表
	 */
	public void insertPreShopSalesEntry(PreShopSalesEntryPo po);

	/**
	 * 删除门店计划销售金额列表
	 */
	public void deletePreShopSales(PreShopSalesPo po);
	
	/**
	 * 删除门店计划销售金额明细列表
	 */
	public void deletePreShopSalesEntry(PreShopSalesPo po);

	/**
	 * 修改门店计划销售金额列表
	 */
	public void updatePreShopSales(PreShopSalesPo po);	
	
	/**
	 * 查看门店计划销售金额明细
	 */
	public PreShopSalesPo getPreShopSalesDetail(PreShopSalesPo po);
	
	/**
	 * 判断门店计划销售金额是否重复
	 */
	public int getPreShopSalesByIDCount(PreShopSalesPo po);
	
	/**
	 * 计算两个日期的间隔天数
	 */
	public int getDayAreaCount(PreShopSalesPo po);
	
	
	
	public int insertPreSalesS(PreSalesPo po);
	
	public PreSalesPo selectPreSalesPoSerialNumber();
	
	
	
	/**
	 * 查询人员计划销售金额列表
	 */
	public List<PrePersonSalesPo> getPrePersonSalesList(PrePersonSalesPo po, int start, int size);
	
	/**
	 * 查询人员计划销售金额总数
	 */
	public int getPrePersonSalesCount(PrePersonSalesPo po);
	
	/**
	 * 新增人员计划销售金额列表
	 */
	public void insertPrePersonSales(PrePersonSalesPo po);
	
	/**
	 * 新增人员计划销售金额明细列表
	 */
	public void insertPrePersonSalesEntry(PrePersonSalesEntryPo po);

	/**
	 * 删除人员计划销售金额列表
	 */
	public void deletePrePersonSales(PrePersonSalesPo po);
	
	/**
	 * 删除人员计划销售金额明细列表
	 */
	public void deletePrePersonSalesEntry(PrePersonSalesPo po);

	/**
	 * 修改人员计划销售金额列表
	 */
	public void updatePrePersonSales(PrePersonSalesPo po);	
	
	/**
	 * 查看人员计划销售金额明细
	 */
	public PrePersonSalesPo getPrePersonSalesDetail(PrePersonSalesPo po);
	
	/**
	 * 判断人员计划销售金额是否重复
	 */
	public int getPrePersonSalesByIDCount(PrePersonSalesPo po);
	/**
	 * 计算两个日期的间隔天数
	 */
	public int getDayAreaCount2(PrePersonSalesPo po);
}
