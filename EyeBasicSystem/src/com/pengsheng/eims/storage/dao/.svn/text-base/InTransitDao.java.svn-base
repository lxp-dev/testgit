package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;

public interface InTransitDao {

	/**
	 * 取所有部门
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsList(DepartmentsPo departmentsPo);
	
	/**
	 * 查询在途状态数量
	 * @param po
	 * @return
	 */
	public int getInTransitCount(SalesBasicPo po);
	
	
	 /**
	  * 分页
	  * @param po
	  * @param start
	  * @param size
	  * @return
	  */
	public List<SalesBasicPo> getInTransitList(SalesBasicPo po,int start, int size);
	
	/**
	 * 查询在途状态
	 * @param po
	 * @return
	 */
	public SalesBasicPo getInTransit(SalesBasicPo po);
	/**
	 * 修改基表在途状态
	 * @param SalesBasicPo
	 * @return
	 */
	public void updateSalesBasicInTransit(InTransitPo inTransitPo);
	/**
	 * 新增基表在途状态
	 * @param List<InTransitPo>
	 * @return
	 */
	public void insertInTransit(InTransitPo inTransitPo);
	
	/**
	 * 查询在途Po
	 * @param po
	 * @return
	 */
	public InTransitPo getInTransitPo(InTransitPo po);
	
	/**
	 * 微信中定制类型待取镜配镜单数量
	 * @param po
	 * @return
	 */
	public int getWeiXinDingzhiDaiqujingCount(String customID);
}
