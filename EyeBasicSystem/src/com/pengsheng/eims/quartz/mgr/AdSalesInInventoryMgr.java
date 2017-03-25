package com.pengsheng.eims.quartz.mgr;

import java.text.ParseException;
import java.util.List;

import com.pengsheng.eims.system.persistence.QuartzLogPo;

public interface AdSalesInInventoryMgr {
	
	/**
	 * 汇总销售出库单
	 * 
	 */
	public void insertCollectSalesOutStorageBill(String bgnDate,String endDate);
	
	/**
	 * 客户批发调货汇总销售出库单、积分兑换汇总销售出库单
	 * 
	 */
	public void insertFromOtherBillToSalesOutStorageBill(String bgnDate,String endDate);
	
	
	/**
	 * 检查人员工作量统计表（单店）
	 * 
	 */
	public void insertInspectPersonWorkload(String bgnDate,String endDate,QuartzLogPo logPo);

	/**
	 * 取镜人员工作量统计表（单店）
	 * 
	 */
	public void insertGetBackEyeglassPersonWorkload(String bgnDate,String endDate,QuartzLogPo logPo);
	
	/**
	 * 加工人员工作量统计（单店）
	 * 
	 */
	public void insertProcessWorkingStatisticsWorkload(String bgnDate,String endDate,QuartzLogPo logPo);
	
	
	/**
	 * 发料人员工作量统计表（单店）
	 * 
	 */
	public void insertSendMaterialWorkload(String bgnDate,String endDate,QuartzLogPo logPo);
	
	
	
	/**
	 * 营业员工作量统计表（单店）
	 * 
	 */
	public void insertSalesPersonQTWorkload(String bgnDate,String endDate,QuartzLogPo logPo,String jkflag,String bqflag);
	
	
	/**
	 * 汇总收银员工作量统计
	 */
	public void insertCashierWorkload(String bgnDate,String endDate,QuartzLogPo logPo,String jkflag,String bqflag);
	
	/**
	 * 汇总挂号台工作量统计
	 */
	public void insertRegistrationDeskWorkload(String bgnDate,String endDate,QuartzLogPo logPo);

	/**
	 * 商品销售统计表
	 */
	public void insertGoodsSalesAnalysis(String bgnDate,String endDate,QuartzLogPo logPo);
	
	/**
	 * 清空当日销售数据
	 */
	public void deleteTodaySalesData(QuartzLogPo logPo);
	
	/**
	 * 自动进行成本计算
	 */
	public void insertAutoCostAccountJob(String billDate,QuartzLogPo logPo);
	
	/**
	 * 验光师工作量统计表（单店）
	 */
	public void insertOptometryWorkload(String bgnDate,String endDate,QuartzLogPo logPo,String flag);
	
	/**
	 * 自动进行会员升级
	 */
	public void insertAutoCustomerUpGradeJob(QuartzLogPo logPo);
	
	/**
	 * 日销售汇总表统计
	 */
	public void insertDayCollect(String bgnDate,String endDate,QuartzLogPo logPo);
	
	/**
	 * 日商品类别销售汇总表统计
	 */
	public void insertDayCollectEntry(String bgnDate,String endDate,QuartzLogPo logPo);
	
	/**
	 * 日商品类别区间销售汇总表统计
	 */
	public void insertDayCollectAreaEntry(String bgnDate,String endDate,QuartzLogPo logPo);
	
	/**
	 * 日商品销售明细表统计
	 */
	public void insertDaySalesEntry(String bgnDate,String endDate,QuartzLogPo logPo,String jkfalg,String bqflag);
	
	/**
	 * 判断套餐是否过期
	 */
	public void updateSetMealOverdue(String date,QuartzLogPo logPo);

	/**
	 * 销售产品同期综合对比分析(隐形镜片分析)
	 */
	public void insertStoreCustomerFlowEntry(String bgnDate,String endDate,QuartzLogPo logPo);
	
	/**
	 * 商品调价定时器
	 */
	public void updateAadjustmentPriceEffective(String date,QuartzLogPo logPo);
	
	/**
	 * 成本调价定时器
	 */
	public void updateAdcostPriceEffective(String date,QuartzLogPo logPo);
	
	/**
	 * 商品批发调价定时器
	 */
	public void updateWholesalePriceEffective(String date,QuartzLogPo logPo);
	
	/**
	 * 商品批发调价定时器
	 */
	public void updateAdConsignProcessTakeJob(String date,QuartzLogPo logPo);
	
	/**
	 * 库存汇总定时器
	 */
	public void updateStockSummary(QuartzLogPo logPo);
	
	/**
	 * 商品库存周转率统计表（按库存）
	 */
	public void insertGoodsStorageRevolveRate(String bgnDate,String endDate,QuartzLogPo logPo);
	
	/**
	 * 品种库存周转率统计表（按库存）
	 */
	public void insertBrandStorageRevolveRate(String bgnDate,String endDate,QuartzLogPo logPo);
	
	/**
	 * 商品库存周转率统计表（按单据）
	 */
	public void insertGoodsStorageRevolveRateByBill(String bgnDate,String endDate,QuartzLogPo logPo);
	
	/**
	 * 新增时英日志
	 */
	public void insertQuartzExecLog(QuartzLogPo logPo);
	
	/**
	 * 修改时英日志
	 */
	public void updateQuartzExecLog(QuartzLogPo logPo);
	
	/**
	 * 查看未执行的任务
	 */
	public List<QuartzLogPo> getQuartzExecLog(QuartzLogPo qpo);
	
	/**
	 * 汇总隐形、护理液的库存
	 */
	public void insertCollectStealthStorage();
	
	/**
	 * 汇总客单价统计表
	 */
	public void insertPerCustomer(String bgnDate,String endDate,QuartzLogPo logPo);
	
	/**
	 * 分店销售指南表
	 */
	public void collectEachShopSalesGuide(String bgnDate,String endDate,QuartzLogPo logPo);
	
	/**
	 * 自动关账和创建临时凭证表
	 */
	public void switchAmount();

	/**
	 * 按日期、仓位、单据类型汇总历史库存
	 */
	public void updateStroageByDateAndBillType(String bgnDate,String endDate,QuartzLogPo logPo);

	/**
	 * 日品种销售明细表统计
	 */
	public void insertDayBrandSalesEntry(String bgnDate,String endDate,QuartzLogPo logPo,String jkfalg,String bqflag);
	
	/**
	 * 汇总销售出库
	 */
	public void insertSalesOutBillByDate(String bgnDate,String endDate,QuartzLogPo logPo);
	
	
	
}
