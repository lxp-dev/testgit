package com.pengsheng.eims.components.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.VarietyPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesAreaPo;

public interface WindowsDao {

	/**
	 * 得到制造商数量
	 * 
	 * @param po
	 * @return
	 */
	public int getSupplierCount(SupplierPo supplierPo);

	/**
	 * 得到所有制造商
	 * 
	 * @param supplierPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SupplierPo> getSupplierList(SupplierPo supplierPo, int start,
			int size);

	/**
	 * 取商品类别集合
	 * 
	 * @return
	 */
	public List<GoodsCategoryPo> getGoodsCategorys();

	/**
	 * 取所有品种
	 * 
	 * @param brandPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<BrandPo> getBrands(BrandPo brandPo, int start, int size);

	/**
	 * 品种总数
	 * 
	 * @param brandPo
	 * @return
	 */
	public int getBrandsCount(BrandPo brandPo);

	/**
	 * 制造商PO
	 * 
	 * @param po
	 * @return
	 */
	public SupplierPo getSupplier(SupplierPo po);

	/**
	 * 取所有品种
	 * 
	 * @param varietyPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<VarietyPo> getVarietys(VarietyPo varietyPo, int start, int size);

	/**
	 * 品种总数
	 * 
	 * @param varietyPo
	 * @return
	 */
	public int getVarietysCount(VarietyPo varietyPo);

	/**
	 * 得到指定品种对象
	 * 
	 * @param brandPo
	 * @return
	 */
	public BrandPo getBrandPo(BrandPo brandPo);
	
	/**
	 * 停用启用在途点
	 * 
	 * @param brandPo
	 * @return
	 */
	public void updateEnabledInTransit(String flag,String inTransitID);
	
	/**
	 * 查询所有在途点
	 * 
	 * @param brandPo
	 * @return
	 */
	public List<InTransitPo> selectInTransit();
	
	/**
	 * 查询当前模块所代表的在途点是否已启用
	 * 
	 * @param brandPo
	 * @return
	 */
	public int isEnabledInTransit(String inTransitID);
	
	/**
	 * 查询出价签打印品种Po
	 * @param po
	 * @return
	 */
	public List<BrandPo> selectPrintBrandPo(BrandPo po, int start, int size);
	
	/**
	 * 获取商品基础信息
	 * @param po
	 * @return
	 */
	public GoodsInfoPo getGoodsInfoPo(GoodsInfoPo po);
	
	/**
	 * 获取价格区间
	 * 
	 * @return
	 */
	public List<SalesAreaPo> getSalesAreaList(SalesAreaPo po);

	public List<SalesAreaPo> selectSalesAreaListAllByGoodsCategoryID(
			String goodsCategoryID, String typeID, String salesTypeID);
	
	public GoodsInfoPo getWholsGoodsInfoByScan(GoodsInfoPo po);
	
}
