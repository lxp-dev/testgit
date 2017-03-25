package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.CustomerPo;

public interface CustomerDao {
	
		/**
		 * 取客户List
		 * 
		 * @param customerPo
		 *            客户参数集
		 * @return
		 */
		public List<CustomerPo> getCustomerList(CustomerPo customerPo);

		/**
		 * 取指定客户
		 * 
		 * @param customerPo
		 *            客户参数集
		 * @return
		 */
		public CustomerPo getCustomer(CustomerPo customerPo);

		/**
		 * 插入客户
		 * 
		 * @param customerPo
		 *            客户参数集
		 */
		public void insertCustomer(CustomerPo customerPo);

		/**
		 * 更新客户
		 * 
		 * @param customerPo
		 *            客户参数集
		 */
		public void updateCustomer(CustomerPo customerPo);

		/**
		 * 删除客户
		 * 
		 * @param customerPo
		 *            客户参数集
		 */
		public void deleteCustomer(CustomerPo customerPo);
		
		public int getCustomerCountForDel(CustomerPo customerPo);
		
		/**
		 * 判断客户名称是否重复
		 * 
		 * @param customerPo
		 *          
		 */
		public int getCustomerPoName(CustomerPo po) ;
		public int getCustomerPoNameUpdate(CustomerPo po) ;
		
		/**
		 * 取客户数量
		 * 
		 * @param customerPo
		 *            
		 * @return
		 */
		public int getCustomerCount(CustomerPo customerPo) ;
		/**
		 * 取客户List
		 * 
		 * @param customerPo
		 *            客户参数集
		 * @return
		 */
		public List getCustomerPoList(CustomerPo po, int start, int size) ;
}
