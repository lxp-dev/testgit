package com.pengsheng.weixin.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.CustomerComplainPo;
import com.pengsheng.weixin.dao.WeiXinServiceDao;
import com.pengsheng.weixin.mgr.WeiXinServiceMgr;
import com.pengsheng.weixin.persistence.WeiXinLuckDrawPo;

public class WeiXinServiceMgrImpl implements WeiXinServiceMgr {
	
	private WeiXinServiceDao weiXinServiceDao;
	
	public WeiXinServiceDao getWeiXinServiceDao() {
		return weiXinServiceDao;
	}

	public void setWeiXinServiceDao(WeiXinServiceDao weiXinServiceDao) {
		this.weiXinServiceDao = weiXinServiceDao;
	}

	
	/**
	 * 获取微信用户在eims系统中的资料
	 * 
	 * @return
	 */
	public CustomerInfoPo getWeiXinCustomer(String openID){
		
		return weiXinServiceDao.getWeiXinCustomer(openID);
	}

	/**
	 * 获取销售记录
	 * 
	 * @return
	 */
	public int getSalesCount(String openID){
		
		return weiXinServiceDao.getSalesCount(openID);
	}
	
	/**
	 * 获取销售门店信息
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsList(){
		
		return weiXinServiceDao.getDepartmentsList();
	}
	
	/**
	 * 获取销售门店信息Po
	 * 
	 * @return
	 */
	public DepartmentsPo getDepartmentsPo(DepartmentsPo po){
		
		return weiXinServiceDao.getDepartmentsPo(po);
	}
	
	/**
	 * 获取会员中奖信息
	 * 
	 * @return
	 */
	public WeiXinLuckDrawPo getLuckDrawPo(String openID){
		
		return weiXinServiceDao.getLuckDrawPo(openID);
	}
	
	/**
	 * 获取会员中奖信息列表
	 * 
	 * @return
	 */
	public List<WeiXinLuckDrawPo> getLuckDrawlist(String openID){
		
		return weiXinServiceDao.getLuckDrawlist(openID);
	}
	
	/**
	 * 获取投诉PO
	 * @param customerComplainPo
	 * @return
	 */
	public CustomerComplainPo selectCustomerComplainPo(CustomerComplainPo customerComplainPo){
		return weiXinServiceDao.selectCustomerComplainPo(customerComplainPo);
	}
}
