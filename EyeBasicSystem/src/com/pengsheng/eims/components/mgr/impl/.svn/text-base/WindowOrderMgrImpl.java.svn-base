package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.WindowOrderDao;
import com.pengsheng.eims.components.mgr.WindowOrderMgr;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;

/**
 * 订单开窗mgr实现类
 */
public class WindowOrderMgrImpl implements WindowOrderMgr {

	private WindowOrderDao windowOrderDao;

	public WindowOrderDao getWindowOrderDao() {
		return windowOrderDao;
	}

	public void setWindowOrderDao(WindowOrderDao windowOrderDao) {
		this.windowOrderDao = windowOrderDao;
	}

	private ProcurementReceiptDao procurementReceiptDao;

	public ProcurementReceiptDao getProcurementReceiptDao() {
		return procurementReceiptDao;
	}

	public void setProcurementReceiptDao(
			ProcurementReceiptDao procurementReceiptDao) {
		this.procurementReceiptDao = procurementReceiptDao;
	}

	/**
	 * 采购订单的未核销商品数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getProcurementOrdersCount(ProcurementOrdersPo po) {

		return windowOrderDao.getProcurementOrdersCount(po);
	}

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
			int start, int size) {
		List<GoodsInfoPo> goodsList = windowOrderDao.getProcurementOrdersList(
				po, start, size);
		for (int i = 0; i < goodsList.size(); i++) {
			GoodsInfoPo goodsInfoPo = goodsList.get(i);
			String pcBarcode = procurementReceiptDao
					.getGoodsBarCode(goodsInfoPo.getBgigoodsbarcode());
			goodsInfoPo.setBgipcbarcode(pcBarcode);
		}
		return goodsList;
	}

	/**
	 * 未核销的采购订单数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getProcurementOrdersForCount(ProcurementOrdersPo po) {

		return windowOrderDao.getProcurementOrdersForCount(po);
	}
	
	public int getProcurementOrdersForyxCount(ProcurementOrdersPo po) {

		return windowOrderDao.getProcurementOrdersForyxCount(po);
	}
	
	public int getProcurementOrdersForCount1(ProcurementOrdersPo po) {

		return windowOrderDao.getProcurementOrdersForCount1(po);
	}
	
	public int getProcurementOrdersForyxCount1(ProcurementOrdersPo po) {

		return windowOrderDao.getProcurementOrdersForyxCount1(po);
	}

	/**
	 * 未核销的采购订单list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<ProcurementOrdersPo> getProcurementOrdersForList(
			ProcurementOrdersPo po, int start, int size) {

		return windowOrderDao.getProcurementOrdersForList(po, start, size);
	}
	
	public List<ProcurementOrdersPo> getProcurementOrdersForyxList(
			ProcurementOrdersPo po, int start, int size) {

		return windowOrderDao.getProcurementOrdersForyxList(po, start, size);
	}
	
	public List<ProcurementOrdersPo> getProcurementOrdersForList1(
			ProcurementOrdersPo po, int start, int size) {

		return windowOrderDao.getProcurementOrdersForList1(po, start, size);
	}
	
	public List<ProcurementOrdersPo> getProcurementOrdersForyxList1(
			ProcurementOrdersPo po, int start, int size) {

		return windowOrderDao.getProcurementOrdersForyxList1(po, start, size);
	}

	/**
	 * 委外订单的未核销商品数量
	 * 
	 * @param po
	 *            订单po
	 * @return int 数量
	 */
	public int getConsignProcessOrderCount(ConsignProcessOrderPo po) {
		// TODO Auto-generated method stub
		return windowOrderDao.getConsignProcessOrderCount(po);
	}

	/**
	 * 委外订单的未核销商品list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public int getConsignProcessOrderForCount(ConsignProcessOrderPo po) {
		// TODO Auto-generated method stub
		return windowOrderDao.getConsignProcessOrderForCount(po);
	}

	/**
	 * 未核销的委外订单数量
	 * 
	 * @param po
	 *            订单po
	 * @return list 订单list
	 */
	public List<ConsignProcessOrderPo> getConsignProcessOrderForList(
			ConsignProcessOrderPo po, int start, int size) {
		// TODO Auto-generated method stub
		return windowOrderDao.getConsignProcessOrderForList(po, start, size);
	}

	/**
	 * 未核销的委外订单list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<GoodsInfoPo> getConsignProcessOrderList(
			ConsignProcessOrderPo po, int start, int size) {
		// TODO Auto-generated method stub
		return windowOrderDao.getConsignProcessOrderList(po, start, size);
	}


	public int getInvoiceForCount(ProcurementOrdersPo po) {
		// TODO Auto-generated method stub
		return windowOrderDao.getInvoiceForCount(po);
	}


	public List<ProcurementOrdersPo> getInvoiceForList(ProcurementOrdersPo po,
			int start, int size) {
		// TODO Auto-generated method stub
		return windowOrderDao.getInvoiceForList(po, start, size);
	}

}
