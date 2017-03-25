package com.pengsheng.eims.hydsycasehistory.mgr;

import java.util.List;

import com.pengsheng.eims.hydsycasehistory.persistence.YjCheckPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface YjCheckHydsyMgr {

	public int getYjCheckCount(YjCheckPo po);
	
	public List<YjCheckPo> getYjCheckList(YjCheckPo po,int start, int size);
	
	public void insertYjCheck(YjCheckPo po,LogisticsLogPo logPo);
	
	public YjCheckPo getYjCheck(YjCheckPo po);

	public YjCheckPo getLastYjCheck(YjCheckPo po);
	
	public void deleteYjCheck(YjCheckPo po,LogisticsLogPo logPo);
}
