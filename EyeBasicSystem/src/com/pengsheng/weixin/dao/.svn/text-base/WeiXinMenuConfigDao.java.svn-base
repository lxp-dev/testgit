package com.pengsheng.weixin.dao;

import java.util.List;

import com.pengsheng.weixin.persistence.WeiXinMenuPo;
import com.pengsheng.weixin.persistence.WeiXinMenuTypePo;

public interface WeiXinMenuConfigDao {
	/**
	 * 获取所有Menu
	 * @param po
	 */
	public WeiXinMenuPo getWeiXinMenuPo();
	
	/**
	 * 新增微信配置Menu
	 */
	public void insertWeiXinMenuPo(WeiXinMenuPo po);	
	
	/**
	 * 更新配置Menu
	 */
	public void updateWeiXinMenuPo(WeiXinMenuPo po);	
	
	/**
	 * 更新配置Menu参数
	 */
	public void updateWeiXinMenuDetail(String menuID,String typeID,String weburl);
	
	/**
	 * 获取所有MenuType
	 * @param po
	 */
	public List<WeiXinMenuTypePo> getWeiXinMenuTypeList();
}
