package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.orders.storage.persistence.ProcurementOrderEntryPo;
import com.pengsheng.orders.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.orders.storage.persistence.ProcurementSendEntryPo;
import com.pengsheng.orders.storage.persistence.ProcurementSendPo;

public interface ConsignProcessOrderStatusMgr {

	/**
	 * 得到委外订单状态数量
	 * @param procurementOrdersPo
	 * @return
	 */
	public int getConsignProcessOrderStatusCount(ProcurementOrdersPo procurementOrdersPo);
	
	/**
	 * 查询委外订单状态信息
	 * @param procurementOrdersPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ProcurementOrdersPo> selectConsignProcessOrderStatus(ProcurementOrdersPo procurementOrdersPo , int start , int size);
	
	/**
	 * 得到公司id
	 * @param companyNamePo
	 * @return
	 */
	public CompanyNamePo getCompanyId(CompanyNamePo companyNamePo);
	
	/**
	 * 得到委外订单详细开窗中表头信息
	 * @param procurementOrdersPo
	 * @return
	 */
	public ProcurementOrdersPo getConsignProcessOrderStatus(ProcurementOrdersPo procurementOrdersPo);
	
	/**
	 * 委外发货单详细
	 * @param procurementSendPo
	 * @return
	 */
	public List<ProcurementSendPo> selectConsignProcessSend(ProcurementSendPo procurementSendPo);
	
	/**
	 * 委外订单详细开窗中表体信息
	 * @param procurementOrderEntryPo
	 * @return
	 */
	public List<ProcurementOrderEntryPo> selectOrderDetaile(ProcurementOrderEntryPo procurementOrderEntryPo);
	
	/**
	 * 委外发货单详细开窗中表头
	 * @param procurementSendPo
	 * @return
	 */
	public ProcurementSendPo getConsginSend(ProcurementSendPo procurementSendPo);
	
	/**
	 * 委外发货单详细开窗中表体
	 * @param procurementSendEntryPo
	 * @return
	 */
	public List<ProcurementSendEntryPo> selectSendDetaile(ProcurementSendEntryPo procurementSendEntryPo);
	
}
