package com.pengsheng.eims.quartz.mgr;

public interface DownloadJobMgr {
	/**
	 * 获取集团端商品成本，并更新医院端成本
	 */
	public void noUpdateCostprice();
	
	/**
	 * 上传顾客信息
	 */
	public void noUploadCustomerInfo();
}
