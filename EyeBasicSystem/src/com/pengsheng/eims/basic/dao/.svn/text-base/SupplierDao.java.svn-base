package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface SupplierDao {
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
	public void insertSupplier(SupplierPo po);
	public void insertXinZhongDa(SupplierPo po);
	
	public StatusModulePo selectSupplierStaus(String ModuleID);

	/**
	 * 修改制造商下所有品种的采购结算方式
	 * 
	 * @param po
	 */
	public void updateBrandSettlementOfSupplier(SupplierPo supplierPo);
	/**
	 * 修改制造商信息
	 * 
	 * @param po
	 */
	public void updateSupplier(SupplierPo po);
	/**
	 * 删除制造商信息
	 * 
	 * @param po
	 */
	public void deleteSupplier(SupplierPo po);
	
	/**
	 * 修改制造商信息
	 * 
	 * @param po
	 */
	public void updateSupplierAccount(SupplierPo po);
	
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
	public void updateSupplierDisable(SupplierPo po);
	/**
	 * 根据制造商ID查找商品数量
	 * 
	 * @param supplierID
	 * @return
	 */
	public int getBrandCount(String supplierID);
	
	public int getGoodsCount(SupplierPo supplierPo);

	/**
	 * 修改所属品种的停用启用信息
	 * 
	 * @param po
	 */
	public void updateBrandDisable(SupplierPo supplierPo);
	
	/**
	 * 修改所属商品的停用启用信息
	 * 
	 * @param po
	 */
	public void updateGoodsDisable(SupplierPo supplierPo);
}
