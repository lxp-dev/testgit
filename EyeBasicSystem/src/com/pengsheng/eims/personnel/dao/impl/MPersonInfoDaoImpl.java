package com.pengsheng.eims.personnel.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.personnel.dao.MPersonInfoDao;
import com.pengsheng.eims.personnel.persistence.EmergencyContactPo;
import com.pengsheng.eims.personnel.persistence.PersonEducationPo;
import com.pengsheng.eims.personnel.persistence.PersonFamilyPo;
import com.pengsheng.eims.personnel.persistence.PersonInfoPo;
import com.pengsheng.eims.personnel.persistence.PersonWorkPo;
import com.pengsheng.eims.personnel.persistence.PersonnelChangePo;
import com.pengsheng.eims.personnel.persistence.PostPo;
import com.pengsheng.eims.personnel.persistence.SchedulingMonthPo;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class MPersonInfoDaoImpl extends BaseJdbcDaoSupport implements MPersonInfoDao
{
	/**
	 * 查询所有人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfos(PersonInfoPo personInfoPo,int start, int size) 
	{
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by SYS_PersonInfo.ID) as 'rowNum', ");
		buffer.append("bdpdepartmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",SYS_PersonInfo.*, rolename ");
		buffer.append("from SYS_PersonInfo ");

		buffer.append(" left join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" left join SYS_Roles ");
		buffer.append("on SYS_Roles.roleid = SYS_PersonRoles.roleid ");


		buffer.append(" where userState = 0 and visibleFlag='1' ");

		// 员工编号
		if (!"".equals(Utility.getName(personInfoPo.getId()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(personInfoPo.getId());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(personInfoPo.getPersonName()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(personInfoPo.getPersonName());
		}
		
		// 所属部门
		if (!"".equals(Utility.getName(personInfoPo.getDepartmentID()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(personInfoPo.getDepartmentID()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}
		
		// 员工角色
		if (!"".equals(Utility.getName(personInfoPo.getRoleid()))) {
			buffer.append(" and SYS_PersonRoles.roleID = ? ");
			params.add(personInfoPo.getRoleid());
		}

		// 在职状态
		if (!"".equals(Utility.getName(personInfoPo.getIsinvocation()))) {
			buffer.append(" and isInvocation = ? ");
			params.add(personInfoPo.getIsinvocation());
		}
		//入职日期
		if(!"".equals(Utility.getName(personInfoPo.getBeginentrytime())))
		{
			buffer.append("and convert(varchar(10),entrytime, 23) >= ? ");
			params.add(personInfoPo.getBeginentrytime());
		}
		if(!"".equals(Utility.getName(personInfoPo.getEndentrytime()))){
			buffer.append("and convert(varchar(10), entrytime, 23) <= ? ");			
			params.add(personInfoPo.getEndentrytime());
		}

		// 查询学历
		if (!"".equals(Utility.getName(personInfoPo.getSeleducation()))) {
			buffer.append(" and maxSchoolLevel = ? ");
			params.add(personInfoPo.getSeleducation());
		}
		
		// 查询中：离职开始时间
		if(!"".equals(Utility.getName(personInfoPo.getBeginlizhi())))
		{
			buffer.append("and convert(varchar(10),lizhidate, 23) >= ? ");
			params.add(personInfoPo.getBeginlizhi());
		}
		// 查询中：离职结束时间
		if(!"".equals(Utility.getName(personInfoPo.getEndlizhi()))){
			buffer.append("and convert(varchar(10), lizhidate, 23) <= ? ");			
			params.add(personInfoPo.getEndlizhi());
		}

		// 查询中：合同开始时间
		if(!"".equals(Utility.getName(personInfoPo.getBeginhetong())))
		{
			buffer.append("and convert(varchar(10),laodonghetongdate, 23) >= ? ");
			params.add(personInfoPo.getBeginhetong());
		}
		// 查询中：合同结束时间
		if(!"".equals(Utility.getName(personInfoPo.getEndhetong()))){
			buffer.append("and convert(varchar(10), laodonghetongdate, 23) <= ? ");			
			params.add(personInfoPo.getEndhetong());
		}	

		// 查询中：性别
		if(!"".equals(Utility.getName(personInfoPo.getSex())))
		{
			buffer.append("and sex = ?  ");
			params.add(personInfoPo.getSex());
		}
		// 查询中：职工类别
		if(!"".equals(Utility.getName(personInfoPo.getZhigongtype())))
		{
			buffer.append("and zhigongtype = ?  ");
			params.add(personInfoPo.getZhigongtype());
		}
		
		// 查询中：年龄开始
		if(!"".equals(Utility.getName(personInfoPo.getBegage())))
		{
			buffer.append("and birthday<>'' and (FLOOR(datediff(DY,birthday,getdate())/365.25)+1) >= ? ");
			params.add(personInfoPo.getBegage());
		}	
		// 查询中：年龄结束
		if(!"".equals(Utility.getName(personInfoPo.getEndage())))
		{
			buffer.append("and birthday<>'' and (FLOOR(datediff(DY,birthday,getdate())/365.25)+1) <= ? ");
			params.add(personInfoPo.getEndage());
		}
		
		// 查询中：工龄开始
		if(!"".equals(Utility.getName(personInfoPo.getBeglengthwork())))
		{
			buffer.append("and zhuanzhengriqi<>'' and (FLOOR(datediff(mm,zhuanzhengriqi,getdate())/12)) >= ? ");
			params.add(personInfoPo.getBeglengthwork());
		}	
		// 查询中：工龄结束
		if(!"".equals(Utility.getName(personInfoPo.getEndlengthwork())))
		{
			buffer.append("and zhuanzhengriqi<>'' and (FLOOR(datediff(mm,zhuanzhengriqi,getdate())/12)) <= ? ");
			params.add(personInfoPo.getEndlengthwork());
		}	

		// 查询中：合同满几年
		if(!"".equals(Utility.getName(personInfoPo.getHetongmanyear())))
		{
			buffer.append("and laodonghetongdate<>'' and (FLOOR(datediff(mm,laodonghetongdate,getdate())/12)) >= ? ");
			params.add(personInfoPo.getHetongmanyear());
		}			

		// 查询中：续签合同满几年
		if(!"".equals(Utility.getName(personInfoPo.getXuqianmanyear())))
		{
			buffer.append("and xuqiandate<>'' and (FLOOR(datediff(mm,xuqiandate,getdate())/12)) >= ? ");
			params.add(personInfoPo.getXuqianmanyear());
		}	

		// 查询中：签署合同对应开始年份
		if(!"".equals(Utility.getName(personInfoPo.getBeghetongyear())))
		{
			buffer.append("and laodonghetongdate<>'' and datepart(yy,laodonghetongdate)>= ? ");
			params.add(personInfoPo.getBeghetongyear());
		}	

		// 查询中：签署合同对应结束年份
		if(!"".equals(Utility.getName(personInfoPo.getEndhetongyear())))
		{
			buffer.append("and laodonghetongdate<>'' and datepart(yy,laodonghetongdate)<= ? ");
			params.add(personInfoPo.getEndhetongyear());
		}	

		// 查询中：签署合同对应月份
		if(!"".equals(Utility.getName(personInfoPo.getHetongmonth())))
		{
			buffer.append("and laodonghetongdate<>'' and datepart(mm,laodonghetongdate)= ? ");
			params.add(personInfoPo.getHetongmonth());
		}			
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), PersonInfoPo.class);
	}

	/**
	 * 得到所有人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersoninfosCount(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(SYS_PersonInfo.id) from SYS_PersonInfo ");

		buffer.append(" left join SYS_PersonRoles ");
		buffer.append(" on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" where userState = 0 and visibleFlag='1' ");

		// 员工编号
		if (!"".equals(Utility.getName(personInfoPo.getId()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(personInfoPo.getId());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(personInfoPo.getPersonName()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(personInfoPo.getPersonName());
		}

		// 所属部门
		if (!"".equals(Utility.getName(personInfoPo.getDepartmentID()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(personInfoPo.getDepartmentID()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}

		// 员工角色
		if (!"".equals(Utility.getName(personInfoPo.getRoleid()))) {
			buffer.append(" and SYS_PersonRoles.roleID = ? ");
			params.add(personInfoPo.getRoleid());
		}

		// 在职状态
		if (!"".equals(Utility.getName(personInfoPo.getIsinvocation()))) {
			buffer.append(" and isInvocation = ? ");
			params.add(personInfoPo.getIsinvocation());
		}
		//入职日期
		if(!"".equals(Utility.getName(personInfoPo.getBeginentrytime())))
		{
			buffer.append("and convert(varchar(10),entrytime, 23) >= ? ");
			params.add(personInfoPo.getBeginentrytime());
		}
		if(!"".equals(Utility.getName(personInfoPo.getEndentrytime()))){
			buffer.append("and convert(varchar(10), entrytime, 23) <= ? ");			
			params.add(personInfoPo.getEndentrytime());
		}

		// 查询学历
		if (!"".equals(Utility.getName(personInfoPo.getSeleducation()))) {
			buffer.append(" and maxSchoolLevel = ? ");
			params.add(personInfoPo.getSeleducation());
		}

		// 查询中：离职开始时间
		if(!"".equals(Utility.getName(personInfoPo.getBeginlizhi())))
		{
			buffer.append("and convert(varchar(10),lizhidate, 23) >= ? ");
			params.add(personInfoPo.getBeginlizhi());
		}
		// 查询中：离职结束时间
		if(!"".equals(Utility.getName(personInfoPo.getEndlizhi()))){
			buffer.append("and convert(varchar(10), lizhidate, 23) <= ? ");			
			params.add(personInfoPo.getEndlizhi());
		}

		// 查询中：合同开始时间
		if(!"".equals(Utility.getName(personInfoPo.getBeginhetong())))
		{
			buffer.append("and convert(varchar(10),laodonghetongdate, 23) >= ? ");
			params.add(personInfoPo.getBeginhetong());
		}
		// 查询中：合同结束时间
		if(!"".equals(Utility.getName(personInfoPo.getEndhetong()))){
			buffer.append("and convert(varchar(10), laodonghetongdate, 23) <= ? ");			
			params.add(personInfoPo.getEndhetong());
		}	
		
		// 查询中：性别
		if(!"".equals(Utility.getName(personInfoPo.getSex())))
		{
			buffer.append("and sex = ?  ");
			params.add(personInfoPo.getSex());
		}
		// 查询中：职工类别
		if(!"".equals(Utility.getName(personInfoPo.getZhigongtype())))
		{
			buffer.append("and zhigongtype = ?  ");
			params.add(personInfoPo.getZhigongtype());
		}
		// 查询中：年龄开始
		if(!"".equals(Utility.getName(personInfoPo.getBegage())))
		{
			buffer.append("and birthday<>'' and (FLOOR(datediff(DY,birthday,getdate())/365.25)+1) >= ? ");
			params.add(personInfoPo.getBegage());
		}	
		// 查询中：年龄结束
		if(!"".equals(Utility.getName(personInfoPo.getEndage())))
		{
			buffer.append("and birthday<>'' and (FLOOR(datediff(DY,birthday,getdate())/365.25)+1) <= ? ");
			params.add(personInfoPo.getEndage());
		}	
		
		// 查询中：工龄开始
		if(!"".equals(Utility.getName(personInfoPo.getBeglengthwork())))
		{
			buffer.append("and zhuanzhengriqi<>'' and (FLOOR(datediff(mm,zhuanzhengriqi,getdate())/12)) >= ? ");
			params.add(personInfoPo.getBeglengthwork());
		}	
		// 查询中：工龄结束
		if(!"".equals(Utility.getName(personInfoPo.getEndlengthwork())))
		{
			buffer.append("and zhuanzhengriqi<>'' and (FLOOR(datediff(mm,zhuanzhengriqi,getdate())/12)) <= ? ");
			params.add(personInfoPo.getEndlengthwork());
		}		

		// 查询中：合同满几年
		if(!"".equals(Utility.getName(personInfoPo.getHetongmanyear())))
		{
			buffer.append("and laodonghetongdate<>'' and (FLOOR(datediff(mm,laodonghetongdate,getdate())/12)) >= ? ");
			params.add(personInfoPo.getHetongmanyear());
		}

		// 查询中：续签合同满几年
		if(!"".equals(Utility.getName(personInfoPo.getXuqianmanyear())))
		{
			buffer.append("and xuqiandate<>'' and (FLOOR(datediff(mm,xuqiandate,getdate())/12)) >= ? ");
			params.add(personInfoPo.getXuqianmanyear());
		}	

		// 查询中：签署合同对应开始年份
		if(!"".equals(Utility.getName(personInfoPo.getBeghetongyear())))
		{
			buffer.append("and laodonghetongdate<>'' and datepart(yy,laodonghetongdate)>= ? ");
			params.add(personInfoPo.getBeghetongyear());
		}	

		// 查询中：签署合同对应结束年份
		if(!"".equals(Utility.getName(personInfoPo.getEndhetongyear())))
		{
			buffer.append("and laodonghetongdate<>'' and datepart(yy,laodonghetongdate)<= ? ");
			params.add(personInfoPo.getEndhetongyear());
		}	

		// 查询中：签署合同对应月份
		if(!"".equals(Utility.getName(personInfoPo.getHetongmonth())))
		{
			buffer.append("and laodonghetongdate<>'' and datepart(mm,laodonghetongdate)= ? ");
			params.add(personInfoPo.getHetongmonth());
		}			
		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}

	
	/**
	 * 查询所有未排班人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonsByScheduingMonth(PersonInfoPo personInfoPo,SchedulingMonthPo schedulingMonthPo,int start, int size) 
	{
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by SYS_PersonInfo.ID) as 'rowNum'");
		buffer.append(",bdpdepartmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");		
		buffer.append(",SYS_PersonInfo.*, rolename ");
		buffer.append("from SYS_PersonInfo ");

		buffer.append(" left join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" left join SYS_Roles ");
		buffer.append("on SYS_Roles.roleid = SYS_PersonRoles.roleid ");


		buffer.append(" where userState = 0 and visibleFlag='1' ");

		if(null!=schedulingMonthPo && null!=schedulingMonthPo.getMsmuuid())
		{
			buffer.append(" and SYS_PersonInfo.ID not in(select distinct M_SchedulingPerson.M_SP_Personid from M_SchedulingPerson where M_SP_SMUUID='"+schedulingMonthPo.getMsmuuid()+"') ");
		}
		// 员工编号
		if (!"".equals(Utility.getName(personInfoPo.getId()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(personInfoPo.getId());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(personInfoPo.getPersonName()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(personInfoPo.getPersonName());
		}
		
		// 所属部门
		if (!"".equals(Utility.getName(personInfoPo.getDepartmentID()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(personInfoPo.getDepartmentID()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}
		
		// 员工角色
		if (!"".equals(Utility.getName(personInfoPo.getRoleid()))) {
			buffer.append(" and SYS_PersonRoles.roleID = ? ");
			params.add(personInfoPo.getRoleid());
		}

		// 在职状态
		if (!"".equals(Utility.getName(personInfoPo.getIsinvocation()))) {
			buffer.append(" and isInvocation = ? ");
			params.add(personInfoPo.getIsinvocation());
		}
		//入职日期
		if(!"".equals(Utility.getName(personInfoPo.getBeginentrytime())))
		{
			buffer.append("and convert(varchar(10),entrytime, 23) >= ? ");
			params.add(personInfoPo.getBeginentrytime());
		}
		if(!"".equals(Utility.getName(personInfoPo.getEndentrytime()))){
			buffer.append("and convert(varchar(10), entrytime, 23) <= ? ");			
			params.add(personInfoPo.getEndentrytime());
		}

		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), PersonInfoPo.class);
		
	}

	/**
	 * 未排班选择人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersonsByScheduingMonthCount(PersonInfoPo personInfoPo,SchedulingMonthPo schedulingMonthPo) 
	{
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		buffer.append("select count(SYS_PersonInfo.id) from SYS_PersonInfo ");

		buffer.append(" left join SYS_PersonRoles ");
		buffer.append(" on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" where userState = 0 and visibleFlag='1'");
		if(null!=schedulingMonthPo && null!=schedulingMonthPo.getMsmuuid())
		{
			buffer.append(" and SYS_PersonInfo.ID not in(select distinct M_SchedulingPerson.M_SP_Personid from M_SchedulingPerson where M_SP_SMUUID='"+schedulingMonthPo.getMsmuuid()+"') ");
		}
		// 员工编号
		if (!"".equals(Utility.getName(personInfoPo.getId()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(personInfoPo.getId());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(personInfoPo.getPersonName()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(personInfoPo.getPersonName());
		}

		// 所属部门
		if (!"".equals(Utility.getName(personInfoPo.getDepartmentID()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(personInfoPo.getDepartmentID()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}

		// 员工角色
		if (!"".equals(Utility.getName(personInfoPo.getRoleid()))) {
			buffer.append(" and SYS_PersonRoles.roleID = ? ");
			params.add(personInfoPo.getRoleid());
		}

		// 在职状态
		if (!"".equals(Utility.getName(personInfoPo.getIsinvocation()))) {
			buffer.append(" and isInvocation = ? ");
			params.add(personInfoPo.getIsinvocation());
		}
		//入职日期
		if(!"".equals(Utility.getName(personInfoPo.getBeginentrytime())))
		{
			buffer.append("and convert(varchar(10),entrytime, 23) >= ? ");
			params.add(personInfoPo.getBeginentrytime());
		}
		if(!"".equals(Utility.getName(personInfoPo.getEndentrytime()))){
			buffer.append("and convert(varchar(10), entrytime, 23) <= ? ");			
			params.add(personInfoPo.getEndentrytime());
		}


		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}

	
	/**
	 * 取得所有角色
	 * 
	 * @return
	 */
	public List<RolePo> getRoles() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from SYS_Roles ");
		buffer.append("where moduleApplicationID = '1' ");

		return queryForObjectList(buffer.toString(), null, RolePo.class);
	}
	
	/**
	 * 删除人员 删除标记
	 * 
	 * @param personID
	 */
	public void delPerson(String personID) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("update SYS_PersonInfo set userState = 1 ");
		buffer.append("where id = ? ");

		getJdbcTemplate().update(buffer.toString(), new String[] { personID });
	}

	/**
	 * 人员新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonInfo(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO SYS_PersonInfo ");
		
		buffer.append("(ID ");
		buffer.append(",password ");
		buffer.append(",personName ");
		buffer.append(",userState ");
		buffer.append(",phone ");
		buffer.append(",sex ");
		buffer.append(",email ");
		buffer.append(",address ");
		buffer.append(",cardID ");
		buffer.append(",isInvocation "); 
		
		buffer.append(",entryTime "); 
		buffer.append(",lengthWork "); 
		buffer.append(",titleOfTechnicalPost "); 
		buffer.append(",postID "); 
		buffer.append(",postName "); 
		buffer.append(",remark "); 
		buffer.append(",birthday "); 
		buffer.append(",nativePlace "); 
		buffer.append(",nation "); 
		buffer.append(",isMarriage "); 
		
		
		buffer.append(",politicsLevel "); 
		buffer.append(",rprAddress "); 
		buffer.append(",rprType "); 
		buffer.append(",graduateSchool "); 
		buffer.append(",learnSpeciality "); 
		buffer.append(",specialityLevel "); 
		buffer.append(",specialityCompetence "); 
		buffer.append(",startWorkDate "); 
		buffer.append(",maxSchoolLevel "); 
		buffer.append(",learnFormat ");
		
		buffer.append(",idCardNum "); 
		buffer.append(",postalcode "); 
		buffer.append(",age "); 
		buffer.append(",picturePath "); 
		buffer.append(",positiveCardPath "); 
		buffer.append(",backCardPath "); 
		buffer.append(",createPersonID ");
		buffer.append(",visibleFlag ");		
		buffer.append(",createTime "); 
		buffer.append(",lizhidate "); 
		buffer.append(",xuqiandate "); 		
		buffer.append(",laodonghetongdate "); 
		buffer.append(",shiyongriqi "); 
		buffer.append(",zhuanzhengriqi ");
		buffer.append(",zhigongtype ");	
		buffer.append(",weixin ");
		buffer.append(",qq ");
		buffer.append(",techang ");
		buffer.append(",personcompanyid ) ");

		buffer.append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,'1',getDate(),?,?,?,?,?,?,?,?,?,?)");

		List<String> params = new ArrayList<String>();
		
		params.add(Utility.getName(personInfoPo.getId()));
		params.add(Utility.getName(personInfoPo.getPassword()));
		params.add(Utility.getName(personInfoPo.getPersonName()));
		params.add(Utility.getName(personInfoPo.getUserState()));
		params.add(Utility.getName(personInfoPo.getPhone()));
		params.add(Utility.getName(personInfoPo.getSex()));
		params.add(Utility.getName(personInfoPo.getEmail()));
		params.add(Utility.getName(personInfoPo.getAddress()));
		params.add(Utility.getName(personInfoPo.getCardid()));
		params.add(Utility.getName(personInfoPo.getIsinvocation()));

		params.add(Utility.getName(personInfoPo.getEntrytime()));
		params.add(Utility.getName(personInfoPo.getLengthwork()));
		params.add(Utility.getName(personInfoPo.getTitleoftechnicalpost()));
		params.add(Utility.getName(personInfoPo.getPostid()));
		params.add(Utility.getName(personInfoPo.getPostname()));
		params.add(Utility.getName(personInfoPo.getRemark()));
		params.add(Utility.getName(personInfoPo.getBirthday()));
		params.add(Utility.getName(personInfoPo.getNativeplace()));
		params.add(Utility.getName(personInfoPo.getNation()));
		params.add(Utility.getName(personInfoPo.getIsmarriage()));
		
		params.add(Utility.getName(personInfoPo.getPoliticslevel()));
		params.add(Utility.getName(personInfoPo.getRpraddress()));
		params.add(Utility.getName(personInfoPo.getRprtype()));
		params.add(Utility.getName(personInfoPo.getGraduateschool()));
		params.add(Utility.getName(personInfoPo.getLearnspeciality()));
		params.add(Utility.getName(personInfoPo.getSpecialitylevel()));
		params.add(Utility.getName(personInfoPo.getSpecialitycompetence()));
		params.add(Utility.getName(personInfoPo.getStartworkdate()));
		params.add(Utility.getName(personInfoPo.getMaxschoollevel()));
		params.add(Utility.getName(personInfoPo.getLearnformat()));
		
		params.add(Utility.getName(personInfoPo.getIdcardnum()));
		params.add(Utility.getName(personInfoPo.getPostalcode()));
		params.add(Utility.getName(personInfoPo.getAge()));
		params.add(Utility.getName(personInfoPo.getPicturepath()));
		params.add(Utility.getName(personInfoPo.getPositivecardpath()));
		params.add(Utility.getName(personInfoPo.getBackcardpath()));
		params.add(Utility.getName(personInfoPo.getCreatepersonid()));
	
		params.add(Utility.getName(personInfoPo.getLizhidate()));
		params.add(Utility.getName(personInfoPo.getXuqiandate()));		
		params.add(Utility.getName(personInfoPo.getLaodonghetongdate()));
		params.add(Utility.getName(personInfoPo.getShiyongriqi()));
		params.add(Utility.getName(personInfoPo.getZhuanzhengriqi()));
		params.add(Utility.getName(personInfoPo.getZhigongtype()));
		params.add(Utility.getName(personInfoPo.getWeixin()));
		params.add(Utility.getName(personInfoPo.getQq()));		
		params.add(Utility.getName(personInfoPo.getTechang()));	
		params.add(Utility.getName(personInfoPo.getPersoncompanyid()));	
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 人员部门新增
	 * 
	 * @param personDepartmentsPo
	 */
	public void insertPersonDepartments(PersonDepartmentsPo personDepartmentsPo) {
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO SYS_PersonDepartments ");
		buffer.append("(SYS_PD_ID ");
		buffer.append(",SYS_PD_PersonID ");
		buffer.append(",SYS_PD_DepartmentID) ");
		buffer.append("VALUES (?, ?, ?)");

		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(personDepartmentsPo.getPersonID());
		params.add(personDepartmentsPo.getDepartmentID());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}
	/**
	 * 教育培训背景新增
	 * 
	 * @param personDepartmentsPo
	 */
	public void insertPersonEducationPo(PersonEducationPo personEducationPo) 
	{
		if(personEducationPo.getMpeeducation().equals("") && personEducationPo.getMpeprofessional().equals("") && personEducationPo.getMpestartstoptime().equals("") && personEducationPo.getMpeuniverstity().equals(""))
		{
		}else
		{
			StringBuffer buffer = new StringBuffer();
	
			buffer.append("INSERT INTO M_PersonEducation ");
			buffer.append("(M_PE_UUID ");
			buffer.append(",M_PE_StartStopTime ");
			buffer.append(",M_PE_Universtity ");
			buffer.append(",M_PE_Professional ");
			buffer.append(",M_PE_Education ");
			buffer.append(",M_PE_PersonId) ");
			buffer.append("VALUES (?, ?, ?, ?, ?, ?)");
	
			List<String> params = new ArrayList<String>();
			params.add(this.uuid.generate());
			params.add(personEducationPo.getMpestartstoptime());
			params.add(personEducationPo.getMpeuniverstity());
			params.add(personEducationPo.getMpeprofessional());
			params.add(personEducationPo.getMpeeducation());
			params.add(personEducationPo.getMpepersonid());
	
			getJdbcTemplate().update(buffer.toString(), params.toArray());
		}
	}
	/**
	 * 教育培训背景查询
	 * 
	 * @param personDepartmentsPo
	 */
	public List<PersonEducationPo> selectPersonEducationPo(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" M_PE_UUID as mpeuuid, ");
		buffer.append(" M_PE_StartStopTime as mpestartstoptime, ");
		buffer.append(" M_PE_Universtity as mpeuniverstity, ");
		buffer.append(" M_PE_Professional as mpeprofessional, ");
		buffer.append(" M_PE_Education as mpeeducation, ");
		buffer.append(" M_PE_PersonId as mpepersonid ");
		buffer.append(" FROM M_PersonEducation ");
		buffer.append(" WHERE ");
		buffer.append("M_PE_PersonId = '" +id + "'");
		return queryForObjectList(buffer.toString(), null, PersonEducationPo.class);
	}
	
	/**
	 * 教育培训背景删除
	 * 
	 * @param personID
	 */
	public void delPersonEducationPo(PersonInfoPo personInfoPo) 
	{
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		buffer.append(" delete from M_PersonEducation where M_PE_PersonId = '"+Utility.getName(personInfoPo.getId())+"'");

		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 工作背景新增
	 * 
	 * @param personDepartmentsPo
	 */
	public void insertPersonWorkPo(PersonWorkPo personWorkPo ) 
	{
		if(personWorkPo.getMpwstartstoptime().equals("") && personWorkPo.getMpwcompany().equals("") && personWorkPo.getMpwdepartment().equals("") && personWorkPo.getMpwpost().equals("") && personWorkPo.getMpwposition().equals(""))
		{
			
		}
		else
		{
			StringBuffer buffer = new StringBuffer();
	
			buffer.append("INSERT INTO M_PersonWork ");
			buffer.append("(M_PW_UUID ");
			buffer.append(",M_PW_StartStopTime ");
			buffer.append(",M_PW_Company ");
			buffer.append(",M_PW_Department ");
			buffer.append(",M_PW_Post ");
			buffer.append(",M_PW_Position ");
			buffer.append(",M_PW_PersonId) ");
			buffer.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
	
			List<String> params = new ArrayList<String>();
			params.add(this.uuid.generate());
			params.add(personWorkPo.getMpwstartstoptime());
			params.add(personWorkPo.getMpwcompany());
			params.add(personWorkPo.getMpwdepartment());
			params.add(personWorkPo.getMpwpost());
			params.add(personWorkPo.getMpwposition());
			params.add(personWorkPo.getMpwpersonid());
	
			getJdbcTemplate().update(buffer.toString(), params.toArray());
		}

	}

	/**
	 * 工作背景查询
	 * 
	 * @param personDepartmentsPo
	 */
	public List<PersonWorkPo> selectPersonWorkPo(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" M_PW_UUID as mpwuuid, ");
		buffer.append(" M_PW_StartStopTime as mpwstartstoptime, ");
		buffer.append(" M_PW_Company as mpwcompany, ");
		buffer.append(" M_PW_Department as mpwdepartment, ");
		buffer.append(" M_PW_Post as mpwpost, ");
		buffer.append(" M_PW_Position as mpwposition, ");
		buffer.append(" M_PW_PersonId as mpwpersonid ");
		buffer.append(" FROM M_PersonWork ");
		buffer.append(" WHERE ");
		buffer.append("M_PW_PersonId = '" +id + "'");
		return queryForObjectList(buffer.toString(), null, PersonWorkPo.class);
	}
		
	/**
	 * 工作背景删除
	 * 
	 * @param personID
	 */
	public void delPersonWorkPo(PersonInfoPo personInfoPo) 
	{
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		buffer.append(" delete from M_PersonWork where M_PW_PersonId = '"+Utility.getName(personInfoPo.getId())+"'");

		getJdbcTemplate().update(buffer.toString());
	}
	/**
	 * 家庭成员新增
	 * 
	 * @param personDepartmentsPo
	 */
	public void insertPersonFamilyPo(PersonFamilyPo personFamilyPo) 
	{
		if(personFamilyPo.getMpfrelation().equals("") && personFamilyPo.getMpfname().equals("") && personFamilyPo.getMpfaddress().equals("") && personFamilyPo.getMpfoccupation().equals("") && personFamilyPo.getMpfphone().equals(""))
		{
			
		}
		else
		{
			StringBuffer buffer = new StringBuffer();
	
			buffer.append("INSERT INTO M_PersonFamily ");
			buffer.append("(M_PF_UUID ");
			buffer.append(",M_PF_Relation ");
			buffer.append(",M_PF_Name ");
			buffer.append(",M_PF_Address ");
			buffer.append(",M_PF_Occupation ");
			buffer.append(",M_PF_Phone ");
			buffer.append(",M_PF_PersonId) ");
			buffer.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
	
			List<String> params = new ArrayList<String>();
			params.add(this.uuid.generate());
			params.add(personFamilyPo.getMpfrelation());
			params.add(personFamilyPo.getMpfname());
			params.add(personFamilyPo.getMpfaddress());
			params.add(personFamilyPo.getMpfoccupation());
			params.add(personFamilyPo.getMpfphone());
			params.add(personFamilyPo.getMpfpersonid());
	
			getJdbcTemplate().update(buffer.toString(), params.toArray());
		}
	}
	/**
	 * 家庭成员查询
	 * 
	 * @param personDepartmentsPo
	 */
	public List<PersonFamilyPo> selectPersonFamilyPo(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" M_PF_UUID as mpfuuid, ");
		buffer.append(" M_PF_Relation as mpfrelation, ");
		buffer.append(" M_PF_Name as mpfname, ");
		buffer.append(" M_PF_Address as mpfaddress, ");
		buffer.append(" M_PF_Occupation as mpfoccupation, ");
		buffer.append(" M_PF_Phone as mpfphone, ");
		buffer.append(" M_PF_PersonId as mpfpersonid ");
		buffer.append(" FROM M_PersonFamily ");
		buffer.append(" WHERE ");
		buffer.append("M_PF_PersonId = '" +id + "'");
		return queryForObjectList(buffer.toString(), null, PersonFamilyPo.class);
	}
	
	/**
	 * 家庭成员删除
	 * 
	 * @param personID
	 */
	public void delPersonFamilyPo(PersonInfoPo personInfoPo){
		StringBuffer buffer = new StringBuffer();

		buffer.append(" delete from M_PersonFamily where M_PF_PersonId = '"+Utility.getName(personInfoPo.getId())+"'");

		getJdbcTemplate().update(buffer.toString());
	}
	/**
	 * 遇紧急情况通知人新增
	 * 
	 * @param personDepartmentsPo
	 */
	public void insertEmergencyContactPo(EmergencyContactPo emergencyContactPo) 
	{
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO M_EmergencyContact ");
		buffer.append("(M_EC_UUID ");
		buffer.append(",M_EC_Name ");
		buffer.append(",M_EC_Relation ");
		buffer.append(",M_EC_CompanyName ");
		buffer.append(",M_EC_CompanyAddress ");
		buffer.append(",M_EC_Phone ");
		buffer.append(",M_EC_PersonId) ");
		buffer.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(emergencyContactPo.getMecname());
		params.add(emergencyContactPo.getMecrelation());
		params.add(emergencyContactPo.getMeccompanyname());
		params.add(emergencyContactPo.getMeccompanyaddress());
		params.add(emergencyContactPo.getMecphone());
		params.add(emergencyContactPo.getMecpersonid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}
	
	/**
	 * 遇紧急情况通知人查询
	 * 
	 * @param personDepartmentsPo
	 */
	public EmergencyContactPo selectEmergencyContactPo(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" M_EC_UUID as mecuuid, ");
		buffer.append(" M_EC_Name as mecname, ");
		buffer.append(" M_EC_Relation as mecrelation, ");
		buffer.append(" M_EC_CompanyName as meccompanyname, ");
		buffer.append(" M_EC_CompanyAddress as meccompanyaddress, ");
		buffer.append(" M_EC_Phone as mecphone, ");
		buffer.append(" M_EC_PersonId as mecpersonid ");
		buffer.append(" FROM M_EmergencyContact ");
		buffer.append(" WHERE ");
		buffer.append("M_EC_PersonId = '" +id + "'");
		return (EmergencyContactPo)queryForObject(buffer.toString(), null, EmergencyContactPo.class);
	}
	
	/**
	 * 遇紧急情况通知人删除
	 * 
	 * @param personID
	 */
	public void delEmergencyContactPo(PersonInfoPo personInfoPo) 
	{
		StringBuffer buffer = new StringBuffer();

		buffer.append(" delete from M_EmergencyContact where M_EC_PersonId = '"+Utility.getName(personInfoPo.getId())+"'");

		getJdbcTemplate().update(buffer.toString());
	}
	/**
	 * 更新人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonInfo(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE SYS_PersonInfo ");
		buffer.append("SET ");
		
		buffer.append("password = ? ");
		buffer.append(",personName = ? ");
		buffer.append(",userState = ? ");
		buffer.append(",phone = ? ");
		buffer.append(",sex = ? ");
		buffer.append(",email = ? ");
		buffer.append(",address = ? ");
		buffer.append(",isInvocation = ? "); 
		
		buffer.append(",entryTime = ? "); 
		buffer.append(",lengthWork = ? "); 
		buffer.append(",titleOfTechnicalPost = ? "); 
		buffer.append(",postID = ? "); 
		buffer.append(",postName = ? "); 
		buffer.append(",remark = ? "); 
		buffer.append(",birthday = ? "); 
		buffer.append(",nativePlace = ? "); 
		buffer.append(",nation = ? "); 
		buffer.append(",isMarriage = ? "); 
		
		
		buffer.append(",politicsLevel = ? "); 
		buffer.append(",rprAddress = ? "); 
		buffer.append(",rprType = ? "); 
		buffer.append(",graduateSchool = ? "); 
		buffer.append(",learnSpeciality = ? "); 
		buffer.append(",specialityLevel = ? "); 
		buffer.append(",specialityCompetence = ? "); 
		buffer.append(",startWorkDate = ? "); 
		buffer.append(",maxSchoolLevel = ? "); 
		buffer.append(",learnFormat = ? ");
		
		buffer.append(",idCardNum = ? "); 
		buffer.append(",postalcode = ? "); 
		buffer.append(",age = ? "); 
		buffer.append(",picturePath = ? "); 
		buffer.append(",positiveCardPath = ? "); 
		buffer.append(",backCardPath = ? "); 
		buffer.append(",updatepersonid=? ");
		buffer.append(",updatetime =getDate() "); 

		buffer.append(",lizhidate = ? "); 
		buffer.append(",xuqiandate = ? "); 		
		buffer.append(",laodonghetongdate = ? "); 
		buffer.append(",shiyongriqi = ? "); 
		buffer.append(",zhuanzhengriqi = ? "); 
		buffer.append(",zhigongtype = ? "); 
		buffer.append(",techang = ? "); 
		buffer.append(",weixin = ? "); 
		buffer.append(",qq = ? ");	
		buffer.append(",personcompanyid = ? ");
		buffer.append("WHERE id = ? ");

		List<String> params = new ArrayList<String>();
		
		
		params.add(Utility.getName(personInfoPo.getPassword()));
		params.add(Utility.getName(personInfoPo.getPersonName()));
		params.add(Utility.getName(personInfoPo.getUserState()));
		params.add(Utility.getName(personInfoPo.getPhone()));
		params.add(Utility.getName(personInfoPo.getSex()));
		params.add(Utility.getName(personInfoPo.getEmail()));
		params.add(Utility.getName(personInfoPo.getAddress()));
		params.add(Utility.getName(personInfoPo.getIsinvocation()));

		params.add(Utility.getName(personInfoPo.getEntrytime()));
		params.add(Utility.getName(personInfoPo.getLengthwork()));
		params.add(Utility.getName(personInfoPo.getTitleoftechnicalpost()));
		params.add(Utility.getName(personInfoPo.getPostid()));
		params.add(Utility.getName(personInfoPo.getPostname()));
		params.add(Utility.getName(personInfoPo.getRemark()));
		params.add(Utility.getName(personInfoPo.getBirthday()));
		params.add(Utility.getName(personInfoPo.getNativeplace()));
		params.add(Utility.getName(personInfoPo.getNation()));
		params.add(Utility.getName(personInfoPo.getIsmarriage()));
		
		params.add(Utility.getName(personInfoPo.getPoliticslevel()));
		params.add(Utility.getName(personInfoPo.getRpraddress()));
		params.add(Utility.getName(personInfoPo.getRprtype()));
		params.add(Utility.getName(personInfoPo.getGraduateschool()));
		params.add(Utility.getName(personInfoPo.getLearnspeciality()));
		params.add(Utility.getName(personInfoPo.getSpecialitylevel()));
		params.add(Utility.getName(personInfoPo.getSpecialitycompetence()));
		params.add(Utility.getName(personInfoPo.getStartworkdate()));
		params.add(Utility.getName(personInfoPo.getMaxschoollevel()));
		params.add(Utility.getName(personInfoPo.getLearnformat()));
		
		params.add(Utility.getName(personInfoPo.getIdcardnum()));
		params.add(Utility.getName(personInfoPo.getPostalcode()));
		params.add(Utility.getName(personInfoPo.getAge()));
		params.add(Utility.getName(personInfoPo.getPicturepath()));
		params.add(Utility.getName(personInfoPo.getPositivecardpath()));
		params.add(Utility.getName(personInfoPo.getBackcardpath()));
		params.add(Utility.getName(personInfoPo.getUpdatepersonid()));
		
		params.add(Utility.getName(personInfoPo.getLizhidate()));
		params.add(Utility.getName(personInfoPo.getXuqiandate()));		
		params.add(Utility.getName(personInfoPo.getLaodonghetongdate()));
		params.add(Utility.getName(personInfoPo.getShiyongriqi()));
		params.add(Utility.getName(personInfoPo.getZhuanzhengriqi()));
		params.add(Utility.getName(personInfoPo.getZhigongtype()));
		params.add(Utility.getName(personInfoPo.getTechang()));		
		params.add(Utility.getName(personInfoPo.getWeixin()));
		params.add(Utility.getName(personInfoPo.getQq()));	
		params.add(Utility.getName(personInfoPo.getPersoncompanyid()));	
		
		params.add(Utility.getName(personInfoPo.getId()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 删除人员部门
	 * 
	 * @param personInfoPo
	 */
	public void deletePersonDepartments(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from SYS_PersonDepartments ");
		buffer.append("WHERE SYS_PD_PersonID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(personInfoPo.getId());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	/**
	 * 得到指定人员信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public PersonInfoPo getPersonInfo(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select distinct SYS_PersonInfo.*");
		buffer.append(",departmentID=stuff((select ',' + B_DP_DepartmentID from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",bdpdepartmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",m1.M_ET_Name as maxschoollevelname,p1.M_PT_content as postname, p2.M_PT_content as postname2,SYS_Roles.roleid ");
		buffer.append(",SYS_Roles.roleName as rolename "); 
		buffer.append(",personcompanyid as personcompanyid ");
		buffer.append("from SYS_PersonInfo ");

		buffer.append(" left join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id left join SYS_Roles on SYS_PersonRoles.roleID=SYS_Roles.roleID ");
		
		buffer.append(" left join M_Post p1 ");
		buffer.append("on p1.M_PT_ID = SYS_PersonInfo.postID ");

		buffer.append(" left join M_Post p2 ");
		buffer.append("on p2.M_PT_ID = SYS_PersonInfo.titleOfTechnicalPost ");

		buffer.append(" left join M_Education m1 ");
		buffer.append("on m1.M_ET_ID = SYS_PersonInfo.maxSchoolLevel ");
		
		buffer.append("where 1 = 1");

		List<String> params = new ArrayList<String>();

		// 员工编号
		if (!"".equals(Utility.getName(personInfoPo.getId()))) {
			buffer.append(" and SYS_PersonInfo.id = ? ");
			params.add(personInfoPo.getId());
		}

		return (PersonInfoPo) queryForObject(buffer.toString(), params
				.toArray(), PersonInfoPo.class);
	}

	/**
	 * 判断人员工号是否重复
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersonRepeat(String id ) 
	{

		StringBuffer buffer = new StringBuffer();
		buffer.append("select count(SYS_PersonInfo.id) from SYS_PersonInfo ");

		buffer.append("where SYS_PersonInfo.id = ? ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(id));
		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}
	/**
	 * 人事变动新增
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public void insertPersonnelChangePo(PersonnelChangePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into M_PersonnelChange ");
		buffer.append("(M_PC_UUID ");
		buffer.append(",M_PC_PersonID ");
		buffer.append(",M_PC_ChangeType ");
		buffer.append(",M_PC_Content ");
		buffer.append(",M_PC_RecordID ");
		buffer.append(",M_PC_RecordName ");
		buffer.append(",M_PC_ChangeDate ) "); 

		buffer.append("VALUES (?, ?, ?, ?, ?, ?, getDate())");

		List<String> params = new ArrayList<String>();
		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getMpcpersonid()));
		params.add(Utility.getName(po.getMpcchangetype()));
		params.add(Utility.getName(po.getMpccontent()));
		params.add(Utility.getName(po.getMpcrecordid()));
		params.add(Utility.getName(po.getMpcrecordname()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询所有 人事变动(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonnelChangePo> getPersonnelChanges(PersonnelChangePo personnelChangePo  ,int start, int size) 
	{
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by SYS_PersonInfo.ID) as 'rowNum'");
		buffer.append(",mpcdepartmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",M_PC_UUID as mpcuuid ");
		buffer.append(",M_PC_PersonID as mpcpersonid ");
		buffer.append(",M_PC_ChangeType as mpcchangetype ");
		buffer.append(",M_PC_ChangeDate as mpcchangedate ");
		
		buffer.append(",personName as mpcpersonname ");
		buffer.append(",postName as mpcpostname ");
		buffer.append(",postID as mpcpostid ");
		buffer.append(",isInvocation as isInvocation ");
		
		buffer.append("from M_PersonnelChange ");
		buffer.append(" left join SYS_PersonInfo ");
		buffer.append("on M_PersonnelChange.M_PC_PersonID = SYS_PersonInfo.id ");

		buffer.append(" where 1=1 ");

		// 员工编号
		if (!"".equals(Utility.getName(personnelChangePo.getMpcpersonid()))) {
			buffer.append(" and M_PC_PersonID  like '%' + ? + '%' ");
			params.add(personnelChangePo.getMpcpersonid());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(personnelChangePo.getMpcpersonname()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(personnelChangePo.getMpcpersonname());
		}
		
		// 所属部门
		if (!"".equals(Utility.getName(personnelChangePo.getMpcdepartmentID()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(personnelChangePo.getMpcdepartmentID()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}
		
		//变动类型
		if (!"".equals(Utility.getName(personnelChangePo.getMpcchangetype()))) {
			buffer.append(" and M_PC_ChangeType like '%' + ? + '%' ");
			params.add(personnelChangePo.getMpcchangetype());
		}
		
		//职务
		if(!"".equals(Utility.getName(personnelChangePo.getMpcpostid())))
		{
			buffer.append("and postID= ? ");
			params.add(personnelChangePo.getMpcpostid());
		}
	

		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" order by mpcchangedate desc");
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), PersonnelChangePo.class);
	}

	/**
	 * 得到所有人事变动总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersonnelChangeCount(PersonnelChangePo personnelChangePo) 
	{
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(M_PersonnelChange.M_PC_UUID) from M_PersonnelChange ");

		buffer.append(" left join SYS_PersonInfo ");
		buffer.append("on M_PersonnelChange.M_PC_PersonID = SYS_PersonInfo.id ");

		buffer.append(" where 1 = 1 ");

		// 员工编号
		if (!"".equals(Utility.getName(personnelChangePo.getMpcpersonid()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(personnelChangePo.getMpcpersonid());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(personnelChangePo.getMpcpersonname()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(personnelChangePo.getMpcpersonname());
		}
		
		// 所属部门
		if (!"".equals(Utility.getName(personnelChangePo.getMpcdepartmentID()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(personnelChangePo.getMpcdepartmentID()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}
		
		//变动类型
		if (!"".equals(Utility.getName(personnelChangePo.getMpcchangetype()))) {
			buffer.append(" and M_PC_ChangeType like '%' + ? + '%' ");
			params.add(personnelChangePo.getMpcchangetype());
		}
		
		//职务
		if(!"".equals(Utility.getName(personnelChangePo.getMpcpostid())))
		{
			buffer.append("and postID= ? ");
			params.add(personnelChangePo.getMpcpostid());
		}
	


		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}

	
	/**
	 * 得到人事变动
	 * @return
	 */
	public PersonnelChangePo selectPersonnelChangePo(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append("M_PC_PersonID as mpcpersonid ");
		buffer.append(",mpcdepartmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",M_PC_ChangeType as mpcchangetype ");
		buffer.append(",M_PC_ChangeDate as mpcchangedate ");
		buffer.append(",M_PC_Content as mpccontent ");
		buffer.append(",personName as mpcpersonname ");
		buffer.append(",postName as mpcpostname ");
		buffer.append(",M_PC_RecordName as mpcrecordname ");
		buffer.append(",isInvocation as isInvocation ");
		
		buffer.append("from M_PersonnelChange ");
		buffer.append(" left join SYS_PersonInfo ");
		buffer.append("on M_PersonnelChange.M_PC_PersonID = SYS_PersonInfo.id ");
		buffer.append(" where ");
		buffer.append("M_PC_UUID = '" + id + "'");
		return (PersonnelChangePo)queryForObject(buffer.toString(), null, PersonnelChangePo.class);
	}
	
	/**
	 * 得到指定人员部门信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonDepartmentsPo> getPersonDepartments(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select SYS_PD_ID as id, SYS_PD_PersonID as personID, SYS_PD_DepartmentID as departmentID, B_DP_DepartmentName as departmentName ");
		buffer.append(" from SYS_PersonDepartments ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID = SYS_PersonDepartments.SYS_PD_DepartmentID ");
		buffer.append("where SYS_PD_PersonID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(personInfoPo.getId());	// 员工编号

		return queryForObjectList(buffer.toString(), params.toArray(), PersonDepartmentsPo.class);
	}
	
	/**
	 * 得到人员部门信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonDepartmentsPo> getDepartments(String  id) 
	{
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select SYS_PD_ID as id, SYS_PD_PersonID as personID, SYS_PD_DepartmentID as departmentID, B_DP_DepartmentName as departmentName ");
		buffer.append(" from SYS_PersonDepartments ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID = SYS_PersonDepartments.SYS_PD_DepartmentID ");
		buffer.append("where SYS_PD_PersonID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(id);	// 员工编号

		return queryForObjectList(buffer.toString(), params.toArray(), PersonDepartmentsPo.class);
	}
	/**
	 * 人员角色新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonRole(PersonInfoPo personInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO SYS_PersonRoles ");
		buffer.append("(ID ");
		buffer.append(",personID ");
		buffer.append(",roleID ");
		buffer.append(",moduleApplicationID) ");
		buffer.append("VALUES (?, ?, ?, ?)");

		List<String> params = new ArrayList<String>();
		params.add(uuid.getInstance().generate());
		params.add(personInfoPo.getId());
		params.add(personInfoPo.getRoleid());
		params.add(personInfoPo.getModuleapplicationid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新角色人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonRole(PersonInfoPo personInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE SYS_PersonRoles ");
		buffer.append("SET roleID = ? ");
		buffer.append("WHERE personID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(personInfoPo.getRoleid());
		params.add(personInfoPo.getId());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public List<PersonInfoPo> getPersonList(String selResult) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from SYS_PersonInfo ");

		List<String> params = new ArrayList<String>();

		if (StringUtils.isNotEmpty(selResult)) {

			buffer
					.append("where id like ? + '%' or  personName like '%' + ? + '%'");
			params.add(selResult);
			params.add(selResult);
		}

		return queryForObjectList(buffer.toString(), params.toArray(),
				PersonInfoPo.class);

	}
	

	/**
	 * 取所有制造商
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SupplierPo> getSupplierList(String selResult){
		StringBuffer buffer = new StringBuffer();
		buffer.append("select B_SP_ID as bspid,B_SP_SupplierName as bspsuppliername from B_Supplier ");

		List<String> params = new ArrayList<String>();

		if (StringUtils.isNotEmpty(selResult)) {
			buffer.append("where B_SP_ID like ? + '%' or B_SP_SupplierName  like '%' + ? + '%' ");
			params.add(selResult);
		}

		return queryForObjectList(buffer.toString(), params.toArray(),SupplierPo.class);
	}
	
	public void isInvocationUpdate(PersonInfoPo personInfoPo){
		StringBuffer sb = new StringBuffer();
		sb.append("update sys_personinfo set isInvocation=? where id=?");
		List<String> params = new ArrayList<String>();
		if("0".equals(personInfoPo.getIsinvocation())){
			params.add("1");
		}
		if("1".equals(personInfoPo.getIsinvocation())){
			params.add("0");
		}
		params.add(personInfoPo.getId());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
		
	/**
	 * 得到职务
	 * @return
	 */
	public PostPo selectPostPo(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" M_PT_ID as mptid, ");
		buffer.append(" M_PT_content as mptcontent ");
		buffer.append(" FROM m_post ");
		buffer.append(" WHERE ");
		buffer.append("M_PT_ID = '" + id + "'");
		return (PostPo)queryForObject(buffer.toString(), null, PostPo.class);
	}
	
	/**
	 * 得到一个部门的所有人员
	 * 处理一人多岗
	 * @return
	 */
	public List<PersonInfoPo> getResponsibility(String departmentid) {
		// TODO Auto-generated method stub
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select distinct ID as id , ");
		buffer.append("personName as personName ");
		buffer.append("from SYS_PersonInfo ");
		buffer.append("where 1 = 1 ");
		
		// 部门
		if (!"".equals(Utility.getName(departmentid))) {
			buffer.append(" and SYS_PersonInfo.id in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID=?) ");
			params.add(departmentid);
		}
	
		return queryForObjectList(buffer.toString(), params.toArray(), PersonInfoPo.class);
		
	}

	/**
	 * 导出人员编号
	 * 
	 * @param personInfoPo
	 */
	public List<PersonInfoPo> exportPersonInfo(PersonInfoPo personInfoPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT DISTINCT SYS_PersonInfo.ID AS id,");
		buffer.append("bdpdepartmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",case sex when '1' then '男' when '2' then '女' end as sex");
		buffer.append(",personName AS personName, isnull((FLOOR(datediff(DY,birthday,getdate())/365.25)+1),0) as begage,");
		buffer.append("Isnull(M_Education.M_ET_Name,'') as maxschoollevelname,Isnull(entryTime,'') as entrytime, Isnull(roleName,'') AS rolename, Isnull(zhigongtype,'') AS zhigongtype,Isnull(remark,'') as remark ");
		buffer.append("FROM SYS_PersonInfo ");

		buffer.append("left JOIN SYS_PersonRoles ON SYS_PersonRoles.personID = SYS_PersonInfo.ID ");
		buffer.append("left JOIN SYS_Roles ON SYS_Roles.roleID = SYS_PersonRoles.roleID ");
		buffer.append("left JOIN M_Education ON M_Education.M_ET_ID = SYS_PersonInfo.maxSchoolLevel ");
		
		buffer.append(" WHERE 1 = 1 ");

		// 员工编号
		if (!"".equals(Utility.getName(personInfoPo.getId()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(personInfoPo.getId());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(personInfoPo.getPersonName()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(personInfoPo.getPersonName());
		}
		
		// 所属部门
		if (!"".equals(Utility.getName(personInfoPo.getDepartmentID()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(personInfoPo.getDepartmentID()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}
		
		// 员工角色
		if (!"".equals(Utility.getName(personInfoPo.getRoleid()))) {
			buffer.append(" and SYS_PersonRoles.roleID = ? ");
			params.add(personInfoPo.getRoleid());
		}

		// 在职状态
		if (!"".equals(Utility.getName(personInfoPo.getIsinvocation()))) {
			buffer.append(" and isInvocation = ? ");
			params.add(personInfoPo.getIsinvocation());
		}
		//入职日期
		if(!"".equals(Utility.getName(personInfoPo.getBeginentrytime())))
		{
			buffer.append("and convert(varchar(10),entrytime, 23) >= ? ");
			params.add(personInfoPo.getBeginentrytime());
		}
		if(!"".equals(Utility.getName(personInfoPo.getEndentrytime()))){
			buffer.append("and convert(varchar(10), entrytime, 23) <= ? ");			
			params.add(personInfoPo.getEndentrytime());
		}

		// 查询学历
		if (!"".equals(Utility.getName(personInfoPo.getSeleducation()))) {
			buffer.append(" and maxSchoolLevel = ? ");
			params.add(personInfoPo.getSeleducation());
		}
		
		// 查询中：离职开始时间
		if(!"".equals(Utility.getName(personInfoPo.getBeginlizhi())))
		{
			buffer.append("and convert(varchar(10),lizhidate, 23) >= ? ");
			params.add(personInfoPo.getBeginlizhi());
		}
		// 查询中：离职结束时间
		if(!"".equals(Utility.getName(personInfoPo.getEndlizhi()))){
			buffer.append("and convert(varchar(10), lizhidate, 23) <= ? ");			
			params.add(personInfoPo.getEndlizhi());
		}

		// 查询中：合同开始时间
		if(!"".equals(Utility.getName(personInfoPo.getBeginhetong())))
		{
			buffer.append("and convert(varchar(10),laodonghetongdate, 23) >= ? ");
			params.add(personInfoPo.getBeginhetong());
		}
		// 查询中：合同结束时间
		if(!"".equals(Utility.getName(personInfoPo.getEndhetong()))){
			buffer.append("and convert(varchar(10), laodonghetongdate, 23) <= ? ");			
			params.add(personInfoPo.getEndhetong());
		}	

		// 查询中：性别
		if(!"".equals(Utility.getName(personInfoPo.getSex())))
		{
			buffer.append("and sex = ?  ");
			params.add(personInfoPo.getSex());
		}
		// 查询中：职工类别
		if(!"".equals(Utility.getName(personInfoPo.getZhigongtype())))
		{
			buffer.append("and zhigongtype = ?  ");
			params.add(personInfoPo.getZhigongtype());
		}
		
		// 查询中：年龄开始
		if(!"".equals(Utility.getName(personInfoPo.getBegage())))
		{
			buffer.append("and birthday<>'' and (FLOOR(datediff(DY,birthday,getdate())/365.25)+1) >= ? ");
			params.add(personInfoPo.getBegage());
		}	
		// 查询中：年龄结束
		if(!"".equals(Utility.getName(personInfoPo.getEndage())))
		{
			buffer.append("and birthday<>'' and (FLOOR(datediff(DY,birthday,getdate())/365.25)+1) <= ? ");
			params.add(personInfoPo.getEndage());
		}	

		// 查询中：工龄开始
		if(!"".equals(Utility.getName(personInfoPo.getBeglengthwork())))
		{
			buffer.append("and entrytime<>'' and (FLOOR(datediff(mm,entryTime,getdate())/12)) >= ? ");
			params.add(personInfoPo.getBeglengthwork());
		}	
		// 查询中：工龄结束
		if(!"".equals(Utility.getName(personInfoPo.getEndlengthwork())))
		{
			buffer.append("and entrytime<>'' and (FLOOR(datediff(mm,entryTime,getdate())/12)) <= ? ");
			params.add(personInfoPo.getEndlengthwork());
		}
		
		buffer.append(" order by bdpdepartmentname");
		return queryForObjectList(buffer.toString(), params.toArray(), PersonInfoPo.class);
	}
	
	/**
	 * 通过moduleid查出具有相关权限的用户
	 * @param moduleid
	 * @return
	 */
	public List<PersonInfoPo> getModulePersoninfoPoList(String moduleid,String departmentID){
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("SELECT ID as id, ");
		varname1.append("       personName as personName ");
		varname1.append("FROM   dbo.SYS_PersonInfo ");
		varname1.append("inner join SYS_PersonDepartments on id = SYS_PD_PersonID ");
		varname1.append("WHERE  ID IN (SELECT personID ");
		varname1.append("              FROM   dbo.SYS_PersonRoles ");
		varname1.append("              WHERE  roleID IN(SELECT roleID ");
		varname1.append("                               FROM   dbo.SYS_RolePermission ");
		varname1.append("                               WHERE  moduleID = ? ");
		varname1.append("                                      AND pageKey = '1' ");
		varname1.append("  )) ");
		varname1.append("and SYS_PD_DepartmentID = ? ");
		
		params.add(moduleid);
		params.add(departmentID);
		return queryForObjectList(varname1.toString(), params.toArray(), PersonInfoPo.class);
	}
	

	/**
	 * 得到所有当月工龄变化人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getGonglingChangePersoninfosCount() {
		//最新逻辑：查看本月工龄变化条件为：如果本月为2014年9月份，那么本月工龄变化人员为转正日期在2013年7月2日到2013年8月1日的人员
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(id) from SYS_PersonInfo");
		buffer.append(" where userState = 0 and visibleFlag='1'");
		buffer.append(" and zhuanzhengriqi>=SUBSTRING (CONVERT(varchar(100), dateadd(mm,-14,GETDATE()), 23),0,8 )+'-02'");
		buffer.append(" and zhuanzhengriqi<=SUBSTRING (CONVERT(varchar(100), dateadd(mm,-13,GETDATE()), 23),0,8 )+'-01'");
		
//		buffer.append(" where userState = 0 and visibleFlag='1' and (FLOOR(datediff(mm,zhuanzhengriqi,getdate())))>0 and (FLOOR(datediff(mm,zhuanzhengriqi,getdate()))) % 12=0 ");
	
		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}
	
	/**
	 * 查询所有当月工龄变化人员
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getGonglingChangePersonInfos(int start, int size) 
	{
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by SYS_PersonInfo.ID) as 'rowNum', ");
		buffer.append("bdpdepartmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",SYS_PersonInfo.*, rolename ");
		buffer.append("from SYS_PersonInfo ");

		buffer.append(" left join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" left join SYS_Roles ");
		buffer.append("on SYS_Roles.roleid = SYS_PersonRoles.roleid ");
		
		buffer.append(" where userState = 0 and visibleFlag='1'");		
		buffer.append(" and zhuanzhengriqi>=SUBSTRING (CONVERT(varchar(100), dateadd(mm,-14,GETDATE()), 23),0,8 )+'-02'");
		buffer.append(" and zhuanzhengriqi<=SUBSTRING (CONVERT(varchar(100), dateadd(mm,-13,GETDATE()), 23),0,8 )+'-01'");
		
		
//		buffer.append(" where userState = 0 and visibleFlag='1' and (FLOOR(datediff(mm,zhuanzhengriqi,getdate())))>0 and (FLOOR(datediff(mm,zhuanzhengriqi,getdate()))) % 12=0");
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), PersonInfoPo.class);
	}	
}
