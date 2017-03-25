package com.pengsheng.eims.his.persistence;


public class HisLogPo {
	
	private String hislogid; // 主键
	private String hislogdepatmentid; // 调用部门ID
	private String hislogdepatmentname; // 调用部门名称
	private String hislogpersonid; // 调用人ID
	private String hislogpersonname; // 调用人姓名
	private String hislogdate; // 调用时间
	private String hisloginterfaceid; // 接口ID
	private String hisloginterfacename; // 接口名称
	private String hisloginparam; // 入参
	private String hislogreturnparam; // 返回值
	private String hislogmoduleid; // 所属模块ID	
	private String hislogmodulename;//所属模块名字
	private String hislogbegindate; // 起始调用时间 
	private String hislogenddate; // 截止调用时间
	private String hislogip; // IP地址
	private String hislogbillid; // 相关单号  
	private String hislogbid; // 相关单号ID L_HI_IL_Hislogbillid
	
	
	
	public String getHislogbid() {
		return hislogbid;
	}
	public void setHislogbid(String hislogbid) {
		this.hislogbid = hislogbid;
	}
	public String getHislogbillid() {
		return hislogbillid;
	}
	public void setHislogbillid(String hislogbillid) {
		this.hislogbillid = hislogbillid;
	}
	public String getHislogmodulename() {
		return hislogmodulename;
	}
	public void setHislogmodulename(String hislogmodulename) {
		this.hislogmodulename = hislogmodulename;
	}
	public String getHislogid() {
		return hislogid;
	}
	public void setHislogid(String hislogid) {
		this.hislogid = hislogid;
	}
	public String getHislogdepatmentid() {
		return hislogdepatmentid;
	}
	public void setHislogdepatmentid(String hislogdepatmentid) {
		this.hislogdepatmentid = hislogdepatmentid;
	}
	public String getHislogdepatmentname() {
		return hislogdepatmentname;
	}
	public void setHislogdepatmentname(String hislogdepatmentname) {
		this.hislogdepatmentname = hislogdepatmentname;
	}
	public String getHislogpersonid() {
		return hislogpersonid;
	}
	public void setHislogpersonid(String hislogpersonid) {
		this.hislogpersonid = hislogpersonid;
	}
	public String getHislogpersonname() {
		return hislogpersonname;
	}
	public void setHislogpersonname(String hislogpersonname) {
		this.hislogpersonname = hislogpersonname;
	}
	public String getHislogdate() {
		return hislogdate;
	}
	public void setHislogdate(String hislogdate) {
		this.hislogdate = hislogdate;
	}
	public String getHisloginterfaceid() {
		return hisloginterfaceid;
	}
	public void setHisloginterfaceid(String hisloginterfaceid) {
		this.hisloginterfaceid = hisloginterfaceid;
	}
	public String getHisloginterfacename() {
		return hisloginterfacename;
	}
	public void setHisloginterfacename(String hisloginterfacename) {
		this.hisloginterfacename = hisloginterfacename;
	}
	public String getHisloginparam() {
		return hisloginparam;
	}
	public void setHisloginparam(String hisloginparam) {
		this.hisloginparam = hisloginparam;
	}
	public String getHislogreturnparam() {
		return hislogreturnparam;
	}
	public void setHislogreturnparam(String hislogreturnparam) {
		this.hislogreturnparam = hislogreturnparam;
	}
	public String getHislogmoduleid() {
		return hislogmoduleid;
	}
	public void setHislogmoduleid(String hislogmoduleid) {
		this.hislogmoduleid = hislogmoduleid;
	}
	public String getHislogbegindate() {
		return hislogbegindate;
	}
	public void setHislogbegindate(String hislogbegindate) {
		this.hislogbegindate = hislogbegindate;
	}
	public String getHislogenddate() {
		return hislogenddate;
	}
	public void setHislogenddate(String hislogenddate) {
		this.hislogenddate = hislogenddate;
	}
	public String getHislogip() {
		return hislogip;
	}
	public void setHislogip(String hislogip) {
		this.hislogip = hislogip;
	}
 
	public String toString() {
		return "HisLogPo [hislogbegindate=" + hislogbegindate + ", hislogdate=" + hislogdate + ", hislogdepatmentid=" + hislogdepatmentid + ", hislogdepatmentname=" + hislogdepatmentname + ", hislogenddate=" + hislogenddate + ", hislogid=" + hislogid + ", hisloginparam=" + hisloginparam + ", hisloginterfaceid=" + hisloginterfaceid + ", hisloginterfacename=" + hisloginterfacename + ", hislogip=" + hislogip + ", hislogmoduleid=" + hislogmoduleid + ", hislogmodulename=" + hislogmodulename + ", hislogpersonid=" + hislogpersonid + ", hislogpersonname=" + hislogpersonname + ", hislogreturnparam=" + hislogreturnparam + "]";
	}
	 
	
	
}
