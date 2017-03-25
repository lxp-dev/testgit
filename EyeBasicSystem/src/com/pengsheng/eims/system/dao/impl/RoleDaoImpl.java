package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.system.dao.RoleDao;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PermissionPo;
import com.pengsheng.eims.system.persistence.RolePermissionPo;
import com.pengsheng.eims.system.persistence.RoleTemplatePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class RoleDaoImpl extends BaseJdbcDaoSupport implements RoleDao {

	public void deleteSysRole(RolePo whereSysRolePo) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(" delete from SYS_Roles");
		buffer.append("  where roleID='" + whereSysRolePo.getRoleid() + "'");
		
		buffer.append(" delete from F_RoleDiscount ");
		buffer.append("  where F_RD_RoleID='" + whereSysRolePo.getRoleid() + "'");
		
		buffer.append(" delete from F_RoleDiscountDetails ");
		buffer.append("  where F_RDD_RoleID='" + whereSysRolePo.getRoleid() + "'");

		getJdbcTemplate().execute(buffer.toString());
	}

	public int getPMpersonCount(String pmName, String applicationID) {
		String sql = "SELECT COUNT(*) FROM sys_roles WHERE roleName = '"
				+ pmName + "' and moduleApplicationID = '" + applicationID
				+ "'";

		return getJdbcTemplate().queryForInt(sql);
	}

	public void deleteSysRolePermissionByWhere(
			RolePermissionPo whereSysRolePermissionPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from SYS_RolePermission where 1=1");
		buffer.append(" and roleID='"
					+ whereSysRolePermissionPo.getRoleID() + "'");

		buffer.append(" and applicationID='"
					+ whereSysRolePermissionPo.getApplicationID() + "'");

		getJdbcTemplate().execute(buffer.toString());
	}

	public int getPersonForRole(String roleID, String moduleApplicationID) {

		String sql = "select count(sys_personroles.id) from sys_personroles inner join SYS_PersonInfo on personID=SYS_PersonInfo.ID where userState='0' and roleID='"
				+ roleID + "' and moduleApplicationID = '"
				+ moduleApplicationID + "'";
		return getJdbcTemplate().queryForInt(sql);
	}

	public int getProjectForRole(String roleID, String moduleApplicationID) {

		String sql = "select count(id) from pro_projectperson where roleID='"
				+ roleID + "'";
		return getJdbcTemplate().queryForInt(sql);
	}

	public int getPermissionForRole(String roleID, String moduleApplicationID) {

		String sql = "select count(roleID) from sys_rolepermission where roleID='"
				+ roleID
				+ "' and applicationID = '"
				+ moduleApplicationID
				+ "'";
		return getJdbcTemplate().queryForInt(sql);
	}

	public RolePo getSysRoleByWhere(RolePo sysRolePo) {
		StringBuffer buffer = new StringBuffer(
				"select top 1  * from  SYS_Roles where 1=1");

		if (sysRolePo.getRoleid() != null && !sysRolePo.getRoleid().equals("")) {
			buffer.append(" and roleID='"
					+ Utility.getName(sysRolePo.getRoleid()) + "'");
		}

		if (sysRolePo.getModuleapplicationid() != null
				&& !sysRolePo.getModuleapplicationid().equals("")) {
			buffer
					.append(" and moduleApplicationID='"
							+ Utility.getName(sysRolePo
									.getModuleapplicationid()) + "'");
		}

		RolePo resultSysRolePo = (RolePo) queryForObject(buffer.toString(),
				null, RolePo.class);

		return resultSysRolePo;
	}

	public List<RolePo> getSysRoleList(RolePo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		
		buffer.append(" roleID 					as roleid ");
		buffer.append(" ,roleName				as rolename");
		buffer.append(" ,roleDescription		as roledescription");
		buffer.append(" ,moduleApplicationID 	as moduleapplicationid");
		buffer.append(" ,roleTypeID				as roletypeid");
		buffer.append(" ,F_CN_Name		as rolecompanyname ");
		
		buffer.append("from SYS_Roles left join F_CompanyName on companyID = F_CN_ID where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getRolecompanyid()))){
		    buffer.append(" and companyID = ? ");
			params.add(Utility.getName(po.getRolecompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getRoleid()))){
			buffer.append(" and roleID=? ");
			params.add(Utility.getName(po.getRoleid()));
		}
		if (!"".equals(Utility.getName(po.getRolename()))){
			buffer.append(" and roleName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getRolename()));
		}
		if (!"".equals(Utility.getName(po.getRoledescription()))){
			buffer.append(" and roleDescription like '%' + ? + '%' ");
			params.add(Utility.getName(po.getRoledescription()));
		}

		buffer.append(" and moduleApplicationID = ? ");
	
		params.add(po.getModuleapplicationid());

		return queryForObjectList(buffer.toString(), params.toArray(),
				RolePo.class);
	}

	public void insertSysRole(RolePo sysRolePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO SYS_Roles");
		buffer.append(" (roleID");
		buffer.append(" ,roleName");
		buffer.append(" ,roleDescription");
		buffer.append(" ,moduleApplicationID");
		buffer.append(" ,roleTypeID");
		buffer.append(" ,companyID)");
		buffer.append(" VALUES ");
		buffer.append(" ('" + Utility.getName(sysRolePo.getRoleid()) + "'");
		buffer.append(" ,'" + Utility.getName(sysRolePo.getRolename()) + "'");
		buffer.append(" ,'" + Utility.getName(sysRolePo.getRoledescription()) + "'");
		buffer.append(" ,'" + Utility.getName(sysRolePo.getModuleapplicationid()) + "'");
		buffer.append(" ,'" + Utility.getName(sysRolePo.getRoletypeid()) + "'");
		buffer.append(" ,'" + Utility.getName(sysRolePo.getRolecompanyid()) + "')");
		
		getJdbcTemplate().update(buffer.toString());
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
		buffer.append(" VALUES ");
		buffer.append(" ('" +this.uuid.generate()+"','"+ whereSysRolePermissionPo.getRoleID() + "'");
		buffer.append(" ,'" + whereSysRolePermissionPo.getApplicationID()+ "'");
		buffer.append(" ,'" + whereSysRolePermissionPo.getModuleID() + "'");
		buffer.append(" ,'" + whereSysRolePermissionPo.getPageKey() + "'");
		buffer.append(" ,'" + whereSysRolePermissionPo.getPageValue() + "')");

		getJdbcTemplate().update(buffer.toString());
	}
	
	public void insertSysRolePermissions(String roleID , List<ModulePo> moduleParents){
		StringBuffer buffer = new StringBuffer();
		
		for (ModulePo moduleParent : moduleParents) {
			if (moduleParent != null) {
				for (ModulePo modulelower : moduleParent.getModuleLowers()) {
					if (modulelower != null) {
						for (PermissionPo permissionPo : modulelower.getPermissionList()) {
							if (permissionPo != null) {								
								buffer.append("INSERT INTO SYS_RolePermission");
								buffer.append(" (SYS_UUID,roleID");
								buffer.append(" ,applicationID");
								buffer.append(" ,moduleID");
								buffer.append(" ,pageKey");
								buffer.append(" ,pageValue)");
								buffer.append("      VALUES");
								buffer.append(" ('" +this.uuid.generate()+"','"+ roleID + "'");
								buffer.append(" ,'1'");
								buffer.append(" ,'" + Utility.getName(permissionPo.getModuleID()) + "'");
								buffer.append(" ,'" + (Utility.getName(permissionPo.getPageKey()).equals("1") ? "1" : "0") + "'");
								buffer.append(" ,'" + Utility.getName(permissionPo.getPageValue()) + "')");						
							}
						}
					}
				}
			}
		}
		
		getJdbcTemplate().update(buffer.toString());
	}

	public void updateSysRole(RolePo whereSysRolePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update SYS_Roles set");
		buffer.append(" roleName='" + whereSysRolePo.getRolename() + "'");
		buffer.append(" ,roleDescription='" + whereSysRolePo.getRoledescription() + "'");

		buffer.append(" where roleID='" + whereSysRolePo.getRoleid()
						+ "'");

		getJdbcTemplate().update(buffer.toString());
	}

	public void updateRole(RolePo rolePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update top (1) SYS_Roles set");
		buffer.append(" roleTypeID='" + Utility.getName(rolePo.getRoletypeid()) + "'");
		buffer.append(",roleDescription='" + Utility.getName(rolePo.getRoledescription()) + "'");
		
		if (!"".equals(Utility.getName(rolePo.getRolename()))){
			buffer.append(" ,roleName='" + Utility.getName(rolePo.getRolename()) + "'");
		}

		buffer.append(" where roleID='" + rolePo.getRoleid() + "'");

		getJdbcTemplate().update(buffer.toString());
	}

	/*
	 * 获取角色模板
	 */
	public List<RoleTemplatePo> getRoleTemplate(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select SYS_RTE_TemplateID as templateID,SYS_RTE_PermissionID as permissionID,moduleID as roleModuleID,pageValue as rolePageValue ");
		buffer.append("  from SYS_RolesTemplateEntry inner join SYS_Permission on SYS_RTE_PermissionID=ID ");
		buffer.append("  order by moduleID,pageValue ");
		
		return queryForObjectList(buffer.toString(),null,RoleTemplatePo.class);
	}

	/**
	 * Description :获取角色类型列表
	 * @return :角色类型列表
	 */
	public List<RoleTemplatePo> getRoleTypeList() {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT SYS_RT_ID AS templateID, SYS_RT_Describe AS templateDescribe ");
		buffer.append("FROM SYS_RolesTemplate WHERE SYS_RT_Flag = '1'");
		
		return queryForObjectList(buffer.toString(), params.toArray(), RoleTemplatePo.class);
	}
	
	/**
	* Description :获取根菜单列表
	* @return :根菜单列表
	*/
	public List<ModulePo> getRootModules(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select moduleID as moduleid ");
		buffer.append(",moduleApplicationID as moduleapplicationid ");
		buffer.append(",moduleParentID as moduleparentid ");
		buffer.append(",modulePageCode as modulepagecode ");
		buffer.append(",moduleCname as modulecname ");
		buffer.append(",moduleDirectory as moduledirectory ");
		buffer.append(",moduleOrderLevel as moduleorderlevel ");
		buffer.append(",moduleIsSystem as moduleissystem ");
		buffer.append(",moduleClose as moduleclose ");
		buffer.append(",moduleIcon as moduleicon ");
		
		buffer.append(",isUpdate as isupdate from sys_module where moduleParentID = '0' ");
		buffer.append(" order by moduleOrderLevel");

		return queryForObjectList(buffer.toString(),null,ModulePo.class);
	}
	
	/**
	* Description :获取所有菜单列表
	* @return :所有菜单列表
	*/
	public List<ModulePo> getAllModules(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select moduleID as moduleid ");
		buffer.append(",moduleParentID as moduleparentid ");
		buffer.append(",moduleCname as modulecname ");
		buffer.append(",moduleOrderLevel as moduleorderlevel ");
		buffer.append(",moduleClose as moduleclose ");
		
		buffer.append(" from sys_module ");
		buffer.append(" order by moduleparentid,moduleOrderLevel");

		return queryForObjectList(buffer.toString(),null,ModulePo.class);
	}
	
	/**
	* Description :获取根菜单列表
	* @return :根菜单列表
	*/
	public List<ModulePo> getInitRootModules(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select moduleID as moduleid ");
		buffer.append(",moduleApplicationID as moduleapplicationid ");
		buffer.append(",moduleParentID as moduleparentid ");
		buffer.append(",modulePageCode as modulepagecode ");
		buffer.append(",moduleCname as modulecname ");
		buffer.append(",moduleDirectory as moduledirectory ");
		buffer.append(",moduleOrderLevel as moduleorderlevel ");
		buffer.append(",moduleIsSystem as moduleissystem ");
		buffer.append(",moduleClose as moduleclose ");
		buffer.append(",moduleIcon as moduleicon ");
		
		buffer.append(",isUpdate as isupdate from SYS_InitModule where moduleParentID = '0' ");
		buffer.append(" order by moduleOrderLevel");

		return queryForObjectList(buffer.toString(),null,ModulePo.class);
	}
	
	/**
	 * Description :得到父节点下所有的子模块
	 * 
	 * @param parentModuleID 父类模块ID
	 * @return 当前父节点下所有的子模块
	 */
	public List<ModulePo> getChildModules(String parentModuleID){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select moduleID as moduleid ");
		buffer.append(",moduleApplicationID as moduleapplicationid ");
		buffer.append(",moduleParentID as moduleparentid ");
		buffer.append(",modulePageCode as modulepagecode ");
		buffer.append(",moduleCname as modulecname ");
		buffer.append(",moduleDirectory as moduledirectory ");
		buffer.append(",moduleOrderLevel as moduleorderlevel ");
		buffer.append(",moduleIsSystem as moduleissystem ");
		buffer.append(",moduleClose as moduleclose ");
		buffer.append(",moduleIcon as moduleicon ");
		buffer.append(",isUpdate as sIsupdate from sys_module where moduleParentID = ? ");
		buffer.append(" order by moduleOrderLevel");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(parentModuleID));
		
		return queryForObjectList(buffer.toString(),params.toArray(),ModulePo.class);
	}
	
	/**
	 * Description :得到父节点下所有的子模块
	 * 
	 * @param parentModuleID 父类模块ID
	 * @return 当前父节点下所有的子模块
	 */
	public List<ModulePo> getInitChildModules(String parentModuleID){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select moduleID as moduleid ");
		buffer.append(",moduleApplicationID as moduleapplicationid ");
		buffer.append(",moduleParentID as moduleparentid ");
		buffer.append(",modulePageCode as modulepagecode ");
		buffer.append(",moduleCname as modulecname ");
		buffer.append(",moduleDirectory as moduledirectory ");
		buffer.append(",moduleOrderLevel as moduleorderlevel ");
		buffer.append(",moduleIsSystem as moduleissystem ");
		buffer.append(",moduleClose as moduleclose ");
		buffer.append(",moduleIcon as moduleicon ");
		buffer.append(",isUpdate as sIsupdate from SYS_InitModule where moduleParentID = ? ");
		buffer.append(" order by moduleOrderLevel");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(parentModuleID));
		
		return queryForObjectList(buffer.toString(),params.toArray(),ModulePo.class);
	}
	
	/**
	 * Description :获取当前角色的所有权限
	 * 
	 * @param  模块实体类
	 * @return 得到当前角色的所有权限
	 */
	public List<RolePermissionPo> getRolePermission(RolePo rolesPo){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT distinct SYS_Permission.moduleID AS moduleID,dbo.getRolePermission(?,?) AS sPermissionBuffer ");
		buffer.append("  FROM SYS_Permission left join sys_rolepermission on SYS_Permission.moduleID=sys_rolepermission.moduleID and SYS_Permission.pageValue=sys_rolepermission.pageValue ");		
		buffer.append("  WHERE sys_permission.moduleID=? ");
		buffer.append("  GROUP BY SYS_Permission.moduleID ");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(rolesPo.getRoleid()));
		params.add(Utility.getName(rolesPo.getModuleID()));
		params.add(Utility.getName(rolesPo.getModuleID()));
		
		return queryForObjectList(buffer.toString(), params.toArray(), RolePermissionPo.class);
	}

	/**
	 * Description :获取所有权限
	 * 
	 * @param  String roleID
	 * @return 得到所有权限
	 */
	public List<PermissionPo> getRolePermissionListByRoleID(String roleID){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT SYS_Permission.ID as id");
		buffer.append(",SYS_Permission.moduleID as moduleID");
		buffer.append(",SYS_Permission.pageValue as pageValue");		
		buffer.append(",SYS_Permission.pageName as pageName");		
		buffer.append(",sys_rolepermission.pageKey as pageKey");	
		buffer.append("  FROM SYS_Permission ");
		buffer.append("  left join sys_rolepermission on SYS_Permission.moduleID=sys_rolepermission.moduleID and SYS_Permission.pageValue=sys_rolepermission.pageValue ");
		buffer.append("  and roleid='"+ roleID +"' ");
		buffer.append("  group by SYS_Permission.ID  ");
		buffer.append("   ,SYS_Permission.moduleID ");
		buffer.append("   ,SYS_Permission.pageValue ");	
		buffer.append("   ,SYS_Permission.pageName ");
		buffer.append("   ,sys_rolepermission.pageKey ");
		
		return queryForObjectList(buffer.toString(), null, PermissionPo.class);
	}
	
	/**
	 * Description :获取当前角色的所有权限
	 * 
	 * @param  模块实体类
	 * @return 得到当前角色的所有权限
	 */
	public List<RolePermissionPo> getInitRolePermission(RolePo rolesPo){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT distinct a.moduleID AS moduleID,dbo.getInitRolePermission(?) AS sPermissionBuffer ");
		buffer.append("  FROM SYS_InitPermission a left join SYS_Permission b on a.ID=b.ID ");		
		buffer.append("  WHERE a.moduleID=? ");
		buffer.append("  GROUP BY a.moduleID ");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(rolesPo.getModuleID()));
		params.add(Utility.getName(rolesPo.getModuleID()));
		
		return queryForObjectList(buffer.toString(), params.toArray(), RolePermissionPo.class);
	}
	
	/**
	 * Description :删除角色权限对应关系
	 */
	public void deleteRolePersonRelationShip(RolePo rolesPo){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from SYS_PersonRoles where roleID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(rolesPo.getRoleid()));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	/**
	 * Description :获取当前模块的所有权限
	 * 
	 * @param  模块实体类
	 * @return 得到当前模块的所有权限
	 */
	public List<RolePermissionPo> getModulePermission(ModulePo childModulePo){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT distinct sys_permission.moduleID AS moduleID,dbo.getPermission(?) AS sPermissionBuffer ");
		buffer.append("  FROM sys_module INNER JOIN sys_permission ON sys_module.moduleID=sys_permission.moduleID ");
		buffer.append("  WHERE sys_module.moduleID=? AND moduleParentID=? AND sys_module.moduleApplicationID='1' ");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(childModulePo.getModuleid()));
		params.add(Utility.getName(childModulePo.getModuleid()));
		params.add(Utility.getName(childModulePo.getModuleparentid()));
		
		return queryForObjectList(buffer.toString(),params.toArray(),RolePermissionPo.class);
	}
	
	/**
	 * Description :新增角色权限
	 *
	 * @param 角色权限实体类
	 */
	public void rolePermissionInsert(RolePermissionPo rolePermissionPo){
		StringBuffer sb = new StringBuffer();
		sb.append("insert into SYS_RolePermission(SYS_UUID,roleID,applicationID,moduleID,pageValue,pageKey) ");
		sb.append(" values(?,?,?,?,?,?)");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(rolePermissionPo.getRoleID()));
		params.add(Utility.getName(rolePermissionPo.getApplicationID()));
		params.add(Utility.getName(rolePermissionPo.getModuleID()));
		params.add(Utility.getName(rolePermissionPo.getPageValue()));
		params.add(Utility.getName(rolePermissionPo.getPageKey()));	
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 删除权限
	 */
	public void deleteSyStemPermission(ModulePo po){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("delete from SYS_Permission ");
		
		getJdbcTemplate().update(sb.toString());
	}
	
	/**
	 * 删除节点
	 */
	public void deleteSyStemModule(ModulePo po){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("delete from SYS_Module ");
		
		getJdbcTemplate().update(sb.toString());
	}
	
	/**
	 * 新增权限
	 */
	public void insertSyStemPermission(RolePermissionPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO SYS_Permission(ID,moduleID,pageValue,pageName,moduleApplicationID) ");
		sb.append(" SELECT ID,moduleID,pageValue,pageName,moduleApplicationID FROM SYS_InitPermission where moduleID = ? and pageValue = ? ");	
		
		params.add(Utility.getName(po.getModuleID()));
		params.add(Utility.getName(po.getPageValue()));
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	/**
	 * 新增节点
	 */
	public void insertSyStemModule(ModulePo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO SYS_Module(moduleID,moduleApplicationID,moduleParentID,modulePageCode,moduleCname,smallmoduleName,moduleDirectory,moduleOrderLevel,moduleIsSystem,moduleClose,moduleIcon,isUpdate,departmentType,moduleDescribe) ");
		sb.append(" SELECT distinct moduleID,moduleApplicationID,moduleParentID,modulePageCode,moduleCname,smallmoduleName,moduleDirectory,moduleOrderLevel,moduleIsSystem,moduleClose,moduleIcon,isUpdate,departmentType,moduleDescribe FROM SYS_InitModule where 1=1 ");		

		if (!"".equals(Utility.getName(po.getModuleID()))){
			sb.append(" and moduleID in ( ");
			
			String[] moduleArray = Utility.getName(po.getModuleID()).split(",");
			for (int i = 0; i < moduleArray.length; i++){
				sb.append(" ?, ");
				params.add(Utility.getName(moduleArray[i]));
			}
			sb.append(" '' ) ");
		}	
		
		sb.append(" union SELECT distinct moduleID,moduleApplicationID,moduleParentID,modulePageCode,moduleCname,smallmoduleName,moduleDirectory,moduleOrderLevel,moduleIsSystem,moduleClose,moduleIcon,isUpdate,departmentType,moduleDescribe FROM SYS_InitModule where moduleID in (SELECT moduleParentID from (SELECT distinct moduleParentID as moduleParentID FROM SYS_InitModule where 1=1 ");		
		
		if (!"".equals(Utility.getName(po.getModuleID()))){
			sb.append(" and moduleID in ( ");
			
			String[] moduleArray = Utility.getName(po.getModuleID()).split(",");
			for (int i = 0; i < moduleArray.length; i++){
				sb.append(" ?, ");
				params.add(Utility.getName(moduleArray[i]));
			}
			sb.append(" '' ) ");
		}	
		
		sb.append(" )temp ) ");
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	
	
	public List<ModulePo> getModuleList() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select moduleID as moduleid, ");
		buffer.append("moduleApplicationID as moduleapplicationid, ");
		buffer.append("moduleParentID as moduleparentid, ");
		buffer.append("modulePageCode as modulepagecode, ");
		buffer.append("moduleCname as modulecname, ");
		buffer.append("smallmoduleName as smallmodulename, ");
		buffer.append("moduleDirectory as moduledirectory, ");
		buffer.append("moduleOrderLevel as moduleorderlevel, ");
		buffer.append("moduleIsSystem as moduleissystem, ");
		buffer.append("moduleClose as moduleclose, ");
		buffer.append("moduleIcon as moduleicon, ");
		buffer.append("isUpdate as isupdate, ");
		buffer.append("departmentType as departmentType, ");
		buffer.append("moduleDescribe as moduleDescribe, ");
		buffer.append("moduleHelp_htmlUrl as moduleHelpHtmlUrl, ");
		buffer.append("muduleHelp_movieUrl as moduleHelpMovieUrl ");
		buffer.append(" from SYS_Module ");
		

		
		return queryForObjectList(buffer.toString(),null,ModulePo.class);
	}
	
	
	public List<PermissionPo> getPermissionList() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select ID as id, ");		 
		buffer.append("moduleID as moduleID, ");
		buffer.append("pageValue as pageValue, ");
		buffer.append("pageName as pageName, ");
		buffer.append("moduleApplicationID as moduleApplicationID ");
		buffer.append(" from SYS_Permission ");
		
		return queryForObjectList(buffer.toString(),null,PermissionPo.class);
	}
	
	public void insertRoleCopyInfo(RolePo rolePo){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select roleID ");
		sb.append("      ,substring(cast(newid() as varchar(50)),1,32) as newroleID ");
		sb.append("      ,roleName ");
		sb.append("      ,roleDescription ");
		sb.append("      ,moduleApplicationID ");
		sb.append("      ,roleTypeID ");
		sb.append("      ,isDelete ");
		sb.append("      ,companyID ");
		sb.append("      ,? as newcompanyID ");
		sb.append("      into #roleInfo ");
		sb.append("  from SYS_Roles ");
		sb.append("  where companyID = ? ");

		sb.append("INSERT INTO SYS_Roles ");
		sb.append("           (roleID ");
		sb.append("           ,roleName ");
		sb.append("           ,roleDescription ");
		sb.append("           ,moduleApplicationID ");
		sb.append("           ,roleTypeID ");
		sb.append("           ,isDelete ");
		sb.append("           ,companyID) ");
		sb.append("select newroleID ");
		sb.append("      ,roleName ");
		sb.append("      ,roleDescription ");
		sb.append("      ,moduleApplicationID ");
		sb.append("      ,roleTypeID ");
		sb.append("      ,isDelete ");
		sb.append("      ,newcompanyID ");
		sb.append("  from #roleInfo ");

		sb.append("select substring(cast(newid() as varchar(50)),1,32) as SYS_UUID ");
		sb.append("      ,b.newroleID as roleID ");
		sb.append("      ,a.applicationID ");
		sb.append("      ,a.moduleID ");
		sb.append("      ,a.pageValue ");
		sb.append("      ,a.pageKey ");
		sb.append("      into #rolePermissionInfo ");
		sb.append("  from SYS_RolePermission a inner join #roleInfo b on a.roleID = b.roleID ");
		sb.append("  where b.companyID = ? ");

		sb.append("insert into SYS_RolePermission ");
		sb.append("           (SYS_UUID ");
		sb.append("           ,roleID ");
		sb.append("           ,applicationID ");
		sb.append("           ,moduleID ");
		sb.append("           ,pageValue ");
		sb.append("           ,pageKey) ");
		sb.append("select SYS_UUID ");
		sb.append("      ,roleID ");
		sb.append("      ,applicationID ");
		sb.append("      ,moduleID ");
		sb.append("      ,pageValue ");
		sb.append("      ,pageKey ");
		sb.append("  from #rolePermissionInfo ");

		sb.append("drop table #roleInfo ");
		sb.append("drop table #rolePermissionInfo ");
		
		params.add(Utility.getName(rolePo.getRoleothercompanyid()));
		params.add(Utility.getName(rolePo.getRolecompanyid()));
		params.add(Utility.getName(rolePo.getRolecompanyid()));
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
		
	}
		
}