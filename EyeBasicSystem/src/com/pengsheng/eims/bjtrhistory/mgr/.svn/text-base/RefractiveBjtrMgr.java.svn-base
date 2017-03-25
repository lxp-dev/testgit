package com.pengsheng.eims.bjtrhistory.mgr;
import com.pengsheng.eims.bjtrhistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;
import com.pengsheng.eims.bjtrhistory.persistence.RefractivePo;

public interface RefractiveBjtrMgr {
	public void insertRefractivePo(RefractivePo refractivePo, OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,DoubleEyeFunPo doubleEyeFunPo);
	
	public int getRefractiveCount(OptometryPo optometryPo);
	
	/**
	 * 显示屈光检查
	 * @param po
	 * @return
	 */
	public RefractivePo getRefractive(RefractivePo po);
	
	public void updateRefractive(RefractivePo po,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,DoubleEyeFunPo doubleEyeFunPo);

}
