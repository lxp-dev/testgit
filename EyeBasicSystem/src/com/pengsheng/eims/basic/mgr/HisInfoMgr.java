package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.HisInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface HisInfoMgr {

	/**
	 * 查询医院HIS系统的信息
	 */
	public List<HisInfoPo> getHisInfoList(HisInfoPo hisInfoPo);
	
	/**
	 * 查询医院HIS系统的详细信息
	 */
	public HisInfoPo getHisInfoDetail(HisInfoPo hisInfoPo);
	
	/**
	 * 新增医院HIS系统的信息
	 */
	public void insertHisInfoList(HisInfoPo hisInfoPo,LogisticsLogPo logPo);
	
	/**
	 * 修改医院HIS系统的信息
	 */
	public void updateHisInfoList(HisInfoPo hisInfoPo,LogisticsLogPo logPo);
	
	/**
	 * 删除医院HIS系统的信息
	 */
	public void deleteHisInfoList(HisInfoPo hisInfoPo,LogisticsLogPo logPo);
	
	
}
