package com.pengsheng.eims.report.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;

public interface LeaderBoardMgr {

	/**
	 *   各店独立核算表,查询各个销售门店
	 */
	public List<DepartmentsPo> getEachStoreList();
	
	/**
	 *   根据不同的部门参数获取部门列表
	 */
	public List<DepartmentsPo> getDepartmentList(DepartmentsPo po);
	
	/**
	 * 查询商品类别
	 */
	public List<GoodsCategoryPo> getGoodsCategoryList();
	
}
