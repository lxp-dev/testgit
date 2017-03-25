package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.AdditionalCostsDao;
import com.pengsheng.eims.system.mgr.AdditionalCostsMgr;
import com.pengsheng.eims.system.persistence.AdditionalCostsPo;

public class AdditionalCostsMgrImpl implements AdditionalCostsMgr {

	private AdditionalCostsDao additionalCostsDao;
	private LogisticsLogDao logisticsLogDao;
	 
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public AdditionalCostsDao getAdditionalCostsDao() {
		return additionalCostsDao;
	}

	public void setAdditionalCostsDao(AdditionalCostsDao additionalCostsDao) {
		this.additionalCostsDao = additionalCostsDao;
	}

	/**
	 * 删除附加费用
	 * 
	 * @param po 附加费用po
	 * @return void
	 */
	public void deleteAdditionalCosts(AdditionalCostsPo po,LogisticsLogPo logPo) {
		additionalCostsDao.deleteAdditionalCosts(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 附加费用数量
	 */
	public int getAdditionalCostsCount(AdditionalCostsPo po) {
		return additionalCostsDao.getAdditionalCostsCount(po);
	}

	
	/**
	 * 查询附加费用ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getAdditionalCostsId(AdditionalCostsPo po) {
		return additionalCostsDao.getAdditionalCostsId(po);
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 附加费用数量
	 */
	public List<AdditionalCostsPo> getAdditionalCostsList(AdditionalCostsPo po, int start, int size) {
		return additionalCostsDao.getAdditionalCostsList(po, start, size);
	}

	/**
	 * 查询附加费用的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 附加费用详细信息
	 */
	public AdditionalCostsPo getAdditionalCostsPo(AdditionalCostsPo po) {
		return additionalCostsDao.getAdditionalCostsPo(po);
	}

	/**
	 * 查询附加费用在   表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTAdditionalCostsWithGoods(AdditionalCostsPo po) {
		return additionalCostsDao.getTAdditionalCostsWithGoods(po);
	}

	/**
	 * 新增附加费用
	 * 
	 * @param po 附加费用po
	 * @return void
	 */
	public void insertAdditionalCosts(AdditionalCostsPo po,LogisticsLogPo logPo) {
		additionalCostsDao.insertAdditionalCosts(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 修改附加费用
	 * 
	 * @param po 附加费用po
	 * @return void
	 */
	public void updateAdditionalCosts(AdditionalCostsPo po,LogisticsLogPo logPo) {
		additionalCostsDao.updateAdditionalCosts(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	public List<AdditionalCostsPo> getAdditionalCostsList(){
		return additionalCostsDao.getAdditionalCostsList();
	}
	/**
	 * 添加时查询附加费用名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getAdditionalCostsName(AdditionalCostsPo po) 
	{
		return additionalCostsDao.getAdditionalCostsName(po);
	}
	/**
	 * 修改时查询附加费用名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getAdditionalCostsNameUpdate(AdditionalCostsPo po)
	{
		return additionalCostsDao.getAdditionalCostsNameUpdate(po);
	}
	
	public List<AdditionalCostsPo> getAdditionalCostsListForAjax(String[] supplierids){
		return additionalCostsDao.getAdditionalCostsListForAjax(supplierids);
	}
}
