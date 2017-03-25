package com.pengsheng.eims.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.quartz.mgr.SmsSetBirthdayMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class SmsSetBirthdayJob extends BaseAction {
	
	private List<CustomerInfoPo> customerInfoPoList;
	private CompanyNamePo companyNamePo;	
	private SmsSetPo smsSetPo;	
	private SmsSetBirthdayMgr smsSetBirthdayMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
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

	public UUIDHexGenerator getUuid() {
		return uuid;
	}

	public void setUuid(UUIDHexGenerator uuid) {
		this.uuid = uuid;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public SmsSetBirthdayMgr getSmsSetBirthdayMgr() {
		return smsSetBirthdayMgr;
	}

	public void setSmsSetBirthdayMgr(SmsSetBirthdayMgr smsSetBirthdayMgr) {
		this.smsSetBirthdayMgr = smsSetBirthdayMgr;
	}

	public SmsSetPo getSmsSetPo() {
		return smsSetPo;
	}

	public void setSmsSetPo(SmsSetPo smsSetPo) {
		this.smsSetPo = smsSetPo;
	}

	public List<CustomerInfoPo> getCustomerInfoPoList() {
		return customerInfoPoList;
	}

	public void setCustomerInfoPoList(List<CustomerInfoPo> customerInfoPoList) {
		this.customerInfoPoList = customerInfoPoList;
	}

	public CompanyNamePo getCompanyNamePo() {
		return companyNamePo;
	}

	public void setCompanyNamePo(CompanyNamePo companyNamePo) {
		this.companyNamePo = companyNamePo;
	}


	
	/**
	 * 生日提醒
	 * @return 
	 * @throws Exception 
	 */
	public void smsSetBirthday() throws Exception{
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqssrtx()))){
			systemParameterPo = systemParameterMgr.getSystemParameterPo();
	    	customerInfoPoList = smsSetBirthdayMgr.getCustomerInfo();
				
			SendNotePo snpo = new SendNotePo();
			snpo.setSnpersonid("admin");
			snpo.setSndepartmentid("600");
			snpo.setSnnotetypeid("11");
			
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
			String billDate = currMouthFirstDay.format(calendar.getTime());	
			
			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("srtx");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);
			
			if (Utility.getName(systemParameterPo.getFspshortmessage()).equals("1") || Utility.getName(systemParameterPo.getFspshortmessage()).equals("2")){
				if (customerInfoPoList != null && customerInfoPoList.size() > 0){
					smsSetBirthdayMgr.insertSmsRecord(customerInfoPoList, snpo,logPo);
					System.out.println("今日关于会员的生日祝福短信发送完毕!");
					return;
				}else{
					System.out.println("今日没有关于会员的生日提醒!");
				}
			}else{
				System.out.println("短信功能已停止使用!");
			}
		
			adSalesInInventoryMgr.updateQuartzExecLog(logPo);			
		}else{
			System.out.println("禁止发送生日提醒的短信!");
		}
		
	}
}
