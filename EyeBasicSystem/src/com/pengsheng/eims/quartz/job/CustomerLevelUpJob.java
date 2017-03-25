package com.pengsheng.eims.quartz.job;

import com.pengsheng.eims.quartz.mgr.CustomerLevelUpMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;


public class CustomerLevelUpJob  extends BaseAction{
	private CustomerLevelUpMgr customerLevelUpMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr;
	
	public String customerLevelUp() throws Exception{
//		systemParameterPo = systemParameterMgr.getSystemParameterPo();
//		
//		if("1".equals(Utility.getName(systemParameterPo.getFsptrlevelup()))){
//			customerLevelUpMgr.updateCustomerLevel(null);
//		}
		
		return SUCCESS;
	}
	
	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public CustomerLevelUpMgr getCustomerLevelUpMgr() {
		return customerLevelUpMgr;
	}

	public void setCustomerLevelUpMgr(CustomerLevelUpMgr customerLevelUpMgr) {
		this.customerLevelUpMgr = customerLevelUpMgr;
	}
}
