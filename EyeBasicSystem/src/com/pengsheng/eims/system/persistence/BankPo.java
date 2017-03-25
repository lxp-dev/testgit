package com.pengsheng.eims.system.persistence;

public class BankPo 
{
	private String bbuuid;			//UUID
	private String bbnumber;		//银行编号  1,2,3,4
	private String bbname;			//银行名称	
	private String bbtype;			//所属类型
	private String bbstatistics;	//参与业绩统计
	
	public String getBbtype() {
		return bbtype;
	}
	public void setBbtype(String bbtype) {
		this.bbtype = bbtype;
	}
	public String getBbstatistics() {
		return bbstatistics;
	}
	public void setBbstatistics(String bbstatistics) {
		this.bbstatistics = bbstatistics;
	}
	public String getBbuuid() {
		return bbuuid;
	}
	public void setBbuuid(String bbuuid) {
		this.bbuuid = bbuuid;
	}
	public String getBbnumber() {
		return bbnumber;
	}
	public void setBbnumber(String bbnumber) {
		this.bbnumber = bbnumber;
	}
	public String getBbname() {
		return bbname;
	}
	public void setBbname(String bbname) {
		this.bbname = bbname;
	}
	
	
}
