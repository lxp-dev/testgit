package com.pengsheng.eims.basic.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DelayNoticePo;
import com.pengsheng.eims.basic.persistence.DelayWarningPo;

public interface DelayWarningDao {
	/**
	 * 加载误期提醒Po
	 * @return
	 */
	public DelayWarningPo selectDelayWarningPo();
	
	/**
	 * 插入误期提醒
	 * @param po
	 */
	public void insertDelayWarning(DelayWarningPo po);
	
	/**
	 * 更新误期提醒
	 * @param po
	 */
	public void updateDelayWarning(DelayWarningPo po);
	
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
	public void insertDelayNotice(DelayNoticePo po);
	
	/**
	 * 委外预误期通知更新
	 * @param po
	 */
	public void updateDelayNotice(DelayNoticePo po);
}
