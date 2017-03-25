package com.pengsheng.eims.system.mgr;

import java.io.File;
import java.util.List;

import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;

public interface CompanyNameMgr {
	
	/**
	 * 新增公司名称设定
	 * @param companyNamePo
	 */
	public void insertCompanyName(CompanyNamePo companyNamePo,File[] upload, String filePath, String[] fFullName,String picPath,LogisticsLogPo logPo);
	
	
	/**
	 * 查询公司名称设定
	 * @param companyNamePo
	 */
	public CompanyNamePo getCompanyName(CompanyNamePo companyNamePo);
	
	/**
	 * 公司使用默认logo或默认背景
	 * @param companyNamePo
	 */
	public void updateCompanyInfo(CompanyNamePo companyNamePo,LogisticsLogPo logPo);
	
	/**
	 * 查询公司的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getCompanyNameCount(CompanyNamePo po);
	
	/**
	 * 查询公司列表
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanyNameList(CompanyNamePo po,int start,int size);
	
	/**
	 * 获取所有公司加载下拉菜单
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanyNameForSelect(CompanyNamePo po);
	
	/**
	 * 删除公司
	 * @param companyNamePo
	 * @param logPo
	 */
	public String deleteCompanyName(CompanyNamePo companyNamePo,LogisticsLogPo logPo);
	
//--------------------------------------------区域维护------------------------------------------------
	
	/**
	 * 查询区域的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getRegionCount(CompanyNamePo po);
	
	/**
	 * 查询区域列表
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getRegionList(CompanyNamePo po,int start,int size);

	/**
	 * 查询区域名称设定
	 */
	public CompanyNamePo getRegion(CompanyNamePo companyNamePo);

	/**
	 * 新增区域名称设定
	 */
	public void insertRegion(CompanyNamePo companyNamePo,LogisticsLogPo logPo);
	
	/**
	 * 修改区域名称设定
	 */
	public void updateRegion(CompanyNamePo companyNamePo,LogisticsLogPo logPo);
	
	/**
	 * 删除区域名称设定
	 */
	public String deleteRegion(CompanyNamePo companyNamePo,LogisticsLogPo logPo);
	
	/**
	 * 查询区域列表填装下拉项
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getRegionListForSelect();
	
	/**
	 * 公司制造商配置信息加载
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanySupplierList(CompanyNamePo po);
	
	/**
	 * 公司供货商配置信息加载
	 * 
	 * @param po
	 * @return
	 */
	public List<SupplierPo> getCompanySupplierAgentList(SupplierPo po);
	
	/**
	 * 公司供货商配置信息新增
	 */
	public void insertCompanyAgent(List<CompanyNamePo> pos,LogisticsLogPo logPo);
	
	/**
	 * 下载区域下公司信息
	 */
	public String noInsertCompanyPoForDownload(CompanyNamePo po,LogisticsLogPo logPo);
	
	/**
	 * 下载区域与公司信息及相应绑定关系
	 * @param po
	 * @return
	 */
	public String noInsertRegionAndCompany(CompanyNamePo po,LogisticsLogPo logPo);
}
