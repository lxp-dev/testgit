package com.pengsheng.eims.hydsycasehistory.mgr;

import java.util.List;

import com.pengsheng.eims.hydsycasehistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;

public interface CornealContactlLensHydsyMgr 
{
	public void cornealContactlLensInsert(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,LogisticsLogPo logPo);
	public void cornealContactlLensUpdate(CornealContactlLensPo cornealContactlLensPo);
	public void cornealContactlLensUpdate(CornealContactlLensPo cornealContactlLensPo,OptometryPo OptometryPo);
	public List<CornealContactlLensPo> getCornealContactlLensList(CornealContactlLensPo cornealContactlLensPo);
	public void cornealContactlLensDelete(CornealContactlLensPo cornealContactlLensPo);
	public int getCornealContactlLensCount(OptometryPo optometryPo);
	public void cornealContactlLensprint(String id);
	public void updateCornealContactlLensFlag(String id,SendNotePo snpo);
	public void cornealContactlLensInsertMessage(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID,LogisticsLogPo logPo) ;
	public void cornealContactlLensUpdateMessage(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID);

	public CustomerInfoPo getCustomerInfo(String id);
}
