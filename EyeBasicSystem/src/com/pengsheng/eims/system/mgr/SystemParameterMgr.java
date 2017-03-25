package com.pengsheng.eims.system.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface SystemParameterMgr {
	/**
	 * 得到DB系统时间；
	 * @param po
	 */
	public String getDBSystemData();
	/**
	 * 新增系统参数信息
	 * @param po
	 */
	public void insertSystemParameter(SystemParameterPo po,LogisticsLogPo logPo);
	
	/**
	 * 更新系统参数信息
	 * @param po
	 */
	public void updateSystemParameter(SystemParameterPo po,LogisticsLogPo logPo);
	
	/**
	 * 更新商品规则
	 * @param po
	 */
	public void updateGoodsViewName(SystemParameterPo po,LogisticsLogPo logPo);
	
	/**
	 * 查询系统参数信息
	 * @return
	 */
	public SystemParameterPo getSystemParameterPo();
	
	/**
	 * 将部门对应的配镜单模版插入到SystemParameterPo中
	 * @return
	 */
	public SystemParameterPo getSystemParameterPoDepartmentBillTemplate(SystemParameterPo po,String departmentID);
	
	/**
	 * 查询使用过的零售价
	 */
	public List<DepartmentsPo> selectDepartmentsPoForWhichretail();
	
	/**
	 * 查询条码样式坐标
	 * @param po
	 * @return
	 */
	public List<SystemParameterPo> selectBarcodeCoordinate(SystemParameterPo po);
	
	/**
	 * 更新指定行的数据
	 * @param po
	 */
	public void updateBarcodeCoordinate(List<SystemParameterPo> pos);
	
	/**
	 * 更新某个商品类型的打印样式
	 * @param po
	 */
	public void updateBarcodeCoordinate(String categoryid,String style);
}
