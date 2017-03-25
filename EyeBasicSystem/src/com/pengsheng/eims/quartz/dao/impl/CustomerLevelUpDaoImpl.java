package com.pengsheng.eims.quartz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.quartz.dao.CustomerLevelUpDao;
import com.pengsheng.eims.quartz.persistence.CustomerLevelUpPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class CustomerLevelUpDaoImpl extends BaseJdbcDaoSupport implements CustomerLevelUpDao {
	
	public void updateCustomerLevel(CustomerLevelUpPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_ME_CustomerInfo set ");
		buffer.append("S_ME_CI_CardType = ?, ");
		buffer.append("S_ME_CI_LevelUpDate = DateAdd(d,1, getdate()) ");
		buffer.append("where S_ME_CI_CustomerID = ? ");
		
		params.add(po.getClunowtype());
		params.add(po.getClucustomerid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public List<CustomerLevelUpPo> getCustomerLevelList(CustomerLevelUpPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
													
		buffer.append("select S_SE_SB_CustomerID 										as clucustomerid, ");
		buffer.append("       dbo.getCustomerSalesSumForToday(S_SE_SB_CustomerID)  		as clutodaysalessum, ");
		buffer.append("       dbo.getCustomerSalesSumForTwoYears(S_SE_SB_CustomerID)  	as clutwoyearssalessum, ");
		buffer.append("       S_ME_CI_CardType  										as cluagotype, ");
		buffer.append("       F_MM_UpgradeCard											as clunowtype ");
		buffer.append("from uview_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SB_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("inner join F_MemberManagement on S_ME_CI_CardType = F_MM_ID ");
		buffer.append("where S_SE_SB_ValueFlag = '1' ");
		buffer.append("  and convert(varchar(10),S_SE_SB_PosDatetime,23) = convert(varchar(10),getdate(),23) ");
		buffer.append("  and S_SE_SB_CheckoutFlag = '0' ");
		buffer.append("  and S_SE_SB_WithdrawFlag <> '1' ");
		buffer.append("group by S_SE_SB_CustomerID, ");
		buffer.append("		 	S_ME_CI_CardType, ");
		buffer.append("		 	F_MM_UpgradeCard ");

		return queryForObjectList(buffer.toString(), params.toArray(),
				CustomerLevelUpPo.class);
	}
}
