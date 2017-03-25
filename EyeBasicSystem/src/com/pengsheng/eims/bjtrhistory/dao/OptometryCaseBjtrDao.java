package com.pengsheng.eims.bjtrhistory.dao;

import java.util.List;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;

public interface OptometryCaseBjtrDao{
	
	public int getOptometryCaseCount(OptometryPo po);
	
	public List<OptometryPo> getOptometryCases(OptometryPo po,int start, int size);

}
