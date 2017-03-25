package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.ContactAccessoriesDao;
import com.pengsheng.eims.components.mgr.ContactAccessoriesMgr;

public class ContactAccessoriesMgrImpl implements ContactAccessoriesMgr {

	private ContactAccessoriesDao contactAccessoriesDao;
	
	
	public ContactAccessoriesDao getContactAccessoriesDao() {
		return contactAccessoriesDao;
	}

	public void setContactAccessoriesDao(ContactAccessoriesDao contactAccessoriesDao) {
		this.contactAccessoriesDao = contactAccessoriesDao;
	}
	
	

	/**
	 * 得到隐形辅料商品信息
	 */
	public List<GoodsInfoPo> contactAccessoriesList(GoodsInfoPo goodsInfoPo  , int start , int size) {
		// TODO Auto-generated method stub
		return contactAccessoriesDao.contactAccessoriesList(goodsInfoPo, start, size);
	}

	/**
	 * 得到隐形辅料商品个数
	 */
	public int getContactAccessoriesCount(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		return contactAccessoriesDao.getContactAccessoriesCount(goodsInfoPo);
	}

	/**
	 * 根据商品条码得到商品信息数量
	 */
	public int getCountByGoodsbarcode(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		return contactAccessoriesDao.getCountByGoodsbarcode(goodsInfoPo);
	}

	/**
	 * 根据商品条码得到商品信息
	 */
	public List<GoodsInfoPo> getListByGoodsbarcode(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return contactAccessoriesDao.getListByGoodsbarcode(goodsInfoPo, start, size);
	}

}
