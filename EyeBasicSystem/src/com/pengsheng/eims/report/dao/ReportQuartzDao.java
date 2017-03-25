package com.pengsheng.eims.report.dao;

import java.util.List;

import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;

public interface ReportQuartzDao {
	
	/**
	 * 查询石英对应的报表
	 * @return
	 */
	public List<ModulePo> getReportInfoByQuartz(ModulePo po);
	
	/**
	 * 删除收银员工作量报表数据
	 */
    public void deleteCashierWorkload(ModulePo po);
    public void deleteCashierWorkloadAppendArrears(ModulePo po);
    
	/**
	 * 删除挂号台工作量报表数据
	 */
    public void deleteRegistrationDeskWorkload(ModulePo po);
    
	/**
	 * 删除检查人员工作量报表数据
	 */
    public void deleteInspectPersonWorkload(ModulePo po);
    
	/**
	 * 删除取镜人员工作量报表数据
	 */
    public void deleteGetBackEyeglassPersonWorkload(ModulePo po);
    
    
	/**
	 * 删除加工人员工作量报表数据
	 */
    public void deleteProcessWorkingStatisticsWorkload(ModulePo po);
    
    
	/**
	 * 删除发料人员工作量报表数据
	 */
    public void deleteSendMaterialWorkload(ModulePo po);
    
	/**
	 * 删除营业员工作量报表数据
	 */
    public void deleteSalesPersonQTWorkload(ModulePo po);
    public void deleteSalesPersonQTWorkloadAppendArrears(ModulePo po);    
    
	/**
	 * 删除验光师工作量报表数据
	 */
    public void deleteOptometryWorkload(ModulePo po);
    
    
	/**
	 * 删除日销售汇总报表数据
	 */
    public void deleteDayCollect(ModulePo po);
    
    
	/**
	 * 删除日商品类别销售汇总报表数据
	 */
    public void deleteDayCollectEntry(ModulePo po);
    
    
	/**
	 * 删除日商品类别区间销售汇总报表数据
	 */
    public void deleteDayCollectAreaEntry(ModulePo po);
    
    
	/**
	 * 删除日商品明细销售报表数据
	 */
    public void deleteDaySalesEntry(ModulePo po);
    
	/**
	 * 删除日商品明细销售报表数据（补齐）
	 */
    public void deleteDaySalesEntryAppendArrears(ModulePo po);
    
	/**
	 * 删除商品销售报表数据
	 */
    public void deleteGoodsSalesAnalysis(ModulePo po);
    
	/**
	 * 删除商品销售报表明细
	 */
    public void deleteGoodsSalesEntryAnalysis(ModulePo po);
    
	/**
	 * 删除价位段销售分析报表数据
	 */
    public void deleteGoodsSalesPriceEntry(ModulePo po);
    
	/**
	 * 删除销售产品同期综合对比分析(隐形镜片分析)
	 */
    public void deleteStoreCustomerFlowEntry(ModulePo po);
    
    /**
	 * 删除销售出库单汇总数据
	 * 
	 */
	public void deleteCollectSalesOutStorageBill(ModulePo po);	
	
	/**
	 * 删除商品进销存表
	 */
	public void deleteGoodsInOrOutStroage(ModulePo po);
	
	/**
	 * 删除商品库存周转率表
	 */
	public void deleteGoodsStorageRevolveRate(ModulePo po);
	/**
	 * 删除商品库存周转率表
	 */
	public void deleteGoodsStorageRevolveRateTemp(ModulePo po);
	/**
	 * 删除商品库存周转率表按单据
	 */
	public void deleteGoodsStorageRevolveRateBill(ModulePo po);
	
	/**
	 * 删除商品库存周转率表
	 */
	public void deleteBrandStorageRevolveRate(ModulePo po);
	
	/**
	 * 删除商品库存周转率表按单据
	 */
	public void deleteGoodsStorageRevolveRateBillTemp(ModulePo po);
	
	/**
	 * 查询时英执行日志总数
	 */
	public int getReportInfoByQuartzCount(QuartzLogPo logPo);
	
	/**
	 * 查询时英执行日志列表
	 */
	public List<QuartzLogPo> getReportInfoByQuartzList(QuartzLogPo logPo,int start,int size);
	
	/**
	 * 删除分店销售指南表数据
	 */
    public void deletePerCustomer(ModulePo po);
	
	public FquartzSwitchPo getFquartzSwitchPo(); 
	
	public void updateFquartzSwitch(FquartzSwitchPo fquartzSwitchPo);
	
	public void updateQuartzModule(ModulePo modulePo);
	
	/**
	 * 删除分店销售指南表数据
	 */
    public void deleteEachShopSalesGuide(ModulePo po);
    
    /**
	 * 删除日品种明细销售报表数据
	 */
    public void deleteDayBrandSalesEntry(ModulePo po);
	
    /**
	 * 删除日品种明细销售报表数据
	 */
    public void deleteDayBrandSalesEntryAppendArrears(ModulePo po);
    
	/**
	 * 删除商品库存周转率表（按单据）
	 */
	public void deleteGoodsStorageRevolveRateByBill(ModulePo po);
	
	/**
	 * 删除商品库存周转率表（按单据）
	 */
	public void deleteBrandStorageRevolveRateByBill(ModulePo po);
	
	
}
