package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.GlassesAccessoriesDao;
import com.pengsheng.eims.basic.dao.UpdateGoodsAttributeDao;
import com.pengsheng.eims.basic.mgr.GlassesAccessoriesMgr;
import com.pengsheng.eims.basic.mgr.UpdateGoodsAttributeMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.util.tools.Utility;

/**
 * mgr 实现类
 */
public class UpdateGoodsAttributeMgrImpl implements UpdateGoodsAttributeMgr {
	private UpdateGoodsAttributeDao updateGoodsAttributeDao;
	
	private LogisticsLogDao logisticsLogDao;
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public UpdateGoodsAttributeDao getUpdateGoodsAttributeDao() {
		return updateGoodsAttributeDao;
	}

	public void setUpdateGoodsAttributeDao(
			UpdateGoodsAttributeDao updateGoodsAttributeDao) {
		this.updateGoodsAttributeDao = updateGoodsAttributeDao;
	}

	public void updateGoodsAttribute(GoodsInfoPo po,String[] goodsid,LogisticsLogPo logPo) {
		if(goodsid.length>1){
			for(String gdID:goodsid){
				if(!"".equals(Utility.getName(gdID))){
					po.setBgigoodsid(gdID);
					updateGoodsAttributeDao.updateGoodsAttribute(po);
					updateGoodsAttributeDao.updateGoodsAttributeNot(po);
				}
			}
		}else{
			updateGoodsAttributeDao.updateGoodsAttribute(po);
			updateGoodsAttributeDao.updateGoodsAttributeNot(po);
		}
		logisticsLogDao.insertLog(logPo);
	}
}
