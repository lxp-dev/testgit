package com.pengsheng.eims.personnel.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.personnel.persistence.EmergencyContactPo;
import com.pengsheng.eims.personnel.persistence.PersonEducationPo;
import com.pengsheng.eims.personnel.persistence.PersonFamilyPo;
import com.pengsheng.eims.personnel.persistence.PersonInfoPo;
import com.pengsheng.eims.personnel.persistence.PersonWorkPo;
import com.pengsheng.eims.personnel.persistence.PersonnelChangePo;
import com.pengsheng.eims.personnel.persistence.PostPo;
import com.pengsheng.eims.personnel.persistence.SchedulingMonthPo;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;


public interface MPersonInfoDao 
{
	/**
	 * 查到所有人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfos(PersonInfoPo personInfoPo,
			int start, int size);

	/**
	 * 得到所有人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersoninfosCount(PersonInfoPo personInfoPo);
	
	/**
	 * 等到所有当月工龄变化人员
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getGonglingChangePersonInfos(int start, int size);
	
	
	/**
	 * 得到所有当月工龄变化人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getGonglingChangePersoninfosCount();
	
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
	 * 得到职务
	 * @return
	 */
	public PostPo selectPostPo(String id);
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
	 * 判断人员工号是否重复
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersonRepeat(String id ) ;
	
	/**
	 * 人员角色新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonRole(PersonInfoPo personInfoPo);
	/**
	 * 教育培训背景新增
	 * 
	 * @param personDepartmentsPo
	 */
	public void insertPersonEducationPo(PersonEducationPo personEducationPo) ;
	
	/**
	 * 教育培训背景查询
	 * 
	 * @param personDepartmentsPo
	 */
	public List<PersonEducationPo> selectPersonEducationPo(String id) ;
	
	/**
	 * 工作背景查询
	 * 
	 * @param personDepartmentsPo
	 */
	public List<PersonWorkPo> selectPersonWorkPo(String id) ;
	
	/**
	 * 工作背景新增
	 * 
	 * @param personDepartmentsPo
	 */
	public void insertPersonWorkPo(PersonWorkPo personWorkPo ) ;
	
	/**
	 * 家庭成员新增
	 * 
	 * @param personDepartmentsPo
	 */
	public void insertPersonFamilyPo(PersonFamilyPo personFamilyPo) ;
	/**
	 * 家庭成员查询
	 * 
	 * @param personDepartmentsPo
	 */
	public List<PersonFamilyPo> selectPersonFamilyPo(String id) ;
	
	/**
	 * 遇紧急情况通知人新增
	 * 
	 * @param personDepartmentsPo
	 */
	public void insertEmergencyContactPo(EmergencyContactPo emergencyContactPo) ;
	/**
	 * 遇紧急情况通知人查询
	 * 
	 * @param personDepartmentsPo
	 */
	public EmergencyContactPo selectEmergencyContactPo(String id) ;
	/**
	 * 更新角色人员
	 * 
	 * @param personInfoPo
	 */
	
	/**
	 * 遇紧急情况通知人删除
	 * 
	 * @param personID
	 */
	public void delEmergencyContactPo(PersonInfoPo personInfoPo) ;
	/**
	 * 家庭成员删除
	 * 
	 * @param personID
	 */
	public void delPersonFamilyPo(PersonInfoPo personInfoPo) ;
	/**
	 * 工作背景删除
	 * 
	 * @param personID
	 */
	public void delPersonWorkPo(PersonInfoPo personInfoPo) ;
	/**
	 * 教育培训背景删除
	 * 
	 * @param personID
	 */
	public void delPersonEducationPo(PersonInfoPo personInfoPo) ;
	
	public void updatePersonRole(PersonInfoPo personInfoPo);
	
	/**
	 * 删除人员 删除标记
	 * @param personID
	 */
	public void delPerson(String personID);
	/**
	 * 人事变动新增
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public void insertPersonnelChangePo(PersonnelChangePo po) ;
	
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
	 * 查询所有 人事变动(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonnelChangePo> getPersonnelChanges(PersonnelChangePo personnelChangePo  ,int start, int size) ;
	/**
	 * 得到所有人事变动总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersonnelChangeCount(PersonnelChangePo personnelChangePo) ;
	/**
	 * 得到人员部门信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonDepartmentsPo> getDepartments(String  id) ;
	/**
	 * 得到人事变动
	 * @return
	 */
	public PersonnelChangePo selectPersonnelChangePo(String id);
	/**
	 * 查询所有未排班人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonsByScheduingMonth(PersonInfoPo personInfoPo,SchedulingMonthPo schedulingMonthPo,int start, int size) ;
	/**
	 * 未排班选择人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersonsByScheduingMonthCount(PersonInfoPo personInfoPo,SchedulingMonthPo schedulingMonthPo) ;
}
