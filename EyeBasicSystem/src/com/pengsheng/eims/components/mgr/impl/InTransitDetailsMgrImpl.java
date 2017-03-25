package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
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

public class InTransitDetailsMgrImpl implements InTransitDetailsMgr {

	private InTransitDetailsDao inTransitDetailsDao;

	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	/**
	 * 显示在途查询信息
	 */
	public List<SalesBasicPo> getSalesBasicDetails(String salesID) {

		return inTransitDetailsDao.getSalesBasicDetails(salesID);
	}

	/**
	 * 显示在途状态
	 */
	public List<InTransitPo> getInTransitState(String salesid) {

		return inTransitDetailsDao.getInTransitState(salesid);
	}
	

	/**
	 * 显示在途状态
	 */
	public List<InTransitPo> getWeiXinInTransitState(String salesid) {

		return inTransitDetailsDao.getWeiXinInTransitState(salesid);
	}
	
	/**
	 * 判断当前在途状态是否启用
	 * @param inTransitID
	 * @return
	 */
	public String getInTransitFlag(String inTransitID){
		return inTransitDetailsDao.getInTransitFlag(inTransitID);
	}

	/**
	 * 得到顾客信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getCustomerInfo(SalesBasicPo salesBasicPo) {
		if (inTransitDetailsDao.getSalesBasicInfoByID(salesBasicPo) == 0){			
			return inTransitDetailsDao.getCustomerInfoFinished(salesBasicPo);
		}	
		return inTransitDetailsDao.getCustomerInfo(salesBasicPo);
	}
	
	public SalesBasicPo getCustomerInfoFinished(SalesBasicPo salesBasicPo){
		return inTransitDetailsDao.getCustomerInfoFinished(salesBasicPo);
	}

	/**
	 * 得到配镜单中商品的详细信息
	 */
	public List<SalesDetailPo> getGoodsInfo(SalesDetailPo salesDetailPo) {
        if (inTransitDetailsDao.getDetailCount(salesDetailPo) > 0){
        	return inTransitDetailsDao.getGoodsInfo(salesDetailPo);
        }
		return inTransitDetailsDao.getGoodsInfoFinished(salesDetailPo);
	}	

	/**
	 * 取出销售单中右眼镜片信息
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {
        if (inTransitDetailsDao.getDetailCount(salesBasicPo,"R") > 0){
        	return inTransitDetailsDao.getODDetailInfo(salesBasicPo);
        }
		return inTransitDetailsDao.getODDetailInfoFinished(salesBasicPo);
	}

	/**
	 * 取出销售单中左眼镜片信息
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {
        if (inTransitDetailsDao.getDetailCount(salesBasicPo,"L") > 0){
        	return inTransitDetailsDao.getOSDetailInfo(salesBasicPo);
        }
		return inTransitDetailsDao.getOSDetailInfoFinished(salesBasicPo);
	}

	/**
	 * 取得附加费用
	 */
	public List<AdditionalCDetailPo> getAddititonalCDetail(
			AdditionalCDetailPo additionalCDetailPo) {

		return inTransitDetailsDao.getAddititonalCDetail(additionalCDetailPo);
	}

	/**
	 * 取得特殊加工要求
	 */
	public List<SpecialPDetailPo> getSpecialPDetail(
			SpecialPDetailPo specialPDetailPo) {

		return inTransitDetailsDao.getSpecialPDetail(specialPDetailPo);
	}

	/**
	 * 取得重订配镜单的原单号
	 * 
	 * @param rSalesID
	 * @return
	 */
	public InTransitPo getOldSalesID(String rSalesID) {
		return inTransitDetailsDao.getOldSalesID(rSalesID);
	}

	/**
	 * 根据重订配镜单的原单号显示重订在途状态
	 * 
	 * @param salesid
	 * @return
	 */
	public List<InTransitPo> getOldInTransitState(String salesid) {
		return inTransitDetailsDao.getOldInTransitState(salesid);
	}
	

	/**
	 * 取得配镜单付款信息
	 * 
	 * @param salesid
	 * @return
	 */
	public List<SalesLogPo> getSalesLog(String salesid) {
		return inTransitDetailsDao.getSalesLog(salesid);
	}
	
	/**
	 *  使用条码非带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByNotBatch(InventoryEntryPo po){
		return inTransitDetailsDao.getStorageNumByNotBatch(po);
	}
	
	/**
	 *  使用条码带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByBatch(InventoryEntryPo po){
		return inTransitDetailsDao.getStorageNumByBatch(po);
	}
	
	/**
	 *  不使用条码（负库存出库）
	 */
	public int getStorageNumByGoodsID(InventoryEntryPo po){
		return inTransitDetailsDao.getStorageNumByGoodsID(po);
	}
	
	/**
	 *  根据仓位获取所在门店
	 */
	public DepartmentsPo getDepartmentByWarehouse(InventoryPo po){
		return inTransitDetailsDao.getDepartmentByWarehouse(po);
	}
	
	/**
	 *  根据商品代码判断是否使用批号
	 */
	public GoodsCategoryPo getGoodsContainBatch(InventoryEntryPo po){
		return inTransitDetailsDao.getGoodsContainBatch(po);
	}
	
	/**
	 *  使用条码非带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByNotBatch(TracEntryPo po){
		
		InventoryEntryPo entryPo = new InventoryEntryPo();
		entryPo.setCstieoutstockid(po.getCstieoutstockid());
		entryPo.setCstiegoodsid(po.getCstiegoodsid());
		entryPo.setCstiebarcode(po.getCstiebarcode());
		
		return inTransitDetailsDao.getStorageNumByNotBatch(entryPo);
	}
	
	/**
	 *  使用条码带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByBatch(TracEntryPo po){
		
		InventoryEntryPo entryPo = new InventoryEntryPo();
		entryPo.setCstieoutstockid(po.getCstieoutstockid());
		entryPo.setCstiegoodsid(po.getCstiegoodsid());
		entryPo.setCstiebarcode(po.getCstiebarcode());
		
		return inTransitDetailsDao.getStorageNumByBatch(entryPo);
	}
	
	/**
	 *  不使用条码（负库存出库）
	 */
	public int getStorageNumByGoodsID(TracEntryPo po){
		
		InventoryEntryPo entryPo = new InventoryEntryPo();
		entryPo.setCstieoutstockid(po.getCstieoutstockid());
		entryPo.setCstiegoodsid(po.getCstiegoodsid());
		
		return inTransitDetailsDao.getStorageNumByGoodsID(entryPo);
	}
	
	/**
	 *  使用条码非带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByNotBatch(AllocationEntryPo po){
		
		InventoryEntryPo entryPo = new InventoryEntryPo();
		entryPo.setCstieoutstockid(po.getCshaaoutstockid());
		entryPo.setCstiegoodsid(po.getCshaaegoodsid());
		entryPo.setCstiebarcode(po.getCshaaegoodsBarCode());
		
		return inTransitDetailsDao.getStorageNumByNotBatch(entryPo);
	}
	
	/**
	 *  使用条码带批号商品判断是否有库存（负库存出库）
	 */
	public int getStorageNumByBatch(AllocationEntryPo po){
		
		InventoryEntryPo entryPo = new InventoryEntryPo();
		entryPo.setCstieoutstockid(po.getCshaaoutstockid());
		entryPo.setCstiegoodsid(po.getCshaaegoodsid());
		entryPo.setCstiebarcode(po.getCshaaegoodsBarCode());
		
		return inTransitDetailsDao.getStorageNumByBatch(entryPo);
	}
	
	/**
	 *  不使用条码（负库存出库）
	 */
	public int getStorageNumByGoodsID(AllocationEntryPo po){
		
		InventoryEntryPo entryPo = new InventoryEntryPo();
		entryPo.setCstieoutstockid(po.getCshaaoutstockid());
		entryPo.setCstiegoodsid(po.getCshaaegoodsid());
		
		return inTransitDetailsDao.getStorageNumByGoodsID(entryPo);
	}
	
	public int getSalesBasicInfoByID(SalesBasicPo salesBasicPo){
		return inTransitDetailsDao.getSalesBasicInfoByID(salesBasicPo);
	}
	
	public SalesBasicPo getSalesBasicInfo(SalesBasicPo salesBasicPo){
		if (inTransitDetailsDao.getSalesBasicInfoByID(salesBasicPo) == 0){	
			 
			return inTransitDetailsDao.getSalesBasicInfoFinished(salesBasicPo);
		}	
		return inTransitDetailsDao.getSalesBasicInfo(salesBasicPo);
	}
	
	/**
	 * 只有待结款的单子才能调用
	 */
	public List<SalesDetailPo> getGoodsInfoNoFinished(SalesDetailPo salesDetailPo) {
		return inTransitDetailsDao.getGoodsInfoNoFinished(salesDetailPo);
	}
	
	/**
	 * 根据配镜单号获取配送人员姓名
	 */
	public String getPsNameInfo(String salesid,String psType){
		if (inTransitDetailsDao.getPsNameInfoCount(salesid,psType) > 0 ){
			return inTransitDetailsDao.getPsNameInfo(salesid,psType);
		}else{
			return "";
		}		
	}
	
}
