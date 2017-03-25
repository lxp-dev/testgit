package com.pengsheng.eims.storage.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.dao.SupplierDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.storage.mgr.ProcurementOrdersMgr;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersEntryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;


public class ProcurementOrdersMgrImpl implements ProcurementOrdersMgr {
	
	private LogisticsLogDao logisticsLogDao;

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private ProcurementOrdersDao procurementOrdersDao;

	private SupplierDao supplierDao;

	public ProcurementOrdersDao getProcurementOrdersDao() {
		return procurementOrdersDao;
	}

	public void setProcurementOrdersDao(
			ProcurementOrdersDao procurementOrdersDao) {
		this.procurementOrdersDao = procurementOrdersDao;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		// TODO Auto-generated method stub
		return procurementOrdersDao.getGoodsCategorys();
	}

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	public void insertProcurementOrdersEntry(
			ProcurementOrdersEntryPo procurementOrdersEntryPo) {
		// TODO Auto-generated method stub
		procurementOrdersDao
				.insertProcurementOrdersEntry(procurementOrdersEntryPo);
	}

	public void insertProcurementOrders(ProcurementOrdersPo procurementOrdersPo) {
		// TODO Auto-generated method stub
		procurementOrdersDao.insertProcurementOrders(procurementOrdersPo);
	}

	public void insertPOs(ProcurementOrdersPo procurementOrdersPo,
			List<ProcurementOrdersEntryPo> procurementOrdersEntrys,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub

		if (procurementOrdersPo.getCstpgoodscategory().matches("^[123456]$")) {
			procurementOrdersPo.setCstpbilltypeid("P");
		} else {
			procurementOrdersPo.setCstpbilltypeid("Q");
		}

		procurementOrdersDao.insertProcurementOrders(procurementOrdersPo);
		
		if("1".equals(procurementOrdersPo.getCstpauditstate()))
		{
			if(!"".equals(procurementOrdersPo.getCshaaabillid()))
			{
				procurementOrdersDao.updateProcurementOrdersStatus(procurementOrdersPo);
				procurementOrdersDao.insertProcurementApplyStatus(procurementOrdersPo);
			}else
			{
				procurementOrdersDao.insertProcurementOrdersStatus(procurementOrdersPo);
			}
		}

		for (ProcurementOrdersEntryPo procurementOrdersEntryPo : procurementOrdersEntrys) {

			procurementOrdersEntryPo.setCstpepurchaseorderid(procurementOrdersPo.getCstpid());
			procurementOrdersDao.insertProcurementOrdersEntry(procurementOrdersEntryPo);
		}


		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public int getProcurementOroderCount(ProcurementOrdersPo procurementOrdersPo) {
		return procurementOrdersDao.getProcurementOroderCount(procurementOrdersPo);
	}

	public List<ProcurementOrdersPo> getProcurementOroderList(ProcurementOrdersPo procurementOrdersPo, int start, int size) {
		return procurementOrdersDao.getProcurementOroderList(procurementOrdersPo, start, size);
	}

	public void delProcurementOrders(String id,LogisticsLogPo logPo) {
		procurementOrdersDao.delProcurementOrders(id);
		procurementOrdersDao.delProcurementOrdersEntry(id);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public ProcurementOrdersPo getProcurementOrders(
			ProcurementOrdersPo procurementOrdersPo) {
		return procurementOrdersDao.getProcurementOrders(procurementOrdersPo);
	}

	public List<ProcurementOrdersEntryPo> getProcurementOrdersEntryList(
			ProcurementOrdersEntryPo procurementOrdersEntryPo) {
		return procurementOrdersDao.getProcurementOrdersEntryList(procurementOrdersEntryPo);
	}
	
	public List<ProcurementOrdersEntryPo> getProcurementOrdersApplyList(ProcurementOrdersPo po)
	{
		return procurementOrdersDao.getProcurementOrdersEntryApplyList(po);
	}

	public void updatePOs(ProcurementOrdersPo procurementOrdersPo,
			List<ProcurementOrdersEntryPo> procurementOrdersEntrys,LogisticsLogPo logPo) {

		/**
		 * 删除订单明细
		 */
		procurementOrdersDao.delProcurementOrdersEntry(procurementOrdersPo
				.getCstpid());

		/**
		 * 更新订单主表
		 */
		procurementOrdersDao.updateProcurementOrders(procurementOrdersPo);
		
		if("1".equals(procurementOrdersPo.getCstpauditstate()))
		{
			if(!"".equals(procurementOrdersPo.getCshaaabillid()))
			{
				procurementOrdersDao.updateProcurementOrdersStatus(procurementOrdersPo);
				procurementOrdersDao.insertProcurementApplyStatus(procurementOrdersPo);
			}
			else
			{
				procurementOrdersDao.insertProcurementOrdersStatus(procurementOrdersPo);
			}
		}

		/**
		 * 更新订单明细
		 */
		for (ProcurementOrdersEntryPo procurementOrdersEntryPo : procurementOrdersEntrys) {

			procurementOrdersEntryPo
					.setCstpepurchaseorderid(procurementOrdersPo.getCstpid());
			procurementOrdersDao.insertProcurementOrdersEntry(procurementOrdersEntryPo);
		}

		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public List<GoodsInfoPo> selectDimensionPos(List<String> goodsids,List<String> vs){
		List<GoodsInfoPo> goodsInfoPos = new ArrayList<GoodsInfoPo>();
		for(int i=0; i<goodsids.size(); i++){
			GoodsInfoPo po = new GoodsInfoPo();
			po = procurementOrdersDao.selectDimensionPo(goodsids.get(i), vs.get(i));
			goodsInfoPos.add(po);
		}
		return goodsInfoPos;
	}
	
	
	public List<GoodsInfoPo> selectDimensionPos(List<String> goodsids,
			List<String> vs, String billID) {
		List<GoodsInfoPo> goodsInfoPos = new ArrayList<GoodsInfoPo>();
		for(int i=0; i<goodsids.size(); i++){
			GoodsInfoPo po = new GoodsInfoPo();
			po = procurementOrdersDao.selectDimensionPo(goodsids.get(i), vs.get(i),billID);
			goodsInfoPos.add(po);
		}
		return goodsInfoPos;
	}
	
	/**
	 * 得到订单中所有的品种
	 */
	public List<GoodsInfoPo> getProBrand(String billID){
		return procurementOrdersDao.getProBrand(billID);
	}
	
}
