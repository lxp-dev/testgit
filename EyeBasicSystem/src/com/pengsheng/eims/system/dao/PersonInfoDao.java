package com.pengsheng.eims.system.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.PersonJobTypePo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.personnel.persistence.PersonnelChangePo;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.tools.Utility;

public interface PersonInfoDao {

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
	public int getPersoninfosCount(PersonInfoPo personInfoPo);

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
	public int getPersoninfosCount2(PersonInfoPo personInfoPo);
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
	public void insertPersonInfo(PersonInfoPo personInfoPo);

	/**
	 * 人员部门新增
	 * 
	 * @param personDepartmentsPo
	 */
	public void insertPersonDepartments(PersonDepartmentsPo personDepartmentsPo);

	/**
	 * 更新人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonInfo(PersonInfoPo personInfoPo);

	/**
	 * 删除人员部门
	 * 
	 * @param personInfoPo
	 */
	public void deletePersonDepartments(PersonInfoPo personInfoPo);

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
	 * 删除人员 删除标记
	 * @param personID
	 */
	public void delPerson(String personID);
	public void delPersonInfo(String personID);
	public void delPersonDepartments(String personID);
	public void delPersonRoles(String personID);
	
	/**
	 * 取所有人员
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
	public void isInvocationUpdate(PersonInfoPo personInfoPo);
	
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
	public List<PersonInfoPo> exportPersonInfo(PersonInfoPo personInfoPo);
	
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
	public List<PersonInfoPo> getPersoninfoPoListByJobType(String jobTypeID,String departmentID);
	/**
	 * 人事变动新增
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public void insertPersonnelChangePo(PersonnelChangePo po) ;
	/**
	 * 得到指定人员信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public PersonInfoPo getPersonInfoID(PersonInfoPo personInfoPo) ;
	
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
	public void insertPersonInfoSupplier(PersonInfoPo personInfoPo);
	
	/**
	 * 更新制造商维护人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonInfoSupplier(PersonInfoPo personInfoPo);
}
