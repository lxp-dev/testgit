package com.pengsheng.eims.system.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.PersonDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;

public interface PersonDiscountMgr {
	
    public int getPersonDiscountCount(PersonDiscountPo po);
	
	public List<PersonDiscountPo> getPersonDiscountList(PersonDiscountPo po,int start, int size);

	public void insertPersonDiscount(PersonDiscountPo po,PersonDiscountDetailsPo dpo,LogisticsLogPo logPo);
	
	public void updatePersonDiscount(PersonDiscountPo po,PersonDiscountDetailsPo dpo,LogisticsLogPo logPo);
	
	public void deletePersonDiscount(PersonDiscountPo po,LogisticsLogPo logPo);
	
	public PersonDiscountPo getPersonDiscount(PersonDiscountPo po);
	
	public List<DepartmentsPo> getDepartmentList(RoleDiscountPo rdpo);
	
	public PersonDiscountPo getPersonDiscountDetail(PersonDiscountPo po);
	
	public void insertPersonDiscountDetails(PersonDiscountDetailsPo po);
	
	public List<PersonDiscountDetailsPo> selectPersonDiscountDetail(PersonDiscountDetailsPo po);
}
