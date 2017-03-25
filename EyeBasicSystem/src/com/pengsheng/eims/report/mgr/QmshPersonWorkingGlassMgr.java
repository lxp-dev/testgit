/**
 * 
 */
package com.pengsheng.eims.report.mgr;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Liuqian
 * 
 */
public interface QmshPersonWorkingGlassMgr {

	/**
	 * 生成excel
	 * 
	 * @param begDate
	 * @param endDate
	 * @throws Exception 
	 * @throws Exception
	 */
	public InputStream bulidShopExcel(FileInputStream excel,String begDate, String endDate) throws Exception;

}
