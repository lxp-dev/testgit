package com.pengsheng.eims.sales.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.MydriasisDao;
import com.pengsheng.eims.sales.mgr.MydriasisMgr;
import com.pengsheng.eims.sales.persistence.MydriasisPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.RegisteredPrintDetailsPo;

public class MydriasisMgrImpl implements MydriasisMgr{
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private  MydriasisDao mydriasisDao;

	public MydriasisDao getMydriasisDao() {
		return mydriasisDao;
	}

	public void setMydriasisDao(MydriasisDao mydriasisDao) {
		this.mydriasisDao = mydriasisDao;
	}
	
	public int getMydriasisCount(MydriasisPo po) {
		
		return mydriasisDao.getMydriasisCount(po);
	}
	public List<MydriasisPo> getMydriasisList(MydriasisPo po, int start,
			int size) {
		
		return mydriasisDao.getMydriasisList(po, start, size);
	}
	public void insertMydriasis(MydriasisPo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		mydriasisDao.insertMydriasis(po);
		
	}
	public MydriasisPo getMydriasis(MydriasisPo po) {
		
		return mydriasisDao.getMydriasis(po);
	}

	/**
	 * 查询费用提交数量
	 * @param po
	 * @return
	 */
	public int getChargePutCount(RegisteredCategoryPo po) {
		return mydriasisDao.getChargePutCount(po);
	}

	/**
	 * 显示费用提交信息并分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<RegisteredCategoryPo> getChargePutList(RegisteredCategoryPo po,
			int start, int size) {
		
		return mydriasisDao.getChargePutList(po, start, size);
	}



	/**
	 * 根据条件查询
	 * @param po
	 * @return
	 */
	public RegisteredCategoryPo getChargePut(RegisteredCategoryPo po) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * 修改挂号类别表
	 * @param po
	 */
	public void updateRegisteredCategory(RegisteredCategoryPo po,List<RegisteredPrintDetailsPo> list) {
		
		mydriasisDao.updateRegisteredCategory(po);
		Iterator<RegisteredPrintDetailsPo> it= list.iterator();
		while(it.hasNext()){
			RegisteredPrintDetailsPo registeredPrintDetailsPo=it.next();
			mydriasisDao.urpateRegisteredPrintDetails(registeredPrintDetailsPo);
		}
	}

	/**
	 * 修改挂号明细表
	 * @param po
	 */
	public void urpateRegisteredPrintDetails(RegisteredPrintDetailsPo po) {
		mydriasisDao.urpateRegisteredPrintDetails(po);
	}

	/**
	 * 新增挂号明细表信息
	 * @param po
	 */

	
	public void insertRegisteredDetails(RegisteredDetailsPo po,LogisticsLogPo logPo) {
		 
		logisticsLogDao.insertLog(logPo);  //新增日志
		mydriasisDao.insertRegisteredDetails(po);
		mydriasisDao.insertRegisteredDetailslog(po);
	}

	 /**
	  * 查询没有维护的收费项目
	  */
	public int getNoTollType() {
		 
		return mydriasisDao.getNoTollType();
	}

 
	public List<RegisteredDetailsPo> getRegisteredList(RegisteredDetailsPo po, int start, int pageSize) {
		return mydriasisDao.getRegisteredList(po ,start,  pageSize);
	}

	
	public int getRegisteredCount(RegisteredDetailsPo po) {
		 
		return mydriasisDao.getRegisteredCount(po);
	}

	 
}
