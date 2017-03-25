package com.pengsheng.eims.sales.mgr.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.dao.UnitDao;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.dao.IntegralAddandSubDao;
import com.pengsheng.eims.sales.mgr.IntegralAddandSubMgr;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public class IntegralAddandSubMgrImpl implements IntegralAddandSubMgr{
	
	private IntegralAddandSubDao integralAddandSubDao;
	private LogisticsLogMgr logisticsLogMgr;
	private CustomerInfoDao customerInfoDao;
	private UnitDao unitDao;
	private SystemParameterDao systemParameterDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	
	public void insertIntegralAddandSubPo(IntegralAddandSubPo po,PersonInfoPo personInfoPo,SmsRecordPo smsRecordPo,String isSend,LogisticsLogPo logPo) {
		
		integralAddandSubDao.insertIntegralAddandSubPo(po);
		
		//变更会员积分
		CustomerInfoPo icpo = new CustomerInfoPo();
		icpo.setSmeciintegral(po.getSmeasxintegral());
		icpo.setSmecimemberid(po.getSmeasmemberid());
		customerInfoDao.updateCustomerInfoIntegral(icpo);
		
		logPo.setsLogContent("会员卡号："+po.getSmeasmemberid()+"积分赠送("+po.getSmeascintegral()+")");		
		
		logisticsLogMgr.insertLog(logPo);
	}
	
	public int selectIntegralAddandSubCount(IntegralAddandSubPo po) {
		return integralAddandSubDao.selectIntegralAddandSubCount(po);
	}

	public List<IntegralAddandSubPo> selectIntegralAddandSubList(
			IntegralAddandSubPo po, int start, int size) {
		return integralAddandSubDao.selectIntegralAddandSubList(po, start, size);
	}
	
	public IntegralAddandSubPo selectIntegralAddandSubPo(IntegralAddandSubPo po) {
		return integralAddandSubDao.selectIntegralAddandSubPo(po);
	}
	
	public void updateIntegralAddandSubSendType(IntegralAddandSubPo po) {
		integralAddandSubDao.updateIntegralAddandSubSendType(po);
	}

	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}

	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}

	public IntegralAddandSubDao getIntegralAddandSubDao() {
		return integralAddandSubDao;
	}

	public void setIntegralAddandSubDao(IntegralAddandSubDao integralAddandSubDao) {
		this.integralAddandSubDao = integralAddandSubDao;
	}

	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	public UnitDao getUnitDao() {
		return unitDao;
	}

	public void setUnitDao(UnitDao unitDao) {
		this.unitDao = unitDao;
	}

	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}

	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}

	public DelaysReminderInformDao getDelaysReminderInformDao() {
		return delaysReminderInformDao;
	}

	public void setDelaysReminderInformDao(
			DelaysReminderInformDao delaysReminderInformDao) {
		this.delaysReminderInformDao = delaysReminderInformDao;
	}
	
}
