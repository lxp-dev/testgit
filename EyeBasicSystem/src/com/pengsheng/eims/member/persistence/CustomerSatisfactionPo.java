package com.pengsheng.eims.member.persistence;

public class CustomerSatisfactionPo {
	private String fcsid;	//UUID
	private String fcsname;	//回访满意度名称
	public String getFcsid() {
		return fcsid;
	}
	public void setFcsid(String fcsid) {
		this.fcsid = fcsid;
	}
	public String getFcsname() {
		return fcsname;
	}
	public void setFcsname(String fcsname) {
		this.fcsname = fcsname;
	}

}
