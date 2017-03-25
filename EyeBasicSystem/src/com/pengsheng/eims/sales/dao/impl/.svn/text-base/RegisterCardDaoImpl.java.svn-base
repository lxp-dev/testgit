package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.dao.RegisterCardDao;
import com.pengsheng.eims.sales.persistence.RechargeRecordPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class RegisterCardDaoImpl extends BaseJdbcDaoSupport implements
		RegisterCardDao {

	/**
	 * 充值卡消费数量
	 */
	public int getRegisterCardCount(String customerID) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(S_SE_RR_ID) ");
		buffer.append("from S_SE_RechargeRecord ");
		buffer
				.append("inner join SYS_PersonInfo on S_SE_RechargeRecord.S_SE_RR_CreatePerson=SYS_PersonInfo.ID ");
		buffer
				.append("inner join S_ME_CustomerInfo on S_SE_RechargeRecord.S_SE_RR_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		buffer
				.append("inner join B_Departments on S_SE_RechargeRecord.S_SE_RR_ShopCode=B_Departments.B_DP_DepartmentID ");
		buffer.append("where S_SE_RR_CustomerID = ? ");
		params.add(customerID);

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}

	/**
	 * 遍历充值卡消费
	 */
	public List<RechargeRecordPo> getRegisterCardList(String customerID,
			int start, int size) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_SE_RR_Date desc) as rowNum, ");

		buffer.append("S_SE_RR_ID as sserrid , ");
		buffer.append("S_SE_RR_Flag as sserrflag ,");
		buffer.append("S_ME_CI_Name as sserrcustomeridname, ");
		buffer.append("S_SE_RR_CustomerID as sserrcustomerid , ");
		buffer.append("S_SE_RR_ShopCode as sserrshopcode ,  ");
		buffer.append("B_DP_DepartmentName as sserrshopcodename,  ");
		buffer.append("S_SE_RR_CreatePerson as sserrcreateperson ,");
		buffer.append("personName as sserrcreatepersonname ,");
		buffer.append("S_SE_RR_Date as sserrdate ,     ");
		buffer.append("S_SE_RR_CardID as sserrcardid , ");
		buffer.append("S_SE_RR_Amount as sserramount   ");
		buffer.append("from S_SE_RechargeRecord  ");
		buffer
				.append("inner join SYS_PersonInfo on S_SE_RechargeRecord.S_SE_RR_CreatePerson=SYS_PersonInfo.ID ");
		buffer
				.append("inner join S_ME_CustomerInfo on S_SE_RechargeRecord.S_SE_RR_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		buffer
				.append("inner join B_Departments on S_SE_RechargeRecord.S_SE_RR_ShopCode=B_Departments.B_DP_DepartmentID ");
		buffer.append("where S_SE_RR_CustomerID = ? ");
		params.add(customerID);

		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		return queryForObjectList(buffer.toString(), params.toArray(),
				RechargeRecordPo.class);
	}

}
