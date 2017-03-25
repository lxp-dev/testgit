package com.pengsheng.eims.system.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.RoleDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;

public interface RoleDiscountMgr {

	public int getRoleDiscountCount(RoleDiscountPo po);
	
	public List<RoleDiscountPo> getRoleDiscountList(RoleDiscountPo po,int start, int size);
	
	public List<RolePo> getRoleList(RoleDiscountPo po);
	
	public RoleDiscountPo getRoleDiscount(RoleDiscountPo po);
	
	public void insertRoleDiscount(RoleDiscountPo po,RoleDiscountDetailsPo idpo,LogisticsLogPo logPo, String changeDiscount);
	
	public void updateRoleDiscount(RoleDiscountPo po,RoleDiscountDetailsPo idpo,LogisticsLogPo logPo, String changeDiscount);	
	
	public RoleDiscountPo getRoleDiscountDetail(RoleDiscountPo po);

	/**
	 * 根据角色ID获取该角色下所有人员
	 * @param RolePo po 角色Po
	 * @return List<PersonInfoPo>
	 * @author ZK
	 */
	public List<PersonInfoPo> getPersonInfoByRole(RoleDiscountPo po);
	
	public List<RoleDiscountDetailsPo> selectRoleDiscountDetails(RoleDiscountDetailsPo po);
}
