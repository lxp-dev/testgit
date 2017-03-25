/**
 * 
 */
package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

/**
 * @author Liuqian
 * 
 */
public interface ArrearsMgr {

	/**
	 * 取顾客会员信息
	 * 
	 * @param po
	 *            会员号或顾客号
	 * @return
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po);

	/*
	 * 欠费查询
	 */
	public List<SalesBasicPo> getArrears(SalesBasicPo salesBasicPo);
	
	/**
	 * 补齐欠款更新
	 * @param salesID
	 * @param logPo
	 */
	public void updateArrears(SalesBasicPo salesBasicPo,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist,LogisticsLogPo logPo,WeixinInviteFriendLogPo weixinInviteFriendLogPo,SystemParameterPo systemParameterPo);
	
	/**
	 * 获取当前收银员当天累计金额
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getArrearsValues(SalesBasicPo salesBasicPo);
	/**
	 * 获取当前收银员当天累计实收金额
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getArrearsValuesToo(SalesBasicPo salesBasicPo);

}
