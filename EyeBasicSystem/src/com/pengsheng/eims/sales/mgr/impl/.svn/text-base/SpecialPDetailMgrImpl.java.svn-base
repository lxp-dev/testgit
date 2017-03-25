package com.pengsheng.eims.sales.mgr.impl;

import com.pengsheng.eims.sales.dao.SpecialPDetailDao;
import com.pengsheng.eims.sales.mgr.SpecialPDetailMgr;
import com.pengsheng.eims.sales.persistence.SalesSpecialPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;

public class SpecialPDetailMgrImpl implements SpecialPDetailMgr {
	
	private SpecialPDetailDao specialPDetailDao;
	
	public SpecialPDetailDao getSpecialPDetailDao() {
		return specialPDetailDao;
	}
	public void setSpecialPDetailDao(SpecialPDetailDao specialPDetailDao) {
		this.specialPDetailDao = specialPDetailDao;
	}
	
	/**插入加工要求明细
	 * @param inTransitPo
	 */
	public void insertSpecialPDetail(SpecialPDetailPo specialPDetailPo){
		specialPDetailDao.insertSpecialPDetail(specialPDetailPo);		
	}
	
	
	/**插入特殊加工要求明细
	 * @param inTransitPo
	 */
	public void insertSalesSpecial(SalesSpecialPo salesSpecialPo){
		specialPDetailDao.insertSalesSpecial(salesSpecialPo);
	}

	

}
