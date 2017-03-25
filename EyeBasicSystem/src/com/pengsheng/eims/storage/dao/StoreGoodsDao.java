package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.TracEntryPo;
import com.pengsheng.eims.storage.persistence.TracPo;


public interface StoreGoodsDao 
{
	public int getStoreGoodsCount(TracPo po);
	
	public List<TracPo> getStoreGoodsList(TracPo po,int start, int size);
	
	public TracPo getStoreGoods(TracPo po);
		
	public List<TracEntryPo> getStoreGoodsEntryList(TracPo po);
	
	public List<TracEntryPo> getStoreGoodsDetailList(TracPo po);
	
	public void insertStoreGoods(TracPo po);
	
	public void insertStoreGoodsEntry(TracEntryPo po);
	public void insertAllocationStatus(TracPo po);
	
	public void updateStoreGoods(TracPo po);
	
	public void deleteStoreGoods(TracPo po);
	
	public void deleteStoreGoodsEntry(TracPo po);
	
	public List<TracEntryPo> getReallocationList(TracPo po);
	/**
	 * 新增业务单据的商品条码
	 * 
	 * @param poID
	 */
	public void insertGoodsBarCode(AllocationBarcodePo allocationBarcodePo);
	
	/**
	 * 删除业务单据的商品条码
	 * 
	 * @param poID
	 */
	public void deleteGoodsBarCode(TracPo po);
	
	/**
	 * 获取业务单据商品条码
	 * @param po
	 * @return
	 */
	public List<AllocationBarcodePo> getTracBarcode(TracPo po);
	/**
	 * 取客户列表
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */
	public List<DepartmentsPo>  getFranchisees();
	public List<DepartmentsPo>  getFranchisees(DepartmentsPo dpo);
	
	/**
	 * 取指定客户
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */
	public DepartmentsPo getFranchisee(String id);
	
	
	/**
	 * 新增客户往来账明细
	 */
	public void insertFranchiseeCurrentAccountDetail(TracPo po);
	
	/**
	 * 新增客户批发退货单往来账明细
	 */
	public void insertFranchiseeReturnCurrentAccountDetail(TracPo po);
	
	/**
	 * 删除客户往来账明细
	 */
	public void deleteFranchiseeCurrentAccountDetail(TracPo po);
	
	/**
	 *  新增客户批发调货在途库存
	 */
	public void insertFranchiseeOutInTransitStorage(TracPo po);
	
	/**
	 * 获取批发申请商品信息
	 * @param po
	 * @return
	 */
	public List<TracEntryPo> getWholeApplyGoodsEntryList(TracPo po);
}
