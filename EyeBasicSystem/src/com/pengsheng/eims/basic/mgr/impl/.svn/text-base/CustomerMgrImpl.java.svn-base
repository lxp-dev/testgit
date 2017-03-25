package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.CustomerDao;
import com.pengsheng.eims.basic.mgr.CustomerMgr;
import com.pengsheng.eims.basic.persistence.CustomerPo;
import com.pengsheng.eims.storage.dao.SalesOutDao;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class CustomerMgrImpl implements CustomerMgr {
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private CustomerDao customerDao;

	public void deleteCustomer(CustomerPo customerPo,LogisticsLogPo logPo) {
		
		this.customerDao.deleteCustomer(customerPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	private SalesOutDao salseOutDao;

	public SalesOutDao getSalseOutDao() {
		return salseOutDao;
	}

	public void setSalseOutDao(SalesOutDao salseOutDao) {
		this.salseOutDao = salseOutDao;
	}

	public CustomerPo getCustomer(CustomerPo customerPo) {
		return this.customerDao.getCustomer(customerPo);
	}

	public List<CustomerPo> getCustomerList(CustomerPo customerPo){
		return this.customerDao.getCustomerList(customerPo);
	}
	
	public int getCustomerCount(CustomerPo customerPo)
	{
		return this.customerDao.getCustomerCount(customerPo);
	}

	public List getCustomerPoList(CustomerPo po, int start, int size) 
	{
		return this.customerDao.getCustomerPoList(po, start, size);
	}
	public void insertCustomer(CustomerPo customerPo,LogisticsLogPo logPo) {
		this.customerDao.insertCustomer(customerPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void updateCustomer(CustomerPo customerPo,LogisticsLogPo logPo) {
		this.customerDao.updateCustomer(customerPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	public int getCustomerCountForDel(CustomerPo customerPo){
		return this.customerDao.getCustomerCountForDel(customerPo);
	}
	/**
	 * 判断客户名称是否重复
	 * 
	 * @param customerPo
	 *          
	 */
	public int getCustomerPoName(CustomerPo po) 
	{
		return customerDao.getCustomerPoName(po);
	}
	public int getCustomerPoNameUpdate(CustomerPo po) 
	{
		return customerDao.getCustomerPoNameUpdate(po);
	}

}
