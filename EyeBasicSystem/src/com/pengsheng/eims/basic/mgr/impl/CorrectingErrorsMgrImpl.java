package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.CorrectingErrorsDao;
import com.pengsheng.eims.basic.mgr.CorrectingErrorsMgr;
import com.pengsheng.eims.basic.persistence.CorrectingErrorsPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.CustomerTakeDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public class CorrectingErrorsMgrImpl implements CorrectingErrorsMgr {

	private CorrectingErrorsDao correctingErrorsDao = null;
	private LogisticsLogDao logisticsLogDao = null;
	private CustomerTakeDao customerTakeDao;
	private SystemParameterPo systemParameterPo;
	private SystemParameterDao systemParameterDao;
	
	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}
	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}
	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}
	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}
	public CustomerTakeDao getCustomerTakeDao() {
		return customerTakeDao;
	}
	public void setCustomerTakeDao(CustomerTakeDao customerTakeDao) {
		this.customerTakeDao = customerTakeDao;
	}
	public CorrectingErrorsDao getCorrectingErrorsDao() {
		return correctingErrorsDao;
	}
	public void setCorrectingErrorsDao(CorrectingErrorsDao correctingErrorsDao) {
		this.correctingErrorsDao = correctingErrorsDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}	

	/**
	 * 获取库存差异查询总数
	 */
	public int getInventoryDifferenceCount(CorrectingErrorsPo po){
		return correctingErrorsDao.getInventoryDifferenceCount(po);
	}
	
	/**
	 * 获取库存差异查询列表
	 */
	public List<CorrectingErrorsPo> getInventoryDifferenceList(CorrectingErrorsPo po,int start,int size){
		return correctingErrorsDao.getInventoryDifferenceList(po,start,size);
	}
	
	/**
	 * 获取单据数量与库存的
	 */
	public List<InventoryEntryPo> getInventoryDifferenceBillEntryDetail(CorrectingErrorsPo po){
		return correctingErrorsDao.getInventoryDifferenceBillEntryDetail(po);
	}
	
	/**
	 * 获取错误条码总数
	 */
	public int getErrorsGoodsBarCodeCount(CorrectingErrorsPo po){
		return correctingErrorsDao.getErrorsGoodsBarCodeCount(po);
	}
	
	/**
	 * 获取错误条码查询列表
	 */
	public List<CorrectingErrorsPo> getErrorsGoodsBarCodeList(CorrectingErrorsPo po,int start,int size){
		return correctingErrorsDao.getErrorsGoodsBarCodeList(po,start,size);
	}
	
	/**
	 * 获取异常单据总数
	 */
	public int getBillDifferenceCount(CorrectingErrorsPo po){
		return correctingErrorsDao.getBillDifferenceCount(po);
	}
	
	/**
	 * 获取异常单据列表
	 */
	public List<CorrectingErrorsPo> getBillDifferenceList(CorrectingErrorsPo po,int start,int size){
		return correctingErrorsDao.getBillDifferenceList(po,start,size);
	}
		
	/**
	 * 获取在途库存商品总数
	 */
	public int getGoodsTransitStorageCount(CorrectingErrorsPo po,PersonInfoPo personInfoPo){
		return correctingErrorsDao.getGoodsTransitStorageCount(po,personInfoPo);
	}
	
	/**
	 * 获取在途库存商品列表
	 */
	public List<CorrectingErrorsPo> getGoodsTransitStorageList(CorrectingErrorsPo po,PersonInfoPo personInfoPo,int start,int size){
		return correctingErrorsDao.getGoodsTransitStorageList(po,personInfoPo,start,size);
	}
	
	
	/**
	 * 获取未完结单据总数
	 */
	public int getNotAuditBillCount(CorrectingErrorsPo po){
		return correctingErrorsDao.getNotAuditBillCount(po);
	}
	
	/**
	 * 获取未完结单据列表
	 */
	public List<CorrectingErrorsPo> getNotAuditBillList(CorrectingErrorsPo po,int start,int size){
		return correctingErrorsDao.getNotAuditBillList(po,start,size);
	}	
	
	/**
	 * 删除未完结单据总数
	 */
	public void deleteNotAuditBill(CorrectingErrorsPo po,LogisticsLogPo logPo){
		
		int count = Utility.getName(po.getCerrchangeid()).split(",").length;
		String[] idArray = Utility.getName(po.getCerrchangeid()).split(",");
		
		for (int i = 0; i < count; i++){
			CorrectingErrorsPo tpo = new CorrectingErrorsPo();
			tpo.setCerrchangeid(idArray[i]);
			
			correctingErrorsDao.deleteNotAuditBill(tpo);
		}		
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 处理配镜单
	 */
	public void updateSalesBillInTransit(SystemParameterPo systemParameterPo,CorrectingErrorsPo po,LogisticsLogPo logPo){
		
		correctingErrorsDao.updateSalesBillInTransit(po);
		correctingErrorsDao.insertSalesBillInTransit(po);
		correctingErrorsDao.deleteSalesBillInTransitStorage(po);
		
		// 将配镜单送至已完结的表中		
		if (Utility.getName(systemParameterPo.getFspsplitsalesdataflag()).equals("1")){			
			customerTakeDao.insertSalesBasicFinished(Utility.getName(po.getCerrchangeid()));
			customerTakeDao.insertSalesDetailFinished(Utility.getName(po.getCerrchangeid()));
			customerTakeDao.deleteSalesBasic(Utility.getName(po.getCerrchangeid()));
			customerTakeDao.deleteSalesDetail(Utility.getName(po.getCerrchangeid()));
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 重新转在途库存
	 */
	public void deleteGoodsTransitStorage(CorrectingErrorsPo po,LogisticsLogPo logPo){
		
		correctingErrorsDao.deleteGoodsTransitStorage(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
}
