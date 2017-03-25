/**
 * 
 */
package com.pengsheng.eims.hydsycasehistory.dao;

import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;

public interface CustomerOptometryHydsyDao {

	/**
	 * 得到验光病历po
	 * 
	 * @param optometryID
	 * @return
	 */
	public OptometryPo getOptometryPo(String optometryID);
}
