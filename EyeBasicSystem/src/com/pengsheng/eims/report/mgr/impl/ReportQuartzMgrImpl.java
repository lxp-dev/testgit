package com.pengsheng.eims.report.mgr.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.quartz.mgr.StockSummaryMgr;
import com.pengsheng.eims.report.dao.ReportQuartzDao;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class ReportQuartzMgrImpl implements ReportQuartzMgr {

	private ReportQuartzDao reportQuartzDao = null;
	private LogisticsLogDao logisticsLogDao = null;
	private AdSalesInInventoryMgr adSalesInInventoryMgr = null;
	private StockSummaryMgr stockSummaryMgr;
	private UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();	
	private AdSalesInInventoryDao adSalesInInventoryDao;
	private SystemParameterMgr systemParameterMgr;
	private ReportQuartzMgr reportQuartzMgr;
	
	public ReportQuartzMgr getReportQuartzMgr() {
		return reportQuartzMgr;
	}

	public void setReportQuartzMgr(ReportQuartzMgr reportQuartzMgr) {
		this.reportQuartzMgr = reportQuartzMgr;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}

	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}

	public StockSummaryMgr getStockSummaryMgr() {
		return stockSummaryMgr;
	}

	public void setStockSummaryMgr(StockSummaryMgr stockSummaryMgr) {
		this.stockSummaryMgr = stockSummaryMgr;
	}

	public AdSalesInInventoryMgr getAdSalesInInventoryMgr() {
		return adSalesInInventoryMgr;
	}

	public void setAdSalesInInventoryMgr(AdSalesInInventoryMgr adSalesInInventoryMgr) {
		this.adSalesInInventoryMgr = adSalesInInventoryMgr;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public ReportQuartzDao getReportQuartzDao() {
		return reportQuartzDao;
	}

	public void setReportQuartzDao(ReportQuartzDao reportQuartzDao) {
		this.reportQuartzDao = reportQuartzDao;
	}
	
	/**
	 * 查询石英对应的报表
	 * @return
	 */
	public List<ModulePo> getReportInfoByQuartz(ModulePo po){
		return reportQuartzDao.getReportInfoByQuartz(po);
	}
	
	/**
	 * 重新生成报表时英的数据
	 * @return
	 */
	public void updateReportQuartzData(ModulePo po,LogisticsLogPo logPo) throws Exception{
		
		logisticsLogDao.insertLog(logPo);
		
		String bgnDate = Utility.getName(po.getReportBgnDate());  //起始日期
		String endDate = Utility.getName(po.getReportEndDate());  //截止日期		

		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		FquartzSwitchPo fspo = reportQuartzMgr.getFquartzSwitchPo();
		List<QuartzLogPo> logList = new ArrayList<QuartzLogPo>();
		
		// 新增日志
		while (bgnDate.compareToIgnoreCase(endDate) <= 0){
		
			QuartzLogPo qlogPo = new QuartzLogPo();
			qlogPo.setSysqllrid(uuid.generate());
			qlogPo.setSysqllrdate(bgnDate);
			qlogPo.setSysqllrquartzid(Utility.getName(po.getReportID()));
			
			adSalesInInventoryMgr.insertQuartzExecLog(qlogPo);
			
			cal.setTime(tempDate.parse(bgnDate));
			cal.add(Calendar.DATE,1);
			
			bgnDate = tempDate.format(cal.getTime());
			
			logList.add(qlogPo);
		}

		//生成新数据
		updateReportQuartzDataByID(po,logList,fspo);
		
	}
	
	/**
	 * 根据编号判断重新上生成的石英数据
	 * @throws ParseException 
	 */
	private void updateReportQuartzDataByID(ModulePo po,List<QuartzLogPo> logList,FquartzSwitchPo fspo) throws ParseException{
		
		for (QuartzLogPo logPo : logList){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
		/**
		 * 汇总收银员工作量报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("R0109")){
			adSalesInInventoryMgr.insertCashierWorkload(po.getReportBgnDate(),po.getReportEndDate(),null,"1","");
			return;
		}
		
		/**
		 * 汇总收银员工作量报表数据(补齐)
		 */
		if (Utility.getName(po.getReportID()).equals("R0109bq")){
			adSalesInInventoryMgr.insertCashierWorkload(po.getReportBgnDate(),po.getReportEndDate(),null,"","1");
			return;
		}
		
		/**
		 * 汇总挂号台工作量报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("R0101")){
			adSalesInInventoryMgr.insertRegistrationDeskWorkload(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
		/**
		 * 汇总检查人员工作量报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("R0103")){
			adSalesInInventoryMgr.insertInspectPersonWorkload(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
		/**
		 * 汇总取镜人员工作量报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("R0111")){
			adSalesInInventoryMgr.insertGetBackEyeglassPersonWorkload(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
		/**
		 * 汇总加工人员工作量报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("R0117")){
			adSalesInInventoryMgr.insertProcessWorkingStatisticsWorkload(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
		/**
		 * 汇总发料人员工作量报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("R0113")){
			adSalesInInventoryMgr.insertSendMaterialWorkload(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
		/**
		 * 汇总营业员工作量报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("R0107")){
			adSalesInInventoryMgr.insertSalesPersonQTWorkload(po.getReportBgnDate(),po.getReportEndDate(),null,"1","");
			return;
		}
		
		/**
		 * 汇总营业员工作量报表数据(补齐)
		 */
		if (Utility.getName(po.getReportID()).equals("R0107bq")){
			adSalesInInventoryMgr.insertSalesPersonQTWorkload(po.getReportBgnDate(),po.getReportEndDate(),null,"","1");
			return;
		}
		
		/**
		 * 汇总验光师工作量报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("R0105")){			
			adSalesInInventoryMgr.insertOptometryWorkload(po.getReportBgnDate(),po.getReportEndDate(),null,Utility.getName(fspo.getFqsygsgzl()));
			return;
		}
		
		/**
		 * 汇总日销售汇总报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("rxshzbtj")){
			adSalesInInventoryMgr.insertDayCollect(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
		/**
		 * 汇总日商品类别销售汇总报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("rxssplbhzb")){
			adSalesInInventoryMgr.insertDayCollectEntry(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
		/**
		 * 汇总日商品类别区间销售汇总报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("rxssplbqjhzbtj")){
			adSalesInInventoryMgr.insertDayCollectAreaEntry(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
		/**
		 * 汇总日商品明细销售报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("rxsspmxbtj")){
			adSalesInInventoryMgr.insertDaySalesEntry(po.getReportBgnDate(),po.getReportEndDate(),null,"1","");
			return;
		}
		
		/**
		 * 汇总日商品明细销售报表数据（补齐）
		 */
		if (Utility.getName(po.getReportID()).equals("rxsspmxbtjbq")){
			adSalesInInventoryMgr.insertDaySalesEntry(po.getReportBgnDate(),po.getReportEndDate(),null,"","1");
			return;
		}
		
		/**
		 * 汇总商品销售报表数据
		 */
		if (Utility.getName(po.getReportID()).equals("spsxtjb")){
			adSalesInInventoryMgr.insertGoodsSalesAnalysis(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
		/**
		 * 汇总销售产品同期综合对比分析表
		 */
		if (Utility.getName(po.getReportID()).equals("mdkll")){
			adSalesInInventoryMgr.insertStoreCustomerFlowEntry(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
		/**
		 * 汇总商品库存周转率表（按库存）
		 */
		if (Utility.getName(po.getReportID()).equals("spkczzl")){
			adSalesInInventoryMgr.insertGoodsStorageRevolveRate(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
		/**
		 * 汇总商品库存周转率表（按单据）
		 */
		if (Utility.getName(po.getReportID()).equals("spkczzladj")){
			adSalesInInventoryMgr.insertGoodsStorageRevolveRateByBill(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
		/**
		 * 汇总客单价表数据
		 */
		if (Utility.getName(po.getReportID()).equals("dgmkdjtj")){
			adSalesInInventoryMgr.insertPerCustomer(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		/**

		/**
		 * 汇总分店销售指南表数据
		 */
		if (Utility.getName(po.getReportID()).equals("fdxsznb")){
			adSalesInInventoryMgr.collectEachShopSalesGuide(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}

		/**
		 * 按日期、仓位、单据类型汇总历史库存
		 */
		if (Utility.getName(po.getReportID()).equals("arqcwdjlxhzkc")){
			adSalesInInventoryMgr.updateStroageByDateAndBillType(po.getReportBgnDate(),po.getReportEndDate(),null);
			adSalesInInventoryDao.insertCollectZZLStorageByBill(po.getReportBgnDate(),po.getReportEndDate());
			return;
		}
		
		/**
		 * 汇总销售出库
		 */
		if (Utility.getName(po.getReportID()).equals("hzxsckd")){
			adSalesInInventoryMgr.insertSalesOutBillByDate(po.getReportBgnDate(),po.getReportEndDate(),null);
			return;
		}
		
	}
	
	/**
	 * 查询时英执行日志总数
	 */
	public int getReportInfoByQuartzCount(QuartzLogPo logPo){
		return reportQuartzDao.getReportInfoByQuartzCount(logPo);
	}
	
	/**
	 * 查询时英执行日志列表
	 */
	public List<QuartzLogPo> getReportInfoByQuartzList(QuartzLogPo logPo,int start,int size){
		return reportQuartzDao.getReportInfoByQuartzList(logPo,start,size);
	}
	
	
	public FquartzSwitchPo getFquartzSwitchPo() {
		return reportQuartzDao.getFquartzSwitchPo();
	}
	
	public void updateFquartzSwitch(FquartzSwitchPo fquartzSwitchPo) {
		reportQuartzDao.updateFquartzSwitch(fquartzSwitchPo);			
	}
	
}
