package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface WarehouseConfigurationMgr {
	
	public List<WarehouseConfigurationPo> getWarehouseConfigurationList();
	
	public WarehouseConfigurationPo getWarehouseConfiguration(WarehouseConfigurationPo po);
	
	public void insertWarehouseConfiguration(WarehouseConfigurationPo po,WarehouseConfigurationPo inpo,LogisticsLogPo logPo);
	
	public void updateWarehouseConfiguration(WarehouseConfigurationPo po,WarehouseConfigurationPo inpo,LogisticsLogPo logPo);
	
	public int getWarehouseConfigurationCount(WarehouseConfigurationPo po);
	
	public List<WarehousePo> getWarehouseList();
	
	public WarehouseConfigurationPo getInWarehouseConfiguration(WarehouseConfigurationPo po);
	
	public int getInWarehouseConfigurationCount(WarehouseConfigurationPo po);

	public void updateInWarehouseConfiguration(WarehouseConfigurationPo po,LogisticsLogPo logPo);
	
	public void insertInWarehouseConfiguration(WarehouseConfigurationPo po,LogisticsLogPo logPo);
	public int getWarehouseConfigurationsCount(DepartmentsPo po);
	public List<WarehouseConfigurationPo> getWarehouseConfigurationsList(DepartmentsPo po,int start, int size) ;
	
	public List<WarehousePo> getWarehouseList(DepartmentsPo po);
	
}
