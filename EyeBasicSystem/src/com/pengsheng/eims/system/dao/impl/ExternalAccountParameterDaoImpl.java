package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.dao.ExternalAccountParameterDao;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ExternalAccountParameterDaoImpl extends BaseJdbcDaoSupport implements ExternalAccountParameterDao {
	
	public void insertExternalAccountParameter(ExternalAccountParameterPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("INSERT INTO F_ExternalAccountParameter ");
		buffer.append("            (F_EA_ID, ");
		buffer.append("             F_EA_AccessAddress, ");
		buffer.append("             F_EA_ExternalAddress, ");
		buffer.append("             F_EA_AccessName, ");
		buffer.append("             F_EA_ExternalName, ");
		buffer.append("             F_EA_ProCreateId, ");
		buffer.append("             F_EA_ProAduiteId, ");
		buffer.append("             F_EA_DepartmentsId, ");
		buffer.append("             F_EA_ProReturnCreateId, ");
		buffer.append("             F_EA_ProReturnAduiteId, ");
		buffer.append("             F_EA_NoCashMothe, ");
		buffer.append("             F_EA_NoCashMotheName, ");
		buffer.append("             F_EA_CastSet) ");
		buffer.append("VALUES      (?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?) ");
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getFeaaccessaddress()));
		params.add(Utility.getName(po.getFeaexternaladdress()));
		params.add(Utility.getName(po.getFeaaccessname()));
		params.add(Utility.getName(po.getFeaexternalname()));
		params.add(Utility.getName(po.getFeaprocreateid()));	
		params.add(Utility.getName(po.getFeaproaduiteid()));
		params.add(Utility.getName(po.getFeadepartmentsid()));
		params.add(Utility.getName(po.getFeaproreturncreateid()));
		params.add(Utility.getName(po.getFeaproreturnaduiteid()));
		params.add(Utility.getName(po.getFeanocashmothe()));	
		params.add(Utility.getName(po.getFeanocashmothename()));	
		params.add(Utility.getName(po.getFeacastset()));	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	public ExternalAccountParameterPo getExternalAccountParameterPo(ExternalAccountParameterPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("SELECT top 1 F_EA_ID as feaid, ");
		buffer.append("       F_EA_AccessAddress as feaaccessaddress, ");
		buffer.append("       F_EA_ExternalAddress as feaexternaladdress, ");
		buffer.append("       F_EA_AccessName as feaaccessname, ");
		buffer.append("       F_EA_ExternalName as feaexternalname, ");
		buffer.append("       F_EA_ProCreateId as feaprocreateid, ");
		buffer.append("       F_EA_ProAduiteId as feaproaduiteid, ");
		buffer.append("       F_EA_DepartmentsId as feadepartmentsid, ");
		buffer.append("       F_EA_ProReturnCreateId as feaproreturncreateid, ");
		buffer.append("       F_EA_ProReturnAduiteId as feaproreturnaduiteid, ");
		buffer.append("       F_EA_NoCashMothe as feanocashmothe, ");
		buffer.append("       F_EA_NoCashMotheName as feanocashmothename, ");
		buffer.append("       F_EA_CastSet as feacastset ");
		buffer.append("FROM   F_ExternalAccountParameter ");
		buffer.append("WHERE  1=1 ");
		if(!"".equals(Utility.getName(po.getFeaid()))){
			buffer.append("AND F_EA_ID = ? ");
			params.add(Utility.getName(po.getFeaid()));
		}
		return (ExternalAccountParameterPo) queryForObject(buffer.toString(), params
				.toArray(), ExternalAccountParameterPo.class);
		
	}
	public void deleteExternalAccountParameter(ExternalAccountParameterPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("delete from  F_ExternalAccountParameter WHERE 1=1");
		if(!"".equals(Utility.getName(po.getFeaid()))){
			buffer.append("AND F_EA_ID = ? ");
			params.add(Utility.getName(po.getFeaid()));
		}
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
