package com.pengsheng.weixin.dao;

import com.pengsheng.weixin.persistence.WeiXinDataConfigPo;

public interface WeiXinDataConfigDao {

	/**
	 * 获取微信数据配置
	 * @param po
	 */
	public WeiXinDataConfigPo getWeiXinDataConfigPo();
	
	
	/**
	 * 新增微信数据配置
	 */
	public void insertWeiXinDataConfigPo(WeiXinDataConfigPo po);
	
	/**
	 * 删除微信数据配置
	 */
	public void deleteWeiXinDataConfigPo();	
	
}
