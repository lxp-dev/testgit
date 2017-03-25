package com.pengsheng.eims.hydsycasehistory.dao;

import java.util.List;

import com.pengsheng.eims.hydsycasehistory.persistence.InspectionPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;

public interface InspectionHydsyDao {
	public void inspectionInsert(InspectionPo inspectionPo);
	public void inspectionUpdate(InspectionPo inspectionPo);
	public List<InspectionPo> getInspectionList(InspectionPo inspectionPo);
	public void inspectionDelete(InspectionPo inspectionPo);
	public int getInspectionCount(OptometryPo optometryPo);
	public void inspectionprint(String id);
	public void updateInspectionFlag(String id);
	public CustomerInfoPo getCustomerInfo(String id);
}
