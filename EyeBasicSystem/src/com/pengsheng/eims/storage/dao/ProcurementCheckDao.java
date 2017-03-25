package com.pengsheng.eims.storage.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementCheckPo;
import com.pengsheng.eims.util.tools.Utility;

public interface ProcurementCheckDao {
	public List<ProcurementCheckPo> getProcurementCheckReceiptList(ProcurementCheckPo procurementCheckPo);
	
	/**
	 * 获取非镜片采购收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getProcurementCheckReceiptList(InventoryPo po,int start, int size);
	
	public int getProcurementCheckReceiptCount(InventoryPo po);
	
	/**
	 * 获取镜片采购收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getProcurementCheckGlassReceiptList(InventoryPo po,int start, int size);
	
	public int getProcurementCheckReceiptGlassCount(InventoryPo po);
	
	/**
	 * 插入收货检验主表
	 * @param po
	 */
	public void insertProcurementCheck(ProcurementCheckPo po);
	
	/**
	 * 插入收货检验明细表
	 * @param po
	 */
	public void insertProcurementCheckEntry(ProcurementCheckPo po);
	
	
	/**
	 * 获取收货检验的Count
	 * @param po
	 * @return
	 */
	public int getProcurementCheckCount(ProcurementCheckPo po);
	
	/**
	 * 获取收货检验的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<ProcurementCheckPo> getProcurementCheckList(ProcurementCheckPo po, int start, int size);
	
	/**
	 * 获取收货检验的详细
	 * @param po
	 * @return
	 */
	public List<ProcurementCheckPo> getProcurementCheckDetails(ProcurementCheckPo po);
	
	/**
	 * 获取收货检验的详细
	 * @param po
	 * @return
	 */
	public ProcurementCheckPo getProcurementCheckDetailsByPin(ProcurementCheckPo po);
}
