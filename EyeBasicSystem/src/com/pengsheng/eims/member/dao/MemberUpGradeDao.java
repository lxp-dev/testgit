package com.pengsheng.eims.member.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.UpgradeRecordPo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;

public interface MemberUpGradeDao {

	/**
	 * 查询会员卡升级信息数量
	 * 
	 * @param customerInfoPo
	 * @return
	 */
	public int getMemberUpGradeCount(CustomerInfoPo customerInfoPo);

	/**
	 * 查询会员卡升级记录信息数量
	 * @param customerInfoPo
	 * @return
	 */
	public int getUpGradeRecordCount(UpgradeRecordPo po);
	
	/**
	 * 查询会员卡升级信息
	 * 
	 * @param customerInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CustomerInfoPo> selectMemberUpGrade(CustomerInfoPo customerInfoPo, int start, int size);
	public List<CustomerInfoPo> selectMemberUpGrade(CustomerInfoPo customerInfoPo);

	/**
	 * 查询会员卡升级信息
	 * @param customerInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<UpgradeRecordPo> selectUpGradeRecordList(UpgradeRecordPo po , int start , int size);
	
	/**
	 * 查询会员卡升级记录详细信息
	 * @param customerInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public UpgradeRecordPo getUpGradeRecordDetail(UpgradeRecordPo po);
	
	/**
	 * 更新需要升级的会员卡
	 * 
	 * @param customerInfoPo
	 */
	public void updateMemberUpGrade(UpgradeRecordPo po);

	/**
	 * 查询会员卡类型
	 * @param memberManagementPo
	 * @return
	 */
	public List<MemberManagementPo> getMemberManageMentList(MemberManagementPo memberManagementPo);
	
	/**
	 * 新增会员卡升级记录
	 * 
	 * @param customerInfoPo
	 */
	public void insertUpGradeRecord(UpgradeRecordPo po);
	
	/**
	 * 查询会员信息
	 * 
	 * @param customerInfoPo
	 */
	public CustomerInfoPo selectCustomerInfo(CustomerInfoPo po);
	
	/**
	 * 查询会员卡升级后的会员卡类型和扣除积分
	 * 
	 * @param customerInfoPo
	 */
	public CustomerInfoPo selectUpgradeCardInfo(CustomerInfoPo po);
	
	/**
	 * 更新会员积分
	 * 
	 * @param po
	 */
	public void updateCustomerInfo(UpgradeRecordPo po);
	
	/**
	 * 会员卡直接升级
	 */
	public void updateMemberCardTypeUpGrade(CustomerInfoPo customerInfoPo);
}
