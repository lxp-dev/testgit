package com.pengsheng.eims.basic.persistence;

public class AreaPo {
	private String faid;	//主键ID
	private String fapid;	//对应父ID
	private String falevel;	//区域级别；0：国家；1：省份；2：市；3：区、县；4：乡镇；5：村、街道；
	private String faname;	//区域名称
	public String getFaid() {
		return faid;
	}
	public void setFaid(String faid) {
		this.faid = faid;
	}
	public String getFapid() {
		return fapid;
	}
	public void setFapid(String fapid) {
		this.fapid = fapid;
	}
	public String getFalevel() {
		return falevel;
	}
	public void setFalevel(String falevel) {
		this.falevel = falevel;
	}
	public String getFaname() {
		return faname;
	}
	public void setFaname(String faname) {
		this.faname = faname;
	}
	}
