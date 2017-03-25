/**
 * 
 */
package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;

/**
 * @author Liuqian
 * 
 */
public interface ArrearsDao {
	

	/**
	 * 取顾客会员信息
	 * 
	 * @param po
	 *            会员号或顾客号
	 * @return
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po);
	/**
	 * 获取当前收银员当天累计实收金额
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getArrearsValuesToo(SalesBasicPo salesBasicPo);

	/*
	 * 欠费查询
	 */
	public List<SalesBasicPo> getArrears(SalesBasicPo salesBasicPo);
	
	/*
	 * 更改欠费状态
	 */
	public void updateArrears(SalesBasicPo salesBasicPo);
	public void updateArrearsToday(SalesBasicPo salesBasicPo);
	
	public void insertCustomizeTui(String salesID);
	
	/**
	 * 获取当前收银员当天累计金额
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getArrearsValues(SalesBasicPo salesBasicPo);
	public SalesBasicPo getArrearsValuesFinished(SalesBasicPo salesBasicPo);
	
}
