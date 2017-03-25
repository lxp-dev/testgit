/**
 * 
 */
package com.pengsheng.eims.sales.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.sales.persistence.SetMealChildPropertyPo;
import com.pengsheng.eims.sales.persistence.SetMealEntryPo;
import com.pengsheng.eims.sales.persistence.SetMealParentPropertyPo;
import com.pengsheng.eims.sales.persistence.SetMealPo;
import com.pengsheng.eims.sales.persistence.SetMealPropertyValuePo;
import com.pengsheng.eims.system.persistence.IntegralPo;
import com.pengsheng.eims.system.persistence.MaxDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.MaxDiscountPo;

/**
 * 套餐
 * 
 */
public interface SetMealDao {
	
	/**
	 * 查询套餐总数
	 */
	public int getSetMealCount(SetMealPo po);
	
	/**
	 * 查询套餐列表
	 */
	public List<SetMealPo> getSetMealList(SetMealPo po, int start, int size);

	/**
	 * 增加套餐
	 * 
	 */
	public void insertSetMeal(SetMealPo po);
	
	/**
	 * 更新套餐
	 * 
	 */
	public void updateSetMealRecord(SetMealPo po);
	
	
	/**
	 * 增加套餐
	 * 
	 */
	public void insertSetMealEntry(SetMealPo po);
	
	/**
	 * 更新套餐
	 * 
	 */
	public void insertSetMealRecordEntry(SetMealEntryPo poEntry);
	
	/**
	 * 反审核套餐
	 * 
	 */
	public void updateSetMealUnAudit(SetMealPo po);
	
	/**
	 * 增加套餐
	 * 
	 */
	public void insertSetMealRecord(SetMealPo po);

	/**
	 * 删除套餐
	 * 
	 */
	public void deleteSetMeal(SetMealPo po);
	
	/**
	 * 删除套餐流水
	 * 
	 */
	public void deleteSetMealRecord(SetMealPo po);
	
	/**
	 * 删除套餐
	 * 
	 */
	public void deleteSetMealEntry(SetMealPo po);
	
	/**
	 * 删除套餐流水明细
	 * 
	 */
	public void deleteSetMealRecordEntry(SetMealPo po);
	
	/**
	 * 套餐详细
	 * 
	 */
	public SetMealPo getSetMealDetail(SetMealPo po);
	
	/**
	 * 套餐商品详细
	 * 
	 */
	public List<SetMealEntryPo> getSetMealEntryDetail(SetMealPo po);
	
	/**
	 * 查询套餐商品总数
	 */
	public int getGoodsCount(GoodsInfoPo po);
	
	/**
	 * 查询套餐商品列表
	 */
	public List<GoodsInfoPo> getGoodsList(GoodsInfoPo po, int start, int size);
	
	/**
	 * 查询制造商总数
	 */
	public int getSupplierCount(GoodsInfoPo po);
	
	/**
	 * 查询制造商列表
	 */
	public List<GoodsInfoPo> getSupplierList(GoodsInfoPo po, int start, int size);
	
	/**
	 * 查询品种总数
	 */
	public int getBrandCount(GoodsInfoPo po);
	
	/**
	 * 查询品种列表
	 */
	public List<GoodsInfoPo> getBrandList(GoodsInfoPo po, int start, int size);
	
	/****************************************************************************************************************/
	
	/**
	 * 查询积分累计规则总数
	 */
	public int getIntegralSetCount(IntegralPo po);
	
	/**
	 * 查询积分累计规则列表
	 */
	public List<IntegralPo> getIntegralSetList(IntegralPo po, int start, int size);

	/**
	 * 增加积分累计规则
	 * 
	 */
	public void insertIntegralSet(IntegralPo po);

	/**
	 * 更新积分累计规则
	 * 
	 */
	public void updateIntegralSet(IntegralPo po);

	/**
	 * 批量更新积分累计规则
	 * 
	 */
	public void updateBatchIntegralSet(IntegralPo po);
	
	/**
	 * 删除积分累计规则
	 * 
	 */
	public void deleteIntegralSet(IntegralPo po);
	
	/**
	 * 查询积分累计规则总数
	 */
	public int getGoodsCount(IntegralPo po);
	
	/**
	 * 查询积分累计规则列表
	 */
	public List<GoodsInfoPo> getGoodsList(IntegralPo po, int start, int size);
	
	/**
	 * 查询积分累计规则列表
	 */
	public List<GoodsInfoPo> getGoodsList(IntegralPo po);
	
	/****************************************************************************************************************/
	
/****************************************************************************************************************/
	
	/**
	 * 查询最大折扣设置总数
	 */
	public int getMaxDiscountSetCount(MaxDiscountPo po);
	
	/**
	 * 查询最大折扣设置列表
	 */
	public List<MaxDiscountPo> getMaxDiscountSetList(MaxDiscountPo po, int start, int size);

	/**
	 * 增加最大折扣设置
	 * 
	 */
	public void insertMaxDiscountSet(MaxDiscountPo po);

	/**
	 * 更新最大折扣设置
	 * 
	 */
	public void updateMaxDiscountSet(MaxDiscountPo po);

	/**
	 * 批量更新最大折扣设置
	 * 
	 */
	public void updateBatchMaxDiscountSet(MaxDiscountPo po);
	
	/**
	 * 删除最大折扣设置
	 * 
	 */
	public void deleteMaxDiscountSet(MaxDiscountPo po);
	
	
	/**
	 * 最大折扣设置详细
	 * 
	 */
	public MaxDiscountPo getMaxDiscountSetDetail(MaxDiscountPo po);
	
	/**
	 * 最大折扣设置编号是否存在
	 * 
	 */
	public int isExistMaxDiscountSet(MaxDiscountPo po);
	
	
	/****************************************************************************************************************/
	
	
	/**
	 * 查询积分兑换设置总数
	 */
	public int getIntegralExchangeSetCount(IntegralPo po);
	
	/**
	 * 查询积分兑换设置列表
	 */
	public List<IntegralPo> getIntegralExchangeSetList(IntegralPo po, int start, int size);

	/**
	 * 增加积分兑换设置
	 * 
	 */
	public void insertIntegralExchangeSet(IntegralPo po);

	/**
	 * 积分累计规则详细
	 * 
	 */
	public IntegralPo getIntegralSetDetail(IntegralPo po);
	
	/**
	 * 累计规则编号是否存在
	 * 
	 */
	public int isExistIntegralSet(IntegralPo po);
	
	/**
	 * 更新积分兑换设置
	 * 
	 */
	public void updateIntegralExchangeSet(IntegralPo po);

	/**
	 * 删除积分兑换设置
	 * 
	 */
	public void deleteIntegralExchangeSet(IntegralPo po);
	
	/**
	 * 积分兑换详细
	 * 
	 */
	public IntegralPo getIntegralExchangeSetDetail(IntegralPo po);
	
	/**
	 * 积分兑换停用启用
	 * 
	 */
	public void enableIntegralExchangeSet(IntegralPo po);
	
	/**
	 * 积分兑换是否存在
	 * 
	 */
	public int isExistIntegralExchangeSet(IntegralPo po);
	
	/****************************************************************************************************/
	
	/**
	 * 前台套餐开窗
	 */
	public List<SetMealPo> getSetMealOpenCount(SetMealPo po);
	
	/**
	 * 前台套餐开窗
	 */
	public List<SetMealPo> getSetMealOpenList(SetMealPo po, int start, int size);
	
	/**
	 * 前台套餐开窗
	 */
	public List<SetMealEntryPo> getSetMealEntryOpen(SetMealPo po);

	/**
	 * 查询积分兑换汇率
	 */
	public IntegralPo getIntegralCountList(String goodsid);
	/**
	 * 查询积分兑换汇率
	 */
	public IntegralPo getIntegralCountList2(String goodsid,String departmentID,String memberType);
	
	/**
	 * 最大折扣查询（销售使用）
	 * 
	 */
	public MaxDiscountPo selectMaxDiscountSetPo(MaxDiscountPo po);
	
	/**
	 * 审核套餐
	 * 
	 */
	public void updateSetMealAudit(SetMealPo po);
	
	/**
	 * 审核套餐
	 * 
	 */
	public void updateSetMealRecordAudit(SetMealPo po);
	
	/**
	 * 停用启用套餐
	 * 
	 */
	public void updateSetMealAble(SetMealPo po);
	
	/**
	 * 停用启用套餐套餐
	 * 
	 */
	public void updateSetMealRecordAble(SetMealPo po);
	
	/**
	 * 修改套餐活动部门
	 * 
	 */
	public void updateSetMealDepartments(SetMealPo po);
	
	/**
	 * 修改套餐活动部门
	 * 
	 */
	public void updateSetMealRecordDepartments(SetMealPo po);
	
	/**
	 * 复制套餐
	 * 
	 */
	public void insertSetMealCopy(SetMealPo po);
	
	/**
	 * 复制套餐明细
	 * 
	 */
	public void insertSetMealEntryCopy(SetMealPo po);
	
	/**
	 * 根据套餐分类查询商品类型
	 * 
	 */
	public List<SetMealParentPropertyPo> getGoodsCategoryBySetMealClassify(SetMealPo po);
	
	/**
	 * 根据商品类型查看商品属性
	 * 
	 */
	public List<SetMealChildPropertyPo> getGoodsPropertyByGoodsCategory(SetMealEntryPo po);
	
	/**
	 * 根据商品属性查看商品属性值
	 * 
	 */
	public List<SetMealPropertyValuePo> getGoodsPropertyValueByGoodsProperty(SetMealEntryPo po);
	
	public void insertMaxDiscountDetails(MaxDiscountDetailsPo po);
	
	public List<MaxDiscountDetailsPo> selectMaxDiscountDetails(MaxDiscountDetailsPo po);
	
	public void deleteMaxDiscountDetails(String pid);
	
}
