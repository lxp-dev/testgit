package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface RegionalConfigurationMgr {
	
	/**
	 * 取指定部门
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */
	public DepartmentsPo getDepartment(DepartmentsPo departmentsPo);
	
	/**
	 * 取部门中所有的区域数据
	 * @return
	 */	
	public List<DepartmentsPo> getQuyuList(DepartmentsPo po);
	/**
	 * 取部门中相关的门店数据
	 * @return
	 */	
	public List<DepartmentsPo> getMendianQuyusList(DepartmentsPo departmentsPo, int start, int size) ;
	
	/**
	 * 取部门中相关的门店数量
	 * @return
	 */	
	public int getMendianQuyusCount(DepartmentsPo departmentsPo) ;
	
	/**
	 * 取部门中相关的门店数据
	 * 
	 * @param po
	 *            部门参数集
	 * @return
	 */
	public List<DepartmentsPo> getMendianQuyuList(DepartmentsPo departmentsPo);
	
	/**
	 * 更新门店对应区域数据
	 * 
	 * @param departmentsPo
	 */
	public void updateDepartment(DepartmentsPo departmentsPo,LogisticsLogPo logPo);
	
}
