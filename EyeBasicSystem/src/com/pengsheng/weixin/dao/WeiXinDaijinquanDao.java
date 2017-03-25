package com.pengsheng.weixin.dao;

import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.weixin.persistence.DaijinquanPo;

public interface WeiXinDaijinquanDao {
	
	public void insertStoredValueCardFlag(DaijinquanPo daijinquanPo);

	/**
	 * 根据openID新增代金券
	 */
	public void insertDaijinquanByOpenID(CashCouponPo po);
	
	/**
	 * 根据openID判断之前是否使用过代金券
	 */
	public int getDaijinquanCountByOpenID(String openID);
	
	/**
	 * 根据openID获取使用过代金券
	 */
	public CashCouponPo getDaijinquanIngoByOpenID(String openID);

	public void deleteStoredValueCardFlag(DaijinquanPo daijinquanPo);
	
	public DaijinquanPo selectStoredValueCardFlagPo(DaijinquanPo daijinquanPo);
	/**
	 * 获取未使用的代金券
	 */
	public CashCouponPo getCashCouponW();
	/**
	 * 代金券发卡绑定
	 */
	public void updateCashCouponW(CashCouponPo cashCouponPo);

}
