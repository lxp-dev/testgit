package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.sales.dao.VenditionInformationDao;
import com.pengsheng.eims.sales.mgr.VenditionInformationMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;

public class VenditionInformationMgrImpl implements VenditionInformationMgr {
	
	private VenditionInformationDao venditionInformationDao;
	
		public VenditionInformationDao getVenditionInformationDao() {
			return venditionInformationDao;
		}
	
		public void setVenditionInformationDao(
				VenditionInformationDao venditionInformationDao) {
			this.venditionInformationDao = venditionInformationDao;
		}


	/**
	 * 得到所有顾客销售结帐明细表,销售结帐基表对应的
	 */
	public List<SalesDetailPo> getcustomerSalesBasic(String ssesdsalesid) {
		
		return venditionInformationDao.getcustomerSalesBasic(ssesdsalesid);
	}

	/**
	 * 取销售结帐基表下有几个销售结帐明细表
	 */
	public int getcustomerSalesBasicCount(String customerID) {
		
		return venditionInformationDao.getcustomerSalesBasicCount(customerID);
	}

	/**
	 * 遍历销售信息
	 */
	public List<SalesBasicPo> getcustomerSalesBasicList(String customerID,
			int start, int size) {
		
		return venditionInformationDao.getcustomerSalesBasicList(customerID, start, size);
	}
	
	/**
	 * 积分消费记录
	 * @param customerID
	 * @return
	 */
	public int getIntegralExpenseCount(String customerID){
		return venditionInformationDao.getIntegralExpenseCount(customerID);
	}
	/**
	 * 储值卡消费记录
	 * @param customerID
	 * @return
	 */
	public int getChuZhiKaExpenseCount(String customerID){
		return venditionInformationDao.getChuZhiKaExpenseCount(customerID);
	}
	
	/**
	 * 积分消费记录
	 * @param customerID
	 * @return
	 */
	public List<SalesBasicPo> getIntegralExpenseList(String customerID){
		return venditionInformationDao.getIntegralExpenseList(customerID);
	}
	/**
	 * 积分消费记录
	 * @param customerID
	 * @return
	 */
	public List<SalesBasicPo> getIntegralExpenseList(String customerID,int start, int size){
		return venditionInformationDao.getIntegralExpenseList(customerID, start, size);
	}
	/**
	 * 储值卡消费记录
	 * @param customerID
	 * @return
	 */
	public List<SalesBasicPo> getChuZhiKaExpenseList(String customerID,int start, int size){
		return venditionInformationDao.getChuZhiKaExpenseList(customerID, start, size);
	}
}
