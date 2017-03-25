package com.pengsheng.eims.system.mgr.impl;

import com.pengsheng.eims.system.dao.PersonSetOptionDao;
import com.pengsheng.eims.system.mgr.PersonSetOptionMgr;
import com.pengsheng.eims.system.persistence.PersonSetOptionPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;


/**
 * 个人登录参数设置Mgr
 * @author moyongsheng 2014 11 16
 *
 */

public class PersonSetOptionMgrImpl extends BaseJdbcDaoSupport implements PersonSetOptionMgr {
	
	private PersonSetOptionDao personSetOptionDao;
	/**
	 * 查询个人登录参数设置<PersonSetOptionPo>；
	 * * @param String personId; 员工ID
	 */
	public PersonSetOptionPo selectPersonSetOptionPo(String personId){
		return personSetOptionDao.selectPersonSetOptionPo(personId);
	}
	
	/**
	 * 更新个人登录参数设置;
	 * * @param PersonSetOptionPo personSetOptionPo; 个人登录参数设置PO
	 */
	public void updatePersonSetOptionPo(PersonSetOptionPo personSetOptionPo){
		personSetOptionDao.deletePersonSetOptionPo(personSetOptionPo.getFpsopersonid());
		personSetOptionDao.insertPersonSetOptionPo(personSetOptionPo);
	}

	public PersonSetOptionDao getPersonSetOptionDao() {
		return personSetOptionDao;
	}

	public void setPersonSetOptionDao(PersonSetOptionDao personSetOptionDao) {
		this.personSetOptionDao = personSetOptionDao;
	}
}
