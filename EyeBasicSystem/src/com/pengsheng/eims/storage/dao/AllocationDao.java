package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StatusPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;

public interface AllocationDao {
	
	public int getAllocationCount(AllocationPo po,DepartmentsPo departmentsPo);
	
	//查询调拨申请商品信息
	public List<AllocationEntryPo> getAlllyList(AllocationPo allocationPo) ;
	
	public List<AllocationPo> getAllocationList(AllocationPo po,DepartmentsPo departmentsPo,int start, int size);
	
	public int getReAllocationCount(AllocationPo po,DepartmentsPo departmentsPo);
	
	public List<AllocationPo> getReAllocationList(AllocationPo po,DepartmentsPo departmentsPo,int start, int size);
	
	public void insertAllocation(AllocationPo po);
	
	public void insertAllocationEntry(AllocationEntryPo po);
	
	public void updateAllocation(AllocationPo po);
	
	public void deleteAllocation(AllocationPo po);
	
	public AllocationPo getAllocation(AllocationPo po);
	
	public List<AllocationEntryPo> getAllocationEntryList(AllocationPo po);
	public List<AllocationEntryPo> getAllocationEntryList2(AllocationPo po);
	
	public void deleteAllocationEntry(AllocationPo po);	
	
	public void updateAllocationReceive(AllocationPo po);
	
	public void insertAllocationForInventory(InventoryPo po);
	
	public void insertAllocationForInventoryEntry(InventoryEntryPo po);
	/**
	 * 调拨申请使用状态
	 */
	public void updateAllocationReceive1(AllocationPo po);
	
	public void returnAudit(String billID);
	
	public void insertSms(SmsLertsPo smsLertsPo);
	
	public void insertAllocationBarcode(AllocationBarcodePo allocationBarcodePo);
	
	public void deleteAllocationBarcode(AllocationPo allocationPo) ;
	
	public List<AllocationBarcodePo> getAllocationBarcode(AllocationPo allocationPo);
	
	public List<AllocationBarcodePo> getAllocationBarcode(AllocationPo allocationPo,String goodsID);
	
	public int getAllocationCount(AllocationPo allocationPo);
	
	public List<AllocationEntryPo> getApplyList(AllocationPo allocationPo);
	
	public List<AllocationEntryPo> getReallocationList(AllocationPo allocationPo);
	
	public List<AllocationEntryPo> getReceiptList(AllocationPo allocationPo);
	
	public void insertAllocationReceiptStatus(AllocationPo allocationPo);
	public void insertAllocationApplyReceiptStatus(AllocationPo allocationPo);
	
	public void insertAllocationStatus(AllocationPo allocationPo);
	public void insertAllocationApplyStatus(AllocationPo allocationPo);
	
	/**
	 * 获取调拨单
	 */
	public StatusPo getStatusPo(StatusPo statusPo);
	
	public List<AllocationEntryPo> getAllocationBarcode(String billid);
	/**
	 * 调拨申请使用状态
	 */
	public void updateAllocationReceive2(AllocationPo po) ;
	
	/**
	 * 获取商品信息
	 */
	public GoodsInfoPo getGoodsInfoPo(GoodsInfoPo po);
	
	public void updateAllocationEntryOutStorageFlag(InventoryEntryPo entryPo);
	
	/**
	 * 收货时判断当前调拨单是否存在
	 */
	public int isExistAllocationBillByID(String billID);
	
	/**
	 * 获取调拨明细
	 */
	public List<AllocationEntryPo> getNotInTransitStorageGoods(AllocationPo po);
	
	/**
	 * 判断当前库存是否满足调拨条件
	 * @param po
	 * @return
	 */
	public List<GoodsInfoPo> checkNumber(GoodsInfoPo po);
	
	/**
	 * 更新调拨申请单的核销状态
	 */
	public void updateAllocationAppStatus(AllocationPo po);
	
	/**
	 * 删除调拨申请单的核销状态
	 */
	public void deleteAllocationAppStatus(AllocationPo po);
	
	public void updateAllocationPrintType(AllocationPo po);
	
	public List<InventoryEntryPo> getAlllyList(String allbillid,String outstockid,String supplieriD) ;
	
	/**
	 * 根据条码获取效期、批号和注册证号
	 */
	public AllocationEntryPo getGoodsRegistrationNumByBarcode(AllocationEntryPo epo);
	
	public int getAllocationSettlementCount(AllocationPo po,DepartmentsPo departmentsPo);
	
	public List<AllocationPo> getAllocationSettlementList(AllocationPo po,DepartmentsPo departmentsPo,int start, int size);
	
	public AllocationPo getAllocationSettlement(AllocationPo po);
	
	public List<AllocationEntryPo> getAllocationSettlementEntry(AllocationPo po);
	
	public void updateAllocationSettlementEntry(List<InventoryEntryPo> eList);
	
	public void updateAllocationSettlement(AllocationPo po);
	
}
