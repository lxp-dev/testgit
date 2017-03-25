package com.pengsheng.eims.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.quartz.mgr.StockSummaryMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class StrogeSummaryJob {
	
	private StockSummaryMgr stockSummaryMgr;
	private AdSalesInInventoryMgr adSalesInInventoryMgr;
	private UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();	
	private ReportQuartzMgr reportQuartzMgr;
	
	public ReportQuartzMgr getReportQuartzMgr() {
		return reportQuartzMgr;
	}

	public void setReportQuartzMgr(ReportQuartzMgr reportQuartzMgr) {
		this.reportQuartzMgr = reportQuartzMgr;
	}

	public AdSalesInInventoryMgr getAdSalesInInventoryMgr() {
		return adSalesInInventoryMgr;
	}

	public void setAdSalesInInventoryMgr(AdSalesInInventoryMgr adSalesInInventoryMgr) {
		this.adSalesInInventoryMgr = adSalesInInventoryMgr;
	}

	public StockSummaryMgr getStockSummaryMgr() {
		return stockSummaryMgr;
	}

	public void setStockSummaryMgr(StockSummaryMgr stockSummaryMgr) {
		this.stockSummaryMgr = stockSummaryMgr;
	}

	/**
	 *spring定时器，删除时英执行日志
	 */
	public void stockSummary() {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);		
		String billDate = currMouthFirstDay.format(calendar.getTime());		
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqshzkc()))){
			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("kchzdsq");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);
		
			//掰轨系统删除当月库存流水
			stockSummaryMgr.insertSalesOutBill(billDate,logPo);
			
			//删除定时任务日志
			stockSummaryMgr.deleteQuartzLog();
			
			System.out.println("删除时英执行日志:"+billDate);
		}else{
			System.out.println("禁止删除时英执行日志:"+billDate);
		}
		
	}

}
