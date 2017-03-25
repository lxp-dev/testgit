package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.storage.dao.ConsignProcessOrderStatusDao;
import com.pengsheng.eims.storage.mgr.ConsignProcessOrderStatusMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.orders.storage.persistence.ProcurementOrderEntryPo;
import com.pengsheng.orders.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.orders.storage.persistence.ProcurementSendEntryPo;
import com.pengsheng.orders.storage.persistence.ProcurementSendPo;

public class ConsignProcessOrderStatusMgrImpl implements ConsignProcessOrderStatusMgr {

	private ConsignProcessOrderStatusDao consignProcessOrderStatusDao;
	
	public ConsignProcessOrderStatusDao getConsignProcessOrderStatusDao() {
		return consignProcessOrderStatusDao;
	}

	public void setConsignProcessOrderStatusDao(
			ConsignProcessOrderStatusDao consignProcessOrderStatusDao) {
		this.consignProcessOrderStatusDao = consignProcessOrderStatusDao;
	}

	/**
	 * 得到公司id
	 * @param companyNamePo
	 * @return
	 */
	public CompanyNamePo getCompanyId(CompanyNamePo companyNamePo) {
		// TODO Auto-generated method stub
		return consignProcessOrderStatusDao.getCompanyId(companyNamePo);
	}

	/**
	 * 得到委外订单状态数量
	 * @param procurementOrdersPo
	 * @return
	 */
	public int getConsignProcessOrderStatusCount(
			ProcurementOrdersPo procurementOrdersPo) {
		// TODO Auto-generated method stub
		return consignProcessOrderStatusDao.getConsignProcessOrderStatusCount(procurementOrdersPo);
	}

	/**
	 * 查询委外订单状态信息
	 * @param procurementOrdersPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ProcurementOrdersPo> selectConsignProcessOrderStatus(
			ProcurementOrdersPo procurementOrdersPo, int start, int size) {
		// TODO Auto-generated method stub
		return consignProcessOrderStatusDao.selectConsignProcessOrderStatus(procurementOrdersPo, start, size);
	}

	/**
	 * 得到委外订单详细开窗中表头信息
	 * @param procurementOrdersPo
	 * @return
	 */
	public ProcurementOrdersPo getConsignProcessOrderStatus(
			ProcurementOrdersPo procurementOrdersPo) {
		// TODO Auto-generated method stub
		return consignProcessOrderStatusDao.getConsignProcessOrderStatus(procurementOrdersPo);
	}

	/**
	 * 委外发货单详细
	 * @param procurementSendPo
	 * @return
	 */
	public List<ProcurementSendPo> selectConsignProcessSend(
			ProcurementSendPo procurementSendPo) {
		// TODO Auto-generated method stub
		return consignProcessOrderStatusDao.selectConsignProcessSend(procurementSendPo);
	}

	/**
	 * 委外订单详细开窗中表体信息
	 * @param procurementOrderEntryPo
	 * @return
	 */
	public List<ProcurementOrderEntryPo> selectOrderDetaile(
			ProcurementOrderEntryPo procurementOrderEntryPo) {
		// TODO Auto-generated method stub
		return consignProcessOrderStatusDao.selectOrderDetaile(procurementOrderEntryPo);
	}

	/**
	 * 委外发货单详细开窗中表头
	 * @param procurementSendPo
	 * @return
	 */
	public ProcurementSendPo getConsginSend(ProcurementSendPo procurementSendPo) {
		// TODO Auto-generated method stub
		return consignProcessOrderStatusDao.getConsginSend(procurementSendPo);
	}

	/**
	 * 委外发货单详细开窗中表体
	 * @param procurementSendEntryPo
	 * @return
	 */
	public List<ProcurementSendEntryPo> selectSendDetaile(
			ProcurementSendEntryPo procurementSendEntryPo) {
		// TODO Auto-generated method stub
		return consignProcessOrderStatusDao.selectSendDetaile(procurementSendEntryPo);
	}

}
