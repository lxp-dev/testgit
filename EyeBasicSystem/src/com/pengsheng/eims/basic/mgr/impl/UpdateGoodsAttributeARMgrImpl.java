package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.GlassesAccessoriesDao;
import com.pengsheng.eims.basic.dao.UpdateGoodsAttributeARDao;
import com.pengsheng.eims.basic.dao.UpdateGoodsAttributeDao;
import com.pengsheng.eims.basic.mgr.GlassesAccessoriesMgr;
import com.pengsheng.eims.basic.mgr.UpdateGoodsAttributeARMgr;
import com.pengsheng.eims.basic.mgr.UpdateGoodsAttributeMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.util.tools.Utility;

/**
 * mgr 实现类
 */
public class UpdateGoodsAttributeARMgrImpl implements UpdateGoodsAttributeARMgr {
	private UpdateGoodsAttributeARDao updateGoodsAttributeARDao;
	private LogisticsLogDao logisticsLogDao;
	
	public UpdateGoodsAttributeARDao getUpdateGoodsAttributeARDao() {
		return updateGoodsAttributeARDao;
	}

	public void setUpdateGoodsAttributeARDao(
			UpdateGoodsAttributeARDao updateGoodsAttributeARDao) {
		this.updateGoodsAttributeARDao = updateGoodsAttributeARDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public void updateGoodsAttribute(GoodsInfoPo po,String[] goodsid,LogisticsLogPo logPo) {
		if(goodsid.length>1){
			for(String gdID:goodsid){
				if(!"".equals(Utility.getName(gdID))){
					po.setBgigoodsid(gdID);
					updateGoodsAttributeARDao.updateGoodsAttribute(po);
					updateGoodsAttributeARDao.updateGoodsAttributeNot(po);
				}
			}
		}else{
			updateGoodsAttributeARDao.updateGoodsAttribute(po);
			updateGoodsAttributeARDao.updateGoodsAttributeNot(po);
		}
		logisticsLogDao.insertLog(logPo);
	}
}
