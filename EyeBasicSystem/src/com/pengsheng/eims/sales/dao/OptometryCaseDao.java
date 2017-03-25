package com.pengsheng.eims.sales.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.persistence.OptometryPo;

public interface OptometryCaseDao{
	
	public int getOptometryCaseCount(OptometryPo po);
	
	public List<OptometryPo> getOptometryCases(OptometryPo po,int start, int size);

}
