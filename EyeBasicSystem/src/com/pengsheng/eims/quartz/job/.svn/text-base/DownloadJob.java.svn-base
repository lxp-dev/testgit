package com.pengsheng.eims.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.pengsheng.eims.quartz.mgr.DownloadJobMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.util.tools.Utility;

public class DownloadJob {
	private DownloadJobMgr downloadJobMgr;
	private ReportQuartzMgr reportQuartzMgr;
	
	public void updateCostprice(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo=reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqssynchronizecost()))){
			downloadJobMgr.noUpdateCostprice();		
		}else{
			System.out.println("禁止同步集团端含税与不含税成本:"+billDate);
		}
	}
	
	public void uploadCustomerInfo(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo=reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqssynchronizecustomer()))){
			downloadJobMgr.noUploadCustomerInfo();		
		}else{
			System.out.println("上传医院端会员信息:"+billDate);
		}
		
	}

	public DownloadJobMgr getDownloadJobMgr() {
		return downloadJobMgr;
	}

	public void setDownloadJobMgr(DownloadJobMgr downloadJobMgr) {
		this.downloadJobMgr = downloadJobMgr;
	}

	public ReportQuartzMgr getReportQuartzMgr() {
		return reportQuartzMgr;
	}

	public void setReportQuartzMgr(ReportQuartzMgr reportQuartzMgr) {
		this.reportQuartzMgr = reportQuartzMgr;
	}
	
}
