package com.pengsheng.eims.personnel.persistence;

public class PersonFamilyPos 
{	
	private	String[]	mpfuuid	;				//UUID主键	
	private	String[]	mpfrelation	;			//与本人关系
	private	String[]	mpfaddress	;			//居住地
	private	String[]	mpfname	;				//姓名
	private	String[]	mpfoccupation;			//职业
	private	String[]	mpfphone;				//联系电话
	private	String[]	mpfpersonid;			//员工表外键
	public String[] getMpfuuid() {
		return mpfuuid;
	}
	public void setMpfuuid(String[] mpfuuid) {
		this.mpfuuid = mpfuuid;
	}
	public String[] getMpfrelation() {
		return mpfrelation;
	}
	public void setMpfrelation(String[] mpfrelation) {
		this.mpfrelation = mpfrelation;
	}
	public String[] getMpfaddress() {
		return mpfaddress;
	}
	public void setMpfaddress(String[] mpfaddress) {
		this.mpfaddress = mpfaddress;
	}
	public String[] getMpfname() {
		return mpfname;
	}
	public void setMpfname(String[] mpfname) {
		this.mpfname = mpfname;
	}
	public String[] getMpfoccupation() {
		return mpfoccupation;
	}
	public void setMpfoccupation(String[] mpfoccupation) {
		this.mpfoccupation = mpfoccupation;
	}
	public String[] getMpfphone() {
		return mpfphone;
	}
	public void setMpfphone(String[] mpfphone) {
		this.mpfphone = mpfphone;
	}
	public String[] getMpfpersonid() {
		return mpfpersonid;
	}
	public void setMpfpersonid(String[] mpfpersonid) {
		this.mpfpersonid = mpfpersonid;
	}
	
	
	
}
