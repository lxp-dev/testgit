package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.sales.persistence.OptometryPo;

public interface OptometryCaseMgr {
	public int getOptometryCaseCount(OptometryPo po);;
	
	public List<OptometryPo> getOptometryCases(OptometryPo po,
			int start, int size);
}
