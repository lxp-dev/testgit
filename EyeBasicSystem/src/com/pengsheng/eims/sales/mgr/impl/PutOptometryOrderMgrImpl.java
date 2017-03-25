package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.PutOptometryOrderDao;
import com.pengsheng.eims.sales.mgr.PutOptometryOrderMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;

public class PutOptometryOrderMgrImpl implements PutOptometryOrderMgr {

	private PutOptometryOrderDao putOptometryOrderDao;
	private InTransitDetailsDao inTransitDetailsDao;
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public PutOptometryOrderDao getPutOptometryOrderDao() {
		return putOptometryOrderDao;
	}

	public void setPutOptometryOrderDao(PutOptometryOrderDao putOptometryOrderDao) {
		this.putOptometryOrderDao = putOptometryOrderDao;
	}

	/**
	 * 根据配镜单号查询顾客信息
	 */
	public CustomerInfoPo getCustmorInfo(CustomerInfoPo customerInfoPo) {
		SalesBasicPo salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbsalesid(customerInfoPo.getFmmsalesid());
		
		if (inTransitDetailsDao.getSalesBasicInfoByID(salesBasicPo) == 0){			
			return putOptometryOrderDao.getCustmorInfoFinished(customerInfoPo);
		}	
		return putOptometryOrderDao.getCustmorInfo(customerInfoPo);
	}

	/**
	 * 得到打印配镜单数量
	 */
	public int getPutOptometryOrderCount(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		return putOptometryOrderDao.getPutOptometryOrderCount(salesBasicPo);
	}

	/**
	 * 得到打印镜单信息
	 */
	public List<SalesBasicPo> selectPutOptometryOrder(
			SalesBasicPo salesBasicPo, int start, int size) {
		// TODO Auto-generated method stub
		return putOptometryOrderDao.selectPutOptometryOrder(salesBasicPo, start, size);
	}

}
