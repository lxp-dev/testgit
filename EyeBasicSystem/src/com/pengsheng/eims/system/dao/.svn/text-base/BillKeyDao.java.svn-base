package com.pengsheng.eims.system.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.SalesDetailPo;

public interface BillKeyDao {
	
	/**
	 * 操作中的单据插入锁定
	 * @param id
	 */
	public void insertBill(String id);
	
	/**
	 * 查询当前单据是否被锁定
	 * @param id
	 * @return
	 */
	public int selectBill(String id);
	
	/**
	 * 单据操作完成后删除锁表记录
	 * @param id
	 */
	public void deleteBill(String id);
	
	/**
	 * 判断业务单据是否被审核  1、审核 0、未审核
	 * @param id
	 * @return
	 */
	public int selectInventoryForAuditType(String id);
	
	/**
	 * 判断采购订单是否重复收货  1、已收货 0、未收货
	 * @param id
	 * @return
	 */
	public int selectProcurementOrderForType(String id);
	
	/**
	 * 判断在途状态是否存在
	 * @param id
	 * @return
	 */
	public int selectProcurementOrderForType(String intransit,String id);
	
	/**
	 * 判断领用单据是否被审核  1、审核 0、未审核
	 * @param id
	 * @return
	 */
	public int selectTakeInventoryForAuditType(String id);
	
	/**
	 * 判断批发单据是否被审核  1、审核 0、未审核
	 * @param id
	 * @return
	 */
	public int selectTracForAuditType(String id);
	
	/**
	 * 判断是否存在同类型的未处理的盈亏单
	 * @param id
	 * @return
	 */
	public int selectSCIorSCOForAuditType(String id, String categoryid, String stockid);
	
	/**
	 * 判断配镜单是否做过委外订单
	 * @param id
	 * @return
	 */
	public int selectOrdersForSalesBill(String id);
	
	/**
	 * 判断调拨单是否已配送
	 * @param id
	 * @return
	 */
	public int selectAllocationIsSend(String billid);
	
	/**
	 * 委外收货后判断配送库存
	 * @param po
	 * @return
	 */
	public int selectConsignProcessIsSend(SalesDetailPo po);
	
	/**
	 * 取镜处取镜(按销售单号获取商品信息)
	 * @param po
	 * @return
	 */
	public List<SalesDetailPo> selectTakeGlassListForSalesID(SalesDetailPo po);
	
	/**
	 * 取镜处判断库存
	 * @param po
	 * @return
	 */
	public int selectTakeGlassIsSend(SalesDetailPo po);
}
