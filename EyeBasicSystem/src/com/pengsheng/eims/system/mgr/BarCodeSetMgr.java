package com.pengsheng.eims.system.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.BarCodeSetPo;

public interface BarCodeSetMgr {

	public int getBarCodeSetCount(BarCodeSetPo barCodeSetPo);
	
	public List<BarCodeSetPo> getBarCodeSetList(BarCodeSetPo barCodeSetPo, int start, int size);
	
	public void insertBarCodeSet(BarCodeSetPo barCodeSetPo,LogisticsLogPo logPo);
	
	public void updateBarCodeSet(BarCodeSetPo barCodeSetPo,LogisticsLogPo logPo);
	
	public void deleteBarCodeSet(BarCodeSetPo barCodeSetPo,LogisticsLogPo logPo);
	
	public int isBarCodeSet(BarCodeSetPo barCodeSetPo);
	
	public BarCodeSetPo getBarCodeSetPo(BarCodeSetPo barCodeSetPo);
	
}
