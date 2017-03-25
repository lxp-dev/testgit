package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.FrameMaterialDao;
import com.pengsheng.eims.system.mgr.FrameMaterialMgr;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;

/**
 * FrameMaterialMgr 镜架材质Mgr
 * 
 * @author GuanZiGang
 * @version 1.0
 * @see FrameMaterialMgr
 */
public class FrameMaterialMgrImpl implements FrameMaterialMgr {

	//工艺类型Dao
	public FrameMaterialDao frameMaterialDao;
	private LogisticsLogDao logisticsLogDao = null;
	
	public FrameMaterialDao getFrameMaterialDao() {
		return frameMaterialDao;
	}

	public void setFrameMaterialDao(FrameMaterialDao frameMaterialDao) {
		this.frameMaterialDao = frameMaterialDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	/**
	 * 删除镜架材质
	 * 
	 * @param po 镜架材质po
	 * @return void
	 */
	public void deleteFrameMaterial(FrameMaterialPo po,LogisticsLogPo logPo) {
		frameMaterialDao.deleteFrameMaterial(po);		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 镜架材质数量
	 */
	public int getFrameMaterialCount(FrameMaterialPo po) {
		return frameMaterialDao.getFrameMaterialCount(po);
	}

	/**
	 * 查询镜架材质ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getFrameMaterialId(FrameMaterialPo po) {
		return frameMaterialDao.getFrameMaterialId(po);
	}

	/**
	 * 添加时查询镜架材质名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getFrameMaterialName(FrameMaterialPo po) 
	{
		return frameMaterialDao.getFrameMaterialName(po);
	}
	
	/**
	 * 修改时查询镜架材质名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getFrameMaterialNameUpdate(FrameMaterialPo po) 
	{
		return frameMaterialDao.getFrameMaterialNameUpdate(po);
	}
	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 镜架材质结果集
	 */
	public List getFrameMaterialList(FrameMaterialPo po, int start, int size) {
		return frameMaterialDao.getFrameMaterialList(po, start, size);
	}

	/**
	 * 新增镜架材质
	 * 
	 * @param po 镜架材质po
	 * @return void
	 */
	public void insertFrameMaterial(FrameMaterialPo po,LogisticsLogPo logPo) {
		frameMaterialDao.insertFrameMaterial(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 修改镜架材质
	 * 
	 * @param po 镜架材质po
	 * @return void
	 */
	public void updateFrameMaterial(FrameMaterialPo po,LogisticsLogPo logPo) {
		frameMaterialDao.updateFrameMaterial(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 查询镜架材质在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getFrameMaterialWithGoods(FrameMaterialPo po){
		return frameMaterialDao.getFrameMaterialWithGoods(po);
	}

	
	/**
	 * 查询镜架材质的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 镜架材质详细信息
	 */
	public FrameMaterialPo getFrameMaterialPo(FrameMaterialPo po) {
		return frameMaterialDao.getFrameMaterialPo(po);
	}
   
	public List<FrameMaterialPo> getFrameMaterialList() {
		
		return frameMaterialDao.getFrameMaterialList();
	}
}
