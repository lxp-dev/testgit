package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.sales.dao.AdditionalCDetailDao;
import com.pengsheng.eims.sales.mgr.AdditionalCDetailMgr;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;

public class AdditionalCDetailMgrImpl implements AdditionalCDetailMgr {

	/**插入附加费用
	 * @param inTransitPo
	 */
	private AdditionalCDetailDao additionalCDetailDao;
	public AdditionalCDetailDao getAdditionalCDetailDao() {
		return additionalCDetailDao;
	}
	public void setAdditionalCDetailDao(AdditionalCDetailDao additionalCDetailDao) {
		this.additionalCDetailDao = additionalCDetailDao;
	}
	public void insertAdditionalCDetail(AdditionalCDetailPo additionalCDetailPo) {
		// TODO Auto-generated method stub
		this.additionalCDetailDao.insertAdditionalCDetail(additionalCDetailPo);
	}

	public List<AdditionalCDetailPo> getAdditionalCDetailPos(String salesID) {
		// TODO Auto-generated method stub
		return this.additionalCDetailDao.getAdditionalCDetailPos(salesID);
	}

	

}
