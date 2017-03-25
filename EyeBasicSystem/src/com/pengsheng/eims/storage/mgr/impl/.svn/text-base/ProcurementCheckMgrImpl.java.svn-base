package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.storage.dao.ProcurementCheckDao;
import com.pengsheng.eims.storage.mgr.ProcurementCheckMgr;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementCheckPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersEntryPo;

public class ProcurementCheckMgrImpl implements ProcurementCheckMgr{
	
	private ProcurementCheckDao procurementCheckDao;

	public ProcurementCheckDao getProcurementCheckDao() {
		return procurementCheckDao;
	}

	public void setProcurementCheckDao(ProcurementCheckDao procurementCheckDao) {
		this.procurementCheckDao = procurementCheckDao;
	} 
	
	/**
	 * 查询采购收货商品信息
	 * @param procurementCheckPo
	 * @return
	 */
	public List<ProcurementCheckPo> getProcurementCheckReceiptList(ProcurementCheckPo procurementCheckPo){
		return procurementCheckDao.getProcurementCheckReceiptList(procurementCheckPo);
	}
	
	/**
	 * 获取非镜片采购收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getProcurementCheckReceiptList(InventoryPo po,int start, int size){
		return procurementCheckDao.getProcurementCheckReceiptList(po,start,size);
	}
	
	public int getProcurementCheckReceiptCount(InventoryPo po){
		return procurementCheckDao.getProcurementCheckReceiptCount(po);
	}
	
	/**
	 * 获取镜片采购收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getProcurementCheckGlassReceiptList(InventoryPo po,int start, int size){
		return procurementCheckDao.getProcurementCheckGlassReceiptList(po,start,size);
	}
	public int getProcurementCheckReceiptGlassCount(InventoryPo po){
		return procurementCheckDao.getProcurementCheckReceiptGlassCount(po);
	}
	
	/**
	 * 插入收货检验
	 * @param po
	 */
	public void insertProcurementCheck(ProcurementCheckPo po){
		procurementCheckDao.insertProcurementCheck(po);
	}
	
	/**
	 * 插入收货检验明细表
	 * @param po
	 */
	public void insertProcurementCheck(ProcurementCheckPo po,List<ProcurementCheckPo> pos){
		procurementCheckDao.insertProcurementCheck(po);
		
		for (ProcurementCheckPo poentry : pos) {
			procurementCheckDao.insertProcurementCheckEntry(poentry);
		}
	}
	
	/**
	 * 获取收货检验的Count
	 * @param po
	 * @return
	 */
	public int getProcurementCheckCount(ProcurementCheckPo po){
		return procurementCheckDao.getProcurementCheckCount(po);
	}
	
	/**
	 * 获取收货检验的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<ProcurementCheckPo> getProcurementCheckList(ProcurementCheckPo po, int start, int size){
		return procurementCheckDao.getProcurementCheckList(po, start, size);
	}
	
	
	/**
	 * 获取收货检验的详细
	 * @param po
	 * @return
	 */
	public List<ProcurementCheckPo> getProcurementCheckDetails(ProcurementCheckPo po){
		return procurementCheckDao.getProcurementCheckDetails(po);
	}

	
	/**
	 * 获取收货检验的详细
	 * @param po
	 * @return
	 */
	public ProcurementCheckPo getProcurementCheckDetailsByPin(ProcurementCheckPo po){
		return procurementCheckDao.getProcurementCheckDetailsByPin(po);
	}
}
