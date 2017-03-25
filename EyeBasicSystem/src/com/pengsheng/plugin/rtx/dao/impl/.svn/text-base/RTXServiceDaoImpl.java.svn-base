package com.pengsheng.plugin.rtx.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.plugin.rtx.dao.RTXServiceDao;

public class RTXServiceDaoImpl extends BaseJdbcDaoSupport implements RTXServiceDao {

	public List<DepartmentsPo> getDepartments()  {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as BDPDepartmentName ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag ");
		buffer.append("FROM B_Departments where B_DP_IsClosed=0 ");

		buffer.append(" order by B_DP_DepartmentID");

		return queryForObjectList(buffer.toString(), null, DepartmentsPo.class);
	}

	/**
	 * 得到一个部门的所有人员
	 * 处理一人多岗
	 * @return
	 */
	public List<PersonInfoPo> getPersonsBydepartmentid(String departmentid) {
		// TODO Auto-generated method stub
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select distinct ID as id , ");
		buffer.append("personName as personName,");
		buffer.append("password as password ");
		buffer.append("from SYS_PersonInfo ");
		buffer.append("where  SYS_PersonInfo.ID='admin' or (userState = 0 and visibleFlag='1' and isInvocation='0')");
		
		// 部门
		if (!"".equals(Utility.getName(departmentid))) {
			buffer.append(" and SYS_PersonInfo.id in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID=?) ");
			params.add(departmentid);
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(), PersonInfoPo.class);
		
	}

	public PersonInfoPo getPerson(PersonInfoPo personInfo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  SYS_PersonInfo.ID ");
		buffer.append(",password ");
		buffer.append(",personName ");
		buffer.append(",SYS_PD_DepartmentID as departmentID ");
		buffer.append(",B_Departments.B_DP_DepartmentName as bdpdepartmentname ");
		buffer.append(",userState ");
		buffer.append(",phone ");
		buffer.append(",sex ");
		buffer.append(",email ");
		buffer.append(",address ");
		buffer.append(",cardID ");
		buffer.append(",roleName ");
		buffer.append(",B_Departments.B_DP_Type as departmenttype ");
		buffer.append(",(select count(SYS_PD_DepartmentID) from SYS_PersonDepartments where SYS_PD_PersonID=?) as departmentCount ");
		buffer.append(" FROM SYS_PersonInfo ");
		buffer.append(" inner join SYS_PersonDepartments on SYS_PD_PersonID=SYS_PersonInfo.ID ");
		buffer.append(" inner join B_Departments on B_Departments.B_DP_DepartmentID=SYS_PD_DepartmentID ");
		buffer.append(" left join SYS_PersonRoles on personid=SYS_PersonInfo.id");
		buffer.append(" left join SYS_Roles on SYS_PersonRoles.roleid=SYS_Roles.roleid");
		buffer.append(" where SYS_PersonInfo.ID='admin' or (SYS_PersonInfo.ID = ? and userState = 0 and visibleFlag='1' and isInvocation='0')");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(personInfo.getId()));
		params.add(Utility.getName(personInfo.getId()));

		return (PersonInfoPo) queryForObject(buffer.toString(), params.toArray(), PersonInfoPo.class);
	}

	
	public List<PersonInfoPo> getPersons() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select SYS_PersonInfo.*, dbo.GetdepartmentidlistForRTX(SYS_PersonInfo.id) as departmentID ");
		buffer.append("from SYS_PersonInfo ");
		buffer.append(" left join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" left join SYS_Roles ");
		buffer.append("on SYS_Roles.roleid = SYS_PersonRoles.roleid ");

		buffer.append(" where SYS_PersonInfo.ID='admin' or (userState = 0 and visibleFlag='1' and isInvocation='0')");


		return queryForObjectList(buffer.toString(), null, PersonInfoPo.class);
	}
}
