package com.pengsheng.eims.basic.mgr.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.dao.WarehouseDao;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.system.dao.DepartmentsDao;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class WarehouseMgrImpl implements WarehouseMgr {
	
	private ProcurementOrdersDao procurementOrdersDao;
	private LogisticsLogDao logisticsLogDao;
	private WarehouseDao warehouseDao;	
	private DepartmentsDao departmentsDao;
	
	public ProcurementOrdersDao getProcurementOrdersDao() {
		return procurementOrdersDao;
	}

	public void setProcurementOrdersDao(
			ProcurementOrdersDao procurementOrdersDao) {
		this.procurementOrdersDao = procurementOrdersDao;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		// TODO Auto-generated method stub
		return procurementOrdersDao.getGoodsCategorys();
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public DepartmentsDao getDepartmentsDao() {
		return departmentsDao;
	}

	public void setDepartmentsDao(DepartmentsDao departmentsDao) {
		this.departmentsDao = departmentsDao;
	}

	public WarehousePo getWarehouse(WarehousePo warehousePo) {
		return this.warehouseDao.getWarehouse(warehousePo);
	}

	public List<WarehousePo> getWarehouseList(WarehousePo warehousePo){
		//warehousePo.setBwhisclosed("1");
		return this.warehouseDao.getWarehouseList(warehousePo);
	}
	
	/**
	 * 取仓位总数
	 */
	public int getWarehouseCount(WarehousePo warehousePo){
		return this.warehouseDao.getWarehouseCount(warehousePo);
	}
	
	/**
	 * 取仓位List(分页)
	 */
	public List<WarehousePo> getWarehouseList(WarehousePo warehousePo,int start,int size){
		return this.warehouseDao.getWarehouseList(warehousePo,start,size);
	}

	public void insertWarehouse(WarehousePo warehousePo,LogisticsLogPo logPo) {
		this.warehouseDao.insertWarehouse(warehousePo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void updateWarehouse(WarehousePo warehousePo,LogisticsLogPo logPo) {
		this.warehouseDao.updateWarehouse(warehousePo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public WarehouseDao getWarehouseDao() {
		return warehouseDao;
	}

	public void setWarehouseDao(WarehouseDao warehouseDao) {
		this.warehouseDao = warehouseDao;
	}

	public void deleteWarehouse(WarehousePo warehousePo,LogisticsLogPo logPo) {
		this.warehouseDao.deleteWarehouse(warehousePo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
    public List<WarehousePo> getWarehouseList(DepartmentsPo po) {
    	
    	List<WarehousePo> warehouselist=new ArrayList<WarehousePo>();
    	
    	String departmenttype = Utility.getName(po.getBdptype());
    	if(departmenttype.equals("3")||departmenttype.equals("4")||departmenttype.equals("5")){//取所有仓位
    		WarehousePo warehousePo=new WarehousePo();
    		warehousePo.setBwhisclosed("0");
			if (!Utility.getName(po.getBdpcompanysid()).equals("")){
				warehousePo.setBwhcompanyid(po.getBdpcompanysid());
			}
    		warehouselist=warehouseDao.getWarehouseList(warehousePo);
    	}else if(departmenttype.equals("2")){//区域 取本区域下仓位+区域下的门店仓位
    		warehouselist=warehouseDao.getWarehouseList(po);//取本区域下仓位
    		List<DepartmentsPo> departmentlist=departmentsDao.getDepartmentsForRegional(po); //取区域下所有门店
    		Iterator<DepartmentsPo> it=departmentlist.iterator();
    		while(it.hasNext()){
    			DepartmentsPo departmentsPo=it.next();//迭代门店
    			List<WarehousePo> tmpWarehouselist=warehouseDao.getWarehouseList(departmentsPo);//取每个门店下对应仓位List
    			warehouselist.addAll(tmpWarehouselist);
    		}    		
    	}else if(departmenttype.equals("1")||departmenttype.equals("2")){//门店 取本门店下仓位
    		warehouselist=warehouseDao.getWarehouseList(po);
    	}else {
    		warehouselist=warehouseDao.getWarehouseList(po);
    	}
    	
    	return warehouselist;
    }
    
    public WarehousePo getWarehousePo(DepartmentsPo po){
    	return warehouseDao.getWarehousePo(po);
    }
    
    public DepartmentsPo getDepartments(WarehousePo po) {
    	
    	return warehouseDao.getDepartments(po);
    }
    public List<WarehousePo> getWarehouseForAllocationList(DepartmentsPo po) {
    	List<WarehousePo> warehouselist=new ArrayList<WarehousePo>();
    	
    	String departmenttype=po.getBdptype();
    	if(departmenttype.equals("3")){//仓储 取所有仓位
    		WarehousePo warehousePo=new WarehousePo();
    		warehousePo.setBwhisclosed("0");
    		warehouselist=warehouseDao.getWarehouseList(warehousePo);
    	}else if(departmenttype.equals("2")){//区域 取本区域下仓位+仓储仓位
    		warehouselist=warehouseDao.getWarehouseForStorageList();;//取本区域下仓位
    	}else if(departmenttype.equals("1")){//门店 取本门店下仓位+仓储仓位
    		warehouselist=warehouseDao.getWarehouseForStorageList();;//取本门店下仓位
    	}
    	return warehouselist;
    }
    public List<WarehousePo> getWarehouseForAjaxList(DepartmentsPo po) {

    	return warehouseDao.getWarehouseList(po);
    }

	public int getWareHouseCountForDel(WarehousePo warehousePo) {
		// TODO Auto-generated method stub
		return this.warehouseDao.getWareHouseCountForDel(warehousePo);
	}
	
	public List<WarehousePo> getWarehouseListForReg(String departmentID) {
		return warehouseDao.getWarehouseListForReg(departmentID);
	}
	
	public List<WarehousePo> getWarehouseForStorageList() {
		return warehouseDao.getWarehouseForStorageList();
	}
	
	public List<WarehousePo> getWarehouseForSalesList() {
		return warehouseDao.getWarehouseForStorageList();
	}
	
	public List<WarehousePo> getWarehouseForSalesList(String departmentID) {
		return warehouseDao.getWarehouseForSalesList(departmentID);
	}

	/**
	 * 仓位停用启用
	 */
	public void updateWarehouseAble(WarehousePo warehousePo,LogisticsLogPo logPo){
		warehouseDao.updateWarehouseAble(warehousePo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 添加时判断仓位名称重复
	 * 
	 */
	public int getWarehouseName(WarehousePo po)
	{
		return warehouseDao.getWarehouseName(po);
	}
	/**
	 * 修改时判断仓位名称重复
	 * 
	 */
	public int getWarehouseNameUpdate(WarehousePo po) 
	{
		return warehouseDao.getWarehouseNameUpdate(po);
	}
	/**
	 * 添加时类型为销售门店的部门只能有一个仓位
	 * 
	 */
	public int getWarehouseDept(DepartmentsPo po) 
	{
		return warehouseDao.getWarehouseDept(po);
	}
	
	public WarehousePo getWarehousebwhid()
	{
		return warehouseDao.getWarehousebwhid();
	}
	/**
	 * 修改时类型为销售门店的部门只能有一个仓位
	 * 
	 */
	public int getWarehouseDeptUpdate(DepartmentsPo po,String wid) 
	{
		return warehouseDao.getWarehouseDeptUpdate(po,wid) ;
	}
	
    public List<WarehousePo> getWarehouseAllList(DepartmentsPo po) {
    	
    	return warehouseDao.getWarehouseAllList(po);
    }
    
    public List<WarehousePo> getRegWarehouseAllList(DepartmentsPo po){
    	return warehouseDao.getRegWarehouseAllList(po);
    }
    
    
	/**
	 * 获取当前部门所属仓位和所有的其他公司的仓位
	 */
	public List<WarehousePo> getWarehouseListByOtherCompany(WarehousePo warehousePo){
		return warehouseDao.getWarehouseListByOtherCompany(warehousePo);
	}
	
	/**
	 * 获取当前部门所属公司下的所有仓位
	 */
	public List<WarehousePo> getWarehouseListByCompany(WarehousePo warehousePo){
		return warehouseDao.getWarehouseListByCompany(warehousePo);
	}
	
	/**
	 * 获取总公司下总库的所有仓位
	 */
	public List<WarehousePo> getWarehouseListByZongCompany(){
		return warehouseDao.getWarehouseListByZongCompany();
	}
	
	public WarehousePo getWarehousebwhid(DepartmentsPo po){
		return warehouseDao.getWarehousebwhid(po);
	}
	
}
