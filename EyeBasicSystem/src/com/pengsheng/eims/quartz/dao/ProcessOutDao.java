package com.pengsheng.eims.quartz.dao;

import java.util.List;


import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface ProcessOutDao {
	
	public List<InventoryEntryPo> getProcessEntryList();

	public void insertProcessOut(InventoryPo po);
	
	public void insertProcessOutEntry(InventoryEntryPo po);
	
	public void updateProcessFlag();
	
	public List<InventoryPo> getSupplierid();
	
	public void insertInventory(String producedid, String supplierid);
	
	public void insertInventoryEntry(String producedid, String supplierid);
}
