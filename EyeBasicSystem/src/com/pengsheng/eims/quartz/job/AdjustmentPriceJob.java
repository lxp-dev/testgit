package com.pengsheng.eims.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.quartz.mgr.AdjustmentPriceJobMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class AdjustmentPriceJob {
	
	private AdjustmentPriceJobMgr adjustmentPriceJobMgr;
	private AdSalesInInventoryMgr adSalesInInventoryMgr;
	private UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();	
	private ReportQuartzMgr reportQuartzMgr;
	private SystemParameterMgr systemParameterMgr;
	
	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

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

	public AdjustmentPriceJobMgr getAdjustmentPriceJobMgr() {
		return adjustmentPriceJobMgr;
	}

	public void setAdjustmentPriceJobMgr(AdjustmentPriceJobMgr adjustmentPriceJobMgr) {
		this.adjustmentPriceJobMgr = adjustmentPriceJobMgr;
	}
	
	/**
	 *spring定时器，调价管理 
	 */
	public void updateAadjustmentPriceEffective(){
		SystemParameterPo spo = systemParameterMgr.getSystemParameterPo();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());		
				
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqslsjtj()))){
			
			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("lsjtj");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);			
			adjustmentPriceJobMgr.updateAadjustmentPriceEffective(billDate,logPo,spo);
			
			System.out.println("零售价调价日期:"+billDate);
		}else{
			System.out.println("禁止零售价调价日期:"+billDate);
		}

	}
	

}
