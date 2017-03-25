/**
 * 
 */
package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;

/**
 * @author Liuqian
 * 
 */
public interface AccSalesDao {

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
	public void insertSalesBasic(SalesBasicPo salesBasicPo);

	/**
	 * 插入明细表
	 * 
	 * @param salesDetailPo
	 */
	public void insertSalesDetail(SalesDetailPo salesDetailPo);
	
	public void insertIntrnsitInfo(InTransitPo inTransitPo) ;
}
