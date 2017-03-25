package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.CashCouponPo;

public interface CashCouponMgr {

	public int selectCashCoupon(CashCouponPo cashCouponPo);
	
	public void insertCashCoupon(CashCouponPo cashCouponPo,LogisticsLogPo logPo);
	
	public void updateCashCoupon(CashCouponPo cashCouponPo,LogisticsLogPo logPo);
	
	public void deleteCashCoupon(CashCouponPo cashCouponPo,LogisticsLogPo logPo);
	
	public CashCouponPo getCashCoupon(CashCouponPo cashCouponPo);	
	
	public int getCashCouponCount(CashCouponPo cashCouponPo);
	
	public List<CashCouponPo> getCashCouponList(CashCouponPo cashCouponPo, int start, int size);
	
	public CashCouponPo getCashCouponDelete(CashCouponPo cashCouponPo);
	
	public void insertBatchCashCoupon(List<CashCouponPo> cashCouponList,LogisticsLogPo logPo);
	
	public CashCouponPo getCashCouponPo(CashCouponPo cashCouponPo);
	
	public CashCouponPo getCashCouponPo2(CashCouponPo cashCouponPo);
	
	public CashCouponPo getCashCouponPogg(CashCouponPo cashCouponPo);
	
	public List<CashCouponPo> getCashCouponList2(String customerID);
	
	public List<CashCouponPo> getCashCouponList3(String customerID);
	
	/**
	 * 批量新增代金券时，判断哪些代金券号已经被使用
	 * @param cardString
	 * @return
	 */
	public List<CashCouponPo> getCashCouponListIsExist(String cardString);
	
	/**
	 * 批量删除代金券
	 * @param cardString
	 * @return
	 */
	public void deleteCashCouponBatch(String cardString,LogisticsLogPo logPo);
}
