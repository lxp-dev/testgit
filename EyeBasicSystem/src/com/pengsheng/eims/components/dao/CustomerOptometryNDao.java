/**
 * 
 */
package com.pengsheng.eims.components.dao;

import com.pengsheng.eims.casehistory.persistence.OptometryPo;

public interface CustomerOptometryNDao {

	/**
	 * 得到验光病历po
	 * 
	 * @param optometryID
	 * @return
	 */
	public OptometryPo getOptometryPo(String optometryID);
}
