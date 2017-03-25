/**
 * 
 */
package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesPostBasicPo;
import com.pengsheng.eims.sales.persistence.SalesPostDetailPo;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public interface DiffPriceMgr {

	/**
	 * 取顾客会员信息
	 * 
	 * @param po
	 *            会员号或顾客号
	 * @return
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po,SalesBasicPo salesBasicPo);

	/**
	 * 取配镜单
	 */
	public List<SalesBasicPo> getDiffPrices(SalesBasicPo salesBasicPo,String departmentID);
	
	public List<SalesDetailPo> getSalesDetail(String ssesdsalesid) ;
	
	public SalesBasicPo getSalesBasicPo(String salesID);
	
	public void insertDetail(SalesPostDetailPo salesPostDetailPo);
	
	public void insertBasic(SalesPostBasicPo salesPostBasicPo,SalesPostDetailPo salesPostDetailPo);
	
	public void updateBasic(SalesPostBasicPo salesPostBasicPo);
	
	public void UpdateDetail(SalesPostDetailPo salesPostDetailPo);
	
	public void updateCustomerIntegral(String customerID,float ssespbpostvalue);
	
	//退差价方法调用
	public void insertPost(SalesBasicPo salesBasicPo,List<SalesDetailPo> salesDetailPos,InTransitPo inTransitPo,SalesPostBasicPo salesPostBasicPo,String newsalesid);
	
	//取得门店仓位
	public WarehousePo getWarehouse(String deptID);
	
	public List<SalesDetailPo> getSalesDetails(String ssesdsalesid);
}
