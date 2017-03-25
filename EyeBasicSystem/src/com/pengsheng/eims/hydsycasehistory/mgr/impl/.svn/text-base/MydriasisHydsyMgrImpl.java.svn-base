package com.pengsheng.eims.hydsycasehistory.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.hydsycasehistory.dao.MydriasisHydsyDao;
import com.pengsheng.eims.hydsycasehistory.mgr.MydriasisHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.MydriasisPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.RegisteredPrintDetailsPo;

public class MydriasisHydsyMgrImpl implements MydriasisHydsyMgr{
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private  MydriasisHydsyDao mydriasisHydsyDao;

	public MydriasisHydsyDao getMydriasisHydsyDao() {
		return mydriasisHydsyDao;
	}

	public void setMydriasisHydsyDao(MydriasisHydsyDao mydriasisHydsyDao) {
		this.mydriasisHydsyDao = mydriasisHydsyDao;
	}

	public int getMydriasisCount(MydriasisPo po) {
		
		return mydriasisHydsyDao.getMydriasisCount(po);
	}
	public List<MydriasisPo> getMydriasisList(MydriasisPo po, int start,
			int size) {
		
		return mydriasisHydsyDao.getMydriasisList(po, start, size);
	}
	public void insertMydriasis(MydriasisPo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		mydriasisHydsyDao.insertMydriasis(po);
		
	}
	public MydriasisPo getMydriasis(MydriasisPo po) {
		
		return mydriasisHydsyDao.getMydriasis(po);
	}

	/**
	 * 查询费用提交数量
	 * @param po
	 * @return
	 */
	public int getChargePutCount(RegisteredCategoryPo po) {
		return mydriasisHydsyDao.getChargePutCount(po);
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
		
		return mydriasisHydsyDao.getChargePutList(po, start, size);
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
		
		mydriasisHydsyDao.updateRegisteredCategory(po);
		Iterator<RegisteredPrintDetailsPo> it= list.iterator();
		while(it.hasNext()){
			RegisteredPrintDetailsPo registeredPrintDetailsPo=it.next();
			mydriasisHydsyDao.urpateRegisteredPrintDetails(registeredPrintDetailsPo);
		}
	}

	/**
	 * 修改挂号明细表
	 * @param po
	 */
	public void urpateRegisteredPrintDetails(RegisteredPrintDetailsPo po) {
		mydriasisHydsyDao.urpateRegisteredPrintDetails(po);
	}

	/**
	 * 新增挂号明细表信息
	 * @param po
	 */

	
	public void insertRegisteredDetails(RegisteredDetailsPo po,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		logisticsLogDao.insertLog(logPo);  //新增日志
		mydriasisHydsyDao.insertRegisteredDetails(po);
	}

}
