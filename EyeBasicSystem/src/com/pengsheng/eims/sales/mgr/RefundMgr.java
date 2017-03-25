/**
 * 
 */
package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

/**
 * @author Liuqian
 * 
 */
public interface RefundMgr {

	/**
	 * 得到打印镜单信息
	 */
	public List<SalesBasicPo> getSalesBasics(SalesBasicPo salesBasicPo);
	
	
	/**
	 * 得到打印镜单信息
	 */
	public List<SalesBasicPo> getSalesBasics(SalesBasicPo salesBasicPo,SystemParameterPo systemParameterPo, int start , int size);
	
	/**
	 * 得到打印镜单信息数量
	 */
	public int getSalesBasicsCount(SalesBasicPo salesBasicPo,SystemParameterPo systemParameterPo);
	

	/**
	 * 销售退款
	 * 
	 * @param salesBasicPo
	 * @param inTransitPo
	 */
	public void insertSalesGutiar(SalesBasicPo salesBasicPo,InTransitPo inTransitPo,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist,LogisticsLogPo logPo, WeixinInviteFriendLogPo weixinInviteFriendLogPo, SystemParameterPo systemParameterPo);

	/**
	 * 根据配镜单号查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo customerInfoPo);
	
	public SalesBasicPo getSalesBasicPo(String salesID);
	
	/**
	 * 部分商品退款
	 * 
	 * @param salesBasicPo
	 * @param inTransitPo
	 */
	public String insertPartSalesGutiar(SalesBasicPo salesBasicPo,InTransitPo inTransitPo,PersonInfoPo personInfoPo,List<SalesDetailPo> salesDetailList,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist,LogisticsLogPo logPo);
	
	/**
	 * 部分商品换货
	 * 
	 * @param salesBasicPo
	 * @param inTransitPo
	 */
	public String insertPartSwapGoodsSalesGutiar(SalesBasicPo salesBasicPo,InTransitPo inTransitPo,PersonInfoPo personInfoPo,List<SalesDetailPo> salesDetailList,SalesDetailPo salesDetailPo,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist,LogisticsLogPo logPo);
	/**
	 * 
	 * 
	 * @param salesBasicPo
	 * @param inTransitPo
	 */
	public List<SalesLogPo> getSalesLogList(SalesLogPo salesLogPo);
}
