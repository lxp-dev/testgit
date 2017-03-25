package com.pengsheng.eims.basic.persistence;

public class RolePo {

	private String roleid;
	private String rolename;
	private String roledescription;
	private String moduleapplicationid;
	private String roletypeid;
	private String moduleID;
	private String isDelete;
	private String rolecompanyid;
	private String rolecompanyname;
	private String roleothercompanyid;
	
	public String getRoleothercompanyid() {
		return roleothercompanyid;
	}

	public void setRoleothercompanyid(String roleothercompanyid) {
		this.roleothercompanyid = roleothercompanyid;
	}

	public String getRolecompanyname() {
		return rolecompanyname;
	}

	public void setRolecompanyname(String rolecompanyname) {
		this.rolecompanyname = rolecompanyname;
	}

	public String getRolecompanyid() {
		return rolecompanyid;
	}

	public void setRolecompanyid(String rolecompanyid) {
		this.rolecompanyid = rolecompanyid;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledescription() {
		return roledescription;
	}

	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}

	public String getModuleapplicationid() {
		return moduleapplicationid;
	}

	public void setModuleapplicationid(String moduleapplicationid) {
		this.moduleapplicationid = moduleapplicationid;
	}

	public String getRoletypeid() {
		return roletypeid;
	}

	public void setRoletypeid(String roletypeid) {
		this.roletypeid = roletypeid;
	}

	public String getModuleID() {
		return moduleID;
	}

	public void setModuleID(String moduleID) {
		this.moduleID = moduleID;
	}

}
