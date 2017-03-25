package com.pengsheng.eims.system.persistence;

public class RoleTemplatePo {
	
	private String templateID;
	private String permissionID;
	private String roleModuleID;
	private String rolePageValue;
	private String templateDescribe;
	private String templateFlag;
	
	public String getTemplateID() {
		return templateID;
	}
	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}
	public String getPermissionID() {
		return permissionID;
	}
	public void setPermissionID(String permissionID) {
		this.permissionID = permissionID;
	}
	public String getRoleModuleID() {
		return roleModuleID;
	}
	public void setRoleModuleID(String roleModuleID) {
		this.roleModuleID = roleModuleID;
	}
	public String getRolePageValue() {
		return rolePageValue;
	}
	public void setRolePageValue(String rolePageValue) {
		this.rolePageValue = rolePageValue;
	}
	public String getTemplateDescribe() {
		return templateDescribe;
	}
	public void setTemplateDescribe(String templateDescribe) {
		this.templateDescribe = templateDescribe;
	}
	public String getTemplateFlag() {
		return templateFlag;
	}
	public void setTemplateFlag(String templateFlag) {
		this.templateFlag = templateFlag;
	}
	
}
