package com.pengsheng.eims.quartz.job;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pengsheng.eims.quartz.mgr.ConsignProcessMgr;


public class ConsignProcessJobs {

	private ConsignProcessMgr consignProcessMgr;
	
	

	public ConsignProcessMgr getConsignProcessMgr() {
		return consignProcessMgr;
	}
	public void setConsignProcessMgr(ConsignProcessMgr consignProcessMgr) {
		this.consignProcessMgr = consignProcessMgr;
	}
	public void insertConsignProcessReceiptJob(){
		consignProcessMgr.insertConsignProcess();
	}
	public static void main(String[] args) {
		ApplicationContext context=context = new ClassPathXmlApplicationContext("spring/**/*.xml");
		ConsignProcessMgr mgr=(ConsignProcessMgr)context.getBean("consignProcessMgr");
		mgr.insertConsignProcess();
	}
}
