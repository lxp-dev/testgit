/**
 * 
 */
package com.pengsheng.eims.sales.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.GoodsCostDiscountDao;
import com.pengsheng.eims.sales.dao.SetMealDao;
import com.pengsheng.eims.sales.mgr.GoodsCostDiscountMgr;
import com.pengsheng.eims.sales.mgr.SetMealMgr;
import com.pengsheng.eims.sales.persistence.SetMealChildPropertyPo;
import com.pengsheng.eims.sales.persistence.SetMealEntryPo;
import com.pengsheng.eims.sales.persistence.SetMealParentPropertyPo;
import com.pengsheng.eims.sales.persistence.SetMealPo;
import com.pengsheng.eims.sales.persistence.SetMealPropertyValuePo;
import com.pengsheng.eims.system.persistence.IntegralPo;
import com.pengsheng.eims.system.persistence.MaxDiscountPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 套餐
 * 
 */
public class GoodsCostDiscountMgrImpl implements GoodsCostDiscountMgr {
	
	private LogisticsLogDao logisticsLogDao;
	private GoodsCostDiscountDao goodsCostDiscountDao;
	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	
	public GoodsCostDiscountDao getGoodsCostDiscountDao() {
		return goodsCostDiscountDao;
	}
	public void setGoodsCostDiscountDao(GoodsCostDiscountDao goodsCostDiscountDao) {
		this.goodsCostDiscountDao = goodsCostDiscountDao;
	}
	/**
	 * 查询套餐总数
	 */
	public int getSetMealCount(SetMealPo po){
		return goodsCostDiscountDao.getSetMealCount(po);
	}
	
	/**
	 * 查询套餐列表
	 */
	public List<SetMealPo> getSetMealList(SetMealPo po, int start, int size){
		return goodsCostDiscountDao.getSetMealList(po, start, size);
	}

	/**
	 * 增加套餐
	 * 
	 */
	public void insertSetMeal(SetMealPo po,List<SetMealEntryPo> salesGoodsArrayList,LogisticsLogPo logPo){
		
		po.setSsmsmid(uuidGenerator.generate());
		goodsCostDiscountDao.insertSetMealRecord(po);
		
		for (SetMealEntryPo poEntry : salesGoodsArrayList){
			
			poEntry.setSsmsgsetmealid(po.getSsmsmid());
			poEntry.setSsmsgid(uuidGenerator.generate());
			
//			poEntry.setSsmsgbigclass("");
//			poEntry.setSsmsgsmallclass("");
			
			goodsCostDiscountDao.insertSetMealRecordEntry(poEntry);
		}
		
		if (Utility.getName(po.getSsmsmauditstate()).equals("1")){
			
			goodsCostDiscountDao.insertSetMeal(po);
			goodsCostDiscountDao.insertSetMealEntry(po);
		}
		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 更新套餐
	 * 
	 */
	public void updateSetMeal(SetMealPo po,List<SetMealEntryPo> poEntryList,LogisticsLogPo logPo){
		
		goodsCostDiscountDao.deleteSetMealRecordEntry(po);

		goodsCostDiscountDao.updateSetMealRecord(po);
		
		for (SetMealEntryPo poEntry : poEntryList){
			
			poEntry.setSsmsgsetmealid(po.getSsmsmid());
			goodsCostDiscountDao.insertSetMealRecordEntry(poEntry);
		}
		
		if (Utility.getName(po.getSsmsmauditstate()).equals("1")){
			
			goodsCostDiscountDao.insertSetMeal(po);
			goodsCostDiscountDao.insertSetMealEntry(po);
		}
		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 删除套餐
	 * 
	 */
	public void deleteSetMeal(SetMealPo po,LogisticsLogPo logPo){
		
		goodsCostDiscountDao.deleteSetMeal(po);
		goodsCostDiscountDao.deleteSetMealEntry(po);
		
		goodsCostDiscountDao.deleteSetMealRecord(po);
		goodsCostDiscountDao.deleteSetMealRecordEntry(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 套餐详细
	 * 
	 */
	public SetMealPo getSetMealDetail(SetMealPo po){
		return goodsCostDiscountDao.getSetMealDetail(po);
	}
	
	/**
	 * 套餐商品详细
	 * 
	 */
	public List<SetMealEntryPo> getSetMealEntryDetail(SetMealPo po){
		return goodsCostDiscountDao.getSetMealEntryDetail(po);
	}
	
	/**
	 * 查询套餐商品总数
	 */
	public int getGoodsCount(GoodsInfoPo po){
		if (Utility.getName(po.getQueryType()).equals("1")){
			return goodsCostDiscountDao.getSupplierCount(po);
		}else if (Utility.getName(po.getQueryType()).equals("2")){
			return goodsCostDiscountDao.getBrandCount(po);
		}else {
			return goodsCostDiscountDao.getGoodsCount(po);
		}
	}
	
	/**
	 * 查询套餐商品列表
	 */
	public List<GoodsInfoPo> getGoodsList(GoodsInfoPo po, int start, int size){
		if (Utility.getName(po.getQueryType()).equals("1")){
			return goodsCostDiscountDao.getSupplierList(po, start, size);
		}else if (Utility.getName(po.getQueryType()).equals("2")){
			return goodsCostDiscountDao.getBrandList(po, start, size);
		}else {
			return goodsCostDiscountDao.getGoodsList(po, start, size);
		}
	}

	/**********************************************************************************************************/

	/**
	 * 查询积分累计规则总数
	 */
	public int getIntegralSetCount(IntegralPo po){
		return goodsCostDiscountDao.getIntegralSetCount(po);
	}
	
	/**
	 * 查询积分累计规则列表
	 */
	public List<IntegralPo> getIntegralSetList(IntegralPo po, int start, int size){
		return goodsCostDiscountDao.getIntegralSetList(po,start,size);
	}

	/**
	 * 增加积分累计规则
	 * 
	 */
	public void insertIntegralSet(IntegralPo po,LogisticsLogPo logPo){
		goodsCostDiscountDao.insertIntegralSet(po);		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 更新积分累计规则
	 * 
	 */
	public void updateIntegralSet(IntegralPo po,LogisticsLogPo logPo){
		goodsCostDiscountDao.updateIntegralSet(po);		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 删除积分累计规则
	 * 
	 */
	public void deleteIntegralSet(IntegralPo po,LogisticsLogPo logPo){
		goodsCostDiscountDao.deleteIntegralSet(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 批量更新积分累计规则
	 * 
	 */
	public void updateBatchIntegralSet(IntegralPo po,LogisticsLogPo logPo){
		
		String[] ids = Utility.getName(po.getFirID()).split(",");
		for (int i = 0; i < ids.length; i++){
			IntegralPo tmp = new IntegralPo();
			tmp.setFirID(ids[i]);
			tmp.setFirIntegralCount(po.getFirIntegralCount());
			
			goodsCostDiscountDao.updateBatchIntegralSet(tmp);
		}
		logisticsLogDao.insertLog(logPo);		
	}

	/**
	 * 批量删除积分累计规则
	 * 
	 */
	public void deleteBatchIntegralSet(IntegralPo po,LogisticsLogPo logPo){
	
		String[] ids = Utility.getName(po.getFirID()).split(",");
		for (int i = 0; i < ids.length; i++){
			IntegralPo tmp = new IntegralPo();
			tmp.setFirID(ids[i]);
			
			goodsCostDiscountDao.deleteIntegralSet(tmp);
		}
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 查询商品总数
	 */
	public int getGoodsCount(IntegralPo po){
		return goodsCostDiscountDao.getGoodsCount(po);
	}
	
	/**
	 * 查询商品列表
	 */
	public List<GoodsInfoPo> getGoodsList(IntegralPo po, int start, int size){
		return goodsCostDiscountDao.getGoodsList(po,start,size);
	}
	
	/**
	 * 查询商品列表
	 */
	public List<GoodsInfoPo> getGoodsList(IntegralPo po){
		return goodsCostDiscountDao.getGoodsList(po);
	}
	
	/**********************************************************************************************************/
	/**********************************************************************************************************/

	/**
	 * 查询最大折扣设置总数
	 */
	public int getMaxDiscountSetCount(MaxDiscountPo po){
		return goodsCostDiscountDao.getMaxDiscountSetCount(po);
	}
	
	/**
	 * 查询最大折扣设置列表
	 */
	public List<MaxDiscountPo> getMaxDiscountSetList(MaxDiscountPo po, int start, int size){
		return goodsCostDiscountDao.getMaxDiscountSetList(po,start,size);
	}

	/**
	 * 增加最大折扣设置
	 * 
	 */
	public void insertMaxDiscountSet(MaxDiscountPo po,LogisticsLogPo logPo){
		goodsCostDiscountDao.insertMaxDiscountSet(po);		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 更新最大折扣设置
	 * 
	 */
	public void updateMaxDiscountSet(MaxDiscountPo po,LogisticsLogPo logPo){
		goodsCostDiscountDao.updateMaxDiscountSet(po);		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 删除最大折扣设置
	 * 
	 */
	public void deleteMaxDiscountSet(MaxDiscountPo po,LogisticsLogPo logPo){
		goodsCostDiscountDao.deleteMaxDiscountSet(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 批量更新最大折扣设置
	 * 
	 */
	public void updateBatchMaxDiscountSet(MaxDiscountPo po,LogisticsLogPo logPo){
		
		String[] ids = Utility.getName(po.getFmdid()).split(",");
		for (int i = 0; i < ids.length; i++){
			MaxDiscountPo tmp = new MaxDiscountPo();
			tmp.setFmdid(ids[i]);
			tmp.setFmdmaxdiscount(po.getFmdmaxdiscount());
			
			goodsCostDiscountDao.updateBatchMaxDiscountSet(tmp);
		}
		logisticsLogDao.insertLog(logPo);		
	}

	/**
	 * 批量删除最大折扣设置
	 * 
	 */
	public void deleteBatchMaxDiscountSet(MaxDiscountPo po,LogisticsLogPo logPo){
	
		String[] ids = Utility.getName(po.getFmdid()).split(",");
		for (int i = 0; i < ids.length; i++){
			MaxDiscountPo tmp = new MaxDiscountPo();
			tmp.setFmdid(ids[i]);
			
			goodsCostDiscountDao.deleteMaxDiscountSet(tmp);
		}
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 最大折扣设置详细
	 * 
	 */
	public MaxDiscountPo getMaxDiscountSetDetail(MaxDiscountPo po){
		return goodsCostDiscountDao.getMaxDiscountSetDetail(po);
	}
	
	/**
	 * 最大折扣设置是否存在
	 * 
	 */
	public int isExistMaxDiscountSet(MaxDiscountPo po){
		return goodsCostDiscountDao.isExistMaxDiscountSet(po);
		 
	}
	
	
	/**********************************************************************************************************/
	/**********************************************************************************************************/
	
	
	/**
	 * 查询积分兑换设置总数
	 */
	public int getIntegralExchangeSetCount(IntegralPo po){
		return goodsCostDiscountDao.getIntegralExchangeSetCount(po);
	}
	
	/**
	 * 查询积分兑换设置列表
	 */
	public List<IntegralPo> getIntegralExchangeSetList(IntegralPo po, int start, int size){
		return goodsCostDiscountDao.getIntegralExchangeSetList(po,start,size);
	}

	/**
	 * 增加积分兑换设置
	 * 
	 */
	public void insertIntegralExchangeSet(List<IntegralPo> poList,LogisticsLogPo logPo){
		for (IntegralPo po : poList){
			goodsCostDiscountDao.insertIntegralExchangeSet(po);
		}		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 积分累计规则详细
	 * 
	 */
	public IntegralPo getIntegralSetDetail(IntegralPo po){
		return goodsCostDiscountDao.getIntegralSetDetail(po);
	}
	
	/**
	 * 累计规则编号是否存在
	 * 
	 */
	public int isExistIntegralSet(IntegralPo po){
		return goodsCostDiscountDao.isExistIntegralSet(po);
	}
	
	/**
	 * 更新积分兑换设置
	 * 
	 */
	public void updateIntegralExchangeSet(IntegralPo po,LogisticsLogPo logPo){
		goodsCostDiscountDao.updateIntegralExchangeSet(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 删除积分兑换设置
	 * 
	 */
	public void deleteIntegralExchangeSet(IntegralPo po,LogisticsLogPo logPo){
		goodsCostDiscountDao.deleteIntegralExchangeSet(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 积分兑换详细
	 * 
	 */
	public IntegralPo getIntegralExchangeSetDetail(IntegralPo po){
		return goodsCostDiscountDao.getIntegralExchangeSetDetail(po);
	}
	
	/**
	 * 积分兑换停用启用
	 * 
	 */
	public void enableIntegralExchangeSet(IntegralPo po,LogisticsLogPo logPo){
		goodsCostDiscountDao.enableIntegralExchangeSet(po);
		logisticsLogDao.insertLog(logPo);
	}	
	
	/**
	 * 判断积分兑换是否存在
	 * 
	 */
	public int isExistIntegralExchangeSet(IntegralPo po){
		return goodsCostDiscountDao.isExistIntegralExchangeSet(po);
	}	

	/**
	 * 前台套餐开窗
	 */
	public List<SetMealPo> getSetMealOpenCount(SetMealPo po){
		return goodsCostDiscountDao.getSetMealOpenCount(po);
	}
	
	/**
	 * 前台套餐开窗
	 */
	public List<SetMealPo> getSetMealOpenList(List<SetMealPo> poList,List<SetMealPo> idList,String goodsamount,int start, int size){
		
		List<SetMealPo> list = new ArrayList<SetMealPo>();
		for (SetMealPo po : idList){
			List<SetMealPo> tmp = goodsCostDiscountDao.getSetMealOpenList(po,start,size);
			for (SetMealPo po2 : tmp){
				list.add(po2);
			}
		}
        
		SetMealPo po = new SetMealPo();
		StringBuffer ssmsmid = null;
		StringBuffer ssmsmentryid = null;
		StringBuffer ssmsmgoodsid = null;
		StringBuffer ssmsmgoodsnum = null;
		List<SetMealEntryPo> goodsList = null;
		List<SetMealEntryPo> goodsList2 = null;
		
		for (int j = 0; j < idList.size(); j++){
			
			ssmsmid = new StringBuffer();
			ssmsmentryid = new StringBuffer();
			ssmsmgoodsid = new StringBuffer();
			ssmsmgoodsnum = new StringBuffer();
			
		    for (int i = 0; i < poList.size(); i++){
		    	if (idList.get(j).getSsmsmid().equals(poList.get(i).getSsmsmid())){
			    	ssmsmid.append(Utility.getName(poList.get(i).getSsmsmid())+",");
			    	ssmsmgoodsid.append(Utility.getName(poList.get(i).getSsmsmgoodsid())+",");
			    	ssmsmentryid.append(Utility.getName(poList.get(i).getSsmsmentryid())+",");
			    	ssmsmgoodsnum.append(Utility.getName(poList.get(i).getSsmsmgoodsnum())+",");
		    	}
		    }
		    
			po.setSsmsmid(ssmsmid.toString());
			po.setSsmsmgoodsid(ssmsmgoodsid.toString());
			po.setSsmsmentryid(ssmsmentryid.toString());
			po.setSsmsmsalesamount(goodsamount);
			po.setSsmsmgoodsnum(ssmsmgoodsnum.toString());
			
			goodsList = goodsCostDiscountDao.getSetMealEntryOpen(po);
	        
			for (int i = 0; i < list.size(); i++){
				
				goodsList2 = new ArrayList<SetMealEntryPo>();
				
				for (int k = 0; k < goodsList.size(); k++){
					if (list.get(i).getSsmsmid().equals(goodsList.get(k).getSsmsgsetmealid())){
						goodsList2.add(goodsList.get(k));
					}
				}
				
				if (goodsList2.size() > 0){
					list.get(i).setSetMealEntryList(goodsList2);
				}
			}
			
		}
		
		return list;
	}
	
	/**
	 * 最大折扣查询（销售使用）
	 * 
	 */
	public MaxDiscountPo selectMaxDiscountSetPo(MaxDiscountPo po){
		return goodsCostDiscountDao.selectMaxDiscountSetPo(po);
	}
	
	/**
	 * 审核套餐
	 * 
	 */
	public void updateSetMealAudit(SetMealPo po,LogisticsLogPo logPo){

		goodsCostDiscountDao.updateSetMealRecordAudit(po);
		
		goodsCostDiscountDao.insertSetMeal(po);
		goodsCostDiscountDao.insertSetMealEntry(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 反审核套餐
	 * 
	 */
	public void updateSetMealUnAudit(SetMealPo po,LogisticsLogPo logPo){

		goodsCostDiscountDao.updateSetMealUnAudit(po);
		
		goodsCostDiscountDao.deleteSetMeal(po);
		goodsCostDiscountDao.deleteSetMealEntry(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 停用套餐
	 * 
	 */
	public void updateSetMealAble(SetMealPo po,LogisticsLogPo logPo){

		goodsCostDiscountDao.updateSetMealRecordAble(po);
		
		goodsCostDiscountDao.deleteSetMeal(po);
		goodsCostDiscountDao.deleteSetMealEntry(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 修改套餐活动部门
	 * 
	 */
	public void updateSetMealDepartments(SetMealPo po,LogisticsLogPo logPo){
		
		goodsCostDiscountDao.updateSetMealDepartments(po);
		goodsCostDiscountDao.updateSetMealRecordDepartments(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 复制套餐
	 * 
	 */
	public void insertSetMealCopy(SetMealPo po,LogisticsLogPo logPo){
		
		goodsCostDiscountDao.insertSetMealCopy(po);
		goodsCostDiscountDao.insertSetMealEntryCopy(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 根据套餐分类查询商品类型
	 * 
	 */
	public List<SetMealParentPropertyPo> getGoodsCategoryBySetMealClassify(SetMealPo po){
		return goodsCostDiscountDao.getGoodsCategoryBySetMealClassify(po);
	}
	
	/**
	 * 根据商品类型查看商品属性
	 * 
	 */
	public List<SetMealChildPropertyPo> getGoodsPropertyByGoodsCategory(SetMealEntryPo po){
		return goodsCostDiscountDao.getGoodsPropertyByGoodsCategory(po);
	}
	
	/**
	 * 根据商品属性查看商品属性值
	 * 
	 */
	public List<SetMealPropertyValuePo> getGoodsPropertyValueByGoodsProperty(SetMealEntryPo po){
		return goodsCostDiscountDao.getGoodsPropertyValueByGoodsProperty(po);
	}
	
}
