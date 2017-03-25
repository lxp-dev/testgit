package com.pengsheng.eims.basic.mgr;

import java.io.File;
import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface BrandMgr {
	
	public List<BrandPo> getAjaxBrands_ByName(BrandPo brandPo);
	
	/**
	 * 取所有品种品种
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
	 * 得到指定品种对象
	 * 
	 * @param brandPo
	 * @return
	 */
	public BrandPo getBrandPo(BrandPo brandPo);

	/**
	 * 增加品种
	 * 
	 * @param brandPo
	 */
	public void insertBrand(BrandPo brandPo, String delFileID,
			File[] upload, String filePath, String[] fFullName,
			String[] ContentType,LogisticsLogPo logPo);

	/**
	 * 更新品种
	 * 
	 * @param brandPo
	 */
	public void updateBrand(BrandPo brandPo,LogisticsLogPo logPo,SystemParameterPo systemParameterPo);

	/**
	 * 删除品种
	 * 
	 * @param brandID
	 *            品种代码
	 */
	public void delBrand(BrandPo brandPo,LogisticsLogPo logPo);

	/**
	 * 制造商对象
	 * 
	 * @param po
	 * @return
	 */
	public SupplierPo getSupplier(SupplierPo po);

	/**
	 * 取商品类别集合
	 * 
	 * @return
	 */
	public List<GoodsCategoryPo> getGoodsCategorys();
	
	/**
	 * 批量导入品种
	 * @param brandPo
	 */
	public void insertBrandExcel(List<BrandPo> brandList);
	
	public int getGoodsCount(BrandPo brandPo);

	/**
	 * Description :修改品种状态（停用启用）
	 * @param：BrandPo 品种信息伴实体	 
	 * @return :品种信息的列表
	 **/
	public void updateBrandEnbled(BrandPo brandPo, LogisticsLogPo logPo);
	
	/**
	 * 取所有商品(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getGoodsTree(String nodeId,String hrefTarget,String href,String isClosed,String fspshowsupplier);
	/**
	 * 取所有商品(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getGoodsTreeNOSupplier(String nodeId,String hrefTarget,String href,String isClosed,String fspshowsupplier);
	/**
	 * 更具树获取商品数量
	 * @param po
	 * @return
	 */
	public int getGoodsTreeCount(GoodsInfoPo po) ;
	/**
	 * 更具树形获取商品信息
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> getGoodsTree(GoodsInfoPo po, int start, int size);
	
	/**
	 * 获取商品等级LIST
	 * @param po
	 * @return
	 */
	public List<GoodsLevelPo> selectGoodsLevelList(GoodsLevelPo po);
}
