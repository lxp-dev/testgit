package com.pengsheng.eims.bjtrhistory.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.bjtrhistory.persistence.InspectionPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;

public interface InspectionBjtrDao {
	public void inspectionInsert(InspectionPo inspectionPo);
	public void inspectionUpdate(InspectionPo inspectionPo);
	public List<InspectionPo> getInspectionList(InspectionPo inspectionPo);
	public void inspectionDelete(InspectionPo inspectionPo);
	public int getInspectionCount(OptometryPo optometryPo);
	public void inspectionprint(String id);
	public void updateInspectionFlag(String id);
	public CustomerInfoPo getCustomerInfo(String id);
}
