package com.pengsheng.eims.logistics.mgr.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.dao.CalDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.mgr.CalMgr;
import com.pengsheng.eims.logistics.persistence.AutoCostAccountPo;
import com.pengsheng.eims.logistics.persistence.LCTCostingTempPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.report.dao.ReportQuartzDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class CalMgrImpl implements CalMgr {
	
	private CalDao calDao;
    private LogisticsLogDao logisticsLogDao = null;
	private AdSalesInInventoryDao adSalesInInventoryDao;
	private ReportQuartzDao reportQuartzDao = null;
	private AdSalesInInventoryMgr adSalesInInventoryMgr;
	private UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();	
	
	public AdSalesInInventoryMgr getAdSalesInInventoryMgr() {
		return adSalesInInventoryMgr;
	}

	public void setAdSalesInInventoryMgr(AdSalesInInventoryMgr adSalesInInventoryMgr) {
		this.adSalesInInventoryMgr = adSalesInInventoryMgr;
	}

	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}

	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}

	public ReportQuartzDao getReportQuartzDao() {
		return reportQuartzDao;
	}

	public void setReportQuartzDao(ReportQuartzDao reportQuartzDao) {
		this.reportQuartzDao = reportQuartzDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public CalDao getCalDao() {
		return calDao;
	}

	public void setCalDao(CalDao calDao) {
		this.calDao = calDao;
	}

	public void insertRealCalStorage(String date,LogisticsLogPo logPo) {	
		calDao.delLastMonth();
		calDao.fromCurrentToLastMonth();
		this.calDao.realCalStorageDel();
		this.calDao.realCalStorage(date,"");
		
		logisticsLogDao.insertLog(logPo);
	}
	public int selCurrentDate(String date){
		return calDao.selCurrentDate(date);
	}
	
	public void insertMoniCalRetrun(LogisticsLogPo logPo) {
		this.calDao.moniCalRetrun();
		calDao.updateGoodsAverageNotTaxRate();
		
		logisticsLogDao.insertLog(logPo);
	}
	public int selLastDate(String date){
		return calDao.selLastDate(date);
	}

	public void insertRealCalRetrun(String date,LogisticsLogPo logPo) {
		
		calDao.delHistoryMonth(date);
		calDao.fromCurrentToHistory();
		
		List<InventoryEntryPo> lst = calDao.selRealCal(date);
		Iterator<InventoryEntryPo> it = lst.iterator();
		while (it.hasNext()){
			InventoryEntryPo po = (InventoryEntryPo)it.next();
			calDao.realCalRetrun(po);
			calDao.updateNotTaxRateAmount(po);
		}
		
		logisticsLogDao.insertLog(logPo);
	}


	public List<LCTCostingTempPo> getResultList(GoodsInfoPo goodsInfoPo,int start , int size) {
		return this.calDao.getResultList(goodsInfoPo,start ,size);
	}


	public int getResultCount(GoodsInfoPo goodsInfoPo) {
		return this.calDao.getResultCount(goodsInfoPo);
	}

	public int getLastMonthDataCount(){
		return 0;
	}
	
	public void delLastMonth(){
		calDao.delLastMonth();
	}
	public void delHistoryMonth(String date){
		calDao.delHistoryMonth(date);
	}
	public void fromCurrentToLastMonth(){
		calDao.fromCurrentToLastMonth();
	}
	
	public void fromCurrentToHistory(){
		calDao.fromCurrentToHistory();
	}
	
	/**
	 * 初始化加权平均计算
	 */
	public void updateWeightingCal(LogisticsLogPo logPo){
		calDao.realCalStorageDel();
		calDao.fromLastMonthToCurrentMonth();	
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 自动进行加权平均计算
	 */
	public void insertAutoCostAccount(String companyID,List<String> dateList,SystemParameterPo spo,LogisticsLogPo logPo){
		
		if (Utility.getName(spo.getFspcbjstype()).equals("1")){
			companyID = "";
		}
		
		calDao.autoCostAccount(companyID,dateList);
		
		if (logPo != null){
			logisticsLogDao.insertLog(logPo);
		}
		
	}
	
	/**
	 * 初始化查看成本回填单据
	 */
	public int getCostResultBillCount(InventoryPo po){
		return calDao.getCostResultBillCount(po);
	}
	
	/**
	 * 查看成本回填单据
	 */
	public List<InventoryPo> getCostResultBillList(InventoryPo po,int start , int size){
		return calDao.getCostResultBillList(po,start,size);
	}
	
	public void insertCostAccountNotBill(String companyID,SystemParameterPo spo,LogisticsLogPo logPo){

		FquartzSwitchPo fspo = reportQuartzDao.getFquartzSwitchPo();
		List<AutoCostAccountPo> acaList = null;		
		
		if (Utility.getName(spo.getFspcbjstype()).equals("1")){
			
			acaList = adSalesInInventoryDao.selCurrentAccountPeriod();

		}else{
			
			acaList = adSalesInInventoryDao.selCurrentAccountPeriodOneCompany();
		}

		calDao.realCalStorage(acaList,Utility.getName(fspo.getFqscbjs()),companyID,"");
		
		calDao.autoCostAccountFinish(acaList,"");
		
		logisticsLogDao.insertLog(logPo);
		
	}
	
	public void insertCostAccountBill(String companyID,SystemParameterPo spo,LogisticsLogPo logPo){

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());	
		
		adSalesInInventoryMgr.insertSalesOutBillByDate(billDate,billDate,null);  //汇总销售出库单
		
		FquartzSwitchPo fspo = reportQuartzDao.getFquartzSwitchPo();
		List<AutoCostAccountPo> acaList = null;		
		
		if (Utility.getName(spo.getFspcbjstype()).equals("1")){     // 按所有公司进行成本计算
			
			acaList = adSalesInInventoryDao.selCurrentAccountPeriod();

			calDao.realCalStorage(acaList,Utility.getName(fspo.getFqscbjs()),"","1");
			
			calDao.autoCostAccountFinish(acaList,"");

		}else{     // 按公司进行成本计算
			
			acaList = adSalesInInventoryDao.selCurrentAccountPeriodOneCompany();

			calDao.realCalStorage(acaList,Utility.getName(fspo.getFqscbjs()),companyID,"1");
			
			calDao.autoCostAccountFinish(acaList,companyID);
		}
		
		//重新转日销商品明细和商品周转率表的时英
		if (Utility.getName(spo.getFspcbjsscxzsy()).equals("2")){
			
			for (AutoCostAccountPo acapo : acaList){
				AutoCostAccountPo apo = adSalesInInventoryDao.getCurrentAccountPeriodDateArea(acapo.getLatcapaymentday());
				
				// 商品周转率表(按库存)
				adSalesInInventoryMgr.insertGoodsStorageRevolveRate(apo.getLatcabgndate(),apo.getLatcaenddate(),null); 
				
				// 商品周转率表(按单据)
				adSalesInInventoryDao.insertCollectZZLStorageByBill(apo.getLatcabgndate(),apo.getLatcaenddate());
				adSalesInInventoryMgr.insertGoodsStorageRevolveRateByBill(apo.getLatcabgndate(),apo.getLatcaenddate(),null); 
			
				// 日销商品明细
				adSalesInInventoryMgr.insertDaySalesEntry(apo.getLatcabgndate(),apo.getLatcaenddate(),null,"1","1");
			}
			System.out.println("重新转日销商品明细和商品周转率表的时英!");
		}
		
		logisticsLogDao.insertLog(logPo);
		
	}
	
	public void updateAccountPeriodSet(String companyID,String year,String month,LogisticsLogPo logPo){
		calDao.updateAccountPeriodSet(companyID,year,month);
		logisticsLogDao.insertLog(logPo);
	}
	
}
