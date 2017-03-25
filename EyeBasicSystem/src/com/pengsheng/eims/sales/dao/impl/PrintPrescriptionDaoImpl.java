package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.dao.PrintPrescriptionDao;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class PrintPrescriptionDaoImpl extends BaseJdbcDaoSupport implements
		PrintPrescriptionDao {

	/**
	 * 查看打印处方信息
	 */

		 public List<InspectionPo> getInspectionPos(String customerID) {

			  StringBuffer buffer = new StringBuffer();
			  buffer.append("select ");
			  buffer.append("personName as sopipersonname ");
			  buffer.append(", S_OP_IP_ID as sopipid ");
			  buffer.append(", S_OP_OY_Time as sopiptime ");
			  buffer.append(", S_OP_IP_CustomerID as sopipcustomerid ");
			  buffer.append(", S_OP_IP_OptometryBasicID as sopipoptometrybasicid ");
			  buffer.append(", S_OP_IP_OptometryID as sopipoptometryid ");
			  buffer.append(", S_OP_IP_GlassType as sopipglasstype ");
			  buffer.append(", S_OP_IP_SecCheckDate as sopipseccheckdate  ");
			  buffer.append(", personname as sopipusername ");
			  buffer.append(", S_OP_IP_Flag as sopipflag  ");
			  buffer.append("from S_OP_Inspection ");
			  buffer.append("inner join (select top 1 ");
			  buffer.append("* from S_OP_Optometry where S_OP_OY_Flag = 1 and S_OP_OY_CustomerID = ? order by S_OP_OY_Time desc) OptometryID ");
			  buffer.append("ON S_OP_OY_OptometryID = S_OP_IP_OptometryID ");
			  buffer.append("inner join SYS_PersonInfo ");
			  buffer.append("ON SYS_PersonInfo.id = S_OP_OY_PersonID ");
			  
			  List<String> params = new ArrayList<String>();
			  params.add(customerID);
			  return queryForObjectList(buffer.toString(), params.toArray(),
			    InspectionPo.class);
			 }

}
