package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.storage.dao.ProcurementOrdersStatusDao;
import com.pengsheng.eims.storage.mgr.ProcurementOrdersStatusMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.orders.storage.persistence.ProcurementOrderEntryPo;
import com.pengsheng.orders.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.orders.storage.persistence.ProcurementSendEntryPo;
import com.pengsheng.orders.storage.persistence.ProcurementSendPo;

public class ProcurementOrdersStatusMgrImpl implements ProcurementOrdersStatusMgr {

	private ProcurementOrdersStatusDao procurementOrdersStatusDao;
	
	public ProcurementOrdersStatusDao getProcurementOrdersStatusDao() {
		return procurementOrdersStatusDao;
	}

	public void setProcurementOrdersStatusDao(
			ProcurementOrdersStatusDao procurementOrdersStatusDao) {
		this.procurementOrdersStatusDao = procurementOrdersStatusDao;
	}

	/**
	 * 得到订单状态数量
	 * @param procurementOrdersPo
	 * @return
	 */
	public int getProcurementOrdersStatusCount(ProcurementOrdersPo procurementOrdersPo) {
		// TODO Auto-generated method stub
		return procurementOrdersStatusDao.getProcurementOrdersStatusCount(procurementOrdersPo);
	}

	/**
	 * 查询订单状态信息
	 * @param procurementOrdersPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ProcurementOrdersPo> selectProcurementOrdersStatus(ProcurementOrdersPo procurementOrdersPo, int start, int size) {
		// TODO Auto-generated method stub
		return procurementOrdersStatusDao.selectProcurementOrdersStatus(procurementOrdersPo, start, size);
	}

	/**
	 * 得到公司id
	 * @param companyNamePo
	 * @return
	 */
	public CompanyNamePo getCompanyId(CompanyNamePo companyNamePo) {
		// TODO Auto-generated method stub
		return procurementOrdersStatusDao.getCompanyId(companyNamePo);
	}

	/**
	 * 得到采购订单详细开窗中表头信息
	 * @param procurementOrdersPo
	 * @return
	 */
	public ProcurementOrdersPo getProcurementOrderStatus(
			ProcurementOrdersPo procurementOrdersPo) {
		// TODO Auto-generated method stub
		return procurementOrdersStatusDao.getProcurementOrderStatus(procurementOrdersPo);
	}

	/**
	 * 采购发货单详细	详细开窗表体
	 * @param procurementSendPo
	 * @return
	 */
	public List<ProcurementSendPo> selectProcurementSend(
			ProcurementSendPo procurementSendPo) {
		// TODO Auto-generated method stub
		return procurementOrdersStatusDao.selectProcurementSend(procurementSendPo);
	}

	/**
	 * 采购订单详细信息开窗中表体信息
	 * @param procurementOrderEntryPo
	 * @return
	 */
	public List<ProcurementOrderEntryPo> selectOrderDetaile(
			ProcurementOrderEntryPo procurementOrderEntryPo) {
		// TODO Auto-generated method stub
		return procurementOrdersStatusDao.selectOrderDetaile(procurementOrderEntryPo);
	}

	/**
	 * 采购发货单详细开窗中表头
	 * @param procurementSendPo
	 * @return
	 */
	public ProcurementSendPo getProcurementSend(
			ProcurementSendPo procurementSendPo) {
		// TODO Auto-generated method stub
		return procurementOrdersStatusDao.getProcurementSend(procurementSendPo);
	}

	/**
	 * 采购发货单详细开窗中表体
	 * @param procurementSendEntryPo
	 * @return
	 */
	public List<ProcurementSendEntryPo> selectSendDetaile(
			ProcurementSendEntryPo procurementSendEntryPo) {
		// TODO Auto-generated method stub
		return procurementOrdersStatusDao.selectSendDetaile(procurementSendEntryPo);
	}

}
