package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.CustomerAgeGroupPo;
import com.pengsheng.eims.basic.persistence.MemberOriginPo;

public interface CustomerAgeGroupDao {
	/**
	 * 新增区间
	 * @param po
	 */
	public void insertCustomerAgeGroupPo(CustomerAgeGroupPo po);
	
	/**
	 * 更新区间
	 * @param po
	 */
	public void updateCustomerAgeGroupPo(CustomerAgeGroupPo po);
	
	/**
	 * 删除区间
	 * @param po
	 */
	public void deleteCustomerAgeGroupPo(CustomerAgeGroupPo po);
	
	/**
	 * 区间Po
	 * @param po
	 * @return
	 */
	public List<CustomerAgeGroupPo> selectCustomerAgeGroupPos(CustomerAgeGroupPo po);
	
	/**
	 * 区间数量
	 * @param po
	 * @return
	 */
	public int selectCustomerAgeGroupCount();
	/**
	 * 区间List
	 * @param po
	 * @return
	 */
	public List<CustomerAgeGroupPo> selectCustomerAgeGroupList(CustomerAgeGroupPo po,int start, int size) ;

	/**
	 * 判断区间是否错误
	 * @param po
	 * @return
	 */
	public int selectCustomerAge(CustomerAgeGroupPo po);
}
