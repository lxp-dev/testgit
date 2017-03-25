package com.pengsheng.eims.system.mgr;

import java.io.InputStream;
import java.util.List;

import com.pengsheng.eims.basic.persistence.PersonJobTypePo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface PersonInfoMgr {

	/**
	 * 等到所有人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfos(PersonInfoPo personInfoPo,
			int start, int size);

	/**
	 * 得到部门中所有在职人员
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfosByDepartmentid(String departmentid);
	
	/**
	 * 得到所有人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersoninfosCount2(PersonInfoPo personInfoPo);
	/**
	 * 等到所有人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfos2(PersonInfoPo personInfoPo,
			int start, int size);

	/**
	 * 得到所有人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersoninfosCount(PersonInfoPo personInfoPo);

	/**
	 * 取得所有角色
	 * 
	 * @return
	 */
	public List<RolePo> getRoles();

	/**
	 * 人员新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonInfo(SystemParameterPo systemParameterPo,PersonInfoPo personInfoPo,List<PersonDepartmentsPo> personDepartments,RoleDiscountPo roleDiscountPo,PersonDiscountPo personDiscountPo,LogisticsLogPo logPo,LogisticsLogPo logPo1);

	/**
	 * 更新人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonInfo(SystemParameterPo systemParameterPo,PersonInfoPo personInfoPo,List<PersonDepartmentsPo> personDepartments,RoleDiscountPo roleDiscountPo,PersonDiscountPo tempPo,PersonDiscountPo personDiscountPo,LogisticsLogPo logPo,LogisticsLogPo logPo1);

	/**
	 * 删除人员 标记删除
	 * 
	 * @param personID
	 */
	public void delPerson(SystemParameterPo systemParameterPo,String personID,LogisticsLogPo logPo);

	/**
	 * 得到指定人员信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public PersonInfoPo getPersonInfo(PersonInfoPo personInfoPo);

	/**
	 * 得到指定人员部门信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonDepartmentsPo> getPersonDepartments(PersonInfoPo personInfoPo);

	/**
	 * 人员角色新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonRole(PersonInfoPo personInfoPo);

	/**
	 * 更新角色人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonRole(PersonInfoPo personInfoPo);

	/**
	 * 取所有人员
	 * 
	 * @return
	 */
	public List<PersonInfoPo> getPersonList(String selResult);
	

	/**
	 * 取所有制造商
	 * 
	 * @return
	 */
	public List<SupplierPo> getSupplierList(String selResult);
	
	/**
	 * 更新启用状态
	 * @param personInfoPo
	 */
	public void isInvocationUpdate(PersonInfoPo personInfoPo,LogisticsLogPo logPo);
	
	/**
	 * 得到一个部门的所有人员
	 * 
	 * @return
	 */
	public List<PersonInfoPo> getResponsibility(String departmentid);

	/**
	 * 导出人员编号
	 * 
	 * @param personInfoPo
	 */
	public InputStream bulidPersonInfoExcel(PersonInfoPo personInfoPo) throws Exception;
	
	/**
	 * 通过moduleid查出具有相关权限的用户
	 * @param moduleid
	 * @return
	 */
	public List<PersonInfoPo> getModulePersoninfoPoList(String moduleid,String departmentID);
	
	/**
	 * 通过工作类型查出用户
	 * @param jobTypeID
	 * @return
	 */	
	public List<PersonInfoPo> getPersoninfoPoListByJobType(String jobTypeID,String departmentID,SystemParameterPo systemParameterPo);
	
	/**
	 * 卡号去重insert
	 * @param po
	 * @return
	 */
	public int getPersonInfoPoName(PersonInfoPo po);
	
	/**
	 * 卡号去重update
	 * @param po
	 * @return
	 */
	public int getPersonInfoPoNameUpdate(PersonInfoPo po);
	
	

	/**
	 * 是否已经使用
	 * @param po
	 * @return
	 */
	public int getPersonInfoPoNameSelect(String id);
	
	
	/**
	 * 获取员工职务类型List
	 * @return List<PersonJobTypePo>
	 */
	public List<PersonJobTypePo> getPersonJobTypeList();
	
	/**
	 * 取得角色信息（按公司类型）
	 * 
	 * @return
	 */
	public List<RolePo> getRolesByCompanyType(RolePo po);
	
	/**
	 * 得到指定人员信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public PersonInfoPo getPersonInfoSupplier(PersonInfoPo personInfoPo);
	
	/**
	 * 制造商人员新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonInfoSupplier(SystemParameterPo systemParameterPo,PersonInfoPo personInfoPo,List<PersonDepartmentsPo> personDepartments,RoleDiscountPo roleDiscountPo,PersonDiscountPo personDiscountPo,LogisticsLogPo logPo,LogisticsLogPo logPo1);
	
	/**
	 * 更新人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonInfoSupplier(SystemParameterPo systemParameterPo,PersonInfoPo personInfoPo,List<PersonDepartmentsPo> personDepartments,RoleDiscountPo roleDiscountPo,PersonDiscountPo tempPo,PersonDiscountPo personDiscountPo,LogisticsLogPo logPo,LogisticsLogPo logPo1);
}
