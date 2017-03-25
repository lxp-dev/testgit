/**
 * 
 */
package com.pengsheng.eims.bjtrhistory.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;

/**
 * @author Liuqian
 * 
 */
public interface OptometryBasicBjtrMgr {
	/**
	 * 得到顾客验光基表
	 * 
	 * @param customerID
	 * @param start
	 * @param size
	 * @return
	 */
	public List<OptometryBasicPo> getcustomerOptometryBasics(String customerID,
			int start, int size);

	/**
	 * 得到顾客所有验光基表明细
	 * 
	 * @param customerID
	 * @return
	 */
	public int getcustomerOptometryBasicCount(String customerID);

	/**
	 * 得到所有顾客验光病历,验光基表对应的
	 * 
	 * @return
	 */
	public List<OptometryPo> getcustomerOptometrys(String basicID);

	/**
	 * 删除验光数据
	 * 
	 * @param basicID
	 * @param optometryID
	 */
	public void delOptometryData(String basicID, String optometryID,LogisticsLogPo logPo);
	public int getOptometryCount2(OptometryPo optometryPo);
	public int getOptometryBasicCount2(OptometryBasicPo optometryBasicPo);
	public OptometryPo getOptometryPo(String optometryBasicID);
	
	public OptometryPo selectOptometryPo(String optometryid);
}
