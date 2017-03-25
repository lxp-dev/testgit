package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.persistence.PersonnelChangePo;
import com.pengsheng.eims.system.dao.MacDao;
import com.pengsheng.eims.system.dao.PersonInfoDao;
import com.pengsheng.eims.system.persistence.MacPo;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class MacDaoImpl extends BaseJdbcDaoSupport implements
		MacDao {

	public void deleteMac(String id) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM SYS_Mac ");
		buffer.append("WHERE SYS_MAC_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(id);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int getISMacrepeat(MacPo macPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( SYS_MAC_ID )");
		buffer.append(" from SYS_Mac where SYS_MAC_ID <> '"+macPo.getSysmacid()+"' and (SYS_MAC_Name = '"+Utility.getName(macPo.getSysmacname())+"' or SYS_MAC_Key = '"+Utility.getName(macPo.getSysmackey())+"')");
		int result = getJdbcTemplate().queryForInt(buffer.toString());
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	public MacPo getMac(MacPo macPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  SYS_MAC_ID as sysmacid ");
		buffer.append(",SYS_MAC_Departmentid  as sysmacdepartmentid ");
		buffer.append(",SYS_MAC_Name as sysmacname ");
		buffer.append(",SYS_MAC_Key as sysmackey ");
		buffer.append(",SYS_MAC_ISAble as sysmacisable ");
		buffer.append(",SYS_MAC_CurrentLoginpersonID as sysmaccurrentloginpersonid ");
		buffer.append("FROM SYS_Mac ");
		buffer.append("WHERE 1 = 1");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(macPo.getSysmacid()))) {
			buffer.append(" AND SYS_MAC_ID = ?");
			params.add(macPo.getSysmacid());
		}

		if (!"".equals(Utility.getName(macPo.getSysmacname()))) {
			buffer.append(" AND SYS_MAC_Name = ?");
			params.add(macPo.getSysmacname());
		}

		if (!"".equals(Utility.getName(macPo.getSysmackey()))) {
			buffer.append(" AND SYS_MAC_Key = ?");
			params.add(macPo.getSysmackey());
		}
		
		return (MacPo) queryForObject(buffer.toString(), params
				.toArray(), MacPo.class);
	}

	public int getMacCount(MacPo macPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(SYS_MAC_ID) FROM SYS_Mac left join B_Departments on SYS_MAC_Departmentid = B_DP_DepartmentID ");
		buffer.append("WHERE 1=1 ");	
		
		if (!"".equals(Utility.getName(macPo.getSysmacid()))) {
			buffer.append(" AND SYS_MAC_ID = ?");
			params.add(macPo.getSysmacid());
		}

		if (!"".equals(Utility.getName(macPo.getSysmacname()))) {
			buffer.append(" AND SYS_MAC_Name like '%' + ? + '%'");
			params.add(macPo.getSysmacname());
		}

		if (!"".equals(Utility.getName(macPo.getSysmackey()))) {
			buffer.append(" AND SYS_MAC_Key like '%' + ? + '%'");
			params.add(macPo.getSysmackey());
		}
		
		if (!"".equals(Utility.getName(macPo.getSysmacdepartmentid()))) {
			buffer.append(" AND SYS_MAC_Departmentid = ? ");
			params.add(macPo.getSysmacdepartmentid());
		}
		
		if (Utility.getName(macPo.getSysmacisable()).equals("1")) {
			buffer.append(" AND SYS_MAC_ISAble = '1'");
		}else if (Utility.getName(macPo.getSysmacisable()).equals("0")) {
			buffer.append(" AND SYS_MAC_ISAble = '0'");
		}		
		
		if (Utility.getName(macPo.getSysmaccurrentloginpersonid()).equals("1")) {
			buffer.append(" AND SYS_MAC_CurrentLoginpersonID is not null and SYS_MAC_CurrentLoginpersonID <> ''");
		}		
		
		if (!"".equals(Utility.getName(macPo.getSysmaccompanyid()))) {
			buffer.append(" AND B_DP_CompanysID = ?");
			params.add(macPo.getSysmaccompanyid());
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<MacPo> getMacList(MacPo macPo, int start, int size) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from ( SELECT ROW_NUMBER() Over(order by SYS_MAC_ID ) as rowNum");
		buffer.append(",SYS_MAC_ID as sysmacid ");
		buffer.append(",SYS_MAC_Departmentid  as sysmacdepartmentid ");
		buffer.append(",SYS_MAC_Name as sysmacname ");
		buffer.append(",SYS_MAC_Key as sysmackey ");
		buffer.append(",SYS_MAC_ISAble as sysmacisable ");
		buffer.append(",SYS_MAC_CurrentLoginpersonID as sysmaccurrentloginpersonid ");
		buffer.append(",B_DP_DepartmentName as sysmacdepartmentname ");
		buffer.append(",personName as sysmaccurrentloginpersonname ");
		
		buffer.append("FROM SYS_Mac ");
		buffer.append("left join B_Departments on SYS_MAC_Departmentid = B_DP_DepartmentID ");
		buffer.append("left join SYS_PersonInfo on SYS_MAC_CurrentLoginpersonID = ID ");
		
		
		buffer.append("WHERE 1=1 ");	
		
		if (!"".equals(Utility.getName(macPo.getSysmacid()))) {
			buffer.append(" AND SYS_MAC_ID = ?");
			params.add(macPo.getSysmacid());
		}

		if (!"".equals(Utility.getName(macPo.getSysmacname()))) {
			buffer.append(" AND SYS_MAC_Name like '%' + ? + '%'");
			params.add(macPo.getSysmacname());
		}

		if (!"".equals(Utility.getName(macPo.getSysmackey()))) {
			buffer.append(" AND SYS_MAC_Key  like '%' + ? + '%'");
			params.add(macPo.getSysmackey());
		}
		
		if (!"".equals(Utility.getName(macPo.getSysmacdepartmentid()))) {
			buffer.append(" AND SYS_MAC_Departmentid = ?");
			params.add(macPo.getSysmacdepartmentid());
		}
		
		if (Utility.getName(macPo.getSysmacisable()).equals("1")) {
			buffer.append(" AND SYS_MAC_ISAble = '1'");
		}else if (Utility.getName(macPo.getSysmacisable()).equals("0")) {
			buffer.append(" AND SYS_MAC_ISAble = '0'");
		}		
		
		if (Utility.getName(macPo.getSysmaccurrentloginpersonid()).equals("1")) {
			buffer.append(" AND SYS_MAC_CurrentLoginpersonID is not null and SYS_MAC_CurrentLoginpersonID <> ''");
		}		
		
		if (!"".equals(Utility.getName(macPo.getSysmaccompanyid()))) {
			buffer.append(" AND B_DP_CompanysID = ? ");
			params.add(macPo.getSysmaccompanyid());
		}
				
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ (start + size));
		
		return queryForObjectList(buffer.toString(), params.toArray(), MacPo.class);
	}

	public void insertMac(MacPo macPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO SYS_Mac ");
		buffer.append("(SYS_MAC_ID ");
		buffer.append(",SYS_MAC_Departmentid ");
		buffer.append(",SYS_MAC_Name ");
		buffer.append(",SYS_MAC_Key ");
		buffer.append(",SYS_MAC_ISAble) ");
		buffer.append("VALUES (?, ?, ?, ?, ?)");

		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(macPo.getSysmacdepartmentid());
		params.add(macPo.getSysmacname());
		params.add(macPo.getSysmackey());
		params.add(macPo.getSysmacisable());		

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateMac(MacPo macPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE SYS_Mac ");
		buffer.append("SET SYS_MAC_Departmentid = ? ,SYS_MAC_Name = ? ,SYS_MAC_Key = ? ,SYS_MAC_ISAble = ? ");
		
		buffer.append("WHERE SYS_MAC_ID = ?");

		List<String> params = new ArrayList<String>();
		
		params.add(macPo.getSysmacdepartmentid());
		params.add(macPo.getSysmacname());
		params.add(macPo.getSysmackey());
		params.add(macPo.getSysmacisable());
		params.add(macPo.getSysmacid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateMacLogin(MacPo macPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE SYS_Mac ");
		buffer.append("SET SYS_MAC_CurrentLoginpersonID = ? ");
		
		buffer.append("WHERE SYS_MAC_Key = ?");

		List<String> params = new ArrayList<String>();
		
		params.add(macPo.getSysmaccurrentloginpersonid());
		params.add(macPo.getSysmackey());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}	
	

	/**
	 * 等到所有人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfosForMac(PersonInfoPo personInfoPo,
			int start, int size) {
		
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;

		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by SYS_PersonInfo.ID) as 'rowNum', ");
		buffer.append("SYS_PersonInfo.*, rolename ,dbo.getDepartmentIDList(SYS_PersonInfo.id) as departmentID,dbo.getDepartmentNameList(SYS_PersonInfo.id) as bdpdepartmentname ");
		buffer.append("from SYS_PersonInfo ");

		buffer.append(" left join SYS_PersonRoles ");
		buffer.append("on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" left join SYS_Roles ");
		buffer.append("on SYS_Roles.roleid = SYS_PersonRoles.roleid ");

		buffer.append(" where userState = 0 and visibleFlag='1' AND ISNULL(checkMac,'') = '0' ");

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
	public int getPersoninfosForMacCount(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(SYS_PersonInfo.id) from SYS_PersonInfo ");

		buffer.append(" left join SYS_PersonRoles ");
		buffer.append(" on SYS_PersonRoles.personID = SYS_PersonInfo.id ");

		buffer.append(" where userState = 0 and visibleFlag='1' AND ISNULL(checkMac,'') = '0' ");

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
		
		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}

	private final String UPDATE_PERSON_CHECK_MAC = "update";
	private final String DEL_PERSON_CHECK_MAC = "del";
	
	public void updatePersonCheckMac(String insertPersonID, String updateOrDelFlag) {
		StringBuffer  sb = new StringBuffer();
		sb.append("UPDATE SYS_PersonInfo ");
		sb.append("SET    checkMac = ? ");
		sb.append("WHERE  ID = ? ");
		List<String> params = new ArrayList<String>();
		if(updateOrDelFlag.equals(UPDATE_PERSON_CHECK_MAC)) {
			params.add("0");
		} else if(updateOrDelFlag.equals(DEL_PERSON_CHECK_MAC)) {
			params.add("1");
		}
		params.add(insertPersonID);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	

}
