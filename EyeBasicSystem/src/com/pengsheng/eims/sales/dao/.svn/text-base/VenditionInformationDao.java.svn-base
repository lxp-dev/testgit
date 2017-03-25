package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;

public interface VenditionInformationDao {
	/**
	 * 销售信息数量
	 * @param customerID
	 * @return
	 */
	public int getcustomerSalesBasicCount(String customerID);
	/**
	 * 储值卡消费记录
	 * @param customerID
	 * @return
	 */
	public List<SalesBasicPo> getChuZhiKaExpenseList(String customerID,int start, int size);
	
	public int getChuZhiKaExpenseCount(String customerID);
	/**
	 * 遍历销售信息
	 * @param customerID
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> getcustomerSalesBasicList(String customerID,int start, int size);
	
	/**
	 * 得到所有顾客销售结帐明细表,销售结帐基表对应的
	 * @param ssesdsalesid
	 * @return
	 */
	public List<SalesDetailPo> getcustomerSalesBasic(String ssesdsalesid);
	
	/**
	 * 得到销售结帐基表对象
	 * @param salesID
	 * @return
	 */
	public SalesBasicPo getSalesBasicPo(String salesID);
	/**
	 * 取销售结帐基表下有几个销售结帐明细表
	 * @param salesID
	 * @return
	 */
	public int getSalesDetailCount(String salesID);
	
	/**
	 * 积分消费记录
	 * @param customerID
	 * @return
	 */
	public int getIntegralExpenseCount(String customerID);
	
	/**
	 * 积分消费记录
	 * @param customerID
	 * @return
	 */
	public List<SalesBasicPo> getIntegralExpenseList(String customerID);
	
	/**
	 * 积分消费记录
	 * @param customerID
	 * @return
	 */
	public List<SalesBasicPo> getIntegralExpenseList(String customerID,int start, int size);
}
