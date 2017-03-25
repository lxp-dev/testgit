package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.SalesAreaDao;
import com.pengsheng.eims.basic.mgr.SalesAreaMgr;
import com.pengsheng.eims.basic.persistence.SalesAreaPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.tools.Utility;

public class SalesAreaMgrImpl implements SalesAreaMgr{
	
	private SalesAreaDao salesAreaDao;
    private LogisticsLogDao logisticsLogDao = null;
	
	public void deleteSalesAreaPo(String id,LogisticsLogPo logPo) {
		
		String[] ids = id.split(",");
		for (int i = 0; i < ids.length; i++){
			salesAreaDao.deleteSalesAreaPo(ids[i]);
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	public void insertSalesAreaPo(List<SalesAreaPo> salesAreaList,LogisticsLogPo logPo) {		
		
		for (SalesAreaPo po : salesAreaList){
			salesAreaDao.insertSalesAreaPo(po);
		}
		
		logisticsLogDao.insertLog(logPo);
	}

	public List<SalesAreaPo> selectSalesAreaListAll(String moduleid) {
		return salesAreaDao.selectSalesAreaListAll(moduleid);
	}

	public SalesAreaPo selectSalesAreaPo(String id) {
		return salesAreaDao.selectSalesAreaPo(id);
	}
	
	public SalesAreaDao getSalesAreaDao() {
		return salesAreaDao;
	}

	public void setSalesAreaDao(SalesAreaDao salesAreaDao) {
		this.salesAreaDao = salesAreaDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public List<SalesAreaPo> selectSalesAreaListAllByGoodsCategoryID(
			String goodsCategoryID) {
		return salesAreaDao.selectSalesAreaListAllByGoodsCategoryID(goodsCategoryID);
	}

	public List<SalesAreaPo> selectSalesAreaListAllByCategoryIDOrSalesType(
			String[] goodsCategoryID, String[] salesType) {
		return salesAreaDao.selectSalesAreaListAllByCategoryIDOrSalesType(goodsCategoryID, salesType);
	}
	
	/**
	 * 确认新增的价格段区间与之前新建的没有重复
	 */
	public int getSalesAreaBeforeCount(SalesAreaPo po){
		if (Utility.getName(po.getRrcsagoodscategoryid()).equals("")){
			return salesAreaDao.getSalesTypeAreaBeforeCount(po);
		}
		return salesAreaDao.getSalesAreaBeforeCount(po);
	}

	public int selectSalesAreaListAllByCategoryIDOrSalesTypeCount(
			String[] goodsCategoryID, String[] salesType) {
		return salesAreaDao.selectSalesAreaListAllByCategoryIDOrSalesTypeCount(goodsCategoryID, salesType);
	}

	public List<SalesAreaPo> selectSalesAreaListAllByCategoryIDOrSalesType(
			String[] goodsCategoryID, String[] salesType, int start, int size) {
		return salesAreaDao.selectSalesAreaListAllByCategoryIDOrSalesType(goodsCategoryID, salesType, start, size);
	}
	
}
