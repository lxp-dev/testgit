package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.PackingListDao;
import com.pengsheng.eims.sales.dao.PutOptometryOrderDao;
import com.pengsheng.eims.sales.mgr.PackingListMgr;
import com.pengsheng.eims.sales.mgr.PutOptometryOrderMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;

public class PackingListMgrImpl implements PackingListMgr {

	private PackingListDao packingListDao;
	
	

	public PackingListDao getPackingListDao() {
		return packingListDao;
	}

	public void setPackingListDao(PackingListDao packingListDao) {
		this.packingListDao = packingListDao;
	}

	/**
	 * 根据配镜单号查询顾客信息
	 */
	public CustomerInfoPo getCustmorInfo(CustomerInfoPo customerInfoPo) {
		// TODO Auto-generated method stub
		return packingListDao.getCustmorInfo(customerInfoPo);
	}

	/**
	 * 得到打印配镜单数量
	 */
	public int getPackingListCount(SalesBasicPo po) {
		// TODO Auto-generated method stub
		return packingListDao.getPackingListCount(po);
	}

	/**
	 * 得到打印镜单信息
	 */
	public List<SalesBasicPo> selectPackingList(
			SalesBasicPo po, int start, int size) {
		return packingListDao.selectPackingList(po, start, size);
	}

	

}
