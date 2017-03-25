package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.TracEntryPo;
import com.pengsheng.eims.storage.persistence.TracPo;

public interface StoreGoodsMgr 
{
	public int getStoreGoodsCount(TracPo po);
	
	public List<TracPo> getStoreGoodsList(TracPo po,int start, int size);
	
	public TracPo getStoreGoods(TracPo po);
	
	public List<TracEntryPo> getStoreGoodsEntryList(TracPo po);	
	
	public List<TracEntryPo> getStoreGoodsDetailList(TracPo po);	
	
	public void insertStoreGoods(TracPo po,List<TracEntryPo> list,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo);
	
	public void updateStoreGoods(TracPo po,List<TracEntryPo> list,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo);
	
	public void deleteStoreGoods(TracPo po,LogisticsLogPo logPo);
	
	public List<TracEntryPo> getReallocationList(TracPo po);
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
	 * 获取批发申请商品信息
	 * @param po
	 * @return
	 */
	public List<TracEntryPo> getWholeApplyGoodsEntryList(TracPo po);
}
