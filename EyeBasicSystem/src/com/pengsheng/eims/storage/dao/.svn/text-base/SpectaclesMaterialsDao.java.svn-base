package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;

public interface SpectaclesMaterialsDao {

	/**
	 * 查询配镜发料信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getSpectaclesMaterialsCount(SalesBasicPo salesBasicPo);
	
	/**
	 * 查询配镜发料信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectSpectaclesMaterials(SalesBasicPo salesBasicPo , int start , int size);
	
	/**
	 * 得到订单及顾客信息 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getSalesDetailInfo(SalesBasicPo salesBasicPo);
	
	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo);
	
	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo);
	
	/**
	 * 得到销售单中商品个数
	 * @param salesDetailPo
	 * @return
	 */
	public int getGoodsDetailCount(SalesDetailPo salesDetailPo);
	
	/**
	 * 得到销售单中商品信息
	 * @param salesDetailPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesDetailPo> selectGoodsDetailInfo(SalesDetailPo salesDetailPo, int start , int size);
	public List<SalesDetailPo> selectGoodsDetailInfoes(SalesDetailPo salesDetailPo);
	public List<SalesDetailPo> selectGoodsDetailInfoes2(SalesDetailPo salesDetailPo);
	
	/**
	 * 更新销售基表中的在途点
	 * @param salesDetailPo
	 */
	public void updateMaterialsInTransit(SalesBasicPo salesBasicPo);
	
	/**
	 * 根据销售单号将信息插入在途明细表中
	 * @param inTransitPo
	 */
	public void insertIntrnsitInfo(InTransitPo inTransitPo);
	
	/**
	 * 根据销售单号将信息插入当月库存变更表中
	 * @param strogeChangePo
	 */
	public void insertStrogeChange(StrogeChangePo strogeChangePo);
	
	/**
	 * 根据销售单号将信息插入当月库存log表中
	 * @param strogeChangePo
	 */
	public void insertStrogeChangeLog(StrogeChangePo strogeChangePo) ;
	
	/**
	 * 更新销售明细表中商品条码
	 * @param salesDetailPo
	 */
	public void updateDetailsBarcode(SalesDetailPo salesDetailPo);
	
	/**
	 * 得到部门列表
	 * @param departmentsPo
	 * @return
	 */
	public List<DepartmentsPo> getdepartment(DepartmentsPo departmentsPo);
	
	/**
	 * 发料时判断销售单在途
	 * @param String
	 * @return
	 */
	public int selectIsSend(String salesid);
	
	/**
	 * 发料时新增自动调拨单
	 */
    public void inertAutoAllocationToStore(InventoryPo po);
    
	/**
	 * 发料时新增自动调拨单明细
	 */
    public void inertAutoAllocationEntryToStore(InventoryEntryPo po);
    
	/**
	 * 根据调拨单号将信息插入当月库存变更表中
	 * @param strogeChangePo
	 */
	public void insertAutoAllocationStrogeChange(InventoryEntryPo po);
	
	/**
	 * 根据调拨单号将信息插入当月库存变更表中
	 * @param strogeChangePo
	 */
	public void insertAutoAllocationStrogeChangeLog(InventoryEntryPo po);
	
	/**
	 * 发料时新增自动调拨单明细条码
	 */
    public void inertAutoAllocationBarcodeToStore(InventoryEntryPo po);
    
	/**
	 * 自动发料生成调拨单（隐藏）
	 */
    public void inertAutoAllocationBillToStore(InventoryPo po);
    
	/**
	 * 根据配送单生成调拨单
	 */
    public void inertAutoAllocationBillByyx(InventoryPo po);
    
	/**
	 * 自动发料生成调拨单明细（隐藏）
	 */
    public void inertAutoAllocationBillEntryToStore(InventoryEntryPo po);
    
	/**
	 * 自动发料生成调拨单条码（隐藏）
	 */
    public void inertAutoAllocationBillBarcodeToStore(InventoryEntryPo po);
    
	/**
	 * 查询未打印发料单的总数
	 */
	public int getPrintSpectaclesMaterialsBillCount(SalesBasicPo salesBasicPo);
	
	/**
	 * 查询未打印发料单
	 */
	public List<SalesBasicPo> selectPrintSpectaclesMaterialsBill(SalesBasicPo salesBasicPo , int start , int size);
	
	/**
	 * 批量新增发料信息
	 */
	public void insertMaterialsBatch(SalesBasicPo po);
	
	/**
	 * 获取发料商品
	 */
	public List<SalesDetailPo> selectGoodsDetailInfo(SalesBasicPo po);	
	
	/**
	 * 根据商品代码查询税率
	 */
	public GoodsInfoPo getGoodsTaxRateByID(String goodsID);
}
