package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.storage.dao.OrdersStatusReturnDao;
import com.pengsheng.eims.storage.mgr.OrdersStatusReturnMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.orders.storage.persistence.ReturnsEntryPo;
import com.pengsheng.orders.storage.persistence.ReturnsPo;

public class OrdersStatusReturnMgrImpl implements OrdersStatusReturnMgr {

	private OrdersStatusReturnDao ordersStatusReturnDao;
	
	
	public OrdersStatusReturnDao getOrdersStatusReturnDao() {
		return ordersStatusReturnDao;
	}

	public void setOrdersStatusReturnDao(OrdersStatusReturnDao ordersStatusReturnDao) {
		this.ordersStatusReturnDao = ordersStatusReturnDao;
	}

	/**
	 * 得到退货信息数量
	 * @param returnsPo
	 * @return
	 */
	public int getOrdersStatusReturnCount(ReturnsPo returnsPo) {
		// TODO Auto-generated method stub
		return ordersStatusReturnDao.getOrdersStatusReturnCount(returnsPo);
	}

	/**
	 * 查询退货信息
	 * @param returnsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ReturnsPo> selectOrdersStatusReturn(ReturnsPo returnsPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return ordersStatusReturnDao.selectOrdersStatusReturn(returnsPo, start, size);
	}

	/**
	 * 详细开窗表头
	 * @param returnsPo
	 * @return
	 */
	public ReturnsPo getOrdersStatusDetaile(ReturnsPo returnsPo) {
		// TODO Auto-generated method stub
		return ordersStatusReturnDao.getOrdersStatusDetaile(returnsPo);
	}

	/**
	 * 详细开窗表体
	 * @param returnsEntryPo
	 * @return
	 */
	public List<ReturnsEntryPo> selectOrdersStatusDetaile(
			ReturnsEntryPo returnsEntryPo) {
		// TODO Auto-generated method stub
		return ordersStatusReturnDao.selectOrdersStatusDetaile(returnsEntryPo);
	}

	/**
	 * 得到公司id
	 * @param companyNamePo
	 * @return
	 */
	public CompanyNamePo getCompanyId(CompanyNamePo companyNamePo) {
		// TODO Auto-generated method stub
		return ordersStatusReturnDao.getCompanyId(companyNamePo);
	}

}
