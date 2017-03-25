package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.SystemModuleDao;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PermissionPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;


public class SystemModuleDaoImpl extends BaseJdbcDaoSupport implements SystemModuleDao {

	public List<ModulePo> getSystemModuleMaxList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT moduleID as moduleid ");
		buffer.append(",moduleApplicationID  as moduleapplicationid,moduleParentID as moduleparentid,modulePageCode as modulepagecode,moduleCname as modulecname,moduleDirectory as moduledirectory, ");
		buffer.append("moduleOrderLevel  as moduleorderlevel,moduleIsSystem as moduleissystem,moduleClose as moduleclose,moduleIcon as moduleicon,isUpdate as isupdate,moduleDescribe as moduleDescribe");
		buffer.append(" ,(select count(b.moduleID) from SYS_Module b where b.moduleParentID <> '0' and b.moduleParentID=a.moduleID) as minCount  ");
		buffer.append(" FROM SYS_Module a ");		
		buffer.append("WHERE moduleParentID = '0' order by moduleOrderLevel ");
		
		return queryForObjectList(buffer.toString(), null, ModulePo.class);
	}

	public List<ModulePo> getSystemModuleMinList(ModulePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT moduleID as moduleid ");
		buffer.append(",moduleApplicationID  as moduleapplicationid,moduleParentID as moduleparentid,modulePageCode as modulepagecode,moduleCname as moduleCname,moduleDirectory as moduledirectory, ");
		buffer.append("moduleOrderLevel  as moduleorderlevel,moduleIsSystem as moduleissystem,moduleClose as moduleclose,moduleIcon as moduleicon,isUpdate as isupdate,moduleDescribe as moduleDescribe");
		buffer.append(" FROM SYS_Module  ");		
		buffer.append("WHERE moduleParentID <> '0' and moduleParentID=? order by moduleOrderLevel ");

		List<String> params = new ArrayList<String>();
		params.add(po.getModuleid());
		
		return queryForObjectList(buffer.toString(), params.toArray(), ModulePo.class);
	}

	public ModulePo getSystemModule(ModulePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1 moduleID as moduleid ");
		buffer.append(",moduleApplicationID  as moduleapplicationid ");
		buffer.append(",moduleParentID  as moduleparentid ");
		buffer.append(",moduleCname as modulecname, moduleParentID as moduleparentid,moduleOrderLevel as moduleorderlevel,moduleIcon as moduleicon,");
		buffer.append("moduleDirectory as moduledirectory,departmentType as departmentType,moduleDescribe as moduleDescribe,isnull(moduleHelp_htmlUrl,'') as moduleHelpHtmlUrl,isnull(muduleHelp_movieUrl,'') as moduleHelpMovieUrl FROM SYS_Module ");
		buffer.append("WHERE moduleID = ?");

		List<String> params = new ArrayList<String>();
		params.add(po.getModuleid());
		
		return (ModulePo) queryForObject(buffer.toString(), params.toArray(), ModulePo.class);
	}
	
	public void insertSystemModule(ModulePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO SYS_Module ");
		buffer.append("(moduleID,moduleApplicationID,moduleParentID,modulePageCode,");
		buffer.append("moduleCname,smallmoduleName,moduleDirectory,moduleOrderLevel,moduleIsSystem,moduleClose,moduleIcon,isUpdate,departmentType,moduleDescribe,moduleHelp_htmlUrl,muduleHelp_movieUrl)");
		buffer.append("VALUES (?, '1', ?, ?,");
		buffer.append("?, ?, ?, ?, 0, 0, ?, null, '1,2,3,4,5',?,?,?)");
		List<String> params = new ArrayList<String>();
		params.add(po.getModuleid());
		params.add(po.getModuleparentid());
		params.add(po.getModuleid());
		params.add(po.getModulecname());
		params.add(po.getModulecname());
		params.add(po.getModuledirectory());
		params.add(po.getModuleorderlevel());
		params.add(po.getModuleicon());
		params.add(Utility.getName(po.getModuleDescribe()));
		params.add(Utility.getName(po.getModuleHelpHtmlUrl()));
		params.add(Utility.getName(po.getModuleHelpMovieUrl()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateSystemModule(ModulePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE SYS_Module SET ");
		if(!"".equals(Utility.getName(po.getModuleparentid())))
		{
			buffer.append("moduleParentID = ?,");
		}
		buffer.append("moduleCname=?,");
		buffer.append("smallmoduleName=?,");
		if(!"".equals(Utility.getName(po.getModuledirectory())))
		{
			buffer.append("moduleDirectory=?,");
		}
		buffer.append("moduleOrderLevel=?,");
		buffer.append("moduleIcon=?, ");
		buffer.append("departmentType=?, ");
		buffer.append("moduleDescribe=? ");
		if (!"".equals(Utility.getName(po.getModuleHelpHtmlUrl()))){
			buffer.append(",moduleHelp_htmlUrl=? ");
		}
		if (!"".equals(Utility.getName(po.getModuleHelpMovieUrl()))){
			buffer.append(",muduleHelp_movieUrl=? ");	
		}			
		buffer.append("WHERE moduleID = ?");

		List<String> params = new ArrayList<String>();
		if(!"".equals(Utility.getName(po.getModuleparentid())))
		{
			params.add(po.getModuleparentid());
		}
		params.add(po.getModulecname());
		params.add(po.getModulecname());
		if(!"".equals(Utility.getName(po.getModuledirectory())))
		{
			params.add(po.getModuledirectory());
		}
		params.add(po.getModuleorderlevel());
		params.add(po.getModuleicon());
		params.add(Utility.getName(po.getDepartmentType()));
		params.add(Utility.getName(po.getModuleDescribe()));
		if (!"".equals(Utility.getName(po.getModuleHelpHtmlUrl()))){
			params.add(Utility.getName(po.getModuleHelpHtmlUrl()));
		}
		if (!"".equals(Utility.getName(po.getModuleHelpMovieUrl()))){
			params.add(Utility.getName(po.getModuleHelpMovieUrl()));
		}
		
		params.add(po.getModuleid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void deleteSystemModule(ModulePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM SYS_Module ");
		buffer.append("WHERE moduleID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getModuleid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void disableSystemModule(ModulePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update SYS_Module SET moduleApplicationID = 0 ");
		buffer.append("WHERE moduleID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getModuleid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void ableSystemModule(ModulePo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update SYS_Module SET moduleApplicationID = 1 ");
		buffer.append("WHERE moduleID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getModuleid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void insertModule(ModulePo modulePo) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO SYS_Module ");
		buffer.append("(moduleID ");
		buffer.append(",moduleApplicationID ");
		buffer.append(",moduleParentID ");
		buffer.append(",modulePageCode ");
		buffer.append(",moduleCname ");
		buffer.append(",smallmoduleName ");
		buffer.append(",moduleDirectory ");
		buffer.append(",moduleOrderLevel ");
		buffer.append(",moduleIsSystem ");
		buffer.append(",moduleClose ");
		buffer.append(",moduleIcon ");
		buffer.append(",isUpdate ");
		buffer.append(",departmentType ");
		buffer.append(",moduleDescribe,moduleHelp_htmlUrl,muduleHelp_movieUrl) ");
		buffer.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(modulePo.getModuleid()));
		params.add(Utility.getName(modulePo.getModuleapplicationid()));
		params.add(Utility.getName(modulePo.getModuleparentid()));
		params.add(Utility.getName(modulePo.getModulepagecode()));
		params.add(Utility.getName(modulePo.getModulecname()));
		params.add(Utility.getName(modulePo.getSmallmodulename()));
		params.add(Utility.getName(modulePo.getModuledirectory()));
		params.add(Utility.getName(modulePo.getModuleorderlevel()));
		params.add(Utility.getName(modulePo.getModuleissystem()));
		params.add(Utility.getName(modulePo.getModuleclose()));
		params.add(Utility.getName(modulePo.getModuleicon()));
		params.add(Utility.getName(modulePo.getIsupdate()));
		params.add(Utility.getName(modulePo.getDepartmentType()));
		params.add(Utility.getName(modulePo.getModuleDescribe()));
		params.add(Utility.getName(modulePo.getModuleHelpHtmlUrl()));
		params.add(Utility.getName(modulePo.getModuleHelpMovieUrl()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
	public void insertPermission(PermissionPo permissionPo) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO SYS_Permission ");
		buffer.append("(ID ");
		buffer.append(",moduleID ");
		buffer.append(",pageValue ");
		buffer.append(",pageName ");
		buffer.append(",moduleApplicationID) ");
		buffer.append(" VALUES (?, ?, ?, ?, ?)");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(permissionPo.getId()));
		params.add(Utility.getName(permissionPo.getModuleID()));
		params.add(Utility.getName(permissionPo.getPageValue()));
		params.add(Utility.getName(permissionPo.getPageName()));
		params.add(Utility.getName(permissionPo.getModuleApplicationID()));

		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
	
	public void deleteModule() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from  SYS_Module ");
		List<String> params = new ArrayList<String>();
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
	public void deletePermission() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from SYS_Permission ");
		List<String> params = new ArrayList<String>();
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
}
