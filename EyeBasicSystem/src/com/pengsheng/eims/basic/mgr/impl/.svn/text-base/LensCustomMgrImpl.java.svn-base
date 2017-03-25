package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.LensCustomDao;
import com.pengsheng.eims.basic.mgr.LensCustomMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
/**
 * 订做镜片mgr 实现类
 */
public class LensCustomMgrImpl implements LensCustomMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private LensCustomDao lensCustomDao;

	public LensCustomDao getLensCustomDao() {
		return lensCustomDao;
	}

	public void setLensCustomDao(LensCustomDao lensCustomDao) {
		this.lensCustomDao = lensCustomDao;
	}
	/**
	 * 删除订做镜片
	 * 
	 * @param po
	 */
	public void deleteLensCustom(GoodsInfoPo po,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		lensCustomDao.deleteLensCustom(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	/**
	 * 取订做镜片PO
	 * 
	 * @param po
	 * @return
	 */
	public GoodsInfoPo getLensCustom(GoodsInfoPo po) {
		return lensCustomDao.getLensCustom(po);
	}
	/**
	 * 订做镜片数量
	 * 
	 * @param goodsInfoPo
	 * @return
	 */
	public int getLensCustomCount(GoodsInfoPo goodsInfoPo) {
		return lensCustomDao.getLensCustomCount(goodsInfoPo);
	}
	/**
	 * 订做镜片
	 * 
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> getLensCustomList(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		return lensCustomDao.getLensCustomList(goodsInfoPo, start, size);
	}
	/**
	 * 新增订做镜片
	 * 
	 * @param po
	 */
	public void insertLensCustom(GoodsInfoPo po,LogisticsLogPo logPo) {
		lensCustomDao.insertLensCustom(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	/**
	 * 停用
	 * 
	 * @param po
	 */
	public void updateLendsCustomDisable(GoodsInfoPo po,LogisticsLogPo logPo) {
		lensCustomDao.updateLendsCustomDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	/**
	 * 更新订做镜片
	 * 
	 * @param po
	 */
	public void updateLensCustom(GoodsInfoPo po,LogisticsLogPo logPo) {
		lensCustomDao.updateLensCustom(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

}
