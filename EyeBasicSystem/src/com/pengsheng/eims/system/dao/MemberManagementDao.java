package com.pengsheng.eims.system.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.persistence.MemberManagementDiscountPo;
import com.pengsheng.eims.system.persistence.MemberManagementDiscountSetUpDetailsPo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;

public interface MemberManagementDao {
	
	public void insertMemberManagement(MemberManagementPo po);
	
	public void updateMemberManagement(MemberManagementPo po);	
	
	public void deleteMemberManagement(MemberManagementPo po);
	
	public MemberManagementPo getMemberManagement(MemberManagementPo po);
	
	public List<MemberManagementPo> getMemberManagementList();
	
	public int getMemberManagementName(MemberManagementPo po) ;

	public int getMemberManagementNameUpdate(MemberManagementPo po) ;
	public int getMemberManagementCount(MemberManagementPo po) ;
	
	public List getMemberList(MemberManagementPo po, int start, int size) ;
	/**
	 * 查询最大折扣设置列表
	 */
	public List<MemberManagementDiscountPo> getMemberManagementDiscountSetList(MemberManagementDiscountPo po, int start, int size);
/**
	 * 查询会员卡类型折扣设置总数
	 */
	public int getMemberManagementDiscountSetCount(MemberManagementDiscountPo po);
	/**
	 * 折扣编号是否存在
	 * 
	 */
	public int isExistMemberManagementDiscountSet(MemberManagementDiscountPo po);
	
	/**
	 * 增加折扣设置
	 * 
	 */
	public void insertMemberManagementDiscountSet(MemberManagementDiscountPo po);
	/**
	 * 折扣设置详细
	 * 
	 */
	public MemberManagementDiscountPo getMemberManagementDiscountSetDetail(MemberManagementDiscountPo po);
	/**
	 * 折扣设置修改
	 * 
	 */
	public void updateMemberManagementDiscount(MemberManagementDiscountPo po) ;
	
	/**
	 * 折扣设置批量修改
	 * 
	 */
	public void updateMemberManagementDiscountBatch(MemberManagementDiscountPo po);
	
	/**
	 * 删除折扣设置
	 * 
	 */
	public void deleteMemberManagementDiscountSet(MemberManagementDiscountPo po);
	
	/**
	 * 查询会员卡类型类别折扣是否存在
	 */
	public int getMemberManagementDiscountCategoryCount(MemberManagementDiscountPo po);
	
	/**
	 * 会员卡类型是否使用
	 */
	public int isUseMemberManagement(MemberManagementPo po);
	
	/**
	 * 判断会员卡积分是否重复
	 */
	public int getMemberCardIntegralArea(MemberManagementPo po);
	
	public void updateMemberManagementDefault(MemberManagementPo po);
	
	public void insertMemberManagementDiscountSetUpDetails(MemberManagementDiscountSetUpDetailsPo po);
	
	public List<MemberManagementDiscountSetUpDetailsPo> selectMemberManagementDiscountSetUpDetails(MemberManagementDiscountSetUpDetailsPo po);
	
	public void deleteMemberManagementDiscountSetUpDetailss(String pid);
	
	public void insertMemberManagementSetDefaultDiscount(MemberManagementDiscountPo po);
}
