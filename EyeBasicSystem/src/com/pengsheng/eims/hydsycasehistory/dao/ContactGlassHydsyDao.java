package com.pengsheng.eims.hydsycasehistory.dao;

import java.util.List;

import com.pengsheng.eims.hydsycasehistory.persistence.ContactGlassPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;

public interface ContactGlassHydsyDao 
{
	public void contactGlassInsert(ContactGlassPo contactGlassPo);
	public void contactGlassUpdate(ContactGlassPo contactGlassPo);
	public List<ContactGlassPo> getContactGlassList(ContactGlassPo contactGlassPo);
	public void contactGlassDelete(ContactGlassPo contactGlassPo);
	public int getContactGlassCount(OptometryPo optometryPo);
//	public void inspectionprint(String id);
//	public void updateInspectionFlag(String id);
	public CustomerInfoPo getCustomerInfo(String id);
}
