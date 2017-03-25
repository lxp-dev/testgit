package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.CashCouponDao;
import com.pengsheng.eims.sales.mgr.CashCouponMgr;
import com.pengsheng.eims.sales.persistence.CashCouponPo;

public class CashCouponMgrImpl implements CashCouponMgr {
	
	private CashCouponDao cashCouponDao;
	
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public CashCouponDao getCashCouponDao() {
		return cashCouponDao;
	}

	public void setCashCouponDao(CashCouponDao cashCouponDao) {
		this.cashCouponDao = cashCouponDao;
	}

	public int selectCashCoupon(CashCouponPo cashCouponPo){
		
		return cashCouponDao.selectCashCoupon(cashCouponPo);
	}
	
	public void insertCashCoupon(CashCouponPo cashCouponPo,LogisticsLogPo logPo){
		
		cashCouponDao.insertCashCoupon(cashCouponPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void updateCashCoupon(CashCouponPo cashCouponPo,LogisticsLogPo logPo){
		
		cashCouponDao.updateCashCoupon(cashCouponPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void deleteCashCoupon(CashCouponPo cashCouponPo,LogisticsLogPo logPo){
		
		cashCouponDao.deleteCashCoupon(cashCouponPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public CashCouponPo getCashCoupon(CashCouponPo cashCouponPo){
		
		return cashCouponDao.getCashCoupon(cashCouponPo);
	}	
	
	public int getCashCouponCount(CashCouponPo cashCouponPo){
		
		return cashCouponDao.getCashCouponCount(cashCouponPo);
		
	}
	
	public List<CashCouponPo> getCashCouponList(CashCouponPo cashCouponPo, int start, int size){
		
		return cashCouponDao.getCashCouponList(cashCouponPo, start, size);
		
	}
	
	public CashCouponPo getCashCouponDelete(CashCouponPo cashCouponPo){
		
		return cashCouponDao.getCashCouponDelete(cashCouponPo);
	}

	public void insertBatchCashCoupon(List<CashCouponPo> cashCouponList,
			LogisticsLogPo logPo) {
		for(CashCouponPo cashCouponPo :cashCouponList){
			cashCouponDao.insertCashCoupon(cashCouponPo);			
		}
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 批量新增代金券时，判断哪些代金券号已经被使用
	 * @param cardString
	 * @return
	 */
	public List<CashCouponPo> getCashCouponListIsExist(String cardString){
		return cashCouponDao.getCashCouponListIsExist(cardString);
	}
	
	/**
	 * 批量删除代金券
	 * @param cardString
	 * @return
	 */
	public void deleteCashCouponBatch(String cardString,LogisticsLogPo logPo){
		cashCouponDao.deleteCashCouponBatch(cardString);
		logisticsLogDao.insertLog(logPo);
	}
	
	public CashCouponPo getCashCouponPo(CashCouponPo cashCouponPo) {
		
		return cashCouponDao.getCashCouponPo(cashCouponPo);
	}
	public CashCouponPo getCashCouponPo2(CashCouponPo cashCouponPo) {
		
		return cashCouponDao.getCashCouponPo2(cashCouponPo);
	}
	public CashCouponPo getCashCouponPogg(CashCouponPo cashCouponPo) {
		
		return cashCouponDao.getCashCouponPogg(cashCouponPo);
	}
	
	public List<CashCouponPo> getCashCouponList2(String customerID){
		
		return cashCouponDao.getCashCouponList2(customerID);
	}
	public List<CashCouponPo> getCashCouponList3(String customerID){
		
		return cashCouponDao.getCashCouponList3(customerID);
	}
}
