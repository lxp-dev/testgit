package com.pengsheng.eims.personnel.persistence;

public class EducationPo {

	private String metid;		//主键
	private String metname;		//学历名称
	private String metsalary;	//对应津贴
	public String getMetid() {
		return metid;
	}
	public void setMetid(String metid) {
		this.metid = metid;
	}
	public String getMetname() {
		return metname;
	}
	public void setMetname(String metname) {
		this.metname = metname;
	}
	public String getMetsalary() {
		return metsalary;
	}
	public void setMetsalary(String metsalary) {
		this.metsalary = metsalary;
	}
	
}
