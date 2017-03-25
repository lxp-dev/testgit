package com.pengsheng.eims.personnel.persistence;

public class PostPo {
	private String mptid;	//主键
	private String mptcontent;	//职务/职称
	private String mptparented;	//父ID
	private String mptparentedname;	//父name
	private String mptdeptid;	//级别：1：职务；2：职称
	private String mptsalary; 	//职称对应的岗位津贴；
	public String getMptsalary() {
		return mptsalary;
	}
	public void setMptsalary(String mptsalary) {
		this.mptsalary = mptsalary;
	}
	private String minCount; 	//职务下包含职称的个数；
	
	public String getMptid() {
		return mptid;
	}
	public void setMptid(String mptid) {
		this.mptid = mptid;
	}
	public String getMptcontent() {
		return mptcontent;
	}
	public void setMptcontent(String mptcontent) {
		this.mptcontent = mptcontent;
	}
	public String getMptparented() {
		return mptparented;
	}
	public void setMptparented(String mptparented) {
		this.mptparented = mptparented;
	}
	public String getMptparentedname() {
		return mptparentedname;
	}
	public void setMptparentedname(String mptparentedname) {
		this.mptparentedname = mptparentedname;
	}
	public String getMptdeptid() {
		return mptdeptid;
	}
	public void setMptdeptid(String mptdeptid) {
		this.mptdeptid = mptdeptid;
	}
	public String getMinCount() {
		return minCount;
	}
	public void setMinCount(String minCount) {
		this.minCount = minCount;
	}
}
