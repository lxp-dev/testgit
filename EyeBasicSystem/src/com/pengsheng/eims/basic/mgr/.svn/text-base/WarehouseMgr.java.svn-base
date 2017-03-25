package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface WarehouseMgr {
	
	/**
	 * 取仓位List(未分页)
	 * 
	 * @param warehousePo
	 *            仓位参数集
	 * @return
	 */
	public List<WarehousePo> getWarehouseList(WarehousePo warehousePo);

	/**
	 * 取仓位总数
	 */
	public int getWarehouseCount(WarehousePo warehousePo);
	
	/**
	 * 取仓位List(分页)
	 */
	public List<WarehousePo> getWarehouseList(WarehousePo warehousePo,int start,int size);
	
	/**
	 * 取指定仓位
	 * 
	 * @param warehousePo
	 *            仓位参数集
	 * @return
	 */
	public WarehousePo getWarehouse(WarehousePo warehousePo);

	/**
	 * 插入仓位
	 * 
	 * @param warehousePo
	 *            仓位参数集
	 */
	public void insertWarehouse(WarehousePo warehousePo,LogisticsLogPo logPo);

	/**
	 * 更新仓位
	 * 
	 * @param warehousePo
	 *            仓位参数集
	 */
	public void updateWarehouse(WarehousePo warehousePo,LogisticsLogPo logPo);

	/**
	 * 删除仓位
	 * 
	 * @param warehousePo
	 *            仓位参数集
	 */
	public void deleteWarehouse(WarehousePo warehousePo,LogisticsLogPo logPo);
	
	/**
	 * 取仓位List
	 * 
	 * @param warehousePo
	 *            仓位参数集
	 * @return
	 */
	public List<WarehousePo> getWarehouseList(DepartmentsPo po);

	/**
	 * 取指定部门
	 * 
	 * @param warehousePo
	 *            仓位参数集
	 * @return
	 */
	public DepartmentsPo getDepartments(WarehousePo po);
	
	
	/**
	 * 取仓位List
	 * 
	 * @param warehousePo
	 *            仓位参数集
	 * @return
	 */
	public List<WarehousePo> getWarehouseForAllocationList(DepartmentsPo po);
	
	public List<WarehousePo> getWarehouseForAjaxList(DepartmentsPo po);
	
	public int getWareHouseCountForDel(WarehousePo warehousePo);
	
	public List<WarehousePo> getWarehouseForStorageList();
	
	public List<WarehousePo> getWarehouseListForReg(String departmentID) ;
	
	public List<WarehousePo> getWarehouseForSalesList(String departmentID);
	
	/**
	 * 仓位停用启用
	 */
	public void updateWarehouseAble(WarehousePo warehousePo,LogisticsLogPo logPo);
	/**
	 * 添加时判断仓位名称重复
	 * 
	 */
	public int getWarehouseName(WarehousePo po) ;
	/**
	 * 修改时判断仓位名称重复
	 * 
	 */
	public int getWarehouseNameUpdate(WarehousePo po) ;
	/**
	 * 添加时类型为销售门店的部门只能有一个仓位
	 * 
	 */
	public int getWarehouseDept(DepartmentsPo po) ;
	/**
	 * 修改时类型为销售门店的部门只能有一个仓位
	 * 
	 */
	public int getWarehouseDeptUpdate(DepartmentsPo po,String wid) ;
	
	public WarehousePo getWarehousebwhid(); 
	
	public List<WarehousePo> getWarehouseAllList(DepartmentsPo po);
	
	public List<WarehousePo> getRegWarehouseAllList(DepartmentsPo po);
	
	/**
	 * 获取当前部门所属仓位和所有的其他公司的仓位
	 */
	public List<WarehousePo> getWarehouseListByOtherCompany(WarehousePo warehousePo);
	
	/**
	 * 获取当前部门所属公司下的所有仓位
	 */
	public List<WarehousePo> getWarehouseListByCompany(WarehousePo warehousePo);
	
	/**
	 * 获取总公司下总库的所有仓位
	 */
	public List<WarehousePo> getWarehouseListByZongCompany();
	
	/**
	 * 通过部门获取仓位PO
	 * @param po
	 * @return
	 */
	public WarehousePo getWarehousePo(DepartmentsPo po);
	
	public WarehousePo getWarehousebwhid(DepartmentsPo po); 
}
