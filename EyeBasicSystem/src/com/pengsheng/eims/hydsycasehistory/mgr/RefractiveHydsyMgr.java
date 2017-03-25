package com.pengsheng.eims.hydsycasehistory.mgr;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.hydsycasehistory.persistence.RefractivePo;

public interface RefractiveHydsyMgr {
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
