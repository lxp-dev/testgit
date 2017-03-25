package com.pengsheng.eims.storage.dao;

import java.util.List;
import java.util.Map;

import com.pengsheng.eims.basic.persistence.GoodsDetailsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.persistence.StockSearchWarehousePo;
import com.pengsheng.eims.storage.persistence.StrogeLogPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

/**
 * 库存查询dao接口
 */
public interface StockSearchDao {
	/**
	 * 获取库存综合查询的数量
	 * @param po 商品po
	 * @return int 数量
	 */	
	public Map<String, Object> getStockSearchCount(GoodsInfoPo po);
	public Map<String, Object> getStockSearchCodeCount(GoodsInfoPo po);
	public Map<String, Object>  getSalseSearchLsCount(GoodsDetailsInfoPo po);
	public List<GoodsDetailsInfoPo> getSalseSearchLsList(GoodsDetailsInfoPo po,int start,int size) ;
	/**
	 * 获取库存综合查询的数量
	 * @param po 商品po
	 * @return int 数量
	 */	
	public Map<String, Object> getStockSearchAnyTimeCount(GoodsInfoPo po);
	/**
	 * 获取库存综合查询的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */		
	public List<GoodsInfoPo> getStockSearchList(GoodsInfoPo po,int start, int size);
	/**
	 * 获取库存综合查询的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */		
	public List<GoodsInfoPo> getStockSearchCodeList(GoodsInfoPo po,int start, int size);
	/**
	 * 获取库存综合查询的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */		
	public List<GoodsInfoPo> getStockSearchAnyTimeList(GoodsInfoPo po,int start, int size);
	

	/**
	 * 获取库存综合查询(品种)的数量
	 * @param po 商品po
	 * @return int 数量
	 */		
	public Map<String, Object> getStockSearchBrandCount(GoodsInfoPo po);
	/**
	 * 获取库存综合查询(品种)的数量
	 * @param po 商品po
	 * @return int 数量
	 */		
	public Map<String, Object> getStockSearchBrandAnyTimeCount(GoodsInfoPo po);
	/**
	 * 获取库存综合查询(品种)的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */	
	public List<GoodsInfoPo> getStockSearchBrandList(GoodsInfoPo po,int start, int size);
	/**
	 * 获取库存综合查询(品种)的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */	
	public List<GoodsInfoPo> getStockSearchBrandAnyTimeList(GoodsInfoPo po,int start, int size);
	
	/**
	 * 获取库存详细查询的数量
	 * 沈兴贺2011-4-29
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getStockSearchDetailsCount(GoodsDetailsInfoPo po,PersonInfoPo personInfoPo);

	/**
	 * 获取库存详细查询的list
	 * @param po 沈兴贺2011-4-29
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */	
	public List<GoodsDetailsInfoPo> getStockSearchDetailsList(GoodsDetailsInfoPo po,PersonInfoPo personInfoPo,int start,
			int size);
	
	/**
	 * 获取库存预警查询的数量
	 * @param po 商品po
	 * @return int 数量
	 */	
	public int getStockAlertCount(GoodsInfoPo po);
	/**
	 * 获取库存预警查询的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */		
	public List<GoodsInfoPo> getStockAlertList(GoodsInfoPo po,int start, int size);
	
	public List<GoodsInfoPo> getStockAlertList(GoodsInfoPo po);
	
	/**
	 * 获取隐形效期查询的数量
	 * sxh 2012-08-30
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getStockSearchInvisibleCount(GoodsDetailsInfoPo po);
	
	/**
	 * 获取隐形效期查询的list
	 * sxh 2012-08-30
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsDetailsInfoPo> getStockSearchInvisibleList(GoodsDetailsInfoPo po,int start,int size);
	
	/**
	 * 获取库存综合查询（仓位）数量
	 * @param po 商品po
	 * @return int 数量
	 */
	public int selectGoodsIdCount(GoodsInfoPo po);
	
	/**
	 * 获取库存综合查询（仓位）list
	 * @param po
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List selectStockSearchWarehouseList(GoodsInfoPo po,PersonInfoPo personInfoPo ,int start,int size);
	
	/**
	 * 取得门店、加工、配送类型的仓位名称
	 * @return
	 */
	public List<StockSearchWarehousePo> selectWarehouseId(String isClosed,String warehouseID);
	
	/**
	 * 获取库存综合查询（仓位）获取总数
	 * @param po
	 * @return
	 */
	public int selectGoodsIdSum(GoodsInfoPo po);
	
	/**
	 * 获取商品信息
	 */
	public GoodsInfoPo getStockGoodsInfoPo(GoodsInfoPo po);
	
	/**
	 * 商品库存流水查询数量
	 * 沈兴贺2011-4-29
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getStockSearchLsCount(GoodsDetailsInfoPo po);
	public Map<String, Object>  getStockSearchLsCount2(GoodsDetailsInfoPo po);
	/**
	 * 商品库存流水查询list
	 * 沈兴贺 2011-11-28
	 * @param po
	 * 商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsDetailsInfoPo> getStockSearchLsList(GoodsDetailsInfoPo po,int start,int size);
	public List<GoodsDetailsInfoPo> getStockSearchLsList2(GoodsDetailsInfoPo po,int start,int size);
	/**
	 * 根据商品代码查询库存流水
	 */
	public List<StrogeLogPo> getGoodsStrogeList(StrogeLogPo po);
	
	/**
	 * 获取期初商品信息
	 */
	public GoodsDetailsInfoPo getFirstStockGoodsInfoPo(GoodsDetailsInfoPo po);
	
	/**
	 * 获取商品库存数量
	 */
	public GoodsDetailsInfoPo getEndStockGoodsInfoPo(GoodsDetailsInfoPo po);
	
	public GoodsInfoPo getStorageAlertGoodsInfoPo(GoodsInfoPo po);
	public GoodsInfoPo getStorageAnyTimerGoodsQ(GoodsInfoPo po);
	public GoodsInfoPo getStorageAnyTimerBrandQ(GoodsInfoPo po);
	
	public Map<String, Object> getStockAgeSearchCount(GoodsInfoPo po,PersonInfoPo personInfoPo);
	
	public List<GoodsInfoPo> getStockAgeSearchList(GoodsInfoPo po,PersonInfoPo personInfoPo,int start, int size);
}
