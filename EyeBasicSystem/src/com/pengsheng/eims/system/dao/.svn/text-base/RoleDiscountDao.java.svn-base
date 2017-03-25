package com.pengsheng.eims.system.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonRolesPo;
import com.pengsheng.eims.system.persistence.RoleDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;

public interface RoleDiscountDao {

	public int getRoleDiscountCount(RoleDiscountPo po);
	
	public List<RoleDiscountPo> getRoleDiscountList(RoleDiscountPo po,int start, int size);
	
	public List<RolePo> getRoleList(RoleDiscountPo po);
	
	public RoleDiscountPo getRoleDiscount(RoleDiscountPo po);
	
	public void insertRoleDiscount(RoleDiscountPo po);
	
	public void updateRoleDiscount(RoleDiscountPo po);		
	
	public RoleDiscountPo getRoleDiscountDetail(RoleDiscountPo po);
	
	public List<PersonRolesPo> getPersonForRole(String roleID);

	/**
	 * 根据角色ID获取该角色下所有人员
	 * @param RolePo po 角色Po
	 * @return List<PersonInfoPo>
	 * @author ZK
	 */
	public List<PersonInfoPo> getPersonInfoByRole(RoleDiscountPo po);
	
	public void insertRoleDiscountDetails(RoleDiscountDetailsPo po);
	
	public List<RoleDiscountDetailsPo> selectRoleDiscountDetails(RoleDiscountDetailsPo po);
	
	public void deleteRoleDiscountDetails(String pid);
}
