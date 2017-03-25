package com.pengsheng.weixin.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.weixin.persistence.WeiXinMenuPo;
import com.pengsheng.weixin.persistence.WeiXinMenuTypePo;

public interface WeiXinMenuConfigMgr {
	
	/**
	 * 获取所有Menu
	 * @param po
	 */
	public WeiXinMenuPo getWeiXinMenuPo();
	
	
	/**
	 * 新增微信配置Menu
	 */
	public void insertWeiXinMenuPo(WeiXinMenuPo po,LogisticsLogPo logPo);
	
	/**
	 * 更新配置Menu参数
	 */
	public void updateWeiXinMenuDetail(String menuID,String typeID,String weburl , LogisticsLogPo logPo);
	
	/**
	 * 获取所有MenuType
	 * @param po
	 */
	public List<WeiXinMenuTypePo> getWeiXinMenuTypeList();
}
