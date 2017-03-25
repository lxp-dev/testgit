package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.dao.PrintRegistrationDao;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class PrintRegistrationDaoImpl extends BaseJdbcDaoSupport implements
		PrintRegistrationDao {

	/**
	 * 打印挂号单
	 */
	public List<RegisteredDetailsPo> getRegisteredDetailsPos(RegisteredDetailsPo registered) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("select scrrddetailsid,scrrdcasher,scrrdregister,scrrdcashername,sum(SCRRDMoney) as SCRRDMoney,scrrdcasherdate,scrrdcustomerid,smecname from ( ");
		buffer.append("select ");
		buffer.append("S_CR_RD_DetailsID as scrrddetailsid, ");
		buffer.append("S_CR_RD_Casher as scrrdcasher, SYS_PersonInfo1.personName as scrrdregister, ");
		buffer.append("SYS_PersonInfo.personName as scrrdcashername, ");
		buffer.append("sum(convert(numeric(13,2), S_CR_RD_Money)) as SCRRDMoney ,");
		buffer.append("convert(varchar(10), S_CR_RD_CasherDate, 120) as scrrdcasherdate, ");
		buffer.append("S_CR_RD_CustomerID  as scrrdcustomerid,");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Name as smecname ");
		buffer.append("from S_CR_RegisteredDetails  ");
		buffer.append("inner join SYS_PersonInfo ON SYS_PersonInfo.id = S_CR_RegisteredDetails.S_CR_RD_Register ");
		buffer.append("inner join (select ID,personName from SYS_PersonInfo)SYS_PersonInfo1 ON SYS_PersonInfo1.id = S_CR_RegisteredDetails.S_CR_RD_Casher "); 
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_CR_RegisteredDetails.S_CR_RD_CustomerID  ");
		buffer.append("where S_CR_RD_Flag  = 1 and S_CR_RD_CustomerID  = ? ");
		buffer.append("and S_CR_RD_ShopCode = ? ");
		buffer.append("group by S_CR_RD_DetailsID, S_CR_RD_CustomerID,S_CR_RD_CasherDate, ");
		buffer.append("S_CR_RD_Casher,SYS_PersonInfo1.personName, SYS_PersonInfo.personName,convert(varchar(10), S_CR_RD_CasherDate, 120), ");
		buffer.append("S_ME_CustomerInfo.S_ME_CI_Name  ");
		buffer.append(")temp group by scrrddetailsid,scrrdcasher,scrrdregister,scrrdcashername,scrrdcasherdate,scrrdcustomerid,smecname  ");
		buffer.append("order by scrrdcasherdate desc ");
		
		List<String> params = new ArrayList<String>();
	   
		params.add(registered.getScrrdcustomerid());
	    params.add(registered.getScrrdshopcode());
		  return queryForObjectList(buffer.toString(), params.toArray(),
				  RegisteredDetailsPo.class);
	}
}
