package com.pengsheng.eims.system.persistence;

import java.util.List;

/**
 * Function：
 * 
 * @author Mysflying E-mail:mysflying@126.com
 * 
 * @version Create Date：2009-5-28 下午09:17:07
 * 
 */

public class RolePermissionPo {

	private String roleID;

	private String applicationID;

	private String moduleID;

	private String pageValue;

	private String pageKey;

	private String pageName;

	private String sPermissionBuffer;
	private List<PermissionPo> lstPermissionPo;
    private List<PermissionPo> tmpLstPermission = null;  // 权限列表
    
	public List<PermissionPo> getTmpLstPermission() {
		return tmpLstPermission;
	}

	public void setTmpLstPermission(List<PermissionPo> tmpLstPermission) {
		this.tmpLstPermission = tmpLstPermission;
	}

	public List<PermissionPo> getLstPermissionPo() {
		return lstPermissionPo;
	}

	public void setLstPermissionPo(List<PermissionPo> lstPermissionPo) {
		this.lstPermissionPo = lstPermissionPo;
	}

	public String getsPermissionBuffer() {
		return sPermissionBuffer;
	}

	public void setsPermissionBuffer(String sPermissionBuffer) {
		this.sPermissionBuffer = sPermissionBuffer;
	}

	public String getPageKey() {
		return pageKey;
	}

	public void setPageKey(String pageKey) {
		this.pageKey = pageKey;
	}

	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public String getModuleID() {
		return moduleID;
	}

	public void setModuleID(String moduleID) {
		this.moduleID = moduleID;
	}

	public String getPageValue() {
		return pageValue;
	}

	public void setPageValue(String pageValue) {
		this.pageValue = pageValue;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

}
