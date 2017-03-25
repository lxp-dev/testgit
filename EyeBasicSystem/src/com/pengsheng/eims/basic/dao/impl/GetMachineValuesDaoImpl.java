package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.GetMachineValuesDao;
import com.pengsheng.eims.basic.persistence.ApparatusPo;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class GetMachineValuesDaoImpl  extends BaseJdbcDaoSupport implements GetMachineValuesDao{

	public void updateGetMachineValues(ApparatusPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_MendMachineReplaceStr set B_MMRS_TOPCON = ? ");		
		params.add(po.getTopcon());
		
		buffer.append(",B_MMRS_NIDEK=? ");
		params.add(po.getNidek());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	public ApparatusPo selectGetMachineValues(ApparatusPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  ");
		buffer.append("B_MMRS_TOPCON as topcon, ");
		buffer.append("B_MMRS_NIDEK as nidek ");
		buffer.append("FROM B_MendMachineReplaceStr ");

		return (ApparatusPo) queryForObject(buffer.toString(), null,ApparatusPo.class);
	}
}
