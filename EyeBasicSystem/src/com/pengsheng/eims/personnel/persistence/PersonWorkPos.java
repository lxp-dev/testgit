package com.pengsheng.eims.personnel.persistence;

public class PersonWorkPos 
{
	private	String[]	mpwuuid	;				//UUID主键
	private	String[]	mpwstartstoptime;		//起止时间
	private	String[]	mpwcompany;				//单位
	private	String[]	mpwdepartment;			//部门
	private	String[]	mpwpost	;				//岗位
	private	String[]	mpwposition	;			//职务
	private	String[]	mpwpersonid	;			//员工表外键
	public String[] getMpwuuid() {
		return mpwuuid;
	}
	public void setMpwuuid(String[] mpwuuid) {
		this.mpwuuid = mpwuuid;
	}
	public String[] getMpwstartstoptime() {
		return mpwstartstoptime;
	}
	public void setMpwstartstoptime(String[] mpwstartstoptime) {
		this.mpwstartstoptime = mpwstartstoptime;
	}
	public String[] getMpwcompany() {
		return mpwcompany;
	}
	public void setMpwcompany(String[] mpwcompany) {
		this.mpwcompany = mpwcompany;
	}
	public String[] getMpwdepartment() {
		return mpwdepartment;
	}
	public void setMpwdepartment(String[] mpwdepartment) {
		this.mpwdepartment = mpwdepartment;
	}
	public String[] getMpwpost() {
		return mpwpost;
	}
	public void setMpwpost(String[] mpwpost) {
		this.mpwpost = mpwpost;
	}
	public String[] getMpwposition() {
		return mpwposition;
	}
	public void setMpwposition(String[] mpwposition) {
		this.mpwposition = mpwposition;
	}
	public String[] getMpwpersonid() {
		return mpwpersonid;
	}
	public void setMpwpersonid(String[] mpwpersonid) {
		this.mpwpersonid = mpwpersonid;
	}
	
	


}
