package com.pengsheng.eims.system.dao.impl;

import java.util.List;

import com.pengsheng.eims.system.dao.PersonPermissionDao;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class PersonPermissionDaoImpl extends BaseJdbcDaoSupport implements PersonPermissionDao {

	
	public List<PersonPermissionPo> getPersonPermissionList(PersonPermissionPo po) {
		
		String sql="select a.roleID,a.applicationID,a.moduleID,a.pageValue,a.pageKey,(select top 1 moduleCname from SYS_Module where SYS_Module.moduleID in ( select parentID from ( select top 1 moduleParentID as parentID from SYS_Module where SYS_Module.moduleID=a.moduleID )temp )) as moduleName from sys_rolepermission a inner join SYS_Module b on a.moduleID=b.moduleID " +
				" where roleID =(select roleID from sys_personroles where moduleApplicationID='"+po.getApplicationID()+"'" +
				" and personID='"+po.getPersonID()+"') and a.moduleID='"+po.getModuleID()+"'";
		
		return queryForObjectList(sql,null,PersonPermissionPo.class);
	}
	
	public List<PersonPermissionPo> getProjectPersonPermissionList(
			PersonPermissionPo po) {
		
		String sql="select applicationID,moduleID,pageValue,case sum(pagekey) when 0 then 0 else 1 end as pagekey from sys_rolepermission" +
				" where roleID in(select roleID from pro_projectperson where projectID='"+po.getProjectID()+"' and personID='"+po.getPersonID()+"')" +
				" and moduleID='"+po.getModuleID()+"' group by pageValue";
		
		return queryForObjectList(sql,null,PersonPermissionPo.class);
	}
}
