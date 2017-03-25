/**
 * 
 */
package com.pengsheng.eims.components.dao;

import com.pengsheng.eims.sales.persistence.OptometryPo;

/**
 * @author Liuqian
 * 
 */
public interface CustomerOptometryDao {

	/**
	 * 得到验光病历po
	 * 
	 * @param optometryID
	 * @return
	 */
	public OptometryPo getOptometryPo(String optometryID);
}
