package com.pengsheng.eims.basic.persistence;

public class NonconformingProductPo {
	private String fnpid;	//主键
	private String fnpcontent;	//原因/现象
	private String fnpparented;	//父ID
	private String fnpparentedname;	//父name
	private String fnpdeptid;	//级别：1：原因；2：现象
	private String minCount; 	//原因下包含现象的个数；
	public String getMinCount() {
		return minCount;
	}
	public void setMinCount(String minCount) {
		this.minCount = minCount;
	}
	public String getFnpid() {
		return fnpid;
	}
	public void setFnpid(String fnpid) {
		this.fnpid = fnpid;
	}
	public String getFnpcontent() {
		return fnpcontent;
	}
	public void setFnpcontent(String fnpcontent) {
		this.fnpcontent = fnpcontent;
	}
	public String getFnpparented() {
		return fnpparented;
	}
	public void setFnpparented(String fnpparented) {
		this.fnpparented = fnpparented;
	}
	public String getFnpdeptid() {
		return fnpdeptid;
	}
	public void setFnpdeptid(String fnpdeptid) {
		this.fnpdeptid = fnpdeptid;
	}
	public String getFnpparentedname() {
		return fnpparentedname;
	}
	public void setFnpparentedname(String fnpparentedname) {
		this.fnpparentedname = fnpparentedname;
	}
}
