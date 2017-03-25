/**
 * 
 */
package com.pengsheng.eims.components.mgr;

import com.pengsheng.eims.casehistory.persistence.OptometryPo;

/**
 * @author Liuqian
 * 
 */
public interface CustomerOptometryNMgr {

	/**
	 * 得到验光病历po
	 * 
	 * @param optometryID
	 * @return
	 */
	public OptometryPo getOptometryPo(String optometryID);
}
