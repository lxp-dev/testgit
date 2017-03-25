package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.storage.persistence.WholeBarcodePo;
import com.pengsheng.eims.storage.persistence.WholeEntryPo;
import com.pengsheng.eims.storage.persistence.WholePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;

public interface WholeApplyForAppDao {
	
	public int getWholeCount(WholePo po,DepartmentsPo departmentsPo);
	
	public List<WholePo> getWholeList(WholePo po,DepartmentsPo departmentsPo,int start, int size);
	
	public int getReWholeCount(WholePo po,DepartmentsPo departmentsPo);
	
	public List<WholePo> getReWholeList(WholePo po,DepartmentsPo departmentsPo,int start, int size);
	
	public void insertWhole(WholePo po);
	
	public void insertWholeStatus(WholePo po);
	
	public void insertWholeEntry(WholeEntryPo po);
	
	public void updateWhole(WholePo po);
	
	public void deleteWhole(WholePo po);
	
	public WholePo getWhole(WholePo po);
	
	public List<WholeEntryPo> getWholeEntryList(WholePo po);
	
	public void deleteWholeEntry(WholePo po);	
	
	public void updateWholeReceive(WholePo po);
	
	public void insertWholeForInventory(InventoryPo po);
	
	public void insertWholeForInventoryEntry(InventoryEntryPo po);
	
	public void returnAudit(String billID);
	
	public void insertSms(SmsLertsPo smsLertsPo);
	
	public void insertWholeBarcode(WholeBarcodePo wholeBarcodePo);
	
	public void deleteWholeBarcode(WholePo wholePo) ;
	
	public List<WholeBarcodePo> getWholeBarcode(WholePo wholePo);
	
	public List<WholeBarcodePo> getWholeBarcode(WholePo wholePo,String goodsID);
	
	public int getWholeCount(WholePo wholePo);
	
}
