package com.pengsheng.eims.report.dao.impl;

import java.util.List;
import java.util.Map;

import com.pengsheng.eims.report.dao.GoodsSalesAnalysisDao;
import com.pengsheng.eims.report.dao.QmshtDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class GoodsSalesAnalysisDaoImpl extends BaseJdbcDaoSupport implements GoodsSalesAnalysisDao{
	
	/**
	 * 获得报表所需信息（存储过程GoodsSalesAnalysis）
	 * 
	 * 
	 */
	public List<Map> getGoodsSalesAnalysis(String ShopCode, String begDate,
			String endDate) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("exec [GoodsSalesAnalysis] ?, ? , ?");
		
		return getJdbcTemplate().queryForList(buffer.toString(),
				new String[] { ShopCode, begDate, endDate });
	}
			
}
