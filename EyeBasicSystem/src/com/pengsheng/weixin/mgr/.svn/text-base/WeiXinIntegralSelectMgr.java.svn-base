package com.pengsheng.weixin.mgr;

import java.util.List;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;

public interface WeiXinIntegralSelectMgr {
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po);
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po, int start,int size);
	
	public int getWeiXinIntegralSelectCount(WeiXinIntegralSelectPo po) ;
	
	/**
	 * 获取积分兑换顾客信息
	 * @param po
	 * @return
	 */
	public CustomerInfoPo selectCustomerInfoPo(CustomerInfoPo po);
	
	/**
	 * 获取积分兑换商品信息
	 * @param po
	 * @return
	 */
	public List<GoodsInfoPo> selectIntegralConvertGoodsList(GoodsInfoPo po);
	
	/**
	 * 获取积分兑换商品信息
	 * @param po
	 * @return
	 */
	public GoodsInfoPo selectIntegralConvertGoods(GoodsInfoPo po);
	
	/**
	 * 增加积分兑换设置
	 * 
	 */
	public void insertWXIntegralExchangeSet(WeiXinIntegralSelectPo po);
	
	public int selectInGoodsNum(String openID,String goodsid);
	
	/**
	 * 插入积分增减
	 * @param po
	 */
	public void insertIntegralAddandSubPo(IntegralAddandSubPo po);
	
	public void insertIntegralSelectPo(WeiXinIntegralSelectPo wpo,IntegralAddandSubPo ipo,CustomerInfoPo cpo,LogisticsLogPo logPo);
	
	public int  selectDepIsClosed(String depID);
	
}
