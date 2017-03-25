package com.pengsheng.eims.bjtrhistory.mgr;

import java.util.List;

import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;

public interface OptometryCaseBjtrMgr {
	public int getOptometryCaseCount(OptometryPo po);;
	
	public List<OptometryPo> getOptometryCases(OptometryPo po,
			int start, int size);
}
