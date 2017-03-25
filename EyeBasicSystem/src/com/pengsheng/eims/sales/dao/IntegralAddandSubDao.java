package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;

public interface IntegralAddandSubDao {
	/**
	 * 增减记录新增
	 * @param po
	 */
	public void insertIntegralAddandSubPo(IntegralAddandSubPo po);
	
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
