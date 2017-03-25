/**
 * 
 */
package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;

/**
 * @author Liuqian
 * 
 */
public interface AccSalesMgr {

	/**
	 * 取顾客会员信息
	 * 
	 * @param po
	 *            会员号或顾客号
	 * @return
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po);

	/**
	 * 插入配镜主表
	 * 
	 * @param salesBasicPo
	 */
	public void insertSalesBasic(SalesBasicPo salesBasicPo,SalesDetailPo salesDetailPo,GiftsPo giftsPo,InTransitPo inTransitPo,LogisticsLogPo logPo);


}
