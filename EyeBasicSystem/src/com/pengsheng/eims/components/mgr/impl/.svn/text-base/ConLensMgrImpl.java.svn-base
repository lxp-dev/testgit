/**
 * 
 */
package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.components.dao.ConLensDao;
import com.pengsheng.eims.components.mgr.ConLensMgr;

/**
 * @author Liuqian
 * 
 */
public class ConLensMgrImpl implements ConLensMgr {

	private ConLensDao conLensDao;

	public ConLensDao getConLensDao() {
		return conLensDao;
	}

	public void setConLensDao(ConLensDao conLensDao) {
		this.conLensDao = conLensDao;
	}

	
	public int getConLensCount(GoodsInfoTempPo goodsInfoTempPo,WarehouseConfigurationPo warehouseConfigurationPo) {
		// TODO Auto-generated method stub
		if("D".equals(goodsInfoTempPo.getIscustomize())){
			return conLensDao.getOConLensCount(goodsInfoTempPo);
		}else
		{
			return conLensDao.getConLensCount(goodsInfoTempPo,warehouseConfigurationPo);
		}
		
	}


	public List<GoodsInfoPo> getConLensList(GoodsInfoTempPo goodsInfoTempPo,WarehouseConfigurationPo warehouseConfigurationPo,
			int start, int size) {
		// TODO Auto-generated method stub
		if("D".equals(goodsInfoTempPo.getIscustomize())){
			return conLensDao.getOConLensList(goodsInfoTempPo, start, size);
		}else
			return conLensDao.getConLensList(goodsInfoTempPo,warehouseConfigurationPo, start, size);
		}
	}


