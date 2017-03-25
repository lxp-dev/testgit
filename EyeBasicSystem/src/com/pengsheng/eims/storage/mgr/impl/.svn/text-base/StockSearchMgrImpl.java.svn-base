package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;
import java.util.Map;

import com.pengsheng.eims.basic.persistence.GoodsDetailsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.dao.StockSearchDao;
import com.pengsheng.eims.storage.mgr.StockSearchMgr;
import com.pengsheng.eims.storage.persistence.StockSearchWarehousePo;
import com.pengsheng.eims.storage.persistence.StrogeLogPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
/**
 * 库存查询mgr接口
 */
public class StockSearchMgrImpl implements StockSearchMgr {

	private StockSearchDao stockSearchDao;
	
	public StockSearchDao getStockSearchDao() {
		return stockSearchDao;
	}
	
	
	
	public void setStockSearchDao(StockSearchDao stockSearchDao) {
		this.stockSearchDao = stockSearchDao;
	}
	/**
	 * 获取库存综合查询的数量
	 * @param po 商品po
	 * @return int 数量
	 */	
	public Map<String, Object> getStockSearchCount(GoodsInfoPo po) {
		return stockSearchDao.getStockSearchCount(po);
	}
	/**
	 * 获取库存综合查询的数量
	 * @param po 商品po
	 * @return int 数量
	 */	
	public Map<String, Object> getStockSearchCodeCount(GoodsInfoPo po) {
		return stockSearchDao.getStockSearchCodeCount(po);
	}
	/**
	 * 获取库存综合查询的数量
	 * @param po 商品po
	 * @return int 数量
	 */	
	public Map<String, Object> getStockSearchAnyTimeCount(GoodsInfoPo po) {
		return stockSearchDao.getStockSearchAnyTimeCount(po);
	}
	/**
	 * 获取库存综合查询的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */	
	public List<GoodsInfoPo> getStockSearchList(GoodsInfoPo po,int start,
			int size) {

		return stockSearchDao.getStockSearchList(po,start, size);
	}
	/**
	 * 获取库存综合查询的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */	
	public List<GoodsInfoPo> getStockSearchCodeList(GoodsInfoPo po,int start,
			int size) {

		return stockSearchDao.getStockSearchCodeList(po,start, size);
	}
	/**
	 * 获取库存综合查询的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */	
	public List<GoodsInfoPo> getStockSearchAnyTimeList(GoodsInfoPo po,int start,
			int size) {

		return stockSearchDao.getStockSearchAnyTimeList(po,start, size);
	}

	/**
	 * 获取库存综合查询(品种)的数量
	 * @param po 商品po
	 * @return int 数量
	 */		
	public Map<String, Object> getStockSearchBrandCount(GoodsInfoPo po) {
		
		return stockSearchDao.getStockSearchBrandCount(po);
	}
	/**
	 * 获取库存综合查询(品种)的数量
	 * @param po 商品po
	 * @return int 数量
	 */		
	public Map<String, Object> getStockSearchBrandAnyTimeCount(GoodsInfoPo po) {
		
		return stockSearchDao.getStockSearchBrandAnyTimeCount(po);
	}
	/**
	 * 获取库存综合查询(品种)的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */	
	public List<GoodsInfoPo> getStockSearchBrandList(GoodsInfoPo po,int start, int size) {

		return stockSearchDao.getStockSearchBrandList(po,start, size);
	}
	/**
	 * 获取库存综合查询(品种)的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */	
	public List<GoodsInfoPo> getStockSearchBrandAnyTimeList(GoodsInfoPo po,int start, int size) {

		return stockSearchDao.getStockSearchBrandAnyTimeList(po, start, size);
	}
	/**
	 * 获取库存详细查询的数量
	 * 沈兴贺2011-4-29
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getStockSearchDetailsCount(GoodsDetailsInfoPo po,PersonInfoPo personInfoPo) {
		return stockSearchDao.getStockSearchDetailsCount(po,personInfoPo);
	}

	public List<GoodsDetailsInfoPo> getStockSearchDetailsList(GoodsDetailsInfoPo po,PersonInfoPo personInfoPo,int start,
			int size) {
		return stockSearchDao.getStockSearchDetailsList(po,personInfoPo, start, size);
	}
	/**
	 * 获取库存预警查询的数量
	 * @param po 商品po
	 * @return int 数量
	 */
	public int getStockAlertCount(GoodsInfoPo po) {
		return stockSearchDao.getStockAlertCount(po);
	}
	/**
	 * 获取库存预警查询的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getStockAlertList(GoodsInfoPo po, int start,
			int size) {
		return stockSearchDao.getStockAlertList(po, start, size);
	}
	
	public List<GoodsInfoPo> getStockAlertList(GoodsInfoPo po){
		return stockSearchDao.getStockAlertList(po);
	}
	
	/**
	 * 获取隐形效期查询的数量
	 * sxh 2012-08-30
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getStockSearchInvisibleCount(GoodsDetailsInfoPo po){
		return stockSearchDao.getStockSearchInvisibleCount(po);
	}
	
	/**
	 * 获取隐形效期查询的list
	 * sxh 2012-08-30
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsDetailsInfoPo> getStockSearchInvisibleList(GoodsDetailsInfoPo po,int start,int size){
		return stockSearchDao.getStockSearchInvisibleList(po, start, size);
	}
	
	/**
	 * 获取库存综合查询（仓位）数量
	 * @param po 商品po
	 * @return int 数量
	 */
	public int selectGoodsIdCount(GoodsInfoPo po){
		return stockSearchDao.selectGoodsIdCount(po);
	}
	
	/**
	 * 获取库存综合查询（仓位）list
	 * @param po
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List selectStockSearchWarehouseList(GoodsInfoPo po,PersonInfoPo personInfoPo ,int start,int size){
		return stockSearchDao.selectStockSearchWarehouseList(po, personInfoPo, start, size);
	}
	
	/**
	 * 取得门店、加工、配送类型的仓位名称
	 * @return
	 */
	public List<StockSearchWarehousePo> selectWarehouseId(String isClosed,String warehouseID){
		return stockSearchDao.selectWarehouseId(isClosed,warehouseID);
	}
	
	/**
	 * 获取库存综合查询（仓位）获取总数
	 * @param po
	 * @return
	 */
	public int selectGoodsIdSum(GoodsInfoPo po){
		return stockSearchDao.selectGoodsIdSum(po);
	}
	
	/**
	 * 获取商品信息
	 */
	public GoodsInfoPo getStockGoodsInfoPo(GoodsInfoPo po){
		return stockSearchDao.getStockGoodsInfoPo(po);
	}
	
	/**
	 * 商品库存流水查询数量
	 * 沈兴贺2011-4-29
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getStockSearchLsCount(GoodsDetailsInfoPo po){
		return stockSearchDao.getStockSearchLsCount(po);
	}
	public Map<String, Object>  getStockSearchLsCount2(GoodsDetailsInfoPo po){
		return stockSearchDao.getStockSearchLsCount2(po);
	}
	public Map<String, Object>  getSalseSearchLsCount(GoodsDetailsInfoPo po){
		return stockSearchDao.getSalseSearchLsCount(po);
	}
	public List<GoodsDetailsInfoPo> getSalseSearchLsList(GoodsDetailsInfoPo po,int start,int size) {
		return stockSearchDao.getSalseSearchLsList(po, start, size);
	}
	/**
	 * 商品库存流水查询list
	 * 沈兴贺 2011-11-28
	 * @param po
	 * 商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsDetailsInfoPo> getStockSearchLsList(GoodsDetailsInfoPo po,int start,int size){
		return stockSearchDao.getStockSearchLsList(po, start, size);
	}

	public List<GoodsDetailsInfoPo> getStockSearchLsList2(GoodsDetailsInfoPo po,int start,int size){
		return stockSearchDao.getStockSearchLsList2(po, start, size);
	}
	
	/**
	 * 根据商品代码查询库存流水
	 */
	public List<StrogeLogPo> getGoodsStrogeList(StrogeLogPo po){
		return stockSearchDao.getGoodsStrogeList(po);
	}
	
	/**
	 * 获取期初商品信息
	 */
	public GoodsDetailsInfoPo getFirstStockGoodsInfoPo(GoodsDetailsInfoPo po){
		return stockSearchDao.getFirstStockGoodsInfoPo(po);
	}
	
	/**
	 * 获取商品库存数量
	 */
	public GoodsDetailsInfoPo getEndStockGoodsInfoPo(GoodsDetailsInfoPo po){
		return stockSearchDao.getEndStockGoodsInfoPo(po);
	}
	
	public GoodsInfoPo getStorageAlertGoodsInfoPo(GoodsInfoPo po){
		return stockSearchDao.getStorageAlertGoodsInfoPo(po);
	}
	public GoodsInfoPo getStorageAnyTimerGoodsQ(GoodsInfoPo po){
		return stockSearchDao.getStorageAnyTimerGoodsQ(po);
	}
	public GoodsInfoPo getStorageAnyTimerBrandQ(GoodsInfoPo po){
		return stockSearchDao.getStorageAnyTimerBrandQ(po);
	}
	
	
	public Map<String, Object> getStockAgeSearchCount(GoodsInfoPo po,
			PersonInfoPo personInfoPo) {
		
		return stockSearchDao.getStockAgeSearchCount(po, personInfoPo);
	}
	
	
	public List<GoodsInfoPo> getStockAgeSearchList(GoodsInfoPo po,
			PersonInfoPo personInfoPo, int start, int size) {
		
		return stockSearchDao.getStockAgeSearchList(po, personInfoPo, start, size);
	}

}
