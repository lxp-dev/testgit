package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;

public interface InspectionMgr {
	public void inspectionInsert(List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,LogisticsLogPo logPo);
	public void inspectionUpdate(InspectionPo inspectionPo);
	public void inspectionUpdate(List<InspectionPo> inspectionPos,OptometryPo OptometryPo);
	public List<InspectionPo> getInspectionList(InspectionPo inspectionPo);
	public void inspectionDelete(InspectionPo inspectionPo);
	public int getInspectionCount(OptometryPo optometryPo);
	public void inspectionprint(String id);
	public void updateInspectionFlag(String id,SendNotePo snpo);
	public void inspectionInsertMessage(List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID,LogisticsLogPo logPo) ;
	public void inspectionUpdateMessage(List<InspectionPo> inspectionPos,OptometryPo optometryPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID);

	public CustomerInfoPo getCustomerInfo(String id);
	
}
