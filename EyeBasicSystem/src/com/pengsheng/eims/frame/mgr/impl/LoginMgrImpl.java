package com.pengsheng.eims.frame.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.frame.dao.LoginDao;
import com.pengsheng.eims.frame.mgr.LoginMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.tools.Utility;
import com.safenet.HaspApi;

public class LoginMgrImpl implements LoginMgr {

	private LoginDao loginDao;

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	/**
	 * 正常登录
	 * @param personInfo
	 * @return
	 */
	public PersonInfoPo getPerson(PersonInfoPo personInfo) {
		return loginDao.getPerson(personInfo);
	}
	
	/**
	 * 员工刷卡登录
	 * @param personInfoPo
	 * @return
	 */
	public PersonInfoPo cardLogin(PersonInfoPo personInfoPo) {
		return loginDao.cardLogin(personInfoPo);
	}

	public void pswdUpdate(PersonInfoPo personInfoPo){
		loginDao.pswdUpdate(personInfoPo);
	}
	
	/**
	 * 根据当前登录人员查询所在部门
	 * @param personInfo
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsByPerson(PersonInfoPo personInfo){
		
		return loginDao.getDepartmentsByPerson(personInfo);
	}
	
	/**
	 * 查询公司信息
	 * 
	 * @return
	 */
	public CompanyNamePo getCompanyInfo(CompanyNamePo po){
		
		CompanyNamePo companyNamePo1 = loginDao.getCompanyInfo(po);		
		CompanyNamePo companyNamePo2 = loginDao.getCompanyPic(po);
		
		companyNamePo1.setFcnbackGroundPath(companyNamePo2.getFcnbackGroundPath());
		companyNamePo1.setFcnLogoPath(companyNamePo2.getFcnLogoPath());
		companyNamePo1.setFcndepgroundPath(companyNamePo2.getFcndepgroundPath());
		return companyNamePo1;
	}
	
	/**
	 * 取得打折人信息
	 * @param personInfo
	 * @return
	 */
	public PersonInfoPo getDiscountPerson(PersonInfoPo personInfo){
		return loginDao.getDiscountPerson(personInfo);
	}
	
	/**
	 * 更新试用期限
	 */
	public void updateSysLicence(String date){
		loginDao.updateSysLicence(date);
	}
	
	/**
	 * 根据部门ID查询门店销售方式
	 */
	public String getShopCodeSalesForm(String dptid){
		return loginDao.getShopCodeSalesForm(dptid);
	}
	
	/**
	 * 获取所有MAC地址对应的公司列表
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanyNameByMacList(CompanyNamePo po){
		return loginDao.getCompanyNameByMacList(po);
	}
}
