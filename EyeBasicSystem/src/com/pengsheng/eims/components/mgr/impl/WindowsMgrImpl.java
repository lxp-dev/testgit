package com.pengsheng.eims.components.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.VarietyPo;
import com.pengsheng.eims.components.dao.WindowsDao;
import com.pengsheng.eims.components.mgr.WindowsMgr;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesAreaPo;

public class WindowsMgrImpl implements WindowsMgr {

	private WindowsDao windowsDao;

	public WindowsDao getWindowsDao() {
		return windowsDao;
	}

	public void setWindowsDao(WindowsDao windowsDao) {
		this.windowsDao = windowsDao;
	}

	public int getSupplierCount(SupplierPo supplierPo) {
		// TODO Auto-generated method stub
		return windowsDao.getSupplierCount(supplierPo);
	}

	public List<SupplierPo> getSupplierList(SupplierPo supplierPo, int start,
			int size) {
		// TODO Auto-generated method stub
		return windowsDao.getSupplierList(supplierPo, start, size);
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return windowsDao.getGoodsCategorys();
	}

	public List<BrandPo> getBrands(BrandPo brandPo, int start, int size) {
		return windowsDao.getBrands(brandPo, start, size);
	}

	public int getBrandsCount(BrandPo brandPo) {
		return windowsDao.getBrandsCount(brandPo);
	}

	public SupplierPo getSupplier(SupplierPo po) {
		return windowsDao.getSupplier(po);
	}

	public List<VarietyPo> getVarietys(VarietyPo varietyPo, int start, int size) {
		return windowsDao.getVarietys(varietyPo, start, size);
	}

	public int getVarietysCount(VarietyPo varietyPo) {
		return windowsDao.getVarietysCount(varietyPo);
	}

	public BrandPo getBrandPo(BrandPo brandPo) {
		return windowsDao.getBrandPo(brandPo);
	}
	
	/**
	 * 停用启用在途点
	 * 
	 * @param brandPo
	 * @return
	 */
	public void updateEnabledInTransit(String flag,String inTransitID){
		windowsDao.updateEnabledInTransit(flag,inTransitID);
	}
	
	/**
	 * 查询所有在途点
	 * 
	 * @param brandPo
	 * @return
	 */
	public List<InTransitPo> selectInTransit(){
		return windowsDao.selectInTransit();
	}
	
	/**
	 * 查询当前模块所代表的在途点是否已启用
	 * 
	 * @param brandPo
	 * @return
	 */
	public int isEnabledInTransit(String inTransitID){
		return windowsDao.isEnabledInTransit(inTransitID);
	}
	
	/**
	 * 查询出价签打印品种Po
	 * @param po
	 * @return
	 */
	public List<BrandPo> selectPrintBrandPo(BrandPo po, int start, int size){
		return windowsDao.selectPrintBrandPo(po, start, size);
	}
	
	/**
	 * 获取商品基础信息
	 * @param po
	 * @return
	 */
	public GoodsInfoPo getGoodsInfoPo(GoodsInfoPo po){
		return windowsDao.getGoodsInfoPo(po);
	}
	
	/**
	 * 获取价格区间
	 * 
	 * @return
	 */
	public List<SalesAreaPo> getSalesAreaList(SalesAreaPo po){
		return windowsDao.getSalesAreaList(po);
	}

	public List<SalesAreaPo> selectSalesAreaListAllByGoodsCategoryID(
			String goodsCategoryID, String typeID, String salesTypeID) {
		return windowsDao.selectSalesAreaListAllByGoodsCategoryID(goodsCategoryID, typeID, salesTypeID);
	}
	
	public GoodsInfoPo getWholsGoodsInfoByScan(GoodsInfoPo po){
		return windowsDao.getWholsGoodsInfoByScan(po);
	}
	
}
