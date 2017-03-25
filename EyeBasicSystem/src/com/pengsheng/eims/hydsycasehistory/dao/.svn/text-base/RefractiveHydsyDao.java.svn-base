package com.pengsheng.eims.hydsycasehistory.dao;

import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.hydsycasehistory.persistence.RefractivePo;

public interface RefractiveHydsyDao {
	//插入屈光检查明细表
	public void insertRefractivePo(RefractivePo refractivePo);
	//判断屈光检查验光号是否存在
	public int getRefractiveCount(OptometryPo optometryPo);
	//更新屈光检查明细表
	public void updateRefractive(RefractivePo refractivePo);
	//更新验光病历主表修改处方日期
	public void updateOptometry(OptometryPo po);
	//更新验光基表病历结束日期
	public void updateOptometryBasic(OptometryBasicPo po);
	/**
	 * 显示屈光检查
	 * 
	 * @param po
	 * @return
	 */
	public RefractivePo getRefractive(RefractivePo po);
}
