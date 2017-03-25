package com.pengsheng.eims.basic.mgr.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.dao.impl.TechnologyTypePo;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.VarietyPo;
import com.pengsheng.eims.components.dao.VarietyDao;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.util.tools.Utility;

public class VarietyMgrImpl implements VarietyMgr {

	private VarietyDao varietyDao;
	private ProcurementReceiptDao procurementReceiptDao;
	
	public ProcurementReceiptDao getProcurementReceiptDao() {
		return procurementReceiptDao;
	}

	public void setProcurementReceiptDao(ProcurementReceiptDao procurementReceiptDao) {
		this.procurementReceiptDao = procurementReceiptDao;
	}

	public VarietyDao getVarietyDao() {
		return varietyDao;
	}

	public void setVarietyDao(VarietyDao varietyDao) {
		this.varietyDao = varietyDao;
	}

	public VarietyPo getVarietyPo(VarietyPo varietyPo) {
		// TODO Auto-generated method stub
		return varietyDao.getVarietyPo(varietyPo);
	}

	public void delVariety(VarietyPo varietyPo) {
		// TODO Auto-generated method stub
		varietyDao.delVariety(varietyPo);
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		// TODO Auto-generated method stub
		return varietyDao.getGoodsCategorys();
	}

	/*
	 * quyanping2011-05-26
	 */
	public List<TechnologyTypePo> getTechnologyType(){
		
		return varietyDao.getTechnologyType();
	}
	
	public List<VarietyPo> getVarietys(VarietyPo varietyPo, int start, int size) {
		// TODO Auto-generated method stub
		return varietyDao.getVarietys(varietyPo, start, size);
	}

	public int getVarietysCount(VarietyPo varietyPo) {
		// TODO Auto-generated method stub
		return varietyDao.getVarietysCount(varietyPo);
	}

	public void insertVariety(VarietyPo varietyPo) {
		// TODO Auto-generated method stub
		varietyDao.insertVariety(varietyPo);
	}

	public void updateVariety(VarietyPo varietyPo) {
		// TODO Auto-generated method stub
		varietyDao.updateVariety(varietyPo);
	}

	public int getGoodsInfos(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		return varietyDao.getGoodsInfos(goodsInfoPo);
	}
	
	/**
	* Description :获取某一品种的最大最小光度
	* 
	* @return :某一品种的最大最小光度
	*/
	public GoodsInfoPo getMaxMinGoods(GoodsInfoPo goodsInfoPo){
		return procurementReceiptDao.getMaxMinGoods(goodsInfoPo);
	}
	
	/**
	* Description :获取某一品种的二维数组
	* 
	* @return :某一品种的二维数组
	*/
	public List<GoodsInfoPo> getstringContextGoodsList(GoodsInfoPo goodsInfoPo){
		return procurementReceiptDao.getstringContextGoodsList(goodsInfoPo);
	}
	
	/**
	 * 查询透视分析表的总行数
	 * 
	 * @return
	 */
	public int getSalesGoodsCount(GoodsInfoPo goodsInfoPo){
		return varietyDao.getSalesGoodsCount(goodsInfoPo);
	}
	
	/**
	 * 查询透视分析表数据
	 * 
	 * @return
	 */
	public List<GoodsInfoPo> getSalesGoodsList(GoodsInfoPo goodsInfoPo, int start, int size){

		List<GoodsInfoPo> goodsInfoList = varietyDao.getSalesGoodsList(goodsInfoPo, start, size);
				
		for (int i = 0; i < goodsInfoList.size(); i++){
			GoodsInfoPo po = new GoodsInfoPo();
			po.setBgigoodsid(goodsInfoList.get(i).getBgigoodsid());
			po.setBgnDate(goodsInfoPo.getBgnDate());
			po.setEndDate(goodsInfoPo.getEndDate());
			po.setQueryType(goodsInfoPo.getQueryType());
			
			goodsInfoList.get(i).setGoodsInfo2List(varietyDao.getSalesGoodsByDepartment(po));
		}
		
		return goodsInfoList;
	}
	
	/**
	 * 查询所有销售门店
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getSalesDepartmentList(){
		return varietyDao.getSalesDepartmentList();
	}
}
