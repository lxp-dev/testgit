package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.LogPo;
import com.pengsheng.eims.system.persistence.ModulePo;

public interface LogDao {
	
	/**
	 * 取得查询总条数
	 * @param logPo
	 * @return
	 */
	public int getLogpageCount(LogPo logPo);
	
	/**
	 * 取得查询详细信息LIST
	 * @param logPo
	 * @return
	 */
	public List<LogPo> getLogpageList(LogPo logPo, int start, int size);

	/**
	 * Description :获取功能设置列表
	 * @return :功能设置的列表
	 */
	public List<ModulePo> getModuleList();
	
}
