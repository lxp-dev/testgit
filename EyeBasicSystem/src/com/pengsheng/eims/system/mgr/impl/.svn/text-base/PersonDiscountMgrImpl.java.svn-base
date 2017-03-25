package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.dao.PersonDiscountDao;
import com.pengsheng.eims.system.mgr.PersonDiscountMgr;
import com.pengsheng.eims.system.persistence.PersonDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class PersonDiscountMgrImpl implements PersonDiscountMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private PersonDiscountDao personDiscountDao;
	
	public PersonDiscountDao getPersonDiscountDao() {
		return personDiscountDao;
	}

	public void setPersonDiscountDao(PersonDiscountDao personDiscountDao) {
		this.personDiscountDao = personDiscountDao;
	}

	public int getPersonDiscountCount(PersonDiscountPo po) {
		
		return personDiscountDao.getPersonDiscountCount(po);
	}
	
	public List<PersonDiscountPo> getPersonDiscountList(PersonDiscountPo po,
			int start, int size) {
		
		return personDiscountDao.getPersonDiscountList(po, start, size);
	}
	
	public void insertPersonDiscount(PersonDiscountPo po,PersonDiscountDetailsPo dpo,LogisticsLogPo logPo) {
		personDiscountDao.insertPersonDiscount(po);
		
		if(dpo != null){
			for(int i=0; i<dpo.getFpddgoodslevels().length; i++){
				PersonDiscountDetailsPo idpo = new PersonDiscountDetailsPo();
				idpo.setFpddpersonid(po.getFpdpersonid());
				idpo.setFpddgoodslevel(dpo.getFpddgoodslevels()[i]);
				idpo.setFpdddiscount(dpo.getFpdddiscounts()[i]);
				idpo.setFpddspecialdiscountnumber(dpo.getFpddspecialdiscountnumbers()[i]);
				idpo.setFpddspecialdiscount(dpo.getFpddspecialdiscounts()[i]);
				personDiscountDao.insertPersonDiscountDetails(idpo);
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void updatePersonDiscount(PersonDiscountPo po,PersonDiscountDetailsPo dpo,LogisticsLogPo logPo) {
		if(dpo != null){
			personDiscountDao.deletePersonDiscountDetails(po.getFpdpersonid());
			
			for(int i=0; i<dpo.getFpddgoodslevels().length; i++){
				PersonDiscountDetailsPo idpo = new PersonDiscountDetailsPo();
				idpo.setFpddpersonid(po.getFpdpersonid());
				idpo.setFpddgoodslevel(dpo.getFpddgoodslevels()[i]);
				idpo.setFpdddiscount(dpo.getFpdddiscounts()[i]);
				idpo.setFpddspecialdiscountnumber(dpo.getFpddspecialdiscountnumbers()[i]);
				idpo.setFpddspecialdiscount(dpo.getFpddspecialdiscounts()[i]);
				personDiscountDao.insertPersonDiscountDetails(idpo);
			}
		}
		
		personDiscountDao.updatePersonDiscount(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	
	public void deletePersonDiscount(PersonDiscountPo po,LogisticsLogPo logPo) {

		personDiscountDao.deletePersonDiscount(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	
	public PersonDiscountPo getPersonDiscount(PersonDiscountPo po) {
		
		return personDiscountDao.getPersonDiscount(po);
	}
	
	public List<DepartmentsPo> getDepartmentList(RoleDiscountPo rdpo) {
		
		return personDiscountDao.getDepartmentList(rdpo);
	}
	
	public PersonDiscountPo getPersonDiscountDetail(PersonDiscountPo po) {
		
		return personDiscountDao.getPersonDiscountDetail(po);
	}
	
	public void insertPersonDiscountDetails(PersonDiscountDetailsPo po){
		personDiscountDao.insertPersonDiscountDetails(po);
	}
	
	public List<PersonDiscountDetailsPo> selectPersonDiscountDetail(PersonDiscountDetailsPo po){
		return personDiscountDao.selectPersonDiscountDetail(po);
	}
}
