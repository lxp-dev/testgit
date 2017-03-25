package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.AreaDao;
import com.pengsheng.eims.basic.persistence.AreaPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;


public class AreaDaoImpl extends BaseJdbcDaoSupport implements AreaDao {

	public List<AreaPo> getAjaxAreaData(String level,String pid) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT F_A_ID as faid ");
		buffer.append(",F_A_Pid  as fapid ");
		buffer.append(",F_A_Level  as falevel ");
		buffer.append(",F_A_Name as faname ");
		buffer.append("FROM F_Area ");		
		buffer.append("WHERE F_A_Level= ? and F_A_Pid=?");
		buffer.append(" order by F_A_ID");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(level));
		params.add(Utility.getName(pid));
		
		return queryForObjectList(buffer.toString(), params.toArray(), AreaPo.class);
	}
}
