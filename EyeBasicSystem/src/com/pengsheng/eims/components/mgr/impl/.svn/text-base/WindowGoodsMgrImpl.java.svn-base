package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.components.dao.WindowGoodsDao;
import com.pengsheng.eims.components.mgr.WindowGoodsMgr;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 商品开窗mgr 实现类
 */
public class WindowGoodsMgrImpl implements WindowGoodsMgr {

	private WindowGoodsDao windowGoodsDao;
	private ProcurementReceiptDao procurementReceiptDao;
	private InTransitDetailsDao inTransitDetailsDao;
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public ProcurementReceiptDao getProcurementReceiptDao() {
		return procurementReceiptDao;
	}

	public void setProcurementReceiptDao(
			ProcurementReceiptDao procurementReceiptDao) {
		this.procurementReceiptDao = procurementReceiptDao;
	}

	public WindowGoodsDao getWindowGoodsDao() {
		return windowGoodsDao;
	}

	public void setWindowGoodsDao(WindowGoodsDao windowGoodsDao) {
		this.windowGoodsDao = windowGoodsDao;
	}
	public List<AllocationPo> getGoodsSingleAllListss(AllocationPo po, int start,int size){
		return windowGoodsDao.getGoodsSingleAllListss(po, start, size);
	}
	public int getGoodsSingleAllCountss(AllocationPo po) {
		return windowGoodsDao.getGoodsSingleAllCountss(po);
	}
	/**
	 * 获取商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsSingleCount(GoodsInfoPo po) {
		return windowGoodsDao.getGoodsSingleCount(po);
	}

	public int getGoodsSingleForAllocationCount(GoodsInfoPo po) {
		return windowGoodsDao.getGoodsSingleForAllocationCount(po);
	}
	
	public int getGoodsSingleExchangeCount(GoodsInfoPo po) {
		return windowGoodsDao.getGoodsSingleExchangeCount(po);
	}
	
	public int getGoodsSingleCountGifts(GoodsInfoPo po) {
		return windowGoodsDao.getGoodsSingleCountGifts(po);
	}

	/**
	 * 获取商品开窗的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getGoodsSingleList(GoodsInfoPo po, int start,
			int size) {
		List<GoodsInfoPo> goodsList = windowGoodsDao.getGoodsSingleList(po,start, size);
		return goodsList;
	}

	public List<GoodsInfoPo> getGoodsSingleForAllocationList(GoodsInfoPo po, int start,
			int size) {
		List<GoodsInfoPo> goodsList = windowGoodsDao.getGoodsSingleForAllocationList(po,start, size);
		return goodsList;
	}
	public List<GoodsInfoPo> getGoodsSingleExchangeList(GoodsInfoPo po, int start,
			int size) {
		List<GoodsInfoPo> goodsList = windowGoodsDao.getGoodsSingleExchangeList(po,
				start, size);
		/*for (int i = 0; i < goodsList.size(); i++) {
			GoodsInfoPo goodsInfoPo = goodsList.get(i);
			String pcBarcode = procurementReceiptDao
					.getGoodsBarCode(goodsInfoPo.getBgigoodsbarcode());
			goodsInfoPo.setBgipcbarcode(pcBarcode);
		}*/
		return goodsList;
	}
	
	public List<GoodsInfoPo> getGoodsSingleGiftsList(GoodsInfoPo po, int start,int size) {
		return windowGoodsDao.getGoodsSingleGiftsList(po,start, size);
	}

	/**
	 * 获取库存预警的商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsAlertCount(GoodsInfoPo po) {
		int i=0;
//		long start = System.currentTimeMillis();
		i=windowGoodsDao.getGoodsAlertCount(po);
//		System.out.println("USE: " + (System.currentTimeMillis() - start)/1000f+" 秒 ");
		return i;
	}

	/**
	 * 获取库存预警的商品开窗的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getGoodsAlertList(GoodsInfoPo po, int start,
			int size) {

		return windowGoodsDao.getGoodsAlertList(po, start, size);
	}

	/**
	 * 获取批量商品数量
	 */
	public int getMoreAdjuestmentPriceCount(GoodsInfoPo po) {
		return windowGoodsDao.getMoreAdjuestmentPriceCount(po);
	}

	/**
	 * 获取批量商品List
	 */
	public List<GoodsInfoPo> getMoreAdjustmentPriceList(GoodsInfoPo po,
			int start, int size) {
		return windowGoodsDao.getMoreAdjustmentPriceList(po, start, size);
	}

	
	public int getGoodsSingleAllCount(GoodsInfoPo po) {
		return windowGoodsDao.getGoodsSingleAllCount(po);
	}


	public List<GoodsInfoPo> getGoodsSingleAllList(GoodsInfoPo po, int start,
			int size) {
		return windowGoodsDao.getGoodsSingleAllList(po, start, size);
	}

	
	public int getGoodsSingleAllCount(AllocationPo po) {
		
		return windowGoodsDao.getGoodsSingleAllCount1(po);
	}
	
	public int getGoodsSingleAllCount1(AllocationPo po) {
		
		return windowGoodsDao.getGoodsSingleAllCount2(po);
	}
	
	public int getGoodsSingleAllCount2(AllocationPo po) {
		
		return windowGoodsDao.getGoodsSingleAllCount3(po);
	}
	
	public int getGoodsSingleAllCountTui(AllocationPo po) {
		
		return windowGoodsDao.getGoodsSingleAllCountTui(po);
	}
	
	public int getGoodsSingleAllCountOut(AllocationPo po) {
		
		return windowGoodsDao.getGoodsSingleAllCountOut(po);
	}
	
	public int getGoodsReceiptCount(InventoryPo po) {
		
		return windowGoodsDao.getGoodsReceiptCount(po);
	}
	
	public List<InventoryPo> getGoodsReceiptList(InventoryPo po, int start,
			int size) {
		
		return windowGoodsDao.getGoodsReceiptList(po, start, size);
	}

	
	public List<AllocationPo> getGoodsSingleAllList(AllocationPo po, int start,
			int size) {
		
		return windowGoodsDao.getGoodsSingleAllList1(po, start, size);
	}
	
	public List<AllocationPo> getGoodsSingleAllList1(AllocationPo po, int start,
			int size) {
		
		return windowGoodsDao.getGoodsSingleAllList2(po, start, size);
	}
	public List<AllocationPo> getGoodsSingleAllList2(AllocationPo po, int start,
			int size) {
		
		return windowGoodsDao.getGoodsSingleAllList3(po, start, size);
	}
	
	public List<AllocationPo> getGoodsSingleAllListTui(AllocationPo po, int start,int size) {
		
		return windowGoodsDao.getGoodsSingleAllListTui(po, start, size);
	}
	
	public List<AllocationPo> getGoodsSingleAllListOut(AllocationPo po, int start,
			int size) {
		
		return windowGoodsDao.getGoodsSingleAllListOut(po, start, size);
	}

	public List<GoodsInfoPo> getGoodsSingleGiftsBatchList(GoodsInfoPo po, int start,int size){
		return windowGoodsDao.getGoodsSingleGiftsBatchList(po,start,size);
	}
	
	public int getGoodsSingleCountGiftsBatch(GoodsInfoPo po){
		return windowGoodsDao.getGoodsSingleCountGiftsBatch(po);
	}

	public int getGoodsSingleZTCount(GoodsInfoPo po) {
		return windowGoodsDao.getGoodsSingleZTCount(po);
	}

	public List<GoodsInfoPo> getGoodsSingleZTList(GoodsInfoPo po, int start,
			int size) {
		return windowGoodsDao.getGoodsSingleZTList(po, start, size);
	}
	
	/**
	 * 获取商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsSingleBPCount(GoodsInfoPo po) {
		return windowGoodsDao.getGoodsSingleBPCount(po);
	}
	
	/**
	 * 获取商品开窗的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getGoodsSingleBPList(GoodsInfoPo po, int start,
			int size) {
		return  windowGoodsDao.getGoodsSingleBPList(po,start, size);
	}
	/**
	 * 获取商品品种的数量
	 */	
	public int getBrandPriceCount(BrandPo brandPo){
		return  windowGoodsDao.getBrandPriceCount(brandPo);
	}
	/**
	 * 获取商品品种的List
	 */	
	public List<BrandPo> getBrandPriceList(BrandPo brandPo, int start,int size){
		
		return  windowGoodsDao.getBrandPriceList(brandPo,start, size);		
	}
	/**
	 * 获取商品品种的数量
	 */	
	public int getBrandPriceCount2(BrandPo brandPo){
		
		return  windowGoodsDao.getBrandPriceCount2(brandPo);
	}
	
	public int getManyBrandPriceCountOpen(BrandPo brandPo){
		return  windowGoodsDao.getManyBrandPriceCountOpen(brandPo);
	}
	
	/**
	 * 获取商品品种的List
	 */	
	public List<BrandPo> getBrandPriceList2(BrandPo brandPo, int start,int size){
		
		return  windowGoodsDao.getBrandPriceList2(brandPo,start, size);		
	}
	
	public List<BrandPo> getManyBrandPriceOpenList(BrandPo brandPo, int start,int size){
		return  windowGoodsDao.getManyBrandPriceOpenList(brandPo,start, size);		
	}
	
	/**
	 * 获取商品品种的数量
	 */	
	public int getBrandPriceCount3(BrandPo brandPo){
		return  windowGoodsDao.getBrandPriceCount3(brandPo);
	}
	/**
	 * 获取商品品种的List
	 */	
	public List<BrandPo> getBrandPriceList3(BrandPo brandPo, int start,int size){
		return  windowGoodsDao.getBrandPriceList3(brandPo,start, size);		
	}
	
	/**
	 * 获取商品的数量
	 */	
	public int getGoodsInfoCountForSOUT(GoodsInfoPo po){
		return  windowGoodsDao.getGoodsInfoCountForSOUT(po);
	}
	/**
	 * 获取商品List
	 */	
	public List<GoodsInfoPo> getGoodsInfoListForSOUT(GoodsInfoPo po, int start,int size){
		return  windowGoodsDao.getGoodsInfoListForSOUT(po, start, size);
	}
	
	/**
	 * 获取类别List
	 */	
	public List<GoodsCategoryPo> getGoodsInfoListForSOUTCategory(GoodsInfoPo po){
		return  windowGoodsDao.getGoodsInfoListForSOUTCategory(po);
	}
	
	/**
	 * 获取制造商List
	 */	
	public List<SupplierPo> getGoodsInfoListForSOUTSupplier(GoodsInfoPo po){
		return  windowGoodsDao.getGoodsInfoListForSOUTSupplier(po);
	}
	
	/**
	 * 获取品种List
	 */	
	public List<BrandPo> getGoodsInfoListForSOUTBrand(GoodsInfoPo po){
		return  windowGoodsDao.getGoodsInfoListForSOUTBrand(po);
	}
	
	public int getBrandCountForReturn(BrandPo po){
		return  windowGoodsDao.getBrandCountForReturn(po);
	}
	
	public List<BrandPo> getBrandListForReturn(BrandPo po,int start,int size){
		return  windowGoodsDao.getBrandListForReturn(po, start, size);
	}

	public int getBrandPriceCount4(BrandPo brandPo) {
		return windowGoodsDao.getBrandPriceCount4(brandPo);
	}

	public List<BrandPo> getBrandPriceList4(BrandPo brandPo, int start, int size) {
		return windowGoodsDao.getBrandPriceList4(brandPo, start, size);
	}

	public int getGoodsSingleAllCountForApp(AllocationPo po) {
		return windowGoodsDao.getGoodsSingleAllCountForApp(po);
	}

	public List<AllocationPo> getGoodsSingleAllListForApp(AllocationPo po,
			int start, int size) {
		return windowGoodsDao.getGoodsSingleAllListForApp(po, start, size);
	}
}
