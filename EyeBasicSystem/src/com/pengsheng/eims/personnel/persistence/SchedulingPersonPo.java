package com.pengsheng.eims.personnel.persistence;

public class SchedulingPersonPo 
{
	private	String	mspuuid	;				//主键
	private	String	msppersonid	;			//人员id
	private	String	mspshiftuuid;			//班次id
	private	String	mspremark	;			//备注
	private	String	mspexaminepersonid;		//审核人员id
	private	String	mspexaminestate	;		//审核状态
	private	String	mspexaminedate	;		//审核日期
	private	String	mspsduuid	;			//日表外键
	private	String	mspsmuuid	;			//月表外键
	private	String	msppersonname	;		//人员
	private	String	mspshiftuuname;			//班次
	private	String	mspexaminepersonname;	//审核人员
	private	String	msdyear				;	//年度
	private	String	msdmonth			;	//月份
	
	
	private	String	personids	;			//人员id
	private	String	personNames	;			//人员姓名
	private	String	departmentids	;			//部门
	
	
	public String getPersonids() {
		return personids;
	}
	public void setPersonids(String personids) {
		this.personids = personids;
	}
	public String getPersonNames() {
		return personNames;
	}
	public void setPersonNames(String personNames) {
		this.personNames = personNames;
	}
	public String getMspuuid() {
		return mspuuid;
	}
	public void setMspuuid(String mspuuid) {
		this.mspuuid = mspuuid;
	}
	public String getMsppersonid() {
		return msppersonid;
	}
	public void setMsppersonid(String msppersonid) {
		this.msppersonid = msppersonid;
	}
	public String getMspshiftuuid() {
		return mspshiftuuid;
	}
	public void setMspshiftuuid(String mspshiftuuid) {
		this.mspshiftuuid = mspshiftuuid;
	}
	public String getMspremark() {
		return mspremark;
	}
	public void setMspremark(String mspremark) {
		this.mspremark = mspremark;
	}
	public String getMspexaminepersonid() {
		return mspexaminepersonid;
	}
	public void setMspexaminepersonid(String mspexaminepersonid) {
		this.mspexaminepersonid = mspexaminepersonid;
	}
	public String getMspexaminestate() {
		return mspexaminestate;
	}
	public void setMspexaminestate(String mspexaminestate) {
		this.mspexaminestate = mspexaminestate;
	}
	public String getMspexaminedate() {
		return mspexaminedate;
	}
	public void setMspexaminedate(String mspexaminedate) {
		this.mspexaminedate = mspexaminedate;
	}
	public String getMspsduuid() {
		return mspsduuid;
	}
	public void setMspsduuid(String mspsduuid) {
		this.mspsduuid = mspsduuid;
	}
	public String getMsppersonname() {
		return msppersonname;
	}
	public void setMsppersonname(String msppersonname) {
		this.msppersonname = msppersonname;
	}
	public String getMspshiftuuname() {
		return mspshiftuuname;
	}
	public void setMspshiftuuname(String mspshiftuuname) {
		this.mspshiftuuname = mspshiftuuname;
	}
	public String getMspexaminepersonname() {
		return mspexaminepersonname;
	}
	public void setMspexaminepersonname(String mspexaminepersonname) {
		this.mspexaminepersonname = mspexaminepersonname;
	}
	public String getMspsmuuid() {
		return mspsmuuid;
	}
	public void setMspsmuuid(String mspsmuuid) {
		this.mspsmuuid = mspsmuuid;
	}
	public String getMsdyear() {
		return msdyear;
	}
	public void setMsdyear(String msdyear) {
		this.msdyear = msdyear;
	}
	public String getMsdmonth() {
		return msdmonth;
	}
	public void setMsdmonth(String msdmonth) {
		this.msdmonth = msdmonth;
	}
	public String getDepartmentids() {
		return departmentids;
	}
	public void setDepartmentids(String departmentids) {
		this.departmentids = departmentids;
	}
	

}
