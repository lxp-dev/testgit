package com.pengsheng.eims.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.quartz.mgr.ProcessOutMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class ProcessOutJob {

	private ProcessOutMgr processOutMgr;		
	private ReportQuartzMgr reportQuartzMgr;
	private UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();		
	private AdSalesInInventoryMgr adSalesInInventoryMgr;
	
	public AdSalesInInventoryMgr getAdSalesInInventoryMgr() {
		return adSalesInInventoryMgr;
	}


	public void setAdSalesInInventoryMgr(AdSalesInInventoryMgr adSalesInInventoryMgr) {
		this.adSalesInInventoryMgr = adSalesInInventoryMgr;
	}


	public ReportQuartzMgr getReportQuartzMgr() {
		return reportQuartzMgr;
	}


	public void setReportQuartzMgr(ReportQuartzMgr reportQuartzMgr) {
		this.reportQuartzMgr = reportQuartzMgr;
	}


	public ProcessOutMgr getProcessOutMgr() {
		return processOutMgr;
	}


	public void setProcessOutMgr(ProcessOutMgr processOutMgr) {
		this.processOutMgr = processOutMgr;
	}


	public void insertProcessOut(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo=reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsbcthfdbhzckdflag()))){
			
			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("bcthfdbhzckd");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);
			
			processOutMgr.insertProcessOut(logPo);			
		    
		}else{
			System.out.println("禁止不合格品转销售出库或采购退货日期:"+billDate);
		}
	}

}
