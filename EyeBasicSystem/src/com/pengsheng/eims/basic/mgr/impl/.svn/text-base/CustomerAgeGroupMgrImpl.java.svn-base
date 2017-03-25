package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.CustomerAgeGroupDao;
import com.pengsheng.eims.basic.mgr.CustomerAgeGroupMgr;
import com.pengsheng.eims.basic.persistence.CustomerAgeGroupPo;
import com.pengsheng.eims.basic.persistence.MemberOriginPo;

public class CustomerAgeGroupMgrImpl implements CustomerAgeGroupMgr{
	private CustomerAgeGroupDao customerAgeGroupDao;
	
	public CustomerAgeGroupDao getCustomerAgeGroupDao() {
		return customerAgeGroupDao;
	}

	public void setCustomerAgeGroupDao(CustomerAgeGroupDao customerAgeGroupDao) {
		this.customerAgeGroupDao = customerAgeGroupDao;
	}

	/**
	 * 新增区间
	 * @param po
	 */
	public void insertCustomerAgeGroupPo(CustomerAgeGroupPo po){
		for(int i=0; i<po.getBcgagesmaxs().length; i++){
			CustomerAgeGroupPo insertpo = new CustomerAgeGroupPo();
			insertpo.setBcggoodscategory(po.getBcggoodscategory());
			insertpo.setBcgagesmin(po.getBcgagesmins()[i]);
			insertpo.setBcgagesmax(po.getBcgagesmaxs()[i]);
			insertpo.setBcgremark("");
			customerAgeGroupDao.insertCustomerAgeGroupPo(insertpo);
		}
	}
	
	/**
	 * 更新区间
	 * @param po
	 */
	public void updateCustomerAgeGroupPo(CustomerAgeGroupPo po){
		customerAgeGroupDao.updateCustomerAgeGroupPo(po);
	}
	
	/**
	 * 删除区间
	 * @param po
	 */
	public void deleteCustomerAgeGroupPo(CustomerAgeGroupPo po){
		customerAgeGroupDao.deleteCustomerAgeGroupPo(po);
	}
	
	/**
	 * 区间Po
	 * @param po
	 * @return
	 */
	public List<CustomerAgeGroupPo> selectCustomerAgeGroupPos(CustomerAgeGroupPo po){
		return customerAgeGroupDao.selectCustomerAgeGroupPos(po);
	}
	
	/**
	 * 区间数量
	 * @param po
	 * @return
	 */
	public int selectCustomerAgeGroupCount(){
		return customerAgeGroupDao.selectCustomerAgeGroupCount();
	}
	/**
	 * 区间List
	 * @param po
	 * @return
	 */
	public List<CustomerAgeGroupPo> selectCustomerAgeGroupList(CustomerAgeGroupPo po,int start, int size){
		return customerAgeGroupDao.selectCustomerAgeGroupList(po, start, size);
	}

	/**
	 * 判断区间是否错误
	 * @param po
	 * @return
	 */
	public int selectCustomerAge(CustomerAgeGroupPo po){
		return customerAgeGroupDao.selectCustomerAge(po);
	}
}
