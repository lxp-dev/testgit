package com.pengsheng.eims.system.persistence;

public class PersonRolesPo {

	private String id;
	
	private String personID;
	
	private String roleID;
	
	private String moduleApplicationID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getModuleApplicationID() {
		return moduleApplicationID;
	}

	public void setModuleApplicationID(String moduleApplicationID) {
		this.moduleApplicationID = moduleApplicationID;
	}

}
