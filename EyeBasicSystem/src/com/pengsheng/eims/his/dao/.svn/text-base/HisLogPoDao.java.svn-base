package com.pengsheng.eims.his.dao;

import java.util.List;

import com.pengsheng.eims.his.persistence.HisLogPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;

public interface HisLogPoDao {

	int getHisLogPoCount(HisLogPo hisLogPo);

	List<HisLogPo> getHisLogPoList(HisLogPo hisLogPo, int start, int pageSize);
	
	void insertHisLog(HisLogPo po);

	void updateNotChargeStateByHis(SalesBasicPo po);

 

	void updateNotChargeStateBySG(SalesBasicPo spo);

	HisLogPo getHisLogInfo(HisLogPo po);

	int queryChargeStatecount(SalesBasicPo spo);

	List<HisLogPo> gethisLogList();

}
