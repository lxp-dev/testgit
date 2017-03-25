package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.dao.BillKeyDao;
import com.pengsheng.eims.system.mgr.BillKeyMgr;

public class BillKeyMgrImpl implements BillKeyMgr{
	private BillKeyDao billKeyDao;
	
	/**
	 * 操作中的单据插入锁定
	 * @param id
	 */
	public void insertBill(String id){
		billKeyDao.insertBill(id);
	}
	
	/**
	 * 查询当前单据是否被锁定
	 * @param id
	 * @return
	 */
	public int selectBill(String id){
		return billKeyDao.selectBill(id);
	}
	
	/**
	 * 单据操作完成后删除锁表记录
	 * @param id
	 */
	public void deleteBill(String id){
		billKeyDao.deleteBill(id);
	}

	public BillKeyDao getBillKeyDao() {
		return billKeyDao;
	}

	public void setBillKeyDao(BillKeyDao billKeyDao) {
		this.billKeyDao = billKeyDao;
	}
	
	/**
	 * 判断业务单据是否被审核  1、审核 0、未审核
	 * @param id
	 * @return
	 */
	public int selectInventoryForAuditType(String id){
		return billKeyDao.selectInventoryForAuditType(id);
	}
	
	/**
	 * 判断采购订单是否重复收货  1、已收货 0、未收货
	 * @param id
	 * @return
	 */
	public int selectProcurementOrderForType(String id){
		return billKeyDao.selectProcurementOrderForType(id);
	}
	
	/**
	 * 判断在途状态是否存在
	 * @param id
	 * @return
	 */
	public int selectProcurementOrderForType(String intransit,String id){
		return billKeyDao.selectProcurementOrderForType(intransit,id);
	}
	
	/**
	 * 判断领用单据是否被审核  1、审核 0、未审核
	 * @param id
	 * @return
	 */
	public int selectTakeInventoryForAuditType(String id){
		return billKeyDao.selectTakeInventoryForAuditType(id);
	}
	
	/**
	 * 判断批发单据是否被审核  1、审核 0、未审核
	 * @param id
	 * @return
	 */
	public int selectTracForAuditType(String id){
		return billKeyDao.selectTracForAuditType(id);
	}
	
	/**
	 * 判断是否存在同类型的未处理的盈亏单
	 * @param id
	 * @return
	 */
	public int selectSCIorSCOForAuditType(String id, String categoryid, String stockid){
		return billKeyDao.selectSCIorSCOForAuditType(id, categoryid, stockid);
	}
	
	/**
	 * 判断配镜单是否做过委外订单
	 * @param id
	 * @return
	 */
	public int selectOrdersForSalesBill(String id) {
		return billKeyDao.selectOrdersForSalesBill(id);
	}
	
	/**
	 * 判断调拨单是否已配送
	 * @param id
	 * @return
	 */
	public int selectAllocationIsSend(String billid){
		return billKeyDao.selectAllocationIsSend(billid);
	}
}
