package com.pengsheng.eims.quartz.mgr.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.dao.SmsSetBirthdayDao;
import com.pengsheng.eims.quartz.mgr.SmsSetBirthdayMgr;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.util.tools.Utility;

public class SmsSetBirthdayMgrImpl implements SmsSetBirthdayMgr {

	private SmsSetBirthdayDao smsSetBirthdayDao;
	private SendNoteMgr sendNoteMgr = null;
	private AdSalesInInventoryDao adSalesInInventoryDao;
	
	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}

	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}

	public SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}

	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}

	public SmsSetBirthdayDao getSmsSetBirthdayDao() {
		return smsSetBirthdayDao;
	}

	public void setSmsSetBirthdayDao(SmsSetBirthdayDao smsSetBirthdayDao) {
		this.smsSetBirthdayDao = smsSetBirthdayDao;
	}

	/**
	 * 查询公司名称
	 */
	public CompanyNamePo getCompanyName() {
		
		return smsSetBirthdayDao.getCompanyName();
	}

	/**
	 * 查询顾客信息
	 */
	public List<CustomerInfoPo> getCustomerInfo() {
		
		return smsSetBirthdayDao.getCustomerInfo();
	}

	/**
	 * 获取短信平台维护表信息
	 */
	public SmsSetPo getSmsSet() {
		
		return smsSetBirthdayDao.getSmsSet();
	}

	/**
	 * 新增短信记录表 
	 * @throws Exception 
	 */
	public void insertSmsRecord(List<CustomerInfoPo> customerInfoPoList,SendNotePo snpo,QuartzLogPo logPo) throws Exception {

		for (CustomerInfoPo cpo : customerInfoPoList){
			
			snpo.setSncustomerid(Utility.getName(cpo.getSmecicustomerid()));
			snpo.setSncustomername(Utility.getName(cpo.getSmeciname()));
			snpo.setSnsex(Utility.getName(cpo.getSmecisex()).equals("0") ? "先生" : (Utility.getName(cpo.getSmecisex()).equals("1") ? "女士" : ""));
			
	        Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 09:00:00");  // 会员生日
			
			snpo.setSnsenddate(dateFormat.format(cal.getTime()));
			
			sendNoteMgr.insertSendNoteContent(snpo);
		}
		
		adSalesInInventoryDao.updateQuartzExecLog(logPo);
	}
	
	
}

