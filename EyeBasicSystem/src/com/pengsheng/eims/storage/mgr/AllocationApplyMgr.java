package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;

public interface AllocationApplyMgr {

	public int getAllocationCount(AllocationPo po,DepartmentsPo departmentsPo);
	
	public List<AllocationPo> getAllocationList(AllocationPo po,DepartmentsPo departmentsPo,int start, int size);
	
	public int getReAllocationCount(AllocationPo po,DepartmentsPo departmentsPo);
	
	public List<AllocationPo> getReAllocationList(AllocationPo po,DepartmentsPo departmentsPo,int start, int size);
	
	public void insertAllocation(AllocationPo po,List<AllocationEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo);
	
	public void updateAllocation(AllocationPo po,List<AllocationEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo);
	
	public void deleteAllocation(AllocationPo po,List<PersonInfoPo> personInfoList,SmsLertsPo smsLertsPo,LogisticsLogPo logPo);
		
	public AllocationPo getAllocation(AllocationPo po);
	
	public List<AllocationEntryPo> getAllocationEntryList(AllocationPo po);
	
	public void updateAllocationReceive(AllocationPo po,LogisticsLogPo logPo);
	
	public void returnAudit(String billID);
	
	public void insertSms(SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList);
	
	public List<AllocationBarcodePo> getAllocationBarcode(AllocationPo allocationPo);
	
	public int getAllocationCount(AllocationPo po);
}
