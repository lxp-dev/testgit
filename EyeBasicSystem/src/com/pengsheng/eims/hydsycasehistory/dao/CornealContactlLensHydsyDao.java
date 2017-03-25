package com.pengsheng.eims.hydsycasehistory.dao;

import java.util.List;

import com.pengsheng.eims.hydsycasehistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;

public interface CornealContactlLensHydsyDao {
	public void cornealContactlLensInsert(CornealContactlLensPo po);
	
	public void cornealContactlLensUpdate(CornealContactlLensPo po);
	
	public List<CornealContactlLensPo> getCornealContactlLensList(CornealContactlLensPo po);
	
	public void cornealContactlLensDelete(CornealContactlLensPo po);
	
	public int getCornealContactlLensCount(OptometryPo optometryPo);
	
	public void cornealContactlLensprint(String id);
	
	public void updateCornealContactlLensFlag(String id);
	
	public CustomerInfoPo getCustomerInfo(String id);
}
