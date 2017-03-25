package com.pengsheng.eims.member.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerSatisfactionPo;

public interface CustomerSatisfactionDao {
	
	public void insertCustomerSatisfaction(CustomerSatisfactionPo po);
	
	public void deleteCustomerSatisfaction(CustomerSatisfactionPo po);
	
	public CustomerSatisfactionPo getCustomerSatisfaction(CustomerSatisfactionPo po);
	
	public List<CustomerSatisfactionPo> getCustomerSatisfactionList();
	public int getCustomerSatisfactionPoName(CustomerSatisfactionPo po) ;
	public int getCustomerSatisfactionPoNameUpdate(CustomerSatisfactionPo po) ;
	public int getCustomerSatisfactionsCount() ;
	
	public List<CustomerSatisfactionPo> getCustomerSatisfactionsList(int start, int size);
}
