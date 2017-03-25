package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.dao.ModuleDao;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ModuleDaoImpl extends BaseJdbcDaoSupport implements ModuleDao {

	public List getSysModuleList() {
		String sqlString = "select * from  SYS_Module order by moduleApplicationID,moduleOrderLevel";
		return queryForObjectList(sqlString, null, ModulePo.class);
	}

	public int getSysModuleRoleList(String userId) {
		String sqlString = "select count(userid) from  sys_personpermission "
				+ "where pagekey = 1 and userID = ? ";
		List<String> params = new ArrayList<String>();
		params.add(userId);

		return getJdbcTemplate().queryForInt(sqlString, params.toArray());
	}

	public ModulePo getModulePo(String modulePageCode) {
		StringBuffer buffer = new StringBuffer(
				"select top 1  * from  SYS_Module where modulePageCode = '"
						+ modulePageCode + "'");

		return (ModulePo) queryForObject(buffer.toString(), null,
				ModulePo.class);

	}

	public ModulePo getModulePo(String modulePageCode, String moduleId) {
		StringBuffer buffer = new StringBuffer(
				"select top 1  * from  SYS_Module where modulePageCode = ? and moduleId <> ?");

		List<String> params = new ArrayList<String>();
		params.add(modulePageCode);
		params.add(moduleId);

		return (ModulePo) queryForObject(buffer.toString(), params.toArray(),
				ModulePo.class);

	}

	public int getSysModuleRoleCount(String roleId) {
		String sqlString = "select count(roleid) from  sys_rolepermission "
				+ "where pagekey = 1 and roleID = ?";
		List<String> params = new ArrayList<String>();
		params.add(roleId);

		return getJdbcTemplate().queryForInt(sqlString, params.toArray());
	}

	public List<ModulePo> getSysModuleListByWhere(PersonInfoPo po) {

		StringBuffer sb = new StringBuffer();
		sb
				.append("select * from sys_module where sys_module.moduleParentID='0' and sys_module.moduleID in");
		sb
				.append(" (select distinct sys_module.moduleParentID from sys_personpermission ");
		sb
				.append("inner join sys_module on sys_personpermission.moduleID = sys_module.moduleID ");
		sb
				.append("where sys_personpermission.pagekey='1' and sys_personpermission.userID= ? )");

		List<String> params = new ArrayList<String>();
		params.add(po.getId());

		return queryForObjectList(sb.toString(), params.toArray(),
				ModulePo.class);
	}

	public List<ModulePo> getSysModuleNullListByWhere(PersonInfoPo po) {

		StringBuffer sb = new StringBuffer();
		sb
				.append("select * from sys_module where sys_module.moduleParentID='0' and sys_module.moduleID IN ");
		sb
				.append(" (select distinct sys_module.moduleParentID from sys_rolepermission");
		sb
				.append("  inner join sys_module on sys_rolepermission.moduleID=sys_module.moduleID");
		sb
				.append("  where sys_rolepermission.pagekey='1' and sys_rolepermission.roleID= ? )");

		List<String> params = new ArrayList<String>();
		params.add(po.getRoleid());

		return queryForObjectList(sb.toString(), params.toArray(),
				ModulePo.class);
	}

	public List<ModulePo> getSysModuleLowerNullListByWhere(String userID,
			String moduleParentID) {
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct module.* from sys_module module ");
		sb
				.append("INNER JOIN sys_rolepermission mission ON module.moduleID = mission.moduleID ");
		sb.append("WHERE pageKey = 1 AND  roleID = ? AND moduleParentID = ?");

		List<String> params = new ArrayList<String>();
		params.add(userID);
		params.add(moduleParentID);

		return queryForObjectList(sb.toString(), params.toArray(),
				ModulePo.class);
	}

	public List<ModulePo> getSysModuleLowerListByWhere(String userID,
			String moduleParentID) {
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct module.* from sys_module module ");
		sb
				.append("INNER JOIN sys_personpermission mission ON module.moduleID = mission.moduleID ");
		sb.append("WHERE pageKey = 1 AND  userID = ? AND moduleParentID = ?");

		List<String> params = new ArrayList<String>();
		params.add(userID);
		params.add(moduleParentID);

		return queryForObjectList(sb.toString(), params.toArray(),
				ModulePo.class);
	}

	public List getSysModuleListByWhere(ModulePo whereModulePo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select * from SYS_Module where 1=1 ");
		if (!Utility.getName(whereModulePo.getModuleparentid()).equals("")) {
			buffer.append(" and moduleParentID=? ");
		}
		if (!Utility.getName(whereModulePo.getModuleapplicationid()).equals("")) {
			buffer.append(" and moduleApplicationID=? ");
		}

		buffer.append(" order by moduleOrderLevel");
		
		params.add(whereModulePo.getModuleparentid());
		params.add(whereModulePo.getModuleapplicationid());
		
		return queryForObjectList(buffer.toString(),params.toArray(), ModulePo.class);
	}

	public int getCount(ModulePo whereModulePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("   select count(moduleID) from SYS_Module where 1=1");
		if (whereModulePo.getModuleparentid() != null
				&& !whereModulePo.getModuleparentid().equals("")) {
			buffer.append(" and moduleParentID='"
					+ whereModulePo.getModuleparentid() + "'");
		}
		if (whereModulePo.getModuleapplicationid() != null
				&& !whereModulePo.getModuleapplicationid().equals("")) {
			buffer.append(" and moduleApplicationID='"
					+ whereModulePo.getModuleapplicationid() + "'");
		}
		// System.out.println(buffer.toString());
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	public int getCountParent(ModulePo whereModulePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("   select count(moduleID) from SYS_Module where 1=1");

		buffer.append(" and moduleParentID='0'");

		if (whereModulePo.getModuleapplicationid() != null
				&& !whereModulePo.getModuleapplicationid().equals("")) {
			buffer.append(" and moduleApplicationID='"
					+ whereModulePo.getModuleapplicationid() + "'");
		}
		// System.out.println(buffer.toString());
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	public void updateSysModuleOrderLevelByWhere(ModulePo whereModulePo,
			String newOrderLeve, String updateKey) {

		StringBuffer buffer = new StringBuffer();
		if (updateKey.equals("updateRun")) {// 排序更新未结束；
			buffer.append("update SYS_Module set isUpdate='"
					+ whereModulePo.getIsupdate() + "',moduleOrderLevel="
					+ newOrderLeve + "");

			buffer.append(" where isUpdate<>'" + whereModulePo.getIsupdate()
					+ "'");
			if (whereModulePo.getModuleapplicationid() != null
					&& !whereModulePo.getModuleapplicationid().equals("")) {// 主功能排序
				buffer.append(" and moduleApplicationID='"
						+ whereModulePo.getModuleapplicationid()
						+ "' and moduleParentID='0' and moduleOrderLevel="
						+ whereModulePo.getModuleorderlevel() + "");
				// System.out.println("主功能排序更新Sql==" + buffer.toString());
			} else if (whereModulePo.getModuleparentid() != null
					&& !whereModulePo.getModuleparentid().equals("")) {// 子功能排序
				buffer.append(" and moduleParentID='"
						+ whereModulePo.getModuleparentid()
						+ "' and moduleOrderLevel="
						+ whereModulePo.getModuleorderlevel() + "");
				// System.out.println("子功能排序更新Sql==" + buffer.toString());
			}

			getJdbcTemplate().update(buffer.toString());
		} else if (updateKey.equals("updateClose")) {// 所有更新都结束的操作,将isUpdate字段恢复默认值；
			buffer.append("update SYS_Module set isUpdate='0'");

			buffer.append(" where isUpdate='" + whereModulePo.getIsupdate()
					+ "'");
			// System.out.println(buffer.toString());
			getJdbcTemplate().update(buffer.toString());
		}
	}

	public ModulePo getSysModuleBywhere(ModulePo whereModulePo) {
		StringBuffer buffer = new StringBuffer(
				"select top 1  * from  SYS_Module where 1=1");

		if (whereModulePo != null && !whereModulePo.getModuleid().equals("")) {
			buffer
					.append(" and moduleID='" + whereModulePo.getModuleid()
							+ "'");
		}

		ModulePo returnModulePo = (ModulePo) queryForObject(buffer.toString(),
				null, ModulePo.class);
		return returnModulePo;
	}

	public ModulePo getSysPerentModuleBywhere(String moduleID) {
		StringBuffer buffer = new StringBuffer(
				"select top 1  * from  SYS_Module where moduleID = (select moduleParentID from SYS_Module)");

		buffer.append(" where moduleID='" + moduleID + "'");

		ModulePo returnModulePo = (ModulePo) queryForObject(buffer.toString(),
				null, ModulePo.class);
		return returnModulePo;
	}

	public void insertSysModuleByWhere(ModulePo whereModulePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO SYS_Module");
		buffer.append(" (moduleID");
		buffer.append(" ,moduleCname");
		buffer.append(" ,moduleParentID");
		buffer.append(" ,moduleApplicationID");
		buffer.append(" ,modulePageCode");
		buffer.append(" ,moduleDirectory");
		buffer.append(" ,moduleIcon");
		buffer.append(" ,moduleIsSystem");
		buffer.append(" ,moduleOrderLevel");
		buffer.append(" ,moduleClose)");
		buffer.append("      VALUES");
		buffer.append(" ('" + this.uuid.generate() + "'");
		buffer.append(" ,'" + whereModulePo.getModulecname() + "'");
		buffer.append(" ,'" + whereModulePo.getModuleparentid() + "'");
		buffer.append(" ,'" + whereModulePo.getModuleapplicationid() + "'");
		buffer.append(" ,'" + whereModulePo.getModulepagecode() + "'");
		buffer.append(" ,'" + whereModulePo.getModuledirectory() + "'");
		buffer.append(" ,'" + whereModulePo.getModuleicon() + "'");
		buffer.append(" ,'" + whereModulePo.getModuleissystem() + "'");
		buffer.append(" ," + getMaxModuleOrderLevel(whereModulePo) + "");
		buffer.append(" ,'" + whereModulePo.getModuleclose() + "')");

		// System.out.println(buffer.toString());
		getJdbcTemplate().update(buffer.toString());

	}

	private String getMaxModuleOrderLevel(ModulePo whereModulePo) {
		StringBuffer buffer = new StringBuffer();
		buffer
				.append("select max(moduleOrderLevel)+1 from SYS_Module where moduleParentID='"
						+ whereModulePo.getModuleparentid() + "'");

		buffer.append(" and moduleApplicationID='"
				+ whereModulePo.getModuleapplicationid() + "'");
		int result = getJdbcTemplate().queryForInt(buffer.toString(), null);
		if (result == 0) {
			result = result + 1;
		}
		return result + "";
	}

	public void updateSysModuleByWhere(ModulePo whereModulePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update SYS_Module set moduleID='"
				+ whereModulePo.getModuleid() + "'");

		if (whereModulePo.getModulepagecode() != null
				&& !whereModulePo.getModulepagecode().equals("")) {
			buffer.append(" , modulePageCode='"
					+ whereModulePo.getModulepagecode() + "'");
		}
		if (whereModulePo.getModulecname() != null
				&& !whereModulePo.getModulecname().equals("")) {
			buffer.append(" , moduleCname='" + whereModulePo.getModulecname()
					+ "'");
		}
		if (whereModulePo.getModuledirectory() != null
				&& !whereModulePo.getModuledirectory().equals("")) {
			buffer.append(" , moduleDirectory='"
					+ whereModulePo.getModuledirectory() + "'");
		}
		if (whereModulePo.getModuleicon() != null
				&& !whereModulePo.getModuleicon().equals("")) {
			buffer.append(" , moduleIcon='" + whereModulePo.getModuleicon()
					+ "'");
		}
		buffer.append(" where moduleID='" + whereModulePo.getModuleid() + "'");

		getJdbcTemplate().update(buffer.toString());
		// System.out.println(buffer.toString());
	}

	public void deleteSysModuleByWhere(ModulePo whereModulePo) {
		String sqlString = "delete from SYS_Module  where moduleID='"
				+ whereModulePo.getModuleid() + "'";
		// System.out.println(sqlString);
		getJdbcTemplate().execute(sqlString);
	}
}