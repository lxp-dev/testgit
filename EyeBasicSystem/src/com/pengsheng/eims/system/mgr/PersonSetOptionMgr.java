package com.pengsheng.eims.system.mgr;

import com.pengsheng.eims.system.persistence.PersonSetOptionPo;

/**
 * 个人登录参数设置Mgr
 * @author moyongsheng 2014 11 16
 *
 */
public interface PersonSetOptionMgr {
	
	/**
	 * 查询个人登录参数设置<PersonSetOptionPo>；
	 * * @param String personId; 员工ID
	 */
	public PersonSetOptionPo selectPersonSetOptionPo(String personId);
	
	/**
	 * 更新个人登录参数设置;
	 * * @param PersonSetOptionPo personSetOptionPo; 个人登录参数设置PO
	 */
	public void updatePersonSetOptionPo(PersonSetOptionPo personSetOptionPo);
	
}
