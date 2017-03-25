package com.pengsheng.weixin.mgr;

import java.util.List;

import com.pengsheng.weixin.persistence.WeiXinLuckDrawPo;

public interface WeiXinLuckDrawSetMgr {
	
	public List<WeiXinLuckDrawPo> selectWeiXinLuckDrawSetList(WeiXinLuckDrawPo weiXinLuckDrawPo, int start, int size);

	public int selectWeiXinLuckDrawSetCount(WeiXinLuckDrawPo weiXinLuckDrawPo);
	
	public void updateWeiXinLuckDrawSet(WeiXinLuckDrawPo weiXinLuckDrawPo);
	
	public WeiXinLuckDrawPo selectWeiXinLuckDrawPo(WeiXinLuckDrawPo weiXinLuckDrawPo);
	
	public void insertWeiXinLuckDrawSet(WeiXinLuckDrawPo weiXinLuckDrawPo);

	public void daleteWeiXinLuckDrawSet(WeiXinLuckDrawPo weiXinLuckDrawPo);

	public WeiXinLuckDrawPo selectWeiXinLuckDrawSet(WeiXinLuckDrawPo weiXinLuckDrawPo);
	
	public void insertWeiXinLuckDrawSetSum(WeiXinLuckDrawPo weiXinLuckDrawPo);
	
	/**
	 * 新增中奖记录
	 */
	public void insertWeiXinLuckDraw(WeiXinLuckDrawPo weiXinLuckDrawPo);
	
	/**
	 * 新增抽奖记录
	 */
	public void insertWeiXinLuckDrawLog(WeiXinLuckDrawPo weiXinLuckDrawPo);
	
	/**
	 * 查询中奖记录
	 */
	public List<WeiXinLuckDrawPo> selectWeiXinLuckDrawSetList(WeiXinLuckDrawPo weiXinLuckDrawPo);
	
	/**
	 * 查询中奖记录总数
	 */
	public int selectWeiXinLuckDrawLogCount(WeiXinLuckDrawPo weiXinLuckDrawPo);
	
	/**
	 * 查询中奖记录总数
	 */
	public int selectWeiXinLuckDrawCount(WeiXinLuckDrawPo weiXinLuckDrawPo);
	
	/**
	 * 查询中奖总数
	 */
	public int selectWeiXinLuckDrawCount(int index);
	
}
