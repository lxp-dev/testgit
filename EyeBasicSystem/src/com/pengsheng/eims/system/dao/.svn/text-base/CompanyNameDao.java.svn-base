package com.pengsheng.eims.system.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.util.tools.Utility;

public interface CompanyNameDao {
	/**
	 * 新增公司名称设定
	 * @param companyNamePo
	 */
	public void insertCompanyName(CompanyNamePo companyNamePo);
	
	/**
	 * 查询公司名称设定
	 * @param companyNamePo
	 */
	public CompanyNamePo getCompanyName(CompanyNamePo companyNamePo);
	
	/**
	 * 删除公司名称设定表中的信息
	 * @param companyNamePo
	 */
	public void deleteCompanyName(CompanyNamePo companyNamePo);

	public void deleteCompanyLogo(CompanyNamePo companyNamePo);
	public void insertCompanyLogo(CompanyNamePo companyNamePo);
	
	/**
	 * 公司使用默认logo或默认背景
	 * @param companyNamePo
	 */
	public void updateCompanyInfo(CompanyNamePo companyNamePo);
	
	/**
	 * 查询公司使用logo或背景
	 * @param companyNamePo
	 */
	public CompanyNamePo selectCompanyInfo(CompanyNamePo companyNamePo);
	
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
	 * 查询此公司下是否设置部门
	 * @param companyNamePo
	 * @return
	 */
	public int selectCompanyDepartmentsCount(CompanyNamePo companyNamePo);
	
	//----------------------------区域维护----------------------------------------
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
	
	public void insertRegion(CompanyNamePo companyNamePo);
	
	public void updateRegion(CompanyNamePo companyNamePo);

	public CompanyNamePo getRegion(CompanyNamePo companyNamePo);
	
	public void deleteRegion(CompanyNamePo companyNamePo);
	
	/**
	 * 查询区域列表填装下拉项
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getRegionListForSelect();
	
	/**
	 * 获取当前区域下是否配置公司
	 * 
	 * @param po
	 * @return
	 */
	public int getRegionCountForDelete(CompanyNamePo po);
	
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
	public void insertCompanyAgent(CompanyNamePo companyNamePo);
	
	/**
	 * 公司供货商配置信息删除
	 */
	public void deleteCompanyAgent(CompanyNamePo companyNamePo);
	
	/**
	 * 集团端下载插入公司临时表
	 * @param companyNamePo
	 */
	public void insertCompanyNameTemp(String sqlstr);
	
	/**
	 * 区域下载，删除该区域下所有临时表数据
	 * @param companyNamePo
	 */
	public void deleteRegionDownloadTemp(CompanyNamePo companyNamePo);
	
	/**
	 * 插入公司制造商供应商配置临时表
	 * 
	 * @param po
	 */
	public void insertCompanySupplierTemp(String sqlstr);
	
	/**
	 * 插入公司制造商临时表
	 * 
	 * @param po
	 */
	public void insertSupplierTemp(String sqlstr);
	
	/**
	 * 匹配公司信息并插入公司表
	 * 
	 * @param po
	 * @return
	 */
	public void insertCompanyPosForDownload(CompanyNamePo po);
	
	/**
	 * 匹配公司制造商配置信息并插入公司表
	 * 
	 * @param po
	 * @return
	 */
	public void insertCompanySupplierPosForDownload(CompanyNamePo po);
	
	/**
	 * 匹配制造商信息并插入制造商表
	 * 
	 * @param po
	 * @return
	 */
	public void insertSupplierPosForDownload(CompanyNamePo po);
	
	/**
	 * 匹配制造商信息并插入制造商表
	 * 
	 * @param po
	 * @return
	 */
	public void insertSupplierAgentPosForDownload(CompanyNamePo po);
	
	public void updateCompanyName(CompanyNamePo companyNamePo);
}
