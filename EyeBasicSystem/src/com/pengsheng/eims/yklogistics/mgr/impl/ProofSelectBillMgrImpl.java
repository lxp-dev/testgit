package com.pengsheng.eims.yklogistics.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.yklogistics.dao.ProofSelectBillDao;
import com.pengsheng.eims.yklogistics.mgr.ProofSelectBillMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public class ProofSelectBillMgrImpl implements ProofSelectBillMgr {

	private ProofSelectBillDao ykproofSelectBillDao;
	
	private List<InventoryEntryPo> goodsList;
	
	public ProofSelectBillDao getYkproofSelectBillDao() {
		return ykproofSelectBillDao;
	}

	public void setYkproofSelectBillDao(ProofSelectBillDao ykproofSelectBillDao) {
		this.ykproofSelectBillDao = ykproofSelectBillDao;
	}

	public List<InventoryEntryPo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<InventoryEntryPo> goodsList) {
		this.goodsList = goodsList;
	}

	/**
	 * 得到业务表信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelectBillCount(InventoryPo inventoryPo) {
		if (!inventoryPo.getCstibilltypeid().equalsIgnoreCase("3")){
			return ykproofSelectBillDao.getSelectBillCount(inventoryPo);
		}else{
			return ykproofSelectBillDao.getSalesBillCount(inventoryPo);
		}
	}

	/**
	 * 查询业务表信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectBill(InventoryPo inventoryPo,
			int start, int size) {
		if (!inventoryPo.getCstibilltypeid().equalsIgnoreCase("3")){
			return ykproofSelectBillDao.selectSelectBill(inventoryPo, start, size);
		}else{
			return ykproofSelectBillDao.selSalesOutStorageBill(inventoryPo, start, size);
		}
	}
	
	
	
	/**
	 * 得到发票信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelectInvoice(InventoryPo inventoryPo) {
		return ykproofSelectBillDao.getSelectInvoice(inventoryPo);
	}
	
	/**
	 * 查询发票信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectInvoice(InventoryPo inventoryPo,int start, int size) {
		return ykproofSelectBillDao.selectSelectInvoice(inventoryPo, start, size);
	}
	
	
	
	/**
	 * 得到冲回信息数量
	 * @param 
	 * @return
	 */
	public int getSelectReversal(InventoryPo inventoryPo) {
		return ykproofSelectBillDao.getSelectReversal(inventoryPo);
	}

	/**
	 * 查询冲回信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectReversal(InventoryPo inventoryPo,int start, int size) {
		return ykproofSelectBillDao.selectSelectReversal(inventoryPo, start, size);
	}
	
	
	

	/**
	 * 详细开窗表头
	 * @param inventoryPo
	 * @return
	 */
	public InventoryPo getBill(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		return ykproofSelectBillDao.getBill(inventoryPo);
	}
	
	/**
	 * 详细发票表头
	 * @param inventoryPo
	 * @return
	 */
	public InventoryPo getInvoice(InventoryPo inventoryPo) {
		return ykproofSelectBillDao.getInvoice(inventoryPo);
	}
	
	/**
	 * 详细冲回表头
	 * @param inventoryPo
	 * @return
	 */
	public InventoryPo getReversal(InventoryPo inventoryPo) {
		return ykproofSelectBillDao.getReversal(inventoryPo);
	}
	
	

	/**
	 * 得到明细商品信息
	 * @param inventoryPo
	 * @return
	 */
	public List<InventoryEntryPo> getBillGoods(String[] bills) {
		// TODO Auto-generated method stub
		List<InventoryEntryPo> billgoodsList = new ArrayList<InventoryEntryPo>();
		
		for (int i = 0; i < bills.length; i++){
			InventoryPo inPo = new InventoryPo();
			
			inPo.setCstibillid(bills[i]);
			
			goodsList = ykproofSelectBillDao.getBillGoods(inPo);
			
			for (InventoryEntryPo billgoodsPo : goodsList) {
				
				billgoodsList.add(billgoodsPo);
				
			}
		}
		
		return billgoodsList;
	}

	/**
	 * 得到发票明细商品信息
	 * @param inventoryPo
	 * @return
	 */
	public List<InventoryEntryPo> getInvoiceGoods(String[] bills) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 得到冲回明细商品信息
	 * @param inventoryPo
	 * @return
	 */
	public List<InventoryEntryPo> getReversalGoods(String[] bills) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	/**
	 * 得到盘盈盘亏总数
	 * 
	 * @param po
	 * @return
	 */
	public int getOveragelossesCount(InventoryPo po) {
		// TODO Auto-generated method stub
		return ykproofSelectBillDao.getOveragelossesCount(po);
	}

	
	/**
	 * 得到盘盈盘亏分页
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getOveragelossesList(InventoryPo po, int start,
			int size) {
		// TODO Auto-generated method stub
		return ykproofSelectBillDao.getOveragelossesList(po, start, size);
	}
	
	/**
	 * 得到盘盈盘亏明细表头
	 * 
	 * @param po
	 * @return
	 */
	public InventoryPo getOveragelosses(InventoryPo po) {
		// TODO Auto-generated method stub
		return ykproofSelectBillDao.getOveragelosses(po);
	}
	
	
	/**
	 * 盘盈盘亏明细总数
	 * 
	 * @param inventoryPo
	 * @return
	 */
	public int getOveragelossesEntryCount(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		return ykproofSelectBillDao.getOveragelossesEntryCount(inventoryPo);
	}
	
	
	/**
	 * 盘盈盘亏明细分页
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryEntryPo> getOveragelossesEntryList(InventoryPo po,
			int start, int size) {
		// TODO Auto-generated method stub
		return ykproofSelectBillDao.getOveragelossesEntryList(po, start, size);
	}

	/**
	 * 得到仓位List
	 * @param warehousePo
	 * @return
	 */
	public List<WarehousePo> getWarehouseList(WarehousePo warehousePo) {
		// TODO Auto-generated method stub
		return ykproofSelectBillDao.getWarehouseList(warehousePo);
	}
	public List<WarehousePo> getWarehouseList(){
		return ykproofSelectBillDao.getWarehouseList();
	}
	
	/**
	 * 详细开窗表体数量
	 * @param inventoryEntryPo
	 * @return
	 */
	public int getBillEntryCount(InventoryEntryPo inventoryEntryPo) {
		// TODO Auto-generated method stub
		return ykproofSelectBillDao.getBillEntryCount(inventoryEntryPo);
	}

	/**
	 * 详细开窗表体
	 * @param inventoryEntryPo
	 * @return
	 */
	public List<InventoryEntryPo> getBillEntry(InventoryEntryPo inventoryEntryPo, int start, int size) {
		// TODO Auto-generated method stub
		return ykproofSelectBillDao.getBillEntry(inventoryEntryPo, start, size);
	}
	public List<InventoryEntryPo> getBillEntry(InventoryEntryPo inventoryEntryPo){
		return ykproofSelectBillDao.getBillEntry(inventoryEntryPo);
	}
	
	/**
	 * 详细发票表体数量
	 * @param inventoryEntryPo
	 * @return
	 */
	public int getInvoiceEntryCount(InventoryEntryPo inventoryEntryPo) {
		// TODO Auto-generated method stub
		return ykproofSelectBillDao.getInvoiceEntryCount(inventoryEntryPo);
	}

	/**
	 * 详细发票表体
	 * @param inventoryEntryPo
	 * @return
	 */
	public List<InventoryEntryPo> getInvoiceEntry(InventoryEntryPo inventoryEntryPo, int start, int size) {
		return ykproofSelectBillDao.getInvoiceEntry(inventoryEntryPo, start, size);
	}
	public List<InventoryEntryPo> getInvoiceEntry(InventoryEntryPo inventoryEntryPo) {
		return ykproofSelectBillDao.getInvoiceEntry(inventoryEntryPo);
	}
	
	/**
	 * 详细冲回表体数量
	 * @param inventoryEntryPo
	 * @return
	 */
	public int getReversalEntryCount(InventoryEntryPo inventoryEntryPo) {
		// TODO Auto-generated method stub
		return ykproofSelectBillDao.getReversalEntryCount(inventoryEntryPo);
	}

	/**
	 * 详细冲回表体
	 * @param inventoryEntryPo
	 * @return
	 */
	public List<InventoryEntryPo> getReversalEntry(InventoryEntryPo inventoryEntryPo, int start, int size) {
		// TODO Auto-generated method stub
		return ykproofSelectBillDao.getReversalEntry(inventoryEntryPo, start, size);
	}
	public List<InventoryEntryPo> getReversalEntry(InventoryEntryPo inventoryEntryPo){
		return ykproofSelectBillDao.getReversalEntry(inventoryEntryPo);
	}
	
}
