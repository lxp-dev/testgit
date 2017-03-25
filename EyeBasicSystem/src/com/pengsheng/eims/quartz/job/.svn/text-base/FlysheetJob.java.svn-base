package com.pengsheng.eims.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.pengsheng.eims.quartz.mgr.FlysheetMgr;

public class FlysheetJob {

	private FlysheetMgr flysheetMgr;
	
	/**
	 * 向外帐传递配镜单
	 */
	public void insertToFlysheetGiveSalesBill(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		flysheetMgr.insertFlysheet(billDate);		
	}
		
	/**
	 * 外帐汇总采购收货单和退货单
	 */
	public void insertFlysheet(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		flysheetMgr.insertFlysheet(billDate);		
	}

	public FlysheetMgr getFlysheetMgr() {
		return flysheetMgr;
	}

	public void setFlysheetMgr(FlysheetMgr flysheetMgr) {
		this.flysheetMgr = flysheetMgr;
	}
	
}
