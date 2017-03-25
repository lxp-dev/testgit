package com.pengsheng.eims.components.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;



public interface SalesBasicDao {
	/**
	 * 取所有部门
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartments();
	
	/**
	 * 销售结帐基表信息数量
	 * @param po
	 * @return
	 */
	public int getSalesBasicCount(SalesBasicPo po);

	/**
	 * 遍历销售结帐基表信息
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> getSalesBasicList(SalesBasicPo po,
			int start, int size);

	/**
	 * 查询销售结帐基表信息
	 * @param po
	 * @return
	 */
	public SalesBasicPo getSalesBasic(SalesBasicPo po);
}
