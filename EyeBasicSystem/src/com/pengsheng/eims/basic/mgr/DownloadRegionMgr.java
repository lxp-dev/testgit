package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;

public interface DownloadRegionMgr {
	/**
	 * 获取品种下载集团端品牌信息
	 * @param po
	 * @return
	 */
	public List<BrandPo> noGetDownloadBrandList(BrandPo po);
	
	/**
	 * 获取所有集团端所有区域
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> noGetRegionList(CompanyNamePo po);
	
	/**
	 * 获取所有集团端所有公司
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> noGetCompanyList(CompanyNamePo po);

	/**
	 * 获取下载集团端商品信息数量
	 * @param po
	 * @return
	 */
	public int noGetDownloadGoodsInfoCount(GoodsInfoPo po);
	
	/**
	 * 获取下载集团端商品信息
	 * @param po
	 * @return
	 */
	public List<GoodsInfoPo> noGetDownloadGoodsInfoList(GoodsInfoPo po, int start,int size);
	
	/**
	 * 获取集团端商品信息插入医院端商品表
	 * @param po
	 * @return
	 */
	public void noInsertCompanyGoodsPo(GoodsInfoPo po,LogisticsLogPo logPo);
	
}
