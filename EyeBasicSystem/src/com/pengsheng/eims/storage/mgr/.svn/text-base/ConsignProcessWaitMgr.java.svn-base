package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;

public interface ConsignProcessWaitMgr {

	/**
	 * 委外查询表体信息  分页
	 * @param consignProcessOrderPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderPo> getConsignProcessOrderList(ConsignProcessOrderPo consignProcessOrderPo , int start , int size);
	
	/**
	 * 委外信息数量
	 * @param consignProcessOrderPo
	 * @return
	 */
	public int getConsignProcessOrderCount(ConsignProcessOrderPo consignProcessOrderPo);
	
	/**
	 * 委外商品详细信息 分页  更新页面表体
	 * @param consignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderDetailsList(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo , int start , int size);
	
	/**
	 * 委外商品详细信息数量
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public int getConsignProcessOrderDetailsCount(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);
	
	/**
	 * 主表(委外收货主表)中插入表头的信息   ConsignProcessReceiptPo
	 * 从表(委外收货明细表)中插入表体的信息   List<ConsignProcessReceiptDetailsPo>
	 * @param consignProcessReceiptPo
	 * @param list
	 */
	public void insertConsignProcessWaitAll(ConsignProcessReceiptPo consignProcessReceiptPo , List<ConsignProcessReceiptDetailsPo> list);
}
