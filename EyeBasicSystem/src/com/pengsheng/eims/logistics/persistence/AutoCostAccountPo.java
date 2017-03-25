package com.pengsheng.eims.logistics.persistence;

public class AutoCostAccountPo {

	private String latcacreatedate;   // 点击自动成本计算时间
	private String latcapaymentday;   // 账期
	private String latcaexecdate;     // 成本计算结束日期
	private String latcaflag;         // 计算状态
	private String latcacompanyid;    // 所属公司ID
	private String latcacompanyname;  // 所属公司名称	
	private String latcabgndate;   // 账期起始日期
	private String latcaenddate;   // 账期截止日期
	
	public String getLatcabgndate() {
		return latcabgndate;
	}
	public void setLatcabgndate(String latcabgndate) {
		this.latcabgndate = latcabgndate;
	}
	public String getLatcaenddate() {
		return latcaenddate;
	}
	public void setLatcaenddate(String latcaenddate) {
		this.latcaenddate = latcaenddate;
	}
	public String getLatcacompanyname() {
		return latcacompanyname;
	}
	public void setLatcacompanyname(String latcacompanyname) {
		this.latcacompanyname = latcacompanyname;
	}
	public String getLatcacompanyid() {
		return latcacompanyid;
	}
	public void setLatcacompanyid(String latcacompanyid) {
		this.latcacompanyid = latcacompanyid;
	}
	public String getLatcacreatedate() {
		return latcacreatedate;
	}
	public void setLatcacreatedate(String latcacreatedate) {
		this.latcacreatedate = latcacreatedate;
	}
	public String getLatcapaymentday() {
		return latcapaymentday;
	}
	public void setLatcapaymentday(String latcapaymentday) {
		this.latcapaymentday = latcapaymentday;
	}
	public String getLatcaexecdate() {
		return latcaexecdate;
	}
	public void setLatcaexecdate(String latcaexecdate) {
		this.latcaexecdate = latcaexecdate;
	}
	public String getLatcaflag() {
		return latcaflag;
	}
	public void setLatcaflag(String latcaflag) {
		this.latcaflag = latcaflag;
	}	
	
}
