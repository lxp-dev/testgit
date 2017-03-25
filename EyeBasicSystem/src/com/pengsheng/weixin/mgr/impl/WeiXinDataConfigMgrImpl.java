package com.pengsheng.weixin.mgr.impl;

import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinDataConfigDao;
import com.pengsheng.weixin.mgr.WeiXinDataConfigMgr;
import com.pengsheng.weixin.persistence.WeiXinDataConfigPo;

public class WeiXinDataConfigMgrImpl implements WeiXinDataConfigMgr {

	private WeiXinDataConfigDao weiXinDataConfigDao;
		
	/**
	 * 获取微信数据配置
	 * @param po
	 */
	public WeiXinDataConfigPo getWeiXinDataConfigPo(){
		WeiXinDataConfigPo returnWeiXinDataConfigPo = weiXinDataConfigDao.getWeiXinDataConfigPo();
		if(!Utility.getName(returnWeiXinDataConfigPo.getWdcdepartmentpicurl()).equals("")){
			returnWeiXinDataConfigPo.setWdcdepartmentpicurl2(returnWeiXinDataConfigPo.getWdcdepartmentpicurl()+",");			
		}
		if(!Utility.getName(returnWeiXinDataConfigPo.getWdccmslargepicurl()).equals("")){
			returnWeiXinDataConfigPo.setWdccmslargepicurl2(returnWeiXinDataConfigPo.getWdccmslargepicurl()+",");			
		}
		if(!Utility.getName(returnWeiXinDataConfigPo.getWdccmssmallpicurl()).equals("")){
			returnWeiXinDataConfigPo.setWdccmssmallpicurl2(returnWeiXinDataConfigPo.getWdccmssmallpicurl()+",");			
		}	
		if(!Utility.getName(returnWeiXinDataConfigPo.getWdcpersoncenterpicurl()).equals("")){
			returnWeiXinDataConfigPo.setWdcpersoncenterpicurl2(returnWeiXinDataConfigPo.getWdcpersoncenterpicurl()+",");			
		}		
		return returnWeiXinDataConfigPo;
	}
	
	
	/**
	 * 新增微信数据配置
	 */
	public void insertWeiXinDataConfigPo(WeiXinDataConfigPo po){
		weiXinDataConfigDao.deleteWeiXinDataConfigPo();
		weiXinDataConfigDao.insertWeiXinDataConfigPo(po);
	}

	public WeiXinDataConfigDao getWeiXinDataConfigDao() {
		return weiXinDataConfigDao;
	}


	public void setWeiXinDataConfigDao(WeiXinDataConfigDao weiXinDataConfigDao) {
		this.weiXinDataConfigDao = weiXinDataConfigDao;
	}	
}
