package com.pengsheng.eims.basic.persistence;

public class JbtiaoPo {
	private String id;
	private String pinfoid;		//员工编号
	private String kqdt;	//考勤日期
	private String jbsbtime;	//加班上班时刻
	private String jbxbtime;	//加班下班时刻
	private String jbsbtimeb;	//加班上班时间开始段
	private String jbsbtimee;	//加班上班时间结束段
	private String jbxbtimeb;	//加班下班时间开始段
	private String jbxbtimee;	//加班下班时间结束段
	private String jbtime;		//加班折合小时数(乘以100)
	private String sbisdk;	//上班是否打卡(0为不打卡;1为打卡)
	private String xbisdk;	//下班是否打卡(0为不打卡;1为打卡)
	private String recordyn;	//是否查看考勤记录
	private String jbtype;  //加班类型
	private String personid;//人员
	
	private String jbtypename;
	
	private String begindate;
	private String enddate;	
	
	private String personname;
	
	private String departmentid;
	
	private String departmentname;
	
	
	
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getJbtypename() {
		return jbtypename;
	}
	public void setJbtypename(String jbtypename) {
		this.jbtypename = jbtypename;
	}
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getPersonid() {
		return personid;
	}
	public void setPersonid(String personid) {
		this.personid = personid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPinfoid() {
		return pinfoid;
	}
	public void setPinfoid(String pinfoid) {
		this.pinfoid = pinfoid;
	}
	public String getKqdt() {
		return kqdt;
	}
	public void setKqdt(String kqdt) {
		this.kqdt = kqdt;
	}
	public String getJbsbtime() {
		return jbsbtime;
	}
	public void setJbsbtime(String jbsbtime) {
		this.jbsbtime = jbsbtime;
	}
	public String getJbxbtime() {
		return jbxbtime;
	}
	public void setJbxbtime(String jbxbtime) {
		this.jbxbtime = jbxbtime;
	}
	public String getJbsbtimeb() {
		return jbsbtimeb;
	}
	public void setJbsbtimeb(String jbsbtimeb) {
		this.jbsbtimeb = jbsbtimeb;
	}
	public String getJbsbtimee() {
		return jbsbtimee;
	}
	public void setJbsbtimee(String jbsbtimee) {
		this.jbsbtimee = jbsbtimee;
	}
	public String getJbxbtimeb() {
		return jbxbtimeb;
	}
	public void setJbxbtimeb(String jbxbtimeb) {
		this.jbxbtimeb = jbxbtimeb;
	}
	public String getJbxbtimee() {
		return jbxbtimee;
	}
	public void setJbxbtimee(String jbxbtimee) {
		this.jbxbtimee = jbxbtimee;
	}
	public String getJbtime() {
		return jbtime;
	}
	public void setJbtime(String jbtime) {
		this.jbtime = jbtime;
	}
	public String getSbisdk() {
		return sbisdk;
	}
	public void setSbisdk(String sbisdk) {
		this.sbisdk = sbisdk;
	}
	public String getXbisdk() {
		return xbisdk;
	}
	public void setXbisdk(String xbisdk) {
		this.xbisdk = xbisdk;
	}
	public String getRecordyn() {
		return recordyn;
	}
	public void setRecordyn(String recordyn) {
		this.recordyn = recordyn;
	}
	public String getJbtype() {
		return jbtype;
	}
	public void setJbtype(String jbtype) {
		this.jbtype = jbtype;
	}
	
	
}
