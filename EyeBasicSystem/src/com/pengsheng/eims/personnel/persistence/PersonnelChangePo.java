package com.pengsheng.eims.personnel.persistence;

public class PersonnelChangePo 
{
	private	String	mpcuuid	;			//uuid主键
	private	String	mpcpersonid;		//人事变动的人员id
	private	String	mpcchangetype;		//人事变动类型
	private	String	mpccontent;			//人事变动内容
	private	String	mpcchangedate;		//人事变动日期	
	private	String	mpcrecordid	;		//人事变动记录人id
	private	String	mpcrecordname;		//人事变动记录人姓名
	
	
	private String mpcpersonname;		
	private String mpcpostname;
	private String mpcpostid;
	private String mpcdepartmentID;			
	private String mpcdepartmentname;
	private String isInvocation;	
	
	public String getMpcpostid() {
		return mpcpostid;
	}
	public void setMpcpostid(String mpcpostid) {
		this.mpcpostid = mpcpostid;
	}
	public String getMpcuuid() 
	{
		return mpcuuid;
	}
	public void setMpcuuid(String mpcuuid) {
		this.mpcuuid = mpcuuid;
	}
	public String getMpcpersonid() {
		return mpcpersonid;
	}
	public void setMpcpersonid(String mpcpersonid) {
		this.mpcpersonid = mpcpersonid;
	}
	public String getMpcchangetype() {
		return mpcchangetype;
	}
	public void setMpcchangetype(String mpcchangetype) {
		this.mpcchangetype = mpcchangetype;
	}
	
	public String getMpccontent() {
		return mpccontent;
	}
	public void setMpccontent(String mpccontent) {
		this.mpccontent = mpccontent;
	}
	public String getMpcchangedate() {
		return mpcchangedate;
	}
	public void setMpcchangedate(String mpcchangedate) {
		this.mpcchangedate = mpcchangedate;
	}
	public String getMpcrecordname() {
		return mpcrecordname;
	}
	public void setMpcrecordname(String mpcrecordname) {
		this.mpcrecordname = mpcrecordname;
	}
	public String getMpcrecordid() {
		return mpcrecordid;
	}
	public void setMpcrecordid(String mpcrecordid) {
		this.mpcrecordid = mpcrecordid;
	}
	public String getMpcpersonname() {
		return mpcpersonname;
	}
	public void setMpcpersonname(String mpcpersonname) {
		this.mpcpersonname = mpcpersonname;
	}
	public String getMpcpostname() {
		return mpcpostname;
	}
	public void setMpcpostname(String mpcpostname) {
		this.mpcpostname = mpcpostname;
	}
	public String getMpcdepartmentID() {
		return mpcdepartmentID;
	}
	public void setMpcdepartmentID(String mpcdepartmentID) {
		this.mpcdepartmentID = mpcdepartmentID;
	}
	public String getMpcdepartmentname() {
		return mpcdepartmentname;
	}
	public void setMpcdepartmentname(String mpcdepartmentname) {
		this.mpcdepartmentname = mpcdepartmentname;
	}
	public String getIsInvocation() {
		return isInvocation;
	}
	public void setIsInvocation(String isInvocation) {
		this.isInvocation = isInvocation;
	}
	
}
