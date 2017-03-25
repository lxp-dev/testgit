package com.pengsheng.eims.member.mgr.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerReturnVisitDao;
import com.pengsheng.eims.member.mgr.CustomerReturnVisitMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.CustomerVisitPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.sms.server.persistence.SmsPo;

public class CustomerReturnVisitMgrImpl implements CustomerReturnVisitMgr {
	private LogisticsLogDao logisticsLogDao;
	
	private SmsRecordPo smsRecordPo;
	
	public SmsRecordPo getSmsRecordPo() {
		return smsRecordPo;
	}

	public void setSmsRecordPo(SmsRecordPo smsRecordPo) {
		this.smsRecordPo = smsRecordPo;
	}


	private DelaysReminderInformDao delaysReminderInformDao;

	public DelaysReminderInformDao getDelaysReminderInformDao() {
		return delaysReminderInformDao;
	}

	public void setDelaysReminderInformDao(
			DelaysReminderInformDao delaysReminderInformDao) {
		this.delaysReminderInformDao = delaysReminderInformDao;
	}
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	
	private CustomerReturnVisitDao customerReturnVisitDao;

	public CustomerReturnVisitDao getCustomerReturnVisitDao() {
		return customerReturnVisitDao;
	}

	public void setCustomerReturnVisitDao(
			CustomerReturnVisitDao customerReturnVisitDao) {
		this.customerReturnVisitDao = customerReturnVisitDao;
	}

	/**
	 * 得到顾客回访信息数量
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public int getCustomerReturnVisitCount(SalesBasicPo salesBasicPo,
			CustomerVisitPo customerVisitPo,SystemParameterPo systemParameterPo) {
		// TODO Auto-generated method stub
		return customerReturnVisitDao.getCustomerReturnVisitCount(salesBasicPo,
				customerVisitPo,systemParameterPo);
	}

	/**
	 * 查询顾客回访信息
	 * 
	 * @param SalesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectCustomerReturnVisitList(
			SalesBasicPo salesBasicPo, CustomerVisitPo customerVisitPo,
			int start, int size,SystemParameterPo systemParameterPo) {
		// TODO Auto-generated method stub
		return customerReturnVisitDao.selectCustomerReturnVisitList(
				salesBasicPo, customerVisitPo, start, size,systemParameterPo);
	}

	/**
	 * 得到要回访的顾客信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getReturnCustomerInfo(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		return customerReturnVisitDao.getReturnCustomerInfo(salesBasicPo);
	}

	/**
	 * 取出销售单中右眼镜片信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {
		return customerReturnVisitDao.getODDetailInfo(salesBasicPo);
	}

	/**
	 * 取出销售单中左眼镜片信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		return customerReturnVisitDao.getOSDetailInfo(salesBasicPo);
	}

	/**
	 * 得到配镜单中商品的详细信息
	 * 
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsInfo(SalesDetailPo salesDetailPo) {
		// TODO Auto-generated method stub
		return customerReturnVisitDao.getGoodsInfo(salesDetailPo);
	}

	/**
	 * 取得附加费用
	 * 
	 * @param additionalCDetailPo
	 * @return
	 */
	public List<AdditionalCDetailPo> getAddititonalCDetail(
			AdditionalCDetailPo additionalCDetailPo) {
		// TODO Auto-generated method stub
		return customerReturnVisitDao
				.getAddititonalCDetail(additionalCDetailPo);
	}

	/**
	 * 取得特殊加工要求
	 * 
	 * @param specialPDetailPo
	 * @return
	 */
	public List<SpecialPDetailPo> getSpecialPDetail(
			SpecialPDetailPo specialPDetailPo) {
		// TODO Auto-generated method stub
		return customerReturnVisitDao.getSpecialPDetail(specialPDetailPo);
	}

	/**
	 * 得到顾客回访信息
	 * 
	 * @param customerVisitPo
	 * @return
	 */
	public List<CustomerVisitPo> getCustomerVisitInfo(CustomerVisitPo customerVisitPo) {
		// TODO Auto-generated method stub
		return customerReturnVisitDao.getCustomerVisitInfo(customerVisitPo);
		
	}

	/**
	 * 插入回访明细表
	 * 
	 * @param customerVisitPo
	 */
	public void insertCustomerVisit(CustomerVisitPo customerVisitPo,CustomerInfoPo customerInfoPo,PersonInfoPo personInfoPo,SmsRecordPo smsRecordPo,String isSend,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		//customerReturnVisitDao.deleteCustomerVisit(customerVisitPo);
		customerReturnVisitDao.insertCustomerVisit(customerVisitPo);
		
//		if(isSend.equals("1"))
//		{			
//			if(Utility.isMobile(customerInfoPo.getSmeciphone()))
//			{
//				smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmecicustomerid());
//				smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());
//				smsRecordPo.setFsrsendperson(personInfoPo.getId());
//				Date now = new Date(); 
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//
//				smsRecordPo.setFsrsenddate(dateFormat.format(now)); 
//				delaysReminderInformDao.insertSmsRecord(smsRecordPo);
//			}
//		}

	}

	/**
	 * 查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfo(String salesid) {

		return customerReturnVisitDao.getCustomerInfo(salesid);
	}

	// public List<CustomerInfoPo> getCustomerInfo() {
	//		
	// return smsSetVisitJobDao.getCustomerInfo();
	// }

	/**
	 * 获取短信平台维护表信息
	 */
	public SmsSetPo getSmsSet() {

		return customerReturnVisitDao.getSmsSet();
	}

	/**
	 * 新增短信记录表
	 */
	public void insertSmsRecord(SmsRecordPo smsRecordPo) {

		
//		SynchronizationSMS synchronizationSMS = SynchronizationSMS
//		.getInstance();


		SmsPo sms = new SmsPo();
		sms.setSmsid(smsRecordPo.getFsrid());
		sms.setFromid("");
		sms.setPhone(smsRecordPo.getFsrreceipttel());
		sms.setContent(smsRecordPo.getFsrsendcontext());
		sms.setSendtime(smsRecordPo.getFsrsenddate());
	
		try {
//			synchronizationSMS.insertSMS(sms);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		customerReturnVisitDao.insertSmsRecord(smsRecordPo);
	}
}
