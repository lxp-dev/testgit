package com.pengsheng.eims.hydsycasehistory.mgr;

import com.pengsheng.eims.hydsycasehistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;

public interface DoubleEyeFunHydsyMgr {

	/**
	 * 显示双眼视功能检查
	 * @param po
	 * @return
	 */
	public DoubleEyeFunPo getDoubleEyeFun(DoubleEyeFunPo po);
	/**
	 * 修改双眼视功能检查
	 * @param po
	 */
	public void updateDoubleEyeFun(DoubleEyeFunPo po,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo);
	/**
	 * 新增双眼视功能检查
	 * @param po
	 */
	public void insertDoubleEyeFun(DoubleEyeFunPo po,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo);
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
