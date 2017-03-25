package com.pengsheng.eims.personnel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.personnel.dao.AttendanceManageDao;
import com.pengsheng.eims.personnel.persistence.AttendanceManagePo;
import com.pengsheng.eims.personnel.persistence.CompensationTemplatePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class AttendanceManageDaoImpl extends BaseJdbcDaoSupport implements AttendanceManageDao
{
	/**
	 * 查询所有员工考勤(查询条件)
	 * 
	 * @param 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<AttendanceManagePo> getAttendanceManages(AttendanceManagePo po,int start, int size) 
	{
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by M_AM_UUID) as 'rowNum', ");
		buffer.append("M_AM_UUID as mamuuid ");
		buffer.append(",M_AM_PersonId as mampersonid ");
		buffer.append(",mamdepartmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",personName as mampersonname ");
		
		buffer.append(",M_AM_chidao as mamchidao ");
		buffer.append(",M_AM_zaotui as mamzaotui ");
		buffer.append(",M_AM_bingjia as mambingjia ");
		buffer.append(",M_AM_shijia as mamshijia ");
		buffer.append(",M_AM_hunjia as mamhunjia ");
		buffer.append(",M_AM_sangjia as mamsangjia ");
		buffer.append(",M_AM_chanjia as mamchanjia ");
		buffer.append(",M_AM_tanqinjia as mamtanqinjia ");
		buffer.append(",M_AM_gongjia as mamgongjia ");
		buffer.append(",M_AM_chuchai as mamchuchai ");
		buffer.append(",M_AM_waichuxuexi as mamwaichuxuexi ");
		buffer.append(",M_AM_year as mamyear ");
		buffer.append(",M_AM_month as mammonth ");		
		
		buffer.append("from M_AttendanceManage ");
		buffer.append(" left join SYS_PersonInfo ");
		buffer.append("on M_AttendanceManage.M_AM_PersonId = SYS_PersonInfo.id ");
		
		buffer.append(" where userState = 0 ");

		// 员工编号
		if (!"".equals(Utility.getName(po.getMampersonid()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(po.getMampersonid());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(po.getMampersonname()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(po.getMampersonname());
		}
		
		// 所属部门
		if (!"".equals(Utility.getName(po.getMamdepartmentid()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(po.getMamdepartmentid()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}
		//考勤年份
		if(!"".equals(Utility.getName(po.getMamyear())))
		{
			buffer.append("and M_AM_Year = ? ");
			params.add(po.getMamyear());
		}
		//考勤月份
		if(!"".equals(Utility.getName(po.getMammonth())))
		{
			buffer.append("and M_AM_Month = ? ");
			params.add(po.getMammonth());
		}		

		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), AttendanceManagePo.class);
	}

	/**
	 * 查询所有员工考勤总数
	 * 
	 * @param 
	 * @return
	 */
	public int getAttendanceManageCount(AttendanceManagePo po) 
	{
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(M_AM_UUID) from M_AttendanceManage ");
		buffer.append(" left join SYS_PersonInfo ");
		buffer.append("on M_AttendanceManage.M_AM_PersonId = SYS_PersonInfo.id ");
		buffer.append(" where userState = 0 ");

		// 员工编号
		if (!"".equals(Utility.getName(po.getMampersonid()))) {
			buffer.append(" and SYS_PersonInfo.id  like '%' + ? + '%' ");
			params.add(po.getMampersonid());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(po.getMampersonname()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(po.getMampersonname());
		}
		
		// 所属部门
		if (!"".equals(Utility.getName(po.getMamdepartmentid()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(po.getMamdepartmentid()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}
		//考勤年份
		if(!"".equals(Utility.getName(po.getMamyear())))
		{
			buffer.append("and M_AM_Year = ? ");
			params.add(po.getMamyear());
		}
		//考勤月份
		if(!"".equals(Utility.getName(po.getMammonth())))
		{
			buffer.append("and M_AM_Month = ? ");
			params.add(po.getMammonth());
		}		
		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}
	
	/**
	 * 新增员工考勤
	 */
	public void insertAttendanceManagePo(AttendanceManagePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO M_AttendanceManage ");
		buffer.append("            (M_AM_UUID, ");
		buffer.append("           	M_AM_PersonId, ");
		buffer.append("             M_AM_chidao, ");
		buffer.append("             M_AM_zaotui, ");
		buffer.append("             M_AM_bingjia, ");
		buffer.append("             M_AM_shijia, ");
		buffer.append("             M_AM_hunjia, ");
		buffer.append("             M_AM_sangjia, ");
		buffer.append("             M_AM_chanjia, ");

		buffer.append("             M_AM_tanqinjia, ");
		buffer.append("             M_AM_gongjia, ");		
		buffer.append("             M_AM_chuchai, ");
		buffer.append("             M_AM_waichuxuexi, ");
		buffer.append("             M_AM_remark, ");
		buffer.append("             M_AM_Year, ");		
		buffer.append("             M_AM_Month)");				
		
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
		buffer.append("    			? ) ");		
		
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(po.getMampersonid()));
		params.add(Utility.getName(po.getMamchidao()));		
		params.add(Utility.getName(po.getMamzaotui()));
		params.add(Utility.getName(po.getMambingjia()));
		params.add(Utility.getName(po.getMamshijia()));
		params.add(Utility.getName(po.getMamhunjia()));
		params.add(Utility.getName(po.getMamsangjia()));
		params.add(Utility.getName(po.getMamchanjia()));
		
		params.add(Utility.getName(po.getMamtanqinjia()));		
		params.add(Utility.getName(po.getMamgongjia()));
		params.add(Utility.getName(po.getMamchuchai()));
		params.add(Utility.getName(po.getMamwaichuxuexi()));
		params.add(Utility.getName(po.getMamremark()));
		params.add(Utility.getName(po.getMamyear()));		
		params.add(Utility.getName(po.getMammonth()));		

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * 更新员工考勤
	 * 
	 * @param 
	 */
	public void updateAttendanceManagePo(AttendanceManagePo po) 
	{		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE M_AttendanceManage ");
		buffer.append("SET ");		
		
		buffer.append("M_AM_chidao=? ");
		buffer.append(",M_AM_zaotui=? ");
		buffer.append(",M_AM_bingjia=? ");
		buffer.append(",M_AM_shijia=? ");
		buffer.append(",M_AM_hunjia=? ");
		buffer.append(",M_AM_sangjia=? ");
		buffer.append(",M_AM_chanjia=? ");

		buffer.append(",M_AM_tanqinjia=? ");
		buffer.append(",M_AM_gongjia=? ");		
		buffer.append(",M_AM_chuchai=? ");
		buffer.append(",M_AM_waichuxuexi=? ");
		buffer.append(",M_AM_remark=? ");
		
		buffer.append("WHERE M_AM_UUID= ?");

		List<String> params = new ArrayList<String>();		
		
		params.add(Utility.getName(po.getMamchidao()));		
		params.add(Utility.getName(po.getMamzaotui()));
		params.add(Utility.getName(po.getMambingjia()));
		params.add(Utility.getName(po.getMamshijia()));
		params.add(Utility.getName(po.getMamhunjia()));
		params.add(Utility.getName(po.getMamsangjia()));
		params.add(Utility.getName(po.getMamchanjia()));
		
		params.add(Utility.getName(po.getMamtanqinjia()));		
		params.add(Utility.getName(po.getMamgongjia()));
		params.add(Utility.getName(po.getMamchuchai()));
		params.add(Utility.getName(po.getMamwaichuxuexi()));
		params.add(Utility.getName(po.getMamremark()));
				
		params.add(Utility.getName(po.getMamuuid()));	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 删除员工考勤
	 * 
	 * @param 
	 */
	public void deleteAttendanceManagePo(AttendanceManagePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from M_AttendanceManage where M_AM_UUID = '"+Utility.getName(po.getMamuuid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}
	
	
	/**
	 * 得到员工考勤
	 * @return
	 */
	public AttendanceManagePo selectAttendanceManagePo(String id)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append("M_AM_UUID as mamuuid ");
		buffer.append(",M_AM_PersonId as mampersonid ");
		buffer.append(",mamdepartmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",personName as mampersonname ");
		
		buffer.append(",M_AM_chidao as mamchidao ");
		buffer.append(",M_AM_zaotui as mamzaotui ");
		buffer.append(",M_AM_bingjia as mambingjia ");
		buffer.append(",M_AM_shijia as mamshijia ");
		buffer.append(",M_AM_hunjia as mamhunjia ");
		buffer.append(",M_AM_sangjia as mamsangjia ");
		buffer.append(",M_AM_chanjia as mamchanjia ");
		buffer.append(",M_AM_tanqinjia as mamtanqinjia ");
		buffer.append(",M_AM_gongjia as mamgongjia ");
		buffer.append(",M_AM_chuchai as mamchuchai ");
		buffer.append(",M_AM_waichuxuexi as mamwaichuxuexi ");
		buffer.append(",M_AM_year as mamyear ");
		buffer.append(",M_AM_month as mammonth ");	
		buffer.append(",M_AM_remark as mamremark ");		
		
		buffer.append("from  M_AttendanceManage");
		buffer.append(" left join SYS_PersonInfo on M_AttendanceManage.M_AM_PersonId = SYS_PersonInfo.id ");
		buffer.append(" where ");
		buffer.append("M_AM_UUID = '" + id + "'");
		return (AttendanceManagePo)queryForObject(buffer.toString(), null, AttendanceManagePo.class);
	}
	
	/**
	 * 判断员工考勤是否重复
	 * 
	 * @param 
	 * @return
	 */
	public int getAttendanceManageRepeat(AttendanceManagePo po)
	{

		StringBuffer buffer = new StringBuffer();
		buffer.append("select count(M_AM_UUID) from M_AttendanceManage ");

		buffer.append("where M_AM_PersonId in('"+ po.getMampersonid().replace(",","','") +"') and M_AM_Year='"+ po.getMamyear() +"' and M_AM_Month='"+ po.getMammonth() +"'");
		List<String> params = new ArrayList<String>();
		//params.add(Utility.getName(po.getMampersonid()));
		//params.add(Utility.getName(po.getMamyear()));
		//params.add(Utility.getName(po.getMammonth()));
		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}
	
	
	/**
	 * 查询出人员
	 * 
	 * @param 
	 * @return
	 */
	public AttendanceManagePo getPersonByid(String id ) 
	{

		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT  ");
		buffer.append("id as mampersonid,");
		buffer.append("mamdepartmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , ''),");
		buffer.append("personName as mampersonname ");
		
		buffer.append("from SYS_PersonInfo ");		
		buffer.append(" where  ");
		buffer.append(" ID = '" + id + "'");
		return (AttendanceManagePo)queryForObject(buffer.toString(), null, AttendanceManagePo.class);
	}
}
