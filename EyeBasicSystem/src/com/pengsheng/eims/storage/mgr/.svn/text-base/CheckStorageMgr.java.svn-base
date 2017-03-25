package com.pengsheng.eims.storage.mgr;

import java.io.File;
import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.CheckStorageEntryPo;
import com.pengsheng.eims.storage.persistence.CheckStoragePo;
import com.pengsheng.eims.storage.persistence.CheckStoragefxEntryPo;
import com.pengsheng.eims.storage.persistence.CheckStoragefxPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface CheckStorageMgr {

	/**
	 * 导入盘点文件，生成临时盘点单
	 * 
	 * @param barcodes
	 * @param checkStoragePo
	 */
	public void insertCheckStorgeTemp(CheckStoragePo checkStoragePo);
	/**
	 * 导入盘点文件，生成临时盘点单
	 * 
	 * @param barcodes
	 * @param checkStoragePo
	 */
	public void insertCheckStorgeTemp(CheckStoragePo checkStoragePo,File[] checkBarcode) throws Exception ;

	/**
	 * 得到指定仓位所有临时盘点单
	 * 
	 * @param stockid
	 * @return
	 */
	public List<CheckStoragePo> getCheckStorageTempList(CheckStoragePo checkStoragePo);

	/**
	 * 得到临时盘点主表
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public CheckStoragePo getCheckStorageTempPo(CheckStoragePo checkStoragePo);

	/**
	 * 得到临时盘点明细总数
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public int getCheckStorageTempEntryCount(CheckStoragePo checkStoragePo);

	/**
	 * 得到临时盘点明细
	 * 
	 * @param checkStoragePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CheckStorageEntryPo> getCheckStorageTempEntryList(
			CheckStoragePo checkStoragePo, int start, int size);

	/**
	 * 审核盘点临时表
	 * 
	 * @param buildid
	 */
	public void auditCheckStorageTemp(String buildid);

	/**
	 * 删除审核盘点临时表
	 * 
	 * @param buildid
	 */
	public void deleteCheckStorageTemp(String buildid);

	/**
	 * 生成盘点单
	 * 
	 * @param checkStoragePo
	 * @param buildids
	 */
	public void insertCheckStorage(CheckStoragePo checkStoragePo,
			LogisticsLogPo logPo,String... buildids);

	/**
	 * 盘点单数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public int getCheckStorageCount(CheckStoragePo checkStoragePo);

	/**
	 * 盘点单分页
	 * 
	 * @param checkStoragePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CheckStoragePo> getCheckStorageList(
			CheckStoragePo checkStoragePo, int start, int size);

	/**
	 * 审核
	 * 
	 * @param buillid
	 */
	public void auditCheckStorage(CheckStoragePo checkStoragePo,String buillid, String personid,LogisticsLogPo logPo);

	/**
	 * 删除盘点单盘点明细
	 * 
	 * @param buildid
	 */
	public void deleteCheckStorage(String buildid,LogisticsLogPo logPo);

	/**
	 * 盘点单数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public int getCheckStorageEntryCount(CheckStoragePo checkStoragePo);

	/**
	 * 盘点单明细
	 * 
	 * @param checkStoragePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CheckStorageEntryPo> getCheckStorageEntryList(
			CheckStoragePo checkStoragePo, int start, int size);

	/**
	 * 得到盘点对象
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public CheckStoragePo getCheckStoragePo(CheckStoragePo checkStoragePo);

	/**
	 * 生成盘盈盘亏单
	 * 
	 * @param inventoryPo
	 */
	public void insertSCISCO(InventoryPo inventoryPo,LogisticsLogPo logPo);
	/*
	 * 插入临时盘点明细表
	 * sxh2011-5-6
	 * 
	 * */
	public void insertCheckStorgeTempEntry(CheckStorageEntryPo checkStorageEntryPo);
	/**
	 * 盘盈盘亏查询数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public int getCheckStorageykCount(CheckStoragePo checkStoragePo);

	/**
	 * 盘盈盘亏查询list
	 * 
	 * @param checkStoragePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CheckStorageEntryPo> getCheckStorageykList(
			CheckStoragePo checkStoragePo, int start, int size);
	/**
	 * 盘盈盘亏查询list
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public List<CheckStorageEntryPo> getCheckStorageykList(CheckStoragePo checkStoragePo);
	
	/**
	 * 盈亏分析新增
	 * 
	 * @param checkStoragefxPo
	 * @return
	 */
	public void insertCheckStoragefx(CheckStoragefxPo checkStoragefxPo,List<CheckStoragefxEntryPo> checkStoragefxEntryList,LogisticsLogPo logPo);
	/**
	 * 盈盘分析数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public int getCheckStoragefxCount(CheckStoragePo checkStoragePo);
	/**
	 * 盈盘分析数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public CheckStoragefxPo getCheckStoragefxPo(CheckStoragePo checkStoragePo);
	/**
	 * 盈盘分析数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public List<CheckStoragefxEntryPo> getCheckStoragefxEntryList(CheckStoragePo checkStoragePo);
}
