package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.dao.RolePermissionDao;
import com.pengsheng.eims.system.persistence.PermissionPo;
import com.pengsheng.eims.system.persistence.RolePermissionPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * Function：
 * 
 * @author Mysflying E-mail:mysflying@126.com
 * 
 * @version Create Date：2009-5-15 下午12:11:57
 * 
 */

public class RolePermissionDaoImpl extends BaseJdbcDaoSupport implements
		RolePermissionDao {

	public List getSysRolePermissionListByWhere(RolePermissionPo whereSysRolePermissionPo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ?,SYS_RolePermission.applicationID AS applicationID, ");
		buffer.append("SYS_RolePermission.moduleID, SYS_RolePermission.pageValue, ISNULL(SYS_RolePermission.pageKey, 0) AS pageKey, ");
		buffer.append("'' as pageName FROM SYS_RolePermission ");
		//buffer.append("sys_permission.pageName FROM SYS_RolePermission ");
		//buffer.append("  LEFT JOIN sys_permission ON sys_rolepermission.moduleID=sys_permission.moduleID AND sys_rolepermission.pageValue=sys_permission.pageValue ");
		buffer.append("where roleID=? ");
		
		if (!Utility.getName(whereSysRolePermissionPo.getApplicationID()).equals("")) {
			buffer.append(" and applicationID=? ");
		}
		if (!Utility.getName(whereSysRolePermissionPo.getModuleID()).equals("")) {
			buffer.append(" and SYS_RolePermission.moduleID=? ");
		}
		
		//buffer.append(" order by SYS_RolePermission.pageValue ");
		
		params.add(Utility.getName(whereSysRolePermissionPo.getRoleID()));
		params.add(Utility.getName(whereSysRolePermissionPo.getRoleID()));
		params.add(Utility.getName(whereSysRolePermissionPo.getApplicationID()));
		params.add(Utility.getName(whereSysRolePermissionPo.getModuleID()));
		
		return queryForObjectList(buffer.toString(), params.toArray(),RolePermissionPo.class);
	}

	public List<RolePermissionPo> getSysPermissionListByWhere(
			PermissionPo sysPermissionPo) {
		StringBuffer buffer = new StringBuffer();
		buffer
				.append("SELECT moduleApplicationID as applicationID, moduleID, pageValue, '0' as pageKey, pageName FROM sys_permission where 1 = 1 ");

		if (sysPermissionPo.getModuleID() != null) {
			buffer.append(" and moduleID='" + sysPermissionPo.getModuleID()
					+ "'");
		}

		if (sysPermissionPo.getModuleApplicationID() != null) {
			buffer.append(" and moduleApplicationID='"
					+ sysPermissionPo.getModuleApplicationID() + "'");
		}
		buffer.append(" order by pageValue ");

		return queryForObjectList(buffer.toString(), null,
				RolePermissionPo.class);
	}

	public void insertSysRolePermissionByWhere(
			RolePermissionPo whereSysRolePermissionPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO SYS_RolePermission");
		buffer.append(" (SYS_UUID,roleID");
		buffer.append(" ,applicationID");
		buffer.append(" ,moduleID");
		buffer.append(" ,pageKey");
		buffer.append(" ,pageValue)");
		buffer.append("      VALUES");
		buffer.append(" ('" +this.uuid.generate()+"','"+ whereSysRolePermissionPo.getRoleID() + "'");
		buffer
				.append(" ,'" + whereSysRolePermissionPo.getApplicationID()
						+ "'");
		buffer.append(" ,'" + whereSysRolePermissionPo.getModuleID() + "'");
		buffer.append(" ,'" + whereSysRolePermissionPo.getPageKey() + "'");
		buffer.append(" ,'" + whereSysRolePermissionPo.getPageValue() + "')");

		getJdbcTemplate().update(buffer.toString());
	}

	public void deleteSysRolePermissionByWhere(
			RolePermissionPo whereSysRolePermissionPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from SYS_RolePermission where 1=1");
		if (whereSysRolePermissionPo.getRoleID() != null) {
			buffer.append(" and roleID='"
					+ whereSysRolePermissionPo.getRoleID() + "'");
		}

		if (whereSysRolePermissionPo.getApplicationID() != null) {
			buffer.append(" and applicationID='"
					+ whereSysRolePermissionPo.getApplicationID() + "'");
		}

		getJdbcTemplate().execute(buffer.toString());
	}

}
