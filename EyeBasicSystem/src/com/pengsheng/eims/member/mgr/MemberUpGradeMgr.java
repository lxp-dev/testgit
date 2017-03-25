package com.pengsheng.eims.member.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.UpgradeRecordPo;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface MemberUpGradeMgr {

	/**
	 * 查询会员卡升级信息数量
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
	 * @param customerInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CustomerInfoPo> selectMemberUpGrade(CustomerInfoPo customerInfoPo , int start , int size);
	
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
	 * @param customerInfoPo
	 */
	public void updateMemberUpGrade(CustomerInfoPo customerInfoPo,LogisticsLogPo logPo);
	
	/**
	 * 查询会员卡类型
	 * @param memberManagementPo
	 * @return
	 */
	public List<MemberManagementPo> getMemberManageMentList(MemberManagementPo memberManagementPo);
	
	/**
	 * 批量升级会员卡
	 * @param smecimemberid
	 * @param customerInfoPo
	 */
	public void updateAllMember(String[] smecimemberid,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,LogisticsLogPo logPo);
	
	/**
	 * 会员卡直接升级
	 */
	public void updateMemberCardTypeUpGrade(CustomerInfoPo customerInfoPo,LogisticsLogPo logPo);
}
