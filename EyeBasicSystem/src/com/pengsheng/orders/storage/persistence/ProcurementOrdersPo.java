package com.pengsheng.orders.storage.persistence;

public class ProcurementOrdersPo {

	private String cstpid; // 单据编号
	private String cstpbilltypeid; // 单据类型
	private String cstpbilldate; // 单据日期
	private String cstpsupplierid; // 制造商编码
	private String cstpcustomerid; // 客户编码
	private String cstpauditperson; // 处理人
	private String cstpauditstate; // 处理状态 1：下单 2：部分发货 3：部分收货 4：全部发货 5：全部收货
	private String cstpcontactperson; // 客户联系人
	private String cstpauditdate; // 处理日期
	private String cstpremark; // 备注

	private String cstpauditstartdate; // 处理日期 start
	private String cstpauditenddate; // 处理日期 end

	private String cstpbillstartdate;// 单据日期 start
	private String cstpbillenddate;// 单据日期 end

	private String cstpsuppliername; // 制造商名称
	private String cstpauditpersonname; // 处理人姓名
	private String cstpcontactpersonname;// 联系人姓名

	public String getCstpbillstartdate() {
		return cstpbillstartdate;
	}

	public void setCstpbillstartdate(String cstpbillstartdate) {
		this.cstpbillstartdate = cstpbillstartdate;
	}

	public String getCstpbillenddate() {
		return cstpbillenddate;
	}

	public void setCstpbillenddate(String cstpbillenddate) {
		this.cstpbillenddate = cstpbillenddate;
	}

	public String getCstpcontactpersonname() {
		return cstpcontactpersonname;
	}

	public void setCstpcontactpersonname(String cstpcontactpersonname) {
		this.cstpcontactpersonname = cstpcontactpersonname;
	}

	private String cstpcompanyid; // 公司id

	public String getCstpcompanyid() {
		return cstpcompanyid;
	}

	public void setCstpcompanyid(String cstpcompanyid) {
		this.cstpcompanyid = cstpcompanyid;
	}

	public String getCstpauditstartdate() {
		return cstpauditstartdate;
	}

	public void setCstpauditstartdate(String cstpauditstartdate) {
		this.cstpauditstartdate = cstpauditstartdate;
	}

	public String getCstpauditenddate() {
		return cstpauditenddate;
	}

	public void setCstpauditenddate(String cstpauditenddate) {
		this.cstpauditenddate = cstpauditenddate;
	}

	public String getCstpsuppliername() {
		return cstpsuppliername;
	}

	public void setCstpsuppliername(String cstpsuppliername) {
		this.cstpsuppliername = cstpsuppliername;
	}

	public String getCstpauditpersonname() {
		return cstpauditpersonname;
	}

	public void setCstpauditpersonname(String cstpauditpersonname) {
		this.cstpauditpersonname = cstpauditpersonname;
	}

	public String getCstpid() {
		return cstpid;
	}

	public void setCstpid(String cstpid) {
		this.cstpid = cstpid;
	}

	public String getCstpbilltypeid() {
		return cstpbilltypeid;
	}

	public void setCstpbilltypeid(String cstpbilltypeid) {
		this.cstpbilltypeid = cstpbilltypeid;
	}

	public String getCstpbilldate() {
		return cstpbilldate;
	}

	public void setCstpbilldate(String cstpbilldate) {
		this.cstpbilldate = cstpbilldate;
	}

	public String getCstpsupplierid() {
		return cstpsupplierid;
	}

	public void setCstpsupplierid(String cstpsupplierid) {
		this.cstpsupplierid = cstpsupplierid;
	}

	public String getCstpcustomerid() {
		return cstpcustomerid;
	}

	public void setCstpcustomerid(String cstpcustomerid) {
		this.cstpcustomerid = cstpcustomerid;
	}

	public String getCstpauditperson() {
		return cstpauditperson;
	}

	public void setCstpauditperson(String cstpauditperson) {
		this.cstpauditperson = cstpauditperson;
	}

	public String getCstpauditstate() {
		return cstpauditstate;
	}

	public void setCstpauditstate(String cstpauditstate) {
		this.cstpauditstate = cstpauditstate;
	}

	public String getCstpcontactperson() {
		return cstpcontactperson;
	}

	public void setCstpcontactperson(String cstpcontactperson) {
		this.cstpcontactperson = cstpcontactperson;
	}

	public String getCstpauditdate() {
		return cstpauditdate;
	}

	public void setCstpauditdate(String cstpauditdate) {
		this.cstpauditdate = cstpauditdate;
	}

	public String getCstpremark() {
		return cstpremark;
	}

	public void setCstpremark(String cstpremark) {
		this.cstpremark = cstpremark;
	}

}
