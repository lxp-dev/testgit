package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.SalesSpecialPo;
import com.pengsheng.eims.system.dao.SpecialRequirementsDao;
import com.pengsheng.eims.system.mgr.SpecialRequirementsMgr;
import com.pengsheng.eims.system.persistence.SpecialRequirementsPo;

public class SpecialRequirementsMgrImpl implements SpecialRequirementsMgr {
	
	//特殊加工要求Dao
	private SpecialRequirementsDao specialRequirementsDao;
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public SpecialRequirementsDao getSpecialRequirementsDao() {
		return specialRequirementsDao;
	}

	public void setSpecialRequirementsDao(
			SpecialRequirementsDao specialRequirementsDao) {
		this.specialRequirementsDao = specialRequirementsDao;
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 特殊加工要求数量
	 */
	public int getSpecialRequirementsCount(SpecialRequirementsPo po){
		return specialRequirementsDao.getSpecialRequirementsCount(po);
	}

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 特殊加工要求结果集
	 */
	public List getSpecialRequirementsList(SpecialRequirementsPo po,int start, int size){
		return specialRequirementsDao.getSpecialRequirementsList(po, start, size);
	}
	
	

	/**
	 * 查询特殊加工要求的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 特殊加工要求详细信息
	 */
	public SpecialRequirementsPo getSpecialRequirementsPo(SpecialRequirementsPo po){
		return specialRequirementsDao.getSpecialRequirementsPo(po);
	}
	
	/**
	 * 查询特殊加工要求ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getSpecialRequirementsId(SpecialRequirementsPo po){
		return specialRequirementsDao.getSpecialRequirementsId(po);
	}
	
	
	/**
	 * 查询特殊加工要求在   表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTSpecialRequirementsWithGoods(SpecialRequirementsPo po){
		return specialRequirementsDao.getTSpecialRequirementsWithGoods(po);
	}
	
	
	/**
	 * 新增特殊加工要求
	 * 
	 * @param po 特殊加工要求po
	 * @return void
	 */
	public void insertSpecialRequirements(SpecialRequirementsPo po,LogisticsLogPo logPo){
		specialRequirementsDao.insertSpecialRequirements(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 修改特殊加工要求
	 * 
	 * @param po 特殊加工要求po
	 * @return void
	 */
	public void updateSpecialRequirements(SpecialRequirementsPo po,LogisticsLogPo logPo){
		specialRequirementsDao.updateSpecialRequirements(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 删除特殊加工要求
	 * 
	 * @param po 特殊加工要求po
	 * @return void
	 */
	public void deleteSpecialRequirements(SpecialRequirementsPo po,LogisticsLogPo logPo){
		specialRequirementsDao.deleteSpecialRequirements(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	public List<SpecialRequirementsPo> getSpecialRequirementsList(){
		return specialRequirementsDao.getSpecialRequirementsList();
	}
	/**
	 * 得到所有特殊加工要求
	 * 
	 * @param 
	 * @return List 
	 */
	public List<SalesSpecialPo> getSpecialRequirements1List(String status){
		return specialRequirementsDao.getSpecialRequirements1List(status);
	}
	
	/**
	 * 添加时查询特殊加工要求名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getSpecialRequirementsName(SpecialRequirementsPo po)
	{
		return specialRequirementsDao.getSpecialRequirementsName(po);
	}
	/**
	 * 修改时查询特殊加工要求名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getSpecialRequirementsNameUpdate(SpecialRequirementsPo po) 
	{
		return specialRequirementsDao.getSpecialRequirementsNameUpdate(po);
	}
}
