package com.pengsheng.eims.hydsycasehistory.mgr;

import java.util.List;

import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;

public interface OptometryCaseHydsyMgr {
	public int getOptometryCaseCount(OptometryPo po);;
	
	public List<OptometryPo> getOptometryCases(OptometryPo po,
			int start, int size);
}
