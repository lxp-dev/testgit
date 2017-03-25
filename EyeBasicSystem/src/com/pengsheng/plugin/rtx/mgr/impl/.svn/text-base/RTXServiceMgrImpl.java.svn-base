package com.pengsheng.plugin.rtx.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.plugin.rtx.dao.RTXServiceDao;
import com.pengsheng.plugin.rtx.mgr.RTXServiceMgr;

public class RTXServiceMgrImpl implements RTXServiceMgr {
	private RTXServiceDao rtxServiceDao;
	public RTXServiceDao getRtxServiceDao() {
		return rtxServiceDao;
	}
	public void setRtxServiceDao(RTXServiceDao rtxServiceDao) {
		this.rtxServiceDao = rtxServiceDao;
	}
	public List<DepartmentsPo> getDepartments() {
		return rtxServiceDao.getDepartments();
	}
	public List<PersonInfoPo> getPersonsBydepartmentid(String departmentid) {
		// TODO Auto-generated method stub
		return rtxServiceDao.getPersonsBydepartmentid(departmentid);
	}

	public PersonInfoPo getPerson(PersonInfoPo personInfo){
		// TODO Auto-generated method stub
		return rtxServiceDao.getPerson(personInfo);
	}
	
	public List<PersonInfoPo> getPersons() {
		// TODO Auto-generated method stub
		return rtxServiceDao.getPersons();
	}
}
