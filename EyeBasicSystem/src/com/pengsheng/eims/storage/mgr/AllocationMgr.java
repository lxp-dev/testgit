package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.StatusPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface AllocationMgr {

	public int getAllocationCount(AllocationPo po,DepartmentsPo departmentsPo);
	
	//查询调拨申请商品信息
	public List<AllocationEntryPo> getAlllyList(AllocationPo allocationPo) ;
	
	public List<AllocationPo> getAllocationList(AllocationPo po,DepartmentsPo departmentsPo,int start, int size);
	
	public int getReAllocationCount(AllocationPo po,DepartmentsPo departmentsPo);
	
	public List<AllocationPo> getReAllocationList(AllocationPo po,DepartmentsPo departmentsPo,int start, int size);
	
	public void insertAllocation(AllocationPo po,List<AllocationEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo);
	
	public void updateAllocation(AllocationPo po,List<AllocationEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo);
	
	public void deleteAllocation(AllocationPo po,List<PersonInfoPo> personInfoList,SmsLertsPo smsLertsPo,LogisticsLogPo logPo,AllocationPo tempAllocationPo);
		
	public AllocationPo getAllocation(AllocationPo po);
	
	public List<AllocationEntryPo> getAllocationEntryList(AllocationPo po);
	public List<AllocationEntryPo> getAllocationEntryList2(AllocationPo po);
	
	public void updateAllocationReceive(AllocationPo po,List<InventoryEntryPo> entryList,LogisticsLogPo logPo);
	
	public void returnAudit(String billID);
	
	public void insertSms(SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList);
	
	public List<AllocationBarcodePo> getAllocationBarcode(AllocationPo allocationPo);
	
	public int getAllocationCount(AllocationPo po);
	
	public List<AllocationEntryPo> getApplyList(AllocationPo po);
	
	public List<AllocationEntryPo> getReallocationList(AllocationPo po);
	
	public List<AllocationEntryPo> getReceiptList(AllocationPo po);
	
	/**
	 * 获取调拨单
	 */
	public StatusPo getStatusPo(StatusPo statusPo);
	
	public List<AllocationEntryPo> getAllocationBarcode(String billid);
	/**
	 * 调拨申请使用状态
	 */
	public void updateAllocationReceive1(AllocationPo po);
	
	/**
	 * 获取商品信息
	 */
	public GoodsInfoPo getGoodsInfoPo(GoodsInfoPo po);
	
	public void updateAllocationEntryOutStorageFlag(List<InventoryEntryPo> entryList);
	
	/**
	 * 收货时判断当前调拨单是否存在
	 */
	public int isExistAllocationBillByID(String billID);
	
	/**
	 * 判断当前库存是否满足调拨条件
	 * @param po
	 * @return
	 */
	public List<GoodsInfoPo> checkNumber(GoodsInfoPo po);
	
	public void updateAllocationPrintType(AllocationPo po);
	
	public List<InventoryEntryPo> getAlllyList(String allbillid,String outstockid,String supplieriD) ;
	
	public int getAllocationSettlementCount(AllocationPo po,DepartmentsPo departmentsPo);
	
	public List<AllocationPo> getAllocationSettlementList(AllocationPo po,DepartmentsPo departmentsPo,int start, int size);
		
	public AllocationPo getAllocationSettlement(AllocationPo po);
	
	public List<AllocationEntryPo> getAllocationSettlementEntry(AllocationPo po);
	
	public void updateAllocationSettlementEntry(AllocationPo po,List<InventoryEntryPo> entryList,LogisticsLogPo logPo);
	
}
