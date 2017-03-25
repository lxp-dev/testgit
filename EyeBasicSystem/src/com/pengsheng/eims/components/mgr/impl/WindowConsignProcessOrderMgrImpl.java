package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.components.dao.WindowConsignProcessOrderDao;
import com.pengsheng.eims.components.mgr.WindowConsignProcessOrderMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.SalesTempPo;
/**
 * 委外管理的开窗mgr实现类
 */
public class WindowConsignProcessOrderMgrImpl implements WindowConsignProcessOrderMgr{
	
	private WindowConsignProcessOrderDao windowConsignProcessOrderDao;
	private InTransitDetailsDao inTransitDetailsDao;
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}
	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}
	public WindowConsignProcessOrderDao getWindowConsignProcessOrderDao() {
		return windowConsignProcessOrderDao;
	}
	public void setWindowConsignProcessOrderDao(
			WindowConsignProcessOrderDao windowConsignProcessOrderDao) {
		this.windowConsignProcessOrderDao = windowConsignProcessOrderDao;
	}
	/**
	 * 委外订单的销售单数量
	 * @param po 销售单po
	 * @return int 数量
	 */	
	public int getSalesBasicForConsignProcessCount(SalesBasicPo po) {
		
		return windowConsignProcessOrderDao.getSalesBasicForConsignProcessCount(po);
	}
	
	public List<SupplierPo> getSuppliersalse(DepartmentsPo departmentsPo)
	{
		return windowConsignProcessOrderDao.getSuppliersalse(departmentsPo);
	}
	
	public List<SupplierPo> getSupplierOrdersalse()
	{
		return windowConsignProcessOrderDao.getSupplierOrdersalse();
	}
	
	public List<SupplierPo> getSupplierOrdersalse(DepartmentsPo departmentsPo)
	{
		return windowConsignProcessOrderDao.getSupplierOrdersalse(departmentsPo);
	}
	
	/**
	 * 未生成委外订单的销售单数量
	 * @param po 销售单po
	 * @return int 数量
	 */	
	public int getSalesBasicForConsignProcessCount1(SalesBasicPo po) {
		
		return windowConsignProcessOrderDao.getSalesBasicForConsignProcessCount1(po);
	}
	/**
	 * 委外订单的销售单list
	 * @param po 销售单po
	 * @param start
	 * @param size
	 * @return list ConsignProcessOrderDetailsPo的list
	 */
	public List<ConsignProcessOrderDetailsPo> getSalesBasicForConsignProcessList(
			SalesBasicPo po, int start, int size) {
		
		return windowConsignProcessOrderDao.getSalesBasicForConsignProcessList(po, start, size);
	}
	
	/**
	 * 未生成委外订单的销售单list
	 * @param po 销售单po
	 * @param start
	 * @param size
	 * @return list ConsignProcessOrderDetailsPo的list
	 */
	public List<ConsignProcessOrderDetailsPo> getSalesBasicForConsignProcessList1(
			SalesBasicPo po, int start, int size) {
		return windowConsignProcessOrderDao.getSalesBasicForConsignProcessList1(po, start, size);
	}
	/**
	 * 委外订单的商品数量
	 * @param po GoodsInfoPo
	 * @return int 数量
	 */	
    public int getGoodsForConsignProcessCount(GoodsInfoPo po) {
    		
    	return windowConsignProcessOrderDao.getGoodsForConsignProcessCount(po);
    }
	/**
	 * 委外订单的商品list
	 * @param po GoodsInfoPo
	 * @param start
	 * @param size
	 * @return list ConsignProcessOrderDetailsPo的list
	 */
    public List<ConsignProcessOrderDetailsPo> getGoodsForConsignProcessList(GoodsInfoPo po,
    		int start, int size) {
    	
    	return windowConsignProcessOrderDao.getGoodsForConsignProcessList(po, start, size);
    }
	/**
	 * 外部的委外订单的数量
	 * @param po ConsignProcessOrderDetailsPo
	 * @return int 数量
	 */	
	public int getGoodsForConsignProcessReceiptCount(
			ConsignProcessOrderDetailsPo po) {
		
		return windowConsignProcessOrderDao.getGoodsForConsignProcessReceiptCount(po);
	}
	/**
	 * 外部的委外订单的list
	 * @param po ConsignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return list ConsignProcessOrderDetailsPo的list
	 */	
	public List<ConsignProcessOrderDetailsPo> getGoodsForConsignProcessReceiptList(
			ConsignProcessOrderDetailsPo po, int start, int size) {
		
		return windowConsignProcessOrderDao.getGoodsForConsignProcessReceiptList(po, start, size);
	}
	
	/**
	 * 外部的委外收货单的数量
	 * @param po ConsignProcessReceiptPo
	 * @return int 数量
	 */	
	public int getConsignProcessReceiptCount(ConsignProcessReceiptPo po) {
		
		return windowConsignProcessOrderDao.getConsignProcessReceiptCount(po);
	}
	
	/**
	 * 外部的委外收货单的list
	 * @param po ConsignProcessReceiptPo
	 * @param start
	 * @param size
	 * @return list ConsignProcessReceiptPo的list
	 */
	public List<ConsignProcessReceiptPo> getConsignProcessReceiptList(
			ConsignProcessReceiptPo po, int start, int size) {
		
		return windowConsignProcessOrderDao.getConsignProcessReceiptList(po, start, size);
	}
	/**
	 * 委外订单的销售单数量
	 * @param po 销售单po
	 * @return int 数量
	 */	
	public int getSalesForConsignProcessCount(SalesBasicPo po){
		
		return windowConsignProcessOrderDao.getSalesForConsignProcessCount(po);
		
	}
	/**
	 * 委外订单的销售单list
	 * @param po 销售单po
	 * @return list
	 */	
	public List<SalesBasicPo> getSalesForConsignProcessList(SalesBasicPo po,int start, int size){
		
		return windowConsignProcessOrderDao.getSalesForConsignProcessList(po,start,size);
	}
	/**
	 * 委外订单的销售单PO
	 * @param po 销售单po
	 * @return PO
	 */	
	public SalesTempPo getSalesForConsignProcessPo(SalesBasicPo po){
		if (inTransitDetailsDao.getSalesBasicInfoByID(po) == 0){			
			return windowConsignProcessOrderDao.getSalesForConsignProcessPoFinished(po);
		}	
		return windowConsignProcessOrderDao.getSalesForConsignProcessPo(po);
	}
}
