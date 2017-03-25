package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface QcInStorageMgr {

	public int getQcInStorageCount(GoodsInfoPo gpo);
	
	public List<GoodsInfoPo> getQcInStorageList(GoodsInfoPo gpo,int start,int size);
	
	public GoodsInfoPo getQcInStorageInfo(GoodsInfoPo gpo);
	
	public void insertQcInStorage(List<GoodsInfoPo> gList,LogisticsLogPo logPo);
	
	public void updateQcInStorage(GoodsInfoPo gpo,LogisticsLogPo logPo);
	
	public int getQcInStorageSum(GoodsInfoPo gpo);
	
	public void insertQcInStorageYx(List<GoodsInfoPo> gList,LogisticsLogPo logPo);
}
