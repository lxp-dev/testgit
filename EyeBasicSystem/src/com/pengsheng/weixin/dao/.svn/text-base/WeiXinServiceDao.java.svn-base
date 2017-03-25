package com.pengsheng.weixin.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.CustomerComplainPo;
import com.pengsheng.weixin.persistence.WeiXinLuckDrawPo;

public interface WeiXinServiceDao {
	
	/**
	 * 获取微信用户在eims系统中的资料
	 * 
	 * @return
	 */
	public CustomerInfoPo getWeiXinCustomer(String openID);
	
	/**
	 * 获取销售记录
	 * 
	 * @return
	 */
	public int getSalesCount(String openID);
	
	/**
	 * 获取销售门店信息
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsList();
	
	/**
	 * 获取销售门店信息Po
	 * 
	 * @return
	 */
	public DepartmentsPo getDepartmentsPo(DepartmentsPo po);
	
	/**
	 * 获取会员中奖信息
	 * 
	 * @return
	 */
	public WeiXinLuckDrawPo getLuckDrawPo(String openID);
	
	/**
	 * 获取会员中奖信息列表
	 * 
	 * @return
	 */
	public List<WeiXinLuckDrawPo> getLuckDrawlist(String openID);
	
	/**
	 * 获取投诉PO
	 * @param customerComplainPo
	 * @return
	 */
	public CustomerComplainPo selectCustomerComplainPo(CustomerComplainPo customerComplainPo);	
}
