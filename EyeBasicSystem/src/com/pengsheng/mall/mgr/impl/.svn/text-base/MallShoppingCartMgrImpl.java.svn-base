package com.pengsheng.mall.mgr.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallShoppingCartDao;
import com.pengsheng.mall.mgr.MallShoppingCartMgr;
import com.pengsheng.mall.po.MallShoppingCartPo;

public class MallShoppingCartMgrImpl implements MallShoppingCartMgr {
	
	private MallShoppingCartDao mallShoppingCartDao;

	public void deleteMallShoppingCartPo(MallShoppingCartPo po) {
		mallShoppingCartDao.deleteMallShoppingCartPo(po);
	}

	public void insertMallShoppingCartPo(MallShoppingCartPo po) {
		mallShoppingCartDao.insertMallShoppingCartPo(po);
	}

	public Map<String, Object> getMallShoppingCartPoCountByOpenID(String openID){
		return mallShoppingCartDao.getMallShoppingCartPoCountByOpenID(openID);
	}

	public List<MallShoppingCartPo> getMallShoppingCartPoListByOpenID(String openID){

		List<MallShoppingCartPo> listTmp = mallShoppingCartDao.getMallShoppingCartPoListByOpenID(openID);
		List<MallShoppingCartPo> newListTmp = new ArrayList();
		Iterator<MallShoppingCartPo> itTmp = listTmp.iterator();
		while(itTmp.hasNext()){
			MallShoppingCartPo tmpPo = (MallShoppingCartPo)itTmp.next();
			if(!Utility.getName(tmpPo.getMscsmallpicurl()).equals("")){
				tmpPo.setMscsmallpicurl2(tmpPo.getMscsmallpicurl()+",");			
			}
			newListTmp.add(tmpPo);
		}
		return newListTmp;
	}

	public void updateMallShoppingCartPo(MallShoppingCartPo po) {
		mallShoppingCartDao.updateMallShoppingCartPo(po);
	}


	public MallShoppingCartPo getMallShoppingCartPo(MallShoppingCartPo po) {
		// TODO Auto-generated method stub
		return mallShoppingCartDao.getMallShoppingCartPo(po);
	}

	public MallShoppingCartDao getMallShoppingCartDao() {
		return mallShoppingCartDao;
	}

	public void setMallShoppingCartDao(MallShoppingCartDao mallShoppingCartDao) {
		this.mallShoppingCartDao = mallShoppingCartDao;
	}
}
