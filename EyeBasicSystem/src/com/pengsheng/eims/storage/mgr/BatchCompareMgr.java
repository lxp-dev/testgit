package com.pengsheng.eims.storage.mgr;

import com.pengsheng.eims.storage.persistence.BatchComparePo;

public interface BatchCompareMgr {
	public void insertBatchComparePo(BatchComparePo po);
	
	public BatchComparePo selectBatchComparePo(BatchComparePo po);
}
