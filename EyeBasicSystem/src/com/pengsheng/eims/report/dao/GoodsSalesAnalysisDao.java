package com.pengsheng.eims.report.dao;

import java.util.List;
import java.util.Map;

public interface GoodsSalesAnalysisDao {
	public List<Map> getGoodsSalesAnalysis(String ShopCode, String begDate,
			String endDate);
}
