package com.pengsheng.eims.system.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.system.persistence.PersonDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;

public interface PersonDiscountDao {
	
    public int getPersonDiscountCount(PersonDiscountPo po);
	
	public List<PersonDiscountPo> getPersonDiscountList(PersonDiscountPo po,int start, int size);

	public void insertPersonDiscount(PersonDiscountPo po);
	
	public void updatePersonDiscount(PersonDiscountPo po);
	
	public void deletePersonDiscount(PersonDiscountPo po);
	
	public PersonDiscountPo getPersonDiscount(PersonDiscountPo po);
	
	public List<DepartmentsPo> getDepartmentList(RoleDiscountPo rdpo);	
	
	public PersonDiscountPo getPersonDiscountDetail(PersonDiscountPo po);
	
	public void insertPersonDiscountDetails(PersonDiscountDetailsPo po);
	
	public List<PersonDiscountDetailsPo> selectPersonDiscountDetail(PersonDiscountDetailsPo po);
	
	public void deletePersonDiscountDetails(String pid);
}
