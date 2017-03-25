package com.pengsheng.mall.mgr.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.mall.dao.MallShoppingCartDao;
import com.pengsheng.mall.dao.MallShoppingOrderDao;
import com.pengsheng.mall.mgr.MallShoppingOrderMgr;
import com.pengsheng.mall.po.MallShoppingCartPo;
import com.pengsheng.mall.po.MallShoppingOrderPo;

public class MallShoppingOrderMgrImpl implements MallShoppingOrderMgr {
	
	private MallShoppingOrderDao mallShoppingOrderDao;
	private MallShoppingCartDao mallShoppingCartDao;

	public void deleteMallShoppingOrderPo(MallShoppingOrderPo po) {
		mallShoppingOrderDao.deleteMallShoppingOrderPo(po);
	}

	public void insertMallShoppingOrderPo(List<MallShoppingCartPo> list) {
		if(list!=null && list.size()>0){
			MallShoppingOrderPo mallShoppingOrderPo = new MallShoppingOrderPo();
			MallShoppingCartPo mallShoppingCartPo = new MallShoppingCartPo();
			Iterator<MallShoppingCartPo> it = list.iterator();
			while(it.hasNext()){
				mallShoppingCartPo = (MallShoppingCartPo)it.next();
				mallShoppingOrderPo.setMsoopenid(mallShoppingCartPo.getMscopenid());
				mallShoppingOrderPo.setMsosmallid(mallShoppingCartPo.getMscsmallid());
				mallShoppingOrderPo.setMsocolor(mallShoppingCartPo.getMsccolor());
				mallShoppingOrderPo.setMsospec(mallShoppingCartPo.getMscspec());
				mallShoppingOrderPo.setMsocount(mallShoppingCartPo.getMsccount());
				mallShoppingOrderPo.setMsopricesum(mallShoppingCartPo.getMscpricesum());
				mallShoppingOrderPo.setMsostate("0");
				mallShoppingOrderDao.insertMallShoppingOrderPo(mallShoppingOrderPo);
				mallShoppingCartDao.deleteMallShoppingCartPo(mallShoppingCartPo);
			}
		}		
	}

	public int getMallShoppingOrderPoCount(MallShoppingOrderPo po){
		return mallShoppingOrderDao.getMallShoppingOrderPoCount(po);
	}

	public List<MallShoppingOrderPo> getMallShoppingOrderPoList(MallShoppingOrderPo po,
			int start, int size) {

		List<MallShoppingOrderPo> listTmp = mallShoppingOrderDao.getMallShoppingOrderPoList(po,start,size);
		List<MallShoppingOrderPo> newListTmp = new ArrayList();
		Iterator<MallShoppingOrderPo> itTmp = listTmp.iterator();
		while(itTmp.hasNext()){
			MallShoppingOrderPo tmpPo = (MallShoppingOrderPo)itTmp.next();
			if(!Utility.getName(tmpPo.getMsosmallpicurl()).equals("")){
				tmpPo.setMsosmallpicurl2(tmpPo.getMsosmallpicurl()+",");			
			}
			newListTmp.add(tmpPo);
		}
		return newListTmp;
	}

	public void updateMallShoppingOrderPo(MallShoppingOrderPo po) {
		mallShoppingOrderDao.updateMallShoppingOrderPo(po);
	}


	public MallShoppingOrderPo getMallShoppingOrderPo(MallShoppingOrderPo po) {
		// TODO Auto-generated method stub
		return mallShoppingOrderDao.getMallShoppingOrderPo(po);
	}

	public MallShoppingOrderDao getMallShoppingOrderDao() {
		return mallShoppingOrderDao;
	}

	public void setMallShoppingOrderDao(MallShoppingOrderDao mallShoppingOrderDao) {
		this.mallShoppingOrderDao = mallShoppingOrderDao;
	}

	public MallShoppingCartDao getMallShoppingCartDao() {
		return mallShoppingCartDao;
	}

	public void setMallShoppingCartDao(MallShoppingCartDao mallShoppingCartDao) {
		this.mallShoppingCartDao = mallShoppingCartDao;
	}
}
