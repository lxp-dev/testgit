package com.pengsheng.weixin.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.weixin.persistence.ConfigurationPo;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;
import com.pengsheng.weixin.persistence.WeiXinMenuCreateReturnCodePo;

public interface ConfigurationMgr {

	/**
	 * 查询微信配置管理信息
	 */
	public ConfigurationPo getConfigurationDetail();
	
	/**
	 * 新增微信配置管理信息
	 */
	public void insertConfigurationInfo(ConfigurationPo po,LogisticsLogPo logPo);
	
	/**
	 * 根据openID查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfoByOpenID(CustomerInfoPo po);
	
	/**
	 * 修改顾客信息
	 */
	public void updateCustomerInfoByOpenID(CustomerInfoPo po);
	
	/**
	 * 修改顾客微信pic
	 */
	public void updateCustomerInfoWeixinPic(String openID,String picUrl);

	/**
	 * 解绑微信Openid
	 */
	public void updateClearOpenId(String customerID);
	
	/**
	 * 根据电话查询是否是老客户
	 */
	public int getCustomerCountByPhone(CustomerInfoPo po);
	
	/**
	 * 更新老客户openid
	 */
	public void updateCustomerOpenID(CustomerInfoPo po);
	
	/**
	 * 新增客户
	 */
	public void insertCustomerOpenID(CustomerInfoPo po);
	
	/**
	 * 查询会员积分兑换的商品总数
	 */
	public int getIntegralExchangeCountByCustomer(CustomerInfoPo po);
	
	/**
	 * 查询会员积分兑换的商品总数
	 */
	public List<WeiXinIntegralSelectPo> getIntegralExchangeListByCustomer(CustomerInfoPo po,int start,int size);
	
	/**
	 * 查询会员消费的配镜单
	 */
	public List<SalesBasicPo> getSalesBillInfoByCustomer(CustomerInfoPo po);
	
	/**
	 * 查询会员消费的定制配镜单
	 */
	public List<SalesBasicPo> getDzSalesBillInfoByCustomer(CustomerInfoPo po);
	
	/**
	 * 查询会员消费的配镜单的商品
	 */
	public List<SalesDetailPo> getSalesBillDetailByCustomer(CustomerInfoPo po);
	
	/**
	 * 根据配镜单号查询在途
	 */
	public SalesBasicPo getSalesBillByCustomer(CustomerInfoPo po);
	
	/**
	 * 创建为新菜单后，根据返回值获得中文说明
	 */
	public WeiXinMenuCreateReturnCodePo getCreateMenuReturnTitle(String returnCode);
	
}
