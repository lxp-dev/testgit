package com.pengsheng.eims.system.persistence;

public class PersonDepartmentsPo {
	
	private String id;				// 主键
	
	private String personID;		// 人员ID
	
	private String departmentID;	// 部门ID

	private String departmentName;	// 部门名称

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

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
