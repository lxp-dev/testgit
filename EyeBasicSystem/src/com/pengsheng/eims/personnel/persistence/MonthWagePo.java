package com.pengsheng.eims.personnel.persistence;

public class MonthWagePo 
{
	private	String	mmwuuid;			//主键
	private	String	mmwnumber;			//工资单编号
	private	String	mmwpersonid;		//录入人员外键
	private	String	mmwyear;			//工资的年份
	private	String	mmwmonth;			//工资的月份
	private	String	mmwstate;			//审核状态   0 未审核    1已审核
	private	String	mmwentrytime;		//录入时间
	
	private String personName;			//录入人员名字
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getMmwuuid() {
		return mmwuuid;
	}
	public void setMmwuuid(String mmwuuid) {
		this.mmwuuid = mmwuuid;
	}
	public String getMmwnumber() {
		return mmwnumber;
	}
	public void setMmwnumber(String mmwnumber) {
		this.mmwnumber = mmwnumber;
	}
	public String getMmwpersonid() {
		return mmwpersonid;
	}
	public void setMmwpersonid(String mmwpersonid) {
		this.mmwpersonid = mmwpersonid;
	}
	public String getMmwyear() {
		return mmwyear;
	}
	public void setMmwyear(String mmwyear) {
		this.mmwyear = mmwyear;
	}
	public String getMmwmonth() {
		return mmwmonth;
	}
	public void setMmwmonth(String mmwmonth) {
		this.mmwmonth = mmwmonth;
	}
	public String getMmwstate() {
		return mmwstate;
	}
	public void setMmwstate(String mmwstate) {
		this.mmwstate = mmwstate;
	}
	public String getMmwentrytime() {
		return mmwentrytime;
	}
	public void setMmwentrytime(String mmwentrytime) {
		this.mmwentrytime = mmwentrytime;
	}
	
	
}
