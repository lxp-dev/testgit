package com.pengsheng.eims.his.mgr;

import java.util.List;

import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;

public interface HisParamMgr {

	public List<HisParamPo> getHisParamPoList(HisParamPo po);
	
	public int getHisParamPoCount(HisParamPo po);
	
	public List<HisParamPo> getHisParamPoList(HisParamPo po,int start, int size);

	public HisParamPo getHisParamPo(HisParamPo hisParamPo);

	public int getNotSubCount(SalesBasicPo po);

	public List<SalesBasicPo> getNotSubList(SalesBasicPo po, int start, int pageSize);
	
	public void deleteHisParam(HisParamPo po);
}
