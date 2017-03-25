package com.pengsheng.eims.storage.mgr.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.CheckStorageDao;
import com.pengsheng.eims.storage.mgr.CheckStorageMgr;
import com.pengsheng.eims.storage.persistence.CheckStorageEntryPo;
import com.pengsheng.eims.storage.persistence.CheckStoragePo;
import com.pengsheng.eims.storage.persistence.CheckStoragefxEntryPo;
import com.pengsheng.eims.storage.persistence.CheckStoragefxPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.tools.Utility;

public class CheckStorageMgrImpl implements CheckStorageMgr {
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private CheckStorageDao checkStorageDao;

	public CheckStorageDao getCheckStorageDao() {
		return checkStorageDao;
	}

	public void setCheckStorageDao(CheckStorageDao checkStorageDao) {
		this.checkStorageDao = checkStorageDao;
	}

	public void insertCheckStorgeTemp(List<String> barcodes,
			CheckStoragePo checkStoragePo) {
		

		checkStorageDao.dropCheckBarcodeTable();// 删除临时条码表
		checkStorageDao.createCheckBarcodeTable();// 创建临时条码表
		checkStorageDao.insertCheckStorgeTemp(checkStoragePo);

		for (String barcode : barcodes) {
			checkStorageDao.insertCheckBarcode(barcode);
		}

		// checkStorageDao.insertCheckStorgeTempEntry(checkStoragePo);
		checkStorageDao.dropCheckBarcodeTable();// 删除临时条码表
	}

	public List<CheckStoragePo> getCheckStorageTempList (CheckStoragePo checkStoragePo) {
		
		return checkStorageDao.getCheckStorageTempList(checkStoragePo);
	}

	public List<CheckStorageEntryPo> getCheckStorageTempEntryList(
			CheckStoragePo checkStoragePo, int start, int size) {
		
		return checkStorageDao.getCheckStorageTempEntryList(checkStoragePo,
				start, size);
	}

	public int getCheckStorageTempEntryCount(CheckStoragePo checkStoragePo) {
		
		return checkStorageDao.getCheckStorageTempEntryCount(checkStoragePo);
	}

	public CheckStoragePo getCheckStorageTempPo(CheckStoragePo checkStoragePo) {
		
		return checkStorageDao.getCheckStorageTempPo(checkStoragePo);
	}

	public void auditCheckStorageTemp(String buildid) {
		
		checkStorageDao.auditCheckStorageTemp(buildid);
	}

	public void deleteCheckStorageTemp(String buildid) {
		
		checkStorageDao.delCheckStorageTemp(buildid);
		checkStorageDao.delCheckStorageTempEntry(buildid);
	}

	/**
	 * 删除当天重复盘点数据，插入新盘点单
	 * 
	 * sxh 2011-5-30
	 * */
	public void insertCheckStorage(CheckStoragePo checkStoragePo,
			LogisticsLogPo logPo,String... buildids) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		int count = checkStorageDao.buildCheckStorageCount(checkStoragePo);
		if (count > 0) {
			checkStorageDao.deleteDoubleCheckStorageEntry(checkStoragePo);
			checkStorageDao.deleteDoubleCheckStorage(checkStoragePo);
		}
//		CheckStoragePo po = checkStorageDao
//				.getCheckStorageTempPo(checkStoragePo);
//
//		checkStoragePo.setCshcsstockid(po.getCshcsstockid());
		// 生成盘点单
		checkStorageDao.buildCheckStorage(checkStoragePo, buildids);
		// 生成盘点明细表
		checkStorageDao.buildCheckStorageEntry(checkStoragePo, buildids);

		// for (String buildid : buildids) {
		// checkStorageDao.delCheckStorageTemp(buildid);
		// checkStorageDao.delCheckStorageTempEntry(buildid);
		// }
	}

	public int getCheckStorageCount(CheckStoragePo checkStoragePo) {
		
		return checkStorageDao.getCheckStorageCount(checkStoragePo);
	}

	public List<CheckStoragePo> getCheckStorageList(
			CheckStoragePo checkStoragePo, int start, int size) {
		
		return checkStorageDao.getCheckStorageList(checkStoragePo, start, size);
	}

	public void auditCheckStorage(CheckStoragePo checkStoragePo,
			String buillid, String personid,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		checkStorageDao.auditCheckStorage(checkStoragePo, buillid, personid);

		checkStorageDao.delCheckStorageTempEntrySum(buillid);
		checkStorageDao.delCheckStorageTempSum(buillid);
	}

	public void deleteCheckStorage(String buildid,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		checkStorageDao.delCheckStorage(buildid);
		checkStorageDao.delCheckStorageEntry(buildid);
	}

	public int getCheckStorageEntryCount(CheckStoragePo checkStoragePo) {
		
		return checkStorageDao.getCheckStorageEntryCount(checkStoragePo);
	}

	public List<CheckStorageEntryPo> getCheckStorageEntryList(
			CheckStoragePo checkStoragePo, int start, int size) {
		
		return checkStorageDao.getCheckStorageEntryList(checkStoragePo, start,
				size);
	}

	public CheckStoragePo getCheckStoragePo(CheckStoragePo checkStoragePo) {
		
		return checkStorageDao.getCheckStoragePo(checkStoragePo);
	}

	public void insertSCISCO(InventoryPo inventoryPo,LogisticsLogPo logPo) {
	
		logisticsLogDao.insertLog(logPo); //新增日志
		
		checkStorageDao.buildSCISCO(inventoryPo);
		checkStorageDao.buildSCISCOEntry(inventoryPo);

		CheckStoragePo checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(inventoryPo.getCstisourcebillid());

		if (inventoryPo.getCstibilltypeid().matches("^5$")) {
			checkStoragePo.setCshcsoverage("2");// 盘盈
		} else if (inventoryPo.getCstibilltypeid().matches("^6$")) {
			checkStoragePo.setCshcslosses("2");// 盘亏
		}

		checkStorageDao.updateCheckStorageSCISCO(checkStoragePo);
	}

	public void insertCheckStorgeTemp(CheckStoragePo checkStoragePo) {
		
		checkStorageDao.insertCheckStorgeTemp(checkStoragePo);
	}

	public void insertCheckStorgeTempEntry(
			CheckStorageEntryPo checkStorageEntryPo) {
		
		checkStorageDao.insertCheckStorgeTempEntry(checkStorageEntryPo);
	}

	/**
	 * 导入盘点文件，生成临时盘点单
	 * 
	 * @param barcodes
	 * @param checkStoragePo
	 */
	public void insertCheckStorgeTemp(CheckStoragePo checkStoragePo,
			File[] checkBarcode) throws Exception {
		
		int count = 0;		
		for (File barcodeF : checkBarcode) {
			BufferedReader bfReader = new BufferedReader(new FileReader(barcodeF));

			String lineStr = "";
			CheckStorageEntryPo checkStorageEntryPo = new CheckStorageEntryPo();
			while ((lineStr = bfReader.readLine()) != null) {
				if (!"".equals(Utility.getName(lineStr)) && Utility.getName(lineStr).trim().length()==26) {
					checkStorageEntryPo.setCshcsebillid(checkStoragePo.getCshcsbillid());
					checkStorageEntryPo.setCshcsebarcode(lineStr.trim().toUpperCase());
					checkStorageDao.insertCheckStorgeTempEntry(checkStorageEntryPo);
					count++;
				}
			}
		}
		
		if (count > 0){
			checkStorageDao.insertCheckStorgeTemp(checkStoragePo);
		}

	}
	
	/**
	 * 盘盈盘亏查询数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public int getCheckStorageykCount(CheckStoragePo checkStoragePo){
		
		return checkStorageDao.getCheckStorageykCount(checkStoragePo);
	}

	/**
	 * 盘盈盘亏查询list
	 * 
	 * @param checkStoragePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CheckStorageEntryPo> getCheckStorageykList(
			CheckStoragePo checkStoragePo, int start, int size){
		
		return checkStorageDao.getCheckStorageykList(checkStoragePo, start, size);
		
	}
	
	/**
	 * 盘盈盘亏查询list
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public List<CheckStorageEntryPo> getCheckStorageykList(CheckStoragePo checkStoragePo){
		
		return checkStorageDao.getCheckStorageykList(checkStoragePo);
	}
	/**
	 * 盈亏分析新增
	 * 
	 * @param checkStoragefxPo
	 * @return
	 */
	public void insertCheckStoragefx(CheckStoragefxPo checkStoragefxPo,List<CheckStoragefxEntryPo> checkStoragefxEntryList,LogisticsLogPo logPo){
		
		//盈亏分析主表新增
 		checkStorageDao.insertCheckStoragefx(checkStoragefxPo);
		//盈亏分析明细表新增
		for (CheckStoragefxEntryPo checkStoragefxEntryPo : checkStoragefxEntryList) {
			checkStorageDao.insertCheckStoragefxEntry(checkStoragefxEntryPo);
		}
		//日志
		logisticsLogDao.insertLog(logPo);  //新增日志
	  }
	
	/**
	 * 盈盘分析数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public int getCheckStoragefxCount(CheckStoragePo checkStoragePo){
		
		return checkStorageDao.getCheckStoragefxCount(checkStoragePo);
	}
	/**
	 * 盈盘分析数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public CheckStoragefxPo getCheckStoragefxPo(CheckStoragePo checkStoragePo){
		return checkStorageDao.getCheckStoragefxPo(checkStoragePo);
	}
	/**
	 * 盈盘分析数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public List<CheckStoragefxEntryPo> getCheckStoragefxEntryList(CheckStoragePo checkStoragePo){
		return checkStorageDao.getCheckStoragefxEntryList(checkStoragePo);
	}
}
