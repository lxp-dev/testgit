package com.pengsheng.weixin.mgr;

import java.util.List;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.weixin.persistence.WeiXinDepartmentPicPo;

public interface WeiXinDepartmentsMgr {
	/**
	 * 取指定部门
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */
	public DepartmentsPo getDepartment(DepartmentsPo departmentsPo);

	/**
	 * 更新部门
	 * 
	 * @param departmentsPo
	 */
	public void updateDepartment(DepartmentsPo departmentsPo,LogisticsLogPo logPo);

	/**
	 * 查询部门的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getDepartmentCount(DepartmentsPo po);
	
	/**
	 * 查询部门列表
	 * 
	 * @param po
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentList(DepartmentsPo po,int start,int size);

	/**
	 * 查询部门列表
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */	
	public List<DepartmentsPo> getDepartmentsList(DepartmentsPo po);
	
	/**
	 * 更新门店是否为微信可见的状态
	 * 
	 * @param departmentsPo
	 */
	public void updateSeeDepartment(DepartmentsPo departmentsPo);
	
	/**
	 * 更新门店是否为微信可预约的状态
	 * 
	 * @param departmentsPo
	 */
	public void updateOptometryAppointmentDepartment(DepartmentsPo departmentsPo);
	
	/**
	 * 获取门店实景图List
	 * 
	 * @param departmentID
	 */
	public List<WeiXinDepartmentPicPo> getDepartmentPicList(String departmentID);
	
	/**
	 * 更新门店实景图
	 * 
	 * @param departmentsPo
	 */
	public void updateDepartmentPic(DepartmentsPo departmentsPo,LogisticsLogPo logPo);
}
