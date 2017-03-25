package com.pengsheng.eims.quartz.mgr;

import com.pengsheng.eims.system.persistence.QuartzLogPo;

public interface WholesalePriceJobMgr {
	/**
	 * 调价管理
	 */
	public void updateWholesalePriceEffective(String date,QuartzLogPo logPo);

}
