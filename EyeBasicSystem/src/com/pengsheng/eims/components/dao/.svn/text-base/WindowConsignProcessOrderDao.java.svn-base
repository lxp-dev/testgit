package com.pengsheng.eims.components.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.SalesTempPo;
/**
 * 委外管理的开窗dao接口
 */
public interface WindowConsignProcessOrderDao {
	/**
	 * 委外订单的销售单数量
	 * @param po 销售单po
	 * @return int 数量
	 */
	public int getSalesBasicForConsignProcessCount(SalesBasicPo po);
	
	public int getSalesBasicForConsignProcessCount1(SalesBasicPo po);
	
	public List<SupplierPo> getSuppliersalse(DepartmentsPo departmentsPo);
	
	public List<SupplierPo> getSupplierOrdersalse();
	
	public List<SupplierPo> getSupplierOrdersalse(DepartmentsPo departmentsPo);
	
	/**
	 * 委外订单的销售单list
	 * @param po 销售单po
	 * @param start
	 * @param size
	 * @return list ConsignProcessOrderDetailsPo的list
	 */		
	public List<ConsignProcessOrderDetailsPo> getSalesBasicForConsignProcessList(SalesBasicPo po,int start, int size);
	public List<ConsignProcessOrderDetailsPo> getSalesBasicForConsignProcessList1(SalesBasicPo po,int start, int size);
	/**
	 * 委外订单的商品数量
	 * @param po GoodsInfoPo
	 * @return int 数量
	 */		
	public int getGoodsForConsignProcessCount(GoodsInfoPo po);
	/**
	 * 委外订单的商品list
	 * @param po GoodsInfoPo
	 * @param start
	 * @param size
	 * @return list ConsignProcessOrderDetailsPo的list
	 */		
	public List<ConsignProcessOrderDetailsPo> getGoodsForConsignProcessList(GoodsInfoPo po,int start, int size);
	/**
	 * 外部的委外订单的数量
	 * @param po ConsignProcessOrderDetailsPo
	 * @return int 数量
	 */		
	public int getGoodsForConsignProcessReceiptCount(ConsignProcessOrderDetailsPo po);
	/**
	 * 外部的委外订单的list
	 * @param po ConsignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return list ConsignProcessOrderDetailsPo的list
	 */	
	public List<ConsignProcessOrderDetailsPo> getGoodsForConsignProcessReceiptList(ConsignProcessOrderDetailsPo po,int start, int size);
	/**
	 * 外部的委外收货单的数量
	 * @param po ConsignProcessReceiptPo
	 * @return int 数量
	 */		
	public int getConsignProcessReceiptCount(ConsignProcessReceiptPo po);
	/**
	 * 外部的委外收货单的list
	 * @param po ConsignProcessReceiptPo
	 * @param start
	 * @param size
	 * @return list ConsignProcessReceiptPo的list
	 */	
	public List<ConsignProcessReceiptPo> getConsignProcessReceiptList(ConsignProcessReceiptPo po,int start, int size);
	/**
	 * 委外订单的销售单数量
	 * @param po 销售单po
	 * @return int 数量
	 */	
	public int getSalesForConsignProcessCount(SalesBasicPo po);
	/**
	 * 委外订单的销售单list
	 * @param po 销售单po
	 * @return list
	 */	
	public List<SalesBasicPo> getSalesForConsignProcessList(SalesBasicPo po,int start, int size);
	/**
	 * 委外订单的销售单PO
	 * @param po 销售单po
	 * @return PO
	 */	
	public SalesTempPo getSalesForConsignProcessPo(SalesBasicPo po);
	public SalesTempPo getSalesForConsignProcessPoFinished(SalesBasicPo po);
	
}
