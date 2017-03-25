package com.pengsheng.weixin.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.weixin.dao.WeiXinIntegralSelectDao;
import com.pengsheng.weixin.mgr.WeiXinIntegralSelectMgr;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;

public class WeiXinIntegralSelectMgrImpl implements WeiXinIntegralSelectMgr{
	private WeiXinIntegralSelectDao weiXinIntegralSelectDao;
	private LogisticsLogDao logisticsLogDao;
	
	public WeiXinIntegralSelectDao getWeiXinIntegralSelectDao() {
		return weiXinIntegralSelectDao;
	}

	public void setWeiXinIntegralSelectDao(
			WeiXinIntegralSelectDao weiXinIntegralSelectDao) {
		this.weiXinIntegralSelectDao = weiXinIntegralSelectDao;
	}

	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po){
		return weiXinIntegralSelectDao.getWeiXinIntegralSelectList(po);
	}
	
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po, int start,int size){
		return weiXinIntegralSelectDao.getWeiXinIntegralSelectList(po, start, size);
	}
	
	public int getWeiXinIntegralSelectCount(WeiXinIntegralSelectPo po) {
		return weiXinIntegralSelectDao.getWeiXinIntegralSelectCount(po);
	}
	
	/**
	 * 获取积分兑换顾客信息
	 * @param po
	 * @return
	 */
	public CustomerInfoPo selectCustomerInfoPo(CustomerInfoPo po){
		return weiXinIntegralSelectDao.selectCustomerInfoPo(po);
	}
	
	/**
	 * 获取积分兑换商品信息
	 * @param po
	 * @return
	 */
	public List<GoodsInfoPo> selectIntegralConvertGoodsList(GoodsInfoPo po){
		return weiXinIntegralSelectDao.selectIntegralConvertGoodsList(po);
	}
	
	/**
	 * 获取积分兑换商品信息
	 * @param po
	 * @return
	 */
	public GoodsInfoPo selectIntegralConvertGoods(GoodsInfoPo po){
		return weiXinIntegralSelectDao.selectIntegralConvertGoods(po);
	}
	
	/**
	 * 增加积分兑换设置
	 * 
	 */
	public void insertWXIntegralExchangeSet(WeiXinIntegralSelectPo po){
		weiXinIntegralSelectDao.insertWXIntegralExchangeSet(po);
	}
	
	/**
	 * 插入积分增减
	 * @param po
	 */
	public void insertIntegralAddandSubPo(IntegralAddandSubPo po){
		weiXinIntegralSelectDao.insertIntegralAddandSubPo(po);
	}
	
	/**
	 * 插入积分增减
	 * @param po
	 */
	public void insertIntegralSelectPo(WeiXinIntegralSelectPo wpo,IntegralAddandSubPo ipo,CustomerInfoPo cpo,LogisticsLogPo logPo){
		
		
		weiXinIntegralSelectDao.insertWXIntegralExchangeSet(wpo);
		weiXinIntegralSelectDao.insertLog(wpo);
		weiXinIntegralSelectDao.updateCustomerInfoIntegral(cpo);
		weiXinIntegralSelectDao.insertIntegralAddandSubPo(ipo);
		logisticsLogDao.insertLog(logPo);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public int selectInGoodsNum(String openID,String goodsid){
		return weiXinIntegralSelectDao.selectInGoodsNum(openID, goodsid);
	}
	public int  selectDepIsClosed(String depID){
		return weiXinIntegralSelectDao.selectDepIsClosed(depID);
	}
}
