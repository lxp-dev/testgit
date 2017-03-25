package com.pengsheng.eims.basic.mgr;

import java.io.File;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface SupplierAgentMgr {
	
	/**
	 * 查询制造商的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getSupplierCount(SupplierPo po);
	
	/**
	 * 
	 * 遍历制造商并实现分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SupplierPo> getSupplierList(SupplierPo po,int start, int size);
	/**
	 * 新增制造商信息
	 * 
	 * @param po
	 */
	public void insertSupplier(SupplierPo po,LogisticsLogPo logPo);
	/**
	 * 修改制造商信息
	 * 
	 * @param po
	 */
	public void updateSupplier(SupplierPo po,LogisticsLogPo logPo);  
	/**
	 * 修改制造商信息(更新品种采购结算方式)
	 * 
	 * @param po
	 */
	public void updateSupplier(SupplierPo po, String updateBrand, LogisticsLogPo logPo); 
	/**
	 * 修改制造商信息
	 * 
	 * @param po
	 */
	public void updateSupplierAccount(SupplierPo po,LogisticsLogPo logPo);
					
	/**
	 * 删除制造商信息
	 * 
	 * @param po
	 */
	public void deleteSupplier(SupplierPo po,LogisticsLogPo logPo);
	/**
	 * 查询制造商信息
	 * 
	 * @param po
	 * @return
	 */
	public SupplierPo getSupplier(SupplierPo po);
	/**
	 * 遍历商品类别
	 * 
	 * @return
	 */
	public List<GoodsCategoryPo> getGoodsCategoryList();
	/**
	 * 修改停用信息
	 * 
	 * @param po
	 */
	public void updateSupplierDisable(SupplierPo po,LogisticsLogPo logPo);
	/**
	 * 根据制造商ID查找商品数量
	 * 
	 * @param supplierID
	 * @return
	 */
	public int getBrandCount(String supplierID);
	
	/**
	 * 制造商批量导入
	 * 
	 * @param supplierPos
	 */
	public void insertSupplier(List<SupplierPo> supplierPos);
	
	public int getGoodsCount(SupplierPo supplierPo);
}
