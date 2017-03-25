package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.DownloadRegionDao;
import com.pengsheng.eims.basic.mgr.DownloadRegionMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;

public class DownloadRegionMgrImpl implements DownloadRegionMgr {
	private DownloadRegionDao downloadRegionDao; 
	private LogisticsLogDao logisticsLogDao;
	
	/**
	 * 获取品种下载集团端品牌信息
	 * @param po
	 * @return
	 */
	public List<BrandPo> noGetDownloadBrandList(BrandPo po){
		
		downloadRegionDao.openWork();
		
		List<BrandPo> brandPos = downloadRegionDao.getDownloadBrandList(po);
		
		downloadRegionDao.closeWork();
		
		return brandPos;
	}

	public DownloadRegionDao getDownloadRegionDao() {
		return downloadRegionDao;
	}

	public void setDownloadRegionDao(DownloadRegionDao downloadRegionDao) {
		this.downloadRegionDao = downloadRegionDao;
	}
	
	/**
	 * 获取所有集团端所有区域
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> noGetRegionList(CompanyNamePo po){
		
		downloadRegionDao.openWork();
		
		List<CompanyNamePo> companyNamePos = downloadRegionDao.getRegionList(po);
		
		downloadRegionDao.closeWork();
		
		return companyNamePos;
	}
	
	/**
	 * 获取所有集团端所有公司
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> noGetCompanyList(CompanyNamePo po){
		downloadRegionDao.openWork();
		
		List<CompanyNamePo> companyNamePos = downloadRegionDao.getCompanyList(po);
		
		downloadRegionDao.closeWork();
		
		return companyNamePos;
	}
	
	/**
	 * 获取下载集团端商品信息数量
	 * @param po
	 * @return
	 */
	public int noGetDownloadGoodsInfoCount(GoodsInfoPo po){
		downloadRegionDao.openWork();
		
		int i = downloadRegionDao.getDownloadGoodsInfoCount(po);
		
		downloadRegionDao.closeWork();
		
		return i;
	}
	
	/**
	 * 获取下载集团端商品信息
	 * @param po
	 * @return
	 */
	public List<GoodsInfoPo> noGetDownloadGoodsInfoList(GoodsInfoPo po, int start,int size) {
		downloadRegionDao.openWork();
		
		List<GoodsInfoPo> goodsInfoPos = downloadRegionDao.getDownloadGoodsInfoList(po, start,size);
		
		downloadRegionDao.closeWork();
		
		return goodsInfoPos;
	}
	
	/**
	 * 获取集团端商品信息插入医院端商品表
	 * @param po
	 * @return
	 */
	public void noInsertCompanyGoodsPo(GoodsInfoPo po,LogisticsLogPo logPo){
		
		downloadRegionDao.openWork();
		
		downloadRegionDao.insertCompanyBrandPo(po);
		downloadRegionDao.insertCompanyGoodsPo(po);
		
		downloadRegionDao.closeWork();
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
}
