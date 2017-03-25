package com.pengsheng.eims.report.mgr;

import java.io.FileInputStream;
import java.io.InputStream;

public interface GoodsSalesAnalysisMgr{
	public InputStream bulidShopExcel(FileInputStream excel,String begDate, String endDate) throws Exception;
	
}
