package com.pengsheng.eims.bjtrhistory.dao;

import com.pengsheng.eims.bjtrhistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;


public interface DoubleEyeFunBjtrDao {
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
	
	/**
	 * 修改双眼视功能检查2(refractive)
	 * 
	 * @param po
	 */
	public void updateDoubleEyeFunAtRefractive(DoubleEyeFunPo po);
}
