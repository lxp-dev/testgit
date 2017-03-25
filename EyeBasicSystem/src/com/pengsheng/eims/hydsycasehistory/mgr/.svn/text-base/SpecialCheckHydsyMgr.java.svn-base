package com.pengsheng.eims.hydsycasehistory.mgr;

import com.pengsheng.eims.hydsycasehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;

public interface SpecialCheckHydsyMgr {

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
