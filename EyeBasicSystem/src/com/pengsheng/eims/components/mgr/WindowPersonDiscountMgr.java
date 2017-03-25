package com.pengsheng.eims.components.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface WindowPersonDiscountMgr {

	/**
	 * 查询员工折扣
	 * 
	 * @param personDiscountPo
	 * @return
	 */
	public PersonInfoPo getDiscount(PersonInfoPo personInfoPo);

	/**
	 * 查询员工折扣
	 * 
	 * @param personDiscountPo
	 * @return
	 */
	public PersonInfoPo getDiscountCard(PersonInfoPo personInfoPo);
	
	public List<PersonInfoPo> getPersonInfoPoList(PersonInfoPo personInfoPo);
	public List<RolePo> getRolePoList(RolePo rolePo);
}
