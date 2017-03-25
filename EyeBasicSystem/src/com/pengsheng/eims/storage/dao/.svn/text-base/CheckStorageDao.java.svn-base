package com.pengsheng.eims.storage.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.persistence.CheckStorageEntryPo;
import com.pengsheng.eims.storage.persistence.CheckStoragePo;
import com.pengsheng.eims.storage.persistence.CheckStoragefxEntryPo;
import com.pengsheng.eims.storage.persistence.CheckStoragefxPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface CheckStorageDao {

	/**
	 * 删除临时表
	 */
	public void dropCheckBarcodeTable();

	/**
	 * 创建临时表
	 */
	public void createCheckBarcodeTable();

	/**
	 * 插入盘点文件到临时表
	 * 
	 * @param barcode
	 */
	public void insertCheckBarcode(String barcode);

	/**
	 * 插入临时盘点单主表
	 * 
	 * @param checkStoragePo
	 */
	public void insertCheckStorgeTemp(CheckStoragePo checkStoragePo);

	/**
	 * 插入临时盘点单从表
	 * 
	 * @param checkStoragePo
	 */
	public void insertCheckStorgeTempEntry(CheckStorageEntryPo checkStorageEntryPo);

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
	public void delCheckStorageTemp(String buildid);

	/**
	 * 删除盘点临时明细表
	 * 
	 * @param buildid
	 */
	public void delCheckStorageTempEntry(String buildid);

	/**
	 * 生成盘点单据
	 * 
	 * @param checkStoragePo
	 * @param buildids
	 */
	public void buildCheckStorage(CheckStoragePo checkStoragePo,
			String... buildids);

	/**
	 * 生成盘点明细表
	 * 
	 * @param checkStoragePo
	 * @param buildids
	 */
	public void buildCheckStorageEntry(CheckStoragePo checkStoragePo,
			String... buildids);

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
	public void auditCheckStorage(CheckStoragePo checkStoragePo,String buillid, String personid);

	/**
	 * 删除盘点单
	 * 
	 * @param buildid
	 */
	public void delCheckStorage(String buildid);

	/**
	 * 删除盘点明细
	 * 
	 * @param buildid
	 */
	public void delCheckStorageEntry(String buildid);

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

	public CheckStoragePo getCheckStoragePo(CheckStoragePo checkStoragePo);

	/**
	 * 生成盘盈盘亏单
	 * 
	 * @param inventoryPo
	 */
	public void buildSCISCO(InventoryPo inventoryPo);

	/**
	 * 生成盘盈盘亏明细表
	 * 
	 * @param inventoryPo
	 */
	public void buildSCISCOEntry(InventoryPo inventoryPo);

	/**
	 * 更新盘点盘盈盘亏生成状态
	 * 
	 * @param checkStoragePo
	 */
	public void updateCheckStorageSCISCO(CheckStoragePo checkStoragePo);

	/**
	 * 汇总删除临时盘点单
	 * 
	 * @param buildid
	 */
	public void delCheckStorageTempSum(String buildid);

	/**
	 * 汇总删除临时盘点明细单
	 * 
	 * @param buildid
	 */
	public void delCheckStorageTempEntrySum(String buildid);
	
	/**
	 * 获取当天仓位盘点主表数量
	 * 
	 * sxh 2011-5-30
	 */
	public int buildCheckStorageCount(CheckStoragePo checkStoragePo);
	
	/**
	 * 删除当天仓位重复盘点主表数据
	 * 
	 * sxh 2011-5-30
	 * */
	public void deleteDoubleCheckStorage(CheckStoragePo checkStoragePo);
	
	/**
	 * 删除当天仓位重复盘点详细表数据
	 * 
	 * sxh 2011-5-30
	 * */
	public void deleteDoubleCheckStorageEntry(CheckStoragePo checkStoragePo);
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
	 * 盈亏分析主表新增
	 * 
	 * @param checkStoragefxPo
	 * @return
	 */
	public void insertCheckStoragefx(CheckStoragefxPo checkStoragefxPo);
	
	/**
	 * 盈亏分析明细表新增
	 * 
	 * @param checkStoragefxPo
	 * @return
	 */
	public void insertCheckStoragefxEntry(CheckStoragefxEntryPo checkStoragefxEntryPo);
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
