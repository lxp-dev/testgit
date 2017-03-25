package com.pengsheng.eims.basic.persistence;

public class OptionParamPo {
	private String fopparamid;	//主键
	private String fopparamname;	//内容
	private String fopmoduleid;	//ModuleID	
	private String fopremark;	//备注
	private String fopparentid;	//父ID
	private String fopparentname;	//父name
	private String foptype;	//类型:1:父;2:子；
	private String minCount; //父值下面有多少子值
	private String fopmodulename;	//Module名称
	
	public String getFopmodulename() {
		return fopmodulename;
	}
	public void setFopmodulename(String fopmodulename) {
		this.fopmodulename = fopmodulename;
	}
	public String getMinCount() {
		return minCount;
	}
	public void setMinCount(String minCount) {
		this.minCount = minCount;
	}
	public String getFoptype() {
		return foptype;
	}
	public void setFoptype(String foptype) {
		this.foptype = foptype;
	}
	public String getFopparentname() {
		return fopparentname;
	}
	public void setFopparentname(String fopparentname) {
		this.fopparentname = fopparentname;
	}
	public String getFopparamid() {
		return fopparamid;
	}
	public void setFopparamid(String fopparamid) {
		this.fopparamid = fopparamid;
	}
	public String getFopparamname() {
		return fopparamname;
	}
	public void setFopparamname(String fopparamname) {
		this.fopparamname = fopparamname;
	}
	public String getFopmoduleid() {
		return fopmoduleid;
	}
	public void setFopmoduleid(String fopmoduleid) {
		this.fopmoduleid = fopmoduleid;
	}
	public String getFopremark() {
		return fopremark;
	}
	public void setFopremark(String fopremark) {
		this.fopremark = fopremark;
	}
	public String getFopparentid() {
		return fopparentid;
	}
	public void setFopparentid(String fopparentid) {
		this.fopparentid = fopparentid;
	}
}
