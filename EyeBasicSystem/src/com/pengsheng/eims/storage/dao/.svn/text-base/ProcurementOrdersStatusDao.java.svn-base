package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.orders.storage.persistence.ProcurementOrderEntryPo;
import com.pengsheng.orders.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.orders.storage.persistence.ProcurementSendEntryPo;
import com.pengsheng.orders.storage.persistence.ProcurementSendPo;

public interface ProcurementOrdersStatusDao {
	
	/**
	 * 得到订单状态数量
	 * @param procurementOrdersPo
	 * @return
	 */
	public int getProcurementOrdersStatusCount(ProcurementOrdersPo procurementOrdersPo);
	
	/**
	 * 查询订单状态信息
	 * @param procurementOrdersPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ProcurementOrdersPo> selectProcurementOrdersStatus(ProcurementOrdersPo procurementOrdersPo , int start , int size);
	
	/**
	 * 得到公司id
	 * @param companyNamePo
	 * @return
	 */
	public CompanyNamePo getCompanyId(CompanyNamePo companyNamePo);
	
	/**
	 * 得到采购订单详细开窗中表头信息
	 * @param procurementOrdersPo
	 * @return
	 */
	public ProcurementOrdersPo getProcurementOrderStatus(ProcurementOrdersPo procurementOrdersPo);
	
	/**
	 * 采购发货单详细	详细开窗表体
	 * @param procurementSendPo
	 * @return
	 */
	public List<ProcurementSendPo> selectProcurementSend(ProcurementSendPo procurementSendPo);
	
	/**
	 * 采购订单详细信息开窗中表体信息
	 * @param procurementOrderEntryPo
	 * @return
	 */
	public List<ProcurementOrderEntryPo> selectOrderDetaile(ProcurementOrderEntryPo procurementOrderEntryPo);
	
	/**
	 * 采购发货单详细开窗中表头
	 * @param procurementSendPo
	 * @return
	 */
	public ProcurementSendPo getProcurementSend(ProcurementSendPo procurementSendPo);
	
	/**
	 * 采购发货单详细开窗中表体
	 * @param procurementSendEntryPo
	 * @return
	 */
	public List<ProcurementSendEntryPo> selectSendDetaile(ProcurementSendEntryPo procurementSendEntryPo);
	
}
