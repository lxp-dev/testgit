package com.pengsheng.eims.system.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public interface SystemParameterDao {
	/**
	 * 得到DB系统时间；
	 * @param po
	 */
	public String getDBSystemData();
	/**
	 * 新增系统参数信息
	 * @param po
	 */
	public void insertSystemParameter(SystemParameterPo po);
	
	/**
	 * 更新系统参数信息
	 * @param po
	 */
	public void updateSystemParameter(SystemParameterPo po);
	
	/**
	 * 查询系统参数信息
	 * @return
	 */
	public SystemParameterPo getSystemParameterPo();
	
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
	public void updateBarcodeCoordinate(SystemParameterPo po);
	
	/**
	 * 更新某个商品类型的打印样式
	 * @param po
	 */
	public void updateCategoryBarcodeType(String categoryid,String style);
	
	
	public void updateGoodsViewName(SystemParameterPo po);
	
	/**
	 * 新增测试手机电话
	 * @param po
	 */
	public void insertTextPhone(String phone);
	
	/**
	 * 删除测试手机电话
	 * @param po
	 */
	public void deleteTextPhone(SystemParameterPo po);
	
	/**
	 *  修改商品命名规则(调整零售价专用)
	 */
	public void updateGoodsViewNameForChangePrice(SystemParameterPo po,GoodsInfoPo gpo);
}
