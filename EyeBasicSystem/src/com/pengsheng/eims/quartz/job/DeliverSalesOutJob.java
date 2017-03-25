package com.pengsheng.eims.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.quartz.mgr.DeliverSalesOutMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class DeliverSalesOutJob {

	private DeliverSalesOutMgr deliverSalesOutMgr;
	private AdSalesInInventoryMgr adSalesInInventoryMgr;
	private ReportQuartzMgr reportQuartzMgr;
	private UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();	
	
	public UUIDHexGenerator getUuid() {
		return uuid;
	}


	public void setUuid(UUIDHexGenerator uuid) {
		this.uuid = uuid;
	}


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


	public DeliverSalesOutMgr getDeliverSalesOutMgr() {
		return deliverSalesOutMgr;
	}


	public void setDeliverSalesOutMgr(DeliverSalesOutMgr deliverSalesOutMgr) {
		this.deliverSalesOutMgr = deliverSalesOutMgr;
	}


	public void insertDeliverSalesOut(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo=reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqswwshdhzckdflag()))){

			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("wwshdhzckd");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);
			
			deliverSalesOutMgr.insertDeliverSalesOut(logPo);			
			
		}else{
			System.out.println("禁止委外送货单汇总出库单:"+billDate);
		}

	}

}
