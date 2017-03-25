package com.pengsheng.eims.sales.mgr;

import com.pengsheng.eims.sales.persistence.HealthCheckPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;

public interface SpecialCheckMgr {

	/**
	 * 新增特殊功能检查
	 * @param healthCheckPo
	 */
	public void insertSpecialCheck(HealthCheckPo healthCheckPo);
	
	/**
	 * 查询特殊功能检查
	 * @param healthCheckPo
	 * @return
	 */
	public HealthCheckPo getSpecialCheck(HealthCheckPo healthCheckPo);
	
	/**
	 * 更新特殊功能检查
	 * @param healthCheckPo
	 */
	public void updateSpecialCheck(HealthCheckPo healthCheckPo);
	/**
	 * 更新特殊功能检查
	 * @param healthCheckPo
	 */
	public void updateSpecialCheck(HealthCheckPo healthCheckPo,OptometryBasicPo optometryBasicPo,OptometryPo optometryPo);	
	
	
	/**
	 * 更新验光表
	 * @param optometryPo
	 */
	public void updateOptometryCheck(OptometryPo optometryPo);
	
	/**
	 * 更新验光基表
	 * @param optometryBasicPo
	 */
	public void updateOptometryBasicCheck(OptometryBasicPo optometryBasicPo);
	
	public void insertSpecialCheck(HealthCheckPo healthCheckPo,OptometryBasicPo optometryBasicPo,OptometryPo optometryPo);
	
	public int getSpecialCheckCount(OptometryPo optometryPo);
}
