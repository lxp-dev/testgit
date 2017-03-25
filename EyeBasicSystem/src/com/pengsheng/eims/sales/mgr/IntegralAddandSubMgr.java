package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface IntegralAddandSubMgr {
	/**
	 * 增减记录新增
	 * @param po
	 */
	public void insertIntegralAddandSubPo(IntegralAddandSubPo po,PersonInfoPo personInfoPo,SmsRecordPo smsRecordPo,String isSend,LogisticsLogPo logPo);
	
	/**
	 * 查询增减Count
	 * @param po
	 */
	public int selectIntegralAddandSubCount(IntegralAddandSubPo po);
	
	/**
	 * 查询增减List
	 * @param po
	 */
	public List<IntegralAddandSubPo> selectIntegralAddandSubList(IntegralAddandSubPo po,int start, int size);
	
	/**
	 * 查询增减Po
	 * @param po
	 */
	public IntegralAddandSubPo selectIntegralAddandSubPo(IntegralAddandSubPo po);
	
	/**
	 * 更新短信状态
	 * @param po
	 */
	public void updateIntegralAddandSubSendType(IntegralAddandSubPo po);
}
