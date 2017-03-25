package com.pengsheng.eims.personnel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.personnel.dao.SchedulingDao;
import com.pengsheng.eims.personnel.persistence.SchedulingDayPo;
import com.pengsheng.eims.personnel.persistence.SchedulingMonthPo;
import com.pengsheng.eims.personnel.persistence.SchedulingPersonDayPo;
import com.pengsheng.eims.personnel.persistence.SchedulingPersonPo;
import com.pengsheng.eims.personnel.persistence.ShiftMaintainPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SchedulingDaoImpl extends BaseJdbcDaoSupport implements SchedulingDao
{
	/**
	 * 查询所有月排班
	 * 
	 * @param 
	 * @return
	 */
	public List<SchedulingMonthPo> getSchedulingMonths(SchedulingMonthPo po,int start, int size) 
	{
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by M_SM_CreateDate desc) as 'rowNum', ");
		buffer.append("M_SM_UUID as msmuuid ");
		buffer.append(",M_SM_Number as msmnumber ");
		buffer.append(",M_SM_Departmentid as msmdepartmentid ");

		buffer.append(",M_SM_Year as msmyear ");
		buffer.append(",M_SM_Month as msmmonth ");
		
		buffer.append(",a.personName as msmcreatepersonname ");
		buffer.append(",b.personName as msmexaminepersonname ");
		buffer.append(",B_Departments.B_DP_DepartmentName as msmdepartmentName ");
		
		buffer.append(",M_SM_CreatePersonid as msmcreatepersonid ");
		buffer.append(",M_SM_CreateDate as msmcreatedate ");
		buffer.append(",M_SM_ExaminePersonid as msmexaminepersonid ");
		buffer.append(",M_SM_ExamineDate as msmexaminedate ");
		buffer.append(",M_SM_ExamineState as msmexaminestate ");
			
		buffer.append("from M_SchedulingMonth ");
		
		buffer.append(" left join (select ID,personName from SYS_PersonInfo) a on M_SchedulingMonth.M_SM_CreatePersonid=a.id ");
		buffer.append(" left join (select ID,personName from SYS_PersonInfo) b on M_SchedulingMonth.M_SM_ExaminePersonid=b.id ");
		buffer.append(" left join B_Departments on M_SchedulingMonth.M_SM_Departmentid=B_Departments.B_DP_DepartmentID ");
		buffer.append(" where 1 = 1 ");

		// 编号
		if (!"".equals(Utility.getName(po.getMsmnumber()))) {
			buffer.append(" and M_SM_Number  like '%' + ? + '%' ");
			params.add(po.getMsmnumber());
		}
		// 所属部门
		if (!"".equals(Utility.getName(po.getMsmdepartmentid()))) 
		{
			buffer.append(" and  B_DP_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(po.getMsmdepartmentid()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ");
		}
		//制单人
		if (!"".equals(Utility.getName(po.getMsmcreatepersonname()))) {
			buffer.append(" and a.personName like '%' + ? + '%' ");
			params.add(po.getMsmcreatepersonname());
		}
		//审核人
		if (!"".equals(Utility.getName(po.getMsmexaminepersonname()))) {
			buffer.append(" and b.personName like '%' + ? + '%' ");
			params.add(po.getMsmexaminepersonname());
		}
		
		// 制单时间
		if(!"".equals(Utility.getName(po.getMsmcreatedatebegin())))
		{
			buffer.append("and convert(varchar(10),M_SM_CreateDate, 23) >= ? ");
			params.add(po.getMsmcreatedatebegin());
		}
		if(!"".equals(Utility.getName(po.getMsmcreatedateend()))){
			buffer.append("and convert(varchar(10), M_SM_CreateDate, 23) <= ? ");			
			params.add(po.getMsmcreatedateend());
		}
		
		// 审核时间
		if(!"".equals(Utility.getName(po.getMsmexaminedatebegin())))
		{
			buffer.append("and convert(varchar(10),M_SM_ExamineDate, 23) >= ? ");
			params.add(po.getMsmexaminedatebegin());
		}
		if(!"".equals(Utility.getName(po.getMsmexaminedateend()))){
			buffer.append("and convert(varchar(10), M_SM_ExamineDate, 23) <= ? ");			
			params.add(po.getMsmexaminedateend());
		}
		
		
		
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), SchedulingMonthPo.class);
	}
	
	/**
	 * 查询月排班Po
	 * 
	 * @param 
	 * @return
	 */
	public SchedulingMonthPo getSchedulingMonthPo(String id) 
	{
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by M_SM_CreateDate desc) as 'rowNum', ");
		buffer.append("M_SM_UUID as msmuuid ");
		buffer.append(",M_SM_Number as msmnumber ");
		buffer.append(",M_SM_Departmentid as msmdepartmentid ");

		buffer.append(",M_SM_Year as msmyear ");
		buffer.append(",M_SM_Month as msmmonth ");
		
		buffer.append(",a.personName as msmcreatepersonname ");
		buffer.append(",b.personName as msmexaminepersonname ");
		buffer.append(",B_Departments.B_DP_DepartmentName as msmdepartmentName ");
		
		buffer.append(",M_SM_CreatePersonid as msmcreatepersonid ");
		buffer.append(",M_SM_CreateDate as msmcreatedate ");
		buffer.append(",M_SM_ExaminePersonid as msmexaminepersonid ");
		buffer.append(",M_SM_ExamineDate as msmexaminedate ");
		buffer.append(",M_SM_ExamineState as msmexaminestate ");
			
		buffer.append("from M_SchedulingMonth ");
		
		buffer.append(" left join (select ID,personName from SYS_PersonInfo) a on M_SchedulingMonth.M_SM_CreatePersonid=a.id ");
		buffer.append(" left join (select ID,personName from SYS_PersonInfo) b on M_SchedulingMonth.M_SM_ExaminePersonid=b.id ");
		buffer.append(" left join B_Departments on M_SchedulingMonth.M_SM_Departmentid=B_Departments.B_DP_DepartmentID ");
		buffer.append(" where 1 = 1 ");

		buffer.append(" and M_SM_UUID = ? ");
		
		params.add(id);
		
		buffer.append(") table1 ");

		return (SchedulingMonthPo) queryForObject(buffer.toString(), params.toArray(), SchedulingMonthPo.class);
	}

	/**
	 * 查询所有月排班总数
	 * 
	 * @param 
	 * @return
	 */
	public int getSchedulingMonthCount(SchedulingMonthPo po) 
	{
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(M_SM_UUID) ");
		buffer.append("from M_SchedulingMonth ");
		
		buffer.append(" left join (select ID,personName from SYS_PersonInfo) a on M_SchedulingMonth.M_SM_CreatePersonid=a.id ");
		buffer.append(" left join (select ID,personName from SYS_PersonInfo) b on M_SchedulingMonth.M_SM_ExaminePersonid=b.id ");
		buffer.append(" left join B_Departments on M_SchedulingMonth.M_SM_Departmentid=B_Departments.B_DP_DepartmentID ");
		buffer.append(" where 1 = 1 ");


		// 编号
		if (!"".equals(Utility.getName(po.getMsmnumber()))) {
			buffer.append(" and M_SM_Number  like '%' + ? + '%' ");
			params.add(po.getMsmnumber());
		}
		// 所属部门
		if (!"".equals(Utility.getName(po.getMsmdepartmentid()))) 
		{
			buffer.append(" and  B_DP_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(po.getMsmdepartmentid()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ");
		}
		//制单人
		if (!"".equals(Utility.getName(po.getMsmcreatepersonname()))) {
			buffer.append(" and a.personName like '%' + ? + '%' ");
			params.add(po.getMsmcreatepersonname());
		}
		//审核人
		if (!"".equals(Utility.getName(po.getMsmexaminepersonname()))) {
			buffer.append(" and b.personName like '%' + ? + '%' ");
			params.add(po.getMsmexaminepersonname());
		}
		
		// 制单时间
		if(!"".equals(Utility.getName(po.getMsmcreatedatebegin())))
		{
			buffer.append("and convert(varchar(10),M_SM_CreateDate, 23) >= ? ");
			params.add(po.getMsmcreatedatebegin());
		}
		if(!"".equals(Utility.getName(po.getMsmcreatedateend()))){
			buffer.append("and convert(varchar(10), M_SM_CreateDate, 23) <= ? ");			
			params.add(po.getMsmcreatedateend());
		}
		
		// 审核时间
		if(!"".equals(Utility.getName(po.getMsmexaminedatebegin())))
		{
			buffer.append("and convert(varchar(10),M_SM_ExamineDate, 23) >= ? ");
			params.add(po.getMsmexaminedatebegin());
		}
		if(!"".equals(Utility.getName(po.getMsmexaminedateend()))){
			buffer.append("and convert(varchar(10), M_SM_ExamineDate, 23) <= ? ");			
			params.add(po.getMsmexaminedateend());
		}
		


		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}
	
	/**
	 * 查询所有日排班
	 * 
	 * @param 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SchedulingPersonPo> getSchedulingPersonPos(SchedulingPersonPo po,int start, int size) 
	{
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by M_SP_UUID) as 'rowNum', ");
		
		buffer.append(" 	M_SP_UUID as mspuuid , ");
		buffer.append(" 	M_SP_Personid as  msppersonid , ");		
		buffer.append(" 	SYS_PersonInfo.personName as	msppersonname, ");		
		buffer.append(" 	M_SP_SMUUID	 as  mspsmuuid ");
		
		buffer.append("from M_SchedulingPerson ");
		buffer.append(" left join SYS_PersonInfo on M_SchedulingPerson.M_SP_Personid=SYS_PersonInfo.id ");		
		buffer.append(" left join M_SchedulingMonth ");
		buffer.append("on M_SchedulingPerson.M_SP_SMUUID = M_SchedulingMonth.M_SM_UUID");
		buffer.append(" where 1 = 1 ");
		
		// 所属部门
		if (!"".equals(Utility.getName(po.getDepartmentids()))) 
		{
			buffer.append(" and M_SchedulingPerson.M_SP_Personid in(select distinct SYS_PersonDepartments.SYS_PD_PersonID from SYS_PersonDepartments where  SYS_PersonDepartments.SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(po.getDepartmentids()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}

//		// 排班编号
//		if (!"".equals(Utility.getName(po.getMsdnumber()))) 
//		{
//			buffer.append(" and M_SD_Number  like '%' + ? + '%' ");
//			params.add(po.getMsdnumber());
//		}
		// 年份
		if (!"".equals(Utility.getName(po.getMsdyear()))) {
			buffer.append(" and M_SchedulingMonth.M_SM_Year = ? ");
			params.add(po.getMsdyear());
		}

		// 月份
		if (!"".equals(Utility.getName(po.getMsdmonth()))) {
			buffer.append(" and M_SchedulingMonth.M_SM_Month = ? ");
			params.add(po.getMsdmonth());
		}
		
		// 人员编号
		if (!"".equals(Utility.getName(po.getMsppersonid()))) {
			buffer.append(" and M_SchedulingPerson.M_SP_Personid like '%' + ? + '%' ");
			params.add(po.getMsppersonid());
		}
		// 人员姓名
		if (!"".equals(Utility.getName(po.getMsppersonname()))) {
			buffer.append(" and SYS_PersonInfo.personName like '%' + ? + '%' ");
			params.add(po.getMsppersonname());
		}

//		// 审核状态
//		if (!"".equals(Utility.getName(po.getMsdexaminestate()))) {
//			buffer.append(" and M_SD_ExamineState = ? ");
//			params.add(po.getMsdexaminestate());
//		}
		
//		if (!"".equals(Utility.getName(po.getMsdsmuuid()))) {
//			buffer.append(" and M_SD_SMUUID = ? ");
//			params.add(po.getMsdsmuuid());
//		}
		

		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");
		return queryForObjectList(buffer.toString(), params.toArray(), SchedulingPersonPo.class);
	}

	/**
	 * 查询所有日排班总数
	 * 
	 * @param 
	 * @return
	 */
	public int getSchedulingPersonPoCount(SchedulingPersonPo po) 
	{
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(M_SP_UUID) ");
			

		buffer.append("from M_SchedulingPerson ");
		buffer.append(" left join SYS_PersonInfo on M_SchedulingPerson.M_SP_Personid=SYS_PersonInfo.id ");				
		buffer.append(" left join M_SchedulingMonth ");
		buffer.append("on M_SchedulingPerson.M_SP_SMUUID = M_SchedulingMonth.M_SM_UUID");
		buffer.append(" where 1 = 1 ");


		// 所属部门
		if (!"".equals(Utility.getName(po.getDepartmentids()))) 
		{
			buffer.append(" and M_SchedulingPerson.M_SP_Personid in(select distinct SYS_PersonDepartments.SYS_PD_PersonID from SYS_PersonDepartments where  SYS_PersonDepartments.SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(po.getDepartmentids()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}
//
//		// 排班编号
//		if (!"".equals(Utility.getName(po.getMsdnumber()))) 
//		{
//			buffer.append(" and M_SD_Number  like '%' + ? + '%' ");
//			params.add(po.getMsdnumber());
//		}
		

//		// 审核状态
//		if (!"".equals(Utility.getName(po.getMsdexaminestate()))) {
//			buffer.append(" and M_SD_ExamineState = ? ");
//			params.add(po.getMsdexaminestate());
//		}
		// 年份
		if (!"".equals(Utility.getName(po.getMsdyear()))) {
			buffer.append(" and M_SchedulingMonth.M_SM_Year = ? ");
			params.add(po.getMsdyear());
		}

		// 月份
		if (!"".equals(Utility.getName(po.getMsdmonth()))) {
			buffer.append(" and M_SchedulingMonth.M_SM_Month = ? ");
			params.add(po.getMsdmonth());
		}
		// 人员编号
		if (!"".equals(Utility.getName(po.getMsppersonid()))) {
			buffer.append(" and M_SchedulingPerson.M_SP_Personid like '%' + ? + '%' ");
			params.add(po.getMsppersonid());
		}
		// 人员姓名
		if (!"".equals(Utility.getName(po.getMsppersonname()))) {
			buffer.append(" and SYS_PersonInfo.personName like '%' + ? + '%' ");
			params.add(po.getMsppersonname());
		}
		
//		if (!"".equals(Utility.getName(po.getMsdsmuuid()))) {
//			buffer.append(" and M_SD_SMUUID = ? ");
//			params.add(po.getMsdsmuuid());
//		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}
	
	/**
	 * 新增月总排班
	 */
	public void insertSchedulingMonthPo(SchedulingMonthPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		

		buffer.append("INSERT INTO M_SchedulingMonth ");
		buffer.append("            (M_SM_UUID, ");
		buffer.append("           	M_SM_Number, ");
		buffer.append("             M_SM_Departmentid, ");
		buffer.append("             M_SM_Year, ");
		buffer.append("             M_SM_Month, ");
		buffer.append("             M_SM_CreatePersonid, ");
		buffer.append("             M_SM_ExamineState, ");
		buffer.append("             M_SM_CreateDate )");
		buffer.append("VALUES    ( ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, "); 
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("    		   getdate() ) ");		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getMsmnumber()));
		params.add(Utility.getName(po.getMsmdepartmentid()));		
		params.add(Utility.getName(po.getMsmyear()));
		params.add(Utility.getName(po.getMsmmonth()));
		params.add(Utility.getName(po.getMsmcreatepersonid()));	
		params.add(Utility.getName(po.getMsmexaminestate()));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public SchedulingMonthPo getSchedulingMonthPoById(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" M_SM_UUID as msmuuid, ");
		buffer.append(" M_SM_Number as msmnumber, ");
		buffer.append(" M_SM_Departmentid as msmdepartmentid, ");
		buffer.append(" M_SM_Year as msmyear, ");
		buffer.append(" M_SM_Month as msmmonth, ");
		buffer.append(" M_SM_CreatePersonid as msmcreatepersonid, ");
		buffer.append(" M_SM_CreateDate as msmcreatedate, ");
		buffer.append(" M_SM_ExaminePersonid as msmexaminepersonid, ");
		buffer.append(" M_SM_ExamineDate as msmexaminedate, ");
		buffer.append(" M_SM_ExamineState as msmexaminestate ");
		buffer.append(" FROM M_SchedulingMonth ");
		buffer.append(" WHERE ");
		buffer.append("M_SM_UUID = '" + id + "'");
		return (SchedulingMonthPo)queryForObject(buffer.toString(), null, SchedulingMonthPo.class);
	}
	
	public SchedulingMonthPo getSchedulingMonthPoByMonth(SchedulingMonthPo po)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" M_SM_UUID as msmuuid, ");
		buffer.append(" M_SM_Number as msmnumber, ");
		buffer.append(" M_SM_Departmentid as msmdepartmentid, ");
		buffer.append(" M_SM_Year as msmyear, ");
		buffer.append(" M_SM_Month as msmmonth, ");
		buffer.append(" M_SM_CreatePersonid as msmcreatepersonid, ");
		buffer.append(" M_SM_CreateDate as msmcreatedate, ");
		buffer.append(" M_SM_ExaminePersonid as msmexaminepersonid, ");
		buffer.append(" M_SM_ExamineDate as msmexaminedate, ");
		buffer.append(" M_SM_ExamineState as msmexaminestate ");
		buffer.append(" FROM M_SchedulingMonth ");
		buffer.append(" WHERE ");
		buffer.append(" M_SM_Year = '" + po.getMsmyear()+ "'");
		buffer.append(" and M_SM_Month = '" + po.getMsmmonth() + "'");
		//buffer.append(" and M_SM_Departmentid = '" + po.getMsmdepartmentid() + "'");
		return (SchedulingMonthPo)queryForObject(buffer.toString(), null, SchedulingMonthPo.class);
	}
	
	public int getSchedulingMonthPoRepeat(SchedulingMonthPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( M_SM_UUID )");
		buffer.append("   from M_SchedulingMonth where ");
		buffer.append(" M_SM_Year = '" + po.getMsmyear()+ "'");
		buffer.append(" and M_SM_Month = '" + po.getMsmmonth() + "'");
		//buffer.append(" and M_SM_Departmentid = '" + po.getMsmdepartmentid() + "'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public int getSchedulingDayPoRepeat(SchedulingMonthPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( M_SD_UUID )");
		buffer.append("   from M_SchedulingDay where ");
		buffer.append(" M_SD_SMUUID = '" + po.getMsmuuid()+ "'");
		//buffer.append(" M_SD_Departmentid = '" + po.getMsddepartmentid()+ "'");
		//buffer.append(" and M_SD_SchedulingDate = '" + po.getMsdschedulingdate() + "'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	/**
	 * 得到日排班
	 * @return
	 */
	public SchedulingDayPo getSchedulingDayByDate(String month,String day)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" 	M_SD_UUID as msduuid	, ");
		buffer.append(" 	M_SD_Number as	msdnumber , ");
		buffer.append(" 	M_SD_Departmentid as msddepartmentid , ");
		buffer.append(" 	M_SD_SchedulingDate	as msdschedulingdate , ");
		buffer.append(" 	M_SD_CreatePersonid as	msdcreatepersonid , ");
		buffer.append(" 	M_SD_CreateDate as	msdcreatedate , ");
		buffer.append(" 	M_SD_ExaminePersonid as	 msdexaminepersonid , ");
		buffer.append(" 	M_SD_ExamineState as msdexaminestate , ");
		buffer.append(" 	M_SD_ExamineDate as	msdexaminedate , ");
		buffer.append(" 	M_SD_Remark as	msdremark, ");
		buffer.append(" 	M_SD_SMUUID as	msdsmuuid ");
		    
		buffer.append("   from M_SchedulingDay where ");
		buffer.append(" M_SD_SMUUID = '" + month+ "'");
		buffer.append(" and M_SD_SchedulingDate = '" + day+ "'");
		//buffer.append(" M_SD_Departmentid = '" + po.getMsddepartmentid()+ "'");
		//buffer.append(" and M_SD_SchedulingDate = '" + po.getMsdschedulingdate() + "'");
		return (SchedulingDayPo)queryForObject(buffer.toString(), null, SchedulingDayPo.class);
	}
	
	/**
	 * 得到日排班id
	 * @return
	 */
	public SchedulingDayPo getSchedulingDayIdByDate(String month,String day)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" 	M_SD_UUID as msduuid	");
		    
		buffer.append("   from M_SchedulingDay where ");
		buffer.append(" M_SD_SMUUID = '" + month+ "'");
		buffer.append(" and M_SD_SchedulingDate = '" + day+ "'");
		//buffer.append(" M_SD_Departmentid = '" + po.getMsddepartmentid()+ "'");
		//buffer.append(" and M_SD_SchedulingDate = '" + po.getMsdschedulingdate() + "'");
		return (SchedulingDayPo)queryForObject(buffer.toString(), null, SchedulingDayPo.class);
	}
	
	public int getSchedulingPersonPoRepeat(SchedulingPersonPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( M_SP_UUID )");
		buffer.append("   from M_SchedulingPerson where ");
		buffer.append(" M_SP_SMUUID = '" + po.getMspsmuuid()+ "'");
		buffer.append(" and  M_SP_Personid = '" + po.getMsppersonid()+ "'");
		//buffer.append(" M_SD_Departmentid = '" + po.getMsddepartmentid()+ "'");
		//buffer.append(" and M_SD_SchedulingDate = '" + po.getMsdschedulingdate() + "'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	/**
	 * 得到日排班人员
	 * @return
	 */
	public SchedulingPersonPo getSchedulingPersonByDate(SchedulingPersonPo po)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" 	M_SP_UUID as mspuuid	, ");
		buffer.append(" 	M_SP_Personid as	msppersonid , ");
		buffer.append(" 	M_SP_SMUUID as mspsmuuid  ");
		    
		buffer.append("   from M_SchedulingPerson where ");
		buffer.append(" M_SP_SMUUID = '" + po.getMspsmuuid()+ "'");
		buffer.append(" and M_SP_Personid = '" + po.getMsppersonid()+ "'");
		//buffer.append(" M_SD_Departmentid = '" + po.getMsddepartmentid()+ "'");
		//buffer.append(" and M_SD_SchedulingDate = '" + po.getMsdschedulingdate() + "'");
		return (SchedulingPersonPo)queryForObject(buffer.toString(), null, SchedulingPersonPo.class);
	}
	
	/**
	 * 得到日排班人员id
	 * @return
	 */
	public SchedulingPersonPo getSchedulingPersonIdByDate(SchedulingPersonPo po)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" 	M_SP_UUID as mspuuid	");

		    
		buffer.append("   from M_SchedulingPerson where ");
		buffer.append(" M_SP_SMUUID = '" + po.getMspsmuuid()+ "'");
		buffer.append(" and M_SP_Personid = '" + po.getMsppersonid()+ "'");
		//buffer.append(" M_SD_Departmentid = '" + po.getMsddepartmentid()+ "'");
		//buffer.append(" and M_SD_SchedulingDate = '" + po.getMsdschedulingdate() + "'");
		return (SchedulingPersonPo)queryForObject(buffer.toString(), null, SchedulingPersonPo.class);
	}
	
	public int getSchedulingDayPoUpdate(SchedulingDayPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( M_SD_UUID )");
		buffer.append("   from M_SchedulingDay where ");
		buffer.append(" M_SD_Departmentid = '" + po.getMsddepartmentid()+ "'");
		buffer.append(" and M_SD_SchedulingDate = '" + po.getMsdschedulingdate() + "'");
		buffer.append(" and M_SD_UUID <> '" + po.getMsduuid() + "'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	/**
	 * 新增日排班
	 */
	public void insertSchedulingDayPo(SchedulingDayPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO M_SchedulingDay ");	
		
		buffer.append(" 	(M_SD_UUID	, ");
		buffer.append(" 	M_SD_Number	, ");
		buffer.append(" 	M_SD_Departmentid	, ");
		buffer.append(" 	M_SD_SchedulingDate	, ");
		buffer.append(" 	M_SD_CreatePersonid	, ");
		buffer.append(" 	M_SD_CreateDate	, ");
		buffer.append(" 	M_SD_ExaminePersonid	, ");
		buffer.append(" 	M_SD_ExamineState	, ");
		buffer.append(" 	M_SD_Remark	, ");
		buffer.append(" 	M_SD_SMUUID	) ");

		buffer.append("VALUES    (?, ");
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
		params.add(Utility.getName(po.getMsdnumber()));
		params.add(Utility.getName(po.getMsddepartmentid()));		
		params.add(Utility.getName(po.getMsdschedulingdate()));
		params.add(Utility.getName(po.getMsdcreatepersonid()));
		params.add(Utility.getName(po.getMsdcreatedate()));
		params.add(Utility.getName(po.getMsdexaminepersonid()));
		params.add(Utility.getName(po.getMsdexaminestate()));		
		params.add(Utility.getName(po.getMsdremark()));
		params.add(Utility.getName(po.getMsdsmuuid()));	
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增日排班
	 */
	public void insertSchedulingDayPos(List<SchedulingDayPo> pos) 
	{
		if(null!=pos && pos.size()>0)
		{
			StringBuffer buffer = new StringBuffer();
			List<String> params = new ArrayList<String>();
			
			buffer.append("INSERT INTO M_SchedulingDay ");	
			
			buffer.append(" 	(M_SD_UUID	, ");
			buffer.append(" 	M_SD_Number	, ");
			buffer.append(" 	M_SD_Departmentid	, ");
			buffer.append(" 	M_SD_SchedulingDate	, ");
			buffer.append(" 	M_SD_CreatePersonid	, ");
			buffer.append(" 	M_SD_CreateDate	, ");
			buffer.append(" 	M_SD_ExaminePersonid	, ");
			buffer.append(" 	M_SD_ExamineState	, ");
			buffer.append(" 	M_SD_Remark	, ");
			buffer.append(" 	M_SD_SMUUID	) ");
			
			for(int i=0;i<pos.size();i++)
			{
				SchedulingDayPo po=pos.get(i);
				if(i==pos.size()-1)
				{
					buffer.append(" select '"+Utility.getName(this.uuid.generate())+"','"+Utility.getName(po.getMsdnumber())+"','"+Utility.getName(po.getMsddepartmentid())+"','"+Utility.getName(po.getMsdschedulingdate())+"','"+Utility.getName(po.getMsdcreatepersonid())+"','"+Utility.getName(po.getMsdcreatedate())+"' ,'"+Utility.getName(po.getMsdexaminepersonid())+"','"+Utility.getName(po.getMsdexaminestate())+"','"+Utility.getName(po.getMsdremark())+"','"+Utility.getName(po.getMsdsmuuid())+"' ");
				}else
				{
					buffer.append(" select '"+Utility.getName(this.uuid.generate())+"','"+Utility.getName(po.getMsdnumber())+"','"+Utility.getName(po.getMsddepartmentid())+"','"+Utility.getName(po.getMsdschedulingdate())+"','"+Utility.getName(po.getMsdcreatepersonid())+"','"+Utility.getName(po.getMsdcreatedate())+"' ,'"+Utility.getName(po.getMsdexaminepersonid())+"','"+Utility.getName(po.getMsdexaminestate())+"','"+Utility.getName(po.getMsdremark())+"','"+Utility.getName(po.getMsdsmuuid())+"' union ");			
				}
								
			}	
			
			getJdbcTemplate().update(buffer.toString(), params.toArray());
		}
	}
	/**
	 * 新增日排班班次
	 */
	public void insertSchedulingPersonDayPo(SchedulingPersonDayPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO M_SchedulingPersonDay ");	
		
		buffer.append(" 	(M_SPD_UUID	, ");
		buffer.append(" 	M_SPD_SDUUID, ");
		buffer.append(" 	M_SPD_SPUUID, ");
		buffer.append(" 	M_SPD_SMUUID, ");
		buffer.append(" 	M_SPD_Shiftuuid, ");
		buffer.append(" 	M_SPD_ShiftName	) ");
		buffer.append("VALUES    (?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, "); 
		buffer.append("            ?, "); 
		buffer.append("            ?, "); 
		buffer.append("    			? ) ");		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getMspdsduuid()));
		params.add(Utility.getName(po.getMspdspuuid()));
		params.add(Utility.getName(po.getMspdsmuuid()));
		params.add(Utility.getName(po.getMspdshiftuuid()));
		params.add(Utility.getName(po.getMspdshiftname()));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增日排班班次
	 */
	public void insertSchedulingPersonDayPos(List<SchedulingPersonDayPo> pos) 
	{
		if(null!=pos && pos.size()>0)
		{
			
			StringBuffer buffer = new StringBuffer();
			List<String> params = new ArrayList<String>();
			
			buffer.append("INSERT INTO M_SchedulingPersonDay ");			
			buffer.append(" 	(M_SPD_UUID	, ");
			buffer.append(" 	M_SPD_SDUUID, ");
			buffer.append(" 	M_SPD_SPUUID, ");
			buffer.append(" 	M_SPD_SMUUID, ");
			buffer.append(" 	M_SPD_Shiftuuid, ");
			buffer.append(" 	M_SPD_ShiftName	) ");
			for(int i=0;i<pos.size();i++)
			{
				SchedulingPersonDayPo po=pos.get(i);
				if(i==pos.size()-1)
				{
					buffer.append(" select '"+Utility.getName(this.uuid.generate())+"','"+Utility.getName(po.getMspdsduuid())+"','"+Utility.getName(po.getMspdspuuid())+"','"+Utility.getName(po.getMspdsmuuid())+"','"+po.getMspdshiftuuid()+"','"+po.getMspdshiftname()+"'  ");
				}else
				{
					buffer.append(" select '"+Utility.getName(this.uuid.generate())+"','"+Utility.getName(po.getMspdsduuid())+"','"+Utility.getName(po.getMspdspuuid())+"','"+Utility.getName(po.getMspdsmuuid())+"','"+po.getMspdshiftuuid()+"','"+po.getMspdshiftname()+"'  union ");				
				}
				
				
			}
			getJdbcTemplate().update(buffer.toString(), params.toArray());
		}
	}
	/**
	 * 更新日排班
	 * 
	 * @param 
	 */
	public void updateSchedulingDayPo(SchedulingDayPo po) 
	{		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE M_SchedulingDay ");
		buffer.append("SET ");		
				
		buffer.append(" 	M_SD_Departmentid=?	, ");
		buffer.append(" 	M_SD_SchedulingDate=? ,");
		
		buffer.append(" 	M_SD_SMUUID=? ,");
		buffer.append(" 	M_SD_Remark=? ");
					
		buffer.append("WHERE M_SD_UUID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getMsddepartmentid()));		
		params.add(Utility.getName(po.getMsdschedulingdate()));
		params.add(Utility.getName(po.getMsdsmuuid()));
		params.add(Utility.getName(po.getMsdremark()));
		params.add(Utility.getName(po.getMsduuid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新日排班
	 * 
	 * @param 
	 */
	public void updateSchedulingDayPoWithExamine(SchedulingDayPo po) 
	{		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE M_SchedulingDay ");
		buffer.append("SET ");		
				
		buffer.append(" 	M_SD_ExamineState = '1'	, ");
		buffer.append(" 	M_SD_ExamineDate = getdate() ,");
		buffer.append(" 	M_SD_ExaminePersonid = ? ");
					
		buffer.append("WHERE M_SD_UUID = ? ");

		List<String> params = new ArrayList<String>();
		
		params.add(Utility.getName(po.getMsdexaminepersonid()));
		params.add(Utility.getName(po.getMsduuid()));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增人员排班
	 */
	public void insertSchedulingPersonPo(SchedulingPersonPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO M_SchedulingPerson ");	

		buffer.append(" 	(M_SP_UUID	, ");
		buffer.append(" 	M_SP_Personid	, ");
		buffer.append(" 	M_SP_Shiftuuid	, ");
		buffer.append(" 	M_SP_Remark	, ");
		buffer.append(" 	M_SP_ExaminePersonid	, ");
		buffer.append(" 	M_SP_ExamineState	, ");		
		buffer.append(" 	M_SP_SMUUID )  ");

		buffer.append("VALUES    (?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, "); 
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("            ?, ");
		buffer.append("    			? ) ");		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getMsppersonid()));
		params.add(Utility.getName(po.getMspshiftuuid()));		
		params.add(Utility.getName(po.getMspremark()));
		params.add(Utility.getName(po.getMspexaminepersonid()));
		params.add(Utility.getName(po.getMspexaminestate()));
		params.add(Utility.getName(po.getMspsmuuid()));	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * 新增人员排班s
	 */
	public void insertSchedulingPersonPos(List<SchedulingPersonPo> pos) 
	{
		if(null!=pos && pos.size()>0)
		{
			StringBuffer buffer = new StringBuffer();
			List<String> params = new ArrayList<String>();			
			buffer.append("INSERT INTO M_SchedulingPerson ");	
	
			buffer.append(" 	(M_SP_UUID	, ");
			buffer.append(" 	M_SP_Personid	, ");
			buffer.append(" 	M_SP_Shiftuuid	, ");
			buffer.append(" 	M_SP_Remark	, ");
			buffer.append(" 	M_SP_ExaminePersonid	, ");
			buffer.append(" 	M_SP_ExamineState	, ");		
			buffer.append(" 	M_SP_SMUUID )  ");
			for(int i=0;i<pos.size();i++)
			{
				SchedulingPersonPo po=pos.get(i);
				if(i==pos.size()-1)
				{
					buffer.append(" select '"+Utility.getName(this.uuid.generate())+"','"+Utility.getName(po.getMsppersonid())+"','"+Utility.getName(po.getMspshiftuuid())+"','"+Utility.getName(po.getMspremark())+"','"+Utility.getName(po.getMspexaminepersonid())+"','"+Utility.getName(po.getMspexaminestate())+"' ,'"+Utility.getName(po.getMspsmuuid())+"'  ");
				}else
				{
					buffer.append(" select '"+Utility.getName(this.uuid.generate())+"','"+Utility.getName(po.getMsppersonid())+"','"+Utility.getName(po.getMspshiftuuid())+"','"+Utility.getName(po.getMspremark())+"','"+Utility.getName(po.getMspexaminepersonid())+"','"+Utility.getName(po.getMspexaminestate())+"' ,'"+Utility.getName(po.getMspsmuuid())+"' union  ");							
				}
								
			}	
			
			getJdbcTemplate().update(buffer.toString(), params.toArray());
		}
	}
	
	/**
	 * 删除人员排班
	 * 
	 * @param 
	 */
	public void deleteSchedulingPersons(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from M_SchedulingPerson where M_SP_UUID = '"+id+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 删除日排班
	 * 
	 * @param 
	 */
	public void delSchedulingPersonDay(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from M_SchedulingPersonDay where M_SPD_SPUUID = '"+id+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 删除日排班
	 * 
	 * @param 
	 */
	public void deleteSchedulingPersonDay(SchedulingPersonDayPo po) 
	{
		StringBuffer buffer = new StringBuffer();		
		buffer.append(" delete from M_SchedulingPersonDay where M_SPD_SDUUID = '"+po.getMspdsduuid()+"' and M_SPD_SPUUID='"+po.getMspdspuuid()+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 删除日排班总
	 * 
	 * @param 
	 */
	public void deleteSchedulingDays(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from M_SchedulingDay where M_SD_SMUUID = '"+id+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	/************************************************************************************************************/
	 
	public void delSchedulingDayByMonthid(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from M_SchedulingDay where M_SD_SMUUID = '"+id+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	public void delSchedulingPersonByMonthid(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from M_SchedulingPerson where M_SP_SMUUID = '"+id+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	public void delSchedulingPersonDayByMonthid(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from M_SchedulingPersonDay where M_SPD_SMUUID = '"+id+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 删除月排班
	 * 
	 * @param 
	 */
	public void deleteSchedulingMonthPo(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from M_SchedulingMonth where M_SM_UUID = '"+id+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	
	/************************************************************************************************************/
	/**
	 * 清空日排班中月排班外键
	 * 
	 * @param 
	 */
	public void updateSchedulingDayPoWithMsdsmuuid(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" update M_SchedulingDay set M_SD_SMUUID = '' where M_SD_SMUUID = '"+id+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 得到日排班
	 * @return
	 */
	public SchedulingDayPo selectSchedulingDayPo(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" 	M_SD_UUID as msduuid	, ");
		buffer.append(" 	M_SD_Number as	msdnumber , ");
		buffer.append(" 	M_SD_Departmentid as msddepartmentid , ");
		buffer.append(" 	M_SD_SchedulingDate	as msdschedulingdate , ");
		buffer.append(" 	M_SD_CreatePersonid as	msdcreatepersonid , ");
		buffer.append(" 	M_SD_CreateDate as	msdcreatedate , ");
		buffer.append(" 	M_SD_ExaminePersonid as	 msdexaminepersonid , ");
		buffer.append(" 	M_SD_ExamineState as msdexaminestate , ");
		buffer.append(" 	M_SD_ExamineDate as	msdexaminedate , ");
		buffer.append(" 	M_SD_Remark as	msdremark, ");
		
		buffer.append(" 	a.personName as	msdcreatepersonname, ");
		buffer.append(" 	b.personName as	msdexaminepersonname, ");
		buffer.append(" 	B_Departments.B_DP_DepartmentName as msddepartmentname, ");
		buffer.append(" 	M_SD_SMUUID as	msdsmuuid ");
		    
		buffer.append("from M_SchedulingDay ");
		buffer.append(" left join (select ID,personName from SYS_PersonInfo) a on M_SchedulingDay.M_SD_CreatePersonid=a.id ");
		buffer.append(" left join (select ID,personName from SYS_PersonInfo) b on M_SchedulingDay.M_SD_ExaminePersonid=b.id ");
		buffer.append(" left join B_Departments on M_SchedulingDay.M_SD_Departmentid=B_Departments.B_DP_DepartmentID ");
		buffer.append(" where  ");
		buffer.append("M_SD_UUID = '" + id + "'");
		return (SchedulingDayPo)queryForObject(buffer.toString(), null, SchedulingDayPo.class);
	}
	/**--------------------------------------------------------------------------------------------*/
	/**
	 * 得到当月排班的所有人员
	 * @return
	 */
	public List<SchedulingPersonPo> getSchedulingPersons(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		
		buffer.append(" 	M_SP_UUID as mspuuid , ");
		buffer.append(" 	M_SP_Personid as  msppersonid , ");		
		buffer.append(" 	a.personName as	msppersonname, ");		
		buffer.append(" 	M_SP_SMUUID	 as  mspsmuuid ");
		

		buffer.append("from M_SchedulingPerson ");
		buffer.append(" left join (select ID,personName from SYS_PersonInfo) a on M_SchedulingPerson.M_SP_Personid=a.id ");	
		buffer.append(" where  ");
		buffer.append("M_SP_SMUUID = '" + id + "'");
		return queryForObjectList(buffer.toString(), null,SchedulingPersonPo.class );
	}
	/**
	 * 根据id得到排班人员
	 * @return
	 */
	public SchedulingPersonPo getSchedulingPersonById(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" 	M_SP_UUID as mspuuid	, ");
		buffer.append(" 	M_SP_Personid as	msppersonid , ");
		buffer.append(" 	a.personName as	msppersonname, ");	
		buffer.append(" 	M_SP_SMUUID as mspsmuuid  ");
		    
		buffer.append("   from M_SchedulingPerson ");
		buffer.append(" left join (select ID,personName from SYS_PersonInfo) a on M_SchedulingPerson.M_SP_Personid=a.id ");	
		buffer.append(" where  ");
		buffer.append(" M_SP_UUID = '" + id+ "'");
		//buffer.append(" M_SD_Departmentid = '" + po.getMsddepartmentid()+ "'");
		//buffer.append(" and M_SD_SchedulingDate = '" + po.getMsdschedulingdate() + "'");
		return (SchedulingPersonPo)queryForObject(buffer.toString(), null, SchedulingPersonPo.class);
	}
	/**
	 * 得到当月包含的日期
	 * @return
	 */
	public List<SchedulingDayPo> getSchedulingDays(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" 	M_SD_UUID as msduuid	, ");
		buffer.append(" 	M_SD_Number as	msdnumber , ");
		buffer.append(" 	M_SD_SchedulingDate	as msdschedulingdate , ");
		buffer.append(" 	M_SchedulingMonth.M_SM_Month	as msdmonth , ");
		buffer.append(" 	M_SD_SMUUID as	msdsmuuid ");
		    
		buffer.append("from M_SchedulingDay ");
		
		buffer.append(" left join M_SchedulingMonth  on M_SchedulingDay.M_SD_SMUUID=M_SchedulingMonth.M_SM_UUID ");
		buffer.append(" where  ");
		buffer.append("M_SD_SMUUID = '" + id + "'");
		return queryForObjectList(buffer.toString(), null,SchedulingDayPo.class );
	}	
	
	/**
	 * 得到当月所有人员整月对应的班次
	 * @return
	 */
	public List<SchedulingPersonDayPo> getSchedulingPersonDays(String id,int mm)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" 	M_SPD_UUID as mspduuid	, ");
		buffer.append(" 	M_SPD_SDUUID as	mspdsduuid , ");
		buffer.append(" 	M_SPD_SPUUID	as mspdspuuid , ");
		buffer.append(" 	M_SPD_SMUUID	as mspdsmuuid , ");
		buffer.append(" 	M_SPD_ShiftName	as mspdshiftname , ");
		buffer.append(" 	M_SPD_Shiftuuid  as	mspdshiftuuid ");
		    
		buffer.append("from M_SchedulingPersonDay ");		
		buffer.append(" where  1=1 ");
		if(mm==1)
		{
			buffer.append(" and M_SPD_SMUUID = '" + id + "'");
		}
		if(mm==2)
		{
			buffer.append(" and M_SPD_SPUUID = '" + id + "'");
		}
		return queryForObjectList(buffer.toString(), null,SchedulingPersonDayPo.class );
	}
	
		
	/**--------------------------------------------------------------------------------------------*/
	
	
	/**
	 * 得到日排班总
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfos(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" 	M_SD_UUID as msduuid	, ");
		buffer.append(" 	M_SD_Number as	msdnumber , ");
		buffer.append(" 	M_SD_Departmentid as msddepartmentid , ");
		buffer.append(" 	M_SD_SchedulingDate	as msdschedulingdate , ");
		buffer.append(" 	M_SD_CreatePersonid as	msdcreatepersonid , ");
		buffer.append(" 	M_SD_CreateDate as	msdcreatedate , ");
		buffer.append(" 	M_SD_ExaminePersonid as	 msdexaminepersonid , ");
		buffer.append(" 	M_SD_ExamineState as msdexaminestate , ");
		buffer.append(" 	M_SD_ExamineDate as	msdexaminedate , ");
		buffer.append(" 	M_SD_Remark as	msdremark, ");
		
		buffer.append(" 	a.personName as	msdcreatepersonname, ");
		buffer.append(" 	b.personName as	msdexaminepersonname, ");
		buffer.append(" 	B_Departments.B_DP_DepartmentName as msddepartmentname, ");
		buffer.append(" 	M_SD_SMUUID as	msdsmuuid ");
		    
		buffer.append("from M_SchedulingDay ");
		buffer.append(" left join (select ID,personName from SYS_PersonInfo) a on M_SchedulingDay.M_SD_CreatePersonid=a.id ");
		buffer.append(" left join (select ID,personName from SYS_PersonInfo) b on M_SchedulingDay.M_SD_ExaminePersonid=b.id ");
		buffer.append(" left join B_Departments on M_SchedulingDay.M_SD_Departmentid=B_Departments.B_DP_DepartmentID ");
		buffer.append(" where  ");
		buffer.append("M_SD_SMUUID = '" + id + "'");
		return queryForObjectList(buffer.toString(), null,PersonInfoPo.class );
	}	
	
	/**
	 * 根据部门id得到此部门下的人员
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfoByDept(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("select distinct SYS_PD_PersonID as id,personName  as personName from SYS_PersonDepartments inner join SYS_PersonInfo on SYS_PD_PersonID=SYS_PersonInfo.id ");
		buffer.append("   where SYS_PD_DepartmentID='"+id+"'  and userState='0' and visibleFlag='1' and isInvocation='0'");
		
		
		return queryForObjectList(buffer.toString(), null,PersonInfoPo.class );
	}
	
	/**
	 * 查询出所有班次
	 * @return
	 */
	public List<ShiftMaintainPo> getShiftMaintainPos()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" m_sm_uuid as msmuuid, ");
		buffer.append(" m_sm_shiftnumber as msmshiftNumber, ");
		buffer.append(" m_sm_shiftname as msmshiftName, ");
		buffer.append(" m_sm_worklong as msmworkLong, ");
		buffer.append(" m_sm_workbegin as msmworkBegin, ");
		buffer.append(" m_sm_workend as msmworkEnd ");
		buffer.append(" FROM m_ShiftMaintain ");
		
		return queryForObjectList(buffer.toString(), null,ShiftMaintainPo.class );
	}
	
	
	/**
	 * 查询出具体班次
	 * @return
	 */
	public ShiftMaintainPo getShiftMaintainPo(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append(" m_sm_uuid as msmuuid, ");
		buffer.append(" m_sm_shiftnumber as msmshiftNumber, ");
		buffer.append(" m_sm_shiftname as msmshiftName, ");
		buffer.append(" m_sm_worklong as msmworkLong, ");
		buffer.append(" m_sm_workbegin as msmworkBegin, ");
		buffer.append(" m_sm_workend as msmworkEnd ");
		buffer.append(" FROM m_ShiftMaintain ");
		buffer.append(" where M_SM_UUID ='" + id + "'");
		return (ShiftMaintainPo)queryForObject(buffer.toString(), null, ShiftMaintainPo.class);
	}
	
	/**
	 * 更新日排班外键
	 * 
	 * @param 
	 */
	public void updateSchedulingDayPoWithMsdsmuuid(SchedulingDayPo po) 
	{		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE M_SchedulingDay ");
		buffer.append("SET ");		
		buffer.append(" 	M_SD_SMUUID=? ");
		buffer.append("WHERE M_SD_UUID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getMsdsmuuid()));
		params.add(Utility.getName(po.getMsduuid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新月排班审核状态
	 * 
	 * @param 
	 */
	public void updateSchedulingMonthPoWithExamine(SchedulingMonthPo po) 
	{		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE M_SchedulingMonth ");
		buffer.append("SET ");		
		buffer.append(" 	M_SM_ExaminePersonid = ? , ");
		buffer.append(" 	M_SM_ExamineDate = getdate() , ");
		buffer.append(" 	M_SM_ExamineState = '1' ");
		buffer.append("WHERE M_SM_UUID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getMsmexaminepersonid()));
		params.add(Utility.getName(po.getMsmuuid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
