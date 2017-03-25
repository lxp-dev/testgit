package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.dao.DoorStoreDeliveryDao;
import com.pengsheng.eims.sales.dao.ShopCodeTakeDao;
import com.pengsheng.eims.sales.mgr.ShopCodeTakeMgr;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.util.tools.Utility;


public class ShopCodeTakeMgrImpl implements ShopCodeTakeMgr {

	private ShopCodeTakeDao shopCodeTakeDao;
	private StrogeChangeDao strogeChangeDao;	
	public DoorStoreDeliveryDao doorStoreDeliveryDao;
	private SystemParameterDao systemParameterDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private SendNoteMgr sendNoteMgr = null;
	private InTransitDetailsDao inTransitDetailsDao;
	private CustomerInfoDao customerInfoDao;
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	public SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}

	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}

	public DoorStoreDeliveryDao getDoorStoreDeliveryDao() {
		return doorStoreDeliveryDao;
	}

	public void setDoorStoreDeliveryDao(DoorStoreDeliveryDao doorStoreDeliveryDao) {
		this.doorStoreDeliveryDao = doorStoreDeliveryDao;
	}

	public ShopCodeTakeDao getShopCodeTakeDao() {
		return shopCodeTakeDao;
	}

	public void setShopCodeTakeDao(ShopCodeTakeDao shopCodeTakeDao) {
		this.shopCodeTakeDao = shopCodeTakeDao;
	}

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	/**
	 * 查询门店取镜信息数量
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public int getShopCodeTakeCount(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		return shopCodeTakeDao.getShopCodeTakeCount(salesBasicPo);
	}

	/**
	 * 查询门店取镜信息
	 * 
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectShopCodeTake(SalesBasicPo salesBasicPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return shopCodeTakeDao.selectShopCodeTake(salesBasicPo, start, size);
	}

	/**
	 * 关联销售明细表查询商品信息
	 * 
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsDetailInfo(SalesDetailPo salesDetailPo) {
		// TODO Auto-generated method stub
		return shopCodeTakeDao.getGoodsDetailInfo(salesDetailPo);
	}

	/**
	 * 查询客户信息
	 */
	public CustomerInfoPo getCustomerInfo(String salesid) {

		return shopCodeTakeDao.getCustomerInfo(salesid);
	}

	/**
	 * 获取短信平台维护表信息
	 */
	public SmsSetPo getSmsSet() {

		return shopCodeTakeDao.getSmsSet();
	}
	
	/**
	 * 日志DAO
	 */
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}


	/**
	 * 新增顾客取镜信息
	 * 
	 * @param smsRecordPo
	 * @param inTransitPo
	 * @param salesPo
	 * @param goodsSalesType
	 * @throws Exception 
	 */
	
	public void insertShopCodeTake(SendNotePo snpo,InTransitPo inTransitPo, SalesBasicPo salesPo,
			String goodsSalesType,CustomerInfoPo customerInfoPo,PersonInfoPo personInfoPo,LogisticsLogPo logPo) throws Exception {

		InTransitPo inTransitPo1 =new InTransitPo();
		inTransitPo1.setSseitsalesid(salesPo.getSsesbsalesid());
		inTransitPo1 = doorStoreDeliveryDao.selectInTransit(inTransitPo1);
		if(Integer.parseInt(inTransitPo1.getSseitstate()) < 12){
			logisticsLogDao.insertLog(logPo);  //新增日志
			
			// 更新销售基表在途
			shopCodeTakeDao.updateInTransit(salesPo);
	
			// 新增在途明细表
			shopCodeTakeDao.insertInTransit(inTransitPo);
			
			//发送短信
			CustomerInfoPo cpo = new CustomerInfoPo();
			cpo.setSmecicustomerid(Utility.getName(snpo.getSncustomerid()));
			cpo = customerInfoDao.getCustomerInfo(cpo);
			
			snpo.setSncustomername(Utility.getName(cpo.getSmeciname()));
			snpo.setSnsex(Utility.getName(cpo.getSmecisex()).equals("0") ? "先生" : (Utility.getName(cpo.getSmecisex()).equals("1") ? "女士" : ""));
			SalesBasicPo salesBasicPo = new SalesBasicPo();
			salesBasicPo.setSsesbsalesid(Utility.getName(snpo.getSnbillid()));
			salesBasicPo = inTransitDetailsDao.getCustomerInfo(salesBasicPo);
			
			snpo.setSntakeshopcodephone(Utility.getName(salesBasicPo.getSsesbtaketelphone()));
			snpo.setSntakeshopcodename(Utility.getName(salesBasicPo.getSsesbtakeshopname()));
			
			sendNoteMgr.insertSendNoteContent(snpo);
		}
		
	}

	/**
	 * 获取到镜提醒时间
	 */
	public SalesBasicPo getSalesBasic(String salesID) {
		
		return shopCodeTakeDao.getSalesBasic(salesID);
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
	
	public void insertShopCodeTakeBulk(String[] salesids, String[] memberids,SendNotePo snpo,
			InTransitPo inTransitPo, SalesBasicPo salesPo,
			String goodsSalesType, CustomerInfoPo customerInfoPo,
			PersonInfoPo personInfoPo, LogisticsLogPo logPo,String ssesbsalerid) throws Exception {
		for (int i = 0; i < salesids.length; i++){

			String salesid=salesids[i];
			//String memberid=memberids[i];
			customerInfoPo=shopCodeTakeDao.getCustomerInfo(salesid);
			
			SalesDetailPo salesDetailPo = new SalesDetailPo();
			salesDetailPo.setSsesdsalesid(salesid);
			List<SalesDetailPo> goodsInfoList = inTransitDetailsDao.getGoodsInfo(salesDetailPo);
			
			inTransitPo.setSseitsalesid(salesid);
			inTransitPo.setSseitcreateperson(ssesbsalerid);
			
			salesPo.setSsesbsalesid(salesid);
			
			snpo.setSnbillid(salesid);
			
			logPo.setsLogContent("门店取镜销售单："+salesid+" 修改");			
			
			this.insertShopCodeTake(snpo, inTransitPo, salesPo, goodsSalesType, customerInfoPo, personInfoPo, logPo);
		}
		
	}


}
