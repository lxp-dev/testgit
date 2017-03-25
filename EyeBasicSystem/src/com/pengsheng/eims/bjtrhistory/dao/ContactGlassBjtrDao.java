package com.pengsheng.eims.bjtrhistory.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.bjtrhistory.persistence.ContactGlassPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;

public interface ContactGlassBjtrDao 
{
	public void contactGlassInsert(ContactGlassPo contactGlassPo);
	public void contactGlassUpdate(ContactGlassPo contactGlassPo);
	public List<ContactGlassPo> getContactGlassList(ContactGlassPo contactGlassPo);
	public void contactGlassDelete(ContactGlassPo contactGlassPo);
	public int getContactGlassCount(OptometryPo optometryPo);
	public CustomerInfoPo getCustomerInfo(String id);
}
