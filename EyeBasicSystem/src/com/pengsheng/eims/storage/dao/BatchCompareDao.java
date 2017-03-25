package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.BatchComparePo;

public interface BatchCompareDao {
	public void insertBatchComparePo(BatchComparePo po);
	
	public BatchComparePo selectBatchComparePo(BatchComparePo po);
}
