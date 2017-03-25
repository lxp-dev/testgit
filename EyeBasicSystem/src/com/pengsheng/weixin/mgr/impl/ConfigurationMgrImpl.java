package com.pengsheng.weixin.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.ConfigurationDao;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.persistence.ConfigurationPo;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;
import com.pengsheng.weixin.persistence.WeiXinMenuCreateReturnCodePo;

public class ConfigurationMgrImpl implements ConfigurationMgr {

	private LogisticsLogDao logisticsLogDao;
	private ConfigurationDao configurationDao;
	
	/**
	 * 查询微信配置管理信息
	 */
	public ConfigurationPo getConfigurationDetail(){		
		return configurationDao.getConfigurationDetail();	
	}
	
	/**
	 * 新增微信配置管理信息
	 */
	public void insertConfigurationInfo(ConfigurationPo po,LogisticsLogPo logPo){
		configurationDao.deleteConfigurationInfo();
		configurationDao.insertConfigurationInfo(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 根据openID查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfoByOpenID(CustomerInfoPo po){
		return configurationDao.getCustomerInfoByOpenID(po);
	}
	
	/**
	 * 修改顾客微信pic
	 */
	public void updateCustomerInfoWeixinPic(String openID,String picUrl){
		configurationDao.updateCustomerInfoWeixinPic(openID,picUrl);
	}
	
	/**
	 * 修改顾客信息
	 */
	public void updateCustomerInfoByOpenID(CustomerInfoPo po){
		configurationDao.updateCustomerInfoByOpenID(po);
	}
		
	/**
	 * 解绑微信Openid
	 */
	public void updateClearOpenId(String customerID){
		configurationDao.updateClearOpenId(customerID);
	}
	
	/**
	 * 根据电话查询是否是老客户
	 */
	public int getCustomerCountByPhone(CustomerInfoPo po){
		return configurationDao.getCustomerCountByPhone(po);
	}
	
	/**
	 * 更新老客户openid
	 */
	public void updateCustomerOpenID(CustomerInfoPo po){
		configurationDao.updateCustomerOpenID(po);
	}
	
	/**
	 * 新增客户
	 */
	public void insertCustomerOpenID(CustomerInfoPo po){
		configurationDao.insertCustomerOpenID(po);
	}
	
	/**
	 * 查询会员积分兑换的商品总数
	 */
	public int getIntegralExchangeCountByCustomer(CustomerInfoPo po){
		return configurationDao.getIntegralExchangeCountByCustomer(po);
	}
	
	/**
	 * 查询会员积分兑换的商品总数
	 */
	public List<WeiXinIntegralSelectPo> getIntegralExchangeListByCustomer(CustomerInfoPo po,int start,int size){
		return configurationDao.getIntegralExchangeListByCustomer(po,start,size);
	}
	
	/**
	 * 查询会员消费的配镜单
	 */
	public List<SalesBasicPo> getSalesBillInfoByCustomer(CustomerInfoPo po){
		return configurationDao.getSalesBillInfoByCustomer(po);
	}
	
	/**
	 * 查询会员消费的定制配镜单
	 */
	public List<SalesBasicPo> getDzSalesBillInfoByCustomer(CustomerInfoPo po){
		return configurationDao.getDzSalesBillInfoByCustomer(po);
	}
	
	/**
	 * 查询会员消费的配镜单的商品
	 */
	public List<SalesDetailPo> getSalesBillDetailByCustomer(CustomerInfoPo po){
		return configurationDao.getSalesBillDetailByCustomer(po);
	}
	
	/**
	 * 根据配镜单号查询在途
	 */
	public SalesBasicPo getSalesBillByCustomer(CustomerInfoPo po){
		return configurationDao.getSalesBillByCustomer(po);
	}
	
	/**
	 * 创建为新菜单后，根据返回值获得中文说明
	 */
	public WeiXinMenuCreateReturnCodePo getCreateMenuReturnTitle(String returnCode){
		return configurationDao.getCreateMenuReturnTitle(returnCode);
	}
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public ConfigurationDao getConfigurationDao() {
		return configurationDao;
	}

	public void setConfigurationDao(ConfigurationDao configurationDao) {
		this.configurationDao = configurationDao;
	}

	
}
