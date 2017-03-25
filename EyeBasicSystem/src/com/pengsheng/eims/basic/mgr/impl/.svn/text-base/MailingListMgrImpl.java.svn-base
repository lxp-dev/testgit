package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.MailingListDao;
import com.pengsheng.eims.basic.mgr.MailingListMgr;
import com.pengsheng.eims.basic.persistence.MailingListPo;

public class MailingListMgrImpl implements MailingListMgr {
	
	private MailingListDao mailingListDao;
	
	public MailingListDao getMailingListDao() {
		return mailingListDao;
	}

	public void setMailingListDao(MailingListDao mailingListDao) {
		this.mailingListDao = mailingListDao;
	}

	public int getMailingListCount(MailingListPo mailingListPo) {
		
		return mailingListDao.getMailingListCount(mailingListPo);
	}
	
	public List<MailingListPo> getMailingList(MailingListPo mailingListPo,
			int start, int size) {
		
		return mailingListDao.getMailingList(mailingListPo, start, size);
	}
	
	public MailingListPo getMailingListPo(MailingListPo mailingListPo) {
		
		return mailingListDao.getMailingListPo(mailingListPo);
	}
	
	public void insertMailingListPo(MailingListPo mailingListPo) {
		
		mailingListDao.insertMailingListPo(mailingListPo);
	}
	
	public void updateMailingListPo(MailingListPo mailingListPo) {
		
		mailingListDao.updateMailingListPo(mailingListPo);
		if(("1").equals(mailingListPo.getBtmluseflag())){
			mailingListDao.updateMailingListUseFlag(mailingListPo);
		}
		
	}
	
	public void deleteMailingListPo(MailingListPo mailingListPo) {
		
		mailingListDao.deleteMailingListPo(mailingListPo);
	}
	
	public List<MailingListPo> getMailingList() {
		
		return mailingListDao.getMailingList();
	}
	
	public MailingListPo getMailingListPo() {
		
		return mailingListDao.getMailingListPo();
	}
}
