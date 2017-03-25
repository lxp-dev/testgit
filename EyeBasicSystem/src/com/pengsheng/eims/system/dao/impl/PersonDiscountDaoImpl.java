package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.system.dao.PersonDiscountDao;
import com.pengsheng.eims.system.persistence.PersonDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class PersonDiscountDaoImpl extends BaseJdbcDaoSupport implements
		PersonDiscountDao {

	public int getPersonDiscountCount(PersonDiscountPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("select count(distinct F_PD_PersonID) from ( ");
		sb.append("select F_PersonDiscount.F_PD_PersonID as F_PD_PersonID,dbo.getDepartmentNameList(F_PersonDiscount.F_PD_PersonID) as fpddepname from F_PersonDiscount ");
		sb.append(" inner join SYS_PersonInfo on F_PersonDiscount.F_PD_PersonID=SYS_PersonInfo.ID ");
		sb.append(" inner join SYS_PersonRoles on F_PersonDiscount.F_PD_PersonID=SYS_PersonRoles.personID");
		sb.append(" inner join SYS_Roles on SYS_PersonRoles.roleID=SYS_Roles.roleID");
		sb.append(" inner join SYS_PersonDepartments on F_PD_PersonID=SYS_PD_PersonID ");
		sb.append(" inner join B_Departments on SYS_PD_DepartmentID=B_Departments.B_DP_DepartmentID where 1=1");
		if (!"".equals(Utility.getName(po.getFpdpersonid()))) {
			sb.append(" and F_PersonDiscount.F_PD_PersonID like'%"
					+ po.getFpdpersonid() + "%'");//quyanping
		}
		if (!"".equals(Utility.getName(po.getFpdpersonname()))) {
			sb.append(" and SYS_PersonInfo.personName like '%"
					+ po.getFpdpersonname() + "%'");
		}
		if (!"".equals(Utility.getName(po.getFpdroleid()))) {
			sb.append(" and SYS_Roles.roleID='" + po.getFpdroleid() + "'");
		}
		if (!"".equals(Utility.getName(po.getFpddepid()))) {
			sb.append(" and B_Departments.B_DP_DepartmentID='"
					+ po.getFpddepid() + "'");
		}
		if (!"".equals(Utility.getName(po.getFpdcompanyid()))){
			sb.append(" and B_Departments.B_DP_CompanysID='" + po.getFpdcompanyid() + "'");
		}
		sb.append(" )temp ");
		return getJdbcTemplate().queryForInt(sb.toString());
	}

	public List<PersonDiscountPo> getPersonDiscountList(PersonDiscountPo po,
			int start, int size) {

		StringBuffer sb = new StringBuffer();
		sb.append("select temp.fpdpersonid as fpdpersonid,temp.fpdpersonname as fpdpersonname,");
		sb.append("temp.fpdrolename as fpdrolename,temp.fpddepname as fpddepname,");
		sb.append("temp.fpddiscount as fpddiscount,temp.fpdspecialdiscountnumber as fpdspecialdiscountnumber,temp.fpdspecialdiscount as fpdspecialdiscount ");
		
		sb.append(" from ( select ROW_NUMBER() Over(order by temp.fpdpersonid) as rowNum,temp.fpdpersonid as fpdpersonid,temp.fpdpersonname as fpdpersonname,");
		sb.append("temp.fpdrolename as fpdrolename,temp.fpddepname as fpddepname,");
		sb.append("temp.fpddiscount as fpddiscount,temp.fpdspecialdiscountnumber as fpdspecialdiscountnumber,temp.fpdspecialdiscount as fpdspecialdiscount ");
				
		sb.append(" from(select distinct ");
		sb.append("F_PersonDiscount.F_PD_PersonID as fpdpersonid,SYS_PersonInfo.personName as fpdpersonname,");
		sb.append("SYS_Roles.roleName as fpdrolename,dbo.getDepartmentNameList(F_PersonDiscount.F_PD_PersonID) as fpddepname,");
		sb.append("F_PersonDiscount.F_PD_Discount as fpddiscount, ");
		sb.append("F_PersonDiscount.F_PD_SpecialDiscountNumber as fpdspecialdiscountnumber, ");
		sb.append("F_PersonDiscount.F_PD_SpecialDiscount as fpdspecialdiscount ");
		sb.append("from F_PersonDiscount ");
		sb.append(" inner join SYS_PersonInfo on F_PersonDiscount.F_PD_PersonID=SYS_PersonInfo.ID ");
		sb.append(" inner join SYS_PersonRoles on F_PersonDiscount.F_PD_PersonID=SYS_PersonRoles.personID");
		sb.append(" inner join SYS_Roles on SYS_PersonRoles.roleID=SYS_Roles.roleID");
		sb.append(" inner join SYS_PersonDepartments on F_PD_PersonID=SYS_PD_PersonID ");
		sb.append(" inner join B_Departments on SYS_PD_DepartmentID=B_Departments.B_DP_DepartmentID where 1=1");
		
		if (!"".equals(Utility.getName(po.getFpdpersonid()))) {
			sb.append(" and F_PersonDiscount.F_PD_PersonID like'%"
					+ po.getFpdpersonid() + "%'");//quyanping
		}
		if (!"".equals(Utility.getName(po.getFpdpersonname()))) {
			sb.append(" and SYS_PersonInfo.personName like '%"
					+ po.getFpdpersonname() + "%'");
		}
		if (!"".equals(Utility.getName(po.getFpdroleid()))) {
			sb.append(" and SYS_Roles.roleID='" + po.getFpdroleid() + "'");
		}
		if (!"".equals(Utility.getName(po.getFpddepid()))) {
			sb.append(" and B_Departments.B_DP_DepartmentID='"
					+ po.getFpddepid() + "'");
		}
		if (!"".equals(Utility.getName(po.getFpdcompanyid()))){
			sb.append(" and B_Departments.B_DP_CompanysID='" + po.getFpdcompanyid() + "'");
		}
		sb.append(" )temp ) temp where rowNum > " + start + " and rowNum <= " + (start + size));
		return queryForObjectList(sb.toString(), null, PersonDiscountPo.class);
	}

	public void insertPersonDiscount(PersonDiscountPo po) {

		String sql = "insert into F_PersonDiscount values('"
				+ po.getFpdpersonid() + "','"
				+ Utility.getName(po.getFpddiscount())+ "','"
				+ Utility.getName(po.getFpdspecialdiscountnumber())+ "','"
				+ Utility.getName(po.getFpdspecialdiscount())+ "')";
		getJdbcTemplate().update(sql);

	}

	public void updatePersonDiscount(PersonDiscountPo po) {

		String sql = "update F_PersonDiscount set " +
				"F_PD_PersonID='"+ po.getFpdpersonid()+ 
				"',F_PD_Discount='"+ po.getFpddiscount()+ 
				"',F_PD_SpecialDiscountNumber='"+ po.getFpdspecialdiscountnumber()+ 
				"',F_PD_SpecialDiscount='"+ po.getFpdspecialdiscount()+ 
				"' where F_PD_PersonID='"
				+ po.getFpdpersonid() + "'";
		getJdbcTemplate().update(sql);

	}

	public void deletePersonDiscount(PersonDiscountPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" delete from F_PersonDiscount where F_PD_PersonID = ? ");
		sb.append(" delete from F_PersonDiscountDetails where F_PDD_PersonID = ? ");
		
		params.add(Utility.getName(po.getFpdpersonid()));
		params.add(Utility.getName(po.getFpdpersonid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public PersonDiscountPo getPersonDiscount(PersonDiscountPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  SYS_PersonInfo.ID as fpdpersonid,SYS_PersonInfo.personName as fpdpersonname,SYS_Roles.roleName as fpdrolename,");
		sb.append("dbo.getDepartmentNameList(SYS_PersonInfo.ID) as fpddepname,F_PersonDiscount.F_PD_Discount as fpddiscount, ");
		sb.append("F_PersonDiscount.F_PD_SpecialDiscountNumber as fpdspecialdiscountnumber,F_PersonDiscount.F_PD_SpecialDiscount as fpdspecialdiscount from SYS_PersonInfo ");
		sb.append(" inner join SYS_PersonRoles on SYS_PersonInfo.ID=SYS_PersonRoles.personID");
		sb.append(" inner join SYS_Roles on SYS_PersonRoles.roleID=SYS_Roles.roleID");
		sb.append(" left join F_PersonDiscount on F_PersonDiscount.F_PD_PersonID=SYS_PersonInfo.ID");
		sb.append(" inner join SYS_PersonDepartments on SYS_PersonInfo.ID=SYS_PD_PersonID ");
		sb.append(" inner join B_Departments on SYS_PD_DepartmentID=B_Departments.B_DP_DepartmentID ");
		sb.append(" where SYS_PersonInfo.ID='" + po.getFpdpersonid() + "'");
		
		if (!"".equals(Utility.getName(po.getFpdcompanyid()))){
			sb.append(" and B_Departments.B_DP_CompanysID = '" + po.getFpdcompanyid() + "'");
		}

		return (PersonDiscountPo) queryForObject(sb.toString(), null,PersonDiscountPo.class);
	}

	public List<DepartmentsPo> getDepartmentList(RoleDiscountPo rdpo) {
		
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName as bdpdepartmentname from B_Departments where 1 = 1 ");
		
		if (!"".equals(Utility.getName(rdpo.getFrdcompanyid()))){
			sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(rdpo.getFrdcompanyid()));
		}

		return queryForObjectList(sb.toString(), params.toArray(), DepartmentsPo.class);
	}

	public PersonDiscountPo getPersonDiscountDetail(PersonDiscountPo po) {

		String sql = "select top 1  F_PD_PersonID as fpdpersonid,F_PD_Discount as fpddiscount from F_PersonDiscount where F_PD_PersonID='"
				+ po.getFpdpersonid() + "'";

		return (PersonDiscountPo) queryForObject(sql, null,
				PersonDiscountPo.class);
	}
	
	public void insertPersonDiscountDetails(PersonDiscountDetailsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into F_PersonDiscountDetails (");
		buffer.append(" F_PDD_UUID, ");
		buffer.append(" F_PDD_PersonID, ");
		buffer.append(" F_PDD_GoodsLevel, ");
		buffer.append(" F_PDD_Discount, ");
		buffer.append(" F_PDD_SpecialDiscountNumber, ");
		buffer.append(" F_PDD_SpecialDiscount ");
		buffer.append(" )values( ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ? ");
		buffer.append(" ) ");
		
		params.add(this.uuid.generate());
		params.add(po.getFpddpersonid());
		params.add(po.getFpddgoodslevel());
		params.add(po.getFpdddiscount());
		params.add(po.getFpddspecialdiscountnumber());
		params.add(po.getFpddspecialdiscount());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public List<PersonDiscountDetailsPo> selectPersonDiscountDetail(PersonDiscountDetailsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append("	F_PDD_UUID 					as fpdduuid, ");
		buffer.append(" F_PDD_PersonID 				as fpddpersonid, ");
		buffer.append(" B_GL_UUID					as fpddgoodslevel, ");
		buffer.append(" B_GL_Name					as fpddgoodslevelname, ");
		buffer.append(" F_PDD_Discount				as fpdddiscount, ");
		buffer.append(" F_PD_Discount				as fpddpdiscount, ");
		buffer.append(" F_PDD_SpecialDiscountNumber as fpddspecialdiscountnumber, ");
		buffer.append(" F_PDD_SpecialDiscount		as fpddspecialdiscount ");
		buffer.append(" from B_GoodsLevel ");
		buffer.append(" left join F_PersonDiscountDetails on F_PDD_GoodsLevel = B_GL_UUID and F_PDD_PersonID = ?");
		buffer.append(" left join F_PersonDiscount on F_PersonDiscount.F_PD_PersonID=F_PDD_PersonID ");
		buffer.append(" order by B_GL_ID ");
		
		params.add(po.getFpddpersonid());

		return queryForObjectList(buffer.toString(), params.toArray(),PersonDiscountDetailsPo.class);
	}
	
	public void deletePersonDiscountDetails(String pid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" delete from F_PersonDiscountDetails ");
		buffer.append(" where F_PDD_PersonID = ? ");
		
		params.add(pid);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
