package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;

public interface AllocationApplyDao {
	
	public int getAllocationCount(AllocationPo po,DepartmentsPo departmentsPo);
	
	public List<AllocationPo> getAllocationList(AllocationPo po,DepartmentsPo departmentsPo,int start, int size);
	
	public int getReAllocationCount(AllocationPo po,DepartmentsPo departmentsPo);
	
	public List<AllocationPo> getReAllocationList(AllocationPo po,DepartmentsPo departmentsPo,int start, int size);
	
	public void insertAllocation(AllocationPo po);
	
	public void insertAllocationStatus(AllocationPo po);
	
	public void insertAllocationEntry(AllocationEntryPo po);
	
	public void updateAllocation(AllocationPo po);
	
	public void deleteAllocation(AllocationPo po);
	
	public AllocationPo getAllocation(AllocationPo po);
	
	public List<AllocationEntryPo> getAllocationEntryList(AllocationPo po);
	
	public void deleteAllocationEntry(AllocationPo po);	
	
	public void updateAllocationReceive(AllocationPo po);
	
	public void insertAllocationForInventory(InventoryPo po);
	
	public void insertAllocationForInventoryEntry(InventoryEntryPo po);
	
	public void returnAudit(String billID);
	
	public void insertSms(SmsLertsPo smsLertsPo);
	
	public void insertAllocationBarcode(AllocationBarcodePo allocationBarcodePo);
	
	public void deleteAllocationBarcode(AllocationPo allocationPo) ;
	
	public List<AllocationBarcodePo> getAllocationBarcode(AllocationPo allocationPo);
	
	public List<AllocationBarcodePo> getAllocationBarcode(AllocationPo allocationPo,String goodsID);
	
	public int getAllocationCount(AllocationPo allocationPo);
	
}
