package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.components.dao.SpecialRequirementsOpenDao;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.SpecialRequirementsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SpecialRequirementsOpenDaoImpl extends BaseJdbcDaoSupport implements
		SpecialRequirementsOpenDao {

	/**
	 * 显示特殊加工要求并分页
	 */
	public List<SpecialRequirementsPo> geSpecialRequirementsList(
			SpecialRequirementsPo po, int start, int size) {
		    StringBuffer sb=new StringBuffer();
	    	int countPage = start + size;
			sb.append("set rowcount " + countPage + " \n");
	        sb.append("select F_SR_ID as fsrid,F_SR_Name as fsrname from ");
			sb.append("(select ROW_NUMBER() Over(order by F_SpecialRequirements.F_SR_ID) as rowNum, ");
			sb.append("F_SR_ID ,");
			sb.append("F_SR_Name ");
			sb.append("from F_SpecialRequirements where 1=1");

			sb.append(" )temp where rowNum > "+start+" and rowNum <= "+ countPage);
			sb.append(" set rowcount 0");
			return queryForObjectList(sb.toString(),null,
					SpecialRequirementsPo.class);
	}

	/**
	 * 查询特殊加工要求数量
	 */
	public int getSpecialRequirementsCount(SpecialRequirementsPo po) {
		StringBuffer sb=new StringBuffer();
		sb.append("select count(F_SR_Name)  ");
		sb.append("from F_SpecialRequirements  ");
		sb.append("where 1=1 ");
		
		return getJdbcTemplate().queryForInt(sb.toString());
	}

}
