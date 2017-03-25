package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.storage.dao.SmsDao;
import com.pengsheng.eims.storage.mgr.SmsMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;


public class SmsMgrImpl implements SmsMgr{

	private SmsDao smsDao;

	
	public SmsDao getSmsDao() {
		return smsDao;
	}
	public void setSmsDao(SmsDao smsDao) {
		this.smsDao = smsDao;
	}
	
	public int getSmsCount(PersonInfoPo personInfoPo,String flag) {
		// TODO Auto-generated method stub
		return smsDao.getSmsCount(personInfoPo,flag);
	}
	
	public int getOrdersSmsCount(PersonInfoPo personInfoPo,String flag) {
		// TODO Auto-generated method stub
		return smsDao.getOrdersSmsCount(personInfoPo,flag);
	}
	
	public List<SmsLertsPo> getSmsList(PersonInfoPo personInfoPo,int start, int size,String flag) {
		// TODO Auto-generated method stub
		return smsDao.getSmsList(personInfoPo, start, size,flag);
	}
	
	public void smsReaded(SmsLertsPo smsLertsPo){
		 smsDao.smsReaded(smsLertsPo);
	}

	public List<SmsLertsPo> getOrdersSmsList(PersonInfoPo personInfoPo,
			int start, int size, String flag) {
		// TODO Auto-generated method stub
		return smsDao.getOrdersSmsList(personInfoPo, start, size,flag);
	}
	
	public void smsOrdersReaded(SmsLertsPo smsLertsPo) {
		 smsDao.smsOrdersReaded(smsLertsPo);
	}
}
