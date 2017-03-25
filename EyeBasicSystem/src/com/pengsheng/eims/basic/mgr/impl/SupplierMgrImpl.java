package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

import com.pengsheng.eims.basic.dao.DownloadRegionDao;
import com.pengsheng.eims.basic.dao.SupplierDao;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;

public class SupplierMgrImpl implements SupplierMgr {

	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id
	
	private LogisticsLogDao logisticsLogDao;
	
	private DownloadRegionDao downloadRegionDao;
	
	public DownloadRegionDao getDownloadRegionDao() {
		return downloadRegionDao;
	}
	public void setDownloadRegionDao(DownloadRegionDao downloadRegionDao) {
		this.downloadRegionDao = downloadRegionDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private SupplierDao supplierDao;

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	/**
	 * 查询制造商的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getSupplierCount(SupplierPo po) {
		return supplierDao.getSupplierCount(po);
	}

	/**
	 * 
	 * 遍历制造商并实现分页
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SupplierPo> getSupplierList(SupplierPo po, int start, int size) {

		return supplierDao.getSupplierList(po, start, size);
	}

	/**
	 * 新增制造商信息
	 * 
	 * @param po
	 */
	public void insertSupplier(SupplierPo supplierPo,LogisticsLogPo logPo) {
		supplierDao.insertSupplier(supplierPo);
		logisticsLogDao.insertLog(logPo); //添加日志
		
		if (Utility.getName(supplierPo.getBspinsertxzdflag()).equals("2")){
			supplierDao.insertXinZhongDa(supplierPo);
		}
	}

	// 自己封装的一个把源文件对象复制成目标文件对象
	private void copy(File src, File dst) throws Exception {
		InputStream in = null;
		OutputStream out = null;
		
		in = new BufferedInputStream(new FileInputStream(src));
		out = new BufferedOutputStream(new FileOutputStream(dst));
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
		
		if (null != in) {
			in.close();
		}
		if (null != out) {
			out.close();
		}
	}

	/**
	 * 修改制造商信息
	 * 
	 * @param po
	 */
	public void updateSupplier(SupplierPo supplierPo,LogisticsLogPo logPo) {
		supplierDao.updateSupplier(supplierPo);
		logisticsLogDao.insertLog(logPo); //添加日志

	}

	/**
	 * 修改制造商信息
	 * 
	 * @param po
	 */
	public void updateSupplier(SupplierPo supplierPo, String updateBrand, LogisticsLogPo logPo) {
		supplierDao.updateSupplier(supplierPo);
		
		if(null != updateBrand && "updateBrand".equals(updateBrand)) {
			logPo.setsLogContent(logPo.getsLogContent() + ",并更新制造商下所有品种!");
			supplierDao.updateBrandSettlementOfSupplier(supplierPo);
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	/**
	 * 修改制造商信息
	 * 
	 * @param po
	 */
	public void updateSupplierAccount(SupplierPo po,LogisticsLogPo logPo){
		supplierDao.updateSupplierAccount(po);		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 删除制造商信息
	 * 
	 * @param po
	 */
	public void deleteSupplier(SupplierPo po,LogisticsLogPo logPo) {

		supplierDao.deleteSupplier(po);
		
		logisticsLogDao.insertLog(logPo); //添加日志

	}

	/**
	 * 查询制造商信息
	 * 
	 * @param po
	 * @return
	 */
	public SupplierPo getSupplier(SupplierPo po) {

		return supplierDao.getSupplier(po);
	}

	/**
	 * 遍历商品类别
	 * 
	 * @return
	 */
	public List<GoodsCategoryPo> getGoodsCategoryList() {

		return supplierDao.getGoodsCategoryList();
	}

	/**
	 * 修改停用信息
	 * 
	 * @param po
	 */
	public void updateSupplierDisable(SupplierPo po,LogisticsLogPo logPo) {

		supplierDao.updateSupplierDisable(po);
		supplierDao.updateBrandDisable(po);
		supplierDao.updateGoodsDisable(po);
		
		logisticsLogDao.insertLog(logPo); //添加日志

	}

	/**
	 * 根据制造商ID查找商品数量
	 * 
	 * @param supplierID
	 * @return
	 */
	public int getBrandCount(String supplierID) {

		return supplierDao.getBrandCount(supplierID);
	}

	/**
	 * 制造商批量导入
	 * 
	 */
	public void insertSupplier(List<SupplierPo> supplierPos) {

		for (SupplierPo supplierPo : supplierPos) {

			HSSFWorkbook workbook = new HSSFWorkbook();

			supplierDao.insertSupplier(supplierPo);
		}
	}

	public int getGoodsCount(SupplierPo supplierPo) {
		
		return this.supplierDao.getGoodsCount(supplierPo);
	}
	
	/**
	 * 获取集团端区域下指定供应商下的品牌及商品插入医院端
	 * @param po
	 * @return
	 */
	public void noInsertCompanyBrandPos(BrandPo po,LogisticsLogPo logPo){
		downloadRegionDao.openWork();
		
		downloadRegionDao.insertCompanyBrandPos(po);
		downloadRegionDao.insertCompanyGoodsPos(po);
		
		downloadRegionDao.closeWork();
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
}
