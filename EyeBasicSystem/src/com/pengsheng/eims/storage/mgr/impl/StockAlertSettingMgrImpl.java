/**
 * 
 */
package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.storage.dao.StockAlertSettingDao;
import com.pengsheng.eims.storage.mgr.StockAlertSettingMgr;
import com.pengsheng.eims.storage.persistence.StockAlertSettingPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

/**
 * @author Liuqian
 * 
 */
public class StockAlertSettingMgrImpl implements StockAlertSettingMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private StockAlertSettingDao stockAlertSettingDao;

	public StockAlertSettingDao getStockAlertSettingDao() {
		return stockAlertSettingDao;
	}


	public StockAlertSettingPo getStockAlertSettingPo(String id) {
		return stockAlertSettingDao.getStockAlertSettingPo(id);
	}


	public List<StockAlertSettingPo> getStrockAlerInfo(
			StockAlertSettingPo stockAlertSettingPo, int start, int size) {
		return stockAlertSettingDao.getStrockAlerInfo(stockAlertSettingPo,
				start, size);
	}


	public int getStrockAlerInfoCount(StockAlertSettingPo stockAlertSettingPo) {
		return stockAlertSettingDao.getStrockAlerInfoCount(stockAlertSettingPo);
	}

	public void setStockAlertSettingDao(
			StockAlertSettingDao stockAlertSettingDao) {
		this.stockAlertSettingDao = stockAlertSettingDao;
	}


	public void updateStockAlertSettings(StockAlertSettingPo po,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub

		// 删除品种库存上下限
		stockAlertSettingDao.delStockAlertSettings(po);

		// 新增库存
		stockAlertSettingDao.insertStockAlertSettings(po);
		logisticsLogDao.insertLog(logPo); //添加日志

	}


	public void updateGoodsStockAlert(StockAlertSettingPo stockAlertSettingPo,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		stockAlertSettingDao.updateGoodsStockAlert(stockAlertSettingPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	
	/**
	 * 批量删除修改
	 * 
	 * @param stockAlertSettingPo
	 */
	public void batchUpdateSettings(StockAlertSettingPo po,LogisticsLogPo logPo){
		
		String[] bills = Utility.getName(po.getCsasaid()).split(",");
		for (int i = 0; i < bills.length; i++){
			po.setCsasaid(bills[i]);
			stockAlertSettingDao.updateGoodsStockAlert(po);			
		}

		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 批量删除
	 * 
	 * @param stockAlertSettingPo
	 */
	public void batchDeteleSettings(StockAlertSettingPo po,LogisticsLogPo logPo){
		
		String[] bills = Utility.getName(po.getCsasaid()).split(",");
		for (int i = 0; i < bills.length; i++){
			stockAlertSettingDao.batchDeteleSettings(bills[i]);			
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public List<GoodsInfoPo> selectDimensionPos(List<GoodsInfoPo> gpoList,String goodsID){

		String[] goodsArray = goodsID.split(",");
		int count = 0;
		for (int i = 0; i < goodsArray.length; i++){
			GoodsInfoPo gpo = new GoodsInfoPo();
			gpo.setBgigoodsid(goodsArray[i]);			
			gpo = stockAlertSettingDao.selectDimensionPos(gpo);
			
			for (int j = 0; j < gpoList.size(); j++){
				if (Utility.getName(gpoList.get(j).getBgigoodsid()).equals(goodsArray[i])){
					count = 1;
					break;
				}
			}
			
			if (count == 0){
				gpoList.add(gpo);
			}
			
		}
		
		
		return gpoList;
	}
	
	/**
	 * 更新、新增品种库存上下限(二维)
	 */
	public void updateStockAlertSettings2D(List<StockAlertSettingPo> poList,LogisticsLogPo logPo){
		
		for (StockAlertSettingPo spo : poList){
			stockAlertSettingDao.deleteStockAlertSetting2D(spo);
			stockAlertSettingDao.insertStockAlertSetting(spo);
		}
		
	}
	
}
