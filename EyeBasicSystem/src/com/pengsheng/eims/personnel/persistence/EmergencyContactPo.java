package com.pengsheng.eims.personnel.persistence;

public class EmergencyContactPo 
{
	private	String	mecuuid	;				//UUID主键
	private	String	mecname	;				//遇紧通知人 姓名
	private	String	mecrelation	;			//与本人关系
	private	String	meccompanyname	;		//工作单位
	private	String	meccompanyaddress;		//单位地址
	private	String	mecphone;				//联系电话
	private	String	mecpersonid	;			//员工表外键
	
	public String getMecuuid() {
		return mecuuid;
	}
	public void setMecuuid(String mecuuid) {
		this.mecuuid = mecuuid;
	}
	public String getMecname() {
		return mecname;
	}
	public void setMecname(String mecname) {
		this.mecname = mecname;
	}
	public String getMecrelation() {
		return mecrelation;
	}
	public void setMecrelation(String mecrelation) {
		this.mecrelation = mecrelation;
	}
	public String getMeccompanyname() {
		return meccompanyname;
	}
	public void setMeccompanyname(String meccompanyname) {
		this.meccompanyname = meccompanyname;
	}
	public String getMeccompanyaddress() {
		return meccompanyaddress;
	}
	public void setMeccompanyaddress(String meccompanyaddress) {
		this.meccompanyaddress = meccompanyaddress;
	}
	public String getMecphone() {
		return mecphone;
	}
	public void setMecphone(String mecphone) {
		this.mecphone = mecphone;
	}
	public String getMecpersonid() {
		return mecpersonid;
	}
	public void setMecpersonid(String mecpersonid) {
		this.mecpersonid = mecpersonid;
	}
	
	

}
