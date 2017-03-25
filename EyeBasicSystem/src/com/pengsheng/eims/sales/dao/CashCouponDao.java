package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.CashCouponPo;

public interface CashCouponDao {
	public int selectCashCoupon(CashCouponPo cashCouponPo);
	
	public void insertCashCoupon(CashCouponPo cashCouponPo);
	
	public void updateCashCoupon(CashCouponPo cashCouponPo);
	
	public void deleteCashCoupon(CashCouponPo cashCouponPo);
	
	public CashCouponPo getCashCoupon(CashCouponPo cashCouponPo);	
	
	public int getCashCouponCount(CashCouponPo cashCouponPo);
	
	public List<CashCouponPo> getCashCouponList(CashCouponPo cashCouponPo, int start, int size);
	
	public CashCouponPo getCashCouponDelete(CashCouponPo cashCouponPo);
	
	public CashCouponPo getCashCouponPo(CashCouponPo cashCouponPo);
	
	public CashCouponPo getCashCouponPo2(CashCouponPo cashCouponPo);
	
	public CashCouponPo getCashCouponPogg(CashCouponPo cashCouponPo);
	
	public void updateCashCouponState(CashCouponPo cashCouponPo); 
	
	public void updateCashCouponState2(CashCouponPo cashCouponPo); 
	
	public List<CashCouponPo> getCashCouponList2(String customerID);
	
	public List<CashCouponPo> getCashCouponList3(String customerID);
	
	public List<CashCouponPo> getCashCouponList4(CashCouponPo cashCouponPo);
	
	public void updateCashCouponState(List<CashCouponPo> ccpList);

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
	public void deleteCashCouponBatch(String cardString);
}
