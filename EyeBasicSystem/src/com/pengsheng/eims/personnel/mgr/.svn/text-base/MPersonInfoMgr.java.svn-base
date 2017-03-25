package com.pengsheng.eims.personnel.mgr;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.persistence.EmergencyContactPo;
import com.pengsheng.eims.personnel.persistence.PersonEducationPo;
import com.pengsheng.eims.personnel.persistence.PersonFamilyPo;
import com.pengsheng.eims.personnel.persistence.PersonInfoPo;
import com.pengsheng.eims.personnel.persistence.PersonWorkPo;
import com.pengsheng.eims.personnel.persistence.PersonnelChangePo;
import com.pengsheng.eims.personnel.persistence.SchedulingMonthPo;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;

public interface MPersonInfoMgr {

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
	public void insertPersonInfo(PersonInfoPo personInfoPo,File[] upload, List<String> mm,String ph,String filePath, String[] fFullName,List<PersonDepartmentsPo> personDepartments,List<PersonWorkPo> personWorkPos,List<PersonFamilyPo> personFamilyPos,List<PersonEducationPo> personEducationPos,EmergencyContactPo emergencyContactPo,LogisticsLogPo logPo) ;

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
	 * 判断人员工号是否重复
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersonRepeat(String id ) ;
	
	/**
	 * 家庭成员查询
	 * 
	 * @param personDepartmentsPo
	 */
	public List<PersonFamilyPo> selectPersonFamilyPo(String id) ;
	
	/**
	 * 遇紧急情况通知人查询
	 * 
	 * @param personDepartmentsPo
	 */
	public EmergencyContactPo selectEmergencyContactPo(String id) ;
	
	/**
	 * 更新人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonInfo(PersonInfoPo personInfoPo,File[] upload,List<String> mm,String ph, String filePath, String[] fFullName,List<PersonDepartmentsPo> personDepartments,List<PersonWorkPo> personWorkPos,List<PersonFamilyPo> personFamilyPos,List<PersonEducationPo> personEducationPos,EmergencyContactPo emergencyContactPo,LogisticsLogPo logPo);

	/**
	 * 删除人员 标记删除
	 * 
	 * @param personID
	 */
	public void delPerson(String personID,LogisticsLogPo logPo);

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
	 * 等到所有人事变动(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonnelChangePo> getPersonnelChanges(PersonnelChangePo personnelChangePo  ,int start, int size);

	/**
	 * 得到所有人事变动总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersonnelChangeCount(PersonnelChangePo personnelChangePo)  ;
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
	
	/**
	 * 导出人员编号
	 * 
	 * @param personInfoPo
	 */
}
