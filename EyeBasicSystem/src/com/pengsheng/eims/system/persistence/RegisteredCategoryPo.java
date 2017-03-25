package com.pengsheng.eims.system.persistence;

public class RegisteredCategoryPo {
	//挂号ID
	private String frcid;
	//挂号名称
	private String frcregisteredname;
	//挂号金额
	private String frcmoney;
	//收费类型
	private String frcfeetype;
	//排序
	private String frcordertype;
	//挂号类型
	private String frcregisteredtype;
	//停止标记
	private String frcflag;
	
	private String frcoutmoney;
	
	private String frcamounttype;
	
	private String frcpayfeeid;
	
	public String getFrcpayfeeid() {
		return frcpayfeeid;
	}
	public void setFrcpayfeeid(String frcpayfeeid) {
		this.frcpayfeeid = frcpayfeeid;
	}
	public String getFrcamounttype() {
		return frcamounttype;
	}
	public void setFrcamounttype(String frcamounttype) {
		this.frcamounttype = frcamounttype;
	}
	public String getFrcid() {
		return frcid;
	}
	public void setFrcid(String frcid) {
		this.frcid = frcid;
	}
	public String getFrcregisteredname() {
		return frcregisteredname;
	}
	public void setFrcregisteredname(String frcregisteredname) {
		this.frcregisteredname = frcregisteredname;
	}
	public String getFrcmoney() {
		return frcmoney;
	}
	public void setFrcmoney(String frcmoney) {
		this.frcmoney = frcmoney;
	}
	public String getFrcfeetype() {
		return frcfeetype;
	}
	public void setFrcfeetype(String frcfeetype) {
		this.frcfeetype = frcfeetype;
	}
	public String getFrcordertype() {
		return frcordertype;
	}
	public void setFrcordertype(String frcordertype) {
		this.frcordertype = frcordertype;
	}
	public String getFrcregisteredtype() {
		return frcregisteredtype;
	}
	public void setFrcregisteredtype(String frcregisteredtype) {
		this.frcregisteredtype = frcregisteredtype;
	}
	public String getFrcflag() {
		return frcflag;
	}
	public void setFrcflag(String frcflag) {
		this.frcflag = frcflag;
	}
	public String getFrcoutmoney() {
		return frcoutmoney;
	}
	public void setFrcoutmoney(String frcoutmoney) {
		this.frcoutmoney = frcoutmoney;
	}
	
}
