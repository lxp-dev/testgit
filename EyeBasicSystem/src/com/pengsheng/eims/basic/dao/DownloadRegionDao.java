package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;

public interface DownloadRegionDao {
	/**
	 * 获取医院中不存在的公司信息插入公司表
	 * @param po
	 * @return
	 */
	public void insertDownloadCompanyPos(CompanyNamePo po);
	
	/**
	 * 获取集团端公司供应商配置信息插入公司供应商配置表
	 * @param po
	 * @return
	 */
	public void insertCompanySupplierMentPos(CompanyNamePo po);
	
	/**
	 * 获取集团端区域下的制造商插入医院端制造商表
	 * @param po
	 * @return
	 */
	public void insertCompanySupplierPos(CompanyNamePo po);
	
	/**
	 * 获取集团端区域下的供应商插入医院端供应商表
	 * @param po
	 * @return
	 */
	public void insertCompanySupplierAgentPos(CompanyNamePo po);
	
	/**
	 * 获取品种下载集团端品牌信息
	 * @param po
	 * @return
	 */
	public List<BrandPo> getDownloadBrandList(BrandPo po);
	
	/**
	 * 打开远程连接服务
	 * @param po
	 * @return
	 */
	public void openWork();
	
	/**
	 * 关闭远程连接服务
	 * @param po
	 * @return
	 */
	public void closeWork();
	
	/**
	 * 获取集团端区域下指定供应商下的品牌插入医院端品牌表
	 * @param po
	 * @return
	 */
	public void insertCompanyBrandPos(BrandPo po);
	
	/**
	 * 获取集团端区域下指定品牌插入医院端品牌表
	 * @param po
	 * @return
	 */
	public void insertCompanyBrandPo(GoodsInfoPo po);
	
	/**
	 * 获取集团端区域下指定供应商下品牌的商品插入医院端商品表
	 * @param po
	 * @return
	 */
	public void insertCompanyGoodsPos(BrandPo po);
	
	/**
	 * 获取集团端商品信息插入医院端商品表
	 * @param po
	 * @return
	 */
	public void insertCompanyGoodsPo(GoodsInfoPo po);
	
	/**
	 * 获取所有集团端所有区域
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getRegionList(CompanyNamePo po);
	
	/**
	 * 获取所有集团端所有公司
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanyList(CompanyNamePo po);
	
	/**
	 * 下载区域与公司信息及相应绑定关系
	 * @param po
	 * @return
	 */
	public void insertRegionAndCompany(CompanyNamePo po);
	
	/**
	 * 获取下载集团端商品信息数量
	 * @param po
	 * @return
	 */
	public int getDownloadGoodsInfoCount(GoodsInfoPo po);
	
	/**
	 * 获取下载集团端商品信息
	 * @param po
	 * @return
	 */
	public List<GoodsInfoPo> getDownloadGoodsInfoList(GoodsInfoPo po, int start,int size);
}
