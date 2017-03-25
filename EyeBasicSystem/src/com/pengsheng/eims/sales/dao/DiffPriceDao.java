/**
 * 
 */
package com.pengsheng.eims.sales.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesPostBasicPo;
import com.pengsheng.eims.sales.persistence.SalesPostDetailPo;

/**
 * @author Liuqian
 * 
 */
public interface DiffPriceDao {

	/**
	 * 取顾客会员信息
	 * 
	 * @param po
	 *            会员号或顾客号
	 * @return
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po,SalesBasicPo salesBasicPo);
	/*
	 * 取调价
	 */
	public List<SalesBasicPo> getDiffPrices(SalesBasicPo salesBasicPo,String departmentID);
	/*
	 * 取配镜单
	 */
	public SalesBasicPo getSalesBasicPo(String salesID);
	/*
	 * 取配镜单明细
	 */
	public List<SalesDetailPo> getSalesDetail(String ssesdsalesid);
	
	/*
	 * 插入退差价基表
	 */
	public void insertBasic(SalesPostBasicPo salesPostBasicPo);

	/*
	 * 插入退差价明细表
	 */
	public void insertDetail(SalesPostDetailPo salesPostDetailPo);
	
	/*
	 * 插入退差价基表
	 */
	public void updateBasic(SalesPostBasicPo salesPostBasicPo);

	/*
	 * 插入退差价明细表
	 */
	public void updateDetail(SalesPostDetailPo salesPostDetailPo);
	
	public void updateCustomerIntegral(String customerID,float ssespbpostvalue);
	
	//获得商品明细信息
	public List<SalesDetailPo> getSalesDetails(String oldsalesid);
	
	//将退差价单号商品添加到新单号内，更新销售基表S_SE_SalesBasic金额
	public void insertSalesBasic(SalesBasicPo salesBasicPo,String newsalesid);
	
	//将退差价单号商品添加到新单号内，更新销售明细表S_SE_SalesDetails金额
	public void insertSalesDetails(SalesDetailPo salesDetailPo,String newsalesid);

	//更新退款标示
	public void updateSalesBasic(SalesBasicPo salesBasicPo);
	
	//退货更新第三张库存表(入库)
	public void insertStrogeChange(SalesDetailPo salesDetailPo);
	
	//退货更新第三张库存表(出库)
	public void insertOutStrogeChange(SalesDetailPo salesDetailPo,String newsalesid);
	
	//退货更新第四张库存表(入库)
	public void insertStrogeLog(SalesDetailPo salesDetailPo);
	
	//退货更新第四张库存表(出库)
	public void insertOutStrogeLog(SalesDetailPo salesDetailPo,String newsalesid);
	
	//插入在途表
	public void insertIntransitInfo(InTransitPo inTransitPo,String newsalesid);
	//插入原单号在途表14
	public void insertYIntransitInfo(InTransitPo inTransitPo);
	//取得仓位
	public WarehousePo getWarehouse(String deptID);
	
	//得到在途List 1,2,13
	public List<InTransitPo> getIntransitInfo(InTransitPo inTransitPo);
}
