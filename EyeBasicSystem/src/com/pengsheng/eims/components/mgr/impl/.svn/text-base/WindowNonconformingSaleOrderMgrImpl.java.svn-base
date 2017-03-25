package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.components.dao.WindowNonconformingSaleOrderDao;
import com.pengsheng.eims.components.mgr.WindowNonconformingSaleOrderMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;

public class WindowNonconformingSaleOrderMgrImpl implements
		WindowNonconformingSaleOrderMgr {

	private WindowNonconformingSaleOrderDao windowNonconformingSaleOrderDao;
	private InTransitDetailsDao inTransitDetailsDao;
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public WindowNonconformingSaleOrderDao getWindowNonconformingSaleOrderDao() {
		return windowNonconformingSaleOrderDao;
	}

	public void setWindowNonconformingSaleOrderDao(
			WindowNonconformingSaleOrderDao windowNonconformingSaleOrderDao) {
		this.windowNonconformingSaleOrderDao = windowNonconformingSaleOrderDao;
	}

	/**
	 * 得到顾客详细信息
	 */
	public SalesBasicPo getCustmorInfo(SalesBasicPo salesBasicPo) {
		if (inTransitDetailsDao.getSalesBasicInfoByID(salesBasicPo) == 0){			
        	return windowNonconformingSaleOrderDao.getCustmorInfoFinished(salesBasicPo);
        }
		return windowNonconformingSaleOrderDao.getCustmorInfo(salesBasicPo);
	}

	/**
	 * 得到销售单中商品信息的数量
	 */
	public int getNonconformingSaleCount(SalesDetailPo salesDetailPo) {
		if (inTransitDetailsDao.getDetailCount(salesDetailPo) == 0){
        	return windowNonconformingSaleOrderDao.getNonconformingSaleCountFinished(salesDetailPo);
        }
		return windowNonconformingSaleOrderDao.getNonconformingSaleCount(salesDetailPo);
	}

	/**
	 * 得到销售单中商品详细信息
	 */
	public List<SalesDetailPo> getNonconformingSaleList(SalesDetailPo salesDetailPo, int start, int size) {
		if (inTransitDetailsDao.getDetailCount(salesDetailPo) == 0){
        	return windowNonconformingSaleOrderDao.getNonconformingSaleListFinished(salesDetailPo, start, size);
        }
		return windowNonconformingSaleOrderDao.getNonconformingSaleList(salesDetailPo, start, size);
	}

	/**
	 * 得到销售单数量
	 */
	public int getSaleOrderCount(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		return windowNonconformingSaleOrderDao.getSaleOrderCount(salesBasicPo);
	}

	/**
	 * 得到销售单号
	 */
	public List<SalesBasicPo> getSaleOrderList(SalesBasicPo salesBasicPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return windowNonconformingSaleOrderDao.getSaleOrderList(salesBasicPo, start, size);
	}

}
