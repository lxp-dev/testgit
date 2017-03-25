package com.pengsheng.eims.logistics.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.logistics.dao.InvoiceSelectBillDao;
import com.pengsheng.eims.logistics.mgr.InvoiceSelectBillMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.tools.Utility;

public class InvoiceSelectBillMgrImpl implements InvoiceSelectBillMgr {

	private InvoiceSelectBillDao invoiceSelectBillDao;

	public InvoiceSelectBillDao getInvoiceSelectBillDao() {
		return invoiceSelectBillDao;
	}

	public void setInvoiceSelectBillDao(InvoiceSelectBillDao invoiceSelectBillDao) {
		this.invoiceSelectBillDao = invoiceSelectBillDao;
	}

	/**
	 * 得到业务表信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelectBillCount(InventoryPo inventoryPo) {
		return invoiceSelectBillDao.getSelectBillCount(inventoryPo);
	}
	public int getSelBillCount(InventoryPo inventoryPo) {
		return invoiceSelectBillDao.getSelBillCount(inventoryPo);
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
		return invoiceSelectBillDao.selectSelectBill(inventoryPo, start, size);
	}
	public List<InventoryPo> selSelectBill(InventoryPo inventoryPo,
			int start, int size) {
		return invoiceSelectBillDao.selSelectBill(inventoryPo, start, size);
	}
	/**
	 * 查询业务表信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectBill(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		return invoiceSelectBillDao.selectSelectBill(inventoryPo);
	}
	
	/**
	 * 单据查询中查看单据基本信息
	 */
	public InventoryPo getBill(InventoryPo inventoryPo) {
		return invoiceSelectBillDao.getBill(inventoryPo);
	}

	/**
	 * 单据查询中查看单据明细信息
	 */
	public List<InventoryEntryPo> getBillEntry(InventoryEntryPo inventoryEntryPo) {
		return invoiceSelectBillDao.getBillEntry(inventoryEntryPo);
	}

	/**
	 * 得到明细商品信息
	 * @param inventoryPo
	 * @return
	 */
	public List<InventoryEntryPo> getBillGoods(List<InventoryEntryPo> inventoryEntryList,String[] bills,String invoiceType) {
		if (inventoryEntryList == null){
			inventoryEntryList = new ArrayList<InventoryEntryPo>();
		}
		for (int i = 0; i < bills.length; i++){
			InventoryPo inPo = new InventoryPo();			
			inPo.setCstibillid(bills[i]);
			inPo.setInvoiceType(invoiceType);
			
			List<InventoryEntryPo> billgoodsList = invoiceSelectBillDao.getBillGoods(inPo);
			
			for (InventoryEntryPo billgoodsPo : billgoodsList) {
				if (!billgoodsPo.getCstiegoodsquantity().equals("0")){ //过滤数量为0的商品
					if (inventoryEntryList.size() != 0){
						if (inventoryEntryList.get(0).getCstiebilltypeid().equalsIgnoreCase(billgoodsPo.getCstiebilltypeid())){
							inventoryEntryList.add(billgoodsPo);
						}					
					}else{
						inventoryEntryList.add(billgoodsPo);
					}
				}		
			}
		}		
		return inventoryEntryList;
	}
	
	public InventoryPo getBillSum(InventoryPo inventoryPo){	
		return invoiceSelectBillDao.getBillSum(inventoryPo);
	}

	public int getSelectGoodsCount(InventoryPo inventoryPo) {
		return invoiceSelectBillDao.getSelectGoodsCount(inventoryPo);
	}
	
	public List<InventoryEntryPo> selectSelectGoods(InventoryPo inventoryPo,
			int start, int size) {
		return invoiceSelectBillDao.selectSelectGoods(inventoryPo, start, size);
	}
}
