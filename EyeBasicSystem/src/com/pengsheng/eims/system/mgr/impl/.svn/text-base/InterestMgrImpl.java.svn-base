package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.InterestDao;
import com.pengsheng.eims.system.mgr.InterestMgr;
import com.pengsheng.eims.system.persistence.InterestPo;


/**
 * InterestMgr 兴趣爱好Mgr
 * 
 * @author InterestPo
 * @version 1.0
 * @see InterestMgr
 */
public class InterestMgrImpl implements InterestMgr {

	//兴趣爱好Dao
	public InterestDao interestDao;
	public InterestDao getInterestDao() {
		return interestDao;
	}

	public void setInterestDao(InterestDao interestDao) {
		this.interestDao = interestDao;
	}

	private LogisticsLogDao logisticsLogDao = null;
	

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	/**
	 * 删除兴趣爱好
	 * 
	 * @param po 兴趣爱好po
	 * @return void
	 */
	public void deleteInterest(InterestPo po,LogisticsLogPo logPo) {
		interestDao.deleteInterest(po);		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 兴趣爱好数量
	 */
	public int getInterestCount(InterestPo po) {
		return interestDao.getInterestCount(po);
	}

	/**
	 * 查询兴趣爱好ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getInterestId(InterestPo po) {
		return interestDao.getInterestId(po);
	}
	/**
	 * 添加时查询兴趣爱好名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getInterestName(InterestPo po) 
	{
		return interestDao.getInterestName(po);
	}
	/**
	 * 修改时查询兴趣爱好名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getInterestNameUpdate(InterestPo po) 
	{
		return interestDao.getInterestNameUpdate(po);
	}
	
	
	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 兴趣爱好结果集
	 */
	public List getInterestList(InterestPo po, int start, int size) {
		return interestDao.getInterestList(po, start, size);
	}

	/**
	 * 新增兴趣爱好
	 * 
	 * @param po 兴趣爱好po
	 * @return void
	 */
	public void insertInterest(InterestPo po,LogisticsLogPo logPo) {
		interestDao.insertInterest(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 修改兴趣爱好
	 * 
	 * @param po 兴趣爱好po
	 * @return void
	 */
	public void updateInterest(InterestPo po,LogisticsLogPo logPo) {
		interestDao.updateInterest(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 查询兴趣爱好在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getInterestWithGoods(InterestPo po){
		return interestDao.getInterestWithGoods(po);
	}

	
	/**
	 * 查询兴趣爱好的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 兴趣爱好详细信息
	 */
	public InterestPo getInterestPo(InterestPo po) {
		return interestDao.getInterestPo(po);
	}
   
	public List getInterestList() {
		
		return interestDao.getInterestList();
	}

}
