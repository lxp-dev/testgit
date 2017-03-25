package com.pengsheng.eims.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.pengsheng.eims.quartz.mgr.AdConsignProcessTakeMgr;
import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class AdConsignProcessTakeJob {

	private AdConsignProcessTakeMgr adConsignProcessTakeMgr;
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

	public AdConsignProcessTakeMgr getAdConsignProcessTakeMgr() {
		return adConsignProcessTakeMgr;
	}

	public void setAdConsignProcessTakeMgr(
			AdConsignProcessTakeMgr adConsignProcessTakeMgr) {
		this.adConsignProcessTakeMgr = adConsignProcessTakeMgr;
	}
	
	/**
	 * 委外收货业务及明细表定时器
	 */
	public void adConsignProcess(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("2".equals(Utility.getName(fquartzSwitchPo.getFqswashzwajs()))){

			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("washdsq");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);
			
			adConsignProcessTakeMgr.insertInventory(logPo);
			
			System.out.println("委外收货单转结算单日期：" + billDate);
			
		}else if("1".equals(Utility.getName(fquartzSwitchPo.getFqswashzwajs()))){
			System.out.println("委外收货单转结算单停用,日期：" + billDate);
			
		}else{
			System.out.println("禁止委外收货单转结算单日期：" + billDate);
		}

	}
	
}
