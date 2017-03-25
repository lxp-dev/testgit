package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.JbtiaoDao;
import com.pengsheng.eims.basic.mgr.JbtiaoMgr;
import com.pengsheng.eims.basic.persistence.JbtiaoPo;
import com.pengsheng.eims.basic.persistence.JbtiaoTypePo;

public class JbtiaoMgrImpl implements JbtiaoMgr {

	private JbtiaoDao jbtiaoDao;
	
	public JbtiaoDao getJbtiaoDao() {
		return jbtiaoDao;
	}

	public void setJbtiaoDao(JbtiaoDao jbtiaoDao) {
		this.jbtiaoDao = jbtiaoDao;
	}

	public List<JbtiaoTypePo> getJbtiaoTypeList() {
		
		return jbtiaoDao.getJbtiaoTypeList();
	}
	
	
	public void insertJbtiao(JbtiaoPo jbtiaoPo) {
		
		String[] persons=jbtiaoPo.getPersonid().split(",");
		for (int i = 0; i < persons.length; i++) {
			jbtiaoPo.setPinfoid(persons[i]);
			jbtiaoDao.insertJbtiao(jbtiaoPo);
		}
		
	}
	
	
	public JbtiaoPo getJbtiaoPo(JbtiaoPo jbtiaoPo) {
		
		return jbtiaoDao.getJbtiaoPo(jbtiaoPo);
	}
	
	public int getJbtiaoCount(JbtiaoPo jbtiaoPo){
		
		return jbtiaoDao.getJbtiaoCount(jbtiaoPo);
	}
	
	public List<JbtiaoPo> getJbtiaoList(JbtiaoPo jbtiaoPo, int start, int size){
		
		return jbtiaoDao.getJbtiaoList(jbtiaoPo, start, size);
	}	
	
	public void updateJbtiao(JbtiaoPo jbtiaoPo) {
		
		jbtiaoDao.updateJbtiao(jbtiaoPo);
	}
	
	public void deleteJbtiao(JbtiaoPo jbtiaoPo) {
		
		jbtiaoDao.deleteJbtiao(jbtiaoPo);
	}
}
