package com.pengsheng.eims.member.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerSatisfactionPo;

public interface CustomerSatisfactionMgr {
	
	public void insertCustomerSatisfaction(CustomerSatisfactionPo po,LogisticsLogPo logPo);
	
	public void deleteCustomerSatisfaction(CustomerSatisfactionPo po,LogisticsLogPo logPo);
	
	public CustomerSatisfactionPo getCustomerSatisfaction(CustomerSatisfactionPo po);
	
	public List<CustomerSatisfactionPo> getCustomerSatisfactionList();
	public int getCustomerSatisfactionPoName(CustomerSatisfactionPo po) ;
	public int getCustomerSatisfactionPoNameUpdate(CustomerSatisfactionPo po) ;
public int getCustomerSatisfactionsCount() ;
	
	public List<CustomerSatisfactionPo> getCustomerSatisfactionsList(int start, int size);
}
