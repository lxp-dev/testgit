package com.pengsheng.eims.components.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface WindowPersonDiscountDao {

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
	
	/**
	 * 更新特殊折扣次数
	 * @param personid
	 */
	public void updateSpecialDiscountNumber(String personid);
	
	/**
	 * 更新特殊折扣次数
	 * @param personid
	 */
	public void updateSpecialDiscountNumberLevel(String personid,String goodslevel);
	
	public List<PersonInfoPo> getPersonInfoPoList(PersonInfoPo personInfoPo);
	public List<RolePo> getRolePoList(RolePo rolePo);
}
