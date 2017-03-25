package com.pengsheng.eims.personnel.dao.impl;

import java.util.ArrayList;
import java.util.List;


import com.pengsheng.eims.personnel.dao.SalaryDao;
import com.pengsheng.eims.personnel.persistence.SalaryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SalaryDaoImpl extends BaseJdbcDaoSupport implements  SalaryDao
{
	/**
	 * 查询所有员工薪酬(查询条件)
	 * 
	 * @param 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalaryPo> getSalarys(SalaryPo po,int start, int size) 
	{
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by M_SL_UUID) as 'rowNum', ");
		buffer.append("M_SL_UUID as msluuid ");
		buffer.append(",M_SL_PersonId as mslpersonid ");
		buffer.append(",M_SL_sumsalary as mslsumsalary ");
		buffer.append(",departmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",personName as personname ");
		buffer.append(",M_SL_Year as mslyear ");
		buffer.append(",M_SL_Month as mslmonth ");
		buffer.append(",isInvocation as isinvocation ");
		
		buffer.append("from M_Salary ");
		buffer.append(" left join SYS_PersonInfo ");
		buffer.append("on M_Salary.M_SL_PersonId = SYS_PersonInfo.id ");
		
		buffer.append(" left join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" left join SYS_Roles ");
		buffer.append("on SYS_Roles.roleid = SYS_PersonRoles.roleid ");
		
		buffer.append(" where userState = 0 ");

		// 员工编号
		if (!"".equals(Utility.getName(po.getMslpersonid()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(po.getMslpersonid());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(po.getPersonname()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(po.getPersonname());
		}
		
		// 所属部门
		if (!"".equals(Utility.getName(po.getDepartmentid()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(po.getDepartmentid()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}
		
		// 员工角色
		if (!"".equals(Utility.getName(po.getRoleid()))) {
			buffer.append(" and SYS_PersonRoles.roleID = ? ");
			params.add(po.getRoleid());
		}

		// 在职状态
		if (!"".equals(Utility.getName(po.getIsinvocation()))) {
			buffer.append(" and isInvocation = ? ");
			params.add(po.getIsinvocation());
		}
		//入职日期
		if(!"".equals(Utility.getName(po.getBeginentrytime())))
		{
			buffer.append("and convert(varchar(10),entrytime, 23) >= ? ");
			params.add(po.getBeginentrytime());
		}
		if(!"".equals(Utility.getName(po.getEndentrytime()))){
			buffer.append("and convert(varchar(10), entrytime, 23) <= ? ");			
			params.add(po.getEndentrytime());
		}
		//工资年份
		if(!"".equals(Utility.getName(po.getMslyear())))
		{
			buffer.append("and M_SL_Year = ? ");
			params.add(po.getMslyear());
		}
		//工资月份
		if(!"".equals(Utility.getName(po.getMslmonth())))
		{
			buffer.append("and M_SL_Month = ? ");
			params.add(po.getMslmonth());
		}		

		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), SalaryPo.class);
	}

	/**
	 * 查询所有员工薪酬总数
	 * 
	 * @param 
	 * @return
	 */
	public int getSalaryCount(SalaryPo po) 
	{
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(M_SL_UUID) from M_Salary ");
		buffer.append(" left join SYS_PersonInfo ");
		buffer.append("on M_Salary.M_SL_PersonId = SYS_PersonInfo.id ");
		
		buffer.append(" left join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" left join SYS_Roles ");
		buffer.append("on SYS_Roles.roleid = SYS_PersonRoles.roleid ");

		buffer.append(" where userState = 0 ");

		// 员工编号
		if (!"".equals(Utility.getName(po.getMslpersonid()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(po.getMslpersonid());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(po.getPersonname()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(po.getPersonname());
		}
		
		// 所属部门
		if (!"".equals(Utility.getName(po.getDepartmentid()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(po.getDepartmentid()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}
		
		// 员工角色
		if (!"".equals(Utility.getName(po.getRoleid()))) {
			buffer.append(" and SYS_PersonRoles.roleID = ? ");
			params.add(po.getRoleid());
		}

		// 在职状态
		if (!"".equals(Utility.getName(po.getIsinvocation()))) {
			buffer.append(" and isInvocation = ? ");
			params.add(po.getIsinvocation());
		}
		//入职日期
		if(!"".equals(Utility.getName(po.getBeginentrytime())))
		{
			buffer.append("and convert(varchar(10),entrytime, 23) >= ? ");
			params.add(po.getBeginentrytime());
		}
		if(!"".equals(Utility.getName(po.getEndentrytime()))){
			buffer.append("and convert(varchar(10), entrytime, 23) <= ? ");			
			params.add(po.getEndentrytime());
		}
		//工资年份
		if(!"".equals(Utility.getName(po.getMslyear())))
		{
			buffer.append("and M_SL_Year = ? ");
			params.add(po.getMslyear());
		}
		//工资月份
		if(!"".equals(Utility.getName(po.getMslmonth())))
		{
			buffer.append("and M_SL_Month = ? ");
			params.add(po.getMslmonth());
		}
		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}
	
	/**
	 * 新增员工工资
	 */
	public void insertSalaryPo(SalaryPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO M_Salary ");
		buffer.append("            (M_SL_UUID, ");
		buffer.append("           	 M_SL_PersonId, ");
		buffer.append("             M_SL_jibengongzi, ");
		buffer.append("             M_SL_gangweijintie, ");
		buffer.append("             M_SL_gonglingjintie, ");
		buffer.append("             M_SL_baoxian, ");
		buffer.append("             M_SL_gongjijin, ");
		buffer.append("             M_SL_wucanfei, ");
		buffer.append("             M_SL_xilifei, ");

		buffer.append("             M_SL_jiabanfei, ");
		buffer.append("             M_SL_nianzhongjiang, ");		
		buffer.append("             M_SL_fuli, ");
		buffer.append("             M_SL_jiangjin, ");
		buffer.append("             M_SL_remark, ");
		buffer.append("             M_SL_sumsalary, ");		
		buffer.append("             M_SL_Year, ");		
		buffer.append("             M_SL_Month)");				
		
		buffer.append("VALUES    (?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, "); 
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, "); 
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");		
		buffer.append("    			? ) ");		
		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getMslpersonid()));
		params.add(Utility.getName(po.getMsljibengongzi()));		
		params.add(Utility.getName(po.getMslgangweijintie()));
		params.add(Utility.getName(po.getMslgonglingjintie()));
		params.add(Utility.getName(po.getMslbaoxian()));
		params.add(Utility.getName(po.getMslgongjijin()));
		params.add(Utility.getName(po.getMslwucanfei()));
		params.add(Utility.getName(po.getMslxilifei()));
		
		params.add(Utility.getName(po.getMsljiabanfei()));		
		params.add(Utility.getName(po.getMslnianzhongjiang()));
		params.add(Utility.getName(po.getMslfuli()));
		params.add(Utility.getName(po.getMsljiangjin()));
		params.add(Utility.getName(po.getMslremark()));
		params.add(Utility.getName(po.getMslsumsalary()));		
		params.add(Utility.getName(po.getMslyear()));
		params.add(Utility.getName(po.getMslmonth()));		

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * 更新员工工资
	 * 
	 * @param 
	 */
	public void updateSalaryPo(SalaryPo po) 
	{		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE M_Salary ");
		buffer.append("SET ");		
		
		buffer.append("M_SL_baoxian=? ");
		buffer.append(",M_SL_gongjijin=? ");
		buffer.append(",M_SL_wucanfei=? ");
		buffer.append(",M_SL_xilifei=? ");		
		
		buffer.append(",M_SL_jiabanfei=? ");
		buffer.append(",M_SL_nianzhongjiang=? ");		
		buffer.append(",M_SL_fuli=? ");
		buffer.append(",M_SL_jiangjin=? ");
		buffer.append(",M_SL_remark=? ");
		buffer.append(",M_SL_sumsalary=? ");		

		
		buffer.append("WHERE M_SL_UUID= ?");

		List<String> params = new ArrayList<String>();		
		
		params.add(Utility.getName(po.getMslbaoxian()));
		params.add(Utility.getName(po.getMslgongjijin()));
		params.add(Utility.getName(po.getMslwucanfei()));
		params.add(Utility.getName(po.getMslxilifei()));

		params.add(Utility.getName(po.getMsljiabanfei()));
		params.add(Utility.getName(po.getMslnianzhongjiang()));
		params.add(Utility.getName(po.getMslfuli()));
		params.add(Utility.getName(po.getMsljiangjin()));
		params.add(Utility.getName(po.getMslremark()));
		params.add(Utility.getName(po.getMslsumsalary()));
				
		params.add(Utility.getName(po.getMsluuid()));	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 删除员工工资
	 * 
	 * @param 
	 */
	public void deleteSalaryPo(SalaryPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from M_Salary where M_SL_UUID = '"+Utility.getName(po.getMsluuid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	
	
	/**
	 * 得到员工工资模版
	 * @return
	 */
	public SalaryPo selectCompensationTemplatePo(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append("M_CT_UUID as msluuid ");
		buffer.append(",SYS_PersonInfo.id as mslpersonid ");	
		buffer.append(",personName as personname ");
		buffer.append(",departmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",isnull(M_Education.M_ET_Salary,'0') as msljibengongzi ");
		buffer.append(",isnull(M_Education.M_ET_Name,'未设置') as mslxueliname ");
		buffer.append(",isnull(M_Post.M_PT_Salary,'0') as mslgangweijintie ");
		buffer.append(",isnull(M_Post.M_PT_content,'未设置') as mslzhichengname ");
		buffer.append(",isnull(M_Workage.M_WP_Salary,'0') as mslgonglingjintie ");
		buffer.append(",isnull(M_Workage.M_WP_Name,'未设置') as mslgonglingname ");
		
		
		buffer.append(",M_CT_baoxian as mslbaoxian ");
		buffer.append(",M_CT_gongjijin as mslgongjijin ");
		buffer.append(",M_CT_jiabanfei as msljiabanfei ");
		buffer.append(",M_CT_nianzhongjiang as mslnianzhongjiang ");
		buffer.append(",M_CT_fuli as mslfuli ");
		buffer.append(",M_CT_wucanfei as mslwucanfei ");
		buffer.append(",M_CT_remark as mslremark ");
		buffer.append(",M_CT_xilifei as mslxilifei ");
		buffer.append(",M_CT_jiangjin as msljiangjin ");		
		
		buffer.append("from  SYS_PersonInfo");
		buffer.append(" left join M_CompensationTemplate on M_CompensationTemplate.M_CT_PersonId = SYS_PersonInfo.id ");
		buffer.append(" left join M_Post on M_Post.M_PT_ID = SYS_PersonInfo.titleoftechnicalpost ");
		buffer.append(" left join M_Education on M_Education.M_ET_ID = SYS_PersonInfo.maxSchoolLevel ");
		buffer.append(" left join M_Workage on M_Workage.M_WP_Name = (FLOOR(datediff(mm,SYS_PersonInfo.zhuanzhengriqi,getdate())/12)) ");
		buffer.append(" where ");
		buffer.append("SYS_PersonInfo.id= '" + id + "' or M_CT_UUID = '" + id + "'");
		return (SalaryPo)queryForObject(buffer.toString(), null, SalaryPo.class);
	}
	
	
	/**
	 * 得到员工工资
	 * @return
	 */
	public SalaryPo selectSalaryPo(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append("M_SL_UUID as msluuid ");
		buffer.append(",SYS_PersonInfo.id as mslpersonid ");	
		buffer.append(",personName as personname ");
		buffer.append(",departmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",isnull(M_SL_jibengongzi,'0') as msljibengongzi ");
		buffer.append(",isnull(M_SL_gangweijintie,'0') as mslgangweijintie ");
		buffer.append(",isnull(M_SL_gonglingjintie,'0') as mslgonglingjintie ");		
		
		buffer.append(",isnull(M_SL_baoxian,'0') as mslbaoxian ");
		buffer.append(",isnull(M_SL_gongjijin,'0') as mslgongjijin ");
		buffer.append(",isnull(M_SL_jiabanfei,'0') as msljiabanfei ");
		buffer.append(",isnull(M_SL_nianzhongjiang,'0') as mslnianzhongjiang ");
		buffer.append(",isnull(M_SL_fuli,'0') as mslfuli ");
		buffer.append(",isnull(M_SL_wucanfei,'0') as mslwucanfei ");
		buffer.append(",M_SL_remark as mslremark ");
		buffer.append(",isnull(M_SL_xilifei,'0') as mslxilifei ");
		buffer.append(",isnull(M_SL_jiangjin,'0') as msljiangjin ");
		buffer.append(",M_SL_Year as mslyear ");
		buffer.append(",M_SL_Month as mslmonth ");	
		buffer.append(",isnull(M_SL_sumsalary,'0') as mslsumsalary ");			
		
		buffer.append("from  M_Salary");
		buffer.append(" left join SYS_PersonInfo on M_Salary.M_SL_PersonId = SYS_PersonInfo.id ");
		buffer.append(" where ");
		buffer.append("M_SL_UUID = '" + id + "'");
		return (SalaryPo)queryForObject(buffer.toString(), null, SalaryPo.class);
	}
	
	/**
	 * 判断员工工资是否重复
	 * 
	 * @param 
	 * @return
	 */
	public int getSalaryRepeat(SalaryPo po)
	{

		StringBuffer buffer = new StringBuffer();
		buffer.append("select count(M_SL_UUID) from M_Salary ");

		buffer.append("where M_SL_PersonId = ? and M_SL_Year=? and M_SL_Month=?");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getMslpersonid()));
		params.add(Utility.getName(po.getMslyear()));
		params.add(Utility.getName(po.getMslmonth()));
		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}
	
	
	/**
	 * 查询出人员
	 * 
	 * @param 
	 * @return
	 */
	public PersonInfoPo getPersonByid(String id ) 
	{

		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" 	ID as id	, ");
		buffer.append(" 	personName as	personName  ");
		    
		buffer.append("from SYS_PersonInfo ");		
		buffer.append(" where  ");
		buffer.append(" ID = '" + id + "'");
		return (PersonInfoPo)queryForObject(buffer.toString(), null, PersonInfoPo.class);
	}
	
	/**
	 * 导出工资
	 * 
	 * @param salaryPo
	 */
	public List<SalaryPo> bulidSalaryExcel(SalaryPo salaryPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT DISTINCT SYS_PersonInfo.ID AS mslpersonid,");
		buffer.append("departmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , ''),");
		buffer.append("case sex when '1' then '男' when '2' then '女' end as sex,personName AS personName");
		
		buffer.append(",isnull(M_SL_jibengongzi,'0') as msljibengongzi ");
		buffer.append(",isnull(M_SL_gangweijintie,'0') as mslgangweijintie ");
		buffer.append(",isnull(M_SL_gonglingjintie,'0') as mslgonglingjintie ");		
		
		buffer.append(",isnull(M_SL_baoxian,'0') as mslbaoxian ");
		buffer.append(",isnull(M_SL_gongjijin,'0') as mslgongjijin ");
		buffer.append(",isnull(M_SL_jiabanfei,'0') as msljiabanfei ");
		buffer.append(",isnull(M_SL_nianzhongjiang,'0') as mslnianzhongjiang ");
		buffer.append(",isnull(M_SL_fuli,'0') as mslfuli ");
		buffer.append(",isnull(M_SL_wucanfei,'0') as mslwucanfei ");
		buffer.append(",M_SL_remark as mslremark ");
		buffer.append(",isnull(M_SL_xilifei,'0') as mslxilifei ");
		buffer.append(",isnull(M_SL_jiangjin,'0') as msljiangjin ");
		buffer.append(",M_SL_Year as mslyear ");
		buffer.append(",M_SL_Month as mslmonth ");	
		buffer.append(",isnull(M_SL_sumsalary,'0') as mslsumsalary ");		
		buffer.append("FROM M_Salary ");

		buffer.append(" left join SYS_PersonInfo on M_Salary.M_SL_PersonId = SYS_PersonInfo.id ");		
		buffer.append(" left join SYS_PersonRoles on SYS_PersonRoles.personID = SYS_PersonInfo.id ");
		buffer.append(" left join SYS_Roles on SYS_Roles.roleid = SYS_PersonRoles.roleid ");
		
		buffer.append(" WHERE 1 = 1 ");

		// 员工编号
		if (!"".equals(Utility.getName(salaryPo.getMslpersonid()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(salaryPo.getMslpersonid());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(salaryPo.getPersonname()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(salaryPo.getPersonname());
		}
		
		// 所属部门
		if (!"".equals(Utility.getName(salaryPo.getDepartmentid()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(salaryPo.getDepartmentid()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}
		
		// 员工角色
		if (!"".equals(Utility.getName(salaryPo.getRoleid()))) {
			buffer.append(" and SYS_PersonRoles.roleID = ? ");
			params.add(salaryPo.getRoleid());
		}

		// 在职状态
		if (!"".equals(Utility.getName(salaryPo.getIsinvocation()))) {
			buffer.append(" and isInvocation = ? ");
			params.add(salaryPo.getIsinvocation());
		}
		//入职日期
		if(!"".equals(Utility.getName(salaryPo.getBeginentrytime())))
		{
			buffer.append("and convert(varchar(10),entrytime, 23) >= ? ");
			params.add(salaryPo.getBeginentrytime());
		}
		if(!"".equals(Utility.getName(salaryPo.getEndentrytime()))){
			buffer.append("and convert(varchar(10), entrytime, 23) <= ? ");			
			params.add(salaryPo.getEndentrytime());
		}
		//工资年份
		if(!"".equals(Utility.getName(salaryPo.getMslyear())))
		{
			buffer.append("and M_SL_Year = ? ");
			params.add(salaryPo.getMslyear());
		}
		//工资月份
		if(!"".equals(Utility.getName(salaryPo.getMslmonth())))
		{
			buffer.append("and M_SL_Month = ? ");
			params.add(salaryPo.getMslmonth());
		}
		
		buffer.append(" order by departmentname");
		return queryForObjectList(buffer.toString(), params.toArray(), SalaryPo.class);
	}
	
}
