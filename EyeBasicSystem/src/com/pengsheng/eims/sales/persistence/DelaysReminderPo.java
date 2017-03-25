package com.pengsheng.eims.sales.persistence;

public class DelaysReminderPo {

	private String ssedrid;// id
	private String ssedrsalesid;// 销售单号
	private String ssedrshopcode;// 所属门店
	private String ssedrmirrorcheckdate;// 原取镜日期
	private String ssedrexpectedcheckdate;// 预计取镜日期
	private String ssedrcausesdelays;// 误期原因
	private String ssedrauditperson;// 审核人
	private String ssedrauditdate;// 审核日期
	private String ssedrauditstatus;// 审核状态
	private String ssedrnoticeperson;// 通知人
	private String ssedrnoticedate;// 通知日期
	private String ssedrnoticestatus;// 通知状态
	private String ssedrcreatedate;// 创建日期
	private String ssedrcustomerid;// 顾客号

	private String ssedrcustomerName;// 顾客姓名(新加)
	private String ssedrname;// 顾客姓名(新加)
	private String ssedrmirrorcheckstartdate;// 原取镜start日期
	private String ssedrmirrorcheckenddate;// 原取镜end日期
	private String ssedrexpectedcheckstartdate;// 预计取镜start日期
	private String ssedrexpectedcheckenddate;// 预计取镜end日期
	private String ssedrnoticestartdate;// 通知start日期
	private String ssedrnoticeenddate;// 通知end日期
	private String days;//误期天数
	
	private String ssedrdepartmenttype;//部门类型(王磊 07-21)
	private String ssedrcompanyid;// 公司id
	
	public String getSsedrcompanyid() {
		return ssedrcompanyid;
	}

	public void setSsedrcompanyid(String ssedrcompanyid) {
		this.ssedrcompanyid = ssedrcompanyid;
	}

	public String getSsedrdepartmenttype() {
		return ssedrdepartmenttype;
	}

	public void setSsedrdepartmenttype(String ssedrdepartmenttype) {
		this.ssedrdepartmenttype = ssedrdepartmenttype;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getSsedrid() {
		return ssedrid;
	}

	public void setSsedrid(String ssedrid) {
		this.ssedrid = ssedrid;
	}

	public String getSsedrsalesid() {
		return ssedrsalesid;
	}

	public void setSsedrsalesid(String ssedrsalesid) {
		this.ssedrsalesid = ssedrsalesid;
	}

	public String getSsedrshopcode() {
		return ssedrshopcode;
	}

	public void setSsedrshopcode(String ssedrshopcode) {
		this.ssedrshopcode = ssedrshopcode;
	}

	public String getSsedrmirrorcheckdate() {
		return ssedrmirrorcheckdate;
	}

	public void setSsedrmirrorcheckdate(String ssedrmirrorcheckdate) {
		this.ssedrmirrorcheckdate = ssedrmirrorcheckdate;
	}

	public String getSsedrexpectedcheckdate() {
		return ssedrexpectedcheckdate;
	}

	public void setSsedrexpectedcheckdate(String ssedrexpectedcheckdate) {
		this.ssedrexpectedcheckdate = ssedrexpectedcheckdate;
	}

	public String getSsedrcausesdelays() {
		return ssedrcausesdelays;
	}

	public void setSsedrcausesdelays(String ssedrcausesdelays) {
		this.ssedrcausesdelays = ssedrcausesdelays;
	}

	public String getSsedrauditperson() {
		return ssedrauditperson;
	}

	public void setSsedrauditperson(String ssedrauditperson) {
		this.ssedrauditperson = ssedrauditperson;
	}

	public String getSsedrauditdate() {
		return ssedrauditdate;
	}

	public void setSsedrauditdate(String ssedrauditdate) {
		this.ssedrauditdate = ssedrauditdate;
	}

	public String getSsedrauditstatus() {
		return ssedrauditstatus;
	}

	public void setSsedrauditstatus(String ssedrauditstatus) {
		this.ssedrauditstatus = ssedrauditstatus;
	}

	public String getSsedrnoticeperson() {
		return ssedrnoticeperson;
	}

	public void setSsedrnoticeperson(String ssedrnoticeperson) {
		this.ssedrnoticeperson = ssedrnoticeperson;
	}

	public String getSsedrnoticedate() {
		return ssedrnoticedate;
	}

	public void setSsedrnoticedate(String ssedrnoticedate) {
		this.ssedrnoticedate = ssedrnoticedate;
	}

	public String getSsedrnoticestatus() {
		return ssedrnoticestatus;
	}

	public void setSsedrnoticestatus(String ssedrnoticestatus) {
		this.ssedrnoticestatus = ssedrnoticestatus;
	}

	public String getSsedrcreatedate() {
		return ssedrcreatedate;
	}

	public void setSsedrcreatedate(String ssedrcreatedate) {
		this.ssedrcreatedate = ssedrcreatedate;
	}

	public String getSsedrcustomerid() {
		return ssedrcustomerid;
	}

	public void setSsedrcustomerid(String ssedrcustomerid) {
		this.ssedrcustomerid = ssedrcustomerid;
	}

	public String getSsedrcustomerName() {
		return ssedrcustomerName;
	}

	public void setSsedrcustomerName(String ssedrcustomerName) {
		this.ssedrcustomerName = ssedrcustomerName;
	}

	public String getSsedrmirrorcheckstartdate() {
		return ssedrmirrorcheckstartdate;
	}

	public void setSsedrmirrorcheckstartdate(String ssedrmirrorcheckstartdate) {
		this.ssedrmirrorcheckstartdate = ssedrmirrorcheckstartdate;
	}

	public String getSsedrmirrorcheckenddate() {
		return ssedrmirrorcheckenddate;
	}

	public void setSsedrmirrorcheckenddate(String ssedrmirrorcheckenddate) {
		this.ssedrmirrorcheckenddate = ssedrmirrorcheckenddate;
	}

	public String getSsedrexpectedcheckstartdate() {
		return ssedrexpectedcheckstartdate;
	}

	public void setSsedrexpectedcheckstartdate(
			String ssedrexpectedcheckstartdate) {
		this.ssedrexpectedcheckstartdate = ssedrexpectedcheckstartdate;
	}

	public String getSsedrexpectedcheckenddate() {
		return ssedrexpectedcheckenddate;
	}

	public void setSsedrexpectedcheckenddate(String ssedrexpectedcheckenddate) {
		this.ssedrexpectedcheckenddate = ssedrexpectedcheckenddate;
	}

	public String getSsedrnoticestartdate() {
		return ssedrnoticestartdate;
	}

	public void setSsedrnoticestartdate(String ssedrnoticestartdate) {
		this.ssedrnoticestartdate = ssedrnoticestartdate;
	}

	public String getSsedrnoticeenddate() {
		return ssedrnoticeenddate;
	}

	public void setSsedrnoticeenddate(String ssedrnoticeenddate) {
		this.ssedrnoticeenddate = ssedrnoticeenddate;
	}

	public String getSsedrname() {
		return ssedrname;
	}

	public void setSsedrname(String ssedrname) {
		this.ssedrname = ssedrname;
	}

}
