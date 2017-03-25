package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface GiftsMgr {
	
	/**
	 * 删除赠品
	 * @param giftsPo
	 */
	public void deleteGifts(GiftsPo giftsPo,LogisticsLogPo logPo);
	/**
	 * 新增赠品
	 * @param giftsPo
	 */
	public void insertGifts(GiftsPo giftsPo,LogisticsLogPo logPo);
	
	public int getGiftsCount(GiftsPo giftsPo);
	public int getGiftsCount2(GiftsPo po);
	
	/**
	 * 修改赠品
	 * @param giftsPo
	 */
	public void updateGifts(GiftsPo giftsPo,LogisticsLogPo logPo);
	
	/**
	 * 修改赠品
	 */
	public void updateGiftsDepartment(GiftsPo giftsPo,LogisticsLogPo logPo);
	
	/**
	 * 获取赠品LIST
	 */
	public List<GiftsPo> getGifts();
	/**
	 * 启用赠品
	 * @param giftsPo
	 */
	public void ableGifts(GiftsPo giftsPo,LogisticsLogPo logPo);
	/**
	 * 停用赠品
	 * @param giftsPo
	 */
	public void disableGifts(GiftsPo giftsPo,LogisticsLogPo logPo);
	/**
	 * 获取赠品Po
	 * @param giftsPo
	 */
	public GiftsPo getGift(GiftsPo giftsPo);
	
	public List<GiftsPo> getGifts(GiftsPo giftsPo, int start, int size);
	
	public List<GiftsPo> getGifts(GiftsPo giftsPo);
	
}
