package com.pengsheng.eims.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.quartz.mgr.AdcostPriceJobMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class AdcostPriceJob {

	private AdcostPriceJobMgr adcostPriceJobMgr;
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

	public AdcostPriceJobMgr getAdcostPriceJobMgr() {
		return adcostPriceJobMgr;
	}

	public void setAdcostPriceJobMgr(AdcostPriceJobMgr adcostPriceJobMgr) {
		this.adcostPriceJobMgr = adcostPriceJobMgr;
	}
	
	/**
	 * 石英调价
	 */
	public void updateAdcostPriceEffective(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());		
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqscbjtj()))){

			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("cbtj");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);
			adcostPriceJobMgr.updateAdcostPriceEffective(billDate,logPo);

			System.out.println("成本调价日期:"+billDate);
		}else{
			System.out.println("禁止成本调价日期:"+billDate);
		}

		
	}
	
}
