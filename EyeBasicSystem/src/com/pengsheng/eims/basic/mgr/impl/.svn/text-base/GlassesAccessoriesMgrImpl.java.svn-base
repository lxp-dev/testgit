package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.GlassesAccessoriesDao;
import com.pengsheng.eims.basic.mgr.GlassesAccessoriesMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
/**
 * 配件类mgr 实现类
 */
public class GlassesAccessoriesMgrImpl implements GlassesAccessoriesMgr {

	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	private GlassesAccessoriesDao glassesAccessoriesDao;
	
	public GlassesAccessoriesDao getGlassesAccessoriesDao() {
		return glassesAccessoriesDao;
	}

	public void setGlassesAccessoriesDao(GlassesAccessoriesDao glassesAccessoriesDao) {
		this.glassesAccessoriesDao = glassesAccessoriesDao;
	}
	/**
	 * 获取配件类数量
	 * @param po 商品po
	 * @return int 数量
	 */
	public int getGlassesAccessoriesCount(GoodsInfoPo po) {
		return glassesAccessoriesDao.getGlassesAccessoriesCount(po);
	}
	/**
	 * 获取配件类list
	 * @param po 商品po
	 * @param start
	 * @param size
	 * @return list 镜架list
	 */	
	public List<GoodsInfoPo> getGlassesAccessoriesList(GoodsInfoPo po,int start, int size) {
		return glassesAccessoriesDao.getGlassesAccessoriesList(po, start, size);
	}
	/**
	 * 新增配件类
	 * @param po 商品po
	 */	
	public void insertGlassesAccessories(GoodsInfoPo po,LogisticsLogPo logPo) {
		glassesAccessoriesDao.insertGlassesAccessories(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	/**
	 * 修改配件类
	 * @param po 商品po
	 */
	public void updateGlassesAccessories(GoodsInfoPo po,LogisticsLogPo logPo) {

		glassesAccessoriesDao.updateGlassesAccessories(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	/**
	 * 获取配件类po
	 * @param po 商品po
	 * @return po 商品po
	 */
	public GoodsInfoPo getGlassesAccessories(GoodsInfoPo po) {
		return glassesAccessoriesDao.getGlassesAccessories(po);
	}
	/**
	 * 修改配件类的停用/启用状态
	 * @param po 商品po
	 */	
	public void updateGlassesAccessoriesDisable(GoodsInfoPo po,LogisticsLogPo logPo) {

		glassesAccessoriesDao.updateGlassesAccessoriesDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	/**
	 * 删除配件类
	 * @param po 商品po
	 */	
	public void deleteGlassesAccessories(GoodsInfoPo po,LogisticsLogPo logPo) {

		glassesAccessoriesDao.deleteGlassesAccessories(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	
}
