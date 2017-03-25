package com.pengsheng.eims.sales.mgr;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.sales.persistence.RefractivePo;

import com.pengsheng.eims.sales.persistence.RefractivePo;

public interface RefractiveMgr {
	public void insertRefractivePo(RefractivePo refractivePo, OptometryPo optometryPo,
			OptometryBasicPo optometryBasicPo);
	
	public int getRefractiveCount(OptometryPo optometryPo);
	
	/**
	 * 显示屈光检查
	 * @param po
	 * @return
	 */
	public RefractivePo getRefractive(RefractivePo po);
	
	public void updateRefractive(RefractivePo po,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo);

}
