package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;

public interface ProcessDistributionDao {

	/**
	 * 获取门店
	 * @param po
	 * @return
	 */
	public List<WarehousePo> getWarehouseList(DepartmentsPo po);
	public List<WarehousePo> getWarehouseList(SalesBasicPo po);
	
	/** 
	 * 查询隐形订做片配送信息
	 * @return
	 */
	//public List<SalesBasicPo> getSalesBasicPos(String customerID);
	public List<SalesBasicPo> getSalesBasicPos(SalesBasicPo salesBasicPo);
	
	/**
	 * 修改在途状态
	 * @param salesBasicPo
	 */
	public void updateSalesBasicPos(SalesBasicPo salesBasicPo);

	/**
	 * 新增在途查询明细表
	 * @param po
	 */
	public void insertInTransit(InTransitPo inTransitPo);
	/**
	 * 新增配送记录主表
	 * @param po
	 */
	public String insertDistribution(DistributionPo distributionPo);
	/**
	 * 新增配送记录明细表
	 * @param po
	 */
	public void insertDistributionEntry(DistributionPo distributionPo,DistributionEntryPo  distributionEntryPo);
}
