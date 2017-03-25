package com.pengsheng.mall.mgr.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallShoppingFavoriteDao;
import com.pengsheng.mall.mgr.MallShoppingFavoriteMgr;
import com.pengsheng.mall.po.MallShoppingFavoritePo;

public class MallShoppingFavoriteMgrImpl implements MallShoppingFavoriteMgr {
	
	private MallShoppingFavoriteDao mallShoppingFavoriteDao;

	public void deleteMallShoppingFavoritePo(MallShoppingFavoritePo po) {
		mallShoppingFavoriteDao.deleteMallShoppingFavoritePo(po);
	}

	public void insertMallShoppingFavoritePo(MallShoppingFavoritePo po) {
		if(mallShoppingFavoriteDao.getMallShoppingFavoritePoCount(po)==0){
			mallShoppingFavoriteDao.insertMallShoppingFavoritePo(po);
		}
	}
	
	public int getMallShoppingFavoritePoCount(MallShoppingFavoritePo po){
		return mallShoppingFavoriteDao.getMallShoppingFavoritePoCount(po);
	}

	public List<MallShoppingFavoritePo> getMallShoppingFavoritePoList(MallShoppingFavoritePo po,
			int start, int size) {

		List<MallShoppingFavoritePo> listTmp = mallShoppingFavoriteDao.getMallShoppingFavoritePoList(po,start,size);
		List<MallShoppingFavoritePo> newListTmp = new ArrayList();
		Iterator<MallShoppingFavoritePo> itTmp = listTmp.iterator();
		while(itTmp.hasNext()){
			MallShoppingFavoritePo tmpPo = (MallShoppingFavoritePo)itTmp.next();
			if(!Utility.getName(tmpPo.getMsfsmallpicurl()).equals("")){
				tmpPo.setMsfsmallpicurl2(tmpPo.getMsfsmallpicurl()+",");			
			}
			newListTmp.add(tmpPo);
		}
		return newListTmp;
	}

	public MallShoppingFavoriteDao getMallShoppingFavoriteDao() {
		return mallShoppingFavoriteDao;
	}

	public void setMallShoppingFavoriteDao(MallShoppingFavoriteDao mallShoppingFavoriteDao) {
		this.mallShoppingFavoriteDao = mallShoppingFavoriteDao;
	}
}
