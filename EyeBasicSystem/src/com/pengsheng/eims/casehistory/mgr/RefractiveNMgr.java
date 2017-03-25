package com.pengsheng.eims.casehistory.mgr;
import com.pengsheng.eims.casehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.casehistory.persistence.RefractivePo;

public interface RefractiveNMgr {
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

	/**
	 * 根据顾客ID获取最后一次屈光检查信息
	 * @param customerID
	 * @return
	 */
	public RefractivePo getLastRefractive(String customerID);
}
