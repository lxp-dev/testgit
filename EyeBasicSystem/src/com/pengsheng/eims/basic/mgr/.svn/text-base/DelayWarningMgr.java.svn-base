package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DelayNoticePo;
import com.pengsheng.eims.basic.persistence.DelayWarningPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;

public interface DelayWarningMgr {
	/**
	 * 加载误期提醒Po
	 * @return
	 */
	public DelayWarningPo selectDelayWarningPo();
	
	/**
	 * 插入误期提醒
	 * @param po
	 */
	public void insertDelayWarning(DelayWarningPo po,LogisticsLogPo logPo);
	
	/**
	 * 更新误期提醒
	 * @param po
	 */
	public void updateDelayWarning(DelayWarningPo po,LogisticsLogPo logPo);
	
	/**
	 * 委外预误期查询count
	 * @param po
	 */
	public int selectDelayWarningCount(DelayWarningPo po);
	
	/**
	 * 委外预误期查询list
	 * @param po
	 */
	public List<DelayWarningPo> selectDelayWarningList(DelayWarningPo po, int start,int size);
	
	/**
	 * 委外预误期加载po
	 * @param po
	 */
	public DelayNoticePo selectDelayNoticePo(DelayNoticePo po);
	
	/**
	 * 委外预误期通知新增
	 * @param po
	 */
	public void insertDelayNotice(DelayNoticePo po,SendNotePo snpo);
	
	/**
	 * 委外预误期通知更新
	 * @param po
	 */
	public void updateDelayNotice(DelayNoticePo po);
}
