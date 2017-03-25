package com.pengsheng.eims.components.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 商品开窗dao 接口
 */
public interface WindowGoodsDao {
	/**
	 * 获取商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsSingleCount(GoodsInfoPo po);
	public List<AllocationPo> getGoodsSingleAllListss(AllocationPo po, int start,int size);
	public int getGoodsSingleAllCountss(AllocationPo po) ;
	
	public int getGoodsSingleForAllocationCount(GoodsInfoPo po);
	
	public int getGoodsSingleZTCount(GoodsInfoPo po);
	
	public int getGoodsSingleExchangeCount(GoodsInfoPo po);
	
	
	public int getGoodsSingleCountGifts(GoodsInfoPo po);

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
			int size);

	public List<GoodsInfoPo> getGoodsSingleForAllocationList(GoodsInfoPo po, int start,
			int size);
	
	public List<GoodsInfoPo> getGoodsSingleZTList(GoodsInfoPo po, int start,
			int size);
	
	public List<GoodsInfoPo> getGoodsSingleExchangeList(GoodsInfoPo po, int start,
			int size);
	
	public List<GoodsInfoPo> getGoodsSingleGiftsList(GoodsInfoPo po, int start,
			int size);

	/**
	 * 获取商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsSingleAllCount(GoodsInfoPo po);
	public int getGoodsSingleAllCount1(AllocationPo po);
	public int getGoodsSingleAllCountForApp(AllocationPo po);
	public int getGoodsSingleAllCount2(AllocationPo po);
	public int getGoodsSingleAllCount3(AllocationPo po);
	public int getGoodsSingleAllCountTui(AllocationPo po);
	public int getGoodsSingleAllCountOut(AllocationPo po);
	
	public int getGoodsReceiptCount(InventoryPo po);
	public List<InventoryPo> getGoodsReceiptList(InventoryPo po, int start,
			int size);

	/**
	 * 获取商品开窗的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getGoodsSingleAllList(GoodsInfoPo po, int start,
			int size);
	public List<AllocationPo> getGoodsSingleAllList1(AllocationPo po, int start,
			int size);
	public List<AllocationPo> getGoodsSingleAllListForApp(AllocationPo po, int start,
			int size);
	public List<AllocationPo> getGoodsSingleAllList2(AllocationPo po, int start,
			int size);
	public List<AllocationPo> getGoodsSingleAllList3(AllocationPo po, int start,
			int size);
	
	public List<AllocationPo> getGoodsSingleAllListTui(AllocationPo po, int start,
			int size);
	public List<AllocationPo> getGoodsSingleAllListOut(AllocationPo po, int start,
			int size);

	/**
	 * 获取库存预警的商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsAlertCount(GoodsInfoPo po);

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
			int size);

	public int getMoreAdjuestmentPriceCount(GoodsInfoPo po);

	public List<GoodsInfoPo> getMoreAdjustmentPriceList(GoodsInfoPo po,
			int start, int size);

	public List<GoodsInfoPo> getGoodsSingleGiftsBatchList(GoodsInfoPo po, int start,int size);
	
	public int getGoodsSingleCountGiftsBatch(GoodsInfoPo po);
	
	/**
	 * 获取商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsSingleBPCount(GoodsInfoPo po);


	/**
	 * 获取商品开窗的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getGoodsSingleBPList(GoodsInfoPo po, int start,int size);
	
	/**
	 * 获取商品品种的数量
	 */	
	public int getBrandPriceCount(BrandPo brandPo);
	/**
	 * 获取商品品种的List
	 */	
	public List<BrandPo> getBrandPriceList(BrandPo brandPo, int start,int size);
	/**
	 * 获取商品品种的数量
	 */	
	public int getBrandPriceCount2(BrandPo brandPo);
	public int getManyBrandPriceCountOpen(BrandPo brandPo);
	
	/**
	 * 获取商品品种的List
	 */	
	public List<BrandPo> getBrandPriceList2(BrandPo brandPo, int start,int size);
	public List<BrandPo> getManyBrandPriceOpenList(BrandPo brandPo, int start,int size);
	
	/**
	 * 获取商品品种的数量
	 */	
	public int getBrandPriceCount3(BrandPo brandPo);
	/**
	 * 获取商品品种的List
	 */	
	public List<BrandPo> getBrandPriceList3(BrandPo brandPo, int start,int size);

	/**
	 * 获取商品品种的数量(门店预销售设置开窗)
	 */	
	public int getBrandPriceCount4(BrandPo brandPo);
	/**
	 * 获取商品品种的List(门店预销售设置开窗)
	 */	
	public List<BrandPo> getBrandPriceList4(BrandPo brandPo, int start,int size);
	/**
	 * 获取商品的数量
	 */	
	public int getGoodsInfoCountForSOUT(GoodsInfoPo po);
	
	/**
	 * 获取商品List
	 */	
	public List<GoodsInfoPo> getGoodsInfoListForSOUT(GoodsInfoPo po, int start,int size);
	
	/**
	 * 获取类别List
	 */	
	public List<GoodsCategoryPo> getGoodsInfoListForSOUTCategory(GoodsInfoPo po);
	
	/**
	 * 获取制造商List
	 */	
	public List<SupplierPo> getGoodsInfoListForSOUTSupplier(GoodsInfoPo po);
	
	/**
	 * 获取品种List
	 */	
	public List<BrandPo> getGoodsInfoListForSOUTBrand(GoodsInfoPo po);
	
	public int getBrandCountForReturn(BrandPo po);
	
	public List<BrandPo> getBrandListForReturn(BrandPo po,int start,int size);
}
