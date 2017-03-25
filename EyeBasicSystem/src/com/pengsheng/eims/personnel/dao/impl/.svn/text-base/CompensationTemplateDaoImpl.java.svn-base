package com.pengsheng.eims.personnel.dao.impl;

import java.util.ArrayList;
import java.util.List;


import com.pengsheng.eims.personnel.dao.CompensationTemplateDao;
import com.pengsheng.eims.personnel.persistence.CompensationTemplatePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CompensationTemplateDaoImpl extends BaseJdbcDaoSupport implements  CompensationTemplateDao
{
	/**
	 * 查询所有员工薪酬(查询条件)
	 * 
	 * @param 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CompensationTemplatePo> getCompensationTemplates(CompensationTemplatePo po,int start, int size) 
	{
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by M_CT_UUID) as 'rowNum', ");
		buffer.append("M_CT_UUID as mctuuid ");
		buffer.append(",M_CT_PersonId as mctpersonid ");
		buffer.append(",M_CT_jibengongzi as mctjibengongzi ");
		
		buffer.append(",personName as personname ");
		buffer.append(",departmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");		
		buffer.append(",entryTime as entrytime ");
		buffer.append(",isInvocation as isinvocation ");
		
		buffer.append("from M_CompensationTemplate ");
		buffer.append(" left join SYS_PersonInfo ");
		buffer.append("on M_CompensationTemplate.M_CT_PersonId = SYS_PersonInfo.id ");
		
		buffer.append(" left join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" left join SYS_Roles ");
		buffer.append("on SYS_Roles.roleid = SYS_PersonRoles.roleid ");
		
		buffer.append(" where userState = 0 ");

		// 员工编号
		if (!"".equals(Utility.getName(po.getMctpersonid()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(po.getMctpersonid());
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

		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), CompensationTemplatePo.class);
	}

	/**
	 * 查询所有员工薪酬总数
	 * 
	 * @param 
	 * @return
	 */
	public int getCompensationTemplateCount(CompensationTemplatePo po) 
	{
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(M_CT_UUID) from M_CompensationTemplate ");
		buffer.append(" left join SYS_PersonInfo ");
		buffer.append("on M_CompensationTemplate.M_CT_PersonId = SYS_PersonInfo.id ");
		
		buffer.append(" left join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" left join SYS_Roles ");
		buffer.append("on SYS_Roles.roleid = SYS_PersonRoles.roleid ");

		buffer.append(" where userState = 0 ");

		// 员工编号
		if (!"".equals(Utility.getName(po.getMctpersonid()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(po.getMctpersonid());
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


		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}
	
	/**
	 * 新增员工薪酬模板
	 */
	public void insertCompensationTemplatePo(CompensationTemplatePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO M_CompensationTemplate ");
		buffer.append("            (M_CT_UUID, ");
		buffer.append("           	 M_CT_PersonId, ");
//		buffer.append("             M_CT_jibengongzi, ");
//		buffer.append("             M_CT_gangweijintie, ");
//		buffer.append("             M_CT_gonglingjintie, ");
		buffer.append("             M_CT_baoxian, ");
		buffer.append("             M_CT_gongjijin, ");
		buffer.append("             M_CT_wucanfei, ");
		buffer.append("             M_CT_xilifei) ");
		buffer.append("VALUES    (?, ");
		buffer.append("            ?, ");
//		buffer.append("            ?, "); 
//		buffer.append("            ?, ");
//		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("    			? ) ");		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getMctpersonid()));
//		params.add(Utility.getName(po.getMctjibengongzi()));		
//		params.add(Utility.getName(po.getMctgangweijintie()));
//		params.add(Utility.getName(po.getMctgonglingjintie()));
		params.add(Utility.getName(po.getMctbaoxian()));
		params.add(Utility.getName(po.getMctgongjijin()));
		params.add(Utility.getName(po.getMctwucanfei()));
		params.add(Utility.getName(po.getMctxilifei()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * 更新员工薪酬模板
	 * 
	 * @param 
	 */
	public void updateCompensationTemplatePo(CompensationTemplatePo po) 
	{		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE M_CompensationTemplate ");
		buffer.append("SET ");		
//		buffer.append(" M_CT_jibengongzi =? ");
//		buffer.append(" ,M_CT_gangweijintie=? ");
//		buffer.append(",M_CT_gonglingjintie=? ");
		
		buffer.append("M_CT_baoxian=? ");
		buffer.append(",M_CT_gongjijin=? ");
		buffer.append(",M_CT_wucanfei=? ");
		buffer.append(",M_CT_xilifei=? ");		
		
		buffer.append("WHERE M_CT_PersonId= ?");

		List<String> params = new ArrayList<String>();		
		
//		params.add(Utility.getName(po.getMctjibengongzi()));		
//		params.add(Utility.getName(po.getMctgangweijintie()));
//		params.add(Utility.getName(po.getMctgonglingjintie()));
		
		params.add(Utility.getName(po.getMctbaoxian()));
		params.add(Utility.getName(po.getMctgongjijin()));
		params.add(Utility.getName(po.getMctwucanfei()));
		params.add(Utility.getName(po.getMctxilifei()));
		params.add(Utility.getName(po.getMctpersonid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 删除员工薪酬模板
	 * 
	 * @param 
	 */
	public void deleteCompensationTemplatePo(CompensationTemplatePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from M_CompensationTemplate where M_CT_UUID = '"+Utility.getName(po.getMctuuid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	
	
	/**
	 * 得到员工薪酬模板
	 * @return
	 */
	public CompensationTemplatePo selectCompensationTemplatePo(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append("M_CT_UUID as mctuuid ");
		buffer.append(",SYS_PersonInfo.id as mctpersonid ");	
		buffer.append(",personName as personname ");
		buffer.append(",departmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",isnull(M_Education.M_ET_Salary,'0') as mctjibengongzi ");
		buffer.append(",isnull(M_Education.M_ET_Name,'未设置') as mctxueliname ");
		buffer.append(",isnull(M_Post.M_PT_Salary,'0') as mctgangweijintie ");
		buffer.append(",isnull(M_Post.M_PT_content,'未设置') as mctzhichengname ");
		buffer.append(",isnull(M_Workage.M_WP_Salary,'0') as mctgonglingjintie ");
		buffer.append(",isnull(M_Workage.M_WP_Name,'未设置') as mctgonglingname ");
		
		
		buffer.append(",M_CT_baoxian as mctbaoxian ");
		buffer.append(",M_CT_gongjijin as mctgongjijin ");
		buffer.append(",M_CT_jiabanfei as mctjiabanfei ");
		buffer.append(",M_CT_nianzhongjiang as mctnianzhongjiang ");
		buffer.append(",M_CT_fuli as mctfuli ");
		buffer.append(",M_CT_wucanfei as mctwucanfei ");
		buffer.append(",M_CT_remark as mctremark ");
		buffer.append(",M_CT_xilifei as mctxilifei ");
		buffer.append(",M_CT_jiangjin as mctjiangjin ");		
		
		buffer.append("from  SYS_PersonInfo");
		buffer.append(" left join M_CompensationTemplate on M_CompensationTemplate.M_CT_PersonId = SYS_PersonInfo.id ");
		buffer.append(" left join M_Post on M_Post.M_PT_ID = SYS_PersonInfo.titleoftechnicalpost ");
		buffer.append(" left join M_Education on M_Education.M_ET_ID = SYS_PersonInfo.maxSchoolLevel ");
		buffer.append(" left join M_Workage on M_Workage.M_WP_Name = (FLOOR(datediff(mm,SYS_PersonInfo.zhuanzhengriqi,getdate())/12)) ");
		buffer.append(" where ");
		buffer.append("SYS_PersonInfo.id= '" + id + "' or M_CT_UUID = '" + id + "'");
		return (CompensationTemplatePo)queryForObject(buffer.toString(), null, CompensationTemplatePo.class);
	}
	
	/**
	 * 判断员工薪酬模板是否重复
	 * 
	 * @param 
	 * @return
	 */
	public int getCompensationTemplateRepeat(String id ) 
	{

		StringBuffer buffer = new StringBuffer();
		buffer.append("select count(M_CT_UUID) from M_CompensationTemplate ");

		buffer.append("where M_CT_PersonId = ? ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(id));
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
	
}
