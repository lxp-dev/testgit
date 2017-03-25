package com.pengsheng.eims.bjtrhistory.dao;

import com.pengsheng.eims.bjtrhistory.persistence.HealthCheckPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;

public interface SpecialCheckBjtrDao {

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
	 * 更新验光表
	 * @param optometryPo
	 */
	public void updateOptometryCheck(OptometryPo optometryPo);
	
	/**
	 * 更新验光基表
	 * @param optometryBasicPo
	 */
	public void updateOptometryBasicCheck(OptometryBasicPo optometryBasicPo);
	public int getSpecailCheckCount(OptometryPo optometryPo);
}
