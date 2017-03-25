package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.WholeBarcodePo;
import com.pengsheng.eims.storage.persistence.WholeEntryPo;
import com.pengsheng.eims.storage.persistence.WholePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;

public interface WholeApplyForAppMgr {

	public int getWholeCount(WholePo po,DepartmentsPo departmentsPo);
	
	public List<WholePo> getWholeList(WholePo po,DepartmentsPo departmentsPo,int start, int size);
	
	public int getReWholeCount(WholePo po,DepartmentsPo departmentsPo);
	
	public List<WholePo> getReWholeList(WholePo po,DepartmentsPo departmentsPo,int start, int size);
	
	public void insertWhole(WholePo po,List<WholeEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<WholeBarcodePo> allocationBarcodeList,LogisticsLogPo logPo);
	
	public void updateWhole(WholePo po,List<WholeEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<WholeBarcodePo> allocationBarcodeList,LogisticsLogPo logPo);
	
	public void deleteWhole(WholePo po,List<PersonInfoPo> personInfoList,SmsLertsPo smsLertsPo,LogisticsLogPo logPo);
		
	public WholePo getWhole(WholePo po);
	
	public List<WholeEntryPo> getWholeEntryList(WholePo po);
	
	public void updateWholeReceive(WholePo po,LogisticsLogPo logPo);
	
	public void returnAudit(String billID);
	
	public void insertSms(SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList);
	
	public List<WholeBarcodePo> getWholeBarcode(WholePo allocationPo);
	
	public int getWholeCount(WholePo po);
}
