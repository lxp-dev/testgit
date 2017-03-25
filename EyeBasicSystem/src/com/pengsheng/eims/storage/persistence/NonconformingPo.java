package com.pengsheng.eims.storage.persistence;

public class NonconformingPo {
	
	private String cshanbillid; //不合格品单号	
	private String cshandepartmentid; //申报部门	
	private String cshandepartmentname;//申报部门名称	
	private String cshanstartTime;//开始时间
	private String cshanendTime;//结束时间	
	private String cshancreateperson; 		//制单人
	private String cshancreatepersonname;	//制单人名称
	private String cshancreatedate; 		//制单日期	
	private String cshanauditperson; 		//审核人
	private String cshanauditpersonname; 	//审核人名称	
	private String cshanauditdate; 			//审核日期	
	private String cshanauditstate; 		//审核状态	0：未审核 1：已审核   2：已处理
	private String cshanconsignmode; 		//处置方式	0：报残   1：退回
	private String cshanconsignperson;
	private String cshanconsignpersonname;
	private String iscustomize; 			//镜片类型      1 2 3 4 5 6 7
	private String cshanremark; 
	private String cshanlinkbillID; 		//关联销售单
	private String cshancustomername; 		//顾客姓名
	private String cshanresponsibility;		//责任人
	private String cshanoutstockid;			//outstockid
	private String cshanoutstockname;		//outstockid
	private String cshanisallocation;		//outstockid
	private String cshanautoallocation;		//自动收货调拨
	private String cshanresponsibilityperson;//责任人姓名
	private String cshanconsigndate;
	private String cshansupplierid; //制造商id
	private String cshanbrandid; //品种id
	private String cshanconsigndeparmentid;   //处置部门	
	private String cshaninstockid;			//入仓
	private String cshanwhichretail;			//使用哪种零售价（页面显示使用）
	private String cshancompanyid; //公司ID
	private String cshanchulistate; //处理状态
	
	public String getCshanchulistate() {
		return cshanchulistate;
	}
	public void setCshanchulistate(String cshanchulistate) {
		this.cshanchulistate = cshanchulistate;
	}
	public String getCshancompanyid() {
		return cshancompanyid;
	}
	public void setCshancompanyid(String cshancompanyid) {
		this.cshancompanyid = cshancompanyid;
	}
	public String getCshanwhichretail() {
		return cshanwhichretail;
	}
	public void setCshanwhichretail(String cshanwhichretail) {
		this.cshanwhichretail = cshanwhichretail;
	}
	public String getCshaninstockid() {
		return cshaninstockid;
	}
	public void setCshaninstockid(String cshaninstockid) {
		this.cshaninstockid = cshaninstockid;
	}
	public String getCshanconsigndeparmentid() {
		return cshanconsigndeparmentid;
	}
	public void setCshanconsigndeparmentid(String cshanconsigndeparmentid) {
		this.cshanconsigndeparmentid = cshanconsigndeparmentid;
	}
	public String getCshanautoallocation() {
		return cshanautoallocation;
	}
	public void setCshanautoallocation(String cshanautoallocation) {
		this.cshanautoallocation = cshanautoallocation;
	}
	public String getCshanisallocation() {
		return cshanisallocation;
	}
	public void setCshanisallocation(String cshanisallocation) {
		this.cshanisallocation = cshanisallocation;
	}
	public String getCshanoutstockname() {
		return cshanoutstockname;
	}
	public void setCshanoutstockname(String cshanoutstockname) {
		this.cshanoutstockname = cshanoutstockname;
	}
	public String getCshanoutstockid() {
		return cshanoutstockid;
	}
	public void setCshanoutstockid(String cshanoutstockid) {
		this.cshanoutstockid = cshanoutstockid;
	}
	public String getCshanresponsibility() {
		return cshanresponsibility;
	}
	public void setCshanresponsibility(String cshanresponsibility) {
		this.cshanresponsibility = cshanresponsibility;
	}
	public String getCshanresponsibilityperson() {
		return cshanresponsibilityperson;
	}
	public void setCshanresponsibilityperson(String cshanresponsibilityperson) {
		this.cshanresponsibilityperson = cshanresponsibilityperson;
	}
	public String getCshancustomername() {
		return cshancustomername;
	}
	public void setCshancustomername(String cshancustomername) {
		this.cshancustomername = cshancustomername;
	}
	public String getCshanlinkbillID() {
		return cshanlinkbillID;
	}
	public void setCshanlinkbillID(String cshanlinkbillID) {
		this.cshanlinkbillID = cshanlinkbillID;
	}
	public String getCshanremark() {
		return cshanremark;
	}
	public void setCshanremark(String cshanremark) {
		this.cshanremark = cshanremark;
	}
	public String getCshanconsignpersonname() {
		return cshanconsignpersonname;
	}
	public void setCshanconsignpersonname(String cshanconsignpersonname) {
		this.cshanconsignpersonname = cshanconsignpersonname;
	}
	public String getCshanconsignperson() {
		return cshanconsignperson;
	}
	public void setCshanconsignperson(String cshanconsignperson) {
		this.cshanconsignperson = cshanconsignperson;
	}
	public String getCshanconsigndate() {
		return cshanconsigndate;
	}
	public void setCshanconsigndate(String cshanconsigndate) {
		this.cshanconsigndate = cshanconsigndate;
	}
	public String getCshansupplierid() {
		return cshansupplierid;
	}
	public void setCshansupplierid(String cshansupplierid) {
		this.cshansupplierid = cshansupplierid;
	}
	public String getCshanbrandid() {
		return cshanbrandid;
	}
	public void setCshanbrandid(String cshanbrandid) {
		this.cshanbrandid = cshanbrandid;
	}
	public String getCshanbillid() {
		return cshanbillid;
	}
	public void setCshanbillid(String cshanbillid) {
		this.cshanbillid = cshanbillid;
	}
	public String getCshandepartmentid() {
		return cshandepartmentid;
	}
	public void setCshandepartmentid(String cshandepartmentid) {
		this.cshandepartmentid = cshandepartmentid;
	}
	public String getCshancreateperson() {
		return cshancreateperson;
	}
	public void setCshancreateperson(String cshancreateperson) {
		this.cshancreateperson = cshancreateperson;
	}
	public String getCshancreatedate() {
		return cshancreatedate;
	}
	public void setCshancreatedate(String cshancreatedate) {
		this.cshancreatedate = cshancreatedate;
	}
	public String getCshanauditperson() {
		return cshanauditperson;
	}
	public void setCshanauditperson(String cshanauditperson) {
		this.cshanauditperson = cshanauditperson;
	}
	public String getCshanauditdate() {
		return cshanauditdate;
	}
	public void setCshanauditdate(String cshanauditdate) {
		this.cshanauditdate = cshanauditdate;
	}
	public String getCshanauditstate() {
		return cshanauditstate;
	}
	public void setCshanauditstate(String cshanauditstate) {
		this.cshanauditstate = cshanauditstate;
	}
	public String getCshanconsignmode() {
		return cshanconsignmode;
	}
	public void setCshanconsignmode(String cshanconsignmode) {
		this.cshanconsignmode = cshanconsignmode;
	}
	public String getCshandepartmentname() {
		return cshandepartmentname;
	}
	public void setCshandepartmentname(String cshandepartmentname) {
		this.cshandepartmentname = cshandepartmentname;
	}
	public String getCshancreatepersonname() {
		return cshancreatepersonname;
	}
	public void setCshancreatepersonname(String cshancreatepersonname) {
		this.cshancreatepersonname = cshancreatepersonname;
	}
	public String getCshanauditpersonname() {
		return cshanauditpersonname;
	}
	public void setCshanauditpersonname(String cshanauditpersonname) {
		this.cshanauditpersonname = cshanauditpersonname;
	}
	public String getCshanstartTime() {
		return cshanstartTime;
	}
	public void setCshanstartTime(String cshanstartTime) {
		this.cshanstartTime = cshanstartTime;
	}
	public String getCshanendTime() {
		return cshanendTime;
	}
	public void setCshanendTime(String cshanendTime) {
		this.cshanendTime = cshanendTime;
	}	
	public String getIscustomize() {
		return iscustomize;
	}
	public void setIscustomize(String iscustomize) {
		this.iscustomize = iscustomize;
	}
	
}
