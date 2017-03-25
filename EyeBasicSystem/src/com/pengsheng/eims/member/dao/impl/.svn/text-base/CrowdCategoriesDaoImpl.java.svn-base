package com.pengsheng.eims.member.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.dao.CrowdCategoriesDao;
import com.pengsheng.eims.member.persistence.CrowdCategoriesPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CrowdCategoriesDaoImpl extends BaseJdbcDaoSupport implements
		CrowdCategoriesDao {

	public void deleteCrowdCategories(CrowdCategoriesPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM F_CrowdCategories ");
		buffer.append("WHERE F_CC_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(po.getFccid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public CrowdCategoriesPo getCrowdCategories(CrowdCategoriesPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  F_CC_ID as fccid ");
		buffer.append(",F_CC_MemberTypeName  as fccmembertypename ");
		buffer.append(",F_CC_UP as fccup ");
		buffer.append(",F_CC_DOWN as fccdown ");
		buffer.append("FROM F_CrowdCategories ");
		buffer.append("WHERE 1 = 1");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getFccid()))) {
			buffer.append(" AND F_CC_ID = ?");
			params.add(po.getFccid());
		}
		
		return (CrowdCategoriesPo) queryForObject(buffer.toString(), params
				.toArray(), CrowdCategoriesPo.class);
	}

	public List<CrowdCategoriesPo> getCrowdCategoriesList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT F_CC_ID as fccid ");
		buffer.append(",F_CC_MemberTypeName  as fccmembertypename ");
		buffer.append(",F_CC_UP as fccup ");
		buffer.append(",F_CC_DOWN as fccdown ");
		buffer.append("FROM F_CrowdCategories ");

		return queryForObjectList(buffer.toString(), null, CrowdCategoriesPo.class);
	}

	public void insertCrowdCategories(CrowdCategoriesPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO F_CrowdCategories ");
		buffer.append("(F_CC_ID ");
		buffer.append(",F_CC_MemberTypeName ");
		buffer.append(",F_CC_UP ");
		buffer.append(",F_CC_DOWN) ");
		buffer.append("VALUES (?, ?, ?, ?)");

		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(po.getFccmembertypename());
		params.add(po.getFccup());
		params.add(po.getFccdown());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateCrowdCategories(CrowdCategoriesPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE F_CrowdCategories ");
		buffer.append("SET F_CC_MemberTypeName = ? ");
		buffer.append(",F_CC_UP = ? ");
		buffer.append(",F_CC_DOWN = ? ");
		buffer.append("WHERE F_CC_ID = ?");

		List<String> params = new ArrayList<String>();

		params.add(po.getFccmembertypename());
		params.add(po.getFccup());
		params.add(po.getFccdown());
		params.add(po.getFccid());
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}	
}
