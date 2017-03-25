package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.orders.storage.persistence.ReturnsEntryPo;
import com.pengsheng.orders.storage.persistence.ReturnsPo;

public interface OrdersStatusReturnDao {

	/**
	 * 得到退货信息数量
	 * @param returnsPo
	 * @return
	 */
	public int getOrdersStatusReturnCount(ReturnsPo returnsPo);
	
	/**
	 * 查询退货信息
	 * @param returnsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ReturnsPo> selectOrdersStatusReturn(ReturnsPo returnsPo , int start , int size);
	
	/**
	 * 详细开窗表头
	 * @param returnsPo
	 * @return
	 */
	public ReturnsPo getOrdersStatusDetaile(ReturnsPo returnsPo);
	
	/**
	 * 详细开窗表体
	 * @param returnsEntryPo
	 * @return
	 */
	public List<ReturnsEntryPo> selectOrdersStatusDetaile(ReturnsEntryPo returnsEntryPo);
	
	/**
	 * 得到公司id
	 * @param companyNamePo
	 * @return
	 */
	public CompanyNamePo getCompanyId(CompanyNamePo companyNamePo);
}
