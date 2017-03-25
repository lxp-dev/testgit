package com.pengsheng.eims.basic.persistence;

public class RegionalConfigurationPo {
	private String bdpdepartmentid;		//部门ID

	private String bdpdepartmentname;	//部门名称
	
	private String isConfig;			//门店是否已经配置所属区域
	
	private String brcregid;			//区域ID

	public String getBdpdepartmentid() {
		return bdpdepartmentid;
	}

	public void setBdpdepartmentid(String bdpdepartmentid) {
		this.bdpdepartmentid = bdpdepartmentid;
	}

	public String getBdpdepartmentname() {
		return bdpdepartmentname;
	}

	public void setBdpdepartmentname(String bdpdepartmentname) {
		this.bdpdepartmentname = bdpdepartmentname;
	}

	public String getIsConfig() {
		return isConfig;
	}

	public void setIsConfig(String isConfig) {
		this.isConfig = isConfig;
	}

	public String getBrcregid() {
		return brcregid;
	}

	public void setBrcregid(String brcregid) {
		this.brcregid = brcregid;
	}


	
}
