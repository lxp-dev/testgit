package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface WarehouseConfigurationDao {
	
	public List<WarehouseConfigurationPo> getWarehouseConfigurationList();
	
	public WarehouseConfigurationPo getWarehouseConfiguration(WarehouseConfigurationPo po);
	
	public void insertWarehouseConfiguration(WarehouseConfigurationPo po);
	
	public void updateWarehouseConfiguration(WarehouseConfigurationPo po);
	
	public int getWarehouseConfigurationCount(WarehouseConfigurationPo po);
	
	public List<WarehousePo> getWarehouseList();
	
	public WarehouseConfigurationPo getInWarehouseConfiguration(WarehouseConfigurationPo po);
	
	public int getInWarehouseConfigurationCount(WarehouseConfigurationPo po);
	
	public void updateInWarehouseConfiguration(WarehouseConfigurationPo po);
	
	public void insertInWarehouseConfiguration(WarehouseConfigurationPo po);
	
	public int getWarehouseConfigurationsCount(DepartmentsPo po);
	public List<WarehouseConfigurationPo> getWarehouseConfigurationsList(DepartmentsPo po,int start, int size) ;
	
	public List<WarehousePo> getWarehouseList(DepartmentsPo po);
}
