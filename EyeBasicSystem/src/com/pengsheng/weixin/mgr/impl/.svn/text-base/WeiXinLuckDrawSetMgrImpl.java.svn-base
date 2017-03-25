package com.pengsheng.weixin.mgr.impl;

import java.util.List;
import com.pengsheng.weixin.dao.WeiXinLuckDrawSetDao;
import com.pengsheng.weixin.mgr.WeiXinLuckDrawSetMgr;
import com.pengsheng.weixin.persistence.WeiXinLuckDrawPo;

public class WeiXinLuckDrawSetMgrImpl implements WeiXinLuckDrawSetMgr{
	private WeiXinLuckDrawSetDao weiXinLuckDrawSetDao;
	
	public WeiXinLuckDrawSetDao getWeiXinLuckDrawSetDao() {
		return weiXinLuckDrawSetDao;
	}

	public void setWeiXinLuckDrawSetDao(WeiXinLuckDrawSetDao weiXinLuckDrawSetDao) {
		this.weiXinLuckDrawSetDao = weiXinLuckDrawSetDao;
	}

	public List<WeiXinLuckDrawPo> selectWeiXinLuckDrawSetList(WeiXinLuckDrawPo weiXinLuckDrawPo, int start, int size){
		return weiXinLuckDrawSetDao.selectWeiXinLuckDrawSetList(weiXinLuckDrawPo, start, size);
	}

	public int selectWeiXinLuckDrawSetCount(WeiXinLuckDrawPo weiXinLuckDrawPo){
		return weiXinLuckDrawSetDao.selectWeiXinLuckDrawSetCount(weiXinLuckDrawPo);
	}
	
	public void updateWeiXinLuckDrawSet(WeiXinLuckDrawPo weiXinLuckDrawPo){
		weiXinLuckDrawSetDao.updateWeiXinLuckDrawSet(weiXinLuckDrawPo);
	}
	
	public WeiXinLuckDrawPo selectWeiXinLuckDrawPo(WeiXinLuckDrawPo weiXinLuckDrawPo){
		return weiXinLuckDrawSetDao.selectWeiXinLuckDrawPo(weiXinLuckDrawPo);
	}
	
	public void insertWeiXinLuckDrawSet(WeiXinLuckDrawPo weiXinLuckDrawPo){
		weiXinLuckDrawSetDao.insertWeiXinLuckDrawSet(weiXinLuckDrawPo);
	}

	public void daleteWeiXinLuckDrawSet(WeiXinLuckDrawPo weiXinLuckDrawPo){
		weiXinLuckDrawSetDao.daleteWeiXinLuckDrawSet(weiXinLuckDrawPo);
	}

	public WeiXinLuckDrawPo selectWeiXinLuckDrawSet(WeiXinLuckDrawPo weiXinLuckDrawPo){
		return weiXinLuckDrawSetDao.selectWeiXinLuckDrawSet(weiXinLuckDrawPo);
	}
	
	public void insertWeiXinLuckDrawSetSum(WeiXinLuckDrawPo weiXinLuckDrawPo){
		weiXinLuckDrawSetDao.daleteWeiXinLuckDrawSet(weiXinLuckDrawPo);
		weiXinLuckDrawSetDao.insertWeiXinLuckDrawSet(weiXinLuckDrawPo);
	}
	
	/**
	 * 新增中奖记录
	 */
	public void insertWeiXinLuckDraw(WeiXinLuckDrawPo weiXinLuckDrawPo){
		weiXinLuckDrawSetDao.insertWeiXinLuckDraw(weiXinLuckDrawPo);
	}
	
	/**
	 * 新增抽奖记录
	 */
	public void insertWeiXinLuckDrawLog(WeiXinLuckDrawPo weiXinLuckDrawPo){
		weiXinLuckDrawSetDao.insertWeiXinLuckDrawLog(weiXinLuckDrawPo);
	}
	
	/**
	 * 查询中奖记录
	 */
	public List<WeiXinLuckDrawPo> selectWeiXinLuckDrawSetList(WeiXinLuckDrawPo weiXinLuckDrawPo){
		return weiXinLuckDrawSetDao.selectWeiXinLuckDrawSetList(weiXinLuckDrawPo);
	}
	
	/**
	 * 查询中奖记录总数
	 */
	public int selectWeiXinLuckDrawLogCount(WeiXinLuckDrawPo weiXinLuckDrawPo){
		return weiXinLuckDrawSetDao.selectWeiXinLuckDrawLogCount(weiXinLuckDrawPo);
	}
	
	/**
	 * 查询中奖记录总数
	 */
	public int selectWeiXinLuckDrawCount(WeiXinLuckDrawPo weiXinLuckDrawPo){
		return weiXinLuckDrawSetDao.selectWeiXinLuckDrawCount(weiXinLuckDrawPo);
	}
	
	/**
	 * 查询中奖总数
	 */
	public int selectWeiXinLuckDrawCount(int index){
		return weiXinLuckDrawSetDao.selectWeiXinLuckDrawCount(index);
	}
	
}
