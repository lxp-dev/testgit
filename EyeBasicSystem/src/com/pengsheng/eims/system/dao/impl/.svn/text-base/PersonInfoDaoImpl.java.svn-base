package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.persistence.PersonJobTypePo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.personnel.persistence.PersonnelChangePo;
import com.pengsheng.eims.system.dao.PersonInfoDao;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class PersonInfoDaoImpl extends BaseJdbcDaoSupport implements
		PersonInfoDao {

	/**
	 * 等到所有人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfos(PersonInfoPo personInfoPo,
			int start, int size) {
		
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;

		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by SYS_PersonInfo.ID) as 'rowNum', ");
		buffer.append("SYS_PersonInfo.*, rolename ,dbo.getDepartmentIDList(SYS_PersonInfo.id) as departmentID,dbo.getDepartmentNameList(SYS_PersonInfo.id) as bdpdepartmentname ");
		buffer.append(",F_CN_Name as personcompanyname ");
		buffer.append("from SYS_PersonInfo ");
		buffer.append("inner join F_CompanyName on F_CN_ID = personcompanyid ");
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
		
		// 所属公司
		if (!"".equals(Utility.getName(personInfoPo.getPersoncompanyid()))) {
			buffer.append(" and personcompanyid = ? ");
			params.add(personInfoPo.getPersoncompanyid());
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
		
		//总分公司判断
		if ("2".equals(Utility.getName(personInfoPo.getPersoncompanytype()))) {
			buffer.append(" and personcompanyid = ? ");
			params.add(Utility.getName(personInfoPo.getPersoncompanyid()));
		}

		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), PersonInfoPo.class);
	}

	/**
	 * 得到部门中所有在职人员
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfosByDepartmentid(String departmentid){
		StringBuffer buffer = new StringBuffer();
		buffer.append("select distinct(SYS_PersonInfo.id) as id,SYS_PersonInfo.personName as personName from SYS_PersonInfo ");
		buffer.append("left join SYS_PersonDepartments on ID=SYS_PD_PersonID ");
		buffer.append("where isInvocation='0'");
		
		if(!departmentid.equals("")){
			buffer.append(" and SYS_PD_DepartmentID = '"+ departmentid +"' ");
		}

		return queryForObjectList(buffer.toString(), null, PersonInfoPo.class);
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
		buffer.append(" left join SYS_PersonRoles on SYS_PersonRoles.personID = SYS_PersonInfo.id ");
		buffer.append(" where userState = 0 and visibleFlag='1' ");

		// 员工编号
		if (!"".equals(Utility.getName(personInfoPo.getId()))) {
			buffer.append(" and SYS_PersonInfo.id like '%' + ? + '%' ");
			params.add(personInfoPo.getId());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(personInfoPo.getPersonName()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(personInfoPo.getPersonName());
		}
		
		// 所属公司
		if (!"".equals(Utility.getName(personInfoPo.getPersoncompanyid()))) {
			buffer.append(" and personcompanyid = ? ");
			params.add(personInfoPo.getPersoncompanyid());
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
		
		//总分公司判断
		if ("2".equals(Utility.getName(personInfoPo.getPersoncompanytype()))) {
			buffer.append(" and personcompanyid = ? ");
			params.add(Utility.getName(personInfoPo.getPersoncompanyid()));
		}
		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}
	/**
	 * 等到所有人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfos2(PersonInfoPo personInfoPo,
			int start, int size) {
		
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;

		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by SYS_PersonInfo.ID) as 'rowNum', ");
		buffer.append("SYS_PersonInfo.*, rolename ,B_DP_DepartmentID as departmentID,B_DP_DepartmentName as bdpdepartmentname ");
		buffer.append("from SYS_PersonInfo ");

		buffer.append(" left join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" left join SYS_Roles ");
		buffer.append("on SYS_Roles.roleid = SYS_PersonRoles.roleid ");
		buffer.append(" left join SYS_PersonDepartments on SYS_PD_PersonID=SYS_PersonInfo.id  ");
		buffer.append(" left join B_Departments on  SYS_PD_DepartmentID=B_DP_DepartmentID ");

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
			buffer.append(" and SYS_PD_DepartmentID = ? ");
			params.add(personInfoPo.getDepartmentID());
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
	public int getPersoninfosCount2(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(SYS_PersonInfo.id) from SYS_PersonInfo ");

		buffer.append(" left join SYS_PersonRoles ");
		buffer.append(" on SYS_PersonRoles.personID = SYS_PersonInfo.id ");
		buffer.append(" left join SYS_PersonDepartments on SYS_PD_PersonID=SYS_PersonInfo.id  ");
		buffer.append(" left join B_Departments on  SYS_PD_DepartmentID=B_DP_DepartmentID ");

		buffer.append(" where userState = 0 and visibleFlag='1' ");

		// 员工编号
		if (!"".equals(Utility.getName(personInfoPo.getId()))) {
			buffer.append(" and SYS_PersonInfo.id like '%' + ? + '%' ");
			params.add(personInfoPo.getId());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(personInfoPo.getPersonName()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(personInfoPo.getPersonName());
		}

		// 所属部门
		if (!"".equals(Utility.getName(personInfoPo.getDepartmentID()))) {
			buffer.append(" and SYS_PD_DepartmentID = ? ");
			params.add(personInfoPo.getDepartmentID());
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
		StringBuffer buffer = new StringBuffer();
		buffer.append("update SYS_PersonInfo set userState = 1 ");
		buffer.append("where id = ? ");

		getJdbcTemplate().update(buffer.toString(), new String[] { personID });
	}
	
	public void delPersonInfo(String personID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from SYS_PersonInfo ");
		buffer.append("where id = ? ");

		getJdbcTemplate().update(buffer.toString(), new String[] { personID });
	}
	
	public void delPersonDepartments(String personID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from SYS_PersonDepartments ");
		buffer.append("where SYS_PD_PersonID = ? ");

		getJdbcTemplate().update(buffer.toString(), new String[] { personID });
	}
	
	public void delPersonRoles(String personID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from SYS_PersonRoles ");
		buffer.append("where personID = ? ");

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
//		buffer.append(",departmentID ");
		buffer.append(",userState ");
		buffer.append(",phone ");
		buffer.append(",sex ");
		buffer.append(",email ");
		buffer.append(",address ");
		buffer.append(",cardID ");
		buffer.append(",outsourcingFlag "); // 新增委外提醒
		buffer.append(",allocationFlag,isInvocation,visibleFlag,checkMac "); // 新增调拨提醒
		buffer.append(",PersonJobType "); 				//员工职务类型
		buffer.append(",personcompanyid "); 
		buffer.append(",SYS_P_SupplierID) "); 
		buffer.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, '0', '0', ?,'1', ?, ?, ?, ?)");

		List<String> params = new ArrayList<String>();
		params.add(personInfoPo.getId());
		params.add(personInfoPo.getPassword());
		params.add(personInfoPo.getPersonName());
		params.add(personInfoPo.getUserState());
		params.add(personInfoPo.getPhone());
		params.add(personInfoPo.getSex());
		params.add(personInfoPo.getEmail());
		params.add(personInfoPo.getAddress());
		params.add(personInfoPo.getCardid());
		params.add(personInfoPo.getIsinvocation());
		params.add( (null == personInfoPo.getCheckMac() ? "1" : personInfoPo.getCheckMac()) );
		params.add(Utility.getName(personInfoPo.getPersonjobtype()));
		params.add(Utility.getName(personInfoPo.getPersoncompanyid()));
		params.add(Utility.getName(personInfoPo.getSyspsupplierid()));

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
	 * 更新人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonInfo(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE SYS_PersonInfo ");
		buffer.append("SET ");
		buffer.append("personName = ? ");
		buffer.append(",password = ? ");
		buffer.append(",userState = ? ");
		buffer.append(",phone = ? ");
		buffer.append(",sex = ? ");
		buffer.append(",email = ? ");
		buffer.append(",address = ? ");
		buffer.append(",cardID = ? ");
		buffer.append(",isInvocation = ? ");
		
		if(null != personInfoPo.getCheckMac()) {
			buffer.append(",checkMac = ? ");
		}
		buffer.append(",PersonJobType = ? ");
		buffer.append(",personcompanyid = ? "); 
		buffer.append(",SYS_P_SupplierID = ? "); 
		buffer.append("WHERE id = ? ");

		List<String> params = new ArrayList<String>();
		params.add(personInfoPo.getPersonName());
		params.add(personInfoPo.getPassword());
		params.add(personInfoPo.getUserState());
		params.add(personInfoPo.getPhone());
		params.add(personInfoPo.getSex());
		params.add(personInfoPo.getEmail());
		params.add(personInfoPo.getAddress());
		params.add(personInfoPo.getCardid());
		params.add(personInfoPo.getIsinvocation());
		
		if(null != personInfoPo.getCheckMac()) {
			params.add(personInfoPo.getCheckMac());
		}
		params.add(Utility.getName(personInfoPo.getPersonjobtype()));
		params.add(Utility.getName(personInfoPo.getPersoncompanyid()));
		params.add(Utility.getName(personInfoPo.getSyspsupplierid()));
		
		params.add(personInfoPo.getId());

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
		buffer.append("select distinct ");
		buffer.append("stuff((select top 1 ',' + B_DP_CompanysID from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '') as personcompanyid");
		buffer.append(",departmentID=stuff((select ',' + B_DP_DepartmentID from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",bdpdepartmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",SYS_PersonInfo.*, SYS_Roles.roleid,SYS_Roles.roleName as rolename "); 
		buffer.append(",PersonJobType as personjobtype ");
		buffer.append(",personcompanyid ");
		buffer.append(",F_CN_Name 				as personcompanyname ");
		buffer.append(",SYS_P_SupplierID		as syspsupplierid ");
		buffer.append(",B_SP_SupplierName		as syspsuppliername ");
		buffer.append("from SYS_PersonInfo ");
		buffer.append("inner join F_CompanyName on F_CN_ID = personcompanyid ");
		buffer.append("left  join B_Supplier on B_SP_ID = SYS_P_SupplierID ");
		buffer.append("left  join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id left join SYS_Roles on SYS_PersonRoles.roleID=SYS_Roles.roleID ");

		buffer.append("where 1 = 1");

		List<String> params = new ArrayList<String>();

		// 员工编号
		if (!"".equals(Utility.getName(personInfoPo.getId()))) {
			buffer.append(" and SYS_PersonInfo.id = ? ");
			params.add(personInfoPo.getId());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(personInfoPo.getPersonName()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(personInfoPo.getPersonName());
		}
		
		// 员工卡号
		if (!"".equals(Utility.getName(personInfoPo.getCardid()))) {
			buffer.append(" and cardid = ? ");
			params.add(personInfoPo.getCardid());
		}
		
		return (PersonInfoPo) queryForObject(buffer.toString(), params
				.toArray(), PersonInfoPo.class);
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
	 * 人员角色新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonRole(PersonInfoPo personInfoPo) {
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
			buffer.append("where B_SP_SupplierName  like '%' + ? + '%' ");
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
	 * 得到一个部门的所有人员
	 * 处理一人多岗
	 * @return
	 */
	public List<PersonInfoPo> getResponsibility(String departmentid) {
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
		buffer.append(" order by id "); // 天津眼科定制，要将不合格品责任人厂家，售后，车间放在最前面
		
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
		
		buffer.append("SELECT DISTINCT SYS_PersonInfo.ID AS id, personName AS personName, ");
		buffer.append("roleName AS rolename, isInvocation AS isinvocation ");
		buffer.append(",bdpdepartmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(" FROM SYS_PersonInfo ");
		buffer.append("INNER JOIN SYS_PersonRoles ON SYS_PersonRoles.personID = SYS_PersonInfo.ID ");
		buffer.append("INNER JOIN SYS_Roles ON SYS_Roles.roleID = SYS_PersonRoles.roleID ");
		buffer.append(" WHERE 1 = 1 ");

		// 员工编号
		if (!"".equals(Utility.getName(personInfoPo.getId()))) {
			buffer.append(" and SYS_PersonInfo.id = ? ");
			params.add(personInfoPo.getId());
		}

		// 员工姓名
		if (!"".equals(Utility.getName(personInfoPo.getPersonName()))) {
			buffer.append(" and personName like '%' + ? + '%' ");
			params.add(personInfoPo.getPersonName());
		}

		// 所属部门
		if (!"".equals(Utility.getName(personInfoPo.getDepartmentID()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID = ?) ");
			params.add(personInfoPo.getDepartmentID());
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
		
		// 所属公司
		if (!"".equals(Utility.getName(personInfoPo.getPersoncompanyid()))) {
			buffer.append(" and SYS_PersonInfo.personcompanyid = ? ");
			params.add(Utility.getName(personInfoPo.getPersoncompanyid()));
		}
		
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
		varname1.append("                                      AND pageKey = '1' and pageValue = '1' ");
		varname1.append("  )) ");
		varname1.append(" and SYS_PD_DepartmentID = ? ");
		varname1.append(" and  isInvocation='0' ");
		
		params.add(moduleid);
		params.add(departmentID);
		return queryForObjectList(varname1.toString(), params.toArray(), PersonInfoPo.class);
	}
	
	/**
	 * 通过工作类型查出用户
	 * @param jobTypeID
	 * @return
	 */
	public List<PersonInfoPo> getPersoninfoPoListByJobType(String jobTypeID,String departmentID){
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("SELECT ID 				as id, ");
		varname1.append("       personName 		as personName, ");
		varname1.append("       F_PD_Discount 	as personDiscount ");
		varname1.append("FROM   SYS_PersonInfo ");
		varname1.append("inner join SYS_PersonDepartments on id = SYS_PD_PersonID ");
		varname1.append("left join F_PersonDiscount on id = F_PD_PersonID ");
		varname1.append("WHERE PersonJobType like '%"+ jobTypeID +"%' ");
		varname1.append(" and SYS_PD_DepartmentID = ? ");
		varname1.append(" and  isInvocation='0' ");
		
		params.add(departmentID);
		return queryForObjectList(varname1.toString(), params.toArray(), PersonInfoPo.class);
	}
	
	/**
	 * 得到指定人员信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public PersonInfoPo getPersonInfoID(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select distinct SYS_PersonInfo.*, SYS_Roles.roleid,SYS_Roles.roleName as rolename from SYS_PersonInfo ");

		buffer.append(" left join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id left join SYS_Roles on SYS_PersonRoles.roleID=SYS_Roles.roleID ");

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
	 * 卡号去重insert
	 * @param po
	 * @return
	 */
	public int getPersonInfoPoName(PersonInfoPo po) { 
		StringBuffer buffer = new StringBuffer(); 
		buffer.append(" select count(*)"); 
		buffer.append(" from dbo.uview_Person where cardID = '"+Utility.getName(po.getCardid())+"'"); 
		return getJdbcTemplate().queryForInt(buffer.toString()); 
	} 
	
	/**
	 * 卡号去重update
	 * @param po
	 * @return
	 */
	public int getPersonInfoPoNameUpdate(PersonInfoPo po) { 
		StringBuffer buffer = new StringBuffer(); 
		buffer.append(" select count(*)"); 
		buffer.append(" from dbo.uview_Person where cardID = '"+Utility.getName(po.getCardid())+"' and id <> '"+Utility.getName(po.getId())+"'"); 
		return getJdbcTemplate().queryForInt(buffer.toString()); 
	}
	
	/**
	 *人员删除是否已经使用
	 * @param po
	 * @return
	 */
	public int getPersonInfoPoNameSelect(String id) { 
		StringBuffer buffer = new StringBuffer(); 
		buffer.append(" select count(id) from ( "); 
		buffer.append("select C_ST_I_createPerson as id from C_ST_Inventory where C_ST_I_createPerson ='"+Utility.getName(id)+"' union all "); 
		buffer.append("select S_OP_OY_PersonID as id from S_OP_Optometry where S_OP_OY_PersonID ='"+Utility.getName(id)+"' union all "); 
		buffer.append("select S_SE_IT_CreatePerson as id from S_SE_InTransit where S_SE_IT_CreatePerson ='"+Utility.getName(id)+"' union all "); 
		buffer.append("select P_CH_CK_ProcessPersonID as id from P_CH_Check where P_CH_CK_ProcessPersonID ='"+Utility.getName(id)+"' "); 
		buffer.append(" )temp "); 
		return getJdbcTemplate().queryForInt(buffer.toString()); 
	}
	
	/**
	 * 获取员工职务类型List
	 * @return List<PersonJobTypePo>
	 */
	public List<PersonJobTypePo> getPersonJobTypeList(){
		StringBuffer  varname1 = new StringBuffer();
		
		varname1.append("SELECT B_PJT_ID		as bpjtid, ");
		varname1.append("       B_PJT_Name 		as bpjtname ");
		varname1.append("FROM   B_PersonJobType ");
		
		return queryForObjectList(varname1.toString(), null, PersonJobTypePo.class);
	}
	
	/**
	 * 取得角色信息（按公司类型）
	 * 
	 * @return
	 */
	public List<RolePo> getRolesByCompanyType(RolePo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from SYS_Roles ");
		buffer.append("where moduleApplicationID = '1' ");
		
		if(!"".equals(Utility.getName(po.getRolecompanyid()))){
			buffer.append("and (isnull(companyID,'') = ? or isnull(companyID,'') = '') ");
			params.add(Utility.getName(po.getRolecompanyid()));
		}
		
		return queryForObjectList(buffer.toString(),params.toArray(), RolePo.class);
	}
	
	/**
	 * 得到指定人员信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public PersonInfoPo getPersonInfoSupplier(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select distinct ");
		buffer.append(" B_Supplier_Person.ID as ID ");
		buffer.append(" ,password as password ");
		buffer.append(" ,personName as personName ");
		buffer.append(" ,SYS_P_SupplierID as syspsupplierid ");
		buffer.append(" ,SYS_Roles.roleid ");
		buffer.append(" ,SYS_Roles.roleName as rolename "); 
		buffer.append("from B_Supplier_Person ");
		buffer.append("left  join SYS_PersonRoles on SYS_PersonRoles.personID = B_Supplier_Person.id ");
		buffer.append("left join SYS_Roles on SYS_PersonRoles.roleID=SYS_Roles.roleID ");
		buffer.append("where 1 = 1");

		List<String> params = new ArrayList<String>();

		// 制造商ID
		buffer.append(" and SYS_P_SupplierID = ? ");
		params.add(personInfoPo.getSyspsupplierid());

		return (PersonInfoPo) queryForObject(buffer.toString(), params
				.toArray(), PersonInfoPo.class);
	}
	
	/**
	 * 制造商人员新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonInfoSupplier(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO B_Supplier_Person ");
		buffer.append("(ID ");
		buffer.append(",password ");
		buffer.append(",personName ");
		buffer.append(",SYS_P_SupplierID) "); 
		buffer.append("VALUES (?, ?, ?, ?)");

		List<String> params = new ArrayList<String>();
		params.add(personInfoPo.getId());
		params.add(personInfoPo.getPassword());
		params.add(personInfoPo.getPersonName());
		params.add(Utility.getName(personInfoPo.getSyspsupplierid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}
	
	/**
	 * 更新制造商维护人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonInfoSupplier(PersonInfoPo personInfoPo) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE B_Supplier_Person ");
		buffer.append("SET ");
		buffer.append("personName = ? ");
		buffer.append(",password = ? ");
		buffer.append("WHERE id = ? ");

		List<String> params = new ArrayList<String>();
		params.add(personInfoPo.getPersonName());
		params.add(personInfoPo.getPassword());
		
		params.add(personInfoPo.getId());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
