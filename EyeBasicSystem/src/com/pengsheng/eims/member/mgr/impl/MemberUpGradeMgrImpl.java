package com.pengsheng.eims.member.mgr.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.dao.MemberUpGradeDao;
import com.pengsheng.eims.member.mgr.MemberUpGradeMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.UpgradeRecordPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.tools.Utility;

public class MemberUpGradeMgrImpl implements MemberUpGradeMgr {

	private LogisticsLogDao logisticsLogDao;
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private MemberUpGradeDao memberUpGradeDao;
	private SystemParameterDao systemParameterDao;
	
	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}
	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}	
	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}
	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}	
	public DelaysReminderInformDao getDelaysReminderInformDao() {
		return delaysReminderInformDao;
	}
	public void setDelaysReminderInformDao(
			DelaysReminderInformDao delaysReminderInformDao) {
		this.delaysReminderInformDao = delaysReminderInformDao;
	}
	public MemberUpGradeDao getMemberUpGradeDao() {
		return memberUpGradeDao;
	}
	public void setMemberUpGradeDao(MemberUpGradeDao memberUpGradeDao) {
		this.memberUpGradeDao = memberUpGradeDao;
	}

	/**
	 * 查询会员卡升级信息数量
	 * 
	 * @param customerInfoPo
	 * @return
	 */
	public int getMemberUpGradeCount(CustomerInfoPo customerInfoPo) {
		return memberUpGradeDao.getMemberUpGradeCount(customerInfoPo);
	}

	/**
	 * 查询会员卡升级记录信息数量
	 * 
	 * @param customerInfoPo
	 * @return
	 */
	public int getUpGradeRecordCount(UpgradeRecordPo po) {
		return memberUpGradeDao.getUpGradeRecordCount(po);
	}
	
	/**
	 * 查询会员卡升级信息
	 * 
	 * @param customerInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CustomerInfoPo> selectMemberUpGrade(CustomerInfoPo customerInfoPo, int start, int size) {
		return memberUpGradeDao.selectMemberUpGrade(customerInfoPo, start, size);
	}
	
	/**
	 * 查询会员卡升级记录信息
	 * 
	 * @param customerInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<UpgradeRecordPo> selectUpGradeRecordList(UpgradeRecordPo po, int start, int size) {
		return memberUpGradeDao.selectUpGradeRecordList(po, start, size);
	}

	/**
	 * 查询会员卡升级记录详细信息
	 * @param customerInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public UpgradeRecordPo getUpGradeRecordDetail(UpgradeRecordPo po){
		return memberUpGradeDao.getUpGradeRecordDetail(po);
	}
	
	/**
	 * 更新需要升级的会员卡
	 * 
	 * @param customerInfoPo
	 */
	public void updateMemberUpGrade(CustomerInfoPo po,LogisticsLogPo logPo) {
		
		CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(po);		
		CustomerInfoPo po2 = memberUpGradeDao.selectCustomerInfo(customerInfoPo);
		CustomerInfoPo po3 = memberUpGradeDao.selectUpgradeCardInfo(customerInfoPo);
		
		UpgradeRecordPo tmp = new UpgradeRecordPo();
		tmp.setSmecucurrentcardid(Utility.getName(po2.getSmecicardtype()));
		tmp.setSmecucurrentintegral(Utility.getName(po2.getSmeciintegral()));
		tmp.setSmeculastcardid(Utility.getName(po3.getSmecicardtype()));

		BigDecimal bg = new BigDecimal(Utility.getName(po2.getSmeciintegral()));
		BigDecimal bg2 = new BigDecimal(Utility.getName(po3.getSmeciintegral()));
		bg = bg.subtract(bg2);
		bg = bg.setScale(0, BigDecimal.ROUND_HALF_UP);
		
		if (!Utility.getName(bg2.toString()).equals("0")){
			tmp.setSmecuintegralchange("-"+Utility.getName(bg2.toString()));
		}else{
			tmp.setSmecuintegralchange("0");
		}
		if (bg.intValue() < 0){
			tmp.setSmeculastintegral("0");
		}else{
			tmp.setSmeculastintegral(bg.toString());
		}
		
		tmp.setSmecucustomerid(Utility.getName(customerInfoPo.getSmecicustomerid()));
		tmp.setSmecumemberid(Utility.getName(customerInfoPo.getSmecimemberid()));
		tmp.setSmecuflag("1");
		tmp.setSmecushopcode(Utility.getName(customerInfoPo.getUpgradeshopcode()));
		tmp.setSmecupersonid(Utility.getName(customerInfoPo.getUpgradeperson()));
		
		memberUpGradeDao.insertUpGradeRecord(tmp);
		memberUpGradeDao.updateCustomerInfo(tmp);
		
		logisticsLogDao.insertLog(logPo);
		memberUpGradeDao.updateMemberUpGrade(tmp);
	}

	/**
	 * 查询会员卡类型
	 * 
	 * @param memberManagementPo
	 * @return
	 */
	public List<MemberManagementPo> getMemberManageMentList(
			MemberManagementPo memberManagementPo) {
		return memberUpGradeDao.getMemberManageMentList(memberManagementPo);
	}

	/**
	 * 批量升级会员卡
	 * 
	 * @param smecimemberid
	 * @param customerInfoPo
	 */
	public void updateAllMember(String[] smecimemberid,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,LogisticsLogPo logPo) {
		
		for (int i = 0; i < smecimemberid.length; i++) {
			CustomerInfoPo customerPo = new CustomerInfoPo();
			if(!"".equals(smecimemberid[i])){
				customerPo.setSmecimemberid(smecimemberid[i]);
				CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(customerPo);
				logPo.setsLogContent("会员卡号："+smecimemberid[i]+" 升级");
				logisticsLogDao.insertLog(logPo);  //新增日志
				
				CustomerInfoPo po2 = memberUpGradeDao.selectCustomerInfo(customerInfoPo);
				CustomerInfoPo po3 = memberUpGradeDao.selectUpgradeCardInfo(customerInfoPo);
				
				UpgradeRecordPo tmp = new UpgradeRecordPo();
				tmp.setSmecucurrentcardid(Utility.getName(po2.getSmecicardtype()));
				tmp.setSmecucurrentintegral(Utility.getName(po2.getSmeciintegral()));
				tmp.setSmeculastcardid(Utility.getName(po3.getSmecicardtype()));
								
				BigDecimal bg = new BigDecimal(Utility.getName(po2.getSmeciintegral()));
				BigDecimal bg2 = new BigDecimal(Utility.getName(po3.getSmeciintegral()));
				bg = bg.subtract(bg2);
				bg = bg.setScale(0, BigDecimal.ROUND_HALF_UP);
				
				if (!Utility.getName(bg2.toString()).equals("0")){
					tmp.setSmecuintegralchange("-"+Utility.getName(bg2.toString()));
				}else{
					tmp.setSmecuintegralchange("0");
				}
				if (bg.intValue() < 0){
					tmp.setSmeculastintegral("0");
				}else{
					tmp.setSmeculastintegral(bg.toString());
				}
				
				tmp.setSmecucustomerid(Utility.getName(customerInfoPo.getSmecicustomerid()));
				tmp.setSmecumemberid(Utility.getName(customerInfoPo.getSmecimemberid()));
				tmp.setSmecuflag("1");
				tmp.setSmecushopcode(Utility.getName(personInfoPo.getDepartmentID()));
				tmp.setSmecupersonid(Utility.getName(personInfoPo.getId()));
				
				memberUpGradeDao.insertUpGradeRecord(tmp);
				memberUpGradeDao.updateCustomerInfo(tmp);
				
				memberUpGradeDao.updateMemberUpGrade(tmp);
				
//				if(isSend.equals("1"))
//				{
//					if(Utility.isMobile(customerInfoPo.getSmeciphone()))
//					{
//						smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmecicustomerid());
//						smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());
//						smsRecordPo.setFsrsendperson(personInfoPo.getId());
//						Date now = new Date(); 
//						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//
//						smsRecordPo.setFsrsenddate(dateFormat.format(now)); 
//						delaysReminderInformDao.insertSmsRecord(smsRecordPo);
//					}
//				}
			}			
		}
	}

	/**
	 * 会员卡直接升级
	 */
	public void updateMemberCardTypeUpGrade(CustomerInfoPo po,LogisticsLogPo logPo){
		
		CustomerInfoPo po2 = memberUpGradeDao.selectCustomerInfo(po);
		if (!Utility.getName(po.getSmecicardtype()).equals(Utility.getName(po2.getSmecicardtype()))){
			UpgradeRecordPo tmp = new UpgradeRecordPo();
			tmp.setSmecucurrentcardid(Utility.getName(po2.getSmecicardtype()));
			tmp.setSmecucurrentintegral(Utility.getName(po2.getSmeciintegral()));
			tmp.setSmecuintegralchange("0");
			tmp.setSmeculastcardid(Utility.getName(po.getSmecicardtype()));
			tmp.setSmeculastintegral(Utility.getName(po2.getSmeciintegral()));
			tmp.setSmecucustomerid(Utility.getName(po2.getSmecicustomerid()));
			tmp.setSmecumemberid(Utility.getName(po2.getSmecimemberid()));
			tmp.setSmecuflag("2");
			tmp.setSmecushopcode(Utility.getName(po.getUpgradeshopcode()));
			tmp.setSmecupersonid(Utility.getName(po.getUpgradeperson()));
			
			memberUpGradeDao.insertUpGradeRecord(tmp);
		}
		
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		this.memberUpGradeDao.updateMemberCardTypeUpGrade(po);
	}
	
}
