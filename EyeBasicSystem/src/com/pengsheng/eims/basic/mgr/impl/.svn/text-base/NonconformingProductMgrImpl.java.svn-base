package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.NonconformingProductDao;
import com.pengsheng.eims.basic.mgr.NonconformingProductMgr;
import com.pengsheng.eims.basic.persistence.NonconformingProductPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public class NonconformingProductMgrImpl implements NonconformingProductMgr {
	
	private NonconformingProductDao nonconformingProductDao;
    private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	
	public List<NonconformingProductPo> getNonconformingProductMaxList()
	{
		return this.nonconformingProductDao.getNonconformingProductMaxList();
	}
	
	
	public List<NonconformingProductPo> getNonconformingProductList(NonconformingProductPo po,int start, int size)
	{
		return this.nonconformingProductDao.getNonconformingProductList(po, start, size);
	}
	
	public int getNonconformingProductCount(NonconformingProductPo po)  
	{
		return this.nonconformingProductDao.getNonconformingProductCount(po);
	}


	public List<NonconformingProductPo> getNonconformingProductMinList(
			NonconformingProductPo nonconformingProductPo) {
		return this.nonconformingProductDao.getNonconformingProductMinList(nonconformingProductPo);
	}


	public NonconformingProductPo getNonconformingProduct(
			NonconformingProductPo nonconformingProductPo) {
		NonconformingProductPo result = new NonconformingProductPo();
		result = this.nonconformingProductDao.getNonconformingProduct(nonconformingProductPo);
		if(!result.getFnpparented().equals("")){
			NonconformingProductPo tmp = new NonconformingProductPo();
			tmp.setFnpid(result.getFnpparented());
			result.setFnpparentedname(this.nonconformingProductDao.getNonconformingProduct(tmp).getFnpcontent());
		}
		return result;
	}
	
	public void insertNonconformingProduct(
			NonconformingProductPo nonconformingProductPo,LogisticsLogPo logPo) {
		this.nonconformingProductDao.insertNonconformingProduct(nonconformingProductPo);
		logisticsLogDao.insertLog(logPo);
	}

	public void updateNonconformingProduct(
			NonconformingProductPo nonconformingProductPo,LogisticsLogPo logPo) {
		this.nonconformingProductDao.updateNonconformingProduct(nonconformingProductPo);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 添加时判断不合格品现象名称 是否重复
	 * @return
	 */
	public int getNonconformingProductName(NonconformingProductPo nonconformingProductPo)
	{
		return nonconformingProductDao.getNonconformingProductName(nonconformingProductPo);
	}
	/**
	 * 修改时判断不合格品现象名称 是否重复
	 * @return
	 */
	public int getNonconformingProductNameUpdate(NonconformingProductPo nonconformingProductPo) 
	{
		return nonconformingProductDao.getNonconformingProductNameUpdate(nonconformingProductPo);
	}
		
	public void deleteNonconformingProduct(
			NonconformingProductPo nonconformingProductPo,LogisticsLogPo logPo) {
		this.nonconformingProductDao.deleteNonconformingProduct(nonconformingProductPo);
		logisticsLogDao.insertLog(logPo);
	}
	
	public NonconformingProductDao getNonconformingProductDao() {
		return nonconformingProductDao;
	}

	public void setNonconformingProductDao(
			NonconformingProductDao nonconformingProductDao) {
		this.nonconformingProductDao = nonconformingProductDao;
	}
}
