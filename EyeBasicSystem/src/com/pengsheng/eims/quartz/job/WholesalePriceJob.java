package com.pengsheng.eims.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.quartz.mgr.WholesalePriceJobMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class WholesalePriceJob {
	
	private WholesalePriceJobMgr wholesalePriceJobMgr;
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

	public WholesalePriceJobMgr getWholesalePriceJobMgr() {
		return wholesalePriceJobMgr;
	}

	public void setWholesalePriceJobMgr(WholesalePriceJobMgr wholesalePriceJobMgr) {
		this.wholesalePriceJobMgr = wholesalePriceJobMgr;
	}
	
	/**
	 *spring定时器，调价管理 
	 */
	public void updateWholesalePriceEffective(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());		
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqspfjtj()))){

			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("pfjtj");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);			
			wholesalePriceJobMgr.updateWholesalePriceEffective(billDate,logPo);
			
			System.out.println("批发价调价日期:"+billDate);
		}else{
			System.out.println("禁止批发价调价日期:"+billDate);
		}
		

	}
	

}
