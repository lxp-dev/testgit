package com.pengsheng.eims.quartz.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.AutoCostAccountPo;
import com.pengsheng.eims.sales.persistence.SalesAreaPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;

public interface AdSalesInInventoryDao {
	
	/**
	 * 取门店号
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentList(String date);
	public List<DepartmentsPo> getAppendArrearsDepartmentList(String date);
	
	/**
	 * 取销售详细信息
	 * @return
	 */
	public List<InventoryEntryPo> getSalesEntry(String departmentid);
	
	/**
	 * 将销售基表数据汇总到业务主表
	 * @param billID
	 */
	public void insertSalesInInventory(String billID , String departmentid);
	
	/**
	 * 将销售明细表数据汇总到业务明细表
	 * @param billID
	 */
	public void insertSalesInInventoryEntry(InventoryEntryPo inventoryEntryPo , String billID , String departmentid);

	/**
	 * 汇总销售出库单
	 * 
	 */
	public void collectSalesOutStorageBill(String bgnDate,String endDate);
	public void collectSalesOutStorageBill_AppendArrears(String bgnDate,String endDate);
	public void collectSalesOutStorageBill_YK_AppendArrears(String bgnDate,String endDate);
	public void collectSalesOutStorageBill_YK(String bgnDate,String endDate);

	/**
	 * 客户批发调货汇总销售出库单、积分兑换汇总销售出库单
	 * 
	 */
	public void insertFromOtherBillToSalesOutStorageBill(String bgnDate,String endDate);
	
	/**
	 * 汇总收银员工作量统计
	 */
	public void insertCashierWorkload(ModulePo po);
	public void insertCashierWorkloadAppendArrears(ModulePo po);
	
	/**
	 * 汇总挂号台工作量统计
	 */
	public void insertRegistrationDeskWorkload(ModulePo po);
	
	/**
	 * 检查人员工作量统计表（单店）
	 * 
	 */
	public void insertInspectPersonWorkload(ModulePo po);

	/**
	 * 取镜人员工作量统计表（单店）
	 * 
	 */
	public void insertGetBackEyeglassPersonWorkload(ModulePo po);
	
	
	/**
	 * 加工人员工作量统计（单店）
	 * 
	 */
	public void insertProcessWorkingStatisticsWorkload(ModulePo po);
	
	/**
	 * 发料人员工作量统计表（单店）
	 * 
	 */
	public void insertSendMaterialWorkload(ModulePo po);
	
	/**
	 * 营业员工作量统计表（单店）
	 * 
	 */
	public void insertSalesPersonQTWorkload(ModulePo po);
	public void insertSalesPersonQTWorkloadAppendArrears(ModulePo po);
	
	/**
	 * 商品销售统计表
	 */
	public void insertGoodsSalesAnalysis(ModulePo po);

	/**
	 * 清空当日销售数据
	 */
	public void deleteTodaySalesData();
	
	/**
	 * 清空当日销售数据
	 */
	public void deleteTodaySalesDataEntry();
	
	/**
	 * 取所有加工部门
	 * @return
	 * 修改记录: SZK
	 */
	public List<DepartmentsPo> getProcessWorkingDepartmentList();
	
	/**
	 * 取所有发料部门
	 * @return
	 * 修改记录: SZK
	 */
	public List<DepartmentsPo> getSendMaterialDepartmentList();
	
	/**
	 * 自动进行成本计算
	 */
	public int autoCostAccountJob(String date);
	
	public List<AutoCostAccountPo> selCurrentAccountPeriod();
	
	/**
	 * 自动进行成本计算完成
	 */
	public void autoCostAccountFinish(String date);
	
	/**
	 * 验光师工作量统计表（单店）
	 * 
	 */
	public void insertOptometryWorkload(ModulePo po);
	public void insertOptometryWorkload_Tr(ModulePo po);
	
	/**
	 * 日销售汇总表统计
	 * 
	 */
	public void insertDayCollect(ModulePo po);
	
	/**
	 * 日商品类别销售汇总表统计
	 * 
	 */
	public void insertDayCollectEntry(ModulePo po);
	
	/**
	 * 日商品类别区间销售汇总表统计
	 * 
	 */
	public void insertDayCollectAreaEntry(ModulePo po,List<SalesAreaPo> saList);
	
	/**
	 * 获取【日商品类别区间销售汇总表】中价格区间
	 * 
	 */
	public List<SalesAreaPo> getDayCollectArea();
	
	/**
	 * 价位段销售分析报表
	 * @param date
	 * @param departmentID
	 */
	public void insertDayCollectSalesPriceAreaEntry(String date,String departmentID);
	
	/**
	 * 日商品销售明细表统计
	 * 
	 */
	public void insertDaySalesEntry(ModulePo po);
	
	/**
	 * 日商品销售明细表统计(补齐)
	 * 
	 */
	public void insertDaySalesEntryAppendArrears(ModulePo po);
	
	/**
	 * 刷新商品进销存表加权平均成本（按公司）
	 * 
	 */
	public void updateGoodsInOrOutStorage(GoodsInfoPo po);
	
	/**
	 * 刷新商品进销存表加权平均成本（按部门）
	 * 
	 */
	public void updateGoodsInOrOutStorageByDpt(GoodsInfoPo po);
	
	/**
	 * 汇总商品进销存表数据
	 * 
	 */
	public void insertCollectGoodsInOrOutStorage(String date);
	
	/**
	 * 判断套餐是否过期
	 */
	public void updateSetMealOverdue(String date);

	
	/**
	 * 销售产品同期综合对比分析(隐形镜片分析)
	 */
	public void insertStoreCustomerFlowEntry(ModulePo po);
	
	/**
	 * 商品库存周转率统计表
	 */
	public void insertGoodsStorageRevolveRate(ModulePo po);	
	/**
	 * 商品库存周转率统计表
	 */
	public void insertGoodsStorageRevolveRateTemp(String date);	
	
	/**
	 * 商品库存周转率统计表按单据
	 */
	public void insertGoodsStorageRevolveRateBill(String date);	
	/**
	 * 商品库存周转率统计表按单据
	 */
	public void insertGoodsStorageRevolveRateBillTemp(String date);	
	/**
	 * 新增时英日志
	 */
	public void insertQuartzExecLog(QuartzLogPo logPo);
	
	/**
	 * 更新时英日志
	 */
	public void updateQuartzExecLog(QuartzLogPo logPo);
	
	/**
	 * 查看未执行的任务
	 */
	public List<QuartzLogPo> getQuartzExecLog(QuartzLogPo po);
	
	/**
	 * 配镜单汇总生成采购收货单
	 */
	public List<SalesDetailPo> getSalesDetailList(String flag);
	
	/**
	 * 更新配镜单汇总生成采购收货单的标识
	 */
	public void updateSalesDetail(String flag);
	
	/**
	 * 配镜单汇总
	 */
	public void inertAutoPurchaseBillFromSalesBill(InventoryPo po);
	
	/**
	 * 配镜单汇总
	 */
	public void inertAutoInventoryBillFromSalesBill(InventoryPo po);
	
	/**
	 * 配镜单汇总明细
	 */
	public void inertAutoPurchaseBillEntryFromSalesBill(InventoryEntryPo po);
	
	/**
	 * 配镜单汇总明细
	 */
	public void inertAutoInventoryBillEntryFromSalesBill(InventoryEntryPo po);
	
	/**
	 * 配镜单汇总
	 */
	public void inertAutoPurchaseBillToStrogeChange(InventoryEntryPo po);
	
	/**
	 * 配镜单汇总
	 */
	public void inertAutoPurchaseBillToStrogeLog(InventoryEntryPo po);
	
	/**
	 * 记录汇总生成采购单的配镜单号
	 */
	public void insertCollectPurchaseBillBySalesBill(ExternalAccountParameterPo epo);
	
	/**
	 * 汇总周转率报表的库存
	 */
	public void insertCollectZZLStorage();
	
	/**
	 * 按商品类型汇总库存
	 */
	public void insertCollectGoodsTypeStorage();
	
	/**
	 * 汇总客单价统计表
	 */
	public void insertPerCustomer(ModulePo po);
	
	/**
	 * 根据当前账期计算自动创建凭证数据的日期
	 */
	public String getCurrentAccountPeriodDate();
	/**
	 * 分店销售指南表
	 */
	public void collectEachShopSalesGuide(ModulePo po);
	
	/**
	 * 分店销售指南表（隐形店）
	 */
	public void collectStealthShopSalesGuide(ModulePo po);
	
	/**
	 * 自动关账
	 */
	public void switchAmount();
	/**
	 * 创建临时凭证表
	 */
	public void createTempVoucherTab();
	
	/**
	 * 清空当日营业员收银员记录
	 */
	public void deleteTodaySalerCashierRecord();
	
	/**
	 * 清空当日营业员收银员记录（补齐）
	 */
	public void deleteTodaySalerCashierRecordAppendArrears();

	public AutoCostAccountPo getCurrentAccountPeriodDateArea(String date);

	/**
	 * 品种库存周转率统计表
	 */
	public void insertBrandStorageRevolveRate(ModulePo po);

	public List<AutoCostAccountPo> selCurrentAccountPeriodOneCompany();

	/**
	 * 日品种销售明细表统计
	 * 
	 */
	public void insertDayBrandSalesEntry(ModulePo po);

	public void autoCostAccountFinish(String date,String companyID);
	
	/**
	 * 按日期、仓位、单据类型汇总历史库存
	 */
	public void updateStroageByDateAndBillType(String bgnDate,String endDate);
		
	/**
	 * 汇总销售出库
	 */
	public void deleteSalesOutBillByDate(String bgnDate,String endDate);
	
	/**
	 * 商品库存周转率统计表（按单据）
	 */
	public void insertGoodsStorageRevolveRateByBill(ModulePo po);	
	
	/**
	 * 汇总周转率报表的库存
	 */
	public void insertCollectZZLStorageByBill(String bgnDate,String endDate);
	
}
