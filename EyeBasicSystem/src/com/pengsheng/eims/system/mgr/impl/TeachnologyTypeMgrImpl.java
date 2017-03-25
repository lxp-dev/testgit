package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.TeachnologyTypeDao;
import com.pengsheng.eims.system.mgr.TeachnologyTypeMgr;
import com.pengsheng.eims.system.persistence.TeachnologyTypePo;

/**
 * TeachnologyTypeMgr 工艺类型Mgr
 * 
 * @author GuanZiGang
 * @version 1.0
 * @see TeachnologyTypeMgr
 */
public class TeachnologyTypeMgrImpl implements TeachnologyTypeMgr {

	//工艺类型Dao
	public TeachnologyTypeDao teachnologyTypeDao;
	private LogisticsLogDao logisticsLogDao = null;
	
	public TeachnologyTypeDao getTeachnologyTypeDao() {
		return teachnologyTypeDao;
	}

	public void setTeachnologyTypeDao(TeachnologyTypeDao teachnologyTypeDao) {
		this.teachnologyTypeDao = teachnologyTypeDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	/**
	 * 删除工艺类型
	 * 
	 * @param po 工艺类型po
	 * @return void
	 */
	public void deleteTeachnologyType(TeachnologyTypePo po,LogisticsLogPo logPo) {
		teachnologyTypeDao.deleteTeachnologyType(po);		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 工艺类型数量
	 */
	public int getTeachnologyTypeCount(TeachnologyTypePo po) {
		return teachnologyTypeDao.getTeachnologyTypeCount(po);
	}

	/**
	 * 查询工艺类型ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTeachnologyTypeId(TeachnologyTypePo po) {
		return teachnologyTypeDao.getTeachnologyTypeId(po);
	}

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 工艺类型结果集
	 */
	public List getTeachnologyTypeList(TeachnologyTypePo po, int start, int size) {
		return teachnologyTypeDao.getTeachnologyTypeList(po, start, size);
	}

	/**
	 * 新增工艺类型
	 * 
	 * @param po 工艺类型po
	 * @return void
	 */
	public void insertTeachnologyType(TeachnologyTypePo po,LogisticsLogPo logPo) {
		teachnologyTypeDao.insertTeachnologyType(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 修改工艺类型
	 * 
	 * @param po 工艺类型po
	 * @return void
	 */
	public void updateTeachnologyType(TeachnologyTypePo po,LogisticsLogPo logPo) {
		teachnologyTypeDao.updateTeachnologyType(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 查询工艺类型在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTeachnologyTypeWithGoods(TeachnologyTypePo po){
		return teachnologyTypeDao.getTeachnologyTypeWithGoods(po);
	}

	
	/**
	 * 查询工艺类型的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 工艺类型详细信息
	 */
	public TeachnologyTypePo getTeachnologyTypePo(TeachnologyTypePo po) {
		return teachnologyTypeDao.getTeachnologyTypePo(po);
	}
   
	public List getTeachnologyTypeList() {
		
		return teachnologyTypeDao.getTeachnologyTypeList();
	}
	
	/**
	 * 添加时查询工艺类型名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTeachnologyTypeName(TeachnologyTypePo po) 
	{
		return teachnologyTypeDao.getTeachnologyTypeName(po);
	}
	/**
	 * 修改时查询工艺类型名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getTeachnologyTypeNameUpdate(TeachnologyTypePo po)
	{
		return teachnologyTypeDao.getTeachnologyTypeNameUpdate(po);
	}
}
