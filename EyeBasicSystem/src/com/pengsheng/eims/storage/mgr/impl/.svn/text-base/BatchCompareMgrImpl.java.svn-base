package com.pengsheng.eims.storage.mgr.impl;

import com.pengsheng.eims.storage.dao.BatchCompareDao;
import com.pengsheng.eims.storage.mgr.BatchCompareMgr;
import com.pengsheng.eims.storage.persistence.BatchComparePo;

public class BatchCompareMgrImpl implements BatchCompareMgr{
	private BatchCompareDao batchCompareDao;
	
	public BatchCompareDao getBatchCompareDao() {
		return batchCompareDao;
	}

	public void setBatchCompareDao(BatchCompareDao batchCompareDao) {
		this.batchCompareDao = batchCompareDao;
	}

	public void insertBatchComparePo(BatchComparePo po) {
		batchCompareDao.insertBatchComparePo(po);
	}

	public BatchComparePo selectBatchComparePo(BatchComparePo po) {
		return batchCompareDao.selectBatchComparePo(po);
	}

}
