package com.pengsheng.eims.his.dao;

import java.util.List;

import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;

public interface HisParamDao {

	public List<HisParamPo> getHisParamPoList(HisParamPo po);

	public int getHisParamPoCount(HisParamPo po);

	public List<HisParamPo> getHisParamPoList(HisParamPo po, int start, int size);

	public HisParamPo getHisParamPo(HisParamPo hisParamPo);

	public void insertSaleInfoToHis(HisParamPo hisParamPo);

	int getHisParamPoCountByBillid(HisParamPo po);

	public void updateTollState(HisParamPo po);

	public int getNotSubCount(SalesBasicPo po);

	public List<SalesBasicPo> getNotSubList(SalesBasicPo po, int start, int pageSize);

	public void updateSaleInfoToHis(HisParamPo hisParamPo);

	public void deleteHisParam(HisParamPo po);


	 
}
