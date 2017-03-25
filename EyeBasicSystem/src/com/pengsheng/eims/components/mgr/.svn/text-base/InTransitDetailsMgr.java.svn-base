package com.pengsheng.eims.components.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.TracEntryPo;

public interface InTransitDetailsMgr {

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
	 * 得到配镜单中商品的详细信息
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsInfo(SalesDetailPo salesDetailPo);
	
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
	 *  使用条码非带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByNotBatch(InventoryEntryPo po);
	
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
	 *  使用条码非带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByNotBatch(TracEntryPo po);
	
	/**
	 *  使用条码带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByBatch(TracEntryPo po);
	
	/**
	 *  不使用条码（负库存出库）
	 */
	public int getStorageNumByGoodsID(TracEntryPo po);
	
	/**
	 *  使用条码非带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByNotBatch(AllocationEntryPo po);
	
	/**
	 *  使用条码带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByBatch(AllocationEntryPo po);
	
	/**
	 *  不使用条码（负库存出库）
	 */
	public int getStorageNumByGoodsID(AllocationEntryPo po);
	
	public int getSalesBasicInfoByID(SalesBasicPo salesBasicPo);
	
	public SalesBasicPo getSalesBasicInfo(SalesBasicPo salesBasicPo);
	
	/**
	 * 只有待结款的单子才能调用
	 */
	public List<SalesDetailPo> getGoodsInfoNoFinished(SalesDetailPo salesDetailPo);
	
	/**
	 * 根据配镜单号获取配送人员姓名
	 */
	public String getPsNameInfo(String salesid,String psType);
	
}
