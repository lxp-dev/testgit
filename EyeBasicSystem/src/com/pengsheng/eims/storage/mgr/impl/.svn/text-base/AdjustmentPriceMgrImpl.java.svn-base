package com.pengsheng.eims.storage.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.quartz.dao.AdjustmentPriceJobDao;
import com.pengsheng.eims.storage.dao.AdjustmentPriceDao;
import com.pengsheng.eims.storage.mgr.AdjustmentPriceMgr;
import com.pengsheng.eims.storage.persistence.AdjustmentPriceEntryPo;
import com.pengsheng.eims.storage.persistence.AdjustmentPricePo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class AdjustmentPriceMgrImpl extends BaseJdbcDaoSupport implements AdjustmentPriceMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	private AdjustmentPriceJobDao adjustmentPriceJobDao = null;
	private AdjustmentPriceDao adjustmentPriceDao;
	private SystemParameterDao systemParameterDao;
	
	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}
	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}
	public AdjustmentPriceJobDao getAdjustmentPriceJobDao() {
		return adjustmentPriceJobDao;
	}
	public void setAdjustmentPriceJobDao(AdjustmentPriceJobDao adjustmentPriceJobDao) {
		this.adjustmentPriceJobDao = adjustmentPriceJobDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	public AdjustmentPriceDao getAdjustmentPriceDao() {
		return adjustmentPriceDao;
	}

	public void setAdjustmentPriceDao(AdjustmentPriceDao adjustmentPriceDao) {
		this.adjustmentPriceDao = adjustmentPriceDao;
	}

	
	public void deleteAdjustmentPrice(AdjustmentPricePo adjustmentPricePo,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		this.adjustmentPriceDao.adjustmentPriceDelete(adjustmentPricePo);
		this.adjustmentPriceDao.adjustmentPriceEntryDelete(adjustmentPricePo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}


	public void adjustmentPriceEntryInsert(
			AdjustmentPriceEntryPo adjustmentPriceEntryPo) {
		// TODO Auto-generated method stub
		
		this.adjustmentPriceDao.adjustmentPriceEntryInsert(adjustmentPriceEntryPo);
	}

	
	public void insertAdjustmentPrice(AdjustmentPricePo adjustmentPricePo,List<AdjustmentPriceEntryPo> adjustmentPriceEntryList,LogisticsLogPo logPo,SystemParameterPo spo) {

		for(int i=0;i<adjustmentPriceEntryList.size();i++){
			AdjustmentPriceEntryPo adjustmentPriceEntryPo=adjustmentPriceEntryList.get(i);
			this.adjustmentPriceDao.adjustmentPriceEntryInsert(adjustmentPriceEntryPo);
		}
		
		adjustmentPriceDao.adjustmentPriceInsert(adjustmentPricePo);
		
		if (Utility.getName(adjustmentPricePo.getCprapflag()).equals("0")){  //实时调价
			if (!Utility.getName(adjustmentPricePo.getCprapauditstate()).equals("0")){
				for(int i=0;i<adjustmentPriceEntryList.size();i++){
					AdjustmentPriceEntryPo adjustmentPriceEntryPo=adjustmentPriceEntryList.get(i);
					adjustmentPriceEntryPo.setCprapewhichprice(adjustmentPricePo.getCprapwhichprice());
					adjustmentPriceJobDao.adjustmentPriceEffective(adjustmentPriceEntryPo);
					
					adjustmentPriceJobDao.updateAdjustmentPriceEffectiveFlySheet(adjustmentPriceEntryPo);
					
					GoodsInfoPo gpo = new GoodsInfoPo();
					gpo.setBgigoodsid(adjustmentPriceEntryPo.getCprapegoodsid());
					systemParameterDao.updateGoodsViewNameForChangePrice(spo, gpo);
				}
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}


	public void updateAdjustmentPrice(AdjustmentPricePo adjustmentPricePo,List<AdjustmentPriceEntryPo> adjustmentPriceEntryList,LogisticsLogPo logPo,SystemParameterPo spo) {

		this.adjustmentPriceDao.adjustmentPriceUpdate(adjustmentPricePo);
		
		this.adjustmentPriceDao.adjustmentPriceEntryDelete(adjustmentPricePo);
		for (int i = 0; i < adjustmentPriceEntryList.size(); i++) {
			AdjustmentPriceEntryPo adjustmentPriceEntryPo=adjustmentPriceEntryList.get(i);
			adjustmentPriceDao.adjustmentPriceEntryInsert(adjustmentPriceEntryPo);
		}
		
		if (Utility.getName(adjustmentPricePo.getCprapflag()).equals("0")){  //实时调价
			if (!Utility.getName(adjustmentPricePo.getCprapauditstate()).equals("0")){
				for(int i = 0;i < adjustmentPriceEntryList.size(); i++){
					AdjustmentPriceEntryPo adjustmentPriceEntryPo=adjustmentPriceEntryList.get(i);
					adjustmentPriceEntryPo.setCprapewhichprice(adjustmentPricePo.getCprapwhichprice());
					adjustmentPriceJobDao.adjustmentPriceEffective(adjustmentPriceEntryPo);
					
					adjustmentPriceJobDao.updateAdjustmentPriceEffectiveFlySheet(adjustmentPriceEntryPo);
					
					GoodsInfoPo gpo = new GoodsInfoPo();
					gpo.setBgigoodsid(adjustmentPriceEntryPo.getCprapegoodsid());
					systemParameterDao.updateGoodsViewNameForChangePrice(spo, gpo);
				}
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}


	public int getAdjuestmentPriceCount(AdjustmentPricePo adjustmentPricePo) {
		return adjustmentPriceDao.getAdjuestmentPriceCount(adjustmentPricePo);
	}


	public List<AdjustmentPricePo> getAdjuestmentPriceList(
			AdjustmentPricePo adjustmentPricePo,int start , int size) {
		return adjustmentPriceDao.getAdjuestmentPriceList(adjustmentPricePo, start, size);
	}


	public AdjustmentPricePo getAdjuestmentPrice(
			AdjustmentPricePo adjustmentPricePo) {
		return this.adjustmentPriceDao.getAdjuestmentPrice(adjustmentPricePo);
	}

	
	public List<AdjustmentPriceEntryPo> getAdjuestmentPriceEntryList(
			AdjustmentPricePo adjustmentPricePo) {
		return this.adjustmentPriceDao.getAdjuestmentPriceEntryList(adjustmentPricePo);
	}
	/**
	 * 按品种获取商品
	 * */
	public List<AdjustmentPriceEntryPo> getAdjuestmentPriceEntryList(BrandPo brandPo){
		
		return adjustmentPriceDao.getAdjuestmentPriceEntryList(brandPo);
	}
	/**
	 * 查询商品信息
	 * @param goodsids
	 * @param vs
	 * @return
	 */
	public List<GoodsInfoPo> selectDimensionPos(List<String> goodsids,List<String> vs,String whichretail){
		List<GoodsInfoPo> goodsInfoPos = new ArrayList<GoodsInfoPo>();
		for(int i=0; i<goodsids.size(); i++){
			GoodsInfoPo po = new GoodsInfoPo();
			po = adjustmentPriceDao.selectDimensionPo(goodsids.get(i), vs.get(i),whichretail);
			goodsInfoPos.add(po);
		}
		return goodsInfoPos;
	}
	
	public void updateChangePriceBill(AdjustmentPricePo adjustmentPricePo,String type,LogisticsLogPo logPo) {

		if (type.equals("1")){ // 零售价调价
			adjustmentPriceDao.updateAdjustmentPrice(adjustmentPricePo);
		}
		
		if (type.equals("2")){ // 成本价调价
			adjustmentPriceDao.updateCostPrice(adjustmentPricePo);
		}
		
		if (type.equals("3")){ // 批发价调价
			adjustmentPriceDao.updateWholesalePrice(adjustmentPricePo);
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
}
