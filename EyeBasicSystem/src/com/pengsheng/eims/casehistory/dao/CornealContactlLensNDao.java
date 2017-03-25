package com.pengsheng.eims.casehistory.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.casehistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;

public interface CornealContactlLensNDao {
	public void cornealContactlLensInsert(CornealContactlLensPo po);
	
	public void cornealContactlLensUpdate(CornealContactlLensPo po);
	
	public List<CornealContactlLensPo> getCornealContactlLensList(CornealContactlLensPo po);
	
	public void cornealContactlLensDelete(CornealContactlLensPo po);
	
	public int getCornealContactlLensCount(OptometryPo optometryPo);
	
	public void cornealContactlLensprint(String id);
	
	public void updateCornealContactlLensFlag(String id);
	
	public CustomerInfoPo getCustomerInfo(String id);
}
