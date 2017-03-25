package com.pengsheng.eims.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.quartz.mgr.CustomerLevelUpMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class AdSalesInInventoryJob {
	
	private AdSalesInInventoryMgr adSalesInInventoryMgr;
	private SystemParameterMgr systemParameterMgr;
	private UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();	
	private SystemParameterPo systemParameterPo;		
	private ReportQuartzMgr reportQuartzMgr;
	private CustomerLevelUpMgr customerLevelUpMgr;
	
	public CustomerLevelUpMgr getCustomerLevelUpMgr() {
		return customerLevelUpMgr;
	}

	public void setCustomerLevelUpMgr(CustomerLevelUpMgr customerLevelUpMgr) {
		this.customerLevelUpMgr = customerLevelUpMgr;
	}

	public ReportQuartzMgr getReportQuartzMgr() {
		return reportQuartzMgr;
	}

	public void setReportQuartzMgr(ReportQuartzMgr reportQuartzMgr) {
		this.reportQuartzMgr = reportQuartzMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public AdSalesInInventoryMgr getAdSalesInInventoryMgr() {
		return adSalesInInventoryMgr;
	}

	public void setAdSalesInInventoryMgr(AdSalesInInventoryMgr adSalesInInventoryMgr) {
		this.adSalesInInventoryMgr = adSalesInInventoryMgr;
	}
	
	/**
	 * 汇总销售出库单
	 */
	public void insertCollectSalesOutStorageBill(){
	}

	
	/**
	 * 汇总收银员工作量统计
	 */
	public void insertCashierWorkload(){	
	
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime()); 	
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqssyygzl()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("R0109");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("R0109");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertCashierWorkload(billDate,billDate,logPo,"1","1");
				}	
			}
			System.out.println("汇总收银员日期:"+billDate);
		}else{
			System.out.println("禁止汇总收银员日期:"+billDate);
		}
		
	}
	
	
	/**
	 * 汇总挂号台工作量统计
	 */
	public void insertRegistrationDeskWorkload(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());			
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsghtgzl()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("R0101");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("R0101");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertRegistrationDeskWorkload(billDate,billDate,logPo);
				}	
			}	
			System.out.println("汇总挂号台日期:"+billDate);
		}else{
			System.out.println("禁止汇总挂号台日期:"+billDate);
		}

	}
	
	/**
	 * 检查人员工作量统计表（单店）
	 */
	public void insertInspectPersonWorkload(){		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());				
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsjcrygzl()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("R0103");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){				
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("R0103");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertInspectPersonWorkload(billDate,billDate,logPo);
				}	
			}
			System.out.println("汇总检查人员日期:"+billDate);
		}else{
			System.out.println("禁止汇总检查人员日期:"+billDate);
		}

	}

	
	/**
	 * 取镜人员工作量统计表（单店）
	 */
	public void insertGetBackEyeglassPersonWorkload(){		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsqjrygzl()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("R0111");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("R0111");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertGetBackEyeglassPersonWorkload(billDate,billDate,logPo);
				}	
			}
			System.out.println("汇总取镜人员日期:"+billDate);
		}else{
			System.out.println("禁止汇总取镜人员日期:"+billDate);
		}

	}

	
	
	/**
	 * 加工人员工作量统计（单店）
	 */
	public void insertProcessWorkingStatisticsWorkload(){		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsjgsgzl()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("R0117");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("R0117");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertProcessWorkingStatisticsWorkload(billDate,billDate,logPo);
				}	
			}
			System.out.println("汇总加工人员日期:"+billDate);
		}else{
			System.out.println("禁止汇总加工人员日期:"+billDate);
		}

	}

	
	/**
	 * 发料人员工作量统计（单店）
	 */
	public void insertSendMaterialWorkload(){		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());		
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsflrygzl()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("R0113");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("R0113");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertSendMaterialWorkload(billDate,billDate,logPo);
				}	
			}
			System.out.println("汇总发料人员日期:"+billDate);
		}else{
			System.out.println("禁止汇总发料人员日期:"+billDate);
		}

	}
	
	
	
	/**
	 * 营业员工作量统计表（单店）
	 */
	public void insertSalesPersonQTWorkload(){		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());		
			
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsyyygzl()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("R0107");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("R0107");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertSalesPersonQTWorkload(billDate,billDate,logPo,"1","1");
				}	
			}
			System.out.println("汇总营业员日期:"+billDate);
		}else{
			System.out.println("禁止汇总营业员日期:"+billDate);
		}

	}
	
	/**
	 * 商品销售统计表
	 */
	public void insertGoodsSalesAnalysis(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());		
			
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqssoxstj()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("spsxtjb");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("spsxtjb");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertGoodsSalesAnalysis(billDate,billDate,logPo);
				}	
			}	
			System.out.println("汇总商品销售统计表日期:"+billDate);
		}else{
			System.out.println("禁止汇总商品销售统计表日期:"+billDate);
		}

	}
	
	
	/**
	 * 清空当日销售数据
	 */
	public void deleteTodaySalesDataJob(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsqkdrxssj()))){
			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("qkdrxssj");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);
			
			adSalesInInventoryMgr.deleteTodaySalesData(logPo);
			System.out.println("清空销售数据日期:"+billDate);
		}else{
			System.out.println("禁止清空销售数据日期:"+billDate);
		}
		
	}
	
	/**
	 * 自动进行成本计算
	 */
	public void insertAutoCostAccountJob(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		QuartzLogPo logPo = new QuartzLogPo();
		logPo.setSysqllrid(uuid.generate());
		logPo.setSysqllrdate(billDate);
		logPo.setSysqllrquartzid("zdcbjs");
		
		adSalesInInventoryMgr.insertQuartzExecLog(logPo);

		adSalesInInventoryMgr.insertAutoCostAccountJob(billDate,logPo); //自动进行成本计算,计算完成后，更新商品进销存表加权平均成本
		System.out.println("汇总销售出库单日期:"+billDate);
		
	}
	
	/**
	 * 验光师工作量统计表（单店）
	 */
	public void insertOptometryWorkload(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());		
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if(!"0".equals(Utility.getName(fquartzSwitchPo.getFqsygsgzl()))){
			
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("R0105");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("R0105");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertOptometryWorkload(billDate,billDate,logPo,Utility.getName(fquartzSwitchPo.getFqsygsgzl()));
				}	
			}
			System.out.println("汇总验光师日期:"+billDate);
		}else{
			System.out.println("禁止汇总验光师日期:"+billDate);
		}
		
	}
	
	/**
	 * 自动进行会员升级
	 */
	public void insertAutoCustomerUpGradeJob(){

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());		
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqshysj()))){
			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("zdhysj");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);
			
			adSalesInInventoryMgr.insertAutoCustomerUpGradeJob(logPo);
			System.out.println("会员自动升级完成!");

		}else if("2".equals(Utility.getName(fquartzSwitchPo.getFqshysj()))){
			
			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("zdhysj");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);
			
			customerLevelUpMgr.updateCustomerLevel(null);
			
			adSalesInInventoryMgr.updateQuartzExecLog(logPo);
			System.out.println("会员自动升级完成!");
			
		}else {
			System.out.println("禁止会员不能自动升级!");
		}
		
	}	
	
	/**
	 * 日销售汇总表统计
	 */
	public void insertDayCollect(){		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsrxshz()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("rxshzbtj");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("rxshzbtj");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertDayCollect(billDate,billDate,logPo);
				}	
			}
			System.out.println("汇总日销售日期:"+billDate);
		}else{
			System.out.println("禁止汇总日销售日期:"+billDate);
		}
		

	}
	
	/**
	 *日商品类别销售汇总表统计
	 */
	public void insertDayCollectEntry(){		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());		
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsrxssplxhz()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("rxssplbhzb");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("rxssplbhzb");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertDayCollectEntry(billDate,billDate,logPo);
				}	
			}
			System.out.println("汇总日商品类别销售日期:"+billDate);
		}else{
			System.out.println("禁止汇总日商品类别销售日期:"+billDate);
		}
		
	}
	
	/**
	 *日商品类别区间销售汇总表统计
	 */
	public void insertDayCollectAreaEntry(){		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsrxssplxqjhz()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("rxssplbqjhzbtj");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("rxssplbqjhzbtj");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertDayCollectAreaEntry(billDate,billDate,logPo);
				}	
			}
			System.out.println("汇总日商品类别区间销售日期:"+billDate);
		}else{
			System.out.println("禁止汇总日商品类别区间销售日期:"+billDate);
		}
		
	}
	
	/**
	 *日商品明细销售表统计
	 */
	public void insertDaySalesEntry(){		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsrxsspmxhz()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("rxsspmxbtj");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("rxsspmxbtj");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertDaySalesEntry(billDate,billDate,logPo,"1","1");
				}	
			}
			System.out.println("汇总日商品明细销售日期:"+billDate);
		}else{
			System.out.println("禁止汇总日商品明细销售日期:"+billDate);
		}
		
	}
	
	/**
	 *日销售品种明细统计
	 */
	public void insertDayBrandSalesEntry(){		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsrxsspmxhz()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("rxsppmxbtj");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("rxsppmxbtj");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertDayBrandSalesEntry(billDate,billDate,logPo,"1","1");
				}	
			}
			System.out.println("汇总日品种明细销售日期:"+billDate);
		}else{
			System.out.println("禁止汇总日品种明细销售日期:"+billDate);
		}
		
	}

	/**
	 * 判断套餐是否过期
	 */
	public void updateSetMealOverdueJob(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());		
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqstcgq()))){
			QuartzLogPo logPo = new QuartzLogPo();
			logPo.setSysqllrid(uuid.generate());
			logPo.setSysqllrdate(billDate);
			logPo.setSysqllrquartzid("tcgqyz");
			
			adSalesInInventoryMgr.insertQuartzExecLog(logPo);
			
			adSalesInInventoryMgr.updateSetMealOverdue(billDate,logPo);
			System.out.println("更新套餐截止日期:"+billDate);
		}else{
			System.out.println("禁止更新套餐截止日期:"+billDate);
		}
		
	}

	/**
	 * 销售产品同期综合对比分析表(隐形镜片分析)
	 */
	public void insertStoreCustomerFlowEntry(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqssscptqzhdbfxb()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("mdkll");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("mdkll");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertStoreCustomerFlowEntry(billDate,billDate,logPo);
				}	
			}
			System.out.println("销售产品同期综合对比分析表日期:"+billDate);
		}else{
			System.out.println("禁止销售产品同期综合对比分析表日期:"+billDate);
		}
		
	}
	
	/**
	 * 商品库存周转率统计表
	 */
	public void insertGoodsStorageRevolveRate(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());		
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqskczzl()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("spkczzl");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("spkczzl");					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertGoodsStorageRevolveRate(billDate,billDate,logPo);
					
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrquartzid("spkczzladj");
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertGoodsStorageRevolveRateByBill(billDate,billDate,logPo);
				}	
			}
			System.out.println("商品库存周转率统计表日期:"+billDate);
		}else{
			System.out.println("禁止商品库存周转率统计表日期:"+billDate);
		}
		
	}
	
	/**
	 * 品种库存周转率统计表
	 */
	public void insertBrandStorageRevolveRate(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime());		
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqskczzl()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("spkczzl");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("ppkczzl");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertBrandStorageRevolveRate(billDate,billDate,logPo);
				}	
			}
			System.out.println("品种库存周转率统计表日期:"+billDate);
		}else{
			System.out.println("禁止品种库存周转率统计表日期:"+billDate);
		}
		
	}
	
	/**
	 * 按商品类型汇总库存
	 */
	public void insertCollectStealthStorage(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());		
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsasplxhzkc()))){
			adSalesInInventoryMgr.insertCollectStealthStorage();
			
			System.out.println("按商品类型汇总库存的日期:"+billDate);
		}else{
			System.out.println("禁止按商品类型汇总库存的日期:"+billDate);
		}
		
	}
	
	/**
	 * 汇总客单价统计
	 */
	public void insertCollectPerCustomer(){	
	
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE,-1);
		String billDate = currMouthFirstDay.format(calendar.getTime()); 
		
		FquartzSwitchPo fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqshzkdjtjb()))){
			QuartzLogPo po = new QuartzLogPo();
			po.setSysqllrquartzid("dgmkdjtj");
			List<QuartzLogPo> quartzLogList = adSalesInInventoryMgr.getQuartzExecLog(po);
			for (QuartzLogPo qpo : quartzLogList){
				billDate = Utility.getName(qpo.getSysqllrdate());
				if (!billDate.equals("")){
					QuartzLogPo logPo = new QuartzLogPo();
					logPo.setSysqllrid(uuid.generate());
					logPo.setSysqllrdate(billDate);
					logPo.setSysqllrquartzid("dgmkdjtj");
					
					adSalesInInventoryMgr.insertQuartzExecLog(logPo);
					
					adSalesInInventoryMgr.insertPerCustomer(billDate,billDate,logPo);
				}	
			}
			System.out.println("汇总客单价日期:"+billDate);
		}else{
			System.out.println("禁止汇总客单价日期:"+billDate);
		}
		
	}
	/**
	 * 分店销售指南表
	 */
	public void collectEachShopSalesGuide(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());	

		FquartzSwitchPo fquartzSwitchPo=reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqsfdxsznbflag()))){
			
			if (!billDate.equals("")){
				QuartzLogPo logPo = new QuartzLogPo();
				logPo.setSysqllrid(uuid.generate());
				logPo.setSysqllrdate(billDate);
				logPo.setSysqllrquartzid("fdxsznb");
				
				adSalesInInventoryMgr.insertQuartzExecLog(logPo);
				
				adSalesInInventoryMgr.collectEachShopSalesGuide(billDate,billDate,logPo);
			}
		   
			System.out.println("成功汇总分店销售指南日期:"+billDate);
		}else{
			System.out.println("禁止汇总分店销售指南日期:"+billDate);
		}
		
	}
	
	/**
	 * 自动关账和创建临时凭证表
	 */
	public void switchAmount(){	
		
		FquartzSwitchPo fquartzSwitchPo=reportQuartzMgr.getFquartzSwitchPo();
		if("1".equals(Utility.getName(fquartzSwitchPo.getFqszdgzhcjlspzbflag()))){
		    adSalesInInventoryMgr.switchAmount();
		}else{
			System.out.println("禁止自动关账和创建临时凭证表");
		}
	}
		
}
