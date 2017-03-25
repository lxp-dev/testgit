package com.pengsheng.eims.casehistory.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.casehistory.persistence.InspectionPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;

public interface InspectionNDao {
	public void inspectionInsert(InspectionPo inspectionPo);
	public void inspectionUpdate(InspectionPo inspectionPo);
	public List<InspectionPo> getInspectionList(InspectionPo inspectionPo);
	public void inspectionDelete(InspectionPo inspectionPo);
	public int getInspectionCount(OptometryPo optometryPo);
	public void inspectionprint(String id);
	public void updateInspectionFlag(String id);
	public CustomerInfoPo getCustomerInfo(String id);
	
	/**
	 * 获得最后一次的检查结论
	 */
	public InspectionPo getLastInspectionPo(String customerID);
	
	
	/**
	 * 获得由某验光师最后一次的检查结论
	 */
	public InspectionPo getLastInspectionPo(String customerID,String doctorID);
}
