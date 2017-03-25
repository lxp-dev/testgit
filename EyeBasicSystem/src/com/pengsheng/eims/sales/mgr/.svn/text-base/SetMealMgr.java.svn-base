/**
 * 
 */
package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
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
public interface SetMealMgr {

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
	public void insertSetMeal(SetMealPo po,List<SetMealEntryPo> salesGoodsArrayList,LogisticsLogPo logPo);

	/**
	 * 更新套餐
	 * 
	 */
	public void updateSetMeal(SetMealPo po,List<SetMealEntryPo> poEntryList,LogisticsLogPo logPo);

	/**
	 * 删除套餐
	 * 
	 */
	public void deleteSetMeal(SetMealPo po,LogisticsLogPo logPo);
	
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
	
	/**********************************************************************************************************/

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
	public void insertIntegralSet(IntegralPo po,LogisticsLogPo logPo);
	
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
	 * 更新积分累计规则
	 * 
	 */
	public void updateIntegralSet(IntegralPo po,LogisticsLogPo logPo);

	/**
	 * 删除积分累计规则
	 * 
	 */
	public void deleteIntegralSet(IntegralPo po,LogisticsLogPo logPo);
	
	/**
	 * 批量更新积分累计规则
	 * 
	 */
	public void updateBatchIntegralSet(IntegralPo po,LogisticsLogPo logPo);

	/**
	 * 批量删除积分累计规则
	 * 
	 */
	public void deleteBatchIntegralSet(IntegralPo po,LogisticsLogPo logPo);	

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
	
	/**********************************************************************************************************/
	
	/**********************************************************************************************************/

	/**
	 * 查询积分累计规则总数
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
	public void insertMaxDiscountSet(MaxDiscountPo po,MaxDiscountDetailsPo mpo,LogisticsLogPo logPo);
	
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

	/**
	 * 更新最大折扣设置
	 * 
	 */
	public void updateMaxDiscountSet(MaxDiscountPo po,MaxDiscountDetailsPo mpo,LogisticsLogPo logPo);

	/**
	 * 删除最大折扣设置
	 * 
	 */
	public void deleteMaxDiscountSet(MaxDiscountPo po,LogisticsLogPo logPo);
	
	/**
	 * 批量更新最大折扣设置
	 * 
	 */
	public void updateBatchMaxDiscountSet(MaxDiscountPo po,MaxDiscountDetailsPo mpo,LogisticsLogPo logPo);

	/**
	 * 批量删除最大折扣设置
	 * 
	 */
	public void deleteBatchMaxDiscountSet(MaxDiscountPo po,LogisticsLogPo logPo);	

	
	/**********************************************************************************************************/
	/**********************************************************************************************************/
	
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
	public void insertIntegralExchangeSet(List<IntegralPo> poList,LogisticsLogPo logPo);

	/**
	 * 更新积分兑换设置
	 * 
	 */
	public void updateIntegralExchangeSet(IntegralPo po,LogisticsLogPo logPo);

	/**
	 * 删除积分兑换设置
	 * 
	 */
	public void deleteIntegralExchangeSet(IntegralPo po,LogisticsLogPo logPo);	
	
	/**
	 * 积分兑换详细
	 * 
	 */
	public IntegralPo getIntegralExchangeSetDetail(IntegralPo po);
	
	/**
	 * 积分兑换停用启用
	 * 
	 */
	public void enableIntegralExchangeSet(IntegralPo po,LogisticsLogPo logPo);
	
	/**
	 * 判断积分兑换是否存在
	 * 
	 */
	public int isExistIntegralExchangeSet(IntegralPo po);
	
	/******************************************************************************************************/
	
	/**
	 * 前台套餐开窗
	 */
	public List<SetMealPo> getSetMealOpenCount(SetMealPo po);
	
	/**
	 * 前台套餐开窗
	 */
	public List<SetMealPo> getSetMealOpenList(List<SetMealPo> poList,List<SetMealPo> idList,String goodsamount,int start, int size);

	/**
	 * 最大折扣查询（销售使用）
	 * 
	 */
	public MaxDiscountPo selectMaxDiscountSetPo(MaxDiscountPo po);
	
	/**
	 * 审核套餐
	 * 
	 */
	public void updateSetMealAudit(SetMealPo po,LogisticsLogPo logPo);
	
	/**
	 * 反审核套餐
	 * 
	 */
	public void updateSetMealUnAudit(SetMealPo po,LogisticsLogPo logPo);
	
	/**
	 * 停用启用套餐
	 * 
	 */
	public void updateSetMealAble(SetMealPo po,LogisticsLogPo logPo);
	
	/**
	 * 复制套餐
	 * 
	 */
	public void insertSetMealCopy(SetMealPo po,LogisticsLogPo logPo);
	
	/**
	 * 修改套餐活动部门
	 * 
	 */
	public void updateSetMealDepartments(SetMealPo po,LogisticsLogPo logPo);
	
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
