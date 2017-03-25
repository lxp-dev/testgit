package com.pengsheng.weixin.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;

public interface WeiXinIntegralSelectDao {
	
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po, int start,int size);
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po);
	
	public int getWeiXinIntegralSelectCount(WeiXinIntegralSelectPo po) ;
	
	/**
	 * 获取积分兑换顾客信息
	 * @param po
	 * @return
	 */
	public CustomerInfoPo selectCustomerInfoPo(CustomerInfoPo po);
	public void insertLog(WeiXinIntegralSelectPo po);
	
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
	
	/**
	 * 插入积分增减
	 * @param po
	 */
	public void insertIntegralAddandSubPo(IntegralAddandSubPo po);
	
	/**
	 * 更新会员积分
	 */
	public void updateCustomerInfoIntegral(CustomerInfoPo po);
	
	public int selectInGoodsNum(String openID,String goodsid);
	
	public int  selectDepIsClosed(String depID);
}
