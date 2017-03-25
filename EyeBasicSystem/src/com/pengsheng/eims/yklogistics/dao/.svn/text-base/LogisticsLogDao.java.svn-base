package com.pengsheng.eims.yklogistics.dao;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface LogisticsLogDao {
	
	/**
	 * 模块：物流系统
	 * 描述：新增日志
	 * 参数：po   日志实体
	 * 优化记录：1. szk 2011-08-10
	 */
	public void insertLog(LogisticsLogPo po);
	
	/**
	 * 模块：物流系统
	 * 描述：查询财务部所有人员
	 * 优化记录：1. szk 2011-08-10
	 */
	public List<PersonInfoPo> selPersonInfo();
	
	/**
	 * 模块：物流系统
	 * 描述：查询物流日志总数
	 * 参数：po   日志实体
	 * 优化记录：1. szk 2011-08-10
	 */
	public int selLogisticsLogCount(LogisticsLogPo po);
	
	/**
	 * 模块：物流系统
	 * 描述：查询物流日志
	 * 参数：po   日志实体
	 *      start 开始行数
	 *      size  每页行数
	 * 优化记录：1. szk 2011-08-10
	 */
	public List<LogisticsLogPo> selLogisticsLog(LogisticsLogPo po,int start,int size);
}
