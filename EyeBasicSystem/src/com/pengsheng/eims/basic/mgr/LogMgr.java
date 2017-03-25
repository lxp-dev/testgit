package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.LogPo;
import com.pengsheng.eims.system.persistence.ModulePo;

public interface LogMgr {
	/**
	 * 日志总页数查询
	 */
	public int getLogpageCount(LogPo logPo);
	
	/**
	 * 日志详细查询
	 */
	public List<LogPo> getLogpageList(LogPo logPo, int start, int size);

	/**
	 * Description :获取功能设置列表
	 * @return :功能设置的列表
	 */
	public List<ModulePo> getModuleList();
	
}
