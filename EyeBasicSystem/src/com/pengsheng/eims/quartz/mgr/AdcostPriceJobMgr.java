package com.pengsheng.eims.quartz.mgr;

import com.pengsheng.eims.system.persistence.QuartzLogPo;

public interface AdcostPriceJobMgr {

	/**
	 * 调价管理
	 */
	public void updateAdcostPriceEffective(String date,QuartzLogPo logPo);
	
}
