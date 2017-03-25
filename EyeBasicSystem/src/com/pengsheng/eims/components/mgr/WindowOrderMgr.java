package com.pengsheng.eims.components.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;

/**
 * 订单开窗mgr接口
 */
public interface WindowOrderMgr {
	/**
	 * 采购订单的未核销商品数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getProcurementOrdersCount(ProcurementOrdersPo po);

	/**
	 * 采购订单的未核销商品list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getProcurementOrdersList(ProcurementOrdersPo po,
			int start, int size);

	/**
	 * 未核销的采购订单数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getProcurementOrdersForCount(ProcurementOrdersPo po);
	
	public int getProcurementOrdersForyxCount(ProcurementOrdersPo po); //隐形订单
	
	public int getProcurementOrdersForCount1(ProcurementOrdersPo po);
	
	public int getProcurementOrdersForyxCount1(ProcurementOrdersPo po); //隐形已核销订单

	/**
	 * 未核销的采购订单list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<ProcurementOrdersPo> getProcurementOrdersForList(ProcurementOrdersPo po, int start, int size);
	
	public List<ProcurementOrdersPo> getProcurementOrdersForyxList(ProcurementOrdersPo po, int start, int size); //隐形订单
	
	public List<ProcurementOrdersPo> getProcurementOrdersForList1(ProcurementOrdersPo po, int start, int size);
	
	public List<ProcurementOrdersPo> getProcurementOrdersForyxList1(ProcurementOrdersPo po, int start, int size); //隐形已核销订单

	/**
	 * 委外订单的未核销商品数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getConsignProcessOrderCount(ConsignProcessOrderPo po);

	/**
	 * 委外订单的未核销商品list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getConsignProcessOrderList(
			ConsignProcessOrderPo po, int start, int size);

	/**
	 * 未核销的委外订单数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getConsignProcessOrderForCount(ConsignProcessOrderPo po);

	/**
	 * 未核销的委外订单list
	 * 
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<ConsignProcessOrderPo> getConsignProcessOrderForList(
			ConsignProcessOrderPo po, int start, int size);

	/**
	 * 取订单系统发货单已发货
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getInvoiceForCount(ProcurementOrdersPo po);

	/**
	 * 未核销的采购订单list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<ProcurementOrdersPo> getInvoiceForList(ProcurementOrdersPo po,
			int start, int size);
}
