package com.pengsheng.eims.his.mgr.impl;

import java.util.List;

import com.pengsheng.eims.his.dao.HisParamDao;
import com.pengsheng.eims.his.mgr.HisParamMgr;
import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class HisParamMgrImpl extends BaseAction implements HisParamMgr {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HisParamDao hisParamDao;
	
	

	public HisParamDao getHisParamDao() {
		return hisParamDao;
	}

	public void setHisParamDao(HisParamDao hisParamDao) {
		this.hisParamDao = hisParamDao;
	} 


	public int getHisParamPoCount(HisParamPo po) {
		return hisParamDao.getHisParamPoCount(po);
	}


	public List<HisParamPo> getHisParamPoList(HisParamPo po) {
		return hisParamDao.getHisParamPoList(po);
	}




	public List<HisParamPo> getHisParamPoList(HisParamPo po, int start, int size) {
		 
		return hisParamDao.getHisParamPoList(po, start, size);
	}




	public HisParamPo getHisParamPo(HisParamPo hisParamPo) {
		
		return hisParamDao.getHisParamPo(hisParamPo);
	}

	
	public int getNotSubCount(SalesBasicPo po) {
		return hisParamDao.getNotSubCount(po);
	}

	public List<SalesBasicPo> getNotSubList(SalesBasicPo po, int start, int pageSize) {
		 
		return hisParamDao.getNotSubList(po,start,pageSize);
	}

	public void deleteHisParam(HisParamPo po) {
		 hisParamDao.deleteHisParam(po);
	} 
}
