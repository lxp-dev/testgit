package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.SupplierDao;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.DelaysReminderPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.storage.dao.StorageDelaysReminderDao;
import com.pengsheng.eims.storage.mgr.StorageDelaysReminderMgr;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class StorageDelaysReminderMgrImpl implements StorageDelaysReminderMgr {
	
	private ProcurementOrdersDao procurementOrdersDao;

	private SupplierDao supplierDao;

	public ProcurementOrdersDao getProcurementOrdersDao() {
		return procurementOrdersDao;
	}

	public void setProcurementOrdersDao(
			ProcurementOrdersDao procurementOrdersDao) {
		this.procurementOrdersDao = procurementOrdersDao;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		// TODO Auto-generated method stub
		return procurementOrdersDao.getGoodsCategorys();
	}
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private StorageDelaysReminderDao storageDelaysReminderDao;

	public StorageDelaysReminderDao getStorageDelaysReminderDao() {
		return storageDelaysReminderDao;
	}

	public void setStorageDelaysReminderDao(
			StorageDelaysReminderDao storageDelaysReminderDao) {
		this.storageDelaysReminderDao = storageDelaysReminderDao;
	}

	public List<DelaysReminderPo> getStorageDelaysRemindertList(
			DelaysReminderPo po, int start, int size) {

		return storageDelaysReminderDao.getStorageDelaysRemindertList(po,
				start, size);
	}

	public int getStoragetDelaysRemindertCount(DelaysReminderPo po) {

		return storageDelaysReminderDao.getStoragetDelaysRemindertCount(po);
	}

	/**
	 * 取出销售单中右眼镜片信息
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {

		return storageDelaysReminderDao.getODDetailInfo(salesBasicPo);
	}

	/**
	 * 取出销售单左眼镜片信息
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {

		return storageDelaysReminderDao.getOSDetailInfo(salesBasicPo);
	}

	/**
	 * 新增误期信息
	 */
	public void insertDelaysRemindert(DelaysReminderPo po,LogisticsLogPo logPo) {
		storageDelaysReminderDao.insertDelaysRemindert(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 删除误期查询
	 */
	public void deleteStorageDelaysRemindert(String id,LogisticsLogPo logPo) {

		storageDelaysReminderDao.deleteStorageDelaysRemindert(id);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 查询误期信息
	 */
	public DelaysReminderPo getStorageDelaysRemindert(DelaysReminderPo po) {

		return storageDelaysReminderDao.getStorageDelaysRemindert(po);
	}

	/**
	 * 查询订单误期信息数量
	 */
	public int getOrderDelaysRemindertCount(DelaysReminderPo delaysReminderPo) {

		return storageDelaysReminderDao
				.getOrderDelaysRemindertCount(delaysReminderPo);
	}

	/**
	 * 显示订单误期信息
	 */
	public List<DelaysReminderPo> getOrderDelaysRemindertList(
			DelaysReminderPo delaysReminderPo, int start, int size) {

		return storageDelaysReminderDao.getOrderDelaysRemindertList(
				delaysReminderPo, start, size);
	}


	public SalesBasicPo getSalesBasic(SalesBasicPo po) {
		// TODO Auto-generated method stub
		return storageDelaysReminderDao.getSalesBasic(po);
	}

}
