package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.QjccDao;
import com.pengsheng.eims.basic.mgr.QjccMgr;
import com.pengsheng.eims.basic.persistence.QjccPo;
import com.pengsheng.eims.basic.persistence.QjccTypePo;

public class QjccMgrImpl implements QjccMgr {
	
	private QjccDao qjccDao;
	
	public QjccDao getQjccDao() {
		return qjccDao;
	}

	public void setQjccDao(QjccDao qjccDao) {
		this.qjccDao = qjccDao;
	}

	public List<QjccTypePo> getQjccTypeList(){
		
		return qjccDao.getQjccTypeList();
	}
	
	
	public List<QjccTypePo> getQjccTypeMinList(QjccTypePo qjccTypePo) {
		
		return qjccDao.getQjccTypeMinList(qjccTypePo);
	}
	
	public void insertQjcc(QjccPo qjccPo){
		
		String[] persons=qjccPo.getPersonid().split(",");
		for (int i = 0; i < persons.length; i++) {
			qjccPo.setPinfoid(persons[i]);
			qjccDao.insertQjcc(qjccPo);
		}
		

	}
	
	public QjccPo getQjccPo(QjccPo qjccPo){
		
		return qjccDao.getQjccPo(qjccPo);
	}
	
	public int getQjccCount(QjccPo qjccPo){
		
		return qjccDao.getQjccCount(qjccPo);
	}
	
	public List<QjccPo> getQjccList(QjccPo qjccPo, int start, int size){
		
		return qjccDao.getQjccList(qjccPo, start, size);
	}
	
	public void updateQjcc(QjccPo qjccPo){
		
		qjccDao.updateQjcc(qjccPo); 
	}
	
	public void deleteQjcc(QjccPo qjccPo){
		
		qjccDao.deleteQjcc(qjccPo);
	}

}
