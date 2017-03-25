package com.pengsheng.eims.frame.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface LoginDao {

	/**
	 * 正常登录
	 * @param personInfo
	 * @return
	 */
	public PersonInfoPo getPerson(PersonInfoPo personInfo);
	
	/**
	 * 员工刷卡登录
	 * @param personInfoPo
	 * @return
	 */
	public PersonInfoPo cardLogin(PersonInfoPo personInfoPo);
	
	public void pswdUpdate(PersonInfoPo personInfoPo);
	
	/**
	 * 根据当前登录人员查询所在部门
	 * @param personInfo
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsByPerson(PersonInfoPo personInfo);
	
	/**
	 * 根据当前登录人员查询所在部门(控制门店数量)
	 * @param personInfo
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsByPersonOther(PersonInfoPo personInfo,String shopCount);
	
	/**
	 * 查询公司信息
	 * 
	 * @return
	 */
	public CompanyNamePo getCompanyInfo(CompanyNamePo po);
	
	/**
	 * 查询公司logo和背景图
	 * 
	 * @return
	 */
	public CompanyNamePo getCompanyPic(CompanyNamePo po);
	
	/**
	 * 取得打折人信息
	 * @param personInfo
	 * @return
	 */
	public PersonInfoPo getDiscountPerson(PersonInfoPo personInfo);
	
	/**
	 * 更新试用期限
	 */
	public void updateSysLicence(String date);
	
	/**
	 * 根据部门ID查询门店销售方式
	 */
	public String getShopCodeSalesForm(String dptid);
	
	/**
	 * 获取所有MAC地址对应的公司列表
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanyNameByMacList(CompanyNamePo po);
}
