package com.pengsheng.eims.quartz.mgr.impl;

import com.pengsheng.eims.basic.dao.DownloadRegionDao;
import com.pengsheng.eims.quartz.dao.DownloadJobDao;
import com.pengsheng.eims.quartz.mgr.DownloadJobMgr;

public class DownloadJobMgrImpl implements DownloadJobMgr{
	private DownloadJobDao downloadJobDao;
	private DownloadRegionDao downloadRegionDao; 
	
	public DownloadRegionDao getDownloadRegionDao() {
		return downloadRegionDao;
	}

	public void setDownloadRegionDao(DownloadRegionDao downloadRegionDao) {
		this.downloadRegionDao = downloadRegionDao;
	}
	
	/**
	 * 获取集团端商品成本，并更新医院端成本
	 */
	public void noUpdateCostprice(){
		downloadRegionDao.openWork();
		
		downloadJobDao.updateCostprice();
		
		downloadRegionDao.closeWork();
	}
	
	/**
	 * 获取集团端商品成本，并更新医院端成本
	 */
	public void noUploadCustomerInfo(){
		downloadRegionDao.openWork();
		
		downloadJobDao.uploadCustomerInfo();
		
		downloadRegionDao.closeWork();
	}
	
	public DownloadJobDao getDownloadJobDao() {
		return downloadJobDao;
	}

	public void setDownloadJobDao(DownloadJobDao downloadJobDao) {
		this.downloadJobDao = downloadJobDao;
	}
	
}
