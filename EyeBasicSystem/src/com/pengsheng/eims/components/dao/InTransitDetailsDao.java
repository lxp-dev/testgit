package com.pengsheng.eims.components.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.PayMentBillPo;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageTypePo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface InTransitDetailsDao {
	/**
	 * 显示在途查询信息
	 * @param salesID
	 * @return
	 */
	public List<SalesBasicPo> getSalesBasicDetails(String salesID) ;

	/**
	 * 显示在途状态
	 * @param po
	 * @return
	 */
	public List<InTransitPo> getInTransitState(String salesid);
	
	/**
	 * 显示在途状态
	 * @param po
	 * @return
	 */
	public List<InTransitPo> getWeiXinInTransitState(String salesid);
	
	/**
	 * 判断当前在途状态是否启用
	 * @param inTransitID
	 * @return
	 */
	public String getInTransitFlag(String inTransitID);
	
	/**
	 * 得到顾客信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getCustomerInfo(SalesBasicPo salesBasicPo);
	public SalesBasicPo getCustomerInfoFinished(SalesBasicPo salesBasicPo);
	public SalesBasicPo getCustomerInfo2(String customerID);
	public SalesBasicPo getCustomerInfo3(String customerID);
	
	/**
	 * 得到顾客信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getCustomerInfoByID(SalesBasicPo salesBasicPo);
	
	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo);
	public SalesBasicPo getODDetailInfoFinished(SalesBasicPo salesBasicPo);
	public int getDetailCount(SalesBasicPo salesBasicPo,String GlassFlag);
	public int getDetailCount(SalesDetailPo salesDetailPo);
	public int getDetailCount(SalesBasicPo salesBasicPo);
	
	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo);
	public SalesBasicPo getOSDetailInfoFinished(SalesBasicPo salesBasicPo);
	
	/**
	 * 得到配镜单中商品的详细信息
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsInfo(SalesDetailPo salesDetailPo);
	public List<SalesDetailPo> getGoodsInfoFinished(SalesDetailPo salesDetailPo);
	public List<SalesDetailPo> getGoodsInfoNoFinished2(SalesDetailPo salesDetailPo);
	public List<SalesDetailPo> getGoodsInfoNoFinished2NoZengPin(SalesDetailPo salesDetailPo);
	
	/**
	 * 取得附加费用
	 * @param additionalCDetailPo
	 * @return
	 */
	public List<AdditionalCDetailPo> getAddititonalCDetail(AdditionalCDetailPo additionalCDetailPo);
	
	/**
	 * 取得特殊加工要求
	 * @param specialPDetailPo
	 * @return
	 */
	public List<SpecialPDetailPo> getSpecialPDetail(SpecialPDetailPo specialPDetailPo);
	
	/**
	 * 取得重订配镜单的原单号
	 * @param rSalesID
	 * @return
	 */
	public InTransitPo getOldSalesID(String rSalesID);	
	
	/**
	 * 根据重订配镜单的原单号显示重订在途状态
	 * @param salesid
	 * @return
	 */
	public List<InTransitPo> getOldInTransitState(String salesid);
	
	/**
	 * 取得配镜单付款信息
	 * 
	 * @param salesid
	 * @return
	 */
	public List<SalesLogPo> getSalesLog(String salesid);	
	
	/**
	 * 获取退货商品（非自架自片）
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getReturnGoodsInfo(SalesDetailPo salesDetailPo);
	
	/**
	 *  使用条码非带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByNotBatch(InventoryEntryPo po);
	/**
	 *  使用条码非带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByNotBatch2(InventoryEntryPo po);
	
	/**
	 *  使用条码带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByBatch(InventoryEntryPo po);
	
	/**
	 *  不使用条码（负库存出库）
	 */
	public int getStorageNumByGoodsID(InventoryEntryPo po);
	
	/**
	 *  根据仓位获取所在门店
	 */
	public DepartmentsPo getDepartmentByWarehouse(InventoryPo po);
	
	/**
	 *  根据商品代码判断是否使用批号
	 */
	public GoodsCategoryPo getGoodsContainBatch(InventoryEntryPo po);
	
	/**
	 *  判断当前模块是否参与在途库存的计算
	 */
	public InTransitStorageTypePo getInTransitStorageSwitch(String moduleID);
	
	/**
	 * 获取商品的在途库存（使用条码）
	 */
	public InTransitStorageEntryPo getGoodsInTransitStorageNum(String goodsID,String goodsBarCode,String bgiwarehouseid);
	
	/**
	 * 获取商品的在途库存（不使用条码）
	 */
	public InTransitStorageEntryPo getGoodsInTransitStorageNum(String goodsID,String bgiwarehouseid);
	
	/**
	 * 根据商品代码查询商品信息
	 */
	public GoodsInfoPo getSalesGoodsInfo(String goodsID);
	
	/**
	 * 获取需要做自动调拨的商品
	 */
	public List<SalesDetailPo> getAutoAllocationGoodsList(SalesDetailPo salesDetailPo);
	
	/**
	 * 得到配镜单中商品的详细信息
	 */
	public List<SalesDetailPo> getSalesGoodsInfo(SalesDetailPo salesDetailPo);
	/**
	 * 得到配镜单中商品的详细信息
	 */
	public List<SalesDetailPo> getSalesGoodsInfo2(SalesDetailPo salesDetailPo);
	
	/**
	 * 新增往来明细
	 */
	public void insertSupplierDealingEntry(InventoryPo po);
	
	/**
	 * 根据业务明细查询商品代码
	 */
	public GoodsInfoPo getGoodsInfoByInventoryEntry(InventoryEntryPo epo);
	
	/**
	 * 删除往来明细
	 */
	public void deleteSupplierDealingEntry(PayMentBillPo po);
	
	/**
	 * 新增付款单往来明细
	 */
	public void insertSupplierDealingEntry(PayMentBillPo po);
	
	/**
	 * 根据配镜单查询委外收货仓位
	 */
	public String getSalesGoodsInWarehouse(String billid);
	
	/**
	 * 更新库存表的结算成本
	 */
	public void updateStorageCostEntry(InventoryEntryPo epo);
	
	/**
	 * 根据单据编号查询商品成本
	 */
	public List<InventoryEntryPo> getStorageCostEntryByBillID(InventoryPo po);
	
	public int getSalesBasicInfoByID(SalesBasicPo salesBasicPo);
	
	public int getSalesDetailInfoByID(SalesDetailPo sdpo);
	
	public SalesBasicPo getSalesBasicInfo(SalesBasicPo salesBasicPo);
	public SalesBasicPo getSalesBasicInfoFinished(SalesBasicPo salesBasicPo);
	
	/**
	 * 只有待结款的单子才能调用
	 */
	public List<SalesDetailPo> getGoodsInfoNoFinished(SalesDetailPo salesDetailPo);
	
	/**
	 * 获取取镜门店列表
	 */
	public List<SalesBasicPo> getLocationShopCodeList(String[] salesBillArray);
	
	/**
	 * 根据配镜单号获取配送人员姓名
	 */
	public String getPsNameInfo(String salesid,String psType);
	
	/**
	 * 根据配镜单号获取配送人员姓名数量
	 */
	public int getPsNameInfoCount(String salesid,String psType);
	
}
