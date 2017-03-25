/**
 * 
 */
package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.storage.persistence.StrogeLogTempPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

/**
 * @author Liuqian
 * 
 */
public interface RefundDao {

	/**
	 * 得到打印镜单信息
	 */
	public List<SalesBasicPo> getSalesBasics(SalesBasicPo salesBasicPo);
	
	
	/**
	 * 得到打印镜单信息
	 */
	public List<SalesBasicPo> getSalesBasics(SalesBasicPo salesBasicPo,SystemParameterPo systemParameterPo,int start, int size);
	
	public int getSalesBasicsCount(SalesBasicPo salesBasicPo,SystemParameterPo systemParameterPo);

	/**
	 * 根据销售单号将信息插入在途明细表中
	 * 
	 * @param inTransitPo
	 */
	public void insertIntrnsitInfo(InTransitPo inTransitPo);

	/**
	 * 更新销售基表中的在途点
	 * 
	 * @param salesDetailPo
	 */
	public void updateMaterialsInTransit(SalesBasicPo salesBasicPo);

//	/**
//	 * 根据销售单号将信息插入当月库存变更表中
//	 * 
//	 * @param strogeChangePo
//	 */
//	public void insertStrogeChange(String salesid, String stockid);

	/**
	 * 根据配镜单号查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo customerInfoPo);

	/**
	 * 更新顾客积分
	 * 
	 * @param customerid
	 * @param integral
	 */
	public void updateCustomerIntegral(SalesBasicPo salesBasicPo);
	
	/**
	 * 退顾客积分
	 * 
	 * @param customerid
	 * @param integral
	 */
	public void updateIntegralAddandSub(SalesBasicPo salesBasicPo);
	
//	public void insertStrogeChangeLog(String salesid, String stockid);

	public SalesBasicPo getSalesBasicPo(String salesID);
	
	public void deleteCustomize(String salesID);

	public void deleteCustomizeTui(String salesID);
	/**
	 * 获取退货信息
	 * 2011-6-9
	 * @param customerid
	 * @param integral
	 */
	public List<StrogeLogTempPo> getSalesDetailList(String salesid,String stockid);
	/**
	 * 插入StrogeLog退货信息
	 * 2011-6-9
	 * @param customerid
	 * @param integral
	 */
	public void insertStrogeLogs(StrogeLogTempPo strogeLogPo);
	
	/**
	 * 更新退款仓位
	 * 2011-6-9
	 * @param customerid
	 * @param integral
	 */
	public void updateInWarehouse(StrogeLogTempPo strogeLogPo);
	
	/**
	 * 插入StrogeChange退货信息
	 * 2011-6-9
	 * @param customerid
	 * @param integral
	 */
	public void insertStrogeChanges(StrogeLogTempPo strogeLogPo);

	/**
	 * 更新当日销售基表中的在途点
	 * 
	 * @param salesDetailPo
	 */
	public void updateMaterialsInTransitToday(SalesBasicPo salesBasicPo);
	
	/**
	 * 查询当日销售基表中是否存在此销售单
	 * 
	 * @param salesDetailPo
	 */
	public int materialsTodayCount(SalesBasicPo salesBasicPo);
	
	/**
	 * 根据配镜单号删除当日销售明细
	 * 
	 * @param salesDetailPo
	 */
	public void deleteMmaterialsToday(SalesBasicPo salesBasicPo);
	
	/**
	 * 更新商品退款标识
	 * 
	 * @param salesDetailPo
	 */
	public void updateSalesDetailGoodsWithdrawFlag(SalesDetailPo po);
	
	/**
	 * 更新今日商品退款标识
	 * 
	 * @param salesDetailPo
	 */
	public void updateSalesDetailGoodsWithdrawFlagToday(SalesDetailPo po);
	
	/**
	 * 新增部分退款单
	 * 
	 * @param salesDetailPo
	 */
	public void insertPartSalesGoodsWithdrawBill(SalesBasicPo po);
	
	/**
	 * 新增部分退款单明细
	 * 
	 * @param salesDetailPo
	 */
	public void insertPartSalesGoodsWithdrawBillEntry(SalesBasicPo po);
	
	/**
	 * 新增部分退款单附加费用
	 * 
	 * @param salesDetailPo
	 */
	public void insertPartSalesGoodsWithdrawAdditional(SalesBasicPo po);
	
	/**
	 * 新增部分退款单加工要求
	 * 
	 * @param salesDetailPo
	 */
	public void insertPartSalesGoodsWithdrawBillSpecialPDetail(SalesBasicPo po);
	
	/**
	 * 查询原配镜单未退款商品的金额
	 * 
	 * @param salesDetailPo
	 */
	public SalesDetailPo getPartSalesGoodsNotWithdrawAmountEntry(SalesBasicPo po);
	
	/**
	 * 更新原配镜单各种金额
	 * 
	 * @param salesDetailPo
	 */
	public void updatePartSalesGoodsWithdrawBillAmount(SalesBasicPo po);
	
	/**
	 * 更新补齐欠款日期
	 */
	public void updateArrearsAppendDate(String salesid);
	
	/**
	 * 
	 * 
	 * @param salesBasicPo
	 * @param inTransitPo
	 */
	public List<SalesLogPo> getSalesLogList(SalesLogPo salesLogPo);
	
	public IntegralAddandSubPo getIntegralAddandSub(IntegralAddandSubPo integralAddandSubPo);
	
}
