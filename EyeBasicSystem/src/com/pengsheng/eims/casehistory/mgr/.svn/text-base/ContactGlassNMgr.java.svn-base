package com.pengsheng.eims.casehistory.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.casehistory.persistence.ContactGlassPo;
import com.pengsheng.eims.casehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface ContactGlassNMgr 
{
	public void contactGlassInsert(List<ContactGlassPo> contactGlassPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,LogisticsLogPo logPo);
	public void contactGlassUpdate(ContactGlassPo contactGlassPo);
	public void contactGlassUpdate(List<ContactGlassPo> contactGlassPos,OptometryPo OptometryPo);
	public List<ContactGlassPo> getContactGlassList(ContactGlassPo contactGlassPo);
	public void contactGlassDelete(ContactGlassPo contactGlassPo);
	public int getcontactGlassCount(OptometryPo optometryPo);
	public void contactGlassInsertMessage(List<ContactGlassPo> contactGlassPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID,LogisticsLogPo logPo) ;
	public void contactGlassUpdateMessage(List<ContactGlassPo> contactGlassPos,OptometryPo optometryPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID);

	public CustomerInfoPo getCustomerInfo(String id);
}
