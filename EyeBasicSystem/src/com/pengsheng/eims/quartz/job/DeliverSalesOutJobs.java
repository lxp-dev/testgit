package com.pengsheng.eims.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.quartz.mgr.DeliverSalesOutsMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class DeliverSalesOutJobs {

	private DeliverSalesOutsMgr deliverSalesOutsMgr;
	private AdSalesInInventoryMgr adSalesInInventoryMgr;
	private ReportQuartzMgr reportQuartzMgr;
	private UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();	
		
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
	public DeliverSalesOutsMgr getDeliverSalesOutsMgr() {
		return deliverSalesOutsMgr;
	}
	public void setDeliverSalesOutsMgr(DeliverSalesOutsMgr deliverSalesOutsMgr) {
		this.deliverSalesOutsMgr = deliverSalesOutsMgr;
	}
	public void insertDeliverSalesOuts(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo=reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqswwddbchzckdflag()))){
			
			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("wwddbchzckd");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);
			
			deliverSalesOutsMgr.insertDeliverSalesOuts(logPo);
		    
		}else{
			System.out.println("禁止委外订单报残汇总出库单日期:"+billDate);
		}
	}

}
