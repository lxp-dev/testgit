package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersEntryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;

public interface ProcurementOrdersDao {
	/**
	 * 取商品类别集合
	 * 
	 * @return
	 */
	public List<GoodsCategoryPo> getGoodsCategorys();

	/**
	 * 增加订单
	 * 
	 * @param brandPo
	 */
	public void insertProcurementOrders(ProcurementOrdersPo procurementOrdersPo);
	public void insertProcurementOrdersStatus(ProcurementOrdersPo procurementOrdersPo);
	public void updateProcurementOrdersStatus(ProcurementOrdersPo procurementOrdersPo);
	public void insertProcurementApplyStatus(ProcurementOrdersPo procurementOrdersPo);

	/**
	 * 增加订单明细
	 * 
	 * @param brandPo
	 */
	public void insertProcurementOrdersEntry(
			ProcurementOrdersEntryPo procurementOrdersEntryPo);

	/**
	 * 取订单合计
	 * 
	 * @param procurementOrdersPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ProcurementOrdersPo> getProcurementOroderList(
			ProcurementOrdersPo procurementOrdersPo, int start, int size);

	/**
	 * 取订单总数
	 * 
	 * @param procurementOrdersPo
	 * @return
	 */
	public int getProcurementOroderCount(ProcurementOrdersPo procurementOrdersPo);

	/**
	 * 删除订单主表
	 * 
	 * @param id
	 */
	public void delProcurementOrders(String id);

	/**
	 * 删除订单从表
	 * 
	 * @param id
	 */
	public void delProcurementOrdersEntry(String id);

	/**
	 * 得到订单主表
	 * 
	 * @param procurementOrdersPo
	 * @return
	 */
	public ProcurementOrdersPo getProcurementOrders(
			ProcurementOrdersPo procurementOrdersPo);

	/**
	 * 得到订单从表
	 * 
	 * @param procurementOrdersEntryPo
	 * @return
	 */
	public List<ProcurementOrdersEntryPo> getProcurementOrdersEntryList(
			ProcurementOrdersEntryPo procurementOrdersEntryPo);
	
	public List<ProcurementOrdersEntryPo> getProcurementOrdersEntryApplyList(ProcurementOrdersPo po);

	/**
	 * 更新订单主表
	 * 
	 * @param procurementOrdersPo
	 */
	public void updateProcurementOrders(ProcurementOrdersPo procurementOrdersPo);

	/**
	 * 导入订单
	 * 
	 * @param poID
	 */
	public void pOimportOrders(String poID);
	
	/**
	 * 订单传输标识
	 * 
	 * @param poID
	 */
	public StatusModulePo OrdersStatus(String ModuleID);
	
	public GoodsInfoPo selectDimensionPo(String goodsid,String v);
	
	public GoodsInfoPo selectDimensionPo(String goodsid,String v,String billID);
	
	/**
	 * 得到订单中所有的品种
	 */
	public List<GoodsInfoPo> getProBrand(String billID);
	
}
