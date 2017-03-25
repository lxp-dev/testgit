package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;

public interface DoubleEyeFunDao {
	/**
	 * 显示双眼视功能检查
	 * 
	 * @param po
	 * @return
	 */
	public DoubleEyeFunPo getDoubleEyeFun(DoubleEyeFunPo po);

	/**
	 * 修改双眼视功能检查
	 * 
	 * @param po
	 */
	public void updateDoubleEyeFun(DoubleEyeFunPo po);

	/**
	 * 新增双眼视功能检查
	 * 
	 * @param po
	 */
	public void insertDoubleEyeFun(DoubleEyeFunPo po);
	
	/**
	 * 更新验光表
	 * @param optometryPo
	 */
	public void updateOptometry(OptometryPo po);
	
	/**
	 * 更新验光基表
	 * @param optometryBasicPo
	 */
	public void updateOptometryBasic(OptometryBasicPo po);
	
	public int getDoubleEyeFunCount(OptometryPo optometryPo) ;
}
