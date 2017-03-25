package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.components.dao.WindowPersonDiscountDao;
import com.pengsheng.eims.components.mgr.WindowPersonDiscountMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public class WindowPersonDiscountMgrImpl implements WindowPersonDiscountMgr {

	private WindowPersonDiscountDao windowPersonDiscountDao;
	
	public WindowPersonDiscountDao getWindowPersonDiscountDao() {
		return windowPersonDiscountDao;
	}

	public void setWindowPersonDiscountDao(
			WindowPersonDiscountDao windowPersonDiscountDao) {
		this.windowPersonDiscountDao = windowPersonDiscountDao;
	}

	/**
	 * 查询员工折扣
	 * @param personDiscountPo
	 * @return
	 */
	public PersonInfoPo getDiscount(PersonInfoPo personInfoPo) {
		return windowPersonDiscountDao.getDiscount(personInfoPo);
	}


	public PersonInfoPo getDiscountCard(PersonInfoPo personInfoPo) {
		return windowPersonDiscountDao.getDiscountCard(personInfoPo);
	}
	
	public List<PersonInfoPo> getPersonInfoPoList(PersonInfoPo personInfoPo){
		return windowPersonDiscountDao.getPersonInfoPoList(personInfoPo);
	}
	
	public List<RolePo> getRolePoList(RolePo rolePo){
		return windowPersonDiscountDao.getRolePoList(rolePo);
	}

}
