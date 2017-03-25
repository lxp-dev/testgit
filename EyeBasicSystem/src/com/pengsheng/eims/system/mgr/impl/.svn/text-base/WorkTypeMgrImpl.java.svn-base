package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.WorkTypeDao;
import com.pengsheng.eims.system.mgr.WorkTypeMgr;
import com.pengsheng.eims.system.persistence.PersonTypePo;
import com.pengsheng.eims.system.persistence.WorkTypePo;

/**
 * WorkTypeMgr 职业Mgr
 * 
 * @author GuanZiGang
 * @version 1.0
 * @see WorkTypeMgr
 */
public class WorkTypeMgrImpl implements WorkTypeMgr {

	//工艺类型Dao
	public WorkTypeDao workTypeDao;
	private LogisticsLogDao logisticsLogDao = null;
	
	public WorkTypeDao getWorkTypeDao() {
		return workTypeDao;
	}

	public void setWorkTypeDao(WorkTypeDao workTypeDao) {
		this.workTypeDao = workTypeDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	/**
	 * 删除职业
	 * 
	 * @param po 职业po
	 * @return void
	 */
	public void deleteWorkType(WorkTypePo po,LogisticsLogPo logPo) {
		workTypeDao.deleteWorkType(po);		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 职业数量
	 */
	public int getWorkTypeCount(WorkTypePo po) {
		return workTypeDao.getWorkTypeCount(po);
	}

	/**
	 * 查询职业ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getWorkTypeId(WorkTypePo po) {
		return workTypeDao.getWorkTypeId(po);
	}

	/**
	 * 添加时查询职业名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getWorkTypeName(WorkTypePo po) 
	{
		return workTypeDao.getWorkTypeName(po);
	}
	
	/**
	 * 修改时查询职业名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getWorkTypeNameUpdate(WorkTypePo po) 
	{
		return workTypeDao.getWorkTypeNameUpdate(po);
	}
	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 职业结果集
	 */
	public List getWorkTypeList(WorkTypePo po, int start, int size) {
		return workTypeDao.getWorkTypeList(po, start, size);
	}

	/**
	 * 新增职业
	 * 
	 * @param po 职业po
	 * @return void
	 */
	public void insertWorkType(WorkTypePo po,LogisticsLogPo logPo) {
		workTypeDao.insertWorkType(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 修改职业
	 * 
	 * @param po 职业po
	 * @return void
	 */
	public void updateWorkType(WorkTypePo po,LogisticsLogPo logPo) {
		workTypeDao.updateWorkType(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 查询职业在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getWorkTypeWithGoods(WorkTypePo po){
		return workTypeDao.getWorkTypeWithGoods(po);
	}

	
	/**
	 * 查询职业的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 职业详细信息
	 */
	public WorkTypePo getWorkTypePo(WorkTypePo po) {
		return workTypeDao.getWorkTypePo(po);
	}
   
	public List getWorkTypeList() {
		return workTypeDao.getWorkTypeList();
	}

	public void deletePersonType(PersonTypePo po,LogisticsLogPo logPo) {
		workTypeDao.deletePersonType(po);		
		logisticsLogDao.insertLog(logPo);
	}
	
	public int getPersonTypeCount(PersonTypePo po) {
		return workTypeDao.getPersonTypeCount(po);
	}
	
	public int getPersonTypeId(PersonTypePo po) {
		return workTypeDao.getPersonTypeId(po);
	}
	
	public int getPersonTypeName(PersonTypePo po) {
		return workTypeDao.getPersonTypeName(po);
	}
	
	public int getPersonTypeNameUpdate(PersonTypePo po) {
		return workTypeDao.getPersonTypeNameUpdate(po);
	}
	
	public List getPersonTypeList(PersonTypePo po, int start, int size) {
		return workTypeDao.getPersonTypeList(po, start, size);
	}
	
	public void insertPersonType(PersonTypePo po,LogisticsLogPo logPo) {
		workTypeDao.insertPersonType(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	public void updatePersonType(PersonTypePo po,LogisticsLogPo logPo) {
		workTypeDao.updatePersonType(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	public int getPersonTypeIsUse(PersonTypePo po){
		return workTypeDao.getPersonTypeIsUse(po);
	}
	
	
	public PersonTypePo getPersonTypePo(PersonTypePo po) {
		return workTypeDao.getPersonTypePo(po);
	}
	
	public List getPersonTypeList() {
		return workTypeDao.getPersonTypeList();
	}
}
