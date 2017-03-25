package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersEntryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;

public interface ProcurementOrdersMgr {
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

	/**
	 * 增加订单明细
	 * 
	 * @param brandPo
	 */
	public void insertProcurementOrdersEntry(
			ProcurementOrdersEntryPo procurementOrdersEntryPo);

	/**
	 * 增加订单
	 * 
	 * @param procurementOrdersPo
	 * @param procurementOrdersEntryPo
	 */
	public void insertPOs(ProcurementOrdersPo procurementOrdersPo,
			List<ProcurementOrdersEntryPo> procurementOrdersEntrys,LogisticsLogPo logPo);
	
	/**
	 * 取订单合计
	 * @param procurementOrdersPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ProcurementOrdersPo> getProcurementOroderList(
			ProcurementOrdersPo procurementOrdersPo, int start, int size);
	
	/**
	 * 取订单总数
	 * @param procurementOrdersPo
	 * @return
	 */
	public int getProcurementOroderCount(ProcurementOrdersPo procurementOrdersPo);
	
	/**
	 * 删除订单表
	 * @param id
	 */
	public void delProcurementOrders(String id,LogisticsLogPo logPo);
	
	/**
	 * 得到订单主表
	 * @param procurementOrdersPo
	 * @return
	 */
	public ProcurementOrdersPo getProcurementOrders(
			ProcurementOrdersPo procurementOrdersPo);

	/**
	 * 得到订单从表
	 * @param procurementOrdersEntryPo
	 * @return
	 */
	public List<ProcurementOrdersEntryPo> getProcurementOrdersEntryList(
			ProcurementOrdersEntryPo procurementOrdersEntryPo);
	
	/**
	 * 更新订单
	 * @param procurementOrdersPo
	 * @param procurementOrdersEntrys
	 */
	public void updatePOs(ProcurementOrdersPo procurementOrdersPo,
			List<ProcurementOrdersEntryPo> procurementOrdersEntrys,LogisticsLogPo logPo);
	
	public List<ProcurementOrdersEntryPo> getProcurementOrdersApplyList(
			ProcurementOrdersPo po);
	
	public List<GoodsInfoPo> selectDimensionPos(List<String> goodsids,List<String> vs);
	
	public List<GoodsInfoPo> selectDimensionPos(List<String> goodsids,List<String> vs,String billID);
	
	/**
	 * 得到订单中所有的品种
	 */
	public List<GoodsInfoPo> getProBrand(String billID);
	
}
