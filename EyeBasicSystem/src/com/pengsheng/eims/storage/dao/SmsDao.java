package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;

public interface SmsDao {
	/*
	 * 获得短信提醒数目
	 */
	public int getSmsCount(PersonInfoPo personInfoPo,String flag);
	
	public List<SmsLertsPo> getSmsList(PersonInfoPo personInfoPo,int start, int size,String flag);
	
	public List<SmsLertsPo> getOrdersSmsList(PersonInfoPo personInfoPo,int start, int size,String flag);
	
	public void smsReaded(SmsLertsPo smsLertsPo);
	
	public int getOrdersSmsCount(PersonInfoPo personInfoPo,String flag);
	
	public void smsOrdersReaded(SmsLertsPo smsLertsPo) ;
	
}
