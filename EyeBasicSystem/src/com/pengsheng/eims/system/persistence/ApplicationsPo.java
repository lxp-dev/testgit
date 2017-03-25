package com.pengsheng.eims.system.persistence;

public class ApplicationsPo {

	private String applicationID;

	private String applicationAppName;

	private String applicationAppDescription;

	private String applicationAppUrl;

	private String childrenNum;
	
	private String applicationType;

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getChildrenNum() {
		return childrenNum;
	}

	public void setChildrenNum(String childrenNum) {
		this.childrenNum = childrenNum;
	}

	public String getApplicationAppDescription() {
		return applicationAppDescription;
	}

	public void setApplicationAppDescription(String applicationAppDescription) {
		this.applicationAppDescription = applicationAppDescription;
	}

	public String getApplicationAppName() {
		return applicationAppName;
	}

	public void setApplicationAppName(String applicationAppName) {
		this.applicationAppName = applicationAppName;
	}

	public String getApplicationAppUrl() {
		return applicationAppUrl;
	}

	public void setApplicationAppUrl(String applicationAppUrl) {
		this.applicationAppUrl = applicationAppUrl;
	}

	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}
}